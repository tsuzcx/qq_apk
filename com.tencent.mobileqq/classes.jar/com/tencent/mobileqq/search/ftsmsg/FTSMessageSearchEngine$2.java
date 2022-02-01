package com.tencent.mobileqq.search.ftsmsg;

import bcdc;
import bclx;
import bcmk;
import java.util.List;

public class FTSMessageSearchEngine$2
  implements Runnable
{
  public FTSMessageSearchEngine$2(bcdc parambcdc, bcmk parambcmk, bclx parambclx) {}
  
  public void run()
  {
    List localList = this.this$0.b(this.jdField_a_of_type_Bcmk);
    if (this.jdField_a_of_type_Bclx != null) {
      this.jdField_a_of_type_Bclx.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */