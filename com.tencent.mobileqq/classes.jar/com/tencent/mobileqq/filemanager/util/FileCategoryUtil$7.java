package com.tencent.mobileqq.filemanager.util;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import apua;
import apue;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;

public final class FileCategoryUtil$7
  implements Runnable
{
  public FileCategoryUtil$7(String paramString, apua paramapua) {}
  
  public void run()
  {
    Object localObject = BaseApplicationImpl.getContext().getPackageManager();
    PackageInfo localPackageInfo = ((PackageManager)localObject).getPackageArchiveInfo(this.jdField_a_of_type_JavaLangString, 1);
    if (localPackageInfo != null)
    {
      this.jdField_a_of_type_Apua.b(localPackageInfo.applicationInfo.packageName);
      localObject = localPackageInfo.applicationInfo.loadLabel((PackageManager)localObject).toString();
      localObject = (String)localObject + ".apk";
      this.jdField_a_of_type_Apua.a((String)localObject);
      return;
    }
    this.jdField_a_of_type_Apua.b(apue.a(this.jdField_a_of_type_JavaLangString));
    this.jdField_a_of_type_Apua.a(apue.a(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.util.FileCategoryUtil.7
 * JD-Core Version:    0.7.0.1
 */