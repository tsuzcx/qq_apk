package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.util.HashMap;

class FileJsPlugin$8
  implements Runnable
{
  FileJsPlugin$8(FileJsPlugin paramFileJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.jsPluginEngine.appBrandRuntime.getCurWebviewContainer();
    if (localObject1 != null)
    {
      ((WebviewContainer)localObject1).swipeRefreshLayout.setEnabled(false);
      localObject1 = MiniAppFileManager.getInstance().getAbsolutePath(this.val$filePath);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject2 = new File((String)localObject1);
        if ((((File)localObject2).exists()) && (((File)localObject2).canRead()))
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("style", "1");
          ((HashMap)localObject2).put("local", "true");
          ((HashMap)localObject2).put("topBarBgColor", "#808080");
          if (QbSdk.openFileReader(this.this$0.jsPluginEngine.getActivityContext(), (String)localObject1, (HashMap)localObject2, new FileJsPlugin.8.1(this)) > 0) {
            this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("[mini] FileJsPlugin", 2, "openDocument fail.");
      }
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, null, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */