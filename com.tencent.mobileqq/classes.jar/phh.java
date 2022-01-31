import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebUiMethodInterface;
import com.tencent.smtt.sdk.WebView;

public class phh
  implements Runnable
{
  public phh(QzonePlugin paramQzonePlugin) {}
  
  public void run()
  {
    if (QzonePlugin.a(this.a) != null)
    {
      Object localObject = QzonePlugin.a(this.a);
      if (this.a.mRuntime.a().getIntent().getExtras().getString("url") != null) {
        localObject = this.a.mRuntime.a().getIntent().getExtras().getString("url");
      }
      QzonePlugin.a(this.a).loadData(new String((String)localObject).replaceAll("#", "%23").replaceAll("%", "%25").replaceAll("'", "%27"), "text/html", "utf-8");
      localObject = this.a.mRuntime.a(this.a.mRuntime.a());
      if ((localObject != null) && ((localObject instanceof WebUiUtils.WebUiMethodInterface))) {
        ((WebUiUtils.WebUiMethodInterface)localObject).a(false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phh
 * JD-Core Version:    0.7.0.1
 */