package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class QQLevelIconProcessor
  extends BaseQVipConfigProcessor<QQLevelIconConfig>
{
  public static QQLevelIconConfig c()
  {
    QQLevelIconConfig localQQLevelIconConfig2 = (QQLevelIconConfig)QConfigManager.a().a(542);
    QQLevelIconConfig localQQLevelIconConfig1 = localQQLevelIconConfig2;
    if (localQQLevelIconConfig2 == null) {
      localQQLevelIconConfig1 = new QQLevelIconConfig();
    }
    return localQQLevelIconConfig1;
  }
  
  @NonNull
  public QQLevelIconConfig a()
  {
    return new QQLevelIconConfig();
  }
  
  @NonNull
  public QQLevelIconConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("QQLevelIconProcessor", 1, paramArrayOfQConfItem[0].a);
    }
    QQLevelIconConfig localQQLevelIconConfig = new QQLevelIconConfig();
    paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
    for (;;)
    {
      try
      {
        if (!TextUtils.isEmpty(paramArrayOfQConfItem))
        {
          paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem);
          if (paramArrayOfQConfItem.optInt("newguideswitch", 1) != 1) {
            continue;
          }
          bool1 = true;
          localQQLevelIconConfig.mIsEnableGuide = bool1;
          bool1 = bool2;
          if (paramArrayOfQConfItem.optInt("rushfeeswitch", 1) == 1) {
            bool1 = true;
          }
          localQQLevelIconConfig.mIsNotifyPayment = bool1;
          localQQLevelIconConfig.mNotifyPaymentText = paramArrayOfQConfItem.optString("rushfeetips", localQQLevelIconConfig.mNotifyPaymentText);
          localQQLevelIconConfig.mExpiredNotifyPaymentText = paramArrayOfQConfItem.optString("expiredtips", localQQLevelIconConfig.mExpiredNotifyPaymentText);
        }
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        boolean bool1;
        SLog.e("QQLevelIconProcessor", "QVipBigClubSVIP9Config onParsed exception :" + paramArrayOfQConfItem.getMessage());
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.e("QQLevelIconProcessor", 1, " : " + localQQLevelIconConfig.toString());
      }
      return localQQLevelIconConfig;
      bool1 = false;
    }
  }
  
  @NonNull
  public QQLevelIconConfig b()
  {
    return new QQLevelIconConfig();
  }
  
  public Class<QQLevelIconConfig> clazz()
  {
    return QQLevelIconConfig.class;
  }
  
  public int type()
  {
    return 542;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QQLevelIconProcessor
 * JD-Core Version:    0.7.0.1
 */