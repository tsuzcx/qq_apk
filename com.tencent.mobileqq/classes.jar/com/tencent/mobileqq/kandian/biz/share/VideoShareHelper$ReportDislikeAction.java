package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class VideoShareHelper$ReportDislikeAction
  extends ShareAction
{
  VideoShareHelper$ReportDislikeAction(VideoShareHelper paramVideoShareHelper) {}
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    try
    {
      if (!VideoShareHelper.m(this.a).isShowing())
      {
        if ((VersionUtils.g()) && (!ShortVideoUtils.isInFullScreenBlackList()))
        {
          VideoShareHelper.m(this.a).getWindow().setFlags(8, 8);
          VideoShareHelper.m(this.a).getWindow().getDecorView().setSystemUiVisibility(VideoShareHelper.f(this.a).getWindow().getDecorView().getSystemUiVisibility());
          VideoShareHelper.m(this.a).setOnShowListener(new VideoShareHelper.ReportDislikeAction.3(this));
        }
        VideoShareHelper.m(this.a).show();
        PublicAccountReportUtils.b(null, null, "0X800913B", "0X800913B", 0, 0, null, null, null, new VideoR5.Builder(VideoReporter.a(null, null, null, null, paramJSONObject)).k(paramAbsBaseArticleInfo.innerUniqueID).b().a(), false);
        return;
      }
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      if (QLog.isColorLevel())
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("dislikeSheet.show exception=");
        paramJSONObject.append(paramAbsBaseArticleInfo);
        QLog.d("Q.readinjoy.video.VideoShareHelper", 2, paramJSONObject.toString());
      }
    }
  }
  
  public int a()
  {
    return 7;
  }
  
  public void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    VideoShareHelper.a(this.a, false);
    paramString = new JSONObject();
    try
    {
      paramString.put("channel_id", VideoShareHelper.k(this.a));
      paramString.put("source", 1);
    }
    catch (JSONException paramActionSheetItem)
    {
      paramActionSheetItem.printStackTrace();
    }
    if ((paramAbsBaseArticleInfo.mDislikeInfos != null) && (paramAbsBaseArticleInfo.mDislikeInfos.size() > 0))
    {
      paramActionSheetItem = this.a;
      VideoShareHelper.a(paramActionSheetItem, (ActionSheet)ActionSheetHelper.b(VideoShareHelper.f(paramActionSheetItem), null));
      paramActionSheetItem = new VideoShareHelper.ReportDislikeAction.1(this);
      VideoShareHelper.m(this.a).registerWatchDisMissActionListener(paramActionSheetItem);
      paramActionSheetItem = new ReadInJoyDisLikeDialogView(VideoShareHelper.g(this.a));
      paramActionSheetItem.setOnUninterestConfirmListener(new VideoShareHelper.ReportDislikeAction.2(this, paramAbsBaseArticleInfo, paramString));
      paramActionSheetItem.setUninterestData(paramAbsBaseArticleInfo.mDislikeInfos);
      VideoShareHelper.m(this.a).setActionContentView(paramActionSheetItem, null);
      a(paramAbsBaseArticleInfo, paramString);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("文章ID为：");
      paramString.append(paramAbsBaseArticleInfo.mArticleID);
      paramString.append("的负反馈数据为空!");
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.VideoShareHelper.ReportDislikeAction
 * JD-Core Version:    0.7.0.1
 */