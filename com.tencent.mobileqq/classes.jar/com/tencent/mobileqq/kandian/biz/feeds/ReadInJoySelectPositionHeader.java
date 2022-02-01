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
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoySelectPositionHeader.ISelectCityListener jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoySelectPositionHeader$ISelectCityListener;
  private TextView b;
  
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
    View localView = LayoutInflater.from(paramContext).inflate(2131560277, this, true);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131377176));
    this.b = ((TextView)localView.findViewById(2131367766));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131367767));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new ReadInJoySelectPositionHeader.1(this, paramContext));
  }
  
  public void setGPSCity(String paramString)
  {
    this.b.setText(paramString);
  }
  
  public void setSelectCityListener(ReadInJoySelectPositionHeader.ISelectCityListener paramISelectCityListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFeedsReadInJoySelectPositionHeader$ISelectCityListener = paramISelectCityListener;
  }
  
  public void setSelectedCity(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.ReadInJoySelectPositionHeader
 * JD-Core Version:    0.7.0.1
 */