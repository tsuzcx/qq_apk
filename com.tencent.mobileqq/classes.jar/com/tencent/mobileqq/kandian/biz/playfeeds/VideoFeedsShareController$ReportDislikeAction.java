package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView;
import com.tencent.mobileqq.kandian.biz.share.ShareAction;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class VideoFeedsShareController$ReportDislikeAction
  extends ShareAction
{
  VideoFeedsShareController$ReportDislikeAction(VideoFeedsShareController paramVideoFeedsShareController) {}
  
  public int a()
  {
    return 7;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoFeedsShareController.b(this.a, true);
    paramString = new JSONObject();
    try
    {
      paramString.put("channel_id", 409409);
      paramString.put("source", 2);
    }
    catch (JSONException paramVideoInfo)
    {
      paramVideoInfo.printStackTrace();
    }
    paramVideoInfo = VideoFeedsShareController.a(this.a);
    if ((paramVideoInfo.b != null) && (paramVideoInfo.b.size() > 0))
    {
      paramActionSheetItem = this.a;
      VideoFeedsShareController.a(paramActionSheetItem, (ActionSheet)ActionSheetHelper.a(VideoFeedsShareController.a(paramActionSheetItem), null));
      paramActionSheetItem = new VideoFeedsShareController.ReportDislikeAction.1(this);
      VideoFeedsShareController.a(this.a).registerWatchDisMissActionListener(paramActionSheetItem);
      paramActionSheetItem = new ReadInJoyDisLikeDialogView(VideoFeedsShareController.a(this.a));
      paramActionSheetItem.setOnUninterestConfirmListener(new VideoFeedsShareController.ReportDislikeAction.2(this, paramVideoInfo, paramString));
      paramActionSheetItem.setUninterestData(paramVideoInfo.b);
      VideoFeedsShareController.a(this.a).setActionContentView(paramActionSheetItem, null);
      try
      {
        if (VideoFeedsShareController.a(this.a).isShowing()) {
          return;
        }
        if ((VersionUtils.g()) && (!ShortVideoUtils.isInFullScreenBlackList()))
        {
          VideoFeedsShareController.a(this.a).getWindow().setFlags(8, 8);
          VideoFeedsShareController.a(this.a).getWindow().getDecorView().setSystemUiVisibility(VideoFeedsShareController.a(this.a).getWindow().getDecorView().getSystemUiVisibility());
          VideoFeedsShareController.a(this.a).setOnShowListener(new VideoFeedsShareController.ReportDislikeAction.3(this));
        }
        VideoFeedsShareController.a(this.a).show();
        paramVideoInfo = new VideoR5.Builder(VideoReporter.a(null, null, null, null, paramString)).j(paramVideoInfo.g).a().a();
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).videoDataReportWithFansInfoInR5(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, paramVideoInfo, false);
        return;
      }
      catch (Exception paramVideoInfo)
      {
        paramString = this.a;
        paramActionSheetItem = new StringBuilder();
        paramActionSheetItem.append("dislikeSheet.show exception=");
        paramActionSheetItem.append(paramVideoInfo);
        VideoFeedsShareController.a(paramString, paramActionSheetItem.toString());
        return;
      }
    }
    else
    {
      paramString = this.a;
      paramActionSheetItem = new StringBuilder();
      paramActionSheetItem.append("文章ID为：");
      paramActionSheetItem.append(paramVideoInfo.g);
      paramActionSheetItem.append(HardCodeUtil.a(2131715993));
      VideoFeedsShareController.a(paramString, paramActionSheetItem.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsShareController.ReportDislikeAction
 * JD-Core Version:    0.7.0.1
 */