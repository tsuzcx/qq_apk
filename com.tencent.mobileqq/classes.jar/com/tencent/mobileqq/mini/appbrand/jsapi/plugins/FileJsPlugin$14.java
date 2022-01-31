package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.appbrand.utils.MiniLog;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.IOException;

class FileJsPlugin$14
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$14(FileJsPlugin paramFileJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, String paramString3, String paramString4, byte[] paramArrayOfByte) {}
  
  public String run()
  {
    if (!FileJsPlugin.access$300(this.this$0, this.val$encoding)) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "invalid encoding " + this.val$encoding, this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$filePath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$filePath, this.val$callbackId);
    }
    String str = MiniAppFileManager.getInstance().getUsrPath(this.val$filePath);
    if (!TextUtils.isEmpty(str))
    {
      if (str.contains("miniprogramLog"))
      {
        MiniLog.writeMiniLog(this.this$0.jsPluginEngine.appBrandRuntime.appId, this.val$data);
        return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
      }
      try
      {
        if (FileJsPlugin.access$400(this.this$0, this.val$nativeBufferBytes, this.val$data, this.val$encoding, str, true))
        {
          str = FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
          return str;
        }
      }
      catch (IOException localIOException)
      {
        return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, localIOException.getMessage(), this.val$callbackId);
      }
    }
    return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open ", this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.14
 * JD-Core Version:    0.7.0.1
 */