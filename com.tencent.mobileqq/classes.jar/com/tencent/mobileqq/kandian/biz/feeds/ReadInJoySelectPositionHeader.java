package com.tencent.mobileqq.kandian.biz.feeds;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ReadInJoySelectPositionHeader
  extends RelativeLayout
{
  private TextView a;
  private TextView b;
  private RelativeLayout c;
  private ReadInJoySelectPositionHeader.ISelectCityListener d;
  
  public ReadInJoySelectPositionHeader(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ReadInJoySelectPositionHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ReadInJoySelectPositionHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131626324, this, true);
    this.a = ((TextView)localView.findViewById(2131445554));
    this.b = ((TextView)localView.findViewById(2131434333));
    this.c = ((RelativeLayout)localView.findViewById(2131434334));
    this.c.setOnClickListener(new ReadInJoySelectPositionHeader.1(this, paramContext));
  }
  
  public void setGPSCity(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void setSelectCityListener(ReadInJoySelectPositionHeader.ISelectCityListener paramISelectCityListener)
  {
    this.d = paramISelectCityListener;
  }
  
  public void setSelectedCity(String paramString)
  {
    this.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadInJoySelectPositionHeader
 * JD-Core Version:    0.7.0.1
 */