package com.tencent.mobileqq.profile;

import SummaryCardTaf.SSummaryCardRsp;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class VipProfileCardBaseActivity$2
  extends CardObserver
{
  VipProfileCardBaseActivity$2(VipProfileCardBaseActivity paramVipProfileCardBaseActivity) {}
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("CardObserver onSetCardTemplateReturn isSuccess : ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", obj : ");
      ((StringBuilder)localObject1).append(paramObject);
      QLog.d("ProfileCard.VipProfileCardBaseActivity", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.a.app.getCurrentAccountUin();
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_BackgroundId", String.valueOf(this.a.p));
    localHashMap.put("param_StyleId", String.valueOf(this.a.n));
    this.a.y.removeCallbacks(this.a.A);
    this.a.b();
    if ((paramBoolean) && (paramObject != null))
    {
      if ((paramObject instanceof Card))
      {
        ThreadManager.post(new VipProfileCardBaseActivity.2.1(this, (Card)paramObject, localHashMap, (String)localObject1), 5, null, true);
        return;
      }
      if ((paramObject instanceof Pair))
      {
        paramObject = (Pair)paramObject;
        Object localObject2;
        if (((Integer)paramObject.first).intValue() == 101107)
        {
          localObject2 = this.a;
          ((VipProfileCardBaseActivity)localObject2).c = 1;
          ((VipProfileCardBaseActivity)localObject2).i = 2;
          localObject2 = ((VipProfileCardBaseActivity)localObject2).y.obtainMessage(9);
          this.a.y.sendMessage((Message)localObject2);
        }
        else if (((Integer)paramObject.first).intValue() == 101108)
        {
          localObject2 = this.a;
          ((VipProfileCardBaseActivity)localObject2).c = 2;
          ((VipProfileCardBaseActivity)localObject2).i = 5;
          localObject2 = ((VipProfileCardBaseActivity)localObject2).y.obtainMessage(9);
          this.a.y.sendMessage((Message)localObject2);
        }
        else
        {
          localObject2 = this.a.y.obtainMessage(6);
          if ((((Integer)paramObject.first).intValue() >= 400000) && (((Integer)paramObject.first).intValue() <= 499999)) {
            ((Message)localObject2).obj = ((SSummaryCardRsp)paramObject.second).emsg;
          }
          this.a.y.sendMessage((Message)localObject2);
        }
        localHashMap.put("param_FailCode", String.valueOf(paramObject.first));
        StatisticCollector.getInstance(this.a.app.getApp()).collectPerformance((String)localObject1, "profileCardSet", false, 0L, 0L, localHashMap, "", false);
      }
    }
    else
    {
      if (!paramBoolean) {
        paramObject = "-104";
      } else {
        paramObject = "-105";
      }
      localHashMap.put("param_FailCode", paramObject);
      StatisticCollector.getInstance(this.a.app.getApp()).collectPerformance((String)localObject1, "profileCardSet", false, 0L, 0L, localHashMap, "", false);
      paramObject = this.a.y.obtainMessage(6);
      this.a.y.sendMessage(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardBaseActivity.2
 * JD-Core Version:    0.7.0.1
 */