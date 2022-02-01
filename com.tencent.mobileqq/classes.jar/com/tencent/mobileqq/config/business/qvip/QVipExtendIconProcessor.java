package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipExtendIconProcessor
  extends BaseQVipConfigProcessor<QVipExtendIconConfig>
{
  @NonNull
  public QVipExtendIconConfig a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateDefaultContent");
    }
    return new QVipExtendIconConfig();
  }
  
  @NonNull
  public QVipExtendIconConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    QVipExtendIconConfig localQVipExtendIconConfig = new QVipExtendIconConfig();
    try
    {
      localQVipExtendIconConfig.a = new JSONObject(paramArrayOfQConfItem[0].a).optBoolean("showVipIcon", false);
      if (QLog.isColorLevel()) {
        QLog.d("QVipExtendIconProcessor", 2, "parsed showVipIcon: " + localQVipExtendIconConfig.a);
      }
      return localQVipExtendIconConfig;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      QLog.e("QVipExtendIconProcessor", 1, "parsed failed: ", paramArrayOfQConfItem);
    }
    return localQVipExtendIconConfig;
  }
  
  @NonNull
  public QVipExtendIconConfig b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QVipExtendIconProcessor", 2, "migrateOldContent");
    }
    return new QVipExtendIconConfig();
  }
  
  public Class<QVipExtendIconConfig> clazz()
  {
    return QVipExtendIconConfig.class;
  }
  
  public int type()
  {
    return 465;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipExtendIconProcessor
 * JD-Core Version:    0.7.0.1
 */