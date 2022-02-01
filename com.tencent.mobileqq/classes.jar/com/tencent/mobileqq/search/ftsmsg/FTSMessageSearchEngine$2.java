package com.tencent.mobileqq.search.ftsmsg;

import bawm;
import bbff;
import bbfs;
import java.util.List;

public class FTSMessageSearchEngine$2
  implements Runnable
{
  public FTSMessageSearchEngine$2(bawm parambawm, bbfs parambbfs, bbff parambbff) {}
  
  public void run()
  {
    List localList = this.this$0.b(this.jdField_a_of_type_Bbfs);
    if (this.jdField_a_of_type_Bbff != null) {
      this.jdField_a_of_type_Bbff.a(localList, 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsmsg.FTSMessageSearchEngine.2
 * JD-Core Version:    0.7.0.1
 */