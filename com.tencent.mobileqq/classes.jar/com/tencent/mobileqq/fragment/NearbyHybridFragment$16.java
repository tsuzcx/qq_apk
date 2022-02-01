package com.tencent.mobileqq.fragment;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.INearbyAppInterface;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.ipc.INearbyProcManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;

class NearbyHybridFragment$16
  implements View.OnClickListener
{
  NearbyHybridFragment$16(NearbyHybridFragment paramNearbyHybridFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (String)((INearbySPUtil)QRoute.api(INearbySPUtil.class)).getValue(this.a.k.getCurrentAccountUin(), "nearby_mine_page_url", "");
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("onClick, server mine url=");
      paramView.append((String)localObject);
      QLog.d("nearby.NearbyHybridFragment", 2, paramView.toString());
    }
    paramView = (View)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramView = "https://nearby.qq.com/nearby-index/mine.html?_bid=3027&_wv=16777218";
    }
    localObject = new Intent(this.a.ag, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", paramView);
    this.a.getActivity().startActivity((Intent)localObject);
    paramView = (AppInterface)this.a.k;
    boolean bool = false;
    NearbyUtils.b(paramView, "my_click", 0);
    if (this.a.Z != null) {
      bool = this.a.Z.h();
    }
    this.a.k.getNearbyProcManager().b(42);
    try
    {
      paramView = new StringBuilder();
      paramView.append(bool);
      paramView.append("");
      ReportController.b(null, "dc00899", "grp_lbs", "", "entry", "nearby_frag_mine_click_tmp", 0, 0, paramView.toString(), "", "", "");
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.fragment.NearbyHybridFragment.16
 * JD-Core Version:    0.7.0.1
 */