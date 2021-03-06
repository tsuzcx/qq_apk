package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.mobileqq.richmedia.mediacodec.renderer.GPUOESMovieFilter;
import com.tencent.mobileqq.richmedia.mediacodec.utils.GlUtil;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.DecodePlayer;
import com.tencent.mobileqq.richmedia.mediacodec.videodecoder.HWDecodeListener;
import com.tencent.mobileqq.shortvideo.util.FileUtil;
import com.tencent.mobileqq.shortvideo.util.VideoUtil;
import com.tencent.sveffects.Logger;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

@TargetApi(11)
public class QQMovieFilter
  extends QQBaseFilter
{
  public static final int MOVIE_FILTER_MESSAGE_RESUME_MUSIC = 3;
  public static final int MOVIE_FILTER_MESSAGE_START = 2;
  public static final int MOVIE_FILTER_MESSAGE_STOP = 1;
  public static final int MOVIE_FILTER_MESSAGE_STOP_MUSIC = 4;
  private static final String TAG = "QQMovieFilter";
  private boolean isSurfaceCreated = false;
  private int lastSendMessage = 1;
  private GPUBaseFilter mBaseFilter;
  private DecodePlayer mDecodePlayer;
  private GPUOESMovieFilter mOESMovieFilter;
  private RenderBuffer mRenderFBO;
  private Handler movieProcessHandler;
  private HandlerThread movieProcessThread;
  private QQMovieFilter.MovieOnFrameAvailableListener onFrameAvailableListener;
  private boolean sizeChange = false;
  protected int surfaceHeight = -1;
  private SurfaceTexture surfaceTexture;
  protected int surfaceWidth = -1;
  private int textureId = -1;
  private String videoFilePath = null;
  private float xOffset = 0.0F;
  private float yOffset = 0.0F;
  
  public QQMovieFilter(QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(100, paramQQFilterRenderManager);
  }
  
  private void stopPlay()
  {
    DecodePlayer localDecodePlayer = this.mDecodePlayer;
    if (localDecodePlayer != null) {
      localDecodePlayer.stopPlay();
    }
  }
  
  public boolean isFilterWork()
  {
    return (this.lastSendMessage == 2) && (this.isSurfaceCreated);
  }
  
  public void onDrawFrame()
  {
    Object localObject = this.mDecodePlayer;
    if ((localObject != null) && (((DecodePlayer)localObject).getCurrentState() == 3) && (this.surfaceTexture != null))
    {
      if (!this.isSurfaceCreated) {
        onSurfaceCreateInternal();
      }
      if ((this.surfaceWidth != getQQFilterRenderManager().getFilterWidth()) && (this.surfaceHeight != getQQFilterRenderManager().getFilterHeight()))
      {
        onSurfaceChangeInternal(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
        this.sizeChange = true;
      }
      else
      {
        this.sizeChange = false;
      }
    }
    if (this.isSurfaceCreated)
    {
      localObject = this.mDecodePlayer;
      if ((localObject != null) && (((DecodePlayer)localObject).getCurrentState() == 3) && (this.surfaceTexture != null))
      {
        localObject = this.mRenderFBO;
        if ((localObject == null) || (((RenderBuffer)localObject).getWidth() <= 0) || (this.mRenderFBO.getWidth() <= 0) || (this.sizeChange)) {
          this.mRenderFBO = new RenderBuffer(true, getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight(), 33984);
        }
        try
        {
          this.mRenderFBO.setTexId(this.mInputTextureID);
          this.mRenderFBO.bind();
          localObject = this.mBaseFilter;
          GPUBaseFilter.checkGlError("fbo bind");
          int i = GLES20.glCheckFramebufferStatus(36160);
          if (i == 36053)
          {
            this.surfaceTexture.updateTexImage();
            localObject = new float[16];
            this.surfaceTexture.getTransformMatrix((float[])localObject);
            this.mOESMovieFilter.drawTexture(this.textureId, (float[])localObject);
            localObject = this.mBaseFilter;
            GPUBaseFilter.checkGlError("oes draw");
            this.mRenderFBO.unbind();
            this.mRenderFBO.recoverInitialTexId();
            this.mRenderFBO.bind();
            i = GLES20.glCheckFramebufferStatus(36160);
            if (i == 36053)
            {
              localObject = this.mBaseFilter;
              GPUBaseFilter.checkGlError("pre clear");
              this.mBaseFilter.drawTexture(this.mInputTextureID, null, null);
              this.mRenderFBO.unbind();
              this.mOutputTextureID = this.mRenderFBO.getTexId();
              return;
            }
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("fbo status2 incomplete, status: ");
            ((StringBuilder)localObject).append(i);
            SLog.e("QQMovieFilter", ((StringBuilder)localObject).toString());
            throw new RuntimeException("fbo status incomplete");
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("fbo status incomplete, status: ");
          ((StringBuilder)localObject).append(i);
          SLog.e("QQMovieFilter", ((StringBuilder)localObject).toString());
          throw new RuntimeException("fbo status incomplete");
        }
        catch (Throwable localThrowable)
        {
          this.mOutputTextureID = this.mInputTextureID;
          SdkContext.getInstance().getLogger().e("QQMovieFilter", "onDrawFrame error.", localThrowable);
          return;
        }
      }
    }
    this.mOutputTextureID = this.mInputTextureID;
  }
  
  public void onMusicOriginalChange(boolean paramBoolean)
  {
    if ((isFilterWork()) && (this.movieProcessHandler != null))
    {
      Object localObject = this.movieProcessThread;
      if ((localObject != null) && (((HandlerThread)localObject).isAlive()))
      {
        int i;
        if (paramBoolean) {
          i = 3;
        } else {
          i = 4;
        }
        localObject = Message.obtain(this.movieProcessHandler, i);
        this.movieProcessHandler.sendMessage((Message)localObject);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("send movie filter msg, what = ");
        localStringBuilder.append(((Message)localObject).what);
        SLog.i("QQMovieFilter", localStringBuilder.toString());
      }
    }
  }
  
  public void onSurfaceChangeInternal(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (SdkContext.getInstance().getLogger().isEnable())
    {
      localObject = SdkContext.getInstance().getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSurfaceChanged : ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(";");
      localStringBuilder.append(paramInt2);
      ((Logger)localObject).d("QQMovieFilter", localStringBuilder.toString());
    }
    this.surfaceWidth = paramInt1;
    this.surfaceHeight = paramInt2;
    try
    {
      int i = GLES20.glGetError();
      if ((i != 0) && (SdkContext.getInstance().getLogger().isEnable()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("previousUnknownError: glError 0x");
        ((StringBuilder)localObject).append(Integer.toHexString(i));
        localObject = ((StringBuilder)localObject).toString();
        SdkContext.getInstance().getLogger().e("QQMovieFilter", (String)localObject);
      }
      if (this.mOESMovieFilter != null)
      {
        this.mOESMovieFilter.onOutputSizeChanged(paramInt1, paramInt2);
        if (this.videoFilePath != null) {
          this.mOESMovieFilter.adjustVideo(VideoUtil.getHeightWidthRatioOfVideo(this.videoFilePath), this.xOffset, this.yOffset);
        }
      }
      if (this.mBaseFilter != null)
      {
        this.mBaseFilter.onOutputSizeChanged(paramInt1, paramInt2);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      this.mRenderFBO = null;
      this.textureId = -1;
      SdkContext.getInstance().getLogger().e("QQMovieFilter", "onSurfaceChange error.", localThrowable);
    }
  }
  
  public void onSurfaceCreate()
  {
    super.onSurfaceCreate();
    this.textureId = GlUtil.createTexture(36197);
  }
  
  public void onSurfaceCreateInternal()
  {
    if (SdkContext.getInstance().getLogger().isEnable()) {
      SdkContext.getInstance().getLogger().d("QQMovieFilter", "onSurfaceCreated");
    }
    try
    {
      if (!this.isSurfaceCreated)
      {
        int i = GLES20.glGetError();
        if ((i != 0) && (SdkContext.getInstance().getLogger().isEnable()))
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("previousUnknownError: glError 0x");
          ((StringBuilder)localObject).append(Integer.toHexString(i));
          localObject = ((StringBuilder)localObject).toString();
          SdkContext.getInstance().getLogger().e("QQMovieFilter", (String)localObject);
        }
        if (this.mOESMovieFilter == null)
        {
          this.mOESMovieFilter = new GPUOESMovieFilter();
          this.mOESMovieFilter.init();
          this.mOESMovieFilter.onOutputSizeChanged(getQQFilterRenderManager().getFilterWidth(), getQQFilterRenderManager().getFilterHeight());
          if (this.videoFilePath != null) {
            this.mOESMovieFilter.adjustVideo(VideoUtil.getHeightWidthRatioOfVideo(this.videoFilePath), this.xOffset, this.yOffset);
          }
        }
        if (this.mBaseFilter == null)
        {
          this.mBaseFilter = new GPUBaseFilter();
          this.mBaseFilter.init();
        }
        GPUBaseFilter.checkGlError("filter init");
        this.isSurfaceCreated = true;
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      this.mRenderFBO = null;
      this.textureId = -1;
      SdkContext.getInstance().getLogger().e("QQMovieFilter", "onSurfaceCreate error.", localThrowable);
    }
  }
  
  public void onSurfaceDestroy()
  {
    if (SdkContext.getInstance().getLogger().isEnable()) {
      SdkContext.getInstance().getLogger().d("QQMovieFilter", "surfaceDestroyed");
    }
    Object localObject = this.mRenderFBO;
    if (localObject != null) {
      ((RenderBuffer)localObject).destroy();
    }
    localObject = this.mOESMovieFilter;
    if (localObject != null) {
      ((GPUOESMovieFilter)localObject).destroy();
    }
    localObject = this.mBaseFilter;
    if (localObject != null) {
      ((GPUBaseFilter)localObject).destroy();
    }
    if (this.movieProcessHandler != null) {
      this.movieProcessHandler = null;
    }
    localObject = this.movieProcessThread;
    if (localObject != null)
    {
      if (((HandlerThread)localObject).isAlive()) {
        this.movieProcessThread.quit();
      }
      this.movieProcessThread = null;
    }
    stopPlay();
    this.isSurfaceCreated = false;
  }
  
  public void setSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    if (this.mDecodePlayer.getCurrentState() == 3) {
      this.surfaceTexture = paramSurfaceTexture;
    }
  }
  
  public void startPlay(String paramString1, String paramString2, boolean paramBoolean, float paramFloat1, float paramFloat2, HWDecodeListener paramHWDecodeListener)
  {
    Object localObject = this.movieProcessThread;
    if ((localObject == null) || (!((HandlerThread)localObject).isAlive()))
    {
      this.movieProcessThread = new HandlerThread("movieTouchThread");
      this.movieProcessThread.start();
      this.movieProcessHandler = new QQMovieFilter.1(this, this.movieProcessThread.getLooper());
    }
    localObject = this.onFrameAvailableListener;
    if (localObject != null) {
      ((QQMovieFilter.MovieOnFrameAvailableListener)localObject).disable();
    }
    this.surfaceTexture = null;
    if (FileUtil.fileExistsAndNotEmpty(paramString1)) {
      paramString1 = Message.obtain(this.movieProcessHandler, 2, new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), paramHWDecodeListener });
    } else {
      paramString1 = Message.obtain(this.movieProcessHandler, 1);
    }
    this.movieProcessHandler.removeMessages(2);
    this.movieProcessHandler.removeMessages(1);
    this.movieProcessHandler.sendMessage(paramString1);
    this.lastSendMessage = paramString1.what;
    paramString1 = new StringBuilder();
    paramString1.append("send movie filter msg, what = ");
    paramString1.append(this.lastSendMessage);
    SLog.i("QQMovieFilter", paramString1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQMovieFilter
 * JD-Core Version:    0.7.0.1
 */