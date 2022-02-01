package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AutoTemplateTipsView
  extends RelativeLayout
{
  private ImageView a;
  private TextView b;
  
  public AutoTemplateTipsView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AutoTemplateTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AutoTemplateTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131628236, this, true);
    this.a = ((ImageView)findViewById(2131428791));
    this.b = ((TextView)findViewById(2131447246));
  }
  
  public void setContent(int paramInt)
  {
    this.b.setText(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.AutoTemplateTipsView
 * JD-Core Version:    0.7.0.1
 */