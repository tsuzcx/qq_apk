package com.tencent.ttpic.videoshelf.model.player;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.report.ReportUtil;
import com.tencent.ttpic.openapi.offlineset.OfflineConfig;
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
    if (!PagUtil.isSupportPagForVideo())
    {
      Log.i("PagShelfPlayer", "当前系统不支持PAG。");
      TTPTLogger.e("PagShelfPlayer", "当前系统不支持PAG。");
      throw new PagNotSupportSystemException("PagShelfPlayer");
    }
    this.mPagRender = new PAGRenderer();
    if (OfflineConfig.isNeedSoftDecode()) {
      PagUtil.useSoftDecode();
    }
    this.mPlayTask = new PagShelfPlayer.PagPlayTimerTask(this, null);
    this.mHandler = new Handler();
    this.mRenderRunable = new PagShelfPlayer.RenderRunable(this, null);
  }
  
  private void setPagfile(PAGFile paramPAGFile)
  {
    if (paramPAGFile == null)
    {
      TTPTLogger.e("PagShelfPlayer", "pagfile is null.");
      if (this.mVideoShelfListener != null) {
        this.mVideoShelfListener.onError(-1, "pagfile is null", null);
      }
    }
    do
    {
      do
      {
        return;
        if (paramPAGFile.tagLevel() <= PAGFile.MaxSupportedTagLevel()) {
          break;
        }
      } while (this.mVideoShelfListener == null);
      this.mVideoShelfListener.onError(-3, "pagsdk version is low", null);
      return;
      this.mPagFile = paramPAGFile;
      if (this.mVideoShelfListener != null) {
        this.mVideoShelfListener.onChangVideoSize(this.mPagFile.width(), this.mPagFile.height());
      }
      this.mDuration = paramPAGFile.duration();
      this.mFrameProgressGap = (40000.0D / this.mDuration);
      if (this.mPlayTask != null) {
        this.mPlayTask.reset();
      }
      this.mPagRender.setFile(paramPAGFile);
    } while (!OfflineConfig.isNeedScale());
    Log.i("PagShelfPlayer", "使用低尺度的PAG文件进行预览。");
    TTPTLogger.i("PagShelfPlayer", "使用低尺度的PAG文件进行预览。");
    this.mPagRender.setMaxFrameRate(-1.0F);
    this.mPagRender.setCacheScale(OfflineConfig.getPagPlayScale());
  }
  
  private void setTimeCount()
  {
    long l = System.currentTimeMillis();
    if (l - this.mTime > 1000L)
    {
      if (this.mVideoShelfListener != null) {
        this.mVideoShelfListener.onUpdateRate(this.mFrameCount);
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
    return (int)(this.mPagRender.getProgress() * this.mDuration / 1000.0D);
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
    if (this.mPagFile != null) {
      return this.mPagFile.height();
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    if (this.mPagFile != null) {
      return this.mPagFile.width();
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
    if (this.mPlayTask != null) {
      this.mPlayTask.pause();
    }
    if ((this.mAudioPlayer != null) && (!this.isStoped)) {}
    try
    {
      this.mAudioPlayer.pause();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.e("PagShelfPlayer", "audioplayer pause has IllegalStateException:" + localIllegalStateException.getMessage());
    }
  }
  
  public void prepare()
  {
    if (this.mAudioPlayer != null) {}
    try
    {
      this.mAudioPlayer.prepare();
      this.isStoped = false;
      if (this.mVideoShelfListener != null) {
        this.mVideoShelfListener.onPrepared(this);
      }
      TTPTLogger.i("PagShelfPlayer", "prepare.");
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        TTPTLogger.e("PagShelfPlayer", "audioplayer prepare has IOException|IllegalStateException:" + localIllegalStateException.getMessage());
      }
    }
    catch (IOException localIOException)
    {
      label46:
      break label46;
    }
  }
  
  public void reset()
  {
    TTPTLogger.i("PagShelfPlayer", "reset");
    if (this.mPlayTask != null) {
      this.mPlayTask.reset();
    }
    this.mPagRender.setProgress(0.0D);
    this.mIsPlaying = false;
    if (this.mPagSurface != null) {
      this.mPagSurface.freeCache();
    }
    if (this.mAudioPlayer != null) {
      this.mAudioPlayer.reset();
    }
  }
  
  public void seekTo(int paramInt)
  {
    TTPTLogger.i("PagShelfPlayer", "seekto:" + paramInt * 1000.0D / this.mDuration);
    this.mPagRender.setProgress(paramInt * 1000.0D / this.mDuration);
    this.mPagRender.flush();
    if (this.mAudioPlayer != null) {}
    try
    {
      if (this.isStoped)
      {
        this.mAudioPlayer.prepare();
        this.isStoped = false;
      }
      this.mAudioPlayer.seekTo(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      TTPTLogger.e("PagShelfPlayer", "audioplayer seekto has IllegalStateException:" + localIllegalStateException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      label99:
      break label99;
    }
  }
  
  public void setDataSource(AssetManager paramAssetManager, String paramString)
  {
    if ((paramAssetManager == null) || (paramString == null)) {
      return;
    }
    setPagfile(PAGFile.Load(paramAssetManager, paramString));
  }
  
  public void setDataSource(String paramString)
  {
    if (paramString == null) {
      return;
    }
    TTPTLogger.i("PagShelfPlayer", "pag path:" + paramString);
    setPagfile(PAGFile.Load(paramString));
  }
  
  public void setDisplay(SurfaceHolder paramSurfaceHolder)
  {
    if (paramSurfaceHolder == null) {}
    for (paramSurfaceHolder = null;; paramSurfaceHolder = PAGSurface.FromSurface(paramSurfaceHolder.getSurface()))
    {
      this.mPagSurface = paramSurfaceHolder;
      this.mPagRender.setSurface(this.mPagSurface);
      return;
    }
  }
  
  public void setLooping(boolean paramBoolean)
  {
    PagShelfPlayer.PagPlayTimerTask localPagPlayTimerTask = this.mPlayTask;
    if (paramBoolean) {}
    for (int i = -1;; i = 1)
    {
      localPagPlayTimerTask.setReaptTime(i);
      if (this.mAudioPlayer != null) {
        this.mAudioPlayer.setLooping(paramBoolean);
      }
      return;
    }
  }
  
  public void setParam(String paramString, Object... paramVarArgs)
  {
    int k = 0;
    int j = 0;
    int i;
    switch (paramString.hashCode())
    {
    default: 
      i = -1;
      label54:
      switch (i)
      {
      }
      break;
    }
    for (;;)
    {
      return;
      if (!paramString.equals("pagShelfPlayerAudioFilePath")) {
        break;
      }
      i = 0;
      break label54;
      if (!paramString.equals("pagImgReplace")) {
        break;
      }
      i = 1;
      break label54;
      if (!paramString.equals("pagTextReplace")) {
        break;
      }
      i = 2;
      break label54;
      if (!paramString.equals("imgGroup")) {
        break;
      }
      i = 3;
      break label54;
      paramString = paramVarArgs[0];
      if ((paramString instanceof Boolean))
      {
        for (;;)
        {
          try
          {
            if (((Boolean)paramString).booleanValue())
            {
              paramString = paramVarArgs[1];
              paramVarArgs = paramVarArgs[2];
              if (((paramString instanceof AssetManager)) && ((paramVarArgs instanceof String)))
              {
                paramString = ((AssetManager)paramString).openFd((String)paramVarArgs);
                this.mAudioPlayer = new MediaPlayer();
                this.mAudioPlayer.setDataSource(paramString.getFileDescriptor(), paramString.getStartOffset(), paramString.getLength());
                TTPTLogger.i("PagShelfPlayer", "audio path(asset):" + (String)paramVarArgs);
              }
              if (this.mAudioPlayer == null) {
                break;
              }
              this.mAudioPlayer.setOnCompletionListener(new PagShelfPlayer.1(this));
              this.mAudioPlayer.setOnErrorListener(new PagShelfPlayer.2(this));
              return;
            }
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
            if (this.mVideoShelfListener != null) {
              this.mVideoShelfListener.onError(-1, "audio file is null", null);
            }
            ReportUtil.report("[" + PagShelfPlayer.class.getSimpleName() + "] mVideoPlayer.setDataSource , error msg = " + paramString.toString());
            return;
          }
          paramString = paramVarArgs[1];
          if ((paramString instanceof String))
          {
            this.mAudioPlayer = new MediaPlayer();
            this.mAudioPlayer.setDataSource((String)paramString);
            TTPTLogger.i("PagShelfPlayer", "audio path:" + (String)paramString);
          }
        }
        if ((paramVarArgs == null) || (paramVarArgs.length < 2))
        {
          TTPTLogger.e("PagShelfPlayer", "传入PAG的替换图像参数有误");
          return;
        }
        Object localObject = paramVarArgs[0];
        if ((localObject instanceof int[]))
        {
          paramString = null;
          if ((paramVarArgs[1] instanceof Bitmap)) {
            paramString = (Bitmap)paramVarArgs[1];
          }
          while (paramString == null)
          {
            TTPTLogger.e("PagShelfPlayer", "传入PAG的替换图像为空。");
            return;
            if ((paramVarArgs[1] instanceof String)) {
              paramString = BitmapUtils.decodeSampledBitmapFromFile((String)paramVarArgs[1], 1080, 1080);
            }
          }
          paramString = PAGImage.FromBitmap(paramString);
          paramString.setScaleMode(3);
          paramVarArgs = (int[])localObject;
          k = paramVarArgs.length;
          i = j;
          while (i < k)
          {
            j = paramVarArgs[i];
            this.mPagRender.replaceImage(j, paramString);
            i += 1;
          }
          continue;
          if ((paramVarArgs == null) || (paramVarArgs.length < 2))
          {
            TTPTLogger.e("PagShelfPlayer", "传入PAG的替换文本参数有误");
            return;
          }
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
              j = paramString.length;
              i = k;
              for (;;)
              {
                if (i >= j) {
                  break label732;
                }
                k = paramString[i].intValue();
                if (k >= this.mPagFile.numTexts()) {
                  break;
                }
                localObject = this.mPagFile.getTextData(k);
                if (localObject == null)
                {
                  TTPTLogger.e("PagShelfPlayer", "文字样式在PAG文件中未找到，无法进行设置文字");
                  return;
                }
                ((PAGText)localObject).text = ((String)paramVarArgs[1]);
                this.mPagRender.setTextData(k, (PAGText)localObject);
                i += 1;
              }
              label732:
              continue;
              if ((paramVarArgs != null) && (paramVarArgs.length != 0))
              {
                paramString = paramVarArgs[0];
                if ((paramString instanceof HashMap))
                {
                  paramString = (HashMap)paramString;
                  if (paramString != null)
                  {
                    paramString = paramString.entrySet().iterator();
                    while (paramString.hasNext())
                    {
                      paramVarArgs = (Map.Entry)paramString.next();
                      setParam("pagImgReplace", new Object[] { paramVarArgs.getValue(), paramVarArgs.getKey() });
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void setSurface(Surface paramSurface)
  {
    TTPTLogger.i("PagShelfPlayer", "setsurface.");
    if (paramSurface == null) {}
    for (paramSurface = null;; paramSurface = PAGSurface.FromSurface(paramSurface))
    {
      this.mPagSurface = paramSurface;
      this.mPagRender.setSurface(this.mPagSurface);
      return;
    }
  }
  
  public void setVideoShelfPlayerListener(IVideoShelfPlayerListener paramIVideoShelfPlayerListener)
  {
    this.mVideoShelfListener = paramIVideoShelfPlayerListener;
  }
  
  public void start()
  {
    double d = this.mPagRender.getProgress();
    TTPTLogger.i("PagShelfPlayer", "start:" + d);
    if (this.mPlayTask != null) {
      this.mPlayTask.resume();
    }
    if (this.mTimer == null)
    {
      this.mTimer = new Timer();
      this.mTimer.schedule(this.mPlayTask, 0L, 40L);
    }
    this.mIsPlaying = true;
    if (this.mAudioPlayer != null) {}
    try
    {
      if (this.isStoped)
      {
        this.mAudioPlayer.prepare();
        this.isStoped = false;
      }
      if (this.mPlayTask.isLooping()) {
        this.mAudioPlayer.setLooping(this.mPlayTask.isLooping());
      }
      this.mAudioPlayer.seekTo((int)(this.mDuration * d / 1000.0D));
      TTPTLogger.i("PagShelfPlayer", "start:" + (int)(this.mDuration * d / 1000.0D));
      this.mAudioPlayer.start();
      this.mIsAudioPlaying = true;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      TTPTLogger.e("PagShelfPlayer", "audioplayer start has IllegalStateException:" + localIllegalStateException.getMessage());
      return;
    }
    catch (IOException localIOException)
    {
      label204:
      break label204;
    }
  }
  
  public void stop()
  {
    TTPTLogger.i("PagShelfPlayer", "stop");
    this.mIsPlaying = false;
    if (this.mPagSurface != null) {
      this.mPagSurface.freeCache();
    }
    this.mPagRender.setSurface(null);
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    if (this.mPlayTask != null)
    {
      this.mPlayTask.pause();
      this.mPlayTask.cancel();
    }
    if (this.mAudioPlayer != null) {}
    try
    {
      this.mIsAudioPlaying = false;
      this.mAudioPlayer.stop();
      this.isStoped = true;
      this.mAudioPlayer.release();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Log.e("PagShelfPlayer", "audioplayer stop has IllegalStateException:" + localIllegalStateException.getMessage());
    }
  }
  
  public void surfaceUpdateSize()
  {
    if (this.mPagSurface != null)
    {
      this.mPagSurface.updateSize();
      this.mPagRender.flush();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.player.PagShelfPlayer
 * JD-Core Version:    0.7.0.1
 */