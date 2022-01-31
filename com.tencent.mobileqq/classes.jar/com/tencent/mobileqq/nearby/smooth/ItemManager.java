package com.tencent.mobileqq.nearby.smooth;

import afqh;
import afqj;
import afqk;
import afql;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.AbsListView;

public final class ItemManager
{
  public int a;
  public afqh a;
  public final Handler a;
  final ItemLoader a;
  public boolean a;
  public boolean b;
  
  public void a()
  {
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1, this);
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(afqh paramafqh)
  {
    this.jdField_a_of_type_Afqh = paramafqh;
    if (this.jdField_a_of_type_Afqh != null)
    {
      paramafqh = this.jdField_a_of_type_Afqh.a();
      paramafqh.setOnScrollListener(new afqk(this, null));
      paramafqh.setOnTouchListener(new afqj(this, null));
      paramafqh.setOnItemSelectedListener(new afql(this, null));
    }
  }
  
  public void a(View paramView1, View paramView2, int paramInt)
  {
    this.jdField_a_of_type_Afqh.a();
    ListAdapter localListAdapter = this.jdField_a_of_type_Afqh.a();
    if ((this.jdField_a_of_type_Int != 2) && (!this.jdField_a_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(paramView1, paramView2, localListAdapter, paramInt, bool);
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Afqh == null) {
      throw new IllegalStateException("Cannot cancel requests with no managed view");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Afqh.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemManager
 * JD-Core Version:    0.7.0.1
 */