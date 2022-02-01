package com.tencent.mobileqq.microapp.apkg;

import akbj;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class h
  implements akbj
{
  h(g paramg, c paramc, String paramString, g.a parama) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApkgManager", 1, "downloadSubPack | getResPath : resCode=" + paramInt + "pathRes=" + paramPathResult);
    }
    if (paramInt == 0)
    {
      str = g.a(this.a.f.config);
      bool = c.a(new File(paramPathResult.filePath).getAbsolutePath(), str, this.b);
      if (QLog.isColorLevel()) {
        QLog.d("ApkgManager", 1, "downloadSubPack | getResPath :hasUnpack=" + bool + "folderPath=" + str + "subRoot=" + this.b);
      }
      if (bool) {
        if (this.c != null) {
          this.c.onInitApkgInfo$76ec3a73(0, this.a);
        }
      }
    }
    while (this.c == null)
    {
      String str;
      boolean bool;
      do
      {
        return;
      } while (this.c == null);
      this.c.onInitApkgInfo$76ec3a73(1, null);
      return;
    }
    this.c.onInitApkgInfo$76ec3a73(1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.h
 * JD-Core Version:    0.7.0.1
 */