package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data;

import com.tencent.mobileqq.kandian.biz.pts.data.DynamicChannelDataModel;
import java.util.Comparator;

class DynamicChannelDataModule$8
  implements Comparator<DynamicChannelDataModel>
{
  DynamicChannelDataModule$8(DynamicChannelDataModule paramDynamicChannelDataModule) {}
  
  public int a(DynamicChannelDataModel paramDynamicChannelDataModel1, DynamicChannelDataModel paramDynamicChannelDataModel2)
  {
    if (paramDynamicChannelDataModel1.recommendSeq == paramDynamicChannelDataModel2.recommendSeq) {
      return 0;
    }
    if (paramDynamicChannelDataModel1.recommendSeq < paramDynamicChannelDataModel2.recommendSeq) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelDataModule.8
 * JD-Core Version:    0.7.0.1
 */