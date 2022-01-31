package com.tencent.mobileqq.troop.filemanager;

import alwy;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import bbuy;
import bbuz;
import bbva;
import bbvb;
import bbvl;
import bdpd;
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
  private ConcurrentHashMap<Intent, bbva> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TroopFileProtoReqMgr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  void a(Intent paramIntent, bbva parambbva)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    parambbva.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean = true;
    parambbva.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
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
        localbbva = (bbva)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localbbva == null) {
          break label727;
        }
        if (localbbva.jdField_a_of_type_Boolean)
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
            bbvl.c("TroopFileProtoReqMgr", bbvl.jdField_a_of_type_Int, "cookie<" + localbbva.jdField_a_of_type_Bbuz.jdField_b_of_type_Long + "> onProtoResponse suc end. scheduleIndex:" + j + " retryCount:" + localbbva.jdField_a_of_type_Alwy.c);
            ((nac)localObject1).onReceive(i, true, paramIntent);
          }
        }
        else
        {
          j = paramIntent.getIntExtra("key_runnable_index", 0);
          a(paramIntent, localbbva);
          Object localObject2 = paramIntent.getExtras();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          localObject2 = localbbva.jdField_a_of_type_Bbuz;
          i = ((bbuz)localObject2).f;
          localbbva.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
          localbbva.jdField_a_of_type_Alwy.jdField_b_of_type_Int = localbbva.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
          int n = paramFromServiceMsg.getResultCode();
          bbvl.c("TroopFileProtoReqMgr", bbvl.jdField_a_of_type_Int, "cookie<" + localbbva.jdField_a_of_type_Bbuz.jdField_b_of_type_Long + "> onProtoResponse. scheduleIndex:" + j + " retCode:" + n);
          if (n == 1000)
          {
            a(localbbva);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            k = 1;
            if (((bbuz)localObject2).jdField_a_of_type_Nac == null) {
              break label717;
            }
            ((Bundle)localObject1).putByteArray("data", bdpd.b(paramFromServiceMsg.getWupBuffer()));
            localnac = ((bbuz)localObject2).jdField_a_of_type_Nac;
            paramIntent = (Intent)localObject1;
            k = 1;
            localObject1 = localnac;
            continue;
          }
          if (n == 2901)
          {
            long l1 = System.currentTimeMillis() - localbbva.jdField_a_of_type_Long;
            if ((l1 < ((bbuz)localObject2).e) && (localbbva.jdField_a_of_type_Int < ((bbuz)localObject2).jdField_b_of_type_Int))
            {
              long l2 = ((bbuz)localObject2).jdField_a_of_type_Int;
              paramIntent = localbbva.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[localbbva.jdField_a_of_type_Int];
              localbbva.jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              paramIntent = (Intent)localObject1;
              k = 0;
              localObject1 = localnac;
              continue;
            }
            bbvl.d("TroopFileProtoReqMgr", bbvl.jdField_b_of_type_Int, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + localbbva.jdField_a_of_type_Int);
          }
          k = m;
          if (!a(localbbva)) {
            break label717;
          }
          a(localbbva);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (n == 1013)
          {
            paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
            paramIntent.setObserver(new bbuy(this, localbbva, (bbuz)localObject2));
            paramIntent.putExtra("action", 2201);
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
            paramIntent = (Intent)localObject1;
            k = 0;
            localObject1 = localnac;
            continue;
          }
          k = m;
          if (((bbuz)localObject2).jdField_a_of_type_Nac == null) {
            break label717;
          }
          localnac = ((bbuz)localObject2).jdField_a_of_type_Nac;
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
      bbvl.a("TroopFileProtoReqMgr", bbvl.jdField_a_of_type_Int, "cookie<" + localbbva.jdField_a_of_type_Bbuz.jdField_b_of_type_Long + "> onProtoResponse fail end. failCode:" + paramFromServiceMsg.getBusinessFailCode() + " retryCount:" + localbbva.jdField_a_of_type_Alwy.c);
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
      bbva localbbva = null;
      i = 1;
      localObject1 = localnac;
    }
  }
  
  public void a(bbuz parambbuz)
  {
    int k = 0;
    if (parambbuz != null) {}
    for (;;)
    {
      try
      {
        bbvl.c("TroopFileProtoReqMgr", bbvl.jdField_a_of_type_Int, "cookie<" + parambbuz.jdField_b_of_type_Long + "> sendProtoRequest. ssocmd:" + parambbuz.jdField_a_of_type_JavaLangString + " tryCount:" + parambbuz.jdField_b_of_type_Int + " fixtryCount:" + parambbuz.c + " fastResend:" + parambbuz.jdField_a_of_type_Boolean + " RemindSlowNet:" + parambbuz.jdField_b_of_type_Boolean);
        bbva localbbva = new bbva();
        parambbuz.jdField_a_of_type_Bbva = localbbva;
        localbbva.jdField_a_of_type_Bbuz = parambbuz;
        localbbva.jdField_a_of_type_Long = System.currentTimeMillis();
        localbbva.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable = new TroopFileProtoReqMgr.ProtoRequestRunnable[parambbuz.jdField_b_of_type_Int];
        int i = 0;
        int j = k;
        if (i < parambbuz.jdField_b_of_type_Int)
        {
          Object localObject = new TroopFileProtoReqMgr.ProtoRequestRunnable(this);
          localbbva.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i] = localObject;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_Bbva = localbbva;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), bbvb.class);
          localObject = ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent;
          if (parambbuz.jdField_a_of_type_AndroidOsBundle != null) {
            ((NewIntent)localObject).putExtras(parambbuz.jdField_a_of_type_AndroidOsBundle);
          }
          ((NewIntent)localObject).putExtra("data", parambbuz.jdField_a_of_type_ArrayOfByte);
          ((NewIntent)localObject).putExtra("cmd", parambbuz.jdField_a_of_type_JavaLangString);
          ((NewIntent)localObject).putExtra("key_runnable_index", i);
          ((NewIntent)localObject).putExtra("fastresendenable", parambbuz.jdField_a_of_type_Boolean);
          ((NewIntent)localObject).putExtra("remind_slown_network", parambbuz.jdField_b_of_type_Boolean);
          i += 1;
          continue;
        }
        if (j < parambbuz.c)
        {
          long l1 = parambbuz.jdField_a_of_type_Int * j / parambbuz.c;
          long l2 = parambbuz.jdField_a_of_type_Int;
          long l3 = parambbuz.d * j;
          localbbva.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j].jdField_a_of_type_Long = (l2 - l1 - l3);
          a(localbbva.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j], l1);
          j += 1;
          continue;
        }
        localbbva.jdField_a_of_type_Int = parambbuz.c;
        return;
      }
      finally {}
      bbvl.a("TroopFileProtoReqMgr", bbvl.jdField_a_of_type_Int, "sendProtoRequest req=null");
    }
  }
  
  void a(bbva parambbva)
  {
    parambbva.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < parambbva.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambbva.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(parambbva.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i]);
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
  
  boolean a(bbva parambbva)
  {
    int i = 0;
    while (i < parambbva.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      if ((!parambbva.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean) && ((parambbva.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_Boolean == true) || (parambbva.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void b(bbuz parambbuz)
  {
    if (parambbuz != null) {}
    try
    {
      if (parambbuz.jdField_a_of_type_Bbva != null)
      {
        bbvl.c("TroopFileProtoReqMgr", bbvl.jdField_a_of_type_Int, "cookie<" + parambbuz.jdField_b_of_type_Long + "> cancelRequest.");
        a(parambbuz.jdField_a_of_type_Bbva);
      }
      return;
    }
    finally
    {
      parambbuz = finally;
      throw parambbuz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr
 * JD-Core Version:    0.7.0.1
 */