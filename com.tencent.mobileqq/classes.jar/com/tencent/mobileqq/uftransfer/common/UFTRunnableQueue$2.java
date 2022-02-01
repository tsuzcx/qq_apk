package com.tencent.mobileqq.uftransfer.common;

import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.LinkedList;
import java.util.Map;

class UFTRunnableQueue$2
  implements Runnable
{
  UFTRunnableQueue$2(UFTRunnableQueue paramUFTRunnableQueue, long paramLong, UFTRunnableQueue.IUFTRunnable paramIUFTRunnable) {}
  
  public void run()
  {
    UFTRunnableQueue.a(this.this$0).put(Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_ComTencentMobileqqUftransferCommonUFTRunnableQueue$IUFTRunnable);
    UFTRunnableQueue.a(this.this$0).add(Long.valueOf(this.jdField_a_of_type_Long));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] add Runnable. ");
    localStringBuilder.append(this.this$0.a());
    UFTLog.b("[UFTTransfer] UFTRunnableQueue", 1, localStringBuilder.toString());
    UFTRunnableQueue.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.UFTRunnableQueue.2
 * JD-Core Version:    0.7.0.1
 */