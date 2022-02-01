package com.tencent.mobileqq.filemanager.api.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReq;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReqMgr;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoServlet;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class TroopFileProtoReqMgrImpl
  implements ITroopFileProtoReqMgr
{
  static final String KEY_RUNNABLE_INDEX = "key_runnable_index";
  public static final String TAG = "TroopFileProtoReqMgr";
  private AppInterface mApp;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private ConcurrentHashMap<Intent, TroopFileProtoReqMgrImpl.ProtoResponse> requests = new ConcurrentHashMap();
  
  private void interCancelRequest(TroopFileProtoReqMgrImpl.ProtoRequest paramProtoRequest)
  {
    if (paramProtoRequest != null) {}
    try
    {
      if (paramProtoRequest.n != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cookie<");
        localStringBuilder.append(paramProtoRequest.o);
        localStringBuilder.append("> cancelRequest.");
        QLog.i("TroopFileProtoReqMgr", 1, localStringBuilder.toString());
        stopAllRunnables(paramProtoRequest.n);
      }
    }
    finally {}
  }
  
  private void interSendProtoRequest(TroopFileProtoReqMgrImpl.ProtoRequest paramProtoRequest)
  {
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("cookie<");
      ((StringBuilder)localObject1).append(paramProtoRequest.o);
      ((StringBuilder)localObject1).append("> sendProtoRequest. ssocmd:");
      ((StringBuilder)localObject1).append(paramProtoRequest.b);
      ((StringBuilder)localObject1).append(" tryCount:");
      ((StringBuilder)localObject1).append(paramProtoRequest.e);
      ((StringBuilder)localObject1).append(" fixtryCount:");
      ((StringBuilder)localObject1).append(paramProtoRequest.f);
      ((StringBuilder)localObject1).append(" fastResend:");
      ((StringBuilder)localObject1).append(paramProtoRequest.i);
      ((StringBuilder)localObject1).append(" RemindSlowNet:");
      ((StringBuilder)localObject1).append(paramProtoRequest.j);
      QLog.i("TroopFileProtoReqMgr", 1, ((StringBuilder)localObject1).toString());
      localObject1 = new TroopFileProtoReqMgrImpl.ProtoResponse();
      paramProtoRequest.n = ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject1);
      ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject1).b = paramProtoRequest;
      ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject1).c = System.currentTimeMillis();
      ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject1).d = new TroopFileProtoReqMgrImpl.ProtoRequestRunnable[paramProtoRequest.e];
      int k = 0;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= paramProtoRequest.e) {
          break;
        }
        Object localObject2 = new TroopFileProtoReqMgrImpl.ProtoRequestRunnable(this);
        ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject1).d[i] = localObject2;
        ((TroopFileProtoReqMgrImpl.ProtoRequestRunnable)localObject2).a = ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject1);
        ((TroopFileProtoReqMgrImpl.ProtoRequestRunnable)localObject2).b = new NewIntent(this.mApp.getApp(), TroopFileProtoServlet.class);
        localObject2 = ((TroopFileProtoReqMgrImpl.ProtoRequestRunnable)localObject2).b;
        if (paramProtoRequest.m != null) {
          ((NewIntent)localObject2).putExtras(paramProtoRequest.m);
        }
        ((NewIntent)localObject2).putExtra("data", paramProtoRequest.c);
        ((NewIntent)localObject2).putExtra("cmd", paramProtoRequest.b);
        ((NewIntent)localObject2).putExtra("key_runnable_index", i);
        ((NewIntent)localObject2).putExtra("fastresendenable", paramProtoRequest.i);
        ((NewIntent)localObject2).putExtra("remind_slown_network", paramProtoRequest.j);
        i += 1;
      }
      while (j < paramProtoRequest.f)
      {
        long l1 = paramProtoRequest.d * j / paramProtoRequest.f;
        long l2 = paramProtoRequest.d;
        long l3 = paramProtoRequest.g * j;
        localObject1.d[j].c = (l2 - l1 - l3);
        scheduleRunnable(localObject1.d[j], l1);
        j += 1;
      }
      ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject1).e = paramProtoRequest.f;
      return;
    }
    finally {}
    for (;;)
    {
      throw paramProtoRequest;
    }
  }
  
  public void cancelRequest(ITroopFileProtoReq paramITroopFileProtoReq)
  {
    if ((paramITroopFileProtoReq != null) && ((paramITroopFileProtoReq instanceof TroopFileProtoReqMgrImpl.ProtoRequest)))
    {
      interCancelRequest((TroopFileProtoReqMgrImpl.ProtoRequest)paramITroopFileProtoReq);
      return;
    }
    QLog.e("TroopFileProtoReqMgr", 1, "cancelRequest err. req=null");
  }
  
  public ITroopFileProtoReq createProtoReq()
  {
    return new TroopFileProtoReqMgrImpl.ProtoRequest();
  }
  
  boolean isAllTryFinished(TroopFileProtoReqMgrImpl.ProtoResponse paramProtoResponse)
  {
    int i = 0;
    while (i < paramProtoResponse.d.length)
    {
      if ((!paramProtoResponse.d[i].e) && ((paramProtoResponse.d[i].d == true) || (paramProtoResponse.d[i].h == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = ((AppInterface)paramAppRuntime);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopFileProtoReqMgr", 2, "onDestroy ");
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mApp = null;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramIntent != null) && (paramFromServiceMsg != null)) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        localProtoResponse = (TroopFileProtoReqMgrImpl.ProtoResponse)this.requests.get(paramIntent);
        if ((localProtoResponse == null) || (localProtoResponse.g)) {
          break label739;
        }
        j = paramIntent.getIntExtra("key_runnable_index", 0);
        recordRunnableBack(paramIntent, localProtoResponse);
        localObject2 = paramIntent.getExtras();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        localObject2 = localProtoResponse.b;
        i = ((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).k;
        localProtoResponse.a = paramFromServiceMsg;
        localProtoResponse.f.b = localProtoResponse.a.getResultCode();
        k = paramFromServiceMsg.getResultCode();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cookie<");
        localStringBuilder.append(localProtoResponse.b.o);
        localStringBuilder.append("> onProtoResponse. scheduleIndex:");
        localStringBuilder.append(j);
        localStringBuilder.append(" retCode:");
        localStringBuilder.append(k);
        QLog.i("TroopFileProtoReqMgr", 1, localStringBuilder.toString());
        if (k == 1000)
        {
          stopAllRunnables(localProtoResponse);
          this.requests.remove(paramIntent);
          if (((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).l == null) {
            break label726;
          }
          ((Bundle)localObject1).putByteArray("data", WupUtil.b(paramFromServiceMsg.getWupBuffer()));
          paramIntent = ((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).l;
          break label728;
        }
        if (k == 2901)
        {
          long l1 = System.currentTimeMillis() - localProtoResponse.c;
          if ((l1 < ((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).h) && (localProtoResponse.e < ((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).e))
          {
            long l2 = ((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).d;
            paramIntent = localProtoResponse.d[localProtoResponse.e];
            localProtoResponse.e += 1;
            paramIntent.c = (l2 - l1 - 5000L);
            scheduleRunnable(paramIntent, 0L);
            break label734;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onReceive found 2901 but do not retry : elapse:");
          localStringBuilder.append(l1);
          localStringBuilder.append(" index:");
          localStringBuilder.append(localProtoResponse.e);
          QLog.d("TroopFileProtoReqMgr", 2, localStringBuilder.toString());
        }
        if (!isAllTryFinished(localProtoResponse)) {
          break label734;
        }
        stopAllRunnables(localProtoResponse);
        this.requests.remove(paramIntent);
        if (k == 1013)
        {
          paramIntent = new NewIntent(this.mApp.getApplication(), BuiltInServlet.class);
          paramIntent.setObserver(new TroopFileProtoReqMgrImpl.CheckConErroObserverImp(this, localProtoResponse, (TroopFileProtoReqMgrImpl.ProtoRequest)localObject2));
          paramIntent.putExtra("action", 2201);
          this.mApp.startServlet(paramIntent);
          break label734;
        }
        if (((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).l == null) {
          break label734;
        }
        paramIntent = ((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).l;
      }
      finally {}
      if (paramIntent != null)
      {
        if (k != 0)
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("cookie<");
          paramFromServiceMsg.append(localProtoResponse.b.o);
          paramFromServiceMsg.append("> onProtoResponse suc end. scheduleIndex:");
          paramFromServiceMsg.append(j);
          paramFromServiceMsg.append(" retryCount:");
          paramFromServiceMsg.append(localProtoResponse.f.c);
          QLog.i("TroopFileProtoReqMgr", 1, paramFromServiceMsg.toString());
          paramIntent.onReceive(i, true, (Bundle)localObject1);
          return;
        }
        ((Bundle)localObject1).putString("data_error_msg", paramFromServiceMsg.getBusinessFailMsg());
        ((Bundle)localObject1).putInt("data_error_code", paramFromServiceMsg.getBusinessFailCode());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cookie<");
        ((StringBuilder)localObject2).append(localProtoResponse.b.o);
        ((StringBuilder)localObject2).append("> onProtoResponse fail end. failCode:");
        ((StringBuilder)localObject2).append(paramFromServiceMsg.getBusinessFailCode());
        ((StringBuilder)localObject2).append(" retryCount:");
        ((StringBuilder)localObject2).append(localProtoResponse.f.c);
        QLog.e("TroopFileProtoReqMgr", 1, ((StringBuilder)localObject2).toString());
        paramIntent.onResult(-1, null, (Bundle)localObject1);
      }
      return;
      label726:
      paramIntent = null;
      label728:
      int k = 1;
      continue;
      label734:
      paramIntent = null;
      break label755;
      label739:
      break label745;
      TroopFileProtoReqMgrImpl.ProtoResponse localProtoResponse = null;
      label745:
      paramIntent = null;
      int j = -1;
      Object localObject1 = null;
      int i = 1;
      label755:
      k = 0;
    }
  }
  
  void recordRunnableBack(Intent paramIntent, TroopFileProtoReqMgrImpl.ProtoResponse paramProtoResponse)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    paramProtoResponse.d[i].e = true;
    paramProtoResponse.d[i].g = System.currentTimeMillis();
  }
  
  void scheduleRunnable(TroopFileProtoReqMgrImpl.ProtoRequestRunnable paramProtoRequestRunnable, long paramLong)
  {
    paramProtoRequestRunnable.h = true;
    this.mHandler.postDelayed(paramProtoRequestRunnable, paramLong);
  }
  
  public void sendProtoRequest(ITroopFileProtoReq paramITroopFileProtoReq)
  {
    if ((paramITroopFileProtoReq != null) && ((paramITroopFileProtoReq instanceof TroopFileProtoReqMgrImpl.ProtoRequest)))
    {
      interSendProtoRequest((TroopFileProtoReqMgrImpl.ProtoRequest)paramITroopFileProtoReq);
      return;
    }
    QLog.e("TroopFileProtoReqMgr", 1, "sendProtoRequest err. req=null");
  }
  
  void sendToMsf(NewIntent paramNewIntent)
  {
    this.mApp.startServlet(paramNewIntent);
  }
  
  void stopAllRunnables(TroopFileProtoReqMgrImpl.ProtoResponse paramProtoResponse)
  {
    paramProtoResponse.g = true;
    int i = 0;
    while (i < paramProtoResponse.d.length)
    {
      this.requests.remove(paramProtoResponse.d[i].b);
      this.mHandler.removeCallbacks(paramProtoResponse.d[i]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.TroopFileProtoReqMgrImpl
 * JD-Core Version:    0.7.0.1
 */