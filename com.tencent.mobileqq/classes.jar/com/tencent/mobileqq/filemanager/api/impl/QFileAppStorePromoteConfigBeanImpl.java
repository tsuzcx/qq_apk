package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.config.business.qfile.QFileAppStorePromoteConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileAppStorePromoteConfigBean;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;

public class QFileAppStorePromoteConfigBeanImpl
  implements IQFileAppStorePromoteConfigBean
{
  public String getActionHint()
  {
    return QFileConfigManager.a().a().jdField_a_of_type_JavaLangString;
  }
  
  public boolean getActionSwitch()
  {
    return QFileConfigManager.a().a().jdField_a_of_type_Boolean;
  }
  
  public void setActionSwitch(boolean paramBoolean)
  {
    QFileConfigManager.a().a().jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QFileAppStorePromoteConfigBeanImpl
 * JD-Core Version:    0.7.0.1
 */