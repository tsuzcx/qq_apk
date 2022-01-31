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
public class lse
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
  private lrj jdField_a_of_type_Lrj;
  private lrp jdField_a_of_type_Lrp;
  private lrq jdField_a_of_type_Lrq;
  final lsd jdField_a_of_type_Lsd = new lsd();
  private lsg jdField_a_of_type_Lsg;
  private lsk jdField_a_of_type_Lsk;
  private lso jdField_a_of_type_Lso = new lso();
  private final lsq jdField_a_of_type_Lsq = new lsq();
  private muu jdField_a_of_type_Muu;
  boolean jdField_a_of_type_Boolean = true;
  byte[] jdField_a_of_type_ArrayOfByte;
  public int[] a;
  int jdField_b_of_type_Int = 0;
  private lsk jdField_b_of_type_Lsk;
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
  
  public lse(Context paramContext, lks paramlks, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[8];
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Muu = new muu();
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager = ((AVRedPacketManager)paramVideoAppInterface.a(6));
    this.jdField_a_of_type_Lrq = paramVideoAppInterface.a();
    bhmu.a();
    bkkj.a();
    this.jdField_a_of_type_Lsq.a = paramlks;
    this.jdField_e_of_type_Int = -1;
    a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static int a(boolean paramBoolean)
  {
    int n = 1;
    if (j == -1)
    {
      lrg locallrg = lrg.a();
      if ((locallrg == null) || (!locallrg.h())) {
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
  
  private lsk a(lsk paramlsk)
  {
    if (!lsl.c()) {
      this.jdField_a_of_type_ArrayOfInt[3] = 0;
    }
    do
    {
      return paramlsk;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfInt[3] = 0;
        return paramlsk;
      }
      localObject = a();
    } while (localObject == null);
    this.l |= 0x4;
    paramlsk = ((DenoiseRender)localObject).process(paramlsk.jdField_b_of_type_Int, paramlsk.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramlsk = lsk.a(paramlsk.getFbo(), paramlsk.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[3] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[5] += 1;
    return paramlsk;
  }
  
  private lsk a(lsk paramlsk, boolean paramBoolean)
  {
    if (!lsl.b()) {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
    }
    do
    {
      return paramlsk;
      if ((!this.jdField_b_of_type_Boolean) || (paramBoolean))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 0;
        return paramlsk;
      }
      localObject = a();
    } while (localObject == null);
    this.l |= 0x2;
    paramlsk = ((LowLightRender)localObject).process(paramlsk.jdField_b_of_type_Int, paramlsk.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramlsk = lsk.a(paramlsk.getFbo(), paramlsk.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[0] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[2] += 1;
    return paramlsk;
  }
  
  public static void a()
  {
    if (!lsa.a()) {
      return;
    }
    VideoPrefsUtil.setMaterialMute(true);
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    TextureProgram localTextureProgram = ltu.a(5);
    ltw[] arrayOfltw = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    lsw.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOfltw[4].jdField_a_of_type_Int, 0);
    GLES20.glUniform1f(arrayOfltw[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfltw[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOfltw[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
    GLES20.glVertexAttribPointer(arrayOfltw[0].jdField_a_of_type_Int, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfltw[0].jdField_a_of_type_Int);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    try
    {
      arof.a(RendererUtils.saveTexture(paramInt1, paramInt2, paramInt3), paramString);
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
    paramArrayOfByte = ltu.a(1);
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
  
  private void a(int paramInt, byte[] paramArrayOfByte, lsk paramlsk1, lsk paramlsk2)
  {
    if ((this.jdField_a_of_type_Lsg != null) && (this.jdField_a_of_type_Lsg.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Lsg.a(this, paramInt, paramArrayOfByte, paramlsk2.jdField_a_of_type_Int, paramlsk2.jdField_b_of_type_Int);
      this.jdField_a_of_type_Lsg.a(paramInt, paramlsk2.jdField_a_of_type_Int, paramlsk2.jdField_b_of_type_Int);
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, String.format("%s, fbo[%s --> %s], textureid[%s --> %s]", new Object[] { lsg.a(paramInt), Integer.valueOf(paramlsk1.jdField_a_of_type_Int), Integer.valueOf(paramlsk2.jdField_a_of_type_Int), Integer.valueOf(paramlsk1.jdField_b_of_type_Int), Integer.valueOf(paramlsk2.jdField_b_of_type_Int) }));
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    int n = 0;
    int m = 0;
    if ((lsl.b()) || (lsl.c()))
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
        lek.a(this.jdField_a_of_type_JavaLangString, " This is the " + paramArrayOfByte[2] + " times open lowlightand the " + paramArrayOfByte[4] + " times open videodenoise");
        lek.a(this.jdField_a_of_type_JavaLangString, " The LowlightInfo is: lowlight flag = " + paramArrayOfByte[0] + ", video denoise flag = " + paramArrayOfByte[3] + ", lowlight open times = " + paramArrayOfByte[1] + ", denoise open times = " + paramArrayOfByte[4] + ", average luma = " + paramArrayOfByte[6]);
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
    if (!lsl.c()) {}
    while (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!lsl.b()) {}
    while ((!this.jdField_b_of_type_Boolean) || (paramBoolean)) {
      return false;
    }
    return true;
  }
  
  private static int[] a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat)
  {
    int[] arrayOfInt = new int[2];
    if (llz.k * llz.l * 3 / 2 != paramArrayOfByte.length)
    {
      lek.e(paramString, "(AndroidCamera.PREVIEW_WIDTH * AndroidCamera.PREVIEW_HEIGHT * 3 / 2) != yuvData.length");
      return arrayOfInt;
    }
    try
    {
      paramString = LowLightUtils.DetectLowLight(paramArrayOfByte, paramInt1, llz.k, llz.l, 60, 0.75F);
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
    TextureProgram localTextureProgram = ltu.a(6);
    ltw[] arrayOfltw = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    lsw.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOfltw[4].jdField_a_of_type_Int, 0);
    GLES20.glUniform1f(arrayOfltw[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOfltw[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOfltw[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
    GLES20.glUniform1f(arrayOfltw[7].jdField_a_of_type_Int, paramInt1);
    GLES20.glUniform1f(arrayOfltw[8].jdField_a_of_type_Int, paramInt2);
    GLES20.glVertexAttribPointer(arrayOfltw[0].jdField_a_of_type_Int, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOfltw[0].jdField_a_of_type_Int);
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
      bhmu.a();
      if (this.jdField_a_of_type_Lrj == null) {
        break;
      }
      this.jdField_a_of_type_Lrj.b(paramInt1, paramInt2);
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
    if ((this.jdField_a_of_type_Lsk != this.jdField_b_of_type_Lsk) && (this.jdField_a_of_type_Lsk != null))
    {
      this.jdField_a_of_type_Lsk.a();
      this.jdField_a_of_type_Lsk = null;
    }
    this.jdField_a_of_type_Lsk = this.jdField_b_of_type_Lsk;
  }
  
  public DenoiseRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = new DenoiseRender(VideoController.a().a());
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.setUpdateRate(lsl.a());
    return this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  }
  
  public LowLightRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = new LowLightRender(VideoController.a().a());
    }
    return this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender;
  }
  
  lsf a(lrs paramlrs, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
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
      GLES20.glViewport(0, 0, paramlrs.jdField_a_of_type_Int, paramlrs.jdField_b_of_type_Int);
      lsf locallsf = null;
      if (!this.jdField_c_of_type_Boolean)
      {
        paramlrs.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        paramlrs.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        paramlrs.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        paramlrs.jdField_c_of_type_Int = 21;
        if (this.jdField_a_of_type_Boolean)
        {
          paramlrs.jdField_c_of_type_Int = 100;
          paramlrs.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
        }
        paramlrs.jdField_d_of_type_Int = ((paramlrs.jdField_d_of_type_Int - a(paramlrs.jdField_a_of_type_Boolean) - 1 + 4) % 4);
        locallsf = new lsf(paramlrs, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramShort1, paramShort2);
      }
      this.jdField_c_of_type_Boolean = false;
      return locallsf;
      a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt1, this.h, this.jdField_a_of_type_JavaNioFloatBuffer);
      a(this.h, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
    }
  }
  
  public lsf a(lrs paramlrs, FilterDesc paramFilterDesc, VideoMaterial paramVideoMaterial, boolean paramBoolean1, boolean paramBoolean2, PendantItem paramPendantItem, lsa paramlsa)
  {
    if (this.jdField_a_of_type_Lsg != null) {
      this.jdField_a_of_type_Lsg.a();
    }
    if (this.jdField_a_of_type_Muu != null) {
      this.jdField_a_of_type_Muu.b();
    }
    long l1 = System.currentTimeMillis();
    b(0L, paramlrs.jdField_b_of_type_Int, paramlrs.jdField_a_of_type_Int);
    int n = paramlrs.jdField_a_of_type_Int;
    int i1 = paramlrs.jdField_b_of_type_Int;
    byte[] arrayOfByte = paramlrs.jdField_a_of_type_ArrayOfByte;
    int i2 = a(paramlrs.jdField_a_of_type_Boolean);
    if ((paramBoolean1) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.c())) {}
    int m;
    for (boolean bool2 = true;; bool2 = false)
    {
      m = this.jdField_a_of_type_Lrq.a("BEAUTY_SKIN");
      this.jdField_a_of_type_Lso.a(this.jdField_a_of_type_JavaLangString, paramlrs.jdField_c_of_type_Long, n, i1, paramlrs.jdField_d_of_type_Int, paramBoolean1, paramFilterDesc, paramVideoMaterial, paramPendantItem, paramlrs, m);
      if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int != 0) && (arrayOfByte != null) && (this.f != -1) && (this.jdField_e_of_type_Boolean)) {
        break;
      }
      return null;
    }
    this.jdField_d_of_type_Boolean = true;
    mtx localmtx = paramlrs.jdField_a_of_type_Mtx;
    if (localmtx != null) {
      localmtx.a(i2);
    }
    this.jdField_a_of_type_Lsd.a(n, i1);
    if (this.jdField_a_of_type_Lsg != null)
    {
      this.jdField_a_of_type_Lsg.c();
      this.jdField_a_of_type_Lsg.a(this, 0, arrayOfByte, -1, -1);
    }
    boolean bool1;
    if (this.jdField_a_of_type_Lrp != null)
    {
      this.jdField_a_of_type_Lrp.a(m);
      if (this.jdField_a_of_type_Lrj != null) {
        this.jdField_a_of_type_Lrj.a(null);
      }
      bool1 = this.jdField_a_of_type_Lrp.a(m);
      paramBoolean1 = false;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Muu != null) {
        this.jdField_a_of_type_Muu.a("checkLowLight");
      }
      a(arrayOfByte, paramlrs.jdField_a_of_type_Long, paramlrs.jdField_a_of_type_Boolean);
      if (localmtx != null) {
        localmtx.e();
      }
      if (this.jdField_a_of_type_Muu != null) {
        this.jdField_a_of_type_Muu.b("checkLowLight");
      }
      if (this.jdField_a_of_type_Lrp != null)
      {
        if (this.jdField_a_of_type_Muu != null) {
          this.jdField_a_of_type_Muu.a("applyBeauty20");
        }
        paramlrs.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Lrp.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, arrayOfByte, paramFilterDesc, m);
        if (paramlrs.jdField_a_of_type_ArrayOfByte != arrayOfByte) {
          this.l |= 0x8;
        }
        if (localmtx != null) {
          if (paramlrs.jdField_a_of_type_ArrayOfByte == arrayOfByte) {
            break label694;
          }
        }
      }
      label694:
      for (boolean bool3 = true;; bool3 = false)
      {
        localmtx.a(bool3);
        if (this.jdField_a_of_type_Muu != null) {
          this.jdField_a_of_type_Muu.b("applyBeauty20");
        }
        if (this.jdField_a_of_type_Lsg != null) {
          this.jdField_a_of_type_Lsg.a(this, 11, paramlrs.jdField_a_of_type_ArrayOfByte, -1, -1);
        }
        if (((paramFilterDesc != null) || (paramVideoMaterial != null) || (bool2) || (bool1) || (paramBoolean1) || (this.jdField_b_of_type_Boolean)) && (lsa.a()) && (llg.b())) {
          break label700;
        }
        paramlrs.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        paramlrs.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_Lsg != null)
        {
          this.jdField_a_of_type_Lsg.a(this, 5, paramlrs.jdField_a_of_type_ArrayOfByte, -1, -1);
          this.jdField_a_of_type_Lsg.d();
        }
        this.jdField_d_of_type_Boolean = false;
        paramlrs.f = ((int)(System.currentTimeMillis() - l1));
        paramlrs.g = this.l;
        if (this.jdField_a_of_type_JavaNioByteBuffer != null) {
          this.jdField_a_of_type_JavaNioByteBuffer.clear();
        }
        this.jdField_a_of_type_JavaNioByteBuffer = null;
        this.jdField_a_of_type_ArrayOfByte = null;
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_ArrayOfByte = null;
        }
        if (this.jdField_a_of_type_Muu != null) {
          this.jdField_a_of_type_Muu.a(paramlrs.jdField_c_of_type_Long);
        }
        luy.a().a(this.l);
        return new lsf(paramlrs, null, null, null, (short)0, (short)0);
        if (this.jdField_a_of_type_Lrj == null) {
          break label2045;
        }
        paramBoolean1 = this.jdField_a_of_type_Lrj.a(this.jdField_a_of_type_Lrq);
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
        if (this.jdField_a_of_type_Muu != null) {
          this.jdField_a_of_type_Muu.a("preRender");
        }
        a(paramlrs);
        if (this.jdField_b_of_type_Lsk != null) {
          break label1990;
        }
        this.jdField_b_of_type_Lsk = lsk.a(this.f, this.jdField_e_of_type_Int);
        label835:
        if (this.jdField_a_of_type_Muu != null) {
          this.jdField_a_of_type_Muu.b("preRender");
        }
        if (this.jdField_a_of_type_Lsg != null)
        {
          this.jdField_a_of_type_Lsg.a(9, this.f, this.jdField_e_of_type_Int);
          this.jdField_a_of_type_Lsg.a(10, this.h, this.g);
          this.jdField_a_of_type_Lsg.a(this, 1, paramlrs.jdField_a_of_type_ArrayOfByte, this.f, this.jdField_e_of_type_Int);
        }
        e();
        if (a())
        {
          if (this.jdField_a_of_type_Muu != null) {
            this.jdField_a_of_type_Muu.a("appleVideoDenoise");
          }
          this.jdField_b_of_type_Lsk = a(this.jdField_a_of_type_Lsk);
          if (localmtx != null)
          {
            if (this.jdField_b_of_type_Lsk.jdField_b_of_type_Int == this.jdField_a_of_type_Lsk.jdField_b_of_type_Int) {
              break label2015;
            }
            bool1 = true;
            label979:
            localmtx.b(bool1);
          }
          if (this.jdField_a_of_type_Muu != null) {
            this.jdField_a_of_type_Muu.b("appleVideoDenoise");
          }
          a(6, null, this.jdField_a_of_type_Lsk, this.jdField_b_of_type_Lsk);
        }
        e();
        if (a(paramlrs.jdField_a_of_type_Boolean))
        {
          if (this.jdField_a_of_type_Muu != null) {
            this.jdField_a_of_type_Muu.a("appleLowlightEnhance");
          }
          this.jdField_b_of_type_Lsk = a(this.jdField_a_of_type_Lsk, paramlrs.jdField_a_of_type_Boolean);
          if (this.jdField_a_of_type_Muu != null) {
            this.jdField_a_of_type_Muu.b("appleLowlightEnhance");
          }
          a(7, null, this.jdField_a_of_type_Lsk, this.jdField_b_of_type_Lsk);
        }
        GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(this.jdField_a_of_type_ArrayOfInt);
        if (localmtx != null)
        {
          if (this.jdField_b_of_type_Lsk.jdField_b_of_type_Int == this.jdField_a_of_type_Lsk.jdField_b_of_type_Int) {
            break label2021;
          }
          bool1 = true;
          label1133:
          localmtx.c(bool1);
        }
        e();
        if (this.jdField_a_of_type_Lrp != null)
        {
          if (this.jdField_a_of_type_Muu != null) {
            this.jdField_a_of_type_Muu.a("applyBeauty30");
          }
          this.jdField_b_of_type_Lsk = this.jdField_a_of_type_Lrp.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Lsk, paramFilterDesc, m);
          if (this.jdField_b_of_type_Lsk.jdField_b_of_type_Int != this.jdField_a_of_type_Lsk.jdField_b_of_type_Int) {
            this.l |= 0x8;
          }
          if (localmtx != null)
          {
            if (this.jdField_b_of_type_Lsk.jdField_b_of_type_Int == this.jdField_a_of_type_Lsk.jdField_b_of_type_Int) {
              break label2027;
            }
            bool1 = true;
            label1247:
            localmtx.d(bool1);
          }
          if (this.jdField_a_of_type_Muu != null) {
            this.jdField_a_of_type_Muu.b("applyBeauty30");
          }
          a(8, null, this.jdField_a_of_type_Lsk, this.jdField_b_of_type_Lsk);
        }
        e();
        if ((this.jdField_a_of_type_Lrj != null) && ((paramBoolean1) || (paramFilterDesc != null) || (paramPendantItem != null) || (paramVideoMaterial != null) || (bool2)))
        {
          if (this.jdField_a_of_type_Muu != null) {
            this.jdField_a_of_type_Muu.a("drawFrameInGL");
          }
          this.jdField_a_of_type_Lrj.a(paramFilterDesc);
          this.jdField_a_of_type_Lrj.a(paramPendantItem, paramVideoMaterial);
          this.jdField_a_of_type_Lrj.a(bool2);
          this.jdField_a_of_type_Lrj.c(this.f, this.jdField_e_of_type_Int);
          this.jdField_b_of_type_Lsk = lsk.a(this.jdField_a_of_type_Lsk.jdField_a_of_type_Int, this.jdField_a_of_type_Lsk.jdField_b_of_type_Int);
          this.jdField_b_of_type_Lsk.jdField_b_of_type_Int = this.jdField_a_of_type_Lrj.a(this.jdField_a_of_type_Lsk.jdField_b_of_type_Int, false, this.jdField_a_of_type_Lsd, paramBoolean2);
          if (this.jdField_a_of_type_Lrj.a()) {
            this.l |= 0x80;
          }
          if (paramFilterDesc != null) {
            this.l |= 0x10;
          }
          if ((paramPendantItem != null) || (paramVideoMaterial != null)) {
            this.l |= 0x20;
          }
          if (this.jdField_a_of_type_Lrj.b()) {
            this.l |= 0x40;
          }
          if (paramBoolean1) {
            this.l |= 0x8;
          }
          if (this.jdField_a_of_type_Muu != null) {
            this.jdField_a_of_type_Muu.b("drawFrameInGL");
          }
          if (localmtx != null)
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
        localmtx.a(paramBoolean2, bool1, bool2, paramBoolean1);
        a(2, null, this.jdField_a_of_type_Lsk, this.jdField_b_of_type_Lsk);
        if ((bool2) || (paramVideoMaterial != null))
        {
          if (this.jdField_a_of_type_Muu != null) {
            this.jdField_a_of_type_Muu.a("faceDetect");
          }
          if ((this.jdField_a_of_type_Lsd.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.c()))
          {
            if ((this.jdField_a_of_type_Lsd.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Lsd.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_Lsd.jdField_a_of_type_ArrayOfFloat != null) && (this.jdField_a_of_type_Lsd.jdField_a_of_type_ArrayOfFloat.length > 0)) {
              this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(this.jdField_a_of_type_Lsd.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Lsd.jdField_a_of_type_ArrayOfFloat);
            }
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(this.jdField_e_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          }
          if (this.jdField_a_of_type_Lrj != null) {
            this.jdField_a_of_type_Lrj.a(paramlsa, this.jdField_a_of_type_Lsd);
          }
          if (this.jdField_a_of_type_Muu != null) {
            this.jdField_a_of_type_Muu.b("faceDetect");
          }
        }
        if (this.jdField_a_of_type_Muu != null) {
          this.jdField_a_of_type_Muu.a("postRender");
        }
        paramFilterDesc = a(paramlrs, this.jdField_b_of_type_Lsk.jdField_b_of_type_Int, this.jdField_b_of_type_Lsk.jdField_a_of_type_Int, this.jdField_a_of_type_Lsd.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Lsd.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Lsd.c, this.jdField_a_of_type_Lsd.jdField_a_of_type_Short, this.jdField_a_of_type_Lsd.jdField_b_of_type_Short);
        if (this.jdField_a_of_type_Muu != null) {
          this.jdField_a_of_type_Muu.b("postRender");
        }
        if ((paramFilterDesc != null) && (this.jdField_a_of_type_Lsg != null))
        {
          this.jdField_a_of_type_Lsg.a(this, 4, null, this.h, this.g);
          this.jdField_a_of_type_Lsg.d();
        }
        this.jdField_d_of_type_Boolean = false;
        if (paramFilterDesc != null)
        {
          paramFilterDesc.f = ((int)(System.currentTimeMillis() - l1));
          paramFilterDesc.g = this.l;
        }
        if (this.jdField_a_of_type_Muu != null) {
          this.jdField_a_of_type_Muu.a(paramlrs.jdField_c_of_type_Long);
        }
        luy.a().a(this.l);
        return paramFilterDesc;
        n = n * i1 * 4;
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length == n)) {
          break;
        }
        this.jdField_a_of_type_ArrayOfByte = new byte[n];
        break;
        this.jdField_b_of_type_Lsk.jdField_a_of_type_Int = this.f;
        this.jdField_b_of_type_Lsk.jdField_b_of_type_Int = this.jdField_e_of_type_Int;
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
    if (this.jdField_a_of_type_Lsg != null) {
      this.jdField_a_of_type_Lsg.a();
    }
    this.jdField_a_of_type_Boolean = mvh.f();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "ray debug, initial useRGB2I420Shader = " + this.jdField_a_of_type_Boolean + ",yuvCenterTextureId = " + this.jdField_e_of_type_Int);
    if (AudioHelper.a(21) == 1) {
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      if ((Build.MODEL.equalsIgnoreCase("Redmi Note 3")) || (Build.MODEL.equalsIgnoreCase("MX5"))) {
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
    label401:
    int[] arrayOfInt;
    if (lsa.a()) {
      if (this.jdField_a_of_type_Lrj == null)
      {
        boolean bool = AEFilterSupport.a();
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "initial, usePtuNew[" + bool + "]");
        }
        if (bool)
        {
          this.jdField_a_of_type_Lrj = new lrk(this.jdField_a_of_type_Lsq);
          this.jdField_a_of_type_Lrj.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
      }
      else
      {
        if (!this.jdField_a_of_type_Lrj.c()) {
          break label482;
        }
        if (this.jdField_a_of_type_Lrp == null) {
          this.jdField_a_of_type_Lrp = new lrp();
        }
        arrayOfInt = new int[4];
        GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
        this.jdField_e_of_type_Int = arrayOfInt[0];
        this.jdField_c_of_type_Int = arrayOfInt[2];
        this.jdField_d_of_type_Int = arrayOfInt[3];
        if (!this.jdField_a_of_type_Boolean) {
          break label518;
        }
        this.k = arrayOfInt[1];
      }
    }
    for (;;)
    {
      this.l = 0;
      return;
      this.jdField_a_of_type_Lrj = new lrl(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Lsq);
      break;
      label482:
      if (this.jdField_a_of_type_Lrp != null) {
        this.jdField_a_of_type_Lrp.a();
      }
      this.jdField_a_of_type_Lrp = null;
      break label401;
      this.jdField_a_of_type_Lrp = new lrp();
      break label401;
      label518:
      this.g = arrayOfInt[1];
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2) {}
  
  void a(lrs paramlrs)
  {
    a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, llz.m, YUVTexture.jdField_a_of_type_ArrayOfFloat, paramlrs.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.f, a(paramlrs.jdField_a_of_type_Boolean), this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glViewport(0, 0, paramlrs.jdField_a_of_type_Int, paramlrs.jdField_b_of_type_Int);
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Lrj != null) {
      this.jdField_a_of_type_Lrj.c();
    }
  }
  
  void b(long paramLong)
  {
    if (this.jdField_a_of_type_Lrj != null)
    {
      this.jdField_a_of_type_Lrj.a(paramLong);
      return;
    }
    this.jdField_a_of_type_Lsq.a(paramLong);
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
      if (this.jdField_a_of_type_Lsg != null) {
        this.jdField_a_of_type_Lsg.b();
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
      if (this.jdField_a_of_type_Lrp != null) {
        this.jdField_a_of_type_Lrp.b();
      }
      if (this.jdField_a_of_type_Lrj != null) {
        this.jdField_a_of_type_Lrj.a();
      }
    } while (this.jdField_a_of_type_Muu == null);
    this.jdField_a_of_type_Muu.a();
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
      if (this.jdField_a_of_type_Lrp != null)
      {
        this.jdField_a_of_type_Lrp.a();
        this.jdField_a_of_type_Lrp = null;
      }
      if (this.jdField_a_of_type_Lrj != null)
      {
        this.jdField_a_of_type_Lrj.b();
        this.jdField_a_of_type_Lrj = null;
      }
      this.jdField_a_of_type_Lsq.a(paramLong);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lse
 * JD-Core Version:    0.7.0.1
 */