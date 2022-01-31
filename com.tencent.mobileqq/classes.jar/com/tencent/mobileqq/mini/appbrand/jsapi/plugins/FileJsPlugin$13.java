package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class FileJsPlugin$13
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$13(FileJsPlugin paramFileJsPlugin, String paramString1, JSONObject paramJSONObject, JsRuntime paramJsRuntime, String paramString2, int paramInt) {}
  
  public String run()
  {
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$params.isNull("dirPath"))) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "invalid path", this.val$callbackId);
    }
    Object localObject = MiniAppFileManager.getInstance().getAbsolutePath(this.val$dirPath);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "no such file or directory, open " + this.val$dirPath, this.val$callbackId);
    }
    if (!new File((String)localObject).isDirectory()) {
      return FileJsPlugin.access$100(this.this$0, this.val$webview, this.val$event, null, "not a directory " + this.val$dirPath, this.val$callbackId);
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
      label247:
      return FileJsPlugin.access$200(this.this$0, this.val$webview, this.val$event, (JSONObject)localObject, this.val$callbackId);
    }
    catch (JSONException localJSONException)
    {
      break label247;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.FileJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */