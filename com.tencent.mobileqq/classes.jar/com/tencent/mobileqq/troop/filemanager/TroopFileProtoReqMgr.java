package com.tencent.mobileqq.troop.filemanager;

import akau;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import azsg;
import azsh;
import azsi;
import azsj;
import azst;
import bbma;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import mxj;

public class TroopFileProtoReqMgr
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ConcurrentHashMap<Intent, azsi> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TroopFileProtoReqMgr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  void a(Intent paramIntent, azsi paramazsi)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    paramazsi.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean = true;
    paramazsi.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    mxj localmxj = null;
    int m = 0;
    if ((paramIntent != null) && (paramFromServiceMsg != null)) {}
    for (;;)
    {
      try
      {
        localazsi = (azsi)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localazsi == null) {
          break label727;
        }
        if (localazsi.jdField_a_of_type_Boolean)
        {
          j = -1;
          paramIntent = null;
          k = 0;
          i = 1;
          localObject1 = localmxj;
          if (localObject1 != null)
          {
            if (k == 0) {
              break label626;
            }
            azst.c("TroopFileProtoReqMgr", azst.jdField_a_of_type_Int, "cookie<" + localazsi.jdField_a_of_type_Azsh.jdField_b_of_type_Long + "> onProtoResponse suc end. scheduleIndex:" + j + " retryCount:" + localazsi.jdField_a_of_type_Akau.c);
            ((mxj)localObject1).onReceive(i, true, paramIntent);
          }
        }
        else
        {
          j = paramIntent.getIntExtra("key_runnable_index", 0);
          a(paramIntent, localazsi);
          Object localObject2 = paramIntent.getExtras();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          localObject2 = localazsi.jdField_a_of_type_Azsh;
          i = ((azsh)localObject2).f;
          localazsi.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
          localazsi.jdField_a_of_type_Akau.jdField_b_of_type_Int = localazsi.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
          int n = paramFromServiceMsg.getResultCode();
          azst.c("TroopFileProtoReqMgr", azst.jdField_a_of_type_Int, "cookie<" + localazsi.jdField_a_of_type_Azsh.jdField_b_of_type_Long + "> onProtoResponse. scheduleIndex:" + j + " retCode:" + n);
          if (n == 1000)
          {
            a(localazsi);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            k = 1;
            if (((azsh)localObject2).jdField_a_of_type_Mxj == null) {
              break label717;
            }
            ((Bundle)localObject1).putByteArray("data", bbma.b(paramFromServiceMsg.getWupBuffer()));
            localmxj = ((azsh)localObject2).jdField_a_of_type_Mxj;
            paramIntent = (Intent)localObject1;
            k = 1;
            localObject1 = localmxj;
            continue;
          }
          if (n == 2901)
          {
            long l1 = System.currentTimeMillis() - localazsi.jdField_a_of_type_Long;
            if ((l1 < ((azsh)localObject2).e) && (localazsi.jdField_a_of_type_Int < ((azsh)localObject2).jdField_b_of_type_Int))
            {
              long l2 = ((azsh)localObject2).jdField_a_of_type_Int;
              paramIntent = localazsi.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[localazsi.jdField_a_of_type_Int];
              localazsi.jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              paramIntent = (Intent)localObject1;
              k = 0;
              localObject1 = localmxj;
              continue;
            }
            azst.d("TroopFileProtoReqMgr", azst.jdField_b_of_type_Int, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + localazsi.jdField_a_of_type_Int);
          }
          k = m;
          if (!a(localazsi)) {
            break label717;
          }
          a(localazsi);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (n == 1013)
          {
            paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
            paramIntent.setObserver(new azsg(this, localazsi, (azsh)localObject2));
            paramIntent.putExtra("action", 2201);
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
            paramIntent = (Intent)localObject1;
            k = 0;
            localObject1 = localmxj;
            continue;
          }
          k = m;
          if (((azsh)localObject2).jdField_a_of_type_Mxj == null) {
            break label717;
          }
          localmxj = ((azsh)localObject2).jdField_a_of_type_Mxj;
          paramIntent = (Intent)localObject1;
          k = 0;
          localObject1 = localmxj;
          continue;
        }
        paramIntent.putString("data_error_msg", paramFromServiceMsg.getBusinessFailMsg());
      }
      finally {}
      label626:
      paramIntent.putInt("data_error_code", paramFromServiceMsg.getBusinessFailCode());
      azst.a("TroopFileProtoReqMgr", azst.jdField_a_of_type_Int, "cookie<" + localazsi.jdField_a_of_type_Azsh.jdField_b_of_type_Long + "> onProtoResponse fail end. failCode:" + paramFromServiceMsg.getBusinessFailCode() + " retryCount:" + localazsi.jdField_a_of_type_Akau.c);
      ((mxj)localObject1).a(-1, null, paramIntent);
      return;
      label717:
      paramIntent = (Intent)localObject1;
      Object localObject1 = localmxj;
      continue;
      label727:
      int j = -1;
      paramIntent = null;
      int k = 0;
      int i = 1;
      localObject1 = localmxj;
      continue;
      j = -1;
      paramIntent = null;
      k = 0;
      azsi localazsi = null;
      i = 1;
      localObject1 = localmxj;
    }
  }
  
  public void a(azsh paramazsh)
  {
    int k = 0;
    if (paramazsh != null) {}
    for (;;)
    {
      try
      {
        azst.c("TroopFileProtoReqMgr", azst.jdField_a_of_type_Int, "cookie<" + paramazsh.jdField_b_of_type_Long + "> sendProtoRequest. ssocmd:" + paramazsh.jdField_a_of_type_JavaLangString + " tryCount:" + paramazsh.jdField_b_of_type_Int + " fixtryCount:" + paramazsh.c + " fastResend:" + paramazsh.jdField_a_of_type_Boolean + " RemindSlowNet:" + paramazsh.jdField_b_of_type_Boolean);
        azsi localazsi = new azsi();
        paramazsh.jdField_a_of_type_Azsi = localazsi;
        localazsi.jdField_a_of_type_Azsh = paramazsh;
        localazsi.jdField_a_of_type_Long = System.currentTimeMillis();
        localazsi.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable = new TroopFileProtoReqMgr.ProtoRequestRunnable[paramazsh.jdField_b_of_type_Int];
        int i = 0;
        int j = k;
        if (i < paramazsh.jdField_b_of_type_Int)
        {
          Object localObject = new TroopFileProtoReqMgr.ProtoRequestRunnable(this);
          localazsi.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i] = localObject;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_Azsi = localazsi;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), azsj.class);
          localObject = ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent;
          if (paramazsh.jdField_a_of_type_AndroidOsBundle != null) {
            ((NewIntent)localObject).putExtras(paramazsh.jdField_a_of_type_AndroidOsBundle);
          }
          ((NewIntent)localObject).putExtra("data", paramazsh.jdField_a_of_type_ArrayOfByte);
          ((NewIntent)localObject).putExtra("cmd", paramazsh.jdField_a_of_type_JavaLangString);
          ((NewIntent)localObject).putExtra("key_runnable_index", i);
          ((NewIntent)localObject).putExtra("fastresendenable", paramazsh.jdField_a_of_type_Boolean);
          ((NewIntent)localObject).putExtra("remind_slown_network", paramazsh.jdField_b_of_type_Boolean);
          i += 1;
          continue;
        }
        if (j < paramazsh.c)
        {
          long l1 = paramazsh.jdField_a_of_type_Int * j / paramazsh.c;
          long l2 = paramazsh.jdField_a_of_type_Int;
          long l3 = paramazsh.d * j;
          localazsi.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j].jdField_a_of_type_Long = (l2 - l1 - l3);
          a(localazsi.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j], l1);
          j += 1;
          continue;
        }
        localazsi.jdField_a_of_type_Int = paramazsh.c;
        return;
      }
      finally {}
      azst.a("TroopFileProtoReqMgr", azst.jdField_a_of_type_Int, "sendProtoRequest req=null");
    }
  }
  
  void a(azsi paramazsi)
  {
    paramazsi.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < paramazsi.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramazsi.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramazsi.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i]);
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
  
  boolean a(azsi paramazsi)
  {
    int i = 0;
    while (i < paramazsi.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      if ((!paramazsi.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean) && ((paramazsi.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_Boolean == true) || (paramazsi.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void b(azsh paramazsh)
  {
    if (paramazsh != null) {}
    try
    {
      if (paramazsh.jdField_a_of_type_Azsi != null)
      {
        azst.c("TroopFileProtoReqMgr", azst.jdField_a_of_type_Int, "cookie<" + paramazsh.jdField_b_of_type_Long + "> cancelRequest.");
        a(paramazsh.jdField_a_of_type_Azsi);
      }
      return;
    }
    finally
    {
      paramazsh = finally;
      throw paramazsh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr
 * JD-Core Version:    0.7.0.1
 */