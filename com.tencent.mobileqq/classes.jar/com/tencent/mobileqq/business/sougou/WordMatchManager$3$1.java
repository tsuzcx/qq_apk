package com.tencent.mobileqq.business.sougou;

import anyq;
import java.util.ArrayList;
import java.util.Iterator;

class WordMatchManager$3$1
  implements Runnable
{
  WordMatchManager$3$1(WordMatchManager.3 param3) {}
  
  public void run()
  {
    this.a.this$0.b = this.a.a;
    this.a.this$0.c = this.a.a;
    this.a.this$0.d = false;
    this.a.this$0.e = false;
    Iterator localIterator = this.a.this$0.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      anyq localanyq = (anyq)localIterator.next();
      if (localanyq != null) {
        localanyq.a(this.a.this$0.jdField_a_of_type_Anyr);
      }
    }
    this.a.this$0.jdField_a_of_type_JavaUtilArrayList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.3.1
 * JD-Core Version:    0.7.0.1
 */