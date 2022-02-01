package com.tencent.mobileqq.videocodec.ffmpeg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FFmpeg
{
  public static final String MESSAGE_COPY_CMD_FAIL = "copy_fail";
  public static final String MESSAGE_COPY_CMD_SUCCESS = "copy_success";
  public static final String MESSAGE_INPUT_NULL = "input path is null";
  public static final String MESSAGE_TS_DONE = "TS file exists";
  protected static final long MINIMUM_TIMEOUT = 10000L;
  protected static final int RESULT_FIAL = 0;
  protected static final int RESULT_NOT_DONE = -9999;
  protected static final int RESULT_SUCCESS = 1;
  public static final String TAG = "FFmpegCmd";
  protected static volatile FFmpeg instance;
  public final Context context;
  public FFmpegExecuteAsyncTask ffmpegExecuteAsyncTask;
  public ArrayList<FFmpegCommandUnit> mCmdQueue = new ArrayList();
  public FFmpegCommandUnit mCurrentCommandUnit;
  public String mCurrentTaskUni;
  public boolean mIsFFmpegingCloseScreen = false;
  protected boolean mIsWorkThreadCallback = false;
  public int mLastTaskResult = -9999;
  public BroadcastReceiver mScreenActionReceiver = new FFmpeg.7(this);
  protected long timeout = 9223372036854775807L;
  public ArrayList<String> tsFileList = new ArrayList();
  
  private FFmpeg(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.SCREEN_OFF");
    paramContext.addAction("android.intent.action.SCREEN_ON");
    this.context.registerReceiver(this.mScreenActionReceiver, paramContext);
    Util.setFileExecutable(new File(FFmpegFileUtils.getFFmpeg(this.context)));
  }
  
  private void detectMediaInfoVolume(String paramString, ExecuteBinResponseCallback paramExecuteBinResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString);
    localArrayList.add("-filter_complex");
    localArrayList.add("volumedetect");
    localArrayList.add("-c:v");
    localArrayList.add("copy");
    localArrayList.add("-f");
    localArrayList.add("null");
    localArrayList.add("/dev/null");
    execute((String[])localArrayList.toArray(new String[0]), paramExecuteBinResponseCallback);
  }
  
  private void getAudioFromMP4(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-vn");
    localArrayList.add("-acodec");
    localArrayList.add("copy");
    localArrayList.add(paramString2);
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public static FFmpeg getInstance(Context paramContext)
  {
    return getInstance(paramContext, false);
  }
  
  public static FFmpeg getInstance(Context paramContext, boolean paramBoolean)
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new FFmpeg(paramContext);
        }
      }
      finally {}
    }
    instance.mIsWorkThreadCallback = paramBoolean;
    return instance;
  }
  
  private void getVideoFromMP4(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-an");
    localArrayList.add("-vcodec");
    localArrayList.add("copy");
    localArrayList.add(paramString2);
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  private void mixAudio(String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-i");
    localArrayList.add(paramString2);
    localArrayList.add("-filter_complex");
    paramString1 = new StringBuilder();
    paramString1.append("[0:a]volume=");
    paramString1.append(paramFloat1);
    paramString1.append("[a0];[1:a]volume=");
    paramString1.append(paramFloat2);
    paramString1.append("[a1];[a0][a1]amix=inputs=2:duration=first:dropout_transition=3");
    localArrayList.add(paramString1.toString());
    localArrayList.add("-strict");
    localArrayList.add("-2");
    localArrayList.add("-vn");
    localArrayList.add(paramString3);
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public static FFmpeg newInstance(Context paramContext, boolean paramBoolean)
  {
    paramContext = new FFmpeg(paramContext);
    paramContext.mIsWorkThreadCallback = paramBoolean;
    return paramContext;
  }
  
  private String parseCmdStringByMillSecond(int paramInt)
  {
    return String.format("%02d:%02d:%02d.%03d", new Object[] { Integer.valueOf((int)Math.floor(paramInt / 3600000)), Integer.valueOf((int)Math.floor(paramInt % 3600000) / 60000), Integer.valueOf((int)Math.floor(paramInt % 60000 / 1000)), Integer.valueOf((int)Math.floor(paramInt % 1000)) });
  }
  
  public void changeOrientationInVideo(String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-metadata:s:v");
    paramString1 = new StringBuilder();
    paramString1.append("rotate=");
    paramString1.append(paramString2);
    localArrayList.add(paramString1.toString());
    localArrayList.add("-codec");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString3).getCanonicalPath());
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void changeOrientationInVideoByTranspose(String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    int i = Integer.valueOf(paramString2).intValue();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vf");
    i %= 360;
    if (i != 0)
    {
      if (i != 90)
      {
        if (i != 180)
        {
          if (i != 270)
          {
            SLog.d("FFmpegCmd", "unSupport orientation:%s", new Object[] { paramString2 });
            return;
          }
          localArrayList.add("transpose=1,transpose=1,transpose=1");
        }
        else
        {
          localArrayList.add("transpose=1,transpose=1");
        }
      }
      else {
        localArrayList.add("transpose=1");
      }
      localArrayList.add("-c:a");
      localArrayList.add("copy");
      localArrayList.add(new File(paramString3).getCanonicalPath());
      execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
      return;
    }
    SLog.b("FFmpegCmd", "no need rotate.");
  }
  
  public boolean checkSameTask(String paramString)
  {
    String str = this.mCurrentTaskUni;
    return (str != null) && (paramString != null) && (paramString.equals(str));
  }
  
  public void clipAudio(String paramString1, String paramString2, int paramInt1, int paramInt2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("clipAudio arguments: \n inAudio");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("\n outAudio:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("\n start:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("\n duration:");
    ((StringBuilder)localObject).append(paramInt2);
    SLog.d("FFmpegCmd", ((StringBuilder)localObject).toString());
    if (!com.tencent.biz.qqstory.utils.FileUtils.d(paramString1))
    {
      SLog.e("FFmpegCmd", "clipAudio but inAudio file is not exist");
      paramFFmpegExecuteResponseCallback.onFailure(String.valueOf(941001));
      paramFFmpegExecuteResponseCallback.onFinish(false);
      return;
    }
    localObject = parseCmdStringByMillSecond(paramInt1);
    String str = parseCmdStringByMillSecond(paramInt2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-ss");
    localArrayList.add(localObject);
    localArrayList.add("-t");
    localArrayList.add(str);
    localArrayList.add("-acodec");
    localArrayList.add("copy");
    localArrayList.add("-vn");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void cmdFFmpegQueue(ArrayList<FFmpegCommandUnit> paramArrayList)
  {
    this.mCmdQueue = paramArrayList;
    if (this.mCmdQueue.size() <= 0) {
      return;
    }
    paramArrayList = (FFmpegCommandUnit)this.mCmdQueue.remove(0);
    ArrayList localArrayList = paramArrayList.arguments;
    String[] arrayOfString = paramArrayList.cmd;
    FFmpeg.6 local6 = new FFmpeg.6(this, paramArrayList.callback, arrayOfString, this.mCmdQueue);
    if (arrayOfString != null)
    {
      execute(arrayOfString, local6);
      return;
    }
    switch (paramArrayList.cmdType)
    {
    default: 
      return;
    case 22: 
      detectMediaInfoVolume((String)localArrayList.get(0), local6);
      return;
    case 21: 
      transcodeM4a((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 20: 
      convertPicToVideoWithTime((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), local6);
      return;
    case 19: 
      getVideoFromMP4((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 18: 
      getAudioFromMP4((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 17: 
      mixAudio((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), ((Float)localArrayList.get(3)).floatValue(), ((Float)localArrayList.get(4)).floatValue(), local6);
      return;
    case 16: 
      convertMp4ToMp3((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 15: 
      combineDoodle((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), local6);
      return;
    case 14: 
      emptyFFmengCmd((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 13: 
      setTimestamp((String)localArrayList.get(0), (String)localArrayList.get(1), ((Integer)localArrayList.get(2)).intValue(), local6);
      return;
    case 12: 
      changeOrientationInVideoByTranspose((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), local6);
      return;
    case 11: 
      compressVideo((String)localArrayList.get(0), ((Integer)localArrayList.get(1)).intValue(), ((Integer)localArrayList.get(2)).intValue(), ((Integer)localArrayList.get(3)).intValue(), ((Boolean)localArrayList.get(4)).booleanValue(), (String)localArrayList.get(5), local6);
      return;
    case 10: 
      hflip((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 9: 
      convertPicToVideo((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 8: 
      concatDifferentCodingMedia((List)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 7: 
      concatMediaByTs((List)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 6: 
      concatTsOutput((List)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 5: 
      mp4Tots((String)localArrayList.get(0), (String)localArrayList.get(1), local6);
      return;
    case 4: 
      combineAudioAndVideo((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), (String)localArrayList.get(3), ((Boolean)localArrayList.get(4)).booleanValue(), ((Integer)localArrayList.get(5)).intValue(), local6);
      return;
    case 3: 
      clipAudio((String)localArrayList.get(0), (String)localArrayList.get(1), ((Integer)localArrayList.get(2)).intValue(), ((Integer)localArrayList.get(3)).intValue(), local6);
      return;
    case 2: 
      concatMedia((List)localArrayList.get(0), (String)localArrayList.get(1), local6, ((Boolean)localArrayList.get(2)).booleanValue());
      return;
    }
    watermark((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), ((Integer)localArrayList.get(3)).intValue(), ((Integer)localArrayList.get(4)).intValue(), local6);
  }
  
  public Clip combineAudioAndVideo(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    paramString4 = new Clip(paramString4);
    paramString4.videoCodec = paramString3;
    return combineAudioAndVideo(paramString1, paramString2, paramBoolean, paramString4, paramInt, paramFFmpegExecuteResponseCallback);
  }
  
  public Clip combineAudioAndVideo(String paramString1, String paramString2, boolean paramBoolean, Clip paramClip, int paramInt, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("combineAudioAndVideo arguments: \n inVideo");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append("\n inAudio:");
    ((StringBuilder)localObject1).append(paramString2);
    ((StringBuilder)localObject1).append("\n outMedia:");
    ((StringBuilder)localObject1).append(paramClip);
    SLog.d("FFmpegCmd", ((StringBuilder)localObject1).toString());
    if (!com.tencent.biz.qqstory.utils.FileUtils.d(paramString1))
    {
      SLog.e("FFmpegCmd", "clipAudio but inVideo file is not exist");
      paramFFmpegExecuteResponseCallback.onFailure(String.valueOf(941002));
      paramFFmpegExecuteResponseCallback.onFinish(false);
      return paramClip;
    }
    if (!com.tencent.biz.qqstory.utils.FileUtils.d(paramString2))
    {
      SLog.e("FFmpegCmd", "clipAudio but inAudio file is not exist");
      paramFFmpegExecuteResponseCallback.onFailure(String.valueOf(941002));
      paramFFmpegExecuteResponseCallback.onFinish(false);
      return paramClip;
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).add("-y");
    ((ArrayList)localObject1).add("-i");
    ((ArrayList)localObject1).add(new File(paramString1).getCanonicalPath());
    Object localObject2;
    long l1;
    if (paramBoolean)
    {
      paramString1 = new MediaMetadataRetriever();
      paramString1.setDataSource(paramString2);
      localObject2 = paramString1.extractMetadata(9);
      paramString1.release();
      l1 = paramInt;
    }
    try
    {
      long l2 = Long.parseLong((String)localObject2);
      l1 = l2;
    }
    catch (Exception paramString1)
    {
      label233:
      int i;
      StringBuilder localStringBuilder;
      break label233;
    }
    i = (int)Math.ceil(paramInt / (float)l1);
    if (i > 1)
    {
      paramString1 = new File(paramString2).getCanonicalPath();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(new File(paramString2).getParent());
      ((StringBuilder)localObject2).append("/catAudioFile.txt");
      localObject2 = ((StringBuilder)localObject2).toString();
      localStringBuilder = new StringBuilder();
      paramInt = 0;
      while (paramInt < i)
      {
        if (paramInt > 0) {
          localStringBuilder.append("\n");
        }
        localStringBuilder.append("file '");
        localStringBuilder.append(paramString1);
        localStringBuilder.append("'");
        paramInt += 1;
      }
      com.tencent.mobileqq.utils.FileUtils.writeFile((String)localObject2, localStringBuilder.toString());
      ((ArrayList)localObject1).add("-f");
      ((ArrayList)localObject1).add("concat");
      ((ArrayList)localObject1).add("-safe");
      ((ArrayList)localObject1).add("0");
      ((ArrayList)localObject1).add("-i");
      ((ArrayList)localObject1).add(localObject2);
    }
    else
    {
      ((ArrayList)localObject1).add("-i");
      ((ArrayList)localObject1).add(new File(paramString2).getCanonicalPath());
      break label492;
      ((ArrayList)localObject1).add("-i");
      ((ArrayList)localObject1).add(new File(paramString2).getCanonicalPath());
    }
    label492:
    ((ArrayList)localObject1).add("-map_chapters");
    ((ArrayList)localObject1).add("-1");
    ((ArrayList)localObject1).add("-strict");
    ((ArrayList)localObject1).add("-2");
    ((ArrayList)localObject1).add("-vcodec");
    if (paramClip.videoCodec != null) {
      ((ArrayList)localObject1).add(paramClip.videoCodec);
    } else {
      ((ArrayList)localObject1).add("copy");
    }
    ((ArrayList)localObject1).add("-acodec");
    if (paramClip.audioCodec != null) {
      ((ArrayList)localObject1).add(paramClip.audioCodec);
    } else {
      ((ArrayList)localObject1).add("aac");
    }
    FFmpegUtils.getAuidoType(paramString2);
    ((ArrayList)localObject1).add("-bsf:a");
    ((ArrayList)localObject1).add("aac_adtstoasc");
    if (paramClip.videoBitrate != -1)
    {
      ((ArrayList)localObject1).add("-b:v");
      paramString1 = new StringBuilder();
      paramString1.append(paramClip.videoBitrate);
      paramString1.append("k");
      ((ArrayList)localObject1).add(paramString1.toString());
    }
    if (paramClip.videoFps != null)
    {
      ((ArrayList)localObject1).add("-r");
      ((ArrayList)localObject1).add(paramClip.videoFps);
    }
    if (paramClip.audioBitrate != -1)
    {
      ((ArrayList)localObject1).add("-b:a");
      paramString1 = new StringBuilder();
      paramString1.append(paramClip.audioBitrate);
      paramString1.append("k");
      ((ArrayList)localObject1).add(paramString1.toString());
    }
    if (paramClip.width > 0)
    {
      ((ArrayList)localObject1).add("-s");
      paramString1 = new StringBuilder();
      paramString1.append(paramClip.width);
      paramString1.append("x");
      paramString1.append(paramClip.height);
      ((ArrayList)localObject1).add(paramString1.toString());
    }
    if (paramClip.format != null)
    {
      ((ArrayList)localObject1).add("-f");
      ((ArrayList)localObject1).add(paramClip.format);
    }
    paramString1 = new File(paramClip.path);
    if (paramBoolean) {
      ((ArrayList)localObject1).add("-shortest");
    }
    ((ArrayList)localObject1).add(paramString1.getCanonicalPath());
    execute((String[])((ArrayList)localObject1).toArray(new String[0]), paramFFmpegExecuteResponseCallback);
    return paramClip;
  }
  
  public void combineDoodle(String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-i");
    localArrayList.add(paramString2);
    localArrayList.add("-filter_complex");
    localArrayList.add("[1:v]scale=iw:ih[s];[0:v][s]overlay=0:0");
    localArrayList.add(paramString3);
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void compressVideo(String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    Object localObject = com.tencent.biz.qqstory.utils.FileUtils.o(paramString1);
    if (localObject == null)
    {
      paramFFmpegExecuteResponseCallback.onFailure("input path is null");
      paramFFmpegExecuteResponseCallback.onFinish(false);
      SLog.e("FFmpegCmd", "compressVideo input path is null");
      return;
    }
    int m = 1;
    int i = localObject[1];
    int n = localObject[2];
    int j = -1;
    if ((i <= 960) && (n <= 960))
    {
      i = -1;
    }
    else
    {
      if (n < i)
      {
        j = i * 540 / n;
        k = 540;
      }
      else
      {
        k = n;
        j = i;
      }
      if (i <= n)
      {
        k = n * 540 / i;
        j = 540;
      }
      i = k;
      if (k % 2 != 0) {
        i = k + 1;
      }
      if (j % 2 != 0) {
        j += 1;
      }
    }
    long l = com.tencent.biz.qqstory.utils.FileUtils.a(paramString1);
    int k = m;
    if (l != -1L)
    {
      k = m;
      if (l < 2202009.6000000001D) {
        k = 0;
      }
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add("-y");
    if (paramInt2 != 0)
    {
      ((ArrayList)localObject).add("-ss");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(paramInt1 / 1000));
      localStringBuilder.append(".");
      localStringBuilder.append(String.valueOf(paramInt1 % 1000));
      ((ArrayList)localObject).add(localStringBuilder.toString());
      ((ArrayList)localObject).add("-accurate_seek");
    }
    ((ArrayList)localObject).add("-i");
    ((ArrayList)localObject).add(new File(paramString1).getCanonicalPath());
    if (paramInt2 != 0)
    {
      ((ArrayList)localObject).add("-t");
      paramString1 = new StringBuilder();
      paramString1.append(String.valueOf(paramInt2 / 1000));
      paramString1.append(".");
      paramString1.append(String.valueOf(paramInt2 % 1000));
      ((ArrayList)localObject).add(paramString1.toString());
    }
    if ((j > 0) && (i > 0))
    {
      ((ArrayList)localObject).add("-vf");
      paramString1 = new StringBuilder();
      paramString1.append("scale=");
      paramString1.append(j);
      paramString1.append(":");
      paramString1.append(i);
      ((ArrayList)localObject).add(paramString1.toString());
    }
    if (paramBoolean)
    {
      ((ArrayList)localObject).add("-an");
    }
    else
    {
      ((ArrayList)localObject).add("-acodec");
      ((ArrayList)localObject).add("aac");
    }
    ((ArrayList)localObject).add("-vcodec");
    ((ArrayList)localObject).add("libx264");
    if (k != 0)
    {
      ((ArrayList)localObject).add("-b:v");
      paramString1 = new StringBuilder();
      paramString1.append("");
      paramString1.append(paramInt3);
      ((ArrayList)localObject).add(paramString1.toString());
    }
    ((ArrayList)localObject).add("-bufsize");
    ((ArrayList)localObject).add("800k");
    ((ArrayList)localObject).add("-r");
    ((ArrayList)localObject).add("25");
    ((ArrayList)localObject).add("-metadata");
    paramString1 = new StringBuilder();
    paramString1.append("title=");
    paramString1.append(System.currentTimeMillis());
    ((ArrayList)localObject).add(paramString1.toString());
    ((ArrayList)localObject).add("-movflags");
    ((ArrayList)localObject).add("faststart");
    ((ArrayList)localObject).add(new File(paramString2).getCanonicalPath());
    execute((String[])((ArrayList)localObject).toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void concatDifferentCodingMedia(List<String> paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("concatDifferentCodingMedia arguments: \n inMedias:");
    ((StringBuilder)localObject).append(paramList);
    ((StringBuilder)localObject).append("\n outMedia:");
    ((StringBuilder)localObject).append(paramString);
    SLog.d("FFmpegCmd", ((StringBuilder)localObject).toString());
    localObject = new ArrayList();
    ((ArrayList)localObject).add("-y");
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      ((ArrayList)localObject).add("-i");
      ((ArrayList)localObject).add(new File((String)paramList.get(i)).getCanonicalPath());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[");
      localStringBuilder2.append(i);
      localStringBuilder2.append(":0]");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append(" ");
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[");
      localStringBuilder2.append(i);
      localStringBuilder2.append(":1]");
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder1.append(" ");
      i += 1;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("concat=n=");
    localStringBuilder2.append(paramList.size());
    localStringBuilder2.append(":v=1:a=1 [v] [a]");
    localStringBuilder1.append(localStringBuilder2.toString());
    ((ArrayList)localObject).add("-filter_complex");
    ((ArrayList)localObject).add(localStringBuilder1.toString());
    ((ArrayList)localObject).add("-map");
    ((ArrayList)localObject).add("[v]");
    ((ArrayList)localObject).add("-map");
    ((ArrayList)localObject).add("[a]");
    ((ArrayList)localObject).add(new File(paramString).getCanonicalPath());
    execute((String[])((ArrayList)localObject).toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  /* Error */
  public void concatMedia(List<String> paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 182	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: ldc_w 628
    //   14: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload 6
    //   20: aload_1
    //   21: invokevirtual 453	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 6
    //   27: ldc_w 450
    //   30: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 6
    //   36: aload_2
    //   37: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 31
    //   43: aload 6
    //   45: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 292	com/tencent/biz/qqstory/support/logging/SLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: new 108	java/io/File
    //   54: dup
    //   55: aload_2
    //   56: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: pop
    //   60: new 182	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   67: astore 6
    //   69: aload 6
    //   71: getstatic 633	com/tencent/biz/qqstory/app/QQStoryConstant:m	Ljava/lang/String;
    //   74: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 6
    //   80: ldc_w 635
    //   83: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: new 108	java/io/File
    //   90: dup
    //   91: aload 6
    //   93: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   99: astore 7
    //   101: aload 7
    //   103: invokevirtual 638	java/io/File:exists	()Z
    //   106: ifeq +9 -> 115
    //   109: aload 7
    //   111: invokevirtual 641	java/io/File:delete	()Z
    //   114: pop
    //   115: aload 7
    //   117: invokevirtual 645	java/io/File:getParentFile	()Ljava/io/File;
    //   120: invokevirtual 638	java/io/File:exists	()Z
    //   123: ifne +12 -> 135
    //   126: aload 7
    //   128: invokevirtual 645	java/io/File:getParentFile	()Ljava/io/File;
    //   131: invokevirtual 648	java/io/File:mkdirs	()Z
    //   134: pop
    //   135: aload 7
    //   137: invokevirtual 651	java/io/File:createNewFile	()Z
    //   140: pop
    //   141: new 653	java/io/BufferedWriter
    //   144: dup
    //   145: new 655	java/io/FileWriter
    //   148: dup
    //   149: aload 7
    //   151: iconst_1
    //   152: invokespecial 658	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   155: invokespecial 661	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   158: astore 6
    //   160: iconst_0
    //   161: istore 5
    //   163: iload 5
    //   165: aload_1
    //   166: invokeinterface 606 1 0
    //   171: if_icmpge +81 -> 252
    //   174: new 182	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   181: astore 8
    //   183: aload 8
    //   185: ldc_w 486
    //   188: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 8
    //   194: new 108	java/io/File
    //   197: dup
    //   198: aload_1
    //   199: iload 5
    //   201: invokeinterface 607 2 0
    //   206: checkcast 146	java/lang/String
    //   209: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   212: invokevirtual 232	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   215: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 8
    //   221: ldc_w 488
    //   224: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: aload 6
    //   230: aload 8
    //   232: invokevirtual 200	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokevirtual 664	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   238: aload 6
    //   240: invokevirtual 667	java/io/BufferedWriter:newLine	()V
    //   243: iload 5
    //   245: iconst_1
    //   246: iadd
    //   247: istore 5
    //   249: goto -86 -> 163
    //   252: aload 6
    //   254: invokevirtual 670	java/io/BufferedWriter:flush	()V
    //   257: aload 6
    //   259: invokevirtual 673	java/io/BufferedWriter:close	()V
    //   262: new 67	java/util/ArrayList
    //   265: dup
    //   266: invokespecial 68	java/util/ArrayList:<init>	()V
    //   269: astore_1
    //   270: aload_1
    //   271: ldc 180
    //   273: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   276: pop
    //   277: aload_1
    //   278: ldc 140
    //   280: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   283: pop
    //   284: aload_1
    //   285: ldc_w 496
    //   288: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   291: pop
    //   292: aload_1
    //   293: ldc 126
    //   295: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   298: pop
    //   299: aload_1
    //   300: aload 7
    //   302: invokevirtual 232	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   305: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   308: pop
    //   309: iload 4
    //   311: ifeq +37 -> 348
    //   314: aload_1
    //   315: ldc 136
    //   317: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   320: pop
    //   321: aload_1
    //   322: ldc_w 578
    //   325: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   328: pop
    //   329: aload_1
    //   330: ldc_w 517
    //   333: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   336: pop
    //   337: aload_1
    //   338: ldc_w 519
    //   341: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   344: pop
    //   345: goto +18 -> 363
    //   348: aload_1
    //   349: ldc_w 675
    //   352: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   355: pop
    //   356: aload_1
    //   357: ldc 138
    //   359: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   362: pop
    //   363: aload_1
    //   364: new 108	java/io/File
    //   367: dup
    //   368: aload_2
    //   369: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   372: invokevirtual 232	java/io/File:getCanonicalPath	()Ljava/lang/String;
    //   375: invokevirtual 130	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   378: pop
    //   379: aload_0
    //   380: aload_1
    //   381: iconst_0
    //   382: anewarray 146	java/lang/String
    //   385: invokevirtual 150	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   388: checkcast 152	[Ljava/lang/String;
    //   391: new 677	com/tencent/mobileqq/videocodec/ffmpeg/FFmpeg$2
    //   394: dup
    //   395: aload_0
    //   396: aload_3
    //   397: aload 7
    //   399: invokespecial 680	com/tencent/mobileqq/videocodec/ffmpeg/FFmpeg$2:<init>	(Lcom/tencent/mobileqq/videocodec/ffmpeg/FFmpeg;Lcom/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteResponseCallback;Ljava/io/File;)V
    //   402: invokevirtual 156	com/tencent/mobileqq/videocodec/ffmpeg/FFmpeg:execute	([Ljava/lang/String;Lcom/tencent/mobileqq/videocodec/ffmpeg/FFmpegExecuteResponseCallback;)V
    //   405: return
    //   406: astore_2
    //   407: aload 6
    //   409: astore_1
    //   410: goto +6 -> 416
    //   413: astore_2
    //   414: aconst_null
    //   415: astore_1
    //   416: aload_1
    //   417: ifnull +7 -> 424
    //   420: aload_1
    //   421: invokevirtual 673	java/io/BufferedWriter:close	()V
    //   424: goto +5 -> 429
    //   427: aload_2
    //   428: athrow
    //   429: goto -2 -> 427
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	FFmpeg
    //   0	432	1	paramList	List<String>
    //   0	432	2	paramString	String
    //   0	432	3	paramFFmpegExecuteResponseCallback	FFmpegExecuteResponseCallback
    //   0	432	4	paramBoolean	boolean
    //   161	87	5	i	int
    //   7	401	6	localObject	Object
    //   99	299	7	localFile	File
    //   181	50	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   163	243	406	finally
    //   252	257	406	finally
    //   141	160	413	finally
  }
  
  public void concatMediaByTs(List<String> paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("concatMediaByTs arguments: \n inMedias:");
    ((StringBuilder)localObject1).append(paramList);
    ((StringBuilder)localObject1).append("\n outMedia:");
    ((StringBuilder)localObject1).append(paramString);
    SLog.d("FFmpegCmd", ((StringBuilder)localObject1).toString());
    localObject1 = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localObject2 = (String)paramList.get(i);
      Object localObject3 = new File((String)localObject2).getName().split("\\.");
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(QQStoryConstant.m);
      ((StringBuilder)localObject4).append(localObject3[0]);
      ((StringBuilder)localObject4).append(".ts");
      localObject3 = ((StringBuilder)localObject4).toString();
      localObject4 = new File((String)localObject3);
      if (!((File)localObject4).getParentFile().exists()) {
        ((File)localObject4).getParentFile().mkdirs();
      }
      localObject4 = new FFmpegCommandUnit();
      ((FFmpegCommandUnit)localObject4).cmdType = 5;
      ((FFmpegCommandUnit)localObject4).arguments = new FFmpeg.3(this, (String)localObject2, (String)localObject3);
      ((FFmpegCommandUnit)localObject4).callback = new FFmpeg.4(this, paramFFmpegExecuteResponseCallback);
      ((ArrayList)localObject1).add(localObject4);
      i += 1;
    }
    paramList = new FFmpegCommandUnit();
    Object localObject2 = this.tsFileList;
    paramList.cmdType = 2;
    paramList.arguments = new FFmpeg.5(this, (ArrayList)localObject2, paramString);
    paramList.callback = paramFFmpegExecuteResponseCallback;
    ((ArrayList)localObject1).add(paramList);
    cmdFFmpegQueue((ArrayList)localObject1);
  }
  
  public void concatTsOutput(List<String> paramList, String paramString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\"concat:");
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuffer.append((String)paramList.get(i));
      if (i != paramList.size() - 1) {
        localStringBuffer.append("|");
      }
      i += 1;
    }
    localStringBuffer.append("\"");
    this.tsFileList = new ArrayList();
    paramList = new ArrayList();
    paramList.add("-y");
    paramList.add("-i");
    paramList.add(new String(localStringBuffer));
    paramList.add("-c");
    paramList.add("copy");
    paramList.add("-bsf:a");
    paramList.add("aac_adtstoasc");
    paramList.add(paramString);
    execute((String[])paramList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void convertMp4ToMp3(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vn");
    localArrayList.add("-c:a");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    paramString1 = (String[])localArrayList.toArray(new String[0]);
    SLog.d("FFmpegCmd", "extractAudioFromMp4 args: %s", new Object[] { Arrays.toString(paramString1) });
    execute(paramString1, paramFFmpegExecuteResponseCallback);
  }
  
  public void convertPicToVideo(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-analyzeduration");
    localArrayList.add("2147483647");
    localArrayList.add("-probesize");
    localArrayList.add("2147483647");
    localArrayList.add("-framerate");
    localArrayList.add("1/3");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vcodec");
    localArrayList.add("libx264");
    localArrayList.add("-preset");
    localArrayList.add("veryslow");
    localArrayList.add("-bufsize");
    localArrayList.add("800k");
    localArrayList.add("-metadata");
    paramString1 = new StringBuilder();
    paramString1.append("title=");
    paramString1.append(System.currentTimeMillis());
    localArrayList.add(paramString1.toString());
    localArrayList.add("-movflags");
    localArrayList.add("faststart");
    localArrayList.add("-r");
    localArrayList.add("25");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    paramString1 = (String[])localArrayList.toArray(new String[0]);
    SLog.d("FFmpegCmd", "convertPicToVideo args: %s", new Object[] { Arrays.toString(paramString1) });
    execute(paramString1, paramFFmpegExecuteResponseCallback);
  }
  
  public void convertPicToVideoWithTime(String paramString1, String paramString2, String paramString3, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-analyzeduration");
    localArrayList.add("2147483647");
    localArrayList.add("-probesize");
    localArrayList.add("2147483647");
    localArrayList.add("-framerate");
    localArrayList.add("1/3");
    localArrayList.add("-loop");
    localArrayList.add("1");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vcodec");
    localArrayList.add("libx264");
    localArrayList.add("-pix_fmt");
    localArrayList.add("yuv420p");
    localArrayList.add("-t");
    localArrayList.add(paramString3);
    localArrayList.add("-preset");
    localArrayList.add("veryslow");
    localArrayList.add("-bufsize");
    localArrayList.add("800k");
    localArrayList.add("-metadata");
    paramString1 = new StringBuilder();
    paramString1.append("title=");
    paramString1.append(System.currentTimeMillis());
    localArrayList.add(paramString1.toString());
    localArrayList.add("-movflags");
    localArrayList.add("faststart");
    localArrayList.add("-r");
    localArrayList.add("25");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    paramString1 = (String[])localArrayList.toArray(new String[0]);
    SLog.d("FFmpegCmd", "convertPicToVideoWithTime args: %s", new Object[] { Arrays.toString(paramString1) });
    execute(paramString1, paramFFmpegExecuteResponseCallback);
  }
  
  public void emptyFFmengCmd(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fake ffmeng command. arguments: \n inMedia:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("\n outMedia:");
    localStringBuilder.append(paramString2);
    SLog.d("FFmpegCmd", localStringBuilder.toString());
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      boolean bool = com.tencent.biz.qqstory.utils.FileUtils.a(this.context, paramString1, paramString2);
      if (bool) {
        paramFFmpegExecuteResponseCallback.onSuccess("copy_success");
      } else {
        paramFFmpegExecuteResponseCallback.onFailure("copy_fail");
      }
      paramFFmpegExecuteResponseCallback.onFinish(bool);
      paramString1 = new StringBuilder();
      paramString1.append("copy video to album result is ");
      paramString1.append(bool);
      SLog.d("FFmpegCmd", paramString1.toString());
      return;
    }
    paramFFmpegExecuteResponseCallback.onFailure("input path is null");
    SLog.e("FFmpegCmd", "fake ffmeng command. input path is null");
    paramFFmpegExecuteResponseCallback.onFinish(false);
  }
  
  public void execute(String[] paramArrayOfString, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    Object localObject = this.ffmpegExecuteAsyncTask;
    if ((localObject != null) && (!((FFmpegExecuteAsyncTask)localObject).isProcessCompleted()))
    {
      SLog.e("FFmpegCmd", "FFmpeg command is already running");
      throw new FFmpegCommandAlreadyRunningException("FFmpeg command is already running, you are only allowed to run single command at a time");
    }
    if (paramArrayOfString.length != 0)
    {
      localObject = paramArrayOfString[(paramArrayOfString.length - 1)];
      this.mCurrentCommandUnit = new FFmpegCommandUnit(paramArrayOfString, (String)localObject, paramFFmpegExecuteResponseCallback);
      int i = ((String)localObject).lastIndexOf("/");
      if ((i > -1) && (i < ((String)localObject).length() - 1))
      {
        localObject = new File(((String)localObject).substring(0, i + 1));
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdir();
        }
      }
      paramFFmpegExecuteResponseCallback = new FFmpeg.1(this, paramFFmpegExecuteResponseCallback);
      paramArrayOfString = (String[])Util.concatenate((String[])Util.concatenate(new String[] { FFmpegFileUtils.getFFmpeg(this.context) }, paramArrayOfString), new String[] { FFmpegFileUtils.getAVCodecSoFilePath(this.context) });
      this.ffmpegExecuteAsyncTask = new FFmpegExecuteAsyncTask(this.context, paramArrayOfString, this.timeout, this.mIsWorkThreadCallback, paramFFmpegExecuteResponseCallback);
      this.ffmpegExecuteAsyncTask.execute(new Void[0]);
      paramFFmpegExecuteResponseCallback = new StringBuilder();
      paramFFmpegExecuteResponseCallback.append("command execute: ");
      paramFFmpegExecuteResponseCallback.append(TextUtils.join(" ", paramArrayOfString));
      SLog.d("FFmpegCmd", paramFFmpegExecuteResponseCallback.toString());
      return;
    }
    throw new IllegalArgumentException("shell command cannot be empty");
  }
  
  public void hflip(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vf");
    localArrayList.add("transpose=1");
    localArrayList.add("-metadata:s:v");
    localArrayList.add("rotate=0");
    localArrayList.add(paramString2);
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void insertFFmpegQueue(ArrayList<FFmpegCommandUnit> paramArrayList)
  {
    killRunningProcesses(false);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[insertFFmpegQueue][old] ");
    ((StringBuilder)localObject).append(TextUtils.join(" ", paramArrayList.toArray()));
    SLog.d("FFmpegCmd", ((StringBuilder)localObject).toString());
    localObject = this.mCurrentCommandUnit;
    if (localObject != null) {
      this.mCmdQueue.add(0, localObject);
    }
    this.mCmdQueue.addAll(0, paramArrayList);
    cmdFFmpegQueue(this.mCmdQueue);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[insertFFmpegQueue][new] ");
    ((StringBuilder)localObject).append(TextUtils.join(" ", paramArrayList.toArray()));
    SLog.d("FFmpegCmd", ((StringBuilder)localObject).toString());
  }
  
  public boolean isFFmpegCommandRunning()
  {
    FFmpegExecuteAsyncTask localFFmpegExecuteAsyncTask = this.ffmpegExecuteAsyncTask;
    return (localFFmpegExecuteAsyncTask != null) && (!localFFmpegExecuteAsyncTask.isProcessCompleted());
  }
  
  public void killRunningProcesses(boolean paramBoolean)
  {
    Object localObject = this.ffmpegExecuteAsyncTask;
    if ((localObject != null) && (!((FFmpegExecuteAsyncTask)localObject).isProcessCompleted()))
    {
      Util.killFFmpegProcess(this.ffmpegExecuteAsyncTask);
      this.ffmpegExecuteAsyncTask = null;
      this.mLastTaskResult = -9999;
      localObject = this.mCurrentCommandUnit;
      if (localObject != null)
      {
        if (((FFmpegCommandUnit)localObject).output != null)
        {
          localObject = new File(this.mCurrentCommandUnit.output);
          if (((File)localObject).exists()) {
            ((File)localObject).delete();
          }
        }
        if ((paramBoolean) && (this.mCurrentCommandUnit.callback != null))
        {
          this.mCurrentCommandUnit.callback.onFailure("FFmpeg任务被强制Kill掉");
          this.mCurrentCommandUnit.callback.onFinish(false);
          SLog.d("FFmpegCmd", "FFmpeg任务被强制Kill掉");
        }
      }
      SLog.b("FFmpegCmd", "KillFFmpeg!");
    }
  }
  
  public void killRunningProcessesForShortVideo(boolean paramBoolean)
  {
    Object localObject = this.ffmpegExecuteAsyncTask;
    if ((localObject != null) && (!((FFmpegExecuteAsyncTask)localObject).isProcessCompleted()))
    {
      Util.killFFmpegProcess(this.ffmpegExecuteAsyncTask);
      this.ffmpegExecuteAsyncTask = null;
      this.mLastTaskResult = -9999;
      localObject = this.mCurrentCommandUnit;
      if (localObject != null)
      {
        if (((FFmpegCommandUnit)localObject).output != null)
        {
          localObject = new File(this.mCurrentCommandUnit.output);
          if (((File)localObject).exists()) {
            ((File)localObject).delete();
          }
        }
        if (this.mCurrentCommandUnit.callback != null)
        {
          this.mCurrentCommandUnit.callback.onFailure("FFmpeg任务被强制Kill掉");
          this.mCurrentCommandUnit.callback.onFinish(false);
          SLog.d("FFmpegCmd", "FFmpeg任务被强制Kill掉");
        }
      }
      SLog.b("FFmpegCmd", "KillFFmpeg!");
    }
  }
  
  public void mp4Tots(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mp4Tots arguments: \n input:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("\n outputPath:");
    ((StringBuilder)localObject).append(paramString2);
    SLog.d("FFmpegCmd", ((StringBuilder)localObject).toString());
    this.tsFileList.add(paramString2);
    if (com.tencent.biz.qqstory.utils.FileUtils.d(paramString2))
    {
      paramFFmpegExecuteResponseCallback.onSuccess("TS file exists");
      paramFFmpegExecuteResponseCallback.onFinish(true);
      SLog.d("FFmpegCmd", "TS file exists");
      return;
    }
    localObject = new ArrayList();
    ((ArrayList)localObject).add("-y");
    ((ArrayList)localObject).add("-i");
    ((ArrayList)localObject).add(new File(paramString1).getCanonicalPath());
    ((ArrayList)localObject).add("-c");
    ((ArrayList)localObject).add("copy");
    ((ArrayList)localObject).add("-bsf:v");
    ((ArrayList)localObject).add("h264_mp4toannexb");
    ((ArrayList)localObject).add("-f");
    ((ArrayList)localObject).add("mpegts");
    ((ArrayList)localObject).add(paramString2);
    execute((String[])((ArrayList)localObject).toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void setCurrentTaskUni(String paramString)
  {
    this.mCurrentTaskUni = paramString;
  }
  
  public void setFFMpegCanExe()
  {
    Util.setFileExecutable(new File(FFmpegFileUtils.getFFmpeg(this.context)));
  }
  
  public void setTimestamp(String paramString1, String paramString2, int paramInt, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-metadata");
    paramString1 = new StringBuilder();
    paramString1.append("title=");
    paramString1.append(System.currentTimeMillis());
    localArrayList.add(paramString1.toString());
    paramString1 = new StringBuilder();
    paramString1.append("dev=");
    paramString1.append(DeviceInfoUtil.f());
    paramString1.append("/");
    paramString1.append("os=");
    paramString1.append(DeviceInfoUtil.g());
    paramString1.append("/");
    paramString1.append("appVer=");
    paramString1.append(AppSetting.b());
    localArrayList.add("-metadata");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("comment=");
    localStringBuilder.append(paramString1.toString());
    localArrayList.add(localStringBuilder.toString());
    if (paramInt != -1)
    {
      localArrayList.add("-metadata:s:v:0");
      paramString1 = new StringBuilder();
      paramString1.append("rotate=");
      paramString1.append(paramInt);
      localArrayList.add(paramString1.toString());
    }
    localArrayList.add("-movflags");
    localArrayList.add("faststart");
    localArrayList.add("-codec");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void transcodeM4a(String paramString1, String paramString2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-ab");
    localArrayList.add("96k");
    localArrayList.add("-ar");
    localArrayList.add("44100");
    localArrayList.add("-ac");
    localArrayList.add("1");
    localArrayList.add("-vn");
    localArrayList.add("-acodec");
    localArrayList.add("aac");
    localArrayList.add(paramString2);
    execute((String[])localArrayList.toArray(new String[0]), paramFFmpegExecuteResponseCallback);
  }
  
  public void watermark(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("watermark arguments: \n inImage");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("\n inMedia:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("\n outMedia:");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append("\n videoWidth:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("\n videoHeight:");
    ((StringBuilder)localObject).append(paramInt2);
    SLog.d("FFmpegCmd", ((StringBuilder)localObject).toString());
    if ((paramString2 != null) && (paramString3 != null))
    {
      if (paramString1 == null)
      {
        boolean bool = com.tencent.biz.qqstory.utils.FileUtils.a(this.context, paramString2, paramString3);
        if (bool) {
          paramFFmpegExecuteResponseCallback.onSuccess("copy_success");
        } else {
          paramFFmpegExecuteResponseCallback.onFailure("copy_fail");
        }
        paramFFmpegExecuteResponseCallback.onFinish(bool);
        paramString1 = new StringBuilder();
        paramString1.append("watermark inImage == null, copy to DCIM result is ");
        paramString1.append(bool);
        SLog.d("FFmpegCmd", paramString1.toString());
        return;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add("-y");
      ((ArrayList)localObject).add("-i");
      ((ArrayList)localObject).add(new File(paramString2).getCanonicalPath());
      ((ArrayList)localObject).add("-vf");
      paramString2 = new StringBuilder();
      paramString2.append("movie=");
      paramString2.append(paramString1);
      paramString2.append(" [watermark]; [watermark]scale=");
      paramString2.append(paramInt1);
      paramString2.append(":");
      paramString2.append(paramInt2);
      paramString2.append(" [watermark]; [in][watermark] overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2 [out] ");
      ((ArrayList)localObject).add(paramString2.toString());
      ((ArrayList)localObject).add("-max_muxing_queue_size");
      ((ArrayList)localObject).add("9999");
      ((ArrayList)localObject).add(new File(paramString3).getCanonicalPath());
      execute((String[])((ArrayList)localObject).toArray(new String[0]), paramFFmpegExecuteResponseCallback);
      return;
    }
    paramFFmpegExecuteResponseCallback.onFailure("input path is null");
    paramFFmpegExecuteResponseCallback.onFinish(false);
    SLog.d("FFmpegCmd", "watermark input path is null");
  }
  
  public void watermarkWithRotation(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, FFmpegExecuteResponseCallback paramFFmpegExecuteResponseCallback)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("watermarkWithRotation arguments: \n inImage");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append("\n inMedia:");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append("\n outMedia:");
    ((StringBuilder)localObject).append(paramString3);
    ((StringBuilder)localObject).append("\n videoWidth:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("\n videoHeight:");
    ((StringBuilder)localObject).append(paramInt2);
    SLog.d("FFmpegCmd", ((StringBuilder)localObject).toString());
    if ((paramString2 != null) && (paramString3 != null))
    {
      if (paramString1 == null)
      {
        boolean bool = com.tencent.biz.qqstory.utils.FileUtils.a(this.context, paramString2, paramString3);
        if (bool) {
          paramFFmpegExecuteResponseCallback.onSuccess("copy_success");
        } else {
          paramFFmpegExecuteResponseCallback.onFailure("copy_fail");
        }
        paramFFmpegExecuteResponseCallback.onFinish(bool);
        paramString1 = new StringBuilder();
        paramString1.append("watermarkWithRotation inImage == null, copy to DCIM result is ");
        paramString1.append(bool);
        SLog.d("FFmpegCmd", paramString1.toString());
        return;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add("-y");
      ((ArrayList)localObject).add("-i");
      ((ArrayList)localObject).add(new File(paramString2).getCanonicalPath());
      ((ArrayList)localObject).add("-vf");
      paramString2 = new StringBuilder();
      paramString2.append("[in]transpose=1 [in]; movie=");
      paramString2.append(paramString1);
      paramString2.append(" [watermark]; [watermark]scale=");
      paramString2.append(paramInt1);
      paramString2.append(":");
      paramString2.append(paramInt2);
      paramString2.append(" [watermark]; [in][watermark] overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2 [out]");
      ((ArrayList)localObject).add(paramString2.toString());
      ((ArrayList)localObject).add("-metadata:s:v");
      ((ArrayList)localObject).add("rotate=0");
      ((ArrayList)localObject).add(new File(paramString3).getCanonicalPath());
      execute((String[])((ArrayList)localObject).toArray(new String[0]), paramFFmpegExecuteResponseCallback);
      return;
    }
    paramFFmpegExecuteResponseCallback.onFailure("input path is null");
    SLog.d("FFmpegCmd", "watermarkWithRotation input path is null");
    paramFFmpegExecuteResponseCallback.onFinish(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videocodec.ffmpeg.FFmpeg
 * JD-Core Version:    0.7.0.1
 */