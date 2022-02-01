package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import ayfx;
import ayhj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;

public class OperationView
  extends FrameLayout
{
  ayhj jdField_a_of_type_Ayhj;
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
  
  public ayhj a()
  {
    return this.jdField_a_of_type_Ayhj;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Ayhj = new ayhj(LayoutInflater.from(getContext()).inflate(2131561323, this, true), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(VideoData paramVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    this.jdField_a_of_type_Ayhj.a(paramVideoData);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) {
      return;
    }
    this.jdField_a_of_type_Ayhj.a(paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a != 4) {
      this.jdField_a_of_type_Ayhj.a();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Ayhj.b();
  }
  
  public void setCurrentAnchorUin(long paramLong)
  {
    if (this.jdField_a_of_type_Ayhj != null) {
      this.jdField_a_of_type_Ayhj.b(paramLong);
    }
  }
  
  public void setOnCloseListener(ayfx paramayfx)
  {
    if (this.jdField_a_of_type_Ayhj != null) {
      this.jdField_a_of_type_Ayhj.a(paramayfx);
    }
  }
  
  public void setOnCommentClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_Ayhj != null) {
      this.jdField_a_of_type_Ayhj.a(paramOnClickListener);
    }
  }
  
  public void setVideoPageSource(int paramInt)
  {
    this.jdField_a_of_type_Ayhj.c(paramInt);
  }
  
  public void setWatchCount(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a == 1) {
      return;
    }
    this.jdField_a_of_type_Ayhj.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.OperationView
 * JD-Core Version:    0.7.0.1
 */