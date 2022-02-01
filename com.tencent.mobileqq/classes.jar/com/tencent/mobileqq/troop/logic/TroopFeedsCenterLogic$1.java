package com.tencent.mobileqq.troop.logic;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTopADInfo;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.utils.TroopAioADManager;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

class TroopFeedsCenterLogic$1
  implements Animation.AnimationListener
{
  TroopFeedsCenterLogic$1(TroopFeedsCenterLogic paramTroopFeedsCenterLogic) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    Object localObject1 = this.a;
    ((TroopFeedsCenterLogic)localObject1).w = false;
    ((TroopFeedsCenterLogic)localObject1).a.getHandler(ChatActivity.class).obtainMessage(68).sendToTarget();
    Object localObject2 = this.a.k;
    localObject1 = Integer.valueOf(123322);
    if (localObject2 == paramAnimation)
    {
      this.a.h.setVisibility(4);
      if (this.a.h != null)
      {
        paramAnimation = this.a.g;
        TroopFeedsCenterLogic.a(this.a);
        this.a.notifyObservers(localObject1);
        this.a.h.clearAnimation();
      }
      if (this.a.g != null) {
        this.a.g.k = false;
      }
      if (this.a.o)
      {
        this.a.d(true);
        this.a.o = false;
      }
      if (this.a.r)
      {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          QQToast.makeText((Context)this.a.b.get(), 1, ((BaseActivity)this.a.b.get()).getString(2131895385), 1).show(((BaseActivity)this.a.b.get()).getResources().getDimensionPixelSize(2131299920) - (int)DisplayUtils.a((Context)this.a.b.get(), 5.0F));
          return;
        }
        localObject1 = (TroopAioADManager)this.a.a.getManager(QQManagerFactory.TROOP_AIO_AD_MANAGER);
        localObject2 = this.a.l.b;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          TroopAioTopADInfo localTroopAioTopADInfo = ((TroopAioADManager)localObject1).a(this.a.l.b);
          if (localTroopAioTopADInfo != null)
          {
            if (TextUtils.isEmpty(localTroopAioTopADInfo.jumpUrl)) {
              paramAnimation = localTroopAioTopADInfo.backgroundUrl;
            } else {
              paramAnimation = localTroopAioTopADInfo.jumpUrl;
            }
            Object localObject3 = JumpParser.a(this.a.a, (Context)this.a.b.get(), paramAnimation);
            if (localObject3 != null)
            {
              ((JumpAction)localObject3).a();
            }
            else if (paramAnimation.startsWith("http"))
            {
              localObject3 = new Intent((Context)this.a.b.get(), QQBrowserActivity.class);
              ((Intent)localObject3).putExtra("url", URLUtil.guessUrl(paramAnimation));
              ((BaseActivity)this.a.b.get()).startActivity((Intent)localObject3);
            }
            paramAnimation = this.a.a;
            localObject3 = this.a.l.b;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(localTroopAioTopADInfo.adId);
            localStringBuilder.append("");
            ReportController.b(paramAnimation, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_Promote", 0, 0, (String)localObject3, localStringBuilder.toString(), "", "");
          }
          ((TroopAioADManager)localObject1).b((String)localObject2);
          this.a.q = false;
        }
      }
    }
    else if (this.a.j == paramAnimation)
    {
      if ((this.a.h != null) && (this.a.g != null))
      {
        this.a.h.setVisibility(0);
        this.a.h.clearAnimation();
        TroopFeedsCenterLogic.b(this.a);
        this.a.notifyObservers(localObject1);
        if ((this.a.p) && (this.a.h != null) && ((this.a.h instanceof TroopAioFeedsCenterView))) {
          if (this.a.q)
          {
            this.a.m.c();
          }
          else if (this.a.s)
          {
            ((TroopAioFeedsCenterView)this.a.h).a();
            this.a.s = false;
          }
          else
          {
            paramAnimation = this.a;
            paramAnimation.p = false;
            ((TroopAioFeedsCenterView)paramAnimation.h).a(true);
          }
        }
      }
      if (this.a.h != null) {
        this.a.h.requestFocus();
      }
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.w = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic.1
 * JD-Core Version:    0.7.0.1
 */