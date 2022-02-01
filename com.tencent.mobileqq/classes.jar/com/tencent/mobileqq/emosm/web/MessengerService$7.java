package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MessengerService$7
  extends ProfileCardObserver
{
  MessengerService$7(MessengerService paramMessengerService) {}
  
  public void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    long l2 = 0L;
    if (QLog.isColorLevel()) {
      QLog.d("MessengerService.onCardDownload", 2, "received onCardDownload");
    }
    Object localObject;
    long l1;
    int i;
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Card)))
    {
      paramObject = (Card)paramObject;
      localObject = (QQAppInterface)MessengerService.h(this.a);
      if ((localObject != null) && (Utils.a(((QQAppInterface)localObject).getCurrentAccountUin(), paramObject.uin))) {
        if ((paramObject.templateRet == 0) || (paramObject.templateRet == 101107) || (paramObject.templateRet == 101108))
        {
          l1 = paramObject.lCurrentBgId;
          l2 = paramObject.lCurrentStyleId;
          if (ProfileCardTemplate.a(l2)) {
            l1 = paramObject.cardId;
          }
          i = 0;
        }
      }
    }
    for (;;)
    {
      paramObject = new Bundle();
      paramObject.putLong("currentId", l1);
      paramObject.putLong("styleId", l2);
      paramObject.putInt("result", i);
      if ((this.a.a != null) && (this.a.a.size() > 0))
      {
        localObject = (Bundle)this.a.a.remove(0);
        ((Bundle)localObject).putBundle("response", paramObject);
        this.a.a((Bundle)localObject);
      }
      return;
      i = -1;
      l1 = 0L;
      continue;
      i = -1;
      l1 = 0L;
      continue;
      QLog.e("Q.emoji.web.MessengerService", 1, "onCardDownload fail isSuccess = " + paramBoolean + "data = " + paramObject);
      i = -1;
      l1 = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.7
 * JD-Core Version:    0.7.0.1
 */