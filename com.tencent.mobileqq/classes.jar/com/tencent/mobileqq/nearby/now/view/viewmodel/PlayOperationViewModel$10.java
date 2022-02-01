package com.tencent.mobileqq.nearby.now.view.viewmodel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PlayOperationViewModel$10
  implements View.OnClickListener
{
  PlayOperationViewModel$10(PlayOperationViewModel paramPlayOperationViewModel) {}
  
  public void onClick(View paramView)
  {
    this.a.f(paramView);
    new NowVideoReporter().h("video").i("playpage_fw_click").a().a(this.a.a);
    ThreadManagerV2.excute(new PlayOperationViewModel.10.1(this, (NearbyCardManager)this.a.a.getManager(QQManagerFactory.NEARBY_CARD_MANAGER)), 16, null, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel.10
 * JD-Core Version:    0.7.0.1
 */