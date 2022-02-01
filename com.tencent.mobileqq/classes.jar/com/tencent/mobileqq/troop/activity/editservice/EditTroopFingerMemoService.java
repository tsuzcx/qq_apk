package com.tencent.mobileqq.troop.activity.editservice;

import android.content.Context;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoActivity;
import com.tencent.mobileqq.troop.activity.editinfo.IEditInfoApi;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class EditTroopFingerMemoService
  implements IEditInfoApi
{
  private Context jdField_a_of_type_AndroidContentContext;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private IEditInfoActivity jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity;
  private String jdField_a_of_type_JavaLangString;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  
  public int a()
  {
    return 0;
  }
  
  public Intent a(Intent paramIntent)
  {
    this.jdField_a_of_type_JavaLangString = paramIntent.getStringExtra("default_text");
    return paramIntent;
  }
  
  public View.OnClickListener a()
  {
    return null;
  }
  
  public EmoticonCallback a()
  {
    return new EditTroopFingerMemoService.2(this);
  }
  
  public OnItemSelectListener a()
  {
    return new EditTroopFingerMemoService.1(this);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ViewGroup paramViewGroup1, EditText paramEditText, ViewGroup paramViewGroup2)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
  }
  
  public void a(IEditInfoActivity paramIEditInfoActivity)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.jdField_a_of_type_AndroidContentContext = paramIEditInfoActivity.getContext();
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity = paramIEditInfoActivity;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.editservice.EditTroopFingerMemoService
 * JD-Core Version:    0.7.0.1
 */