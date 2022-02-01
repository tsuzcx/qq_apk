import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@TargetApi(17)
public class lpq
{
  int jdField_a_of_type_Int = 0;
  protected Context a;
  final String jdField_a_of_type_JavaLangString = "FilterProcessRender_" + AudioHelper.b();
  protected FloatBuffer a;
  private lou jdField_a_of_type_Lou;
  private loz jdField_a_of_type_Loz;
  private lpa jdField_a_of_type_Lpa;
  private lpn jdField_a_of_type_Lpn;
  final lpp jdField_a_of_type_Lpp = new lpp();
  protected lpr a;
  protected lps a;
  protected lpx a;
  private lpy jdField_a_of_type_Lpy;
  protected lqb a;
  protected lqc a;
  private lqg jdField_a_of_type_Lqg = new lqg();
  protected final lqm a;
  protected msy a;
  protected boolean a;
  int jdField_b_of_type_Int = 0;
  protected lpx b;
  private boolean jdField_b_of_type_Boolean;
  int c = -1;
  int d = -1;
  private int e = 0;
  
  public lpq(Context paramContext, lpr paramlpr, lpa paramlpa)
  {
    this.jdField_a_of_type_Lqm = new lqm();
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Msy = new msy();
    }
    this.jdField_a_of_type_Lpr = paramlpr;
    this.jdField_a_of_type_Lpa = paramlpa;
    blfp.a();
    boem.a();
    this.jdField_a_of_type_Lqm.a = null;
    this.c = -1;
    lqj.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a();
    if (paramContext != null) {}
    for (this.jdField_a_of_type_Lqc = new lql(paramContext);; this.jdField_a_of_type_Lqc = new lqn())
    {
      this.jdField_a_of_type_Lqb = new lqo(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Lpn = new lpn(this);
      return;
    }
  }
  
  private void a(lpc paramlpc)
  {
    if (this.jdField_b_of_type_Lpx == null)
    {
      this.jdField_b_of_type_Lpx = lpx.a(this.d, this.c);
      if ((this.jdField_a_of_type_Lqc != null) && (!this.jdField_a_of_type_Lqc.a(paramlpc)))
      {
        this.jdField_a_of_type_Lqc.c();
        this.jdField_a_of_type_Lqc.b();
        this.jdField_a_of_type_Lqc = null;
        if (QLog.isDevelopLevel()) {
          QLog.i("SurfaceTag", 4, "preRender, not match frame.");
        }
      }
      if (this.jdField_a_of_type_Lqc == null)
      {
        if (!paramlpc.b()) {
          break label213;
        }
        this.jdField_a_of_type_Lqc = new lqn();
        this.jdField_a_of_type_Lqc.a();
        this.jdField_a_of_type_Lqc.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("SurfaceTag", 4, "preRender, new render for frame.");
      }
      if ((this.jdField_a_of_type_Lqc != null) && (this.jdField_a_of_type_Lqc.a(paramlpc)))
      {
        c();
        this.jdField_b_of_type_Lpx = this.jdField_a_of_type_Lqc.a(this, paramlpc, this.jdField_a_of_type_Lpx);
      }
      return;
      this.jdField_b_of_type_Lpx.jdField_a_of_type_Int = this.d;
      this.jdField_b_of_type_Lpx.jdField_b_of_type_Int = this.c;
      break;
      label213:
      if (paramlpc.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        this.jdField_a_of_type_Lqc = new lql(paramlpc.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
        this.jdField_a_of_type_Lqc.a();
        this.jdField_a_of_type_Lqc.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
    }
  }
  
  private void a(lpc paramlpc, lqh paramlqh, boolean paramBoolean1, msb parammsb, boolean paramBoolean2)
  {
    c();
    int j;
    int i;
    boolean bool1;
    if ((this.jdField_a_of_type_Lou != null) && ((paramBoolean2) || (paramlqh.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) || (paramlqh.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) || (paramlqh.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) || (paramBoolean1)))
    {
      if (this.jdField_a_of_type_Msy != null) {
        this.jdField_a_of_type_Msy.a("drawFrameInGL");
      }
      j = this.jdField_a_of_type_Int;
      i = this.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Lpn == null) {
        break label514;
      }
      this.jdField_a_of_type_Lpn.a(paramlpc, paramlqh, this.jdField_a_of_type_Lpx, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      lpp locallpp = this.jdField_a_of_type_Lpp;
      if (this.jdField_a_of_type_Lpn.jdField_b_of_type_Int == 0) {
        break label496;
      }
      bool1 = true;
      locallpp.jdField_a_of_type_Boolean = bool1;
      if ((this.jdField_a_of_type_Lpn.c != 1) && (this.jdField_a_of_type_Lpn.c != 2)) {
        break label514;
      }
      j = this.jdField_b_of_type_Int;
      i = this.jdField_a_of_type_Int;
    }
    label514:
    for (;;)
    {
      this.jdField_a_of_type_Lou.b(j, i);
      boolean bool3 = this.jdField_a_of_type_Lou.d();
      this.jdField_a_of_type_Lou.a(paramlqh.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      this.jdField_a_of_type_Lou.a(paramlqh.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramlqh.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
      this.jdField_a_of_type_Lou.a(paramBoolean1);
      this.jdField_a_of_type_Lou.c(this.d, this.c);
      this.jdField_b_of_type_Lpx = lpx.a(this.jdField_a_of_type_Lpx.jdField_a_of_type_Int, this.jdField_a_of_type_Lpx.jdField_b_of_type_Int);
      this.jdField_b_of_type_Lpx.jdField_b_of_type_Int = this.jdField_a_of_type_Lou.a(this.jdField_a_of_type_Lpx.jdField_b_of_type_Int, false, this.jdField_a_of_type_Lpp, paramlqh.jdField_b_of_type_Boolean);
      boolean bool4 = this.jdField_a_of_type_Lou.d();
      if (this.jdField_a_of_type_Lou.a()) {
        a(128);
      }
      if (paramlqh.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) {
        a(16);
      }
      if ((paramlqh.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) || (paramlqh.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null)) {
        a(32);
      }
      if (this.jdField_a_of_type_Lou.b()) {
        a(64);
      }
      if (paramBoolean2) {
        a(8);
      }
      if (this.jdField_a_of_type_Msy != null) {
        this.jdField_a_of_type_Msy.b("drawFrameInGL");
      }
      if (parammsb != null)
      {
        if (paramlqh.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc == null) {
          break label502;
        }
        bool1 = true;
        label414:
        if (paramlqh.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) {
          break label508;
        }
      }
      label496:
      label502:
      label508:
      for (boolean bool2 = true;; bool2 = false)
      {
        parammsb.a(bool1, bool2, paramBoolean1, paramBoolean2);
        a(2, this.jdField_a_of_type_Lpx, this.jdField_b_of_type_Lpx);
        if (this.jdField_a_of_type_Lpn != null) {
          this.jdField_a_of_type_Lpn.a(this.jdField_b_of_type_Lpx, bool3, bool4, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        }
        if (this.jdField_a_of_type_Lpn != null) {
          this.jdField_a_of_type_Lpn.a(paramlpc, paramlqh);
        }
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label414;
      }
    }
  }
  
  private void a(lpc paramlpc, lqi paramlqi, long paramLong)
  {
    if (this.jdField_a_of_type_Lqb != null) {
      this.jdField_a_of_type_Lqb.a(this, paramlpc, this.jdField_b_of_type_Lpx, this.jdField_a_of_type_Lpp, paramlqi);
    }
    this.jdField_b_of_type_Boolean = false;
    if (paramlqi.a == null) {
      paramlqi.a = paramlpc;
    }
    long l = System.currentTimeMillis();
    paramlqi.a.f = ((int)(l - paramLong));
    paramlqi.a.g = this.e;
    if (this.jdField_a_of_type_Msy != null) {
      this.jdField_a_of_type_Msy.a(paramlpc.c);
    }
    lsw.a().a(this.e);
  }
  
  private void a(lqh paramlqh, lpj paramlpj, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramlqh.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null))
    {
      if (this.jdField_a_of_type_Msy != null) {
        this.jdField_a_of_type_Msy.a("faceDetect");
      }
      if (this.jdField_a_of_type_Lpr != null) {
        this.jdField_a_of_type_Lpr.a(this.jdField_a_of_type_Lpp, this.c, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_Lou != null) {
        this.jdField_a_of_type_Lou.a(paramlpj, this.jdField_a_of_type_Lpp);
      }
      if (this.jdField_a_of_type_Msy != null) {
        this.jdField_a_of_type_Msy.b("faceDetect");
      }
    }
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
    this.d = AVGLUtils.initFrameBuffer(paramInt1, paramInt2, this.c);
    if (this.jdField_a_of_type_Lqc != null) {
      this.jdField_a_of_type_Lqc.a(paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_Lqb != null) {
      this.jdField_a_of_type_Lqb.a(paramInt1, paramInt2);
    }
    d();
    blfp.a();
  }
  
  private void b(lpc paramlpc, lqi paramlqi, long paramLong)
  {
    paramlpc.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    paramlpc.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Lps != null)
    {
      this.jdField_a_of_type_Lps.a(this, 5, paramlpc, null);
      this.jdField_a_of_type_Lps.d();
    }
    this.jdField_b_of_type_Boolean = false;
    paramlpc.f = ((int)(System.currentTimeMillis() - paramLong));
    paramlpc.g = this.e;
    if (this.jdField_a_of_type_Lqc != null) {
      this.jdField_a_of_type_Lqc.b();
    }
    if (this.jdField_a_of_type_Lqb != null) {
      this.jdField_a_of_type_Lqb.b();
    }
    if (this.jdField_a_of_type_Msy != null) {
      this.jdField_a_of_type_Msy.a(paramlpc.c);
    }
    lsw.a().a(this.e);
    paramlqi.a(paramlpc, null, null, null, (short)0, (short)0);
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
  
  void a()
  {
    if (this.jdField_a_of_type_Lou != null) {
      this.jdField_a_of_type_Lou.c();
    }
  }
  
  protected void a(int paramInt)
  {
    this.e |= paramInt;
  }
  
  public void a(int paramInt, lpx paramlpx1, lpx paramlpx2)
  {
    if ((this.jdField_a_of_type_Lps != null) && (this.jdField_a_of_type_Lps.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Lps.a(this, paramInt, null, paramlpx2);
      this.jdField_a_of_type_Lps.a(paramInt, paramlpx2.jdField_a_of_type_Int, paramlpx2.jdField_b_of_type_Int);
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, String.format("%s, fbo[%s --> %s], textureid[%s --> %s]", new Object[] { lps.a(paramInt), Integer.valueOf(paramlpx1.jdField_a_of_type_Int), Integer.valueOf(paramlpx2.jdField_a_of_type_Int), Integer.valueOf(paramlpx1.jdField_b_of_type_Int), Integer.valueOf(paramlpx2.jdField_b_of_type_Int) }));
      }
    }
  }
  
  void a(long paramLong)
  {
    if (this.jdField_a_of_type_Lou != null)
    {
      this.jdField_a_of_type_Lou.a(paramLong);
      return;
    }
    this.jdField_a_of_type_Lqm.a(paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (AudioHelper.f()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "initial, szie[" + this.jdField_a_of_type_Int + ", " + this.jdField_b_of_type_Int + "], id[" + this.c + "], seq[" + paramLong + "]");
    }
    if (this.jdField_a_of_type_Lps != null) {
      this.jdField_a_of_type_Lps.a();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    if (this.c != -1) {
      return;
    }
    if (lpk.b())
    {
      if (this.jdField_a_of_type_Lou == null)
      {
        this.jdField_a_of_type_Lou = new lov(this.jdField_a_of_type_Lqm, paramInt);
        this.jdField_a_of_type_Lou.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_Lou.c()) {
        if (this.jdField_a_of_type_Loz == null) {
          this.jdField_a_of_type_Loz = new loz();
        }
      }
    }
    for (;;)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
      this.c = arrayOfInt[0];
      if (this.jdField_a_of_type_Lqc != null) {
        this.jdField_a_of_type_Lqc.a();
      }
      if (this.jdField_a_of_type_Lqb != null) {
        this.jdField_a_of_type_Lqb.a();
      }
      this.e = 0;
      if (this.jdField_a_of_type_Lpn == null) {
        break;
      }
      this.jdField_a_of_type_Lpn.a();
      return;
      if (this.jdField_a_of_type_Loz != null) {
        this.jdField_a_of_type_Loz.a();
      }
      this.jdField_a_of_type_Loz = null;
      continue;
      this.jdField_a_of_type_Loz = new loz();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(lpc paramlpc, lqh paramlqh, lpj paramlpj, lqi paramlqi)
  {
    if (this.jdField_a_of_type_Lps != null) {
      this.jdField_a_of_type_Lps.a();
    }
    if (this.jdField_a_of_type_Msy != null) {
      this.jdField_a_of_type_Msy.b();
    }
    long l = System.currentTimeMillis();
    paramlqi.a = paramlpc;
    b(0L, paramlpc.jdField_b_of_type_Int, paramlpc.jdField_a_of_type_Int);
    int i = paramlpc.jdField_a_of_type_Int;
    int k = paramlpc.jdField_b_of_type_Int;
    int m = lqj.a(paramlpc.jdField_a_of_type_Boolean);
    boolean bool1 = paramlqh.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Lpr != null) {
      bool1 |= this.jdField_a_of_type_Lpr.a();
    }
    for (;;)
    {
      int j = this.jdField_a_of_type_Lpa.a("BEAUTY_SKIN");
      this.jdField_a_of_type_Lqg.a(this.jdField_a_of_type_JavaLangString, paramlpc.c, i, k, paramlpc.d, paramlqh.jdField_a_of_type_Boolean, paramlqh.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, paramlqh.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial, paramlqh.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramlpc, j);
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0) || (paramlpc.a()) || (this.d == -1) || (!this.jdField_a_of_type_Boolean)) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      msb localmsb = paramlpc.jdField_a_of_type_Msb;
      if (localmsb != null) {
        localmsb.a(m);
      }
      this.jdField_a_of_type_Lpp.a(i, k);
      if ((paramlpc.b()) && (this.jdField_a_of_type_Lps != null))
      {
        this.jdField_a_of_type_Lps.c();
        this.jdField_a_of_type_Lps.a(this, 0, paramlpc, null);
      }
      boolean bool4 = false;
      boolean bool3 = false;
      boolean bool2;
      if (this.jdField_a_of_type_Loz != null)
      {
        this.jdField_a_of_type_Loz.a(j);
        if (this.jdField_a_of_type_Lou != null) {
          this.jdField_a_of_type_Lou.a(null);
        }
        bool2 = this.jdField_a_of_type_Loz.a(j);
        if ((paramlqh.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc == null) && (paramlqh.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null)) {
          break label503;
        }
        i = 1;
        label325:
        boolean bool5 = false;
        bool4 = bool5;
        if (paramlpc.b())
        {
          bool4 = bool5;
          if (this.jdField_a_of_type_Lpy != null)
          {
            this.jdField_a_of_type_Lpy.a(this.jdField_a_of_type_Msy, paramlpc, localmsb);
            bool4 = this.jdField_a_of_type_Lpy.jdField_a_of_type_Boolean;
          }
        }
        if ((paramlpc.b()) && (this.jdField_a_of_type_Loz != null)) {
          this.jdField_a_of_type_Loz.a(this, this.jdField_a_of_type_Msy, paramlpc, localmsb, paramlqh, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, j);
        }
        if ((i == 0) && (!bool1) && (!bool2) && (!bool3) && (!bool4)) {
          break label509;
        }
        i = 1;
      }
      for (;;)
      {
        if ((!paramlqh.c) || (i == 0))
        {
          if (paramlpc.b())
          {
            b(paramlpc, paramlqi, l);
            return;
            bool2 = bool4;
            if (this.jdField_a_of_type_Lou == null) {
              break;
            }
            bool3 = this.jdField_a_of_type_Lou.a(this.jdField_a_of_type_Lpa);
            bool2 = bool4;
            break;
            label503:
            i = 0;
            break label325;
            label509:
            i = 0;
            continue;
          }
          a(paramlpc);
          a(paramlpc, paramlqi, l);
          return;
        }
      }
      a(paramlpc);
      if ((paramlpc.b()) && (this.jdField_a_of_type_Lpy != null)) {
        this.jdField_a_of_type_Lpy.a(this.jdField_a_of_type_Msy, localmsb);
      }
      if ((paramlpc.b()) && (this.jdField_a_of_type_Lpy != null)) {
        this.jdField_a_of_type_Lpy.b(this.jdField_a_of_type_Msy, paramlpc, localmsb);
      }
      if ((paramlpc.b()) && (this.jdField_a_of_type_Loz != null)) {
        this.jdField_a_of_type_Loz.a(this, this.jdField_a_of_type_Msy, localmsb, paramlqh, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, j);
      }
      a(paramlpc, paramlqh, bool1, localmsb, bool3);
      a(paramlqh, paramlpj, bool1);
      a(paramlpc, paramlqi, l);
      return;
    }
  }
  
  void b()
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "uninit, mIsInited[" + this.jdField_a_of_type_Boolean + "], mIsRendering[" + this.jdField_b_of_type_Boolean + "], seq[" + l + "]");
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Lps != null) {
        this.jdField_a_of_type_Lps.b();
      }
      if (this.jdField_a_of_type_Lqb != null) {
        this.jdField_a_of_type_Lqb.b();
      }
      if (this.jdField_a_of_type_Lqc != null) {
        this.jdField_a_of_type_Lqc.b();
      }
      a(l);
      if (this.jdField_a_of_type_Loz != null) {
        this.jdField_a_of_type_Loz.b();
      }
      if (this.jdField_a_of_type_Lou != null) {
        this.jdField_a_of_type_Lou.a();
      }
    } while (this.jdField_a_of_type_Msy == null);
    this.jdField_a_of_type_Msy.a();
  }
  
  public void b(long paramLong)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "clear, seq[" + paramLong + "]");
    if (this.jdField_a_of_type_Lqc != null)
    {
      this.jdField_a_of_type_Lqc.b();
      this.jdField_a_of_type_Lqc.c();
    }
    if (this.d != -1)
    {
      GLES20.glDeleteFramebuffers(1, new int[] { this.d }, 0);
      this.d = -1;
    }
    if (this.c != -1)
    {
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.c;
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      this.c = -1;
    }
    if (this.jdField_a_of_type_Lqb != null) {
      this.jdField_a_of_type_Lqb.c();
    }
    if (this.jdField_a_of_type_Lpy != null)
    {
      this.jdField_a_of_type_Lpy.a();
      this.jdField_a_of_type_Lpy = null;
    }
    if (this.jdField_a_of_type_Loz != null)
    {
      this.jdField_a_of_type_Loz.a();
      this.jdField_a_of_type_Loz = null;
    }
    if (this.jdField_a_of_type_Lou != null)
    {
      this.jdField_a_of_type_Lou.b();
      this.jdField_a_of_type_Lou = null;
    }
    if (this.jdField_a_of_type_Lpn != null) {
      this.jdField_a_of_type_Lpn.b();
    }
    this.jdField_a_of_type_Lqm.a(paramLong);
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_Lpx != this.jdField_b_of_type_Lpx) && (this.jdField_a_of_type_Lpx != null))
    {
      this.jdField_a_of_type_Lpx.a();
      this.jdField_a_of_type_Lpx = null;
    }
    this.jdField_a_of_type_Lpx = this.jdField_b_of_type_Lpx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpq
 * JD-Core Version:    0.7.0.1
 */