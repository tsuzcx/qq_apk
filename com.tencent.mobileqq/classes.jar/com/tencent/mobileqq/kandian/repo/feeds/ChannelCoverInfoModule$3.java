package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.util.JSONUtils;
import org.json.JSONObject;

class ChannelCoverInfoModule$3
  implements Runnable
{
  ChannelCoverInfoModule$3(ChannelCoverInfoModule paramChannelCoverInfoModule, TabChannelCoverInfo paramTabChannelCoverInfo) {}
  
  public void run()
  {
    if (this.a.redPoint != null)
    {
      TabChannelCoverInfo localTabChannelCoverInfo = this.a;
      localTabChannelCoverInfo.redPointJson = JSONUtils.a(localTabChannelCoverInfo.redPoint).toString();
    }
    this.this$0.updateEntity(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule.3
 * JD-Core Version:    0.7.0.1
 */