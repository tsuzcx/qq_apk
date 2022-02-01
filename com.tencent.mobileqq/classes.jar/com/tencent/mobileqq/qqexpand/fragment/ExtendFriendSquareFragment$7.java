package com.tencent.mobileqq.qqexpand.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.statistics.ReportController;

class ExtendFriendSquareFragment$7
  implements View.OnClickListener
{
  ExtendFriendSquareFragment$7(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.i, "dc00898", "", "", "0X8009E2F", "0X8009E2F", 0, 0, "", "", "", "");
    if (this.a.c != null)
    {
      ExtendFriendReport.a().b(3);
      this.a.c.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.7
 * JD-Core Version:    0.7.0.1
 */