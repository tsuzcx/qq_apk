package com.tencent.mobileqq.doutu;

import java.util.List;

class DoutuManager$5
  implements Runnable
{
  DoutuManager$5(DoutuManager paramDoutuManager, boolean paramBoolean1, List paramList, boolean paramBoolean2, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.a != null)
    {
      if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_JavaUtilList.size() < 0)) {
        break label52;
      }
      this.this$0.a.a(this.jdField_a_of_type_JavaUtilList, this.b, this.jdField_a_of_type_Long);
    }
    label52:
    while (!this.b) {
      return;
    }
    this.this$0.a.a(this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.DoutuManager.5
 * JD-Core Version:    0.7.0.1
 */