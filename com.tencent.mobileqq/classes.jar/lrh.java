import android.opengl.GLES20;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.utils.AVGLUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class lrh
{
  private static int jdField_a_of_type_Int = -1;
  private static lrh jdField_a_of_type_Lrh;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  boolean jdField_a_of_type_Boolean = true;
  private int b;
  private int c;
  private int d = jdField_a_of_type_Int;
  private int e = jdField_a_of_type_Int;
  private int f = jdField_a_of_type_Int;
  private int g = jdField_a_of_type_Int;
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.d;
    if (this.d == jdField_a_of_type_Int)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      i = arrayOfInt[0];
    }
    for (;;)
    {
      GLES20.glBindFramebuffer(36160, i);
      GLES20.glBindTexture(3553, paramInt3);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glBindTexture(3553, 0);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt3, 0);
      GLES20.glBindFramebuffer(36160, 0);
      return i;
    }
  }
  
  public static lrh a()
  {
    if (jdField_a_of_type_Lrh == null) {
      jdField_a_of_type_Lrh = new lrh();
    }
    return jdField_a_of_type_Lrh;
  }
  
  private int b(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = this.f;
    if (this.f == jdField_a_of_type_Int)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      i = arrayOfInt[0];
    }
    for (;;)
    {
      GLES20.glBindFramebuffer(36160, i);
      GLES20.glBindTexture(3553, paramInt3);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6408, paramInt1, paramInt2, 0, 6408, 5121, null);
      GLES20.glBindTexture(3553, 0);
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt3, 0);
      GLES20.glBindFramebuffer(36160, 0);
      return i;
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_JavaNioFloatBuffer != null) {
      return;
    }
    float[] arrayOfFloat = new float[8];
    arrayOfFloat[0] = (-0.5F + 0.0F);
    arrayOfFloat[1] = (-0.5F + 0.0F);
    arrayOfFloat[2] = (0.5F + 0.0F);
    arrayOfFloat[3] = (-0.5F + 0.0F);
    arrayOfFloat[4] = (-0.5F + 0.0F);
    arrayOfFloat[5] = (0.5F + 0.0F);
    arrayOfFloat[6] = (0.5F + 0.0F);
    arrayOfFloat[7] = (0.5F + 0.0F);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(arrayOfFloat.length * 4);
    localByteBuffer.order(ByteOrder.nativeOrder());
    this.jdField_a_of_type_JavaNioFloatBuffer = localByteBuffer.asFloatBuffer();
    this.jdField_a_of_type_JavaNioFloatBuffer.put(arrayOfFloat);
    this.jdField_a_of_type_JavaNioFloatBuffer.position(0);
  }
  
  private void c()
  {
    if (this.g == jdField_a_of_type_Int)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      this.g = arrayOfInt[0];
    }
    this.f = b(this.b, this.c, this.g);
  }
  
  private void d()
  {
    if (this.e == jdField_a_of_type_Int)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(1, arrayOfInt, 0);
      this.e = arrayOfInt[0];
    }
    this.d = a(this.b, this.c, this.e);
  }
  
  public void a()
  {
    if (this.d != jdField_a_of_type_Int)
    {
      GLES20.glDeleteFramebuffers(2, new int[] { this.d, this.f }, 0);
      GLES20.glDeleteTextures(2, new int[] { this.e, this.g }, 0);
    }
    this.d = jdField_a_of_type_Int;
    this.e = jdField_a_of_type_Int;
    this.f = jdField_a_of_type_Int;
    this.g = jdField_a_of_type_Int;
  }
  
  public void a(lqb paramlqb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramlqb = lra.a(0);
      GLES20.glUseProgram(paramlqb.a());
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.g);
      GLES20.glUniform1i(paramlqb.a()[4].jdField_a_of_type_Int, 0);
      GLES20.glUniform1f(paramlqb.a()[2].jdField_a_of_type_Int, 1.0F);
    }
  }
  
  public void a(lqb paramlqb, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, float[] paramArrayOfFloat, int paramInt8, int paramInt9)
  {
    if ((this.b != paramInt1 * 2) || (this.d == jdField_a_of_type_Int))
    {
      this.b = (paramInt1 * 2);
      this.c = (paramInt2 * 2);
      d();
      c();
      b();
    }
    GLES20.glBindFramebuffer(36160, this.d);
    GLES20.glViewport(0, 0, this.b, this.c);
    GLES20.glClearColor(0.4F, 0.4F, 0.4F, 1.0F);
    GLES20.glClear(16640);
    TextureProgram localTextureProgram = lra.a(2);
    lrc[] arrayOflrc = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    GLES20.glUniform1f(localTextureProgram.a()[7].jdField_a_of_type_Int, paramInt1);
    GLES20.glUniform1f(localTextureProgram.a()[8].jdField_a_of_type_Int, paramInt2);
    GLES20.glUniformMatrix4fv(localTextureProgram.a()[9].jdField_a_of_type_Int, 1, false, paramArrayOfFloat, 0);
    GLES20.glUniform1i(localTextureProgram.a()[10].jdField_a_of_type_Int, paramInt8);
    GLES20.glUniform1i(localTextureProgram.a()[11].jdField_a_of_type_Int, paramInt9);
    lqc.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt5);
    GLES20.glUniform1i(arrayOflrc[4].jdField_a_of_type_Int, 0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, paramInt6);
    GLES20.glUniform1i(arrayOflrc[5].jdField_a_of_type_Int, 1);
    GLES20.glActiveTexture(33986);
    GLES20.glBindTexture(3553, paramInt7);
    GLES20.glUniform1i(arrayOflrc[6].jdField_a_of_type_Int, 2);
    GLES20.glUniform1f(arrayOflrc[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOflrc[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixV, 0);
    GLES20.glUniformMatrix4fv(arrayOflrc[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
    GLES20.glVertexAttribPointer(arrayOflrc[0].jdField_a_of_type_Int, 2, 5126, false, 8, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOflrc[0].jdField_a_of_type_Int);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(arrayOflrc[0].jdField_a_of_type_Int);
    GLES20.glBindFramebuffer(36160, this.f);
    GLES20.glViewport(0, 0, this.b, this.c);
    GLES20.glClearColor(0.4F, 0.4F, 0.4F, 1.0F);
    GLES20.glClear(16640);
    localTextureProgram = lra.a(3);
    arrayOflrc = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    GLES20.glUniform1f(localTextureProgram.a()[7].jdField_a_of_type_Int, paramInt1);
    GLES20.glUniform1f(localTextureProgram.a()[8].jdField_a_of_type_Int, paramInt2);
    GLES20.glUniformMatrix4fv(localTextureProgram.a()[9].jdField_a_of_type_Int, 1, false, paramArrayOfFloat, 0);
    GLES20.glUniform1i(localTextureProgram.a()[10].jdField_a_of_type_Int, paramInt8);
    GLES20.glUniform1i(localTextureProgram.a()[11].jdField_a_of_type_Int, paramInt9);
    lqc.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.e);
    GLES20.glUniform1i(arrayOflrc[4].jdField_a_of_type_Int, 0);
    GLES20.glUniform1f(arrayOflrc[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOflrc[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixV, 0);
    GLES20.glUniformMatrix4fv(arrayOflrc[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
    GLES20.glVertexAttribPointer(arrayOflrc[0].jdField_a_of_type_Int, 2, 5126, false, 8, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOflrc[0].jdField_a_of_type_Int);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glDisableVertexAttribArray(arrayOflrc[0].jdField_a_of_type_Int);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glViewport(0, 0, paramInt3, paramInt4);
    a(paramlqb, paramInt1, paramInt2, paramInt5, paramInt6, paramInt7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lrh
 * JD-Core Version:    0.7.0.1
 */