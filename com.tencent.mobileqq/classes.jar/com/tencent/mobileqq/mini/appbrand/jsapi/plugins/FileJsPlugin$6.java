package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import org.json.JSONObject;

class FileJsPlugin$6
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$6(FileJsPlugin paramFileJsPlugin, String paramString1, JSONObject paramJSONObject, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public String run()
  {
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$params.isNull("dirPath"))) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "invalid path", this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$dirPath) == 2)
    {
      if (!TextUtils.isEmpty(MiniAppFileManager.getInstance().getAbsolutePath(this.val$dirPath))) {
        return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "file already exists " + this.val$dirPath, this.val$callbackId);
      }
      String str = MiniAppFileManager.getInstance().getUsrPath(this.val$dirPath);
      if ((!TextUtils.isEmpty(str)) && (new VFSFile(str).mkdirs())) {
        return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
      }
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$dirPath, this.val$callbackId);
    }
    return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$dirPath, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */