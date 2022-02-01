package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.config.business.qfile.QFileExcitingGroupUploadConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileExcitingGroupUploadConfigBean;

public class QFileExcitingGroupUploadConfigBeanImpl
  implements IQFileExcitingGroupUploadConfigBean
{
  public boolean isDebugLocalEnable()
  {
    return QFileExcitingGroupUploadConfigBean.c();
  }
  
  public boolean isDebugUseLocalCfg()
  {
    return QFileExcitingGroupUploadConfigBean.b();
  }
  
  public void setDebugLocalEnable(boolean paramBoolean)
  {
    QFileExcitingGroupUploadConfigBean.b(paramBoolean);
  }
  
  public void setDebugUseLocalCfg(boolean paramBoolean)
  {
    QFileExcitingGroupUploadConfigBean.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QFileExcitingGroupUploadConfigBeanImpl
 * JD-Core Version:    0.7.0.1
 */