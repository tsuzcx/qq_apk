package com.tencent.mobileqq.extendfriend.limitchat;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.qphone.base.util.QLog;

public class LimitChatOnPlusConfProcessor
  extends IQConfigProcessor<limitChatOnPlusConfBean>
{
  public static limitChatOnPlusConfBean a()
  {
    return (limitChatOnPlusConfBean)QConfigManager.a().a(532);
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
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatOnPlusConfProcessor", 2, "onParsed " + paramArrayOfQConfItem.length);
      }
      return limitChatOnPlusConfBean.a(paramArrayOfQConfItem[0]);
    }
    return null;
  }
  
  public void a(limitChatOnPlusConfBean paramlimitChatOnPlusConfBean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onUpdate ");
      if (paramlimitChatOnPlusConfBean == null) {
        break label73;
      }
    }
    label73:
    for (paramlimitChatOnPlusConfBean = paramlimitChatOnPlusConfBean.toString();; paramlimitChatOnPlusConfBean = " empty")
    {
      QLog.d("LimitChatOnPlusConfProcessor", 2, paramlimitChatOnPlusConfBean);
      paramlimitChatOnPlusConfBean = BaseApplicationImpl.getApplication().getRuntime();
      if ((paramlimitChatOnPlusConfBean instanceof QQAppInterface)) {
        ((ExtendFriendManager)((QQAppInterface)paramlimitChatOnPlusConfBean).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).d();
      }
      return;
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
    if (QLog.isColorLevel()) {
      QLog.e("LimitChatOnPlusConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 532;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.LimitChatOnPlusConfProcessor
 * JD-Core Version:    0.7.0.1
 */