package com.tencent.mobileqq.emosm.web;

import SummaryCardTaf.SSummaryCardRsp;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class MessengerService$6
  extends CardObserver
{
  MessengerService$6(MessengerService paramMessengerService) {}
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    int i = 0;
    String str = "";
    Object localObject;
    if ((paramBoolean) && (paramObject != null))
    {
      if ((paramObject instanceof Card))
      {
        paramObject = "";
        j = 0;
        break label149;
      }
      if ((paramObject instanceof Pair))
      {
        paramObject = (Pair)paramObject;
        i = ((Integer)paramObject.first).intValue();
        str = ((SSummaryCardRsp)paramObject.second).emsg;
        j = ((SSummaryCardRsp)paramObject.second).payType;
        paramObject = ((SSummaryCardRsp)paramObject.second).aid;
        break label149;
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetCardTemplateReturn fail isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append("obj = ");
      ((StringBuilder)localObject).append(paramObject);
      QLog.e("Q.emoji.web.MessengerService", 1, ((StringBuilder)localObject).toString());
    }
    paramObject = "";
    int j = 0;
    i = -1;
    label149:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSetCardTemplateReturn...resultCode=");
      ((StringBuilder)localObject).append(i);
      QLog.d("Q.emoji.web.MessengerService", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.a != null)
    {
      localObject = new Bundle();
      this.a.a.putString("cmd", "card_setSummaryCard");
      ((Bundle)localObject).putInt("result", i);
      ((Bundle)localObject).putString("message", str);
      if (TextUtils.isEmpty(paramObject)) {
        ((Bundle)localObject).putString("aid", paramObject);
      }
      ((Bundle)localObject).putInt("payType", j);
      this.a.a.putBundle("response", (Bundle)localObject);
      paramObject = this.a;
      paramObject.a(paramObject.a);
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.6
 * JD-Core Version:    0.7.0.1
 */