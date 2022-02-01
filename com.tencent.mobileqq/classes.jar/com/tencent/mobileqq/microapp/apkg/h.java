package com.tencent.mobileqq.microapp.apkg;

import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.OnGetPathListener;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class h
  implements PreloadManager.OnGetPathListener
{
  h(g paramg, c paramc, String paramString, g.a parama) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadSubPack | getResPath : resCode=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("pathRes=");
      ((StringBuilder)localObject).append(paramPathResult);
      QLog.d("ApkgManager", 1, ((StringBuilder)localObject).toString());
    }
    if (paramInt == 0)
    {
      localObject = g.a(this.a.f.config);
      boolean bool = c.a(new File(paramPathResult.filePath).getAbsolutePath(), (String)localObject, this.b);
      if (QLog.isColorLevel())
      {
        paramPathResult = new StringBuilder();
        paramPathResult.append("downloadSubPack | getResPath :hasUnpack=");
        paramPathResult.append(bool);
        paramPathResult.append("folderPath=");
        paramPathResult.append((String)localObject);
        paramPathResult.append("subRoot=");
        paramPathResult.append(this.b);
        QLog.d("ApkgManager", 1, paramPathResult.toString());
      }
      if (bool)
      {
        paramPathResult = this.c;
        if (paramPathResult != null) {
          paramPathResult.onInitApkgInfo$76ec3a73(0, this.a);
        }
      }
      else
      {
        paramPathResult = this.c;
        if (paramPathResult != null) {
          paramPathResult.onInitApkgInfo$76ec3a73(1, null);
        }
      }
    }
    else
    {
      paramPathResult = this.c;
      if (paramPathResult != null) {
        paramPathResult.onInitApkgInfo$76ec3a73(1, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.h
 * JD-Core Version:    0.7.0.1
 */