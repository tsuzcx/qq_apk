package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class VideoFeedsRecommendManager$PlayRecommendObserver
  extends VideoPlayRecommendObserver
{
  private VideoFeedsRecommendManager$PlayRecommendObserver(VideoFeedsRecommendManager paramVideoFeedsRecommendManager) {}
  
  protected void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      Object localObject1 = paramBundle.getString("VALUE_REQUEST_VIDEO_ARTICLE_ID");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        if (!((String)localObject1).equals(VideoFeedsRecommendManager.a(this.a).l)) {
          return;
        }
        paramBundle = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
        if (paramBundle != null)
        {
          if (paramBundle.size() == 0) {
            return;
          }
          Object localObject2 = paramBundle.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (VideoInfo)((Iterator)localObject2).next();
            ((VideoInfo)localObject3).V = true;
            ((VideoInfo)localObject3).W = ((String)localObject1);
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("动态插入视频 title = ");
              localStringBuilder.append(((VideoInfo)localObject3).g);
              localStringBuilder.append(", rowkey = ");
              localStringBuilder.append(((VideoInfo)localObject3).l);
              QLog.d("Q.pubaccount.video.feedsVideoFeedsRecommendManager", 2, localStringBuilder.toString());
            }
          }
          localObject2 = new ArrayList();
          Object localObject3 = new ArrayList();
          int m = 0;
          int i = 0;
          int k;
          for (int j = -1; i < VideoFeedsRecommendManager.b(this.a).size(); j = k)
          {
            if (j == -1)
            {
              if (((VideoInfo)VideoFeedsRecommendManager.b(this.a).get(i)).s() == null)
              {
                k = j;
              }
              else
              {
                k = j;
                if (((VideoInfo)VideoFeedsRecommendManager.b(this.a).get(i)).s().equals(VideoFeedsRecommendManager.a(this.a).s())) {
                  k = i;
                }
              }
            }
            else
            {
              k = j;
              if (((VideoInfo)VideoFeedsRecommendManager.b(this.a).get(i)).aq)
              {
                ((ArrayList)localObject2).add(Integer.valueOf(i));
                ((ArrayList)localObject3).add(VideoFeedsRecommendManager.b(this.a).get(i));
                k = j;
              }
            }
            i += 1;
          }
          if (!VideoFeedsRecommendManager.c(this.a).g())
          {
            if (!((String)localObject1).equals(VideoFeedsRecommendManager.a(this.a).l)) {
              return;
            }
            localObject1 = VideoFeedsRecommendManager.d(this.a).iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((VideoFeedsRecommendManager.Listener)((Iterator)localObject1).next()).c();
            }
            i = ((ArrayList)localObject2).size() - 1;
            while (i >= 0)
            {
              VideoFeedsRecommendManager.b(this.a).remove(((Integer)((ArrayList)localObject2).get(i)).intValue());
              VideoFeedsRecommendManager.e(this.a).notifyItemRemoved(((Integer)((ArrayList)localObject2).get(i)).intValue());
              i -= 1;
            }
            localObject1 = VideoFeedsRecommendManager.b(this.a);
            i = j + 1;
            ((ArrayList)localObject1).addAll(i, paramBundle);
            VideoFeedsRecommendManager.e(this.a).notifyItemRangeInserted(i, paramBundle.size());
            i = m;
            while (i < ((ArrayList)localObject2).size())
            {
              VideoFeedsRecommendManager.b(this.a).add(((Integer)((ArrayList)localObject2).get(i)).intValue(), ((ArrayList)localObject3).get(i));
              VideoFeedsRecommendManager.e(this.a).notifyItemInserted(((Integer)((ArrayList)localObject2).get(i)).intValue());
              i += 1;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendManager.PlayRecommendObserver
 * JD-Core Version:    0.7.0.1
 */