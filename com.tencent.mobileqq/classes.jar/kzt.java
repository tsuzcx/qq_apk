import com.tencent.biz.pubaccount.ecshopassit.BusinessReporter;
import com.tencent.biz.webviewplugin.BusinessReportPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;

public final class kzt
  implements Runnable
{
  public kzt(String paramString, WebViewPluginEngine paramWebViewPluginEngine) {}
  
  public void run()
  {
    
    if ((BusinessReporter.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(new String[] { "JD_REPORT" });
      WebViewPlugin localWebViewPlugin = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a("JD_REPORT");
      if (localWebViewPlugin != null) {
        ((BusinessReportPlugin)localWebViewPlugin).b(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kzt
 * JD-Core Version:    0.7.0.1
 */