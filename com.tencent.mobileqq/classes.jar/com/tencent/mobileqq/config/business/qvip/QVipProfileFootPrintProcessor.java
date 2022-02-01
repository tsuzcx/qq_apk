package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipProfileFootPrintProcessor
  extends BaseQVipConfigProcessor<QVipProfileFootPrintConfig>
{
  public static QVipProfileFootPrintConfig a()
  {
    return (QVipProfileFootPrintConfig)QConfigManager.a().a(413);
  }
  
  @NonNull
  public QVipProfileFootPrintConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    QVipProfileFootPrintConfig localQVipProfileFootPrintConfig = new QVipProfileFootPrintConfig();
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
    if (paramArrayOfQConfItem != null) {}
    try
    {
      if (!"".equals(paramArrayOfQConfItem))
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem);
        localQVipProfileFootPrintConfig.a(paramArrayOfQConfItem.getString("url"));
        localQVipProfileFootPrintConfig.a(paramArrayOfQConfItem.getBoolean("isEnable"));
        localQVipProfileFootPrintConfig.b(paramArrayOfQConfItem.getBoolean("hideHotValue"));
      }
      return localQVipProfileFootPrintConfig;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      paramArrayOfQConfItem.printStackTrace();
    }
    return localQVipProfileFootPrintConfig;
  }
  
  @NonNull
  public QVipProfileFootPrintConfig b()
  {
    return new QVipProfileFootPrintConfig();
  }
  
  @NonNull
  public QVipProfileFootPrintConfig c()
  {
    return new QVipProfileFootPrintConfig();
  }
  
  public Class<QVipProfileFootPrintConfig> clazz()
  {
    return QVipProfileFootPrintConfig.class;
  }
  
  public int type()
  {
    return 413;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipProfileFootPrintProcessor
 * JD-Core Version:    0.7.0.1
 */