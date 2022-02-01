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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new EcshopNewPageFragment.2(this);
  private SparseArray<EcshopTabFragment> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private TabLayoutController jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTabLayoutController;
  private EcshopTabFragment jdField_a_of_type_ComTencentMobileqqEcshopWidgetEcshopTabFragment;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private boolean c;
  private boolean d = false;
  private boolean e = false;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setTitle(getResources().getString(2131691856));
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setRightImage(getResources().getDrawable(2130850470));
    ((ImageView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.findViewById(2131369563)).setImageResource(2130851067);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setOnItemSelectListener(new EcshopNewPageFragment.1(this));
    if (ThemeUtil.isNowThemeIsNight(AppUtils.a(), false, null))
    {
      ImmersiveUtils.setStatusTextColor(false, getActivity().getWindow());
      this.b.findViewById(2131371886).setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.setBackgroundColor(-16777216);
    }
    else
    {
      this.b.findViewById(2131371886).setVisibility(8);
    }
    b(this.b);
  }
  
  private void a(Intent paramIntent)
  {
    if (paramIntent != null)
    {
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("tab_id", 1);
      this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("jump_url");
      this.c = paramIntent.getBooleanExtra("req_qgg_title", true);
      this.e = paramIntent.getBooleanExtra("req_qgg_hide_tab", false);
    }
    else
    {
      this.jdField_a_of_type_Int = getArguments().getInt("tab_id");
      this.jdField_a_of_type_JavaLangString = getArguments().getString("jump_url", "");
      this.c = getArguments().getBoolean("req_qgg_title", true);
      this.e = getArguments().getBoolean("req_qgg_hide_tab", false);
    }
    if (QLog.isColorLevel()) {
      QLog.i("Ecshop_EcshopNewPageFragment", 2, this.jdField_a_of_type_JavaLangString);
    }
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTabLayoutController;
    if (paramIntent != null) {
      paramIntent.a(this.jdField_a_of_type_Int);
    }
    EcshopTabFragment localEcshopTabFragment = (EcshopTabFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    paramIntent = localEcshopTabFragment;
    if (localEcshopTabFragment == null)
    {
      paramIntent = new EcshopTabFragment();
      this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Int, paramIntent);
    }
    paramIntent.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
    paramIntent = (EcshopTabFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if (paramIntent != null) {
      a(paramIntent);
    }
  }
  
  private void a(EcshopTabFragment paramEcshopTabFragment)
  {
    FragmentTransaction localFragmentTransaction = getChildFragmentManager().beginTransaction();
    EcshopTabFragment localEcshopTabFragment = this.jdField_a_of_type_ComTencentMobileqqEcshopWidgetEcshopTabFragment;
    if (localEcshopTabFragment == null)
    {
      if (!paramEcshopTabFragment.isAdded()) {
        localFragmentTransaction.add(2131365175, paramEcshopTabFragment).commitAllowingStateLoss();
      } else {
        localFragmentTransaction.show(paramEcshopTabFragment).commitAllowingStateLoss();
      }
    }
    else if (!localEcshopTabFragment.a(paramEcshopTabFragment)) {
      if (!paramEcshopTabFragment.isAdded()) {
        localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqEcshopWidgetEcshopTabFragment).add(2131365175, paramEcshopTabFragment).commitAllowingStateLoss();
      } else {
        localFragmentTransaction.hide(this.jdField_a_of_type_ComTencentMobileqqEcshopWidgetEcshopTabFragment).show(paramEcshopTabFragment).commitAllowingStateLoss();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqEcshopWidgetEcshopTabFragment = paramEcshopTabFragment;
  }
  
  private void b(View paramView)
  {
    Object localObject = (LinearLayout)paramView.findViewById(2131365354);
    paramView = EcshopConfProcessor.a();
    if (paramView == null) {
      return;
    }
    if (QQShopConfigUtil.a(paramView))
    {
      localObject = new TabLayoutController((LinearLayout)localObject);
      ((TabLayoutController)localObject).a(this.e ^ true);
      ((TabLayoutController)localObject).a(paramView.a, paramView.b);
      ((TabLayoutController)localObject).a(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTabLayoutController = ((TabLayoutController)localObject);
      QQShopRedPointUtil.a(this.c);
    }
  }
  
  protected int a()
  {
    return 2131561890;
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    a();
  }
  
  public void a(@NotNull ArrayList<RedPointInfo> paramArrayList)
  {
    TabLayoutController localTabLayoutController = this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTabLayoutController;
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
      if ((!this.d) && (getActivity() != null))
      {
        paramBundle = new IntentFilter();
        paramBundle.addAction("com.tencent.mobileqq.ecshop.finish");
        paramBundle.addAction("action_notify_view_update");
        getActivity().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramBundle);
        this.d = true;
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
    Object localObject = this.jdField_a_of_type_AndroidUtilSparseArray;
    if ((localObject != null) && (((SparseArray)localObject).size() > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        localObject = (EcshopTabFragment)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
        if ((localObject != null) && (((EcshopTabFragment)localObject).a != null)) {
          ((EcshopTabFragment)localObject).a.c();
        }
        i += 1;
      }
    }
    localObject = this.jdField_a_of_type_AndroidUtilSparseArray;
    if ((localObject != null) && (((SparseArray)localObject).size() > 0)) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    EcshopWebviewPool.a().a(null, "");
    try
    {
      if ((this.d) && (getActivity() != null))
      {
        getActivity().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.d = false;
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
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
      ((StringBuilder)localObject1).append("isJumpToThirdPage: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_Boolean);
      QLog.i("Ecshop_EcshopNewPageFragment", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (EcshopTabFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if ((localObject1 != null) && (((EcshopTabFragment)localObject1).a != null)) {
      ((EcshopTabFragment)localObject1).a.b();
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(SystemClock.elapsedRealtime());
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    localStringBuilder.append("");
    ReportUtil.a("gouwu.aio.stay", (String)localObject1, (String)localObject2, localStringBuilder.toString());
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject1).append("");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(SystemClock.elapsedRealtime());
    ((StringBuilder)localObject2).append("");
    localObject2 = ((StringBuilder)localObject2).toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long);
    localStringBuilder.append("");
    ReportUtil.b("gouwu_aio_stay", (String)localObject1, (String)localObject2, localStringBuilder.toString());
  }
  
  public void onResume()
  {
    super.onResume();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" EcshopNewPageFragment [onResume] mCurrentTabId: ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    QLog.i("Ecshop_EcshopNewPageFragment", 2, ((StringBuilder)localObject).toString());
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    }
    this.jdField_a_of_type_Boolean = false;
    localObject = (EcshopTabFragment)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
    if ((localObject != null) && (((EcshopTabFragment)localObject).a != null)) {
      ((EcshopTabFragment)localObject).a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.widget.EcshopNewPageFragment
 * JD-Core Version:    0.7.0.1
 */