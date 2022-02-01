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
  private IEditInfoActivity a;
  private EditText b;
  private AppRuntime c;
  private Context d;
  private String e;
  
  public Intent a(Intent paramIntent)
  {
    this.e = paramIntent.getStringExtra("default_text");
    return paramIntent;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ViewGroup paramViewGroup1, EditText paramEditText, ViewGroup paramViewGroup2)
  {
    this.b = paramEditText;
  }
  
  public void a(IEditInfoActivity paramIEditInfoActivity)
  {
    this.c = MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.d = paramIEditInfoActivity.getContext();
    this.a = paramIEditInfoActivity;
  }
  
  public OnItemSelectListener b()
  {
    return new EditTroopFingerMemoService.1(this);
  }
  
  public void c() {}
  
  public int d()
  {
    return 0;
  }
  
  public View.OnClickListener e()
  {
    return null;
  }
  
  public EmoticonCallback f()
  {
    return new EditTroopFingerMemoService.2(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.editservice.EditTroopFingerMemoService
 * JD-Core Version:    0.7.0.1
 */