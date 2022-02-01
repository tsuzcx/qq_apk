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
  private long jdField_a_of_type_Long;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private VideoFeedsAdapter jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
  private VideoPlayRecommendObserver jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver;
  private VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
  private ArrayList<VideoFeedsRecommendManager.Listener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private ArrayList<VideoInfo> b;
  
  public VideoFeedsRecommendManager(AppInterface paramAppInterface, BaseActivity paramBaseActivity, ArrayList<VideoInfo> paramArrayList, VideoFeedsAdapter paramVideoFeedsAdapter, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.b = paramArrayList;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter = paramVideoFeedsAdapter;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
  }
  
  public VideoPlayRecommendObserver a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver = new VideoFeedsRecommendManager.PlayRecommendObserver(this, null);
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver);
    }
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver;
  }
  
  public VideoInfo a()
  {
    VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    if (localVideoInfo != null) {
      return localVideoInfo;
    }
    return null;
  }
  
  public String a()
  {
    int i;
    label84:
    int j;
    int k;
    int m;
    try
    {
      localObject1 = new JSONObject();
      localObject2 = new JSONArray();
      n = 0;
      i = 0;
      if (i >= this.b.size()) {
        break label711;
      }
      if ((((VideoInfo)this.b.get(i)).f() == null) || (!((VideoInfo)this.b.get(i)).f().equals(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.f()))) {
        break label704;
      }
    }
    catch (Exception localException)
    {
      Object localObject1;
      int n;
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
    if (j >= 0)
    {
      localVideoInfo = (VideoInfo)this.b.get(j);
      m = k;
      if (localVideoInfo.a == null) {
        break label747;
      }
      localJSONObject = new JSONObject();
      localJSONObject.put("rowkey", localVideoInfo.g);
      localJSONObject.put("video_duration", localVideoInfo.c());
      localJSONObject.put("watch_duration", (float)localVideoInfo.a.jdField_a_of_type_Long / 1000.0F);
      localJSONObject.put("alg_id", localVideoInfo.f);
      localJSONObject.put("video_index", j);
      if (localVideoInfo.a.jdField_a_of_type_Boolean)
      {
        m = 1;
        localJSONObject.put("is_biu", m);
        if (!localVideoInfo.a.b) {
          break label735;
        }
        m = 1;
        localJSONObject.put("is_like", m);
        if (!localVideoInfo.a.c) {
          break label741;
        }
        m = 1;
        localJSONObject.put("is_comment", m);
        ((JSONArray)localObject2).put(localJSONObject);
        m = k + 1;
        break label747;
      }
    }
    else
    {
      ((JSONObject)localObject1).put("play_info", localObject2);
      ((JSONObject)localObject1).put("first_rowkey", ((VideoInfo)this.b.get(0)).g);
      localObject2 = ((VideoInfo)this.b.get(0)).a;
      if (localObject2 != null) {
        ((JSONObject)localObject1).put("first_watch_duration", (float)((VideoInfo)this.b.get(0)).a.jdField_a_of_type_Long / 1000.0F);
      } else {
        ((JSONObject)localObject1).put("first_watch_duration", 0);
      }
      ((JSONObject)localObject1).put("first_video_duration", ((VideoInfo)this.b.get(0)).c());
      ((JSONObject)localObject1).put("current_rowkey", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g);
      ((JSONObject)localObject1).put("current_watch_duration", (float)this.jdField_a_of_type_Long / 1000.0F);
      ((JSONObject)localObject1).put("current_video_duration", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.c());
      ((JSONObject)localObject1).put("current_algid", this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.f);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a;
      if (localObject2 != null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a.jdField_a_of_type_Boolean) {
          break label767;
        }
        j = 1;
        ((JSONObject)localObject1).put("current_isbiu", j);
        if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a.c) {
          break label772;
        }
        j = 1;
      }
    }
    for (;;)
    {
      ((JSONObject)localObject1).put("current_iscomment", j);
      j = n;
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a.b) {
        j = 1;
      }
      ((JSONObject)localObject1).put("current_islike", j);
      break label591;
      ((JSONObject)localObject1).put("current_isbiu", 0);
      ((JSONObject)localObject1).put("current_iscomment", 0);
      ((JSONObject)localObject1).put("current_islike", 0);
      label591:
      ((JSONObject)localObject1).put("current_video_index", i);
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
      i += 1;
      break;
      label711:
      i = -1;
      if (i == -1) {
        return null;
      }
      j = i - 1;
      k = 0;
      break label84;
      m = 0;
      break label207;
      label735:
      m = 0;
      break label234;
      label741:
      m = 0;
      break label261;
      label747:
      if (m >= 10) {
        break label287;
      }
      j -= 1;
      k = m;
      break label84;
      label767:
      j = 0;
      break label498;
      label772:
      j = 0;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, long paramLong)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      VideoInfo localVideoInfo = (VideoInfo)localIterator.next();
      if ((localVideoInfo.f() != null) && (localVideoInfo.f().equals(paramVideoInfo.f())))
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
    if (paramVideoInfo.a == null) {
      paramVideoInfo.a = new VideoInfo.VideoHistoryAction();
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
          paramVideoInfo.a.c = true;
          return;
        }
        paramVideoInfo.a.b = true;
        return;
      }
      paramVideoInfo.a.jdField_a_of_type_Boolean = true;
      return;
    }
    paramVideoInfo.a.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(long paramLong)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      this.jdField_a_of_type_Long = paramLong;
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.m != 0) && (this.jdField_a_of_type_Long > this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.m * 1000))
      {
        this.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("满足条件，触发请求 currentVideo = ");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.c);
          QLog.d("Q.pubaccount.video.feedsVideoFeedsRecommendManager", 2, ((StringBuilder)localObject1).toString());
        }
        Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
    this.jdField_a_of_type_JavaUtilArrayList.add(paramListener);
  }
  
  public void a(VideoInfo paramVideoInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel())
    {
      paramVideoInfo = new StringBuilder();
      paramVideoInfo.append("切换视频 videoInfo.DynamicTriggerSec = ");
      paramVideoInfo.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.m);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsRecommendManager", 2, paramVideoInfo.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendManager
 * JD-Core Version:    0.7.0.1
 */