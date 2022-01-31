package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bejl;
import bekr;
import belh;
import java.io.File;
import org.json.JSONObject;

class FileJsPlugin$12
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$12(FileJsPlugin paramFileJsPlugin, String paramString, JSONObject paramJSONObject, bekr parambekr, boolean paramBoolean) {}
  
  public String run()
  {
    if ((TextUtils.isEmpty(this.val$dirPath)) || (this.val$reqParamObj.isNull("dirPath"))) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "fail parameter error: parameter.dirPath should be String instead of Null;");
    }
    if (bejl.a().a(this.val$dirPath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$dirPath);
    }
    String str = bejl.a().c(this.val$dirPath);
    if (!new File(str).exists()) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$dirPath);
    }
    if (this.val$recursive) {
      belh.a(str);
    }
    for (;;)
    {
      return FileJsPlugin.access$200(this.this$0, this.val$req, null);
      belh.b(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.12
 * JD-Core Version:    0.7.0.1
 */