package cooperation.qzone.webviewplugin;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qzonehub.api.IQzoneShareApi;
import java.util.Map;

final class QZoneWebViewJsHandleLogic$2
  implements Runnable
{
  QZoneWebViewJsHandleLogic$2(WebViewPlugin.PluginRuntime paramPluginRuntime, Map paramMap, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    Object localObject = this.val$runtime.d();
    if (localObject != null)
    {
      if (((Activity)localObject).isFinishing()) {
        return;
      }
      localObject = (Bitmap)this.val$wrapper.remove("image");
      ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).addObserver(QZoneWebViewJsHandleLogic.wxShareListener);
      ((IQzoneShareApi)QRoute.api(IQzoneShareApi.class)).shareMiniProgram(this.val$title, (Bitmap)localObject, this.val$description, this.val$webpageUrl, this.val$path, this.val$userName, null, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.webviewplugin.QZoneWebViewJsHandleLogic.2
 * JD-Core Version:    0.7.0.1
 */