package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bejl;
import bekr;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$10
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$10(FileJsPlugin paramFileJsPlugin, String paramString, JSONObject paramJSONObject, bekr parambekr) {}
  
  public String run()
  {
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$reqParamObj.isNull("dirPath"))) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid path");
    }
    Object localObject = bejl.a().a(this.val$dirPath);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$dirPath);
    }
    if (!new File((String)localObject).isDirectory()) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "not a directory " + this.val$dirPath);
    }
    File[] arrayOfFile = new File((String)localObject).listFiles();
    localObject = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    if (arrayOfFile != null)
    {
      int j = arrayOfFile.length;
      int i = 0;
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
      ((JSONObject)localObject).put("files", localJSONArray);
      label223:
      return FileJsPlugin.access$200(this.this$0, this.val$req, (JSONObject)localObject);
    }
    catch (JSONException localJSONException)
    {
      break label223;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.10
 * JD-Core Version:    0.7.0.1
 */