package com.tencent.qqmini.sdk.core.plugins;

import android.text.TextUtils;
import bdeu;
import bdfz;
import bdgo;
import bdnw;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

class FileJsPlugin$8
  implements FileJsPlugin.FileTask
{
  FileJsPlugin$8(FileJsPlugin paramFileJsPlugin, String paramString1, bdfz parambdfz, String paramString2, long paramLong) {}
  
  public String run()
  {
    if ((bdeu.a().a(this.val$srcPath) == 9999) && (!bdeu.a().a(this.val$srcPath))) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$srcPath);
    }
    if (bdeu.a().a(this.val$destPath) != 2) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open " + this.val$srcPath);
    }
    String str1 = bdeu.a().a(this.val$srcPath);
    String str2 = bdeu.a().c(this.val$destPath);
    MiniAppInfo localMiniAppInfo = this.this$0.mMiniAppInfo;
    if (localMiniAppInfo != null) {}
    for (long l = localMiniAppInfo.usrFileSizeLimit; !bdeu.a().a(2, bdgo.a(str1), this.this$0.mIsMiniGame, l); l = 0L) {
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "the maximum size of the file storage is exceeded");
    }
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      boolean bool = bdgo.b(str1, str2);
      bdnw.a("FileJsPlugin", "copyFile [minigame timecost:" + (System.currentTimeMillis() - this.val$startMS) + "ms], src:" + str1 + ", dest:" + str2);
      if (bool) {
        return FileJsPlugin.access$200(this.this$0, this.val$req, null);
      }
      return FileJsPlugin.access$100(this.this$0, this.val$req, null, "permission denied, open ");
    }
    return FileJsPlugin.access$100(this.this$0, this.val$req, null, "no such file or directory, open ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.FileJsPlugin.8
 * JD-Core Version:    0.7.0.1
 */