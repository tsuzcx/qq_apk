package com.tencent.mobileqq.cmshow.brickengine.apollo;

import android.graphics.SurfaceTexture;
import com.tencent.mobileqq.apollo.utils.ApolloHardWareTester;
import com.tencent.mobileqq.apollo.view.opengl.EGLContextFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

class ApolloTextureView$ApolloContextFactory
  implements EGLContextFactory
{
  private ApolloTextureView$ApolloContextFactory(ApolloTextureView paramApolloTextureView) {}
  
  public EGLContext a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    if (this.a.mIsDestroy != null) {
      this.a.mIsDestroy.set(false);
    }
    int i = ApolloHardWareTester.a();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[createContext], id:");
    ((StringBuilder)localObject1).append(Thread.currentThread().getId());
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", hashCode: ");
    ((StringBuilder)localObject2).append(hashCode());
    QLog.d("[cmshow]ApolloTextureView", 1, new Object[] { localObject1, ",openGLVersion: ", ((StringBuilder)localObject2).toString() });
    int[] arrayOfInt = new int[3];
    arrayOfInt[0] = 12440;
    arrayOfInt[1] = i;
    arrayOfInt[2] = 12344;
    localObject2 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, arrayOfInt);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (arrayOfInt[1] == 3)
      {
        QLog.e("[cmshow]ApolloTextureView", 1, "[createContext], context error, try foll back opengl 2.0");
        arrayOfInt[1] = 2;
        localObject1 = paramEGL10.eglCreateContext(paramEGLDisplay, paramEGLConfig, EGL10.EGL_NO_CONTEXT, arrayOfInt);
      }
    }
    return localObject1;
  }
  
  public void a(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLContext paramEGLContext)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("[destroyContext], id:");
    localStringBuilder1.append(Thread.currentThread().getId());
    if ((this.a.mRender != null) && (this.a.mRender.getSavaWrapper() != null))
    {
      localStringBuilder1.append(", director: ");
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(this.a.mRender.getSavaWrapper().toString());
      localStringBuilder2.append(", hashCode: ");
      localStringBuilder2.append(hashCode());
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    QLog.d("[cmshow]ApolloTextureView", 1, localStringBuilder1.toString());
    if (this.a.mIsDestroy != null) {
      this.a.mIsDestroy.set(true);
    }
    if (this.a.mRender != null) {
      this.a.mRender.onDestroy();
    }
    paramEGL10.eglDestroyContext(paramEGLDisplay, paramEGLContext);
    if (ApolloTextureView.access$200(this.a) != null)
    {
      ApolloTextureView.access$200(this.a).release();
      ApolloTextureView.access$202(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloTextureView.ApolloContextFactory
 * JD-Core Version:    0.7.0.1
 */