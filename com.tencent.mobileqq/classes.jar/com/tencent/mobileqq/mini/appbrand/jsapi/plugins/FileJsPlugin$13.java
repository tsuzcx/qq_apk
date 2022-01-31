package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;

class FileJsPlugin$13
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$13(FileJsPlugin paramFileJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, String paramString3, long paramLong) {}
  
  public String run()
  {
    if ((MiniAppFileManager.getInstance().getWxFileType(this.val$srcPath) == 9999) && (!MiniAppFileManager.getInstance().isPackageRelativePath(this.val$srcPath))) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$srcPath, this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$destPath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$srcPath, this.val$callbackId);
    }
    String str1 = MiniAppFileManager.getInstance().getAbsolutePath(this.val$srcPath);
    String str2 = MiniAppFileManager.getInstance().getUsrPath(this.val$destPath);
    if (!MiniAppFileManager.getInstance().isFolderCanWrite(2, FileUtils.getFileSizes(str1))) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "the maximum size of the file storage is exceeded", this.val$callbackId);
    }
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      boolean bool = FileUtils.copyFile(str1, str2);
      QLog.d("[mini] FileJsPlugin", 1, "copyFile [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], src:" + str1 + ", dest:" + str2);
      if (bool) {
        return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
      }
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "permission denied, open ", this.val$callbackId);
    }
    return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open ", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */