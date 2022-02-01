package com.tencent.mobileqq.profile;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

class VipProfileCardBaseActivity$2$1
  implements Runnable
{
  VipProfileCardBaseActivity$2$1(VipProfileCardBaseActivity.2 param2, Card paramCard, HashMap paramHashMap, String paramString) {}
  
  public void run()
  {
    boolean bool = this.d.a.a((int)this.a.lCurrentStyleId, (int)this.a.lCurrentBgId, this.a.backgroundUrl, (int)this.a.backgroundColor, this.a.templateRet);
    HashMap localHashMap = this.b;
    if (bool) {
      localObject = "0";
    } else {
      localObject = "-102";
    }
    localHashMap.put("param_FailCode", localObject);
    if (bool == true)
    {
      StatisticCollector.getInstance(this.d.a.app.getApp()).collectPerformance(this.c, "profileCardSet", true, 0L, 0L, this.b, "", false);
      localObject = this.d.a.y.obtainMessage(5);
      this.d.a.y.sendMessage((Message)localObject);
      return;
    }
    StatisticCollector.getInstance(this.d.a.app.getApp()).collectPerformance(this.c, "profileCardSet", false, 0L, 0L, this.b, "", false);
    Object localObject = this.d.a.y.obtainMessage(6);
    this.d.a.y.sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.VipProfileCardBaseActivity.2.1
 * JD-Core Version:    0.7.0.1
 */