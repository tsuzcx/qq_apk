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
    OpenSdkRandomConfBean localOpenSdkRandomConfBean = (OpenSdkRandomConfBean)QConfigManager.a().a(paramInt);
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
        QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] type=" + type() + ", content = " + (String)localObject1);
      }
    }
    try
    {
      paramArrayOfQConfItem = (OpenSdkRandomConfBean.OpenSdkRandomConfig)QStorage.a(localObject1, OpenSdkRandomConfBean.OpenSdkRandomConfig.class);
      localObject1 = new OpenSdkRandomConfBean((String)localObject1, paramArrayOfQConfItem);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfQConfItem)
    {
      for (;;)
      {
        QLog.i("OpenSdkRandomProcessor", 1, "readJsonOrXml:" + (String)localObject1 + "fail", paramArrayOfQConfItem);
        paramArrayOfQConfItem = null;
      }
    }
    label125:
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onParsed] content is empty, config type = " + type());
    return null;
  }
  
  public void a(OpenSdkRandomConfBean paramOpenSdkRandomConfBean)
  {
    QLog.d("OpenSdkRandomProcessor", 1, "OpenVirtual.[onUpdate] type=" + type() + ", content = " + paramOpenSdkRandomConfBean.a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkRandomProcessor
 * JD-Core Version:    0.7.0.1
 */