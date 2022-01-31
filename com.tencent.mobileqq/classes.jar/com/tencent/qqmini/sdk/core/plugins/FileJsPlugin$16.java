package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bejl;
import bekr;
import betc;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.io.IOException;

class FileJsPlugin$16
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$16(FileJsPlugin paramFileJsPlugin, String paramString1, byte[] paramArrayOfByte, bekr parambekr, String paramString2, String paramString3, long paramLong) {}
  
  public String run()
  {
    if ((this.val$data == null) && (this.val$nativeBufferBytes == null)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid data ");
    }
    if (!FileJsPlugin.access$300(this.this$0, this.val$encoding)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid encoding " + this.val$encoding);
    }
    if (bejl.a().a(this.val$filePath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$filePath);
    }
    Object localObject = this.this$0.mMiniAppInfo;
    long l1;
    if (localObject != null)
    {
      l1 = ((MiniAppInfo)localObject).usrFileSizeLimit;
      localObject = bejl.a();
      if (this.val$nativeBufferBytes == null) {
        break label204;
      }
    }
    label204:
    for (long l2 = this.val$nativeBufferBytes.length;; l2 = this.val$data.length())
    {
      if (((bejl)localObject).a(2, l2, this.this$0.mIsMiniGame, l1)) {
        break label216;
      }
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
      l1 = 0L;
      break;
    }
    label216:
    String str2 = bejl.a().c(this.val$filePath);
    if (!TextUtils.isEmpty(str2)) {}
    for (;;)
    {
      try
      {
        if (!FileJsPlugin.access$400(this.this$0, this.val$nativeBufferBytes, this.val$data, this.val$encoding, str2, false))
        {
          StringBuilder localStringBuilder = new StringBuilder().append("writeFile failed! path:").append(str2).append(",encoding:").append(this.val$encoding).append(",nativeBufferBytes:");
          if (this.val$nativeBufferBytes == null) {
            break label491;
          }
          localObject = Integer.valueOf(this.val$nativeBufferBytes.length);
          localStringBuilder = localStringBuilder.append(localObject).append(",data:");
          if (this.val$data != null)
          {
            localObject = Integer.valueOf(this.val$data.length());
            betc.d("FileJsPlugin", localObject);
            return FileJsPlugin.access$100(this.this$0, this.val$req, null, "failed to  write file" + str2);
          }
          localObject = "null";
          continue;
          return FileJsPlugin.access$100(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
        }
      }
      catch (IOException localIOException)
      {
        return FileJsPlugin.access$100(this.this$0, this.val$req, null, localIOException.getMessage());
      }
      betc.a("FileJsPlugin", "writeFile [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], aboFilePath:" + str2);
      return FileJsPlugin.access$200(this.this$0, this.val$req, null);
      label491:
      String str1 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.16
 * JD-Core Version:    0.7.0.1
 */