package com.tencent.mobileqq.cmshow.brickengine.apollo;

import com.tencent.mobileqq.apollo.utils.ApolloHardWareTester;
import com.tencent.mobileqq.apollo.view.opengl.EGLContextFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class ApolloSurfaceView$ApolloContextFactory
  implements EGLContextFactory
{
  private ApolloSurfaceView$ApolloContextFactory(ApolloSurfaceView paramApolloSurfaceView) {}
  
  public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int i;
    if (ApolloSurfaceView.access$200(this.a) != 0) {
      i = 2;
    } else {
      i = ApolloHardWareTester.a();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[createContext], id:");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    QLog.d("[cmshow]ApolloSurfaceView", 1, new Object[] { ((StringBuilder)localObject).toString(), ",openGLVersion:", Integer.valueOf(i) });
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = 12440;
    arrayOfInt[1] = i;
    arrayOfInt[2] = 12344;
    EGLContext localEGLContext = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, arrayOfInt);
    localObject = localEGLContext;
    if (localEGLContext == null)
    {
      localObject = localEGLContext;
      if (arrayOfInt[1] == 3)
      {
        QLog.e("[cmshow]ApolloSurfaceView", 1, "[createContext], context error, try foll back opengl 2.0");
        arrayOfInt[1] = 2;
        localObject = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, arrayOfInt);
      }
    }
    this.a.mIsDestroy.set(false);
    return localObject;
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[destroyContext], id:");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    QLog.d("[cmshow]ApolloSurfaceView", 1, ((StringBuilder)localObject).toString());
    if (ApolloSurfaceView.access$300(this.a))
    {
      localObject = ApolloCmdChannel.getInstance();
      ((ApolloCmdChannel)localObject).callbackEngineWrapper(this.a.isJsRuntime(), this.a.getLuaState(), 0, "sc.force_stop_game.local", "{}");
      ((ApolloCmdChannel)localObject).destroyMusic();
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloSurfaceView", 2, "destroyContext, closeGame)");
      }
    }
    else if ((this.a.mApolloWorker != null) && (this.a.mApolloWorker.b != null))
    {
      this.a.mApolloWorker.b.execScriptString("if(\"undefined\" != typeof clearSprite && clearSprite){clearSprite();}");
    }
    this.a.mIsDestroy.set(true);
    if (ApolloSurfaceView.access$400(this.a) != null) {
      ApolloSurfaceView.access$400(this.a).onDestroy();
    }
    if (paramEGL10 != null) {
      paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloSurfaceView.ApolloContextFactory
 * JD-Core Version:    0.7.0.1
 */