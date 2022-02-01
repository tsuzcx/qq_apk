package dov.com.qq.im.aeeditor.module.autotemplate;

import android.opengl.GLES30;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/module/autotemplate/FrameWrapper;", "", "()V", "framebufferName", "", "height", "getHeight", "()I", "setHeight", "(I)V", "renderbufferName", "texName", "width", "getWidth", "setWidth", "bindFBO", "", "initAndBindFBO", "release", "setup", "setupSampler", "target", "mag", "min", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class FrameWrapper
{
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  
  private final void a()
  {
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.e;
    GLES30.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.e = 0;
    arrayOfInt[0] = this.d;
    GLES30.glDeleteRenderbuffers(arrayOfInt.length, arrayOfInt, 0);
    this.d = 0;
    arrayOfInt[0] = this.c;
    GLES30.glDeleteFramebuffers(arrayOfInt.length, arrayOfInt, 0);
    this.c = 0;
  }
  
  private final void a(int paramInt1, int paramInt2, int paramInt3)
  {
    GLES30.glTexParameterf(paramInt1, 10240, paramInt2);
    GLES30.glTexParameterf(paramInt1, 10241, paramInt3);
    GLES30.glTexParameteri(paramInt1, 10242, 33071);
    GLES30.glTexParameteri(paramInt1, 10243, 33071);
  }
  
  private final void b()
  {
    GLES30.glBindFramebuffer(36160, this.c);
    GLES30.glViewport(0, 0, this.a, this.b);
  }
  
  private final void b(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = new int[1];
    GLES30.glGetIntegerv(3379, arrayOfInt, 0);
    if ((paramInt1 > arrayOfInt[0]) || (paramInt2 > arrayOfInt[0])) {
      throw ((Throwable)new IllegalArgumentException("GL_MAX_TEXTURE_SIZE " + arrayOfInt[0]));
    }
    GLES30.glGetIntegerv(34024, arrayOfInt, 0);
    if ((paramInt1 > arrayOfInt[0]) || (paramInt2 > arrayOfInt[0])) {
      throw ((Throwable)new IllegalArgumentException("GL_MAX_RENDERBUFFER_SIZE " + arrayOfInt[0]));
    }
    GLES30.glGetIntegerv(36006, arrayOfInt, 0);
    int i = arrayOfInt[0];
    GLES30.glGetIntegerv(36007, arrayOfInt, 0);
    int j = arrayOfInt[0];
    GLES30.glGetIntegerv(32873, arrayOfInt, 0);
    int k = arrayOfInt[0];
    a();
    try
    {
      this.a = paramInt1;
      this.b = paramInt2;
      GLES30.glGenFramebuffers(arrayOfInt.length, arrayOfInt, 0);
      this.c = arrayOfInt[0];
      GLES30.glBindFramebuffer(36160, this.c);
      GLES30.glGenRenderbuffers(arrayOfInt.length, arrayOfInt, 0);
      this.d = arrayOfInt[0];
      GLES30.glBindRenderbuffer(36161, this.d);
      GLES30.glRenderbufferStorage(36161, 33189, paramInt1, paramInt2);
      GLES30.glFramebufferRenderbuffer(36160, 36096, 36161, this.d);
      GLES30.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
      this.e = arrayOfInt[0];
      GLES30.glBindTexture(3553, this.e);
      a(3553, 9729, 9729);
      GLES30.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES30.glFramebufferTexture2D(36160, 36064, 3553, this.e, 0);
      int m = GLES30.glCheckFramebufferStatus(36160);
      if (m != 36053) {
        throw ((Throwable)new RuntimeException("Failed to initialize framebuffer object " + m + " width:" + paramInt1 + " height:" + paramInt2));
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      a();
      throw ((Throwable)localRuntimeException);
    }
    GLES30.glBindFramebuffer(36160, i);
    GLES30.glBindRenderbuffer(36161, j);
    GLES30.glBindTexture(3553, k);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((!GLES30.glIsTexture(this.e)) || (!GLES30.glIsFramebuffer(this.c))) {
      b(paramInt1, paramInt2);
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.FrameWrapper
 * JD-Core Version:    0.7.0.1
 */