package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bglv;
import bgnt;
import bgok;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.IOException;

class FileJsPlugin$16
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$16(FileJsPlugin paramFileJsPlugin, String paramString1, byte[] paramArrayOfByte, bgok parambgok, String paramString2, String paramString3, long paramLong) {}
  
  public String run()
  {
    if ((this.val$data == null) && (this.val$nativeBufferBytes == null)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid data ");
    }
    if (!FileJsPlugin.access$300(this.this$0, this.val$encoding)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid encoding " + this.val$encoding);
    }
    if (bgnt.a().a(this.val$filePath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$filePath);
    }
    Object localObject = this.this$0.mMiniAppInfo;
    long l1;
    if (localObject != null)
    {
      l1 = ((MiniAppInfo)localObject).usrFileSizeLimit;
      localObject = bgnt.a();
      if (this.val$nativeBufferBytes == null) {
        break label223;
      }
    }
    label223:
    for (long l2 = this.val$nativeBufferBytes.length;; l2 = this.val$data.length())
    {
      if (((bgnt)localObject).a(2, l2, this.this$0.mIsMiniGame, l1, this.this$0.mMiniAppInfo, this.this$0.mMiniAppContext.a())) {
        break label235;
      }
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
      l1 = 0L;
      break;
    }
    label235:
    String str2 = bgnt.a().c(this.val$filePath);
    if (!TextUtils.isEmpty(str2)) {}
    for (;;)
    {
      try
      {
        if (!FileJsPlugin.access$400(this.this$0, this.val$nativeBufferBytes, this.val$data, this.val$encoding, str2, false))
        {
          StringBuilder localStringBuilder = new StringBuilder().append("writeFile failed! path:").append(str2).append(",encoding:").append(this.val$encoding).append(",nativeBufferBytes:");
          if (this.val$nativeBufferBytes == null) {
            break label510;
          }
          localObject = Integer.valueOf(this.val$nativeBufferBytes.length);
          localStringBuilder = localStringBuilder.append(localObject).append(",data:");
          if (this.val$data != null)
          {
            localObject = Integer.valueOf(this.val$data.length());
            QMLog.e("FileJsPlugin", localObject);
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
      QMLog.d("FileJsPlugin", "writeFile [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], aboFilePath:" + str2);
      return FileJsPlugin.access$200(this.this$0, this.val$req, null);
      label510:
      String str1 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.16
 * JD-Core Version:    0.7.0.1
 */