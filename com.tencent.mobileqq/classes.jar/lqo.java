import android.opengl.GLES20;
import android.os.Build;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

public class lqo
  implements lqb
{
  int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  byte[] jdField_a_of_type_ArrayOfByte;
  int jdField_b_of_type_Int = -1;
  private boolean jdField_b_of_type_Boolean = true;
  byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int = -1;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int d = -1;
  
  public lqo(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    d();
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    TextureProgram localTextureProgram = lrs.a(5);
    lru[] arrayOflru = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    lqu.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOflru[4].jdField_a_of_type_Int, 0);
    GLES20.glUniform1f(arrayOflru[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOflru[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOflru[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
    GLES20.glVertexAttribPointer(arrayOflru[0].jdField_a_of_type_Int, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOflru[0].jdField_a_of_type_Int);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, ByteBuffer.wrap(paramArrayOfByte));
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  private void a(lpq paramlpq, lpc paramlpc, lpx paramlpx, lpp paramlpp, FloatBuffer paramFloatBuffer, lqi paramlqi)
  {
    int i = paramlpc.jdField_a_of_type_Int;
    int j = paramlpc.jdField_b_of_type_Int;
    int k = i * j * 3 / 2;
    if (this.jdField_b_of_type_Boolean)
    {
      if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != k)) {
        this.jdField_b_of_type_ArrayOfByte = new byte[k];
      }
      i = i * j * 1 / 2;
      if ((this.jdField_c_of_type_ArrayOfByte == null) || (this.jdField_c_of_type_ArrayOfByte.length != i)) {
        this.jdField_c_of_type_ArrayOfByte = new byte[i];
      }
      if (!this.jdField_b_of_type_Boolean) {
        break label311;
      }
      b(paramlpq.jdField_a_of_type_Int, paramlpq.jdField_b_of_type_Int, paramlpx.jdField_b_of_type_Int, this.jdField_c_of_type_Int, paramFloatBuffer);
      b(paramlpq.jdField_a_of_type_Int, paramlpq.jdField_b_of_type_Int);
    }
    for (;;)
    {
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, paramlpc.jdField_a_of_type_Int, paramlpc.jdField_b_of_type_Int);
      if ((!this.jdField_a_of_type_Boolean) || (!paramlpc.b()))
      {
        paramlpc.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        paramlpc.jdField_a_of_type_Int = paramlpq.jdField_b_of_type_Int;
        paramlpc.jdField_b_of_type_Int = paramlpq.jdField_a_of_type_Int;
        paramlpc.jdField_c_of_type_Int = 21;
        if (this.jdField_b_of_type_Boolean)
        {
          paramlpc.jdField_c_of_type_Int = 100;
          paramlpc.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
        }
        paramlpc.d = ((paramlpc.d - lqj.a(paramlpc.jdField_a_of_type_Boolean) - 1 + 4) % 4);
        paramlqi.a(paramlpc, paramlpp.jdField_a_of_type_ArrayOfByte, paramlpp.jdField_b_of_type_ArrayOfByte, paramlpp.jdField_c_of_type_ArrayOfByte, paramlpp.jdField_a_of_type_Short, paramlpp.jdField_b_of_type_Short);
      }
      this.jdField_a_of_type_Boolean = false;
      return;
      i = i * j * 4;
      if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length == i)) {
        break;
      }
      this.jdField_a_of_type_ArrayOfByte = new byte[i];
      break;
      label311:
      a(paramlpq.jdField_a_of_type_Int, paramlpq.jdField_b_of_type_Int, paramlpx.jdField_b_of_type_Int, this.jdField_b_of_type_Int, paramFloatBuffer);
      a(this.jdField_b_of_type_Int, paramlpq.jdField_b_of_type_Int, paramlpq.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveTexture2I420DataBuffer called");
    }
    Object localObject = ByteBuffer.wrap(this.jdField_b_of_type_ArrayOfByte);
    GLES20.glBindFramebuffer(36160, this.jdField_c_of_type_Int);
    GLES20.glReadPixels(0, 0, paramInt2 * 2 / 8, paramInt1, 6408, 5121, (Buffer)localObject);
    localObject = this.jdField_c_of_type_ArrayOfByte;
    ByteBuffer localByteBuffer = ByteBuffer.wrap((byte[])localObject);
    GLES20.glReadPixels(paramInt2 * 2 / 8, 0, paramInt2 * 1 / 8, paramInt1, 6408, 5121, localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    System.arraycopy(localObject, 0, this.jdField_b_of_type_ArrayOfByte, paramInt2 * paramInt1, localObject.length);
  }
  
  static void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    TextureProgram localTextureProgram = lrs.a(6);
    lru[] arrayOflru = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    lqu.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOflru[4].jdField_a_of_type_Int, 0);
    GLES20.glUniform1f(arrayOflru[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOflru[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOflru[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
    GLES20.glUniform1f(arrayOflru[7].jdField_a_of_type_Int, paramInt1);
    GLES20.glUniform1f(arrayOflru[8].jdField_a_of_type_Int, paramInt2);
    GLES20.glVertexAttribPointer(arrayOflru[0].jdField_a_of_type_Int, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOflru[0].jdField_a_of_type_Int);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  private void d()
  {
    this.jdField_b_of_type_Boolean = mtl.g();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "initUseRBG2I420Switch useRGB2I420Shader = " + this.jdField_b_of_type_Boolean);
    if (this.jdField_b_of_type_Boolean)
    {
      String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.useRGB2I420ShaderCfg.name(), "1");
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "initUseRBG2I420Switch dpcValue = " + str);
      if (str.equals("0")) {
        this.jdField_b_of_type_Boolean = false;
      }
    }
    if (AudioHelper.a(21) == 1) {
      this.jdField_b_of_type_Boolean = true;
    }
    for (;;)
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "initUseRBG2I420Switch,after getDebugValue, initial useRGB2I420Shader = " + this.jdField_b_of_type_Boolean + ",Build.MODEL = " + Build.MODEL);
      return;
      if (AudioHelper.a(21) == 0) {
        this.jdField_b_of_type_Boolean = false;
      }
    }
  }
  
  public int a()
  {
    int i = 0;
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      i = 42;
    }
    while (this.jdField_b_of_type_ArrayOfByte == null) {
      return i;
    }
    return 35;
  }
  
  public void a()
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
    if (this.jdField_b_of_type_Boolean)
    {
      this.d = arrayOfInt[0];
      return;
    }
    this.jdField_a_of_type_Int = arrayOfInt[0];
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_c_of_type_Int = AVGLUtils.initFrameBuffer(paramInt2, paramInt1, this.d);
      return;
    }
    this.jdField_b_of_type_Int = AVGLUtils.initFrameBuffer(paramInt2, paramInt1, this.jdField_a_of_type_Int);
  }
  
  public void a(lpq paramlpq, lpc paramlpc, lpx paramlpx, lpp paramlpp, lqi paramlqi)
  {
    if (paramlpq.jdField_a_of_type_Msy != null) {
      paramlpq.jdField_a_of_type_Msy.a("postRender");
    }
    a(paramlpq, paramlpc, paramlpx, paramlpp, paramlpq.jdField_a_of_type_JavaNioFloatBuffer, paramlqi);
    if (paramlpq.jdField_a_of_type_Msy != null) {
      paramlpq.jdField_a_of_type_Msy.b("postRender");
    }
    if (paramlpq.jdField_a_of_type_Lps != null)
    {
      paramlpc = lpx.a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
      paramlpq.jdField_a_of_type_Lps.a(paramlpq, 4, null, paramlpc);
      paramlpq.jdField_a_of_type_Lps.d();
      paramlpc.a();
    }
  }
  
  public byte[] a()
  {
    byte[] arrayOfByte = null;
    if (this.jdField_a_of_type_ArrayOfByte != null) {
      arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    }
    while (this.jdField_b_of_type_ArrayOfByte == null) {
      return arrayOfByte;
    }
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ArrayOfByte = null;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_ArrayOfByte = null;
      this.jdField_c_of_type_ArrayOfByte = null;
    }
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = this.d;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.d = -1;
      GLES20.glDeleteFramebuffers(1, new int[] { this.jdField_c_of_type_Int }, 0);
      this.jdField_c_of_type_Int = -1;
      return;
    }
    int[] arrayOfInt = new int[1];
    arrayOfInt[0] = this.jdField_a_of_type_Int;
    GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
    this.jdField_a_of_type_Int = -1;
    GLES20.glDeleteFramebuffers(1, new int[] { this.jdField_b_of_type_Int }, 0);
    this.jdField_b_of_type_Int = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lqo
 * JD-Core Version:    0.7.0.1
 */