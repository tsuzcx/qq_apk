package com.tencent.mobileqq.kandian.repo.video;

import com.tencent.mobileqq.kandian.base.utils.ReadInJoyStringUtils;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoData;
import com.tencent.mobileqq.kandian.repo.video.entity.WeiShiVideoArticleInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class VideoArticleModule$4
  implements Runnable
{
  VideoArticleModule$4(VideoArticleModule paramVideoArticleModule, long paramLong1, boolean paramBoolean1, List paramList, int paramInt, boolean paramBoolean2, long paramLong2, ToServiceMsg paramToServiceMsg) {}
  
  public void run()
  {
    long l = this.a;
    int i = 0;
    boolean bool;
    if (l == -1L) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.b)
    {
      StringBuilder localStringBuilder1 = new StringBuilder("\n");
      Object localObject1 = this.c;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = this.c.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          WeiShiVideoArticleInfo localWeiShiVideoArticleInfo = (WeiShiVideoArticleInfo)((Iterator)localObject2).next();
          if (localWeiShiVideoArticleInfo != null)
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("article【");
            localStringBuilder2.append(i);
            localStringBuilder2.append("】 id : ");
            localStringBuilder2.append(localWeiShiVideoArticleInfo.articleID);
            localStringBuilder2.append(" seq : ");
            localStringBuilder2.append(localWeiShiVideoArticleInfo.recommendSeq);
            localStringBuilder2.append(" title : ");
            localStringBuilder2.append(ReadInJoyStringUtils.b(localWeiShiVideoArticleInfo.title));
            localStringBuilder2.append(" rowkey : ");
            localStringBuilder2.append(localWeiShiVideoArticleInfo.rowkey);
            localStringBuilder2.append(" isUgc : ");
            localStringBuilder2.append(localWeiShiVideoArticleInfo.isUgc);
            localStringBuilder2.append(" vid : ");
            if (localWeiShiVideoArticleInfo.videoData == null) {
              localObject1 = "";
            } else {
              localObject1 = localWeiShiVideoArticleInfo.videoData.e;
            }
            localStringBuilder2.append((String)localObject1);
            localStringBuilder2.append(" feedsType : ");
            localStringBuilder2.append(localWeiShiVideoArticleInfo.feedsType);
            localStringBuilder2.append(" algorithmID : ");
            localStringBuilder2.append(localWeiShiVideoArticleInfo.algorithmID);
            localStringBuilder2.append(" strategyId : ");
            localStringBuilder2.append(localWeiShiVideoArticleInfo.strategyID);
            localStringBuilder2.append(" \n");
            localStringBuilder1.append(localStringBuilder2.toString());
            i += 1;
          }
        }
      }
      localObject1 = VideoArticleModule.a;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onGetChannelArticleList success=");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append(" channelId=");
      ((StringBuilder)localObject2).append(this.d);
      ((StringBuilder)localObject2).append(" noMoreData=");
      ((StringBuilder)localObject2).append(this.e);
      ((StringBuilder)localObject2).append(" beginRecommendSeq=");
      ((StringBuilder)localObject2).append(this.a);
      ((StringBuilder)localObject2).append(" endRecommendSeq=");
      ((StringBuilder)localObject2).append(this.f);
      ((StringBuilder)localObject2).append(" isRefresh : ");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(localStringBuilder1.toString());
      QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    if (bool)
    {
      VideoArticleModule.a(this.this$0, this.b, this.d, this.e, this.c, this.a, this.f, this.g);
      return;
    }
    VideoArticleModule.a(this.this$0, this.b, this.d, this.e, this.c, this.a, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.video.VideoArticleModule.4
 * JD-Core Version:    0.7.0.1
 */