package com.tencent.mobileqq.filemanager.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class QQFMSettings$StorageInfo
{
  long jdField_a_of_type_Long;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  String b;
  String c;
  
  private QQFMSettings$StorageInfo(QQFMSettings paramQQFMSettings) {}
  
  public void a() {}
  
  public void a(Context paramContext)
  {
    paramContext.getSharedPreferences("FMSETTING_59", 3).edit().putString("DefaultRootPath", this.b).commit();
    paramContext = this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings;
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append(this.c);
    paramContext = QQFMSettings.a(paramContext, ((StringBuilder)localObject1).toString());
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append(this.c);
    localObject1 = QQFMSettings.b((QQFMSettings)localObject1, ((StringBuilder)localObject2).toString());
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append(this.c);
    localObject2 = QQFMSettings.c((QQFMSettings)localObject2, localStringBuilder.toString());
    QQFMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings, paramContext);
    QQFMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings, (String)localObject2);
    QQFMSettings.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings, (String)localObject1);
    paramContext = this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings.a.keySet().iterator();
    while (paramContext.hasNext())
    {
      localObject1 = (String)paramContext.next();
      localObject1 = (StorageInfo)this.jdField_a_of_type_ComTencentMobileqqFilemanagerSettingsQQFMSettings.a.get(localObject1);
      if ((((StorageInfo)localObject1).jdField_a_of_type_Boolean) && (localObject1 != this))
      {
        paramContext = new StringBuilder();
        paramContext.append("getDefaultStorage[");
        paramContext.append(((StorageInfo)localObject1).b);
        paramContext.append("]");
        QQFMSettings.a(2, paramContext.toString());
        ((StorageInfo)localObject1).jdField_a_of_type_Boolean = false;
      }
    }
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.settings.QQFMSettings.StorageInfo
 * JD-Core Version:    0.7.0.1
 */