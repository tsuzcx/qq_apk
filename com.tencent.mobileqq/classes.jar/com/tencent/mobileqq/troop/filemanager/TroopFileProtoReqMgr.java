package com.tencent.mobileqq.troop.filemanager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import anqe;
import bevj;
import bevk;
import bevl;
import bevm;
import bevx;
import bguc;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import niv;

public class TroopFileProtoReqMgr
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ConcurrentHashMap<Intent, bevl> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TroopFileProtoReqMgr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  void a(Intent paramIntent, bevl parambevl)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    parambevl.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean = true;
    parambevl.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    niv localniv = null;
    int m = 0;
    if ((paramIntent != null) && (paramFromServiceMsg != null)) {}
    for (;;)
    {
      try
      {
        localbevl = (bevl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localbevl == null) {
          break label727;
        }
        if (localbevl.jdField_a_of_type_Boolean)
        {
          j = -1;
          paramIntent = null;
          k = 0;
          i = 1;
          localObject1 = localniv;
          if (localObject1 != null)
          {
            if (k == 0) {
              break label626;
            }
            bevx.c("TroopFileProtoReqMgr", bevx.jdField_a_of_type_Int, "cookie<" + localbevl.jdField_a_of_type_Bevk.jdField_b_of_type_Long + "> onProtoResponse suc end. scheduleIndex:" + j + " retryCount:" + localbevl.jdField_a_of_type_Anqe.c);
            ((niv)localObject1).onReceive(i, true, paramIntent);
          }
        }
        else
        {
          j = paramIntent.getIntExtra("key_runnable_index", 0);
          a(paramIntent, localbevl);
          Object localObject2 = paramIntent.getExtras();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          localObject2 = localbevl.jdField_a_of_type_Bevk;
          i = ((bevk)localObject2).f;
          localbevl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
          localbevl.jdField_a_of_type_Anqe.jdField_b_of_type_Int = localbevl.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
          int n = paramFromServiceMsg.getResultCode();
          bevx.c("TroopFileProtoReqMgr", bevx.jdField_a_of_type_Int, "cookie<" + localbevl.jdField_a_of_type_Bevk.jdField_b_of_type_Long + "> onProtoResponse. scheduleIndex:" + j + " retCode:" + n);
          if (n == 1000)
          {
            a(localbevl);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            k = 1;
            if (((bevk)localObject2).jdField_a_of_type_Niv == null) {
              break label717;
            }
            ((Bundle)localObject1).putByteArray("data", bguc.b(paramFromServiceMsg.getWupBuffer()));
            localniv = ((bevk)localObject2).jdField_a_of_type_Niv;
            paramIntent = (Intent)localObject1;
            k = 1;
            localObject1 = localniv;
            continue;
          }
          if (n == 2901)
          {
            long l1 = System.currentTimeMillis() - localbevl.jdField_a_of_type_Long;
            if ((l1 < ((bevk)localObject2).e) && (localbevl.jdField_a_of_type_Int < ((bevk)localObject2).jdField_b_of_type_Int))
            {
              long l2 = ((bevk)localObject2).jdField_a_of_type_Int;
              paramIntent = localbevl.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[localbevl.jdField_a_of_type_Int];
              localbevl.jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              paramIntent = (Intent)localObject1;
              k = 0;
              localObject1 = localniv;
              continue;
            }
            bevx.d("TroopFileProtoReqMgr", bevx.jdField_b_of_type_Int, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + localbevl.jdField_a_of_type_Int);
          }
          k = m;
          if (!a(localbevl)) {
            break label717;
          }
          a(localbevl);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (n == 1013)
          {
            paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
            paramIntent.setObserver(new bevj(this, localbevl, (bevk)localObject2));
            paramIntent.putExtra("action", 2201);
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
            paramIntent = (Intent)localObject1;
            k = 0;
            localObject1 = localniv;
            continue;
          }
          k = m;
          if (((bevk)localObject2).jdField_a_of_type_Niv == null) {
            break label717;
          }
          localniv = ((bevk)localObject2).jdField_a_of_type_Niv;
          paramIntent = (Intent)localObject1;
          k = 0;
          localObject1 = localniv;
          continue;
        }
        paramIntent.putString("data_error_msg", paramFromServiceMsg.getBusinessFailMsg());
      }
      finally {}
      label626:
      paramIntent.putInt("data_error_code", paramFromServiceMsg.getBusinessFailCode());
      bevx.a("TroopFileProtoReqMgr", bevx.jdField_a_of_type_Int, "cookie<" + localbevl.jdField_a_of_type_Bevk.jdField_b_of_type_Long + "> onProtoResponse fail end. failCode:" + paramFromServiceMsg.getBusinessFailCode() + " retryCount:" + localbevl.jdField_a_of_type_Anqe.c);
      ((niv)localObject1).a(-1, null, paramIntent);
      return;
      label717:
      paramIntent = (Intent)localObject1;
      Object localObject1 = localniv;
      continue;
      label727:
      int j = -1;
      paramIntent = null;
      int k = 0;
      int i = 1;
      localObject1 = localniv;
      continue;
      j = -1;
      paramIntent = null;
      k = 0;
      bevl localbevl = null;
      i = 1;
      localObject1 = localniv;
    }
  }
  
  public void a(bevk parambevk)
  {
    int k = 0;
    if (parambevk != null) {}
    for (;;)
    {
      try
      {
        bevx.c("TroopFileProtoReqMgr", bevx.jdField_a_of_type_Int, "cookie<" + parambevk.jdField_b_of_type_Long + "> sendProtoRequest. ssocmd:" + parambevk.jdField_a_of_type_JavaLangString + " tryCount:" + parambevk.jdField_b_of_type_Int + " fixtryCount:" + parambevk.c + " fastResend:" + parambevk.jdField_a_of_type_Boolean + " RemindSlowNet:" + parambevk.jdField_b_of_type_Boolean);
        bevl localbevl = new bevl();
        parambevk.jdField_a_of_type_Bevl = localbevl;
        localbevl.jdField_a_of_type_Bevk = parambevk;
        localbevl.jdField_a_of_type_Long = System.currentTimeMillis();
        localbevl.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable = new TroopFileProtoReqMgr.ProtoRequestRunnable[parambevk.jdField_b_of_type_Int];
        int i = 0;
        int j = k;
        if (i < parambevk.jdField_b_of_type_Int)
        {
          Object localObject = new TroopFileProtoReqMgr.ProtoRequestRunnable(this);
          localbevl.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i] = localObject;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_Bevl = localbevl;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), bevm.class);
          localObject = ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent;
          if (parambevk.jdField_a_of_type_AndroidOsBundle != null) {
            ((NewIntent)localObject).putExtras(parambevk.jdField_a_of_type_AndroidOsBundle);
          }
          ((NewIntent)localObject).putExtra("data", parambevk.jdField_a_of_type_ArrayOfByte);
          ((NewIntent)localObject).putExtra("cmd", parambevk.jdField_a_of_type_JavaLangString);
          ((NewIntent)localObject).putExtra("key_runnable_index", i);
          ((NewIntent)localObject).putExtra("fastresendenable", parambevk.jdField_a_of_type_Boolean);
          ((NewIntent)localObject).putExtra("remind_slown_network", parambevk.jdField_b_of_type_Boolean);
          i += 1;
          continue;
        }
        if (j < parambevk.c)
        {
          long l1 = parambevk.jdField_a_of_type_Int * j / parambevk.c;
          long l2 = parambevk.jdField_a_of_type_Int;
          long l3 = parambevk.d * j;
          localbevl.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j].jdField_a_of_type_Long = (l2 - l1 - l3);
          a(localbevl.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j], l1);
          j += 1;
          continue;
        }
        localbevl.jdField_a_of_type_Int = parambevk.c;
        return;
      }
      finally {}
      bevx.a("TroopFileProtoReqMgr", bevx.jdField_a_of_type_Int, "sendProtoRequest req=null");
    }
  }
  
  void a(bevl parambevl)
  {
    parambevl.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < parambevl.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambevl.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(parambevl.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i]);
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
  
  boolean a(bevl parambevl)
  {
    int i = 0;
    while (i < parambevl.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      if ((!parambevl.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean) && ((parambevl.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_Boolean == true) || (parambevl.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void b(bevk parambevk)
  {
    if (parambevk != null) {}
    try
    {
      if (parambevk.jdField_a_of_type_Bevl != null)
      {
        bevx.c("TroopFileProtoReqMgr", bevx.jdField_a_of_type_Int, "cookie<" + parambevk.jdField_b_of_type_Long + "> cancelRequest.");
        a(parambevk.jdField_a_of_type_Bevl);
      }
      return;
    }
    finally
    {
      parambevk = finally;
      throw parambevk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr
 * JD-Core Version:    0.7.0.1
 */