package com.tencent.mobileqq.extendfriend.fragment;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExpandDTParamBuilder;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.bean.FeedBannerViewHolder.FeedBannerClickListener;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendReport;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendBottomBarView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedBannerView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView.OnItemClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.api.FeedListView.FeedUinChangedListener;
import cooperation.qzone.api.FeedListView.LoadFeedCallback;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ExtendFriendCampusFragment
  extends ExtendFriendTabFragment
  implements Handler.Callback, ViewTreeObserver.OnGlobalLayoutListener, FeedBannerViewHolder.FeedBannerClickListener, ExtendFriendSearchBarView.OnItemClickListener, AbsListView.OnScrollListener, FeedListView.FeedUinChangedListener, FeedListView.LoadFeedCallback
{
  private static final int jdField_a_of_type_Int = ViewUtils.b(60.0F);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExtendFriendManager jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager;
  private ExtendEmptyViewDirector jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector;
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new ExtendFriendCampusFragment.1(this);
  private ExtendFriendBottomBarView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView;
  private ExtendFriendFeedBannerView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView;
  private ExtendFriendSearchBarView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView;
  private FeedListView jdField_a_of_type_CooperationQzoneApiFeedListView;
  private String jdField_a_of_type_JavaLangString = ExtendFriendManager.jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  
  private void a(View paramView)
  {
    VideoReport.addToDetectionWhitelist(getActivity());
    VideoReport.setPageId(paramView, "school_tab");
    VideoReport.setPageParams(paramView, new ExpandDTParamBuilder().a());
    QLog.i("ExtendFriendCampusFragment", 1, "reportDaTongRegister");
  }
  
  private void a(String paramString, List<Long> paramList)
  {
    if (((ExtendFriendManager.jdField_a_of_type_JavaLangString.equals(paramString)) || (TextUtils.isEmpty(paramString))) && (paramList != null))
    {
      paramString = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramString.add(String.valueOf((Long)paramList.next()));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager != null))
      {
        int i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.h();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView.a(i, paramString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(paramString);
      }
    }
  }
  
  private void b(View paramView)
  {
    View localView = paramView.findViewById(2131375864);
    paramView = paramView.findViewById(2131375865);
    if (localView != null)
    {
      localView.setOnTouchListener(new ExtendFriendCampusFragment.5(this, paramView));
      localView.setOnClickListener(new ExtendFriendCampusFragment.6(this));
    }
  }
  
  private void c()
  {
    Object localObject;
    boolean bool2;
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      localObject = (ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      bool2 = ((ExtendFriendManager)localObject).i();
      if (((ExtendFriendManager)localObject).e() != 0) {
        break label237;
      }
    }
    label237:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendCampusFragment", 2, String.format("initHeaderView mTabPos=%s limitChatSwitch=%s, currentPageShowFeedBanner=%b", new Object[] { Integer.valueOf(this.j), Boolean.valueOf(bool2), Boolean.valueOf(bool1) }));
      }
      if (this.j == 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        if ((bool2) && (bool1))
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView = new ExtendFriendFeedBannerView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          localObject = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject).topMargin = ((int)UITools.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 10.0F));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView, (ViewGroup.LayoutParams)localObject);
          this.jdField_b_of_type_Boolean = true;
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A4", "0X80096A4", 0, 0, "", "", "", "");
        }
      }
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout, 2);
      return;
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView.a();
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView = null;
    }
  }
  
  private void e()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null))
    {
      boolean bool = true;
      if (this.jdField_a_of_type_CooperationQzoneApiFeedListView.getFirstVisiblePosition() > 0) {
        bool = false;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(bool);
      }
    }
  }
  
  private void f()
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
      QLog.d("ExtendFriendCampusFragment", 2, String.format("onTagItemClick tag=%s position=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
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
  
  public void an_()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$OnTabRequiredListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendFragment$OnTabRequiredListener.a();
      ExtendFriendReport.a().b(2);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A5", "0X80096A5", 0, 0, "", "", "", "");
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
    QLog.i("ExtendFriendCampusFragment", 4, "onCreate: ");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager = ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
    }
    this.c = true;
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
      QLog.i("ExtendFriendCampusFragment", 4, paramViewGroup);
      try
      {
        paramViewGroup = paramLayoutInflater.inflate(2131561201, null);
        if (paramViewGroup == null)
        {
          ExtendFriendFragment.a();
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
          QLog.w("ExtendFriendCampusFragment", 4, "onCreateView: failed create view");
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
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.postDelayed(new ExtendFriendCampusFragment.2(this), 800L);
          this.jdField_a_of_type_CooperationQzoneApiFeedListView.setExpandHead(new ExtendFriendCampusFragment.3(this));
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector = new ExtendEmptyViewDirector(paramViewGroup);
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector.b();
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView = ((ExtendFriendBottomBarView)paramViewGroup.findViewById(2131363785));
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_CooperationQzoneApiFeedListView);
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.setOnClickListener(new ExtendFriendCampusFragment.4(this));
          b(paramViewGroup);
          this.jdField_a_of_type_Boolean = false;
          a(paramViewGroup);
          paramLayoutInflater = paramViewGroup;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onDestroy");
    super.onDestroy();
    d();
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
      QLog.d("ExtendFriendCampusFragment", 2, String.format("onFeedUinChanged tag=%s uinList=%s", new Object[] { paramString, paramList }));
    }
    if ((paramList != null) && (!paramList.isEmpty())) {
      c();
    }
    a(paramString, paramList);
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
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.postDelayed(new ExtendFriendCampusFragment.7(this), 20L);
      return;
    }
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    QLog.i("ExtendFriendCampusFragment", 1, "onLoadOver: " + paramBoolean);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector.a();
    }
    for (;;)
    {
      if (this.c)
      {
        this.c = false;
        f();
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
    QLog.i("ExtendFriendCampusFragment", 4, "onPause");
    super.onPause();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onPause();
    }
  }
  
  public void onResume()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onResume");
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
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      e();
    }
  }
  
  public void onStart()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onStart");
    super.onStart();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStart();
    }
  }
  
  public void onStop()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onStop");
    super.onStop();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment
 * JD-Core Version:    0.7.0.1
 */