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

public abstract class los
  extends lpd
  implements lor
{
  private static boolean jdField_a_of_type_Boolean;
  protected Context a;
  private ljf jdField_a_of_type_Ljf = new lot(this);
  private lok jdField_a_of_type_Lok;
  public loy a;
  private final lpl jdField_a_of_type_Lpl = new lpl();
  private final lpp jdField_a_of_type_Lpp = new lpp();
  private final lpq jdField_a_of_type_Lpq = new lpq();
  private boolean b;
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Loy != null)
    {
      this.jdField_a_of_type_Loy.a(paramLong, b());
      this.jdField_a_of_type_Loy.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  private void a(lok paramlok, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
  {
    if (paramlok != null)
    {
      paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramShort1, paramShort2, (short)paramlok.jdField_a_of_type_Int, (short)paramlok.jdField_b_of_type_Int);
      if (paramlok.jdField_a_of_type_Mrk != null) {
        paramlok.jdField_a_of_type_Mrk.f();
      }
      GraphicRenderMgr.getInstance().sendCameraFrame(paramlok.jdField_a_of_type_ArrayOfByte, paramlok.jdField_c_of_type_Int, paramlok.jdField_a_of_type_Int, paramlok.jdField_b_of_type_Int, paramlok.d, paramlok.e, paramlok.jdField_b_of_type_Long, paramlok.jdField_a_of_type_Boolean, a(), paramArrayOfByte1, paramlok.f, paramlok.g);
      paramlok.b();
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
      lba.f("EffectCtrlBase", "isUserEffectFace error  osVersion:" + i);
      return false;
    }
    return a(paramInt, paramLong, 1073741824L);
  }
  
  public static boolean a(int paramInt, long paramLong1, long paramLong2)
  {
    int i = lld.e();
    if (i < paramInt)
    {
      QLog.w("EffectCtrlBase", 1, "isSupportOfDevice fail, cpuCount[" + i + " < " + paramInt + "]");
      return false;
    }
    long l = lld.d();
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
  
  private void b(lok paramlok)
  {
    if (this.jdField_a_of_type_Lok == paramlok) {
      this.jdField_a_of_type_Lok = null;
    }
    this.jdField_a_of_type_Lpq.a();
    byte[] arrayOfByte = paramlok.jdField_a_of_type_ArrayOfByte;
    if (arrayOfByte != null) {
      ljj.a().a(arrayOfByte, 3);
    }
    a(paramlok, this.jdField_a_of_type_Lpp);
    mrk localmrk = paramlok.jdField_a_of_type_Mrk;
    localmrk.c();
    if (this.jdField_a_of_type_Loy != null) {
      this.jdField_a_of_type_Loy.a(paramlok, this.jdField_a_of_type_Lpp, this, this.jdField_a_of_type_Lpq);
    }
    paramlok.a();
    localmrk.d();
    if (arrayOfByte != null) {
      ljj.a().a(arrayOfByte, 0);
    }
    int i = lhr.a(this.jdField_a_of_type_Lpp.a, this.jdField_a_of_type_Lpp.b);
    GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(i, 1);
    if (this.jdField_a_of_type_Lpq.jdField_a_of_type_Lok == null) {
      this.jdField_a_of_type_Lpq.jdField_a_of_type_Lok = paramlok;
    }
    this.jdField_a_of_type_Lpq.jdField_a_of_type_Lok.jdField_a_of_type_Mrk = localmrk;
    a(this.jdField_a_of_type_Lpq.jdField_a_of_type_Lok, this.jdField_a_of_type_Lpq.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Lpq.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Lpq.c, this.jdField_a_of_type_Lpq.jdField_a_of_type_Short, this.jdField_a_of_type_Lpq.jdField_b_of_type_Short);
  }
  
  public static boolean b()
  {
    return (bljd.b()) && (bbxj.a());
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
    lnz locallnz = lnz.a();
    if ((locallnz != null) && (locallnz.f()))
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
    if ((locallnz != null) && (!locallnz.e()))
    {
      lba.h("EffectCtrlBase", "isUserEffectFace| model in black list.modle=" + Build.MANUFACTURER + ":" + Build.MODEL);
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
    if (this.jdField_a_of_type_Loy != null) {
      this.jdField_a_of_type_Loy.a();
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
    if (this.jdField_a_of_type_Loy != null) {
      this.jdField_a_of_type_Loy.a(paramLong);
    }
  }
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      b(mtt.a(paramMessage.obj));
      return;
    case 2: 
      c(mtt.a(paramMessage.obj));
      return;
    case 3: 
      b((lok)paramMessage.obj);
      return;
    case 4: 
      a(mtt.a(paramMessage.obj), liy.jdField_b_of_type_Int, liy.jdField_a_of_type_Int);
      return;
    case 5: 
      e();
      return;
    }
    g();
  }
  
  public void a(lok paramlok)
  {
    int i;
    if (paramlok.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {
      i = 1;
    }
    while (i == 0)
    {
      paramlok.b();
      return;
      this.jdField_a_of_type_Lpl.a(paramlok.jdField_a_of_type_ArrayOfByte, paramlok.jdField_a_of_type_Int, paramlok.jdField_b_of_type_Int, paramlok.jdField_c_of_type_Int, paramlok.d, paramlok.jdField_a_of_type_Long, paramlok.jdField_a_of_type_Boolean, paramlok.jdField_c_of_type_Long);
      if ((paramlok.jdField_a_of_type_ArrayOfByte != null) && (paramlok.jdField_a_of_type_Int != 0) && (paramlok.jdField_b_of_type_Int != 0)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(3))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      if ((this.jdField_a_of_type_Lok == null) || (this.jdField_a_of_type_Lok == paramlok)) {}
    }
    try
    {
      this.jdField_a_of_type_Lok.b();
      label129:
      this.jdField_a_of_type_Lok = null;
      if (paramlok.jdField_a_of_type_ArrayOfByte != null) {
        ljj.a().a(2, 0);
      }
      if (paramlok.jdField_a_of_type_ArrayOfByte != null) {
        ljj.a().a(paramlok.jdField_a_of_type_ArrayOfByte, 2);
      }
      this.jdField_a_of_type_Lok = paramlok;
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, paramlok).sendToTarget();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label129;
    }
  }
  
  protected abstract void a(lok paramlok, lpp paramlpp);
  
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
      if (this.jdField_a_of_type_Loy != null) {
        this.jdField_a_of_type_Loy.a(paramLong, b());
      }
    } while ((!liy.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Loy == null));
    this.jdField_a_of_type_Loy.a(paramLong, liy.jdField_b_of_type_Int, liy.jdField_a_of_type_Int);
  }
  
  public void c()
  {
    long l = AudioHelper.b();
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.obj = Long.valueOf(l);
    localMessage.sendToTarget();
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Ljf);
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
    if (this.jdField_a_of_type_Loy != null) {
      this.jdField_a_of_type_Loy.b(paramLong);
    }
    super.d();
  }
  
  public void d()
  {
    long l = AudioHelper.b();
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(this.jdField_a_of_type_Ljf);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = Long.valueOf(l);
    localMessage.sendToTarget();
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EffectCtrlBase", 2, "unInitInGL, p[" + this.jdField_a_of_type_Loy + "]");
    }
    if (this.jdField_a_of_type_Loy != null) {
      this.jdField_a_of_type_Loy.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     los
 * JD-Core Version:    0.7.0.1
 */