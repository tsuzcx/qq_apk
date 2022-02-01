package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.utils.NativeBuffer;
import com.tencent.mobileqq.triton.sdk.bridge.ITNativeBufferPool;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class FileJsPlugin$10
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$10(FileJsPlugin paramFileJsPlugin, String paramString1, String paramString2, long paramLong, JsRuntime paramJsRuntime, int paramInt, String paramString3) {}
  
  public String run()
  {
    long l = System.currentTimeMillis();
    if (TextUtils.isEmpty(this.val$filePath))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, this.val$filePath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "invalid path", this.val$callbackId);
    }
    if (!FileJsPlugin.access$400(this.this$0, this.val$encoding))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, this.val$filePath);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "invalid encoding " + this.val$encoding, this.val$callbackId);
    }
    String str = MiniAppFileManager.getInstance().getAbsolutePath(this.val$filePath);
    if ((TextUtils.isEmpty(str)) || (!new File(str).exists()))
    {
      FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, str);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$filePath, this.val$callbackId);
    }
    for (;;)
    {
      try
      {
        Object localObject = FileJsPlugin.access$600(this.this$0, this.val$encoding, str);
        if (localObject == null)
        {
          QLog.e("[mini] FileJsPlugin", 1, "readFile failed! path:" + str);
          FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, str);
          return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$filePath, this.val$callbackId);
        }
        JSONObject localJSONObject = new JSONObject();
        if ((this.this$0.isGameRuntime) && ((localObject instanceof byte[])))
        {
          NativeBuffer.packNativeBuffer((byte[])localObject, NativeBuffer.TYPE_BUFFER_NATIVE, "data", localJSONObject, (ITNativeBufferPool)this.this$0.jsPluginEngine.getNativeBufferPool());
          FileJsPlugin.access$100(this.this$0, this.val$event, true, this.val$startMS, l, str);
          return FileJsPlugin.access$300(this.this$0, this.val$webview, this.val$event, localJSONObject, this.val$callbackId);
        }
        if ((!this.this$0.isGameRuntime) && ((localObject instanceof byte[]))) {
          NativeBuffer.packNativeBuffer((byte[])localObject, NativeBuffer.TYPE_BUFFER_BASE64, "data", localJSONObject, null);
        } else {
          localJSONObject.put("data", localThrowable);
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("[mini] FileJsPlugin", 1, "readFile failed! ", localThrowable);
        FileJsPlugin.access$100(this.this$0, this.val$event, false, this.val$startMS, l, str);
        return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, localThrowable.getMessage(), this.val$callbackId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */