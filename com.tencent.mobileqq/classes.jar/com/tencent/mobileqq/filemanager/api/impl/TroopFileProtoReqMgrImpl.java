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
      if (paramProtoRequest.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cookie<");
        localStringBuilder.append(paramProtoRequest.jdField_b_of_type_Long);
        localStringBuilder.append("> cancelRequest.");
        QLog.i("TroopFileProtoReqMgr", 1, localStringBuilder.toString());
        stopAllRunnables(paramProtoRequest.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse);
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
      ((StringBuilder)localObject1).append(paramProtoRequest.jdField_b_of_type_Long);
      ((StringBuilder)localObject1).append("> sendProtoRequest. ssocmd:");
      ((StringBuilder)localObject1).append(paramProtoRequest.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject1).append(" tryCount:");
      ((StringBuilder)localObject1).append(paramProtoRequest.jdField_b_of_type_Int);
      ((StringBuilder)localObject1).append(" fixtryCount:");
      ((StringBuilder)localObject1).append(paramProtoRequest.c);
      ((StringBuilder)localObject1).append(" fastResend:");
      ((StringBuilder)localObject1).append(paramProtoRequest.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject1).append(" RemindSlowNet:");
      ((StringBuilder)localObject1).append(paramProtoRequest.jdField_b_of_type_Boolean);
      QLog.i("TroopFileProtoReqMgr", 1, ((StringBuilder)localObject1).toString());
      localObject1 = new TroopFileProtoReqMgrImpl.ProtoResponse();
      paramProtoRequest.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse = ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject1);
      ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject1).jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest = paramProtoRequest;
      ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
      ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequestRunnable = new TroopFileProtoReqMgrImpl.ProtoRequestRunnable[paramProtoRequest.jdField_b_of_type_Int];
      int k = 0;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= paramProtoRequest.jdField_b_of_type_Int) {
          break;
        }
        Object localObject2 = new TroopFileProtoReqMgrImpl.ProtoRequestRunnable(this);
        ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequestRunnable[i] = localObject2;
        ((TroopFileProtoReqMgrImpl.ProtoRequestRunnable)localObject2).jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoResponse = ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject1);
        ((TroopFileProtoReqMgrImpl.ProtoRequestRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.mApp.getApp(), TroopFileProtoServlet.class);
        localObject2 = ((TroopFileProtoReqMgrImpl.ProtoRequestRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent;
        if (paramProtoRequest.jdField_a_of_type_AndroidOsBundle != null) {
          ((NewIntent)localObject2).putExtras(paramProtoRequest.jdField_a_of_type_AndroidOsBundle);
        }
        ((NewIntent)localObject2).putExtra("data", paramProtoRequest.jdField_a_of_type_ArrayOfByte);
        ((NewIntent)localObject2).putExtra("cmd", paramProtoRequest.jdField_a_of_type_JavaLangString);
        ((NewIntent)localObject2).putExtra("key_runnable_index", i);
        ((NewIntent)localObject2).putExtra("fastresendenable", paramProtoRequest.jdField_a_of_type_Boolean);
        ((NewIntent)localObject2).putExtra("remind_slown_network", paramProtoRequest.jdField_b_of_type_Boolean);
        i += 1;
      }
      while (j < paramProtoRequest.c)
      {
        long l1 = paramProtoRequest.jdField_a_of_type_Int * j / paramProtoRequest.c;
        long l2 = paramProtoRequest.jdField_a_of_type_Int;
        long l3 = paramProtoRequest.d * j;
        localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequestRunnable[j].jdField_a_of_type_Long = (l2 - l1 - l3);
        scheduleRunnable(localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequestRunnable[j], l1);
        j += 1;
      }
      ((TroopFileProtoReqMgrImpl.ProtoResponse)localObject1).jdField_a_of_type_Int = paramProtoRequest.c;
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
    while (i < paramProtoResponse.jdField_a_of_type_ArrayOfComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequestRunnable.length)
    {
      if ((!paramProtoResponse.jdField_a_of_type_ArrayOfComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequestRunnable[i].jdField_b_of_type_Boolean) && ((paramProtoResponse.jdField_a_of_type_ArrayOfComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequestRunnable[i].jdField_a_of_type_Boolean == true) || (paramProtoResponse.jdField_a_of_type_ArrayOfComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequestRunnable[i].jdField_c_of_type_Boolean == true))) {
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
        if ((localProtoResponse == null) || (localProtoResponse.jdField_a_of_type_Boolean)) {
          break label739;
        }
        j = paramIntent.getIntExtra("key_runnable_index", 0);
        recordRunnableBack(paramIntent, localProtoResponse);
        localObject2 = paramIntent.getExtras();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        localObject2 = localProtoResponse.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest;
        i = ((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).f;
        localProtoResponse.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
        localProtoResponse.jdField_a_of_type_ComTencentMobileqqAppStatictisInfo.jdField_b_of_type_Int = localProtoResponse.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
        k = paramFromServiceMsg.getResultCode();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("cookie<");
        localStringBuilder.append(localProtoResponse.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest.jdField_b_of_type_Long);
        localStringBuilder.append("> onProtoResponse. scheduleIndex:");
        localStringBuilder.append(j);
        localStringBuilder.append(" retCode:");
        localStringBuilder.append(k);
        QLog.i("TroopFileProtoReqMgr", 1, localStringBuilder.toString());
        if (k == 1000)
        {
          stopAllRunnables(localProtoResponse);
          this.requests.remove(paramIntent);
          if (((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver == null) {
            break label726;
          }
          ((Bundle)localObject1).putByteArray("data", WupUtil.b(paramFromServiceMsg.getWupBuffer()));
          paramIntent = ((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver;
          break label728;
        }
        if (k == 2901)
        {
          long l1 = System.currentTimeMillis() - localProtoResponse.jdField_a_of_type_Long;
          if ((l1 < ((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).e) && (localProtoResponse.jdField_a_of_type_Int < ((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).jdField_b_of_type_Int))
          {
            long l2 = ((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).jdField_a_of_type_Int;
            paramIntent = localProtoResponse.jdField_a_of_type_ArrayOfComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequestRunnable[localProtoResponse.jdField_a_of_type_Int];
            localProtoResponse.jdField_a_of_type_Int += 1;
            paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
            scheduleRunnable(paramIntent, 0L);
            break label734;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onReceive found 2901 but do not retry : elapse:");
          localStringBuilder.append(l1);
          localStringBuilder.append(" index:");
          localStringBuilder.append(localProtoResponse.jdField_a_of_type_Int);
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
        if (((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver == null) {
          break label734;
        }
        paramIntent = ((TroopFileProtoReqMgrImpl.ProtoRequest)localObject2).jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver;
      }
      finally {}
      if (paramIntent != null)
      {
        if (k != 0)
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("cookie<");
          paramFromServiceMsg.append(localProtoResponse.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest.jdField_b_of_type_Long);
          paramFromServiceMsg.append("> onProtoResponse suc end. scheduleIndex:");
          paramFromServiceMsg.append(j);
          paramFromServiceMsg.append(" retryCount:");
          paramFromServiceMsg.append(localProtoResponse.jdField_a_of_type_ComTencentMobileqqAppStatictisInfo.c);
          QLog.i("TroopFileProtoReqMgr", 1, paramFromServiceMsg.toString());
          paramIntent.onReceive(i, true, (Bundle)localObject1);
          return;
        }
        ((Bundle)localObject1).putString("data_error_msg", paramFromServiceMsg.getBusinessFailMsg());
        ((Bundle)localObject1).putInt("data_error_code", paramFromServiceMsg.getBusinessFailCode());
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cookie<");
        ((StringBuilder)localObject2).append(localProtoResponse.jdField_a_of_type_ComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequest.jdField_b_of_type_Long);
        ((StringBuilder)localObject2).append("> onProtoResponse fail end. failCode:");
        ((StringBuilder)localObject2).append(paramFromServiceMsg.getBusinessFailCode());
        ((StringBuilder)localObject2).append(" retryCount:");
        ((StringBuilder)localObject2).append(localProtoResponse.jdField_a_of_type_ComTencentMobileqqAppStatictisInfo.c);
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
    paramProtoResponse.jdField_a_of_type_ArrayOfComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequestRunnable[i].jdField_b_of_type_Boolean = true;
    paramProtoResponse.jdField_a_of_type_ArrayOfComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequestRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  void scheduleRunnable(TroopFileProtoReqMgrImpl.ProtoRequestRunnable paramProtoRequestRunnable, long paramLong)
  {
    paramProtoRequestRunnable.jdField_c_of_type_Boolean = true;
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
    paramProtoResponse.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < paramProtoResponse.jdField_a_of_type_ArrayOfComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequestRunnable.length)
    {
      this.requests.remove(paramProtoResponse.jdField_a_of_type_ArrayOfComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequestRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.mHandler.removeCallbacks(paramProtoResponse.jdField_a_of_type_ArrayOfComTencentMobileqqFilemanagerApiImplTroopFileProtoReqMgrImpl$ProtoRequestRunnable[i]);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.TroopFileProtoReqMgrImpl
 * JD-Core Version:    0.7.0.1
 */