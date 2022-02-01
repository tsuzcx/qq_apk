package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$10
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$10(FileJsPlugin paramFileJsPlugin, String paramString, JSONObject paramJSONObject, RequestEvent paramRequestEvent, long paramLong) {}
  
  public String run()
  {
    int i = 0;
    long l = System.currentTimeMillis();
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$reqParamObj.isNull("dirPath")))
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l, this.val$dirPath);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "invalid path");
    }
    String str = ((MiniAppFileManager)FileJsPlugin.access$4800(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$dirPath);
    if (TextUtils.isEmpty(str))
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l, this.val$dirPath);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$dirPath);
    }
    if (!new File(str).isDirectory())
    {
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, false, this.val$startMS, l, str);
      return FileJsPlugin.access$1200(this.this$0, this.val$req, null, "not a directory " + this.val$dirPath);
    }
    File[] arrayOfFile = new File(str).listFiles();
    JSONObject localJSONObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      while (i < j)
      {
        File localFile = arrayOfFile[i];
        if (localFile != null) {
          localJSONArray.put(localFile.getName());
        }
        i += 1;
      }
    }
    try
    {
      localJSONObject.put("files", localJSONArray);
      label317:
      FileJsPlugin.access$1100(this.this$0, this.val$req.event, true, this.val$startMS, l, str);
      return FileJsPlugin.access$1300(this.this$0, this.val$req, localJSONObject);
    }
    catch (JSONException localJSONException)
    {
      break label317;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */