import android.opengl.GLES20;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

public class mab
{
  private int jdField_a_of_type_Int;
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private int[] jdField_b_of_type_ArrayOfInt;
  private int c;
  
  private void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || ((this.jdField_a_of_type_Int == paramInt1) && (this.jdField_b_of_type_Int == paramInt2))) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (this.jdField_a_of_type_JavaNioByteBuffer != null) {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
    }
    this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(paramInt1 * paramInt2 * 3 / 2);
    if (this.c != -1)
    {
      GLES20.glDeleteFramebuffers(0, new int[] { this.c }, 0);
      this.c = -1;
    }
    this.c = AVGLUtils.initFrameBuffer(paramInt2, paramInt1, this.jdField_b_of_type_ArrayOfInt[0]);
    b();
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < this.jdField_a_of_type_Int * this.jdField_b_of_type_Int * 3 / 2) || (this.jdField_a_of_type_JavaNioByteBuffer == null) || (this.jdField_a_of_type_JavaNioByteBuffer.capacity() < this.jdField_a_of_type_Int * this.jdField_b_of_type_Int * 3 / 2)) {
      return;
    }
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    this.jdField_a_of_type_JavaNioByteBuffer.put(paramArrayOfByte, 0, this.jdField_a_of_type_Int * this.jdField_b_of_type_Int);
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    GLES20.glBindFramebuffer(36160, 0);
    lqc.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[0]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6409, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, 0, 6409, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    this.jdField_a_of_type_JavaNioByteBuffer.put(paramArrayOfByte, this.jdField_a_of_type_Int * this.jdField_b_of_type_Int, this.jdField_a_of_type_Int * this.jdField_b_of_type_Int / 2);
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    lrc[] arrayOflrc;
    if (paramInt1 == 0)
    {
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[1]);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6409, this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int / 2, 0, 6409, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
      this.jdField_a_of_type_JavaNioByteBuffer.position(0);
      this.jdField_a_of_type_JavaNioByteBuffer.put(paramArrayOfByte, this.jdField_a_of_type_Int * this.jdField_b_of_type_Int + this.jdField_a_of_type_Int * this.jdField_b_of_type_Int / 4, this.jdField_a_of_type_Int * this.jdField_b_of_type_Int / 4);
      this.jdField_a_of_type_JavaNioByteBuffer.position(0);
      GLES20.glActiveTexture(33986);
      GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[2]);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6409, this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int / 2, 0, 6409, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
      GLES20.glBindFramebuffer(36160, this.c);
      GLES20.glViewport(0, 0, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
      GLES20.glClearColor(0.0F, 0.0F, 0.0F, 1.0F);
      GLES20.glClear(16640);
      paramArrayOfByte = lra.a(1);
      arrayOflrc = paramArrayOfByte.a();
      GLES20.glUseProgram(paramArrayOfByte.a());
      GLES20.glUniform1f(arrayOflrc[2].jdField_a_of_type_Int, 1.0F);
      GLES20.glUniform1f(arrayOflrc[7].jdField_a_of_type_Int, this.jdField_a_of_type_Int);
      GLES20.glUniform1f(arrayOflrc[8].jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      GLES20.glUniformMatrix4fv(arrayOflrc[9].jdField_a_of_type_Int, 1, false, YUVTexture.a, 0);
      GLES20.glUniform1i(arrayOflrc[10].jdField_a_of_type_Int, paramInt1);
      GLES20.glUniform1i(arrayOflrc[11].jdField_a_of_type_Int, 0);
      GLES20.glDisable(3042);
      GLES20.glActiveTexture(33984);
      GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[0]);
      GLES20.glUniform1i(arrayOflrc[4].jdField_a_of_type_Int, 0);
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[1]);
      GLES20.glUniform1i(arrayOflrc[5].jdField_a_of_type_Int, 1);
      if (paramInt1 == 0)
      {
        GLES20.glActiveTexture(33986);
        GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[2]);
        GLES20.glUniform1i(arrayOflrc[6].jdField_a_of_type_Int, 2);
      }
      if (paramInt2 % 4 != 1) {
        break label925;
      }
      GLES20.glUniformMatrix4fv(arrayOflrc[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate90, 0);
    }
    for (;;)
    {
      GLES20.glUniformMatrix4fv(arrayOflrc[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
      GLES20.glVertexAttribPointer(arrayOflrc[0].jdField_a_of_type_Int, 2, 5126, false, 8, this.jdField_a_of_type_JavaNioFloatBuffer);
      GLES20.glEnableVertexAttribArray(arrayOflrc[0].jdField_a_of_type_Int);
      GLES20.glDrawArrays(5, 0, 4);
      GLES20.glDisableVertexAttribArray(arrayOflrc[0].jdField_a_of_type_Int);
      GLES20.glBindFramebuffer(36160, 0);
      return;
      if ((paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 3)) {
        break;
      }
      GLES20.glActiveTexture(33985);
      GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[1]);
      GLES20.glTexParameterf(3553, 10241, 9729.0F);
      GLES20.glTexParameterf(3553, 10240, 9729.0F);
      GLES20.glTexParameterf(3553, 10242, 33071.0F);
      GLES20.glTexParameterf(3553, 10243, 33071.0F);
      GLES20.glTexImage2D(3553, 0, 6410, this.jdField_a_of_type_Int / 2, this.jdField_b_of_type_Int / 2, 0, 6410, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
      break;
      label925:
      GLES20.glUniformMatrix4fv(arrayOflrc[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate270, 0);
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
  
  int a()
  {
    return this.jdField_b_of_type_ArrayOfInt[0];
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaNioByteBuffer != null)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_JavaNioByteBuffer = null;
    }
    if (this.c != -1)
    {
      GLES20.glDeleteFramebuffers(0, new int[] { this.c }, 0);
      this.c = -1;
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    if (paramArrayOfByte != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SwitchFaceYUVRender", 2, "WL_DEBUG onDrawFrame width = " + paramInt1 + ", height = " + paramInt2 + ", frameFormat = " + paramInt3 + ", data.length = " + paramArrayOfByte.length + ", inFrameAngle = " + paramInt4);
      }
      a(paramInt1, paramInt2);
      a(paramInt3, paramArrayOfByte, paramInt4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mab
 * JD-Core Version:    0.7.0.1
 */