package com.tencent.mobileqq.kandian.glue.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class VideoRecommendManager
{
  private boolean a = false;
  private VideoRecommendManager.Listener b;
  private int c = 0;
  private int d = -1;
  private float e = -1.0F;
  private int f = 0;
  private AbsBaseArticleInfo g;
  private HashMap<Long, AbsBaseArticleInfo> h = new HashMap();
  private HashMap<Long, AbsBaseArticleInfo> i = new HashMap();
  private String j;
  private Activity k;
  
  public VideoRecommendManager(Activity paramActivity)
  {
    this.k = paramActivity;
    ThreadManager.post(new VideoRecommendManager.1(this), 10, null, true);
  }
  
  private void a(int paramInt, long paramLong)
  {
    int m = 2;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          m = 0;
        }
      }
      else {
        m = 1;
      }
    }
    else if (paramLong >= this.d) {
      m = 3;
    } else {
      m = 4;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("dynamic_recommend_strategyid", this.c);
      localJSONObject.put("condition", m);
      localJSONObject.put("strategy_duration_limit", this.d);
      localJSONObject.put("strategy_duration_percent", this.e);
      localJSONObject.put("operator", this.f);
      if (!TextUtils.isEmpty(this.j)) {
        localJSONObject.put("video_session_id", this.j);
      }
      label138:
      Activity localActivity = this.k;
      if ((localActivity != null) && (localActivity.getIntent() != null)) {
        paramInt = this.k.getIntent().getIntExtra("channel_from", -1);
      } else {
        paramInt = 0;
      }
      PublicAccountReportUtils.b(null, null, "0X80087C7", "0X80087C7", 0, 0, String.valueOf(0), "", "", new VideoR5.Builder(VideoReporter.b(localJSONObject)).O(paramInt).b().a(), false);
      return;
    }
    catch (Exception localException)
    {
      break label138;
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong1, long paramLong2)
  {
    label91:
    StringBuilder localStringBuilder;
    int n;
    if (paramAbsBaseArticleInfo != null)
    {
      label180:
      try
      {
        if (!this.h.containsKey(Long.valueOf(paramAbsBaseArticleInfo.mArticleID))) {
          break label360;
        }
      }
      finally {}
      if (paramInt != 0) {
        break label388;
      }
      if (this.f == 0)
      {
        if ((paramLong1 < this.d) || ((float)paramLong1 <= (float)paramLong2 * this.e)) {
          break label382;
        }
        break label376;
      }
      if (paramLong1 >= this.d) {
        break label376;
      }
      if ((float)paramLong1 <= (float)paramLong2 * this.e) {
        break label382;
      }
      break label376;
      if (m == 0) {
        break label388;
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateLatestUserAction() action=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", playDuration=");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(", totalDuration=");
        localStringBuilder.append(paramLong2);
        QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, localStringBuilder.toString());
      }
      this.g = paramAbsBaseArticleInfo;
      m = n;
      break label230;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateLatestUserAction() action=");
        localStringBuilder.append(paramInt);
        QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, localStringBuilder.toString());
      }
      this.g = paramAbsBaseArticleInfo;
    }
    label388:
    for (int m = n;; m = 0)
    {
      label230:
      if ((m != 0) && (this.b != null))
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("updateLatestUserAction() 触发拉取 articleInfo.mArticleID = ");
          localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
          localStringBuilder.append(", articleInfo.mTitle = ");
          localStringBuilder.append(paramAbsBaseArticleInfo.mTitle);
          QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, localStringBuilder.toString());
        }
        a(paramInt, paramLong1);
        this.h.put(Long.valueOf(this.g.mArticleID), this.g);
        this.b.a(this.a, this.g);
      }
      return;
      return;
      label360:
      n = 1;
      if (paramInt == 1) {
        break label180;
      }
      if (paramInt != 2) {
        break;
      }
      break label180;
      label376:
      m = 1;
      break label91;
      label382:
      m = 0;
      break label91;
    }
  }
  
  public void a(String paramString)
  {
    this.j = paramString;
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.next();
      this.i.put(Long.valueOf(localAbsBaseArticleInfo.mArticleID), localAbsBaseArticleInfo);
    }
  }
  
  public boolean a(long paramLong)
  {
    return this.i.containsKey(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoRecommendManager
 * JD-Core Version:    0.7.0.1
 */