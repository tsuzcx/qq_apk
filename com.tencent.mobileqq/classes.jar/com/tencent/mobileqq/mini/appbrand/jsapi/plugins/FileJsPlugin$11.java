package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;

class FileJsPlugin$11
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$11(FileJsPlugin paramFileJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public String run()
  {
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$filePath) == 9999) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "invalid path" + this.val$filePath, this.val$callbackId);
    }
    String str = MiniAppFileManager.getInstance().getAbsolutePath(this.val$filePath);
    if (TextUtils.isEmpty(str)) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$filePath, this.val$callbackId);
    }
    if (new VFSFile(str).isDirectory()) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "operation not permitted, unlink " + this.val$filePath, this.val$callbackId);
    }
    if (!new VFSFile(str).exists()) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$filePath, this.val$callbackId);
    }
    FileUtils.delete(str, false);
    return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */