package com.tencent.mobileqq.kandian.biz.tab;

import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter;
import com.tencent.mobileqq.kandian.biz.framework.util.RIJChannelViewpagerEnterPathHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

class ReadInJoyChannelViewPagerController$4
  extends ReadInJoyObserver
{
  ReadInJoyChannelViewPagerController$4(ReadInJoyChannelViewPagerController paramReadInJoyChannelViewPagerController) {}
  
  public void a(float paramFloat, int paramInt)
  {
    super.a(paramFloat, paramInt);
    paramFloat /= paramInt;
    ReadInJoyChannelViewPagerController.f(this.a).setY((1.0F - paramFloat) * ReadInJoyChannelViewPagerController.f(this.a).getHeight() * 0.03F);
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    super.a(paramTabChannelCoverInfo);
    if (paramTabChannelCoverInfo != null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "onChannelTabSelected, channelID = ", Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), ", channelName = ", paramTabChannelCoverInfo.mChannelCoverName });
      RIJChannelViewpagerEnterPathHelper.a().put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), Integer.valueOf(1));
      this.a.c(paramTabChannelCoverInfo.mChannelCoverId);
      ReadInJoyChannelViewPagerController.d(this.a);
      if (ReadInJoyHelper.S())
      {
        ReadInJoyChannelViewPagerController.b(this.a, paramTabChannelCoverInfo);
        ReadInJoyChannelViewPagerController localReadInJoyChannelViewPagerController = this.a;
        ReadInJoyChannelViewPagerController.c(localReadInJoyChannelViewPagerController, ReadInJoyChannelViewPagerController.b(localReadInJoyChannelViewPagerController, ReadInJoyChannelViewPagerController.e(localReadInJoyChannelViewPagerController)));
      }
      RIJChannelReporter.a(paramTabChannelCoverInfo.mChannelCoverId, "303");
    }
  }
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramInt, paramList, paramBoolean2);
    paramInt = this.a.j();
    ReadInJoyChannelViewPagerController.b(this.a, paramInt);
    ReadInJoyChannelViewPagerController.g(this.a).a();
  }
  
  public void b(boolean paramBoolean)
  {
    ReadInJoyChannelViewPagerController.a(this.a, paramBoolean);
    boolean bool = ChannelModeConfigHandler.a();
    int i = 8;
    if (!bool)
    {
      ImageView localImageView = ReadInJoyChannelViewPagerController.c(this.a);
      if (paramBoolean) {
        i = 0;
      }
      localImageView.setVisibility(i);
      return;
    }
    ReadInJoyChannelViewPagerController.c(this.a).setVisibility(8);
  }
  
  public void cE_()
  {
    super.cE_();
  }
  
  public void e(boolean paramBoolean, List<TabChannelCoverInfo> paramList)
  {
    int i = 0;
    if (paramList != null) {
      i = paramList.size();
    }
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onIndependentMainChannelListupdate, success = ", Boolean.valueOf(paramBoolean), ", size = ", Integer.valueOf(i) });
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      ReadInJoyChannelViewPagerController.a(this.a, paramList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController.4
 * JD-Core Version:    0.7.0.1
 */