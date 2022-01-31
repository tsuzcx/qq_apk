import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import android.os.Build;
import android.os.SystemClock;
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
public class lfm
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
  private lev jdField_a_of_type_Lev;
  private lez jdField_a_of_type_Lez;
  private lfa jdField_a_of_type_Lfa;
  final lfl jdField_a_of_type_Lfl = new lfl();
  private lfo jdField_a_of_type_Lfo;
  private lfs jdField_a_of_type_Lfs;
  private lfv jdField_a_of_type_Lfv = new lfv();
  private final lfx jdField_a_of_type_Lfx = new lfx();
  private mhe jdField_a_of_type_Mhe;
  boolean jdField_a_of_type_Boolean = true;
  byte[] jdField_a_of_type_ArrayOfByte;
  public int[] a;
  int jdField_b_of_type_Int = 0;
  private lfs jdField_b_of_type_Lfs;
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
  
  public lfm(Context paramContext, kyc paramkyc, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[8];
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Mhe = new mhe();
    }
    this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager = ((AVRedPacketManager)paramVideoAppInterface.a(6));
    this.jdField_a_of_type_Lfa = paramVideoAppInterface.a();
    bedt.a();
    bgxr.a();
    this.jdField_a_of_type_Lfx.a = paramkyc;
    this.jdField_e_of_type_Int = -1;
    a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static int a(boolean paramBoolean)
  {
    int n = 1;
    if (j == -1)
    {
      les localles = les.a();
      if ((localles == null) || (!localles.h())) {
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
  
  private lfs a(lfs paramlfs)
  {
    if (!lft.c()) {
      this.jdField_a_of_type_ArrayOfInt[3] = 0;
    }
    do
    {
      return paramlfs;
      if (!this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfInt[3] = 0;
        return paramlfs;
      }
      localObject = a();
    } while (localObject == null);
    this.l |= 0x4;
    paramlfs = ((DenoiseRender)localObject).process(paramlfs.jdField_b_of_type_Int, paramlfs.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramlfs = lfs.a(paramlfs.getFbo(), paramlfs.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[3] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[5] += 1;
    return paramlfs;
  }
  
  private lfs a(lfs paramlfs, boolean paramBoolean)
  {
    if (!lft.b()) {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
    }
    do
    {
      return paramlfs;
      if ((!this.jdField_b_of_type_Boolean) || (paramBoolean))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 0;
        return paramlfs;
      }
      localObject = a();
    } while (localObject == null);
    this.l |= 0x2;
    paramlfs = ((LowLightRender)localObject).process(paramlfs.jdField_b_of_type_Int, paramlfs.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramlfs = lfs.a(paramlfs.getFbo(), paramlfs.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[0] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[2] += 1;
    return paramlfs;
  }
  
  public static void a()
  {
    if (!lfi.a()) {
      return;
    }
    VideoPrefsUtil.setMaterialMute(true);
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    TextureProgram localTextureProgram = lhb.a(5);
    lhd[] arrayOflhd = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    lgd.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOflhd[4].jdField_a_of_type_Int, 0);
    GLES20.glUniform1f(arrayOflhd[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOflhd[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOflhd[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
    GLES20.glVertexAttribPointer(arrayOflhd[0].jdField_a_of_type_Int, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOflhd[0].jdField_a_of_type_Int);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    try
    {
      apdh.a(RendererUtils.saveTexture(paramInt1, paramInt2, paramInt3), paramString);
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
    paramArrayOfByte = lhb.a(1);
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
  
  private void a(int paramInt, byte[] paramArrayOfByte, lfs paramlfs1, lfs paramlfs2)
  {
    if (this.jdField_a_of_type_Lfo != null)
    {
      this.jdField_a_of_type_Lfo.a(this, paramInt, paramArrayOfByte, paramlfs2.jdField_a_of_type_Int, paramlfs2.jdField_b_of_type_Int);
      this.jdField_a_of_type_Lfo.a(paramInt, paramlfs2.jdField_a_of_type_Int, paramlfs2.jdField_b_of_type_Int);
    }
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, String.format("%s, fbo[%s --> %s], textureid[%s --> %s]", new Object[] { lfo.a(paramInt), Integer.valueOf(paramlfs1.jdField_a_of_type_Int), Integer.valueOf(paramlfs2.jdField_a_of_type_Int), Integer.valueOf(paramlfs1.jdField_b_of_type_Int), Integer.valueOf(paramlfs2.jdField_b_of_type_Int) }));
    }
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    int n = 0;
    int m = 0;
    if ((lft.b()) || (lft.c()))
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
        krx.a(this.jdField_a_of_type_JavaLangString, " This is the " + paramArrayOfByte[2] + " times open lowlightand the " + paramArrayOfByte[4] + " times open videodenoise");
        krx.a(this.jdField_a_of_type_JavaLangString, " The LowlightInfo is: lowlight flag = " + paramArrayOfByte[0] + ", video denoise flag = " + paramArrayOfByte[3] + ", lowlight open times = " + paramArrayOfByte[1] + ", denoise open times = " + paramArrayOfByte[4] + ", average luma = " + paramArrayOfByte[6]);
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
    if (!lft.c()) {}
    while (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!lft.b()) {}
    while ((!this.jdField_b_of_type_Boolean) || (paramBoolean)) {
      return false;
    }
    return true;
  }
  
  private static int[] a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat)
  {
    int[] arrayOfInt = new int[2];
    if (kzl.k * kzl.l * 3 / 2 != paramArrayOfByte.length)
    {
      krx.e(paramString, "(AndroidCamera.PREVIEW_WIDTH * AndroidCamera.PREVIEW_HEIGHT * 3 / 2) != yuvData.length");
      return arrayOfInt;
    }
    return LowLightUtils.DetectLowLight(paramArrayOfByte, paramInt1, kzl.k, kzl.l, 60, 0.75F);
  }
  
  static void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2 / 4, (int)(paramInt1 * 1.5D));
    TextureProgram localTextureProgram = lhb.a(6);
    lhd[] arrayOflhd = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    lgd.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOflhd[4].jdField_a_of_type_Int, 0);
    GLES20.glUniform1f(arrayOflhd[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOflhd[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOflhd[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
    GLES20.glUniform1f(arrayOflhd[7].jdField_a_of_type_Int, paramInt1);
    GLES20.glUniform1f(arrayOflhd[8].jdField_a_of_type_Int, paramInt2);
    GLES20.glVertexAttribPointer(arrayOflhd[0].jdField_a_of_type_Int, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOflhd[0].jdField_a_of_type_Int);
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
      bedt.a();
      if (this.jdField_a_of_type_Lev == null) {
        break;
      }
      this.jdField_a_of_type_Lev.b(paramInt1, paramInt2);
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
    if ((this.jdField_a_of_type_Lfs != this.jdField_b_of_type_Lfs) && (this.jdField_a_of_type_Lfs != null))
    {
      this.jdField_a_of_type_Lfs.a();
      this.jdField_a_of_type_Lfs = null;
    }
    this.jdField_a_of_type_Lfs = this.jdField_b_of_type_Lfs;
  }
  
  public DenoiseRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = new DenoiseRender(VideoController.a().a());
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.setUpdateRate(lft.a());
    return this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  }
  
  public LowLightRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = new LowLightRender(VideoController.a().a());
    }
    return this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender;
  }
  
  lfn a(lfc paramlfc, int paramInt1, int paramInt2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
  {
    long l6;
    long l3;
    long l1;
    long l4;
    long l2;
    long l5;
    if (this.jdField_a_of_type_Boolean)
    {
      l6 = SystemClock.elapsedRealtimeNanos();
      l3 = System.currentTimeMillis();
      b(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt1, this.i, this.jdField_a_of_type_JavaNioFloatBuffer);
      l1 = SystemClock.elapsedRealtimeNanos();
      l4 = System.currentTimeMillis();
      paramInt1 = this.jdField_b_of_type_Int / 4;
      paramInt2 = (int)(this.jdField_a_of_type_Int * 1.5D);
      a(this.i, paramInt1, paramInt2, this.jdField_b_of_type_ArrayOfByte);
      if (QLog.isColorLevel())
      {
        l2 = SystemClock.elapsedRealtimeNanos();
        l5 = System.currentTimeMillis();
        l3 = l4 - l3;
        l6 = l1 - l6;
        l4 = l5 - l4;
        l1 = l2 - l1;
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "i420 ray debug postRender ,totalCostM=" + (l3 + l4) + ",shaderCostM=" + l3 + ",readPixelCostM=" + l4 + ",totalCostNano=" + (l6 + l1) + ",shaderCostNano=" + l6 + ",readPixelCostNano=" + l1);
      }
    }
    for (;;)
    {
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, paramlfc.jdField_a_of_type_Int, paramlfc.jdField_b_of_type_Int);
      lfn locallfn = null;
      if (!this.jdField_c_of_type_Boolean)
      {
        paramlfc.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        paramlfc.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        paramlfc.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        paramlfc.jdField_c_of_type_Int = 21;
        if (this.jdField_a_of_type_Boolean)
        {
          paramlfc.jdField_c_of_type_Int = 100;
          paramlfc.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
        }
        paramlfc.jdField_d_of_type_Int = ((paramlfc.jdField_d_of_type_Int - a(paramlfc.jdField_a_of_type_Boolean) - 1 + 4) % 4);
        locallfn = new lfn(paramlfc, paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramShort1, paramShort2);
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "postRender  frame.format = " + paramlfc.jdField_c_of_type_Int);
      }
      this.jdField_c_of_type_Boolean = false;
      return locallfn;
      l6 = SystemClock.elapsedRealtimeNanos();
      l3 = System.currentTimeMillis();
      a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramInt1, this.h, this.jdField_a_of_type_JavaNioFloatBuffer);
      l1 = SystemClock.elapsedRealtimeNanos();
      l4 = System.currentTimeMillis();
      a(this.h, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
      if (QLog.isColorLevel())
      {
        l2 = SystemClock.elapsedRealtimeNanos();
        l5 = System.currentTimeMillis();
        l3 = l4 - l3;
        l6 = l1 - l6;
        l4 = l5 - l4;
        l1 = l2 - l1;
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "yuva ray debug postRender ,totalCostM=" + (l3 + l4) + ",shaderCostM=" + l3 + ",readPixelCostM=" + l4 + ",totalCostNano=" + (l6 + l1) + ",shaderCostNano=" + l6 + ",readPixelCostNano=" + l1);
      }
    }
  }
  
  public lfn a(lfc paramlfc, FilterDesc paramFilterDesc, VideoMaterial paramVideoMaterial, boolean paramBoolean1, boolean paramBoolean2, PendantItem paramPendantItem, lfi paramlfi)
  {
    if (this.jdField_a_of_type_Lfo != null) {
      this.jdField_a_of_type_Lfo.a();
    }
    if (this.jdField_a_of_type_Mhe != null) {
      this.jdField_a_of_type_Mhe.b();
    }
    long l1 = System.currentTimeMillis();
    b(0L, paramlfc.jdField_b_of_type_Int, paramlfc.jdField_a_of_type_Int);
    int n = paramlfc.jdField_a_of_type_Int;
    int i1 = paramlfc.jdField_b_of_type_Int;
    byte[] arrayOfByte = paramlfc.jdField_a_of_type_ArrayOfByte;
    int i2 = a(paramlfc.jdField_a_of_type_Boolean);
    if ((paramBoolean1) || (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.c())) {}
    int m;
    for (boolean bool2 = true;; bool2 = false)
    {
      m = this.jdField_a_of_type_Lfa.a("BEAUTY_SKIN");
      this.jdField_a_of_type_Lfv.a(this.jdField_a_of_type_JavaLangString, paramlfc.jdField_c_of_type_Long, n, i1, paramlfc.jdField_d_of_type_Int, paramBoolean1, paramFilterDesc, paramVideoMaterial, paramPendantItem, paramlfc, m);
      if ((this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int != 0) && (arrayOfByte != null) && (this.f != -1) && (this.jdField_e_of_type_Boolean)) {
        break;
      }
      return null;
    }
    this.jdField_d_of_type_Boolean = true;
    mgh localmgh = paramlfc.jdField_a_of_type_Mgh;
    if (localmgh != null) {
      localmgh.a(i2);
    }
    this.jdField_a_of_type_Lfl.a(n, i1);
    if (this.jdField_a_of_type_Lfo != null)
    {
      this.jdField_a_of_type_Lfo.c();
      this.jdField_a_of_type_Lfo.a(this, 0, arrayOfByte, -1, -1);
    }
    boolean bool1;
    if (this.jdField_a_of_type_Lez != null)
    {
      this.jdField_a_of_type_Lez.a(m);
      if (this.jdField_a_of_type_Lev != null) {
        this.jdField_a_of_type_Lev.a(null);
      }
      bool1 = this.jdField_a_of_type_Lez.a(m);
      paramBoolean1 = false;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mhe != null) {
        this.jdField_a_of_type_Mhe.a("checkLowLight");
      }
      a(arrayOfByte, paramlfc.jdField_a_of_type_Long, paramlfc.jdField_a_of_type_Boolean);
      if (localmgh != null) {
        localmgh.e();
      }
      if (this.jdField_a_of_type_Mhe != null) {
        this.jdField_a_of_type_Mhe.b("checkLowLight");
      }
      if (this.jdField_a_of_type_Lez != null)
      {
        if (this.jdField_a_of_type_Mhe != null) {
          this.jdField_a_of_type_Mhe.a("applyBeauty20");
        }
        paramlfc.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Lez.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, arrayOfByte, paramFilterDesc, m);
        if (paramlfc.jdField_a_of_type_ArrayOfByte != arrayOfByte) {
          this.l |= 0x8;
        }
        if (localmgh != null) {
          if (paramlfc.jdField_a_of_type_ArrayOfByte == arrayOfByte) {
            break label694;
          }
        }
      }
      label694:
      for (boolean bool3 = true;; bool3 = false)
      {
        localmgh.a(bool3);
        if (this.jdField_a_of_type_Mhe != null) {
          this.jdField_a_of_type_Mhe.b("applyBeauty20");
        }
        if (this.jdField_a_of_type_Lfo != null) {
          this.jdField_a_of_type_Lfo.a(this, 11, paramlfc.jdField_a_of_type_ArrayOfByte, -1, -1);
        }
        if (((paramFilterDesc != null) || (paramVideoMaterial != null) || (bool2) || (bool1) || (paramBoolean1) || (this.jdField_b_of_type_Boolean)) && (lfi.a()) && (kys.b())) {
          break label700;
        }
        paramlfc.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        paramlfc.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_Lfo != null)
        {
          this.jdField_a_of_type_Lfo.a(this, 5, paramlfc.jdField_a_of_type_ArrayOfByte, -1, -1);
          this.jdField_a_of_type_Lfo.d();
        }
        this.jdField_d_of_type_Boolean = false;
        paramlfc.f = ((int)(System.currentTimeMillis() - l1));
        paramlfc.g = this.l;
        if (this.jdField_a_of_type_JavaNioByteBuffer != null) {
          this.jdField_a_of_type_JavaNioByteBuffer.clear();
        }
        this.jdField_a_of_type_JavaNioByteBuffer = null;
        this.jdField_a_of_type_ArrayOfByte = null;
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_b_of_type_ArrayOfByte = null;
        }
        if (this.jdField_a_of_type_Mhe != null) {
          this.jdField_a_of_type_Mhe.a(paramlfc.jdField_c_of_type_Long);
        }
        lif.a().a(this.l);
        return new lfn(paramlfc, null, null, null, (short)0, (short)0);
        if (this.jdField_a_of_type_Lev == null) {
          break label2045;
        }
        paramBoolean1 = this.jdField_a_of_type_Lev.a(this.jdField_a_of_type_Lfa);
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
        if (this.jdField_a_of_type_Mhe != null) {
          this.jdField_a_of_type_Mhe.a("preRender");
        }
        a(paramlfc);
        if (this.jdField_b_of_type_Lfs != null) {
          break label1990;
        }
        this.jdField_b_of_type_Lfs = lfs.a(this.f, this.jdField_e_of_type_Int);
        label835:
        if (this.jdField_a_of_type_Mhe != null) {
          this.jdField_a_of_type_Mhe.b("preRender");
        }
        if (this.jdField_a_of_type_Lfo != null)
        {
          this.jdField_a_of_type_Lfo.a(9, this.f, this.jdField_e_of_type_Int);
          this.jdField_a_of_type_Lfo.a(10, this.h, this.g);
          this.jdField_a_of_type_Lfo.a(this, 1, paramlfc.jdField_a_of_type_ArrayOfByte, this.f, this.jdField_e_of_type_Int);
        }
        e();
        if (a())
        {
          if (this.jdField_a_of_type_Mhe != null) {
            this.jdField_a_of_type_Mhe.a("appleVideoDenoise");
          }
          this.jdField_b_of_type_Lfs = a(this.jdField_a_of_type_Lfs);
          if (localmgh != null)
          {
            if (this.jdField_b_of_type_Lfs.jdField_b_of_type_Int == this.jdField_a_of_type_Lfs.jdField_b_of_type_Int) {
              break label2015;
            }
            bool1 = true;
            label979:
            localmgh.b(bool1);
          }
          if (this.jdField_a_of_type_Mhe != null) {
            this.jdField_a_of_type_Mhe.b("appleVideoDenoise");
          }
          a(6, null, this.jdField_a_of_type_Lfs, this.jdField_b_of_type_Lfs);
        }
        e();
        if (a(paramlfc.jdField_a_of_type_Boolean))
        {
          if (this.jdField_a_of_type_Mhe != null) {
            this.jdField_a_of_type_Mhe.a("appleLowlightEnhance");
          }
          this.jdField_b_of_type_Lfs = a(this.jdField_a_of_type_Lfs, paramlfc.jdField_a_of_type_Boolean);
          if (this.jdField_a_of_type_Mhe != null) {
            this.jdField_a_of_type_Mhe.b("appleLowlightEnhance");
          }
          a(7, null, this.jdField_a_of_type_Lfs, this.jdField_b_of_type_Lfs);
        }
        GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(this.jdField_a_of_type_ArrayOfInt);
        if (localmgh != null)
        {
          if (this.jdField_b_of_type_Lfs.jdField_b_of_type_Int == this.jdField_a_of_type_Lfs.jdField_b_of_type_Int) {
            break label2021;
          }
          bool1 = true;
          label1133:
          localmgh.c(bool1);
        }
        e();
        if (this.jdField_a_of_type_Lez != null)
        {
          if (this.jdField_a_of_type_Mhe != null) {
            this.jdField_a_of_type_Mhe.a("applyBeauty30");
          }
          this.jdField_b_of_type_Lfs = this.jdField_a_of_type_Lez.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Lfs, paramFilterDesc, m);
          if (this.jdField_b_of_type_Lfs.jdField_b_of_type_Int != this.jdField_a_of_type_Lfs.jdField_b_of_type_Int) {
            this.l |= 0x8;
          }
          if (localmgh != null)
          {
            if (this.jdField_b_of_type_Lfs.jdField_b_of_type_Int == this.jdField_a_of_type_Lfs.jdField_b_of_type_Int) {
              break label2027;
            }
            bool1 = true;
            label1247:
            localmgh.d(bool1);
          }
          if (this.jdField_a_of_type_Mhe != null) {
            this.jdField_a_of_type_Mhe.b("applyBeauty30");
          }
          a(8, null, this.jdField_a_of_type_Lfs, this.jdField_b_of_type_Lfs);
        }
        e();
        if ((this.jdField_a_of_type_Lev != null) && ((paramBoolean1) || (paramFilterDesc != null) || (paramPendantItem != null) || (paramVideoMaterial != null) || (bool2)))
        {
          if (this.jdField_a_of_type_Mhe != null) {
            this.jdField_a_of_type_Mhe.a("drawFrameInGL");
          }
          this.jdField_a_of_type_Lev.a(paramFilterDesc);
          this.jdField_a_of_type_Lev.a(paramPendantItem, paramVideoMaterial);
          this.jdField_a_of_type_Lev.a(bool2);
          this.jdField_a_of_type_Lev.c(this.f, this.jdField_e_of_type_Int);
          this.jdField_b_of_type_Lfs = lfs.a(this.jdField_a_of_type_Lfs.jdField_a_of_type_Int, this.jdField_a_of_type_Lfs.jdField_b_of_type_Int);
          this.jdField_b_of_type_Lfs.jdField_b_of_type_Int = this.jdField_a_of_type_Lev.a(this.jdField_a_of_type_Lfs.jdField_b_of_type_Int, false, this.jdField_a_of_type_Lfl, paramBoolean2);
          if (this.jdField_a_of_type_Lev.a()) {
            this.l |= 0x80;
          }
          if (paramFilterDesc != null) {
            this.l |= 0x10;
          }
          if ((paramPendantItem != null) || (paramVideoMaterial != null)) {
            this.l |= 0x20;
          }
          if (this.jdField_a_of_type_Lev.b()) {
            this.l |= 0x40;
          }
          if (paramBoolean1) {
            this.l |= 0x8;
          }
          if (this.jdField_a_of_type_Mhe != null) {
            this.jdField_a_of_type_Mhe.b("drawFrameInGL");
          }
          if (localmgh != null)
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
        localmgh.a(paramBoolean2, bool1, bool2, paramBoolean1);
        a(2, null, this.jdField_a_of_type_Lfs, this.jdField_b_of_type_Lfs);
        if ((bool2) || (paramVideoMaterial != null))
        {
          if (this.jdField_a_of_type_Mhe != null) {
            this.jdField_a_of_type_Mhe.a("faceDetect");
          }
          if ((this.jdField_a_of_type_Lfl.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.c()))
          {
            if ((this.jdField_a_of_type_Lfl.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_Lfl.jdField_a_of_type_JavaUtilList.size() > 0) && (this.jdField_a_of_type_Lfl.jdField_a_of_type_ArrayOfFloat != null) && (this.jdField_a_of_type_Lfl.jdField_a_of_type_ArrayOfFloat.length > 0)) {
              this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(this.jdField_a_of_type_Lfl.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Lfl.jdField_a_of_type_ArrayOfFloat);
            }
            this.jdField_a_of_type_ComTencentAvRedpacketAVRedPacketManager.a(this.jdField_e_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          }
          if (this.jdField_a_of_type_Lev != null) {
            this.jdField_a_of_type_Lev.a(paramlfi, this.jdField_a_of_type_Lfl);
          }
          if (this.jdField_a_of_type_Mhe != null) {
            this.jdField_a_of_type_Mhe.b("faceDetect");
          }
        }
        if (this.jdField_a_of_type_Mhe != null) {
          this.jdField_a_of_type_Mhe.a("postRender");
        }
        paramFilterDesc = a(paramlfc, this.jdField_b_of_type_Lfs.jdField_b_of_type_Int, this.jdField_b_of_type_Lfs.jdField_a_of_type_Int, this.jdField_a_of_type_Lfl.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Lfl.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Lfl.c, this.jdField_a_of_type_Lfl.jdField_a_of_type_Short, this.jdField_a_of_type_Lfl.jdField_b_of_type_Short);
        if (this.jdField_a_of_type_Mhe != null) {
          this.jdField_a_of_type_Mhe.b("postRender");
        }
        if ((paramFilterDesc != null) && (this.jdField_a_of_type_Lfo != null))
        {
          this.jdField_a_of_type_Lfo.a(this, 4, null, this.h, this.g);
          this.jdField_a_of_type_Lfo.d();
        }
        this.jdField_d_of_type_Boolean = false;
        if (paramFilterDesc != null)
        {
          paramFilterDesc.f = ((int)(System.currentTimeMillis() - l1));
          paramFilterDesc.g = this.l;
        }
        if (this.jdField_a_of_type_Mhe != null) {
          this.jdField_a_of_type_Mhe.a(paramlfc.jdField_c_of_type_Long);
        }
        lif.a().a(this.l);
        return paramFilterDesc;
        n = n * i1 * 4;
        if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length == n)) {
          break;
        }
        this.jdField_a_of_type_ArrayOfByte = new byte[n];
        break;
        this.jdField_b_of_type_Lfs.jdField_a_of_type_Int = this.f;
        this.jdField_b_of_type_Lfs.jdField_b_of_type_Int = this.jdField_e_of_type_Int;
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
    if (this.jdField_a_of_type_Lfo != null) {
      this.jdField_a_of_type_Lfo.a();
    }
    this.jdField_a_of_type_Boolean = mhr.f();
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
    if (lfi.a()) {
      if (this.jdField_a_of_type_Lev == null)
      {
        boolean bool = AEFilterSupport.a();
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "initial, usePtuNew[" + bool + "]");
        }
        if (bool)
        {
          this.jdField_a_of_type_Lev = new lew(this.jdField_a_of_type_Lfx);
          this.jdField_a_of_type_Lev.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
      }
      else
      {
        if (!this.jdField_a_of_type_Lev.c()) {
          break label470;
        }
        if (this.jdField_a_of_type_Lez == null) {
          this.jdField_a_of_type_Lez = new lez();
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
      this.jdField_a_of_type_Lev = new lex(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Lfx);
      break;
      label470:
      if (this.jdField_a_of_type_Lez != null) {
        this.jdField_a_of_type_Lez.a();
      }
      this.jdField_a_of_type_Lez = null;
      break label389;
      this.jdField_a_of_type_Lez = new lez();
      break label389;
      label506:
      this.g = arrayOfInt[1];
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2) {}
  
  void a(lfc paramlfc)
  {
    a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, kzl.m, YUVTexture.jdField_a_of_type_ArrayOfFloat, paramlfc.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.f, a(paramlfc.jdField_a_of_type_Boolean), this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glViewport(0, 0, paramlfc.jdField_a_of_type_Int, paramlfc.jdField_b_of_type_Int);
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Lev != null) {
      this.jdField_a_of_type_Lev.c();
    }
  }
  
  void b(long paramLong)
  {
    if (this.jdField_a_of_type_Lev != null)
    {
      this.jdField_a_of_type_Lev.a(paramLong);
      return;
    }
    this.jdField_a_of_type_Lfx.a(paramLong);
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
      if (this.jdField_a_of_type_Lfo != null) {
        this.jdField_a_of_type_Lfo.b();
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
      if (this.jdField_a_of_type_Lez != null) {
        this.jdField_a_of_type_Lez.b();
      }
      if (this.jdField_a_of_type_Lev != null) {
        this.jdField_a_of_type_Lev.a();
      }
    } while (this.jdField_a_of_type_Mhe == null);
    this.jdField_a_of_type_Mhe.a();
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
      if (this.jdField_a_of_type_Lez != null)
      {
        this.jdField_a_of_type_Lez.a();
        this.jdField_a_of_type_Lez = null;
      }
      if (this.jdField_a_of_type_Lev != null)
      {
        this.jdField_a_of_type_Lev.b();
        this.jdField_a_of_type_Lev = null;
      }
      this.jdField_a_of_type_Lfx.a(paramLong);
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
 * Qualified Name:     lfm
 * JD-Core Version:    0.7.0.1
 */