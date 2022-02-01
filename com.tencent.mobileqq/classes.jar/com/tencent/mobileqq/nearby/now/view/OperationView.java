package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.viewmodel.IPlayOperationViewModel;
import com.tencent.mobileqq.qroute.QRoute;

public class OperationView
  extends FrameLayout
{
  public AppInterface a;
  VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  IPlayOperationViewModel jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelIPlayOperationViewModel;
  
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
  
  public IPlayOperationViewModel a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelIPlayOperationViewModel;
  }
  
  public void a()
  {
    View localView = LayoutInflater.from(getContext()).inflate(((IResourceUtil)QRoute.api(IResourceUtil.class)).getQQNearbyNowLayoutVideoOperator(), this, true);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelIPlayOperationViewModel = ((IPlayOperationViewModel)QRoute.api(IPlayOperationViewModel.class)).init(localView, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
  }
  
  public void a(VideoData paramVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelIPlayOperationViewModel.updateShowInfo(paramVideoData);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelIPlayOperationViewModel.showIfCan(paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.b != 4) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelIPlayOperationViewModel.initCommentsWidget();
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelIPlayOperationViewModel.destroy();
  }
  
  public void setCurrentAnchorUin(long paramLong)
  {
    IPlayOperationViewModel localIPlayOperationViewModel = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelIPlayOperationViewModel;
    if (localIPlayOperationViewModel != null) {
      localIPlayOperationViewModel.setCurrentAnchorUin(paramLong);
    }
  }
  
  public void setOnCloseListener(Object paramObject)
  {
    IPlayOperationViewModel localIPlayOperationViewModel = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelIPlayOperationViewModel;
    if (localIPlayOperationViewModel != null) {
      localIPlayOperationViewModel.setOnCloseListener(paramObject);
    }
  }
  
  public void setOnCommentClickListener(View.OnClickListener paramOnClickListener)
  {
    IPlayOperationViewModel localIPlayOperationViewModel = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelIPlayOperationViewModel;
    if (localIPlayOperationViewModel != null) {
      localIPlayOperationViewModel.setOnCommentClickListener(paramOnClickListener);
    }
  }
  
  public void setVideoPageSource(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelIPlayOperationViewModel.setVideoPageSource(paramInt);
  }
  
  public void setWatchCount(int paramInt)
  {
    VideoData localVideoData = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
    if (localVideoData == null) {
      return;
    }
    if (localVideoData.b == 1) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelIPlayOperationViewModel.setWatchCount(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.OperationView
 * JD-Core Version:    0.7.0.1
 */