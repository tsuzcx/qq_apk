package com.tencent.mobileqq.onlinestatus;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.utils.UITools.MyViewAlphaOnTouchListener;
import com.tencent.avgame.gameroom.AVGameLottieHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.mutualmark.ZipResourcesDownloader;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.OnlineBatteryProducer;

public class OnlineStatusItemView
  extends RelativeLayout
  implements Animator.AnimatorListener
{
  private int jdField_a_of_type_Int;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  public OnlineStatusItem a;
  private OnlineStatusPanelParams jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams;
  public boolean a;
  private int b;
  public boolean b;
  
  public OnlineStatusItemView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public OnlineStatusItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  public OnlineStatusItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private String a()
  {
    return "";
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = new CheckBox(getContext());
    this.jdField_a_of_type_AndroidWidgetCheckBox.setClickable(false);
    int i = AIOUtils.a(16.0F, getResources());
    int j = AIOUtils.a(7.0F, getResources());
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(10);
    localLayoutParams.topMargin = j;
    localLayoutParams.rightMargin = j;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(null);
    localLayoutParams.addRule(11);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundDrawable(getResources().getDrawable(2130840428));
    addView(this.jdField_a_of_type_AndroidWidgetCheckBox, localLayoutParams);
  }
  
  private boolean a(OnlineStatusItem paramOnlineStatusItem, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramOnlineStatusItem.e)) || (TextUtils.isEmpty(paramOnlineStatusItem.f)) || (!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.d) || (!paramBoolean)) {
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.d = false;
    String[] arrayOfString = OnlineStatusResDownLoader.a(paramOnlineStatusItem.jdField_a_of_type_Long);
    return ZipResourcesDownloader.a(paramOnlineStatusItem.e, paramOnlineStatusItem.f, arrayOfString);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = new DiniFlyAnimationView(getContext());
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout(getContext());
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).setGravity(17);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    addView((View)localObject, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131372521);
    localLayoutParams = new RelativeLayout.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
    ((LinearLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131372522);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = AIOUtils.a(4.0F, getResources());
    ((LinearLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  private void c()
  {
    e();
    if ((this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem == null) || (!a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem, this.jdField_b_of_type_Boolean)))
    {
      d();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    String str = OnlineStatusResDownLoader.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem.e, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem.f, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem.jdField_a_of_type_Long);
    AVGameLottieHelper.b(BaseApplicationImpl.getContext(), str + "data.json", str + "images/", this.jdField_b_of_type_Int, this.jdField_b_of_type_Int, new OnlineStatusItemView.1(this));
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.removeAnimatorListener(this);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating()) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.removeAnimatorListener(this);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setFrame(0);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (!this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
    }
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem)
  {
    if (paramOnlineStatusItem == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem = paramOnlineStatusItem;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramOnlineStatusItem.b);
    if (paramOnlineStatusItem.jdField_a_of_type_Int == 2) {
      paramOnlineStatusItem = OnlineStatusConstants.a(paramOnlineStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status);
    }
    for (;;)
    {
      if (paramOnlineStatusItem != null)
      {
        paramOnlineStatusItem.setBounds(0, 0, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramOnlineStatusItem);
      }
      boolean bool = ThemeUtil.isNowThemeIsNight(null, false, "");
      int i;
      label86:
      int j;
      label100:
      TextView localTextView;
      if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.jdField_b_of_type_Boolean)
      {
        i = 2130839566;
        if (!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.c) {
          break label244;
        }
        j = 2130839527;
        if (bool) {
          i = j;
        }
        setBackgroundResource(i);
        localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        if (!bool) {
          break label251;
        }
      }
      label244:
      label251:
      for (paramOnlineStatusItem = "#FFFFFF";; paramOnlineStatusItem = "#03081A")
      {
        localTextView.setTextColor(Color.parseColor(paramOnlineStatusItem));
        return;
        if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(a())))
        {
          paramOnlineStatusItem = new com.tencent.mobileqq.text.QQText(a(), 3).mSpans[0];
          if (!(paramOnlineStatusItem instanceof EmoticonSpan)) {
            break label258;
          }
          paramOnlineStatusItem = ((EmoticonSpan)paramOnlineStatusItem).getDrawable();
          break;
        }
        if (OnLineStatusHelper.a().a(paramOnlineStatusItem))
        {
          i = OnLineStatusHelper.a();
          paramOnlineStatusItem = new OnlineBatteryProducer().a(i, 1);
          break;
        }
        paramOnlineStatusItem = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem.c, URLDrawable.URLDrawableOptions.obtain());
        break;
        i = 2130839565;
        break label86;
        j = 2130839564;
        break label100;
      }
      label258:
      paramOnlineStatusItem = null;
    }
  }
  
  public void a(OnlineStatusPanelParams paramOnlineStatusPanelParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams = paramOnlineStatusPanelParams;
    this.jdField_a_of_type_Int = AIOUtils.a(24.0F, getResources());
    b();
    if (paramOnlineStatusPanelParams.jdField_a_of_type_Boolean) {
      a();
    }
    setOnTouchListener(new UITools.MyViewAlphaOnTouchListener());
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, "");
    int i;
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.jdField_b_of_type_Boolean)
    {
      i = 2130839566;
      if (!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.c) {
        break label119;
      }
      j = 2130839527;
      label37:
      if (bool) {
        i = j;
      }
      setBackgroundResource(i);
      this.jdField_b_of_type_Boolean = paramBoolean;
      if (!this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.jdField_a_of_type_Boolean) {
        break label134;
      }
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!bool) {
        break label126;
      }
    }
    label119:
    label126:
    for (String str = "#FFFFFF";; str = "#03081A")
    {
      localTextView.setTextColor(Color.parseColor(str));
      setSelected(false);
      c();
      invalidate();
      return;
      i = 2130839565;
      break;
      j = 2130839564;
      break label37;
    }
    label134:
    setSelected(paramBoolean);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (bool) {
      str = "#FFFFFF";
    }
    for (;;)
    {
      localTextView.setTextColor(Color.parseColor(str));
      break;
      if (paramBoolean) {
        str = "#FFFFFF";
      } else {
        str = "#03081A";
      }
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    d();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    d();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void setItemWidth(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusItemView
 * JD-Core Version:    0.7.0.1
 */