package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bgnt;
import bgok;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.MiniLog;
import java.io.IOException;

class FileJsPlugin$5
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$5(FileJsPlugin paramFileJsPlugin, String paramString1, bgok parambgok, String paramString2, String paramString3, byte[] paramArrayOfByte) {}
  
  public String run()
  {
    if (!FileJsPlugin.access$300(this.this$0, this.val$encoding)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid encoding " + this.val$encoding);
    }
    if (bgnt.a().a(this.val$filePath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$filePath);
    }
    String str = bgnt.a().c(this.val$filePath);
    if (!TextUtils.isEmpty(str))
    {
      if (str.contains("miniprogramLog"))
      {
        MiniLog.writeMiniLog(this.this$0.mMiniAppInfo.appId, this.val$data);
        return FileJsPlugin.access$200(this.this$0, this.val$req, null);
      }
      try
      {
        if (FileJsPlugin.access$400(this.this$0, this.val$nativeBufferBytes, this.val$data, this.val$encoding, str, true))
        {
          str = FileJsPlugin.access$200(this.this$0, this.val$req, null);
          return str;
        }
      }
      catch (IOException localIOException)
      {
        return FileJsPlugin.access$100(this.this$0, this.val$req, null, localIOException.getMessage());
      }
    }
    return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */