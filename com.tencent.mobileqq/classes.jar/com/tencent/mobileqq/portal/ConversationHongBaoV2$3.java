package com.tencent.mobileqq.portal;

import android.os.CountDownTimer;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback;
import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;
import com.tencent.mobileqq.activity.springfestival.entry.model.CommonData;
import com.tencent.mobileqq.activity.springfestival.entry.model.EntryConfigBean;
import com.tencent.mobileqq.activity.springfestival.entry.model.UserData;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;

class ConversationHongBaoV2$3
  extends CountDownTimer
{
  ConversationHongBaoV2$3(ConversationHongBaoV2 paramConversationHongBaoV2, long paramLong1, long paramLong2, long paramLong3)
  {
    super(paramLong1, paramLong2);
  }
  
  public void onFinish()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("CountDownTimer onFinish pullState = ");
    ((StringBuilder)localObject1).append(this.b.i);
    ((StringBuilder)localObject1).append(",totalGrabCountForShare = ");
    ((StringBuilder)localObject1).append(ConversationHongBaoV2.l(this.b));
    ((StringBuilder)localObject1).append(",maxComboCountForShare = ");
    ((StringBuilder)localObject1).append(ConversationHongBaoV2.c(this.b));
    ((StringBuilder)localObject1).append(",mResume");
    ((StringBuilder)localObject1).append(this.b.l);
    QLog.d("2021_UI_ConversationHongBaoV2", 1, ((StringBuilder)localObject1).toString());
    Object localObject2 = (SpringFestivalEntryManager)this.b.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER);
    ((SpringFestivalEntryManager)localObject2).n();
    ConversationHongBaoV2.c(this.b, 0L);
    this.b.e();
    Object localObject3 = this.b.q.ab.c();
    this.b.q.ab.g((BaseActivityData)localObject3);
    localObject1 = ((SpringFestivalEntryManager)localObject2).d();
    if ((localObject1 != null) && (((EntryConfigBean)localObject1).commonData != null)) {
      localObject1 = ((EntryConfigBean)localObject1).commonData.getShareWordings(ConversationHongBaoV2.l(this.b));
    } else {
      localObject1 = null;
    }
    int i = ((SpringFestivalEntryManager)localObject2).a().getShareForbidden();
    localObject2 = ((BaseActivityData)localObject3).getId();
    if (this.b.l)
    {
      localObject3 = this.b;
      new ConversationHongBaoV2.ShowSharePageTask((ConversationHongBaoV2)localObject3, (List)localObject1, ConversationHongBaoV2.m((ConversationHongBaoV2)localObject3), (String)localObject2, ConversationHongBaoV2.l(this.b), ConversationHongBaoV2.c(this.b), ConversationHongBaoV2.n(this.b), i).a();
    }
    else
    {
      localObject3 = this.b;
      ConversationHongBaoV2.a((ConversationHongBaoV2)localObject3, new ConversationHongBaoV2.ShowSharePageTask((ConversationHongBaoV2)localObject3, (List)localObject1, ConversationHongBaoV2.m((ConversationHongBaoV2)localObject3), (String)localObject2, ConversationHongBaoV2.l(this.b), ConversationHongBaoV2.c(this.b), ConversationHongBaoV2.n(this.b), i));
    }
    this.b.w();
    ConversationHongBaoV2.o(this.b);
  }
  
  public void onTick(long paramLong)
  {
    long l = System.currentTimeMillis();
    ConversationHongBaoV2.a(this.b, paramLong);
    if (l - ConversationHongBaoV2.k(this.b) > 1000L)
    {
      ConversationHongBaoV2.b(this.b, l);
      ConversationHongBaoV2.c(this.b, paramLong);
    }
    if (ConversationHongBaoV2.a(this.b).getVisibility() == 0)
    {
      this.b.a(paramLong);
      ConversationHongBaoV2.a(this.b).a(paramLong, this.a, this.b.w);
    }
    if (this.b.a.getVisibility() == 0)
    {
      this.b.a(paramLong);
      this.b.a.a(paramLong, this.a, this.b.x);
    }
    paramLong = System.currentTimeMillis() - this.b.s;
    if (paramLong > 2000L)
    {
      this.b.a.setHBSpeed(1);
      return;
    }
    if (paramLong > 1000L) {
      this.b.a.setHBSpeed(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.3
 * JD-Core Version:    0.7.0.1
 */