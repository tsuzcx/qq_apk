package com.tencent.mobileqq.troop.filemanager;

import ajlb;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class TroopFileProtoReqMgr
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TroopFileProtoReqMgr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  void a(ajlb paramajlb, long paramLong)
  {
    paramajlb.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramajlb, paramLong);
  }
  
  void a(Intent paramIntent, TroopFileProtoReqMgr.ProtoResponse paramProtoResponse)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    paramProtoResponse.jdField_a_of_type_ArrayOfAjlb[i].jdField_b_of_type_Boolean = true;
    paramProtoResponse.jdField_a_of_type_ArrayOfAjlb[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    ProtoUtils.TroopProtocolObserver localTroopProtocolObserver = null;
    int m = 0;
    if ((paramIntent != null) && (paramFromServiceMsg != null)) {}
    for (;;)
    {
      try
      {
        localProtoResponse = (TroopFileProtoReqMgr.ProtoResponse)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localProtoResponse == null) {
          break label728;
        }
        if (localProtoResponse.jdField_a_of_type_Boolean)
        {
          j = -1;
          paramIntent = null;
          k = 0;
          i = 1;
          localObject1 = localTroopProtocolObserver;
          if (localObject1 != null)
          {
            if (k == 0) {
              break label626;
            }
            TroopFileTransferUtil.Log.c("TroopFileProtoReqMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "cookie<" + localProtoResponse.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest.jdField_b_of_type_Long + "> onProtoResponse suc end. scheduleIndex:" + j + " retryCount:" + localProtoResponse.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo.c);
            ((ProtoUtils.TroopProtocolObserver)localObject1).onReceive(i, true, paramIntent);
          }
        }
        else
        {
          j = paramIntent.getIntExtra("key_runnable_index", 0);
          a(paramIntent, localProtoResponse);
          Object localObject2 = paramIntent.getExtras();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          localObject2 = localProtoResponse.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest;
          i = ((TroopFileProtoReqMgr.ProtoRequest)localObject2).f;
          localProtoResponse.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
          localProtoResponse.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo.jdField_b_of_type_Int = localProtoResponse.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
          int n = paramFromServiceMsg.getResultCode();
          TroopFileTransferUtil.Log.c("TroopFileProtoReqMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "cookie<" + localProtoResponse.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest.jdField_b_of_type_Long + "> onProtoResponse. scheduleIndex:" + j + " retCode:" + n);
          if (n == 1000)
          {
            a(localProtoResponse);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            k = 1;
            if (((TroopFileProtoReqMgr.ProtoRequest)localObject2).jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver == null) {
              break label718;
            }
            ((Bundle)localObject1).putByteArray("data", WupUtil.b(paramFromServiceMsg.getWupBuffer()));
            localTroopProtocolObserver = ((TroopFileProtoReqMgr.ProtoRequest)localObject2).jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver;
            paramIntent = (Intent)localObject1;
            k = 1;
            localObject1 = localTroopProtocolObserver;
            continue;
          }
          if (n == 2901)
          {
            long l1 = System.currentTimeMillis() - localProtoResponse.jdField_a_of_type_Long;
            if ((l1 < ((TroopFileProtoReqMgr.ProtoRequest)localObject2).e) && (localProtoResponse.jdField_a_of_type_Int < ((TroopFileProtoReqMgr.ProtoRequest)localObject2).jdField_b_of_type_Int))
            {
              long l2 = ((TroopFileProtoReqMgr.ProtoRequest)localObject2).jdField_a_of_type_Int;
              paramIntent = localProtoResponse.jdField_a_of_type_ArrayOfAjlb[localProtoResponse.jdField_a_of_type_Int];
              localProtoResponse.jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              paramIntent = (Intent)localObject1;
              k = 0;
              localObject1 = localTroopProtocolObserver;
              continue;
            }
            TroopFileTransferUtil.Log.d("TroopFileProtoReqMgr", TroopFileTransferUtil.Log.jdField_b_of_type_Int, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + localProtoResponse.jdField_a_of_type_Int);
          }
          k = m;
          if (!a(localProtoResponse)) {
            break label718;
          }
          a(localProtoResponse);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (n == 1013)
          {
            paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
            paramIntent.setObserver(new TroopFileProtoReqMgr.CheckConErroObserverImp(this, localProtoResponse, (TroopFileProtoReqMgr.ProtoRequest)localObject2));
            paramIntent.putExtra("action", 2201);
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
            paramIntent = (Intent)localObject1;
            k = 0;
            localObject1 = localTroopProtocolObserver;
            continue;
          }
          k = m;
          if (((TroopFileProtoReqMgr.ProtoRequest)localObject2).jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver == null) {
            break label718;
          }
          localTroopProtocolObserver = ((TroopFileProtoReqMgr.ProtoRequest)localObject2).jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver;
          paramIntent = (Intent)localObject1;
          k = 0;
          localObject1 = localTroopProtocolObserver;
          continue;
        }
        paramIntent.putString("data_error_msg", paramFromServiceMsg.getBusinessFailMsg());
      }
      finally {}
      label626:
      paramIntent.putInt("data_error_code", paramFromServiceMsg.getBusinessFailCode());
      TroopFileTransferUtil.Log.a("TroopFileProtoReqMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "cookie<" + localProtoResponse.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest.jdField_b_of_type_Long + "> onProtoResponse fail end. failCode:" + paramFromServiceMsg.getBusinessFailCode() + " retryCount:" + localProtoResponse.jdField_a_of_type_ComTencentMobileqqAppMessageObserver$StatictisInfo.c);
      ((ProtoUtils.TroopProtocolObserver)localObject1).a(-1, null, paramIntent);
      return;
      label718:
      paramIntent = (Intent)localObject1;
      Object localObject1 = localTroopProtocolObserver;
      continue;
      label728:
      int j = -1;
      paramIntent = null;
      int k = 0;
      int i = 1;
      localObject1 = localTroopProtocolObserver;
      continue;
      j = -1;
      paramIntent = null;
      k = 0;
      TroopFileProtoReqMgr.ProtoResponse localProtoResponse = null;
      i = 1;
      localObject1 = localTroopProtocolObserver;
    }
  }
  
  public void a(TroopFileProtoReqMgr.ProtoRequest paramProtoRequest)
  {
    int k = 0;
    if (paramProtoRequest != null) {}
    for (;;)
    {
      try
      {
        TroopFileTransferUtil.Log.c("TroopFileProtoReqMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "cookie<" + paramProtoRequest.jdField_b_of_type_Long + "> sendProtoRequest. ssocmd:" + paramProtoRequest.jdField_a_of_type_JavaLangString + " tryCount:" + paramProtoRequest.jdField_b_of_type_Int + " fixtryCount:" + paramProtoRequest.c + " fastResend:" + paramProtoRequest.jdField_a_of_type_Boolean + " RemindSlowNet:" + paramProtoRequest.jdField_b_of_type_Boolean);
        TroopFileProtoReqMgr.ProtoResponse localProtoResponse = new TroopFileProtoReqMgr.ProtoResponse();
        paramProtoRequest.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse = localProtoResponse;
        localProtoResponse.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = paramProtoRequest;
        localProtoResponse.jdField_a_of_type_Long = System.currentTimeMillis();
        localProtoResponse.jdField_a_of_type_ArrayOfAjlb = new ajlb[paramProtoRequest.jdField_b_of_type_Int];
        int i = 0;
        int j = k;
        if (i < paramProtoRequest.jdField_b_of_type_Int)
        {
          Object localObject = new ajlb(this);
          localProtoResponse.jdField_a_of_type_ArrayOfAjlb[i] = localObject;
          ((ajlb)localObject).jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse = localProtoResponse;
          ((ajlb)localObject).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), TroopFileProtoServlet.class);
          localObject = ((ajlb)localObject).jdField_a_of_type_MqqAppNewIntent;
          if (paramProtoRequest.jdField_a_of_type_AndroidOsBundle != null) {
            ((NewIntent)localObject).putExtras(paramProtoRequest.jdField_a_of_type_AndroidOsBundle);
          }
          ((NewIntent)localObject).putExtra("data", paramProtoRequest.jdField_a_of_type_ArrayOfByte);
          ((NewIntent)localObject).putExtra("cmd", paramProtoRequest.jdField_a_of_type_JavaLangString);
          ((NewIntent)localObject).putExtra("key_runnable_index", i);
          ((NewIntent)localObject).putExtra("fastresendenable", paramProtoRequest.jdField_a_of_type_Boolean);
          ((NewIntent)localObject).putExtra("remind_slown_network", paramProtoRequest.jdField_b_of_type_Boolean);
          i += 1;
          continue;
        }
        if (j < paramProtoRequest.c)
        {
          long l1 = paramProtoRequest.jdField_a_of_type_Int * j / paramProtoRequest.c;
          long l2 = paramProtoRequest.jdField_a_of_type_Int;
          long l3 = paramProtoRequest.d * j;
          localProtoResponse.jdField_a_of_type_ArrayOfAjlb[j].jdField_a_of_type_Long = (l2 - l1 - l3);
          a(localProtoResponse.jdField_a_of_type_ArrayOfAjlb[j], l1);
          j += 1;
          continue;
        }
        localProtoResponse.jdField_a_of_type_Int = paramProtoRequest.c;
        return;
      }
      finally {}
      TroopFileTransferUtil.Log.a("TroopFileProtoReqMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "sendProtoRequest req=null");
    }
  }
  
  void a(TroopFileProtoReqMgr.ProtoResponse paramProtoResponse)
  {
    paramProtoResponse.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < paramProtoResponse.jdField_a_of_type_ArrayOfAjlb.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramProtoResponse.jdField_a_of_type_ArrayOfAjlb[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramProtoResponse.jdField_a_of_type_ArrayOfAjlb[i]);
      i += 1;
    }
  }
  
  public void a(NewIntent paramNewIntent)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramNewIntent);
  }
  
  boolean a(TroopFileProtoReqMgr.ProtoResponse paramProtoResponse)
  {
    int i = 0;
    while (i < paramProtoResponse.jdField_a_of_type_ArrayOfAjlb.length)
    {
      if ((!paramProtoResponse.jdField_a_of_type_ArrayOfAjlb[i].jdField_b_of_type_Boolean) && ((paramProtoResponse.jdField_a_of_type_ArrayOfAjlb[i].jdField_a_of_type_Boolean == true) || (paramProtoResponse.jdField_a_of_type_ArrayOfAjlb[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void b(TroopFileProtoReqMgr.ProtoRequest paramProtoRequest)
  {
    if (paramProtoRequest != null) {}
    try
    {
      if (paramProtoRequest.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse != null)
      {
        TroopFileTransferUtil.Log.c("TroopFileProtoReqMgr", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "cookie<" + paramProtoRequest.jdField_b_of_type_Long + "> cancelRequest.");
        a(paramProtoRequest.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoResponse);
      }
      return;
    }
    finally
    {
      paramProtoRequest = finally;
      throw paramProtoRequest;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr
 * JD-Core Version:    0.7.0.1
 */