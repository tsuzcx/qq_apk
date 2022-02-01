package com.tencent.mobileqq.troop.recommend;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class TDCRecomTroopConfigProcessor
  extends IQConfigProcessor<TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean>
{
  public static TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean a()
  {
    TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean localTDCRecomTroopConfigBean = (TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean)QConfigManager.a().a(547);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getConfigBean configBean = ");
      localStringBuilder.append(localTDCRecomTroopConfigBean);
      QLog.d("TDCRecomTroopConfigProcessor", 2, localStringBuilder.toString());
    }
    return localTDCRecomTroopConfigBean;
  }
  
  @NonNull
  public TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean a(int paramInt)
  {
    return new TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean();
  }
  
  @Nullable
  public TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length != 0))
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0].a;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" onParsed,configID:547, content:");
        localStringBuilder.append(paramArrayOfQConfItem);
        QLog.d("TDCRecomTroopConfigProcessor", 2, localStringBuilder.toString());
      }
      return TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean.a(paramArrayOfQConfItem);
    }
    return null;
  }
  
  public void a(TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean paramTDCRecomTroopConfigBean) {}
  
  public Class<TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean> clazz()
  {
    return TDCRecomTroopConfigProcessor.TDCRecomTroopConfigBean.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 547;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.recommend.TDCRecomTroopConfigProcessor
 * JD-Core Version:    0.7.0.1
 */