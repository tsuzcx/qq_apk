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
    int i = this.jdField_a_of_type_Int;
    long l = this.jdField_a_of_type_Long;
    int j = this.b;
    localObject = ((EntityManager)localObject).query(DynamicChannelDataModel.class, true, "channelID = ? and recommendSeq > ?", new String[] { String.valueOf(i), String.valueOf(l) }, null, null, "recommendSeq asc", String.valueOf(j));
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      localObject = DynamicChannelDataModule.a(this.this$0, this.jdField_a_of_type_Int, (List)localObject, false);
      DynamicChannelDataModule.a(this.this$0, false, this.jdField_a_of_type_Int, true, true, (List)localObject);
      return;
    }
    DynamicChannelDataModule.a(this.this$0, this.jdField_a_of_type_Int, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelDataModule.5
 * JD-Core Version:    0.7.0.1
 */