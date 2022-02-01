package com.tencent.mobileqq.kandian.biz.video;

import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.BaseVideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController.RecommendDataAdapter;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class VideoUIManager$2
  implements VideoFullPlayController.RecommendDataAdapter
{
  VideoUIManager$2(VideoUIManager paramVideoUIManager) {}
  
  public List<BaseVideoPlayParam> a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (VideoInfo)paramList.next();
        if (localObject != null)
        {
          localObject = FeedsChannelDataHelper.a((VideoInfo)localObject);
          if (localObject != null) {
            localArrayList.add(ReadInJoyBaseAdapter.a((AbsBaseArticleInfo)localObject, true));
          }
        }
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoUIManager.2
 * JD-Core Version:    0.7.0.1
 */