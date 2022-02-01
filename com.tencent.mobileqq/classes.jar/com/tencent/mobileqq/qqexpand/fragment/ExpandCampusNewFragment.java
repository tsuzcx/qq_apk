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
  private static final int jdField_b_of_type_Int = ViewUtils.b(60.0F);
  private long jdField_a_of_type_Long = 0L;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExtendEmptyViewDirector jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendEmptyViewDirector;
  private IExpandManager jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager;
  private final ExpandObserver jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver = new ExpandCampusNewFragment.1(this);
  private ExpandSearchBarView jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView;
  public QQCustomDialog a;
  private FeedListView jdField_a_of_type_CooperationQzoneApiFeedListView;
  private String jdField_a_of_type_JavaLangString = "推荐";
  private boolean jdField_a_of_type_Boolean = true;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  
  private void a(long paramLong, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("limit_days", String.valueOf(paramLong));
    localHashMap.put("limit_reason", String.valueOf(paramInt));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#limit_windows#view", true, localHashMap);
  }
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131375380);
    paramView = paramView.findViewById(2131375381);
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
    this.jdField_c_of_type_Boolean = localExpandForbiddenInfo.isForbidden();
    this.jdField_a_of_type_Long = localExpandForbiddenInfo.getRemainingForbiddenTime();
    this.jdField_b_of_type_JavaLangString = localExpandForbiddenInfo.getForbiddenTips();
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Long > 0L))
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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager;
    boolean bool = true;
    if (localObject != null) {
      localObject = ((IExpandManager)localObject).a(1);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ExpandSearchBarView localExpandSearchBarView = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView;
      if (localExpandSearchBarView != null)
      {
        localExpandSearchBarView.setSearchTags((ArrayList)localObject, 0);
        localExpandSearchBarView = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView;
        if (((List)localObject).size() >= 2) {
          bool = false;
        }
        localExpandSearchBarView.setSearchTextShow(bool);
      }
    }
  }
  
  public void a()
  {
    PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, ExtendFriendCampusSearchFragment.class);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.overridePendingTransition(0, 2130772377);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusNewFragment", 2, String.format("onTagItemClick tag=%s position=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    if (!paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendEmptyViewDirector.b();
    FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (paramInt == 0) {
      localObject = null;
    } else {
      localObject = paramString;
    }
    if (!localFeedListView.switchTag((String)localObject, this)) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendEmptyViewDirector.a();
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
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.doActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onCreate: ");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getQBaseActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime());
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (paramBundle != null)
    {
      paramBundle.addObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager = ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
    }
    this.jdField_b_of_type_Boolean = true;
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
      paramBundle = paramLayoutInflater.inflate(2131561068, null);
      paramViewGroup = paramBundle;
    }
    catch (Throwable paramBundle)
    {
      QLog.w("ExtendFriendCampusNewFragment", 4, "onCreateView: failed create view", paramBundle);
    }
    if (paramViewGroup == null)
    {
      ExpandNewFragment.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
      return new View(paramLayoutInflater.getContext());
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView = ((ExpandSearchBarView)paramViewGroup.findViewById(2131377019));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView.setItemClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView.setSearchButtonEnable(true);
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView;
    int i;
    if (QzoneConfig.isNeedShowNuanShuoSearchBar()) {
      i = 0;
    } else {
      i = 8;
    }
    paramLayoutInflater.setVisibility(i);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView = ((FeedListView)paramViewGroup.findViewById(2131376947));
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOverScrollMode(0);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setEdgeEffectEnabled(false);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setVerticalScrollBarEnabled(false);
    paramLayoutInflater = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    paramLayoutInflater.attach(paramBundle, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, paramBundle.getLongAccountUin());
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setFeedUinChangedListener(this);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOnScrollListener(this);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.postDelayed(new ExpandCampusNewFragment.2(this), 800L);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setExpandHead(new ExpandCampusNewFragment.3(this));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendEmptyViewDirector = new ExtendEmptyViewDirector(paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendEmptyViewDirector.b();
    a(paramViewGroup);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131367156));
    c();
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onDestroy");
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqQqexpandNetworkExpandObserver);
    }
    if (Build.VERSION.SDK_INT > 15)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView;
      if (localObject != null) {
        ((ExpandSearchBarView)localObject).getViewTreeObserver().removeOnGlobalLayoutListener(this);
      }
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
      if (localObject != null)
      {
        ((FeedListView)localObject).onDestroy();
        this.jdField_a_of_type_Boolean = true;
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
    int i = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView.getHeight();
    if (i > this.jdField_c_of_type_Int)
    {
      this.jdField_c_of_type_Int = i;
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView.a(this.jdField_a_of_type_CooperationQzoneApiFeedListView.getHeight());
      if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetSearchExpandSearchBarView.getVisibility() == 0) {
        i = this.jdField_c_of_type_Int;
      } else {
        i = 0;
      }
      FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
      localFeedListView.setPadding(localFeedListView.getPaddingLeft(), i, this.jdField_a_of_type_CooperationQzoneApiFeedListView.getPaddingRight(), jdField_b_of_type_Int);
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.postDelayed(new ExpandCampusNewFragment.8(this), 20L);
    }
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadOver: ");
    localStringBuilder.append(paramBoolean);
    QLog.i("ExtendFriendCampusNewFragment", 1, localStringBuilder.toString());
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendEmptyViewDirector.a();
    } else if (NetworkUtil.isNetworkAvailable()) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendEmptyViewDirector.c();
    } else {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendEmptyViewDirector.e();
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      f();
    }
  }
  
  public void onPause()
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onPause");
    super.onPause();
    FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localFeedListView != null) {
      localFeedListView.onPause();
    }
  }
  
  public void onResume()
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onResume");
    super.onResume();
    Object localObject = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localObject != null) {
      ((FeedListView)localObject).onResume();
    }
    int i = getQBaseActivity().getIntent().getIntExtra("extend_frient_from", 0);
    localObject = new HashMap();
    ((HashMap)localObject).put("frompage", String.valueOf(i));
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#school_tab#view", true, -1L, -1L, (Map)localObject, true, true);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onStart()
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onStart");
    super.onStart();
    FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localFeedListView != null) {
      localFeedListView.onStart();
    }
  }
  
  public void onStop()
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onStop");
    super.onStop();
    FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localFeedListView != null) {
      localFeedListView.onStop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExpandCampusNewFragment
 * JD-Core Version:    0.7.0.1
 */