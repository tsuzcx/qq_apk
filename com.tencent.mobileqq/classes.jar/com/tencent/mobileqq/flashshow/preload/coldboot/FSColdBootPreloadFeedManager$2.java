package com.tencent.mobileqq.flashshow.preload.coldboot;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import feedcloud.FeedCloudRead.StGetFeedListRsp;
import qqcircle.QQCircleFeedBase.StFeedListBusiRspData;

class FSColdBootPreloadFeedManager$2
  implements Runnable
{
  FSColdBootPreloadFeedManager$2(FSColdBootPreloadFeedManager paramFSColdBootPreloadFeedManager, FeedCloudRead.StGetFeedListRsp paramStGetFeedListRsp) {}
  
  public void run()
  {
    if (this.a.busiRspData.has())
    {
      QQCircleFeedBase.StFeedListBusiRspData localStFeedListBusiRspData = new QQCircleFeedBase.StFeedListBusiRspData();
      try
      {
        localStFeedListBusiRspData.mergeFrom(this.a.busiRspData.get().toByteArray());
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        localInvalidProtocolBufferMicroException.printStackTrace();
      }
      if (localStFeedListBusiRspData.rspExpireAt.has()) {
        FSColdBootPreloadFeedManager.access$102(this.this$0, localStFeedListBusiRspData.rspExpireAt.get() * 1000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.preload.coldboot.FSColdBootPreloadFeedManager.2
 * JD-Core Version:    0.7.0.1
 */