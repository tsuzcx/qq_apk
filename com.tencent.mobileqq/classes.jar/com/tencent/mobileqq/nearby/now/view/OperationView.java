package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import avft;
import avhf;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;

public class OperationView
  extends FrameLayout
{
  avhf jdField_a_of_type_Avhf;
  public QQAppInterface a;
  VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  
  public OperationView(Context paramContext)
  {
    super(paramContext);
  }
  
  public OperationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OperationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public avhf a()
  {
    return this.jdField_a_of_type_Avhf;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Avhf = new avhf(LayoutInflater.from(getContext()).inflate(2131561074, this, true), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(VideoData paramVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    this.jdField_a_of_type_Avhf.a(paramVideoData);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) {
      return;
    }
    this.jdField_a_of_type_Avhf.a(paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a != 4) {
      this.jdField_a_of_type_Avhf.a();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Avhf.b();
  }
  
  public void setCurrentAnchorUin(long paramLong)
  {
    if (this.jdField_a_of_type_Avhf != null) {
      this.jdField_a_of_type_Avhf.b(paramLong);
    }
  }
  
  public void setOnCloseListener(avft paramavft)
  {
    if (this.jdField_a_of_type_Avhf != null) {
      this.jdField_a_of_type_Avhf.a(paramavft);
    }
  }
  
  public void setOnCommentClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Avhf != null) {
      this.jdField_a_of_type_Avhf.a(paramOnClickListener);
    }
  }
  
  public void setVideoPageSource(int paramInt)
  {
    this.jdField_a_of_type_Avhf.c(paramInt);
  }
  
  public void setWatchCount(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a == 1) {
      return;
    }
    this.jdField_a_of_type_Avhf.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.OperationView
 * JD-Core Version:    0.7.0.1
 */