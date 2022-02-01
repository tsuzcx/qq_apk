package com.tencent.mobileqq.vas.config.business.qvip;

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
      QLog.d("CustomOnlineStatusProcessor", 2, "migrateDefaultContent");
    }
    return new CustomOnlineStatusConfig();
  }
  
  @NonNull
  public CustomOnlineStatusConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    CustomOnlineStatusConfig localCustomOnlineStatusConfig = new CustomOnlineStatusConfig();
    boolean bool = false;
    try
    {
      if (paramArrayOfQConfItem[0].a != null)
      {
        if (new JSONObject(paramArrayOfQConfItem[0].a).optInt("show_custom_online_state", 1) == 1) {
          bool = true;
        }
        localCustomOnlineStatusConfig.a = bool;
        if (QLog.isColorLevel())
        {
          paramArrayOfQConfItem = new StringBuilder();
          paramArrayOfQConfItem.append("parsed showVipIcon: ");
          paramArrayOfQConfItem.append(localCustomOnlineStatusConfig.a);
          QLog.d("CustomOnlineStatusProcessor", 2, paramArrayOfQConfItem.toString());
          return localCustomOnlineStatusConfig;
        }
      }
    }
    catch (Exception paramArrayOfQConfItem)
    {
      QLog.e("CustomOnlineStatusProcessor", 1, "parsed failed: ", paramArrayOfQConfItem);
    }
    return localCustomOnlineStatusConfig;
  }
  
  @NonNull
  public CustomOnlineStatusConfig b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CustomOnlineStatusProcessor", 2, "migrateOldContent");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.CustomOnlineStatusProcessor
 * JD-Core Version:    0.7.0.1
 */