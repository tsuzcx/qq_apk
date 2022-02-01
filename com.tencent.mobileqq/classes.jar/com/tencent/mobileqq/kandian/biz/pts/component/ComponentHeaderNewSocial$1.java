package com.tencent.mobileqq.kandian.biz.pts.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import org.json.JSONException;
import org.json.JSONObject;

class ComponentHeaderNewSocial$1
  implements View.OnClickListener
{
  ComponentHeaderNewSocial$1(ComponentHeaderNewSocial paramComponentHeaderNewSocial, AbsBaseArticleInfo paramAbsBaseArticleInfo) {}
  
  public void onClick(View paramView)
  {
    try
    {
      paramView = new JSONObject();
      paramView.put("folder_status", RIJKanDianFolderStatus.reportFolderStatus);
      paramView.put("feeds_source", String.valueOf(this.a.mSocialFeedInfo.c.a));
      paramView.put("tab_source", RIJTransMergeKanDianReport.b());
      paramView.put("kandian_mode", RIJAppSetting.b());
      paramView.put("rowkey", this.a.innerUniqueID);
      paramView = paramView.toString();
    }
    catch (JSONException paramView)
    {
      paramView.printStackTrace();
      paramView = "";
    }
    PublicAccountReportUtils.a(null, this.a.mSubscribeID, "0X8007B63", "0X8007B63", 0, 0, String.valueOf(this.a.mFeedId), String.valueOf(this.a.mArticleID), "", paramView, false);
    paramView = new StringBuilder();
    paramView.append(ReadInJoyConstants.g);
    paramView.append(this.a.mFeedId);
    paramView = paramView.toString();
    ReadInJoyUtils.a(this.b.getContext(), paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderNewSocial.1
 * JD-Core Version:    0.7.0.1
 */