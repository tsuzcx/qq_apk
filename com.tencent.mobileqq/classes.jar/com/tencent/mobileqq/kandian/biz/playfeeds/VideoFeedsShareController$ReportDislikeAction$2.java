package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView.OnUninterestConfirmListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfoKt;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;
import org.json.JSONObject;

class VideoFeedsShareController$ReportDislikeAction$2
  implements ReadInJoyDisLikeDialogView.OnUninterestConfirmListener
{
  VideoFeedsShareController$ReportDislikeAction$2(VideoFeedsShareController.ReportDislikeAction paramReportDislikeAction, VideoInfo paramVideoInfo, JSONObject paramJSONObject) {}
  
  public boolean a(View paramView, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    paramView = RIJQQAppInterfaceUtil.d();
    if (this.a != null) {
      ReadInJoyLogicEngine.a().a(Long.valueOf(paramView).longValue(), BaseArticleInfoKt.a(VideoFeedsShareController.e(this.c.a).aB, paramArrayList, VideoFeedsShareController.e(this.c.a).l));
    }
    QQToast.makeText(VideoFeedsShareController.f(this.c.a), -1, VideoFeedsShareController.f(this.c.a).getString(2131897938), 0).show(VideoFeedsShareController.f(this.c.a).getResources().getDimensionPixelSize(2131299920));
    VideoFeedsShareController.k(this.c.a).dismiss();
    VideoFeedsShareController.b(this.c.a, false);
    PublicAccountReportUtils.b(null, null, "0X800913C", "0X800913C", 0, 0, null, null, null, new VideoR5.Builder(VideoReporter.a(null, null, null, null, this.b)).k(this.a.l).a(paramArrayList).b().a(), false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.ReportDislikeAction.2
 * JD-Core Version:    0.7.0.1
 */