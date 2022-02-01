package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.io.File;
import org.json.JSONObject;

class FileJsPlugin$13
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$13(FileJsPlugin paramFileJsPlugin, String paramString, JSONObject paramJSONObject, RequestEvent paramRequestEvent, long paramLong, boolean paramBoolean) {}
  
  public String run()
  {
    long l2 = System.currentTimeMillis();
    if ((!TextUtils.isEmpty(this.val$dirPath)) && (!this.val$reqParamObj.isNull("dirPath")))
    {
      RequestEvent localRequestEvent;
      StringBuilder localStringBuilder;
      if (((MiniAppFileManager)FileJsPlugin.access$5100(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$dirPath) != 2)
      {
        FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l2, this.val$dirPath);
        localObject = this.this$0;
        localRequestEvent = this.val$req;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("permission denied, open ");
        localStringBuilder.append(this.val$dirPath);
        return FileJsPlugin.access$1000((FileJsPlugin)localObject, localRequestEvent, null, localStringBuilder.toString());
      }
      Object localObject = ((MiniAppFileManager)FileJsPlugin.access$5200(this.this$0).getManager(MiniAppFileManager.class)).getUsrPath(this.val$dirPath);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "no such file or directory, open dirPath is null");
      }
      if (!new File((String)localObject).exists())
      {
        FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l2, (String)localObject);
        localObject = this.this$0;
        localRequestEvent = this.val$req;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("no such file or directory, open ");
        localStringBuilder.append(this.val$dirPath);
        return FileJsPlugin.access$1000((FileJsPlugin)localObject, localRequestEvent, null, localStringBuilder.toString());
      }
      long l1;
      if (this.val$recursive) {
        l1 = FileUtils.deleteDirectory((String)localObject);
      } else {
        l1 = FileUtils.deleteFilesInDirectory((String)localObject);
      }
      FileJsPlugin.access$2400(this.this$0).updateFolderSize(2, -l1);
      FileJsPlugin.access$900(this.this$0, this.val$req.event, true, this.val$startMS, l2, (String)localObject);
      return FileJsPlugin.access$1100(this.this$0, this.val$req, null);
    }
    FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l2, this.val$dirPath);
    return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "fail parameter error: parameter.dirPath should be String instead of Null;");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */