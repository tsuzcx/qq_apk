package com.tencent.mobileqq.doutu.api.impl;

import com.tencent.mobileqq.doutu.DoutuEmotionAdapter;
import java.util.List;

class DoutuServiceImpl$5
  implements Runnable
{
  DoutuServiceImpl$5(DoutuServiceImpl paramDoutuServiceImpl, boolean paramBoolean1, List paramList, boolean paramBoolean2, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.mDoutuAdapter != null)
    {
      if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilList.size() >= 0))
      {
        this.this$0.mDoutuAdapter.a(this.jdField_a_of_type_JavaUtilList, this.b, this.jdField_a_of_type_Long);
        return;
      }
      if (this.b) {
        this.this$0.mDoutuAdapter.a(this.jdField_a_of_type_Long);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.impl.DoutuServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */