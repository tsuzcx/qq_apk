package com.tencent.mobileqq.filemanager.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import arrj;
import arso;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import java.util.Iterator;
import java.util.List;

public final class FileCategoryUtil$6
  implements Runnable
{
  public FileCategoryUtil$6(FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (arso.a(this.a.getFilePath())) {}
    PackageInfo localPackageInfo;
    do
    {
      Iterator localIterator;
      do
      {
        return;
        while ((this.a.strApkPackageName == null) || (this.a.strApkPackageName.length() == 0)) {}
        localIterator = arrj.a(BaseApplicationImpl.getContext()).iterator();
      } while (!localIterator.hasNext());
      localPackageInfo = (PackageInfo)localIterator.next();
    } while (!this.a.strApkPackageName.equalsIgnoreCase(localPackageInfo.packageName));
    this.a.setFilePath(localPackageInfo.applicationInfo.publicSourceDir);
    this.a.fileName = arrj.a(this.a.getFilePath());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileCategoryUtil.6
 * JD-Core Version:    0.7.0.1
 */