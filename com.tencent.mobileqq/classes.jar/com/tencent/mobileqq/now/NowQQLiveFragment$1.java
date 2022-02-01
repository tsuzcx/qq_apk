package com.tencent.mobileqq.now;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.now.roport.NowQQLiveDataReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class NowQQLiveFragment$1
  implements OnItemSelectListener
{
  NowQQLiveFragment$1(NowQQLiveFragment paramNowQQLiveFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if (4 == paramInt)
    {
      paramView = new ActivityURIRequest(this.a.getActivity(), "/pubaccount/detail");
      paramView.extra().putString("uin", NowQQLiveConstant.a);
      QRoute.startUri(paramView, null);
    }
    do
    {
      return;
      if (5 == paramInt)
      {
        paramView = new Intent();
        Bundle localBundle = new Bundle();
        paramView.setComponent(new ComponentName(this.a.getActivity(), ChatActivity.class));
        localBundle.putString("uin", NowQQLiveConstant.a);
        localBundle.putInt("uintype", 1008);
        localBundle.putString("uinname", HardCodeUtil.a(2131694575));
        paramView.putExtras(localBundle);
        paramView.setFlags(67108864);
        paramView.putExtra("isforceRequestDetail", false);
        paramView.putExtra("jump_from", 2);
        this.a.getActivity().startActivity(paramView);
        NowQQLiveDataReport.a();
        NowQQLiveDataReport.b();
        return;
      }
    } while (1 != paramInt);
    NowQQLiveFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.now.NowQQLiveFragment.1
 * JD-Core Version:    0.7.0.1
 */