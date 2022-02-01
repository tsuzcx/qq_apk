package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.io.IOException;

class FileJsPlugin$16
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$16(FileJsPlugin paramFileJsPlugin, String paramString1, byte[] paramArrayOfByte, RequestEvent paramRequestEvent, long paramLong, String paramString2, String paramString3) {}
  
  public String run()
  {
    long l2 = System.currentTimeMillis();
    if ((this.val$data == null) && (this.val$nativeBufferBytes == null))
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l2, this.val$filePath);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "invalid data ");
    }
    if (!FileJsPlugin.access$1400(this.this$0, this.val$encoding))
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l2, this.val$filePath);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "invalid encoding " + this.val$encoding);
    }
    if (((MiniAppFileManager)FileJsPlugin.access$6600(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$filePath) != 2)
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l2, this.val$filePath);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "permission denied, open " + this.val$filePath);
    }
    if (this.val$nativeBufferBytes != null) {}
    for (long l1 = this.val$nativeBufferBytes.length; !((MiniAppFileManager)FileJsPlugin.access$7000(this.this$0).getManager(MiniAppFileManager.class)).isFolderCanWrite(2, l1, FileJsPlugin.access$6700(this.this$0), FileJsPlugin.access$6800(this.this$0), FileJsPlugin.access$6900(this.this$0).getAttachedActivity()); l1 = this.val$data.length())
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l2, this.val$filePath);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
    }
    String str2 = ((MiniAppFileManager)FileJsPlugin.access$7100(this.this$0).getManager(MiniAppFileManager.class)).getUsrPath(this.val$filePath);
    if (!TextUtils.isEmpty(str2)) {}
    for (;;)
    {
      try
      {
        if (FileJsPlugin.access$1800(this.this$0, this.val$nativeBufferBytes, this.val$data, this.val$encoding, str2, false)) {
          break label634;
        }
        StringBuilder localStringBuilder = new StringBuilder().append("writeFile failed! path:").append(str2).append(",encoding:").append(this.val$encoding).append(",nativeBufferBytes:");
        if (this.val$nativeBufferBytes == null) {
          break label669;
        }
        Object localObject = Integer.valueOf(this.val$nativeBufferBytes.length);
        localStringBuilder = localStringBuilder.append(localObject).append(",data:");
        if (this.val$data != null)
        {
          localObject = Integer.valueOf(this.val$data.length());
          QMLog.e("FileJsPlugin", localObject);
          FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l2, str2);
          return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "failed to  write file" + str2);
        }
        localObject = "null";
        continue;
        FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l2, str2);
      }
      catch (IOException localIOException)
      {
        FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l2, str2);
        return FileJsPlugin.access$1200(this.this$0, this.val$req, null, localIOException.getMessage());
      }
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
      label634:
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, true, this.val$startMS, l2, str2);
      return FileJsPlugin.access$1300(this.this$0, this.val$req, null);
      label669:
      String str1 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.16
 * JD-Core Version:    0.7.0.1
 */