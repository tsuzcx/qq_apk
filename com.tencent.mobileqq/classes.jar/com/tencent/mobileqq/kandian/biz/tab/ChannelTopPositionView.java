package com.tencent.mobileqq.kandian.biz.tab;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class ChannelTopPositionView
  extends RelativeLayout
{
  private Context a;
  private RelativeLayout b;
  private View.OnClickListener c = new ChannelTopPositionView.1(this);
  
  public ChannelTopPositionView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public ChannelTopPositionView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(this.a).inflate(2131626015, this, true);
    b();
    c();
  }
  
  private void b()
  {
    this.b = ((RelativeLayout)findViewById(2131440533));
  }
  
  private void c()
  {
    this.b.setOnClickListener(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ChannelTopPositionView
 * JD-Core Version:    0.7.0.1
 */