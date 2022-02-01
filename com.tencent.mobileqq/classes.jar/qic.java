import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSSwitchManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry;
import mqq.os.MqqHandler;

public class qic
{
  public static qic a;
  private boolean a;
  private boolean b;
  private boolean c;
  
  static
  {
    jdField_a_of_type_Qic = new qic();
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
    qhq.b();
    PTSNativeModuleRegistry.registerNativeModule("RequestFeedsModule", new qhk());
    PTSNativeModuleRegistry.registerNativeModule("NavigateToModule", new qhi());
    PTSNativeModuleRegistry.registerNativeModule("AllInOneJumpModule", new qhc());
    PTSNativeModuleRegistry.registerNativeModule("LoadFeedsModule", new qhf());
    PTSNativeModuleRegistry.registerNativeModule("HandleJSException", new qhe());
    PTSNativeModuleRegistry.registerNativeModule("ReportTo1160", new qhj());
    PTSNativeModuleRegistry.registerNativeModule("MarkArticleRead", new qhh());
    qgu.a().a();
    qgs.a().a();
  }
  
  private void d()
  {
    qhq.c();
    PTSNativeModuleRegistry.clearNativeModule();
    qfx.a().a();
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
 * Qualified Name:     qic
 * JD-Core Version:    0.7.0.1
 */