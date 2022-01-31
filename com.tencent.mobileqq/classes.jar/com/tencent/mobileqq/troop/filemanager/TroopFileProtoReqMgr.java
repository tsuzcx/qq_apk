package com.tencent.mobileqq.troop.filemanager;

import ajmn;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import ayro;
import ayrp;
import ayrq;
import ayrr;
import aysb;
import bakc;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.concurrent.ConcurrentHashMap;
import mmn;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class TroopFileProtoReqMgr
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ConcurrentHashMap<Intent, ayrq> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TroopFileProtoReqMgr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  void a(Intent paramIntent, ayrq paramayrq)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    paramayrq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean = true;
    paramayrq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    mmn localmmn = null;
    int m = 0;
    if ((paramIntent != null) && (paramFromServiceMsg != null)) {}
    for (;;)
    {
      try
      {
        localayrq = (ayrq)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localayrq == null) {
          break label727;
        }
        if (localayrq.jdField_a_of_type_Boolean)
        {
          j = -1;
          paramIntent = null;
          k = 0;
          i = 1;
          localObject1 = localmmn;
          if (localObject1 != null)
          {
            if (k == 0) {
              break label626;
            }
            aysb.c("TroopFileProtoReqMgr", aysb.jdField_a_of_type_Int, "cookie<" + localayrq.jdField_a_of_type_Ayrp.jdField_b_of_type_Long + "> onProtoResponse suc end. scheduleIndex:" + j + " retryCount:" + localayrq.jdField_a_of_type_Ajmn.c);
            ((mmn)localObject1).onReceive(i, true, paramIntent);
          }
        }
        else
        {
          j = paramIntent.getIntExtra("key_runnable_index", 0);
          a(paramIntent, localayrq);
          Object localObject2 = paramIntent.getExtras();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          localObject2 = localayrq.jdField_a_of_type_Ayrp;
          i = ((ayrp)localObject2).f;
          localayrq.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
          localayrq.jdField_a_of_type_Ajmn.jdField_b_of_type_Int = localayrq.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
          int n = paramFromServiceMsg.getResultCode();
          aysb.c("TroopFileProtoReqMgr", aysb.jdField_a_of_type_Int, "cookie<" + localayrq.jdField_a_of_type_Ayrp.jdField_b_of_type_Long + "> onProtoResponse. scheduleIndex:" + j + " retCode:" + n);
          if (n == 1000)
          {
            a(localayrq);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            k = 1;
            if (((ayrp)localObject2).jdField_a_of_type_Mmn == null) {
              break label717;
            }
            ((Bundle)localObject1).putByteArray("data", bakc.b(paramFromServiceMsg.getWupBuffer()));
            localmmn = ((ayrp)localObject2).jdField_a_of_type_Mmn;
            paramIntent = (Intent)localObject1;
            k = 1;
            localObject1 = localmmn;
            continue;
          }
          if (n == 2901)
          {
            long l1 = System.currentTimeMillis() - localayrq.jdField_a_of_type_Long;
            if ((l1 < ((ayrp)localObject2).e) && (localayrq.jdField_a_of_type_Int < ((ayrp)localObject2).jdField_b_of_type_Int))
            {
              long l2 = ((ayrp)localObject2).jdField_a_of_type_Int;
              paramIntent = localayrq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[localayrq.jdField_a_of_type_Int];
              localayrq.jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              paramIntent = (Intent)localObject1;
              k = 0;
              localObject1 = localmmn;
              continue;
            }
            aysb.d("TroopFileProtoReqMgr", aysb.jdField_b_of_type_Int, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + localayrq.jdField_a_of_type_Int);
          }
          k = m;
          if (!a(localayrq)) {
            break label717;
          }
          a(localayrq);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (n == 1013)
          {
            paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
            paramIntent.setObserver(new ayro(this, localayrq, (ayrp)localObject2));
            paramIntent.putExtra("action", 2201);
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
            paramIntent = (Intent)localObject1;
            k = 0;
            localObject1 = localmmn;
            continue;
          }
          k = m;
          if (((ayrp)localObject2).jdField_a_of_type_Mmn == null) {
            break label717;
          }
          localmmn = ((ayrp)localObject2).jdField_a_of_type_Mmn;
          paramIntent = (Intent)localObject1;
          k = 0;
          localObject1 = localmmn;
          continue;
        }
        paramIntent.putString("data_error_msg", paramFromServiceMsg.getBusinessFailMsg());
      }
      finally {}
      label626:
      paramIntent.putInt("data_error_code", paramFromServiceMsg.getBusinessFailCode());
      aysb.a("TroopFileProtoReqMgr", aysb.jdField_a_of_type_Int, "cookie<" + localayrq.jdField_a_of_type_Ayrp.jdField_b_of_type_Long + "> onProtoResponse fail end. failCode:" + paramFromServiceMsg.getBusinessFailCode() + " retryCount:" + localayrq.jdField_a_of_type_Ajmn.c);
      ((mmn)localObject1).a(-1, null, paramIntent);
      return;
      label717:
      paramIntent = (Intent)localObject1;
      Object localObject1 = localmmn;
      continue;
      label727:
      int j = -1;
      paramIntent = null;
      int k = 0;
      int i = 1;
      localObject1 = localmmn;
      continue;
      j = -1;
      paramIntent = null;
      k = 0;
      ayrq localayrq = null;
      i = 1;
      localObject1 = localmmn;
    }
  }
  
  public void a(ayrp paramayrp)
  {
    int k = 0;
    if (paramayrp != null) {}
    for (;;)
    {
      try
      {
        aysb.c("TroopFileProtoReqMgr", aysb.jdField_a_of_type_Int, "cookie<" + paramayrp.jdField_b_of_type_Long + "> sendProtoRequest. ssocmd:" + paramayrp.jdField_a_of_type_JavaLangString + " tryCount:" + paramayrp.jdField_b_of_type_Int + " fixtryCount:" + paramayrp.c + " fastResend:" + paramayrp.jdField_a_of_type_Boolean + " RemindSlowNet:" + paramayrp.jdField_b_of_type_Boolean);
        ayrq localayrq = new ayrq();
        paramayrp.jdField_a_of_type_Ayrq = localayrq;
        localayrq.jdField_a_of_type_Ayrp = paramayrp;
        localayrq.jdField_a_of_type_Long = System.currentTimeMillis();
        localayrq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable = new TroopFileProtoReqMgr.ProtoRequestRunnable[paramayrp.jdField_b_of_type_Int];
        int i = 0;
        int j = k;
        if (i < paramayrp.jdField_b_of_type_Int)
        {
          Object localObject = new TroopFileProtoReqMgr.ProtoRequestRunnable(this);
          localayrq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i] = localObject;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_Ayrq = localayrq;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), ayrr.class);
          localObject = ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent;
          if (paramayrp.jdField_a_of_type_AndroidOsBundle != null) {
            ((NewIntent)localObject).putExtras(paramayrp.jdField_a_of_type_AndroidOsBundle);
          }
          ((NewIntent)localObject).putExtra("data", paramayrp.jdField_a_of_type_ArrayOfByte);
          ((NewIntent)localObject).putExtra("cmd", paramayrp.jdField_a_of_type_JavaLangString);
          ((NewIntent)localObject).putExtra("key_runnable_index", i);
          ((NewIntent)localObject).putExtra("fastresendenable", paramayrp.jdField_a_of_type_Boolean);
          ((NewIntent)localObject).putExtra("remind_slown_network", paramayrp.jdField_b_of_type_Boolean);
          i += 1;
          continue;
        }
        if (j < paramayrp.c)
        {
          long l1 = paramayrp.jdField_a_of_type_Int * j / paramayrp.c;
          long l2 = paramayrp.jdField_a_of_type_Int;
          long l3 = paramayrp.d * j;
          localayrq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j].jdField_a_of_type_Long = (l2 - l1 - l3);
          a(localayrq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j], l1);
          j += 1;
          continue;
        }
        localayrq.jdField_a_of_type_Int = paramayrp.c;
        return;
      }
      finally {}
      aysb.a("TroopFileProtoReqMgr", aysb.jdField_a_of_type_Int, "sendProtoRequest req=null");
    }
  }
  
  void a(ayrq paramayrq)
  {
    paramayrq.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < paramayrq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramayrq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramayrq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i]);
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
  
  boolean a(ayrq paramayrq)
  {
    int i = 0;
    while (i < paramayrq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      if ((!paramayrq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean) && ((paramayrq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_Boolean == true) || (paramayrq.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void b(ayrp paramayrp)
  {
    if (paramayrp != null) {}
    try
    {
      if (paramayrp.jdField_a_of_type_Ayrq != null)
      {
        aysb.c("TroopFileProtoReqMgr", aysb.jdField_a_of_type_Int, "cookie<" + paramayrp.jdField_b_of_type_Long + "> cancelRequest.");
        a(paramayrp.jdField_a_of_type_Ayrq);
      }
      return;
    }
    finally
    {
      paramayrp = finally;
      throw paramayrp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr
 * JD-Core Version:    0.7.0.1
 */