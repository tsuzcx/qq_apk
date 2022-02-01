package com.tencent.mobileqq.kandian.biz.pts.listeners;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.comment.ReadInJoyCommentUtils;
import com.tencent.mobileqq.kandian.biz.comment.bean.CommentComponentArgs;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import org.json.JSONException;
import org.json.JSONObject;

public class OnUserCommentEditClickListener
  implements ViewBase.OnClickListener
{
  private AbsBaseArticleInfo a;
  private VafContext b;
  
  public OnUserCommentEditClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, VafContext paramVafContext)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramVafContext;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.a;
    if (paramViewBase == null) {
      return;
    }
    if (RIJFeedsType.ab(paramViewBase))
    {
      paramViewBase = new CommentComponentArgs().a(this.a).a(17).a("").b("");
      ReadInJoyCommentUtils.a(this.b.getCurActivity(), paramViewBase);
      GalleryReportedUtils.a(this.b.getCurActivity(), this.a, "0X8009A72", null);
      return;
    }
    paramViewBase = this.b.getCurActivity();
    Object localObject = this.a;
    ReadInJoyCommentUtils.a(paramViewBase, (AbsBaseArticleInfo)localObject, null, (int)((AbsBaseArticleInfo)localObject).mFeedId, HardCodeUtil.a(2131905663), null, false, null, false, null, 1);
    if (ReadinjoyReportUtils.d(this.a.mChannelID)) {
      paramViewBase = "0X80094A0";
    } else {
      paramViewBase = "0X800949E";
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("folder_status", "x");
      String str = this.a.mSubscribeID;
      long l1 = this.a.mSocialFeedInfo.a;
      long l2 = this.a.mArticleID;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.a.mStrategyId);
      PublicAccountReportUtils.a(null, str, paramViewBase, paramViewBase, 0, 0, String.valueOf(l1), String.valueOf(l2), localStringBuilder.toString(), ((JSONObject)localObject).toString(), false);
      return;
    }
    catch (JSONException paramViewBase)
    {
      paramViewBase.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnUserCommentEditClickListener
 * JD-Core Version:    0.7.0.1
 */