import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserMiscHandler;
import com.tencent.qphone.base.util.QLog;

class phq
  implements Runnable
{
  phq(php paramphp, SwiftBrowserComponentsProvider.SwiftBrowserComponentProviderSupporter paramSwiftBrowserComponentProviderSupporter) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.e("shareWebPage", 2, "WebView screenshot START. shareUrl=" + this.jdField_a_of_type_Php.a);
    }
    ((SwiftBrowserMiscHandler)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider$SwiftBrowserComponentProviderSupporter.b().a(32)).a(270, 270, new phr(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phq
 * JD-Core Version:    0.7.0.1
 */