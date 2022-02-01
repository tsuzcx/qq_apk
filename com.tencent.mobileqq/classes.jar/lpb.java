import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import android.os.Build;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.texture.YUVTexture;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.denoise.DenoiseRender;
import com.tencent.av.video.effect.lowlight.LowLightRender;
import com.tencent.av.video.effect.utils.LowLightUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.view.RendererUtils;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@TargetApi(17)
public class lpb
{
  private static Boolean jdField_a_of_type_JavaLangBoolean;
  static int i = -1;
  int jdField_a_of_type_Int = 0;
  protected Context a;
  private DenoiseRender jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  private LowLightRender jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender;
  final String jdField_a_of_type_JavaLangString = "FilterProcessRender_" + AudioHelper.b();
  private ByteBuffer jdField_a_of_type_JavaNioByteBuffer;
  private FloatBuffer jdField_a_of_type_JavaNioFloatBuffer;
  private log jdField_a_of_type_Log;
  private lom jdField_a_of_type_Lom;
  private lon jdField_a_of_type_Lon;
  final lpa jdField_a_of_type_Lpa = new lpa();
  protected lpc a;
  private lpe jdField_a_of_type_Lpe;
  private lpi jdField_a_of_type_Lpi;
  private lpk jdField_a_of_type_Lpk;
  private lpp jdField_a_of_type_Lpp = new lpp();
  protected final lps a;
  private msa jdField_a_of_type_Msa;
  protected boolean a;
  byte[] jdField_a_of_type_ArrayOfByte;
  private int[] jdField_a_of_type_ArrayOfInt = new int[8];
  int jdField_b_of_type_Int = 0;
  private lpi jdField_b_of_type_Lpi;
  private boolean jdField_b_of_type_Boolean = true;
  byte[] jdField_b_of_type_ArrayOfByte;
  int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = true;
  private byte[] jdField_c_of_type_ArrayOfByte;
  int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  int jdField_f_of_type_Int = -1;
  private boolean jdField_f_of_type_Boolean;
  int g = -1;
  int h = -1;
  private int j = -1;
  private int k = -1;
  private int l = 0;
  
  public lpb(Context paramContext, lpc paramlpc, lon paramlon)
  {
    this.jdField_a_of_type_Lps = new lps();
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Msa = new msa();
    }
    this.jdField_a_of_type_Lpc = paramlpc;
    this.jdField_a_of_type_Lon = paramlon;
    bkel.a();
    bndd.a();
    this.jdField_a_of_type_Lps.a = null;
    this.jdField_e_of_type_Int = -1;
    a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static int a(boolean paramBoolean)
  {
    int n = 1;
    if (i == -1)
    {
      lod locallod = lod.a();
      if (((locallod == null) || (!locallod.h())) && (!b())) {
        break label107;
      }
    }
    label107:
    for (i = 1;; i = 0)
    {
      QLog.i("Render", 1, "getFrameAngle, mInversion[" + i + "], manufacture[" + Build.MANUFACTURER + "], model[" + Build.MODEL + "]");
      int m = n;
      if (paramBoolean)
      {
        m = n;
        if (i != 1) {
          m = 3;
        }
      }
      return m;
    }
  }
  
  private lpd a(lop paramlop, lpi paramlpi, lpa paramlpa)
  {
    if (this.jdField_c_of_type_Boolean)
    {
      b(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramlpi.jdField_b_of_type_Int, this.j, this.jdField_a_of_type_JavaNioFloatBuffer);
      e();
    }
    for (;;)
    {
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glViewport(0, 0, paramlop.jdField_a_of_type_Int, paramlop.jdField_b_of_type_Int);
      paramlpi = null;
      if (!this.jdField_b_of_type_Boolean)
      {
        paramlop.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
        paramlop.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
        paramlop.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
        paramlop.jdField_c_of_type_Int = 21;
        if (this.jdField_c_of_type_Boolean)
        {
          paramlop.jdField_c_of_type_Int = 100;
          paramlop.jdField_a_of_type_ArrayOfByte = this.jdField_b_of_type_ArrayOfByte;
        }
        paramlop.jdField_d_of_type_Int = ((paramlop.jdField_d_of_type_Int - a(paramlop.jdField_a_of_type_Boolean) - 1 + 4) % 4);
        paramlpi = new lpd(paramlop, paramlpa.jdField_a_of_type_ArrayOfByte, paramlpa.jdField_b_of_type_ArrayOfByte, paramlpa.jdField_c_of_type_ArrayOfByte, paramlpa.jdField_a_of_type_Short, paramlpa.jdField_b_of_type_Short);
      }
      this.jdField_b_of_type_Boolean = false;
      return paramlpi;
      a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, paramlpi.jdField_b_of_type_Int, this.h, this.jdField_a_of_type_JavaNioFloatBuffer);
      a(this.h, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, this.jdField_a_of_type_ArrayOfByte);
    }
  }
  
  private lpi a(lpi paramlpi)
  {
    if (!lpj.c()) {
      this.jdField_a_of_type_ArrayOfInt[3] = 0;
    }
    do
    {
      return paramlpi;
      if (!this.jdField_d_of_type_Boolean)
      {
        this.jdField_a_of_type_ArrayOfInt[3] = 0;
        return paramlpi;
      }
      localObject = a();
    } while (localObject == null);
    this.l |= 0x4;
    paramlpi = ((DenoiseRender)localObject).process(paramlpi.jdField_b_of_type_Int, paramlpi.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramlpi = lpi.a(paramlpi.getFbo(), paramlpi.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[3] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[5] += 1;
    return paramlpi;
  }
  
  private lpi a(lpi paramlpi, boolean paramBoolean)
  {
    if (!lpj.b()) {
      this.jdField_a_of_type_ArrayOfInt[0] = 0;
    }
    do
    {
      return paramlpi;
      if ((!this.jdField_d_of_type_Boolean) || (paramBoolean))
      {
        this.jdField_a_of_type_ArrayOfInt[0] = 0;
        return paramlpi;
      }
      localObject = a();
    } while (localObject == null);
    this.l |= 0x2;
    paramlpi = ((LowLightRender)localObject).process(paramlpi.jdField_b_of_type_Int, paramlpi.jdField_a_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    paramlpi = lpi.a(paramlpi.getFbo(), paramlpi.getTextureId());
    this.jdField_a_of_type_ArrayOfInt[0] = 1;
    Object localObject = this.jdField_a_of_type_ArrayOfInt;
    localObject[2] += 1;
    return paramlpi;
  }
  
  public static void a()
  {
    if (!loz.b()) {
      return;
    }
    VideoPrefsUtil.setMaterialMute(true);
  }
  
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    TextureProgram localTextureProgram = lqw.a(5);
    lqy[] arrayOflqy = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    lpy.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOflqy[4].jdField_a_of_type_Int, 0);
    GLES20.glUniform1f(arrayOflqy[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOflqy[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOflqy[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
    GLES20.glVertexAttribPointer(arrayOflqy[0].jdField_a_of_type_Int, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOflqy[0].jdField_a_of_type_Int);
    GLES20.glDrawArrays(5, 0, 4);
    GLES20.glBindFramebuffer(36160, 0);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    try
    {
      atwl.a(RendererUtils.saveTexture(paramInt1, paramInt2, paramInt3), paramString);
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
    paramArrayOfByte = lqw.a(1);
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
        break label553;
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
      label553:
      GLES20.glUniformMatrix4fv(paramByteBuffer[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate270, 0);
    }
  }
  
  private void a(int paramInt, byte[] paramArrayOfByte, lpi paramlpi1, lpi paramlpi2)
  {
    if ((this.jdField_a_of_type_Lpe != null) && (this.jdField_a_of_type_Lpe.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Lpe.a(this, paramInt, paramArrayOfByte, paramlpi2.jdField_a_of_type_Int, paramlpi2.jdField_b_of_type_Int);
      this.jdField_a_of_type_Lpe.a(paramInt, paramlpi2.jdField_a_of_type_Int, paramlpi2.jdField_b_of_type_Int);
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, String.format("%s, fbo[%s --> %s], textureid[%s --> %s]", new Object[] { lpe.a(paramInt), Integer.valueOf(paramlpi1.jdField_a_of_type_Int), Integer.valueOf(paramlpi2.jdField_a_of_type_Int), Integer.valueOf(paramlpi1.jdField_b_of_type_Int), Integer.valueOf(paramlpi2.jdField_b_of_type_Int) }));
      }
    }
  }
  
  private void a(lop paramlop)
  {
    a(this.jdField_b_of_type_Int, this.jdField_a_of_type_Int, liw.m, YUVTexture.a, paramlop.jdField_a_of_type_ArrayOfByte, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_f_of_type_Int, a(paramlop.jdField_a_of_type_Boolean), this.jdField_a_of_type_JavaNioByteBuffer, this.jdField_a_of_type_JavaNioFloatBuffer);
    GLES20.glViewport(0, 0, paramlop.jdField_a_of_type_Int, paramlop.jdField_b_of_type_Int);
  }
  
  private void a(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    int n = 0;
    int m = 0;
    if ((lpj.b()) || (lpj.c()))
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
      if ((!this.jdField_d_of_type_Boolean) && (bool))
      {
        if (!paramBoolean) {
          paramArrayOfByte[1] += 1;
        }
        paramArrayOfByte[4] += 1;
        lbc.a(this.jdField_a_of_type_JavaLangString, " This is the " + paramArrayOfByte[2] + " times open lowlightand the " + paramArrayOfByte[4] + " times open videodenoise");
        lbc.a(this.jdField_a_of_type_JavaLangString, " The LowlightInfo is: lowlight flag = " + paramArrayOfByte[0] + ", video denoise flag = " + paramArrayOfByte[3] + ", lowlight open times = " + paramArrayOfByte[1] + ", denoise open times = " + paramArrayOfByte[4] + ", average luma = " + paramArrayOfByte[6]);
      }
      paramArrayOfByte[6] = m;
      if (n == 0)
      {
        paramArrayOfByte[0] = 0;
        paramArrayOfByte[3] = 0;
        GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(paramArrayOfByte);
      }
      paramArrayOfByte[7] = ((int)paramLong);
      this.jdField_d_of_type_Boolean = bool;
      return;
    }
  }
  
  private boolean a()
  {
    if (!lpj.c()) {}
    while (!this.jdField_d_of_type_Boolean) {
      return false;
    }
    return true;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!lpj.b()) {}
    while ((!this.jdField_d_of_type_Boolean) || (paramBoolean)) {
      return false;
    }
    return true;
  }
  
  private static int[] a(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2, float paramFloat)
  {
    int[] arrayOfInt = new int[2];
    if (liw.k * liw.l * 3 / 2 != paramArrayOfByte.length)
    {
      lbc.e(paramString, "(AndroidCamera.PREVIEW_WIDTH * AndroidCamera.PREVIEW_HEIGHT * 3 / 2) != yuvData.length");
      return arrayOfInt;
    }
    try
    {
      paramString = LowLightUtils.DetectLowLight(paramArrayOfByte, paramInt1, liw.k, liw.l, 60, 0.75F);
      return paramString;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        QLog.i("FilterProcessRender", 1, "detectLowLightProcess", paramString);
        paramString = arrayOfInt;
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        QLog.i("FilterProcessRender", 1, "detectLowLightProcess", paramString);
        paramString = arrayOfInt;
      }
    }
  }
  
  static void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FloatBuffer paramFloatBuffer)
  {
    GLES20.glBindFramebuffer(36160, paramInt4);
    GLES20.glViewport(0, 0, paramInt2, paramInt1);
    TextureProgram localTextureProgram = lqw.a(6);
    lqy[] arrayOflqy = localTextureProgram.a();
    GLES20.glUseProgram(localTextureProgram.a());
    lpy.a(false);
    GLES20.glActiveTexture(33984);
    GLES20.glBindTexture(3553, paramInt3);
    GLES20.glUniform1i(arrayOflqy[4].jdField_a_of_type_Int, 0);
    GLES20.glUniform1f(arrayOflqy[2].jdField_a_of_type_Int, 1.0F);
    GLES20.glUniformMatrix4fv(arrayOflqy[1].jdField_a_of_type_Int, 1, false, AVGLUtils.matrixVRotate90, 0);
    GLES20.glUniformMatrix4fv(arrayOflqy[3].jdField_a_of_type_Int, 1, false, AVGLUtils.matrix, 0);
    GLES20.glUniform1f(arrayOflqy[7].jdField_a_of_type_Int, paramInt1);
    GLES20.glUniform1f(arrayOflqy[8].jdField_a_of_type_Int, paramInt2);
    GLES20.glVertexAttribPointer(arrayOflqy[0].jdField_a_of_type_Int, 2, 5126, false, 8, paramFloatBuffer);
    GLES20.glEnableVertexAttribArray(arrayOflqy[0].jdField_a_of_type_Int);
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
    this.jdField_f_of_type_Int = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.jdField_e_of_type_Int);
    if (this.jdField_c_of_type_Boolean) {
      this.j = AVGLUtils.initFrameBuffer(paramInt2, paramInt1, this.k);
    }
    for (;;)
    {
      f();
      bkel.a();
      if (this.jdField_a_of_type_Log == null) {
        break;
      }
      this.jdField_a_of_type_Log.b(paramInt1, paramInt2);
      return;
      this.h = AVGLUtils.initFrameBuffer(paramInt2, paramInt1, this.g);
    }
  }
  
  private static boolean b()
  {
    if (jdField_a_of_type_JavaLangBoolean == null) {}
    for (;;)
    {
      try
      {
        str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.isInversionWhenFaceDetect.name(), "0");
        try
        {
          if ("1".equals(str))
          {
            jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
            QLog.i("Render", 1, "isSpecialDevices, [" + jdField_a_of_type_JavaLangBoolean + "], manufacture[" + Build.MANUFACTURER + "], model[" + Build.MODEL + "], dpcValue[" + str + "]");
            return jdField_a_of_type_JavaLangBoolean.booleanValue();
          }
          if ((!"HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) || (!"TAH-AN00".equalsIgnoreCase(Build.MODEL))) {
            continue;
          }
          jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
          continue;
          QLog.i("Render", 1, "isSpecialDevices", localThrowable1);
        }
        catch (Throwable localThrowable1) {}
      }
      catch (Throwable localThrowable2)
      {
        String str = null;
        continue;
      }
      continue;
      jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
    }
  }
  
  private void d()
  {
    this.jdField_c_of_type_Boolean = msn.g();
    QLog.d(this.jdField_a_of_type_JavaLangString, 1, "initUseRBG2I420Switch useRGB2I420Shader = " + this.jdField_c_of_type_Boolean + ",yuvCenterTextureId = " + this.jdField_e_of_type_Int);
    if (this.jdField_c_of_type_Boolean)
    {
      String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.useRGB2I420ShaderCfg.name(), "1");
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "initUseRBG2I420Switch dpcValue = " + str);
      if (str.equals("0")) {
        this.jdField_c_of_type_Boolean = false;
      }
    }
    if (AudioHelper.a(21) == 1) {
      this.jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      QLog.d(this.jdField_a_of_type_JavaLangString, 1, "initUseRBG2I420Switch,after getDebugValue, initial useRGB2I420Shader = " + this.jdField_c_of_type_Boolean + ",yuvCenterTextureId = " + this.jdField_e_of_type_Int + ",Build.MODEL = " + Build.MODEL);
      return;
      if (AudioHelper.a(21) == 0) {
        this.jdField_c_of_type_Boolean = false;
      }
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "saveTexture2I420DataBuffer called");
    }
    Object localObject = ByteBuffer.wrap(this.jdField_b_of_type_ArrayOfByte);
    GLES20.glBindFramebuffer(36160, this.j);
    GLES20.glReadPixels(0, 0, this.jdField_b_of_type_Int * 2 / 8, this.jdField_a_of_type_Int, 6408, 5121, (Buffer)localObject);
    localObject = this.jdField_c_of_type_ArrayOfByte;
    ByteBuffer localByteBuffer = ByteBuffer.wrap((byte[])localObject);
    GLES20.glReadPixels(this.jdField_b_of_type_Int * 2 / 8, 0, this.jdField_b_of_type_Int * 1 / 8, this.jdField_a_of_type_Int, 6408, 5121, localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    System.arraycopy(localObject, 0, this.jdField_b_of_type_ArrayOfByte, this.jdField_b_of_type_Int * this.jdField_a_of_type_Int, localObject.length);
  }
  
  private void f()
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
  
  private void g()
  {
    if ((this.jdField_a_of_type_Lpi != this.jdField_b_of_type_Lpi) && (this.jdField_a_of_type_Lpi != null))
    {
      this.jdField_a_of_type_Lpi.a();
      this.jdField_a_of_type_Lpi = null;
    }
    this.jdField_a_of_type_Lpi = this.jdField_b_of_type_Lpi;
  }
  
  public DenoiseRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender = new DenoiseRender(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender.setUpdateRate(lpj.a());
    return this.jdField_a_of_type_ComTencentAvVideoEffectDenoiseDenoiseRender;
  }
  
  public LowLightRender a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender == null) {
      this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender = new LowLightRender(this.jdField_a_of_type_AndroidContentContext);
    }
    return this.jdField_a_of_type_ComTencentAvVideoEffectLowlightLowLightRender;
  }
  
  public lpd a(lop paramlop, lpq paramlpq, low paramlow)
  {
    if (this.jdField_a_of_type_Lpe != null) {
      this.jdField_a_of_type_Lpe.a();
    }
    if (this.jdField_a_of_type_Msa != null) {
      this.jdField_a_of_type_Msa.b();
    }
    long l1 = System.currentTimeMillis();
    b(0L, paramlop.jdField_b_of_type_Int, paramlop.jdField_a_of_type_Int);
    int i1 = paramlop.jdField_a_of_type_Int;
    int i2 = paramlop.jdField_b_of_type_Int;
    Object localObject2 = paramlop.jdField_a_of_type_ArrayOfByte;
    int n = a(paramlop.jdField_a_of_type_Boolean);
    boolean bool3 = paramlpq.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Lpc != null) {
      bool3 |= this.jdField_a_of_type_Lpc.a();
    }
    for (;;)
    {
      int m = this.jdField_a_of_type_Lon.a("BEAUTY_SKIN");
      this.jdField_a_of_type_Lpp.a(this.jdField_a_of_type_JavaLangString, paramlop.jdField_c_of_type_Long, i1, i2, paramlop.jdField_d_of_type_Int, paramlpq.jdField_a_of_type_Boolean, paramlpq.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, paramlpq.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial, paramlpq.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramlop, m);
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0) || (localObject2 == null) || (this.jdField_f_of_type_Int == -1) || (!this.jdField_a_of_type_Boolean)) {
        return null;
      }
      this.jdField_e_of_type_Boolean = true;
      Object localObject1 = paramlop.jdField_a_of_type_Mrd;
      if (localObject1 != null) {
        ((mrd)localObject1).a(n);
      }
      this.jdField_a_of_type_Lpa.a(i1, i2);
      if (this.jdField_a_of_type_Lpe != null)
      {
        this.jdField_a_of_type_Lpe.c();
        this.jdField_a_of_type_Lpe.a(this, 0, (byte[])localObject2, -1, -1);
      }
      boolean bool2;
      boolean bool1;
      if (this.jdField_a_of_type_Lom != null)
      {
        this.jdField_a_of_type_Lom.a(m);
        if (this.jdField_a_of_type_Log != null) {
          this.jdField_a_of_type_Log.a(null);
        }
        bool2 = this.jdField_a_of_type_Lom.a(m);
        bool1 = false;
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Msa != null) {
          this.jdField_a_of_type_Msa.a("checkLowLight");
        }
        a((byte[])localObject2, paramlop.jdField_a_of_type_Long, paramlop.jdField_a_of_type_Boolean);
        if (localObject1 != null) {
          ((mrd)localObject1).e();
        }
        if (this.jdField_a_of_type_Msa != null) {
          this.jdField_a_of_type_Msa.b("checkLowLight");
        }
        if (this.jdField_a_of_type_Lom != null)
        {
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.a("applyBeauty20");
          }
          paramlop.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_Lom.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, (byte[])localObject2, paramlpq.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, m);
          if (paramlop.jdField_a_of_type_ArrayOfByte != localObject2) {
            this.l |= 0x8;
          }
          if (localObject1 != null) {
            if (paramlop.jdField_a_of_type_ArrayOfByte == localObject2) {
              break label716;
            }
          }
        }
        label716:
        for (boolean bool4 = true;; bool4 = false)
        {
          ((mrd)localObject1).a(bool4);
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.b("applyBeauty20");
          }
          if (this.jdField_a_of_type_Lpe != null) {
            this.jdField_a_of_type_Lpe.a(this, 11, paramlop.jdField_a_of_type_ArrayOfByte, -1, -1);
          }
          if (((paramlpq.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) || (paramlpq.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) || (bool3) || (bool2) || (bool1) || (this.jdField_d_of_type_Boolean)) && (paramlpq.jdField_c_of_type_Boolean)) {
            break label722;
          }
          paramlop.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
          paramlop.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
          if (this.jdField_a_of_type_Lpe != null)
          {
            this.jdField_a_of_type_Lpe.a(this, 5, paramlop.jdField_a_of_type_ArrayOfByte, -1, -1);
            this.jdField_a_of_type_Lpe.d();
          }
          this.jdField_e_of_type_Boolean = false;
          paramlop.jdField_f_of_type_Int = ((int)(System.currentTimeMillis() - l1));
          paramlop.g = this.l;
          if (this.jdField_a_of_type_JavaNioByteBuffer != null) {
            this.jdField_a_of_type_JavaNioByteBuffer.clear();
          }
          this.jdField_a_of_type_JavaNioByteBuffer = null;
          this.jdField_a_of_type_ArrayOfByte = null;
          if (this.jdField_c_of_type_Boolean)
          {
            this.jdField_b_of_type_ArrayOfByte = null;
            this.jdField_c_of_type_ArrayOfByte = null;
          }
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.a(paramlop.jdField_c_of_type_Long);
          }
          lsa.a().a(this.l);
          return new lpd(paramlop, null, null, null, (short)0, (short)0);
          if (this.jdField_a_of_type_Log == null) {
            break label2399;
          }
          bool1 = this.jdField_a_of_type_Log.a(this.jdField_a_of_type_Lon);
          bool2 = false;
          break;
        }
        label722:
        n = i1 * i2 * 3 / 2;
        label893:
        boolean bool6;
        label1037:
        label1191:
        boolean bool7;
        label1308:
        label1834:
        boolean bool5;
        if (this.jdField_c_of_type_Boolean)
        {
          if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != n)) {
            this.jdField_b_of_type_ArrayOfByte = new byte[n];
          }
          i1 = i1 * i2 * 1 / 2;
          if ((this.jdField_c_of_type_ArrayOfByte == null) || (this.jdField_c_of_type_ArrayOfByte.length != i1)) {
            this.jdField_c_of_type_ArrayOfByte = new byte[i1];
          }
          if ((this.jdField_a_of_type_JavaNioByteBuffer != null) && (this.jdField_a_of_type_JavaNioByteBuffer.capacity() != n))
          {
            this.jdField_a_of_type_JavaNioByteBuffer.clear();
            this.jdField_a_of_type_JavaNioByteBuffer = null;
          }
          if (this.jdField_a_of_type_JavaNioByteBuffer == null) {
            this.jdField_a_of_type_JavaNioByteBuffer = ByteBuffer.allocate(n);
          }
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.a("preRender");
          }
          a(paramlop);
          if (this.jdField_b_of_type_Lpi != null) {
            break label2294;
          }
          this.jdField_b_of_type_Lpi = lpi.a(this.jdField_f_of_type_Int, this.jdField_e_of_type_Int);
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.b("preRender");
          }
          if (this.jdField_a_of_type_Lpe != null)
          {
            this.jdField_a_of_type_Lpe.a(9, this.jdField_f_of_type_Int, this.jdField_e_of_type_Int);
            this.jdField_a_of_type_Lpe.a(10, this.h, this.g);
            this.jdField_a_of_type_Lpe.a(this, 1, paramlop.jdField_a_of_type_ArrayOfByte, this.jdField_f_of_type_Int, this.jdField_e_of_type_Int);
          }
          g();
          if (a())
          {
            if (this.jdField_a_of_type_Msa != null) {
              this.jdField_a_of_type_Msa.a("appleVideoDenoise");
            }
            this.jdField_b_of_type_Lpi = a(this.jdField_a_of_type_Lpi);
            if (localObject1 != null)
            {
              if (this.jdField_b_of_type_Lpi.jdField_b_of_type_Int == this.jdField_a_of_type_Lpi.jdField_b_of_type_Int) {
                break label2319;
              }
              bool2 = true;
              ((mrd)localObject1).b(bool2);
            }
            if (this.jdField_a_of_type_Msa != null) {
              this.jdField_a_of_type_Msa.b("appleVideoDenoise");
            }
            a(6, null, this.jdField_a_of_type_Lpi, this.jdField_b_of_type_Lpi);
          }
          g();
          if (a(paramlop.jdField_a_of_type_Boolean))
          {
            if (this.jdField_a_of_type_Msa != null) {
              this.jdField_a_of_type_Msa.a("appleLowlightEnhance");
            }
            this.jdField_b_of_type_Lpi = a(this.jdField_a_of_type_Lpi, paramlop.jdField_a_of_type_Boolean);
            if (this.jdField_a_of_type_Msa != null) {
              this.jdField_a_of_type_Msa.b("appleLowlightEnhance");
            }
            a(7, null, this.jdField_a_of_type_Lpi, this.jdField_b_of_type_Lpi);
          }
          GraphicRenderMgr.getInstance().setLowlightAndVideoDenoiseInfo(this.jdField_a_of_type_ArrayOfInt);
          if (localObject1 != null)
          {
            if (this.jdField_b_of_type_Lpi.jdField_b_of_type_Int == this.jdField_a_of_type_Lpi.jdField_b_of_type_Int) {
              break label2325;
            }
            bool2 = true;
            ((mrd)localObject1).c(bool2);
          }
          g();
          if (this.jdField_a_of_type_Lom != null)
          {
            if (this.jdField_a_of_type_Msa != null) {
              this.jdField_a_of_type_Msa.a("applyBeauty30");
            }
            this.jdField_b_of_type_Lpi = this.jdField_a_of_type_Lom.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Lpi, paramlpq.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, m);
            if (this.jdField_b_of_type_Lpi.jdField_b_of_type_Int != this.jdField_a_of_type_Lpi.jdField_b_of_type_Int) {
              this.l |= 0x8;
            }
            if (localObject1 != null)
            {
              if (this.jdField_b_of_type_Lpi.jdField_b_of_type_Int == this.jdField_a_of_type_Lpi.jdField_b_of_type_Int) {
                break label2331;
              }
              bool2 = true;
              ((mrd)localObject1).d(bool2);
            }
            if (this.jdField_a_of_type_Msa != null) {
              this.jdField_a_of_type_Msa.b("applyBeauty30");
            }
            a(8, null, this.jdField_a_of_type_Lpi, this.jdField_b_of_type_Lpi);
          }
          bool4 = false;
          bool2 = bool4;
          if (paramlpq.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null)
          {
            bool2 = bool4;
            if (paramlpq.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) {
              bool2 = paramlpq.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem.needHMirror;
            }
          }
          g();
          if ((this.jdField_a_of_type_Log != null) && ((bool1) || (paramlpq.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) || (paramlpq.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) || (paramlpq.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) || (bool3)))
          {
            if (this.jdField_a_of_type_Msa != null) {
              this.jdField_a_of_type_Msa.a("drawFrameInGL");
            }
            this.jdField_a_of_type_Lpa.jdField_a_of_type_Boolean = bool2;
            if ((bool2) && (this.jdField_a_of_type_Lpk != null))
            {
              if (this.jdField_a_of_type_Msa != null) {
                this.jdField_a_of_type_Msa.a("mirrorIn");
              }
              localObject2 = this.jdField_a_of_type_Lpk.a(this.jdField_a_of_type_Lpi, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
              if (localObject2 != null)
              {
                a(12, null, this.jdField_a_of_type_Lpi, (lpi)localObject2);
                this.jdField_a_of_type_Lpi.jdField_a_of_type_Int = ((lpi)localObject2).jdField_a_of_type_Int;
                this.jdField_a_of_type_Lpi.jdField_b_of_type_Int = ((lpi)localObject2).jdField_b_of_type_Int;
                ((lpi)localObject2).a();
              }
              if (this.jdField_a_of_type_Msa != null) {
                this.jdField_a_of_type_Msa.b("mirrorIn");
              }
            }
            bool6 = this.jdField_a_of_type_Log.d();
            this.jdField_a_of_type_Log.a(paramlpq.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
            this.jdField_a_of_type_Log.a(paramlpq.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramlpq.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
            this.jdField_a_of_type_Log.a(bool3);
            this.jdField_a_of_type_Log.c(this.jdField_f_of_type_Int, this.jdField_e_of_type_Int);
            this.jdField_b_of_type_Lpi = lpi.a(this.jdField_a_of_type_Lpi.jdField_a_of_type_Int, this.jdField_a_of_type_Lpi.jdField_b_of_type_Int);
            this.jdField_b_of_type_Lpi.jdField_b_of_type_Int = this.jdField_a_of_type_Log.a(this.jdField_a_of_type_Lpi.jdField_b_of_type_Int, false, this.jdField_a_of_type_Lpa, paramlpq.jdField_b_of_type_Boolean);
            bool7 = this.jdField_a_of_type_Log.d();
            if (this.jdField_a_of_type_Log.a()) {
              this.l |= 0x80;
            }
            if (paramlpq.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) {
              this.l |= 0x10;
            }
            if ((paramlpq.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) || (paramlpq.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null)) {
              this.l |= 0x20;
            }
            if (this.jdField_a_of_type_Log.b()) {
              this.l |= 0x40;
            }
            if (bool1) {
              this.l |= 0x8;
            }
            if (this.jdField_a_of_type_Msa != null) {
              this.jdField_a_of_type_Msa.b("drawFrameInGL");
            }
            if (localObject1 != null)
            {
              if (paramlpq.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc == null) {
                break label2337;
              }
              bool4 = true;
              if (paramlpq.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) {
                break label2343;
              }
              bool5 = true;
              label1844:
              ((mrd)localObject1).a(bool4, bool5, bool3, bool1);
            }
            a(2, null, this.jdField_a_of_type_Lpi, this.jdField_b_of_type_Lpi);
            if (this.jdField_a_of_type_Lpk == null) {
              break label2349;
            }
            m = 1;
            label1881:
            if (bool6 != bool7) {
              break label2361;
            }
            if ((m == 0) || (!this.jdField_f_of_type_Boolean)) {
              break label2355;
            }
            m = 1;
          }
        }
        for (;;)
        {
          if (m != 0)
          {
            if (this.jdField_a_of_type_Msa != null) {
              this.jdField_a_of_type_Msa.a("mirrorOut");
            }
            localObject1 = this.jdField_a_of_type_Lpk.a(this.jdField_b_of_type_Lpi, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
            if (localObject1 != null)
            {
              a(13, null, this.jdField_b_of_type_Lpi, (lpi)localObject1);
              this.jdField_b_of_type_Lpi.jdField_a_of_type_Int = ((lpi)localObject1).jdField_a_of_type_Int;
              this.jdField_b_of_type_Lpi.jdField_b_of_type_Int = ((lpi)localObject1).jdField_b_of_type_Int;
              ((lpi)localObject1).a();
            }
            if (this.jdField_a_of_type_Msa != null) {
              this.jdField_a_of_type_Msa.b("mirrorOut");
            }
          }
          this.jdField_f_of_type_Boolean = bool2;
          if ((bool3) || (paramlpq.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null))
          {
            if (this.jdField_a_of_type_Msa != null) {
              this.jdField_a_of_type_Msa.a("faceDetect");
            }
            if (this.jdField_a_of_type_Lpc != null) {
              this.jdField_a_of_type_Lpc.a(this.jdField_a_of_type_Lpa, this.jdField_e_of_type_Int, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
            }
            if (this.jdField_a_of_type_Log != null) {
              this.jdField_a_of_type_Log.a(paramlow, this.jdField_a_of_type_Lpa);
            }
            if (this.jdField_a_of_type_Msa != null) {
              this.jdField_a_of_type_Msa.b("faceDetect");
            }
          }
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.a("postRender");
          }
          paramlpq = a(paramlop, this.jdField_b_of_type_Lpi, this.jdField_a_of_type_Lpa);
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.b("postRender");
          }
          if ((paramlpq != null) && (this.jdField_a_of_type_Lpe != null))
          {
            this.jdField_a_of_type_Lpe.a(this, 4, null, this.h, this.g);
            this.jdField_a_of_type_Lpe.d();
          }
          this.jdField_e_of_type_Boolean = false;
          if (paramlpq != null)
          {
            paramlpq.jdField_f_of_type_Int = ((int)(System.currentTimeMillis() - l1));
            paramlpq.g = this.l;
          }
          if (this.jdField_a_of_type_Msa != null) {
            this.jdField_a_of_type_Msa.a(paramlop.jdField_c_of_type_Long);
          }
          lsa.a().a(this.l);
          return paramlpq;
          i1 = i1 * i2 * 4;
          if ((this.jdField_a_of_type_ArrayOfByte != null) && (this.jdField_a_of_type_ArrayOfByte.length == i1)) {
            break;
          }
          this.jdField_a_of_type_ArrayOfByte = new byte[i1];
          break;
          label2294:
          this.jdField_b_of_type_Lpi.jdField_a_of_type_Int = this.jdField_f_of_type_Int;
          this.jdField_b_of_type_Lpi.jdField_b_of_type_Int = this.jdField_e_of_type_Int;
          break label893;
          label2319:
          bool2 = false;
          break label1037;
          label2325:
          bool2 = false;
          break label1191;
          label2331:
          bool2 = false;
          break label1308;
          label2337:
          bool4 = false;
          break label1834;
          label2343:
          bool5 = false;
          break label1844;
          label2349:
          m = 0;
          break label1881;
          label2355:
          m = 0;
          continue;
          label2361:
          if ((!bool6) && (bool7))
          {
            if ((m != 0) && (bool2)) {
              m = 1;
            } else {
              m = 0;
            }
          }
          else {
            m = 0;
          }
        }
        label2399:
        bool1 = false;
        bool2 = false;
      }
    }
  }
  
  void a(long paramLong)
  {
    if (this.jdField_a_of_type_Log != null)
    {
      this.jdField_a_of_type_Log.a(paramLong);
      return;
    }
    this.jdField_a_of_type_Lps.a(paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (AudioHelper.f()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "initial, szie[" + this.jdField_a_of_type_Int + ", " + this.jdField_b_of_type_Int + "], id[" + this.jdField_e_of_type_Int + "], seq[" + paramLong + "]");
    }
    if (this.jdField_a_of_type_Lpe != null) {
      this.jdField_a_of_type_Lpe.a();
    }
    d();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_e_of_type_Boolean = false;
    if (this.jdField_e_of_type_Int != -1) {
      return;
    }
    label194:
    label241:
    int[] arrayOfInt;
    if (loz.b()) {
      if (this.jdField_a_of_type_Log == null)
      {
        boolean bool = AEFilterSupport.a();
        if (QLog.isColorLevel()) {
          QLog.i(this.jdField_a_of_type_JavaLangString, 2, "initial, usePtuNew[" + bool + "]");
        }
        if (bool)
        {
          this.jdField_a_of_type_Log = new loh(this.jdField_a_of_type_Lps, paramInt);
          this.jdField_a_of_type_Log.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
      }
      else
      {
        if (!this.jdField_a_of_type_Log.c()) {
          break label340;
        }
        if (this.jdField_a_of_type_Lom == null) {
          this.jdField_a_of_type_Lom = new lom();
        }
        arrayOfInt = new int[4];
        GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
        this.jdField_e_of_type_Int = arrayOfInt[0];
        this.jdField_c_of_type_Int = arrayOfInt[2];
        this.jdField_d_of_type_Int = arrayOfInt[3];
        if (!this.jdField_c_of_type_Boolean) {
          break label376;
        }
        this.k = arrayOfInt[1];
      }
    }
    for (;;)
    {
      this.l = 0;
      if (this.jdField_a_of_type_Lpk != null) {
        break;
      }
      this.jdField_a_of_type_Lpk = new lpk();
      return;
      this.jdField_a_of_type_Log = new loi(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Lps);
      break label194;
      label340:
      if (this.jdField_a_of_type_Lom != null) {
        this.jdField_a_of_type_Lom.a();
      }
      this.jdField_a_of_type_Lom = null;
      break label241;
      this.jdField_a_of_type_Lom = new lom();
      break label241;
      label376:
      this.g = arrayOfInt[1];
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2) {}
  
  void b()
  {
    if (this.jdField_a_of_type_Log != null) {
      this.jdField_a_of_type_Log.c();
    }
  }
  
  public void b(long paramLong)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "clear, seq[" + paramLong + "]");
    if (this.jdField_a_of_type_JavaNioByteBuffer != null)
    {
      this.jdField_a_of_type_JavaNioByteBuffer.clear();
      this.jdField_a_of_type_JavaNioByteBuffer = null;
    }
    if (this.jdField_f_of_type_Int != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.jdField_f_of_type_Int }, 0);
      this.jdField_f_of_type_Int = -1;
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
    if (this.jdField_c_of_type_Boolean)
    {
      arrayOfInt = new int[1];
      arrayOfInt[0] = this.k;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.k = -1;
      GLES20.glDeleteFramebuffers(1, new int[] { this.j }, 0);
      this.j = -1;
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
      if (this.jdField_a_of_type_Lom != null)
      {
        this.jdField_a_of_type_Lom.a();
        this.jdField_a_of_type_Lom = null;
      }
      if (this.jdField_a_of_type_Log != null)
      {
        this.jdField_a_of_type_Log.b();
        this.jdField_a_of_type_Log = null;
      }
      if (this.jdField_a_of_type_Lpk != null)
      {
        this.jdField_a_of_type_Lpk.a();
        this.jdField_a_of_type_Lpk = null;
      }
      this.jdField_a_of_type_Lps.a(paramLong);
      return;
      arrayOfInt = new int[1];
      arrayOfInt[0] = this.g;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.g = -1;
      GLES20.glDeleteFramebuffers(1, new int[] { this.h }, 0);
      this.h = -1;
    }
  }
  
  void c()
  {
    long l1 = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "uninit, mIsInited[" + this.jdField_a_of_type_Boolean + "], mIsRendering[" + this.jdField_e_of_type_Boolean + "], seq[" + l1 + "]");
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Lpe != null) {
        this.jdField_a_of_type_Lpe.b();
      }
      this.jdField_a_of_type_ArrayOfByte = null;
      if (this.jdField_c_of_type_Boolean)
      {
        this.jdField_b_of_type_ArrayOfByte = null;
        this.jdField_c_of_type_ArrayOfByte = null;
      }
      if (this.jdField_a_of_type_JavaNioByteBuffer != null)
      {
        this.jdField_a_of_type_JavaNioByteBuffer.clear();
        this.jdField_a_of_type_JavaNioByteBuffer = null;
      }
      a(l1);
      if (this.jdField_a_of_type_Lom != null) {
        this.jdField_a_of_type_Lom.b();
      }
      if (this.jdField_a_of_type_Log != null) {
        this.jdField_a_of_type_Log.a();
      }
    } while (this.jdField_a_of_type_Msa == null);
    this.jdField_a_of_type_Msa.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpb
 * JD-Core Version:    0.7.0.1
 */