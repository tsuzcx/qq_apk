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
    Object localObject = (AbsBaseArticleInfo)this.a.a.a.k().mGroupSubArticleList.get(0);
    if ((localObject != null) && (((AbsBaseArticleInfo)localObject).mPolymericInfo != null) && (((AbsBaseArticleInfo)localObject).mPolymericInfo.f == paramLong))
    {
      SocializeFeedsInfo localSocializeFeedsInfo = ((AbsBaseArticleInfo)localObject).mSocialFeedInfo;
      ComponentHeaderPolymeric.a(this.a).setVisibility(0);
      if (paramBoolean)
      {
        ComponentHeaderPolymeric.b(this.a, true);
        if (localSocializeFeedsInfo != null) {
          localSocializeFeedsInfo.o = 2;
        }
        ((AbsBaseArticleInfo)localObject).mPolymericInfo.p = 2;
        return;
      }
      ComponentHeaderPolymeric.b(this.a, false);
      if (localSocializeFeedsInfo != null) {
        localSocializeFeedsInfo.o = 1;
      }
      ((AbsBaseArticleInfo)localObject).mPolymericInfo.p = 1;
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
    Object localObject = (AbsBaseArticleInfo)this.a.a.a.k().mGroupSubArticleList.get(0);
    if ((localObject != null) && (((AbsBaseArticleInfo)localObject).mPolymericInfo != null) && (((AbsBaseArticleInfo)localObject).mPolymericInfo.m == paramLong))
    {
      ComponentHeaderPolymeric.a(this.a).setVisibility(0);
      if (paramBoolean)
      {
        ComponentHeaderPolymeric.b(this.a, true);
        if ((((AbsBaseArticleInfo)localObject).mTopicRecommendFeedsInfo != null) && (((AbsBaseArticleInfo)localObject).mTopicRecommendFeedsInfo.g != null)) {
          ((TopicRecommendFeedsInfo.TopicRecommendInfo)((AbsBaseArticleInfo)localObject).mTopicRecommendFeedsInfo.g.get(0)).g = 1;
        }
        if (((AbsBaseArticleInfo)localObject).mPolymericInfo != null)
        {
          ((AbsBaseArticleInfo)localObject).mPolymericInfo.p = 2;
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("articleInfo mPolymericInfo == null articleInfo.mArticleID = ");
        localStringBuilder.append(((AbsBaseArticleInfo)localObject).mArticleID);
        QLog.e("ComponentHeaderPolymeric", 2, localStringBuilder.toString());
        return;
      }
      ComponentHeaderPolymeric.b(this.a, false);
      if ((((AbsBaseArticleInfo)localObject).mTopicRecommendFeedsInfo != null) && (((AbsBaseArticleInfo)localObject).mTopicRecommendFeedsInfo.g != null)) {
        ((TopicRecommendFeedsInfo.TopicRecommendInfo)((AbsBaseArticleInfo)localObject).mTopicRecommendFeedsInfo.g.get(0)).g = 0;
      }
      if (((AbsBaseArticleInfo)localObject).mPolymericInfo != null)
      {
        ((AbsBaseArticleInfo)localObject).mPolymericInfo.p = 1;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("articleInfo mPolymericInfo == null articleInfo.mArticleID = ");
      localStringBuilder.append(((AbsBaseArticleInfo)localObject).mArticleID);
      QLog.e("ComponentHeaderPolymeric", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderPolymeric.6
 * JD-Core Version:    0.7.0.1
 */