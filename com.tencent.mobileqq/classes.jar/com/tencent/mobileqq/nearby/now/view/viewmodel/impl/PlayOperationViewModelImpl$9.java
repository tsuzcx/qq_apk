package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.newnearby.INearbyReportHelper;
import com.tencent.mobileqq.qroute.QRoute;

class PlayOperationViewModelImpl$9
  implements View.OnClickListener
{
  PlayOperationViewModelImpl$9(PlayOperationViewModelImpl paramPlayOperationViewModelImpl) {}
  
  public void onClick(View paramView)
  {
    this.a.onClickLike(paramView);
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_like_click").genderInd1().reportByVideo(this.a.app);
    ThreadManagerV2.excute(new PlayOperationViewModelImpl.9.1(this, (INearbyCardManager)this.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
    ((INearbyReportHelper)QRoute.api(INearbyReportHelper.class)).reportTrendDetailLikeClick(this.a.app, String.valueOf(this.a.mVideoData.i));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.9
 * JD-Core Version:    0.7.0.1
 */