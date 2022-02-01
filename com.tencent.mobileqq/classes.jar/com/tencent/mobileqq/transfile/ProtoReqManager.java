package com.tencent.mobileqq.transfile;

import amqq;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import azby;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class ProtoReqManager
  implements amqq
{
  public static final String KEY_RUNNABLE_INDEX = "key_runnable_index";
  public static final String TAG = "Q.richmedia.ProtoReqManager";
  private AppInterface mApp;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private boolean mHasGetDPC;
  ConcurrentHashMap<Intent, ProtoReqManager.ProtoResp> requests = new ConcurrentHashMap();
  
  public ProtoReqManager(AppInterface paramAppInterface)
  {
    this.mApp = paramAppInterface;
  }
  
  private void getDPC()
  {
    if (DeviceProfileManager.a().a() == 4) {
      RichMediaStrategy.updataFromDpc(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
  }
  
  private boolean isAllTryFinished(ProtoReqManager.ProtoResp paramProtoResp)
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
  
  private boolean isPttCmd(ProtoReqManager.ProtoReq paramProtoReq)
  {
    return ("PttStore.GroupPttUp".equals(paramProtoReq.ssoCmd)) || ("PttStore.GroupPttDown".equals(paramProtoReq.ssoCmd)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500".equals(paramProtoReq.ssoCmd)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200".equals(paramProtoReq.ssoCmd));
  }
  
  private void recordRunnableBack(Intent paramIntent, ProtoReqManager.ProtoResp paramProtoResp)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    paramProtoResp.runs[i].finished = true;
    paramProtoResp.runs[i].finishTime = System.currentTimeMillis();
  }
  
  private void setConfigFromDpc(ProtoReqManager.ProtoReq paramProtoReq)
  {
    paramProtoReq.tryTime = RichMediaStrategy.getTryTime_dpc();
    paramProtoReq.tryCount = RichMediaStrategy.getTryCount_dpc();
    paramProtoReq.fixScheduleCount = RichMediaStrategy.getFixSchedulTryCount_dpc();
  }
  
  private void setPttConfigFromDpc(ProtoReqManager.ProtoReq paramProtoReq)
  {
    if ((this.mApp instanceof QQAppInterface))
    {
      paramProtoReq.tryTime = azby.a((QQAppInterface)this.mApp);
      paramProtoReq.tryCount = azby.b((QQAppInterface)this.mApp);
      paramProtoReq.fixScheduleCount = azby.c((QQAppInterface)this.mApp);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.ProtoReqManager", 2, "ptt config from dpc:" + paramProtoReq.tryTime + paramProtoReq.tryCount + paramProtoReq.fixScheduleCount);
      }
    }
  }
  
  private void stopAllRunnables(ProtoReqManager.ProtoResp paramProtoResp)
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
  
  public void cancelReq(ProtoReqManager.ProtoReq paramProtoReq)
  {
    if (paramProtoReq != null) {}
    try
    {
      if (paramProtoReq.resp != null) {
        stopAllRunnables(paramProtoReq.resp);
      }
      return;
    }
    finally
    {
      paramProtoReq = finally;
      throw paramProtoReq;
    }
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
      RichMediaStrategy.updataFromDpc(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
    DeviceProfileManager.b(this);
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = null;
    for (;;)
    {
      ProtoReqManager.IProtoRespBack localIProtoRespBack;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive." + paramFromServiceMsg);
        }
        if ((paramIntent == null) || (paramFromServiceMsg == null)) {
          break label539;
        }
        localObject = (ProtoReqManager.ProtoResp)this.requests.get(paramIntent);
        if (localObject == null) {
          break label524;
        }
        if (((ProtoReqManager.ProtoResp)localObject).processed)
        {
          localProtoReq = null;
          paramIntent = null;
          paramFromServiceMsg = (FromServiceMsg)localObject;
          localObject = localProtoReq;
          if (localObject != null) {
            ((ProtoReqManager.IProtoRespBack)localObject).onProtoResp(paramFromServiceMsg, paramIntent);
          }
          return;
        }
        recordRunnableBack(paramIntent, (ProtoReqManager.ProtoResp)localObject);
        localProtoReq = ((ProtoReqManager.ProtoResp)localObject).req;
        ((ProtoReqManager.ProtoResp)localObject).resp = paramFromServiceMsg;
        ((ProtoReqManager.ProtoResp)localObject).statisInfo.b = ((ProtoReqManager.ProtoResp)localObject).resp.getResultCode();
        int i = paramFromServiceMsg.getResultCode();
        if (i == 1000)
        {
          stopAllRunnables((ProtoReqManager.ProtoResp)localObject);
          this.requests.remove(paramIntent);
          if (localProtoReq.callback != null)
          {
            i = paramFromServiceMsg.getWupBuffer().length - 4;
            paramIntent = new byte[i];
            PkgTools.copyData(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
            paramFromServiceMsg.putWupBuffer(paramIntent);
            localIProtoRespBack = localProtoReq.callback;
            paramFromServiceMsg = (FromServiceMsg)localObject;
            paramIntent = localProtoReq;
            localObject = localIProtoRespBack;
          }
        }
        else
        {
          if (i == 2901)
          {
            long l1 = System.currentTimeMillis() - ((ProtoReqManager.ProtoResp)localObject).startTime;
            if ((l1 < localProtoReq.noMsfSuggestRetryTime) && (((ProtoReqManager.ProtoResp)localObject).freeRunnalbleIndex < localProtoReq.tryCount))
            {
              long l2 = localProtoReq.tryTime;
              paramIntent = localObject.runs[localObject.freeRunnalbleIndex];
              ((ProtoReqManager.ProtoResp)localObject).freeRunnalbleIndex += 1;
              paramIntent.timeOut = (l2 - l1 - 5000L);
              scheduleRunnable(paramIntent, 0L);
              localIProtoRespBack = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localProtoReq;
              localObject = localIProtoRespBack;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + ((ProtoReqManager.ProtoResp)localObject).freeRunnalbleIndex);
            }
          }
          if (isAllTryFinished((ProtoReqManager.ProtoResp)localObject))
          {
            stopAllRunnables((ProtoReqManager.ProtoResp)localObject);
            this.requests.remove(paramIntent);
            if (i == 1013)
            {
              paramIntent = new NewIntent(this.mApp.getApplication(), BuiltInServlet.class);
              paramIntent.setObserver(new ProtoReqManager.CheckConErroObserverImp(this, (ProtoReqManager.ProtoResp)localObject, localProtoReq));
              paramIntent.putExtra("action", 2201);
              this.mApp.startServlet(paramIntent);
              localIProtoRespBack = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localProtoReq;
              localObject = localIProtoRespBack;
              continue;
            }
            if (localProtoReq.callback != null)
            {
              localIProtoRespBack = localProtoReq.callback;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localProtoReq;
              localObject = localIProtoRespBack;
              continue;
            }
          }
        }
        localIProtoRespBack = null;
      }
      finally {}
      paramFromServiceMsg = (FromServiceMsg)localObject;
      paramIntent = localProtoReq;
      localObject = localIProtoRespBack;
      continue;
      label524:
      ProtoReqManager.ProtoReq localProtoReq = null;
      paramIntent = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localProtoReq;
      continue;
      label539:
      paramIntent = null;
      localProtoReq = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localProtoReq;
    }
  }
  
  void scheduleRunnable(ProtoReqManager.ProtoReqRunnable paramProtoReqRunnable, long paramLong)
  {
    paramProtoReqRunnable.scheduled = true;
    this.mHandler.postDelayed(paramProtoReqRunnable, paramLong);
  }
  
  public void sendProtoReq(ProtoReqManager.ProtoReq paramProtoReq)
  {
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "req:" + paramProtoReq.ssoCmd);
        }
        if (!this.mHasGetDPC)
        {
          getDPC();
          this.mHasGetDPC = true;
        }
        localObject1 = this.mApp;
        if (localObject1 == null) {
          return;
        }
        if (paramProtoReq == null) {
          continue;
        }
        if ((paramProtoReq.ssoCmd != null) && ((paramProtoReq.ssoCmd.equals("ImgStore.GroupPicUp")) || (paramProtoReq.ssoCmd.equals("LongConn.OffPicUp")))) {
          setConfigFromDpc(paramProtoReq);
        }
        if ((paramProtoReq.ssoCmd != null) && ((paramProtoReq.ssoCmd.equals("PttStore.GroupPttUp")) || (paramProtoReq.ssoCmd.equals("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500")))) {
          setPttConfigFromDpc(paramProtoReq);
        }
        localObject1 = new ProtoReqManager.ProtoResp();
        paramProtoReq.resp = ((ProtoReqManager.ProtoResp)localObject1);
        ((ProtoReqManager.ProtoResp)localObject1).req = paramProtoReq;
        ((ProtoReqManager.ProtoResp)localObject1).startTime = System.currentTimeMillis();
        ((ProtoReqManager.ProtoResp)localObject1).runs = new ProtoReqManager.ProtoReqRunnable[paramProtoReq.tryCount];
        byte[] arrayOfByte = paramProtoReq.reqBody;
        Object localObject2 = ByteBuffer.allocate(arrayOfByte.length + 4);
        ((ByteBuffer)localObject2).putInt(arrayOfByte.length + 4).put(arrayOfByte);
        arrayOfByte = ((ByteBuffer)localObject2).array();
        i = 0;
        if (i >= paramProtoReq.tryCount) {
          break label516;
        }
        localObject2 = new ProtoReqManager.ProtoReqRunnable(this);
        ((ProtoReqManager.ProtoResp)localObject1).runs[i] = localObject2;
        ((ProtoReqManager.ProtoReqRunnable)localObject2).resp = ((ProtoReqManager.ProtoResp)localObject1);
        ((ProtoReqManager.ProtoReqRunnable)localObject2).intent = new NewIntent(this.mApp.getApp(), ProtoServlet.class);
        localObject2 = ((ProtoReqManager.ProtoReqRunnable)localObject2).intent;
        ((NewIntent)localObject2).putExtra("key_body", arrayOfByte);
        ((NewIntent)localObject2).putExtra("key_cmd", paramProtoReq.ssoCmd);
        ((NewIntent)localObject2).putExtra("key_runnable_index", i);
        ((NewIntent)localObject2).putExtra("key_fastresend", paramProtoReq.isFastResendEnable);
        ((NewIntent)localObject2).putExtra("remind_slown_network", paramProtoReq.isNeedRemindSlowNetwork);
        if ((!isPttCmd(paramProtoReq)) || (!(this.mApp instanceof QQAppInterface)) || (!azby.d((QQAppInterface)this.mApp))) {
          break label509;
        }
        ((NewIntent)localObject2).putExtra("quickSendEnable", true);
        ((NewIntent)localObject2).putExtra("quickSendStrategy", 1);
        if (!QLog.isColorLevel()) {
          break label509;
        }
        QLog.d("http_sideway", 2, "set");
      }
      finally {}
      if (i < paramProtoReq.fixScheduleCount)
      {
        long l1 = paramProtoReq.tryTime * i / paramProtoReq.fixScheduleCount;
        long l2 = paramProtoReq.tryTime;
        long l3 = paramProtoReq.timeSpace * i;
        localObject1.runs[i].timeOut = (l2 - l1 - l3);
        scheduleRunnable(localObject1.runs[i], l1);
        i += 1;
      }
      else
      {
        ((ProtoReqManager.ProtoResp)localObject1).freeRunnalbleIndex = paramProtoReq.fixScheduleCount;
        continue;
        label509:
        i += 1;
        continue;
        label516:
        i = 0;
      }
    }
  }
  
  void sendToMsf(NewIntent paramNewIntent)
  {
    if (this.mApp != null) {
      this.mApp.startServlet(paramNewIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoReqManager
 * JD-Core Version:    0.7.0.1
 */