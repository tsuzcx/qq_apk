package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class CustomOnlineStatusProcessor
  extends BaseQVipConfigProcessor<CustomOnlineStatusConfig>
{
  @NonNull
  public CustomOnlineStatusConfig a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateDefaultContent");
    }
    return new CustomOnlineStatusConfig();
  }
  
  @NonNull
  public CustomOnlineStatusConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    boolean bool = false;
    CustomOnlineStatusConfig localCustomOnlineStatusConfig = new CustomOnlineStatusConfig();
    try
    {
      if (paramArrayOfQConfItem[0].a != null)
      {
        if (new JSONObject(paramArrayOfQConfItem[0].a).optInt("show_custom_online_state", 1) == 1) {
          bool = true;
        }
        localCustomOnlineStatusConfig.a = bool;
        if (QLog.isColorLevel()) {
          QLog.d("CustomOnlineStatusManager", 2, "parsed showVipIcon: " + localCustomOnlineStatusConfig.a);
        }
      }
      return localCustomOnlineStatusConfig;
    }
    catch (Exception paramArrayOfQConfItem)
    {
      QLog.e("CustomOnlineStatusManager", 1, "parsed failed: ", paramArrayOfQConfItem);
    }
    return localCustomOnlineStatusConfig;
  }
  
  @NonNull
  public CustomOnlineStatusConfig b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusManager", 2, "migrateOldContent");
    }
    return new CustomOnlineStatusConfig();
  }
  
  public Class<CustomOnlineStatusConfig> clazz()
  {
    return CustomOnlineStatusConfig.class;
  }
  
  public int type()
  {
    return 479;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.CustomOnlineStatusProcessor
 * JD-Core Version:    0.7.0.1
 */