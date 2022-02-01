package com.tencent.mobileqq.filemanager.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.qphone.base.util.BaseApplication;

final class FileCategoryUtil$3
  implements Runnable
{
  FileCategoryUtil$3(String paramString, GetApkPackageInfoCallback paramGetApkPackageInfoCallback) {}
  
  public void run()
  {
    Object localObject2 = BaseApplication.getContext().getPackageManager();
    Object localObject1 = ((PackageManager)localObject2).getPackageArchiveInfo(this.a, 1);
    if (localObject1 != null)
    {
      localObject2 = ((PackageInfo)localObject1).applicationInfo.loadLabel((PackageManager)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(".apk");
      localObject2 = localStringBuilder.toString();
      this.b.a((String)localObject2, ((PackageInfo)localObject1).applicationInfo.packageName);
      return;
    }
    localObject1 = QQFileManagerUtil.n(this.a);
    this.b.a((String)localObject1, (String)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileCategoryUtil.3
 * JD-Core Version:    0.7.0.1
 */