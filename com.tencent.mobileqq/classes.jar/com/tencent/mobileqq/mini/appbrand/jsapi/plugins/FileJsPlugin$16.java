package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.File;
import nmk;

class FileJsPlugin$16
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$16(FileJsPlugin paramFileJsPlugin, String paramString1, String paramString2, long paramLong, JsRuntime paramJsRuntime, int paramInt, String paramString3) {}
  
  public String run()
  {
    boolean bool = false;
    long l2 = System.currentTimeMillis();
    if ((MiniAppFileManager.getInstance().getWxFileType(this.val$zipFilePath) == 9999) && (!MiniAppFileManager.getInstance().isPackageRelativePath(this.val$zipFilePath)))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l2, this.val$zipFilePath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$zipFilePath, this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$targetPath) != 2)
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l2, this.val$targetPath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$targetPath, this.val$callbackId);
    }
    String str1 = MiniAppFileManager.getInstance().getAbsolutePath(this.val$zipFilePath);
    String str2 = MiniAppFileManager.getInstance().getUsrPath(this.val$targetPath);
    if ((TextUtils.isEmpty(str1)) || (!new File(str1).exists()))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l2, str1);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$zipFilePath, this.val$callbackId);
    }
    long l1 = FileUtils.getFileOrFolderSize(str2);
    int i = nmk.a(str1, str2);
    FileJsPlugin localFileJsPlugin = this.this$0;
    String str3 = this.val$event;
    if (i == 0) {
      bool = true;
    }
    FileJsPlugin.access$100(localFileJsPlugin, str3, bool, this.val$startMS, l2, str1);
    if (i == 0)
    {
      l2 = FileUtils.getFileOrFolderSize(str2);
      MiniAppFileManager.getInstance().updateFolderSize(2, l2 - l1);
      return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
    }
    return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "read zip data", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.16
 * JD-Core Version:    0.7.0.1
 */