package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackQuestionAnswerExtraInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackTopicExtraInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.utils.Base64Util;
import java.util.List;
import org.json.JSONObject;

class ComponentContentHotQuestion$1
  implements View.OnClickListener
{
  ComponentContentHotQuestion$1(ComponentContentHotQuestion paramComponentContentHotQuestion) {}
  
  public void onClick(View paramView)
  {
    Object localObject3 = this.a.a.a();
    AbsBaseArticleInfo localAbsBaseArticleInfo = ((IReadInJoyModel)localObject3).k();
    paramView = localAbsBaseArticleInfo.mNewPolymericInfo.p;
    int i = 0;
    Object localObject2 = (NewPolymericInfo.PackArticleInfo)paramView.get(0);
    if ((localAbsBaseArticleInfo.mNewPolymericInfo.d == 12) && (((NewPolymericInfo.PackArticleInfo)localObject2).p != null))
    {
      localObject1 = new Intent(this.a.b, ReadInJoyDeliverUGCActivity.class);
      ((Intent)localObject1).putExtra("arg_topic_id", String.valueOf(((NewPolymericInfo.PackArticleInfo)localObject2).p.d));
      boolean bool = true;
      ((Intent)localObject1).putExtra("support_topic", true);
      ((Intent)localObject1).putExtra("support_linkify", true);
      try
      {
        paramView = new String(Base64Util.decode(((NewPolymericInfo.PackArticleInfo)localObject2).p.c, 0));
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        paramView = "";
      }
      ((Intent)localObject1).putExtra("is_from_poly_topic", true);
      if (((IReadInJoyModel)localObject3).m() != 70) {
        bool = false;
      }
      ((Intent)localObject1).putExtra("is_from_dian_dian", bool);
      ((Intent)localObject1).putExtra("arg_topic_name", paramView);
      ((Intent)localObject1).putExtra("arg_ad_tag", ((NewPolymericInfo.PackArticleInfo)localObject2).p.e);
      this.a.getContext().startActivity((Intent)localObject1);
    }
    Object localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("channel_id", ((IReadInJoyModel)localObject3).m());
      if (((NewPolymericInfo.PackArticleInfo)localObject2).q != null) {
        paramView = ((NewPolymericInfo.PackArticleInfo)localObject2).q.a;
      } else {
        paramView = Integer.valueOf(0);
      }
      ((JSONObject)localObject1).put("rowkey", paramView);
      if (((NewPolymericInfo.PackArticleInfo)localObject2).p != null) {
        i = ((NewPolymericInfo.PackArticleInfo)localObject2).p.d;
      }
      ((JSONObject)localObject1).put("topicid", i);
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
    }
    paramView = new StringBuilder();
    paramView.append(localAbsBaseArticleInfo.mFeedId);
    paramView.append("");
    localObject2 = paramView.toString();
    if (RIJFeedsType.L(localAbsBaseArticleInfo)) {
      paramView = "1";
    } else {
      paramView = "2";
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(localAbsBaseArticleInfo.mStrategyId);
    ((StringBuilder)localObject3).append("");
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800982C", "0X800982C", 0, 0, (String)localObject2, paramView, ((StringBuilder)localObject3).toString(), ((JSONObject)localObject1).toString(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentHotQuestion.1
 * JD-Core Version:    0.7.0.1
 */