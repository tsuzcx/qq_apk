package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import androidx.annotation.Keep;
import com.tencent.mobileqq.apollo.game.process.CmGameUtil;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.touch.CMActionTouchManager;
import com.tencent.mobileqq.apollo.touch.ICMTouchManager;
import com.tencent.mobileqq.apollo.touch.LightGameTouchManager;
import com.tencent.mobileqq.apollo.utils.ApolloHardWareTester;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.view.opengl.ApolloConfigChooser;
import com.tencent.mobileqq.apollo.view.opengl.GLSurfaceView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

@Keep
public class ApolloSurfaceView
  extends GLSurfaceView
  implements IApolloRenderView, ITriggerRenderCallback, ICMShowView
{
  public static final String TAG = "[cmshow]ApolloSurfaceView";
  private static final int UI_STATE_DETACHFROMWINDOW = 2;
  private static final int UI_STATE_SURFACECREATE = 1;
  private static final int UI_STATE_SURFACEDESTROY = 3;
  protected ApolloRenderDriver mApolloWorker;
  private boolean mCloseGame;
  protected float mDensity = super.getContext().getResources().getDisplayMetrics().density;
  private int mEngineType = 0;
  private int mGameId;
  private int mInitHeight;
  public AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  public boolean mIsGameReady;
  private ApolloRender mRender;
  protected ApolloRenderInterfaceImpl mRenderImpl;
  public int mRenderMode = 1;
  private ICMTouchManager mTouchManager;
  private AtomicInteger mUIState = new AtomicInteger();
  public int uiOptions;
  
  public ApolloSurfaceView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    initEGLConfig(ApolloUtilImpl.getDeviceMSAALevel());
    if (paramBoolean)
    {
      super.setZOrderOnTop(true);
      super.getHolder().setFormat(-2);
    }
    QLog.d("[cmshow]ApolloSurfaceView", 2, "[ApolloSurfaceView] constructor for cmshow");
  }
  
  public ApolloSurfaceView(Context paramContext, AttributeSet paramAttributeSet, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramContext, paramAttributeSet);
    int i = CmGameUtil.j();
    if (!paramBoolean2) {
      i = 3;
    }
    initEGLConfig(i);
    if (paramBoolean1) {
      super.setZOrderOnTop(true);
    }
    if (paramBoolean3) {
      super.getHolder().setFormat(-2);
    }
    QLog.d("[cmshow]ApolloSurfaceView", 2, "[ApolloSurfaceView] constructor for game");
  }
  
  private void initEGLConfig(int paramInt)
  {
    super.setEGLContextClientVersion(ApolloHardWareTester.a());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ApolloSurfaceView MSAA_level:");
      localStringBuilder.append(paramInt);
      QLog.d("[cmshow]ApolloSurfaceView", 2, localStringBuilder.toString());
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        super.setEGLConfigChooser(8, 8, 8, 8, 16, 8);
        return;
      }
      super.setEGLConfigChooser(new ApolloConfigChooser(2));
      return;
    }
    super.setEGLConfigChooser(new ApolloConfigChooser(4));
  }
  
  public static native void nativeTouchInput(long paramLong, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
  
  private void superSurfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder)
  {
    super.surfaceRedrawNeeded(paramSurfaceHolder);
  }
  
  public int getGameId()
  {
    return this.mGameId;
  }
  
  public int getInitHeight()
  {
    return this.mInitHeight;
  }
  
  public long getLuaState()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("apollochannel_,getLuaState,mIsGameReady:");
    ((StringBuilder)localObject).append(this.mIsGameReady);
    ((StringBuilder)localObject).append(",mIsDestroy:");
    ((StringBuilder)localObject).append(this.mIsDestroy);
    QLog.d("[cmshow]ApolloSurfaceView", 2, ((StringBuilder)localObject).toString());
    if (this.mIsDestroy.get()) {
      return -1L;
    }
    localObject = this.mRender;
    if (localObject != null)
    {
      if (((ApolloRender)localObject).getSavaWrapper() == null) {
        return -1L;
      }
      return this.mRender.getSavaWrapper().getLuaState();
    }
    return -1L;
  }
  
  public String getQtaTestResult()
  {
    return this.mRender.getQtaTestResult();
  }
  
  public ApolloRender getRender()
  {
    return this.mRender;
  }
  
  public int getRenderHeight()
  {
    return super.getHeight();
  }
  
  public ApolloRenderInterfaceImpl getRenderImpl()
  {
    return this.mRenderImpl;
  }
  
  public long getRenderThreadId()
  {
    return getGLThreadId();
  }
  
  public int getRenderWidth()
  {
    return super.getWidth();
  }
  
  @NotNull
  public ICMTouchManager getTouchManager()
  {
    return this.mTouchManager;
  }
  
  public AtomicInteger getUIState()
  {
    return this.mUIState;
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
  
  public void init(OnApolloViewListener paramOnApolloViewListener, int paramInt)
  {
    try
    {
      init(paramOnApolloViewListener, paramInt, false);
      return;
    }
    finally
    {
      paramOnApolloViewListener = finally;
      throw paramOnApolloViewListener;
    }
  }
  
  public void init(OnApolloViewListener paramOnApolloViewListener, int paramInt, boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[init], callback:");
        localStringBuilder.append(paramOnApolloViewListener);
        localStringBuilder.append(",engineType:");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", isOffscreen=");
        localStringBuilder.append(paramBoolean);
        QLog.d("[cmshow]ApolloSurfaceView", 2, localStringBuilder.toString());
      }
      try
      {
        this.mEngineType = paramInt;
        this.mRender = new ApolloRender(this.mDensity, paramOnApolloViewListener, paramInt);
        super.setEGLContextFactory(new ApolloSurfaceView.ApolloContextFactory(this, null));
        super.setRenderer(this.mRender);
        super.setRenderMode(this.mRenderMode);
        this.mApolloWorker = new ApolloRenderDriver(this, this.mRender.getSavaWrapper());
        this.mRender.setRenderView(this);
        this.mRenderImpl = new ApolloRenderInterfaceImpl(this.mApolloWorker, this.mRender);
        this.mRender.setOffscreen(paramBoolean);
        if (isGameMode())
        {
          this.mTouchManager = new LightGameTouchManager(this, this, this.mRender, this.mApolloWorker);
        }
        else
        {
          this.mTouchManager = new CMActionTouchManager(this, paramOnApolloViewListener);
          this.mRender.setAABBChangeListener(new ApolloSurfaceView.1(this));
        }
      }
      catch (Throwable paramOnApolloViewListener)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[init], errInfo2->");
        localStringBuilder.append(paramOnApolloViewListener.getMessage());
        QLog.e("[cmshow]ApolloSurfaceView", 1, localStringBuilder.toString());
      }
      catch (OutOfMemoryError paramOnApolloViewListener)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[init], errInfo1->");
        localStringBuilder.append(paramOnApolloViewListener.getMessage());
        QLog.e("[cmshow]ApolloSurfaceView", 1, localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public boolean isGameMode()
  {
    return this.mEngineType == 1;
  }
  
  public boolean isJsRuntime()
  {
    int i = this.mGameId;
    return (i != 1) && (i != 2);
  }
  
  protected void onAttachedToWindow()
  {
    try
    {
      super.onAttachedToWindow();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("[cmshow]ApolloSurfaceView", 1, localThrowable, new Object[] { "[onAttachedToWindow]" });
    }
  }
  
  protected void onDetachedFromWindow()
  {
    this.mUIState.set(2);
    super.onDetachedFromWindow();
    this.mUIState.set(0);
  }
  
  public void onEnterGame(String paramString)
  {
    ApolloRenderDriver localApolloRenderDriver = this.mApolloWorker;
    if (localApolloRenderDriver != null)
    {
      localApolloRenderDriver.a();
      this.mApolloWorker.b(paramString);
    }
  }
  
  public void onRender()
  {
    if (getRender() != null)
    {
      if (getRender().getSavaWrapper() == null) {
        return;
      }
      runRenderTask(new ApolloSurfaceView.2(this, getRender()));
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject = this.mIsDestroy;
    if ((localObject != null) && (((AtomicBoolean)localObject).get())) {
      return false;
    }
    if (!ApolloEngine.isEngineReady())
    {
      QLog.i("[cmshow]ApolloSurfaceView", 1, "apollo lib NOT loaded, [onTouchEvent] return.");
      return false;
    }
    localObject = this.mApolloWorker;
    if (localObject == null) {
      return false;
    }
    if ((((ApolloRenderDriver)localObject).b != null) && (!this.mApolloWorker.b.readyDraw("surface.touch"))) {
      return false;
    }
    localObject = this.mTouchManager;
    if (localObject != null) {
      return ((ICMTouchManager)localObject).a(paramMotionEvent);
    }
    return false;
  }
  
  public void pause() {}
  
  public boolean performLongClick()
  {
    return super.performLongClick();
  }
  
  @Deprecated
  public void queueEvent(Runnable paramRunnable)
  {
    if ((paramRunnable instanceof IApolloRunnableTask))
    {
      ApolloRender localApolloRender = this.mRender;
      if (localApolloRender != null) {
        localApolloRender.queueRenderTask((IApolloRunnableTask)paramRunnable);
      } else {
        QLog.e("[cmshow]ApolloSurfaceView", 1, "queueEvent mRender== null");
      }
      requestRender();
      return;
    }
    throw new RuntimeException("queueEvent r must instanceof IApolloRunnableTask");
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
    QLog.e("[cmshow]ApolloSurfaceView", 1, new Object[] { "runRenderTask error, apolloEngine null, script:", paramScript });
  }
  
  public void setFrameNum(int paramInt)
  {
    ApolloRenderDriver localApolloRenderDriver = this.mApolloWorker;
    if (localApolloRenderDriver != null) {
      localApolloRenderDriver.e = paramInt;
    }
  }
  
  public void setGameId(int paramInt)
  {
    this.mGameId = paramInt;
  }
  
  public void setGameName(String paramString)
  {
    ApolloRender localApolloRender = this.mRender;
    if (localApolloRender != null) {
      localApolloRender.setGameName(paramString);
    }
  }
  
  public void setInitHeight(int paramInt)
  {
    this.mInitHeight = paramInt;
  }
  
  public void setOnDestroyCloseGame(boolean paramBoolean)
  {
    this.mCloseGame = paramBoolean;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setOnDestroyCloseGame, closeGame:");
      localStringBuilder.append(paramBoolean);
      QLog.d("[cmshow]ApolloSurfaceView", 2, localStringBuilder.toString());
    }
  }
  
  public void setVisibility(int paramInt)
  {
    try
    {
      super.setVisibility(paramInt);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloSurfaceView", 1, localException, new Object[0]);
    }
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    this.mUIState.set(1);
    super.surfaceCreated(paramSurfaceHolder);
    this.mUIState.set(0);
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    this.mUIState.set(3);
    super.surfaceDestroyed(paramSurfaceHolder);
    this.mUIState.set(0);
  }
  
  public void surfaceRedrawNeeded(SurfaceHolder paramSurfaceHolder)
  {
    if ((Build.VERSION.SDK_INT != 24) && (Build.VERSION.SDK_INT != 25))
    {
      super.surfaceRedrawNeeded(paramSurfaceHolder);
    }
    else
    {
      ApolloRender localApolloRender = this.mRender;
      if (localApolloRender != null)
      {
        if (localApolloRender.isDrawTaskRunning())
        {
          ThreadManagerV2.excute(new ApolloSurfaceView.3(this, paramSurfaceHolder), 16, null, false);
          QLog.i("[cmshow]ApolloSurfaceView", 1, "surfaceRedrawNeeded mRender.isDrawTaskRunning()");
        }
      }
      else {
        super.surfaceRedrawNeeded(paramSurfaceHolder);
      }
    }
    if (QLog.isColorLevel())
    {
      paramSurfaceHolder = new StringBuilder();
      paramSurfaceHolder.append("surfaceRedrawNeeded width:");
      paramSurfaceHolder.append(getWidth());
      paramSurfaceHolder.append(" height:");
      paramSurfaceHolder.append(getHeight());
      QLog.i("[cmshow]ApolloSurfaceView", 2, paramSurfaceHolder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView
 * JD-Core Version:    0.7.0.1
 */