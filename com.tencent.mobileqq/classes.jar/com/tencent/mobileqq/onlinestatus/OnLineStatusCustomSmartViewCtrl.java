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
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private boolean jdField_a_of_type_Boolean = false;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c = false;
  
  public OnLineStatusCustomSmartViewCtrl(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
  }
  
  public static void a(View paramView, boolean paramBoolean1, TextView paramTextView, boolean paramBoolean2)
  {
    boolean bool = QQTheme.a();
    paramView.setSelected(paramBoolean1);
    int i;
    if (paramBoolean2) {
      i = 2130839424;
    } else {
      i = 2130839423;
    }
    if (bool) {
      i = 2130839421;
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
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.c = false;
    LottieDrawable localLottieDrawable = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localLottieDrawable == null) {
      return;
    }
    if (localLottieDrawable.isAnimating()) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setFrame(0);
  }
  
  public void a(Activity paramActivity)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      if (paramActivity == null) {
        return;
      }
      if (((ICustomOnlineStatusManager)QRoute.api(ICustomOnlineStatusManager.class)).featureEnable())
      {
        paramActivity = this.jdField_b_of_type_AndroidViewView;
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
        paramActivity = (ImageView)localView.findViewById(2131369951);
        paramActivity.setImageDrawable(paramActivity.getResources().getDrawable(2130837631));
        paramActivity = (TextView)localView.findViewById(2131369980);
        paramActivity.setText(2131691319);
        a(localView, false, paramActivity, this.jdField_a_of_type_Boolean);
        return;
      }
      localView.setVisibility(8);
    }
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramContext = View.inflate(paramContext, 2131558460, null);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131365357);
    this.jdField_b_of_type_AndroidViewView = paramContext.findViewById(2131365355);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369953));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369951));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = Utils.a(9.0F, paramViewGroup.getResources());
    localLayoutParams.leftMargin = Utils.a(14.0F, paramViewGroup.getResources());
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
    paramViewGroup.addView(paramContext, paramInt, localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new AutoStatusSelectView.MyViewAlphaOnTouchListener());
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new AutoStatusSelectView.MyViewAlphaOnTouchListener());
    if (this.jdField_b_of_type_Boolean) {
      LottieHelper.a(MobileQQ.getContext(), "online_status_smart/data.json", "online_status_smart/images/", 24, 34, -1, new OnLineStatusCustomSmartViewCtrl.1(this));
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity, AppRuntime.Status paramStatus, long paramLong)
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if ((localView != null) && (paramQBaseActivity != null))
    {
      if (paramStatus == null) {
        return;
      }
      if (!OnlineStatusUtil.a())
      {
        localView.setVisibility(8);
        a();
        return;
      }
      OnlineStatusItem localOnlineStatusItem = ((OnlineAutoStatusBean)QConfigManager.a().a(652)).a.a;
      boolean bool2 = false;
      localView.setVisibility(0);
      TextView localTextView = (TextView)localView.findViewById(2131369980);
      if (localOnlineStatusItem.b == null) {
        paramQBaseActivity = "";
      } else {
        paramQBaseActivity = localOnlineStatusItem.b;
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
      a(localView, bool1, localTextView, this.jdField_a_of_type_Boolean);
    }
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    a();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    if (!TextUtils.isEmpty(paramOnlineStatusItem.c))
    {
      int i = Utils.a(24.0F, this.jdField_a_of_type_AndroidWidgetImageView.getResources());
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = i;
      localURLDrawableOptions.mRequestHeight = i;
      paramOnlineStatusItem = URLDrawable.getDrawable(paramOnlineStatusItem.c, localURLDrawableOptions);
      if (paramOnlineStatusItem != null)
      {
        paramOnlineStatusItem.setBounds(0, 0, i, i);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramOnlineStatusItem);
      }
    }
  }
  
  public boolean a(AppRuntime.Status paramStatus, long paramLong)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusCustomSmartViewCtrl", 4, new Object[] { " showLottiAni mUseLottiAni=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusCustomSmartViewCtrl", 4, new Object[] { " showLottiAni onlineStatus=", paramStatus, " extStatus=", Long.valueOf(paramLong) });
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    if ((paramStatus == AppRuntime.Status.online) && (paramLong == 40001L))
    {
      b();
      return true;
    }
    a();
    return true;
  }
  
  public View b()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void b()
  {
    this.c = true;
    LottieDrawable localLottieDrawable = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if ((localLottieDrawable != null) && (!localLottieDrawable.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnLineStatusCustomSmartViewCtrl
 * JD-Core Version:    0.7.0.1
 */