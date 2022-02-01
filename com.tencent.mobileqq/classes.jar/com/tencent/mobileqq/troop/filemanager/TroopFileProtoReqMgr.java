package com.tencent.mobileqq.troop.filemanager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import anza;
import bflr;
import bfls;
import bflt;
import bflu;
import bfmf;
import bhjl;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;
import ntf;

public class TroopFileProtoReqMgr
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ConcurrentHashMap<Intent, bflt> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  public TroopFileProtoReqMgr(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  void a(Intent paramIntent, bflt parambflt)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    parambflt.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean = true;
    parambflt.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    ntf localntf = null;
    int m = 0;
    if ((paramIntent != null) && (paramFromServiceMsg != null)) {}
    for (;;)
    {
      try
      {
        localbflt = (bflt)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localbflt == null) {
          break label727;
        }
        if (localbflt.jdField_a_of_type_Boolean)
        {
          j = -1;
          paramIntent = null;
          k = 0;
          i = 1;
          localObject1 = localntf;
          if (localObject1 != null)
          {
            if (k == 0) {
              break label626;
            }
            bfmf.c("TroopFileProtoReqMgr", bfmf.jdField_a_of_type_Int, "cookie<" + localbflt.jdField_a_of_type_Bfls.jdField_b_of_type_Long + "> onProtoResponse suc end. scheduleIndex:" + j + " retryCount:" + localbflt.jdField_a_of_type_Anza.c);
            ((ntf)localObject1).onReceive(i, true, paramIntent);
          }
        }
        else
        {
          j = paramIntent.getIntExtra("key_runnable_index", 0);
          a(paramIntent, localbflt);
          Object localObject2 = paramIntent.getExtras();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new Bundle();
          }
          localObject2 = localbflt.jdField_a_of_type_Bfls;
          i = ((bfls)localObject2).f;
          localbflt.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
          localbflt.jdField_a_of_type_Anza.jdField_b_of_type_Int = localbflt.jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
          int n = paramFromServiceMsg.getResultCode();
          bfmf.c("TroopFileProtoReqMgr", bfmf.jdField_a_of_type_Int, "cookie<" + localbflt.jdField_a_of_type_Bfls.jdField_b_of_type_Long + "> onProtoResponse. scheduleIndex:" + j + " retCode:" + n);
          if (n == 1000)
          {
            a(localbflt);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            k = 1;
            if (((bfls)localObject2).jdField_a_of_type_Ntf == null) {
              break label717;
            }
            ((Bundle)localObject1).putByteArray("data", bhjl.b(paramFromServiceMsg.getWupBuffer()));
            localntf = ((bfls)localObject2).jdField_a_of_type_Ntf;
            paramIntent = (Intent)localObject1;
            k = 1;
            localObject1 = localntf;
            continue;
          }
          if (n == 2901)
          {
            long l1 = System.currentTimeMillis() - localbflt.jdField_a_of_type_Long;
            if ((l1 < ((bfls)localObject2).e) && (localbflt.jdField_a_of_type_Int < ((bfls)localObject2).jdField_b_of_type_Int))
            {
              long l2 = ((bfls)localObject2).jdField_a_of_type_Int;
              paramIntent = localbflt.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[localbflt.jdField_a_of_type_Int];
              localbflt.jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              paramIntent = (Intent)localObject1;
              k = 0;
              localObject1 = localntf;
              continue;
            }
            bfmf.d("TroopFileProtoReqMgr", bfmf.jdField_b_of_type_Int, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + localbflt.jdField_a_of_type_Int);
          }
          k = m;
          if (!a(localbflt)) {
            break label717;
          }
          a(localbflt);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (n == 1013)
          {
            paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
            paramIntent.setObserver(new bflr(this, localbflt, (bfls)localObject2));
            paramIntent.putExtra("action", 2201);
            this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
            paramIntent = (Intent)localObject1;
            k = 0;
            localObject1 = localntf;
            continue;
          }
          k = m;
          if (((bfls)localObject2).jdField_a_of_type_Ntf == null) {
            break label717;
          }
          localntf = ((bfls)localObject2).jdField_a_of_type_Ntf;
          paramIntent = (Intent)localObject1;
          k = 0;
          localObject1 = localntf;
          continue;
        }
        paramIntent.putString("data_error_msg", paramFromServiceMsg.getBusinessFailMsg());
      }
      finally {}
      label626:
      paramIntent.putInt("data_error_code", paramFromServiceMsg.getBusinessFailCode());
      bfmf.a("TroopFileProtoReqMgr", bfmf.jdField_a_of_type_Int, "cookie<" + localbflt.jdField_a_of_type_Bfls.jdField_b_of_type_Long + "> onProtoResponse fail end. failCode:" + paramFromServiceMsg.getBusinessFailCode() + " retryCount:" + localbflt.jdField_a_of_type_Anza.c);
      ((ntf)localObject1).a(-1, null, paramIntent);
      return;
      label717:
      paramIntent = (Intent)localObject1;
      Object localObject1 = localntf;
      continue;
      label727:
      int j = -1;
      paramIntent = null;
      int k = 0;
      int i = 1;
      localObject1 = localntf;
      continue;
      j = -1;
      paramIntent = null;
      k = 0;
      bflt localbflt = null;
      i = 1;
      localObject1 = localntf;
    }
  }
  
  public void a(bfls parambfls)
  {
    int k = 0;
    if (parambfls != null) {}
    for (;;)
    {
      try
      {
        bfmf.c("TroopFileProtoReqMgr", bfmf.jdField_a_of_type_Int, "cookie<" + parambfls.jdField_b_of_type_Long + "> sendProtoRequest. ssocmd:" + parambfls.jdField_a_of_type_JavaLangString + " tryCount:" + parambfls.jdField_b_of_type_Int + " fixtryCount:" + parambfls.c + " fastResend:" + parambfls.jdField_a_of_type_Boolean + " RemindSlowNet:" + parambfls.jdField_b_of_type_Boolean);
        bflt localbflt = new bflt();
        parambfls.jdField_a_of_type_Bflt = localbflt;
        localbflt.jdField_a_of_type_Bfls = parambfls;
        localbflt.jdField_a_of_type_Long = System.currentTimeMillis();
        localbflt.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable = new TroopFileProtoReqMgr.ProtoRequestRunnable[parambfls.jdField_b_of_type_Int];
        int i = 0;
        int j = k;
        if (i < parambfls.jdField_b_of_type_Int)
        {
          Object localObject = new TroopFileProtoReqMgr.ProtoRequestRunnable(this);
          localbflt.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i] = localObject;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_Bflt = localbflt;
          ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), bflu.class);
          localObject = ((TroopFileProtoReqMgr.ProtoRequestRunnable)localObject).jdField_a_of_type_MqqAppNewIntent;
          if (parambfls.jdField_a_of_type_AndroidOsBundle != null) {
            ((NewIntent)localObject).putExtras(parambfls.jdField_a_of_type_AndroidOsBundle);
          }
          ((NewIntent)localObject).putExtra("data", parambfls.jdField_a_of_type_ArrayOfByte);
          ((NewIntent)localObject).putExtra("cmd", parambfls.jdField_a_of_type_JavaLangString);
          ((NewIntent)localObject).putExtra("key_runnable_index", i);
          ((NewIntent)localObject).putExtra("fastresendenable", parambfls.jdField_a_of_type_Boolean);
          ((NewIntent)localObject).putExtra("remind_slown_network", parambfls.jdField_b_of_type_Boolean);
          i += 1;
          continue;
        }
        if (j < parambfls.c)
        {
          long l1 = parambfls.jdField_a_of_type_Int * j / parambfls.c;
          long l2 = parambfls.jdField_a_of_type_Int;
          long l3 = parambfls.d * j;
          localbflt.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j].jdField_a_of_type_Long = (l2 - l1 - l3);
          a(localbflt.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[j], l1);
          j += 1;
          continue;
        }
        localbflt.jdField_a_of_type_Int = parambfls.c;
        return;
      }
      finally {}
      bfmf.a("TroopFileProtoReqMgr", bfmf.jdField_a_of_type_Int, "sendProtoRequest req=null");
    }
  }
  
  void a(bflt parambflt)
  {
    parambflt.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < parambflt.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambflt.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(parambflt.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i]);
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
  
  boolean a(bflt parambflt)
  {
    int i = 0;
    while (i < parambflt.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable.length)
    {
      if ((!parambflt.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_b_of_type_Boolean) && ((parambflt.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_a_of_type_Boolean == true) || (parambflt.jdField_a_of_type_ArrayOfComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequestRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public void b(bfls parambfls)
  {
    if (parambfls != null) {}
    try
    {
      if (parambfls.jdField_a_of_type_Bflt != null)
      {
        bfmf.c("TroopFileProtoReqMgr", bfmf.jdField_a_of_type_Int, "cookie<" + parambfls.jdField_b_of_type_Long + "> cancelRequest.");
        a(parambfls.jdField_a_of_type_Bflt);
      }
      return;
    }
    finally
    {
      parambfls = finally;
      throw parambfls;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr
 * JD-Core Version:    0.7.0.1
 */