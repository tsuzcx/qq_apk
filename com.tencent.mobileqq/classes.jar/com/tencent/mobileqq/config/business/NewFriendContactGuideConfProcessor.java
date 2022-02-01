package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.qphone.base.util.QLog;

public class NewFriendContactGuideConfProcessor
  extends IQConfigProcessor<NewFriendContactGuideConfBean>
{
  @NonNull
  public static NewFriendContactGuideConfBean a()
  {
    NewFriendContactGuideConfBean localNewFriendContactGuideConfBean2 = (NewFriendContactGuideConfBean)QConfigManager.a().a(458);
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "loadConfig bean: " + localNewFriendContactGuideConfBean2);
    }
    NewFriendContactGuideConfBean localNewFriendContactGuideConfBean1 = localNewFriendContactGuideConfBean2;
    if (localNewFriendContactGuideConfBean2 == null) {
      localNewFriendContactGuideConfBean1 = new NewFriendContactGuideConfBean();
    }
    return localNewFriendContactGuideConfBean1;
  }
  
  @NonNull
  public NewFriendContactGuideConfBean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "migrateOldOrDefaultContent " + paramInt);
    }
    return new NewFriendContactGuideConfBean();
  }
  
  @Nullable
  public NewFriendContactGuideConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    return NewFriendContactGuideConfBean.a(paramArrayOfQConfItem);
  }
  
  public void a(NewFriendContactGuideConfBean paramNewFriendContactGuideConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate " + paramNewFriendContactGuideConfBean.toString());
    }
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      if (((QQAppInterface)localObject).isCreateManager(QQManagerFactory.NEW_FRIEND_MANAGER))
      {
        ((NewFriendManager)((QQAppInterface)localObject).getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).a = paramNewFriendContactGuideConfBean;
        if (QLog.isColorLevel()) {
          QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate bean");
        }
      }
    }
  }
  
  public Class<NewFriendContactGuideConfBean> clazz()
  {
    return NewFriendContactGuideConfBean.class;
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
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onReqFailed " + paramInt);
    }
  }
  
  public int type()
  {
    return 458;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.NewFriendContactGuideConfProcessor
 * JD-Core Version:    0.7.0.1
 */