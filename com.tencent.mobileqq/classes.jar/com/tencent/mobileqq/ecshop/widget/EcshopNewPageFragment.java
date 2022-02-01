package com.tencent.mobileqq.ecshop.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfProcessor;
import com.tencent.mobileqq.ecshop.conf.QQShopConfigUtil;
import com.tencent.mobileqq.ecshop.redpoint.QQShopRedPointUtil;
import com.tencent.mobileqq.ecshop.redpoint.QQShopRedPointUtil.IGetRedPointCallback;
import com.tencent.mobileqq.ecshop.redpoint.RedPointInfo;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.utils.AppUtils;
import com.tencent.mobileqq.ecshop.view.EcshopNewPageWebViewBuilder;
import com.tencent.mobileqq.ecshop.view.EcshopWebviewPool;
import com.tencent.mobileqq.ecshop.view.controller.TabLayoutController;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class EcshopNewPageFragment
  extends QIphoneTitleBarFragment
  implements QQShopRedPointUtil.IGetRedPointCallback
{
  public boolean a;
  private int b;
  private String c;
  private boolean d;
  private SparseArray<EcshopTabFragment> e = new SparseArray();
  private long f;
  private TabLayoutController g;
  private boolean w = false;
  private boolean x = false;
  private EcshopTabFragment y;
  private BroadcastReceiver z = new EcshopNewPageFragment.2(this);
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      this.b = paramIntent.getIntExtra("tab_id", 1);
      this.c = paramIntent.getStringExtra("jump_url");
      this.d = paramIntent.getBooleanExtra("req_qgg_title", true);
      this.x = paramIntent.getBooleanExtra("req_qgg_hide_tab", false);
    }
    else
    {
      this.b = getArguments().getInt("tab_id");
      this.c = getArguments().getString("jump_url", "");
      this.d = getArguments().getBoolean("req_qgg_title", true);
      this.x = getArguments().getBoolean("req_qgg_hide_tab", false);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopNewPageFragment", 2, this.c);
    }
    paramIntent = this.g;
    if (paramIntent != null) {
      paramIntent.a(this.b);
    }
    EcshopTabFragment localEcshopTabFragment = (EcshopTabFragment)this.e.get(this.b);
    paramIntent = localEcshopTabFragment;
    if (localEcshopTabFragment == null)
    {
      paramIntent = new EcshopTabFragment();
      this.e.put(this.b, paramIntent);
    }
    paramIntent.a(this.b, this.c);
    paramIntent = (EcshopTabFragment)this.e.get(this.b);
    if (paramIntent != null) {
      a(paramIntent);
    }
  }
  
  private void a(EcshopTabFragment paramEcshopTabFragment)
  {
    FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
    EcshopTabFragment localEcshopTabFragment = this.y;
    if (localEcshopTabFragment == null)
    {
      if (!paramEcshopTabFragment.isAdded()) {
        localFragmentTransaction.add(2131431328, paramEcshopTabFragment).commitAllowingStateLoss();
      } else {
        localFragmentTransaction.show(paramEcshopTabFragment).commitAllowingStateLoss();
      }
    }
    else if (!localEcshopTabFragment.a(paramEcshopTabFragment)) {
      if (!paramEcshopTabFragment.isAdded()) {
        localFragmentTransaction.hide(this.y).add(2131431328, paramEcshopTabFragment).commitAllowingStateLoss();
      } else {
        localFragmentTransaction.hide(this.y).show(paramEcshopTabFragment).commitAllowingStateLoss();
      }
    }
    this.y = paramEcshopTabFragment;
  }
  
  private void b()
  {
    this.p.setTitle(getResources().getString(2131888821));
    this.p.setRightImage(getResources().getDrawable(2130852266));
    ((ImageView)this.p.findViewById(2131436666)).setImageResource(2130853298);
    this.p.setOnItemSelectListener(new EcshopNewPageFragment.1(this));
    if (ThemeUtil.isNowThemeIsNight(AppUtils.a(), false, null))
    {
      ImmersiveUtils.setStatusTextColor(false, getActivity().getWindow());
      this.t.findViewById(2131439329).setVisibility(0);
      this.p.setBackgroundColor(-16777216);
    }
    else
    {
      this.t.findViewById(2131439329).setVisibility(8);
    }
    b(this.t);
  }
  
  private void b(View paramView)
  {
    Object localObject = (LinearLayout)paramView.findViewById(2131431540);
    paramView = EcshopConfProcessor.a();
    if (paramView == null) {
      return;
    }
    if (QQShopConfigUtil.a(paramView))
    {
      localObject = new TabLayoutController((LinearLayout)localObject);
      ((TabLayoutController)localObject).a(this.x ^ true);
      ((TabLayoutController)localObject).a(paramView.k, paramView.e);
      ((TabLayoutController)localObject).a(this.b);
      this.g = ((TabLayoutController)localObject);
      QQShopRedPointUtil.a(this.d);
    }
  }
  
  protected int a()
  {
    return 2131628308;
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    b();
  }
  
  public void a(@NotNull ArrayList<RedPointInfo> paramArrayList)
  {
    TabLayoutController localTabLayoutController = this.g;
    if (localTabLayoutController != null) {
      localTabLayoutController.a(paramArrayList);
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.overridePendingTransition(0, 0);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    try
    {
      if (getActivity() != null) {
        getActivity().sendBroadcast(new Intent("com.tencent.mobileqq.ecshop.finish"));
      }
      QQShopRedPointUtil.a();
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Ecshop_EcshopNewPageFragment", 2, "onPageBack", localThrowable);
      }
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopNewPageFragment", 2, "[onCreate]");
    }
    super.onCreate(paramBundle);
    try
    {
      if ((!this.w) && (getActivity() != null))
      {
        paramBundle = new IntentFilter();
        paramBundle.addAction("com.tencent.mobileqq.ecshop.finish");
        paramBundle.addAction("action_notify_view_update");
        getActivity().registerReceiver(this.z, paramBundle);
        this.w = true;
      }
    }
    catch (Throwable paramBundle)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onCreate] regist exitreceiver fail ");
      localStringBuilder.append(paramBundle);
      QLog.e("Ecshop_EcshopNewPageFragment", 1, localStringBuilder.toString());
    }
    QQShopRedPointUtil.a(this);
    a(null);
  }
  
  public void onDestroy()
  {
    QLog.i("Ecshop_EcshopNewPageFragment", 2, "[onDestroy]");
    super.onDestroy();
    Object localObject = this.e;
    if ((localObject != null) && (((SparseArray)localObject).size() > 0))
    {
      int i = 0;
      while (i < this.e.size())
      {
        localObject = (EcshopTabFragment)this.e.valueAt(i);
        if ((localObject != null) && (((EcshopTabFragment)localObject).c != null)) {
          ((EcshopTabFragment)localObject).c.c();
        }
        i += 1;
      }
    }
    localObject = this.e;
    if ((localObject != null) && (((SparseArray)localObject).size() > 0)) {
      this.e.clear();
    }
    EcshopWebviewPool.a().a(null, "");
    try
    {
      if ((this.w) && (getActivity() != null))
      {
        getActivity().unregisterReceiver(this.z);
        this.w = false;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    QQShopRedPointUtil.a();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" EcshopNewPageFragment [onPause] mCurrentTabId: ");
      ((StringBuilder)localObject1).append(this.b);
      ((StringBuilder)localObject1).append("isJumpToThirdPage: ");
      ((StringBuilder)localObject1).append(this.a);
      QLog.i("Ecshop_EcshopNewPageFragment", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (EcshopTabFragment)this.e.get(this.b);
    if ((localObject1 != null) && (((EcshopTabFragment)localObject1).c != null)) {
      ((EcshopTabFragment)localObject1).c.b();
    }
    if (this.a) {
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(SystemClock.elapsedRealtime());
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SystemClock.elapsedRealtime() - this.f);
    localStringBuilder.append("");
    ReportUtil.a("gouwu.aio.stay", (String)localObject1, (String)localObject2, localStringBuilder.toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.b);
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(SystemClock.elapsedRealtime());
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(SystemClock.elapsedRealtime() - this.f);
    localStringBuilder.append("");
    ReportUtil.b("gouwu_aio_stay", (String)localObject1, (String)localObject2, localStringBuilder.toString());
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" EcshopNewPageFragment [onResume] mCurrentTabId: ");
    ((StringBuilder)localObject).append(this.b);
    QLog.i("Ecshop_EcshopNewPageFragment", 2, ((StringBuilder)localObject).toString());
    if (!this.a) {
      this.f = SystemClock.elapsedRealtime();
    }
    this.a = false;
    localObject = (EcshopTabFragment)this.e.get(this.b);
    if ((localObject != null) && (((EcshopTabFragment)localObject).c != null)) {
      ((EcshopTabFragment)localObject).c.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.widget.EcshopNewPageFragment
 * JD-Core Version:    0.7.0.1
 */