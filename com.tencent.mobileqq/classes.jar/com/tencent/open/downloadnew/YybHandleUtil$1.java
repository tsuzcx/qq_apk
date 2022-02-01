package com.tencent.open.downloadnew;

import android.text.TextUtils;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.common.DownloadDBHelper;
import java.io.File;

final class YybHandleUtil$1
  implements Runnable
{
  public void run()
  {
    Object localObject = DownloadDBHelper.a().a("com.tencent.android.qqdownloader");
    String str = "";
    if (localObject != null) {
      str = ((DownloadInfo)localObject).l;
    }
    if (!TextUtils.isEmpty(str))
    {
      localObject = new File(str);
      LogUtility.c(YybHandleUtil.a, "---localFilePath = " + str);
      if ((localObject != null) && (((File)localObject).exists()))
      {
        LogUtility.c(YybHandleUtil.a, "---delete apk ");
        ((File)localObject).delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.YybHandleUtil.1
 * JD-Core Version:    0.7.0.1
 */