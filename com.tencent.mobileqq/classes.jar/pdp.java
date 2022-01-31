import android.app.Activity;
import com.tencent.biz.webviewplugin.WebSoPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webview.webso.WebSoUtils;

public class pdp
  implements Runnable
{
  public pdp(WebSoPlugin paramWebSoPlugin, String paramString) {}
  
  public void run()
  {
    if ((WebSoUtils.c(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin.mRuntime != null) && (this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin.mRuntime.a() != null)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginWebSoPlugin.mRuntime.a().runOnUiThread(new pdq(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pdp
 * JD-Core Version:    0.7.0.1
 */