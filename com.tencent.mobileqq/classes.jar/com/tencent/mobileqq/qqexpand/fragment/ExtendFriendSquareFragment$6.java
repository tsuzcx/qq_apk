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
    QPublicFragmentActivity.startForResult(this.a.h, ExtendFriendSearchFragment.class, 3);
    this.a.h.overridePendingTransition(0, 2130772473);
    ReportController.b(this.a.i, "dc00898", "", "", "0X8009417", "0X8009417", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString, int paramInt)
  {
    if (!paramString.equals(this.a.N))
    {
      ExtendFriendSquareFragment localExtendFriendSquareFragment = this.a;
      localExtendFriendSquareFragment.N = paramString;
      boolean bool1;
      if ("推荐".equals(localExtendFriendSquareFragment.N))
      {
        ExtendFriendSquareFragment.a(this.a, false);
        bool1 = ExtendFriendSquareFragment.g(this.a);
      }
      else
      {
        bool1 = false;
      }
      boolean bool2 = ExtendFriendSquareFragment.a(this.a, false, paramString);
      long l = Math.abs(System.currentTimeMillis() - ExtendFriendSquareFragment.h(this.a));
      if ((bool2) && (l <= 60000L) && (!bool1))
      {
        ExtendFriendSquareFragment.b(this.a, true);
      }
      else
      {
        ExtendFriendSquareFragment.b(this.a, false);
        this.a.m.c();
        this.a.m.notifyDataSetChanged();
        this.a.m.a(false);
        ExtendFriendSquareFragment.d(this.a);
        ExtendFriendSquareFragment.a(this.a).removeMessages(11);
        ExtendFriendSquareFragment.a(this.a).sendEmptyMessageDelayed(11, 500L);
      }
      paramString = new HashMap();
      paramString.put("small_tab_id", this.a.N);
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#voice_tab#small_tab", true, -1L, -1L, paramString, true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendSquareFragment.6
 * JD-Core Version:    0.7.0.1
 */