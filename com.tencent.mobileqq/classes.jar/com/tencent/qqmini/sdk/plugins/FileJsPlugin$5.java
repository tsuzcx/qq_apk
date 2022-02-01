package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.MiniLog;
import java.io.IOException;

class FileJsPlugin$5
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$5(FileJsPlugin paramFileJsPlugin, String paramString1, RequestEvent paramRequestEvent, long paramLong, String paramString2, String paramString3, byte[] paramArrayOfByte) {}
  
  public String run()
  {
    long l = System.currentTimeMillis();
    if (!FileJsPlugin.access$1200(this.this$0, this.val$encoding))
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMs, l, this.val$filePath);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "invalid encoding " + this.val$encoding);
    }
    if (((MiniAppFileManager)FileJsPlugin.access$1300(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$filePath) != 2)
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMs, l, this.val$filePath);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "permission denied, open " + this.val$filePath);
    }
    String str1 = ((MiniAppFileManager)FileJsPlugin.access$1400(this.this$0).getManager(MiniAppFileManager.class)).getUsrPath(this.val$filePath);
    if (!TextUtils.isEmpty(str1))
    {
      if (str1.contains("miniprogramLog"))
      {
        MiniLog.writeMiniLog(FileJsPlugin.access$1500(this.this$0).appId, this.val$data);
        FileJsPlugin.access$900(this.this$0, this.val$req.event, true, this.val$startMs, l, str1);
        return FileJsPlugin.access$1100(this.this$0, this.val$req, null);
      }
      try
      {
        if (FileJsPlugin.access$1600(this.this$0, this.val$nativeBufferBytes, this.val$data, this.val$encoding, str1, true))
        {
          FileJsPlugin.access$900(this.this$0, this.val$req.event, true, this.val$startMs, l, str1);
          String str2 = FileJsPlugin.access$1100(this.this$0, this.val$req, null);
          return str2;
        }
      }
      catch (IOException localIOException)
      {
        FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMs, l, str1);
        return FileJsPlugin.access$1000(this.this$0, this.val$req, null, localIOException.getMessage());
      }
    }
    FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMs, l, this.val$filePath);
    return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "no such file or directory, open ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */