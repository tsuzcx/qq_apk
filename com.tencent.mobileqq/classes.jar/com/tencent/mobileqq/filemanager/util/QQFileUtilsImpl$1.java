package com.tencent.mobileqq.filemanager.util;

import android.content.Context;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.qroute.QRoute;

final class QQFileUtilsImpl$1
  implements FMDialogUtil.FMDialogInterface
{
  QQFileUtilsImpl$1(Context paramContext, String paramString) {}
  
  public void a()
  {
    ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).startActivityByLinkByWeiyunFragment(this.a, null, this.b, false);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.QQFileUtilsImpl.1
 * JD-Core Version:    0.7.0.1
 */