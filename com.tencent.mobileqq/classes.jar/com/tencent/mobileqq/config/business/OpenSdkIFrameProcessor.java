package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class OpenSdkIFrameProcessor
  extends IQConfigProcessor<OpenSdkIFrameBean>
{
  public static boolean a()
  {
    OpenSdkIFrameBean localOpenSdkIFrameBean = (OpenSdkIFrameBean)QConfigManager.a().a(675);
    if (localOpenSdkIFrameBean != null) {}
    for (boolean bool = localOpenSdkIFrameBean.a();; bool = true)
    {
      QLog.d("OpenSdkIFrameProcessor", 1, new Object[] { "isEnableIFrame = ", Boolean.valueOf(bool) });
      return bool;
    }
  }
  
  @NonNull
  public OpenSdkIFrameBean a(int paramInt)
  {
    return new OpenSdkIFrameBean();
  }
  
  @Nullable
  public OpenSdkIFrameBean a(QConfItem[] paramArrayOfQConfItem)
  {
    int i = 0;
    if (paramArrayOfQConfItem == null) {}
    for (;;)
    {
      QLog.d("OpenSdkIFrameProcessor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
      if ((paramArrayOfQConfItem == null) || (paramArrayOfQConfItem.length <= 0)) {
        break;
      }
      new OpenSdkIFrameBean();
      return OpenSdkIFrameBean.a(paramArrayOfQConfItem);
      i = paramArrayOfQConfItem.length;
    }
    return null;
  }
  
  public void a(OpenSdkIFrameBean paramOpenSdkIFrameBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("OpenSdkIFrameProcessor", 2, "onUpdate " + paramOpenSdkIFrameBean.toString());
    }
  }
  
  public Class<OpenSdkIFrameBean> clazz()
  {
    return OpenSdkIFrameBean.class;
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
    return 675;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkIFrameProcessor
 * JD-Core Version:    0.7.0.1
 */