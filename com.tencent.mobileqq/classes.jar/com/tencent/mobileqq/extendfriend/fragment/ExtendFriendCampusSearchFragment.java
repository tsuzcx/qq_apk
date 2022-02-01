package com.tencent.mobileqq.extendfriend.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.FeedListView;
import cooperation.qzone.api.FeedListView.LoadFeedCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtendFriendCampusSearchFragment
  extends ExtendFriendSearchBaseFragment
  implements ExtendFriendSearchHistoryManager.HistoryTagChangeListener, FeedListView.LoadFeedCallback
{
  private ExtendFriendManager jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager;
  private ExtendEmptyViewDirector jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector;
  private ExtendFriendSearchHistoryManager jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchHistoryManager;
  private FeedListView jdField_a_of_type_CooperationQzoneApiFeedListView;
  private boolean jdField_a_of_type_Boolean;
  
  private void c()
  {
    List localList1 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.b(1);
    List localList2 = this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchHistoryManager.a();
    b("");
    b((ArrayList)localList1);
    a((ArrayList)localList2);
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchHistoryManager.a();
  }
  
  void a(ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) || (getActivity() == null)) {
      return;
    }
    View localView = LayoutInflater.from(getActivity()).inflate(2131561236, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector = new ExtendEmptyViewDirector(localView);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView = ((FeedListView)localView.findViewById(2131377505));
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setExtArgs(Collections.singletonMap("search_mode", "1"));
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOverScrollMode(0);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setEdgeEffectEnabled(false);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.attach(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    paramViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusSearchFragment", 2, String.format("onSearch searchKey=%s", new Object[] { paramString }));
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchHistoryManager.a(paramString);
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector.b();
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOverScrollMode(0);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.postDelayed(new ExtendFriendCampusSearchFragment.1(this, paramString), 800L);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.switchTag(paramString, this);
  }
  
  public void b()
  {
    a((ArrayList)this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchHistoryManager.a());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      paramInt1 = -1;
    }
    for (;;)
    {
      if ((paramInt1 != -1) && (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null)) {
        this.jdField_a_of_type_CooperationQzoneApiFeedListView.doActivityResult(paramInt1, paramInt2, paramIntent);
      }
      return;
      paramInt1 = 20121205;
      continue;
      paramInt1 = 20121206;
      continue;
      paramInt1 = 20121207;
      continue;
      paramInt1 = 20121208;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager = ((ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchHistoryManager = this.jdField_a_of_type_ComTencentMobileqqExtendfriendExtendFriendManager.b();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendSearchHistoryManager.a(this);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_CooperationQzoneApiFeedListView.getFeedCnt() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector.d();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector.a();
      return;
    }
    if (NetworkUtil.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector.c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendEmptyViewDirector.e();
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    c();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.onStop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusSearchFragment
 * JD-Core Version:    0.7.0.1
 */