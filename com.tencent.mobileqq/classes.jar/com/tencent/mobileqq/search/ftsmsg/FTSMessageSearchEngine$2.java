package com.tencent.mobileqq.search.ftsmsg;

import ayhe;
import aypy;
import ayql;
import java.util.List;

public class FTSMessageSearchEngine$2
  implements Runnable
{
  public FTSMessageSearchEngine$2(ayhe paramayhe, ayql paramayql, aypy paramaypy) {}
  
  public void run()
  {
    List localList = this.this$0.b(this.jdField_a_of_type_Ayql);
    if (this.jdField_a_of_type_Aypy != null) {
      this.jdField_a_of_type_Aypy.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */