package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class DropdownView
  extends RelativeLayout
  implements PopupWindow.OnDismissListener
{
  DropdownView.AutoCompleteView a;
  Drawable b;
  Drawable c;
  boolean d = false;
  InputMethodManager e;
  private ImageView f;
  private ImageView g;
  private final RelativeLayout.LayoutParams h = new RelativeLayout.LayoutParams(-1, -1);
  private float i;
  private Context j;
  
  public DropdownView(Context paramContext)
  {
    super(paramContext);
    this.j = paramContext;
    this.a = new DropdownView.AutoCompleteView(this, paramContext);
    a(paramContext);
  }
  
  public DropdownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = new DropdownView.AutoCompleteView(this, paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  @TargetApi(11)
  public DropdownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = new DropdownView.AutoCompleteView(this, paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.e = ((InputMethodManager)paramContext.getSystemService("input_method"));
    this.i = paramContext.getResources().getDisplayMetrics().density;
    setLayoutParams(this.h);
    setPadding(0, 0, 0, 0);
    Object localObject1 = new RelativeLayout.LayoutParams(this.h);
    addView(this.a, (ViewGroup.LayoutParams)localObject1);
    this.a.setDropDownVerticalOffset(0);
    localObject1 = new LinearLayout(paramContext);
    new RelativeLayout.LayoutParams(this.h);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -1);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(0, 0, 0, 0);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(7, this.a.getId());
    addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.g = new ImageView(paramContext);
    localObject2 = this.g;
    float f1 = this.i;
    ((ImageView)localObject2).setPadding((int)(f1 * 10.0F), (int)(f1 * 10.0F), (int)(f1 * 15.0F), (int)(f1 * 10.0F));
    this.g.setImageResource(2130839566);
    this.g.setClickable(true);
    this.g.setVisibility(8);
    this.g.setContentDescription(HardCodeUtil.a(2131901657));
    new LinearLayout.LayoutParams(this.h);
    f1 = this.i;
    localObject2 = new LinearLayout.LayoutParams((int)(44.0F * f1), (int)(f1 * 39.0F));
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    ((LinearLayout)localObject1).addView(this.g, (ViewGroup.LayoutParams)localObject2);
    this.f = new ImageView(paramContext);
    this.f.setId(571);
    paramContext = this.f;
    f1 = this.i;
    paramContext.setPadding((int)(1.0F * f1), (int)(f1 * 10.0F), (int)(15.0F * f1), (int)(f1 * 10.0F));
    this.f.setContentDescription(HardCodeUtil.a(2131901658));
    this.b = getResources().getDrawable(2130841452);
    this.c = getResources().getDrawable(2130841453);
    this.f.setImageDrawable(this.b);
    this.f.setClickable(true);
    f1 = this.i;
    paramContext = new LinearLayout.LayoutParams((int)(35.0F * f1), (int)(f1 * 33.0F));
    paramContext.gravity = 16;
    ((LinearLayout)localObject1).addView(this.f, paramContext);
    this.f.setOnClickListener(new DropdownView.1(this));
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
  
  public ImageView getDelIcon()
  {
    return this.g;
  }
  
  public ImageView getDropDownIcon()
  {
    return this.f;
  }
  
  public AutoCompleteTextView getView()
  {
    return this.a;
  }
  
  public void onDismiss()
  {
    this.f.setImageDrawable(this.b);
    new Handler().postDelayed(new DropdownView.2(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DropdownView
 * JD-Core Version:    0.7.0.1
 */