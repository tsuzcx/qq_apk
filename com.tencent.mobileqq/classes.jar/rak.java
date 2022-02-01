import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSSwitchManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry;
import mqq.os.MqqHandler;

public class rak
{
  public static rak a;
  private boolean a;
  private boolean b;
  private boolean c;
  
  static
  {
    jdField_a_of_type_Rak = new rak();
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
    qzw.b();
    PTSNativeModuleRegistry.registerNativeModule("RequestFeedsModule", new qzq());
    PTSNativeModuleRegistry.registerNativeModule("NavigateToModule", new qzo());
    PTSNativeModuleRegistry.registerNativeModule("AllInOneJumpModule", new qzi());
    PTSNativeModuleRegistry.registerNativeModule("LoadFeedsModule", new qzl());
    PTSNativeModuleRegistry.registerNativeModule("HandleJSException", new qzk());
    PTSNativeModuleRegistry.registerNativeModule("ReportTo1160", new qzp());
    PTSNativeModuleRegistry.registerNativeModule("MarkArticleRead", new qzn());
    qza.a().a();
    qyy.a().a();
  }
  
  private void d()
  {
    qzw.c();
    PTSNativeModuleRegistry.clearNativeModule();
    qxy.a().a();
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
 * Qualified Name:     rak
 * JD-Core Version:    0.7.0.1
 */