import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import android.os.Build;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.denoise.DenoiseRender;
import com.tencent.av.video.effect.lowlight.LowLightRender;
import com.tencent.av.video.effect.utils.LowLightUtils;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.view.RendererUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

@TargetApi(17)
public class lpy
{
  static int j = -1;
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  AVRedPacketManager jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager;
  DenoiseRender jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = null;
  LowLightRender jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = null;
  final String jdField_a_of_type_JavaLangString = "FilterProcessRender_" + AudioHelper.b();
  ByteBuffer jdField_a_of_type_JavaNioByteBuffer = null;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private lpg jdField_a_of_type_Lpg;
  private lpm jdField_a_of_type_Lpm;
  private lpn jdField_a_of_type_Lpn;
  final lpx jdField_a_of_type_Lpx = new lpx();
  private lqa jdField_a_of_type_Lqa;
  private lqe jdField_a_of_type_Lqe;
  private lqh jdField_a_of_type_Lqh = new lqh();
  private final lqj jdField_a_of_type_Lqj = new lqj();
  private msa jdField_a_of_type_Msa;
  boolean jdField_a_of_type_Boolean = true;
  byte[] jdField_a_of_type_ArrayOfByte;
  public int[] a;
  int jdField_b_of_type_Int = 0;
  private lqe jdField_b_of_type_Lqe;
  public boolean b;
  byte[] jdField_b_of_type_ArrayOfByte;
  int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = true;
  int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  int f = -1;
  int g = -1;
  int h = -1;
  int i = -1;
  private int k = -1;
  private int l = 0;
  
  public lpy(Context paramContext, lip paramlip, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[8];
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Msa = new msa();
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager = ((AVRedPacketManager)paramVideoAppInterface.a(6));
    this.jdField_a_of_type_Lpn = paramVideoAppInterface.a();
    bfma.a();
    biik.a();
    this.jdField_a_of_type_Lqj.a = paramlip;
    this.jdField_e_of_type_Int = -1;
    a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static int a(boolean paramBoolean)
  {
    int n = 1;
    if (j == -1)
    {
      lpd locallpd = lpd.a();
      if ((locallpd == null) || (!locallpd.h())) {
        break label47;
      }
    }
    label47:
    for (j = 1;; j = 0)
    {
      int m = n;
      if (paramBoolean)
      {
        m = n;
        if (j != 1) {
          m = 3;
        }
      }
      return m;
    }
  }
  
  private lqe a(lqe paramlqe)
  {
    if (!lqf.c()) {
      this.jdField_a_of_type_ArrayOfInt[3] = 0;
    }
    do
    {
      return paramlqe;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfInt[3] = 0;
        return paramlqe;
      }
      localObject = a();
    } while (localObject == null);
    this.l |= 0x4;
    paramlqe = ((DenoiseRender)localObject).process(paramlqe.jdField_b_of_type_Int, paramlqe.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramlqe = lqe.a(paramlqe.getFbo(), paramlqe.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[3] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[5] += 1;
    return paramlqe;
  }
  
  private lqe a(lqe paramlqe, boolean paramBoolean)
  {
    if (!lqf.b()) {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
    }
    do
    {
      return paramlqe;
      if ((!this.jdField_b_of_type_Boolean) || (paramBoolean))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 0;
        return paramlqe;
      }
      localObject = a();
    } while (localObject == null);
    this.l |= 0x2;
    paramlqe = ((LowLightRender)localObject).process(paramlqe.jdField_b_of_type_Int, paramlqe.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramlqe = lqe.a(paramlqe.getFbo(), paramlqe.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[0] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[2] += 1;
    return paramlqe;
  }
  
  public static void a()
  {
    if (!lpu.a()) {
      return;
    }
    VideoPrefsUtil.setMaterialMute(true);
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    TextureProgram localTextureProgram = lrn.a(5);
    lrp[] arrayOflrp = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    lqp.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOflrp[4].jdField_a_of_type_Int, 0);
    GLES20.glUniform1f(arrayOflrp[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOflrp[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOflrp[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
    GLES20.glVertexAttribPointer(arrayOflrp[0].jdField_a_of_type_Int, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOflrp[0].jdField_a_of_type_Int);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    try
    {
      apvd.a(RendererUtils.saveTexture(paramInt1, paramInt2, paramInt3), paramString);
      return;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    GLES20.glBindFramebuffer(36160, paramInt1);
    GLES20.glViewport(0, 0, paramInt2, paramInt3);
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, ByteBuffer.wrap(paramArrayOfByte));
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  private static void a(int paramInt1, int paramInt2, int paramInt3, float[] paramArrayOfFloat, byte[] paramArrayOfByte, int paramInt4, int paramInt5, int paramInt6, int paramInt7, ByteBuffer paramByteBuffer, FloatBuffer paramFloatBuffer)
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
    paramArrayOfByte = lrn.a(1);
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
        break label551;
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
      label551:
      GLES20.glUniformMatrix4fv(paramByteBuffer[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate270, 0);
    }
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte, lqe paramlqe1, lqe paramlqe2)
  {
    if ((this.jdField_a_of_type_Lqa != null) && (this.jdField_a_of_type_Lqa.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Lqa.a(this, paramInt, paramArrayOfByte, paramlqe2.jdField_a_of_type_Int, paramlqe2.jdField_b_of_type_Int);
      this.jdField_a_of_type_Lqa.a(paramInt, paramlqe2.jdField_a_of_type_Int, paramlqe2.jdField_b_of_type_Int);
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, String.format("%s, fbo[%s --> %s], textureid[%s --> %s]", new Object[] { lqa.a(paramInt), Integer.valueOf(paramlqe1.jdField_a_of_type_Int), Integer.valueOf(paramlqe2.jdField_a_of_type_Int), Integer.valueOf(paramlqe1.jdField_b_of_type_Int), Integer.valueOf(paramlqe2.jdField_b_of_type_Int) }));
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    int n = 0;
    int m = 0;
    if ((lqf.b()) || (lqf.c()))
    {
      this.l |= 0x1;
      paramArrayOfByte = a(this.jdField_a_of_type_JavaLangString, paramArrayOfByte, (int)paramLong, 60, 0.75F);
      n = paramArrayOfByte[0];
      m = paramArrayOfByte[1];
    }
    paramArrayOfByte = this.jdField_a_of_type_ArrayOfInt;
    if (n == 1) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!this.jdField_b_of_type_Boolean) && (bool))
      {
        if (!paramBoolean) {
          paramArrayOfByte[1] += 1;
        }
        paramArrayOfByte[4] += 1;
        lcg.a(this.jdField_a_of_type_JavaLangString, " This is the " + paramArrayOfByte[2] + " times open lowlightand the " + paramArrayOfByte[4] + " times open videodenoise");
        lcg.a(this.jdField_a_of_type_JavaLangString, " The LowlightInfo is: lowlight flag = " + paramArrayOfByte[0] + ", video denoise flag = " + paramArrayOfByte[3] + ", lowlight open times = " + paramArrayOfByte[1] + ", denoise open times = " + paramArrayOfByte[4] + ", average luma = " + paramArrayOfByte[6]);
      }
      paramArrayOfByte[6] = m;
      if (n == 0)
      {
        paramArrayOfByte[0] = 0;
        paramArrayOfByte[3] = 0;
        GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(paramArrayOfByte);
      }
      paramArrayOfByte[7] = ((int)paramLong);
      this.jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  private boolean a()
  {
    if (!lqf.c()) {}
    while (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!lqf.b()) {}
    while ((!this.jdField_b_of_type_Boolean) || (paramBoolean)) {
      return false;
    }
    return true;
  }
  
  private static int[] a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat)
  {
    int[] arrayOfInt = new int[2];
    if (ljw.k * ljw.l * 3 / 2 != paramArrayOfByte.length)
    {
      lcg.e(paramString, "(AndroidCamera.PREVIEW_WIDTH * AndroidCamera.PREVIEW_HEIGHT * 3 / 2) != yuvData.length");
      return arrayOfInt;
    }
    try
    {
      paramString = LowLightUtils.DetectLowLight(paramArrayOfByte, paramInt1, ljw.k, ljw.l, 60, 0.75F);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        QLog.i("FilterProcessRender", 1, "DetectLowlightprocess", paramString);
        paramString = arrayOfInt;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.i("FilterProcessRender", 1, "DetectLowlightprocess", paramString);
        paramString = arrayOfInt;
      }
    }
  }
  
  static void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2 / 4, (int)(paramInt1 * 1.5D));
    TextureProgram localTextureProgram = lrn.a(6);
    lrp[] arrayOflrp = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    lqp.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOflrp[4].jdField_a_of_type_Int, 0);
    GLES20.glUniform1f(arrayOflrp[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOflrp[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOflrp[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
    GLES20.glUniform1f(arrayOflrp[7].jdField_a_of_type_Int, paramInt1);
    GLES20.glUniform1f(arrayOflrp[8].jdField_a_of_type_Int, paramInt2);
    GLES20.glVertexAttribPointer(arrayOflrp[0].jdField_a_of_type_Int, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOflrp[0].jdField_a_of_type_Int);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  private void b(long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0) || ((this.jdField_a_of_type_Int == paramInt1) && (this.jdField_b_of_type_Int == paramInt2))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "innerUpdatePreviewSize, width[" + this.jdField_a_of_type_Int + "->" + paramInt1 + "], height[" + this.jdField_b_of_type_Int + "->" + paramInt2 + "], seq[" + paramLong + "]");
    }
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.f = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.jdField_e_of_type_Int);
    if (this.jdField_a_of_type_Boolean) {
      this.i = AVGLUtils.initFrameBuffer(paramInt2 / 4, (int)(paramInt1 * 1.5D), this.k);
    }
    for (;;)
    {
      d();
      bfma.a();
      if (this.jdField_a_of_type_Lpg == null) {
        break;
      }
      this.jdField_a_of_type_Lpg.b(paramInt1, paramInt2);
      return;
      this.h = AVGLUtils.initFrameBuffer(paramInt2, paramInt1, this.g);
    }
  }
  
  private void d()
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
  
  private void e()
  {
    if ((this.jdField_a_of_type_Lqe != this.jdField_b_of_type_Lqe) && (this.jdField_a_of_type_Lqe != null))
    {
      this.jdField_a_of_type_Lqe.a();
      this.jdField_a_of_type_Lqe = null;
    }
    this.jdField_a_of_type_Lqe = this.jdField_b_of_type_Lqe;
  }
  
  public DenoiseRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = new DenoiseRender(VideoController.a().a());
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.setUpdateRate(lqf.a());
    return this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  }
  
  public LowLightRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = new LowLightRender(VideoController.a().a());
    }
    return this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender;
  }
  
  lpz a(lpp paramlpp, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      b(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt1, this.i, this.jdField_a_of_type_JavaNioFloatBuffer);
      paramInt1 = this.jdField_b_of_type_Int / 4;
      paramInt2 = (int)(this.jdField_a_of_type_Int * 1.5D);
      a(this.i, paramInt1, paramInt2, this.jdField_b_of_type_ArrayOfByte);
    }
    for (;;)
    {
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, paramlpp.jdField_a_of_type_Int, paramlpp.jdField_b_of_type_Int);
      lpz locallpz = null;
      if (!this.jdField_c_of_type_Boolean)
      {
        paramlpp.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        paramlpp.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        paramlpp.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        paramlpp.jdField_c_of_type_Int = 21;
        if (this.jdField_a_of_type_Boolean)
        {
          paramlpp.jdField_c_of_type_Int = 100;
          paramlpp.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
        }
        paramlpp.jdField_d_of_type_Int = ((paramlpp.jdField_d_of_type_Int - a(paramlpp.jdField_a_of_type_Boolean) - 1 + 4) % 4);
        locallpz = new lpz(paramlpp, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramShort1, paramShort2);
      }
      this.jdField_c_of_type_Boolean = false;
      return locallpz;
      a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt1, this.h, this.jdField_a_of_type_JavaNioFloatBuffer);
      a(this.h, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
    }
  }
  
  public lpz a(lpp paramlpp, FilterDesc paramFilterDesc, VideoMaterial paramVideoMaterial, boolean paramBoolean1, boolean paramBoolean2, PendantItem paramPendantItem, lpu paramlpu)
  {
    if (this.jdField_a_of_type_Lqa != null) {
      this.jdField_a_of_type_Lqa.a();
    }
    if (this.jdField_a_of_type_Msa != null) {
      this.jdField_a_of_type_Msa.b();
    }
    long l1 = System.currentTimeMillis();
    b(0L, paramlpp.jdField_b_of_type_Int, paramlpp.jdField_a_of_type_Int);
    int n = paramlpp.jdField_a_of_type_Int;
    int i1 = paramlpp.jdField_b_of_type_Int;
    byte[] arrayOfByte = paramlpp.jdField_a_of_type_ArrayOfByte;
    int i2 = a(paramlpp.jdField_a_of_type_Boolean);
    if ((paramBoolean1) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.c())) {}
    int m;
    for (boolean bool2 = true;; bool2 = false)
    {
      m = this.jdField_a_of_type_Lpn.a("BEAUTY_SKIN");
      this.jdField_a_of_type_Lqh.a(this.jdField_a_of_type_JavaLangString, paramlpp.jdField_c_of_type_Long, n, i1, paramlpp.jdField_d_of_type_Int, paramBoolean1, paramFilterDesc, paramVideoMaterial, paramPendantItem, paramlpp, m);
      if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int != 0) && (arrayOfByte != null) && (this.f != -1) && (this.jdField_e_of_type_Boolean)) {
        break;
      }
      return null;
    }
    this.jdField_d_of_type_Boolean = true;
    mrd localmrd = paramlpp.jdField_a_of_type_Mrd;
    if (localmrd != null) {
      localmrd.a(i2);
    }
    this.jdField_a_of_type_Lpx.a(n, i1);
    if (this.jdField_a_of_type_Lqa != null)
    {
      this.jdField_a_of_type_Lqa.c();
      this.jdField_a_of_type_Lqa.a(this, 0, arrayOfByte, -1, -1);
    }
    boolean bool1;
    if (this.jdField_a_of_type_Lpm != null)
    {
      this.jdField_a_of_type_Lpm.a(m);
      if (this.jdField_a_of_type_Lpg != null) {
        this.jdField_a_of_type_Lpg.a(null);
      }
      bool1 = this.jdField_a_of_type_Lpm.a(m);
      paramBoolean1 = false;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Msa != null) {
        this.jdField_a_of_type_Msa.a("checkLowLight");
      }
      a(arrayOfByte, paramlpp.jdField_a_of_type_Long, paramlpp.jdField_a_of_type_Boolean);
      if (localmrd != null) {
        localmrd.e();
      }
      if (this.jdField_a_of_type_Msa != null) {
        this.jdField_a_of_type_Msa.b("checkLowLight");
      }
      if (this.jdField_a_of_type_Lpm != null)
      {
        if (this.jdField_a_of_type_Msa != null) {
          this.jdField_a_of_type_Msa.a("applyBeauty20");
        }
        paramlpp.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Lpm.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, arrayOfByte, paramFilterDesc, m);
        if (paramlpp.jdField_a_of_type_ArrayOfByte != arrayOfByte) {
          this.l |= 0x8;
        }
        if (localmrd != null) {
          if (paramlpp.jdField_a_of_type_ArrayOfByte == arrayOfByte) {
            break label694;
          }
        }
      }
      label694:
      for (boolean bool3 = true;; bool3 = false)
      {
        localmrd.a(bool3);
        if (this.jdField_a_of_type_Msa != null) {
          this.jdField_a_of_type_Msa.b("applyBeauty20");
        }
        if (this.jdField_a_of_type_Lqa != null) {
          this.jdField_a_of_type_Lqa.a(this, 11, paramlpp.jdField_a_of_type_ArrayOfByte, -1, -1);
        }
        if (((paramFilterDesc != null) || (paramVideoMaterial != null) || (bool2) || (bool1) || (paramBoolean1) || (this.jdField_b_of_type_Boolean)) && (lpu.a()) && (ljd.b())) {
          break label700;
        }
        paramlpp.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        paramlpp.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_Lqa != null)
        {
          this.jdField_a_of_type_Lqa.a(this, 5, paramlpp.jdField_a_of_type_ArrayOfByte, -1, -1);
          this.jdField_a_of_type_Lqa.d();
        }
        this.jdField_d_of_type_Boolean = false;
        paramlpp.f = ((int)(System.currentTimeMillis() - l1));
        paramlpp.g = this.l;
        if (this.jdField_a_of_type_JavaNioByteBuffer != null) {
          this.jdField_a_of_type_JavaNioByteBuffer.clear();
        }
        this.jdField_a_of_type_JavaNioByteBuffer = null;
        this.jdField_a_of_type_ArrayOfByte = null;
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_ArrayOfByte = null;
        }
        if (this.jdField_a_of_type_Msa != null) {
          this.jdField_a_of_type_Msa.a(paramlpp.jdField_c_of_type_Long);
        }
        lsr.a().a(this.l);
        return new lpz(paramlpp, null, null, null, (short)0, (short)0);
        if (this.jdField_a_of_type_Lpg == null) {
          break label2045;
        }
        paramBoolean1 = this.jdField_a_of_type_Lpg.a(this.jdField_a_of_type_Lpn);
        bool1 = false;
        break;
      }
      label700:
      i2 = n * i1 * 3 / 2;
      if (this.jdField_a_of_type_Boolean)
      {
        if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != i2)) {
          this.jdField_b_of_type_ArrayOfByte = new byte[i2];
        }
        if ((this.jdField_a_of_type_JavaNioByteBuffer != null) && (this.jdField_a_of_type_JavaNioByteBuffer.capacity() != i2))
        {
          this.jdField_a_of_type_JavaNioByteBuffer.clear();
          this.jdField_a_of_type_JavaNioByteBuffer = null;
        }
        if (this.jdField_a_of_type_JavaNioByteBuffer == null) {
          this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(i2);
        }
        if (this.jdField_a_of_type_Msa != null) {
          this.jdField_a_of_type_Msa.a("preRender");
        }
        a(paramlpp);
        if (this.jdField_b_of_type_Lqe != null) {
          break label1990;
        }
        this.jdField_b_of_type_Lqe = lqe.a(this.f, this.jdField_e_of_type_Int);
        label835:
        if (this.jdField_a_of_type_Msa != null) {
          this.jdField_a_of_type_Msa.b("preRender");
        }
        if (this.jdField_a_of_type_Lqa != null)
        {
          this.jdField_a_of_type_Lqa.a(9, this.f, this.jdField_e_of_type_Int);
          this.jdField_a_of_type_Lqa.a(10, this.h, this.g);
          this.jdField_a_of_type_Lqa.a(this, 1, paramlpp.jdField_a_of_type_ArrayOfByte, this.f, this.jdField_e_of_type_Int);
        }
        e();
        if (a())
        {
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.a("appleVideoDenoise");
          }
          this.jdField_b_of_type_Lqe = a(this.jdField_a_of_type_Lqe);
          if (localmrd != null)
          {
            if (this.jdField_b_of_type_Lqe.jdField_b_of_type_Int == this.jdField_a_of_type_Lqe.jdField_b_of_type_Int) {
              break label2015;
            }
            bool1 = true;
            label979:
            localmrd.b(bool1);
          }
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.b("appleVideoDenoise");
          }
          a(6, null, this.jdField_a_of_type_Lqe, this.jdField_b_of_type_Lqe);
        }
        e();
        if (a(paramlpp.jdField_a_of_type_Boolean))
        {
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.a("appleLowlightEnhance");
          }
          this.jdField_b_of_type_Lqe = a(this.jdField_a_of_type_Lqe, paramlpp.jdField_a_of_type_Boolean);
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.b("appleLowlightEnhance");
          }
          a(7, null, this.jdField_a_of_type_Lqe, this.jdField_b_of_type_Lqe);
        }
        GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(this.jdField_a_of_type_ArrayOfInt);
        if (localmrd != null)
        {
          if (this.jdField_b_of_type_Lqe.jdField_b_of_type_Int == this.jdField_a_of_type_Lqe.jdField_b_of_type_Int) {
            break label2021;
          }
          bool1 = true;
          label1133:
          localmrd.c(bool1);
        }
        e();
        if (this.jdField_a_of_type_Lpm != null)
        {
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.a("applyBeauty30");
          }
          this.jdField_b_of_type_Lqe = this.jdField_a_of_type_Lpm.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Lqe, paramFilterDesc, m);
          if (this.jdField_b_of_type_Lqe.jdField_b_of_type_Int != this.jdField_a_of_type_Lqe.jdField_b_of_type_Int) {
            this.l |= 0x8;
          }
          if (localmrd != null)
          {
            if (this.jdField_b_of_type_Lqe.jdField_b_of_type_Int == this.jdField_a_of_type_Lqe.jdField_b_of_type_Int) {
              break label2027;
            }
            bool1 = true;
            label1247:
            localmrd.d(bool1);
          }
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.b("applyBeauty30");
          }
          a(8, null, this.jdField_a_of_type_Lqe, this.jdField_b_of_type_Lqe);
        }
        e();
        if ((this.jdField_a_of_type_Lpg != null) && ((paramBoolean1) || (paramFilterDesc != null) || (paramPendantItem != null) || (paramVideoMaterial != null) || (bool2)))
        {
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.a("drawFrameInGL");
          }
          this.jdField_a_of_type_Lpg.a(paramFilterDesc);
          this.jdField_a_of_type_Lpg.a(paramPendantItem, paramVideoMaterial);
          this.jdField_a_of_type_Lpg.a(bool2);
          this.jdField_a_of_type_Lpg.c(this.f, this.jdField_e_of_type_Int);
          this.jdField_b_of_type_Lqe = lqe.a(this.jdField_a_of_type_Lqe.jdField_a_of_type_Int, this.jdField_a_of_type_Lqe.jdField_b_of_type_Int);
          this.jdField_b_of_type_Lqe.jdField_b_of_type_Int = this.jdField_a_of_type_Lpg.a(this.jdField_a_of_type_Lqe.jdField_b_of_type_Int, false, this.jdField_a_of_type_Lpx, paramBoolean2);
          if (this.jdField_a_of_type_Lpg.a()) {
            this.l |= 0x80;
          }
          if (paramFilterDesc != null) {
            this.l |= 0x10;
          }
          if ((paramPendantItem != null) || (paramVideoMaterial != null)) {
            this.l |= 0x20;
          }
          if (this.jdField_a_of_type_Lpg.b()) {
            this.l |= 0x40;
          }
          if (paramBoolean1) {
            this.l |= 0x8;
          }
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.b("drawFrameInGL");
          }
          if (localmrd != null)
          {
            if (paramFilterDesc == null) {
              break label2033;
            }
            paramBoolean2 = true;
            label1565:
            if (paramVideoMaterial == null) {
              break label2039;
            }
          }
        }
      }
      label1990:
      label2015:
      label2021:
      label2027:
      label2033:
      label2039:
      for (bool1 = true;; bool1 = false)
      {
        localmrd.a(paramBoolean2, bool1, bool2, paramBoolean1);
        a(2, null, this.jdField_a_of_type_Lqe, this.jdField_b_of_type_Lqe);
        if ((bool2) || (paramVideoMaterial != null))
        {
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.a("faceDetect");
          }
          if ((this.jdField_a_of_type_Lpx.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.c()))
          {
            if ((this.jdField_a_of_type_Lpx.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Lpx.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_Lpx.jdField_a_of_type_ArrayOfFloat != null) && (this.jdField_a_of_type_Lpx.jdField_a_of_type_ArrayOfFloat.length > 0)) {
              this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(this.jdField_a_of_type_Lpx.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Lpx.jdField_a_of_type_ArrayOfFloat);
            }
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(this.jdField_e_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          }
          if (this.jdField_a_of_type_Lpg != null) {
            this.jdField_a_of_type_Lpg.a(paramlpu, this.jdField_a_of_type_Lpx);
          }
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.b("faceDetect");
          }
        }
        if (this.jdField_a_of_type_Msa != null) {
          this.jdField_a_of_type_Msa.a("postRender");
        }
        paramFilterDesc = a(paramlpp, this.jdField_b_of_type_Lqe.jdField_b_of_type_Int, this.jdField_b_of_type_Lqe.jdField_a_of_type_Int, this.jdField_a_of_type_Lpx.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Lpx.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Lpx.c, this.jdField_a_of_type_Lpx.jdField_a_of_type_Short, this.jdField_a_of_type_Lpx.jdField_b_of_type_Short);
        if (this.jdField_a_of_type_Msa != null) {
          this.jdField_a_of_type_Msa.b("postRender");
        }
        if ((paramFilterDesc != null) && (this.jdField_a_of_type_Lqa != null))
        {
          this.jdField_a_of_type_Lqa.a(this, 4, null, this.h, this.g);
          this.jdField_a_of_type_Lqa.d();
        }
        this.jdField_d_of_type_Boolean = false;
        if (paramFilterDesc != null)
        {
          paramFilterDesc.f = ((int)(System.currentTimeMillis() - l1));
          paramFilterDesc.g = this.l;
        }
        if (this.jdField_a_of_type_Msa != null) {
          this.jdField_a_of_type_Msa.a(paramlpp.jdField_c_of_type_Long);
        }
        lsr.a().a(this.l);
        return paramFilterDesc;
        n = n * i1 * 4;
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length == n)) {
          break;
        }
        this.jdField_a_of_type_ArrayOfByte = new byte[n];
        break;
        this.jdField_b_of_type_Lqe.jdField_a_of_type_Int = this.f;
        this.jdField_b_of_type_Lqe.jdField_b_of_type_Int = this.jdField_e_of_type_Int;
        break label835;
        bool1 = false;
        break label979;
        bool1 = false;
        break label1133;
        bool1 = false;
        break label1247;
        paramBoolean2 = false;
        break label1565;
      }
      label2045:
      paramBoolean1 = false;
      bool1 = false;
    }
  }
  
  public void a(long paramLong)
  {
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "initial, szie[" + this.jdField_a_of_type_Int + ", " + this.jdField_b_of_type_Int + "], id[" + this.jdField_e_of_type_Int + "], seq[" + paramLong + "]");
    }
    if (this.jdField_a_of_type_Lqa != null) {
      this.jdField_a_of_type_Lqa.a();
    }
    this.jdField_a_of_type_Boolean = msn.f();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "ray debug, initial useRGB2I420Shader = " + this.jdField_a_of_type_Boolean + ",yuvCenterTextureId = " + this.jdField_e_of_type_Int);
    if (AudioHelper.a(21) == 1) {
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      if (Build.MODEL.equalsIgnoreCase("Redmi Note 3")) {
        this.jdField_a_of_type_Boolean = false;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "ray debug,after getDebugValue, initial useRGB2I420Shader = " + this.jdField_a_of_type_Boolean + ",yuvCenterTextureId = " + this.jdField_e_of_type_Int + ",Build.MODEL = " + Build.MODEL);
      this.jdField_e_of_type_Boolean = true;
      this.jdField_d_of_type_Boolean = false;
      if (this.jdField_e_of_type_Int == -1) {
        break;
      }
      return;
      if (AudioHelper.a(21) == 0) {
        this.jdField_a_of_type_Boolean = false;
      }
    }
    label389:
    int[] arrayOfInt;
    if (lpu.a()) {
      if (this.jdField_a_of_type_Lpg == null)
      {
        boolean bool = AEFilterSupport.a();
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "initial, usePtuNew[" + bool + "]");
        }
        if (bool)
        {
          this.jdField_a_of_type_Lpg = new lph(this.jdField_a_of_type_Lqj);
          this.jdField_a_of_type_Lpg.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
      }
      else
      {
        if (!this.jdField_a_of_type_Lpg.c()) {
          break label470;
        }
        if (this.jdField_a_of_type_Lpm == null) {
          this.jdField_a_of_type_Lpm = new lpm();
        }
        arrayOfInt = new int[4];
        GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
        this.jdField_e_of_type_Int = arrayOfInt[0];
        this.jdField_c_of_type_Int = arrayOfInt[2];
        this.jdField_d_of_type_Int = arrayOfInt[3];
        if (!this.jdField_a_of_type_Boolean) {
          break label506;
        }
        this.k = arrayOfInt[1];
      }
    }
    for (;;)
    {
      this.l = 0;
      return;
      this.jdField_a_of_type_Lpg = new lpi(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Lqj);
      break;
      label470:
      if (this.jdField_a_of_type_Lpm != null) {
        this.jdField_a_of_type_Lpm.a();
      }
      this.jdField_a_of_type_Lpm = null;
      break label389;
      this.jdField_a_of_type_Lpm = new lpm();
      break label389;
      label506:
      this.g = arrayOfInt[1];
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2) {}
  
  void a(lpp paramlpp)
  {
    a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, ljw.m, YUVTexture.jdField_a_of_type_ArrayOfFloat, paramlpp.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.f, a(paramlpp.jdField_a_of_type_Boolean), this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glViewport(0, 0, paramlpp.jdField_a_of_type_Int, paramlpp.jdField_b_of_type_Int);
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Lpg != null) {
      this.jdField_a_of_type_Lpg.c();
    }
  }
  
  void b(long paramLong)
  {
    if (this.jdField_a_of_type_Lpg != null)
    {
      this.jdField_a_of_type_Lpg.a(paramLong);
      return;
    }
    this.jdField_a_of_type_Lqj.a(paramLong);
  }
  
  void c()
  {
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "uninit, mIsInited[" + this.jdField_e_of_type_Boolean + "], mIsRendering[" + this.jdField_d_of_type_Boolean + "], seq[" + l1 + "]");
    if (!this.jdField_e_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_e_of_type_Boolean = false;
      if (this.jdField_a_of_type_Lqa != null) {
        this.jdField_a_of_type_Lqa.b();
      }
      this.jdField_a_of_type_ArrayOfByte = null;
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_b_of_type_ArrayOfByte = null;
      }
      if (this.jdField_a_of_type_JavaNioByteBuffer != null)
      {
        this.jdField_a_of_type_JavaNioByteBuffer.clear();
        this.jdField_a_of_type_JavaNioByteBuffer = null;
      }
      b(l1);
      if (this.jdField_a_of_type_Lpm != null) {
        this.jdField_a_of_type_Lpm.b();
      }
      if (this.jdField_a_of_type_Lpg != null) {
        this.jdField_a_of_type_Lpg.a();
      }
    } while (this.jdField_a_of_type_Msa == null);
    this.jdField_a_of_type_Msa.a();
  }
  
  public void c(long paramLong)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "clear, seq[" + paramLong + "]");
    if (this.jdField_a_of_type_JavaNioByteBuffer != null)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_JavaNioByteBuffer = null;
    }
    if (this.f != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.f }, 0);
      this.f = -1;
    }
    int[] arrayOfInt;
    if (this.jdField_e_of_type_Int != -1)
    {
      arrayOfInt = new int[3];
      arrayOfInt[0] = this.jdField_e_of_type_Int;
      arrayOfInt[1] = this.jdField_c_of_type_Int;
      arrayOfInt[2] = this.jdField_d_of_type_Int;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.jdField_c_of_type_Int = -1;
      this.jdField_d_of_type_Int = -1;
      this.jdField_e_of_type_Int = -1;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = this.k;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.k = -1;
      GLES20.glDeleteFramebuffers(1, new int[] { this.i }, 0);
      this.i = -1;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender != null)
      {
        this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.destroy();
        this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = null;
      }
      if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender != null)
      {
        this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender.destroy();
        this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = null;
      }
      if (this.jdField_a_of_type_Lpm != null)
      {
        this.jdField_a_of_type_Lpm.a();
        this.jdField_a_of_type_Lpm = null;
      }
      if (this.jdField_a_of_type_Lpg != null)
      {
        this.jdField_a_of_type_Lpg.b();
        this.jdField_a_of_type_Lpg = null;
      }
      this.jdField_a_of_type_Lqj.a(paramLong);
      return;
      arrayOfInt = new int[1];
      arrayOfInt[0] = this.g;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.g = -1;
      GLES20.glDeleteFramebuffers(1, new int[] { this.h }, 0);
      this.h = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lpy
 * JD-Core Version:    0.7.0.1
 */