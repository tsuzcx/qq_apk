package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;

public class QQStoryVideoPlayerErrorView
  extends FrameLayout
{
  protected TextView a;
  protected TextView b;
  
  public QQStoryVideoPlayerErrorView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public QQStoryVideoPlayerErrorView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public void a()
  {
    this.a.setText(HardCodeUtil.a(2131711064));
    this.a.setVisibility(0);
    this.b.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    this.b.setVisibility(0);
    this.a.setVisibility(8);
  }
  
  public void a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559619, this, true);
    this.a = ((TextView)paramContext.findViewById(2131377011));
    this.b = ((TextView)paramContext.findViewById(2131379394));
  }
  
  public void setOnRetryClickListener(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
    this.b.setOnClickListener(paramOnClickListener);
  }
  
  public void setText(String paramString)
  {
    this.b.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.QQStoryVideoPlayerErrorView
 * JD-Core Version:    0.7.0.1
 */