package com.tencent.mobileqq.flashshow.data.update;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.richframework.data.idata.IDataConverter;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StLike;

public class FSFeedConverter
  implements IDataConverter<FeedCloudMeta.StFeed>
{
  private void b(FeedCloudMeta.StFeed paramStFeed1, FeedCloudMeta.StFeed paramStFeed2)
  {
    if (paramStFeed2.commentCount.has()) {
      paramStFeed1.commentCount.set(paramStFeed2.commentCount.get());
    }
  }
  
  private void c(FeedCloudMeta.StFeed paramStFeed1, FeedCloudMeta.StFeed paramStFeed2)
  {
    if (paramStFeed2.likeInfo.has()) {
      paramStFeed1.likeInfo.set(paramStFeed2.likeInfo.get());
    }
  }
  
  public String a(FeedCloudMeta.StFeed paramStFeed)
  {
    return paramStFeed.id.get();
  }
  
  public void a(FeedCloudMeta.StFeed paramStFeed1, FeedCloudMeta.StFeed paramStFeed2)
  {
    b(paramStFeed1, paramStFeed2);
    c(paramStFeed1, paramStFeed2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.data.update.FSFeedConverter
 * JD-Core Version:    0.7.0.1
 */