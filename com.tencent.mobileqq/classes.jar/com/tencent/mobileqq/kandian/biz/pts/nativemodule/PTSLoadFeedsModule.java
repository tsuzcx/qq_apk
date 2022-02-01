package com.tencent.mobileqq.kandian.biz.pts.nativemodule;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.pts.PTSEventDispatcher;
import com.tencent.mobileqq.kandian.repo.pts.PTSEventDispatcher.PTSObserver;
import com.tencent.pts.nativemodule.IPTSLoadFeeds;
import com.tencent.qphone.base.util.QLog;

public class PTSLoadFeedsModule
  implements IPTSLoadFeeds
{
  private PTSEventDispatcher.PTSObserver a = new PTSLoadFeedsModule.1(this);
  
  public PTSLoadFeedsModule()
  {
    PTSEventDispatcher.a().a(this.a);
  }
  
  public void loadFeeds(long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    ReadInJoyLogicManager localReadInJoyLogicManager = (ReadInJoyLogicManager)((QQAppInterface)ReadInJoyUtils.b()).getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[loadFeeds], channelID = ");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(", limitCount = ");
    localStringBuilder.append(paramInt);
    QLog.i("PTSLoadFeedsModule", 1, localStringBuilder.toString());
    if (localReadInJoyLogicManager != null) {
      localReadInJoyLogicManager.getReadInJoyLogicEngine().a((int)paramLong1, paramInt, 9223372036854775807L, true, paramLong3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.nativemodule.PTSLoadFeedsModule
 * JD-Core Version:    0.7.0.1
 */