package com.tencent.mobileqq.persistence;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;

public class CommonFunctionPublishConfigProcessor
  extends IQConfigProcessor<CommonFunctionPublishConfigProcessor.Config>
{
  public static CommonFunctionPublishConfigProcessor.Config a()
  {
    CommonFunctionPublishConfigProcessor.Config localConfig = (CommonFunctionPublishConfigProcessor.Config)QConfigManager.b().b(730);
    if (localConfig != null)
    {
      com.tencent.mobileqq.app.SQLiteOpenHelper.WAL_ENABLE = localConfig.b;
      return localConfig;
    }
    return new CommonFunctionPublishConfigProcessor.Config();
  }
  
  @NonNull
  public CommonFunctionPublishConfigProcessor.Config a(int paramInt)
  {
    return new CommonFunctionPublishConfigProcessor.Config();
  }
  
  @Nullable
  public CommonFunctionPublishConfigProcessor.Config a(QConfItem[] paramArrayOfQConfItem)
  {
    CommonFunctionPublishConfigProcessor.Config localConfig = new CommonFunctionPublishConfigProcessor.Config();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null)) {
      CommonFunctionPublishConfigProcessor.Config.a(localConfig, paramArrayOfQConfItem[0].b);
    }
    return localConfig;
  }
  
  public void a(CommonFunctionPublishConfigProcessor.Config paramConfig) {}
  
  public Class<CommonFunctionPublishConfigProcessor.Config> clazz()
  {
    return CommonFunctionPublishConfigProcessor.Config.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public boolean isNeedUpgradeReset()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 730;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.CommonFunctionPublishConfigProcessor
 * JD-Core Version:    0.7.0.1
 */