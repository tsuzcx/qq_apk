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
    if (localObject != null) {
      localObject = ((DownloadInfo)localObject).q;
    } else {
      localObject = "";
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      File localFile = new File((String)localObject);
      String str = YybHandleUtil.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("---localFilePath = ");
      localStringBuilder.append((String)localObject);
      LogUtility.c(str, localStringBuilder.toString());
      if (localFile.exists())
      {
        LogUtility.c(YybHandleUtil.a, "---delete apk ");
        localFile.delete();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.YybHandleUtil.1
 * JD-Core Version:    0.7.0.1
 */