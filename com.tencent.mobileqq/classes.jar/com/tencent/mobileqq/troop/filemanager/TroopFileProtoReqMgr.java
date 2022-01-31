package com.tencent.mobileqq.troop.filemanager;

import alsj;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import bbqp;
import bbqq;
import bbqr;
import bbqs;
import bbrc;
import bdku;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import nac;

public class TroopFileProtoReqMgr
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ConcurrentHashMap<Intent, bbqr> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TroopFileProtoReqMgr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  void a(Intent paramIntent, bbqr parambbqr)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    parambbqr.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean = true;
    parambbqr.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    nac localnac = null;
    int m = 0;
    if ((paramIntent != null) && (paramFromServiceMsg != null)) {}
    for (;;)
    {
      try
      {
        localbbqr = (bbqr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localbbqr == null) {
          break label727;
        }
        if (localbbqr.jdField_a_of_type_Boolean)
        {
          j = -1;
          paramIntent = null;
          k = 0;
          i = 1;
          localObject1 = localnac;
          if (localObject1 != null)
          {
            if (k == 0) {
              break label626;
            }
            bbrc.c("TroopFileProtoReqMgr", bbrc.jdField_a_of_type_Int, "cookie<" + localbbqr.jdField_a_of_type_Bbqq.jdField_b_of_type_Long + "> onProtoResponse suc end. scheduleIndex:" + j + " retryCount:" + localbbqr.jdField_a_of_type_Alsj.c);
            ((nac)localObject1).onReceive(i, true, paramIntent);
          }
        }
        else
        {
          j = paramIntent.getIntExtra("key_runnable_index", 0);
          a(paramIntent, localbbqr);
          Object localObject2 = paramIntent.getExtras();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          localObject2 = localbbqr.jdField_a_of_type_Bbqq;
          i = ((bbqq)localObject2).f;
          localbbqr.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
          localbbqr.jdField_a_of_type_Alsj.jdField_b_of_type_Int = localbbqr.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
          int n = paramFromServiceMsg.getResultCode();
          bbrc.c("TroopFileProtoReqMgr", bbrc.jdField_a_of_type_Int, "cookie<" + localbbqr.jdField_a_of_type_Bbqq.jdField_b_of_type_Long + "> onProtoResponse. scheduleIndex:" + j + " retCode:" + n);
          if (n == 1000)
          {
            a(localbbqr);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            k = 1;
            if (((bbqq)localObject2).jdField_a_of_type_Nac == null) {
              break label717;
            }
            ((Bundle)localObject1).putByteArray("data", bdku.b(paramFromServiceMsg.getWupBuffer()));
            localnac = ((bbqq)localObject2).jdField_a_of_type_Nac;
            paramIntent = (Intent)localObject1;
            k = 1;
            localObject1 = localnac;
            continue;
          }
          if (n == 2901)
          {
            long l1 = System.currentTimeMillis() - localbbqr.jdField_a_of_type_Long;
            if ((l1 < ((bbqq)localObject2).e) && (localbbqr.jdField_a_of_type_Int < ((bbqq)localObject2).jdField_b_of_type_Int))
            {
              long l2 = ((bbqq)localObject2).jdField_a_of_type_Int;
              paramIntent = localbbqr.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[localbbqr.jdField_a_of_type_Int];
              localbbqr.jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              paramIntent = (Intent)localObject1;
              k = 0;
              localObject1 = localnac;
              continue;
            }
            bbrc.d("TroopFileProtoReqMgr", bbrc.jdField_b_of_type_Int, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + localbbqr.jdField_a_of_type_Int);
          }
          k = m;
          if (!a(localbbqr)) {
            break label717;
          }
          a(localbbqr);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (n == 1013)
          {
            paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
            paramIntent.setObserver(new bbqp(this, localbbqr, (bbqq)localObject2));
            paramIntent.putExtra("action", 2201);
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
            paramIntent = (Intent)localObject1;
            k = 0;
            localObject1 = localnac;
            continue;
          }
          k = m;
          if (((bbqq)localObject2).jdField_a_of_type_Nac == null) {
            break label717;
          }
          localnac = ((bbqq)localObject2).jdField_a_of_type_Nac;
          paramIntent = (Intent)localObject1;
          k = 0;
          localObject1 = localnac;
          continue;
        }
        paramIntent.putString("data_error_msg", paramFromServiceMsg.getBusinessFailMsg());
      }
      finally {}
      label626:
      paramIntent.putInt("data_error_code", paramFromServiceMsg.getBusinessFailCode());
      bbrc.a("TroopFileProtoReqMgr", bbrc.jdField_a_of_type_Int, "cookie<" + localbbqr.jdField_a_of_type_Bbqq.jdField_b_of_type_Long + "> onProtoResponse fail end. failCode:" + paramFromServiceMsg.getBusinessFailCode() + " retryCount:" + localbbqr.jdField_a_of_type_Alsj.c);
      ((nac)localObject1).a(-1, null, paramIntent);
      return;
      label717:
      paramIntent = (Intent)localObject1;
      Object localObject1 = localnac;
      continue;
      label727:
      int j = -1;
      paramIntent = null;
      int k = 0;
      int i = 1;
      localObject1 = localnac;
      continue;
      j = -1;
      paramIntent = null;
      k = 0;
      bbqr localbbqr = null;
      i = 1;
      localObject1 = localnac;
    }
  }
  
  public void a(bbqq parambbqq)
  {
    int k = 0;
    if (parambbqq != null) {}
    for (;;)
    {
      try
      {
        bbrc.c("TroopFileProtoReqMgr", bbrc.jdField_a_of_type_Int, "cookie<" + parambbqq.jdField_b_of_type_Long + "> sendProtoRequest. ssocmd:" + parambbqq.jdField_a_of_type_JavaLangString + " tryCount:" + parambbqq.jdField_b_of_type_Int + " fixtryCount:" + parambbqq.c + " fastResend:" + parambbqq.jdField_a_of_type_Boolean + " RemindSlowNet:" + parambbqq.jdField_b_of_type_Boolean);
        bbqr localbbqr = new bbqr();
        parambbqq.jdField_a_of_type_Bbqr = localbbqr;
        localbbqr.jdField_a_of_type_Bbqq = parambbqq;
        localbbqr.jdField_a_of_type_Long = System.currentTimeMillis();
        localbbqr.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable = new TroopFileProtoReqMgr.ProtoRequestRunnable[parambbqq.jdField_b_of_type_Int];
        int i = 0;
        int j = k;
        if (i < parambbqq.jdField_b_of_type_Int)
        {
          Object localObject = new TroopFileProtoReqMgr.ProtoRequestRunnable(this);
          localbbqr.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i] = localObject;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_Bbqr = localbbqr;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), bbqs.class);
          localObject = ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent;
          if (parambbqq.jdField_a_of_type_AndroidOsBundle != null) {
            ((NewIntent)localObject).putExtras(parambbqq.jdField_a_of_type_AndroidOsBundle);
          }
          ((NewIntent)localObject).putExtra("data", parambbqq.jdField_a_of_type_ArrayOfByte);
          ((NewIntent)localObject).putExtra("cmd", parambbqq.jdField_a_of_type_JavaLangString);
          ((NewIntent)localObject).putExtra("key_runnable_index", i);
          ((NewIntent)localObject).putExtra("fastresendenable", parambbqq.jdField_a_of_type_Boolean);
          ((NewIntent)localObject).putExtra("remind_slown_network", parambbqq.jdField_b_of_type_Boolean);
          i += 1;
          continue;
        }
        if (j < parambbqq.c)
        {
          long l1 = parambbqq.jdField_a_of_type_Int * j / parambbqq.c;
          long l2 = parambbqq.jdField_a_of_type_Int;
          long l3 = parambbqq.d * j;
          localbbqr.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j].jdField_a_of_type_Long = (l2 - l1 - l3);
          a(localbbqr.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j], l1);
          j += 1;
          continue;
        }
        localbbqr.jdField_a_of_type_Int = parambbqq.c;
        return;
      }
      finally {}
      bbrc.a("TroopFileProtoReqMgr", bbrc.jdField_a_of_type_Int, "sendProtoRequest req=null");
    }
  }
  
  void a(bbqr parambbqr)
  {
    parambbqr.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < parambbqr.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambbqr.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(parambbqr.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i]);
      i += 1;
    }
  }
  
  void a(TroopFileProtoReqMgr.ProtoRequestRunnable paramProtoRequestRunnable, long paramLong)
  {
    paramProtoRequestRunnable.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramProtoRequestRunnable, paramLong);
  }
  
  void a(NewIntent paramNewIntent)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramNewIntent);
  }
  
  boolean a(bbqr parambbqr)
  {
    int i = 0;
    while (i < parambbqr.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      if ((!parambbqr.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean) && ((parambbqr.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_Boolean == true) || (parambbqr.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void b(bbqq parambbqq)
  {
    if (parambbqq != null) {}
    try
    {
      if (parambbqq.jdField_a_of_type_Bbqr != null)
      {
        bbrc.c("TroopFileProtoReqMgr", bbrc.jdField_a_of_type_Int, "cookie<" + parambbqq.jdField_b_of_type_Long + "> cancelRequest.");
        a(parambbqq.jdField_a_of_type_Bbqr);
      }
      return;
    }
    finally
    {
      parambbqq = finally;
      throw parambbqq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr
 * JD-Core Version:    0.7.0.1
 */