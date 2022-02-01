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
public class lpl
{
  int jdField_a_of_type_Int = 0;
  protected Context a;
  final String jdField_a_of_type_JavaLangString = "FilterProcessRender_" + AudioHelper.b();
  protected FloatBuffer a;
  private lop jdField_a_of_type_Lop;
  private lou jdField_a_of_type_Lou;
  private lov jdField_a_of_type_Lov;
  private lpi jdField_a_of_type_Lpi;
  final lpk jdField_a_of_type_Lpk = new lpk();
  protected lpm a;
  protected lpn a;
  protected lps a;
  private lpt jdField_a_of_type_Lpt;
  protected lpw a;
  protected lpx a;
  private lqb jdField_a_of_type_Lqb = new lqb();
  protected final lqh a;
  protected mte a;
  protected boolean a;
  int jdField_b_of_type_Int = 0;
  protected lps b;
  private boolean jdField_b_of_type_Boolean;
  int c = -1;
  int d = -1;
  private int e = 0;
  
  public lpl(Context paramContext, lpm paramlpm, lov paramlov)
  {
    this.jdField_a_of_type_Lqh = new lqh();
    if (QLog.isColorLevel()) {
      this.jdField_a_of_type_Mte = new mte();
    }
    this.jdField_a_of_type_Lpm = paramlpm;
    this.jdField_a_of_type_Lov = paramlov;
    SvEffectSdkInitor.init();
    bmwb.a();
    this.jdField_a_of_type_Lqh.a = null;
    this.c = -1;
    lqe.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a();
    if (paramContext != null) {}
    for (this.jdField_a_of_type_Lpx = new lqg(paramContext);; this.jdField_a_of_type_Lpx = new lqi())
    {
      this.jdField_a_of_type_Lpw = new lqj(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Lpi = new lpi(this);
      return;
    }
  }
  
  private void a(lox paramlox)
  {
    if (this.jdField_b_of_type_Lps == null)
    {
      this.jdField_b_of_type_Lps = lps.a(this.d, this.c);
      if ((this.jdField_a_of_type_Lpx != null) && (!this.jdField_a_of_type_Lpx.a(paramlox)))
      {
        this.jdField_a_of_type_Lpx.c();
        this.jdField_a_of_type_Lpx.b();
        this.jdField_a_of_type_Lpx = null;
        if (QLog.isDevelopLevel()) {
          QLog.i("SurfaceTag", 4, "preRender, not match frame.");
        }
      }
      if (this.jdField_a_of_type_Lpx == null)
      {
        if (!paramlox.b()) {
          break label213;
        }
        this.jdField_a_of_type_Lpx = new lqi();
        this.jdField_a_of_type_Lpx.a();
        this.jdField_a_of_type_Lpx.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("SurfaceTag", 4, "preRender, new render for frame.");
      }
      if ((this.jdField_a_of_type_Lpx != null) && (this.jdField_a_of_type_Lpx.a(paramlox)))
      {
        c();
        this.jdField_b_of_type_Lps = this.jdField_a_of_type_Lpx.a(this, paramlox, this.jdField_a_of_type_Lps);
      }
      return;
      this.jdField_b_of_type_Lps.jdField_a_of_type_Int = this.d;
      this.jdField_b_of_type_Lps.jdField_b_of_type_Int = this.c;
      break;
      label213:
      if (paramlox.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null)
      {
        this.jdField_a_of_type_Lpx = new lqg(paramlox.jdField_a_of_type_AndroidGraphicsSurfaceTexture);
        this.jdField_a_of_type_Lpx.a();
        this.jdField_a_of_type_Lpx.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
    }
  }
  
  private void a(lox paramlox, lqc paramlqc, boolean paramBoolean1, msh parammsh, boolean paramBoolean2)
  {
    boolean bool2 = true;
    c();
    boolean bool1;
    boolean bool3;
    boolean bool4;
    if ((this.jdField_a_of_type_Lop != null) && ((paramBoolean2) || (paramlqc.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) || (paramlqc.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) || (paramlqc.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null) || (paramBoolean1)))
    {
      if (this.jdField_a_of_type_Mte != null) {
        this.jdField_a_of_type_Mte.a("drawFrameInGL");
      }
      int i = this.jdField_a_of_type_Int;
      int j = this.jdField_b_of_type_Int;
      if (this.jdField_a_of_type_Lpi != null)
      {
        this.jdField_a_of_type_Lpi.a(paramlox, paramlqc, this.jdField_a_of_type_Lps, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        lpk locallpk = this.jdField_a_of_type_Lpk;
        if (this.jdField_a_of_type_Lpi.jdField_a_of_type_Int == 0) {
          break label462;
        }
        bool1 = true;
        locallpk.jdField_a_of_type_Boolean = bool1;
      }
      this.jdField_a_of_type_Lop.b(i, j);
      bool3 = this.jdField_a_of_type_Lop.d();
      this.jdField_a_of_type_Lop.a(paramlqc.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc);
      this.jdField_a_of_type_Lop.a(paramlqc.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramlqc.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial);
      this.jdField_a_of_type_Lop.a(paramBoolean1);
      this.jdField_a_of_type_Lop.c(this.d, this.c);
      this.jdField_b_of_type_Lps = lps.a(this.jdField_a_of_type_Lps.jdField_a_of_type_Int, this.jdField_a_of_type_Lps.jdField_b_of_type_Int);
      this.jdField_b_of_type_Lps.jdField_b_of_type_Int = this.jdField_a_of_type_Lop.a(this.jdField_a_of_type_Lps.jdField_b_of_type_Int, false, this.jdField_a_of_type_Lpk, paramlqc.jdField_b_of_type_Boolean);
      bool4 = this.jdField_a_of_type_Lop.d();
      if (this.jdField_a_of_type_Lop.a()) {
        a(128);
      }
      if (paramlqc.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc != null) {
        a(16);
      }
      if ((paramlqc.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem != null) || (paramlqc.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null)) {
        a(32);
      }
      if (this.jdField_a_of_type_Lop.b()) {
        a(64);
      }
      if (paramBoolean2) {
        a(8);
      }
      if (this.jdField_a_of_type_Mte != null) {
        this.jdField_a_of_type_Mte.b("drawFrameInGL");
      }
      if (parammsh != null)
      {
        if (paramlqc.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc == null) {
          break label468;
        }
        bool1 = true;
        label383:
        if (paramlqc.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null) {
          break label474;
        }
      }
    }
    for (;;)
    {
      parammsh.a(bool1, bool2, paramBoolean1, paramBoolean2);
      a(2, this.jdField_a_of_type_Lps, this.jdField_b_of_type_Lps);
      if (this.jdField_a_of_type_Lpi != null) {
        this.jdField_a_of_type_Lpi.a(this.jdField_b_of_type_Lps, bool3, bool4, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_Lpi != null) {
        this.jdField_a_of_type_Lpi.a(paramlox, paramlqc);
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
  
  private void a(lox paramlox, lqd paramlqd, long paramLong)
  {
    if (this.jdField_a_of_type_Lpw != null) {
      this.jdField_a_of_type_Lpw.a(this, paramlox, this.jdField_b_of_type_Lps, this.jdField_a_of_type_Lpk, paramlqd);
    }
    this.jdField_b_of_type_Boolean = false;
    if (paramlqd.a == null) {
      paramlqd.a = paramlox;
    }
    long l = System.currentTimeMillis();
    paramlqd.a.f = ((int)(l - paramLong));
    paramlqd.a.g = this.e;
    if (this.jdField_a_of_type_Mte != null) {
      this.jdField_a_of_type_Mte.a(paramlox.c);
    }
    lsr.a().a(this.e);
  }
  
  private void a(lqc paramlqc, lpe paramlpe, boolean paramBoolean)
  {
    if ((paramBoolean) || (paramlqc.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial != null))
    {
      if (this.jdField_a_of_type_Mte != null) {
        this.jdField_a_of_type_Mte.a("faceDetect");
      }
      if (this.jdField_a_of_type_Lpm != null) {
        this.jdField_a_of_type_Lpm.a(this.jdField_a_of_type_Lpk, this.c, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_Lop != null) {
        this.jdField_a_of_type_Lop.a(paramlpe, this.jdField_a_of_type_Lpk);
      }
      if (this.jdField_a_of_type_Mte != null) {
        this.jdField_a_of_type_Mte.b("faceDetect");
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
    if (this.jdField_a_of_type_Lpx != null) {
      this.jdField_a_of_type_Lpx.a(paramInt1, paramInt2);
    }
    if (this.jdField_a_of_type_Lpw != null) {
      this.jdField_a_of_type_Lpw.a(paramInt1, paramInt2);
    }
    d();
    SvEffectSdkInitor.init();
  }
  
  private void b(lox paramlox, lqd paramlqd, long paramLong)
  {
    paramlox.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    paramlox.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
    if (this.jdField_a_of_type_Lpn != null)
    {
      this.jdField_a_of_type_Lpn.a(this, 5, paramlox, null);
      this.jdField_a_of_type_Lpn.d();
    }
    this.jdField_b_of_type_Boolean = false;
    paramlox.f = ((int)(System.currentTimeMillis() - paramLong));
    paramlox.g = this.e;
    if (this.jdField_a_of_type_Lpx != null) {
      this.jdField_a_of_type_Lpx.b();
    }
    if (this.jdField_a_of_type_Lpw != null) {
      this.jdField_a_of_type_Lpw.b();
    }
    if (this.jdField_a_of_type_Mte != null) {
      this.jdField_a_of_type_Mte.a(paramlox.c);
    }
    lsr.a().a(this.e);
    paramlqd.a(paramlox, null, null, null, (short)0, (short)0);
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
    if (this.jdField_a_of_type_Lop != null) {
      this.jdField_a_of_type_Lop.c();
    }
  }
  
  protected void a(int paramInt)
  {
    this.e |= paramInt;
  }
  
  public void a(int paramInt, lps paramlps1, lps paramlps2)
  {
    if ((this.jdField_a_of_type_Lpn != null) && (this.jdField_a_of_type_Lpn.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Lpn.a(this, paramInt, null, paramlps2);
      this.jdField_a_of_type_Lpn.a(paramInt, paramlps2.jdField_a_of_type_Int, paramlps2.jdField_b_of_type_Int);
      if (QLog.isDevelopLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 4, String.format("%s, fbo[%s --> %s], textureid[%s --> %s]", new Object[] { lpn.a(paramInt), Integer.valueOf(paramlps1.jdField_a_of_type_Int), Integer.valueOf(paramlps2.jdField_a_of_type_Int), Integer.valueOf(paramlps1.jdField_b_of_type_Int), Integer.valueOf(paramlps2.jdField_b_of_type_Int) }));
      }
    }
  }
  
  void a(long paramLong)
  {
    if (this.jdField_a_of_type_Lop != null)
    {
      this.jdField_a_of_type_Lop.a(paramLong);
      return;
    }
    this.jdField_a_of_type_Lqh.a(paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (AudioHelper.f()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "initial, szie[" + this.jdField_a_of_type_Int + ", " + this.jdField_b_of_type_Int + "], id[" + this.c + "], seq[" + paramLong + "]");
    }
    if (this.jdField_a_of_type_Lpn != null) {
      this.jdField_a_of_type_Lpn.a();
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    if (this.c != -1) {
      return;
    }
    if (lpf.b())
    {
      if (this.jdField_a_of_type_Lop == null)
      {
        this.jdField_a_of_type_Lop = new loq(this.jdField_a_of_type_Lqh, paramInt);
        this.jdField_a_of_type_Lop.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
      }
      if (this.jdField_a_of_type_Lop.c()) {
        if (this.jdField_a_of_type_Lou == null) {
          this.jdField_a_of_type_Lou = new lou();
        }
      }
    }
    for (;;)
    {
      int[] arrayOfInt = new int[1];
      GLES20.glGenTextures(arrayOfInt.length, arrayOfInt, 0);
      this.c = arrayOfInt[0];
      if (this.jdField_a_of_type_Lpx != null) {
        this.jdField_a_of_type_Lpx.a();
      }
      if (this.jdField_a_of_type_Lpw != null) {
        this.jdField_a_of_type_Lpw.a();
      }
      this.e = 0;
      if (this.jdField_a_of_type_Lpi == null) {
        break;
      }
      this.jdField_a_of_type_Lpi.a();
      return;
      if (this.jdField_a_of_type_Lou != null) {
        this.jdField_a_of_type_Lou.a();
      }
      this.jdField_a_of_type_Lou = null;
      continue;
      this.jdField_a_of_type_Lou = new lou();
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(lox paramlox, lqc paramlqc, lpe paramlpe, lqd paramlqd)
  {
    if (this.jdField_a_of_type_Lpn != null) {
      this.jdField_a_of_type_Lpn.a();
    }
    if (this.jdField_a_of_type_Mte != null) {
      this.jdField_a_of_type_Mte.b();
    }
    long l = System.currentTimeMillis();
    paramlqd.a = paramlox;
    b(0L, paramlox.jdField_b_of_type_Int, paramlox.jdField_a_of_type_Int);
    int i = paramlox.jdField_a_of_type_Int;
    int k = paramlox.jdField_b_of_type_Int;
    int m = lqe.a(paramlox.jdField_a_of_type_Boolean);
    boolean bool1 = paramlqc.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Lpm != null) {
      bool1 |= this.jdField_a_of_type_Lpm.a();
    }
    for (;;)
    {
      int j = this.jdField_a_of_type_Lov.a("BEAUTY_SKIN");
      this.jdField_a_of_type_Lqb.a(this.jdField_a_of_type_JavaLangString, paramlox.c, i, k, paramlox.d, paramlqc.jdField_a_of_type_Boolean, paramlqc.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc, paramlqc.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial, paramlqc.jdField_a_of_type_ComTencentAvBusinessManagerPendantPendantItem, paramlox, j);
      if ((this.jdField_a_of_type_Int == 0) || (this.jdField_b_of_type_Int == 0) || (paramlox.a()) || (this.d == -1) || (!this.jdField_a_of_type_Boolean)) {
        return;
      }
      this.jdField_b_of_type_Boolean = true;
      msh localmsh = paramlox.jdField_a_of_type_Msh;
      if (localmsh != null) {
        localmsh.a(m);
      }
      this.jdField_a_of_type_Lpk.a(i, k);
      if ((paramlox.b()) && (this.jdField_a_of_type_Lpn != null))
      {
        this.jdField_a_of_type_Lpn.c();
        this.jdField_a_of_type_Lpn.a(this, 0, paramlox, null);
      }
      boolean bool4 = false;
      boolean bool3 = false;
      boolean bool2;
      if (this.jdField_a_of_type_Lou != null)
      {
        this.jdField_a_of_type_Lou.a(j);
        if (this.jdField_a_of_type_Lop != null) {
          this.jdField_a_of_type_Lop.a(null);
        }
        bool2 = this.jdField_a_of_type_Lou.a(j);
        if ((paramlqc.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataFilterDesc == null) && (paramlqc.jdField_a_of_type_ComTencentTtpicOpenapiModelVideoMaterial == null)) {
          break label503;
        }
        i = 1;
        label325:
        boolean bool5 = false;
        bool4 = bool5;
        if (paramlox.b())
        {
          bool4 = bool5;
          if (this.jdField_a_of_type_Lpt != null)
          {
            this.jdField_a_of_type_Lpt.a(this.jdField_a_of_type_Mte, paramlox, localmsh);
            bool4 = this.jdField_a_of_type_Lpt.jdField_a_of_type_Boolean;
          }
        }
        if ((paramlox.b()) && (this.jdField_a_of_type_Lou != null)) {
          this.jdField_a_of_type_Lou.a(this, this.jdField_a_of_type_Mte, paramlox, localmsh, paramlqc, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, j);
        }
        if ((i == 0) && (!bool1) && (!bool2) && (!bool3) && (!bool4)) {
          break label509;
        }
        i = 1;
      }
      for (;;)
      {
        if ((!paramlqc.c) || (i == 0))
        {
          if (paramlox.b())
          {
            b(paramlox, paramlqd, l);
            return;
            bool2 = bool4;
            if (this.jdField_a_of_type_Lop == null) {
              break;
            }
            bool3 = this.jdField_a_of_type_Lop.a(this.jdField_a_of_type_Lov);
            bool2 = bool4;
            break;
            label503:
            i = 0;
            break label325;
            label509:
            i = 0;
            continue;
          }
          a(paramlox);
          a(paramlox, paramlqd, l);
          return;
        }
      }
      a(paramlox);
      if ((paramlox.b()) && (this.jdField_a_of_type_Lpt != null)) {
        this.jdField_a_of_type_Lpt.a(this.jdField_a_of_type_Mte, localmsh);
      }
      if ((paramlox.b()) && (this.jdField_a_of_type_Lpt != null)) {
        this.jdField_a_of_type_Lpt.b(this.jdField_a_of_type_Mte, paramlox, localmsh);
      }
      if ((paramlox.b()) && (this.jdField_a_of_type_Lou != null)) {
        this.jdField_a_of_type_Lou.a(this, this.jdField_a_of_type_Mte, localmsh, paramlqc, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, j);
      }
      a(paramlox, paramlqc, bool1, localmsh, bool3);
      a(paramlqc, paramlpe, bool1);
      a(paramlox, paramlqd, l);
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
      if (this.jdField_a_of_type_Lpn != null) {
        this.jdField_a_of_type_Lpn.b();
      }
      if (this.jdField_a_of_type_Lpw != null) {
        this.jdField_a_of_type_Lpw.b();
      }
      if (this.jdField_a_of_type_Lpx != null) {
        this.jdField_a_of_type_Lpx.b();
      }
      a(l);
      if (this.jdField_a_of_type_Lou != null) {
        this.jdField_a_of_type_Lou.b();
      }
      if (this.jdField_a_of_type_Lop != null) {
        this.jdField_a_of_type_Lop.a();
      }
    } while (this.jdField_a_of_type_Mte == null);
    this.jdField_a_of_type_Mte.a();
  }
  
  public void b(long paramLong)
  {
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "clear, seq[" + paramLong + "]");
    if (this.jdField_a_of_type_Lpx != null)
    {
      this.jdField_a_of_type_Lpx.b();
      this.jdField_a_of_type_Lpx.c();
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
    if (this.jdField_a_of_type_Lpw != null) {
      this.jdField_a_of_type_Lpw.c();
    }
    if (this.jdField_a_of_type_Lpt != null)
    {
      this.jdField_a_of_type_Lpt.a();
      this.jdField_a_of_type_Lpt = null;
    }
    if (this.jdField_a_of_type_Lou != null)
    {
      this.jdField_a_of_type_Lou.a();
      this.jdField_a_of_type_Lou = null;
    }
    if (this.jdField_a_of_type_Lop != null)
    {
      this.jdField_a_of_type_Lop.b();
      this.jdField_a_of_type_Lop = null;
    }
    if (this.jdField_a_of_type_Lpi != null) {
      this.jdField_a_of_type_Lpi.b();
    }
    this.jdField_a_of_type_Lqh.a(paramLong);
  }
  
  protected void c()
  {
    if ((this.jdField_a_of_type_Lps != this.jdField_b_of_type_Lps) && (this.jdField_a_of_type_Lps != null))
    {
      this.jdField_a_of_type_Lps.a();
      this.jdField_a_of_type_Lps = null;
    }
    this.jdField_a_of_type_Lps = this.jdField_b_of_type_Lps;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lpl
 * JD-Core Version:    0.7.0.1
 */