package com.tencent.mobileqq.extendfriend.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import aqbg;
import aqex;
import aqey;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class ExtendFriendCampusSearchFragment
  extends ExtendFriendSearchBaseFragment
  implements aqey
{
  private aqbg jdField_a_of_type_Aqbg;
  private aqex jdField_a_of_type_Aqex;
  
  private void c()
  {
    String str = this.jdField_a_of_type_Aqbg.b();
    List localList1 = this.jdField_a_of_type_Aqbg.b(1);
    List localList2 = this.jdField_a_of_type_Aqex.a();
    b(str);
    b((ArrayList)localList1);
    a((ArrayList)localList2);
  }
  
  void a()
  {
    this.jdField_a_of_type_Aqex.a();
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
    this.jdField_a_of_type_Aqex.a(paramString);
  }
  
  public void b()
  {
    a((ArrayList)this.jdField_a_of_type_Aqex.a());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Aqbg = ((aqbg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(264));
    this.jdField_a_of_type_Aqex = this.jdField_a_of_type_Aqbg.b();
    this.jdField_a_of_type_Aqex.a(this);
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