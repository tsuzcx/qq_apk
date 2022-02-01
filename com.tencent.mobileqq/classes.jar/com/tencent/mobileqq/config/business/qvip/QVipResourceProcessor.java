package com.tencent.mobileqq.config.business.qvip;

import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ClubContentUpdateHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class QVipResourceProcessor
  extends BaseQVipConfigProcessor<QVipResourceConfig>
{
  @NonNull
  public QVipResourceConfig a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ClubContentUpdateHandler localClubContentUpdateHandler = (ClubContentUpdateHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CLUBCONTENTUPDATE_HANDLER);
    if (localClubContentUpdateHandler != null) {
      localClubContentUpdateHandler.a(localQQAppInterface.getApplication().getApplicationContext());
    }
    return new QVipResourceConfig();
  }
  
  @NonNull
  public QVipResourceConfig a(QConfItem[] paramArrayOfQConfItem)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ClubContentUpdateHandler localClubContentUpdateHandler = (ClubContentUpdateHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CLUBCONTENTUPDATE_HANDLER);
    if (localClubContentUpdateHandler != null) {
      localClubContentUpdateHandler.a(localQQAppInterface, paramArrayOfQConfItem[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QVipResourceProcessor", 2, "receiveAllConfigs|type: 26,content: " + paramArrayOfQConfItem[0]);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qvip.QVipResourceProcessor
 * JD-Core Version:    0.7.0.1
 */