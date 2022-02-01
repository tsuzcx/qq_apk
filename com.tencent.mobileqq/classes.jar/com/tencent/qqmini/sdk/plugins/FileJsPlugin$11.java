package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.io.File;

class FileJsPlugin$11
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$11(FileJsPlugin paramFileJsPlugin, String paramString1, RequestEvent paramRequestEvent, long paramLong, String paramString2) {}
  
  public String run()
  {
    long l1 = System.currentTimeMillis();
    if (TextUtils.isEmpty(this.val$oldPath))
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$oldPath);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "invalid path");
    }
    int i = ((MiniAppFileManager)FileJsPlugin.access$4900(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$oldPath);
    int j = ((MiniAppFileManager)FileJsPlugin.access$5000(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$newPath);
    if (i != 2)
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$oldPath);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "permission denied, open " + this.val$oldPath);
    }
    if (j != 2)
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$newPath);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "permission denied, open " + this.val$newPath);
    }
    String str1 = ((MiniAppFileManager)FileJsPlugin.access$5100(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$oldPath);
    String str2 = ((MiniAppFileManager)FileJsPlugin.access$5200(this.this$0).getManager(MiniAppFileManager.class)).getUsrPath(this.val$newPath);
    if (!new File(str1).exists())
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l1, str1);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$oldPath);
    }
    if (FileUtils.renameFile(str1, str2))
    {
      if (i != 2)
      {
        long l2 = FileUtils.getFileSizes(str2);
        FileJsPlugin.access$2600(this.this$0).updateFolderSize(i, -l2);
        FileJsPlugin.access$2600(this.this$0).updateFolderSize(j, l2);
      }
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, true, this.val$startMS, l1, str1);
      return FileJsPlugin.access$1300(this.this$0, this.val$req, null);
    }
    FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$oldPath);
    return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "no such file or directory, open ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */