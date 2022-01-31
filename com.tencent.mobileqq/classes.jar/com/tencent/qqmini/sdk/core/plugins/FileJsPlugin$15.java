package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bdeu;
import bdfz;
import bdgo;
import java.io.File;

class FileJsPlugin$15
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$15(FileJsPlugin paramFileJsPlugin, String paramString, bdfz parambdfz) {}
  
  public String run()
  {
    if (bdeu.a().a(this.val$filePath) == 9999) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid path" + this.val$filePath);
    }
    String str = bdeu.a().a(this.val$filePath);
    if (TextUtils.isEmpty(str)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$filePath);
    }
    if (new File(str).isDirectory()) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "operation not permitted, unlink " + this.val$filePath);
    }
    if (!new File(str).exists()) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$filePath);
    }
    bdgo.a(str, false);
    return FileJsPlugin.access$200(this.this$0, this.val$req, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.15
 * JD-Core Version:    0.7.0.1
 */