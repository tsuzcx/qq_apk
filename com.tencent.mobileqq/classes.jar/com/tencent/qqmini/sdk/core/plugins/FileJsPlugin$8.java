package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bgnt;
import bgok;
import java.io.File;
import org.json.JSONObject;

class FileJsPlugin$8
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$8(FileJsPlugin paramFileJsPlugin, String paramString, JSONObject paramJSONObject, bgok parambgok) {}
  
  public String run()
  {
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$reqParamObj.isNull("dirPath"))) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid path");
    }
    if (bgnt.a().a(this.val$dirPath) == 2)
    {
      if (!TextUtils.isEmpty(bgnt.a().a(this.val$dirPath))) {
        return FileJsPlugin.access$100(this.this$0, this.val$req, null, "file already exists " + this.val$dirPath);
      }
      String str = bgnt.a().c(this.val$dirPath);
      if ((!TextUtils.isEmpty(str)) && (new File(str).mkdirs())) {
        return FileJsPlugin.access$200(this.this$0, this.val$req, null);
      }
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$dirPath);
    }
    return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$dirPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */