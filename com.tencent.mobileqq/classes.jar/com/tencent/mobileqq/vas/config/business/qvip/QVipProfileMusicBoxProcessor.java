package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipProfileMusicBoxProcessor
  extends BaseQVipConfigProcessor<QVipProfileMusicBoxConfig>
{
  public static QVipProfileMusicBoxConfig a()
  {
    return (QVipProfileMusicBoxConfig)QConfigManager.b().b(563);
  }
  
  @NonNull
  public QVipProfileMusicBoxConfig a(@NonNull QConfItem[] paramArrayOfQConfItem)
  {
    QVipProfileMusicBoxConfig localQVipProfileMusicBoxConfig = new QVipProfileMusicBoxConfig();
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].b;
    if (paramArrayOfQConfItem != null) {
      try
      {
        if (!"".equals(paramArrayOfQConfItem))
        {
          paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem);
          localQVipProfileMusicBoxConfig.a = paramArrayOfQConfItem.getString("musicBoxUrl");
          localQVipProfileMusicBoxConfig.b = paramArrayOfQConfItem.getString("playerUrl");
          return localQVipProfileMusicBoxConfig;
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        paramArrayOfQConfItem.printStackTrace();
      }
    }
    return localQVipProfileMusicBoxConfig;
  }
  
  @NonNull
  public QVipProfileMusicBoxConfig b()
  {
    return new QVipProfileMusicBoxConfig();
  }
  
  public Class<QVipProfileMusicBoxConfig> clazz()
  {
    return QVipProfileMusicBoxConfig.class;
  }
  
  @NonNull
  public QVipProfileMusicBoxConfig e()
  {
    return new QVipProfileMusicBoxConfig();
  }
  
  public int type()
  {
    return 563;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipProfileMusicBoxProcessor
 * JD-Core Version:    0.7.0.1
 */