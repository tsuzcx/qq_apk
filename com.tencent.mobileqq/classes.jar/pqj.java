import android.os.HandlerThread;
import com.tencent.biz.pubaccount.readinjoy.pts.util.PTSSwitchManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.utils.PTSLog;
import mqq.os.MqqHandler;

public class pqj
{
  public static pqj a;
  private boolean a;
  private boolean b;
  private boolean c;
  
  static
  {
    jdField_a_of_type_Pqj = new pqj();
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
    PTSLog.registerLogger(new pqg());
    PTSNodeFactory.registerNodeBuilder("img", new pqe());
    PTSNativeModuleRegistry.registerNativeModule("RequestFeedsModule", new pqa());
    PTSNativeModuleRegistry.registerNativeModule("NavigateToModule", new ppy());
    PTSNativeModuleRegistry.registerNativeModule("AllInOneJumpModule", new pps());
    PTSNativeModuleRegistry.registerNativeModule("LoadFeedsModule", new ppv());
    PTSNativeModuleRegistry.registerNativeModule("HandleJSException", new ppu());
    PTSNativeModuleRegistry.registerNativeModule("ReportTo1160", new ppz());
    PTSNativeModuleRegistry.registerNativeModule("MarkArticleRead", new ppx());
    HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("readinjoy-common-pts-sub", 0);
    localHandlerThread.start();
    PTSThreadUtil.registerSubHandlerThread(localHandlerThread);
    ppm.a().a();
    ppk.a().a();
  }
  
  private void d()
  {
    PTSNativeModuleRegistry.clearNativeModule();
    ppd.a().a();
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
 * Qualified Name:     pqj
 * JD-Core Version:    0.7.0.1
 */