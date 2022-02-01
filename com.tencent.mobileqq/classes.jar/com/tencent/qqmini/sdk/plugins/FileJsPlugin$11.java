package com.tencent.qqmini.sdk.plugins;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$11
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$11(FileJsPlugin paramFileJsPlugin, String paramString, JSONObject paramJSONObject, RequestEvent paramRequestEvent, long paramLong) {}
  
  public String run()
  {
    long l = System.currentTimeMillis();
    Object localObject1;
    Object localObject2;
    JSONArray localJSONArray;
    if ((!TextUtils.isEmpty(this.val$dirPath)) && (!this.val$reqParamObj.isNull("dirPath")))
    {
      localObject1 = ((MiniAppFileManager)FileJsPlugin.access$4600(this.this$0).getManager(MiniAppFileManager.class)).getAbsolutePath(this.val$dirPath);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, this.val$dirPath);
        localObject1 = this.this$0;
        localObject2 = this.val$req;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("no such file or directory, open ");
        ((StringBuilder)localObject3).append(this.val$dirPath);
        return FileJsPlugin.access$1000((FileJsPlugin)localObject1, (RequestEvent)localObject2, null, ((StringBuilder)localObject3).toString());
      }
      if (!new File((String)localObject1).isDirectory())
      {
        FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, (String)localObject1);
        localObject1 = this.this$0;
        localObject2 = this.val$req;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("not a directory ");
        ((StringBuilder)localObject3).append(this.val$dirPath);
        return FileJsPlugin.access$1000((FileJsPlugin)localObject1, (RequestEvent)localObject2, null, ((StringBuilder)localObject3).toString());
      }
      Object localObject3 = new File((String)localObject1).listFiles();
      localObject2 = new JSONObject();
      localJSONArray = new JSONArray();
      if (localObject3 != null)
      {
        int j = localObject3.length;
        int i = 0;
        while (i < j)
        {
          Object localObject4 = localObject3[i];
          if (localObject4 != null) {
            localJSONArray.put(localObject4.getName());
          }
          i += 1;
        }
      }
    }
    try
    {
      ((JSONObject)localObject2).put("files", localJSONArray);
      label317:
      FileJsPlugin.access$900(this.this$0, this.val$req.event, true, this.val$startMS, l, (String)localObject1);
      return FileJsPlugin.access$1100(this.this$0, this.val$req, (JSONObject)localObject2);
      FileJsPlugin.access$900(this.this$0, this.val$req.event, false, this.val$startMS, l, this.val$dirPath);
      return FileJsPlugin.access$1000(this.this$0, this.val$req, null, "invalid path");
    }
    catch (JSONException localJSONException)
    {
      break label317;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.FileJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */