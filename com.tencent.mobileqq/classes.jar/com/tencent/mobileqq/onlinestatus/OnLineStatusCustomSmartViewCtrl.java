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
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.avgame.gameroom.AVGameLottieHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.business.OnlineAutoStatusBean;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.onlinestatus.config.AutoStatusElement;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.CustomOnlineStatusManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

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
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, "");
    paramView.setSelected(paramBoolean1);
    int i;
    String str;
    if (paramBoolean2)
    {
      i = 2130839566;
      if (bool) {
        i = 2130839564;
      }
      paramView.setBackgroundResource(i);
      if (paramTextView != null)
      {
        if (!bool) {
          break label71;
        }
        str = "#FFFFFF";
      }
    }
    for (;;)
    {
      paramTextView.setTextColor(Color.parseColor(str));
      paramView.invalidate();
      return;
      i = 2130839565;
      break;
      label71:
      if (paramBoolean1) {
        str = "#FFFFFF";
      } else {
        str = "#03081A";
      }
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.c = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating()) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setFrame(0);
  }
  
  public void a(Activity paramActivity)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView == null) || (paramActivity == null)) {
      return;
    }
    if (CustomOnlineStatusManager.a().a()) {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0) {
          break label131;
        }
      }
    }
    label131:
    for (int i = 9;; i = 0)
    {
      paramActivity = (LinearLayout.LayoutParams)localView.getLayoutParams();
      paramActivity.leftMargin = AIOUtils.a(i, localView.getResources());
      localView.setLayoutParams(paramActivity);
      localView.setVisibility(0);
      paramActivity = (ImageView)localView.findViewById(2131370283);
      paramActivity.setImageDrawable(paramActivity.getResources().getDrawable(2130837544));
      paramActivity = (TextView)localView.findViewById(2131370312);
      paramActivity.setText(2131691397);
      a(localView, false, paramActivity, this.jdField_a_of_type_Boolean);
      return;
      localView.setVisibility(8);
      return;
    }
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramContext = View.inflate(paramContext, 2131558432, null);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131365511);
    this.jdField_b_of_type_AndroidViewView = paramContext.findViewById(2131365509);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370285));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370283));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = AIOUtils.a(9.0F, paramViewGroup.getResources());
    localLayoutParams.leftMargin = AIOUtils.a(14.0F, paramViewGroup.getResources());
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
    paramViewGroup.addView(paramContext, paramInt, localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
    if (this.jdField_b_of_type_Boolean) {
      AVGameLottieHelper.a(BaseApplicationImpl.getContext(), "online_status_smart/data.json", "online_status_smart/images/", 24, 34, -1, new OnLineStatusCustomSmartViewCtrl.1(this));
    }
  }
  
  public void a(BaseActivity paramBaseActivity, AppRuntime.Status paramStatus, long paramLong)
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if ((localView == null) || (paramBaseActivity == null) || (paramStatus == null)) {
      return;
    }
    if (!OnlineStatusUtil.a())
    {
      localView.setVisibility(8);
      a();
      return;
    }
    OnlineStatusItem localOnlineStatusItem = ((OnlineAutoStatusBean)QConfigManager.a().a(652)).a.a;
    localView.setVisibility(0);
    TextView localTextView = (TextView)localView.findViewById(2131370312);
    if (localOnlineStatusItem.b == null)
    {
      paramBaseActivity = "";
      localTextView.setText(paramBaseActivity);
      if (!a(paramStatus, paramLong)) {
        a(localOnlineStatusItem);
      }
      paramBaseActivity = OnLineStatusHelper.a().a(AppRuntime.Status.online, 40001L);
      if ((!OnlineStatusItem.a(paramStatus, paramLong)) || (!OnlineStatusUtil.b(paramBaseActivity))) {
        break label162;
      }
    }
    label162:
    for (boolean bool = true;; bool = false)
    {
      a(localView, bool, localTextView, this.jdField_a_of_type_Boolean);
      return;
      paramBaseActivity = localOnlineStatusItem.b;
      break;
    }
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    a();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    if (!TextUtils.isEmpty(paramOnlineStatusItem.c))
    {
      int i = AIOUtils.a(24.0F, this.jdField_a_of_type_AndroidWidgetImageView.getResources());
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
    if ((paramStatus == AppRuntime.Status.online) && (paramLong == 40001L)) {
      b();
    }
    for (;;)
    {
      return true;
      a();
    }
  }
  
  public View b()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void b()
  {
    this.c = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (!this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnLineStatusCustomSmartViewCtrl
 * JD-Core Version:    0.7.0.1
 */