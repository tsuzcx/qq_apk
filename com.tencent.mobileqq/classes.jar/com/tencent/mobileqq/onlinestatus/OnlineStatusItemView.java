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
  public boolean a = false;
  public boolean b = false;
  public OnlineStatusItem c;
  private int d;
  private TextView e;
  private ImageView f;
  private CheckBox g;
  private DiniFlyAnimationView h;
  private LottieDrawable i;
  private OnlineStatusPanelParams j;
  private int k;
  
  public OnlineStatusItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public OnlineStatusItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OnlineStatusItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    this.g = new CheckBox(getContext());
    this.g.setClickable(false);
    int m = ViewUtils.dpToPx(16.0F);
    int n = ViewUtils.dpToPx(7.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(m, m);
    localLayoutParams.addRule(10);
    localLayoutParams.topMargin = n;
    localLayoutParams.rightMargin = n;
    this.g.setButtonDrawable(null);
    localLayoutParams.addRule(11);
    this.g.setBackgroundDrawable(getResources().getDrawable(2130837707));
    addView(this.g, localLayoutParams);
  }
  
  private boolean a(OnlineStatusItem paramOnlineStatusItem, boolean paramBoolean)
  {
    if ((!TextUtils.isEmpty(paramOnlineStatusItem.k)) && (!TextUtils.isEmpty(paramOnlineStatusItem.l)) && (this.j.m))
    {
      if (!paramBoolean) {
        return false;
      }
      this.j.m = false;
      String[] arrayOfString = OnlineStatusResDownLoader.a(paramOnlineStatusItem.b);
      return ZipResourcesDownloader.a(paramOnlineStatusItem.k, paramOnlineStatusItem.l, arrayOfString);
    }
    return false;
  }
  
  private void b()
  {
    this.h = new DiniFlyAnimationView(getContext());
    this.h.setVisibility(8);
    Object localObject = new RelativeLayout.LayoutParams(-1, -1);
    addView(this.h, (ViewGroup.LayoutParams)localObject);
    localObject = new LinearLayout(getContext());
    ((LinearLayout)localObject).setOrientation(1);
    ((LinearLayout)localObject).setGravity(17);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13);
    addView((View)localObject, localLayoutParams);
    this.f = new ImageView(getContext());
    this.f.setId(2131439576);
    int m = this.d;
    localLayoutParams = new RelativeLayout.LayoutParams(m, m);
    ((LinearLayout)localObject).addView(this.f, localLayoutParams);
    this.e = new TextView(getContext());
    this.e.setId(2131439577);
    this.e.setTextSize(1, 14.0F);
    this.e.setSingleLine(true);
    this.e.setEllipsize(TextUtils.TruncateAt.END);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.topMargin = ViewUtils.dpToPx(4.0F);
    ((LinearLayout)localObject).addView(this.e, localLayoutParams);
  }
  
  private void c()
  {
    e();
    Object localObject1 = this.c;
    if ((localObject1 != null) && (a((OnlineStatusItem)localObject1, this.b)))
    {
      this.h.setVisibility(0);
      String str = OnlineStatusResDownLoader.a(this.c.k, this.c.l, this.c.b);
      localObject1 = MobileQQ.getContext();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("data.json");
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("images/");
      str = localStringBuilder.toString();
      int m = this.k;
      LottieHelper.a((Context)localObject1, (String)localObject2, str, m, m, new OnlineStatusItemView.1(this));
      return;
    }
    d();
  }
  
  private void d()
  {
    this.h.setVisibility(8);
    LottieDrawable localLottieDrawable = this.i;
    if (localLottieDrawable != null) {
      localLottieDrawable.removeAnimatorListener(this);
    }
  }
  
  private void e()
  {
    LottieDrawable localLottieDrawable = this.i;
    if (localLottieDrawable == null) {
      return;
    }
    if (localLottieDrawable.isAnimating()) {
      this.i.stop();
    }
    this.i.removeAnimatorListener(this);
    this.i.setFrame(0);
    this.i = null;
  }
  
  private void f()
  {
    LottieDrawable localLottieDrawable = this.i;
    if ((localLottieDrawable != null) && (!localLottieDrawable.isAnimating())) {
      this.i.playAnimation();
    }
  }
  
  private String getEmotionString()
  {
    return "";
  }
  
  public void a(OnlineStatusItem paramOnlineStatusItem)
  {
    if (paramOnlineStatusItem == null) {
      return;
    }
    this.c = paramOnlineStatusItem;
    this.e.setText(paramOnlineStatusItem.c);
    TextView localTextView = null;
    int m;
    if (paramOnlineStatusItem.f == 2)
    {
      paramOnlineStatusItem = OnlineStatusConstants.b(paramOnlineStatusItem.g);
    }
    else if ((this.a) && (!TextUtils.isEmpty(getEmotionString())))
    {
      Object localObject = new com.tencent.mobileqq.text.QQText(getEmotionString(), 3).mSpans[0];
      paramOnlineStatusItem = localTextView;
      if ((localObject instanceof EmoticonSpan)) {
        paramOnlineStatusItem = ((EmoticonSpan)localObject).getDrawable();
      }
    }
    else if (OnLineStatusHelper.a().a(paramOnlineStatusItem))
    {
      m = OnLineStatusHelper.g();
      paramOnlineStatusItem = new OnlineBatteryProducer().a(m, 1);
    }
    else if ((paramOnlineStatusItem.b == 1080L) && (OnLineStatusHelper.a().d()))
    {
      paramOnlineStatusItem = OnLineStatusHelper.a().a(paramOnlineStatusItem, this.d, 3);
    }
    else
    {
      paramOnlineStatusItem = URLDrawable.getDrawable(this.c.d, URLDrawable.URLDrawableOptions.obtain());
    }
    if (paramOnlineStatusItem != null)
    {
      m = this.d;
      paramOnlineStatusItem.setBounds(0, 0, m, m);
      this.f.setImageDrawable(paramOnlineStatusItem);
    }
    boolean bool = QQTheme.isNowThemeIsNight();
    if (this.j.j) {
      m = 2130839608;
    } else {
      m = 2130839607;
    }
    int n;
    if (this.j.k) {
      n = 2130839567;
    } else {
      n = 2130839605;
    }
    if (bool) {
      m = n;
    }
    setBackgroundResource(m);
    localTextView = this.e;
    if (bool) {
      paramOnlineStatusItem = "#FFFFFF";
    } else {
      paramOnlineStatusItem = "#03081A";
    }
    localTextView.setTextColor(Color.parseColor(paramOnlineStatusItem));
  }
  
  public void a(OnlineStatusPanelParams paramOnlineStatusPanelParams)
  {
    this.j = paramOnlineStatusPanelParams;
    this.d = ViewUtils.dpToPx(24.0F);
    b();
    if (paramOnlineStatusPanelParams.b) {
      a();
    }
    setOnTouchListener(new LottieHelper.ViewAlphaOnTouchListener());
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool1 = QQTheme.isNowThemeIsNight();
    int m;
    if (this.j.j) {
      m = 2130839608;
    } else {
      m = 2130839607;
    }
    int n;
    if (this.j.k) {
      n = 2130839567;
    } else {
      n = 2130839605;
    }
    if (bool1) {
      m = n;
    }
    setBackgroundResource(m);
    this.b = paramBoolean;
    boolean bool2 = this.j.b;
    Object localObject1 = "#03081A";
    Object localObject2 = "#FFFFFF";
    if (bool2)
    {
      this.g.setChecked(paramBoolean);
      localObject2 = this.e;
      if (bool1) {
        localObject1 = "#FFFFFF";
      }
      ((TextView)localObject2).setTextColor(Color.parseColor((String)localObject1));
      setSelected(false);
    }
    else
    {
      setSelected(paramBoolean);
      TextView localTextView = this.e;
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
    this.k = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusItemView
 * JD-Core Version:    0.7.0.1
 */