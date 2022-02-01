package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class OpenSdkFakeMsgProcessor
  extends IQConfigProcessor<OpenSdkFakeMsgBean>
{
  public static boolean a()
  {
    OpenSdkFakeMsgBean localOpenSdkFakeMsgBean = (OpenSdkFakeMsgBean)QConfigManager.a().a(632);
    if (localOpenSdkFakeMsgBean != null) {}
    for (boolean bool = localOpenSdkFakeMsgBean.a();; bool = false)
    {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, new Object[] { "isEnableFakeMsg = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public OpenSdkFakeMsgBean a(int paramInt)
  {
    return new OpenSdkFakeMsgBean();
  }
  
  @Nullable
  public OpenSdkFakeMsgBean a(QConfItem[] paramArrayOfQConfItem)
  {
    int i = 0;
    if (paramArrayOfQConfItem == null) {}
    for (;;)
    {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
        break;
      }
      new OpenSdkFakeMsgBean();
      return OpenSdkFakeMsgBean.a(paramArrayOfQConfItem);
      i = paramArrayOfQConfItem.length;
    }
    return null;
  }
  
  public void a(OpenSdkFakeMsgBean paramOpenSdkFakeMsgBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SDK_SHARE.OpenSdkFakeMsgProcessor", 2, "onUpdate " + paramOpenSdkFakeMsgBean.toString());
    }
  }
  
  public Class<OpenSdkFakeMsgBean> clazz()
  {
    return OpenSdkFakeMsgBean.class;
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
    return 632;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkFakeMsgProcessor
 * JD-Core Version:    0.7.0.1
 */