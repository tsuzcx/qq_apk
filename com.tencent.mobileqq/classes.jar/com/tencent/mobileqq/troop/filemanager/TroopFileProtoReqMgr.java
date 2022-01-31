package com.tencent.mobileqq.troop.filemanager;

import akaw;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import azse;
import azsf;
import azsg;
import azsh;
import azsr;
import bblm;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import mxm;

public class TroopFileProtoReqMgr
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ConcurrentHashMap<Intent, azsg> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TroopFileProtoReqMgr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  void a(Intent paramIntent, azsg paramazsg)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    paramazsg.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean = true;
    paramazsg.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    mxm localmxm = null;
    int m = 0;
    if ((paramIntent != null) && (paramFromServiceMsg != null)) {}
    for (;;)
    {
      try
      {
        localazsg = (azsg)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localazsg == null) {
          break label727;
        }
        if (localazsg.jdField_a_of_type_Boolean)
        {
          j = -1;
          paramIntent = null;
          k = 0;
          i = 1;
          localObject1 = localmxm;
          if (localObject1 != null)
          {
            if (k == 0) {
              break label626;
            }
            azsr.c("TroopFileProtoReqMgr", azsr.jdField_a_of_type_Int, "cookie<" + localazsg.jdField_a_of_type_Azsf.jdField_b_of_type_Long + "> onProtoResponse suc end. scheduleIndex:" + j + " retryCount:" + localazsg.jdField_a_of_type_Akaw.c);
            ((mxm)localObject1).onReceive(i, true, paramIntent);
          }
        }
        else
        {
          j = paramIntent.getIntExtra("key_runnable_index", 0);
          a(paramIntent, localazsg);
          Object localObject2 = paramIntent.getExtras();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          localObject2 = localazsg.jdField_a_of_type_Azsf;
          i = ((azsf)localObject2).f;
          localazsg.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
          localazsg.jdField_a_of_type_Akaw.jdField_b_of_type_Int = localazsg.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
          int n = paramFromServiceMsg.getResultCode();
          azsr.c("TroopFileProtoReqMgr", azsr.jdField_a_of_type_Int, "cookie<" + localazsg.jdField_a_of_type_Azsf.jdField_b_of_type_Long + "> onProtoResponse. scheduleIndex:" + j + " retCode:" + n);
          if (n == 1000)
          {
            a(localazsg);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            k = 1;
            if (((azsf)localObject2).jdField_a_of_type_Mxm == null) {
              break label717;
            }
            ((Bundle)localObject1).putByteArray("data", bblm.b(paramFromServiceMsg.getWupBuffer()));
            localmxm = ((azsf)localObject2).jdField_a_of_type_Mxm;
            paramIntent = (Intent)localObject1;
            k = 1;
            localObject1 = localmxm;
            continue;
          }
          if (n == 2901)
          {
            long l1 = System.currentTimeMillis() - localazsg.jdField_a_of_type_Long;
            if ((l1 < ((azsf)localObject2).e) && (localazsg.jdField_a_of_type_Int < ((azsf)localObject2).jdField_b_of_type_Int))
            {
              long l2 = ((azsf)localObject2).jdField_a_of_type_Int;
              paramIntent = localazsg.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[localazsg.jdField_a_of_type_Int];
              localazsg.jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              paramIntent = (Intent)localObject1;
              k = 0;
              localObject1 = localmxm;
              continue;
            }
            azsr.d("TroopFileProtoReqMgr", azsr.jdField_b_of_type_Int, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + localazsg.jdField_a_of_type_Int);
          }
          k = m;
          if (!a(localazsg)) {
            break label717;
          }
          a(localazsg);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (n == 1013)
          {
            paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
            paramIntent.setObserver(new azse(this, localazsg, (azsf)localObject2));
            paramIntent.putExtra("action", 2201);
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
            paramIntent = (Intent)localObject1;
            k = 0;
            localObject1 = localmxm;
            continue;
          }
          k = m;
          if (((azsf)localObject2).jdField_a_of_type_Mxm == null) {
            break label717;
          }
          localmxm = ((azsf)localObject2).jdField_a_of_type_Mxm;
          paramIntent = (Intent)localObject1;
          k = 0;
          localObject1 = localmxm;
          continue;
        }
        paramIntent.putString("data_error_msg", paramFromServiceMsg.getBusinessFailMsg());
      }
      finally {}
      label626:
      paramIntent.putInt("data_error_code", paramFromServiceMsg.getBusinessFailCode());
      azsr.a("TroopFileProtoReqMgr", azsr.jdField_a_of_type_Int, "cookie<" + localazsg.jdField_a_of_type_Azsf.jdField_b_of_type_Long + "> onProtoResponse fail end. failCode:" + paramFromServiceMsg.getBusinessFailCode() + " retryCount:" + localazsg.jdField_a_of_type_Akaw.c);
      ((mxm)localObject1).a(-1, null, paramIntent);
      return;
      label717:
      paramIntent = (Intent)localObject1;
      Object localObject1 = localmxm;
      continue;
      label727:
      int j = -1;
      paramIntent = null;
      int k = 0;
      int i = 1;
      localObject1 = localmxm;
      continue;
      j = -1;
      paramIntent = null;
      k = 0;
      azsg localazsg = null;
      i = 1;
      localObject1 = localmxm;
    }
  }
  
  public void a(azsf paramazsf)
  {
    int k = 0;
    if (paramazsf != null) {}
    for (;;)
    {
      try
      {
        azsr.c("TroopFileProtoReqMgr", azsr.jdField_a_of_type_Int, "cookie<" + paramazsf.jdField_b_of_type_Long + "> sendProtoRequest. ssocmd:" + paramazsf.jdField_a_of_type_JavaLangString + " tryCount:" + paramazsf.jdField_b_of_type_Int + " fixtryCount:" + paramazsf.c + " fastResend:" + paramazsf.jdField_a_of_type_Boolean + " RemindSlowNet:" + paramazsf.jdField_b_of_type_Boolean);
        azsg localazsg = new azsg();
        paramazsf.jdField_a_of_type_Azsg = localazsg;
        localazsg.jdField_a_of_type_Azsf = paramazsf;
        localazsg.jdField_a_of_type_Long = System.currentTimeMillis();
        localazsg.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable = new TroopFileProtoReqMgr.ProtoRequestRunnable[paramazsf.jdField_b_of_type_Int];
        int i = 0;
        int j = k;
        if (i < paramazsf.jdField_b_of_type_Int)
        {
          Object localObject = new TroopFileProtoReqMgr.ProtoRequestRunnable(this);
          localazsg.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i] = localObject;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_Azsg = localazsg;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), azsh.class);
          localObject = ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent;
          if (paramazsf.jdField_a_of_type_AndroidOsBundle != null) {
            ((NewIntent)localObject).putExtras(paramazsf.jdField_a_of_type_AndroidOsBundle);
          }
          ((NewIntent)localObject).putExtra("data", paramazsf.jdField_a_of_type_ArrayOfByte);
          ((NewIntent)localObject).putExtra("cmd", paramazsf.jdField_a_of_type_JavaLangString);
          ((NewIntent)localObject).putExtra("key_runnable_index", i);
          ((NewIntent)localObject).putExtra("fastresendenable", paramazsf.jdField_a_of_type_Boolean);
          ((NewIntent)localObject).putExtra("remind_slown_network", paramazsf.jdField_b_of_type_Boolean);
          i += 1;
          continue;
        }
        if (j < paramazsf.c)
        {
          long l1 = paramazsf.jdField_a_of_type_Int * j / paramazsf.c;
          long l2 = paramazsf.jdField_a_of_type_Int;
          long l3 = paramazsf.d * j;
          localazsg.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j].jdField_a_of_type_Long = (l2 - l1 - l3);
          a(localazsg.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j], l1);
          j += 1;
          continue;
        }
        localazsg.jdField_a_of_type_Int = paramazsf.c;
        return;
      }
      finally {}
      azsr.a("TroopFileProtoReqMgr", azsr.jdField_a_of_type_Int, "sendProtoRequest req=null");
    }
  }
  
  void a(azsg paramazsg)
  {
    paramazsg.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < paramazsg.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramazsg.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramazsg.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i]);
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
  
  boolean a(azsg paramazsg)
  {
    int i = 0;
    while (i < paramazsg.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      if ((!paramazsg.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean) && ((paramazsg.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_Boolean == true) || (paramazsg.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void b(azsf paramazsf)
  {
    if (paramazsf != null) {}
    try
    {
      if (paramazsf.jdField_a_of_type_Azsg != null)
      {
        azsr.c("TroopFileProtoReqMgr", azsr.jdField_a_of_type_Int, "cookie<" + paramazsf.jdField_b_of_type_Long + "> cancelRequest.");
        a(paramazsf.jdField_a_of_type_Azsg);
      }
      return;
    }
    finally
    {
      paramazsf = finally;
      throw paramazsf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr
 * JD-Core Version:    0.7.0.1
 */