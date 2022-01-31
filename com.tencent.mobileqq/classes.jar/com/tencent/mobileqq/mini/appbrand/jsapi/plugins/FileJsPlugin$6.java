package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import bace;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class FileJsPlugin$6
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$6(FileJsPlugin paramFileJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, String paramString3, long paramLong) {}
  
  public String run()
  {
    Object localObject = MiniAppFileManager.getInstance().getAbsolutePath(this.val$tempFilePath);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "tempFilePath file not exist", this.val$callbackId);
    }
    if (TextUtils.isEmpty(this.val$filePath))
    {
      if (!MiniAppFileManager.getInstance().isFolderCanWrite(1, bace.a((String)localObject))) {
        return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "the maximum size of the file storage is exceeded", this.val$callbackId);
      }
      str = MiniAppFileManager.getInstance().savePath(this.val$tempFilePath);
      if (!TextUtils.isEmpty(str))
      {
        localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("savedFilePath", str);
          QLog.d("[mini] FileJsPlugin", 1, "saveFile old succeed! [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], saveFilePath:" + str);
          return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, (JSONObject)localObject, this.val$callbackId);
        }
        catch (Throwable localThrowable1)
        {
          for (;;)
          {
            localThrowable1.printStackTrace();
          }
        }
      }
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, null, this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$filePath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$filePath, this.val$callbackId);
    }
    if (!MiniAppFileManager.getInstance().isFolderCanWrite(2, bace.a((String)localObject))) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "the maximum size of the file storage is exceeded", this.val$callbackId);
    }
    String str = MiniAppFileManager.getInstance().getUsrPath(this.val$filePath);
    bace.d((String)localObject, str);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("savedFilePath", this.val$filePath);
      QLog.d("[mini] FileJsPlugin", 1, "saveFile succeed! [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], saveAboPath:" + str);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, (JSONObject)localObject, this.val$callbackId);
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        localThrowable2.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.6
 * JD-Core Version:    0.7.0.1
 */