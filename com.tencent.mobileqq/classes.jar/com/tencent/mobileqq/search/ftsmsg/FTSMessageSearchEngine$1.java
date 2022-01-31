package com.tencent.mobileqq.search.ftsmsg;

import awmb;
import awuv;
import awvi;
import bbmo;
import java.util.List;

public class FTSMessageSearchEngine$1
  implements Runnable
{
  public FTSMessageSearchEngine$1(awmb paramawmb, awvi paramawvi, awuv paramawuv) {}
  
  public void run()
  {
    if (bbmo.g(awmb.a(this.this$0)) == 1) {}
    for (List localList = this.this$0.b(this.jdField_a_of_type_Awvi, false);; localList = this.this$0.a(this.jdField_a_of_type_Awvi, false))
    {
      if (this.jdField_a_of_type_Awuv != null) {
        this.jdField_a_of_type_Awuv.a(localList, 1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */