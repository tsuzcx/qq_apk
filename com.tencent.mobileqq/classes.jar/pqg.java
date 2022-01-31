import android.os.HandlerThread;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSSwitchManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.utils.PTSLog;
import mqq.os.MqqHandler;

public class pqg
{
  public static pqg a;
  private boolean a;
  private boolean b;
  private boolean c;
  
  static
  {
    jdField_a_of_type_Pqg = new pqg();
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
    PTSLog.registerLogger(new pqd());
    PTSNodeFactory.registerNodeBuilder("img", new pqb());
    PTSNativeModuleRegistry.registerNativeModule("RequestFeedsModule", new ppx());
    PTSNativeModuleRegistry.registerNativeModule("NavigateToModule", new ppv());
    PTSNativeModuleRegistry.registerNativeModule("AllInOneJumpModule", new ppp());
    PTSNativeModuleRegistry.registerNativeModule("LoadFeedsModule", new pps());
    PTSNativeModuleRegistry.registerNativeModule("HandleJSException", new ppr());
    PTSNativeModuleRegistry.registerNativeModule("ReportTo1160", new ppw());
    PTSNativeModuleRegistry.registerNativeModule("MarkArticleRead", new ppu());
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("readinjoy-common-pts-sub", 0);
    localHandlerThread.start();
    PTSThreadUtil.registerSubHandlerThread(localHandlerThread);
    ppj.a().a();
    pph.a().a();
  }
  
  private void d()
  {
    PTSNativeModuleRegistry.clearNativeModule();
    ppa.a().a();
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
    return this.b;
  }
  
  public boolean d()
  {
    return (this.jdField_a_of_type_Boolean) || (this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pqg
 * JD-Core Version:    0.7.0.1
 */