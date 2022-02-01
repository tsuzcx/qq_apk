package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ReadInJoyTipsView
  extends LinearLayout
{
  public int a = 0;
  private ImageView b;
  private ImageView c;
  private TextView d;
  private RelativeLayout e;
  private View.OnClickListener f;
  
  public ReadInJoyTipsView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    inflate(paramContext, 2131626342, this);
  }
  
  private void a()
  {
    this.b = ((ImageView)findViewById(2131444334));
    this.d = ((TextView)findViewById(2131444337));
    this.c = ((ImageView)findViewById(2131444336));
    this.e = ((RelativeLayout)findViewById(2131444335));
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    a();
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      this.f = paramOnClickListener;
      return;
    }
    this.e.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyTipsView
 * JD-Core Version:    0.7.0.1
 */