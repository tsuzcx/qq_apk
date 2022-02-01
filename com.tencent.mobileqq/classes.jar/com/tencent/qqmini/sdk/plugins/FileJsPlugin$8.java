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
    if ((!TextUtils.isEmpty(this.val$dirPath)) && (!this.val$reqParamObj.isNull("dirPath")))
    {
      if (((MiniAppFileManager)FileJsPlugin.access$3900(this.this$0).getManager(MiniAppFileManager.class)).getWxFileType(this.val$dirPath) == 2)
      {
        localObject = ((MiniAppFileManager)FileJsPlugin.access$4000(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$dirPath);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, (String)localObject);
          localObject = this.this$0;
          localRequestEvent = this.val$req;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("file already exists ");
          localStringBuilder.append(this.val$dirPath);
          return FileJsPlugin.access$1000((FileJsPlugin)localObject, localRequestEvent, null, localStringBuilder.toString());
        }
        localObject = ((MiniAppFileManager)FileJsPlugin.access$4100(this.this$0).getManager(MiniAppFileManager.class)).getUsrPath(this.val$dirPath);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).mkdirs()))
        {
          FileJsPlugin.access$900(this.this$0, this.val$req.event, true, this.val$startMS, l, (String)localObject);
          return FileJsPlugin.access$1100(this.this$0, this.val$req, null);
        }
        FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, this.val$dirPath);
        localObject = this.this$0;
        localRequestEvent = this.val$req;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("permission denied, open ");
        localStringBuilder.append(this.val$dirPath);
        return FileJsPlugin.access$1000((FileJsPlugin)localObject, localRequestEvent, null, localStringBuilder.toString());
      }
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, this.val$dirPath);
      Object localObject = this.this$0;
      RequestEvent localRequestEvent = this.val$req;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("permission denied, open ");
      localStringBuilder.append(this.val$dirPath);
      return FileJsPlugin.access$1000((FileJsPlugin)localObject, localRequestEvent, null, localStringBuilder.toString());
    }
    FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, this.val$dirPath);
    return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "invalid path");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */