package com.tencent.mobileqq.vas.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.handler.api.IClubContentUpdateHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class QVipResourceProcessor
  extends BaseQVipConfigProcessor<QVipResourceConfig>
{
  @NonNull
  public QVipResourceConfig a()
  {
    ((IClubContentUpdateHandler)QRoute.api(IClubContentUpdateHandler.class)).checkJsonVersion(MobileQQ.context);
    return new QVipResourceConfig();
  }
  
  @NonNull
  public QVipResourceConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    ((IClubContentUpdateHandler)QRoute.api(IClubContentUpdateHandler.class)).saveQVIPResConfigContent(paramArrayOfQConfItem[0].b);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("receiveAllConfigs|type: 26,content: ");
      localStringBuilder.append(paramArrayOfQConfItem[0]);
      QLog.d("QVipResourceProcessor", 2, localStringBuilder.toString());
    }
    return new QVipResourceConfig();
  }
  
  @NonNull
  public QVipResourceConfig b()
  {
    return new QVipResourceConfig();
  }
  
  public Class<QVipResourceConfig> clazz()
  {
    return QVipResourceConfig.class;
  }
  
  public boolean isNeedCompressed()
  {
    return false;
  }
  
  public int type()
  {
    return 26;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.config.business.qvip.QVipResourceProcessor
 * JD-Core Version:    0.7.0.1
 */