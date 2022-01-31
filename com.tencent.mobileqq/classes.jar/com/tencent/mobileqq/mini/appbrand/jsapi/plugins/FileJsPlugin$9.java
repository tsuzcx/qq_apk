package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class FileJsPlugin$9
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$9(FileJsPlugin paramFileJsPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt, String paramString3, long paramLong) {}
  
  public String run()
  {
    if (TextUtils.isEmpty(this.val$filePath)) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "invalid path", this.val$callbackId);
    }
    if (!FileJsPlugin.access$300(this.this$0, this.val$encoding)) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "invalid encoding " + this.val$encoding, this.val$callbackId);
    }
    String str = MiniAppFileManager.getInstance().getAbsolutePath(this.val$filePath);
    if ((TextUtils.isEmpty(str)) || (!new VFSFile(str).exists())) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$filePath, this.val$callbackId);
    }
    for (;;)
    {
      try
      {
        Object localObject = FileJsPlugin.access$500(this.this$0, this.val$encoding, str);
        if (localObject == null)
        {
          QLog.e("[mini] FileJsPlugin", 1, "readFile failed! path:" + str);
          return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$filePath, this.val$callbackId);
        }
        JSONObject localJSONObject = new JSONObject();
        if ((this.this$0.isGameRuntime) && ((localObject instanceof byte[])))
        {
          NativeBuffer.packNativeBuffer((byte[])localObject, NativeBuffer.TYPE_BUFFER_NATIVE, "data", localJSONObject, (ITNativeBufferPool)this.this$0.jsPluginEngine.getNativeBufferPool());
          QLog.d("[mini] FileJsPlugin", 1, "readFile succeed! [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], aboFilePath:" + str);
          return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, localJSONObject, this.val$callbackId);
        }
        if ((!this.this$0.isGameRuntime) && ((localObject instanceof byte[]))) {
          NativeBuffer.packNativeBuffer((byte[])localObject, NativeBuffer.TYPE_BUFFER_BASE64, "data", localJSONObject, null);
        } else {
          localJSONObject.put("data", localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[mini] FileJsPlugin", 1, "readFile failed! ," + localThrowable.getMessage());
        return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, localThrowable.getMessage(), this.val$callbackId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */