package com.tencent.widget;

import android.util.SparseArray;
import android.view.View;

class AbsSpinner$RecycleBin
{
  private final SparseArray<View> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  
  AbsSpinner$RecycleBin(AbsSpinner paramAbsSpinner) {}
  
  View a(int paramInt)
  {
    View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localView != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.delete(paramInt);
    }
    return localView;
  }
  
  void a()
  {
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    int j = localSparseArray.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)localSparseArray.valueAt(i);
      if (localView != null) {
        AbsSpinner.a(this.jdField_a_of_type_ComTencentWidgetAbsSpinner, localView, true);
      }
      i += 1;
    }
    localSparseArray.clear();
  }
  
  public void a(int paramInt, View paramView)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
  }
  
  void b()
  {
    SparseArray localSparseArray = this.jdField_a_of_type_AndroidUtilSparseArray;
    int j = localSparseArray.size();
    int i = 0;
    View localView;
    if (i < j)
    {
      localView = (View)localSparseArray.valueAt(i);
      if ((localView == null) || (!(localView.getTag(2131367678) instanceof Boolean))) {
        break label94;
      }
    }
    label94:
    for (boolean bool = ((Boolean)localView.getTag(2131367678)).booleanValue();; bool = true)
    {
      if ((localView != null) && (bool)) {
        AbsSpinner.b(this.jdField_a_of_type_ComTencentWidgetAbsSpinner, localView, true);
      }
      i += 1;
      break;
      localSparseArray.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.widget.AbsSpinner.RecycleBin
 * JD-Core Version:    0.7.0.1
 */