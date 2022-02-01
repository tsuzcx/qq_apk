package com.tencent.mobileqq.hotpic;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import mqq.os.MqqHandler;

class HotPicPageView$4
  implements TVK_SDKMgr.InstallListener
{
  HotPicPageView$4(HotPicPageView paramHotPicPageView, HotPicPageView.MyVideoViewHolder paramMyVideoViewHolder, int paramInt) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    ThreadManager.getUIHandler().post(new HotPicPageView.4.2(this));
    if (QLog.isColorLevel()) {
      QLog.d("HotPicManagerHotPicPageView", 2, "tencent sdk onInstalledFail");
    }
  }
  
  public void onInstalledSuccessed()
  {
    this.jdField_a_of_type_ComTencentMobileqqHotpicHotPicPageView.d = false;
    new Thread(new HotPicPageView.4.1(this)).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicPageView.4
 * JD-Core Version:    0.7.0.1
 */