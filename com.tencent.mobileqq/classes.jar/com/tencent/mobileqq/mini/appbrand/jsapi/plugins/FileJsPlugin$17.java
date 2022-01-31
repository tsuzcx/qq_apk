package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import bace;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.File;
import org.json.JSONObject;

class FileJsPlugin$17
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$17(FileJsPlugin paramFileJsPlugin, String paramString1, JSONObject paramJSONObject, JsRuntime paramJsRuntime, String paramString2, int paramInt, boolean paramBoolean) {}
  
  public String run()
  {
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$params.isNull("dirPath"))) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "fail parameter error: parameter.dirPath should be String instead of Null;", this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$dirPath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$dirPath, this.val$callbackId);
    }
    String str = MiniAppFileManager.getInstance().getUsrPath(this.val$dirPath);
    if (!new File(str).exists()) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$dirPath, this.val$callbackId);
    }
    if (this.val$recursive) {
      bace.a(str);
    }
    for (;;)
    {
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
      bace.b(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.17
 * JD-Core Version:    0.7.0.1
 */