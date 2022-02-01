import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSSwitchManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry;
import mqq.os.MqqHandler;

public class qof
{
  public static qof a;
  private boolean a;
  private boolean b;
  private boolean c;
  
  static
  {
    jdField_a_of_type_Qof = new qof();
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
    qnr.b();
    PTSNativeModuleRegistry.registerNativeModule("RequestFeedsModule", new qnl());
    PTSNativeModuleRegistry.registerNativeModule("NavigateToModule", new qnj());
    PTSNativeModuleRegistry.registerNativeModule("AllInOneJumpModule", new qnd());
    PTSNativeModuleRegistry.registerNativeModule("LoadFeedsModule", new qng());
    PTSNativeModuleRegistry.registerNativeModule("HandleJSException", new qnf());
    PTSNativeModuleRegistry.registerNativeModule("ReportTo1160", new qnk());
    PTSNativeModuleRegistry.registerNativeModule("MarkArticleRead", new qni());
    qmv.a().a();
    qmt.a().a();
  }
  
  private void d()
  {
    qnr.c();
    PTSNativeModuleRegistry.clearNativeModule();
    qlt.a().a();
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
 * Qualified Name:     qof
 * JD-Core Version:    0.7.0.1
 */