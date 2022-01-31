package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bgnt;
import bgok;
import bgpc;
import java.io.File;

class FileJsPlugin$14
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$14(FileJsPlugin paramFileJsPlugin, String paramString, bgok parambgok) {}
  
  public String run()
  {
    if (bgnt.a().a(this.val$filePath) == 9999) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "invalid path" + this.val$filePath);
    }
    String str = bgnt.a().a(this.val$filePath);
    if (TextUtils.isEmpty(str)) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$filePath);
    }
    if (new File(str).isDirectory()) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "operation not permitted, unlink " + this.val$filePath);
    }
    if (!new File(str).exists()) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$filePath);
    }
    bgpc.a(str, false);
    return FileJsPlugin.access$200(this.this$0, this.val$req, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.14
 * JD-Core Version:    0.7.0.1
 */