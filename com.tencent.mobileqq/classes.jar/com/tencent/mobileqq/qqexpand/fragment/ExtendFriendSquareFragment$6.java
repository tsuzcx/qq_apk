package com.tencent.mobileqq.qqexpand.fragment;

import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.search.ExpandSearchBarView.OnItemClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;

class ExtendFriendSquareFragment$6
  implements ExpandSearchBarView.OnItemClickListener
{
  ExtendFriendSquareFragment$6(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void a()
  {
    QPublicFragmentActivity.startForResult(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, ExtendFriendSearchFragment.class, 3);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.overridePendingTransition(0, 2130772377);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009417", "0X8009417", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!paramString.equals(this.a.b))
    {
      ExtendFriendSquareFragment localExtendFriendSquareFragment = this.a;
      localExtendFriendSquareFragment.b = paramString;
      boolean bool1;
      if ("推荐".equals(localExtendFriendSquareFragment.b))
      {
        ExtendFriendSquareFragment.a(this.a, false);
        bool1 = ExtendFriendSquareFragment.c(this.a);
      }
      else
      {
        bool1 = false;
      }
      boolean bool2 = ExtendFriendSquareFragment.a(this.a, false, paramString);
      long l = Math.abs(System.currentTimeMillis() - ExtendFriendSquareFragment.a(this.a));
      if ((bool2) && (l <= 60000L) && (!bool1))
      {
        ExtendFriendSquareFragment.b(this.a, true);
      }
      else
      {
        ExtendFriendSquareFragment.b(this.a, false);
        this.a.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a();
        this.a.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.notifyDataSetChanged();
        this.a.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentRecyclerViewAdapter.a(false);
        ExtendFriendSquareFragment.c(this.a);
        ExtendFriendSquareFragment.a(this.a).removeMessages(11);
        ExtendFriendSquareFragment.a(this.a).sendEmptyMessageDelayed(11, 500L);
      }
      paramString = new HashMap();
      paramString.put("small_tab_id", this.a.b);
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#voice_tab#small_tab", true, -1L, -1L, paramString, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.6
 * JD-Core Version:    0.7.0.1
 */