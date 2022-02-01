package com.tencent.mobileqq.nearby.now.view.viewmodel.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.qroute.QRoute;

class PlayOperationViewModelImpl$10
  implements View.OnClickListener
{
  PlayOperationViewModelImpl$10(PlayOperationViewModelImpl paramPlayOperationViewModelImpl) {}
  
  public void onClick(View paramView)
  {
    this.a.onClickShare(paramView);
    ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opType("video").opName("playpage_fw_click").LvInd1().reportByVideo(this.a.app);
    ThreadManagerV2.excute(new PlayOperationViewModelImpl.10.1(this, (INearbyCardManager)this.a.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.impl.PlayOperationViewModelImpl.10
 * JD-Core Version:    0.7.0.1
 */