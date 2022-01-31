package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;

public class OperationView
  extends FrameLayout
{
  public QQAppInterface a;
  VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  PlayOperationViewModel jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel;
  
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
  
  public PlayOperationViewModel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel = new PlayOperationViewModel(LayoutInflater.from(getContext()).inflate(2130970453, this, true), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(VideoData paramVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.a(paramVideoData);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.a(paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a != 4) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.a();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.b();
  }
  
  public void setCurrentAnchorUin(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.b(paramLong);
    }
  }
  
  public void setOnCloseListener(StuffContainerView.OnCloseListener paramOnCloseListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.a(paramOnCloseListener);
    }
  }
  
  public void setOnCommentClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.a(paramOnClickListener);
    }
  }
  
  public void setVideoPageSource(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.c(paramInt);
  }
  
  public void setWatchCount(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a == 1) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.OperationView
 * JD-Core Version:    0.7.0.1
 */