package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.now.view.widget.LikeAniView;

class PlayOperationViewModel$3
  implements GestureDetector.OnDoubleTapListener
{
  PlayOperationViewModel$3(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (System.currentTimeMillis() - PlayOperationViewModel.a(this.a) >= 500L)
    {
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      if ((this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null) && (this.a.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a != 6)) {
        ((LikeAniView)this.a.jdField_a_of_type_AndroidViewView.findViewById(2131370357)).a(i, j);
      }
      if (!PlayOperationViewModel.a(this.a)) {
        break label98;
      }
    }
    for (;;)
    {
      PlayOperationViewModel.a(this.a, System.currentTimeMillis());
      return true;
      label98:
      if ((!PlayOperationViewModel.b(this.a)) && (this.a.jdField_a_of_type_AndroidViewView.findViewById(2131370357).getVisibility() == 0))
      {
        PlayOperationViewModel.a(this.a, false);
        this.a.c(null);
        new NowVideoReporter().h("video").i("playpage_double_click").b().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        ThreadManagerV2.excute(new PlayOperationViewModel.3.1(this, (NearbyCardManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.3
 * JD-Core Version:    0.7.0.1
 */