package com.tencent.open.downloadnew;

import android.text.TextUtils;
import bfhg;
import bfll;
import bflq;
import java.io.File;

public final class YybHandleUtil$1
  implements Runnable
{
  public void run()
  {
    Object localObject = bflq.a().a("com.tencent.android.qqdownloader");
    String str = "";
    if (localObject != null) {
      str = ((DownloadInfo)localObject).l;
    }
    if (!TextUtils.isEmpty(str))
    {
      localObject = new File(str);
      bfhg.c(bfll.a, "---localFilePath = " + str);
      if ((localObject != null) && (((File)localObject).exists()))
      {
        bfhg.c(bfll.a, "---delete apk ");
        ((File)localObject).delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.YybHandleUtil.1
 * JD-Core Version:    0.7.0.1
 */