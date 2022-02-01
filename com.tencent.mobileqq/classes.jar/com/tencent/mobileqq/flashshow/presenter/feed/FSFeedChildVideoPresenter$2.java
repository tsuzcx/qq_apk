package com.tencent.mobileqq.flashshow.presenter.feed;

import com.tencent.mobileqq.flashshow.player.widget.FSBaseVideoView.InitListener;
import com.tencent.mobileqq.flashshow.player.widget.FSVideoView;
import com.tencent.qphone.base.util.QLog;

class FSFeedChildVideoPresenter$2
  implements FSBaseVideoView.InitListener
{
  FSFeedChildVideoPresenter$2(FSFeedChildVideoPresenter paramFSFeedChildVideoPresenter, String paramString) {}
  
  public void a()
  {
    FSFeedChildVideoPresenter.c(this.b).setBaseVideoViewListenerSets(new FSFeedChildVideoPresenter.2.1(this));
    FSFeedChildVideoPresenter.c(this.b).setProgressBar(FSFeedChildVideoPresenter.b(this.b));
    FSFeedChildVideoPresenter.c(this.b).setLoadingView(FSFeedChildVideoPresenter.d(this.b));
    FSFeedChildVideoPresenter.c(this.b).setVideoCover(FSFeedChildVideoPresenter.e(this.b));
    FSFeedChildVideoPresenter.c(this.b).setLoopBack(true);
    FSFeedChildVideoPresenter.c(this.b).setOutPutMute(FSFeedChildVideoPresenter.f(this.b));
    QLog.d("FSFeedChildVideoPresenter", 1, "onInitSuccess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildVideoPresenter.2
 * JD-Core Version:    0.7.0.1
 */