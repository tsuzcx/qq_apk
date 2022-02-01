package com.tencent.mobileqq.kandian.biz.pts.component;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.HotWordInfo;
import com.tencent.mobileqq.kandian.repo.feeds.HotWordItem;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.report.ReportInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ComponentContentHotSearch$ViewHolder
  implements View.OnClickListener
{
  HotWordItem a;
  TextView b;
  TextView c;
  
  protected ComponentContentHotSearch$ViewHolder(ComponentContentHotSearch paramComponentContentHotSearch) {}
  
  public void onClick(View paramView)
  {
    paramView = new ActivityURIRequest(this.c.getContext(), "/pubaccount/browser");
    paramView.extra().putString("url", this.a.b);
    QRoute.startUri(paramView, null);
    paramView = RIJTransMergeKanDianReport.a(this.a.a, ComponentContentHotSearch.a(this.d).innerUniqueID, ComponentContentHotSearch.a(this.d).hotWordInfo.a.indexOf(this.a) + 1);
    try
    {
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80096DD", "0X80096DD", 0, 0, "", "", "", paramView.toString(), false);
    }
    catch (Exception paramView)
    {
      localObject = ComponentContentHotSearch.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick, e = ");
      localStringBuilder.append(paramView);
      QLog.e((String)localObject, 1, localStringBuilder.toString());
    }
    RIJJumpUtils.a(this.d.getContext(), ComponentContentHotSearch.a(this.d), ComponentContentHotSearch.b(this.d), (int)ComponentContentHotSearch.a(this.d).mChannelID);
    paramView = new ArrayList();
    Object localObject = new ReportInfo();
    ((ReportInfo)localObject).mUin = RIJQQAppInterfaceUtil.c();
    ((ReportInfo)localObject).mOperation = 53;
    ((ReportInfo)localObject).mInnerId = ComponentContentHotSearch.a(this.d).innerUniqueID;
    ((ReportInfo)localObject).mHotWord = this.a.a;
    paramView.add(localObject);
    ReadInJoyLogicEngine.a().a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentHotSearch.ViewHolder
 * JD-Core Version:    0.7.0.1
 */