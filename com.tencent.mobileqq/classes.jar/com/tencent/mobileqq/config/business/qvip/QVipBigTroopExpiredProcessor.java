package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import org.json.JSONException;
import org.json.JSONObject;

public class QVipBigTroopExpiredProcessor
  extends BaseQVipConfigProcessor<QVipBigTroopExpiredConfig>
{
  public static QVipBigTroopExpiredConfig c()
  {
    QVipBigTroopExpiredConfig localQVipBigTroopExpiredConfig2 = (QVipBigTroopExpiredConfig)QConfigManager.a().a(428);
    QVipBigTroopExpiredConfig localQVipBigTroopExpiredConfig1 = localQVipBigTroopExpiredConfig2;
    if (localQVipBigTroopExpiredConfig2 == null) {
      localQVipBigTroopExpiredConfig1 = new QVipBigTroopExpiredConfig();
    }
    return localQVipBigTroopExpiredConfig1;
  }
  
  @NonNull
  public QVipBigTroopExpiredConfig a()
  {
    return new QVipBigTroopExpiredConfig();
  }
  
  @NonNull
  public QVipBigTroopExpiredConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    boolean bool = true;
    localQVipBigTroopExpiredConfig = new QVipBigTroopExpiredConfig();
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
    try
    {
      if (!TextUtils.isEmpty(paramArrayOfQConfItem))
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem);
        if (paramArrayOfQConfItem.optInt("enable", 1) != 1) {
          break label164;
        }
      }
      for (;;)
      {
        localQVipBigTroopExpiredConfig.mIsEnable = bool;
        localQVipBigTroopExpiredConfig.mNotifyTipsMaxDay = paramArrayOfQConfItem.optInt("NotifyTipsMaxDay", 15);
        localQVipBigTroopExpiredConfig.mNotifyTipsMinDay = paramArrayOfQConfItem.optInt("NotifyTipsMinDay", 7);
        localQVipBigTroopExpiredConfig.mNotifyTipsMaxCount = paramArrayOfQConfItem.optInt("NotifyTipsMaxCount", 2);
        localQVipBigTroopExpiredConfig.mNotifyTipsPerDay = paramArrayOfQConfItem.optInt("NotifyTipsPerDay", 1);
        localQVipBigTroopExpiredConfig.mNotifyTipsMaxCloseCount = paramArrayOfQConfItem.optInt("NotifyTipsMaxCloseCount", 3);
        localQVipBigTroopExpiredConfig.mNotifyDialogMaxDay = paramArrayOfQConfItem.optInt("NotifyDialogMaxDay", 7);
        localQVipBigTroopExpiredConfig.mNotifyDialogMinDay = paramArrayOfQConfItem.optInt("NotifyDialogMinDay", 0);
        localQVipBigTroopExpiredConfig.mNotifyDialogMaxCount = paramArrayOfQConfItem.optInt("NotifyDialogMaxCount", 2);
        localQVipBigTroopExpiredConfig.mNotifyDialogPerDay = paramArrayOfQConfItem.optInt("NotifyDialogPerDay", 1);
        localQVipBigTroopExpiredConfig.mNotifyDialogExpiredIntervalDay = paramArrayOfQConfItem.optInt("NotifyDialogExpiredIntervalDay", 5);
        return localQVipBigTroopExpiredConfig;
        label164:
        bool = false;
      }
      return localQVipBigTroopExpiredConfig;
    }
    catch (JSONException paramArrayOfQConfItem)
    {
      SLog.e("QVipBigTroopExpiredProcessor", "QVipBigTroopExpiredConfig onParsed exception :" + paramArrayOfQConfItem.getMessage());
    }
  }
  
  @NonNull
  public QVipBigTroopExpiredConfig b()
  {
    return new QVipBigTroopExpiredConfig();
  }
  
  public Class<QVipBigTroopExpiredConfig> clazz()
  {
    return QVipBigTroopExpiredConfig.class;
  }
  
  public int type()
  {
    return 428;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipBigTroopExpiredProcessor
 * JD-Core Version:    0.7.0.1
 */