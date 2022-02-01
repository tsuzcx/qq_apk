package com.tencent.mobileqq.search.ftsmsg;

import bcdc;
import bclx;
import bcmk;
import bhkf;
import java.util.List;

public class FTSMessageSearchEngine$1
  implements Runnable
{
  public FTSMessageSearchEngine$1(bcdc parambcdc, bcmk parambcmk, bclx parambclx) {}
  
  public void run()
  {
    if (bhkf.g(bcdc.a(this.this$0)) == 1) {}
    for (List localList = this.this$0.b(this.jdField_a_of_type_Bcmk, false);; localList = this.this$0.a(this.jdField_a_of_type_Bcmk, false))
    {
      if (this.jdField_a_of_type_Bclx != null) {
        this.jdField_a_of_type_Bclx.a(localList, 1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */