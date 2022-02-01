package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.config.business.qfile.QFileExcitingC2CUploadConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileExcitingC2CUploadConfigBean;

public class QFileExcitingC2CUploadConfigBeanImpl
  implements IQFileExcitingC2CUploadConfigBean
{
  public boolean isDebugLocalEnable()
  {
    return QFileExcitingC2CUploadConfigBean.c();
  }
  
  public boolean isDebugUseLocalCfg()
  {
    return QFileExcitingC2CUploadConfigBean.b();
  }
  
  public void setDebugLocalEnable(boolean paramBoolean)
  {
    QFileExcitingC2CUploadConfigBean.b(paramBoolean);
  }
  
  public void setDebugUseLocalCfg(boolean paramBoolean)
  {
    QFileExcitingC2CUploadConfigBean.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QFileExcitingC2CUploadConfigBeanImpl
 * JD-Core Version:    0.7.0.1
 */