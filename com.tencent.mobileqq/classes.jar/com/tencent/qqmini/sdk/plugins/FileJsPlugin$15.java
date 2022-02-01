package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ZipUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.io.File;

class FileJsPlugin$15
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$15(FileJsPlugin paramFileJsPlugin, String paramString1, RequestEvent paramRequestEvent, long paramLong, String paramString2) {}
  
  public String run()
  {
    long l2 = System.currentTimeMillis();
    if ((((MiniAppFileManager)FileJsPlugin.access$5900(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$zipFilePath) == 9999) && (!((MiniAppFileManager)FileJsPlugin.access$6000(this.this$0).getManager(MiniAppFileManager.class)).isPackageRelativePath(this.val$zipFilePath)))
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l2, this.val$zipFilePath);
      localObject1 = this.this$0;
      localObject2 = this.val$req;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("permission denied, open ");
      ((StringBuilder)localObject3).append(this.val$zipFilePath);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject1, (RequestEvent)localObject2, null, ((StringBuilder)localObject3).toString());
    }
    if (((MiniAppFileManager)FileJsPlugin.access$6100(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$targetPath) != 2)
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l2, this.val$targetPath);
      localObject1 = this.this$0;
      localObject2 = this.val$req;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("permission denied, open ");
      ((StringBuilder)localObject3).append(this.val$targetPath);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject1, (RequestEvent)localObject2, null, ((StringBuilder)localObject3).toString());
    }
    Object localObject2 = ((MiniAppFileManager)FileJsPlugin.access$6200(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$zipFilePath);
    Object localObject1 = ((MiniAppFileManager)FileJsPlugin.access$6300(this.this$0).getManager(MiniAppFileManager.class)).getUsrPath(this.val$targetPath);
    if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (new File((String)localObject2).exists()))
    {
      long l1 = FileUtils.getFileOrFolderSize((String)localObject1);
      int i = ZipUtil.unZipFolder((String)localObject2, (String)localObject1);
      localObject2 = this.this$0;
      localObject3 = this.val$req.event;
      boolean bool;
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
      FileJsPlugin.access$900((FileJsPlugin)localObject2, (String)localObject3, bool, this.val$startMS, l2, this.val$zipFilePath);
      if (i == 0)
      {
        l2 = FileUtils.getFileOrFolderSize((String)localObject1);
        FileJsPlugin.access$2400(this.this$0).updateFolderSize(2, l2 - l1);
        return FileJsPlugin.access$1100(this.this$0, this.val$req, null);
      }
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "read zip data");
    }
    FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l2, (String)localObject2);
    localObject1 = this.this$0;
    localObject2 = this.val$req;
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("no such file or directory, open ");
    ((StringBuilder)localObject3).append(this.val$zipFilePath);
    return FileJsPlugin.access$1000((FileJsPlugin)localObject1, (RequestEvent)localObject2, null, ((StringBuilder)localObject3).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.15
 * JD-Core Version:    0.7.0.1
 */