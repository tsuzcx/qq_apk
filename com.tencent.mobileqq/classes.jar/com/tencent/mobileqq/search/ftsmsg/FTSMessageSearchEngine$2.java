package com.tencent.mobileqq.search.ftsmsg;

import awmb;
import awuv;
import awvi;
import java.util.List;

public class FTSMessageSearchEngine$2
  implements Runnable
{
  public FTSMessageSearchEngine$2(awmb paramawmb, awvi paramawvi, awuv paramawuv) {}
  
  public void run()
  {
    List localList = this.this$0.b(this.jdField_a_of_type_Awvi);
    if (this.jdField_a_of_type_Awuv != null) {
      this.jdField_a_of_type_Awuv.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */