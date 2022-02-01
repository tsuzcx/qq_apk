package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.config.business.qfile.QFileAppStorePromoteDialogConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileAppStorePromoteDialogConfigBean;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;

public class QFileAppStorePromoteDialogConfigBeanImpl
  implements IQFileAppStorePromoteDialogConfigBean
{
  public boolean getDialogSwitch()
  {
    return QFileConfigManager.a().a().a;
  }
  
  public void setDialogSwitch(boolean paramBoolean)
  {
    QFileConfigManager.a().a().a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QFileAppStorePromoteDialogConfigBeanImpl
 * JD-Core Version:    0.7.0.1
 */