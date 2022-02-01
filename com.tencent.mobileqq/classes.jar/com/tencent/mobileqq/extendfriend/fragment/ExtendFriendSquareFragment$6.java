package com.tencent.mobileqq.extendfriend.fragment;

import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView.OnItemClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.util.WeakReferenceHandler;
import java.util.HashMap;

class ExtendFriendSquareFragment$6
  implements ExtendFriendSearchBarView.OnItemClickListener
{
  ExtendFriendSquareFragment$6(ExtendFriendSquareFragment paramExtendFriendSquareFragment) {}
  
  public void a()
  {
    PublicFragmentActivity.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ExtendFriendSearchFragment.class, 3);
    this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 2130772345);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8009417", "0X8009417", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!paramString.equals(this.a.b))
    {
      this.a.b = paramString;
      if (!ExtendFriendManager.a.equals(this.a.b)) {
        break label225;
      }
      ExtendFriendSquareFragment.a(this.a, false);
    }
    label225:
    for (boolean bool1 = ExtendFriendSquareFragment.c(this.a);; bool1 = false)
    {
      boolean bool2 = ExtendFriendSquareFragment.a(this.a, false, paramString);
      long l = Math.abs(System.currentTimeMillis() - ExtendFriendSquareFragment.a(this.a));
      if ((!bool2) || (l > 60000L) || (bool1))
      {
        ExtendFriendSquareFragment.b(this.a, false);
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a();
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.notifyDataSetChanged();
        this.a.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentRecyclerViewAdapter.a(false);
        ExtendFriendSquareFragment.c(this.a);
        ExtendFriendSquareFragment.a(this.a).removeMessages(11);
        ExtendFriendSquareFragment.a(this.a).sendEmptyMessageDelayed(11, 500L);
      }
      for (;;)
      {
        paramString = new HashMap();
        paramString.put("small_tab_id", this.a.b);
        ExpandReportUtils.a("click#voice_tab#small_tab", true, -1L, -1L, paramString, true, true);
        return;
        ExtendFriendSquareFragment.b(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendSquareFragment.6
 * JD-Core Version:    0.7.0.1
 */