package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Keep;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.touch.CMActionTouchManager;
import com.tencent.mobileqq.apollo.touch.ICMTouchManager;
import com.tencent.mobileqq.apollo.utils.ApolloHardWareTester;
import com.tencent.mobileqq.apollo.utils.ProcessUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.view.opengl.ApolloConfigChooser;
import com.tencent.mobileqq.apollo.view.opengl.ApolloOffscreenSurfaceFactory;
import com.tencent.mobileqq.apollo.view.opengl.ComponentSizeChooser;
import com.tencent.mobileqq.apollo.view.opengl.GLTextureView;
import com.tencent.mobileqq.cmshow.brickengine.BKUtils;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;

@Keep
public class ApolloTextureView
  extends GLTextureView
  implements IApolloRenderView, ITriggerRenderCallback, ICMShowView
{
  public static final String TAG = "[cmshow]ApolloTextureView";
  public static long sReAttachTime;
  protected ApolloRenderDriver mApolloWorker;
  private int mAttachCount;
  private float mDensity = super.getContext().getResources().getDisplayMetrics().density;
  private int mInitHeight;
  public AtomicBoolean mIsDestroy;
  public boolean mIsDrawerView = false;
  public boolean mIsReAttach;
  private int mOffscreenHeight;
  private int mOffscreenWidth;
  private SurfaceTexture mPendingReleaseTexture;
  public ApolloRender mRender;
  protected ApolloRenderInterfaceImpl mRenderImpl;
  private int mSamplesMultiValue;
  private CMActionTouchManager mTouchManager;
  
  @TargetApi(14)
  public ApolloTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    super.setEGLContextClientVersion(ApolloHardWareTester.a());
    int i = ApolloUtilImpl.getDeviceMSAALevel();
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("ApolloTextureView MSAA_level:");
      paramContext.append(i);
      QLog.d("[cmshow]ApolloTextureView", 2, paramContext.toString());
    }
    if (i != 1)
    {
      if (i != 2) {
        this.mSamplesMultiValue = 0;
      } else {
        this.mSamplesMultiValue = 2;
      }
    }
    else {
      this.mSamplesMultiValue = 4;
    }
    super.setOpaque(false);
    this.mIsDestroy = new AtomicBoolean(false);
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloTextureView", 2, "[ApolloSurfaceView4Drawer] constructor");
    }
  }
  
  public void disableTouchEvent(boolean paramBoolean)
  {
    this.mTouchManager.a(paramBoolean);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    QLog.d("sava", 2, "texture view dispatchDraw");
  }
  
  public int getInitHeight()
  {
    if (isOffscreen()) {
      return this.mOffscreenHeight;
    }
    return this.mInitHeight;
  }
  
  public long getLuaState()
  {
    ApolloRender localApolloRender = this.mRender;
    if ((localApolloRender != null) && (localApolloRender.getSavaWrapper() != null)) {
      return this.mRender.getSavaWrapper().getLuaState();
    }
    return -1L;
  }
  
  public float getManRectMaxHeight()
  {
    CMActionTouchManager localCMActionTouchManager = this.mTouchManager;
    if (localCMActionTouchManager == null) {
      return 0.0F;
    }
    return localCMActionTouchManager.a();
  }
  
  @Deprecated
  public ApolloRender getRender()
  {
    return this.mRender;
  }
  
  public int getRenderHeight()
  {
    if (isOffscreen()) {
      return this.mOffscreenHeight;
    }
    return super.getHeight();
  }
  
  @Deprecated
  public ApolloRenderInterfaceImpl getRenderImpl()
  {
    return this.mRenderImpl;
  }
  
  public long getRenderThreadId()
  {
    return getGLThreadId();
  }
  
  public String getRenderThreadName()
  {
    return "Apollo_GL";
  }
  
  public int getRenderWidth()
  {
    if (isOffscreen()) {
      return this.mOffscreenWidth;
    }
    return super.getWidth();
  }
  
  @NotNull
  public ICMTouchManager getTouchManager()
  {
    return this.mTouchManager;
  }
  
  @NotNull
  public View getView()
  {
    return this;
  }
  
  public int getWindowAttachCount()
  {
    return super.getWindowAttachCount();
  }
  
  public ApolloRenderDriver getWorker()
  {
    return this.mApolloWorker;
  }
  
  public void init(OnApolloViewListener paramOnApolloViewListener)
  {
    try
    {
      init(paramOnApolloViewListener, false);
      return;
    }
    finally
    {
      paramOnApolloViewListener = finally;
      throw paramOnApolloViewListener;
    }
  }
  
  public void init(OnApolloViewListener paramOnApolloViewListener, boolean paramBoolean)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[init], callback:");
        localStringBuilder.append(paramOnApolloViewListener);
        localStringBuilder.append(" sLoadEngineLibDone: ");
        localStringBuilder.append(ApolloEngine.isEngineReady());
        localStringBuilder.append(", isOffscreen=");
        localStringBuilder.append(paramBoolean);
        QLog.d("[cmshow]ApolloTextureView", 2, localStringBuilder.toString());
      }
      this.mRender = new ApolloRender(this.mDensity, paramOnApolloViewListener, 0);
      this.mTouchManager = new CMActionTouchManager(this, paramOnApolloViewListener);
      this.mTouchManager.b(this.mIsDrawerView);
      this.mRender.setAABBChangeListener(new ApolloTextureView.1(this));
      super.setEGLContextFactory(new ApolloTextureView.ApolloContextFactory(this, null));
      if (this.mSamplesMultiValue != 0) {
        paramOnApolloViewListener = new ApolloConfigChooser(this.mSamplesMultiValue, paramBoolean);
      } else {
        paramOnApolloViewListener = new ComponentSizeChooser(ApolloHardWareTester.a(), 8, 8, 8, 8, 16, 0);
      }
      super.setEGLConfigChooser(paramOnApolloViewListener);
      if (paramBoolean) {
        super.setEGLWindowSurfaceFactory(new ApolloOffscreenSurfaceFactory(this.mOffscreenWidth, this.mOffscreenHeight));
      }
      super.setRenderer(this.mRender);
      if (paramBoolean)
      {
        surfaceCreated(null);
        surfaceChanged(null, 0, this.mOffscreenWidth, this.mOffscreenHeight);
      }
      super.setRenderMode(0);
      this.mApolloWorker = new ApolloRenderDriver(this, this.mRender.getSavaWrapper());
      this.mRender.setRenderView(this);
      this.mRender.setOffscreen(paramBoolean);
      this.mRenderImpl = new ApolloRenderInterfaceImpl(this.mApolloWorker, this.mRender);
      return;
    }
    finally {}
  }
  
  public boolean isJsRuntime()
  {
    return true;
  }
  
  public boolean isOffscreen()
  {
    ApolloRender localApolloRender = this.mRender;
    if (localApolloRender != null) {
      return localApolloRender.isOffscreen();
    }
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    this.mAttachCount += 1;
    Object localObject;
    if ((this.mAttachCount > 1) && (!this.mIsDrawerView) && (ProcessUtil.a()))
    {
      this.mIsReAttach = true;
      localObject = Thread.currentThread().getStackTrace();
      if (localObject != null)
      {
        localObject = Arrays.toString((Object[])localObject);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onAttachedToWindow found re_attach:");
          localStringBuilder.append((String)localObject);
          QLog.i("[cmshow]ApolloTextureView", 1, localStringBuilder.toString());
          sReAttachTime = System.currentTimeMillis();
        }
      }
    }
    if (this.mIsReAttach)
    {
      localObject = getRender();
      if (localObject != null)
      {
        ((ApolloRender)localObject).queueDestroy();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onAttachedToWindow re_attach GLThread need destroy mDisableCreateRenderThread: ");
        ((StringBuilder)localObject).append(this.mDisableCreateRenderThread);
        QLog.e("[cmshow]ApolloTextureView", 1, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAttachedToWindow re_attach but new GLThread mDisableCreateRenderThread: ");
      ((StringBuilder)localObject).append(this.mDisableCreateRenderThread);
      QLog.i("[cmshow]ApolloTextureView", 1, ((StringBuilder)localObject).toString());
    }
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QLog.i("[cmshow]ApolloTextureView", 1, "onDetachedFromWindow");
  }
  
  @Deprecated
  public void onExecDispose()
  {
    ApolloRenderInterfaceImpl localApolloRenderInterfaceImpl = this.mRenderImpl;
    if (localApolloRenderInterfaceImpl != null) {
      localApolloRenderInterfaceImpl.a();
    }
  }
  
  @Deprecated
  public void onExecDispose(String paramString)
  {
    ApolloRenderInterfaceImpl localApolloRenderInterfaceImpl = this.mRenderImpl;
    if (localApolloRenderInterfaceImpl != null) {
      localApolloRenderInterfaceImpl.a(paramString);
    }
  }
  
  public RectF onGetDressRect(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onGetDressRect], dressName:");
      localStringBuilder.append(paramString);
      QLog.d("[cmshow]ApolloTextureView", 2, localStringBuilder.toString());
    }
    return BKUtils.a(paramString, this.mRender);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    QLog.d("sava", 2, "texture view onLayout");
  }
  
  public void onRender()
  {
    queueEvent(new ApolloTextureView.2(this));
  }
  
  public void onResume()
  {
    super.onResume();
    QLog.d("sava", 2, "texture view onresume");
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    boolean bool = CmShowWnsUtils.G();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSurfaceTextureDestroyed enablePendingRelease:");
    localStringBuilder.append(bool);
    QLog.i("[cmshow]ApolloTextureView", 1, localStringBuilder.toString());
    if (bool)
    {
      this.mPendingReleaseTexture = paramSurfaceTexture;
      super.onSurfaceTextureDestroyed(paramSurfaceTexture);
      return false;
    }
    return super.onSurfaceTextureDestroyed(paramSurfaceTexture);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.mIsDestroy;
    if ((localObject != null) && (((AtomicBoolean)localObject).get())) {
      return false;
    }
    if (!ApolloEngine.isEngineReady())
    {
      QLog.w("[cmshow]ApolloTextureView", 1, "apollo lib NOT loaded, textureview ontouch return.");
      return false;
    }
    localObject = this.mTouchManager;
    if (localObject != null) {
      return ((CMActionTouchManager)localObject).a(paramMotionEvent);
    }
    return false;
  }
  
  public void pause() {}
  
  @Deprecated
  public void queueEvent(Runnable paramRunnable)
  {
    ApolloRender localApolloRender;
    if ((paramRunnable instanceof IApolloRunnableTask))
    {
      localApolloRender = this.mRender;
      if (localApolloRender != null) {
        localApolloRender.queueRenderTask((IApolloRunnableTask)paramRunnable);
      } else {
        QLog.e("[cmshow]ApolloTextureView", 1, "queueEvent mRender== null");
      }
    }
    else
    {
      localApolloRender = this.mRender;
      if (localApolloRender != null) {
        localApolloRender.queueRenderTask(new ApolloTextureView.3(this, paramRunnable));
      } else {
        QLog.e("[cmshow]ApolloTextureView", 1, "queueEvent mRender== null");
      }
    }
    requestRender();
  }
  
  public void resume() {}
  
  public void runRenderTask(IApolloRunnableTask paramIApolloRunnableTask)
  {
    if ((!this.mIsDestroy.get()) && (paramIApolloRunnableTask != null)) {
      queueEvent(paramIApolloRunnableTask);
    }
  }
  
  public void runRenderTask(Script paramScript)
  {
    if ((getWorker() != null) && (getWorker().b != null))
    {
      runRenderTask(SpriteUtil.a(paramScript, getWorker().b));
      return;
    }
    QLog.e("[cmshow]ApolloTextureView", 1, new Object[] { "runRenderTask error, apolloEngine null, script:", paramScript });
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setDumplicateCreateRenderThread(boolean paramBoolean)
  {
    this.mDisableCreateRenderThread = paramBoolean;
  }
  
  public void setForeground(Drawable paramDrawable) {}
  
  public void setInitHeight(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloTextureView", 2, new Object[] { "setInitHeight height:", Integer.valueOf(paramInt) });
    }
    this.mInitHeight = paramInt;
  }
  
  public void setOffscreenSize(int paramInt1, int paramInt2)
  {
    QLog.d("[cmshow]ApolloTextureView", 1, new Object[] { "FrameRecorder setOffscreenSize, width=", Integer.valueOf(paramInt1), ", height=", Integer.valueOf(paramInt2) });
    this.mOffscreenWidth = paramInt1;
    this.mOffscreenHeight = paramInt2;
  }
  
  public void setTouchableRect(RectF paramRectF)
  {
    this.mTouchManager.a(paramRectF);
  }
  
  @Deprecated
  public void stopLoopDelayed(long paramLong)
  {
    ApolloRenderInterfaceImpl localApolloRenderInterfaceImpl = this.mRenderImpl;
    if (localApolloRenderInterfaceImpl != null) {
      localApolloRenderInterfaceImpl.a(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView
 * JD-Core Version:    0.7.0.1
 */