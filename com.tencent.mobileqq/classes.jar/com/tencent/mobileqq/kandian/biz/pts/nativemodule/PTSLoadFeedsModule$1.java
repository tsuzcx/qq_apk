package com.tencent.mobileqq.kandian.biz.pts.nativemodule;

import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.pts.PTSDataUtil;
import com.tencent.mobileqq.kandian.repo.pts.PTSEventDispatcher.PTSObserver;
import com.tencent.pts.core.jni.PTSJsJniHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class PTSLoadFeedsModule$1
  extends PTSEventDispatcher.PTSObserver
{
  PTSLoadFeedsModule$1(PTSLoadFeedsModule paramPTSLoadFeedsModule) {}
  
  public void a(int paramInt, List<Long> paramList, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onFeedsLoaded], channelID = ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("\n");
    List localList = ReadInJoyLogicEngine.a().a(Integer.valueOf(paramInt), paramList);
    if (QLog.isColorLevel())
    {
      paramInt = 0;
      while (paramInt < localList.size())
      {
        localStringBuilder.append("articleInfo [");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]: ");
        localStringBuilder.append(localList.get(paramInt));
        localStringBuilder.append("\n");
        paramInt += 1;
      }
      QLog.i("PTSLoadFeedsModule", 1, localStringBuilder.toString());
    }
    paramList = new Object[1];
    paramList[0] = PTSDataUtil.a(true, localList);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onFeedsLoaded], args[0]");
      localStringBuilder.append(paramList[0]);
      QLog.i("PTSLoadFeedsModule", 1, localStringBuilder.toString());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("js callback ptr = ");
    localStringBuilder.append(paramLong);
    QLog.i("PTSLoadFeedsModule", 1, localStringBuilder.toString());
    PTSJsJniHandler.jsFunctionCallbackAsync(paramLong, paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.nativemodule.PTSLoadFeedsModule.1
 * JD-Core Version:    0.7.0.1
 */