package com.tencent.mobileqq.extendfriend.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import apwx;
import aqao;
import aqap;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ExtendFriendCampusSearchFragment
  extends ExtendFriendSearchBaseFragment
  implements aqap
{
  private apwx jdField_a_of_type_Apwx;
  private aqao jdField_a_of_type_Aqao;
  
  private void c()
  {
    String str = this.jdField_a_of_type_Apwx.b();
    List localList1 = this.jdField_a_of_type_Apwx.b(1);
    List localList2 = this.jdField_a_of_type_Aqao.a();
    b(str);
    b((ArrayList)localList1);
    a((ArrayList)localList2);
  }
  
  void a()
  {
    this.jdField_a_of_type_Aqao.a();
  }
  
  void a(ViewGroup paramViewGroup)
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    localTextView.setGravity(17);
    localTextView.setTextColor(-16777216);
    localTextView.setTextSize(40.0F);
    localTextView.setText("搜索内容");
    paramViewGroup.addView(localTextView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendCampusSearchFragment", 2, String.format("onSearch searchKey=%s", new Object[] { paramString }));
    }
    this.jdField_a_of_type_Aqao.a(paramString);
  }
  
  public void b()
  {
    a((ArrayList)this.jdField_a_of_type_Aqao.a());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Apwx = ((apwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264));
    this.jdField_a_of_type_Aqao = this.jdField_a_of_type_Apwx.b();
    this.jdField_a_of_type_Aqao.a(this);
  }
  
  public void onResume()
  {
    super.onResume();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.fragment.ExtendFriendCampusSearchFragment
 * JD-Core Version:    0.7.0.1
 */