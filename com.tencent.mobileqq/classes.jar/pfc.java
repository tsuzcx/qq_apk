import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.viewplugin.ViewPluginManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class pfc
  implements Runnable
{
  public pfc(ViewPluginManager paramViewPluginManager) {}
  
  public void run()
  {
    String str = "http://" + this.a.b + "?_bid=" + this.a.jdField_a_of_type_JavaLangString;
    if (TextUtils.isEmpty(str)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ViewPluginManager", 2, "checkOfflineUpNotCallback.");
    }
    HtmlOffline.b(str, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getAppRuntime());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pfc
 * JD-Core Version:    0.7.0.1
 */