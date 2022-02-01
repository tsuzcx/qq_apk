package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.now.view.widget.LikeAniView;
import com.tencent.mobileqq.qroute.QRoute;

class PlayOperationViewModelImpl$3
  implements GestureDetector.OnDoubleTapListener
{
  PlayOperationViewModelImpl$3(PlayOperationViewModelImpl paramPlayOperationViewModelImpl) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (System.currentTimeMillis() - PlayOperationViewModelImpl.access$400(this.a) >= 500L)
    {
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      if ((this.a.mVideoData != null) && (this.a.mVideoData.b != VideoData.a)) {
        ((LikeAniView)this.a.mBinding.findViewById(2131370024)).a(i, j);
      }
      if ((!PlayOperationViewModelImpl.access$500(this.a)) && (!PlayOperationViewModelImpl.access$600(this.a)) && (this.a.mBinding.findViewById(2131370024).getVisibility() == 0))
      {
        PlayOperationViewModelImpl.access$702(this.a, false);
        this.a.onClickLike(null);
        ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_double_click").genderInd1().reportByVideo(this.a.app);
        ThreadManagerV2.excute(new PlayOperationViewModelImpl.3.1(this, (INearbyCardManager)this.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
      }
      PlayOperationViewModelImpl.access$402(this.a, System.currentTimeMillis());
    }
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.3
 * JD-Core Version:    0.7.0.1
 */