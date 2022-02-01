package com.tencent.mobileqq.kandian.biz.pts.util;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.kandian.base.view.widget.RoundAngleFrameLayout;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianFeedsCardStyleAladdinConfig;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.util.DisplayUtil;

public class ReadInjoyFeedsUtils
{
  public static void a(Context paramContext, View paramView, RoundAngleFrameLayout paramRoundAngleFrameLayout)
  {
    int j = paramView.getPaddingTop();
    int k = paramView.getPaddingBottom();
    int i;
    if (RIJKanDianFeedsCardStyleAladdinConfig.a())
    {
      paramRoundAngleFrameLayout.setRadius(DisplayUtil.a(paramContext, 8.0F));
      i = DisplayUtil.a(paramContext, 14.0F);
    }
    else
    {
      paramRoundAngleFrameLayout.setRadius(DisplayUtil.a(paramContext, 0.0F));
      i = DisplayUtil.a(paramContext, 6.0F);
    }
    paramView.setPadding(i, j, i, k);
  }
  
  public static boolean a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int i = paramAbsBaseArticleInfo.mFeedType;
    boolean bool = true;
    if (i != 25)
    {
      if ((paramAbsBaseArticleInfo.mFeedType == 1) && (RIJFeedsType.d(paramAbsBaseArticleInfo) == 25)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.ReadInjoyFeedsUtils
 * JD-Core Version:    0.7.0.1
 */