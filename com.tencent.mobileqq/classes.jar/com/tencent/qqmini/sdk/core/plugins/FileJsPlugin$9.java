package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bdeu;
import bdfz;
import java.io.File;
import org.json.JSONObject;

class FileJsPlugin$9
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$9(FileJsPlugin paramFileJsPlugin, String paramString, JSONObject paramJSONObject, bdfz parambdfz) {}
  
  public String run()
  {
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$reqParamObj.isNull("dirPath"))) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid path");
    }
    if (bdeu.a().a(this.val$dirPath) == 2)
    {
      if (!TextUtils.isEmpty(bdeu.a().a(this.val$dirPath))) {
        return FileJsPlugin.access$100(this.this$0, this.val$req, null, "file already exists " + this.val$dirPath);
      }
      String str = bdeu.a().c(this.val$dirPath);
      if ((!TextUtils.isEmpty(str)) && (new File(str).mkdirs())) {
        return FileJsPlugin.access$200(this.this$0, this.val$req, null);
      }
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$dirPath);
    }
    return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$dirPath);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.9
 * JD-Core Version:    0.7.0.1
 */