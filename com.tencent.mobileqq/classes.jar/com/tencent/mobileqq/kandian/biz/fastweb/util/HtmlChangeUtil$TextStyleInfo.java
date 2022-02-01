package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.util.SparseArray;
import java.util.Stack;

class HtmlChangeUtil$TextStyleInfo
{
  SparseArray<Integer> a = new SparseArray();
  SparseArray<Object> b = new SparseArray();
  Stack<String> c = new Stack();
  
  public int a()
  {
    int j = -1;
    int k = 3;
    int i = 0;
    while (i < this.a.size())
    {
      int m = j;
      if (this.a.keyAt(i) > j)
      {
        m = this.a.keyAt(i);
        k = ((Integer)this.a.valueAt(i)).intValue();
      }
      i += 1;
      j = m;
    }
    return k;
  }
  
  public int b()
  {
    int i = this.c.size() - 1;
    while (i >= 0)
    {
      String str = (String)this.c.get(i);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.HtmlChangeUtil.TextStyleInfo
 * JD-Core Version:    0.7.0.1
 */