package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data;

import com.tencent.mobileqq.kandian.biz.pts.data.DynamicChannelDataModel;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

class DynamicChannelDataModule$10
  implements Runnable
{
  DynamicChannelDataModule$10(DynamicChannelDataModule paramDynamicChannelDataModule, int paramInt) {}
  
  public void run()
  {
    EntityManager localEntityManager = DynamicChannelDataModule.a(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DELETE FROM ");
    localStringBuilder.append(DynamicChannelDataModel.class.getSimpleName());
    localStringBuilder.append(" WHERE channelID = ");
    localStringBuilder.append(this.a);
    boolean bool = localEntityManager.execSQL(localStringBuilder.toString());
    QLog.d("DynamicChannelDataModule", 2, new Object[] { "clear dataModel from db, channelID = ", Integer.valueOf(this.a), ", res = ", Boolean.valueOf(bool) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.data.DynamicChannelDataModule.10
 * JD-Core Version:    0.7.0.1
 */