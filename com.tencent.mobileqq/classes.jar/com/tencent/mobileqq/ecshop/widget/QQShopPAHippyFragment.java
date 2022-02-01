package com.tencent.mobileqq.ecshop.widget;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.fragment.app.FragmentActivity;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.utils.SerializableMap;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ecshop.conf.EcshopConfBean;
import com.tencent.mobileqq.ecshop.conf.EcshopConfProcessor;
import com.tencent.mobileqq.ecshop.conf.QQShopConfigUtil;
import com.tencent.mobileqq.ecshop.redpoint.QQShopRedPointUtil;
import com.tencent.mobileqq.ecshop.report.ReportUtil;
import com.tencent.mobileqq.ecshop.utils.EcshopUtils;
import com.tencent.mobileqq.ecshop.view.controller.TabLayoutController;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/ecshop/widget/QQShopPAHippyFragment;", "Lcom/tencent/hippy/qq/fragment/CommonHippyFragment;", "()V", "hasRegist", "", "isHideTab", "mCurrentTabId", "", "mExtiReceiver", "Landroid/content/BroadcastReceiver;", "mShouldReqQgg", "mStartTime", "", "mTabLayoutController", "Lcom/tencent/mobileqq/ecshop/view/controller/TabLayoutController;", "navBar", "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "doBussinessInitData", "Lorg/json/JSONObject;", "jsInitData", "getLayoutResId", "gotoErrorUrl", "initCustomTab", "", "contentView", "Landroid/view/View;", "initFragment", "intent", "Landroid/content/Intent;", "initNavBar", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "onResume", "reportStayTime", "setNavBar", "Companion", "qqshop-feature-impl_release"}, k=1, mv={1, 1, 16})
public final class QQShopPAHippyFragment
  extends CommonHippyFragment
{
  public static final QQShopPAHippyFragment.Companion a;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = (BroadcastReceiver)new QQShopPAHippyFragment.mExtiReceiver.1(this);
  private TabLayoutController jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTabLayoutController;
  private NavBarCommon jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  private boolean c = true;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqEcshopWidgetQQShopPAHippyFragment$Companion = new QQShopPAHippyFragment.Companion(null);
  }
  
  private final void a(Intent paramIntent)
  {
    boolean bool2 = false;
    boolean bool1 = true;
    if (paramIntent != null)
    {
      this.jdField_a_of_type_Int = paramIntent.getIntExtra("tab_id", 1);
      this.c = paramIntent.getBooleanExtra("req_qgg_title", true);
      this.b = paramIntent.getBooleanExtra("req_qgg_hide_tab", false);
    }
    else
    {
      paramIntent = getArguments();
      int i;
      if (paramIntent != null) {
        i = paramIntent.getInt("tab_id");
      } else {
        i = 0;
      }
      this.jdField_a_of_type_Int = i;
      paramIntent = getArguments();
      if (paramIntent != null) {
        bool1 = paramIntent.getBoolean("req_qgg_title", true);
      }
      this.c = bool1;
      paramIntent = getArguments();
      bool1 = bool2;
      if (paramIntent != null) {
        bool1 = paramIntent.getBoolean("req_qgg_hide_tab", false);
      }
      this.b = bool1;
    }
    paramIntent = this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTabLayoutController;
    if (paramIntent != null) {
      paramIntent.a(this.jdField_a_of_type_Int);
    }
  }
  
  private final void a(View paramView)
  {
    paramView = paramView.findViewById(2131365354);
    if (paramView != null)
    {
      Object localObject1 = (LinearLayout)paramView;
      paramView = EcshopConfProcessor.a();
      if (paramView != null)
      {
        Intrinsics.checkExpressionValueIsNotNull(paramView, "EcshopConfProcessor.loadConfig() ?: return");
        if (QQShopConfigUtil.a(paramView))
        {
          QQShopRedPointUtil.a(this.c);
          localObject1 = new TabLayoutController((LinearLayout)localObject1);
          ((TabLayoutController)localObject1).a(this.b ^ true);
          Object localObject2 = paramView.a;
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "ecshopConfBean.tabConfs");
          localObject2 = (List)localObject2;
          String str = paramView.b;
          Intrinsics.checkExpressionValueIsNotNull(str, "ecshopConfBean.tabBg");
          ((TabLayoutController)localObject1).a((List)localObject2, str);
          ((TabLayoutController)localObject1).a(this.jdField_a_of_type_Int);
          ((TabLayoutController)localObject1).a(this.jdField_a_of_type_Int, (Function1)new QQShopPAHippyFragment.initCustomTab..inlined.apply.lambda.1(this, paramView));
          this.jdField_a_of_type_ComTencentMobileqqEcshopViewControllerTabLayoutController = ((TabLayoutController)localObject1);
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout");
  }
  
  private final void b()
  {
    View localView = this.mRootView.findViewById(2131374337);
    Intrinsics.checkExpressionValueIsNotNull(localView, "mRootView.findViewById(R…qq_shop_pa_hippy_nav_bar)");
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon = ((NavBarCommon)localView);
    c();
  }
  
  private final void c()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("navBar");
    }
    ((NavBarCommon)localObject1).setTitle((CharSequence)"QQ购物");
    ((NavBarCommon)localObject1).setRightImage(((NavBarCommon)localObject1).getResources().getDrawable(2130850470));
    ((NavBarCommon)localObject1).setOnItemSelectListener((OnItemSelectListener)new QQShopPAHippyFragment.setNavBar..inlined.run.lambda.1(this));
    Object localObject2 = ((NavBarCommon)localObject1).getLayoutParams();
    if (localObject2 != null)
    {
      localObject2 = (LinearLayout.LayoutParams)localObject2;
      ((LinearLayout.LayoutParams)localObject2).setMargins(0, ImmersiveUtils.getStatusBarHeight((Context)getActivity()) - 1, 0, 0);
      ((NavBarCommon)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.mRootView.setBackgroundColor(-1);
      localObject1 = this.mRootView;
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "mRootView");
      localObject1 = (LinearLayout)((View)localObject1).findViewById(2131374338);
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon;
      if (localObject2 == null) {
        Intrinsics.throwUninitializedPropertyAccessException("navBar");
      }
      ((LinearLayout)localObject1).setBackgroundDrawable(((NavBarCommon)localObject2).getBackground());
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
  }
  
  private final void d()
  {
    ReportUtil.a("gouwu.aio.stay", String.valueOf(this.jdField_a_of_type_Int), String.valueOf(SystemClock.elapsedRealtime()), String.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
    ReportUtil.b("gouwu_aio_stay", String.valueOf(this.jdField_a_of_type_Int), String.valueOf(SystemClock.elapsedRealtime()), String.valueOf(SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long));
  }
  
  public void a()
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  @NotNull
  protected JSONObject doBussinessInitData(@Nullable JSONObject paramJSONObject)
  {
    paramJSONObject = super.doBussinessInitData(paramJSONObject);
    if (paramJSONObject == null) {
      paramJSONObject = new JSONObject();
    }
    Object localObject = getParameters();
    if (localObject != null)
    {
      SerializableMap localSerializableMap = (SerializableMap)((Bundle)localObject).getSerializable("qqshopParams");
      if (localSerializableMap != null)
      {
        localObject = localSerializableMap.getMap();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "map");
        Map localMap = (Map)localObject;
        if (EcshopUtils.a("3046055438")) {
          localObject = "1";
        } else {
          localObject = "0";
        }
        localMap.put("isFollowed", localObject);
        paramJSONObject.put("qqshopParams", ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).wrapHashMap(null, localSerializableMap.getMap()));
      }
    }
    return paramJSONObject;
  }
  
  protected int getLayoutResId()
  {
    return 2131561479;
  }
  
  protected boolean gotoErrorUrl()
  {
    QBaseActivity localQBaseActivity = getQBaseActivity();
    String str = getParameters().getString("errorUrl");
    if ((!TextUtils.isEmpty((CharSequence)str)) && (!isFragmentDestroyed()) && (localQBaseActivity != null))
    {
      PageSwitchUtil.a.a((Context)localQBaseActivity, this.jdField_a_of_type_Int, str);
      localQBaseActivity.finish();
      return true;
    }
    return super.gotoErrorUrl();
  }
  
  protected void initViews()
  {
    super.initViews();
    ViewGroup localViewGroup = this.mRootView;
    Intrinsics.checkExpressionValueIsNotNull(localViewGroup, "mRootView");
    a((View)localViewGroup);
    b();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a(null);
    try
    {
      paramBundle = getActivity();
      if ((!this.jdField_a_of_type_Boolean) && (paramBundle != null))
      {
        localObject = new IntentFilter();
        ((IntentFilter)localObject).addAction("com.tencent.mobileqq.ecshop.finish");
        ((IntentFilter)localObject).addAction("action_notify_view_update");
        paramBundle.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
        this.jdField_a_of_type_Boolean = true;
        return;
      }
    }
    catch (Throwable paramBundle)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[onCreate] regist exitreceiver fail ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.e("BaseHippyFragment", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      FragmentActivity localFragmentActivity = getActivity();
      if ((this.jdField_a_of_type_Boolean) && (localFragmentActivity != null))
      {
        localFragmentActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void onNewIntent(@Nullable Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
  }
  
  public void onResume()
  {
    super.onResume();
    getQBaseActivity().adjustSimpleStatusBar();
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.widget.QQShopPAHippyFragment
 * JD-Core Version:    0.7.0.1
 */