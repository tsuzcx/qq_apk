package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class FileJsPlugin$7
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$7(FileJsPlugin paramFileJsPlugin, String paramString1, RequestEvent paramRequestEvent, long paramLong, String paramString2) {}
  
  public String run()
  {
    long l1 = System.currentTimeMillis();
    if ((((MiniAppFileManager)FileJsPlugin.access$3200(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$srcPath) == 9999) && (!((MiniAppFileManager)FileJsPlugin.access$3300(this.this$0).getManager(MiniAppFileManager.class)).isPackageRelativePath(this.val$srcPath)))
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$srcPath);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "permission denied, open " + this.val$srcPath);
    }
    if (((MiniAppFileManager)FileJsPlugin.access$3400(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$destPath) != 2)
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$srcPath);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "permission denied, open " + this.val$srcPath);
    }
    String str1 = ((MiniAppFileManager)FileJsPlugin.access$3500(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$srcPath);
    String str2 = ((MiniAppFileManager)FileJsPlugin.access$3600(this.this$0).getManager(MiniAppFileManager.class)).getUsrPath(this.val$destPath);
    long l2 = FileUtils.getFileSizes(str1);
    if (!((MiniAppFileManager)FileJsPlugin.access$4000(this.this$0).getManager(MiniAppFileManager.class)).isFolderCanWrite(2, l2, FileJsPlugin.access$3700(this.this$0), FileJsPlugin.access$3800(this.this$0), FileJsPlugin.access$3900(this.this$0).getAttachedActivity()))
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l1, str1);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
    }
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      boolean bool = FileUtils.copyFile(str1, str2);
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, bool, this.val$startMS, l1, str1);
      if (bool)
      {
        FileJsPlugin.access$2600(this.this$0).updateFolderSize(2, l2);
        return FileJsPlugin.access$1300(this.this$0, this.val$req, null);
      }
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "permission denied, open ");
    }
    return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "no such file or directory, open ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */