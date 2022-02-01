package com.tencent.mobileqq.qqexpand.fragment;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.HashMap;

class ExtendFriendBaseFragment$4
  implements ActionSheet.OnButtonClickListener
{
  ExtendFriendBaseFragment$4(ExtendFriendBaseFragment paramExtendFriendBaseFragment, StrangerInfo paramStrangerInfo, boolean paramBoolean1, boolean paramBoolean2, RecyclerView.ViewHolder paramViewHolder) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedStrangerInfo.mUin, NewReportPlugin.b(this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedStrangerInfo.mUin, NewReportPlugin.b(2)), null, null, this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 20005, null, null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009C8F", "0X8009C8F", 0, 0, "", "", "", "");
      paramView = new HashMap();
      paramView.put("frompage", "3");
      paramView.put("to_uid", this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedStrangerInfo.mUin);
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#complaint_page#complaint", true, -1L, -1L, paramView, true, true);
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkIExpandHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkIExpandHandler.a(this.jdField_a_of_type_ComTencentMobileqqQqexpandBeanFeedStrangerInfo.mUin);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentWidgetActionSheet != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentWidgetActionSheet = null;
      }
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (!this.b))
    {
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendBaseFragment.a(false, true, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
        VasWebviewUtil.a("strangers_makefriend", "plaza_actionsheet", "", 0, "", "1");
      }
    }
    else if ((!this.jdField_a_of_type_Boolean) && (this.b))
    {
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendBaseFragment.a(true, false, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
        VasWebviewUtil.a("strangers_makefriend", "plaza_actionsheet", "", 0, "", "2");
      }
    }
    else if ((this.b) && (this.jdField_a_of_type_Boolean))
    {
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendBaseFragment.a(false, true, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
        VasWebviewUtil.a("strangers_makefriend", "plaza_actionsheet", "", 0, "", "1");
      }
      else if (paramInt == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendBaseFragment.a(true, false, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
        VasWebviewUtil.a("strangers_makefriend", "plaza_actionsheet", "", 0, "", "2");
      }
    }
    else if ((!this.jdField_a_of_type_Boolean) && (!this.b) && (paramInt == 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendBaseFragment.a(false, false, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
      VasWebviewUtil.a("strangers_makefriend", "plaza_actionsheet", "", 0, "", "3");
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
    VasWebviewUtil.a("strangers_makefriend", "plaza_actionsheet", "", 0, "", "4");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment.4
 * JD-Core Version:    0.7.0.1
 */