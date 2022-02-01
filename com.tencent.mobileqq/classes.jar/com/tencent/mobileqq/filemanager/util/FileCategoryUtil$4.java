package com.tencent.mobileqq.filemanager.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

final class FileCategoryUtil$4
  implements Runnable
{
  FileCategoryUtil$4(FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (FileUtil.a(this.a.getFilePath())) {}
    PackageInfo localPackageInfo;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((this.a.strApkPackageName == null) || (this.a.strApkPackageName.length() == 0)) {}
        localIterator = FileCategoryUtil.a(BaseApplicationImpl.getContext()).iterator();
      } while (!localIterator.hasNext());
      localPackageInfo = (PackageInfo)localIterator.next();
    } while (!this.a.strApkPackageName.equalsIgnoreCase(localPackageInfo.packageName));
    this.a.setFilePath(localPackageInfo.applicationInfo.publicSourceDir);
    this.a.fileName = FileCategoryUtil.a(this.a.getFilePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileCategoryUtil.4
 * JD-Core Version:    0.7.0.1
 */