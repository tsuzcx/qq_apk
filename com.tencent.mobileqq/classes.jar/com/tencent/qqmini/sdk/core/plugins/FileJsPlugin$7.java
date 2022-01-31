package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bglv;
import bgnt;
import bgok;
import bgpc;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.log.QMLog;

class FileJsPlugin$7
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$7(FileJsPlugin paramFileJsPlugin, String paramString1, bgok parambgok, String paramString2, long paramLong) {}
  
  public String run()
  {
    if ((bgnt.a().a(this.val$srcPath) == 9999) && (!bgnt.a().a(this.val$srcPath))) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$srcPath);
    }
    if (bgnt.a().a(this.val$destPath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$srcPath);
    }
    String str1 = bgnt.a().a(this.val$srcPath);
    String str2 = bgnt.a().c(this.val$destPath);
    MiniAppInfo localMiniAppInfo = this.this$0.mMiniAppInfo;
    if (localMiniAppInfo != null) {}
    for (long l = localMiniAppInfo.usrFileSizeLimit; !bgnt.a().a(2, bgpc.a(str1), this.this$0.mIsMiniGame, l, this.this$0.mMiniAppInfo, this.this$0.mMiniAppContext.a()); l = 0L) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
    }
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      boolean bool = bgpc.b(str1, str2);
      QMLog.d("FileJsPlugin", "copyFile [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], src:" + str1 + ", dest:" + str2);
      if (bool) {
        return FileJsPlugin.access$200(this.this$0, this.val$req, null);
      }
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open ");
    }
    return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.7
 * JD-Core Version:    0.7.0.1
 */