package com.tencent.mobileqq.kandian.biz.share;

import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView.OnUninterestConfirmListener;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import org.json.JSONObject;

class VideoShareHelper$ReportDislikeAction$2
  implements ReadInJoyDisLikeDialogView.OnUninterestConfirmListener
{
  VideoShareHelper$ReportDislikeAction$2(VideoShareHelper.ReportDislikeAction paramReportDislikeAction, AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    VideoShareHelper.c(this.c.a, true);
    RIJQQAppInterfaceUtil.d();
    VideoShareHelper.m(this.c.a).dismiss();
    ((Animation)VideoShareHelper.p(this.c.a).getTag(2131436721)).setAnimationListener(new VideoShareHelper.ReportDislikeAction.2.1(this, paramArrayList));
    VideoShareHelper.p(this.c.a).startAnimation((Animation)VideoShareHelper.p(this.c.a).getTag(2131436721));
    PublicAccountReportUtils.b(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, new VideoR5.Builder(VideoReporter.a(null, null, null, null, this.b)).k(this.a.innerUniqueID).a(paramArrayList).b().a(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.ReportDislikeAction.2
 * JD-Core Version:    0.7.0.1
 */