package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.qroute.QRoute;

class PlayOperationViewModelImpl$8
  implements View.OnClickListener
{
  PlayOperationViewModelImpl$8(PlayOperationViewModelImpl paramPlayOperationViewModelImpl) {}
  
  public void onClick(View paramView)
  {
    this.a.onClickPublishComment(paramView);
    ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportTrendDetailCommentClick(this.a.app, String.valueOf(this.a.mVideoData.i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.8
 * JD-Core Version:    0.7.0.1
 */