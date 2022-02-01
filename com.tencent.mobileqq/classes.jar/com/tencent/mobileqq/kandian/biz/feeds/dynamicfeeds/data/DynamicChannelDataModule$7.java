package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data;

import java.util.List;

class DynamicChannelDataModule$7
  implements Runnable
{
  DynamicChannelDataModule$7(DynamicChannelDataModule paramDynamicChannelDataModule, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, List paramList) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      DataEventDispatcher.a().a(this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_JavaUtilList);
      return;
    }
    DataEventDispatcher.a().b(this.jdField_a_of_type_Int, this.b, this.c, this.jdField_a_of_type_JavaUtilList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelDataModule.7
 * JD-Core Version:    0.7.0.1
 */