package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.page.WebviewContainer;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.util.HashMap;

class FileJsPlugin$7
  implements Runnable
{
  FileJsPlugin$7(FileJsPlugin paramFileJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.jsPluginEngine.appBrandRuntime.getCurWebviewContainer();
    if (localObject1 != null)
    {
      ((WebviewContainer)localObject1).swipeRefreshLayout.setEnabled(false);
      localObject1 = MiniAppFileManager.getInstance().getAbsolutePath(this.val$filePath);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        Object localObject2 = new VFSFile((String)localObject1);
        if ((((VFSFile)localObject2).exists()) && (((VFSFile)localObject2).canRead()))
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("style", "1");
          ((HashMap)localObject2).put("local", "true");
          ((HashMap)localObject2).put("topBarBgColor", "#808080");
          if (QbSdk.openFileReader(this.this$0.jsPluginEngine.getActivityContext(), (String)localObject1, (HashMap)localObject2, new FileJsPlugin.7.1(this)) > 0) {
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
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */