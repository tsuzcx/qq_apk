package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class OpenSdkD55Processor
  extends IQConfigProcessor<OpenSdkD55Bean>
{
  public static boolean a()
  {
    OpenSdkD55Bean localOpenSdkD55Bean = (OpenSdkD55Bean)QConfigManager.b().b(613);
    boolean bool;
    if (localOpenSdkD55Bean != null) {
      bool = localOpenSdkD55Bean.a();
    } else {
      bool = false;
    }
    QLog.d("OpenSdkD55Processor", 1, new Object[] { "isSwitchOpen = ", Boolean.valueOf(bool) });
    return bool;
  }
  
  @NonNull
  public OpenSdkD55Bean a(int paramInt)
  {
    return new OpenSdkD55Bean();
  }
  
  @Nullable
  public OpenSdkD55Bean a(QConfItem[] paramArrayOfQConfItem)
  {
    int i = 0;
    if (paramArrayOfQConfItem != null) {
      i = paramArrayOfQConfItem.length;
    }
    QLog.d("OpenSdkD55Processor", 1, new Object[] { "onParsed confFiles.length=", Integer.valueOf(i) });
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      new OpenSdkD55Bean();
      return OpenSdkD55Bean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(OpenSdkD55Bean paramOpenSdkD55Bean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramOpenSdkD55Bean.toString());
      QLog.d("OpenSdkD55Processor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<OpenSdkD55Bean> clazz()
  {
    return OpenSdkD55Bean.class;
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
    return 613;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.OpenSdkD55Processor
 * JD-Core Version:    0.7.0.1
 */