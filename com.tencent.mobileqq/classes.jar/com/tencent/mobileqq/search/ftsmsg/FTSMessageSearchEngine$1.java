package com.tencent.mobileqq.search.ftsmsg;

import ayhe;
import aypy;
import ayql;
import bdli;
import java.util.List;

public class FTSMessageSearchEngine$1
  implements Runnable
{
  public FTSMessageSearchEngine$1(ayhe paramayhe, ayql paramayql, aypy paramaypy) {}
  
  public void run()
  {
    if (bdli.g(ayhe.a(this.this$0)) == 1) {}
    for (List localList = this.this$0.b(this.jdField_a_of_type_Ayql, false);; localList = this.this$0.a(this.jdField_a_of_type_Ayql, false))
    {
      if (this.jdField_a_of_type_Aypy != null) {
        this.jdField_a_of_type_Aypy.a(localList, 1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */