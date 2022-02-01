package com.tencent.mobileqq.troop.activity.editinfo;

import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

public abstract interface IEditInfoApi
{
  public abstract Intent a(Intent paramIntent);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void a(ViewGroup paramViewGroup1, EditText paramEditText, ViewGroup paramViewGroup2);
  
  public abstract void a(IEditInfoActivity paramIEditInfoActivity);
  
  public abstract OnItemSelectListener b();
  
  public abstract void c();
  
  public abstract int d();
  
  public abstract View.OnClickListener e();
  
  public abstract EmoticonCallback f();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.editinfo.IEditInfoApi
 * JD-Core Version:    0.7.0.1
 */