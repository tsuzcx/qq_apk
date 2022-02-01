package com.tencent.mobileqq.filemanager.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class FMSettings$StorageInfo
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  String b;
  String c;
  
  private FMSettings$StorageInfo(FMSettings paramFMSettings) {}
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext.getSharedPreferences("FMSETTING_59", 3).edit().putString("DefaultRootPath", this.b).commit();
    paramContext = FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, this.b + this.c);
    Object localObject = FMSettings.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, this.b + this.c);
    String str = FMSettings.c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, this.b + this.c);
    FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, paramContext);
    FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, str);
    FMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings, (String)localObject);
    paramContext = this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a.keySet().iterator();
    while (paramContext.hasNext())
    {
      localObject = (String)paramContext.next();
      localObject = (StorageInfo)this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsFMSettings.a.get(localObject);
      if ((((StorageInfo)localObject).jdField_a_of_type_Boolean) && (localObject != this))
      {
        FMSettings.a(2, "getDefaultStorage[" + ((StorageInfo)localObject).b + "]");
        ((StorageInfo)localObject).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.FMSettings.StorageInfo
 * JD-Core Version:    0.7.0.1
 */