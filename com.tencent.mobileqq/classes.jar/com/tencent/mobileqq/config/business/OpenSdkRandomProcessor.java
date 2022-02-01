package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class OpenSdkRandomProcessor
  extends IQConfigProcessor<OpenSdkRandomConfBean>
{
  public static OpenSdkRandomConfBean b(int paramInt)
  {
    OpenSdkRandomConfBean localOpenSdkRandomConfBean = (OpenSdkRandomConfBean)QConfigManager.b().b(paramInt);
    if (localOpenSdkRandomConfBean != null) {
      return localOpenSdkRandomConfBean;
    }
    return new OpenSdkRandomConfBean();
  }
  
  @NonNull
  public OpenSdkRandomConfBean a(int paramInt)
  {
    return new OpenSdkRandomConfBean();
  }
  
  @Nullable
  public OpenSdkRandomConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    Object localObject = null;
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      String str = paramArrayOfQConfItem[0].b;
      if (!TextUtils.isEmpty(str))
      {
        paramArrayOfQConfItem = new StringBuilder();
        paramArrayOfQConfItem.append("OpenVirtual.[onParsed] type=");
        paramArrayOfQConfItem.append(type());
        paramArrayOfQConfItem.append(", content = ");
        paramArrayOfQConfItem.append(str);
        QLog.d("OpenSdkRandomProcessor", 1, paramArrayOfQConfItem.toString());
        try
        {
          paramArrayOfQConfItem = (OpenSdkRandomConfBean.OpenSdkRandomConfig)QStorage.a(str, OpenSdkRandomConfBean.OpenSdkRandomConfig.class);
        }
        catch (QStorageInstantiateException paramArrayOfQConfItem)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("readJsonOrXml:");
          localStringBuilder.append(str);
          localStringBuilder.append("fail");
          QLog.i("OpenSdkRandomProcessor", 1, localStringBuilder.toString(), paramArrayOfQConfItem);
          paramArrayOfQConfItem = localObject;
        }
        return new OpenSdkRandomConfBean(str, paramArrayOfQConfItem);
      }
      paramArrayOfQConfItem = new StringBuilder();
      paramArrayOfQConfItem.append("OpenVirtual.[onParsed] content is empty, config type = ");
      paramArrayOfQConfItem.append(type());
      QLog.d("OpenSdkRandomProcessor", 1, paramArrayOfQConfItem.toString());
    }
    return null;
  }
  
  public void a(OpenSdkRandomConfBean paramOpenSdkRandomConfBean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OpenVirtual.[onUpdate] type=");
    localStringBuilder.append(type());
    localStringBuilder.append(", content = ");
    localStringBuilder.append(paramOpenSdkRandomConfBean.a());
    QLog.d("OpenSdkRandomProcessor", 1, localStringBuilder.toString());
  }
  
  public Class<OpenSdkRandomConfBean> clazz()
  {
    return OpenSdkRandomConfBean.class;
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
    return 466;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkRandomProcessor
 * JD-Core Version:    0.7.0.1
 */