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
  private String a;
  private View b;
  private RecyclerView c;
  private QQLiveAdapter d;
  private RecommendAnchorDataManager e;
  private NavBarAIO f;
  private boolean g;
  private Dialog h;
  
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
    this.c = ((RecyclerView)paramView.findViewById(2131444519));
    this.c.setLayoutManager((RecyclerView.LayoutManager)localObject);
    if ((getBaseActivity() != null) && (!getBaseActivity().isFinishing()))
    {
      localObject = new RecommendSpacesItemDecoration(getBaseActivity().getResources().getDimensionPixelSize(2131299630));
      this.c.addItemDecoration((RecyclerView.ItemDecoration)localObject);
    }
    this.d = new QQLiveAdapter(getBaseActivity(), this.c, this.e.a());
    this.c.setAdapter(this.d);
    a();
    b(paramView);
  }
  
  private void b(View paramView)
  {
    this.f = ((NavBarAIO)paramView.findViewById(2131439478));
    paramView = this.f;
    if (paramView == null) {
      return;
    }
    paramView = (LinearLayout.LayoutParams)paramView.getLayoutParams();
    paramView.setMargins(0, StatusBarUtil.a(getBaseActivity()), 0, 0);
    this.f.setLayoutParams(paramView);
    paramView = this.f.findViewById(2131436180);
    if (paramView != null) {
      if (ThemeImageWrapper.isNightMode())
      {
        paramView.setBackgroundResource(2130851009);
        this.f.setRight1Icon(2130852267);
        this.f.setRight2Icon(2130842331);
      }
      else
      {
        paramView.setBackgroundResource(2130851109);
        this.f.setRight1Icon(2130841270);
        this.f.setRight2Icon(2130842330);
      }
    }
    int i = NowQQLiveHelper.a();
    if (i > 0)
    {
      paramView = (TextView)this.f.findViewById(2131436218);
      paramView.setText(String.valueOf(i));
      paramView.setVisibility(0);
      NowQQLiveHelper.b();
    }
    paramView = this.f.findViewById(2131436666);
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    paramView = this.f.findViewById(2131446540);
    if (paramView != null) {
      paramView.setVisibility(8);
    }
    TextView localTextView = (TextView)this.f.findViewById(2131447463);
    if (localTextView != null)
    {
      paramView = c();
      if ((paramView != null) && (!TextUtils.isEmpty(paramView.getName()))) {
        paramView = paramView.getName();
      } else {
        paramView = HardCodeUtil.a(2131892228);
      }
      localTextView.setText(paramView);
    }
    this.f.setOnSelectListener(new NowQQLiveFragment.1(this));
  }
  
  private IPublicAccountDetail c()
  {
    Object localObject = UserInfoMgr.c();
    if (localObject != null)
    {
      localObject = (IPublicAccountDataManager)((AppInterface)localObject).getRuntimeService(IPublicAccountDataManager.class, "all");
      if (localObject != null) {
        return ((IPublicAccountDataManager)localObject).findAccountDetailInfo(NowQQLiveConstant.a);
      }
    }
    return null;
  }
  
  private void d()
  {
    CookieManager.getInstance().setCookie("fastest.now.qq.com", "__client_type=16130");
    CookieManager.getInstance().setCookie("now.qq.com", "__client_type=16130");
    LoginMgr.a().a(this);
  }
  
  private void e()
  {
    LoginMgr.a().d();
    if (getBaseActivity() != null) {
      getBaseActivity().finish();
    }
  }
  
  private void f()
  {
    if (this.g == StatusBarUtil.a()) {
      return;
    }
    this.g = StatusBarUtil.a();
    this.f.d();
    Object localObject;
    if (this.g)
    {
      StatusBarUtil.a(getBaseActivity(), true);
      localObject = this.f.findViewById(2131436180);
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(2130851009);
      }
      localObject = (TextView)this.f.findViewById(2131447463);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(-1);
      }
    }
    else
    {
      StatusBarUtil.a(getBaseActivity(), false);
      localObject = this.f.findViewById(2131436180);
      if (localObject != null) {
        ((View)localObject).setBackgroundResource(2130851109);
      }
      localObject = (TextView)this.f.findViewById(2131447463);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(-16777216);
      }
      if (!QQTheme.isCustomTheme(MobileQQ.sMobileQQ.waitAppRuntime(null).getCurrentUin(), false)) {
        this.f.setBackgroundColor(-1);
      }
    }
  }
  
  private void g()
  {
    if (NetworkUtil.isNetworkAvailable())
    {
      Dialog localDialog = this.h;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.h.dismiss();
      }
      return;
    }
    if (this.h == null) {
      this.h = DialogUtil.a(getBaseActivity(), null, getBaseActivity().getString(2131892229), 0, 2131892230, null, null, null);
    }
    if (!this.h.isShowing()) {
      this.h.show();
    }
  }
  
  public void a()
  {
    this.c.getItemAnimator().setAddDuration(0L);
    this.c.getItemAnimator().setChangeDuration(0L);
    this.c.getItemAnimator().setMoveDuration(0L);
    this.c.getItemAnimator().setRemoveDuration(0L);
    if ((this.c.getItemAnimator() instanceof SimpleItemAnimator)) {
      ((SimpleItemAnimator)this.c.getItemAnimator()).setSupportsChangeAnimations(false);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    FocusLiveStreamDataManager.a().b();
    this.e.a(0, this, false);
  }
  
  public void a(List<RecommendAnchorInfo> paramList)
  {
    this.d.b(1);
    this.d.notifyDataSetChanged();
  }
  
  public void b()
  {
    this.d.b(2);
    this.d.notifyDataSetChanged();
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
    paramActivity.overridePendingTransition(2130771999, 2130772001);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getBaseActivity().getIntent();
    this.a = paramBundle.getStringExtra("public_account_uin");
    this.e = new RecommendAnchorDataManager();
    this.g = (StatusBarUtil.a() ^ true);
    g();
    NowQQLiveDataReport.a(String.valueOf(paramBundle.getIntExtra("public_account_source", 1)));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    d();
    this.b = paramLayoutInflater.inflate(2131625537, paramViewGroup, false);
    a(this.b);
    if (getBaseActivity() == null)
    {
      QLog.e("NowQQLiveFragment", 1, "activity is null");
      paramLayoutInflater = this.b;
    }
    else if (getArguments() == null)
    {
      QLog.e("NowQQLiveFragment", 1, "argsBundle is null");
      paramLayoutInflater = this.b;
    }
    else
    {
      SimpleEventBus.getInstance().registerReceiver(this);
      paramLayoutInflater = this.b;
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    FocusLiveStreamDataManager.a().d();
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
      QfavUtil.a(getBaseActivity(), 2131892115, 1);
      b();
      return;
    }
    if (LoginMgr.a().c())
    {
      if ((paramSimpleBaseEvent instanceof NoRecommendDataEvent))
      {
        paramSimpleBaseEvent = this.e;
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
    this.d.a();
    this.e.a(this);
    FocusLiveStreamDataManager.a().b();
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.now.NowQQLiveFragment
 * JD-Core Version:    0.7.0.1
 */