package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.io.File;
import org.json.JSONObject;

class FileJsPlugin$8
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$8(FileJsPlugin paramFileJsPlugin, String paramString, JSONObject paramJSONObject, RequestEvent paramRequestEvent, long paramLong) {}
  
  public String run()
  {
    long l = System.currentTimeMillis();
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$reqParamObj.isNull("dirPath")))
    {
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, this.val$dirPath);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "invalid path");
    }
    if (((MiniAppFileManager)FileJsPlugin.access$3900(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$dirPath) == 2)
    {
      String str = ((MiniAppFileManager)FileJsPlugin.access$4000(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$dirPath);
      if (!TextUtils.isEmpty(str))
      {
        FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, str);
        return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "file already exists " + this.val$dirPath);
      }
      str = ((MiniAppFileManager)FileJsPlugin.access$4100(this.this$0).getManager(MiniAppFileManager.class)).getUsrPath(this.val$dirPath);
      if ((!TextUtils.isEmpty(str)) && (new File(str).mkdirs()))
      {
        FileJsPlugin.access$900(this.this$0, this.val$req.event, true, this.val$startMS, l, str);
        return FileJsPlugin.access$1100(this.this$0, this.val$req, null);
      }
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, this.val$dirPath);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "permission denied, open " + this.val$dirPath);
    }
    FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, this.val$dirPath);
    return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "permission denied, open " + this.val$dirPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */