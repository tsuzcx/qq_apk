package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;

class FileJsPlugin$8
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$8(FileJsPlugin paramFileJsPlugin, String paramString1, RequestEvent paramRequestEvent, long paramLong, String paramString2) {}
  
  public String run()
  {
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if ((((MiniAppFileManager)FileJsPlugin.access$3000(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$srcPath) == 9999) && (!((MiniAppFileManager)FileJsPlugin.access$3100(this.this$0).getManager(MiniAppFileManager.class)).isPackageRelativePath(this.val$srcPath)))
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$srcPath);
      localObject1 = this.this$0;
      localObject2 = this.val$req;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("permission denied, open ");
      localStringBuilder.append(this.val$srcPath);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject1, (RequestEvent)localObject2, null, localStringBuilder.toString());
    }
    if (((MiniAppFileManager)FileJsPlugin.access$3200(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$destPath) != 2)
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$srcPath);
      localObject1 = this.this$0;
      localObject2 = this.val$req;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("permission denied, open ");
      localStringBuilder.append(this.val$srcPath);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject1, (RequestEvent)localObject2, null, localStringBuilder.toString());
    }
    Object localObject1 = ((MiniAppFileManager)FileJsPlugin.access$3300(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$srcPath);
    Object localObject2 = ((MiniAppFileManager)FileJsPlugin.access$3400(this.this$0).getManager(MiniAppFileManager.class)).getUsrPath(this.val$destPath);
    long l2 = FileUtils.getFileSizes((String)localObject1);
    if (!((MiniAppFileManager)FileJsPlugin.access$3800(this.this$0).getManager(MiniAppFileManager.class)).isFolderCanWrite(2, l2, FileJsPlugin.access$3500(this.this$0), FileJsPlugin.access$3600(this.this$0), FileJsPlugin.access$3700(this.this$0).getAttachedActivity()))
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, (String)localObject1);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      boolean bool = FileUtils.copyFile((String)localObject1, (String)localObject2);
      FileJsPlugin.access$900(this.this$0, this.val$req.event, bool, this.val$startMS, l1, (String)localObject1);
      if (bool)
      {
        FileJsPlugin.access$2400(this.this$0).updateFolderSize(2, l2);
        return FileJsPlugin.access$1100(this.this$0, this.val$req, null);
      }
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "permission denied, open ");
    }
    return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "no such file or directory, open ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */