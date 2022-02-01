package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import java.lang.ref.WeakReference;

class TeamWorkShareActionSheetBuilder$InnerShareReportListener
  implements ShareActionSheet.OnItemClickListener
{
  private WeakReference<QQBrowserActivity> a;
  private WeakReference<WebView> b;
  private TeamWorkFileImportInfo c;
  private ShareActionSheet.OnItemClickListener d;
  
  TeamWorkShareActionSheetBuilder$InnerShareReportListener(QQBrowserActivity paramQQBrowserActivity, WebView paramWebView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    this.a = new WeakReference(paramQQBrowserActivity);
    this.b = new WeakReference(paramWebView);
    this.c = paramTeamWorkFileImportInfo;
    this.d = paramOnItemClickListener;
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    QLog.w("TeamWorkShareActionSheetBuilder", 1, "inner on item click");
    ShareActionSheet.OnItemClickListener localOnItemClickListener = this.d;
    if (localOnItemClickListener != null) {
      localOnItemClickListener.onItemClick(paramActionSheetItem, paramShareActionSheet);
    }
    if (this.c == null) {
      return;
    }
    QLog.w("TeamWorkShareActionSheetBuilder", 1, "info exist");
    if (!this.c.d()) {
      return;
    }
    QLog.w("TeamWorkShareActionSheetBuilder", 1, "from online preview");
    int i = paramActionSheetItem.action;
    if ((i == 1) || (i == 2) || (i == 9) || (i == 10))
    {
      paramActionSheetItem = (WebView)this.b.get();
      if (paramActionSheetItem != null) {
        paramActionSheetItem = paramActionSheetItem.getUrl();
      } else {
        paramActionSheetItem = "";
      }
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(this.c, paramActionSheetItem, "0X8009F34");
    }
    paramActionSheetItem = (QQBrowserActivity)this.a.get();
    if (paramActionSheetItem != null)
    {
      if (i == 1)
      {
        ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).tryReportHistoryTab(paramActionSheetItem.getIntent(), "0X800A16F");
        return;
      }
      if ((i != 2) && (i != 9) && (i != 10) && (i != 3) && (i != 12))
      {
        if (i == 6)
        {
          ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).tryReportHistoryTab(paramActionSheetItem.getIntent(), "0X800A170");
          return;
        }
        if (i == 5) {
          ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).tryReportHistoryTab(paramActionSheetItem.getIntent(), "0X800A171");
        }
      }
      else
      {
        ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).tryReportHistoryTab(paramActionSheetItem.getIntent(), "0X800A16E");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder.InnerShareReportListener
 * JD-Core Version:    0.7.0.1
 */