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
public class lqd
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
  private lpl jdField_a_of_type_Lpl;
  private lpr jdField_a_of_type_Lpr;
  private lps jdField_a_of_type_Lps;
  final lqc jdField_a_of_type_Lqc = new lqc();
  private lqf jdField_a_of_type_Lqf;
  private lqj jdField_a_of_type_Lqj;
  private lqm jdField_a_of_type_Lqm = new lqm();
  private final lqo jdField_a_of_type_Lqo = new lqo();
  private msd jdField_a_of_type_Msd;
  boolean jdField_a_of_type_Boolean = true;
  byte[] jdField_a_of_type_ArrayOfByte;
  public int[] a;
  int jdField_b_of_type_Int = 0;
  private lqj jdField_b_of_type_Lqj;
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
  
  public lqd(Context paramContext, liu paramliu, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[8];
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Msd = new msd();
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager = ((AVRedPacketManager)paramVideoAppInterface.a(6));
    this.jdField_a_of_type_Lps = paramVideoAppInterface.a();
    bflj.a();
    biht.a();
    this.jdField_a_of_type_Lqo.a = paramliu;
    this.jdField_e_of_type_Int = -1;
    a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static int a(boolean paramBoolean)
  {
    int n = 1;
    if (j == -1)
    {
      lpi locallpi = lpi.a();
      if ((locallpi == null) || (!locallpi.h())) {
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
  
  private lqj a(lqj paramlqj)
  {
    if (!lqk.c()) {
      this.jdField_a_of_type_ArrayOfInt[3] = 0;
    }
    do
    {
      return paramlqj;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfInt[3] = 0;
        return paramlqj;
      }
      localObject = a();
    } while (localObject == null);
    this.l |= 0x4;
    paramlqj = ((DenoiseRender)localObject).process(paramlqj.jdField_b_of_type_Int, paramlqj.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramlqj = lqj.a(paramlqj.getFbo(), paramlqj.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[3] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[5] += 1;
    return paramlqj;
  }
  
  private lqj a(lqj paramlqj, boolean paramBoolean)
  {
    if (!lqk.b()) {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
    }
    do
    {
      return paramlqj;
      if ((!this.jdField_b_of_type_Boolean) || (paramBoolean))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 0;
        return paramlqj;
      }
      localObject = a();
    } while (localObject == null);
    this.l |= 0x2;
    paramlqj = ((LowLightRender)localObject).process(paramlqj.jdField_b_of_type_Int, paramlqj.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramlqj = lqj.a(paramlqj.getFbo(), paramlqj.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[0] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[2] += 1;
    return paramlqj;
  }
  
  public static void a()
  {
    if (!lpz.a()) {
      return;
    }
    VideoPrefsUtil.setMaterialMute(true);
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
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    try
    {
      apvb.a(RendererUtils.saveTexture(paramInt1, paramInt2, paramInt3), paramString);
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
  
  private void a(int paramInt, byte[] paramArrayOfByte, lqj paramlqj1, lqj paramlqj2)
  {
    if ((this.jdField_a_of_type_Lqf != null) && (this.jdField_a_of_type_Lqf.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Lqf.a(this, paramInt, paramArrayOfByte, paramlqj2.jdField_a_of_type_Int, paramlqj2.jdField_b_of_type_Int);
      this.jdField_a_of_type_Lqf.a(paramInt, paramlqj2.jdField_a_of_type_Int, paramlqj2.jdField_b_of_type_Int);
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, String.format("%s, fbo[%s --> %s], textureid[%s --> %s]", new Object[] { lqf.a(paramInt), Integer.valueOf(paramlqj1.jdField_a_of_type_Int), Integer.valueOf(paramlqj2.jdField_a_of_type_Int), Integer.valueOf(paramlqj1.jdField_b_of_type_Int), Integer.valueOf(paramlqj2.jdField_b_of_type_Int) }));
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    int n = 0;
    int m = 0;
    if ((lqk.b()) || (lqk.c()))
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
        lcl.a(this.jdField_a_of_type_JavaLangString, " This is the " + paramArrayOfByte[2] + " times open lowlightand the " + paramArrayOfByte[4] + " times open videodenoise");
        lcl.a(this.jdField_a_of_type_JavaLangString, " The LowlightInfo is: lowlight flag = " + paramArrayOfByte[0] + ", video denoise flag = " + paramArrayOfByte[3] + ", lowlight open times = " + paramArrayOfByte[1] + ", denoise open times = " + paramArrayOfByte[4] + ", average luma = " + paramArrayOfByte[6]);
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
    if (!lqk.c()) {}
    while (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!lqk.b()) {}
    while ((!this.jdField_b_of_type_Boolean) || (paramBoolean)) {
      return false;
    }
    return true;
  }
  
  private static int[] a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat)
  {
    int[] arrayOfInt = new int[2];
    if (lkb.k * lkb.l * 3 / 2 != paramArrayOfByte.length)
    {
      lcl.e(paramString, "(AndroidCamera.PREVIEW_WIDTH * AndroidCamera.PREVIEW_HEIGHT * 3 / 2) != yuvData.length");
      return arrayOfInt;
    }
    try
    {
      paramString = LowLightUtils.DetectLowLight(paramArrayOfByte, paramInt1, lkb.k, lkb.l, 60, 0.75F);
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
      bflj.a();
      if (this.jdField_a_of_type_Lpl == null) {
        break;
      }
      this.jdField_a_of_type_Lpl.b(paramInt1, paramInt2);
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
    if ((this.jdField_a_of_type_Lqj != this.jdField_b_of_type_Lqj) && (this.jdField_a_of_type_Lqj != null))
    {
      this.jdField_a_of_type_Lqj.a();
      this.jdField_a_of_type_Lqj = null;
    }
    this.jdField_a_of_type_Lqj = this.jdField_b_of_type_Lqj;
  }
  
  public DenoiseRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = new DenoiseRender(VideoController.a().a());
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.setUpdateRate(lqk.a());
    return this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  }
  
  public LowLightRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = new LowLightRender(VideoController.a().a());
    }
    return this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender;
  }
  
  lqe a(lpu paramlpu, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
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
      GLES20.glViewport(0, 0, paramlpu.jdField_a_of_type_Int, paramlpu.jdField_b_of_type_Int);
      lqe locallqe = null;
      if (!this.jdField_c_of_type_Boolean)
      {
        paramlpu.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        paramlpu.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        paramlpu.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        paramlpu.jdField_c_of_type_Int = 21;
        if (this.jdField_a_of_type_Boolean)
        {
          paramlpu.jdField_c_of_type_Int = 100;
          paramlpu.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
        }
        paramlpu.jdField_d_of_type_Int = ((paramlpu.jdField_d_of_type_Int - a(paramlpu.jdField_a_of_type_Boolean) - 1 + 4) % 4);
        locallqe = new lqe(paramlpu, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramShort1, paramShort2);
      }
      this.jdField_c_of_type_Boolean = false;
      return locallqe;
      a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt1, this.h, this.jdField_a_of_type_JavaNioFloatBuffer);
      a(this.h, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
    }
  }
  
  public lqe a(lpu paramlpu, FilterDesc paramFilterDesc, VideoMaterial paramVideoMaterial, boolean paramBoolean1, boolean paramBoolean2, PendantItem paramPendantItem, lpz paramlpz)
  {
    if (this.jdField_a_of_type_Lqf != null) {
      this.jdField_a_of_type_Lqf.a();
    }
    if (this.jdField_a_of_type_Msd != null) {
      this.jdField_a_of_type_Msd.b();
    }
    long l1 = System.currentTimeMillis();
    b(0L, paramlpu.jdField_b_of_type_Int, paramlpu.jdField_a_of_type_Int);
    int n = paramlpu.jdField_a_of_type_Int;
    int i1 = paramlpu.jdField_b_of_type_Int;
    byte[] arrayOfByte = paramlpu.jdField_a_of_type_ArrayOfByte;
    int i2 = a(paramlpu.jdField_a_of_type_Boolean);
    if ((paramBoolean1) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.c())) {}
    int m;
    for (boolean bool2 = true;; bool2 = false)
    {
      m = this.jdField_a_of_type_Lps.a("BEAUTY_SKIN");
      this.jdField_a_of_type_Lqm.a(this.jdField_a_of_type_JavaLangString, paramlpu.jdField_c_of_type_Long, n, i1, paramlpu.jdField_d_of_type_Int, paramBoolean1, paramFilterDesc, paramVideoMaterial, paramPendantItem, paramlpu, m);
      if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int != 0) && (arrayOfByte != null) && (this.f != -1) && (this.jdField_e_of_type_Boolean)) {
        break;
      }
      return null;
    }
    this.jdField_d_of_type_Boolean = true;
    mrg localmrg = paramlpu.jdField_a_of_type_Mrg;
    if (localmrg != null) {
      localmrg.a(i2);
    }
    this.jdField_a_of_type_Lqc.a(n, i1);
    if (this.jdField_a_of_type_Lqf != null)
    {
      this.jdField_a_of_type_Lqf.c();
      this.jdField_a_of_type_Lqf.a(this, 0, arrayOfByte, -1, -1);
    }
    boolean bool1;
    if (this.jdField_a_of_type_Lpr != null)
    {
      this.jdField_a_of_type_Lpr.a(m);
      if (this.jdField_a_of_type_Lpl != null) {
        this.jdField_a_of_type_Lpl.a(null);
      }
      bool1 = this.jdField_a_of_type_Lpr.a(m);
      paramBoolean1 = false;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Msd != null) {
        this.jdField_a_of_type_Msd.a("checkLowLight");
      }
      a(arrayOfByte, paramlpu.jdField_a_of_type_Long, paramlpu.jdField_a_of_type_Boolean);
      if (localmrg != null) {
        localmrg.e();
      }
      if (this.jdField_a_of_type_Msd != null) {
        this.jdField_a_of_type_Msd.b("checkLowLight");
      }
      if (this.jdField_a_of_type_Lpr != null)
      {
        if (this.jdField_a_of_type_Msd != null) {
          this.jdField_a_of_type_Msd.a("applyBeauty20");
        }
        paramlpu.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Lpr.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, arrayOfByte, paramFilterDesc, m);
        if (paramlpu.jdField_a_of_type_ArrayOfByte != arrayOfByte) {
          this.l |= 0x8;
        }
        if (localmrg != null) {
          if (paramlpu.jdField_a_of_type_ArrayOfByte == arrayOfByte) {
            break label694;
          }
        }
      }
      label694:
      for (boolean bool3 = true;; bool3 = false)
      {
        localmrg.a(bool3);
        if (this.jdField_a_of_type_Msd != null) {
          this.jdField_a_of_type_Msd.b("applyBeauty20");
        }
        if (this.jdField_a_of_type_Lqf != null) {
          this.jdField_a_of_type_Lqf.a(this, 11, paramlpu.jdField_a_of_type_ArrayOfByte, -1, -1);
        }
        if (((paramFilterDesc != null) || (paramVideoMaterial != null) || (bool2) || (bool1) || (paramBoolean1) || (this.jdField_b_of_type_Boolean)) && (lpz.a()) && (lji.b())) {
          break label700;
        }
        paramlpu.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        paramlpu.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_Lqf != null)
        {
          this.jdField_a_of_type_Lqf.a(this, 5, paramlpu.jdField_a_of_type_ArrayOfByte, -1, -1);
          this.jdField_a_of_type_Lqf.d();
        }
        this.jdField_d_of_type_Boolean = false;
        paramlpu.f = ((int)(System.currentTimeMillis() - l1));
        paramlpu.g = this.l;
        if (this.jdField_a_of_type_JavaNioByteBuffer != null) {
          this.jdField_a_of_type_JavaNioByteBuffer.clear();
        }
        this.jdField_a_of_type_JavaNioByteBuffer = null;
        this.jdField_a_of_type_ArrayOfByte = null;
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_ArrayOfByte = null;
        }
        if (this.jdField_a_of_type_Msd != null) {
          this.jdField_a_of_type_Msd.a(paramlpu.jdField_c_of_type_Long);
        }
        lsw.a().a(this.l);
        return new lqe(paramlpu, null, null, null, (short)0, (short)0);
        if (this.jdField_a_of_type_Lpl == null) {
          break label2045;
        }
        paramBoolean1 = this.jdField_a_of_type_Lpl.a(this.jdField_a_of_type_Lps);
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
        if (this.jdField_a_of_type_Msd != null) {
          this.jdField_a_of_type_Msd.a("preRender");
        }
        a(paramlpu);
        if (this.jdField_b_of_type_Lqj != null) {
          break label1990;
        }
        this.jdField_b_of_type_Lqj = lqj.a(this.f, this.jdField_e_of_type_Int);
        label835:
        if (this.jdField_a_of_type_Msd != null) {
          this.jdField_a_of_type_Msd.b("preRender");
        }
        if (this.jdField_a_of_type_Lqf != null)
        {
          this.jdField_a_of_type_Lqf.a(9, this.f, this.jdField_e_of_type_Int);
          this.jdField_a_of_type_Lqf.a(10, this.h, this.g);
          this.jdField_a_of_type_Lqf.a(this, 1, paramlpu.jdField_a_of_type_ArrayOfByte, this.f, this.jdField_e_of_type_Int);
        }
        e();
        if (a())
        {
          if (this.jdField_a_of_type_Msd != null) {
            this.jdField_a_of_type_Msd.a("appleVideoDenoise");
          }
          this.jdField_b_of_type_Lqj = a(this.jdField_a_of_type_Lqj);
          if (localmrg != null)
          {
            if (this.jdField_b_of_type_Lqj.jdField_b_of_type_Int == this.jdField_a_of_type_Lqj.jdField_b_of_type_Int) {
              break label2015;
            }
            bool1 = true;
            label979:
            localmrg.b(bool1);
          }
          if (this.jdField_a_of_type_Msd != null) {
            this.jdField_a_of_type_Msd.b("appleVideoDenoise");
          }
          a(6, null, this.jdField_a_of_type_Lqj, this.jdField_b_of_type_Lqj);
        }
        e();
        if (a(paramlpu.jdField_a_of_type_Boolean))
        {
          if (this.jdField_a_of_type_Msd != null) {
            this.jdField_a_of_type_Msd.a("appleLowlightEnhance");
          }
          this.jdField_b_of_type_Lqj = a(this.jdField_a_of_type_Lqj, paramlpu.jdField_a_of_type_Boolean);
          if (this.jdField_a_of_type_Msd != null) {
            this.jdField_a_of_type_Msd.b("appleLowlightEnhance");
          }
          a(7, null, this.jdField_a_of_type_Lqj, this.jdField_b_of_type_Lqj);
        }
        GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(this.jdField_a_of_type_ArrayOfInt);
        if (localmrg != null)
        {
          if (this.jdField_b_of_type_Lqj.jdField_b_of_type_Int == this.jdField_a_of_type_Lqj.jdField_b_of_type_Int) {
            break label2021;
          }
          bool1 = true;
          label1133:
          localmrg.c(bool1);
        }
        e();
        if (this.jdField_a_of_type_Lpr != null)
        {
          if (this.jdField_a_of_type_Msd != null) {
            this.jdField_a_of_type_Msd.a("applyBeauty30");
          }
          this.jdField_b_of_type_Lqj = this.jdField_a_of_type_Lpr.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Lqj, paramFilterDesc, m);
          if (this.jdField_b_of_type_Lqj.jdField_b_of_type_Int != this.jdField_a_of_type_Lqj.jdField_b_of_type_Int) {
            this.l |= 0x8;
          }
          if (localmrg != null)
          {
            if (this.jdField_b_of_type_Lqj.jdField_b_of_type_Int == this.jdField_a_of_type_Lqj.jdField_b_of_type_Int) {
              break label2027;
            }
            bool1 = true;
            label1247:
            localmrg.d(bool1);
          }
          if (this.jdField_a_of_type_Msd != null) {
            this.jdField_a_of_type_Msd.b("applyBeauty30");
          }
          a(8, null, this.jdField_a_of_type_Lqj, this.jdField_b_of_type_Lqj);
        }
        e();
        if ((this.jdField_a_of_type_Lpl != null) && ((paramBoolean1) || (paramFilterDesc != null) || (paramPendantItem != null) || (paramVideoMaterial != null) || (bool2)))
        {
          if (this.jdField_a_of_type_Msd != null) {
            this.jdField_a_of_type_Msd.a("drawFrameInGL");
          }
          this.jdField_a_of_type_Lpl.a(paramFilterDesc);
          this.jdField_a_of_type_Lpl.a(paramPendantItem, paramVideoMaterial);
          this.jdField_a_of_type_Lpl.a(bool2);
          this.jdField_a_of_type_Lpl.c(this.f, this.jdField_e_of_type_Int);
          this.jdField_b_of_type_Lqj = lqj.a(this.jdField_a_of_type_Lqj.jdField_a_of_type_Int, this.jdField_a_of_type_Lqj.jdField_b_of_type_Int);
          this.jdField_b_of_type_Lqj.jdField_b_of_type_Int = this.jdField_a_of_type_Lpl.a(this.jdField_a_of_type_Lqj.jdField_b_of_type_Int, false, this.jdField_a_of_type_Lqc, paramBoolean2);
          if (this.jdField_a_of_type_Lpl.a()) {
            this.l |= 0x80;
          }
          if (paramFilterDesc != null) {
            this.l |= 0x10;
          }
          if ((paramPendantItem != null) || (paramVideoMaterial != null)) {
            this.l |= 0x20;
          }
          if (this.jdField_a_of_type_Lpl.b()) {
            this.l |= 0x40;
          }
          if (paramBoolean1) {
            this.l |= 0x8;
          }
          if (this.jdField_a_of_type_Msd != null) {
            this.jdField_a_of_type_Msd.b("drawFrameInGL");
          }
          if (localmrg != null)
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
        localmrg.a(paramBoolean2, bool1, bool2, paramBoolean1);
        a(2, null, this.jdField_a_of_type_Lqj, this.jdField_b_of_type_Lqj);
        if ((bool2) || (paramVideoMaterial != null))
        {
          if (this.jdField_a_of_type_Msd != null) {
            this.jdField_a_of_type_Msd.a("faceDetect");
          }
          if ((this.jdField_a_of_type_Lqc.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.c()))
          {
            if ((this.jdField_a_of_type_Lqc.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Lqc.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_Lqc.jdField_a_of_type_ArrayOfFloat != null) && (this.jdField_a_of_type_Lqc.jdField_a_of_type_ArrayOfFloat.length > 0)) {
              this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(this.jdField_a_of_type_Lqc.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Lqc.jdField_a_of_type_ArrayOfFloat);
            }
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(this.jdField_e_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          }
          if (this.jdField_a_of_type_Lpl != null) {
            this.jdField_a_of_type_Lpl.a(paramlpz, this.jdField_a_of_type_Lqc);
          }
          if (this.jdField_a_of_type_Msd != null) {
            this.jdField_a_of_type_Msd.b("faceDetect");
          }
        }
        if (this.jdField_a_of_type_Msd != null) {
          this.jdField_a_of_type_Msd.a("postRender");
        }
        paramFilterDesc = a(paramlpu, this.jdField_b_of_type_Lqj.jdField_b_of_type_Int, this.jdField_b_of_type_Lqj.jdField_a_of_type_Int, this.jdField_a_of_type_Lqc.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Lqc.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Lqc.c, this.jdField_a_of_type_Lqc.jdField_a_of_type_Short, this.jdField_a_of_type_Lqc.jdField_b_of_type_Short);
        if (this.jdField_a_of_type_Msd != null) {
          this.jdField_a_of_type_Msd.b("postRender");
        }
        if ((paramFilterDesc != null) && (this.jdField_a_of_type_Lqf != null))
        {
          this.jdField_a_of_type_Lqf.a(this, 4, null, this.h, this.g);
          this.jdField_a_of_type_Lqf.d();
        }
        this.jdField_d_of_type_Boolean = false;
        if (paramFilterDesc != null)
        {
          paramFilterDesc.f = ((int)(System.currentTimeMillis() - l1));
          paramFilterDesc.g = this.l;
        }
        if (this.jdField_a_of_type_Msd != null) {
          this.jdField_a_of_type_Msd.a(paramlpu.jdField_c_of_type_Long);
        }
        lsw.a().a(this.l);
        return paramFilterDesc;
        n = n * i1 * 4;
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length == n)) {
          break;
        }
        this.jdField_a_of_type_ArrayOfByte = new byte[n];
        break;
        this.jdField_b_of_type_Lqj.jdField_a_of_type_Int = this.f;
        this.jdField_b_of_type_Lqj.jdField_b_of_type_Int = this.jdField_e_of_type_Int;
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
    if (this.jdField_a_of_type_Lqf != null) {
      this.jdField_a_of_type_Lqf.a();
    }
    this.jdField_a_of_type_Boolean = msq.f();
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
    if (lpz.a()) {
      if (this.jdField_a_of_type_Lpl == null)
      {
        boolean bool = AEFilterSupport.a();
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "initial, usePtuNew[" + bool + "]");
        }
        if (bool)
        {
          this.jdField_a_of_type_Lpl = new lpm(this.jdField_a_of_type_Lqo);
          this.jdField_a_of_type_Lpl.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
      }
      else
      {
        if (!this.jdField_a_of_type_Lpl.c()) {
          break label470;
        }
        if (this.jdField_a_of_type_Lpr == null) {
          this.jdField_a_of_type_Lpr = new lpr();
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
      this.jdField_a_of_type_Lpl = new lpn(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Lqo);
      break;
      label470:
      if (this.jdField_a_of_type_Lpr != null) {
        this.jdField_a_of_type_Lpr.a();
      }
      this.jdField_a_of_type_Lpr = null;
      break label389;
      this.jdField_a_of_type_Lpr = new lpr();
      break label389;
      label506:
      this.g = arrayOfInt[1];
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2) {}
  
  void a(lpu paramlpu)
  {
    a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, lkb.m, YUVTexture.jdField_a_of_type_ArrayOfFloat, paramlpu.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.f, a(paramlpu.jdField_a_of_type_Boolean), this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glViewport(0, 0, paramlpu.jdField_a_of_type_Int, paramlpu.jdField_b_of_type_Int);
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Lpl != null) {
      this.jdField_a_of_type_Lpl.c();
    }
  }
  
  void b(long paramLong)
  {
    if (this.jdField_a_of_type_Lpl != null)
    {
      this.jdField_a_of_type_Lpl.a(paramLong);
      return;
    }
    this.jdField_a_of_type_Lqo.a(paramLong);
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
      if (this.jdField_a_of_type_Lqf != null) {
        this.jdField_a_of_type_Lqf.b();
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
      if (this.jdField_a_of_type_Lpr != null) {
        this.jdField_a_of_type_Lpr.b();
      }
      if (this.jdField_a_of_type_Lpl != null) {
        this.jdField_a_of_type_Lpl.a();
      }
    } while (this.jdField_a_of_type_Msd == null);
    this.jdField_a_of_type_Msd.a();
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
      if (this.jdField_a_of_type_Lpr != null)
      {
        this.jdField_a_of_type_Lpr.a();
        this.jdField_a_of_type_Lpr = null;
      }
      if (this.jdField_a_of_type_Lpl != null)
      {
        this.jdField_a_of_type_Lpl.b();
        this.jdField_a_of_type_Lpl = null;
      }
      this.jdField_a_of_type_Lqo.a(paramLong);
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
 * Qualified Name:     lqd
 * JD-Core Version:    0.7.0.1
 */