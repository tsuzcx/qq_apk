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
    OpenSdkSwitchConfBean localOpenSdkSwitchConfBean = (OpenSdkSwitchConfBean)QConfigManager.a().a(paramInt);
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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfQConfItem != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfQConfItem.length > 0)
      {
        localObject1 = paramArrayOfQConfItem[0].a;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label125;
        }
        QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] type=" + type() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfQConfItem = (OpenSdkSwitchConfBean.OpenSdkSwitchConfig)QStorage.a(localObject1, OpenSdkSwitchConfBean.OpenSdkSwitchConfig.class);
      localObject1 = new OpenSdkSwitchConfBean((String)localObject1, paramArrayOfQConfItem);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfQConfItem)
    {
      for (;;)
      {
        QLog.i("OpenSdkSwitchProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfQConfItem);
        paramArrayOfQConfItem = null;
      }
    }
    label125:
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + type());
    return null;
  }
  
  public void a(OpenSdkSwitchConfBean paramOpenSdkSwitchConfBean)
  {
    QLog.d("OpenSdkSwitchProcessor", 1, "OpenVirtual.[onUpdate] type=" + type() + ", content = " + paramOpenSdkSwitchConfBean.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkSwitchProcessor
 * JD-Core Version:    0.7.0.1
 */