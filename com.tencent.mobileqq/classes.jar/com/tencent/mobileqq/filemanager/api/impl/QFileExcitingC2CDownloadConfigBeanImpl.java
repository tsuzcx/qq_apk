package com.tencent.mobileqq.filemanager.api.impl;

import com.tencent.mobileqq.config.business.qfile.QFileExcitingC2CDownloadConfigBean;
import com.tencent.mobileqq.filemanager.api.IQFileExcitingC2CDownloadConfigBean;

public class QFileExcitingC2CDownloadConfigBeanImpl
  implements IQFileExcitingC2CDownloadConfigBean
{
  public void setDebugLocalEnable(boolean paramBoolean)
  {
    QFileExcitingC2CDownloadConfigBean.b(paramBoolean);
  }
  
  public void setDebugUseLocalCfg(boolean paramBoolean)
  {
    QFileExcitingC2CDownloadConfigBean.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.QFileExcitingC2CDownloadConfigBeanImpl
 * JD-Core Version:    0.7.0.1
 */