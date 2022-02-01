package com.tencent.mobileqq.vas.config.business;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.vas.config.business.qvip.BaseQVipConfigProcessor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;

public class QVipHippyProcessor
  extends BaseQVipConfigProcessor<QVipHippyConfig>
{
  public static QVipHippyConfig a()
  {
    QVipHippyConfig localQVipHippyConfig2 = (QVipHippyConfig)QConfigManager.a().a(734);
    QVipHippyConfig localQVipHippyConfig1 = localQVipHippyConfig2;
    if (localQVipHippyConfig2 == null) {
      localQVipHippyConfig1 = new QVipHippyConfig(new LinkedTreeMap());
    }
    return localQVipHippyConfig1;
  }
  
  @NonNull
  public QVipHippyConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    try
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
      QLog.d("QVipHippyProcessor", 2, paramArrayOfQConfItem);
      if (!TextUtils.isEmpty(paramArrayOfQConfItem))
      {
        Type localType = new QVipHippyProcessor.1(this).getType();
        paramArrayOfQConfItem = new QVipHippyConfig((LinkedTreeMap)new Gson().fromJson(paramArrayOfQConfItem, localType));
        return paramArrayOfQConfItem;
      }
    }
    catch (Exception paramArrayOfQConfItem)
    {
      QLog.e("QVipHippyProcessor", 1, paramArrayOfQConfItem, new Object[0]);
    }
    return new QVipHippyConfig(new LinkedTreeMap());
  }
  
  @NonNull
  public QVipHippyConfig b()
  {
    return new QVipHippyConfig(new LinkedTreeMap());
  }
  
  @NonNull
  public QVipHippyConfig c()
  {
    return new QVipHippyConfig(new LinkedTreeMap());
  }
  
  public Class<QVipHippyConfig> clazz()
  {
    return QVipHippyConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public int type()
  {
    return 734;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.QVipHippyProcessor
 * JD-Core Version:    0.7.0.1
 */