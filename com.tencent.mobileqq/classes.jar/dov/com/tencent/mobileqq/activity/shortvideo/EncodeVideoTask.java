package dov.com.tencent.mobileqq.activity.shortvideo;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import aorg;
import aori;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.utils.ffmpeg.ExecuteBinResponseCallback;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.mediacodec.utils.ShortVideoExceptionReporter;
import com.tencent.mobileqq.shortvideo.mediadevice.CodecParam;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo;
import dov.com.tencent.mobileqq.richmedia.mediacodec.MergeEditVideo.EditParam;
import dov.com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import dov.com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import dov.com.tencent.mobileqq.shortvideo.util.HwVideoMerge;
import java.io.File;
import java.util.HashMap;

public class EncodeVideoTask
  extends AsyncTask
{
  private static FFmpeg jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private aori jdField_a_of_type_Aori = new aorg(this);
  private EncodeVideoTask.ResultListener jdField_a_of_type_DovComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener;
  private EncodeVideoTask.ThumbInfo jdField_a_of_type_DovComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = true;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean;
  private String e;
  
  public EncodeVideoTask(Context paramContext, String paramString, boolean paramBoolean1, EncodeVideoTask.ThumbInfo paramThumbInfo, boolean paramBoolean2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoEncodeVideoTask$ThumbInfo = paramThumbInfo;
    this.jdField_c_of_type_Boolean = paramBoolean1;
    this.jdField_d_of_type_Boolean = paramBoolean2;
    if (paramThumbInfo != null) {
      this.jdField_b_of_type_JavaLangString = paramThumbInfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  private int a(String paramString1, String paramString2, PublishVideoEntry paramPublishVideoEntry, boolean paramBoolean)
  {
    System.currentTimeMillis();
    MergeEditVideo localMergeEditVideo = new MergeEditVideo();
    MergeEditVideo.EditParam localEditParam = new MergeEditVideo.EditParam(CodecParam.r, paramPublishVideoEntry);
    localEditParam.a = paramBoolean;
    return localMergeEditVideo.a(paramString1, paramString2, localEditParam, paramPublishVideoEntry);
  }
  
  public static void a(long paramLong, int paramInt)
  {
    if (paramLong <= 0L) {}
    for (;;)
    {
      return;
      String str = "";
      if (paramInt == 1) {
        str = "actShortVideoGenerateSource";
      }
      while (!TextUtils.isEmpty(str))
      {
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(null, str, true, paramLong, 0L, null, "");
        return;
        if (paramInt == 2) {
          str = "actShortVideoGenerateAudio";
        } else if (paramInt == 3) {
          str = "actShortVideoGeneratePic";
        } else if (paramInt == 4) {
          str = "actMediaCodecMergeEdit";
        } else if (paramInt == 5) {
          str = "actMediaCodecMergeSelfAudio";
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("EncodeVideoTask", 2, "" + paramString);
    }
  }
  
  private static void b(String paramString, PublishVideoEntry paramPublishVideoEntry, aori paramaori)
  {
    String str = ShortVideoUtils.a(new File(paramPublishVideoEntry.mLocalRawVideoDir));
    if (jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg == null) {
      jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg = FFmpeg.a(BaseApplicationImpl.getApplication());
    }
    if (jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files mFFmpeg is running!");
      }
      return;
    }
    try
    {
      EncodeVideoTask.VideoSaveAlumCallBack localVideoSaveAlumCallBack = new EncodeVideoTask.VideoSaveAlumCallBack(paramPublishVideoEntry, paramString, str, paramaori);
      jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a(str);
      jdField_a_of_type_ComTencentBizQqstoryUtilsFfmpegFFmpeg.a(paramPublishVideoEntry.doodlePath, paramString, str, paramPublishVideoEntry.videoWidth, paramPublishVideoEntry.videoHeight, localVideoSaveAlumCallBack);
      return;
    }
    catch (Exception paramString)
    {
      paramaori.a(-12);
      QLog.e("EncodeVideoTask", 2, "generate files save alum:", paramString);
    }
  }
  
  protected Integer a(Void... paramVarArgs)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return c(paramVarArgs);
    }
    return b(paramVarArgs);
  }
  
  public void a(EncodeVideoTask.ResultListener paramResultListener)
  {
    this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener = paramResultListener;
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", Integer.toString(paramInteger.intValue()));
    StatisticCollector localStatisticCollector = StatisticCollector.a(BaseApplicationImpl.getContext());
    if (paramInteger.intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.a(null, "actMediaCodecEncodeSuccessRate", bool, 0L, 0L, localHashMap, "");
      if (paramInteger.intValue() != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EncodeVideoTask", 2, "onPostExecute result:" + paramInteger);
        }
        this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoEncodeVideoTask$ResultListener.a(paramInteger.intValue());
      }
      return;
    }
  }
  
  protected Integer b(Void... paramVarArgs)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return Integer.valueOf(-1);
    }
    long l1 = System.currentTimeMillis();
    PublishVideoEntry localPublishVideoEntry = VideoCompositeHelper.a(this.jdField_a_of_type_JavaLangString);
    if (localPublishVideoEntry == null)
    {
      a("[NewVersion]configure param error, fakeVid:" + this.jdField_a_of_type_JavaLangString);
      return Integer.valueOf(-2);
    }
    if (TextUtils.isEmpty(localPublishVideoEntry.mLocalRawVideoDir))
    {
      QLog.e("EncodeVideoTask", 2, "[NewVersion]configure param error, fakeId:" + this.jdField_a_of_type_JavaLangString + ", EntryId:" + localPublishVideoEntry.fakeVid);
      ShortVideoExceptionReporter.a(new RuntimeException("onMediaCodecEncode failed"));
      return Integer.valueOf(-2);
    }
    File localFile1 = new File(localPublishVideoEntry.mLocalRawVideoDir);
    paramVarArgs = localFile1.getParentFile();
    String str2 = ShortVideoUtils.a(paramVarArgs);
    Object localObject = localPublishVideoEntry.mLocalRawVideoDir;
    String str1 = paramVarArgs.getAbsolutePath() + File.separator + "mc_audio.mp4";
    if (!FileUtils.b((String)localObject))
    {
      a("[NewVersion]video file empty, path=" + (String)localObject);
      return Integer.valueOf(-3);
    }
    long l2 = System.currentTimeMillis();
    paramVarArgs = (String)localObject + "_merge_video_x.mp4";
    int i = a((String)localObject, paramVarArgs, localPublishVideoEntry, this.jdField_d_of_type_Boolean);
    if (i != 0) {
      if (i == -1)
      {
        File localFile2 = new File(paramVarArgs);
        paramVarArgs = (Void[])localObject;
        if (localFile2.exists())
        {
          localFile2.delete();
          paramVarArgs = (Void[])localObject;
        }
        if ((TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath)) || (!FileUtils.a(localPublishVideoEntry.backgroundMusicPath))) {
          break label502;
        }
      }
    }
    label502:
    for (i = 1;; i = 0)
    {
      l2 = System.currentTimeMillis();
      if (!localPublishVideoEntry.isMuteRecordVoice)
      {
        localObject = str1;
        if (i == 0) {}
      }
      else
      {
        localObject = null;
      }
      int j = HwVideoMerge.a(paramVarArgs, (String)localObject, str2, 0);
      a("[NewVersion]HwVideoMerge.merge cost:" + (System.currentTimeMillis() - l2) / 1000.0D);
      a(System.currentTimeMillis() - l2, 5);
      if (j == 0) {
        break label507;
      }
      a("[NewVersion]HwVideoMerge->merge: errcode=" + j);
      return Integer.valueOf(-5);
      a("[NewVersion]videoSynthesis: errcode=" + i);
      return Integer.valueOf(-4);
      a(System.currentTimeMillis() - l2, 4);
      break;
    }
    label507:
    if (i != 0) {}
    for (;;)
    {
      try
      {
        l2 = System.currentTimeMillis();
        paramVarArgs = ShortVideoUtils.d(localFile1);
        localObject = new File(paramVarArgs).getParentFile();
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        long l3 = ShortVideoUtils.b(str2);
        localObject = new EncodeVideoTask.ResponseCallBack(localPublishVideoEntry, str2, paramVarArgs);
        ((EncodeVideoTask.ResponseCallBack)localObject).a(this.jdField_a_of_type_Aori);
        FFmpegUtils.a(true, this.jdField_a_of_type_AndroidContentContext, str2, localPublishVideoEntry.backgroundMusicPath, localPublishVideoEntry.backgroundMusicOffset, (int)l3, paramVarArgs, (ExecuteBinResponseCallback)localObject);
        a("[NewVersion]FFmpegUtils.combinBackgroundMusic cost:" + (System.currentTimeMillis() - l2) / 1000.0D);
      }
      catch (Exception paramVarArgs)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EncodeVideoTask", 2, "generate error:", paramVarArgs);
        continue;
      }
      a("[NewVersion] doInBackground cost:" + (System.currentTimeMillis() - l1) / 1000.0D);
      return Integer.valueOf(0);
      this.jdField_a_of_type_Aori.a(localPublishVideoEntry, str2);
    }
  }
  
  protected Integer c(Void... paramVarArgs)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      return Integer.valueOf(-1);
    }
    PublishVideoEntry localPublishVideoEntry = VideoCompositeHelper.a(this.jdField_a_of_type_JavaLangString);
    if (localPublishVideoEntry == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("EncodeVideoTask", 2, "configure param error, fakeVid:" + this.jdField_a_of_type_JavaLangString);
      }
      return Integer.valueOf(-2);
    }
    CodecParam.y = (int)localPublishVideoEntry.recordTime;
    CodecParam.z = localPublishVideoEntry.recordFrames;
    if (localPublishVideoEntry.saveMode != 0) {
      CodecParam.J = localPublishVideoEntry.saveMode;
    }
    int i;
    label131:
    int j;
    Object localObject2;
    Object localObject1;
    long l;
    if (localPublishVideoEntry.businessId == 2)
    {
      i = 0;
      CodecParam.D = i;
      if (TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath)) {
        break label386;
      }
      i = 1;
      if (TextUtils.isEmpty(localPublishVideoEntry.doodlePath)) {
        break label391;
      }
      j = 1;
      localObject2 = new File(localPublishVideoEntry.mLocalRawVideoDir);
      localObject1 = ShortVideoUtils.b((File)localObject2);
      paramVarArgs = (Void[])localObject1;
      if (i == 0)
      {
        paramVarArgs = (Void[])localObject1;
        if (j == 0) {
          paramVarArgs = ShortVideoUtils.a((File)localObject2);
        }
      }
      l = System.currentTimeMillis();
      localObject1 = new EncodeThread(null, null, localPublishVideoEntry.mLocalRawVideoDir, paramVarArgs, null);
      ((EncodeThread)localObject1).a(false);
      ((EncodeThread)localObject1).b(false);
      ((EncodeThread)localObject1).c(localPublishVideoEntry.isMuteRecordVoice);
      if (localPublishVideoEntry.mMosaicMask != null) {
        ((EncodeThread)localObject1).a(localPublishVideoEntry.mMosaicMask, localPublishVideoEntry.mMosaicSize);
      }
      ((EncodeThread)localObject1).run();
      a(System.currentTimeMillis() - l, 1);
      if (QLog.isColorLevel()) {
        QLog.d("EncodeVideoTask", 2, "generate files|first step cost:" + (System.currentTimeMillis() - l) / 1000.0D);
      }
      if (i == 0) {
        break label416;
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = ShortVideoUtils.d((File)localObject2);
        l = ShortVideoUtils.b(paramVarArgs);
        localObject2 = new EncodeVideoTask.ResponseCallBack(localPublishVideoEntry, paramVarArgs, (String)localObject1);
        ((EncodeVideoTask.ResponseCallBack)localObject2).a(this.jdField_a_of_type_Aori);
        FFmpegUtils.a(true, this.jdField_a_of_type_AndroidContentContext, paramVarArgs, localPublishVideoEntry.backgroundMusicPath, localPublishVideoEntry.backgroundMusicOffset, (int)l, (String)localObject1, (ExecuteBinResponseCallback)localObject2);
        return Integer.valueOf(0);
        i = 1;
        break;
        label386:
        i = 0;
        break label131;
        label391:
        j = 0;
      }
      catch (Exception paramVarArgs)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("EncodeVideoTask", 2, "generate error:", paramVarArgs);
        continue;
      }
      label416:
      this.jdField_a_of_type_Aori.a(localPublishVideoEntry, paramVarArgs);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.shortvideo.EncodeVideoTask
 * JD-Core Version:    0.7.0.1
 */