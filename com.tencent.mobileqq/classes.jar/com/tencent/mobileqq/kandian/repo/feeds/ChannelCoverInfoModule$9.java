package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ChannelCoverInfoModule$9
  implements Runnable
{
  ChannelCoverInfoModule$9(ChannelCoverInfoModule paramChannelCoverInfoModule, int paramInt, List paramList) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyUIToRefresh channelId=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" ;size = ");
      localStringBuilder.append(this.b.size());
      QLog.d("ChannelCoverInfoModule", 2, localStringBuilder.toString());
    }
    int i = this.a;
    if (i == 0) {
      ReadInJoyLogicEngineEventDispatcher.a().f(true, this.b);
    } else if (i == 56) {
      ReadInJoyLogicEngineEventDispatcher.a().g(true, this.b);
    } else if (i == 41402) {
      ReadInJoyLogicEngineEventDispatcher.a().h(true, this.b);
    }
    ReadInJoyLogicEngineEventDispatcher.a().a(this.a, true, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule.9
 * JD-Core Version:    0.7.0.1
 */