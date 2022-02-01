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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper.ViewAlphaOnTouchListener;
import com.tencent.mobileqq.onlinestatus.utils.ZipResourcesDownloader;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.OnlineBatteryProducer;
import mqq.app.MobileQQ;

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
    int i = ViewUtils.b(16.0F);
    int j = ViewUtils.b(7.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(10);
    localLayoutParams.topMargin = j;
    localLayoutParams.rightMargin = j;
    this.jdField_a_of_type_AndroidWidgetCheckBox.setButtonDrawable(null);
    localLayoutParams.addRule(11);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setBackgroundDrawable(getResources().getDrawable(2130837683));
    addView(this.jdField_a_of_type_AndroidWidgetCheckBox, localLayoutParams);
  }
  
  private boolean a(OnlineStatusItem paramOnlineStatusItem, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramOnlineStatusItem.f)) && (!TextUtils.isEmpty(paramOnlineStatusItem.g)) && (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.d))
    {
      if (!paramBoolean) {
        return false;
      }
      this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.d = false;
      String[] arrayOfString = OnlineStatusResDownLoader.a(paramOnlineStatusItem.jdField_a_of_type_Long);
      return ZipResourcesDownloader.a(paramOnlineStatusItem.f, paramOnlineStatusItem.g, arrayOfString);
    }
    return false;
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
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131372106);
    int i = this.jdField_a_of_type_Int;
    localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    ((LinearLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
    this.jdField_a_of_type_AndroidWidgetTextView.setId(2131372107);
    this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 14.0F);
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine(true);
    this.jdField_a_of_type_AndroidWidgetTextView.setEllipsize(TextUtils.TruncateAt.END);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = ViewUtils.b(4.0F);
    ((LinearLayout)localObject).addView(this.jdField_a_of_type_AndroidWidgetTextView, localLayoutParams);
  }
  
  private void c()
  {
    e();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem;
    if ((localObject1 != null) && (a((OnlineStatusItem)localObject1, this.jdField_b_of_type_Boolean)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
      String str = OnlineStatusResDownLoader.a(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem.f, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem.g, this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem.jdField_a_of_type_Long);
      localObject1 = MobileQQ.getContext();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("data.json");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("images/");
      str = localStringBuilder.toString();
      int i = this.jdField_b_of_type_Int;
      LottieHelper.a((Context)localObject1, (String)localObject2, str, i, i, new OnlineStatusItemView.1(this));
      return;
    }
    d();
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    LottieDrawable localLottieDrawable = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localLottieDrawable != null) {
      localLottieDrawable.removeAnimatorListener(this);
    }
  }
  
  private void e()
  {
    LottieDrawable localLottieDrawable = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localLottieDrawable == null) {
      return;
    }
    if (localLottieDrawable.isAnimating()) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.removeAnimatorListener(this);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setFrame(0);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
  }
  
  private void f()
  {
    LottieDrawable localLottieDrawable = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if ((localLottieDrawable != null) && (!localLottieDrawable.isAnimating())) {
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
    TextView localTextView = null;
    int i;
    if (paramOnlineStatusItem.jdField_a_of_type_Int == 2)
    {
      paramOnlineStatusItem = OnlineStatusConstants.a(paramOnlineStatusItem.jdField_a_of_type_MqqAppAppRuntime$Status);
    }
    else if ((this.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(a())))
    {
      Object localObject = new com.tencent.mobileqq.text.QQText(a(), 3).mSpans[0];
      paramOnlineStatusItem = localTextView;
      if ((localObject instanceof EmoticonSpan)) {
        paramOnlineStatusItem = ((EmoticonSpan)localObject).getDrawable();
      }
    }
    else if (OnLineStatusHelper.a().a(paramOnlineStatusItem))
    {
      i = OnLineStatusHelper.a();
      paramOnlineStatusItem = new OnlineBatteryProducer().a(i, 1);
    }
    else
    {
      paramOnlineStatusItem = URLDrawable.getDrawable(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusItem.c, URLDrawable.URLDrawableOptions.obtain());
    }
    if (paramOnlineStatusItem != null)
    {
      i = this.jdField_a_of_type_Int;
      paramOnlineStatusItem.setBounds(0, 0, i, i);
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramOnlineStatusItem);
    }
    boolean bool = QQTheme.a();
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.jdField_b_of_type_Boolean) {
      i = 2130839424;
    } else {
      i = 2130839423;
    }
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.c) {
      j = 2130839383;
    } else {
      j = 2130839421;
    }
    if (bool) {
      i = j;
    }
    setBackgroundResource(i);
    localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (bool) {
      paramOnlineStatusItem = "#FFFFFF";
    } else {
      paramOnlineStatusItem = "#03081A";
    }
    localTextView.setTextColor(Color.parseColor(paramOnlineStatusItem));
  }
  
  public void a(OnlineStatusPanelParams paramOnlineStatusPanelParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams = paramOnlineStatusPanelParams;
    this.jdField_a_of_type_Int = ViewUtils.b(24.0F);
    b();
    if (paramOnlineStatusPanelParams.jdField_a_of_type_Boolean) {
      a();
    }
    setOnTouchListener(new LottieHelper.ViewAlphaOnTouchListener());
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool1 = QQTheme.a();
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.jdField_b_of_type_Boolean) {
      i = 2130839424;
    } else {
      i = 2130839423;
    }
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.c) {
      j = 2130839383;
    } else {
      j = 2130839421;
    }
    if (bool1) {
      i = j;
    }
    setBackgroundResource(i);
    this.jdField_b_of_type_Boolean = paramBoolean;
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPanelParams.jdField_a_of_type_Boolean;
    Object localObject1 = "#03081A";
    Object localObject2 = "#FFFFFF";
    if (bool2)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (bool1) {
        localObject1 = "#FFFFFF";
      }
      ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      setSelected(false);
    }
    else
    {
      setSelected(paramBoolean);
      TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
      if (bool1) {
        localObject1 = localObject2;
      } else if (paramBoolean) {
        localObject1 = localObject2;
      } else {
        localObject1 = "#03081A";
      }
      localTextView.setTextColor(Color.parseColor((String)localObject1));
    }
    c();
    invalidate();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusItemView
 * JD-Core Version:    0.7.0.1
 */