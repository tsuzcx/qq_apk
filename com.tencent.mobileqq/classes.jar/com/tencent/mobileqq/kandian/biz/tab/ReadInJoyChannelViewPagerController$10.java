package com.tencent.mobileqq.kandian.biz.tab;

import com.tencent.biz.widgets.TabLayout;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import java.util.List;

class ReadInJoyChannelViewPagerController$10
  implements Runnable
{
  ReadInJoyChannelViewPagerController$10(ReadInJoyChannelViewPagerController paramReadInJoyChannelViewPagerController, int paramInt) {}
  
  public void run()
  {
    ReadInJoyChannelViewPagerController.b(this.this$0, true);
    ReadInJoyChannelViewPagerController.g(this.this$0).setSwappingAnimation();
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)ReadInJoyChannelViewPagerController.n(this.this$0).get(this.a);
    ReadInJoyChannelViewPagerController.b(this.this$0, localTabChannelCoverInfo);
    ReadInJoyChannelViewPagerController.o(this.this$0).a(localTabChannelCoverInfo.mChannelCoverId, 4, false, true);
    ReadInJoyChannelViewPagerController.a(this.this$0).setCurrentItem(ReadInJoyChannelViewPagerController.c, false);
    ReadInJoyChannelViewPagerController.g(this.this$0).a(this.a, ReadInJoyChannelViewPagerController.c, new ReadInJoyChannelViewPagerController.10.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController.10
 * JD-Core Version:    0.7.0.1
 */