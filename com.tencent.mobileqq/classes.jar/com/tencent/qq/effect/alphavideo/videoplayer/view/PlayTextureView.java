package com.tencent.qq.effect.alphavideo.videoplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import com.tencent.qq.effect.alphavideo.common.IntervalFpsLogTimer;
import com.tencent.qq.effect.alphavideo.videoplayer.decoder.HardwareFileDecoder;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecodeListener;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoFileDecoder;
import com.tencent.qq.effect.alphavideo.videoplayer.interfaces.IVideoPLayListener;
import com.tencent.qq.effect.alphavideo.videoplayer.render.BaseRender;
import com.tencent.qq.effect.alphavideo.videoplayer.render.SurfaceTextureBlendRender;
import com.tencent.qq.effect.utils.LogUtil;
import com.tencent.qq.effect.utils.QEffectUtils;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class PlayTextureView
  extends GLTextureView
  implements GLSurfaceView.Renderer
{
  private final int DEFAULT_FRAME_RATE = 25;
  private String TAG = "VideoPlayer|PlayView";
  private boolean mContentVisible = true;
  private Context mContext;
  private float mCropValue = 0.0F;
  private int mCurFrameCount = 0;
  private BaseRender mCurRender = null;
  private long mCurTime = 0L;
  private IVideoFileDecodeListener mDecodeListener = new PlayTextureView.1(this);
  private Thread mDecodeThread = null;
  private String mFilepath = null;
  private int mFrameTime = 0;
  private int mGLViewHeight = 0;
  private int mGLViewWidth = 0;
  private int mHalfVideoWidth = 0;
  private IVideoFileDecoder mHardDecoder = null;
  private Runnable mHardwareDecodeWaitForRunnable = new PlayTextureView.6(this);
  private boolean mIsPortrait = true;
  private Object mLock = new Object();
  private boolean mLoop = false;
  private boolean mNeedConfigViewport = true;
  private IntervalFpsLogTimer mOnPreviewFrameLogTimer = new IntervalFpsLogTimer(4000);
  private IVideoPLayListener mPlayListener = null;
  private boolean mPlayStarting = false;
  private boolean mStopping = false;
  private BaseRender mSurfaceTextureRender = null;
  private String mTmpFilePath = null;
  private int mVideoHeight = 0;
  private int mVideoWidth = 0;
  private Handler mViewHandler = new Handler();
  private boolean mViewReady = false;
  
  public PlayTextureView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    init();
  }
  
  public PlayTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init();
  }
  
  public PlayTextureView(Context paramContext, IVideoPLayListener paramIVideoPLayListener)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mPlayListener = paramIVideoPLayListener;
    init();
  }
  
  private float CalCrop(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (paramInt2 != 0)
    {
      f1 = f2;
      if (paramInt3 != 0)
      {
        f1 = f2;
        if (paramInt1 != 0)
        {
          f1 = f2;
          if (paramInt4 != 0)
          {
            int i = paramInt2 * paramInt3;
            int j = paramInt1 * paramInt4;
            if (i == j)
            {
              LogUtil.v(this.TAG, " crop 0");
              return 0.0F;
            }
            if (i > j)
            {
              f1 = 0.5F - paramInt4 * paramInt1 * 0.5F / paramInt3 / paramInt2;
              str = this.TAG;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(" crop height = ");
              localStringBuilder.append(f1);
              LogUtil.v(str, localStringBuilder.toString());
              return f1;
            }
            f1 = paramInt3 * paramInt2 * 0.5F / paramInt4 / paramInt1 - 0.5F;
            String str = this.TAG;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(" crop width = ");
            localStringBuilder.append(f1);
            LogUtil.v(str, localStringBuilder.toString());
          }
        }
      }
    }
    return f1;
  }
  
  private void _calcCropValue()
  {
    if (this.mIsPortrait)
    {
      i = this.mHalfVideoWidth;
      j = this.mVideoHeight;
      if (i > j)
      {
        this.mCropValue = CalCrop(j, i, this.mGLViewWidth, this.mGLViewHeight);
        return;
      }
      this.mCropValue = CalCrop(i, j, this.mGLViewWidth, this.mGLViewHeight);
      return;
    }
    int i = this.mHalfVideoWidth;
    int j = this.mVideoHeight;
    if (i * 9 >= j * 16)
    {
      this.mCropValue = CalCrop(i, j, this.mGLViewWidth, this.mGLViewHeight);
      return;
    }
    this.mCropValue = 0.0F;
  }
  
  private void callbackError(int paramInt)
  {
    if (this.mPlayListener != null)
    {
      Handler localHandler = this.mViewHandler;
      if (localHandler != null) {
        localHandler.post(new PlayTextureView.3(this, paramInt));
      }
    }
  }
  
  private void configViewportOnDraw()
  {
    int j;
    BaseRender localBaseRender;
    int i;
    if (this.mIsPortrait)
    {
      j = this.mHalfVideoWidth;
      int k = this.mVideoHeight;
      if (j < k)
      {
        localBaseRender = this.mCurRender;
        if (localBaseRender != null)
        {
          localBaseRender.setCropValue(this.mCropValue);
          GLES20.glViewport(0, 0, this.mGLViewWidth, this.mGLViewHeight);
        }
      }
      else
      {
        int m = this.mGLViewWidth;
        i = m * 9 / 16;
        if (j != 0) {
          i = m * k / j;
        }
        j = (this.mGLViewHeight - i) * 2 / 3;
        localBaseRender = this.mCurRender;
        if (localBaseRender != null)
        {
          localBaseRender.setCropValue(this.mCropValue);
          GLES20.glViewport(0, j, this.mGLViewWidth, i);
        }
      }
    }
    else
    {
      i = this.mHalfVideoWidth;
      j = this.mVideoHeight;
      if (i * 9 >= j * 16)
      {
        localBaseRender = this.mCurRender;
        if (localBaseRender != null)
        {
          localBaseRender.setCropValue(this.mCropValue);
          GLES20.glViewport(0, 0, this.mGLViewWidth, this.mGLViewHeight);
        }
      }
      else
      {
        i = i * this.mGLViewHeight / j;
        j = (this.mGLViewWidth - i) / 2;
        localBaseRender = this.mCurRender;
        if (localBaseRender != null)
        {
          localBaseRender.setCropValue(this.mCropValue);
          GLES20.glViewport(j, 0, i, this.mGLViewHeight);
        }
      }
    }
  }
  
  private Surface getSurface()
  {
    BaseRender localBaseRender = this.mSurfaceTextureRender;
    if ((localBaseRender != null) && ((localBaseRender instanceof SurfaceTextureBlendRender))) {
      return ((SurfaceTextureBlendRender)localBaseRender).getSurface();
    }
    return null;
  }
  
  private void init()
  {
    setEGLContextClientVersion(2);
    setEGLConfigChooser(8, 8, 8, 8, 16, 0);
    setRenderer(this);
    setRenderMode(0);
    setVisibility(8);
  }
  
  private void processDecodeEnd()
  {
    queueEvent(new PlayTextureView.4(this));
  }
  
  private void processDecodeError(int paramInt)
  {
    queueEvent(new PlayTextureView.5(this, paramInt));
  }
  
  private void releaseRenderGLThread()
  {
    BaseRender localBaseRender = this.mSurfaceTextureRender;
    if (localBaseRender != null)
    {
      localBaseRender.destroy();
      this.mSurfaceTextureRender = null;
    }
  }
  
  private void setupDecodeRender()
  {
    this.mHardDecoder = new HardwareFileDecoder(this.mLoop);
    this.mHardDecoder.setDecodeListener(this.mDecodeListener);
    try
    {
      this.mSurfaceTextureRender = new SurfaceTextureBlendRender();
      this.mSurfaceTextureRender.setup();
      setupFrameListenerOES();
      return;
    }
    catch (Exception localException)
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mSurfaceTextureRender Exception switch  soft decode Exception=");
      localStringBuilder.append(localException);
      LogUtil.v(str, localStringBuilder.toString());
      localException.printStackTrace();
    }
  }
  
  private void setupFrameListenerOES()
  {
    BaseRender localBaseRender = this.mSurfaceTextureRender;
    if ((localBaseRender != null) && (localBaseRender.getRenderType() == 1) && (((SurfaceTextureBlendRender)this.mSurfaceTextureRender).getVideoTexture() != null)) {
      ((SurfaceTextureBlendRender)this.mSurfaceTextureRender).getVideoTexture().setOnFrameAvailableListener(new PlayTextureView.9(this));
    }
  }
  
  private void startDecode()
  {
    this.mFrameTime = 0;
    this.mDecodeThread = new Thread(this.mHardwareDecodeWaitForRunnable);
    this.mDecodeThread.start();
  }
  
  public boolean getContentVisible()
  {
    return this.mContentVisible;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    if ((this.mViewReady) && (this.mCurRender != null))
    {
      int i = this.mVideoWidth;
      if (i > 0)
      {
        int j = this.mVideoHeight;
        if (j <= 0) {
          return;
        }
        if ((this.mNeedConfigViewport) && (i > 0) && (j > 0) && (this.mGLViewWidth > 0) && (this.mGLViewHeight > 0))
        {
          _calcCropValue();
          configViewportOnDraw();
          this.mNeedConfigViewport = false;
        }
        this.mCurRender.draw(null, 0, 0, false);
        i = this.mFrameTime;
        if (i > 0)
        {
          this.mCurFrameCount += 1;
          this.mCurTime = (i * this.mCurFrameCount);
          this.mViewHandler.post(new PlayTextureView.8(this));
        }
        if (this.mOnPreviewFrameLogTimer.isTimeToWriteLog())
        {
          paramGL10 = this.TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDrawFrame fps= ");
          localStringBuilder.append(this.mOnPreviewFrameLogTimer.getFps());
          LogUtil.i(paramGL10, localStringBuilder.toString());
        }
        if (!this.mContentVisible)
        {
          GLES20.glClear(16384);
          GLES20.glFinish();
        }
      }
    }
  }
  
  public void onSurfaceChanged(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("===================gl render onSurfaceChanged ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" h=");
    localStringBuilder.append(paramInt2);
    LogUtil.e(str, localStringBuilder.toString());
    paramGL10.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
    this.mGLViewWidth = paramInt1;
    this.mGLViewHeight = paramInt2;
    boolean bool;
    if (this.mGLViewWidth > this.mGLViewHeight) {
      bool = false;
    } else {
      bool = true;
    }
    this.mIsPortrait = bool;
    if ((this.mVideoWidth > 0) && (this.mVideoHeight > 0) && (this.mGLViewWidth > 0) && (this.mGLViewHeight > 0)) {
      this.mNeedConfigViewport = true;
    }
    if (!this.mViewReady)
    {
      this.mViewReady = true;
      this.mViewHandler.post(new PlayTextureView.7(this));
    }
  }
  
  public void onSurfaceCreated(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    LogUtil.e(this.TAG, "===================gl render onSurfaceCreated");
    setupDecodeRender();
  }
  
  public void playFile(String paramString)
  {
    if (this.mStopping) {
      this.mTmpFilePath = paramString;
    } else {
      this.mTmpFilePath = null;
    }
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" playFile , want to play filepath =");
    localStringBuilder.append(paramString);
    LogUtil.e(str, localStringBuilder.toString());
    if (this.mPlayStarting)
    {
      LogUtil.v(this.TAG, " playFile , one has played , return");
      return;
    }
    if (this.mViewReady)
    {
      LogUtil.v(this.TAG, " playFile , view not ready , return ");
      return;
    }
    this.mPlayStarting = true;
    if (QEffectUtils.fileIsExists(paramString))
    {
      this.mFilepath = paramString;
      this.mCurRender = null;
      new Thread(new PlayTextureView.2(this)).start();
      setVisibility(0);
      return;
    }
    LogUtil.e(this.TAG, " file , get error");
    callbackError(-1);
    this.mPlayStarting = false;
  }
  
  public void setContentVisible(boolean paramBoolean)
  {
    this.mContentVisible = paramBoolean;
  }
  
  public void setLoopState(boolean paramBoolean)
  {
    this.mLoop = paramBoolean;
    IVideoFileDecoder localIVideoFileDecoder = this.mHardDecoder;
    if (localIVideoFileDecoder != null) {
      localIVideoFileDecoder.setLoopState(this.mLoop);
    }
  }
  
  public void setPlayListener(IVideoPLayListener paramIVideoPLayListener)
  {
    this.mPlayListener = paramIVideoPLayListener;
  }
  
  public void stop()
  {
    Log.v(this.TAG, "==============PlayView Stop");
    if (!this.mViewReady) {
      return;
    }
    IVideoFileDecoder localIVideoFileDecoder = this.mHardDecoder;
    if (localIVideoFileDecoder != null) {
      localIVideoFileDecoder.stop();
    }
    this.mStopping = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qq.effect.alphavideo.videoplayer.view.PlayTextureView
 * JD-Core Version:    0.7.0.1
 */