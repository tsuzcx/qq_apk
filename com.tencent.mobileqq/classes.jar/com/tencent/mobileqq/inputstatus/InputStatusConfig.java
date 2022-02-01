package com.tencent.mobileqq.inputstatus;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;

public class InputStatusConfig
  extends IQConfigProcessor<InputStatusConfig.Config>
{
  @NonNull
  public InputStatusConfig.Config a(int paramInt)
  {
    return new InputStatusConfig.Config();
  }
  
  @Nullable
  public InputStatusConfig.Config a(QConfItem[] paramArrayOfQConfItem)
  {
    InputStatusConfig.Config localConfig = new InputStatusConfig.Config();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null)) {
      InputStatusConfig.Config.a(localConfig, paramArrayOfQConfItem[0].b);
    }
    return localConfig;
  }
  
  public void a(InputStatusConfig.Config paramConfig) {}
  
  public Class<InputStatusConfig.Config> clazz()
  {
    return InputStatusConfig.Config.class;
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
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public void onReqNoReceive() {}
  
  public int type()
  {
    return 445;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.inputstatus.InputStatusConfig
 * JD-Core Version:    0.7.0.1
 */