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
        if (!((String)localObject1).equals(VideoFeedsRecommendManager.a(this.a).g)) {
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
            ((VideoInfo)localObject3).i = true;
            ((VideoInfo)localObject3).t = ((String)localObject1);
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("动态插入视频 title = ");
              localStringBuilder.append(((VideoInfo)localObject3).c);
              localStringBuilder.append(", rowkey = ");
              localStringBuilder.append(((VideoInfo)localObject3).g);
              QLog.d("Q.pubaccount.video.feedsVideoFeedsRecommendManager", 2, localStringBuilder.toString());
            }
          }
          localObject2 = new ArrayList();
          Object localObject3 = new ArrayList();
          int m = 0;
          int i = 0;
          int k;
          for (int j = -1; i < VideoFeedsRecommendManager.a(this.a).size(); j = k)
          {
            if (j == -1)
            {
              if (((VideoInfo)VideoFeedsRecommendManager.a(this.a).get(i)).f() == null)
              {
                k = j;
              }
              else
              {
                k = j;
                if (((VideoInfo)VideoFeedsRecommendManager.a(this.a).get(i)).f().equals(VideoFeedsRecommendManager.a(this.a).f())) {
                  k = i;
                }
              }
            }
            else
            {
              k = j;
              if (((VideoInfo)VideoFeedsRecommendManager.a(this.a).get(i)).r)
              {
                ((ArrayList)localObject2).add(Integer.valueOf(i));
                ((ArrayList)localObject3).add(VideoFeedsRecommendManager.a(this.a).get(i));
                k = j;
              }
            }
            i += 1;
          }
          if (!VideoFeedsRecommendManager.a(this.a).c())
          {
            if (!((String)localObject1).equals(VideoFeedsRecommendManager.a(this.a).g)) {
              return;
            }
            localObject1 = VideoFeedsRecommendManager.b(this.a).iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((VideoFeedsRecommendManager.Listener)((Iterator)localObject1).next()).c();
            }
            i = ((ArrayList)localObject2).size() - 1;
            while (i >= 0)
            {
              VideoFeedsRecommendManager.a(this.a).remove(((Integer)((ArrayList)localObject2).get(i)).intValue());
              VideoFeedsRecommendManager.a(this.a).notifyItemRemoved(((Integer)((ArrayList)localObject2).get(i)).intValue());
              i -= 1;
            }
            localObject1 = VideoFeedsRecommendManager.a(this.a);
            i = j + 1;
            ((ArrayList)localObject1).addAll(i, paramBundle);
            VideoFeedsRecommendManager.a(this.a).notifyItemRangeInserted(i, paramBundle.size());
            i = m;
            while (i < ((ArrayList)localObject2).size())
            {
              VideoFeedsRecommendManager.a(this.a).add(((Integer)((ArrayList)localObject2).get(i)).intValue(), ((ArrayList)localObject3).get(i));
              VideoFeedsRecommendManager.a(this.a).notifyItemInserted(((Integer)((ArrayList)localObject2).get(i)).intValue());
              i += 1;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendManager.PlayRecommendObserver
 * JD-Core Version:    0.7.0.1
 */