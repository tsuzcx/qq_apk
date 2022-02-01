import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSSwitchManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry;
import mqq.os.MqqHandler;

public class qpo
{
  public static qpo a;
  private boolean a;
  private boolean b;
  private boolean c;
  
  static
  {
    jdField_a_of_type_Qpo = new qpo();
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
    qpc.b();
    PTSNativeModuleRegistry.registerNativeModule("RequestFeedsModule", new qoy());
    PTSNativeModuleRegistry.registerNativeModule("NavigateToModule", new qow());
    PTSNativeModuleRegistry.registerNativeModule("AllInOneJumpModule", new qoq());
    PTSNativeModuleRegistry.registerNativeModule("LoadFeedsModule", new qot());
    PTSNativeModuleRegistry.registerNativeModule("HandleJSException", new qos());
    PTSNativeModuleRegistry.registerNativeModule("ReportTo1160", new qox());
    PTSNativeModuleRegistry.registerNativeModule("MarkArticleRead", new qov());
    qoi.a().a();
    qog.a().a();
  }
  
  private void d()
  {
    qpc.c();
    PTSNativeModuleRegistry.clearNativeModule();
    qnm.a().a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qpo
 * JD-Core Version:    0.7.0.1
 */