package com.tencent.mtt.abtestsdk.manager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mtt.abtestsdk.entity.FeatureEntity;
import com.tencent.mtt.abtestsdk.listener.GetConfigListener;
import com.tencent.mtt.abtestsdk.listener.GetFeatureListener;
import com.tencent.mtt.abtestsdk.listener.OnUpdateExperimentsListener;
import com.tencent.mtt.abtestsdk.utils.ABTestLog;
import org.json.JSONObject;

class ClientManager$1
  extends Handler
{
  ClientManager$1(ClientManager paramClientManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    Object localObject;
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
              localObject = paramMessage.getData();
              i = ((Bundle)localObject).getInt("errCode");
              localObject = ((Bundle)localObject).getString("errMsg");
              paramMessage = (GetConfigListener)paramMessage.obj;
              if (paramMessage != null) {
                paramMessage.getConfigFailed(i, (String)localObject);
              }
            }
            else if ((paramMessage.obj instanceof GetConfigListener))
            {
              paramMessage = (GetConfigListener)paramMessage.obj;
              if (paramMessage != null) {
                paramMessage.getConfigSucceed(null);
              }
            }
          }
          else
          {
            localObject = paramMessage.getData();
            i = ((Bundle)localObject).getInt("errCode");
            localObject = ((Bundle)localObject).getString("errMsg");
            paramMessage = (GetFeatureListener)paramMessage.obj;
            if (paramMessage != null) {
              paramMessage.getFeatureFailed(i, (String)localObject);
            }
          }
        }
        else if ((paramMessage.obj instanceof Object[]))
        {
          localObject = (Object[])paramMessage.obj;
          paramMessage = (FeatureEntity)localObject[0];
          localObject = (GetFeatureListener)localObject[1];
          if (localObject != null) {
            ((GetFeatureListener)localObject).getFeatureSucceed(paramMessage);
          }
        }
        else
        {
          ABTestLog.error("handle pass data err", new Object[0]);
        }
      }
      else
      {
        localObject = paramMessage.getData();
        i = ((Bundle)localObject).getInt("errCode");
        localObject = ((Bundle)localObject).getString("errMsg");
        paramMessage = (OnUpdateExperimentsListener)paramMessage.obj;
        if (paramMessage != null) {
          paramMessage.updateExperimentsFailed(i, (String)localObject);
        }
      }
    }
    else if ((paramMessage.obj instanceof Object[]))
    {
      localObject = (Object[])paramMessage.obj;
      paramMessage = (JSONObject)localObject[0];
      localObject = (OnUpdateExperimentsListener)localObject[1];
      if (localObject != null) {
        ((OnUpdateExperimentsListener)localObject).updateExperimentsSucceed(paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.abtestsdk.manager.ClientManager.1
 * JD-Core Version:    0.7.0.1
 */