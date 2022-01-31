import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSSwitchManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry;
import mqq.os.MqqHandler;

public class pxb
{
  public static pxb a;
  private boolean a;
  private boolean b;
  private boolean c;
  
  static
  {
    jdField_a_of_type_Pxb = new pxb();
  }
  
  private void b()
  {
    this.c = false;
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    d();
  }
  
  private void c()
  {
    d();
    pwt.b();
    PTSNativeModuleRegistry.registerNativeModule("RequestFeedsModule", new pwo());
    PTSNativeModuleRegistry.registerNativeModule("NavigateToModule", new pwm());
    PTSNativeModuleRegistry.registerNativeModule("AllInOneJumpModule", new pwg());
    PTSNativeModuleRegistry.registerNativeModule("LoadFeedsModule", new pwj());
    PTSNativeModuleRegistry.registerNativeModule("HandleJSException", new pwi());
    PTSNativeModuleRegistry.registerNativeModule("ReportTo1160", new pwn());
    PTSNativeModuleRegistry.registerNativeModule("MarkArticleRead", new pwl());
    pvy.a().a();
    pvw.a().a();
  }
  
  private void d()
  {
    pwt.c();
    PTSNativeModuleRegistry.clearNativeModule();
    pvi.a().a();
  }
  
  void a()
  {
    b();
    PTSSwitchManager.1 local1 = new PTSSwitchManager.1(this);
    ThreadManager.getSubThreadHandler().post(local1);
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Boolean) || (this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pxb
 * JD-Core Version:    0.7.0.1
 */