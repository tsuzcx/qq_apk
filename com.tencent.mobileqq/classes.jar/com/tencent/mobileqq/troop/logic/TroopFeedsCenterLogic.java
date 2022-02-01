package com.tencent.mobileqq.troop.logic;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.troopreddot.api.ITroopRedDotHandler;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.widget.TroopAioFeedsCenterView;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class TroopFeedsCenterLogic
  extends Observable
  implements Observer
{
  QQCustomDialog A;
  protected Animation.AnimationListener B = new TroopFeedsCenterLogic.1(this);
  protected QQAppInterface a;
  protected WeakReference<BaseActivity> b;
  protected RelativeLayout c;
  protected RelativeLayout d;
  protected ImageView e;
  protected ImageView f;
  protected TroopAioTips g;
  public View h;
  protected int i;
  protected TranslateAnimation j;
  protected TranslateAnimation k;
  protected SessionInfo l;
  protected TroopFeedsDataManager m;
  protected boolean n = false;
  protected boolean o = false;
  protected boolean p = false;
  protected boolean q = false;
  protected boolean r = false;
  protected boolean s = false;
  protected boolean t = false;
  protected boolean u = false;
  protected String v = "0";
  protected boolean w = false;
  protected boolean x = false;
  protected boolean y = false;
  protected TroopInfoManager z = null;
  
  public TroopFeedsCenterLogic(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, ImageView paramImageView, TroopAioTips paramTroopAioTips, boolean paramBoolean, Observer paramObserver)
  {
    this.a = paramQQAppInterface;
    this.b = new WeakReference(paramBaseActivity);
    this.c = paramRelativeLayout;
    this.f = paramImageView;
    this.l = paramSessionInfo;
    this.g = paramTroopAioTips;
    this.x = paramBoolean;
    this.y = paramQQAppInterface.getHotChatMng(true).b(paramSessionInfo.b);
    this.i = paramBaseActivity.getResources().getDimensionPixelSize(2131299965);
    this.z = ((TroopInfoManager)paramQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER));
    paramBaseActivity = this.z;
    if (paramBaseActivity != null) {}
    try
    {
      this.m = paramBaseActivity.a(Long.valueOf(Long.parseLong(this.l.b)), true);
      this.m.addObserver(this);
    }
    catch (NumberFormatException paramBaseActivity)
    {
      label216:
      break label216;
    }
    if (QLog.isColorLevel())
    {
      paramBaseActivity = new StringBuilder();
      paramBaseActivity.append("NumberFormatException, mSessionInfo.curFriendUin:");
      paramBaseActivity.append(this.l.b);
      QLog.e("TroopFeedsCenterLogic", 2, paramBaseActivity.toString());
    }
    ReportController.b(paramQQAppInterface, "P_CliOper", "BizTechReport", ".troop.notification_center", "TroopFeedsCenterLogic init", "", 0, 0, paramSessionInfo.b, "", "", "");
    if (paramObserver != null) {
      addObserver(paramObserver);
    }
  }
  
  private void e(boolean paramBoolean)
  {
    Object localObject1 = (BaseActivity)this.b.get();
    if (localObject1 == null) {
      return;
    }
    if (paramBoolean)
    {
      if (a()) {
        return;
      }
      Object localObject2;
      if (this.d != null)
      {
        localObject2 = this.e;
        if (localObject2 != null)
        {
          ((ImageView)localObject2).setVisibility(0);
          return;
        }
      }
      this.d = ((RelativeLayout)((BaseActivity)localObject1).findViewById(2131436236));
      if (this.d == null)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("mRightTitleLayout == null,");
          ((StringBuilder)localObject2).append(localObject1.getClass().getName());
          QLog.w("TroopFeedsCenterLogic", 2, ((StringBuilder)localObject2).toString());
        }
        return;
      }
      int i1 = AIOUtils.b(10.0F, ((BaseActivity)localObject1).getResources());
      int i2 = AIOUtils.b(8.0F, ((BaseActivity)localObject1).getResources());
      this.e = new ImageView(((BaseActivity)localObject1).getActivity());
      this.e.setBackgroundResource(2130852588);
      localObject1 = new RelativeLayout.LayoutParams(i1, i1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131436189);
      ((RelativeLayout.LayoutParams)localObject1).addRule(6, 2131436189);
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, i2, 0, 0);
      this.e.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      this.e.setVisibility(0);
      this.d.addView(this.e);
      return;
    }
    if (this.d != null)
    {
      localObject1 = this.e;
      if (localObject1 != null) {
        ((ImageView)localObject1).setVisibility(4);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2)
  {
    this.A = ((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatAnnounceDialog(paramQQAppInterface, paramContext, paramString1, paramString2);
    try
    {
      this.A.show();
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public boolean a()
  {
    View localView = this.h;
    return (localView != null) && (localView.getVisibility() == 0);
  }
  
  public int b()
  {
    View localView = this.h;
    if (localView != null) {
      return localView.getHeight();
    }
    return 0;
  }
  
  public void b(boolean paramBoolean)
  {
    this.r = paramBoolean;
    c();
  }
  
  public void c()
  {
    Object localObject = (BaseActivity)this.b.get();
    if (localObject == null) {
      return;
    }
    TroopAioTips localTroopAioTips = this.g;
    if (localTroopAioTips != null) {
      localTroopAioTips.k = false;
    }
    if (this.k == null)
    {
      localObject = AnimationUtils.loadInterpolator(((BaseActivity)localObject).getActivity(), 17432582);
      this.k = new TranslateAnimation(0.0F, 0.0F, 0.0F, this.i * -1);
      this.k.setDuration(250L);
      this.k.setInterpolator((Interpolator)localObject);
      this.k.setAnimationListener(this.B);
      this.k.setFillAfter(true);
    }
    if (!this.w) {
      this.h.startAnimation(this.k);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject1 = (BaseActivity)this.b.get();
    if (localObject1 == null) {
      return;
    }
    this.t = paramBoolean;
    if ((this.f != null) && (this.n))
    {
      if (this.t) {
        this.q = false;
      }
      this.p = true;
      d(false);
      ((ITroopRedDotHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(this.l.b, 1102858908);
      ChatActivityUtils.a(this.a, this.l.b, Integer.valueOf(0));
      this.v = "1";
    }
    else
    {
      this.v = "0";
    }
    this.n = false;
    Object localObject2 = this.g;
    if (localObject2 != null) {
      ((TroopAioTips)localObject2).k = true;
    }
    if (this.j == null)
    {
      localObject2 = AnimationUtils.loadInterpolator(((BaseActivity)localObject1).getActivity(), 17432582);
      this.j = new TranslateAnimation(0.0F, 0.0F, this.i * -1, 0.0F);
      this.j.setDuration(250L);
      this.j.setInterpolator((Interpolator)localObject2);
      this.j.setAnimationListener(this.B);
      this.j.setFillEnabled(true);
    }
    localObject2 = this.h;
    if (localObject2 == null)
    {
      localObject2 = (TroopGagMgr)this.a.getManager(QQManagerFactory.TROOP_GAG_MANAGER);
      QQAppInterface localQQAppInterface = this.a;
      SessionInfo localSessionInfo = this.l;
      this.h = new TroopAioFeedsCenterView(localQQAppInterface, (Context)localObject1, localSessionInfo, ((TroopGagMgr)localObject2).c(localSessionInfo.b), this);
      this.h.setFocusableInTouchMode(true);
      this.h.setId(2131447885);
      localObject2 = new RelativeLayout.LayoutParams(-1, this.i);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ((BaseActivity)localObject1).getResources().getDimensionPixelSize(2131299920);
      int i1 = this.c.getChildCount() - 1;
      while (i1 >= 0)
      {
        localObject1 = this.c.getChildAt(i1);
        if ((localObject1 instanceof TroopAioFeedsCenterView))
        {
          ((TroopAioFeedsCenterView)localObject1).c();
          this.c.removeView((View)localObject1);
        }
        i1 -= 1;
      }
      this.c.addView(this.h, (ViewGroup.LayoutParams)localObject2);
      this.p = true;
      this.h.startAnimation(this.j);
      if (this.p) {
        ((TroopAioFeedsCenterView)this.h).b();
      }
    }
    else if (((View)localObject2).getVisibility() != 0)
    {
      this.h.setVisibility(4);
      this.h.requestLayout();
      this.h.startAnimation(this.j);
      if (this.p) {
        ((TroopAioFeedsCenterView)this.h).b();
      }
    }
    if (!this.p)
    {
      localObject1 = this.m;
      if ((localObject1 != null) && (((TroopFeedsDataManager)localObject1).d != null) && (this.m.d.size() > 0))
      {
        if (!paramBoolean)
        {
          ReportController.b(this.a, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.l.b, "1", "", "");
          return;
        }
        ReportController.b(this.a, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.l.b, "1", this.v, "");
        return;
      }
      if (!paramBoolean)
      {
        ReportController.b(this.a, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.l.b, "0", "", "");
        return;
      }
      ReportController.b(this.a, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.l.b, "0", this.v, "");
      return;
    }
    this.u = true;
  }
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopFeedsCenterLogic.troop.notification_center", 2, "destory");
    }
    e(false);
    Object localObject = this.h;
    if ((localObject != null) && ((localObject instanceof TroopAioFeedsCenterView)))
    {
      ((TroopAioFeedsCenterView)localObject).c();
      this.h.setVisibility(8);
    }
    localObject = this.c;
    if (localObject != null)
    {
      View localView = this.h;
      if (localView != null) {
        ((RelativeLayout)localObject).removeView(localView);
      }
    }
    localObject = this.g;
    if (localObject != null) {
      ((TroopAioTips)localObject).k = false;
    }
    localObject = this.m;
    if (localObject != null)
    {
      ((TroopFeedsDataManager)localObject).deleteObserver(this);
      this.m.a();
      if (this.z == null) {
        this.z = ((TroopInfoManager)this.a.getManager(QQManagerFactory.TROOPINFO_MANAGER));
      }
      this.z.a(Long.valueOf(Long.parseLong(this.l.b)));
    }
    localObject = this.A;
    if ((localObject != null) && (((QQCustomDialog)localObject).isShowing())) {
      this.A.dismiss();
    }
    deleteObservers();
  }
  
  public void d(boolean paramBoolean)
  {
    BaseActivity localBaseActivity = (BaseActivity)this.b.get();
    if (localBaseActivity == null) {
      return;
    }
    if (paramBoolean)
    {
      this.p = true;
      if (!a())
      {
        this.n = true;
        e(true);
        this.f.setContentDescription(localBaseActivity.getString(2131895002));
        return;
      }
      this.o = true;
      return;
    }
    e(false);
    this.o = false;
    if (a())
    {
      this.f.setContentDescription(localBaseActivity.getString(2131895001));
      return;
    }
    this.f.setContentDescription(localBaseActivity.getString(2131895000));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof Integer))
    {
      paramObservable = (Integer)paramObject;
      if (paramObservable.intValue() == 104)
      {
        this.p = true;
        this.a.runOnUiThread(new TroopFeedsCenterLogic.2(this));
        return;
      }
      if ((paramObservable.intValue() != 101) && (paramObservable.intValue() != 103))
      {
        if (((paramObservable.intValue() == 1008) || (paramObservable.intValue() == 1009)) && (this.m.d.size() > 0))
        {
          paramObject = (TroopFeedItem)this.m.d.get(0);
          if ((paramObject.type != 5) && (paramObject.type != 19)) {
            return;
          }
          if (paramObservable.intValue() == 1009)
          {
            d(false);
            ((ITroopRedDotHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_RED_DOT_HANDLER)).a(this.l.b, 1102858908);
            ChatActivityUtils.a(this.a, this.l.b, Integer.valueOf(0));
          }
        }
      }
      else
      {
        if (this.u)
        {
          paramObject = this.m;
          if ((paramObject != null) && (paramObject.d != null) && (this.m.d.size() > 0))
          {
            if (!this.t) {
              ReportController.b(this.a, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.l.b, "1", "", "");
            } else {
              ReportController.b(this.a, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.l.b, "1", "", "");
            }
          }
          else if (!this.t) {
            ReportController.b(this.a, "P_CliOper", "Grp_AIO", "", "notice_center", "push", 0, 0, this.l.b, "0", "", "");
          } else {
            ReportController.b(this.a, "P_CliOper", "Grp_AIO", "", "notice_center", "Clk_entry", 0, 0, this.l.b, "0", "", "");
          }
        }
        if (paramObservable.intValue() == 103) {
          this.p = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic
 * JD-Core Version:    0.7.0.1
 */