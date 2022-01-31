package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import bace;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.File;

class FileJsPlugin$18
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$18(FileJsPlugin paramFileJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, String paramString3) {}
  
  public String run()
  {
    if (TextUtils.isEmpty(this.val$oldPath)) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "invalid path", this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$oldPath) == 9999) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$oldPath, this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$newPath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$newPath, this.val$callbackId);
    }
    String str1 = MiniAppFileManager.getInstance().getAbsolutePath(this.val$oldPath);
    String str2 = MiniAppFileManager.getInstance().getUsrPath(this.val$newPath);
    if (!new File(str1).exists()) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$oldPath, this.val$callbackId);
    }
    if (bace.c(str1, str2)) {
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
    }
    return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open ", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.18
 * JD-Core Version:    0.7.0.1
 */