package com.tencent.mobileqq.kandian.biz.playfeeds;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo.VideoHistoryAction;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoFeedsRecommendManager
{
  private ArrayList<VideoFeedsRecommendManager.Listener> a = new ArrayList();
  private BaseActivity b;
  private VideoFeedsAdapter c;
  private AppInterface d;
  private ArrayList<VideoInfo> e;
  private VideoFeedsRecyclerView f;
  private VideoPlayRecommendObserver g;
  private VideoInfo h;
  private boolean i = false;
  private long j;
  
  public VideoFeedsRecommendManager(AppInterface paramAppInterface, BaseActivity paramBaseActivity, ArrayList<VideoInfo> paramArrayList, VideoFeedsAdapter paramVideoFeedsAdapter, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.d = paramAppInterface;
    this.b = paramBaseActivity;
    this.e = paramArrayList;
    this.c = paramVideoFeedsAdapter;
    this.f = paramVideoFeedsRecyclerView;
  }
  
  public VideoInfo a()
  {
    VideoInfo localVideoInfo = this.h;
    if (localVideoInfo != null) {
      return localVideoInfo;
    }
    return null;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, long paramLong)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
      if ((localVideoInfo.s() != null) && (localVideoInfo.s().equals(paramVideoInfo.s())))
      {
        paramVideoInfo = localVideoInfo;
        break label65;
      }
    }
    paramVideoInfo = null;
    label65:
    if (paramVideoInfo == null) {
      return;
    }
    if (paramVideoInfo.aI == null) {
      paramVideoInfo.aI = new VideoInfo.VideoHistoryAction();
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          paramVideoInfo.aI.d = true;
          return;
        }
        paramVideoInfo.aI.c = true;
        return;
      }
      paramVideoInfo.aI.b = true;
      return;
    }
    paramVideoInfo.aI.a = paramLong;
  }
  
  public void a(long paramLong)
  {
    try
    {
      boolean bool = this.i;
      if (bool) {
        return;
      }
      this.j = paramLong;
      if ((this.h.U != 0) && (this.j > this.h.U * 1000))
      {
        this.i = true;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("满足条件，触发请求 currentVideo = ");
          ((StringBuilder)localObject1).append(this.h.g);
          QLog.d("Q.pubaccount.video.feedsVideoFeedsRecommendManager", 2, ((StringBuilder)localObject1).toString());
        }
        Object localObject1 = this.a.iterator();
        while (((Iterator)localObject1).hasNext()) {
          ((VideoFeedsRecommendManager.Listener)((Iterator)localObject1).next()).b();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void a(VideoFeedsRecommendManager.Listener paramListener)
  {
    this.a.add(paramListener);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.h = paramVideoInfo;
    this.i = false;
    if (QLog.isColorLevel())
    {
      paramVideoInfo = new StringBuilder();
      paramVideoInfo.append("切换视频 videoInfo.DynamicTriggerSec = ");
      paramVideoInfo.append(this.h.U);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsRecommendManager", 2, paramVideoInfo.toString());
    }
  }
  
  public String b()
  {
    int k;
    label84:
    int m;
    int n;
    int i1;
    try
    {
      localObject1 = new JSONObject();
      localObject2 = new JSONArray();
      i2 = 0;
      k = 0;
      if (k >= this.e.size()) {
        break label711;
      }
      if ((((VideoInfo)this.e.get(k)).s() == null) || (!((VideoInfo)this.e.get(k)).s().equals(this.h.s()))) {
        break label704;
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      int i2;
      VideoInfo localVideoInfo;
      JSONObject localJSONObject;
      label207:
      label234:
      label498:
      if (!QLog.isColorLevel()) {
        break label702;
      }
      label261:
      label287:
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getRequestHistoryData() ERROR = ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      QLog.d("Q.pubaccount.video.feedsVideoFeedsRecommendManager", 2, ((StringBuilder)localObject2).toString());
      return null;
    }
    if (m >= 0)
    {
      localVideoInfo = (VideoInfo)this.e.get(m);
      i1 = n;
      if (localVideoInfo.aI == null) {
        break label747;
      }
      localJSONObject = new JSONObject();
      localJSONObject.put("rowkey", localVideoInfo.l);
      localJSONObject.put("video_duration", localVideoInfo.k());
      localJSONObject.put("watch_duration", (float)localVideoInfo.aI.a / 1000.0F);
      localJSONObject.put("alg_id", localVideoInfo.ah);
      localJSONObject.put("video_index", m);
      if (localVideoInfo.aI.b)
      {
        i1 = 1;
        localJSONObject.put("is_biu", i1);
        if (!localVideoInfo.aI.c) {
          break label735;
        }
        i1 = 1;
        localJSONObject.put("is_like", i1);
        if (!localVideoInfo.aI.d) {
          break label741;
        }
        i1 = 1;
        localJSONObject.put("is_comment", i1);
        ((JSONArray)localObject2).put(localJSONObject);
        i1 = n + 1;
        break label747;
      }
    }
    else
    {
      ((JSONObject)localObject1).put("play_info", localObject2);
      ((JSONObject)localObject1).put("first_rowkey", ((VideoInfo)this.e.get(0)).l);
      localObject2 = ((VideoInfo)this.e.get(0)).aI;
      if (localObject2 != null) {
        ((JSONObject)localObject1).put("first_watch_duration", (float)((VideoInfo)this.e.get(0)).aI.a / 1000.0F);
      } else {
        ((JSONObject)localObject1).put("first_watch_duration", 0);
      }
      ((JSONObject)localObject1).put("first_video_duration", ((VideoInfo)this.e.get(0)).k());
      ((JSONObject)localObject1).put("current_rowkey", this.h.l);
      ((JSONObject)localObject1).put("current_watch_duration", (float)this.j / 1000.0F);
      ((JSONObject)localObject1).put("current_video_duration", this.h.k());
      ((JSONObject)localObject1).put("current_algid", this.h.ah);
      localObject2 = this.h.aI;
      if (localObject2 != null)
      {
        if (!this.h.aI.b) {
          break label767;
        }
        m = 1;
        ((JSONObject)localObject1).put("current_isbiu", m);
        if (!this.h.aI.d) {
          break label772;
        }
        m = 1;
      }
    }
    for (;;)
    {
      ((JSONObject)localObject1).put("current_iscomment", m);
      m = i2;
      if (this.h.aI.c) {
        m = 1;
      }
      ((JSONObject)localObject1).put("current_islike", m);
      break label591;
      ((JSONObject)localObject1).put("current_isbiu", 0);
      ((JSONObject)localObject1).put("current_iscomment", 0);
      ((JSONObject)localObject1).put("current_islike", 0);
      label591:
      ((JSONObject)localObject1).put("current_video_index", k);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("触发动态插入 json = ");
        ((StringBuilder)localObject2).append(((JSONObject)localObject1).toString());
        QLog.d("Q.pubaccount.video.feedsVideoFeedsRecommendManager", 2, ((StringBuilder)localObject2).toString());
      }
      localObject1 = ((JSONObject)localObject1).toString();
      return localObject1;
      label702:
      label704:
      k += 1;
      break;
      label711:
      k = -1;
      if (k == -1) {
        return null;
      }
      m = k - 1;
      n = 0;
      break label84;
      i1 = 0;
      break label207;
      label735:
      i1 = 0;
      break label234;
      label741:
      i1 = 0;
      break label261;
      label747:
      if (i1 >= 10) {
        break label287;
      }
      m -= 1;
      n = i1;
      break label84;
      label767:
      m = 0;
      break label498;
      label772:
      m = 0;
    }
  }
  
  public VideoPlayRecommendObserver c()
  {
    if (this.g == null)
    {
      this.g = new VideoFeedsRecommendManager.PlayRecommendObserver(this, null);
      this.b.addObserver(this.g);
    }
    return this.g;
  }
  
  public void d()
  {
    this.a.clear();
    this.d = null;
    this.b.removeObserver(this.g);
    this.b = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendManager
 * JD-Core Version:    0.7.0.1
 */