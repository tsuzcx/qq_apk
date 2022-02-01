package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data;

import com.tencent.mobileqq.kandian.biz.pts.data.DynamicChannelDataModel;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

class DynamicChannelDataModule$5
  implements Runnable
{
  DynamicChannelDataModule$5(DynamicChannelDataModule paramDynamicChannelDataModule, int paramInt1, long paramLong, int paramInt2) {}
  
  public void run()
  {
    Object localObject = DynamicChannelDataModule.a(this.this$0);
    int i = this.a;
    long l = this.b;
    int j = this.c;
    localObject = ((EntityManager)localObject).query(DynamicChannelDataModel.class, true, "channelID = ? and recommendSeq > ?", new String[] { String.valueOf(i), String.valueOf(l) }, null, null, "recommendSeq asc", String.valueOf(j));
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = DynamicChannelDataModule.a(this.this$0, this.a, (List)localObject, false);
      DynamicChannelDataModule.a(this.this$0, false, this.a, true, true, (List)localObject);
      return;
    }
    DynamicChannelDataModule.a(this.this$0, this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelDataModule.5
 * JD-Core Version:    0.7.0.1
 */