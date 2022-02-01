package com.tencent.mobileqq.config.business;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class FlashChatConfProcessor
  extends IQConfigProcessor<FlashChatConfBean>
{
  @NonNull
  public FlashChatConfBean a(int paramInt)
  {
    return new FlashChatConfBean();
  }
  
  @Nullable
  public FlashChatConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0) && (paramArrayOfQConfItem[0] != null))
    {
      FlashChatConfBean localFlashChatConfBean = FlashChatConfBean.a(paramArrayOfQConfItem[0].a);
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      paramArrayOfQConfItem = localFlashChatConfBean;
      if ((localAppRuntime instanceof QQAppInterface))
      {
        ((FlashChatManager)((QQAppInterface)localAppRuntime).getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).b(localFlashChatConfBean.a);
        return localFlashChatConfBean;
      }
    }
    else
    {
      paramArrayOfQConfItem = null;
    }
    return paramArrayOfQConfItem;
  }
  
  public void a(FlashChatConfBean paramFlashChatConfBean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdate ");
      localStringBuilder.append(paramFlashChatConfBean.toString());
      QLog.d("FlashChatConfProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public Class<FlashChatConfBean> clazz()
  {
    return FlashChatConfBean.class;
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
    return 168;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.FlashChatConfProcessor
 * JD-Core Version:    0.7.0.1
 */