package com.tencent.mobileqq.extendfriend.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import asvi;
import asxn;
import aszn;
import aszo;
import bhnv;
import bmwu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.FeedListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExtendFriendCampusSearchFragment
  extends ExtendFriendSearchBaseFragment
  implements aszo, bmwu
{
  private asvi jdField_a_of_type_Asvi;
  private asxn jdField_a_of_type_Asxn;
  private aszn jdField_a_of_type_Aszn;
  private FeedListView jdField_a_of_type_CooperationQzoneApiFeedListView;
  private boolean jdField_a_of_type_Boolean;
  
  private void c()
  {
    List localList1 = this.jdField_a_of_type_Asvi.b(1);
    List localList2 = this.jdField_a_of_type_Aszn.a();
    b("");
    b((ArrayList)localList1);
    a((ArrayList)localList2);
  }
  
  void a()
  {
    this.jdField_a_of_type_Aszn.a();
  }
  
  void a(ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) || (getActivity() == null)) {
      return;
    }
    View localView = LayoutInflater.from(getActivity()).inflate(2131561204, paramViewGroup, false);
    this.jdField_a_of_type_Asxn = new asxn(localView);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView = ((FeedListView)localView.findViewById(2131377070));
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setExtArgs(Collections.singletonMap("search_mode", "1"));
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOverScrollMode(0);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setEdgeEffectEnabled(false);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin());
    paramViewGroup.addView(localView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusSearchFragment", 2, String.format("onSearch searchKey=%s", new Object[] { paramString }));
    }
    this.jdField_a_of_type_Aszn.a(paramString);
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView == null) {
      return;
    }
    this.jdField_a_of_type_Asxn.b();
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.setOverScrollMode(0);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.postDelayed(new ExtendFriendCampusSearchFragment.1(this, paramString), 800L);
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_a_of_type_CooperationQzoneApiFeedListView.a(paramString, this);
  }
  
  public void b()
  {
    a((ArrayList)this.jdField_a_of_type_Aszn.a());
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_CooperationQzoneApiFeedListView.b() == 0)
      {
        this.jdField_a_of_type_Asxn.d();
        return;
      }
      this.jdField_a_of_type_Asxn.a();
      return;
    }
    if (bhnv.a())
    {
      this.jdField_a_of_type_Asxn.c();
      return;
    }
    this.jdField_a_of_type_Asxn.e();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Asvi = ((asvi)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264));
    this.jdField_a_of_type_Aszn = this.jdField_a_of_type_Asvi.b();
    this.jdField_a_of_type_Aszn.a(this);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.h();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    c();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.g();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.f();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_CooperationQzoneApiFeedListView != null) {
      this.jdField_a_of_type_CooperationQzoneApiFeedListView.m();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusSearchFragment
 * JD-Core Version:    0.7.0.1
 */