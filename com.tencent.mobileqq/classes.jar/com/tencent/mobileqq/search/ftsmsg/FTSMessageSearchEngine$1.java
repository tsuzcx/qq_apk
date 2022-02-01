package com.tencent.mobileqq.search.ftsmsg;

import bcdk;
import bcmd;
import bcmq;
import bhut;
import java.util.List;

public class FTSMessageSearchEngine$1
  implements Runnable
{
  public FTSMessageSearchEngine$1(bcdk parambcdk, bcmq parambcmq, bcmd parambcmd) {}
  
  public void run()
  {
    if (bhut.g(bcdk.a(this.this$0)) == 1) {}
    for (List localList = this.this$0.b(this.jdField_a_of_type_Bcmq, false);; localList = this.this$0.a(this.jdField_a_of_type_Bcmq, false))
    {
      if (this.jdField_a_of_type_Bcmd != null) {
        this.jdField_a_of_type_Bcmd.a(localList, 1);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */