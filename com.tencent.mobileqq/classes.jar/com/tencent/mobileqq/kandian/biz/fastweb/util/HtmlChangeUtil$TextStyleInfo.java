package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.util.SparseArray;
import java.util.Stack;

class HtmlChangeUtil$TextStyleInfo
{
  SparseArray<Integer> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  Stack<String> jdField_a_of_type_JavaUtilStack = new Stack();
  SparseArray<Object> b = new SparseArray();
  
  public int a()
  {
    int j = -1;
    int k = 3;
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      int m = j;
      if (this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i) > j)
      {
        m = this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i);
        k = ((Integer)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i)).intValue();
      }
      i += 1;
      j = m;
    }
    return k;
  }
  
  public int b()
  {
    int i = this.jdField_a_of_type_JavaUtilStack.size() - 1;
    while (i >= 0)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilStack.get(i);
      if (HtmlChangeUtil.a().equals(str)) {
        return 3;
      }
      if (HtmlChangeUtil.b().equals(str)) {
        return 2;
      }
      i -= 1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.HtmlChangeUtil.TextStyleInfo
 * JD-Core Version:    0.7.0.1
 */