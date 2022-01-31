package com.tencent.mobileqq.widget;

import akul;
import akum;
import akun;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.Pair;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class GuideViewBuilder
{
  akun jdField_a_of_type_Akun;
  Context jdField_a_of_type_AndroidContentContext;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  public PopupWindow a;
  
  public GuideViewBuilder(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Akun = new akun(this, paramContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setWindowLayoutMode(-1, -1);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setBackgroundDrawable(new ColorDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131492883)));
  }
  
  public GuideViewBuilder a(int paramInt, View paramView, GuideViewBuilder.GuideLayoutParams paramGuideLayoutParams)
  {
    akum localakum = (akum)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localakum != null) {
      localakum.jdField_a_of_type_JavaUtilArrayList.add(new Pair(paramView, paramGuideLayoutParams));
    }
    return this;
  }
  
  public GuideViewBuilder a(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) == null)
    {
      akum localakum = new akum(this, null);
      localakum.jdField_a_of_type_AndroidViewView = paramView;
      if (paramView.isShown())
      {
        localakum.jdField_a_of_type_ArrayOfInt = new int[2];
        paramView.getLocationOnScreen(localakum.jdField_a_of_type_ArrayOfInt);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localakum);
    }
    return this;
  }
  
  public void a(int paramInt, View.OnClickListener paramOnClickListener)
  {
    akum localakum = (akum)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localakum != null) {
      localakum.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    }
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    a(paramOnDismissListener, true);
  }
  
  public void a(PopupWindow.OnDismissListener paramOnDismissListener, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setContentView(this.jdField_a_of_type_Akun);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(new View(this.jdField_a_of_type_AndroidContentContext), 0, 0, 0);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setOnDismissListener(paramOnDismissListener);
    this.jdField_a_of_type_Akun.setOnClickListener(new akul(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GuideViewBuilder
 * JD-Core Version:    0.7.0.1
 */