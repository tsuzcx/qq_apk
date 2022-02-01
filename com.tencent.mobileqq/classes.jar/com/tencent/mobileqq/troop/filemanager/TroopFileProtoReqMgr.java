package com.tencent.mobileqq.troop.filemanager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import aock;
import bfvd;
import bfve;
import bfvf;
import bfvg;
import bfvr;
import bhuf;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import nkq;

public class TroopFileProtoReqMgr
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ConcurrentHashMap<Intent, bfvf> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TroopFileProtoReqMgr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  void a(Intent paramIntent, bfvf parambfvf)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    parambfvf.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean = true;
    parambfvf.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    nkq localnkq = null;
    int m = 0;
    if ((paramIntent != null) && (paramFromServiceMsg != null)) {}
    for (;;)
    {
      try
      {
        localbfvf = (bfvf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localbfvf == null) {
          break label727;
        }
        if (localbfvf.jdField_a_of_type_Boolean)
        {
          j = -1;
          paramIntent = null;
          k = 0;
          i = 1;
          localObject1 = localnkq;
          if (localObject1 != null)
          {
            if (k == 0) {
              break label626;
            }
            bfvr.c("TroopFileProtoReqMgr", bfvr.jdField_a_of_type_Int, "cookie<" + localbfvf.jdField_a_of_type_Bfve.jdField_b_of_type_Long + "> onProtoResponse suc end. scheduleIndex:" + j + " retryCount:" + localbfvf.jdField_a_of_type_Aock.c);
            ((nkq)localObject1).onReceive(i, true, paramIntent);
          }
        }
        else
        {
          j = paramIntent.getIntExtra("key_runnable_index", 0);
          a(paramIntent, localbfvf);
          Object localObject2 = paramIntent.getExtras();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          localObject2 = localbfvf.jdField_a_of_type_Bfve;
          i = ((bfve)localObject2).f;
          localbfvf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
          localbfvf.jdField_a_of_type_Aock.jdField_b_of_type_Int = localbfvf.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
          int n = paramFromServiceMsg.getResultCode();
          bfvr.c("TroopFileProtoReqMgr", bfvr.jdField_a_of_type_Int, "cookie<" + localbfvf.jdField_a_of_type_Bfve.jdField_b_of_type_Long + "> onProtoResponse. scheduleIndex:" + j + " retCode:" + n);
          if (n == 1000)
          {
            a(localbfvf);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            k = 1;
            if (((bfve)localObject2).jdField_a_of_type_Nkq == null) {
              break label717;
            }
            ((Bundle)localObject1).putByteArray("data", bhuf.b(paramFromServiceMsg.getWupBuffer()));
            localnkq = ((bfve)localObject2).jdField_a_of_type_Nkq;
            paramIntent = (Intent)localObject1;
            k = 1;
            localObject1 = localnkq;
            continue;
          }
          if (n == 2901)
          {
            long l1 = System.currentTimeMillis() - localbfvf.jdField_a_of_type_Long;
            if ((l1 < ((bfve)localObject2).e) && (localbfvf.jdField_a_of_type_Int < ((bfve)localObject2).jdField_b_of_type_Int))
            {
              long l2 = ((bfve)localObject2).jdField_a_of_type_Int;
              paramIntent = localbfvf.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[localbfvf.jdField_a_of_type_Int];
              localbfvf.jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              paramIntent = (Intent)localObject1;
              k = 0;
              localObject1 = localnkq;
              continue;
            }
            bfvr.d("TroopFileProtoReqMgr", bfvr.jdField_b_of_type_Int, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + localbfvf.jdField_a_of_type_Int);
          }
          k = m;
          if (!a(localbfvf)) {
            break label717;
          }
          a(localbfvf);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (n == 1013)
          {
            paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
            paramIntent.setObserver(new bfvd(this, localbfvf, (bfve)localObject2));
            paramIntent.putExtra("action", 2201);
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
            paramIntent = (Intent)localObject1;
            k = 0;
            localObject1 = localnkq;
            continue;
          }
          k = m;
          if (((bfve)localObject2).jdField_a_of_type_Nkq == null) {
            break label717;
          }
          localnkq = ((bfve)localObject2).jdField_a_of_type_Nkq;
          paramIntent = (Intent)localObject1;
          k = 0;
          localObject1 = localnkq;
          continue;
        }
        paramIntent.putString("data_error_msg", paramFromServiceMsg.getBusinessFailMsg());
      }
      finally {}
      label626:
      paramIntent.putInt("data_error_code", paramFromServiceMsg.getBusinessFailCode());
      bfvr.a("TroopFileProtoReqMgr", bfvr.jdField_a_of_type_Int, "cookie<" + localbfvf.jdField_a_of_type_Bfve.jdField_b_of_type_Long + "> onProtoResponse fail end. failCode:" + paramFromServiceMsg.getBusinessFailCode() + " retryCount:" + localbfvf.jdField_a_of_type_Aock.c);
      ((nkq)localObject1).a(-1, null, paramIntent);
      return;
      label717:
      paramIntent = (Intent)localObject1;
      Object localObject1 = localnkq;
      continue;
      label727:
      int j = -1;
      paramIntent = null;
      int k = 0;
      int i = 1;
      localObject1 = localnkq;
      continue;
      j = -1;
      paramIntent = null;
      k = 0;
      bfvf localbfvf = null;
      i = 1;
      localObject1 = localnkq;
    }
  }
  
  public void a(bfve parambfve)
  {
    int k = 0;
    if (parambfve != null) {}
    for (;;)
    {
      try
      {
        bfvr.c("TroopFileProtoReqMgr", bfvr.jdField_a_of_type_Int, "cookie<" + parambfve.jdField_b_of_type_Long + "> sendProtoRequest. ssocmd:" + parambfve.jdField_a_of_type_JavaLangString + " tryCount:" + parambfve.jdField_b_of_type_Int + " fixtryCount:" + parambfve.c + " fastResend:" + parambfve.jdField_a_of_type_Boolean + " RemindSlowNet:" + parambfve.jdField_b_of_type_Boolean);
        bfvf localbfvf = new bfvf();
        parambfve.jdField_a_of_type_Bfvf = localbfvf;
        localbfvf.jdField_a_of_type_Bfve = parambfve;
        localbfvf.jdField_a_of_type_Long = System.currentTimeMillis();
        localbfvf.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable = new TroopFileProtoReqMgr.ProtoRequestRunnable[parambfve.jdField_b_of_type_Int];
        int i = 0;
        int j = k;
        if (i < parambfve.jdField_b_of_type_Int)
        {
          Object localObject = new TroopFileProtoReqMgr.ProtoRequestRunnable(this);
          localbfvf.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i] = localObject;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_Bfvf = localbfvf;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), bfvg.class);
          localObject = ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent;
          if (parambfve.jdField_a_of_type_AndroidOsBundle != null) {
            ((NewIntent)localObject).putExtras(parambfve.jdField_a_of_type_AndroidOsBundle);
          }
          ((NewIntent)localObject).putExtra("data", parambfve.jdField_a_of_type_ArrayOfByte);
          ((NewIntent)localObject).putExtra("cmd", parambfve.jdField_a_of_type_JavaLangString);
          ((NewIntent)localObject).putExtra("key_runnable_index", i);
          ((NewIntent)localObject).putExtra("fastresendenable", parambfve.jdField_a_of_type_Boolean);
          ((NewIntent)localObject).putExtra("remind_slown_network", parambfve.jdField_b_of_type_Boolean);
          i += 1;
          continue;
        }
        if (j < parambfve.c)
        {
          long l1 = parambfve.jdField_a_of_type_Int * j / parambfve.c;
          long l2 = parambfve.jdField_a_of_type_Int;
          long l3 = parambfve.d * j;
          localbfvf.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j].jdField_a_of_type_Long = (l2 - l1 - l3);
          a(localbfvf.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j], l1);
          j += 1;
          continue;
        }
        localbfvf.jdField_a_of_type_Int = parambfve.c;
        return;
      }
      finally {}
      bfvr.a("TroopFileProtoReqMgr", bfvr.jdField_a_of_type_Int, "sendProtoRequest req=null");
    }
  }
  
  void a(bfvf parambfvf)
  {
    parambfvf.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < parambfvf.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambfvf.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(parambfvf.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i]);
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
  
  boolean a(bfvf parambfvf)
  {
    int i = 0;
    while (i < parambfvf.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      if ((!parambfvf.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean) && ((parambfvf.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_Boolean == true) || (parambfvf.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void b(bfve parambfve)
  {
    if (parambfve != null) {}
    try
    {
      if (parambfve.jdField_a_of_type_Bfvf != null)
      {
        bfvr.c("TroopFileProtoReqMgr", bfvr.jdField_a_of_type_Int, "cookie<" + parambfve.jdField_b_of_type_Long + "> cancelRequest.");
        a(parambfve.jdField_a_of_type_Bfvf);
      }
      return;
    }
    finally
    {
      parambfve = finally;
      throw parambfve;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr
 * JD-Core Version:    0.7.0.1
 */