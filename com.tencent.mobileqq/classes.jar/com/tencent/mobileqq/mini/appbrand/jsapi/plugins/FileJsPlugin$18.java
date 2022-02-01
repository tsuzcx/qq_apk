package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.File;

class FileJsPlugin$18
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$18(FileJsPlugin paramFileJsPlugin, String paramString1, String paramString2, long paramLong, JsRuntime paramJsRuntime, int paramInt, String paramString3) {}
  
  public String run()
  {
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(this.val$oldPath))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, this.val$oldPath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "invalid path", this.val$callbackId);
    }
    int i = MiniAppFileManager.getInstance().getWxFileType(this.val$oldPath);
    int j = MiniAppFileManager.getInstance().getWxFileType(this.val$newPath);
    if (i != 2)
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, this.val$oldPath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$oldPath, this.val$callbackId);
    }
    if (j != 2)
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, this.val$newPath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$newPath, this.val$callbackId);
    }
    String str1 = MiniAppFileManager.getInstance().getAbsolutePath(this.val$oldPath);
    String str2 = MiniAppFileManager.getInstance().getUsrPath(this.val$newPath);
    if (!new File(str1).exists())
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, str1);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$oldPath, this.val$callbackId);
    }
    if (FileUtils.rename(str1, str2))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, true, this.val$startMS, l, str1);
      return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
    }
    FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, this.val$oldPath);
    return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open ", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.18
 * JD-Core Version:    0.7.0.1
 */