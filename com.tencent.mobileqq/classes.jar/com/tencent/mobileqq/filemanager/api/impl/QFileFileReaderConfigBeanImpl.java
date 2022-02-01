package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.config.business.qfile.QFileFileReaderConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileFileReaderConfigBean;
import com.tencent.mobileqq.filemanager.app.QFileConfigManager;

public class QFileFileReaderConfigBeanImpl
  implements IQFileFileReaderConfigBean
{
  public boolean getIsShowReaderBar()
  {
    return QFileConfigManager.a().a().a;
  }
  
  public void setIsShowReaderBar(boolean paramBoolean)
  {
    QFileConfigManager.a().a().a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QFileFileReaderConfigBeanImpl
 * JD-Core Version:    0.7.0.1
 */