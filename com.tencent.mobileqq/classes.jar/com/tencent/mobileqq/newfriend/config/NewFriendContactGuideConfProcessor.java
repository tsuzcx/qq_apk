package com.tencent.mobileqq.newfriend.config;

import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class NewFriendContactGuideConfProcessor
  extends IQConfigProcessor<NewFriendContactGuideConfBean>
{
  public static NewFriendContactGuideConfBean a()
  {
    NewFriendContactGuideConfBean localNewFriendContactGuideConfBean = (NewFriendContactGuideConfBean)QConfigManager.a().a(458);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadConfig bean: ");
      ((StringBuilder)localObject).append(localNewFriendContactGuideConfBean);
      QLog.d("NewFriendContactGuideConfProcessor", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = localNewFriendContactGuideConfBean;
    if (localNewFriendContactGuideConfBean == null) {
      localObject = new NewFriendContactGuideConfBean();
    }
    return localObject;
  }
  
  public NewFriendContactGuideConfBean a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("migrateOldOrDefaultContent ");
      localStringBuilder.append(paramInt);
      QLog.d("NewFriendContactGuideConfProcessor", 2, localStringBuilder.toString());
    }
    return new NewFriendContactGuideConfBean();
  }
  
  public NewFriendContactGuideConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    return NewFriendContactGuideConfBean.a(paramArrayOfQConfItem);
  }
  
  public void a(NewFriendContactGuideConfBean paramNewFriendContactGuideConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramNewFriendContactGuideConfBean.toString());
      QLog.d("NewFriendContactGuideConfProcessor", 2, localStringBuilder.toString());
    }
    ((NewFriendServiceImpl)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(INewFriendService.class, "")).mBean = paramNewFriendContactGuideConfBean;
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendContactGuideConfProcessor", 2, "onUpdate bean");
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed ");
      localStringBuilder.append(paramInt);
      QLog.d("NewFriendContactGuideConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 458;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.config.NewFriendContactGuideConfProcessor
 * JD-Core Version:    0.7.0.1
 */