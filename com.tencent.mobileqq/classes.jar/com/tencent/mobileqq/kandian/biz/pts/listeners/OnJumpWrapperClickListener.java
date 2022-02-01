package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class OnJumpWrapperClickListener
  implements ViewBase.OnClickListener
{
  private Context a;
  private AbsBaseArticleInfo b;
  
  public OnJumpWrapperClickListener(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.a = paramContext;
    this.b = paramAbsBaseArticleInfo;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = (String)RIJSPUtils.b("kd_topic_recommend_card_jump_url", "0");
    if (QLog.isColorLevel()) {
      QLog.d("OnJumpWrapperClickListener", 2, new Object[] { "jumpUrl = ", paramViewBase });
    }
    if (!TextUtils.isEmpty(paramViewBase))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = this.b;
      if (localAbsBaseArticleInfo != null) {
        RIJFrameworkReportManager.b(localAbsBaseArticleInfo, (int)localAbsBaseArticleInfo.mChannelID);
      }
      ReadInJoyUtils.a(this.a, paramViewBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnJumpWrapperClickListener
 * JD-Core Version:    0.7.0.1
 */