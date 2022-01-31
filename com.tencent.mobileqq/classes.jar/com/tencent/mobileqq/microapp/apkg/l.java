package com.tencent.mobileqq.microapp.apkg;

import ahbt;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.microapp.c.c;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class l
  implements ahbt
{
  l(g paramg, String paramString, MiniAppConfig paramMiniAppConfig, g.c paramc) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApkgManager", 2, "downloaded apkg:" + paramInt + "|" + paramPathResult);
    }
    if (paramInt == 0) {
      if (c.a(new File(paramPathResult.filePath).getAbsolutePath(), this.a))
      {
        paramPathResult = f.a(this.a, this.b);
        if (this.c != null) {
          this.c.a(paramPathResult);
        }
      }
    }
    while (this.c == null)
    {
      do
      {
        return;
      } while (this.c == null);
      this.c.a(null);
      return;
    }
    this.c.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.l
 * JD-Core Version:    0.7.0.1
 */