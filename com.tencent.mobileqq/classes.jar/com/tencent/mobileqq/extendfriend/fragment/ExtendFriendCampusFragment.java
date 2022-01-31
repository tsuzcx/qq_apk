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
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqbg;
import aqbl;
import aqcd;
import aqdh;
import aqdi;
import aqdj;
import aqdk;
import aqdl;
import aqdm;
import aqeb;
import aqfg;
import aqhg;
import aqik;
import azqs;
import bdoo;
import bhtd;
import bhtv;
import bjhl;
import bjhm;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendBottomBarView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendCampusVerifyTipsView.TipsType;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedBannerView;
import com.tencent.mobileqq.extendfriend.wiget.ExtendFriendSearchBarView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import cooperation.qzone.api.FeedListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mww;

public class ExtendFriendCampusFragment
  extends aqfg
  implements Handler.Callback, ViewTreeObserver.OnGlobalLayoutListener, aqcd, aqik, bhtv, bjhl, bjhm
{
  private static final int jdField_a_of_type_Int = bdoo.b(60.0F);
  private Handler jdField_a_of_type_AndroidOsHandler;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqbg jdField_a_of_type_Aqbg;
  private aqbl jdField_a_of_type_Aqbl = new aqdh(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ExtendFriendBottomBarView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView;
  private ExtendFriendCampusVerifyTipsView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView;
  private ExtendFriendFeedBannerView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView;
  private ExtendFriendSearchBarView jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView;
  private FeedListView jdField_a_of_type_CooperationQzoneApiFeedListView;
  private String jdField_a_of_type_JavaLangString = aqbg.jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c = true;
  
  private void a(View paramView)
  {
    View localView = paramView.findViewById(2131374617);
    paramView = paramView.findViewById(2131374618);
    if (localView != null)
    {
      localView.setOnTouchListener(new aqdk(this, paramView));
      localView.setOnClickListener(new aqdl(this));
    }
  }
  
  private void b(String paramString, List<Long> paramList)
  {
    if ((aqbg.jdField_a_of_type_JavaLangString.equals(paramString)) || (TextUtils.isEmpty(paramString)))
    {
      paramString = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramString.add(String.valueOf((Long)paramList.next()));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView != null)
      {
        int i = this.jdField_a_of_type_Aqbg.d();
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView.a(i, paramString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView != null) {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(paramString);
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null)
    {
      boolean bool = ((aqbg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264)).f();
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendCampusFragment", 2, String.format("initHeaderView mTabPos=%s limitChatSwitch=%s", new Object[] { Integer.valueOf(this.j), Boolean.valueOf(bool) }));
      }
      if (this.j == 0)
      {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        if (bool)
        {
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView = new ExtendFriendFeedBannerView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
          this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this);
          localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
          localLayoutParams.topMargin = ((int)mww.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 10.0F));
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendFeedBannerView, localLayoutParams);
          this.jdField_b_of_type_Boolean = true;
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A4", "0X80096A4", 0, 0, "", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView = new ExtendFriendCampusVerifyTipsView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView.setOnClickListener(new aqdm(this));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        localLayoutParams.topMargin = ((int)mww.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 10.0F));
        localLayoutParams.leftMargin = ((int)mww.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 8.0F));
        localLayoutParams.rightMargin = ((int)mww.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 8.0F));
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView, localLayoutParams);
        g();
      }
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.addHeaderView(this.jdField_a_of_type_AndroidWidgetLinearLayout, 2);
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
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView = null;
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
    if (this.jdField_a_of_type_Aqbg != null) {
      localList = this.jdField_a_of_type_Aqbg.a(1);
    }
    if ((localList != null) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, 0);
      this.jdField_a_of_type_AndroidOsHandler.post(new ExtendFriendCampusFragment.9(this));
    }
  }
  
  private void g()
  {
    Object localObject = (aqbg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264);
    boolean bool = ((aqbg)localObject).e();
    int i = ((aqbg)localObject).c();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusFragment", 2, String.format("updateVerifyTipsView needShowVerifyTips=%s verifyStatus=%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i) }));
    }
    bool = ExtendFriendCampusVerifyTipsView.a(bool, i);
    localObject = ExtendFriendCampusVerifyTipsView.a(i);
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusFragment", 2, String.format("updateVerifyTipsView showVerifyTips=%s tipsType=%s", new Object[] { Boolean.valueOf(bool), localObject }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView != null)
    {
      if (bool)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView.setVisibility(0);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView.setTipsType((ExtendFriendCampusVerifyTipsView.TipsType)localObject);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendCampusVerifyTipsView.setVisibility(8);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aqeb != null)
    {
      this.jdField_a_of_type_Aqeb.a();
      aqhg.a().b(2);
    }
    azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80096A5", "0X80096A5", 0, 0, "", "", "", "");
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusFragment", 2, String.format("onTagItemClick tag=%s position=%s", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    if (!paramString.equals(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = paramString;
    }
    FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (paramInt == 0) {
      paramString = null;
    }
    if (localFeedListView.a(paramString, this))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131718563);
    }
  }
  
  public void a(String paramString, List<Long> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusFragment", 2, String.format("onFeedUinChanged tag=%s uinList=%s", new Object[] { paramString, paramList }));
    }
    if ((paramList != null) && (!paramList.isEmpty())) {
      c();
    }
    b(paramString, paramList);
  }
  
  public void b()
  {
    PublicFragmentActivity.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, ExtendFriendCampusSearchFragment.class);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.overridePendingTransition(0, 2130772324);
  }
  
  public void d(boolean paramBoolean)
  {
    QLog.i("ExtendFriendCampusFragment", 1, "onLoadOver: " + paramBoolean);
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText("刷新失败，请下拉重试");
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onCreate: ");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = getActivity();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.app;
    this.jdField_a_of_type_AndroidOsHandler = new bhtd(Looper.getMainLooper(), this);
    this.jdField_a_of_type_Aqbg = ((aqbg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264));
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aqbl);
    }
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
        paramViewGroup = paramLayoutInflater.inflate(2131560935, null);
        if (paramViewGroup == null)
        {
          ExtendFriendFragment.a();
          this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.finish();
          return new View(paramLayoutInflater.getContext());
          paramViewGroup = paramLayoutInflater.getFactory().getClass().getName();
        }
      }
      catch (Throwable paramViewGroup)
      {
        for (;;)
        {
          QLog.w("ExtendFriendCampusFragment", 4, "onCreateView: failed create view");
          paramViewGroup = paramBundle;
        }
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView = ((ExtendFriendSearchBarView)paramViewGroup.findViewById(2131376222));
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.getViewTreeObserver().addOnGlobalLayoutListener(this);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setItemClickListener(this);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchButtonEnable(false);
        this.jdField_a_of_type_CooperationQzoneApiFeedListView = ((FeedListView)paramViewGroup.findViewById(2131376169));
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOverScrollMode(0);
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.setEdgeEffectEnabled(false);
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.setVerticalScrollBarEnabled(false);
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.setFeedUinChangedListener(this);
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOnScrollListener(this);
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.postDelayed(new ExtendFriendCampusFragment.2(this), 800L);
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.setExpandHead(new aqdi(this));
        this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131374606);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131374608));
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView = ((ExtendFriendBottomBarView)paramViewGroup.findViewById(2131363377));
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_CooperationQzoneApiFeedListView);
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendBottomBarView.setOnClickListener(new aqdj(this));
        a(paramViewGroup);
        this.jdField_a_of_type_Boolean = false;
      }
    }
    return paramViewGroup;
  }
  
  public void onDestroy()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onDestroy");
    super.onDestroy();
    d();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aqbl);
    }
    if ((Build.VERSION.SDK_INT > 15) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null))
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.i();
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void onGlobalLayout()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.getHeight();
    if (i > this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_Int = i;
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.a(this.jdField_a_of_type_CooperationQzoneApiFeedListView.getHeight());
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.setPadding(this.jdField_a_of_type_CooperationQzoneApiFeedListView.getPaddingLeft(), this.jdField_b_of_type_Int, this.jdField_a_of_type_CooperationQzoneApiFeedListView.getPaddingRight(), jdField_a_of_type_Int);
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.postDelayed(new ExtendFriendCampusFragment.7(this), 20L);
    }
  }
  
  public void onPause()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onPause");
    super.onPause();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.h();
    }
  }
  
  public void onResume()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onResume");
    super.onResume();
    if ((this.c) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView != null))
    {
      List localList = this.jdField_a_of_type_Aqbg.a(1);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendSearchBarView.setSearchTags((ArrayList)localList, 0);
      this.c = false;
    }
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.g();
    }
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
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.f();
    }
  }
  
  public void onStop()
  {
    QLog.i("ExtendFriendCampusFragment", 4, "onStop");
    super.onStop();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusFragment
 * JD-Core Version:    0.7.0.1
 */