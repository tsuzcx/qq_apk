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

public class EditTroopNameService
  implements IEditInfoApi
{
  private static String jdField_a_of_type_JavaLangString = "EditTroopNameService";
  private Context jdField_a_of_type_AndroidContentContext;
  private IEditInfoActivity jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity = null;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public int a()
  {
    return 0;
  }
  
  public Intent a(Intent paramIntent)
  {
    this.b = paramIntent.getStringExtra("default_text");
    this.jdField_a_of_type_Boolean = paramIntent.getBooleanExtra("edit_mode", false);
    this.c = paramIntent.getStringExtra("troopUin");
    return paramIntent;
  }
  
  public View.OnClickListener a()
  {
    return new EditTroopNameService.2(this);
  }
  
  public EmoticonCallback a()
  {
    return null;
  }
  
  public OnItemSelectListener a()
  {
    return new EditTroopNameService.1(this);
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ViewGroup paramViewGroup1, EditText paramEditText, ViewGroup paramViewGroup2) {}
  
  public void a(IEditInfoActivity paramIEditInfoActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopActivityEditinfoIEditInfoActivity = paramIEditInfoActivity;
    this.jdField_a_of_type_AndroidContentContext = paramIEditInfoActivity.getContext();
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.editservice.EditTroopNameService
 * JD-Core Version:    0.7.0.1
 */