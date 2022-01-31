package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bdeu;
import bdfz;
import bdgo;
import java.io.File;

class FileJsPlugin$12
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$12(FileJsPlugin paramFileJsPlugin, String paramString1, bdfz parambdfz, String paramString2) {}
  
  public String run()
  {
    if (TextUtils.isEmpty(this.val$oldPath)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid path");
    }
    if (bdeu.a().a(this.val$oldPath) == 9999) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$oldPath);
    }
    if (bdeu.a().a(this.val$newPath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$newPath);
    }
    String str1 = bdeu.a().a(this.val$oldPath);
    String str2 = bdeu.a().c(this.val$newPath);
    if (!new File(str1).exists()) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$oldPath);
    }
    if (bdgo.a(str1, str2)) {
      return FileJsPlugin.access$200(this.this$0, this.val$req, null);
    }
    return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.12
 * JD-Core Version:    0.7.0.1
 */