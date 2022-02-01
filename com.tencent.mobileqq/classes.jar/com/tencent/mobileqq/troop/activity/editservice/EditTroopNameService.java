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
  private static String a = "EditTroopNameService";
  private IEditInfoActivity b = null;
  private Context c;
  private String d;
  private String e;
  private boolean f;
  
  public Intent a(Intent paramIntent)
  {
    this.d = paramIntent.getStringExtra("default_text");
    this.f = paramIntent.getBooleanExtra("edit_mode", false);
    this.e = paramIntent.getStringExtra("troopUin");
    return paramIntent;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ViewGroup paramViewGroup1, EditText paramEditText, ViewGroup paramViewGroup2) {}
  
  public void a(IEditInfoActivity paramIEditInfoActivity)
  {
    this.b = paramIEditInfoActivity;
    this.c = paramIEditInfoActivity.getContext();
  }
  
  public OnItemSelectListener b()
  {
    return new EditTroopNameService.1(this);
  }
  
  public void c() {}
  
  public int d()
  {
    return 0;
  }
  
  public View.OnClickListener e()
  {
    return new EditTroopNameService.2(this);
  }
  
  public EmoticonCallback f()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.editservice.EditTroopNameService
 * JD-Core Version:    0.7.0.1
 */