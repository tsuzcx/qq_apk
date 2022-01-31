package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import beiu;
import beka;
import java.io.File;
import org.json.JSONObject;

class FileJsPlugin$8
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$8(FileJsPlugin paramFileJsPlugin, String paramString, JSONObject paramJSONObject, beka parambeka) {}
  
  public String run()
  {
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$reqParamObj.isNull("dirPath"))) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid path");
    }
    if (beiu.a().a(this.val$dirPath) == 2)
    {
      if (!TextUtils.isEmpty(beiu.a().a(this.val$dirPath))) {
        return FileJsPlugin.access$100(this.this$0, this.val$req, null, "file already exists " + this.val$dirPath);
      }
      String str = beiu.a().c(this.val$dirPath);
      if ((!TextUtils.isEmpty(str)) && (new File(str).mkdirs())) {
        return FileJsPlugin.access$200(this.this$0, this.val$req, null);
      }
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$dirPath);
    }
    return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$dirPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */