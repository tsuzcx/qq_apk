package com.tencent.mobileqq.vas.adv.qzone.logic;

import android.os.Handler;
import com.tencent.mobileqq.vas.adv.common.data.AlumBasicData;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;

class AdVideoViewController$4
  implements Runnable
{
  AdVideoViewController$4(AdVideoViewController paramAdVideoViewController, AlumBasicData paramAlumBasicData, BaseVideoView paramBaseVideoView) {}
  
  public void run()
  {
    if ((AdVideoViewController.a(this.this$0, this.a)) && (AdVideoViewController.j(this.this$0) != null)) {
      AdVideoViewController.j(this.this$0).post(new AdVideoViewController.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.qzone.logic.AdVideoViewController.4
 * JD-Core Version:    0.7.0.1
 */