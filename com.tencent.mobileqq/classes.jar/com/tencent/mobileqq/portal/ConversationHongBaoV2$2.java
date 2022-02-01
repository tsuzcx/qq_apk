package com.tencent.mobileqq.portal;

import android.os.Handler;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager;
import com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalTaskCallback;
import com.tencent.mobileqq.activity.springfestival.entry.model.BaseActivityData;
import com.tencent.mobileqq.activity.springfestival.entry.model.PendantData;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HongBaoListView;
import com.tencent.widget.HongBaoListViewListener;
import mqq.app.AppRuntime;

class ConversationHongBaoV2$2
  implements HongBaoListViewListener
{
  private int b = 0;
  
  ConversationHongBaoV2$2(ConversationHongBaoV2 paramConversationHongBaoV2) {}
  
  public void a()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tryCountdown mState = ");
      ((StringBuilder)localObject).append(this.a.e);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.e == 3)
    {
      this.a.b(-1L);
      this.a.v();
      ConversationHongBaoV2.b(this.a);
      localObject = this.a;
      ((ConversationHongBaoV2)localObject).r += 1;
      if (this.a.r == 1) {
        this.a.s = System.currentTimeMillis();
      }
      if (this.a.r > ConversationHongBaoV2.c(this.a))
      {
        localObject = this.a;
        ConversationHongBaoV2.a((ConversationHongBaoV2)localObject, ((ConversationHongBaoV2)localObject).r);
      }
    }
    if (this.a.m) {
      b(false);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.b != 0) && (paramInt2 == 0)) {
      a(false);
    }
    this.b = paramInt2;
    int i = -paramInt2;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" [dddd] onOverScroll scrollX = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(",scrollY = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(",nScrollY = ");
      localStringBuilder.append(i);
      localStringBuilder.append(",mCountDownRedBannerHeight = ");
      localStringBuilder.append(this.a.p);
      localStringBuilder.append(",mResume = ");
      localStringBuilder.append(this.a.l);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    if (!this.a.l) {
      return;
    }
    paramInt1 = this.a.e;
    if (paramInt1 != 3)
    {
      if (paramInt1 != 4)
      {
        if ((paramInt1 == 5) && (i <= 0))
        {
          if (this.a.z) {
            this.a.c.s();
          }
          this.a.a.a();
        }
      }
      else if (i <= this.a.p)
      {
        ConversationHongBaoV2.d(this.a);
        ConversationHongBaoV2.a(this.a).setAlpha(255);
        ConversationHongBaoV2.a(this.a).setVisibility(0);
        this.a.a.a();
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, " [dddd] onOverScroll nScrollY <= mCountDownRedBannerHeight, mProgressViewRed  set to visible, alpha to 255");
        }
        FrameHelperActivity.b(true);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("2021_UI_ConversationHongBaoV2", 2, " [dddd] onOverScroll nScrollY > mCountDownRedBannerHeight, mProgressViewRed  goto set invisible");
        }
        FrameHelperActivity.b(false);
        paramInt1 = this.a.p * 2;
        if (i <= paramInt1)
        {
          paramInt1 = (int)((paramInt1 + paramInt2) * 1.0F / this.a.p * 255.0F);
          if (QLog.isColorLevel()) {
            QLog.d("2021_UI_ConversationHongBaoV2", 2, " [dddd] onOverScroll 2*mCountDownRedBannerHeight >= nScrollY > mCountDownRedBannerHeight, mProgressViewRed  goto set invisible");
          }
          ConversationHongBaoV2.a(this.a).setAlpha(paramInt1);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("2021_UI_ConversationHongBaoV2", 2, " [dddd] onOverScroll nScrollY > mCountDownRedBannerHeight, mProgressViewRed  alpha to 0 (missing)");
          }
          ConversationHongBaoV2.a(this.a).setAlpha(0);
        }
        this.a.a.a(true);
      }
    }
    else if (i <= 0) {
      this.a.a.a();
    } else {
      this.a.a.a(true);
    }
    if ((this.a.c.E) && (this.a.e != 4))
    {
      this.a.c.y = true;
      return;
    }
    paramInt1 = this.a.e;
    if (paramInt1 != 2)
    {
      if (paramInt1 != 5) {
        return;
      }
      this.a.c.y = this.a.z;
      return;
    }
    this.a.c.y = true;
  }
  
  public void a(HongBaoListView paramHongBaoListView)
  {
    if (QLog.isColorLevel())
    {
      paramHongBaoListView = new StringBuilder();
      paramHongBaoListView.append("onTouchDown, ");
      paramHongBaoListView.append(this.a.e);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, paramHongBaoListView.toString());
    }
  }
  
  public void a(HongBaoListView paramHongBaoListView, boolean paramBoolean)
  {
    this.a.g.removeCallbacks(this.a.C);
    try
    {
      int i = -paramHongBaoListView.getScrollY();
      if ((paramBoolean) && ((this.a.e == 2) || (this.a.e == 4)) && (i > ViewUtils.dpToPx(1.0F)))
      {
        ConversationHongBaoV2.d(this.a);
        return;
      }
    }
    catch (Throwable paramHongBaoListView)
    {
      QLog.e("2021_UI_ConversationHongBaoV2", 1, "onTouchMoving", paramHongBaoListView);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("showTitle direct = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    this.a.b(paramBoolean);
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHongBaoPendantClick mState = ");
      ((StringBuilder)localObject).append(this.a.e);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    ConversationHongBaoV2.d(this.a);
    ConversationHongBaoV2.e(this.a);
    Object localObject = this.a;
    boolean bool;
    if (((ConversationHongBaoV2)localObject).e == 3) {
      bool = true;
    } else {
      bool = false;
    }
    ((ConversationHongBaoV2)localObject).f(bool);
  }
  
  public void b(HongBaoListView paramHongBaoListView)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTouchRelease, mState = ");
      localStringBuilder.append(this.a.e);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    int i = paramHongBaoListView.getScrollY();
    paramHongBaoListView = this.a;
    paramHongBaoListView.i = 0;
    i = -i;
    if (i >= paramHongBaoListView.c.C / 2)
    {
      if ((this.a.e == 2) && (System.currentTimeMillis() - this.a.u > 500L))
      {
        this.a.u = System.currentTimeMillis();
        ConversationHongBaoV2.j(this.a);
      }
      if (this.a.e == 5) {
        this.a.i = 1;
      }
    }
    if (this.a.e != 4)
    {
      if ((i < this.a.c.C / 2) && (i > 0))
      {
        if (this.a.e == 5) {
          this.a.i = 2;
        }
        this.a.g.removeCallbacks(this.a.C);
        this.a.c.setSpringbackOffset(0);
        this.a.c.springBackTo(this.a.c.w);
      }
    }
    else if ((i < this.a.c.C / 2) && (i > 0))
    {
      this.a.g.removeCallbacks(this.a.C);
      this.a.c.setSpringbackOffset(-this.a.p);
      this.a.c.springBackTo(this.a.c.w);
    }
    if ((i < this.a.c.C / 2) && (!this.a.c.E)) {
      a(false);
    }
    this.a.g.removeCallbacks(this.a.C);
    this.a.g.postDelayed(this.a.C, 2000L);
    if (QLog.isColorLevel())
    {
      paramHongBaoListView = new StringBuilder();
      paramHongBaoListView.append("onTouchRelease mState = ");
      paramHongBaoListView.append(this.a.e);
      paramHongBaoListView.append(",pullState = ");
      paramHongBaoListView.append(this.a.i);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, paramHongBaoListView.toString());
    }
    if (this.a.e == 5)
    {
      this.a.g.removeMessages(1005);
      if (this.a.i != 0)
      {
        paramHongBaoListView = this.a.g;
        long l;
        if (this.a.i == 2) {
          l = 200L;
        } else {
          l = 2500L;
        }
        paramHongBaoListView.sendEmptyMessageDelayed(1005, l);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideTitle direct = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, localStringBuilder.toString());
    }
    this.a.c(paramBoolean);
  }
  
  public void c()
  {
    BaseActivityData localBaseActivityData = this.a.q.ab.c();
    Object localObject = localBaseActivityData.pendantData;
    boolean bool = false;
    int i;
    if (localObject != null) {
      i = localBaseActivityData.pendantData.closeType;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHongBaoPendantCloseIconClick mSate = ");
      ((StringBuilder)localObject).append(this.a.e);
      ((StringBuilder)localObject).append(",closeType = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("2021_UI_ConversationHongBaoV2", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.a;
    if (((ConversationHongBaoV2)localObject).e == 3) {
      bool = true;
    }
    ((ConversationHongBaoV2)localObject).g(bool);
    ConversationHongBaoV2.f(this.a);
    this.a.c.r();
    if ((i != 0) && (i != 1)) {
      if (i != 2)
      {
        if (i == 3)
        {
          this.a.e();
          ((SpringFestivalEntryManager)this.a.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(localBaseActivityData);
          this.a.q.ab.g(localBaseActivityData);
        }
      }
      else
      {
        this.a.e();
        this.a.q.ab.g(localBaseActivityData);
      }
    }
    ConversationHongBaoV2.g(this.a);
  }
  
  public void d()
  {
    if (this.a.e == 4)
    {
      ConversationHongBaoV2.b(this.a);
      Object localObject = this.a;
      int i = ((ConversationHongBaoV2)localObject).r;
      boolean bool = true;
      ((ConversationHongBaoV2)localObject).r = (i + 1);
      long l1 = System.currentTimeMillis();
      if (this.a.r == 1)
      {
        this.a.a.a(this.a.r, ConversationHongBaoV2.h(this.a), true);
        this.a.s = l1;
      }
      else
      {
        long l2 = l1 - this.a.s;
        localObject = this.a;
        ((ConversationHongBaoV2)localObject).s = l1;
        if (l2 > 600L)
        {
          ((ConversationHongBaoV2)localObject).r = 1;
          ((ConversationHongBaoV2)localObject).a.setHBSpeed(1);
        }
        else if (l2 > 400L)
        {
          ((ConversationHongBaoV2)localObject).a.setHBSpeed(2);
        }
        else
        {
          ((ConversationHongBaoV2)localObject).a.setHBSpeed(3);
        }
        localObject = this.a.a;
        i = this.a.r;
        String str = ConversationHongBaoV2.h(this.a);
        if (this.a.s - this.a.d <= 500L) {
          bool = false;
        }
        ((FormalView)localObject).a(i, str, bool);
        ((SpringFestivalEntryManager)this.a.q.aF.getManager(QQManagerFactory.SPRING_FESTIVAL_ENTRY_MANAGER)).a(0);
      }
      if (this.a.r > ConversationHongBaoV2.c(this.a))
      {
        localObject = this.a;
        ConversationHongBaoV2.a((ConversationHongBaoV2)localObject, ((ConversationHongBaoV2)localObject).r);
      }
      if (ConversationHongBaoV2.i(this.a))
      {
        this.a.q.ab.a(this.a.r);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("2021_UI_ConversationHongBaoV2", 2, "tryGrab not allowGrabHongbao");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ConversationHongBaoV2.2
 * JD-Core Version:    0.7.0.1
 */