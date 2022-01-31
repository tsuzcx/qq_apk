package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bgjm;
import bgkd;
import bglr;
import com.tencent.qqmini.sdk.log.QMLog;
import java.io.File;

class FileJsPlugin$15
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$15(FileJsPlugin paramFileJsPlugin, String paramString1, bgkd parambgkd, String paramString2, long paramLong) {}
  
  public String run()
  {
    if ((bgjm.a().a(this.val$zipFilePath) == 9999) && (!bgjm.a().a(this.val$zipFilePath))) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$zipFilePath);
    }
    if (bgjm.a().a(this.val$targetPath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$targetPath);
    }
    String str1 = bgjm.a().a(this.val$zipFilePath);
    String str2 = bgjm.a().c(this.val$targetPath);
    if ((TextUtils.isEmpty(str1)) || (!new File(str1).exists())) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open " + this.val$zipFilePath);
    }
    int i = bglr.a(str1, str2);
    QMLog.d("FileJsPlugin", "unzip [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], zipPath:" + str1 + ", target:" + str2);
    if (i == 0) {
      return FileJsPlugin.access$200(this.this$0, this.val$req, null);
    }
    return FileJsPlugin.access$100(this.this$0, this.val$req, null, "read zip data");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.15
 * JD-Core Version:    0.7.0.1
 */