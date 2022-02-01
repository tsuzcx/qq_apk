package dov.com.qq.im.aeeditor.module.autotemplate;

import android.opengl.GLES30;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Ldov/com/qq/im/aeeditor/module/autotemplate/FrameWrapper;", "", "()V", "framebufferName", "", "height", "getHeight", "()I", "setHeight", "(I)V", "renderbufferName", "texName", "width", "getWidth", "setWidth", "bindFBO", "", "initAndBindFBO", "release", "setup", "setupSampler", "target", "mag", "min", "aelight_impl_release"}, k=1, mv={1, 1, 16})
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
    Object localObject = new int[1];
    GLES30.glGetIntegerv(3379, (int[])localObject, 0);
    if ((paramInt1 <= localObject[0]) && (paramInt2 <= localObject[0]))
    {
      GLES30.glGetIntegerv(34024, (int[])localObject, 0);
      if ((paramInt1 <= localObject[0]) && (paramInt2 <= localObject[0]))
      {
        GLES30.glGetIntegerv(36006, (int[])localObject, 0);
        int i = localObject[0];
        GLES30.glGetIntegerv(36007, (int[])localObject, 0);
        int j = localObject[0];
        GLES30.glGetIntegerv(32873, (int[])localObject, 0);
        int k = localObject[0];
        a();
        try
        {
          this.a = paramInt1;
          this.b = paramInt2;
          GLES30.glGenFramebuffers(localObject.length, (int[])localObject, 0);
          this.c = localObject[0];
          GLES30.glBindFramebuffer(36160, this.c);
          GLES30.glGenRenderbuffers(localObject.length, (int[])localObject, 0);
          this.d = localObject[0];
          GLES30.glBindRenderbuffer(36161, this.d);
          GLES30.glRenderbufferStorage(36161, 33189, paramInt1, paramInt2);
          GLES30.glFramebufferRenderbuffer(36160, 36096, 36161, this.d);
          GLES30.glGenTextures(localObject.length, (int[])localObject, 0);
          this.e = localObject[0];
          GLES30.glBindTexture(3553, this.e);
          a(3553, 9729, 9729);
          GLES30.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
          GLES30.glFramebufferTexture2D(36160, 36064, 3553, this.e, 0);
          int m = GLES30.glCheckFramebufferStatus(36160);
          if (m == 36053)
          {
            GLES30.glBindFramebuffer(36160, i);
            GLES30.glBindRenderbuffer(36161, j);
            GLES30.glBindTexture(3553, k);
            return;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Failed to initialize framebuffer object ");
          ((StringBuilder)localObject).append(m);
          ((StringBuilder)localObject).append(" width:");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(" height:");
          ((StringBuilder)localObject).append(paramInt2);
          throw ((Throwable)new RuntimeException(((StringBuilder)localObject).toString()));
        }
        catch (RuntimeException localRuntimeException)
        {
          a();
          throw ((Throwable)localRuntimeException);
        }
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("GL_MAX_RENDERBUFFER_SIZE ");
      localStringBuilder.append(localRuntimeException[0]);
      throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GL_MAX_TEXTURE_SIZE ");
    localStringBuilder.append(localRuntimeException[0]);
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((!GLES30.glIsTexture(this.e)) || (!GLES30.glIsFramebuffer(this.c))) {
      b(paramInt1, paramInt2);
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.FrameWrapper
 * JD-Core Version:    0.7.0.1
 */