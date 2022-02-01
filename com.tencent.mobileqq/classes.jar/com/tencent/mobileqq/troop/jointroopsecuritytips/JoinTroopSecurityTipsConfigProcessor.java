package com.tencent.mobileqq.troop.jointroopsecuritytips;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;

public class JoinTroopSecurityTipsConfigProcessor
  extends IQConfigProcessor<JoinTroopSecurityTipsConfig>
{
  @NonNull
  public JoinTroopSecurityTipsConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type = ");
    localStringBuilder.append(paramInt);
    QLog.d("JoinTroopSecurityTipsConfigProcessor", 2, localStringBuilder.toString());
    return new JoinTroopSecurityTipsConfig();
  }
  
  @Nullable
  public JoinTroopSecurityTipsConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("JoinTroopSecurityTipsConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return JoinTroopSecurityTipsConfig.a(paramArrayOfQConfItem[0].a);
    }
    return null;
  }
  
  public void a(JoinTroopSecurityTipsConfig paramJoinTroopSecurityTipsConfig) {}
  
  public Class<JoinTroopSecurityTipsConfig> clazz()
  {
    return JoinTroopSecurityTipsConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onReqFailed, failCode = ");
    localStringBuilder.append(paramInt);
    QLog.d("JoinTroopSecurityTipsConfigProcessor", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 669;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.jointroopsecuritytips.JoinTroopSecurityTipsConfigProcessor
 * JD-Core Version:    0.7.0.1
 */