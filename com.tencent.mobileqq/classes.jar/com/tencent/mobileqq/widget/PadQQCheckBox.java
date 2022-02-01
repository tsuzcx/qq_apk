package com.tencent.mobileqq.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class PadQQCheckBox
  extends LinearLayout
  implements View.OnClickListener
{
  private ImageView a;
  private TextView b;
  private boolean c;
  private CharSequence d;
  
  public PadQQCheckBox(Context paramContext)
  {
    super(paramContext);
  }
  
  public PadQQCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bY);
    this.c = paramAttributeSet.getBoolean(R.styleable.bZ, true);
    this.d = paramAttributeSet.getString(R.styleable.ca);
    LayoutInflater.from(paramContext).inflate(2131625556, this, true);
    this.a = ((ImageView)findViewById(2131430670));
    this.b = ((TextView)findViewById(2131430683));
    setChecked(this.c);
    this.b.setText(this.d);
    paramAttributeSet.recycle();
    setOnClickListener(this);
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public void onClick(View paramView)
  {
    setChecked(this.c ^ true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @TargetApi(14)
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    int i;
    if (this.c) {
      i = 2131905687;
    } else {
      i = 2131905686;
    }
    String str = HardCodeUtil.a(i);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.d);
    localStringBuilder.append(str);
    paramAccessibilityNodeInfo.setContentDescription(localStringBuilder.toString());
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.c = paramBoolean;
    if (this.c) {
      this.a.setImageResource(2130841442);
    } else {
      this.a.setImageResource(2130841440);
    }
    refreshDrawableState();
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    if ((this.b != null) && (!TextUtils.isEmpty(paramCharSequence)))
    {
      this.d = paramCharSequence;
      this.b.setText(paramCharSequence);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PadQQCheckBox
 * JD-Core Version:    0.7.0.1
 */