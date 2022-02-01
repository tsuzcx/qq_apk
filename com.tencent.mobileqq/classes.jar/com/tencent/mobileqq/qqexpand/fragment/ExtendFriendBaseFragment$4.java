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
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      NewReportPlugin.a(this.e.h, this.a.mUin, NewReportPlugin.b(this.a.mUin, NewReportPlugin.c(2)), null, null, this.e.i.getCurrentAccountUin(), 20005, null, null);
      ReportController.b(this.e.i, "dc00898", "", "", "0X8009C8F", "0X8009C8F", 0, 0, "", "", "", "");
      paramView = new HashMap();
      paramView.put("frompage", "3");
      paramView.put("to_uid", this.a.mUin);
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#complaint_page#complaint", true, -1L, -1L, paramView, true, true);
      if (this.e.k != null) {
        this.e.k.a(this.a.mUin);
      }
      if (this.e.L != null)
      {
        this.e.L.dismiss();
        this.e.L = null;
      }
      return;
    }
    if ((this.b) && (!this.c))
    {
      if (paramInt == 1)
      {
        this.e.a(false, true, this.d);
        VasWebviewUtil.a("strangers_makefriend", "plaza_actionsheet", "", 0, "", "1");
      }
    }
    else if ((!this.b) && (this.c))
    {
      if (paramInt == 1)
      {
        this.e.a(true, false, this.d);
        VasWebviewUtil.a("strangers_makefriend", "plaza_actionsheet", "", 0, "", "2");
      }
    }
    else if ((this.c) && (this.b))
    {
      if (paramInt == 1)
      {
        this.e.a(false, true, this.d);
        VasWebviewUtil.a("strangers_makefriend", "plaza_actionsheet", "", 0, "", "1");
      }
      else if (paramInt == 2)
      {
        this.e.a(true, false, this.d);
        VasWebviewUtil.a("strangers_makefriend", "plaza_actionsheet", "", 0, "", "2");
      }
    }
    else if ((!this.b) && (!this.c) && (paramInt == 1))
    {
      this.e.a(false, false, this.d);
      VasWebviewUtil.a("strangers_makefriend", "plaza_actionsheet", "", 0, "", "3");
    }
    this.e.L.cancel();
    VasWebviewUtil.a("strangers_makefriend", "plaza_actionsheet", "", 0, "", "4");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendBaseFragment.4
 * JD-Core Version:    0.7.0.1
 */