package com.tencent.mobileqq.now;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemAnimator;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.SimpleItemAnimator;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.now.focusanchor.focusdata.FocusLiveStreamDataManager;
import com.tencent.mobileqq.now.netchannel.websso.LoginMgr;
import com.tencent.mobileqq.now.netchannel.websso.LoginMgr.Listener;
import com.tencent.mobileqq.now.netchannel.websso.UserInfoMgr;
import com.tencent.mobileqq.now.recommend.NoRecommendDataEvent;
import com.tencent.mobileqq.now.recommend.RecommendAnchorDataManager;
import com.tencent.mobileqq.now.recommend.RecommendAnchorDataManager.RecommendAnchorDataCallback;
import com.tencent.mobileqq.now.recommend.RecommendAnchorInfo;
import com.tencent.mobileqq.now.recommend.RecommendSpacesItemDecoration;
import com.tencent.mobileqq.now.roport.NowQQLiveDataReport;
import com.tencent.mobileqq.now.utils.StatusBarUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.widget.ThemeImageWrapper;
import cooperation.qqfav.QfavUtil;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class NowQQLiveFragment
  extends PublicBaseFragment
  implements SimpleEventReceiver, LoginMgr.Listener, RecommendAnchorDataManager.RecommendAnchorDataCallback
{
  private Dialog jdField_a_of_type_AndroidAppDialog;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private View jdField_a_of_type_AndroidViewView;
  private QQLiveAdapter jdField_a_of_type_ComTencentMobileqqNowQQLiveAdapter;
  private RecommendAnchorDataManager jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager;
  private NavBarAIO jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  private IPublicAccountDetail a()
  {
    Object localObject = UserInfoMgr.a();
    if (localObject != null)
    {
      localObject = (IPublicAccountDataManager)((AppInterface)localObject).getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject != null) {
        return ((IPublicAccountDataManager)localObject).findAccountDetailInfo(NowQQLiveConstant.jdField_a_of_type_JavaLangString);
      }
    }
    return null;
  }
  
  public static final void a(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, PublicFragmentActivity.class);
    localIntent.putExtra("public_account_uin", paramString);
    localIntent.putExtra("public_account_source", paramInt);
    localIntent.addFlags(67108864);
    PublicFragmentActivity.Launcher.a(paramContext, localIntent, PublicFragmentActivity.class, NowQQLiveFragment.class);
  }
  
  private void a(View paramView)
  {
    Object localObject = new StaggeredGridLayoutManager(2, 1);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131376308));
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager((RecyclerView.LayoutManager)localObject);
    if ((getBaseActivity() != null) && (!getBaseActivity().isFinishing()))
    {
      localObject = new RecommendSpacesItemDecoration(getBaseActivity().getResources().getDimensionPixelSize(2131298908));
      this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqNowQQLiveAdapter = new QQLiveAdapter(getBaseActivity(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView, this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNowQQLiveAdapter);
    a();
    b(paramView);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)paramView.findViewById(2131372019));
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (paramView == null) {
      return;
    }
    paramView = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    paramView.setMargins(0, StatusBarUtil.a(getBaseActivity()), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setLayoutParams(paramView);
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369202);
    if (paramView != null) {
      if (ThemeImageWrapper.isNightMode())
      {
        paramView.setBackgroundResource(2130849325);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130850471);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130841489);
      }
      else
      {
        paramView.setBackgroundResource(2130849425);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight1Icon(2130840504);
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setRight2Icon(2130841488);
      }
    }
    int i = NowQQLiveHelper.a();
    if (i > 0)
    {
      paramView = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369240);
      paramView.setText(String.valueOf(i));
      paramView.setVisibility(0);
      NowQQLiveHelper.a();
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369563);
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    paramView = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378040);
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    TextView localTextView = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378784);
    if (localTextView != null)
    {
      paramView = a();
      if ((paramView != null) && (!TextUtils.isEmpty(paramView.getName()))) {
        paramView = paramView.getName();
      } else {
        paramView = HardCodeUtil.a(2131694544);
      }
      localTextView.setText(paramView);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setOnSelectListener(new NowQQLiveFragment.1(this));
  }
  
  private void c()
  {
    CookieManager.getInstance().setCookie("fastest.now.qq.com", "__client_type=16130");
    CookieManager.getInstance().setCookie("now.qq.com", "__client_type=16130");
    LoginMgr.a().a(this);
  }
  
  private void d()
  {
    LoginMgr.a().b();
    if (getBaseActivity() != null) {
      getBaseActivity().finish();
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Boolean == StatusBarUtil.a()) {
      return;
    }
    this.jdField_a_of_type_Boolean = StatusBarUtil.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.d();
    Object localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      StatusBarUtil.a(getBaseActivity(), true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369202);
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(2130849325);
      }
      localObject = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378784);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(-1);
      }
    }
    else
    {
      StatusBarUtil.a(getBaseActivity(), false);
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131369202);
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(2130849425);
      }
      localObject = (TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.findViewById(2131378784);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(-16777216);
      }
      if (!QQTheme.a(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin(), false)) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.setBackgroundColor(-1);
      }
    }
  }
  
  private void f()
  {
    if (NetworkUtil.isNetworkAvailable())
    {
      Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidAppDialog == null) {
      this.jdField_a_of_type_AndroidAppDialog = DialogUtil.a(getBaseActivity(), null, getBaseActivity().getString(2131694545), 0, 2131694546, null, null, null);
    }
    if (!this.jdField_a_of_type_AndroidAppDialog.isShowing()) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator().setAddDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator().setChangeDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator().setMoveDuration(0L);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator().setRemoveDuration(0L);
    if ((this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator() instanceof SimpleItemAnimator)) {
      ((SimpleItemAnimator)this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    FocusLiveStreamDataManager.a().a();
    this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager.a(0, this, false);
  }
  
  public void a(List<RecommendAnchorInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqNowQQLiveAdapter.a(1);
    this.jdField_a_of_type_ComTencentMobileqqNowQQLiveAdapter.notifyDataSetChanged();
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqNowQQLiveAdapter.a(2);
    this.jdField_a_of_type_ComTencentMobileqqNowQQLiveAdapter.notifyDataSetChanged();
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(NoRecommendDataEvent.class);
    return localArrayList;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().setSoftInputMode(17);
    paramActivity.overridePendingTransition(2130771996, 2130771998);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getBaseActivity().getIntent();
    this.jdField_a_of_type_JavaLangString = paramBundle.getStringExtra("public_account_uin");
    this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager = new RecommendAnchorDataManager();
    this.jdField_a_of_type_Boolean = (StatusBarUtil.a() ^ true);
    f();
    NowQQLiveDataReport.a(String.valueOf(paramBundle.getIntExtra("public_account_source", 1)));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    c();
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater.inflate(2131559515, paramViewGroup, false);
    a(this.jdField_a_of_type_AndroidViewView);
    if (getBaseActivity() == null)
    {
      QLog.e("NowQQLiveFragment", 1, "activity is null");
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    }
    else if (getArguments() == null)
    {
      QLog.e("NowQQLiveFragment", 1, "argsBundle is null");
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    }
    else
    {
      SimpleEventBus.getInstance().registerReceiver(this);
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    FocusLiveStreamDataManager.a().b();
    URLDrawable.clearMemoryCache();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((getBaseActivity() != null) && (!NetworkUtil.isNetworkAvailable(getBaseActivity().getApplication())))
    {
      QfavUtil.a(getBaseActivity(), 2131694435, 1);
      b();
      return;
    }
    if (LoginMgr.a().a())
    {
      if ((paramSimpleBaseEvent instanceof NoRecommendDataEvent))
      {
        paramSimpleBaseEvent = this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager;
        if (paramSimpleBaseEvent != null) {
          paramSimpleBaseEvent.a(0, this, false);
        }
      }
    }
    else {
      LoginMgr.a().a(this);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.jdField_a_of_type_ComTencentMobileqqNowQQLiveAdapter.a();
    this.jdField_a_of_type_ComTencentMobileqqNowRecommendRecommendAnchorDataManager.a(this);
    FocusLiveStreamDataManager.a().a();
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.NowQQLiveFragment
 * JD-Core Version:    0.7.0.1
 */