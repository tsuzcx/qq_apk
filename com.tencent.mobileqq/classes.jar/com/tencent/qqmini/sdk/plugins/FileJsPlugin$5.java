package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$5
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$5(FileJsPlugin paramFileJsPlugin, RequestEvent paramRequestEvent, long paramLong) {}
  
  public String run()
  {
    long l = System.currentTimeMillis();
    try
    {
      String str = new JSONObject(this.val$req.jsonParams).optString("path");
      Object localObject = ((MiniAppFileManager)FileJsPlugin.access$800(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(str);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (new File((String)localObject).exists()))
      {
        FileJsPlugin.access$900(this.this$0, this.val$req.event, true, this.val$startMS, l, (String)localObject);
        return FileJsPlugin.access$1100(this.this$0, this.val$req, null);
      }
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, (String)localObject);
      localObject = this.this$0;
      RequestEvent localRequestEvent = this.val$req;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("no such file or directory \"");
      localStringBuilder.append(str);
      localStringBuilder.append("\"");
      str = FileJsPlugin.access$1000((FileJsPlugin)localObject, localRequestEvent, null, localStringBuilder.toString());
      return str;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.5
 * JD-Core Version:    0.7.0.1
 */