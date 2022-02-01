package com.tencent.mobileqq.emosm.web;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.profilecard.template.ProfileTemplateApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MessengerService$7
  extends ProfileCardObserver
{
  MessengerService$7(MessengerService paramMessengerService) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MessengerService.onCardDownload", 2, "received onCardDownload");
    }
    long l1 = 0L;
    int i = -1;
    Object localObject;
    if ((paramBoolean) && (paramObject != null) && ((paramObject instanceof Card)))
    {
      paramObject = (Card)paramObject;
      localObject = (QQAppInterface)MessengerService.j(this.a);
      if ((localObject != null) && (Utils.a(((QQAppInterface)localObject).getCurrentAccountUin(), paramObject.uin)) && ((paramObject.templateRet == 0) || (paramObject.templateRet == 101107) || (paramObject.templateRet == 101108)))
      {
        l1 = paramObject.lCurrentBgId;
        l2 = paramObject.lCurrentStyleId;
        if (ProfileTemplateApi.isDiyTemplateStyleID(l2)) {
          l1 = paramObject.cardId;
        }
        i = 0;
        break label180;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCardDownload fail isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("data = ");
      ((StringBuilder)localObject).append(paramObject);
      QLog.e("Q.emoji.web.MessengerService", 1, ((StringBuilder)localObject).toString());
    }
    long l2 = 0L;
    label180:
    paramObject = new Bundle();
    paramObject.putLong("currentId", l1);
    paramObject.putLong("styleId", l2);
    paramObject.putInt("result", i);
    if ((this.a.k != null) && (this.a.k.size() > 0))
    {
      localObject = (Bundle)this.a.k.remove(0);
      ((Bundle)localObject).putBundle("response", paramObject);
      this.a.a((Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.7
 * JD-Core Version:    0.7.0.1
 */