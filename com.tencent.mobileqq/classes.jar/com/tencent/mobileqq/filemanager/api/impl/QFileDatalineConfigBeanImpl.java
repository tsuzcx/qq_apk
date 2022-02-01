package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.config.business.qfile.QFileDatalineConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileDatalineConfigBean;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;
import mqq.app.AppRuntime;

public class QFileDatalineConfigBeanImpl
  implements IQFileDatalineConfigBean
{
  public long getDelayStartOfflineTime()
  {
    return QFileConfigManager.a().a().c;
  }
  
  public boolean getFileAssistantSwitch()
  {
    return QFileConfigManager.a().a().jdField_a_of_type_Boolean;
  }
  
  public boolean getIpadOnline()
  {
    return QFileConfigManager.a().a().jdField_b_of_type_Boolean;
  }
  
  public long getOfflineAutoDownload()
  {
    return QFileConfigManager.a().a().jdField_b_of_type_Long;
  }
  
  public long getOnlyOfflineLimitSize()
  {
    return QFileConfigManager.a().a().jdField_a_of_type_Long;
  }
  
  public void setFileAssistantSwitch(boolean paramBoolean)
  {
    QFileConfigManager.a().a().jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setIpadOnline(boolean paramBoolean)
  {
    QFileConfigManager.a().a().jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setNewFileAssistantSwitch(AppRuntime paramAppRuntime, boolean paramBoolean)
  {
    QFileConfigManager.a().a().a(paramAppRuntime, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QFileDatalineConfigBeanImpl
 * JD-Core Version:    0.7.0.1
 */