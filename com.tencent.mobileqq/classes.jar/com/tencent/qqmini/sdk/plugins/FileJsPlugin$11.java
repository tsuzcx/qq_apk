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
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$oldPath);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "invalid path");
    }
    int i = ((MiniAppFileManager)FileJsPlugin.access$4700(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$oldPath);
    int j = ((MiniAppFileManager)FileJsPlugin.access$4800(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$newPath);
    StringBuilder localStringBuilder;
    if (i != 2)
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$oldPath);
      localObject1 = this.this$0;
      localObject2 = this.val$req;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("permission denied, open ");
      localStringBuilder.append(this.val$oldPath);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject1, (RequestEvent)localObject2, null, localStringBuilder.toString());
    }
    if (j != 2)
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$newPath);
      localObject1 = this.this$0;
      localObject2 = this.val$req;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("permission denied, open ");
      localStringBuilder.append(this.val$newPath);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject1, (RequestEvent)localObject2, null, localStringBuilder.toString());
    }
    Object localObject1 = ((MiniAppFileManager)FileJsPlugin.access$4900(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$oldPath);
    Object localObject2 = ((MiniAppFileManager)FileJsPlugin.access$5000(this.this$0).getManager(MiniAppFileManager.class)).getUsrPath(this.val$newPath);
    if (!new File((String)localObject1).exists())
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, (String)localObject1);
      localObject1 = this.this$0;
      localObject2 = this.val$req;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("no such file or directory, open ");
      localStringBuilder.append(this.val$oldPath);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject1, (RequestEvent)localObject2, null, localStringBuilder.toString());
    }
    if (FileUtils.renameFile((String)localObject1, (String)localObject2))
    {
      if (i != 2)
      {
        long l2 = FileUtils.getFileSizes((String)localObject2);
        FileJsPlugin.access$2400(this.this$0).updateFolderSize(i, -l2);
        FileJsPlugin.access$2400(this.this$0).updateFolderSize(j, l2);
      }
      FileJsPlugin.access$900(this.this$0, this.val$req.event, true, this.val$startMS, l1, (String)localObject1);
      return FileJsPlugin.access$1100(this.this$0, this.val$req, null);
    }
    FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$oldPath);
    return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "no such file or directory, open ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */