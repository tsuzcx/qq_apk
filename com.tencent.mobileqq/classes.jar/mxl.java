import android.opengl.GLES20;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.video.effect.core.qqavimage.QQAVImageFilter;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

public class mxl
{
  int jdField_a_of_type_Int = -1;
  QQAVImageFilter jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = null;
  ByteBuffer jdField_a_of_type_JavaNioByteBuffer = null;
  byte[] jdField_a_of_type_ArrayOfByte = null;
  int[] jdField_a_of_type_ArrayOfInt = new int[1];
  int jdField_b_of_type_Int = -1;
  byte[] jdField_b_of_type_ArrayOfByte = null;
  int[] jdField_b_of_type_ArrayOfInt = new int[1];
  int c = 0;
  int d = 0;
  int e = 0;
  
  public mxl(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = (paramInt1 * paramInt2 * 3);
    this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(this.e);
    this.jdField_b_of_type_ArrayOfByte = new byte[this.c * this.d * 4];
    GLES20.glGenTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    GLES20.glGenTextures(this.jdField_b_of_type_ArrayOfInt.length, this.jdField_b_of_type_ArrayOfInt, 0);
    this.jdField_a_of_type_Int = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.jdField_a_of_type_ArrayOfInt[0]);
    this.jdField_b_of_type_Int = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.jdField_b_of_type_ArrayOfInt[0]);
    this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = new mxn();
    this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter.init();
    this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter.setQQAVEffectID("filter-test");
    if (QLog.isColorLevel()) {
      QLog.d("FilterProcess", 2, "mBeforeTextureId:" + this.jdField_a_of_type_ArrayOfInt[0] + "\nmBeforeTextureFbo:" + this.jdField_a_of_type_Int + "\nmAfterTextureId:" + this.jdField_b_of_type_ArrayOfInt[0] + "\nmAfterTextureFbo:" + this.jdField_b_of_type_Int);
    }
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length == 0)) {
      return -1L;
    }
    if (this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter == null) {
      return -2L;
    }
    if ((this.jdField_a_of_type_ArrayOfInt[0] == 0) || (this.jdField_b_of_type_ArrayOfInt[0] == 0)) {
      return -3L;
    }
    long l = System.nanoTime();
    int i = 0;
    while (i < 70)
    {
      a();
      a(a(this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfInt[0], this.jdField_b_of_type_Int, this.jdField_b_of_type_ArrayOfInt[0]).jdField_a_of_type_Int, this.c, this.d, 6408, this.jdField_b_of_type_ArrayOfByte);
      i += 1;
    }
    return (System.nanoTime() - l) / 1000L / 1000L;
  }
  
  mxm a(QQAVImageFilter paramQQAVImageFilter, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramQQAVImageFilter != null)
    {
      paramQQAVImageFilter.onOutputSizeChanged(this.c, this.d);
      paramQQAVImageFilter.onDraw2(paramInt2, paramInt3);
      return new mxm(this, paramInt3, paramInt4);
    }
    return new mxm(this, paramInt1, paramInt2);
  }
  
  void a()
  {
    if ((this.jdField_a_of_type_JavaNioByteBuffer == null) || (this.jdField_a_of_type_ArrayOfByte == null)) {
      return;
    }
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    this.jdField_a_of_type_JavaNioByteBuffer.put(this.jdField_a_of_type_ArrayOfByte, 0, this.e);
    this.jdField_a_of_type_JavaNioByteBuffer.position(0);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, this.jdField_a_of_type_ArrayOfInt[0]);
    GLES20.glTexParameterf(3553, 10241, 9729.0F);
    GLES20.glTexParameterf(3553, 10240, 9729.0F);
    GLES20.glTexParameterf(3553, 10242, 33071.0F);
    GLES20.glTexParameterf(3553, 10243, 33071.0F);
    GLES20.glTexImage2D(3553, 0, 6407, this.c, this.d, 0, 6407, 5121, this.jdField_a_of_type_JavaNioByteBuffer);
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, paramInt4, 5121, ByteBuffer.wrap(paramArrayOfByte));
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaNioByteBuffer != null)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_JavaNioByteBuffer = null;
    }
    this.jdField_b_of_type_ArrayOfByte = null;
    GLES20.glDeleteFramebuffers(2, new int[] { this.jdField_a_of_type_Int, this.jdField_b_of_type_Int }, 0);
    GLES20.glDeleteTextures(this.jdField_a_of_type_ArrayOfInt.length, this.jdField_a_of_type_ArrayOfInt, 0);
    GLES20.glDeleteTextures(this.jdField_b_of_type_ArrayOfInt.length, this.jdField_b_of_type_ArrayOfInt, 0);
    if (this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter != null)
    {
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter.destroy();
      this.jdField_a_of_type_ComTencentAvVideoEffectCoreQqavimageQQAVImageFilter = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mxl
 * JD-Core Version:    0.7.0.1
 */