package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.io.File;
import org.json.JSONObject;

class FileJsPlugin$12
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$12(FileJsPlugin paramFileJsPlugin, String paramString, JSONObject paramJSONObject, RequestEvent paramRequestEvent, long paramLong, boolean paramBoolean) {}
  
  public String run()
  {
    long l2 = System.currentTimeMillis();
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$reqParamObj.isNull("dirPath")))
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l2, this.val$dirPath);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "fail parameter error: parameter.dirPath should be String instead of Null;");
    }
    if (((MiniAppFileManager)FileJsPlugin.access$5100(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$dirPath) != 2)
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l2, this.val$dirPath);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "permission denied, open " + this.val$dirPath);
    }
    String str = ((MiniAppFileManager)FileJsPlugin.access$5200(this.this$0).getManager(MiniAppFileManager.class)).getUsrPath(this.val$dirPath);
    if (TextUtils.isEmpty(str)) {
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "no such file or directory, open dirPath is null");
    }
    if (!new File(str).exists())
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l2, str);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$dirPath);
    }
    if (this.val$recursive) {}
    for (long l1 = FileUtils.deleteDirectory(str);; l1 = FileUtils.deleteFilesInDirectory(str))
    {
      FileJsPlugin.access$2400(this.this$0).updateFolderSize(2, -l1);
      FileJsPlugin.access$900(this.this$0, this.val$req.event, true, this.val$startMS, l2, str);
      return FileJsPlugin.access$1100(this.this$0, this.val$req, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.12
 * JD-Core Version:    0.7.0.1
 */