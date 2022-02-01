package com.tencent.mobileqq.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ABTestUtil;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.qphone.base.util.QLog;

public abstract class IQConfigProcessor<T>
{
  public static final int DEFAULT = 1;
  public static final int FAIL_CODE_ERROR = -2;
  public static final int FAIL_CODE_REQ_TIMEOUT = -1;
  public static final int MIGRATE = 0;
  private static final String TAG = "IQConfigProcessor";
  
  public abstract Class<T> clazz();
  
  public boolean isAccountRelated()
  {
    return true;
  }
  
  public abstract boolean isNeedCompressed();
  
  public boolean isNeedReloadConf()
  {
    return false;
  }
  
  public abstract boolean isNeedStoreLargeFile();
  
  public boolean isNeedUpgradeReset()
  {
    return false;
  }
  
  @NonNull
  public abstract T migrateOldOrDefaultContent(int paramInt);
  
  public abstract int migrateOldVersion();
  
  @Nullable
  public abstract T onParsed(QConfItem[] paramArrayOfQConfItem);
  
  public void onProcessorConstructed(int paramInt) {}
  
  public abstract void onReqFailed(int paramInt);
  
  public void onReqNoReceive()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqNoReceive: type=");
      localStringBuilder.append(type());
      QLog.d("IQConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int onSend(int paramInt)
  {
    return paramInt;
  }
  
  public abstract void onUpdate(T paramT);
  
  public String tabExperimentId()
  {
    if (ABTestController.a().b())
    {
      ExpEntityInfo localExpEntityInfo = ABTestController.a().a(type());
      if ((localExpEntityInfo.i()) && (!localExpEntityInfo.g()) && (ABTestUtil.a(localExpEntityInfo.c()))) {
        return localExpEntityInfo.c();
      }
    }
    return "";
  }
  
  public String tabGroupId()
  {
    if (ABTestController.a().b())
    {
      ExpEntityInfo localExpEntityInfo = ABTestController.a().a(type());
      if ((localExpEntityInfo.i()) && (!localExpEntityInfo.g()) && (ABTestUtil.a(localExpEntityInfo.d()))) {
        return localExpEntityInfo.d();
      }
    }
    return "";
  }
  
  public abstract int type();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.IQConfigProcessor
 * JD-Core Version:    0.7.0.1
 */