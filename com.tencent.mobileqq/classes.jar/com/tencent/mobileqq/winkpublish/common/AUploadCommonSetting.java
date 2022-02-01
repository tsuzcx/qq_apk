package com.tencent.mobileqq.winkpublish.common;

import com.tencent.mobileqq.winkpublish.api.IUploadLocalConfig;
import com.tencent.mobileqq.winkpublish.common.config.QFSUploadLocalConfig;
import com.tencent.qphone.base.util.QLog;

public final class AUploadCommonSetting
{
  private static final String a;
  private static IUploadLocalConfig b;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(UploadConstants.a);
    localStringBuilder.append("AUploadCommonSetting");
    a = localStringBuilder.toString();
  }
  
  public static final IUploadLocalConfig a()
  {
    if (b == null)
    {
      b = new QFSUploadLocalConfig();
      QLog.d(a, 1, "getUploadLocalConfig... use DefaultUploadLocalConfig");
    }
    return b;
  }
  
  public static void a(IUploadLocalConfig paramIUploadLocalConfig)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("init... config:");
    localStringBuilder.append(paramIUploadLocalConfig);
    QLog.d(str, 1, localStringBuilder.toString());
    b = paramIUploadLocalConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.common.AUploadCommonSetting
 * JD-Core Version:    0.7.0.1
 */