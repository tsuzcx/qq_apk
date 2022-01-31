package com.tencent.mobileqq.hotpic;

import android.util.SparseArray;
import java.util.ArrayList;

public class HotPicIndexAndIDMap
{
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public HotPicTagInfo a(int paramInt)
  {
    return (HotPicTagInfo)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
  }
  
  public void a(HotPicTagInfo paramHotPicTagInfo)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramHotPicTagInfo);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramHotPicTagInfo.tagId, paramHotPicTagInfo);
  }
  
  public HotPicTagInfo b(int paramInt)
  {
    return (HotPicTagInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.hotpic.HotPicIndexAndIDMap
 * JD-Core Version:    0.7.0.1
 */