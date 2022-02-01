package com.tencent.mobileqq.search.ftsmsg;

import bbkr;
import bbtk;
import bbtx;
import bguq;
import java.util.List;

public class FTSMessageSearchEngine$1
  implements Runnable
{
  public FTSMessageSearchEngine$1(bbkr parambbkr, bbtx parambbtx, bbtk parambbtk) {}
  
  public void run()
  {
    if (bguq.g(bbkr.a(this.this$0)) == 1) {}
    for (List localList = this.this$0.b(this.jdField_a_of_type_Bbtx, false);; localList = this.this$0.a(this.jdField_a_of_type_Bbtx, false))
    {
      if (this.jdField_a_of_type_Bbtk != null) {
        this.jdField_a_of_type_Bbtk.a(localList, 1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */