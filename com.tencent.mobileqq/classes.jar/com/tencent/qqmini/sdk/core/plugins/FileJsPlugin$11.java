package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bgjm;
import bgkd;
import bgkv;
import java.io.File;

class FileJsPlugin$11
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$11(FileJsPlugin paramFileJsPlugin, String paramString1, bgkd parambgkd, String paramString2) {}
  
  public String run()
  {
    if (TextUtils.isEmpty(this.val$oldPath)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid path");
    }
    if (bgjm.a().a(this.val$oldPath) == 9999) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$oldPath);
    }
    if (bgjm.a().a(this.val$newPath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$newPath);
    }
    String str1 = bgjm.a().a(this.val$oldPath);
    String str2 = bgjm.a().c(this.val$newPath);
    if (!new File(str1).exists()) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$oldPath);
    }
    if (bgkv.a(str1, str2)) {
      return FileJsPlugin.access$200(this.this$0, this.val$req, null);
    }
    return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.11
 * JD-Core Version:    0.7.0.1
 */