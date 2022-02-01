package com.tencent.mobileqq.kandian.biz.pts.component;

import android.os.Looper;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class ComponentHeaderPolymeric$6
  extends ReadInJoyObserver
{
  ComponentHeaderPolymeric$6(ComponentHeaderPolymeric paramComponentHeaderPolymeric) {}
  
  public void a(long paramLong, boolean paramBoolean)
  {
    int i;
    if (Looper.getMainLooper() == Looper.myLooper()) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      QLog.e("ComponentHeaderPolymeric", 2, "Please call this method in main thread!!!");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateAfterAccountFollow uin = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" isFollow = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ComponentHeaderPolymeric", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (AbsBaseArticleInfo)this.a.a.a.a().mGroupSubArticleList.get(0);
    if ((localObject != null) && (((AbsBaseArticleInfo)localObject).mPolymericInfo != null) && (((AbsBaseArticleInfo)localObject).mPolymericInfo.b == paramLong))
    {
      SocializeFeedsInfo localSocializeFeedsInfo = ((AbsBaseArticleInfo)localObject).mSocialFeedInfo;
      ComponentHeaderPolymeric.a(this.a).setVisibility(0);
      if (paramBoolean)
      {
        ComponentHeaderPolymeric.a(this.a, true);
        if (localSocializeFeedsInfo != null) {
          localSocializeFeedsInfo.h = 2;
        }
        ((AbsBaseArticleInfo)localObject).mPolymericInfo.e = 2;
        return;
      }
      ComponentHeaderPolymeric.a(this.a, false);
      if (localSocializeFeedsInfo != null) {
        localSocializeFeedsInfo.h = 1;
      }
      ((AbsBaseArticleInfo)localObject).mPolymericInfo.e = 1;
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    int i;
    if (Looper.getMainLooper() == Looper.myLooper()) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      QLog.e("ComponentHeaderPolymeric", 2, "Please call this method in main thread!!!");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUpdateAfterSmallVideoTopicFollow topicId = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" isFollow = ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ComponentHeaderPolymeric", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (AbsBaseArticleInfo)this.a.a.a.a().mGroupSubArticleList.get(0);
    if ((localObject != null) && (((AbsBaseArticleInfo)localObject).mPolymericInfo != null) && (((AbsBaseArticleInfo)localObject).mPolymericInfo.f == paramLong))
    {
      ComponentHeaderPolymeric.a(this.a).setVisibility(0);
      if (paramBoolean)
      {
        ComponentHeaderPolymeric.a(this.a, true);
        if ((((AbsBaseArticleInfo)localObject).mTopicRecommendFeedsInfo != null) && (((AbsBaseArticleInfo)localObject).mTopicRecommendFeedsInfo.a != null)) {
          ((TopicRecommendFeedsInfo.TopicRecommendInfo)((AbsBaseArticleInfo)localObject).mTopicRecommendFeedsInfo.a.get(0)).c = 1;
        }
        if (((AbsBaseArticleInfo)localObject).mPolymericInfo != null)
        {
          ((AbsBaseArticleInfo)localObject).mPolymericInfo.e = 2;
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("articleInfo mPolymericInfo == null articleInfo.mArticleID = ");
        localStringBuilder.append(((AbsBaseArticleInfo)localObject).mArticleID);
        QLog.e("ComponentHeaderPolymeric", 2, localStringBuilder.toString());
        return;
      }
      ComponentHeaderPolymeric.a(this.a, false);
      if ((((AbsBaseArticleInfo)localObject).mTopicRecommendFeedsInfo != null) && (((AbsBaseArticleInfo)localObject).mTopicRecommendFeedsInfo.a != null)) {
        ((TopicRecommendFeedsInfo.TopicRecommendInfo)((AbsBaseArticleInfo)localObject).mTopicRecommendFeedsInfo.a.get(0)).c = 0;
      }
      if (((AbsBaseArticleInfo)localObject).mPolymericInfo != null)
      {
        ((AbsBaseArticleInfo)localObject).mPolymericInfo.e = 1;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("articleInfo mPolymericInfo == null articleInfo.mArticleID = ");
      localStringBuilder.append(((AbsBaseArticleInfo)localObject).mArticleID);
      QLog.e("ComponentHeaderPolymeric", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderPolymeric.6
 * JD-Core Version:    0.7.0.1
 */