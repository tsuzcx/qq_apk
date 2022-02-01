import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLES20;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.utils.AVGLUtils;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sveffects.SvEffectSdkInitor;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

@TargetApi(17)
public class loy
{
  int jdField_a_of_type_Int = 0;
  protected Context a;
  final String jdField_a_of_type_JavaLangString = "FilterProcessRender_" + AudioHelper.b();
  protected FloatBuffer a;
  private loc jdField_a_of_type_Loc;
  private loh jdField_a_of_type_Loh;
  private loi jdField_a_of_type_Loi;
  private lov jdField_a_of_type_Lov;
  final lox jdField_a_of_type_Lox = new lox();
  protected loz a;
  protected lpa a;
  protected lpf a;
  private lpg jdField_a_of_type_Lpg;
  protected lpj a;
  protected lpk a;
  private lpo jdField_a_of_type_Lpo = new lpo();
  protected final lpu a;
  protected msh a;
  protected boolean a;
  int jdField_b_of_type_Int = 0;
  protected lpf b;
  private boolean jdField_b_of_type_Boolean;
  int c = -1;
  int d = -1;
  private int e = 0;
  
  public loy(Context paramContext, loz paramloz, loi paramloi)
  {
    this.jdField_a_of_type_Lpu = new lpu();
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Msh = new msh();
    }
    this.jdField_a_of_type_Loz = paramloz;
    this.jdField_a_of_type_Loi = paramloi;
    SvEffectSdkInitor.init();
    bljd.a();
    this.jdField_a_of_type_Lpu.a = null;
    this.c = -1;
    lpr.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a();
    if (paramContext != null) {}
    for (this.jdField_a_of_type_Lpk = new lpt(paramContext);; this.jdField_a_of_type_Lpk = new lpv())
    {
      this.jdField_a_of_type_Lpj = new lpw(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Lov = new lov(this);
      return;
    }
  }
  
  private void a(lok paramlok)
  {
    if (this.jdField_b_of_type_Lpf == null)
    {
      this.jdField_b_of_type_Lpf = lpf.a(this.d, this.c);
      if ((this.jdField_a_of_type_Lpk != null) && (!this.jdField_a_of_type_Lpk.a(paramlok)))
      {
        this.jdField_a_of_type_Lpk.c();
        this.jdField_a_of_type_Lpk.b();
        this.jdField_a_of_type_Lpk = null;
        if (QLog.isDevelopLevel()) {
          QLog.i("SurfaceTag", 4, "preRender, not match frame.");
        }
      }
      if (this.jdField_a_of_type_Lpk == null)
      {
        if (!paramlok.b()) {
          break label213;
        }
        this.jdField_a_of_type_Lpk = new lpv();
        this.jdField_a_of_type_Lpk.a();
        this.jdField_a_of_type_Lpk.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("SurfaceTag", 4, "preRender, new render for frame.");
      }
      if ((this.jdField_a_of_type_Lpk != null) && (this.jdField_a_of_type_Lpk.a(paramlok)))
      {
        c();
        this.jdField_b_of_type_Lpf = this.jdField_a_of_type_Lpk.a(this, paramlok, this.jdField_a_of_type_Lpf);
      }
      return;
      this.jdField_b_of_type_Lpf.jdField_a_of_type_Int = this.d;
      this.jdField_b_of_type_Lpf.jdField_b_of_type_Int = this.c;
      break;
      label213:
      if (paramlok.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        this.jdField_a_of_type_Lpk = new lpt(paramlok.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
        this.jdField_a_of_type_Lpk.a();
        this.jdField_a_of_type_Lpk.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
    }
  }
  
  private void a(lok paramlok, lpp paramlpp, boolean paramBoolean1, mrk parammrk, boolean paramBoolean2)
  {
    boolean bool2 = true;
    c();
    boolean bool1;
    boolean bool3;
    boolean bool4;
    if ((this.jdField_a_of_type_Loc != null) && ((paramBoolean2) || (paramlpp.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) || (paramlpp.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) || (paramlpp.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) || (paramBoolean1)))
    {
      if (this.jdField_a_of_type_Msh != null) {
        this.jdField_a_of_type_Msh.a("drawFrameInGL");
      }
      int i = this.jdField_a_of_type_Int;
      int j = this.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Lov != null)
      {
        this.jdField_a_of_type_Lov.a(paramlok, paramlpp, this.jdField_a_of_type_Lpf, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        lox locallox = this.jdField_a_of_type_Lox;
        if (this.jdField_a_of_type_Lov.jdField_a_of_type_Int == 0) {
          break label462;
        }
        bool1 = true;
        locallox.jdField_a_of_type_Boolean = bool1;
      }
      this.jdField_a_of_type_Loc.b(i, j);
      bool3 = this.jdField_a_of_type_Loc.d();
      this.jdField_a_of_type_Loc.a(paramlpp.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      this.jdField_a_of_type_Loc.a(paramlpp.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramlpp.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
      this.jdField_a_of_type_Loc.a(paramBoolean1);
      this.jdField_a_of_type_Loc.c(this.d, this.c);
      this.jdField_b_of_type_Lpf = lpf.a(this.jdField_a_of_type_Lpf.jdField_a_of_type_Int, this.jdField_a_of_type_Lpf.jdField_b_of_type_Int);
      this.jdField_b_of_type_Lpf.jdField_b_of_type_Int = this.jdField_a_of_type_Loc.a(this.jdField_a_of_type_Lpf.jdField_b_of_type_Int, false, this.jdField_a_of_type_Lox, paramlpp.jdField_b_of_type_Boolean);
      bool4 = this.jdField_a_of_type_Loc.d();
      if (this.jdField_a_of_type_Loc.a()) {
        a(128);
      }
      if (paramlpp.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) {
        a(16);
      }
      if ((paramlpp.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) || (paramlpp.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null)) {
        a(32);
      }
      if (this.jdField_a_of_type_Loc.b()) {
        a(64);
      }
      if (paramBoolean2) {
        a(8);
      }
      if (this.jdField_a_of_type_Msh != null) {
        this.jdField_a_of_type_Msh.b("drawFrameInGL");
      }
      if (parammrk != null)
      {
        if (paramlpp.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc == null) {
          break label468;
        }
        bool1 = true;
        label383:
        if (paramlpp.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) {
          break label474;
        }
      }
    }
    for (;;)
    {
      parammrk.a(bool1, bool2, paramBoolean1, paramBoolean2);
      a(2, this.jdField_a_of_type_Lpf, this.jdField_b_of_type_Lpf);
      if (this.jdField_a_of_type_Lov != null) {
        this.jdField_a_of_type_Lov.a(this.jdField_b_of_type_Lpf, bool3, bool4, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_Lov != null) {
        this.jdField_a_of_type_Lov.a(paramlok, paramlpp);
      }
      return;
      label462:
      bool1 = false;
      break;
      label468:
      bool1 = false;
      break label383;
      label474:
      bool2 = false;
    }
  }
  
  private void a(lok paramlok, lpq paramlpq, long paramLong)
  {
    if (this.jdField_a_of_type_Lpj != null) {
      this.jdField_a_of_type_Lpj.a(this, paramlok, this.jdField_b_of_type_Lpf, this.jdField_a_of_type_Lox, paramlpq);
    }
    this.jdField_b_of_type_Boolean = false;
    if (paramlpq.a == null) {
      paramlpq.a = paramlok;
    }
    long l = System.currentTimeMillis();
    paramlpq.a.f = ((int)(l - paramLong));
    paramlpq.a.g = this.e;
    if (this.jdField_a_of_type_Msh != null) {
      this.jdField_a_of_type_Msh.a(paramlok.c);
    }
    lse.a().a(this.e);
  }
  
  private void a(lpp paramlpp, lor paramlor, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramlpp.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null))
    {
      if (this.jdField_a_of_type_Msh != null) {
        this.jdField_a_of_type_Msh.a("faceDetect");
      }
      if (this.jdField_a_of_type_Loz != null) {
        this.jdField_a_of_type_Loz.a(this.jdField_a_of_type_Lox, this.c, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_Loc != null) {
        this.jdField_a_of_type_Loc.a(paramlor, this.jdField_a_of_type_Lox);
      }
      if (this.jdField_a_of_type_Msh != null) {
        this.jdField_a_of_type_Msh.b("faceDetect");
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
    if (this.jdField_a_of_type_Lpk != null) {
      this.jdField_a_of_type_Lpk.a(paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_Lpj != null) {
      this.jdField_a_of_type_Lpj.a(paramInt1, paramInt2);
    }
    d();
    SvEffectSdkInitor.init();
  }
  
  private void b(lok paramlok, lpq paramlpq, long paramLong)
  {
    paramlok.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    paramlok.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Lpa != null)
    {
      this.jdField_a_of_type_Lpa.a(this, 5, paramlok, null);
      this.jdField_a_of_type_Lpa.d();
    }
    this.jdField_b_of_type_Boolean = false;
    paramlok.f = ((int)(System.currentTimeMillis() - paramLong));
    paramlok.g = this.e;
    if (this.jdField_a_of_type_Lpk != null) {
      this.jdField_a_of_type_Lpk.b();
    }
    if (this.jdField_a_of_type_Lpj != null) {
      this.jdField_a_of_type_Lpj.b();
    }
    if (this.jdField_a_of_type_Msh != null) {
      this.jdField_a_of_type_Msh.a(paramlok.c);
    }
    lse.a().a(this.e);
    paramlpq.a(paramlok, null, null, null, (short)0, (short)0);
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
    if (this.jdField_a_of_type_Loc != null) {
      this.jdField_a_of_type_Loc.c();
    }
  }
  
  protected void a(int paramInt)
  {
    this.e |= paramInt;
  }
  
  public void a(int paramInt, lpf paramlpf1, lpf paramlpf2)
  {
    if ((this.jdField_a_of_type_Lpa != null) && (this.jdField_a_of_type_Lpa.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Lpa.a(this, paramInt, null, paramlpf2);
      this.jdField_a_of_type_Lpa.a(paramInt, paramlpf2.jdField_a_of_type_Int, paramlpf2.jdField_b_of_type_Int);
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, String.format("%s, fbo[%s --> %s], textureid[%s --> %s]", new Object[] { lpa.a(paramInt), Integer.valueOf(paramlpf1.jdField_a_of_type_Int), Integer.valueOf(paramlpf2.jdField_a_of_type_Int), Integer.valueOf(paramlpf1.jdField_b_of_type_Int), Integer.valueOf(paramlpf2.jdField_b_of_type_Int) }));
      }
    }
  }
  
  void a(long paramLong)
  {
    if (this.jdField_a_of_type_Loc != null)
    {
      this.jdField_a_of_type_Loc.a(paramLong);
      return;
    }
    this.jdField_a_of_type_Lpu.a(paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (AudioHelper.f()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "initial, szie[" + this.jdField_a_of_type_Int + ", " + this.jdField_b_of_type_Int + "], id[" + this.c + "], seq[" + paramLong + "]");
    }
    if (this.jdField_a_of_type_Lpa != null) {
      this.jdField_a_of_type_Lpa.a();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    if (this.c != -1) {
      return;
    }
    if (los.b())
    {
      if (this.jdField_a_of_type_Loc == null)
      {
        this.jdField_a_of_type_Loc = new lod(this.jdField_a_of_type_Lpu, paramInt);
        this.jdField_a_of_type_Loc.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_Loc.c()) {
        if (this.jdField_a_of_type_Loh == null) {
          this.jdField_a_of_type_Loh = new loh();
        }
      }
    }
    for (;;)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
      this.c = arrayOfInt[0];
      if (this.jdField_a_of_type_Lpk != null) {
        this.jdField_a_of_type_Lpk.a();
      }
      if (this.jdField_a_of_type_Lpj != null) {
        this.jdField_a_of_type_Lpj.a();
      }
      this.e = 0;
      if (this.jdField_a_of_type_Lov == null) {
        break;
      }
      this.jdField_a_of_type_Lov.a();
      return;
      if (this.jdField_a_of_type_Loh != null) {
        this.jdField_a_of_type_Loh.a();
      }
      this.jdField_a_of_type_Loh = null;
      continue;
      this.jdField_a_of_type_Loh = new loh();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(lok paramlok, lpp paramlpp, lor paramlor, lpq paramlpq)
  {
    if (this.jdField_a_of_type_Lpa != null) {
      this.jdField_a_of_type_Lpa.a();
    }
    if (this.jdField_a_of_type_Msh != null) {
      this.jdField_a_of_type_Msh.b();
    }
    long l = System.currentTimeMillis();
    paramlpq.a = paramlok;
    b(0L, paramlok.jdField_b_of_type_Int, paramlok.jdField_a_of_type_Int);
    int i = paramlok.jdField_a_of_type_Int;
    int k = paramlok.jdField_b_of_type_Int;
    int m = lpr.a(paramlok.jdField_a_of_type_Boolean);
    boolean bool1 = paramlpp.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Loz != null) {
      bool1 |= this.jdField_a_of_type_Loz.a();
    }
    for (;;)
    {
      int j = this.jdField_a_of_type_Loi.a("BEAUTY_SKIN");
      this.jdField_a_of_type_Lpo.a(this.jdField_a_of_type_JavaLangString, paramlok.c, i, k, paramlok.d, paramlpp.jdField_a_of_type_Boolean, paramlpp.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, paramlpp.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial, paramlpp.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramlok, j);
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0) || (paramlok.a()) || (this.d == -1) || (!this.jdField_a_of_type_Boolean)) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      mrk localmrk = paramlok.jdField_a_of_type_Mrk;
      if (localmrk != null) {
        localmrk.a(m);
      }
      this.jdField_a_of_type_Lox.a(i, k);
      if ((paramlok.b()) && (this.jdField_a_of_type_Lpa != null))
      {
        this.jdField_a_of_type_Lpa.c();
        this.jdField_a_of_type_Lpa.a(this, 0, paramlok, null);
      }
      boolean bool4 = false;
      boolean bool3 = false;
      boolean bool2;
      if (this.jdField_a_of_type_Loh != null)
      {
        this.jdField_a_of_type_Loh.a(j);
        if (this.jdField_a_of_type_Loc != null) {
          this.jdField_a_of_type_Loc.a(null);
        }
        bool2 = this.jdField_a_of_type_Loh.a(j);
        if ((paramlpp.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc == null) && (paramlpp.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null)) {
          break label503;
        }
        i = 1;
        label325:
        boolean bool5 = false;
        bool4 = bool5;
        if (paramlok.b())
        {
          bool4 = bool5;
          if (this.jdField_a_of_type_Lpg != null)
          {
            this.jdField_a_of_type_Lpg.a(this.jdField_a_of_type_Msh, paramlok, localmrk);
            bool4 = this.jdField_a_of_type_Lpg.jdField_a_of_type_Boolean;
          }
        }
        if ((paramlok.b()) && (this.jdField_a_of_type_Loh != null)) {
          this.jdField_a_of_type_Loh.a(this, this.jdField_a_of_type_Msh, paramlok, localmrk, paramlpp, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, j);
        }
        if ((i == 0) && (!bool1) && (!bool2) && (!bool3) && (!bool4)) {
          break label509;
        }
        i = 1;
      }
      for (;;)
      {
        if ((!paramlpp.c) || (i == 0))
        {
          if (paramlok.b())
          {
            b(paramlok, paramlpq, l);
            return;
            bool2 = bool4;
            if (this.jdField_a_of_type_Loc == null) {
              break;
            }
            bool3 = this.jdField_a_of_type_Loc.a(this.jdField_a_of_type_Loi);
            bool2 = bool4;
            break;
            label503:
            i = 0;
            break label325;
            label509:
            i = 0;
            continue;
          }
          a(paramlok);
          a(paramlok, paramlpq, l);
          return;
        }
      }
      a(paramlok);
      if ((paramlok.b()) && (this.jdField_a_of_type_Lpg != null)) {
        this.jdField_a_of_type_Lpg.a(this.jdField_a_of_type_Msh, localmrk);
      }
      if ((paramlok.b()) && (this.jdField_a_of_type_Lpg != null)) {
        this.jdField_a_of_type_Lpg.b(this.jdField_a_of_type_Msh, paramlok, localmrk);
      }
      if ((paramlok.b()) && (this.jdField_a_of_type_Loh != null)) {
        this.jdField_a_of_type_Loh.a(this, this.jdField_a_of_type_Msh, localmrk, paramlpp, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, j);
      }
      a(paramlok, paramlpp, bool1, localmrk, bool3);
      a(paramlpp, paramlor, bool1);
      a(paramlok, paramlpq, l);
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
      if (this.jdField_a_of_type_Lpa != null) {
        this.jdField_a_of_type_Lpa.b();
      }
      if (this.jdField_a_of_type_Lpj != null) {
        this.jdField_a_of_type_Lpj.b();
      }
      if (this.jdField_a_of_type_Lpk != null) {
        this.jdField_a_of_type_Lpk.b();
      }
      a(l);
      if (this.jdField_a_of_type_Loh != null) {
        this.jdField_a_of_type_Loh.b();
      }
      if (this.jdField_a_of_type_Loc != null) {
        this.jdField_a_of_type_Loc.a();
      }
    } while (this.jdField_a_of_type_Msh == null);
    this.jdField_a_of_type_Msh.a();
  }
  
  public void b(long paramLong)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "clear, seq[" + paramLong + "]");
    if (this.jdField_a_of_type_Lpk != null)
    {
      this.jdField_a_of_type_Lpk.b();
      this.jdField_a_of_type_Lpk.c();
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
    if (this.jdField_a_of_type_Lpj != null) {
      this.jdField_a_of_type_Lpj.c();
    }
    if (this.jdField_a_of_type_Lpg != null)
    {
      this.jdField_a_of_type_Lpg.a();
      this.jdField_a_of_type_Lpg = null;
    }
    if (this.jdField_a_of_type_Loh != null)
    {
      this.jdField_a_of_type_Loh.a();
      this.jdField_a_of_type_Loh = null;
    }
    if (this.jdField_a_of_type_Loc != null)
    {
      this.jdField_a_of_type_Loc.b();
      this.jdField_a_of_type_Loc = null;
    }
    if (this.jdField_a_of_type_Lov != null) {
      this.jdField_a_of_type_Lov.b();
    }
    this.jdField_a_of_type_Lpu.a(paramLong);
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_Lpf != this.jdField_b_of_type_Lpf) && (this.jdField_a_of_type_Lpf != null))
    {
      this.jdField_a_of_type_Lpf.a();
      this.jdField_a_of_type_Lpf = null;
    }
    this.jdField_a_of_type_Lpf = this.jdField_b_of_type_Lpf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     loy
 * JD-Core Version:    0.7.0.1
 */