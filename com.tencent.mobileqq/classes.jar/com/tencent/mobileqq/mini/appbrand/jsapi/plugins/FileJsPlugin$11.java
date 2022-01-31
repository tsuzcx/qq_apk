package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class FileJsPlugin$11
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$11(FileJsPlugin paramFileJsPlugin, String paramString1, long paramLong, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public String run()
  {
    String str = MiniAppFileManager.getInstance().getAbsolutePath(this.val$path);
    QLog.d("[mini] FileJsPlugin", 1, "accessFile [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], aboFilePath:" + str);
    if ((TextUtils.isEmpty(str)) || (!new File(str).exists())) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "no such file or directory \"" + this.val$path + "\"", this.val$callbackId);
    }
    return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */