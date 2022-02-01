package com.tencent.mobileqq.qqexpand.manager.config;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.qphone.base.util.QLog;

public class LimitChatOnPlusConfProcessor
  extends IQConfigProcessor<limitChatOnPlusConfBean>
{
  public static limitChatOnPlusConfBean a()
  {
    return (limitChatOnPlusConfBean)QConfigManager.b().b(532);
  }
  
  @NonNull
  public limitChatOnPlusConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "migrateOldOrDefaultContent ");
    }
    return new limitChatOnPlusConfBean();
  }
  
  @Nullable
  public limitChatOnPlusConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed start");
    }
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onParsed ");
        localStringBuilder.append(paramArrayOfQConfItem.length);
        QLog.d("LimitChatOnPlusConfProcessor", 2, localStringBuilder.toString());
      }
      return limitChatOnPlusConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(limitChatOnPlusConfBean paramlimitChatOnPlusConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      if (paramlimitChatOnPlusConfBean != null) {
        paramlimitChatOnPlusConfBean = paramlimitChatOnPlusConfBean.toString();
      } else {
        paramlimitChatOnPlusConfBean = " empty";
      }
      localStringBuilder.append(paramlimitChatOnPlusConfBean);
      QLog.d("LimitChatOnPlusConfProcessor", 2, localStringBuilder.toString());
    }
    paramlimitChatOnPlusConfBean = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramlimitChatOnPlusConfBean instanceof QQAppInterface)) {
      ((IExpandManager)((QQAppInterface)paramlimitChatOnPlusConfBean).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).M();
    }
  }
  
  public Class<limitChatOnPlusConfBean> clazz()
  {
    return limitChatOnPlusConfBean.class;
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
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.e("LimitChatOnPlusConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 532;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.manager.config.LimitChatOnPlusConfProcessor
 * JD-Core Version:    0.7.0.1
 */