package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mpx;

class FileJsPlugin$16
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$16(FileJsPlugin paramFileJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, String paramString3, long paramLong) {}
  
  public String run()
  {
    if ((MiniAppFileManager.getInstance().getWxFileType(this.val$zipFilePath) == 9999) && (!MiniAppFileManager.getInstance().isPackageRelativePath(this.val$zipFilePath))) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$zipFilePath, this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$targetPath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$targetPath, this.val$callbackId);
    }
    String str1 = MiniAppFileManager.getInstance().getAbsolutePath(this.val$zipFilePath);
    String str2 = MiniAppFileManager.getInstance().getUsrPath(this.val$targetPath);
    if ((TextUtils.isEmpty(str1)) || (!new File(str1).exists())) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$zipFilePath, this.val$callbackId);
    }
    int i = mpx.a(str1, str2);
    QLog.d("[mini] FileJsPlugin", 1, "unzip [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], zipPath:" + str1 + ", target:" + str2);
    if (i == 0) {
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
    }
    return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "read zip data", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.16
 * JD-Core Version:    0.7.0.1
 */