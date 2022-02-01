package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AlphaClickableImageView;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class NewStyleDropdownView
  extends RelativeLayout
  implements PopupWindow.OnDismissListener
{
  NewStyleDropdownView.AutoCompleteView a;
  Drawable b;
  Drawable c;
  boolean d = false;
  InputMethodManager e;
  public NewStyleDropdownView.DropdownCallback f;
  private ImageView g;
  private ImageView h;
  private FrameLayout i;
  private URLImageView j;
  private final RelativeLayout.LayoutParams k = new RelativeLayout.LayoutParams(-1, -1);
  private float l;
  private ImageView m;
  
  public NewStyleDropdownView(Context paramContext)
  {
    super(paramContext);
    this.a = new NewStyleDropdownView.AutoCompleteView(this, paramContext);
    a(paramContext);
  }
  
  public NewStyleDropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = new NewStyleDropdownView.AutoCompleteView(this, paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  @TargetApi(11)
  public NewStyleDropdownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new NewStyleDropdownView.AutoCompleteView(this, paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private int a(float paramFloat, Resources paramResources)
  {
    return ViewUtils.dip2px(paramFloat);
  }
  
  private void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      try
      {
        View.class.getMethod("setImportantForAutofill", new Class[] { Integer.TYPE }).invoke(this.a, new Object[] { Integer.valueOf(8) });
      }
      catch (Exception localException)
      {
        QLog.w("NewStyleDropdownView", 2, "disable auto fill error", localException);
      }
    }
    this.a.setHintTextColor(getResources().getColor(2131166414));
    this.a.setHighlightColor(Color.parseColor("#8000CAFC"));
    this.e = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.l = paramContext.getResources().getDisplayMetrics().density;
    setLayoutParams(this.k);
    setPadding(0, 0, 0, 0);
    Object localObject1 = new RelativeLayout.LayoutParams(this.k);
    addView(this.a, (ViewGroup.LayoutParams)localObject1);
    this.a.setDropDownVerticalOffset(ViewUtils.dip2px(12.0F));
    this.a.setDropDownHeight(a(251.5F, getResources()));
    this.a.setPadding(ViewUtils.dip2px(63.0F), 0, ViewUtils.dip2px(63.0F), 0);
    this.a.setGravity(17);
    this.a.setDropDownBackgroundResource(2130847008);
    localObject1 = new SpannableString(HardCodeUtil.a(2131905388));
    ((SpannableString)localObject1).setSpan(new AbsoluteSizeSpan(17, true), 0, ((SpannableString)localObject1).length(), 33);
    this.a.setHint((CharSequence)localObject1);
    this.i = new FrameLayout(paramContext);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    Object localObject2 = (RelativeLayout.LayoutParams)localObject1;
    ((RelativeLayout.LayoutParams)localObject2).setMargins(ViewUtils.dip2px(10.0F), 0, 0, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    addView(this.i, (ViewGroup.LayoutParams)localObject1);
    this.m = new ImageView(paramContext);
    int n = ViewUtils.dip2px(40.0F) + 4;
    localObject1 = new FrameLayout.LayoutParams(n, n);
    this.m.setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((FrameLayout.LayoutParams)localObject1).gravity = 17;
    this.i.addView(this.m, (ViewGroup.LayoutParams)localObject1);
    this.j = new URLImageView(paramContext);
    n -= 4;
    localObject1 = new FrameLayout.LayoutParams(n, n);
    this.j.setScaleType(ImageView.ScaleType.FIT_CENTER);
    ((FrameLayout.LayoutParams)localObject1).gravity = 17;
    this.i.addView(this.j, (ViewGroup.LayoutParams)localObject1);
    this.h = new ImageView(paramContext);
    this.h.setImageResource(2130846062);
    this.h.setClickable(true);
    this.h.setVisibility(8);
    this.h.setContentDescription(HardCodeUtil.a(2131905389));
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    localObject2 = this.h;
    float f1 = this.l;
    ((ImageView)localObject2).setPadding((int)(f1 * 10.0F), (int)(f1 * 10.0F), (int)(f1 * 10.0F), (int)(f1 * 10.0F));
    ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, ViewUtils.dip2px(40.0F), 0);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11, -1);
    addView(this.h, (ViewGroup.LayoutParams)localObject1);
    this.g = new AlphaClickableImageView(paramContext);
    this.g.setId(571);
    paramContext = this.g;
    f1 = this.l;
    paramContext.setPadding((int)(f1 * 10.0F), (int)(f1 * 10.0F), (int)(f1 * 10.0F), (int)(f1 * 10.0F));
    this.g.setContentDescription(HardCodeUtil.a(2131905387));
    this.b = getResources().getDrawable(2130841447);
    this.c = getResources().getDrawable(2130841448);
    this.g.setImageDrawable(this.b);
    this.g.setClickable(true);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.setMargins(0, 0, ViewUtils.dip2px(15.0F), 0);
    paramContext.addRule(15);
    paramContext.addRule(11, -1);
    addView(this.g, paramContext);
    this.g.setOnClickListener(new NewStyleDropdownView.1(this));
    try
    {
      paramContext = this.a.getClass().getSuperclass().getDeclaredField("mPopup");
      paramContext.setAccessible(true);
      paramContext = paramContext.get(this.a);
      paramContext.getClass().getMethod("setOnDismissListener", new Class[] { PopupWindow.OnDismissListener.class }).invoke(paramContext, new Object[] { this });
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public void a()
  {
    NewStyleDropdownView.AutoCompleteView localAutoCompleteView = this.a;
    if (localAutoCompleteView != null) {
      localAutoCompleteView.showDropDown();
    }
  }
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.i.setVisibility(0);
      if ((paramObject instanceof Bitmap))
      {
        this.j.setImageBitmap((Bitmap)paramObject);
        this.m.setVisibility(0);
        return;
      }
      if ((paramObject instanceof Drawable))
      {
        this.j.setImageDrawable((Drawable)paramObject);
        this.m.setVisibility(4);
        return;
      }
      this.j.setImageResource(2130841444);
      this.m.setVisibility(0);
      return;
    }
    this.i.setVisibility(8);
  }
  
  public ImageView getDelIcon()
  {
    return this.h;
  }
  
  public ImageView getDropDownIcon()
  {
    return this.g;
  }
  
  public AutoCompleteTextView getView()
  {
    return this.a;
  }
  
  public void onDismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewStyleDropdownView", 2, "onDismiss set icon down");
    }
    this.g.setImageDrawable(this.b);
    NewStyleDropdownView.DropdownCallback localDropdownCallback = this.f;
    if (localDropdownCallback != null) {
      localDropdownCallback.e();
    }
    this.g.postDelayed(new NewStyleDropdownView.2(this), 500L);
  }
  
  public void setHeadBorder(int paramInt)
  {
    this.m.setImageResource(paramInt);
  }
  
  public void setHeadDrawableDownListener(URLDrawableDownListener.Adapter paramAdapter)
  {
    this.j.setURLDrawableDownListener(paramAdapter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NewStyleDropdownView
 * JD-Core Version:    0.7.0.1
 */