package com.tencent.mtt.abtestsdk.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mtt.abtestsdk.abtest.ExperimentClient;
import com.tencent.mtt.abtestsdk.abtest.FeatureClient;
import com.tencent.mtt.abtestsdk.abtest.RemoteConfigClient;
import com.tencent.mtt.abtestsdk.entity.ExpStrategyEntity;
import com.tencent.mtt.abtestsdk.entity.FeatureStrategyEntity;
import com.tencent.mtt.abtestsdk.manager.CacheManager;

final class HandlerThreadUtil$1
  extends Handler
{
  HandlerThreadUtil$1(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage == null)
    {
      ABTestLog.warn("msg is null", new Object[0]);
      return;
    }
    int i = paramMessage.what;
    Object localObject;
    Message localMessage;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return;
              }
              ABTestLog.configUpload("stop update config data", new Object[0]);
              HandlerThreadUtil.access$000().removeMessages(4);
              return;
            }
            paramMessage = (RemoteConfigClient)paramMessage.obj;
            paramMessage.handleIntervalFetchConfigByNet(null, 0);
            HandlerThreadUtil.access$000().removeMessages(4);
            paramMessage = HandlerThreadUtil.access$000().obtainMessage(4, paramMessage);
            HandlerThreadUtil.access$000().sendMessageDelayed(paramMessage, 1800000L);
            ABTestLog.configUpload(String.format("update remote config data for %ss", new Object[] { Integer.valueOf(1800) }), new Object[0]);
            return;
          }
          ABTestLog.featureUpload("stop update feature data", new Object[0]);
          HandlerThreadUtil.access$000().removeMessages(2);
          return;
        }
        localObject = (Object[])paramMessage.obj;
        if (((localObject[0] instanceof FeatureClient)) && ((localObject[1] instanceof CacheManager)))
        {
          paramMessage = (FeatureClient)localObject[0];
          localObject = (CacheManager)localObject[1];
          paramMessage.handleIntervalFetchFeatureByNet(null, 0);
          HandlerThreadUtil.access$000().removeMessages(2);
          localMessage = HandlerThreadUtil.access$000().obtainMessage(2, new Object[] { paramMessage, localObject });
          localObject = ((CacheManager)localObject).getFeatureReportStrategy();
          paramMessage = (Message)localObject;
          if (localObject == null) {
            paramMessage = new FeatureStrategyEntity();
          }
          i = paramMessage.getReportFetchTimeInSecs();
          HandlerThreadUtil.access$000().sendMessageDelayed(localMessage, i * 1000);
          ABTestLog.featureUpload(String.format("update feature data for %ss", new Object[] { Integer.valueOf(i) }), new Object[0]);
        }
      }
      else
      {
        ABTestLog.expUpload("stop update data", new Object[0]);
        HandlerThreadUtil.access$000().removeMessages(0);
      }
    }
    else
    {
      localObject = (Object[])paramMessage.obj;
      if (((localObject[0] instanceof ExperimentClient)) && ((localObject[1] instanceof CacheManager)))
      {
        paramMessage = (ExperimentClient)localObject[0];
        localObject = (CacheManager)localObject[1];
        paramMessage.handleIntervalFetchExpByNet(null, 0);
        HandlerThreadUtil.access$000().removeMessages(0);
        localMessage = HandlerThreadUtil.access$000().obtainMessage(0, new Object[] { paramMessage, localObject });
        localObject = ((CacheManager)localObject).getExpReportStrategy();
        paramMessage = (Message)localObject;
        if (localObject == null) {
          paramMessage = new ExpStrategyEntity();
        }
        i = paramMessage.getRefreshDuration();
        HandlerThreadUtil.access$000().sendMessageDelayed(localMessage, i * 1000);
        ABTestLog.expUpload(String.format("update exp data for %ss", new Object[] { Integer.valueOf(i) }), new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.utils.HandlerThreadUtil.1
 * JD-Core Version:    0.7.0.1
 */