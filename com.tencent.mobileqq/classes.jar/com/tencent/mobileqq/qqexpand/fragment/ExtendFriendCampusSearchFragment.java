package com.tencent.mobileqq.qqexpand.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendSearchHistoryManager;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendSearchHistoryManager.HistoryTagChangeListener;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
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
  private ExtendEmptyViewDirector jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendEmptyViewDirector;
  private ExtendFriendSearchHistoryManager jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendSearchHistoryManager;
  private IExpandManager jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager;
  private FeedListView jdField_a_of_type_CooperationQzoneApiFeedListView;
  private boolean jdField_a_of_type_Boolean;
  
  private void c()
  {
    List localList1 = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.b(1);
    List localList2 = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendSearchHistoryManager.a();
    b("");
    b((ArrayList)localList1);
    a((ArrayList)localList2);
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendSearchHistoryManager.a();
  }
  
  void a(ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null)
    {
      if (getBaseActivity() == null) {
        return;
      }
      View localView = LayoutInflater.from(getBaseActivity()).inflate(2131561092, paramViewGroup, false);
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendEmptyViewDirector = new ExtendEmptyViewDirector(localView);
      this.jdField_a_of_type_CooperationQzoneApiFeedListView = ((FeedListView)localView.findViewById(2131376948));
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.setExtArgs(Collections.singletonMap("search_mode", "1"));
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOverScrollMode(0);
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.setEdgeEffectEnabled(false);
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.setVerticalScrollBarEnabled(false);
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.attach(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
      paramViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
    }
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusSearchFragment", 2, String.format("onSearch searchKey=%s", new Object[] { paramString }));
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendSearchHistoryManager.a(paramString);
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendEmptyViewDirector.b();
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOverScrollMode(0);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.postDelayed(new ExtendFriendCampusSearchFragment.1(this, paramString), 800L);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.switchTag(paramString, this);
  }
  
  public void aM_()
  {
    a((ArrayList)this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendSearchHistoryManager.a());
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      paramInt1 = -1;
      break;
    case 1208: 
      paramInt1 = 1208;
      break;
    case 1207: 
      paramInt1 = 1207;
      break;
    case 1206: 
      paramInt1 = 1206;
      break;
    case 1205: 
      paramInt1 = 1205;
    }
    if (paramInt1 != -1)
    {
      FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
      if (localFeedListView != null) {
        localFeedListView.doActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager = ((IExpandManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendSearchHistoryManager = this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerIExpandManager.b();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandManagerExtendFriendSearchHistoryManager.a(this);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onLoadOver(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_CooperationQzoneApiFeedListView.getFeedCnt() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendEmptyViewDirector.d();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendEmptyViewDirector.a();
      return;
    }
    if (NetworkUtil.isNetworkAvailable())
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendEmptyViewDirector.c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandFragmentExtendEmptyViewDirector.e();
  }
  
  public void onPause()
  {
    super.onPause();
    FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localFeedListView != null) {
      localFeedListView.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    c();
    FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localFeedListView != null) {
      localFeedListView.onResume();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localFeedListView != null) {
      localFeedListView.onStart();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    FeedListView localFeedListView = this.jdField_a_of_type_CooperationQzoneApiFeedListView;
    if (localFeedListView != null) {
      localFeedListView.onStop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendFriendCampusSearchFragment
 * JD-Core Version:    0.7.0.1
 */