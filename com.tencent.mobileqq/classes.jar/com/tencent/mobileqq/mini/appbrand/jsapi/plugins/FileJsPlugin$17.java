package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.File;
import org.json.JSONObject;

class FileJsPlugin$17
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$17(FileJsPlugin paramFileJsPlugin, String paramString1, JSONObject paramJSONObject, String paramString2, long paramLong, JsRuntime paramJsRuntime, int paramInt, boolean paramBoolean) {}
  
  public String run()
  {
    long l2 = System.currentTimeMillis();
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$params.isNull("dirPath")))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l2, this.val$dirPath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "fail parameter error: parameter.dirPath should be String instead of Null;", this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$dirPath) != 2)
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l2, this.val$dirPath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$dirPath, this.val$callbackId);
    }
    String str = MiniAppFileManager.getInstance().getUsrPath(this.val$dirPath);
    if (!new File(str).exists())
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l2, str);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$dirPath, this.val$callbackId);
    }
    if (this.val$recursive) {}
    for (long l1 = FileUtils.deleteDirectory(str);; l1 = FileUtils.deleteFilesInDirectory(str))
    {
      MiniAppFileManager.getInstance().updateFolderSize(2, -l1);
      FileJsPlugin.access$100(this.this$0, this.val$event, true, this.val$startMS, l2, str);
      return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.17
 * JD-Core Version:    0.7.0.1
 */