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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfQConfItem != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfQConfItem.length > 0)
      {
        localObject1 = localObject2;
        if (paramArrayOfQConfItem[0] != null)
        {
          localObject1 = FlashChatConfBean.a(paramArrayOfQConfItem[0].a);
          paramArrayOfQConfItem = BaseApplicationImpl.getApplication().getRuntime();
          if ((paramArrayOfQConfItem instanceof QQAppInterface)) {
            ((FlashChatManager)((QQAppInterface)paramArrayOfQConfItem).getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).b(((FlashChatConfBean)localObject1).a);
          }
        }
      }
    }
    return localObject1;
  }
  
  public void a(FlashChatConfBean paramFlashChatConfBean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChatConfProcessor", 2, "onUpdate " + paramFlashChatConfBean.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.FlashChatConfProcessor
 * JD-Core Version:    0.7.0.1
 */