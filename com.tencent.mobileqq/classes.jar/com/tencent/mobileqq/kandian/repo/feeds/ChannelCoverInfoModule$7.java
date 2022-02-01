package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ChannelCoverInfoModule$7
  implements Runnable
{
  ChannelCoverInfoModule$7(ChannelCoverInfoModule paramChannelCoverInfoModule, int paramInt) {}
  
  public void run()
  {
    List localList = ChannelCoverInfoModule.a(this.this$0, this.a);
    if ((localList != null) && (localList.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadChannelCoverListFromDB size = ");
      localStringBuilder.append(localList.size());
      localStringBuilder.append("\n");
      localStringBuilder = new StringBuilder(localStringBuilder.toString());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
        if (QLog.isColorLevel())
        {
          localStringBuilder.append("[channelCoverId=");
          localStringBuilder.append(localChannelCoverInfo.mChannelCoverId);
          localStringBuilder.append(", mChannelCoverName=");
          localStringBuilder.append(localChannelCoverInfo.mChannelCoverName);
          localStringBuilder.append(", mChannelCoverStyle=");
          localStringBuilder.append(localChannelCoverInfo.mChannelCoverStyle);
          localStringBuilder.append(", mChannelCoverSummary=");
          localStringBuilder.append(localChannelCoverInfo.mChannelCoverSummary);
          localStringBuilder.append(", mChannelCoverPicUrl=");
          localStringBuilder.append(localChannelCoverInfo.mChannelCoverPicUrl);
          localStringBuilder.append(", mChannelJumpUrl=");
          localStringBuilder.append(localChannelCoverInfo.mChannelJumpUrl);
          localStringBuilder.append(", mArticleIds=");
          localStringBuilder.append(localChannelCoverInfo.mArticleId);
          localStringBuilder.append(", mChannelType=");
          localStringBuilder.append(localChannelCoverInfo.mChannelType);
          localStringBuilder.append("]\n");
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, localStringBuilder.toString());
      }
      this.this$0.d(localList, this.a);
      this.this$0.f(localList, this.a);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "loadChannelCoverListFromDB list is null");
    }
    int i = this.a;
    if (i == 41402) {
      this.this$0.a(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule.7
 * JD-Core Version:    0.7.0.1
 */