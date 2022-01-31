package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class FileJsPlugin$16
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$16(FileJsPlugin paramFileJsPlugin, String paramString1, JSONObject paramJSONObject, JsRuntime paramJsRuntime, String paramString2, int paramInt, boolean paramBoolean) {}
  
  public String run()
  {
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$params.isNull("dirPath"))) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "fail parameter error: parameter.dirPath should be String instead of Null;", this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$dirPath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$dirPath, this.val$callbackId);
    }
    String str = MiniAppFileManager.getInstance().getUsrPath(this.val$dirPath);
    if (!new VFSFile(str).exists()) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$dirPath, this.val$callbackId);
    }
    if (this.val$recursive) {
      FileUtils.deleteDirectory(str);
    }
    for (;;)
    {
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
      FileUtils.deleteFilesInDirectory(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.16
 * JD-Core Version:    0.7.0.1
 */