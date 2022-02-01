package com.tencent.mobileqq.transfile.api.impl;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.transfile.ProtoServlet;
import com.tencent.mobileqq.transfile.RichMediaStrategy;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.proto.IProtoReqStrategy;
import com.tencent.mobileqq.transfile.ptt.PttProtoReqStrategy;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class ProtoReqManagerImpl
  implements DPCObserver, IProtoReqManager
{
  public static final String KEY_RUNNABLE_INDEX = "key_runnable_index";
  public static final String TAG = "Q.richmedia.ProtoReqManager";
  @ConfigInject(configPath="Foundation/Transfile/src/main/resources/Inject_InitProtoReqStrategyConfig.yml", version=1)
  public static HashMap<String, Class<? extends IProtoReqStrategy>> protoReqStrategy = new HashMap();
  private AppInterface mApp;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private boolean mHasGetDPC = false;
  ConcurrentHashMap<Intent, ProtoReqManagerImpl.ProtoResp> requests = new ConcurrentHashMap();
  
  static
  {
    protoReqStrategy.put("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200", PttProtoReqStrategy.class);
    protoReqStrategy.put("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500", PttProtoReqStrategy.class);
    protoReqStrategy.put("PttStore.GroupPttDown", PttProtoReqStrategy.class);
    protoReqStrategy.put("PttStore.GroupPttUp", PttProtoReqStrategy.class);
  }
  
  private void getDPC()
  {
    if (((IDPCApi)QRoute.api(IDPCApi.class)).getServerDataCurrentState() == 4) {
      RichMediaStrategy.updataFromDpc(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.RichProReqCfg.name()));
    }
  }
  
  private boolean isAllTryFinished(ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    int i = 0;
    while (i < paramProtoResp.runs.length)
    {
      if ((!paramProtoResp.runs[i].finished) && ((paramProtoResp.runs[i].activated == true) || (paramProtoResp.runs[i].scheduled == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void recordRunnableBack(Intent paramIntent, ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    paramProtoResp.runs[i].finished = true;
    paramProtoResp.runs[i].finishTime = System.currentTimeMillis();
  }
  
  private void setConfigFromDpc(ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    paramProtoReq.tryTime = RichMediaStrategy.getTryTime_dpc();
    paramProtoReq.tryCount = RichMediaStrategy.getTryCount_dpc();
    paramProtoReq.fixScheduleCount = RichMediaStrategy.getFixSchedulTryCount_dpc();
  }
  
  private void stopAllRunnables(ProtoReqManagerImpl.ProtoResp paramProtoResp)
  {
    paramProtoResp.processed = true;
    int i = 0;
    while (i < paramProtoResp.runs.length)
    {
      this.requests.remove(paramProtoResp.runs[i].intent);
      this.mHandler.removeCallbacks(paramProtoResp.runs[i]);
      i += 1;
    }
  }
  
  public void cancelReq(ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    if (paramProtoReq != null) {}
    try
    {
      if (paramProtoReq.resp != null) {
        stopAllRunnables(paramProtoReq.resp);
      }
    }
    finally {}
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.ProtoReqManager", 2, "onDestroy ");
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mApp = null;
  }
  
  public void onDpcPullFinished(boolean paramBoolean)
  {
    if (paramBoolean) {
      RichMediaStrategy.updataFromDpc(((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.RichProReqCfg.name()));
    }
    ((IDPCApi)QRoute.api(IDPCApi.class)).removeObserver(this);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    for (;;)
    {
      Object localObject3;
      ProtoReqManagerImpl.ProtoResp localProtoResp2;
      try
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onReceive.");
          ((StringBuilder)localObject1).append(paramFromServiceMsg);
          QLog.d("Q.richmedia.ProtoReqManager", 2, ((StringBuilder)localObject1).toString());
        }
        localObject3 = null;
        if ((paramIntent == null) || (paramFromServiceMsg == null)) {
          break label565;
        }
        localProtoResp2 = (ProtoReqManagerImpl.ProtoResp)this.requests.get(paramIntent);
        if ((localProtoResp2 != null) && (!localProtoResp2.processed))
        {
          recordRunnableBack(paramIntent, localProtoResp2);
          ProtoReqManagerImpl.ProtoReq localProtoReq = localProtoResp2.req;
          localProtoResp2.resp = paramFromServiceMsg;
          localProtoResp2.statisInfo.b = localProtoResp2.resp.getResultCode();
          int i = paramFromServiceMsg.getResultCode();
          if (i == 1000)
          {
            stopAllRunnables(localProtoResp2);
            this.requests.remove(paramIntent);
            localObject1 = localObject3;
            localProtoResp1 = localProtoResp2;
            localObject2 = localProtoReq;
            if (localProtoReq.callback != null)
            {
              i = paramFromServiceMsg.getWupBuffer().length - 4;
              paramIntent = new byte[i];
              PkgTools.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
              paramFromServiceMsg.putWupBuffer(paramIntent);
              localObject1 = localProtoReq.callback;
              localProtoResp1 = localProtoResp2;
              localObject2 = localProtoReq;
            }
          }
          else
          {
            if (i == 2901)
            {
              long l1 = System.currentTimeMillis() - localProtoResp2.startTime;
              if ((l1 < localProtoReq.noMsfSuggestRetryTime) && (localProtoResp2.freeRunnalbleIndex < localProtoReq.tryCount))
              {
                long l2 = localProtoReq.tryTime;
                paramIntent = localProtoResp2.runs[localProtoResp2.freeRunnalbleIndex];
                localProtoResp2.freeRunnalbleIndex += 1;
                paramIntent.timeOut = (l2 - l1 - 5000L);
                scheduleRunnable(paramIntent, 0L);
                localObject1 = localObject3;
                localProtoResp1 = localProtoResp2;
                localObject2 = localProtoReq;
                continue;
              }
              if (QLog.isColorLevel())
              {
                paramFromServiceMsg = new StringBuilder();
                paramFromServiceMsg.append("onReceive found 2901 but do not retry : elapse:");
                paramFromServiceMsg.append(l1);
                paramFromServiceMsg.append(" index:");
                paramFromServiceMsg.append(localProtoResp2.freeRunnalbleIndex);
                QLog.d("Q.richmedia.ProtoReqManager", 2, paramFromServiceMsg.toString());
              }
            }
            localObject1 = localObject3;
            localProtoResp1 = localProtoResp2;
            localObject2 = localProtoReq;
            if (isAllTryFinished(localProtoResp2))
            {
              stopAllRunnables(localProtoResp2);
              this.requests.remove(paramIntent);
              if (i == 1013)
              {
                paramIntent = new NewIntent(this.mApp.getApplication(), BuiltInServlet.class);
                paramIntent.setObserver(new ProtoReqManagerImpl.CheckConErroObserverImp(this, localProtoResp2, localProtoReq));
                paramIntent.putExtra("action", 2201);
                this.mApp.startServlet(paramIntent);
                localObject1 = localObject3;
                localProtoResp1 = localProtoResp2;
                localObject2 = localProtoReq;
              }
              else
              {
                localObject1 = localObject3;
                localProtoResp1 = localProtoResp2;
                localObject2 = localProtoReq;
                if (localProtoReq.callback != null)
                {
                  localObject1 = localProtoReq.callback;
                  localProtoResp1 = localProtoResp2;
                  localObject2 = localProtoReq;
                }
              }
            }
          }
          if (localObject1 != null) {
            ((ProtoReqManagerImpl.IProtoRespBack)localObject1).onProtoResp(localProtoResp1, (ProtoReqManagerImpl.ProtoReq)localObject2);
          }
          return;
        }
      }
      finally {}
      Object localObject2 = null;
      Object localObject1 = localObject3;
      ProtoReqManagerImpl.ProtoResp localProtoResp1 = localProtoResp2;
      continue;
      label565:
      localProtoResp1 = null;
      localObject2 = localProtoResp1;
      localObject1 = localObject3;
    }
  }
  
  public void scheduleRunnable(ProtoReqManagerImpl.ProtoReqRunnable paramProtoReqRunnable, long paramLong)
  {
    paramProtoReqRunnable.scheduled = true;
    this.mHandler.postDelayed(paramProtoReqRunnable, paramLong);
  }
  
  public void sendProtoReq(ProtoReqManagerImpl.ProtoReq paramProtoReq)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("req:");
        ((StringBuilder)localObject1).append(paramProtoReq.ssoCmd);
        QLog.d("Q.richmedia.ProtoReqManager", 2, ((StringBuilder)localObject1).toString());
      }
      if (!this.mHasGetDPC)
      {
        getDPC();
        this.mHasGetDPC = true;
      }
      Object localObject1 = this.mApp;
      if (localObject1 == null) {
        return;
      }
      if (paramProtoReq == null) {
        break label519;
      }
      if ((paramProtoReq.ssoCmd != null) && ((paramProtoReq.ssoCmd.equals("ImgStore.GroupPicUp")) || (paramProtoReq.ssoCmd.equals("LongConn.OffPicUp")) || (paramProtoReq.ssoCmd.equals("ImgStore.QQMeetPicUp")))) {
        setConfigFromDpc(paramProtoReq);
      }
      localObject1 = paramProtoReq.ssoCmd;
      if (localObject1 == null) {
        break label533;
      }
      localObject1 = (Class)protoReqStrategy.get(localObject1);
      if (localObject1 == null) {
        break label533;
      }
      try
      {
        localObject1 = (IProtoReqStrategy)((Class)localObject1).newInstance();
      }
      catch (InstantiationException localInstantiationException)
      {
        localInstantiationException.printStackTrace();
        break label533;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        localIllegalAccessException.printStackTrace();
        break label533;
      }
    }
    finally
    {
      for (;;)
      {
        ProtoReqManagerImpl.ProtoResp localProtoResp;
        byte[] arrayOfByte;
        Object localObject3;
        int k;
        int i;
        int j;
        for (;;)
        {
          label519:
          throw paramProtoReq;
        }
        label533:
        Object localObject2 = null;
        continue;
        i += 1;
      }
    }
    if (localIllegalAccessException != null) {
      localIllegalAccessException.updateReq(paramProtoReq);
    }
    localProtoResp = new ProtoReqManagerImpl.ProtoResp();
    paramProtoReq.resp = localProtoResp;
    localProtoResp.req = paramProtoReq;
    localProtoResp.startTime = System.currentTimeMillis();
    localProtoResp.runs = new ProtoReqManagerImpl.ProtoReqRunnable[paramProtoReq.tryCount];
    arrayOfByte = paramProtoReq.reqBody;
    localObject3 = ByteBuffer.allocate(arrayOfByte.length + 4);
    ((ByteBuffer)localObject3).putInt(arrayOfByte.length + 4).put(arrayOfByte);
    arrayOfByte = ((ByteBuffer)localObject3).array();
    k = 0;
    i = 0;
    j = k;
    if (i < paramProtoReq.tryCount)
    {
      localObject3 = new ProtoReqManagerImpl.ProtoReqRunnable(this);
      localProtoResp.runs[i] = localObject3;
      ((ProtoReqManagerImpl.ProtoReqRunnable)localObject3).resp = localProtoResp;
      ((ProtoReqManagerImpl.ProtoReqRunnable)localObject3).intent = new NewIntent(this.mApp.getApp(), ProtoServlet.class);
      localObject3 = ((ProtoReqManagerImpl.ProtoReqRunnable)localObject3).intent;
      ((NewIntent)localObject3).putExtra("key_body", arrayOfByte);
      ((NewIntent)localObject3).putExtra("key_cmd", paramProtoReq.ssoCmd);
      ((NewIntent)localObject3).putExtra("key_runnable_index", i);
      ((NewIntent)localObject3).putExtra("key_fastresend", paramProtoReq.isFastResendEnable);
      ((NewIntent)localObject3).putExtra("remind_slown_network", paramProtoReq.isNeedRemindSlowNetwork);
      if (localIllegalAccessException != null) {
        localIllegalAccessException.updateIntent((NewIntent)localObject3);
      }
    }
    else
    {
      while (j < paramProtoReq.fixScheduleCount)
      {
        long l1 = paramProtoReq.tryTime * j / paramProtoReq.fixScheduleCount;
        long l2 = paramProtoReq.tryTime;
        long l3 = paramProtoReq.timeSpace * j;
        localProtoResp.runs[j].timeOut = (l2 - l1 - l3);
        scheduleRunnable(localProtoResp.runs[j], l1);
        j += 1;
      }
      localProtoResp.freeRunnalbleIndex = paramProtoReq.fixScheduleCount;
      return;
    }
  }
  
  void sendToMsf(NewIntent paramNewIntent)
  {
    AppInterface localAppInterface = this.mApp;
    if (localAppInterface != null) {
      localAppInterface.startServlet(paramNewIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl
 * JD-Core Version:    0.7.0.1
 */