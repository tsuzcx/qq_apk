package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class FileJsPlugin$8
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$8(FileJsPlugin paramFileJsPlugin, String paramString1, byte[] paramArrayOfByte, JsRuntime paramJsRuntime, String paramString2, int paramInt, String paramString3, String paramString4, long paramLong) {}
  
  public String run()
  {
    if ((this.val$data == null) && (this.val$nativeBufferBytes == null)) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "invalid data ", this.val$callbackId);
    }
    if (!FileJsPlugin.access$300(this.this$0, this.val$encoding)) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "invalid encoding " + this.val$encoding, this.val$callbackId);
    }
    if (MiniAppFileManager.getInstance().getWxFileType(this.val$filePath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "permission denied, open " + this.val$filePath, this.val$callbackId);
    }
    Object localObject = MiniAppFileManager.getInstance();
    if (this.val$nativeBufferBytes != null) {}
    for (long l = this.val$nativeBufferBytes.length; !((MiniAppFileManager)localObject).isFolderCanWrite(2, l); l = this.val$data.length()) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "the maximum size of the file storage is exceeded", this.val$callbackId);
    }
    String str2 = MiniAppFileManager.getInstance().getUsrPath(this.val$filePath);
    if (!TextUtils.isEmpty(str2)) {}
    for (;;)
    {
      try
      {
        if (!FileJsPlugin.access$400(this.this$0, this.val$nativeBufferBytes, this.val$data, this.val$encoding, str2, false))
        {
          StringBuilder localStringBuilder = new StringBuilder().append("writeFile failed! path:").append(str2).append(",encoding:").append(this.val$encoding).append(",nativeBufferBytes:");
          if (this.val$nativeBufferBytes == null) {
            break label515;
          }
          localObject = Integer.valueOf(this.val$nativeBufferBytes.length);
          localStringBuilder = localStringBuilder.append(localObject).append(",data:");
          if (this.val$data != null)
          {
            localObject = Integer.valueOf(this.val$data.length());
            QLog.e("[mini] FileJsPlugin", 1, localObject);
            return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "failed to  write file" + str2, this.val$callbackId);
          }
          localObject = "null";
          continue;
          return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "the maximum size of the file storage is exceeded", this.val$callbackId);
        }
      }
      catch (IOException localIOException)
      {
        return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, localIOException.getMessage(), this.val$callbackId);
      }
      QLog.d("[mini] FileJsPlugin", 1, "writeFile [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], aboFilePath:" + str2);
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, null, this.val$callbackId);
      label515:
      String str1 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */