package com.tencent.mobileqq.emosm.view;

import android.util.SparseIntArray;
import java.util.ArrayList;

class DragSortListView$HeightCache
{
  private int jdField_a_of_type_Int;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray;
  private ArrayList<Integer> jdField_a_of_type_JavaUtilArrayList;
  
  public DragSortListView$HeightCache(DragSortListView paramDragSortListView, int paramInt)
  {
    this.jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray(paramInt);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramInt);
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a(int paramInt)
  {
    return this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt, -1);
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidUtilSparseIntArray.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_AndroidUtilSparseIntArray.get(paramInt1, -1);
    if (i != paramInt2)
    {
      if (i == -1)
      {
        if (this.jdField_a_of_type_AndroidUtilSparseIntArray.size() == this.jdField_a_of_type_Int) {
          this.jdField_a_of_type_AndroidUtilSparseIntArray.delete(((Integer)this.jdField_a_of_type_JavaUtilArrayList.remove(0)).intValue());
        }
      }
      else {
        this.jdField_a_of_type_JavaUtilArrayList.remove(Integer.valueOf(paramInt1));
      }
      this.jdField_a_of_type_AndroidUtilSparseIntArray.put(paramInt1, paramInt2);
      this.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(paramInt1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView.HeightCache
 * JD-Core Version:    0.7.0.1
 */