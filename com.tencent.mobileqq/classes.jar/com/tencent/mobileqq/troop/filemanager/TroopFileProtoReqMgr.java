package com.tencent.mobileqq.troop.filemanager;

import amwm;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import beeo;
import beep;
import beeq;
import beer;
import befc;
import bgau;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import nmf;

public class TroopFileProtoReqMgr
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ConcurrentHashMap<Intent, beeq> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TroopFileProtoReqMgr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  void a(Intent paramIntent, beeq parambeeq)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    parambeeq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean = true;
    parambeeq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    nmf localnmf = null;
    int m = 0;
    if ((paramIntent != null) && (paramFromServiceMsg != null)) {}
    for (;;)
    {
      try
      {
        localbeeq = (beeq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localbeeq == null) {
          break label727;
        }
        if (localbeeq.jdField_a_of_type_Boolean)
        {
          j = -1;
          paramIntent = null;
          k = 0;
          i = 1;
          localObject1 = localnmf;
          if (localObject1 != null)
          {
            if (k == 0) {
              break label626;
            }
            befc.c("TroopFileProtoReqMgr", befc.jdField_a_of_type_Int, "cookie<" + localbeeq.jdField_a_of_type_Beep.jdField_b_of_type_Long + "> onProtoResponse suc end. scheduleIndex:" + j + " retryCount:" + localbeeq.jdField_a_of_type_Amwm.c);
            ((nmf)localObject1).onReceive(i, true, paramIntent);
          }
        }
        else
        {
          j = paramIntent.getIntExtra("key_runnable_index", 0);
          a(paramIntent, localbeeq);
          Object localObject2 = paramIntent.getExtras();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          localObject2 = localbeeq.jdField_a_of_type_Beep;
          i = ((beep)localObject2).f;
          localbeeq.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
          localbeeq.jdField_a_of_type_Amwm.jdField_b_of_type_Int = localbeeq.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
          int n = paramFromServiceMsg.getResultCode();
          befc.c("TroopFileProtoReqMgr", befc.jdField_a_of_type_Int, "cookie<" + localbeeq.jdField_a_of_type_Beep.jdField_b_of_type_Long + "> onProtoResponse. scheduleIndex:" + j + " retCode:" + n);
          if (n == 1000)
          {
            a(localbeeq);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            k = 1;
            if (((beep)localObject2).jdField_a_of_type_Nmf == null) {
              break label717;
            }
            ((Bundle)localObject1).putByteArray("data", bgau.b(paramFromServiceMsg.getWupBuffer()));
            localnmf = ((beep)localObject2).jdField_a_of_type_Nmf;
            paramIntent = (Intent)localObject1;
            k = 1;
            localObject1 = localnmf;
            continue;
          }
          if (n == 2901)
          {
            long l1 = System.currentTimeMillis() - localbeeq.jdField_a_of_type_Long;
            if ((l1 < ((beep)localObject2).e) && (localbeeq.jdField_a_of_type_Int < ((beep)localObject2).jdField_b_of_type_Int))
            {
              long l2 = ((beep)localObject2).jdField_a_of_type_Int;
              paramIntent = localbeeq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[localbeeq.jdField_a_of_type_Int];
              localbeeq.jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              paramIntent = (Intent)localObject1;
              k = 0;
              localObject1 = localnmf;
              continue;
            }
            befc.d("TroopFileProtoReqMgr", befc.jdField_b_of_type_Int, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + localbeeq.jdField_a_of_type_Int);
          }
          k = m;
          if (!a(localbeeq)) {
            break label717;
          }
          a(localbeeq);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (n == 1013)
          {
            paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
            paramIntent.setObserver(new beeo(this, localbeeq, (beep)localObject2));
            paramIntent.putExtra("action", 2201);
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
            paramIntent = (Intent)localObject1;
            k = 0;
            localObject1 = localnmf;
            continue;
          }
          k = m;
          if (((beep)localObject2).jdField_a_of_type_Nmf == null) {
            break label717;
          }
          localnmf = ((beep)localObject2).jdField_a_of_type_Nmf;
          paramIntent = (Intent)localObject1;
          k = 0;
          localObject1 = localnmf;
          continue;
        }
        paramIntent.putString("data_error_msg", paramFromServiceMsg.getBusinessFailMsg());
      }
      finally {}
      label626:
      paramIntent.putInt("data_error_code", paramFromServiceMsg.getBusinessFailCode());
      befc.a("TroopFileProtoReqMgr", befc.jdField_a_of_type_Int, "cookie<" + localbeeq.jdField_a_of_type_Beep.jdField_b_of_type_Long + "> onProtoResponse fail end. failCode:" + paramFromServiceMsg.getBusinessFailCode() + " retryCount:" + localbeeq.jdField_a_of_type_Amwm.c);
      ((nmf)localObject1).a(-1, null, paramIntent);
      return;
      label717:
      paramIntent = (Intent)localObject1;
      Object localObject1 = localnmf;
      continue;
      label727:
      int j = -1;
      paramIntent = null;
      int k = 0;
      int i = 1;
      localObject1 = localnmf;
      continue;
      j = -1;
      paramIntent = null;
      k = 0;
      beeq localbeeq = null;
      i = 1;
      localObject1 = localnmf;
    }
  }
  
  public void a(beep parambeep)
  {
    int k = 0;
    if (parambeep != null) {}
    for (;;)
    {
      try
      {
        befc.c("TroopFileProtoReqMgr", befc.jdField_a_of_type_Int, "cookie<" + parambeep.jdField_b_of_type_Long + "> sendProtoRequest. ssocmd:" + parambeep.jdField_a_of_type_JavaLangString + " tryCount:" + parambeep.jdField_b_of_type_Int + " fixtryCount:" + parambeep.c + " fastResend:" + parambeep.jdField_a_of_type_Boolean + " RemindSlowNet:" + parambeep.jdField_b_of_type_Boolean);
        beeq localbeeq = new beeq();
        parambeep.jdField_a_of_type_Beeq = localbeeq;
        localbeeq.jdField_a_of_type_Beep = parambeep;
        localbeeq.jdField_a_of_type_Long = System.currentTimeMillis();
        localbeeq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable = new TroopFileProtoReqMgr.ProtoRequestRunnable[parambeep.jdField_b_of_type_Int];
        int i = 0;
        int j = k;
        if (i < parambeep.jdField_b_of_type_Int)
        {
          Object localObject = new TroopFileProtoReqMgr.ProtoRequestRunnable(this);
          localbeeq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i] = localObject;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_Beeq = localbeeq;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), beer.class);
          localObject = ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent;
          if (parambeep.jdField_a_of_type_AndroidOsBundle != null) {
            ((NewIntent)localObject).putExtras(parambeep.jdField_a_of_type_AndroidOsBundle);
          }
          ((NewIntent)localObject).putExtra("data", parambeep.jdField_a_of_type_ArrayOfByte);
          ((NewIntent)localObject).putExtra("cmd", parambeep.jdField_a_of_type_JavaLangString);
          ((NewIntent)localObject).putExtra("key_runnable_index", i);
          ((NewIntent)localObject).putExtra("fastresendenable", parambeep.jdField_a_of_type_Boolean);
          ((NewIntent)localObject).putExtra("remind_slown_network", parambeep.jdField_b_of_type_Boolean);
          i += 1;
          continue;
        }
        if (j < parambeep.c)
        {
          long l1 = parambeep.jdField_a_of_type_Int * j / parambeep.c;
          long l2 = parambeep.jdField_a_of_type_Int;
          long l3 = parambeep.d * j;
          localbeeq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j].jdField_a_of_type_Long = (l2 - l1 - l3);
          a(localbeeq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j], l1);
          j += 1;
          continue;
        }
        localbeeq.jdField_a_of_type_Int = parambeep.c;
        return;
      }
      finally {}
      befc.a("TroopFileProtoReqMgr", befc.jdField_a_of_type_Int, "sendProtoRequest req=null");
    }
  }
  
  void a(beeq parambeeq)
  {
    parambeeq.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < parambeeq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambeeq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(parambeeq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i]);
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
  
  boolean a(beeq parambeeq)
  {
    int i = 0;
    while (i < parambeeq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      if ((!parambeeq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean) && ((parambeeq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_Boolean == true) || (parambeeq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void b(beep parambeep)
  {
    if (parambeep != null) {}
    try
    {
      if (parambeep.jdField_a_of_type_Beeq != null)
      {
        befc.c("TroopFileProtoReqMgr", befc.jdField_a_of_type_Int, "cookie<" + parambeep.jdField_b_of_type_Long + "> cancelRequest.");
        a(parambeep.jdField_a_of_type_Beeq);
      }
      return;
    }
    finally
    {
      parambeep = finally;
      throw parambeep;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr
 * JD-Core Version:    0.7.0.1
 */