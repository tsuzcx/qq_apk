package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.io.File;

class FileJsPlugin$14
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$14(FileJsPlugin paramFileJsPlugin, String paramString, RequestEvent paramRequestEvent, long paramLong) {}
  
  public String run()
  {
    long l1 = System.currentTimeMillis();
    int i = ((MiniAppFileManager)FileJsPlugin.access$5700(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$filePath);
    RequestEvent localRequestEvent;
    StringBuilder localStringBuilder;
    if (i == 9999)
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$filePath);
      localObject = this.this$0;
      localRequestEvent = this.val$req;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("invalid path");
      localStringBuilder.append(this.val$filePath);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject, localRequestEvent, null, localStringBuilder.toString());
    }
    Object localObject = ((MiniAppFileManager)FileJsPlugin.access$5800(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$filePath);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, this.val$filePath);
      localObject = this.this$0;
      localRequestEvent = this.val$req;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("no such file or directory, open ");
      localStringBuilder.append(this.val$filePath);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject, localRequestEvent, null, localStringBuilder.toString());
    }
    if (new File((String)localObject).isDirectory())
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, (String)localObject);
      localObject = this.this$0;
      localRequestEvent = this.val$req;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("operation not permitted, unlink ");
      localStringBuilder.append(this.val$filePath);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject, localRequestEvent, null, localStringBuilder.toString());
    }
    if (!new File((String)localObject).exists())
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l1, (String)localObject);
      localObject = this.this$0;
      localRequestEvent = this.val$req;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("no such file or directory, open ");
      localStringBuilder.append(this.val$filePath);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject, localRequestEvent, null, localStringBuilder.toString());
    }
    long l2 = FileUtils.delete((String)localObject, false);
    FileJsPlugin.access$2400(this.this$0).updateFolderSize(i, -l2);
    FileJsPlugin.access$900(this.this$0, this.val$req.event, true, this.val$startMS, l1, (String)localObject);
    return FileJsPlugin.access$1100(this.this$0, this.val$req, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.14
 * JD-Core Version:    0.7.0.1
 */