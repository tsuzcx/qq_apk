package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.ViewUtils;

public class FormMultiLineSwitchItem
  extends FormSwitchItem
{
  TextView a;
  TextView b;
  String c;
  
  public FormMultiLineSwitchItem(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FormMultiLineSwitchItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e = false;
    this.c = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.FormItem).getString(21);
    b();
  }
  
  private void b()
  {
    this.a = getTextView();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
    localLayoutParams.addRule(15, 0);
    localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131297089);
    this.a.setLayoutParams(localLayoutParams);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    this.b = new TextView(getContext());
    if (!TextUtils.isEmpty(this.c)) {
      this.b.setText(this.c);
    }
    if ((AppSetting.e) && (Build.VERSION.SDK_INT >= 16))
    {
      AccessibilityUtil.a(this.b, false);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.getText());
      localStringBuilder.append(" ");
      localStringBuilder.append(this.c);
      setContentDescription(localStringBuilder.toString());
    }
    this.b.setSingleLine(false);
    this.b.setDuplicateParentStateEnabled(true);
    int i = ViewUtils.getScreenWidth();
    int j = ViewUtils.dip2px(96.0F);
    this.b.setMaxWidth(i - j);
    localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131297078);
    localLayoutParams.bottomMargin = getResources().getDimensionPixelOffset(2131297084);
    localLayoutParams.leftMargin = getResources().getDimensionPixelSize(2131298976);
    localLayoutParams.addRule(3, 2131433633);
    i = getResources().getDimensionPixelSize(2131297104);
    this.b.setTextColor(getResources().getColorStateList(2131168118));
    this.b.setTextSize(0, i);
    this.b.setGravity(19);
    addView(this.b, localLayoutParams);
  }
  
  public void setSecendLineClick(View.OnClickListener paramOnClickListener)
  {
    this.b.setOnClickListener(paramOnClickListener);
  }
  
  public void setSecendLineText(Spanned paramSpanned)
  {
    this.b.setText(paramSpanned);
    if ((AppSetting.e) && (Build.VERSION.SDK_INT >= 16))
    {
      paramSpanned = new StringBuilder();
      paramSpanned.append(this.a.getText());
      paramSpanned.append(" ");
      paramSpanned.append(this.c);
      setContentDescription(paramSpanned.toString());
    }
  }
  
  public void setSecendLineText(String paramString)
  {
    this.b.setText(paramString);
    if ((AppSetting.e) && (Build.VERSION.SDK_INT >= 16))
    {
      paramString = new StringBuilder();
      paramString.append(this.a.getText());
      paramString.append(" ");
      paramString.append(this.c);
      setContentDescription(paramString.toString());
    }
  }
  
  public void setSecondLineTextViewVisibility(int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(paramInt);
      localObject = (RelativeLayout.LayoutParams)this.a.getLayoutParams();
      if (paramInt == 8)
      {
        setMinimumHeight(getResources().getDimensionPixelSize(2131297097));
        ((RelativeLayout.LayoutParams)localObject).addRule(15, -1);
        return;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(15, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FormMultiLineSwitchItem
 * JD-Core Version:    0.7.0.1
 */