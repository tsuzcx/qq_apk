import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;

public abstract class lpf
  extends lpq
  implements lpe
{
  private static boolean jdField_a_of_type_Boolean;
  protected Context a;
  private ljr jdField_a_of_type_Ljr = new lpg(this);
  private lox jdField_a_of_type_Lox;
  public lpl a;
  private final lpy jdField_a_of_type_Lpy = new lpy();
  private final lqc jdField_a_of_type_Lqc = new lqc();
  private final lqd jdField_a_of_type_Lqd = new lqd();
  private boolean b;
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Lpl != null)
    {
      this.jdField_a_of_type_Lpl.a(paramLong, b());
      this.jdField_a_of_type_Lpl.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  private void a(lox paramlox, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
  {
    if (paramlox != null)
    {
      paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramShort1, paramShort2, (short)paramlox.jdField_a_of_type_Int, (short)paramlox.jdField_b_of_type_Int);
      if (paramlox.jdField_a_of_type_Msh != null) {
        paramlox.jdField_a_of_type_Msh.f();
      }
      GraphicRenderMgr.getInstance().sendCameraFrame(paramlox.jdField_a_of_type_ArrayOfByte, paramlox.jdField_c_of_type_Int, paramlox.jdField_a_of_type_Int, paramlox.jdField_b_of_type_Int, paramlox.d, paramlox.e, paramlox.jdField_b_of_type_Long, paramlox.jdField_a_of_type_Boolean, a(), paramArrayOfByte1, paramlox.f, paramlox.g);
      paramlox.b();
    }
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    if (e()) {
      return true;
    }
    int i = DeviceInfoUtil.getOsVersion();
    if (i < 17)
    {
      lbd.f("EffectCtrlBase", "isUserEffectFace error  osVersion:" + i);
      return false;
    }
    return a(paramInt, paramLong, 1073741824L);
  }
  
  public static boolean a(int paramInt, long paramLong1, long paramLong2)
  {
    int i = llq.e();
    if (i < paramInt)
    {
      QLog.w("EffectCtrlBase", 1, "isSupportOfDevice fail, cpuCount[" + i + " < " + paramInt + "]");
      return false;
    }
    long l = llq.d();
    if ((l != 0L) && (l < paramLong1))
    {
      QLog.w("EffectCtrlBase", 1, "isSupportOfDevice fail, cpuFrequency[" + l + " < " + paramLong1 + "]");
      return false;
    }
    paramLong1 = DeviceInfoUtil.getSystemTotalMemory();
    if (paramLong1 < paramLong2)
    {
      QLog.w("EffectCtrlBase", 1, "isSupportOfDevice fail, mem[" + paramLong1 + " < " + paramLong2 + "]");
      return false;
    }
    return true;
  }
  
  private void b(lox paramlox)
  {
    if (this.jdField_a_of_type_Lox == paramlox) {
      this.jdField_a_of_type_Lox = null;
    }
    this.jdField_a_of_type_Lqd.a();
    byte[] arrayOfByte = paramlox.jdField_a_of_type_ArrayOfByte;
    if (arrayOfByte != null) {
      ljv.a().a(arrayOfByte, 3);
    }
    a(paramlox, this.jdField_a_of_type_Lqc);
    msh localmsh = paramlox.jdField_a_of_type_Msh;
    localmsh.c();
    if (this.jdField_a_of_type_Lpl != null) {
      this.jdField_a_of_type_Lpl.a(paramlox, this.jdField_a_of_type_Lqc, this, this.jdField_a_of_type_Lqd);
    }
    paramlox.a();
    localmsh.d();
    if (arrayOfByte != null) {
      ljv.a().a(arrayOfByte, 0);
    }
    int i = lid.a(this.jdField_a_of_type_Lqc.a, this.jdField_a_of_type_Lqc.b);
    GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(i, 1);
    if (this.jdField_a_of_type_Lqd.jdField_a_of_type_Lox == null) {
      this.jdField_a_of_type_Lqd.jdField_a_of_type_Lox = paramlox;
    }
    this.jdField_a_of_type_Lqd.jdField_a_of_type_Lox.jdField_a_of_type_Msh = localmsh;
    a(this.jdField_a_of_type_Lqd.jdField_a_of_type_Lox, this.jdField_a_of_type_Lqd.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Lqd.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Lqd.c, this.jdField_a_of_type_Lqd.jdField_a_of_type_Short, this.jdField_a_of_type_Lqd.jdField_b_of_type_Short);
  }
  
  public static boolean b()
  {
    return (bmwb.b()) && (bdee.a());
  }
  
  public static boolean c()
  {
    if (Build.VERSION.SDK_INT <= 15) {
      return false;
    }
    return a(2, 1200000L, 1073741824L);
  }
  
  public static boolean d()
  {
    if (jdField_a_of_type_Boolean) {
      return true;
    }
    lom locallom = lom.a();
    if ((locallom != null) && (locallom.f()))
    {
      jdField_a_of_type_Boolean = true;
      return true;
    }
    if (!c()) {
      return false;
    }
    if ((a(4, 1400000L, 1073741824L)) || (a(8, 1200000L, 1073741824L))) {}
    for (int i = 1; i == 0; i = 0) {
      return false;
    }
    if ((locallom != null) && (!locallom.e()))
    {
      lbd.h("EffectCtrlBase", "isUserEffectFace| model in black list.modle=" + Build.MANUFACTURER + ":" + Build.MODEL);
      return false;
    }
    jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public static boolean e()
  {
    String str = Build.MODEL;
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return str.equals("MI 5");
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Lpl != null) {
      this.jdField_a_of_type_Lpl.a();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EffectCtrlBase", 2, "uninit");
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(5).sendToTarget();
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Lpl != null) {
      this.jdField_a_of_type_Lpl.a(paramLong);
    }
  }
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      b(mur.a(paramMessage.obj));
      return;
    case 2: 
      c(mur.a(paramMessage.obj));
      return;
    case 3: 
      b((lox)paramMessage.obj);
      return;
    case 4: 
      a(mur.a(paramMessage.obj), ljk.jdField_b_of_type_Int, ljk.jdField_a_of_type_Int);
      return;
    case 5: 
      e();
      return;
    }
    g();
  }
  
  public void a(lox paramlox)
  {
    int i;
    if (paramlox.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {
      i = 1;
    }
    while (i == 0)
    {
      paramlox.b();
      return;
      this.jdField_a_of_type_Lpy.a(paramlox.jdField_a_of_type_ArrayOfByte, paramlox.jdField_a_of_type_Int, paramlox.jdField_b_of_type_Int, paramlox.jdField_c_of_type_Int, paramlox.d, paramlox.jdField_a_of_type_Long, paramlox.jdField_a_of_type_Boolean, paramlox.jdField_c_of_type_Long);
      if ((paramlox.jdField_a_of_type_ArrayOfByte != null) && (paramlox.jdField_a_of_type_Int != 0) && (paramlox.jdField_b_of_type_Int != 0)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(3))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      if ((this.jdField_a_of_type_Lox == null) || (this.jdField_a_of_type_Lox == paramlox)) {}
    }
    try
    {
      this.jdField_a_of_type_Lox.b();
      label129:
      this.jdField_a_of_type_Lox = null;
      if (paramlox.jdField_a_of_type_ArrayOfByte != null) {
        ljv.a().a(2, 0);
      }
      if (paramlox.jdField_a_of_type_ArrayOfByte != null) {
        ljv.a().a(paramlox.jdField_a_of_type_ArrayOfByte, 2);
      }
      this.jdField_a_of_type_Lox = paramlox;
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, paramlox).sendToTarget();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label129;
    }
  }
  
  protected abstract void a(lox paramlox, lqc paramlqc);
  
  protected abstract byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2, short paramShort3, short paramShort4);
  
  protected abstract float[] a();
  
  protected int b()
  {
    return 0;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(6).sendToTarget();
  }
  
  protected void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("EffectCtrlBase", 1, "initInGL, isInitial[" + this.b + "], soloadedPTV[" + GraphicRenderMgr.soloadedPTV + "], seq[" + paramLong + "]");
    }
    if (this.b) {}
    do
    {
      return;
      this.b = true;
      super.c();
      if (this.jdField_a_of_type_Lpl != null) {
        this.jdField_a_of_type_Lpl.a(paramLong, b());
      }
    } while ((!ljk.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Lpl == null));
    this.jdField_a_of_type_Lpl.a(paramLong, ljk.jdField_b_of_type_Int, ljk.jdField_a_of_type_Int);
  }
  
  public void c()
  {
    long l = AudioHelper.b();
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.obj = Long.valueOf(l);
    localMessage.sendToTarget();
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Ljr);
    if (QLog.isColorLevel()) {
      QLog.i("SurfaceTag", 2, "Effect-init");
    }
  }
  
  protected void c(long paramLong)
  {
    if (!this.b) {
      return;
    }
    this.b = false;
    if (AudioHelper.f()) {
      QLog.w("EffectCtrlBase", 1, "terminateInGL, seq[" + paramLong + "]");
    }
    if (this.jdField_a_of_type_Lpl != null) {
      this.jdField_a_of_type_Lpl.b(paramLong);
    }
    super.d();
  }
  
  public void d()
  {
    long l = AudioHelper.b();
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(this.jdField_a_of_type_Ljr);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = Long.valueOf(l);
    localMessage.sendToTarget();
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EffectCtrlBase", 2, "unInitInGL, p[" + this.jdField_a_of_type_Lpl + "]");
    }
    if (this.jdField_a_of_type_Lpl != null) {
      this.jdField_a_of_type_Lpl.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lpf
 * JD-Core Version:    0.7.0.1
 */