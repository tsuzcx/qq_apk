package com.tencent.mobileqq.onlinestatus;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.onlinestatus.view.AutoStatusSelectView.MyViewAlphaOnTouchListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.onlinestatus.api.ICustomOnlineStatusManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;
import mqq.app.MobileQQ;

public class OnLineStatusCustomSmartViewCtrl
{
  private View a;
  private View b;
  private DiniFlyAnimationView c;
  private ImageView d;
  private boolean e = false;
  private boolean f = false;
  private LottieDrawable g;
  private boolean h = false;
  
  public OnLineStatusCustomSmartViewCtrl(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.e = paramBoolean1;
    this.f = paramBoolean2;
  }
  
  public static void a(View paramView, boolean paramBoolean1, TextView paramTextView, boolean paramBoolean2)
  {
    boolean bool = QQTheme.isNowThemeIsNight();
    paramView.setSelected(paramBoolean1);
    int i;
    if (paramBoolean2) {
      i = 2130839608;
    } else {
      i = 2130839607;
    }
    if (bool) {
      i = 2130839605;
    }
    paramView.setBackgroundResource(i);
    if (paramTextView != null)
    {
      String str = "#FFFFFF";
      if ((!bool) && (!paramBoolean1)) {
        str = "#03081A";
      }
      paramTextView.setTextColor(Color.parseColor(str));
    }
    paramView.invalidate();
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a(Activity paramActivity)
  {
    View localView = this.a;
    if (localView != null)
    {
      if (paramActivity == null) {
        return;
      }
      if (((ICustomOnlineStatusManager)QRoute.api(ICustomOnlineStatusManager.class)).featureEnable())
      {
        paramActivity = this.b;
        if (paramActivity != null)
        {
          int i;
          if (paramActivity.getVisibility() == 0) {
            i = 9;
          } else {
            i = 0;
          }
          paramActivity = (LinearLayout.LayoutParams)localView.getLayoutParams();
          paramActivity.leftMargin = Utils.a(i, localView.getResources());
          localView.setLayoutParams(paramActivity);
        }
        localView.setVisibility(0);
        paramActivity = (ImageView)localView.findViewById(2131437100);
        paramActivity.setImageDrawable(paramActivity.getResources().getDrawable(2130837639));
        paramActivity = (TextView)localView.findViewById(2131437131);
        paramActivity.setText(2131888274);
        a(localView, false, paramActivity, this.e);
        return;
      }
      localView.setVisibility(8);
    }
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramContext = View.inflate(paramContext, 2131623996, null);
    this.a = paramContext.findViewById(2131431544);
    this.b = paramContext.findViewById(2131431541);
    this.c = ((DiniFlyAnimationView)this.b.findViewById(2131437103));
    this.d = ((ImageView)this.b.findViewById(2131437100));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = Utils.a(9.0F, paramViewGroup.getResources());
    localLayoutParams.leftMargin = Utils.a(14.0F, paramViewGroup.getResources());
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
    paramViewGroup.addView(paramContext, paramInt, localLayoutParams);
    this.a.setOnTouchListener(new AutoStatusSelectView.MyViewAlphaOnTouchListener());
    this.b.setOnTouchListener(new AutoStatusSelectView.MyViewAlphaOnTouchListener());
    if (this.f) {
      LottieHelper.a(MobileQQ.getContext(), "online_status_smart/data.json", "online_status_smart/images/", 24, 34, -1, new OnLineStatusCustomSmartViewCtrl.1(this));
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, AppRuntime.Status paramStatus, long paramLong)
  {
    View localView = this.b;
    if ((localView != null) && (paramQBaseActivity != null))
    {
      if (paramStatus == null) {
        return;
      }
      if (!OnlineStatusUtil.a())
      {
        localView.setVisibility(8);
        c();
        return;
      }
      OnlineStatusItem localOnlineStatusItem = ((OnlineAutoStatusBean)QConfigManager.b().b(652)).a.b;
      boolean bool2 = false;
      localView.setVisibility(0);
      TextView localTextView = (TextView)localView.findViewById(2131437131);
      if (localOnlineStatusItem.c == null) {
        paramQBaseActivity = "";
      } else {
        paramQBaseActivity = localOnlineStatusItem.c;
      }
      localTextView.setText(paramQBaseActivity);
      if (!a(paramStatus, paramLong)) {
        a(localOnlineStatusItem);
      }
      paramQBaseActivity = OnLineStatusHelper.a().a(AppRuntime.Status.online, 40001L);
      boolean bool1 = bool2;
      if (OnlineStatusItem.a(paramStatus, paramLong))
      {
        bool1 = bool2;
        if (OnlineStatusUtil.b(paramQBaseActivity)) {
          bool1 = true;
        }
      }
      a(localView, bool1, localTextView, this.e);
    }
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem)
  {
    this.d.setVisibility(0);
    c();
    this.c.setVisibility(8);
    if (!TextUtils.isEmpty(paramOnlineStatusItem.d))
    {
      int i = Utils.a(24.0F, this.d.getResources());
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = i;
      localURLDrawableOptions.mRequestHeight = i;
      paramOnlineStatusItem = URLDrawable.getDrawable(paramOnlineStatusItem.d, localURLDrawableOptions);
      if (paramOnlineStatusItem != null)
      {
        paramOnlineStatusItem.setBounds(0, 0, i, i);
        this.d.setImageDrawable(paramOnlineStatusItem);
      }
    }
  }
  
  public boolean a(AppRuntime.Status paramStatus, long paramLong)
  {
    if (!this.f)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusCustomSmartViewCtrl", 4, new Object[] { " showLottiAni mUseLottiAni=", Boolean.valueOf(this.f) });
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusCustomSmartViewCtrl", 4, new Object[] { " showLottiAni onlineStatus=", paramStatus, " extStatus=", Long.valueOf(paramLong) });
    }
    this.d.setVisibility(8);
    this.c.setVisibility(0);
    if ((paramStatus == AppRuntime.Status.online) && (paramLong == 40001L))
    {
      d();
      return true;
    }
    c();
    return true;
  }
  
  public View b()
  {
    return this.b;
  }
  
  public void c()
  {
    this.h = false;
    LottieDrawable localLottieDrawable = this.g;
    if (localLottieDrawable == null) {
      return;
    }
    if (localLottieDrawable.isAnimating()) {
      this.g.stop();
    }
    this.g.setFrame(0);
  }
  
  public void d()
  {
    this.h = true;
    LottieDrawable localLottieDrawable = this.g;
    if ((localLottieDrawable != null) && (!localLottieDrawable.isAnimating())) {
      this.g.playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnLineStatusCustomSmartViewCtrl
 * JD-Core Version:    0.7.0.1
 */