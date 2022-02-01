package com.tencent.mobileqq.flashshow.presenter.feed;

import android.widget.TextView;
import com.tencent.biz.richframework.util.RFWTypefaceUtil;
import com.tencent.mobileqq.flashshow.utils.DateUtils;
import com.tencent.superplayer.api.ISuperPlayer;

class FSFeedChildVideoPresenter$3
  implements Runnable
{
  FSFeedChildVideoPresenter$3(FSFeedChildVideoPresenter paramFSFeedChildVideoPresenter, ISuperPlayer paramISuperPlayer) {}
  
  public void run()
  {
    if (FSFeedChildVideoPresenter.g(this.this$0) != null)
    {
      RFWTypefaceUtil.a(FSFeedChildVideoPresenter.g(this.this$0), false);
      FSFeedChildVideoPresenter.g(this.this$0).setText(DateUtils.a((int)this.a.getDurationMs()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.presenter.feed.FSFeedChildVideoPresenter.3
 * JD-Core Version:    0.7.0.1
 */