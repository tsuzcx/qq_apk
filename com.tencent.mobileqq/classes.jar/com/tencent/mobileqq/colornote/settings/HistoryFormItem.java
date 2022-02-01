package com.tencent.mobileqq.colornote.settings;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QFormSimpleItem;

public class HistoryFormItem
  extends QFormSimpleItem
{
  private boolean s = false;
  private ImageView t;
  private HistoryFormItem.OnIconClickListener u;
  private int v = 0;
  private boolean w = true;
  
  public HistoryFormItem(Context paramContext)
  {
    super(paramContext);
    e();
  }
  
  public HistoryFormItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    e();
  }
  
  private void e()
  {
    f();
  }
  
  private void f()
  {
    this.t = new ImageView(getContext());
    this.t.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    this.t.setContentDescription(getResources().getString(2131887855));
    setCheckIcon(this.s);
    int i = getResources().getDimensionPixelSize(2131299686);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(11, 1);
    localLayoutParams.addRule(15, 1);
    addView(this.t, localLayoutParams);
    this.t.setOnClickListener(new HistoryFormItem.1(this));
  }
  
  private void setCheckBackground(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setBackgroundResource(2130852504);
      return;
    }
    setBgType(2);
  }
  
  private void setCheckIcon(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.t.setImageResource(2130839420);
      return;
    }
    this.t.setImageResource(2130839419);
  }
  
  protected void a()
  {
    super.a();
    this.r = DisplayUtil.a(getContext(), 290.0F);
  }
  
  public void a(View paramView, boolean paramBoolean)
  {
    setCheckBackground(paramBoolean);
    setCheckIcon(paramBoolean);
  }
  
  public boolean b()
  {
    return this.w;
  }
  
  public int getIndex()
  {
    return this.v;
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.w = paramBoolean;
  }
  
  public void setIndex(int paramInt)
  {
    this.v = paramInt;
  }
  
  public void setItemOnClickListener(View.OnClickListener paramOnClickListener)
  {
    setOnClickListener(paramOnClickListener);
  }
  
  public void setOnIconClickListener(HistoryFormItem.OnIconClickListener paramOnIconClickListener)
  {
    this.u = paramOnIconClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.HistoryFormItem
 * JD-Core Version:    0.7.0.1
 */