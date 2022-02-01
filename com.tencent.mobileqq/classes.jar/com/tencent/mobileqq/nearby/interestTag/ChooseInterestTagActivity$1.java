package com.tencent.mobileqq.nearby.interestTag;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import axqt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.List;

class ChooseInterestTagActivity$1
  implements Runnable
{
  ChooseInterestTagActivity$1(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void run()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Object localObject2 = this.this$0.getSharedPreferences("dating_pref" + this.this$0.app.getCurrentAccountUin(), 0);
    int j;
    int k;
    int i;
    if ((l - ((SharedPreferences)localObject2).getLong("list_last_update_time_" + ChooseInterestTagActivity.a(this.this$0), -1L) >= 3600000L) || (ChooseInterestTagActivity.a(this.this$0)))
    {
      if (NetworkUtil.isNetSupport(this.this$0))
      {
        localObject1 = ChooseInterestTagActivity.a(this.this$0);
        j = ChooseInterestTagActivity.a(this.this$0);
        k = ChooseInterestTagActivity.b(this.this$0);
        if (ChooseInterestTagActivity.a(this.this$0)) {}
        for (i = 1;; i = 0)
        {
          ((axqt)localObject1).a("", j, k, 30, 0, i);
          return;
        }
      }
      ChooseInterestTagActivity.a(this.this$0).sendEmptyMessage(4099);
      return;
    }
    EntityManager localEntityManager = this.this$0.app.getEntityManagerFactory().createEntityManager();
    Object localObject1 = localEntityManager.query(InterestTagInfo.class, true, "tagType = ?", new String[] { String.valueOf(ChooseInterestTagActivity.a(this.this$0)) }, null, null, null, String.valueOf(30));
    localEntityManager.close();
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      if (NetworkUtil.isNetSupport(this.this$0))
      {
        localObject1 = ChooseInterestTagActivity.a(this.this$0);
        j = ChooseInterestTagActivity.a(this.this$0);
        k = ChooseInterestTagActivity.b(this.this$0);
        if (ChooseInterestTagActivity.a(this.this$0)) {}
        for (i = 1;; i = 0)
        {
          ((axqt)localObject1).a("", j, k, 30, 0, i);
          return;
        }
      }
      ChooseInterestTagActivity.a(this.this$0).sendEmptyMessage(4099);
      return;
    }
    ChooseInterestTagActivity.a(this.this$0, ((SharedPreferences)localObject2).getInt("list_fetch_pos_" + ChooseInterestTagActivity.a(this.this$0), ((List)localObject1).size()));
    localObject2 = Message.obtain();
    ((Message)localObject2).what = 4098;
    ((Message)localObject2).obj = localObject1;
    ChooseInterestTagActivity.a(this.this$0).sendMessage((Message)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity.1
 * JD-Core Version:    0.7.0.1
 */