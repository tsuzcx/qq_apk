package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.kandian.biz.account.api.impl.CellFactory;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackQuestionAnswerExtraInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackTopicExtraInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONObject;

class ComponentPolymericView$ReadinjoyHorizontalAdapter
  extends BaseAdapter
{
  private ComponentPolymericView$ReadinjoyHorizontalAdapter(ComponentPolymericView paramComponentPolymericView) {}
  
  public int getCount()
  {
    if (ComponentPolymericView.a(this.a) != null) {
      return ComponentPolymericView.a(this.a).size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    return ComponentPolymericView.a(this.a).get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return ((AbsBaseArticleInfo)ComponentPolymericView.a(this.a).get(paramInt)).mRecommendSeq;
  }
  
  public int getItemViewType(int paramInt)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)ComponentPolymericView.a(this.a).get(paramInt);
    if (RIJFeedsType.l(localAbsBaseArticleInfo))
    {
      switch (localAbsBaseArticleInfo.mNewPolymericInfo.d)
      {
      default: 
        if (RIJFeedsType.b(localAbsBaseArticleInfo)) {
          return 51;
        }
        break;
      case 13: 
        return 97;
      case 12: 
        return 98;
      case 11: 
        return 69;
      case 10: 
        return 68;
      case 9: 
        return 67;
      }
      if (RIJFeedsType.d(localAbsBaseArticleInfo)) {
        return 52;
      }
      if (localAbsBaseArticleInfo.mSinglePicture != null) {
        return 50;
      }
    }
    else
    {
      if (localAbsBaseArticleInfo.mPolymericInfo != null) {
        switch (localAbsBaseArticleInfo.mPolymericInfo.e)
        {
        default: 
          break;
        case 11: 
          return 69;
        case 10: 
          return 68;
        case 9: 
          return 67;
        }
      }
      if (RIJFeedsType.a(localAbsBaseArticleInfo)) {
        return 51;
      }
      if (RIJFeedsType.d(localAbsBaseArticleInfo)) {
        return 52;
      }
      if (localAbsBaseArticleInfo.mSinglePicture == null) {}
    }
    return 50;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (AbsBaseArticleInfo)ComponentPolymericView.a(this.a).get(paramInt);
    Object localObject1 = ComponentPolymericView.b(this.a);
    int j = getItemViewType(paramInt);
    int k = (int)paramViewGroup.mChannelID;
    int i;
    if (paramViewGroup.mChannelID == 3L) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject2 = new ReadInJoyModelImpl((Context)localObject1, paramViewGroup, j, k, i, paramInt, false, getCount(), null, (ReadInJoyBaseAdapter)ComponentPolymericView.c(this.a).a.u());
    localObject1 = CellFactory.INSTANCE.getView(paramInt, localObject2, getItemViewType(paramInt), paramView, ComponentPolymericView.b(this.a), ComponentPolymericView.c(this.a).a.u(), ((ReadInJoyBaseAdapter)ComponentPolymericView.c(this.a).a.u()).l());
    if (localObject1 != null)
    {
      ((View)localObject1).setTag(2131449867, localObject2);
      ((ReadInJoyBaseAdapter)ComponentPolymericView.c(this.a).a.u()).a(paramViewGroup, (IReadInJoyModel)localObject2, System.currentTimeMillis(), paramInt);
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("ComponentPolymericView getView position:");
      paramView.append(paramInt);
      paramView.append(" count:");
      paramView.append(getCount());
      QLog.d("PolymericSmallVideo", 2, paramView.toString());
    }
    if (ComponentPolymericView.d(this.a)[paramInt] == null) {
      ComponentPolymericView.d(this.a)[paramInt] = Boolean.valueOf(false);
    }
    if (((RIJFeedsType.L(paramViewGroup)) || (RIJFeedsType.M(paramViewGroup))) && (!ComponentPolymericView.d(this.a)[paramInt].booleanValue())) {
      localObject2 = new JSONObject();
    }
    for (;;)
    {
      try
      {
        localObject3 = (NewPolymericInfo.PackArticleInfo)paramViewGroup.mNewPolymericInfo.p.get(0);
        ((JSONObject)localObject2).put("channel_id", paramViewGroup.mChannelID);
        if (((NewPolymericInfo.PackArticleInfo)localObject3).q != null) {
          paramView = ((NewPolymericInfo.PackArticleInfo)localObject3).q.a;
        } else {
          paramView = Integer.valueOf(0);
        }
        ((JSONObject)localObject2).put("rowkey", paramView);
        if (((NewPolymericInfo.PackArticleInfo)localObject3).p == null) {
          break label568;
        }
        i = ((NewPolymericInfo.PackArticleInfo)localObject3).p.d;
        ((JSONObject)localObject2).put("topicid", i);
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      paramView = new StringBuilder();
      paramView.append(paramViewGroup.mFeedId);
      paramView.append("");
      Object localObject3 = paramView.toString();
      if (RIJFeedsType.L(paramViewGroup)) {
        paramView = "1";
      } else {
        paramView = "2";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramViewGroup.mStrategyId);
      localStringBuilder.append("");
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8009829", "0X8009829", 0, 0, (String)localObject3, paramView, localStringBuilder.toString(), ((JSONObject)localObject2).toString(), false);
      ComponentPolymericView.d(this.a)[paramInt] = Boolean.valueOf(true);
      if ((RIJFeedsType.F(paramViewGroup)) && (paramViewGroup.mPolymericInfo != null)) {
        paramViewGroup.mPolymericInfo.q = paramInt;
      }
      return localObject1;
      label568:
      i = 0;
    }
  }
  
  public int getViewTypeCount()
  {
    return 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentPolymericView.ReadinjoyHorizontalAdapter
 * JD-Core Version:    0.7.0.1
 */