import android.opengl.GLES20;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class lqn
  implements lqc
{
  protected int a;
  private ByteBuffer a;
  protected int b = -1;
  
  public lqn()
  {
    this.jdField_a_of_type_Int = -1;
    if (QLog.isColorLevel()) {
      QLog.i("SurfaceTag", 2, "SurfacePreRender");
    }
    lpc.a("YUVMode");
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, byte[] paramArrayOfByte, int paramInt4, int paramInt5, int paramInt6, int paramInt7, ByteBuffer paramByteBuffer, FloatBuffer paramFloatBuffer)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < paramInt1 * paramInt2 * 3 / 2) || (paramByteBuffer.capacity() < paramInt1 * paramInt2 * 3 / 2)) {
      return;
    }
    paramByteBuffer.position(0);
    paramByteBuffer.put(paramArrayOfByte, 0, paramInt1 * paramInt2);
    paramByteBuffer.position(0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt4);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6409, paramInt1, paramInt2, 0, 6409, 5121, paramByteBuffer);
    paramByteBuffer.position(0);
    paramByteBuffer.put(paramArrayOfByte, paramInt1 * paramInt2, paramInt1 * paramInt2 / 2);
    paramByteBuffer.position(0);
    GLES20.glActiveTexture(33985);
    GLES20.glBindTexture(3553, paramInt5);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6410, paramInt1 / 2, paramInt2 / 2, 0, 6410, 5121, paramByteBuffer);
    GLES20.glBindFramebuffer(36160, paramInt6);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
    GLES20.glClear(16640);
    paramArrayOfByte = lrs.a(1);
    paramByteBuffer = paramArrayOfByte.a();
    GLES20.glUseProgram(paramArrayOfByte.a());
    GLES20.glUniform1f(paramByteBuffer[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniform1f(paramByteBuffer[7].jdField_a_of_type_Int, paramInt1);
    GLES20.glUniform1f(paramByteBuffer[8].jdField_a_of_type_Int, paramInt2);
    GLES20.glUniformMatrix4fv(paramByteBuffer[9].jdField_a_of_type_Int, 1, false, paramArrayOfFloat, 0);
    if (paramInt3 == 17)
    {
      GLES20.glUniform1i(paramByteBuffer[10].jdField_a_of_type_Int, 3);
      GLES20.glUniform1i(paramByteBuffer[11].jdField_a_of_type_Int, 0);
      GLES20.glDisable(3042);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, paramInt4);
      GLES20.glUniform1i(paramByteBuffer[4].jdField_a_of_type_Int, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, paramInt5);
      GLES20.glUniform1i(paramByteBuffer[5].jdField_a_of_type_Int, 1);
      if (paramInt7 % 4 != 1) {
        break label541;
      }
      GLES20.glUniformMatrix4fv(paramByteBuffer[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate90, 0);
    }
    for (;;)
    {
      GLES20.glUniformMatrix4fv(paramByteBuffer[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
      GLES20.glVertexAttribPointer(paramByteBuffer[0].jdField_a_of_type_Int, 2, 5126, false, 8, paramFloatBuffer);
      GLES20.glEnableVertexAttribArray(paramByteBuffer[0].jdField_a_of_type_Int);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(paramByteBuffer[0].jdField_a_of_type_Int);
      GLES20.glBindFramebuffer(36160, 0);
      return;
      GLES20.glUniform1i(paramByteBuffer[10].jdField_a_of_type_Int, 1);
      break;
      label541:
      GLES20.glUniformMatrix4fv(paramByteBuffer[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate270, 0);
    }
  }
  
  private void a(lpc paramlpc, int paramInt, FloatBuffer paramFloatBuffer)
  {
    a(paramlpc.jdField_a_of_type_Int, paramlpc.b, lje.c, YUVTexture.a, paramlpc.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.b, paramInt, lqj.a(paramlpc.jdField_a_of_type_Boolean), this.jdField_a_of_type_JavaNioByteBuffer, paramFloatBuffer);
    GLES20.glViewport(0, 0, paramlpc.jdField_a_of_type_Int, paramlpc.b);
  }
  
  public lpx a(lpq paramlpq, lpc paramlpc, lpx paramlpx)
  {
    if (paramlpq.jdField_a_of_type_Msy != null) {
      paramlpq.jdField_a_of_type_Msy.a("preRender");
    }
    int i = paramlpc.jdField_a_of_type_Int * paramlpc.b * 3 / 2;
    if ((this.jdField_a_of_type_JavaNioByteBuffer != null) && (this.jdField_a_of_type_JavaNioByteBuffer.capacity() != i))
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_JavaNioByteBuffer = null;
    }
    if (this.jdField_a_of_type_JavaNioByteBuffer == null) {
      this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(i);
    }
    a(paramlpc, paramlpx.jdField_a_of_type_Int, paramlpq.jdField_a_of_type_JavaNioFloatBuffer);
    if (paramlpq.jdField_a_of_type_Msy != null) {
      paramlpq.jdField_a_of_type_Msy.b("preRender");
    }
    if (paramlpq.jdField_a_of_type_Lps != null)
    {
      paramlpq.jdField_a_of_type_Lps.a(9, paramlpx.jdField_a_of_type_Int, paramlpx.b);
      paramlpq.jdField_a_of_type_Lps.a(paramlpq, 1, paramlpc, paramlpx);
    }
    return paramlpx;
  }
  
  public void a()
  {
    int[] arrayOfInt = new int[2];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    this.jdField_a_of_type_Int = arrayOfInt[0];
    this.b = arrayOfInt[1];
  }
  
  public void a(int paramInt1, int paramInt2) {}
  
  public boolean a(lpc paramlpc)
  {
    return (paramlpc != null) && (paramlpc.jdField_a_of_type_ArrayOfByte != null) && (paramlpc.jdField_a_of_type_ArrayOfByte.length > 0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaNioByteBuffer != null) {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
    }
    this.jdField_a_of_type_JavaNioByteBuffer = null;
  }
  
  public void c()
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.jdField_a_of_type_Int;
    arrayOfInt[1] = this.b;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.jdField_a_of_type_Int = -1;
    this.b = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lqn
 * JD-Core Version:    0.7.0.1
 */