package com.tencent.mobileqq.kandian.biz.pts.listeners;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.glue.report.GalleryReportedUtils;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;

public class OnUserCommentClickListener
  implements ViewBase.OnClickListener
{
  AbsBaseArticleInfo a;
  Context b;
  ReadInJoyBaseAdapter c;
  
  public OnUserCommentClickListener(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.a = paramAbsBaseArticleInfo;
    this.b = paramContext;
    this.c = paramReadInJoyBaseAdapter;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    if (RIJItemViewTypeUtils.a(this.a))
    {
      RIJJumpUtils.a(this.b, this.a, 1, false, 0, 1);
    }
    else if (RIJFeedsType.ab(this.a))
    {
      RIJJumpUtils.a(this.b, this.a);
      GalleryReportedUtils.a(this.b, this.a, "0X8009A77", null);
    }
    else
    {
      RIJJumpUtils.a(this.b, this.a, 0, false, 0, 1);
    }
    GalleryReportedUtils.a(this.b, this.a, this.c);
    OnSocialOperationListener.a(this.a, "0X8009442", "0X8009445");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.listeners.OnUserCommentClickListener
 * JD-Core Version:    0.7.0.1
 */