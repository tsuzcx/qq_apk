package com.tencent.mobileqq.kandian.biz.pts.component;

import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ComponentHeaderPolymeric$4
  implements Ox978RespCallBack
{
  ComponentHeaderPolymeric$4(ComponentHeaderPolymeric paramComponentHeaderPolymeric, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("978 resp, result : ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", data : ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" distUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", topicID : ");
      localStringBuilder.append(this.a.mPolymericInfo.m);
      localStringBuilder.append(" followStatus = ");
      localStringBuilder.append(this.a.mPolymericInfo.p);
      QLog.d("ComponentHeaderPolymeric", 2, localStringBuilder.toString());
    }
    if (!paramString.equals(ComponentHeaderPolymeric.a(this.b).getTag())) {
      return;
    }
    ComponentHeaderPolymeric.a(this.b, true);
    if (paramBoolean)
    {
      if (this.a.mPolymericInfo.p == 1) {
        ComponentHeaderPolymeric.b(this.b, true);
      } else if (this.a.mPolymericInfo.p == 2) {
        ComponentHeaderPolymeric.b(this.b, false);
      }
      if ((this.a.mPolymericInfo.p != 1) && (this.a.mPolymericInfo.p != 2))
      {
        paramString = new StringBuilder();
        paramString.append("978 resp error, result : ");
        paramString.append(paramBoolean);
        paramString.append(", data : ");
        paramString.append(paramInt);
        paramString.append(", topicID : ");
        paramString.append(this.a.mPolymericInfo.m);
        QLog.e("ComponentHeaderPolymeric", 2, paramString.toString());
        return;
      }
      if (this.a.mPolymericInfo.p == 1) {
        paramInt = i;
      } else {
        paramInt = 1;
      }
      this.a.mPolymericInfo.p = paramInt;
      if ((this.a.mTopicRecommendFeedsInfo != null) && (this.a.mTopicRecommendFeedsInfo.g != null)) {
        ((TopicRecommendFeedsInfo.TopicRecommendInfo)this.a.mTopicRecommendFeedsInfo.g.get(0)).g = (paramInt - 1);
      }
      ThreadManager.post(new ComponentHeaderPolymeric.4.1(this, paramInt), 5, null, true);
      return;
    }
    if (this.a.mPolymericInfo.p == 1)
    {
      ComponentHeaderPolymeric.a(this.b, 1);
      return;
    }
    if (this.a.mPolymericInfo.p == 2) {
      ComponentHeaderPolymeric.a(this.b, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderPolymeric.4
 * JD-Core Version:    0.7.0.1
 */