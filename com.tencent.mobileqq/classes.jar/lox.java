import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.camera.CameraUtils;
import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public abstract class lox
  extends lpg
  implements low
{
  private static boolean jdField_a_of_type_Boolean;
  protected Context a;
  private ljd jdField_a_of_type_Ljd = new loy(this);
  public lpb a;
  private final lpm jdField_a_of_type_Lpm = new lpm();
  private final lpq jdField_a_of_type_Lpq = new lpq();
  private boolean b;
  
  private void a(long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Lpb.a(paramLong, b());
    this.jdField_a_of_type_Lpb.a(paramLong, paramInt1, paramInt2);
  }
  
  private void a(lop paramlop, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2)
  {
    if (paramlop != null)
    {
      paramArrayOfByte1 = a(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramShort1, paramShort2, (short)paramlop.jdField_a_of_type_Int, (short)paramlop.jdField_b_of_type_Int);
      if (paramlop.jdField_a_of_type_Mrd != null) {
        paramlop.jdField_a_of_type_Mrd.f();
      }
      GraphicRenderMgr.getInstance().sendCameraFrame(paramlop.jdField_a_of_type_ArrayOfByte, paramlop.jdField_c_of_type_Int, paramlop.jdField_a_of_type_Int, paramlop.jdField_b_of_type_Int, paramlop.d, paramlop.e, paramlop.jdField_b_of_type_Long, paramlop.jdField_a_of_type_Boolean, VideoController.a().a.a(), paramArrayOfByte1, paramlop.f, paramlop.g);
    }
  }
  
  public static boolean a(int paramInt, long paramLong)
  {
    if (e()) {
      return true;
    }
    int i = bgln.a();
    if (i < 17)
    {
      lbc.c("EffectCtrlBase", "isUserEffectFace error  osVersion:" + i);
      return false;
    }
    return a(paramInt, paramLong, 1073741824L);
  }
  
  public static boolean a(int paramInt, long paramLong1, long paramLong2)
  {
    int i = lkw.e();
    if (i < paramInt)
    {
      QLog.w("EffectCtrlBase", 1, "isSupportOfDevice fail, cpuCount[" + i + " < " + paramInt + "]");
      return false;
    }
    long l = lkw.d();
    if ((l != 0L) && (l < paramLong1))
    {
      QLog.w("EffectCtrlBase", 1, "isSupportOfDevice fail, cpuFrequency[" + l + " < " + paramLong1 + "]");
      return false;
    }
    paramLong1 = bgln.d();
    if (paramLong1 < paramLong2)
    {
      QLog.w("EffectCtrlBase", 1, "isSupportOfDevice fail, mem[" + paramLong1 + " < " + paramLong2 + "]");
      return false;
    }
    return true;
  }
  
  private void b(lop paramlop)
  {
    short s2 = 0;
    byte[] arrayOfByte1 = paramlop.jdField_a_of_type_ArrayOfByte;
    ljh.a().a(arrayOfByte1, 3);
    a(paramlop, this.jdField_a_of_type_Lpq);
    mrd localmrd = paramlop.jdField_a_of_type_Mrd;
    localmrd.c();
    if (this.jdField_a_of_type_Lpb != null) {}
    for (Object localObject1 = this.jdField_a_of_type_Lpb.a(paramlop, this.jdField_a_of_type_Lpq, this);; localObject1 = null)
    {
      localmrd.d();
      ljh.a().a(arrayOfByte1, 0);
      int i = lhp.a(this.jdField_a_of_type_Lpq.a, this.jdField_a_of_type_Lpq.b);
      GraphicRenderMgr.getInstance().setBeautyOrFaceConfig(i, 1);
      byte[] arrayOfByte2;
      short s1;
      if (localObject1 != null)
      {
        paramlop = ((lpd)localObject1).jdField_b_of_type_ArrayOfByte;
        arrayOfByte1 = ((lpd)localObject1).c;
        arrayOfByte2 = ((lpd)localObject1).d;
        s1 = ((lpd)localObject1).a;
        s2 = ((lpd)localObject1).jdField_b_of_type_Short;
      }
      for (;;)
      {
        ((lop)localObject1).jdField_a_of_type_Mrd = localmrd;
        a((lop)localObject1, paramlop, arrayOfByte1, arrayOfByte2, s1, s2);
        return;
        s1 = 0;
        arrayOfByte2 = null;
        arrayOfByte1 = null;
        Object localObject2 = null;
        localObject1 = paramlop;
        paramlop = localObject2;
      }
    }
  }
  
  public static boolean b()
  {
    return (bndd.b()) && (bcls.a());
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
    lod locallod = lod.a();
    if ((locallod != null) && (locallod.f()))
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
    if ((locallod != null) && (!locallod.e()))
    {
      lbc.e("EffectCtrlBase", "isUserEffectFace| model in black list.modle=" + Build.MANUFACTURER + ":" + Build.MODEL);
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
    if (this.jdField_a_of_type_Lpb != null) {
      this.jdField_a_of_type_Lpb.b();
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
    if (this.jdField_a_of_type_Lpb != null) {
      this.jdField_a_of_type_Lpb.a(paramLong);
    }
  }
  
  protected void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      b(mtl.a(paramMessage.obj));
      return;
    case 2: 
      c(mtl.a(paramMessage.obj));
      return;
    case 3: 
      b((lop)paramMessage.obj);
      return;
    case 4: 
      a(mtl.a(paramMessage.obj), liw.l, liw.k);
      return;
    case 5: 
      e();
      return;
    }
    g();
  }
  
  public void a(lop paramlop)
  {
    this.jdField_a_of_type_Lpm.a(paramlop.jdField_a_of_type_ArrayOfByte, paramlop.jdField_a_of_type_Int, paramlop.jdField_b_of_type_Int, paramlop.jdField_c_of_type_Int, paramlop.d, paramlop.jdField_a_of_type_Long, paramlop.jdField_a_of_type_Boolean, paramlop.jdField_c_of_type_Long);
    if ((paramlop.jdField_a_of_type_ArrayOfByte == null) || (paramlop.jdField_a_of_type_Int == 0) || (paramlop.jdField_b_of_type_Int == 0)) {
      return;
    }
    if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(3))
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(3);
      ljh.a().a(2, 0);
    }
    ljh.a().a(paramlop.jdField_a_of_type_ArrayOfByte, 2);
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3, paramlop).sendToTarget();
  }
  
  protected abstract void a(lop paramlop, lpq paramlpq);
  
  protected abstract byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2, short paramShort3, short paramShort4);
  
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
      if (this.jdField_a_of_type_Lpb != null) {
        this.jdField_a_of_type_Lpb.a(paramLong, b());
      }
    } while (!liw.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_Lpb.a(paramLong, liw.l, liw.k);
  }
  
  public void c()
  {
    long l = AudioHelper.b();
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.obj = Long.valueOf(l);
    localMessage.sendToTarget();
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_Ljd);
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
    if (this.jdField_a_of_type_Lpb != null) {
      this.jdField_a_of_type_Lpb.b(paramLong);
    }
    super.d();
  }
  
  public void d()
  {
    long l = AudioHelper.b();
    CameraUtils.a(this.jdField_a_of_type_AndroidContentContext).b(this.jdField_a_of_type_Ljd);
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(2);
    localMessage.obj = Long.valueOf(l);
    localMessage.sendToTarget();
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("EffectCtrlBase", 2, "unInitInGL, p[" + this.jdField_a_of_type_Lpb + "]");
    }
    if (this.jdField_a_of_type_Lpb != null) {
      this.jdField_a_of_type_Lpb.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lox
 * JD-Core Version:    0.7.0.1
 */