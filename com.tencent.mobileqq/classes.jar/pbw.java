import com.tencent.biz.common.util.Util;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.OfflinePlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserOfflineHandler.CheckOfflineCallback;
import com.tencent.qphone.base.util.QLog;

public class pbw
  implements SwiftBrowserOfflineHandler.CheckOfflineCallback
{
  public pbw(OfflinePlugin paramOfflinePlugin, long paramLong, String paramString) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.c = ((int)(System.currentTimeMillis() - this.jdField_a_of_type_Long));
    if (QLog.isColorLevel()) {
      QLog.i("OfflinePluginQQ", 2, "onCheckOfflineFinish, cost: " + this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.c + ", url: " + Util.b(this.jdField_a_of_type_JavaLangString, new String[0]));
    }
    this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.a(this.jdField_a_of_type_JavaLangString, paramInt);
    CustomWebView localCustomWebView = this.jdField_a_of_type_ComTencentBizWebviewpluginOfflinePlugin.mRuntime.a();
    if (localCustomWebView != null)
    {
      localCustomWebView.a(this.jdField_a_of_type_JavaLangString);
      return;
    }
    QLog.e("OfflinePluginQQ", 1, "error!!!! webview is null, now can not loadUrl " + this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pbw
 * JD-Core Version:    0.7.0.1
 */