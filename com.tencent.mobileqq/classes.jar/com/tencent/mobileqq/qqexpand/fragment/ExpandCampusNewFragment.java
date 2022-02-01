package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandForbiddenInfo;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.IExpandForbiddenUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.widget.search.ExpandSearchBarView;
import com.tencent.mobileqq.qqexpand.widget.search.ExpandSearchBarView.OnItemClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.api.FeedListView.FeedUinChangedListener;
import cooperation.qzone.api.FeedListView.LoadFeedCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpandCampusNewFragment
  extends ExpandTabFragment
  implements Handler.Callback, ViewTreeObserver.OnGlobalLayoutListener, ExpandSearchBarView.OnItemClickListener, AbsListView.OnScrollListener, FeedListView.FeedUinChangedListener, FeedListView.LoadFeedCallback
{
  private static final int d = ViewUtils.dpToPx(60.0F);
  public QQCustomDialog a;
  private QBaseActivity e;
  private QQAppInterface f;
  private IExpandManager g;
  private ExpandSearchBarView h;
  private FeedListView i;
  private ExtendEmptyViewDirector j;
  private FrameLayout k;
  private boolean l = true;
  private int m = 0;
  private String n = "推荐";
  private boolean o;
  private boolean p = false;
  private long q = 0L;
  private String r = "";
  private final ExpandObserver s = new ExpandCampusNewFragment.1(this);
  
  private void a(long paramLong, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("limit_days", String.valueOf(paramLong));
    localHashMap.put("limit_reason", String.valueOf(paramInt));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#limit_windows#view", true, localHashMap);
  }
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131443566);
    paramView = paramView.findViewById(2131443567);
    if (localView != null)
    {
      localView.setOnTouchListener(new ExpandCampusNewFragment.4(this, paramView));
      localView.setOnClickListener(new ExpandCampusNewFragment.5(this));
    }
  }
  
  private void c()
  {
    ExpandForbiddenInfo localExpandForbiddenInfo = ((IExpandForbiddenUtils)QRoute.api(IExpandForbiddenUtils.class)).getForbiddenInfo();
    if (localExpandForbiddenInfo == null) {
      return;
    }
    this.p = localExpandForbiddenInfo.isForbidden();
    this.q = localExpandForbiddenInfo.getRemainingForbiddenTime();
    this.r = localExpandForbiddenInfo.getForbiddenTips();
    if ((this.p) && (this.q > 0L))
    {
      d();
      e();
      a(localExpandForbiddenInfo.getForbiddenDuration(), localExpandForbiddenInfo.getForbiddenReason());
    }
  }
  
  private void d()
  {
    ThreadManager.getUIHandlerV2().post(new ExpandCampusNewFragment.6(this));
  }
  
  private void e()
  {
    ThreadManager.getUIHandlerV2().post(new ExpandCampusNewFragment.7(this));
  }
  
  private void f()
  {
    Object localObject = this.g;
    boolean bool = true;
    if (localObject != null) {
      localObject = ((IExpandManager)localObject).b(1);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ExpandSearchBarView localExpandSearchBarView = this.h;
      if (localExpandSearchBarView != null)
      {
        localExpandSearchBarView.setSearchTags((ArrayList)localObject, 0);
        localExpandSearchBarView = this.h;
        if (((List)localObject).size() >= 2) {
          bool = false;
        }
        localExpandSearchBarView.setSearchTextShow(bool);
      }
    }
  }
  
  public void a()
  {
    PublicFragmentActivity.a(this.e, ExtendFriendCampusSearchFragment.class);
    this.e.overridePendingTransition(0, 2130772473);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusNewFragment", 2, String.format("onTagItemClick tag=%s position=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    if (!paramString.equals(this.n)) {
      this.n = paramString;
    }
    this.j.b();
    FeedListView localFeedListView = this.i;
    if (paramInt == 0) {
      localObject = null;
    } else {
      localObject = paramString;
    }
    if (!localFeedListView.switchTag((String)localObject, this)) {
      this.j.a();
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("small_tab_id", paramString);
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#school_tab#small_tab", true, -1L, -1L, (Map)localObject, true, true);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.i.doActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onCreate: ");
    super.onCreate(paramBundle);
    this.e = getQBaseActivity();
    this.f = ((QQAppInterface)this.e.getAppRuntime());
    paramBundle = this.f;
    if (paramBundle != null)
    {
      paramBundle.addObserver(this.s);
      this.g = ((IExpandManager)this.f.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
    }
    this.o = true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = new StringBuilder();
    paramBundle.append("onCreateView: ");
    if (paramLayoutInflater.getFactory() == null) {
      paramViewGroup = "null";
    } else {
      paramViewGroup = paramLayoutInflater.getFactory().getClass().getName();
    }
    paramBundle.append(paramViewGroup);
    QLog.i("ExtendFriendCampusNewFragment", 4, paramBundle.toString());
    paramViewGroup = null;
    try
    {
      paramBundle = paramLayoutInflater.inflate(2131627411, null);
      paramViewGroup = paramBundle;
    }
    catch (Throwable paramBundle)
    {
      QLog.w("ExtendFriendCampusNewFragment", 4, "onCreateView: failed create view", paramBundle);
    }
    if (paramViewGroup == null)
    {
      ExpandNewFragment.a();
      this.e.finish();
      return new View(paramLayoutInflater.getContext());
    }
    this.h = ((ExpandSearchBarView)paramViewGroup.findViewById(2131445383));
    this.h.getViewTreeObserver().addOnGlobalLayoutListener(this);
    this.h.setItemClickListener(this);
    this.h.setSearchButtonEnable(true);
    paramLayoutInflater = this.h;
    int i1;
    if (QzoneConfig.isNeedShowNuanShuoSearchBar()) {
      i1 = 0;
    } else {
      i1 = 8;
    }
    paramLayoutInflater.setVisibility(i1);
    this.i = ((FeedListView)paramViewGroup.findViewById(2131445308));
    this.i.setOverScrollMode(0);
    this.i.setEdgeEffectEnabled(false);
    this.i.setVerticalScrollBarEnabled(false);
    paramLayoutInflater = this.i;
    paramBundle = this.f;
    paramLayoutInflater.attach(paramBundle, this.e, paramBundle.getLongAccountUin());
    this.i.setFeedUinChangedListener(this);
    this.i.setOnScrollListener(this);
    this.i.postDelayed(new ExpandCampusNewFragment.2(this), 800L);
    this.i.setExpandHead(new ExpandCampusNewFragment.3(this));
    this.j = new ExtendEmptyViewDirector(paramViewGroup);
    this.j.b();
    a(paramViewGroup);
    this.l = false;
    this.k = ((FrameLayout)paramViewGroup.findViewById(2131433610));
    c();
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onDestroy");
    super.onDestroy();
    Object localObject = this.f;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.s);
    }
    if (Build.VERSION.SDK_INT > 15)
    {
      localObject = this.h;
      if (localObject != null) {
        ((ExpandSearchBarView)localObject).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
    }
    if (!this.l)
    {
      localObject = this.i;
      if (localObject != null)
      {
        ((FeedListView)localObject).onDestroy();
        this.l = true;
      }
    }
  }
  
  public void onFeedUinChanged(String paramString, List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusNewFragment", 2, String.format("onFeedUinChanged tag=%s uinList=%s", new Object[] { paramString, paramList }));
    }
  }
  
  public void onGlobalLayout()
  {
    int i1 = this.h.getHeight();
    if (i1 > this.m)
    {
      this.m = i1;
      this.h.a(this.i.getHeight());
      if (this.h.getVisibility() == 0) {
        i1 = this.m;
      } else {
        i1 = 0;
      }
      FeedListView localFeedListView = this.i;
      localFeedListView.setPadding(localFeedListView.getPaddingLeft(), i1, this.i.getPaddingRight(), d);
      this.i.postDelayed(new ExpandCampusNewFragment.8(this), 20L);
    }
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadOver: ");
    localStringBuilder.append(paramBoolean);
    QLog.i("ExtendFriendCampusNewFragment", 1, localStringBuilder.toString());
    if (paramBoolean) {
      this.j.a();
    } else if (NetworkUtil.isNetworkAvailable()) {
      this.j.c();
    } else {
      this.j.e();
    }
    if (this.o)
    {
      this.o = false;
      f();
    }
  }
  
  public void onPause()
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onPause");
    super.onPause();
    FeedListView localFeedListView = this.i;
    if (localFeedListView != null) {
      localFeedListView.onPause();
    }
  }
  
  public void onResume()
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onResume");
    super.onResume();
    Object localObject = this.i;
    if (localObject != null) {
      ((FeedListView)localObject).onResume();
    }
    int i1 = getQBaseActivity().getIntent().getIntExtra("extend_frient_from", 0);
    localObject = new HashMap();
    ((HashMap)localObject).put("frompage", String.valueOf(i1));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#school_tab#view", true, -1L, -1L, (Map)localObject, true, true);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onStart()
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onStart");
    super.onStart();
    FeedListView localFeedListView = this.i;
    if (localFeedListView != null) {
      localFeedListView.onStart();
    }
  }
  
  public void onStop()
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onStop");
    super.onStop();
    FeedListView localFeedListView = this.i;
    if (localFeedListView != null) {
      localFeedListView.onStop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandCampusNewFragment
 * JD-Core Version:    0.7.0.1
 */