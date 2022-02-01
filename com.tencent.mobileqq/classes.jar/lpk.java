import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public abstract class lpk
  extends lpv
  implements lpj
{
  private static boolean jdField_a_of_type_Boolean;
  protected Context a;
  private ljl jdField_a_of_type_Ljl = new lpl(this);
  private lpc jdField_a_of_type_Lpc;
  public lpq a;
  private final lqd jdField_a_of_type_Lqd = new lqd();
  private final lqh jdField_a_of_type_Lqh = new lqh();
  private final lqi jdField_a_of_type_Lqi = new lqi();
  private boolean b;
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Lpq.a(paramLong, b());
    this.jdField_a_of_type_Lpq.a(paramLong, paramInt1, paramInt2);
  }
  
  private void a(lpc paramlpc, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
  {
    if (paramlpc != null)
    {
      paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramShort1, paramShort2, (short)paramlpc.jdField_a_of_type_Int, (short)paramlpc.jdField_b_of_type_Int);
      if (paramlpc.jdField_a_of_type_Msb != null) {
        paramlpc.jdField_a_of_type_Msb.f();
      }
      GraphicRenderMgr.getInstance().sendCameraFrame(paramlpc.jdField_a_of_type_ArrayOfByte, paramlpc.jdField_c_of_type_Int, paramlpc.jdField_a_of_type_Int, paramlpc.jdField_b_of_type_Int, paramlpc.d, paramlpc.e, paramlpc.jdField_b_of_type_Long, paramlpc.jdField_a_of_type_Boolean, a(), paramArrayOfByte1, paramlpc.f, paramlpc.g);
      paramlpc.b();
    }
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    if (e()) {
      return true;
    }
    int i = bhlo.a();
    if (i < 17)
    {
      lbj.c("EffectCtrlBase", "isUserEffectFace error  osVersion:" + i);
      return false;
    }
    return a(paramInt, paramLong, 1073741824L);
  }
  
  public static boolean a(int paramInt, long paramLong1, long paramLong2)
  {
    int i = llk.e();
    if (i < paramInt)
    {
      QLog.w("EffectCtrlBase", 1, "isSupportOfDevice fail, cpuCount[" + i + " < " + paramInt + "]");
      return false;
    }
    long l = llk.d();
    if ((l != 0L) && (l < paramLong1))
    {
      QLog.w("EffectCtrlBase", 1, "isSupportOfDevice fail, cpuFrequency[" + l + " < " + paramLong1 + "]");
      return false;
    }
    paramLong1 = bhlo.d();
    if (paramLong1 < paramLong2)
    {
      QLog.w("EffectCtrlBase", 1, "isSupportOfDevice fail, mem[" + paramLong1 + " < " + paramLong2 + "]");
      return false;
    }
    return true;
  }
  
  private void b(lpc paramlpc)
  {
    if (this.jdField_a_of_type_Lpc == paramlpc) {
      this.jdField_a_of_type_Lpc = null;
    }
    this.jdField_a_of_type_Lqi.a();
    byte[] arrayOfByte = paramlpc.jdField_a_of_type_ArrayOfByte;
    if (arrayOfByte != null) {
      ljp.a().a(arrayOfByte, 3);
    }
    a(paramlpc, this.jdField_a_of_type_Lqh);
    msb localmsb = paramlpc.jdField_a_of_type_Msb;
    localmsb.c();
    if (this.jdField_a_of_type_Lpq != null) {
      this.jdField_a_of_type_Lpq.a(paramlpc, this.jdField_a_of_type_Lqh, this, this.jdField_a_of_type_Lqi);
    }
    paramlpc.a();
    localmsb.d();
    if (arrayOfByte != null) {
      ljp.a().a(arrayOfByte, 0);
    }
    int i = lhx.a(this.jdField_a_of_type_Lqh.a, this.jdField_a_of_type_Lqh.b);
    GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(i, 1);
    if (this.jdField_a_of_type_Lqi.jdField_a_of_type_Lpc == null) {
      this.jdField_a_of_type_Lqi.jdField_a_of_type_Lpc = paramlpc;
    }
    this.jdField_a_of_type_Lqi.jdField_a_of_type_Lpc.jdField_a_of_type_Msb = localmsb;
    a(this.jdField_a_of_type_Lqi.jdField_a_of_type_Lpc, this.jdField_a_of_type_Lqi.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Lqi.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_Lqi.c, this.jdField_a_of_type_Lqi.jdField_a_of_type_Short, this.jdField_a_of_type_Lqi.jdField_b_of_type_Short);
  }
  
  public static boolean b()
  {
    return (boem.b()) && (bdek.a());
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
    lor locallor = lor.a();
    if ((locallor != null) && (locallor.f()))
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
    if ((locallor != null) && (!locallor.e()))
    {
      lbj.e("EffectCtrlBase", "isUserEffectFace| model in black list.modle=" + Build.MANUFACTURER + ":" + Build.MODEL);
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
    if (this.jdField_a_of_type_Lpq != null) {
      this.jdField_a_of_type_Lpq.a();
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
    if (this.jdField_a_of_type_Lpq != null) {
      this.jdField_a_of_type_Lpq.a(paramLong);
    }
  }
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      b(muk.a(paramMessage.obj));
      return;
    case 2: 
      c(muk.a(paramMessage.obj));
      return;
    case 3: 
      b((lpc)paramMessage.obj);
      return;
    case 4: 
      a(muk.a(paramMessage.obj), lje.jdField_b_of_type_Int, lje.jdField_a_of_type_Int);
      return;
    case 5: 
      e();
      return;
    }
    g();
  }
  
  public void a(lpc paramlpc)
  {
    int i;
    if (paramlpc.jdField_a_of_type_AndroidGraphicsSurfaceTexture != null) {
      i = 1;
    }
    while (i == 0)
    {
      paramlpc.b();
      return;
      this.jdField_a_of_type_Lqd.a(paramlpc.jdField_a_of_type_ArrayOfByte, paramlpc.jdField_a_of_type_Int, paramlpc.jdField_b_of_type_Int, paramlpc.jdField_c_of_type_Int, paramlpc.d, paramlpc.jdField_a_of_type_Long, paramlpc.jdField_a_of_type_Boolean, paramlpc.jdField_c_of_type_Long);
      if ((paramlpc.jdField_a_of_type_ArrayOfByte != null) && (paramlpc.jdField_a_of_type_Int != 0) && (paramlpc.jdField_b_of_type_Int != 0)) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(3))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      if ((this.jdField_a_of_type_Lpc == null) || (this.jdField_a_of_type_Lpc == paramlpc)) {}
    }
    try
    {
      this.jdField_a_of_type_Lpc.b();
      label129:
      this.jdField_a_of_type_Lpc = null;
      if (paramlpc.jdField_a_of_type_ArrayOfByte != null) {
        ljp.a().a(2, 0);
      }
      if (paramlpc.jdField_a_of_type_ArrayOfByte != null) {
        ljp.a().a(paramlpc.jdField_a_of_type_ArrayOfByte, 2);
      }
      this.jdField_a_of_type_Lpc = paramlpc;
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, paramlpc).sendToTarget();
      return;
    }
    catch (Throwable localThrowable)
    {
      break label129;
    }
  }
  
  protected abstract void a(lpc paramlpc, lqh paramlqh);
  
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
      if (this.jdField_a_of_type_Lpq != null) {
        this.jdField_a_of_type_Lpq.a(paramLong, b());
      }
    } while (!lje.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Lpq.a(paramLong, lje.jdField_b_of_type_Int, lje.jdField_a_of_type_Int);
  }
  
  public void c()
  {
    long l = AudioHelper.b();
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.obj = Long.valueOf(l);
    localMessage.sendToTarget();
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Ljl);
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
    if (this.jdField_a_of_type_Lpq != null) {
      this.jdField_a_of_type_Lpq.b(paramLong);
    }
    super.d();
  }
  
  public void d()
  {
    long l = AudioHelper.b();
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(this.jdField_a_of_type_Ljl);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = Long.valueOf(l);
    localMessage.sendToTarget();
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EffectCtrlBase", 2, "unInitInGL, p[" + this.jdField_a_of_type_Lpq + "]");
    }
    if (this.jdField_a_of_type_Lpq != null) {
      this.jdField_a_of_type_Lpq.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lpk
 * JD-Core Version:    0.7.0.1
 */