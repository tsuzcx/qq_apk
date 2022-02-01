package com.tencent.mobileqq.extendfriend.fragment;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.ExpandForbiddenUtils;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView.OnItemClickListener;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.api.FeedListView.FeedUinChangedListener;
import cooperation.qzone.api.FeedListView.LoadFeedCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtendFriendCampusNewFragment
  extends ExtendFriendTabFragment
  implements Handler.Callback, ViewTreeObserver.OnGlobalLayoutListener, ExtendFriendSearchBarView.OnItemClickListener, AbsListView.OnScrollListener, FeedListView.FeedUinChangedListener, FeedListView.LoadFeedCallback
{
  private static final int jdField_a_of_type_Int = ViewUtils.b(60.0F);
  private long jdField_a_of_type_Long = 0L;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExtendFriendManager jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager;
  private ExtendEmptyViewDirector jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector;
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new ExtendFriendCampusNewFragment.1(this);
  private ExtendFriendSearchBarView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView;
  public QQCustomDialog a;
  private FeedListView jdField_a_of_type_CooperationQzoneApiFeedListView;
  private String jdField_a_of_type_JavaLangString = ExtendFriendManager.jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = false;
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131375864);
    paramView = paramView.findViewById(2131375865);
    if (localView != null)
    {
      localView.setOnTouchListener(new ExtendFriendCampusNewFragment.4(this, paramView));
      localView.setOnClickListener(new ExtendFriendCampusNewFragment.5(this));
    }
  }
  
  private void b()
  {
    this.c = this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.p();
    this.jdField_a_of_type_Long = ExpandForbiddenUtils.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.d());
    if ((this.c) && (this.jdField_a_of_type_Long > 0L))
    {
      c();
      d();
      ExpandReportUtils.a("expose#limit_windows#view", true, null);
    }
  }
  
  private void c()
  {
    ThreadManager.getUIHandlerV2().post(new ExtendFriendCampusNewFragment.6(this));
  }
  
  private void d()
  {
    ThreadManager.getUIHandlerV2().post(new ExtendFriendCampusNewFragment.7(this));
  }
  
  private void e()
  {
    List localList = null;
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager != null) {
      localList = this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.a(1);
    }
    ExtendFriendSearchBarView localExtendFriendSearchBarView;
    if ((localList != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, 0);
      localExtendFriendSearchBarView = this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView;
      if (localList.size() >= 2) {
        break label72;
      }
    }
    label72:
    for (boolean bool = true;; bool = false)
    {
      localExtendFriendSearchBarView.setSearchTextShow(bool);
      return;
    }
  }
  
  public void a()
  {
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ExtendFriendCampusSearchFragment.class);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 2130772345);
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusNewFragment", 2, String.format("onTagItemClick tag=%s position=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    if (!paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector.b();
    FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (paramInt == 0) {}
    for (Object localObject = null;; localObject = paramString)
    {
      if (!localFeedListView.switchTag((String)localObject, this)) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector.a();
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("small_tab_id", paramString);
      ExpandReportUtils.a("click#school_tab#small_tab", true, -1L, -1L, (Map)localObject, true, true);
      return;
    }
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
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager = ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
    }
    this.jdField_b_of_type_Boolean = true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = null;
    StringBuilder localStringBuilder = new StringBuilder().append("onCreateView: ");
    if (paramLayoutInflater.getFactory() == null) {
      paramViewGroup = "null";
    }
    for (;;)
    {
      QLog.i("ExtendFriendCampusNewFragment", 4, paramViewGroup);
      try
      {
        paramViewGroup = paramLayoutInflater.inflate(2131561201, null);
        if (paramViewGroup == null)
        {
          ExtendFriendNewFragment.a();
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
          paramLayoutInflater = new View(paramLayoutInflater.getContext());
          V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
          return paramLayoutInflater;
          paramViewGroup = paramLayoutInflater.getFactory().getClass().getName();
        }
      }
      catch (Throwable paramViewGroup)
      {
        for (;;)
        {
          QLog.w("ExtendFriendCampusNewFragment", 4, "onCreateView: failed create view", paramViewGroup);
          paramViewGroup = paramBundle;
          continue;
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView = ((ExtendFriendSearchBarView)paramViewGroup.findViewById(2131377575));
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.getViewTreeObserver().addOnGlobalLayoutListener(this);
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setItemClickListener(this);
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchButtonEnable(true);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView = ((FeedListView)paramViewGroup.findViewById(2131377504));
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOverScrollMode(0);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setEdgeEffectEnabled(false);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setVerticalScrollBarEnabled(false);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.attach(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setFeedUinChangedListener(this);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOnScrollListener(this);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.postDelayed(new ExtendFriendCampusNewFragment.2(this), 800L);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setExpandHead(new ExtendFriendCampusNewFragment.3(this));
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector = new ExtendEmptyViewDirector(paramViewGroup);
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector.b();
          a(paramViewGroup);
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)paramViewGroup.findViewById(2131367374));
          b();
          paramLayoutInflater = paramViewGroup;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onDestroy");
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    }
    if ((Build.VERSION.SDK_INT > 15) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null))
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onDestroy();
      this.jdField_a_of_type_Boolean = true;
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
    int i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.getHeight();
    if (i > this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_Int = i;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.a(this.jdField_a_of_type_CooperationQzoneApiFeedListView.getHeight());
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.getVisibility() != 0) {
        break label95;
      }
    }
    label95:
    for (i = this.jdField_b_of_type_Int;; i = 0)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.setPadding(this.jdField_a_of_type_CooperationQzoneApiFeedListView.getPaddingLeft(), i, this.jdField_a_of_type_CooperationQzoneApiFeedListView.getPaddingRight(), jdField_a_of_type_Int);
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.postDelayed(new ExtendFriendCampusNewFragment.8(this), 20L);
      return;
    }
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    QLog.i("ExtendFriendCampusNewFragment", 1, "onLoadOver: " + paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector.a();
    }
    for (;;)
    {
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        e();
      }
      return;
      if (NetworkUtil.a()) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector.c();
      } else {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector.e();
      }
    }
  }
  
  public void onPause()
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onPause");
    super.onPause();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onPause();
    }
  }
  
  public void onResume()
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onResume");
    super.onResume();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onResume();
    }
    int i = getActivity().getIntent().getIntExtra("extend_frient_from", 0);
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", String.valueOf(i));
    ExpandReportUtils.a("expose#school_tab#view", true, -1L, -1L, localHashMap, true, true);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
  
  public void onStart()
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onStart");
    super.onStart();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStart();
    }
  }
  
  public void onStop()
  {
    QLog.i("ExtendFriendCampusNewFragment", 4, "onStop");
    super.onStop();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusNewFragment
 * JD-Core Version:    0.7.0.1
 */