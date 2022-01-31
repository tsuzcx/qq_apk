import android.os.HandlerThread;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSSwitchManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.utils.PTSLog;
import mqq.os.MqqHandler;

public class pep
{
  public static pep a;
  private boolean a;
  private boolean b;
  
  static
  {
    jdField_a_of_type_Pep = new pep();
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    d();
  }
  
  private void c()
  {
    d();
    PTSLog.registerLogger(new pem());
    PTSNodeFactory.registerNodeBuilder("img", new pek());
    PTSNativeModuleRegistry.registerNativeModule("DailyRequestModule", new pdz());
    PTSNativeModuleRegistry.registerNativeModule("NavigateToModule", new peg());
    PTSNativeModuleRegistry.registerNativeModule("AllInOneJumpModule", new pdy());
    PTSNativeModuleRegistry.registerNativeModule("LoadDailyDBArticlesModule", new ped());
    PTSNativeModuleRegistry.registerNativeModule("HandleJSException", new pec());
    PTSNativeModuleRegistry.registerNativeModule("ReportTo1160", new peh());
    PTSNativeModuleRegistry.registerNativeModule("MarkArticleRead", new pef());
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("readinjoy-common-pts-sub", 0);
    localHandlerThread.start();
    PTSThreadUtil.registerSubHandlerThread(localHandlerThread);
    pdu.a().a();
    pds.a().a();
  }
  
  private void d()
  {
    PTSNativeModuleRegistry.clearNativeModule();
    pdl.a().a();
  }
  
  void a()
  {
    b();
    PTSSwitchManager.1 local1 = new PTSSwitchManager.1(this);
    ThreadManager.getSubThreadHandler().post(local1);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_Boolean) || (this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pep
 * JD-Core Version:    0.7.0.1
 */