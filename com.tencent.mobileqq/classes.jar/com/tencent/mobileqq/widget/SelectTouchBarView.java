package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;

public class SelectTouchBarView
  extends RelativeLayout
{
  protected TextView a;
  protected CharSequence b;
  protected int c;
  protected MutliSeletedBottomLine d;
  protected MutliSeletedBottomLine e;
  private Context f;
  private int g = -1;
  
  public SelectTouchBarView(Context paramContext)
  {
    super(paramContext);
    this.f = paramContext;
    LayoutInflater.from(paramContext).inflate(2131624132, this);
    this.a = ((TextView)findViewById(2131428093));
    a((RelativeLayout)findViewById(2131428092));
  }
  
  public SelectTouchBarView a(int paramInt)
  {
    this.c = paramInt;
    if (paramInt <= 0) {
      this.c = 0;
    }
    setMinimumHeight(this.c);
    return this;
  }
  
  public SelectTouchBarView a(CharSequence paramCharSequence)
  {
    if ((this.a != null) && (!TextUtils.isEmpty(paramCharSequence)))
    {
      this.b = paramCharSequence;
      this.a.setText(paramCharSequence);
      this.a.setContentDescription(paramCharSequence);
    }
    return this;
  }
  
  public void a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)findViewById(2131428092);
    localRelativeLayout.removeView(this.d);
    localRelativeLayout.removeView(this.e);
    a(localRelativeLayout);
    invalidate();
  }
  
  protected void a(RelativeLayout paramRelativeLayout)
  {
    int i = (int)DeviceInfoUtil.a(true);
    int j = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.a.measure(j, j);
    j = (i - this.a.getMeasuredWidth() - DisplayUtil.a(this.f, 16.0F)) / 2;
    i = j;
    if (j < 0) {
      i = 0;
    }
    this.d = new MutliSeletedBottomLine(this.f, i, false);
    this.e = new MutliSeletedBottomLine(this.f, i, true);
    RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(i, -2);
    localLayoutParams1.addRule(9);
    RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(i, -2);
    localLayoutParams2.addRule(11);
    paramRelativeLayout.addView(this.d, localLayoutParams1);
    paramRelativeLayout.addView(this.e, localLayoutParams2);
  }
  
  public SelectTouchBarView b()
  {
    if (this.c <= 0) {
      this.c = 30;
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    localLayoutParams.height = this.c;
    localLayoutParams.width = -1;
    setLayoutParams(localLayoutParams);
    a();
    return this;
  }
  
  public void setCheckedNum(int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (paramInt == 0)
    {
      localStringBuilder1.append("选择到这里");
    }
    else
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("选择到这里(已选");
      localStringBuilder2.append(paramInt);
      localStringBuilder2.append("条)");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    this.a.setText(localStringBuilder1.toString());
    this.a.setContentDescription(localStringBuilder1.toString());
    a();
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.SelectTouchBarView
 * JD-Core Version:    0.7.0.1
 */