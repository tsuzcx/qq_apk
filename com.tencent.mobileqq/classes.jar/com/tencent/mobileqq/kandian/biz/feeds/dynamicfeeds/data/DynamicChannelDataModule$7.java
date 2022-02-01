package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data;

import java.util.List;

class DynamicChannelDataModule$7
  implements Runnable
{
  DynamicChannelDataModule$7(DynamicChannelDataModule paramDynamicChannelDataModule, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3, List paramList) {}
  
  public void run()
  {
    if (this.a)
    {
      DataEventDispatcher.a().a(this.b, this.c, this.d, this.e);
      return;
    }
    DataEventDispatcher.a().b(this.b, this.c, this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelDataModule.7
 * JD-Core Version:    0.7.0.1
 */