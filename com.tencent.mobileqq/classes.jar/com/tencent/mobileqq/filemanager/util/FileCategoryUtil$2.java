package com.tencent.mobileqq.filemanager.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.Iterator;
import java.util.List;

final class FileCategoryUtil$2
  implements Runnable
{
  FileCategoryUtil$2(FileManagerEntity paramFileManagerEntity) {}
  
  public void run()
  {
    if (FileUtil.d(this.a.getFilePath())) {
      return;
    }
    if (this.a.strApkPackageName != null)
    {
      if (this.a.strApkPackageName.length() == 0) {
        return;
      }
      Object localObject = FileCategoryUtil.e(BaseApplication.getContext()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PackageInfo localPackageInfo = (PackageInfo)((Iterator)localObject).next();
        if (this.a.strApkPackageName.equalsIgnoreCase(localPackageInfo.packageName))
        {
          this.a.setFilePath(localPackageInfo.applicationInfo.publicSourceDir);
          localObject = this.a;
          ((FileManagerEntity)localObject).fileName = FileCategoryUtil.a(((FileManagerEntity)localObject).getFilePath());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileCategoryUtil.2
 * JD-Core Version:    0.7.0.1
 */