package com.tencent.mobileqq.search.ftsmsg;

import bcdk;
import bcmd;
import bcmq;
import java.util.List;

public class FTSMessageSearchEngine$2
  implements Runnable
{
  public FTSMessageSearchEngine$2(bcdk parambcdk, bcmq parambcmq, bcmd parambcmd) {}
  
  public void run()
  {
    List localList = this.this$0.b(this.jdField_a_of_type_Bcmq);
    if (this.jdField_a_of_type_Bcmd != null) {
      this.jdField_a_of_type_Bcmd.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */