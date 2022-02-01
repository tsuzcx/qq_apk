package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data;

import com.tencent.mobileqq.kandian.base.utils.CollectionUtils.IPredicate;
import com.tencent.mobileqq.kandian.biz.pts.data.DynamicChannelDataModel;

class DynamicChannelDataModule$4
  implements CollectionUtils.IPredicate<DynamicChannelDataModel>
{
  DynamicChannelDataModule$4(DynamicChannelDataModule paramDynamicChannelDataModule, long paramLong) {}
  
  public boolean a(DynamicChannelDataModel paramDynamicChannelDataModel)
  {
    return paramDynamicChannelDataModel.recommendSeq > this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelDataModule.4
 * JD-Core Version:    0.7.0.1
 */