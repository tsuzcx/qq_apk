package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.config.business.qfile.QFileExcitingGroupDownloadConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileExcitingGroupDownloadConfigBean;

public class QFileExcitingGroupDownloadConfigBeanImpl
  implements IQFileExcitingGroupDownloadConfigBean
{
  public boolean isDebugLocalEnable()
  {
    return QFileExcitingGroupDownloadConfigBean.b();
  }
  
  public void setDebugLocalEnable(boolean paramBoolean)
  {
    QFileExcitingGroupDownloadConfigBean.b(paramBoolean);
  }
  
  public void setDebugUseLocalCfg(boolean paramBoolean)
  {
    QFileExcitingGroupDownloadConfigBean.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QFileExcitingGroupDownloadConfigBeanImpl
 * JD-Core Version:    0.7.0.1
 */