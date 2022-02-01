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
    int j = 0;
    int i = -1;
    String str2 = "";
    String str1 = "";
    if ((paramBoolean) && (paramObject != null)) {
      if ((paramObject instanceof Card)) {
        i = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.emoji.web.MessengerService", 2, "onSetCardTemplateReturn...resultCode=" + i);
      }
      if (this.a.a != null)
      {
        paramObject = new Bundle();
        this.a.a.putString("cmd", "card_setSummaryCard");
        paramObject.putInt("result", i);
        paramObject.putString("message", str2);
        if (TextUtils.isEmpty(str1)) {
          paramObject.putString("aid", str1);
        }
        paramObject.putInt("payType", j);
        this.a.a.putBundle("response", paramObject);
        this.a.a(this.a.a);
        this.a.a = null;
      }
      return;
      if ((paramObject instanceof Pair))
      {
        paramObject = (Pair)paramObject;
        i = ((Integer)paramObject.first).intValue();
        str2 = ((SSummaryCardRsp)paramObject.second).emsg;
        j = ((SSummaryCardRsp)paramObject.second).payType;
        str1 = ((SSummaryCardRsp)paramObject.second).aid;
        continue;
        QLog.e("Q.emoji.web.MessengerService", 1, "onSetCardTemplateReturn fail isSuccess = " + paramBoolean + "obj = " + paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.6
 * JD-Core Version:    0.7.0.1
 */