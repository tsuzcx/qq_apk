import android.os.SystemClock;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class oyv
  implements Runnable
{
  public oyv(AbsBaseWebViewActivity paramAbsBaseWebViewActivity) {}
  
  public void run()
  {
    SystemClock.uptimeMillis();
    synchronized (this.a.jdField_a_of_type_JavaLangObject)
    {
      if (this.a.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
        this.a.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web"));
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine == null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine = WebAccelerateHelper.getInstance().createWebViewPluginEngine(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, this.a, null, null);
        WebAccelerateHelper.getInstance().onPluginRuntimeReady(this.a.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine, this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, this.a);
        SystemClock.uptimeMillis();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyv
 * JD-Core Version:    0.7.0.1
 */