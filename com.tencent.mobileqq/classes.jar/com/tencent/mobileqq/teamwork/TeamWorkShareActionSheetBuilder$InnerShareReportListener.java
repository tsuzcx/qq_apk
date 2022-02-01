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
  private TeamWorkFileImportInfo jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo;
  private ShareActionSheet.OnItemClickListener jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener;
  private WeakReference<QQBrowserActivity> jdField_a_of_type_JavaLangRefWeakReference;
  private WeakReference<WebView> b;
  
  TeamWorkShareActionSheetBuilder$InnerShareReportListener(QQBrowserActivity paramQQBrowserActivity, WebView paramWebView, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, ShareActionSheet.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQBrowserActivity);
    this.b = new WeakReference(paramWebView);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo = paramTeamWorkFileImportInfo;
    this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener = paramOnItemClickListener;
  }
  
  public void onItemClick(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, ShareActionSheet paramShareActionSheet)
  {
    QLog.w("TeamWorkShareActionSheetBuilder", 1, "inner on item click");
    ShareActionSheet.OnItemClickListener localOnItemClickListener = this.jdField_a_of_type_ComTencentMobileqqWidgetShareShareActionSheet$OnItemClickListener;
    if (localOnItemClickListener != null) {
      localOnItemClickListener.onItemClick(paramActionSheetItem, paramShareActionSheet);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo == null) {
      return;
    }
    QLog.w("TeamWorkShareActionSheetBuilder", 1, "info exist");
    if (!this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo.d()) {
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
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).reportOnlinePreview(this.jdField_a_of_type_ComTencentMobileqqTeamworkBeanTeamWorkFileImportInfo, paramActionSheetItem, "0X8009F34");
    }
    paramActionSheetItem = (QQBrowserActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.TeamWorkShareActionSheetBuilder.InnerShareReportListener
 * JD-Core Version:    0.7.0.1
 */