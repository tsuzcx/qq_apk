package com.tencent.ttpic.videoshelf.model.player;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import com.tencent.ttpic.videoshelf.libpag.PagNotSupportSystemException;
import com.tencent.ttpic.videoshelf.libpag.PagUtil;
import com.tencent.ttpic.videoshelf.utils.TTPTLogger;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Timer;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGRenderer;
import org.libpag.PAGSurface;
import org.libpag.PAGText;

public class PagShelfPlayer
  implements IVideoShelfPlayer
{
  public static final String AUDIO_PATH = "pagShelfPlayerAudioFilePath";
  public static final int ERR_AUDIO_PLAYER = -2;
  public static final int ERR_FILE_NOT_FOUND = -1;
  public static final String IMG_GROUP = "imgGroup";
  public static final String PAG_IMG = "pagImgReplace";
  public static final int PAG_SDK_LOW = -3;
  public static final String PAG_TEXT = "pagTextReplace";
  private final int FRAME_GAP_TIME = 40;
  private final String TAG = "PagShelfPlayer";
  private boolean isStoped = true;
  private MediaPlayer mAudioPlayer;
  private long mDuration = 0L;
  private int mFrameCount = 0;
  private double mFrameProgressGap = 0.0D;
  private Handler mHandler;
  private boolean mIsAudioPlaying = false;
  private boolean mIsPlaying = false;
  private PAGFile mPagFile;
  private PAGRenderer mPagRender;
  private PAGSurface mPagSurface;
  private PagShelfPlayer.PagPlayTimerTask mPlayTask;
  private PagShelfPlayer.RenderRunable mRenderRunable;
  private long mTime = 0L;
  private Timer mTimer;
  private IVideoShelfPlayerListener mVideoShelfListener;
  
  public PagShelfPlayer()
  {
    if (PagUtil.isSupportPagForVideo())
    {
      this.mPagRender = new PAGRenderer();
      if (AEOfflineConfig.isNeedSoftDecode()) {
        PagUtil.useSoftDecode();
      }
      this.mPlayTask = new PagShelfPlayer.PagPlayTimerTask(this, null);
      this.mHandler = new Handler();
      this.mRenderRunable = new PagShelfPlayer.RenderRunable(this, null);
      return;
    }
    Log.i("PagShelfPlayer", "当前系统不支持PAG。");
    TTPTLogger.e("PagShelfPlayer", "当前系统不支持PAG。");
    throw new PagNotSupportSystemException("PagShelfPlayer");
  }
  
  private void setPagfile(PAGFile paramPAGFile)
  {
    if (paramPAGFile == null)
    {
      TTPTLogger.e("PagShelfPlayer", "pagfile is null.");
      paramPAGFile = this.mVideoShelfListener;
      if (paramPAGFile != null) {
        paramPAGFile.onError(-1, "pagfile is null", null);
      }
      return;
    }
    if (paramPAGFile.tagLevel() > PAGFile.MaxSupportedTagLevel())
    {
      paramPAGFile = this.mVideoShelfListener;
      if (paramPAGFile != null) {
        paramPAGFile.onError(-3, "pagsdk version is low", null);
      }
      return;
    }
    this.mPagFile = paramPAGFile;
    Object localObject = this.mVideoShelfListener;
    if (localObject != null) {
      ((IVideoShelfPlayerListener)localObject).onChangVideoSize(this.mPagFile.width(), this.mPagFile.height());
    }
    this.mDuration = paramPAGFile.duration();
    double d = this.mDuration;
    Double.isNaN(d);
    this.mFrameProgressGap = (40000.0D / d);
    localObject = this.mPlayTask;
    if (localObject != null) {
      ((PagShelfPlayer.PagPlayTimerTask)localObject).reset();
    }
    this.mPagRender.setFile(paramPAGFile);
    if (AEOfflineConfig.isNeedScale())
    {
      Log.i("PagShelfPlayer", "使用低尺度的PAG文件进行预览。");
      TTPTLogger.i("PagShelfPlayer", "使用低尺度的PAG文件进行预览。");
      this.mPagRender.setMaxFrameRate(-1.0F);
      this.mPagRender.setCacheScale(AEOfflineConfig.getPagPlayScale());
    }
  }
  
  private void setTimeCount()
  {
    long l = System.currentTimeMillis();
    if (l - this.mTime > 1000L)
    {
      IVideoShelfPlayerListener localIVideoShelfPlayerListener = this.mVideoShelfListener;
      if (localIVideoShelfPlayerListener != null) {
        localIVideoShelfPlayerListener.onUpdateRate(this.mFrameCount);
      }
      this.mTime = l;
      this.mFrameCount = 0;
    }
    this.mFrameCount += 1;
  }
  
  public void flush()
  {
    Log.i("VideoShelfPlayView", "PagShelfPlayer-flush");
    this.mPagRender.flush(true);
  }
  
  public int getCurrentPosition()
  {
    double d1 = this.mPagRender.getProgress();
    double d2 = this.mDuration;
    Double.isNaN(d2);
    return (int)(d1 * d2 / 1000.0D);
  }
  
  public long getDuration()
  {
    return this.mDuration / 1000L;
  }
  
  public Object getPagRender()
  {
    return this.mPagRender;
  }
  
  public int getVideoHeight()
  {
    PAGFile localPAGFile = this.mPagFile;
    if (localPAGFile != null) {
      return localPAGFile.height();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    PAGFile localPAGFile = this.mPagFile;
    if (localPAGFile != null) {
      return localPAGFile.width();
    }
    return 0;
  }
  
  public boolean isPlaying()
  {
    return this.mIsPlaying;
  }
  
  public void pause()
  {
    TTPTLogger.i("PagShelfPlayer", "pause");
    this.mIsPlaying = false;
    Object localObject = this.mPlayTask;
    if (localObject != null) {
      ((PagShelfPlayer.PagPlayTimerTask)localObject).pause();
    }
    localObject = this.mAudioPlayer;
    if ((localObject != null) && (!this.isStoped)) {
      try
      {
        ((MediaPlayer)localObject).pause();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("audioplayer pause has IllegalStateException:");
        localStringBuilder.append(localIllegalStateException.getMessage());
        Log.e("PagShelfPlayer", localStringBuilder.toString());
      }
    }
  }
  
  public void prepare()
  {
    MediaPlayer localMediaPlayer = this.mAudioPlayer;
    if (localMediaPlayer != null)
    {
      try
      {
        localMediaPlayer.prepare();
        this.isStoped = false;
      }
      catch (IllegalStateException localIllegalStateException) {}catch (IOException localIOException) {}
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("audioplayer prepare has IOException|IllegalStateException:");
      localStringBuilder.append(localIOException.getMessage());
      TTPTLogger.e("PagShelfPlayer", localStringBuilder.toString());
    }
    IVideoShelfPlayerListener localIVideoShelfPlayerListener = this.mVideoShelfListener;
    if (localIVideoShelfPlayerListener != null) {
      localIVideoShelfPlayerListener.onPrepared(this);
    }
    TTPTLogger.i("PagShelfPlayer", "prepare.");
  }
  
  public void reset()
  {
    TTPTLogger.i("PagShelfPlayer", "reset");
    Object localObject = this.mPlayTask;
    if (localObject != null) {
      ((PagShelfPlayer.PagPlayTimerTask)localObject).reset();
    }
    this.mPagRender.setProgress(0.0D);
    this.mIsPlaying = false;
    localObject = this.mPagSurface;
    if (localObject != null) {
      ((PAGSurface)localObject).freeCache();
    }
    localObject = this.mAudioPlayer;
    if (localObject != null) {
      ((MediaPlayer)localObject).reset();
    }
  }
  
  public void seekTo(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("seekto:");
    double d1 = paramInt;
    Double.isNaN(d1);
    d1 *= 1000.0D;
    double d2 = this.mDuration;
    Double.isNaN(d2);
    ((StringBuilder)localObject).append(d1 / d2);
    TTPTLogger.i("PagShelfPlayer", ((StringBuilder)localObject).toString());
    localObject = this.mPagRender;
    d2 = this.mDuration;
    Double.isNaN(d2);
    ((PAGRenderer)localObject).setProgress(d1 / d2);
    this.mPagRender.flush();
    localObject = this.mAudioPlayer;
    if (localObject != null)
    {
      try
      {
        if (this.isStoped)
        {
          ((MediaPlayer)localObject).prepare();
          this.isStoped = false;
        }
        this.mAudioPlayer.seekTo(paramInt);
        return;
      }
      catch (IllegalStateException localIllegalStateException) {}catch (IOException localIOException) {}
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("audioplayer seekto has IllegalStateException:");
      localStringBuilder.append(localIOException.getMessage());
      TTPTLogger.e("PagShelfPlayer", localStringBuilder.toString());
    }
  }
  
  public void setDataSource(AssetManager paramAssetManager, String paramString)
  {
    if (paramAssetManager != null)
    {
      if (paramString == null) {
        return;
      }
      setPagfile(PAGFile.Load(paramAssetManager, paramString));
    }
  }
  
  public void setDataSource(String paramString)
  {
    if (paramString == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pag path:");
    localStringBuilder.append(paramString);
    TTPTLogger.i("PagShelfPlayer", localStringBuilder.toString());
    setPagfile(PAGFile.Load(paramString));
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    if (paramSurfaceHolder == null) {
      paramSurfaceHolder = null;
    } else {
      paramSurfaceHolder = PAGSurface.FromSurface(paramSurfaceHolder.getSurface());
    }
    this.mPagSurface = paramSurfaceHolder;
    this.mPagRender.setSurface(this.mPagSurface);
  }
  
  public void setLooping(boolean paramBoolean)
  {
    Object localObject = this.mPlayTask;
    int i;
    if (paramBoolean) {
      i = -1;
    } else {
      i = 1;
    }
    ((PagShelfPlayer.PagPlayTimerTask)localObject).setReaptTime(i);
    localObject = this.mAudioPlayer;
    if (localObject != null) {
      ((MediaPlayer)localObject).setLooping(paramBoolean);
    }
  }
  
  public void setParam(String paramString, Object... paramVarArgs)
  {
    int i = paramString.hashCode();
    int k = 0;
    int j = 0;
    switch (i)
    {
    default: 
      break;
    case 1991330946: 
      if (paramString.equals("pagShelfPlayerAudioFilePath")) {
        i = 0;
      }
      break;
    case 1707690663: 
      if (paramString.equals("pagImgReplace")) {
        i = 1;
      }
      break;
    case -716976004: 
      if (paramString.equals("imgGroup")) {
        i = 3;
      }
      break;
    case -1145231791: 
      if (paramString.equals("pagTextReplace")) {
        i = 2;
      }
      break;
    }
    i = -1;
    paramString = null;
    Object localObject;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return;
          }
          if (paramVarArgs != null)
          {
            if (paramVarArgs.length == 0) {
              return;
            }
            paramString = paramVarArgs[0];
            if ((paramString instanceof HashMap))
            {
              paramString = (HashMap)paramString;
              if (paramString == null) {
                return;
              }
              paramString = paramString.entrySet().iterator();
              while (paramString.hasNext())
              {
                paramVarArgs = (Map.Entry)paramString.next();
                setParam("pagImgReplace", new Object[] { paramVarArgs.getValue(), paramVarArgs.getKey() });
              }
            }
          }
        }
        else if ((paramVarArgs != null) && (paramVarArgs.length >= 2))
        {
          paramString = paramVarArgs[0];
          if ((paramString instanceof Integer[]))
          {
            if ((paramVarArgs[1] instanceof Bitmap))
            {
              setParam("pagImgReplace", paramVarArgs);
              return;
            }
            if (((paramVarArgs[1] instanceof String)) && (this.mPagFile != null) && (this.mPagRender != null))
            {
              paramString = (Integer[])paramString;
              k = paramString.length;
              i = j;
              while (i < k)
              {
                j = paramString[i].intValue();
                if (j >= this.mPagFile.numTexts()) {
                  return;
                }
                localObject = this.mPagFile.getTextData(j);
                if (localObject == null)
                {
                  TTPTLogger.e("PagShelfPlayer", "文字样式在PAG文件中未找到，无法进行设置文字");
                  return;
                }
                ((PAGText)localObject).text = ((String)paramVarArgs[1]);
                this.mPagRender.setTextData(j, (PAGText)localObject);
                i += 1;
              }
            }
          }
        }
        else
        {
          TTPTLogger.e("PagShelfPlayer", "传入PAG的替换文本参数有误");
        }
      }
      else if ((paramVarArgs != null) && (paramVarArgs.length >= 2))
      {
        localObject = paramVarArgs[0];
        if ((localObject instanceof int[]))
        {
          if ((paramVarArgs[1] instanceof Bitmap)) {
            paramString = (Bitmap)paramVarArgs[1];
          } else if ((paramVarArgs[1] instanceof String)) {
            paramString = BitmapUtils.decodeSampledBitmapFromFile((String)paramVarArgs[1], 1080, 1080);
          }
          if (paramString == null)
          {
            TTPTLogger.e("PagShelfPlayer", "传入PAG的替换图像为空。");
            return;
          }
          paramString = PAGImage.FromBitmap(paramString);
          paramString.setScaleMode(3);
          paramVarArgs = (int[])localObject;
          j = paramVarArgs.length;
          i = k;
          while (i < j)
          {
            k = paramVarArgs[i];
            this.mPagRender.replaceImage(k, paramString);
            i += 1;
          }
        }
      }
      else
      {
        TTPTLogger.e("PagShelfPlayer", "传入PAG的替换图像参数有误");
      }
    }
    else
    {
      paramString = paramVarArgs[0];
      if ((paramString instanceof Boolean)) {
        try
        {
          if (((Boolean)paramString).booleanValue())
          {
            localObject = paramVarArgs[1];
            paramString = paramVarArgs[2];
            if (((localObject instanceof AssetManager)) && ((paramString instanceof String)))
            {
              paramVarArgs = ((AssetManager)localObject).openFd((String)paramString);
              this.mAudioPlayer = new ReportMediaPlayer();
              this.mAudioPlayer.setDataSource(paramVarArgs.getFileDescriptor(), paramVarArgs.getStartOffset(), paramVarArgs.getLength());
              paramVarArgs = new StringBuilder();
              paramVarArgs.append("audio path(asset):");
              paramVarArgs.append((String)paramString);
              TTPTLogger.i("PagShelfPlayer", paramVarArgs.toString());
            }
          }
          else
          {
            paramString = paramVarArgs[1];
            if ((paramString instanceof String))
            {
              this.mAudioPlayer = new ReportMediaPlayer();
              this.mAudioPlayer.setDataSource((String)paramString);
              paramVarArgs = new StringBuilder();
              paramVarArgs.append("audio path:");
              paramVarArgs.append((String)paramString);
              TTPTLogger.i("PagShelfPlayer", paramVarArgs.toString());
            }
          }
          if (this.mAudioPlayer != null)
          {
            this.mAudioPlayer.setOnCompletionListener(new PagShelfPlayer.1(this));
            this.mAudioPlayer.setOnErrorListener(new PagShelfPlayer.2(this));
            return;
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          paramVarArgs = this.mVideoShelfListener;
          if (paramVarArgs != null) {
            paramVarArgs.onError(-1, "audio file is null", null);
          }
          paramVarArgs = new StringBuilder();
          paramVarArgs.append("[");
          paramVarArgs.append(PagShelfPlayer.class.getSimpleName());
          paramVarArgs.append("] mVideoPlayer.setDataSource , error msg = ");
          paramVarArgs.append(paramString.toString());
          ReportUtil.report(paramVarArgs.toString());
        }
      }
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    TTPTLogger.i("PagShelfPlayer", "setsurface.");
    if (paramSurface == null) {
      paramSurface = null;
    } else {
      paramSurface = PAGSurface.FromSurface(paramSurface);
    }
    this.mPagSurface = paramSurface;
    this.mPagRender.setSurface(this.mPagSurface);
  }
  
  public void setVideoShelfPlayerListener(IVideoShelfPlayerListener paramIVideoShelfPlayerListener)
  {
    this.mVideoShelfListener = paramIVideoShelfPlayerListener;
  }
  
  public void start()
  {
    double d1 = this.mPagRender.getProgress();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("start:");
    ((StringBuilder)localObject).append(d1);
    TTPTLogger.i("PagShelfPlayer", ((StringBuilder)localObject).toString());
    localObject = this.mPlayTask;
    if (localObject != null) {
      ((PagShelfPlayer.PagPlayTimerTask)localObject).resume();
    }
    if (this.mTimer == null)
    {
      this.mTimer = new Timer();
      this.mTimer.schedule(this.mPlayTask, 0L, 40L);
    }
    this.mIsPlaying = true;
    localObject = this.mAudioPlayer;
    if (localObject != null)
    {
      try
      {
        if (this.isStoped)
        {
          ((MediaPlayer)localObject).prepare();
          this.isStoped = false;
        }
        if (this.mPlayTask.isLooping()) {
          this.mAudioPlayer.setLooping(this.mPlayTask.isLooping());
        }
        localObject = this.mAudioPlayer;
        long l = this.mDuration;
        double d2 = l;
        Double.isNaN(d2);
        int i = (int)(d2 * d1 / 1000.0D);
        ((MediaPlayer)localObject).seekTo(i);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("start:");
        l = this.mDuration;
        d2 = l;
        Double.isNaN(d2);
        i = (int)(d2 * d1 / 1000.0D);
        ((StringBuilder)localObject).append(i);
        TTPTLogger.i("PagShelfPlayer", ((StringBuilder)localObject).toString());
        this.mAudioPlayer.start();
        this.mIsAudioPlaying = true;
        return;
      }
      catch (IllegalStateException localIllegalStateException) {}catch (IOException localIOException) {}
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("audioplayer start has IllegalStateException:");
      localStringBuilder.append(localIOException.getMessage());
      TTPTLogger.e("PagShelfPlayer", localStringBuilder.toString());
    }
  }
  
  public void stop()
  {
    TTPTLogger.i("PagShelfPlayer", "stop");
    this.mIsPlaying = false;
    Object localObject = this.mPagSurface;
    if (localObject != null) {
      ((PAGSurface)localObject).freeCache();
    }
    this.mPagRender.setSurface(null);
    localObject = this.mTimer;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.mTimer = null;
    }
    localObject = this.mPlayTask;
    if (localObject != null)
    {
      ((PagShelfPlayer.PagPlayTimerTask)localObject).pause();
      this.mPlayTask.cancel();
    }
    localObject = this.mAudioPlayer;
    if (localObject != null) {
      try
      {
        this.mIsAudioPlaying = false;
        ((MediaPlayer)localObject).stop();
        this.isStoped = true;
        this.mAudioPlayer.release();
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("audioplayer stop has IllegalStateException:");
        localStringBuilder.append(localIllegalStateException.getMessage());
        Log.e("PagShelfPlayer", localStringBuilder.toString());
      }
    }
  }
  
  public void surfaceUpdateSize()
  {
    PAGSurface localPAGSurface = this.mPagSurface;
    if (localPAGSurface != null)
    {
      localPAGSurface.updateSize();
      this.mPagRender.flush();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer
 * JD-Core Version:    0.7.0.1
 */