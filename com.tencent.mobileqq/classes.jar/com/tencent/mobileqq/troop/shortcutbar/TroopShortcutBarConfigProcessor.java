package com.tencent.mobileqq.troop.shortcutbar;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nullable;

public class TroopShortcutBarConfigProcessor
  extends IQConfigProcessor<TroopShortcutBarConfig>
{
  @NonNull
  public TroopShortcutBarConfig a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("migrateOldOrDefaultContent, type: ");
    localStringBuilder.append(paramInt);
    QLog.d("TroopShortcutBarConfig.config", 2, localStringBuilder.toString());
    return new TroopShortcutBarConfig();
  }
  
  @Nullable
  public TroopShortcutBarConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0)) {
      return TroopShortcutBarConfig.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TroopShortcutBarConfig paramTroopShortcutBarConfig) {}
  
  public Class<TroopShortcutBarConfig> clazz()
  {
    return TroopShortcutBarConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return true;
  }
  
  public boolean isNeedUpgradeReset()
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
    QLog.d("TroopShortcutBarConfig.config", 1, localStringBuilder.toString());
  }
  
  public int type()
  {
    return 590;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarConfigProcessor
 * JD-Core Version:    0.7.0.1
 */