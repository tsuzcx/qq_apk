package com.tencent.mobileqq.extendfriend.fragment;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.bean.StrangerInfo;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.HashMap;

class ExtendFriendBaseFragment$2
  implements ActionSheet.OnButtonClickListener
{
  ExtendFriendBaseFragment$2(ExtendFriendBaseFragment paramExtendFriendBaseFragment, StrangerInfo paramStrangerInfo, boolean paramBoolean1, boolean paramBoolean2, RecyclerView.ViewHolder paramViewHolder) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      NewReportPlugin.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanStrangerInfo.mUin, NewReportPlugin.b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanStrangerInfo.mUin, NewReportPlugin.b(2)), null, null, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 20005, null, null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009C8F", "0X8009C8F", 0, 0, "", "", "", "");
      paramView = new HashMap();
      paramView.put("frompage", "3");
      paramView.put("to_uid", this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanStrangerInfo.mUin);
      ExpandReportUtils.a("click#complaint_page#complaint", true, -1L, -1L, paramView, true, true);
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendHandler != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendHandler.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendBeanStrangerInfo.mUin);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentWidgetActionSheet != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentWidgetActionSheet = null;
      }
      return;
    }
    if ((this.jdField_a_of_type_Boolean) && (!this.b)) {
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.a(false, true, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "1");
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "4");
      return;
      if ((!this.jdField_a_of_type_Boolean) && (this.b))
      {
        if (paramInt == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.a(true, false, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
          VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "2");
        }
      }
      else if ((this.b) && (this.jdField_a_of_type_Boolean))
      {
        if (paramInt == 1)
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.a(false, true, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
          VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "1");
        }
        else if (paramInt == 2)
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.a(true, false, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
          VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "2");
        }
      }
      else if ((!this.jdField_a_of_type_Boolean) && (!this.b) && (paramInt == 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendBaseFragment.a(false, false, this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder);
        VasWebviewUtil.reportCommercialDrainage("strangers_makefriend", "plaza_actionsheet", "", 0, "", "3");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */