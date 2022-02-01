package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class OpenSdkConfProcessor
  extends IQConfigProcessor<OpenSdkConfBean>
{
  public static OpenSdkConfBean a()
  {
    return (OpenSdkConfBean)QConfigManager.a().a(426);
  }
  
  public static boolean a()
  {
    OpenSdkConfBean localOpenSdkConfBean = a();
    if (localOpenSdkConfBean != null) {}
    for (boolean bool = localOpenSdkConfBean.b();; bool = false)
    {
      QLog.d("OpenSdkConfProcessor", 1, new Object[] { "isUseThirdTransformPkgName, useThirdTransformPkgName = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public OpenSdkConfBean a(int paramInt)
  {
    return new OpenSdkConfBean();
  }
  
  @Nullable
  public OpenSdkConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      new OpenSdkConfBean();
      return OpenSdkConfBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(OpenSdkConfBean paramOpenSdkConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkConfProcessor", 2, "onUpdate " + paramOpenSdkConfBean.toString());
    }
  }
  
  public Class<OpenSdkConfBean> clazz()
  {
    return OpenSdkConfBean.class;
  }
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 426;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkConfProcessor
 * JD-Core Version:    0.7.0.1
 */