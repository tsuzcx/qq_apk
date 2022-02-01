package com.tencent.mobileqq.kandian.glue.video;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class VideoRecommendManager
{
  private float jdField_a_of_type_Float = -1.0F;
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private VideoRecommendManager.Listener jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager$Listener;
  private AbsBaseArticleInfo jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<Long, AbsBaseArticleInfo> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private HashMap<Long, AbsBaseArticleInfo> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private int c = 0;
  
  public VideoRecommendManager(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    ThreadManager.post(new VideoRecommendManager.1(this), 10, null, true);
  }
  
  private void a(int paramInt, long paramLong)
  {
    int i = 2;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          i = 0;
        }
      }
      else {
        i = 1;
      }
    }
    else if (paramLong >= this.jdField_b_of_type_Int) {
      i = 3;
    } else {
      i = 4;
    }
    Object localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("dynamic_recommend_strategyid", this.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("condition", i);
      ((JSONObject)localObject).put("strategy_duration_limit", this.jdField_b_of_type_Int);
      ((JSONObject)localObject).put("strategy_duration_percent", this.jdField_a_of_type_Float);
      ((JSONObject)localObject).put("operator", this.c);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        ((JSONObject)localObject).put("video_session_id", this.jdField_a_of_type_JavaLangString);
      }
      label138:
      Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
      if ((localActivity != null) && (localActivity.getIntent() != null)) {
        paramInt = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("channel_from", -1);
      } else {
        paramInt = 0;
      }
      localObject = new VideoR5.Builder(VideoReporter.a((JSONObject)localObject)).N(paramInt).a().a();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, null, "0X80087C7", "0X80087C7", 0, 0, String.valueOf(0), "", "", (String)localObject, false);
      return;
    }
    catch (Exception localException)
    {
      break label138;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, long paramLong1, long paramLong2)
  {
    label91:
    StringBuilder localStringBuilder;
    int j;
    if (paramAbsBaseArticleInfo != null)
    {
      label180:
      try
      {
        if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramAbsBaseArticleInfo.mArticleID))) {
          break label360;
        }
      }
      finally {}
      if (paramInt != 0) {
        break label388;
      }
      if (this.c == 0)
      {
        if ((paramLong1 < this.jdField_b_of_type_Int) || ((float)paramLong1 <= (float)paramLong2 * this.jdField_a_of_type_Float)) {
          break label382;
        }
        break label376;
      }
      if (paramLong1 >= this.jdField_b_of_type_Int) {
        break label376;
      }
      if ((float)paramLong1 <= (float)paramLong2 * this.jdField_a_of_type_Float) {
        break label382;
      }
      break label376;
      if (i == 0) {
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
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
      i = j;
      break label230;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateLatestUserAction() action=");
        localStringBuilder.append(paramInt);
        QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo = paramAbsBaseArticleInfo;
    }
    label388:
    for (int i = j;; i = 0)
    {
      label230:
      if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager$Listener != null))
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
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo.mArticleID), this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager$Listener.a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityAbsBaseArticleInfo);
      }
      return;
      return;
      label360:
      j = 1;
      if (paramInt == 1) {
        break label180;
      }
      if (paramInt != 2) {
        break;
      }
      break label180;
      label376:
      i = 1;
      break label91;
      label382:
      i = 0;
      break label91;
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramList.next();
      this.jdField_b_of_type_JavaUtilHashMap.put(Long.valueOf(localAbsBaseArticleInfo.mArticleID), localAbsBaseArticleInfo);
    }
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_b_of_type_JavaUtilHashMap.containsKey(Long.valueOf(paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoRecommendManager
 * JD-Core Version:    0.7.0.1
 */