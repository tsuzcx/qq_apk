package com.tencent.mobileqq.filemanager.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import audw;
import auea;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public final class FileCategoryUtil$5
  implements Runnable
{
  public FileCategoryUtil$5(String paramString, audw paramaudw) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getContext().getPackageManager();
    PackageInfo localPackageInfo = ((PackageManager)localObject).getPackageArchiveInfo(this.jdField_a_of_type_JavaLangString, 1);
    if (localPackageInfo != null)
    {
      localObject = localPackageInfo.applicationInfo.loadLabel((PackageManager)localObject).toString();
      localObject = (String)localObject + ".apk";
      this.jdField_a_of_type_Audw.a((String)localObject, localPackageInfo.applicationInfo.packageName);
      return;
    }
    this.jdField_a_of_type_Audw.a(auea.a(this.jdField_a_of_type_JavaLangString), auea.a(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileCategoryUtil.5
 * JD-Core Version:    0.7.0.1
 */