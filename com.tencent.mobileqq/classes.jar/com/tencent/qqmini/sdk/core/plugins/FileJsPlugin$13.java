package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bdeu;
import bdfz;
import bdgo;
import java.io.File;
import org.json.JSONObject;

class FileJsPlugin$13
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$13(FileJsPlugin paramFileJsPlugin, String paramString, JSONObject paramJSONObject, bdfz parambdfz, boolean paramBoolean) {}
  
  public String run()
  {
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$reqParamObj.isNull("dirPath"))) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "fail parameter error: parameter.dirPath should be String instead of Null;");
    }
    if (bdeu.a().a(this.val$dirPath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$dirPath);
    }
    String str = bdeu.a().c(this.val$dirPath);
    if (!new File(str).exists()) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$dirPath);
    }
    if (this.val$recursive) {
      bdgo.a(str);
    }
    for (;;)
    {
      return FileJsPlugin.access$200(this.this$0, this.val$req, null);
      bdgo.b(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.13
 * JD-Core Version:    0.7.0.1
 */