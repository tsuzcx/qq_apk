package com.tencent.mobileqq.nearby.smooth;

import afmi;
import afmk;
import afml;
import afmm;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ListAdapter;
import com.tencent.widget.AbsListView;

public final class ItemManager
{
  public int a;
  public afmi a;
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
  
  public void a(afmi paramafmi)
  {
    this.jdField_a_of_type_Afmi = paramafmi;
    if (this.jdField_a_of_type_Afmi != null)
    {
      paramafmi = this.jdField_a_of_type_Afmi.a();
      paramafmi.setOnScrollListener(new afml(this, null));
      paramafmi.setOnTouchListener(new afmk(this, null));
      paramafmi.setOnItemSelectedListener(new afmm(this, null));
    }
  }
  
  public void a(View paramView1, View paramView2, int paramInt)
  {
    this.jdField_a_of_type_Afmi.a();
    ListAdapter localListAdapter = this.jdField_a_of_type_Afmi.a();
    if ((this.jdField_a_of_type_Int != 2) && (!this.jdField_a_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(paramView1, paramView2, localListAdapter, paramInt, bool);
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Afmi == null) {
      throw new IllegalStateException("Cannot cancel requests with no managed view");
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbySmoothItemLoader.a(this.jdField_a_of_type_Afmi.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.smooth.ItemManager
 * JD-Core Version:    0.7.0.1
 */