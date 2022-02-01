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

public class OpenSdkSwitchProcessor
  extends IQConfigProcessor<OpenSdkSwitchConfBean>
{
  public static OpenSdkSwitchConfBean b(int paramInt)
  {
    OpenSdkSwitchConfBean localOpenSdkSwitchConfBean = (OpenSdkSwitchConfBean)QConfigManager.b().b(paramInt);
    if (localOpenSdkSwitchConfBean != null) {
      return localOpenSdkSwitchConfBean;
    }
    return new OpenSdkSwitchConfBean();
  }
  
  @NonNull
  public OpenSdkSwitchConfBean a(int paramInt)
  {
    return new OpenSdkSwitchConfBean();
  }
  
  @Nullable
  public OpenSdkSwitchConfBean a(QConfItem[] paramArrayOfQConfItem)
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
        QLog.d("OpenSdkSwitchProcessor", 1, paramArrayOfQConfItem.toString());
        try
        {
          paramArrayOfQConfItem = (OpenSdkSwitchConfBean.OpenSdkSwitchConfig)QStorage.a(str, OpenSdkSwitchConfBean.OpenSdkSwitchConfig.class);
        }
        catch (QStorageInstantiateException paramArrayOfQConfItem)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("readJsonOrXml:");
          localStringBuilder.append(str);
          localStringBuilder.append("fail");
          QLog.i("OpenSdkSwitchProcessor", 1, localStringBuilder.toString(), paramArrayOfQConfItem);
          paramArrayOfQConfItem = localObject;
        }
        return new OpenSdkSwitchConfBean(str, paramArrayOfQConfItem);
      }
      paramArrayOfQConfItem = new StringBuilder();
      paramArrayOfQConfItem.append("OpenVirtual.[onParsed] content is empty, config type = ");
      paramArrayOfQConfItem.append(type());
      QLog.d("OpenSdkSwitchProcessor", 1, paramArrayOfQConfItem.toString());
    }
    return null;
  }
  
  public void a(OpenSdkSwitchConfBean paramOpenSdkSwitchConfBean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OpenVirtual.[onUpdate] type=");
    localStringBuilder.append(type());
    localStringBuilder.append(", content = ");
    localStringBuilder.append(paramOpenSdkSwitchConfBean.a());
    QLog.d("OpenSdkSwitchProcessor", 1, localStringBuilder.toString());
  }
  
  public Class<OpenSdkSwitchConfBean> clazz()
  {
    return OpenSdkSwitchConfBean.class;
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
    return 467;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkSwitchProcessor
 * JD-Core Version:    0.7.0.1
 */