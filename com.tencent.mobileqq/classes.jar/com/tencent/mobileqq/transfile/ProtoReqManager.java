package com.tencent.mobileqq.transfile;

import ajuz;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import avbx;
import ayti;
import aytj;
import aytk;
import aytl;
import aytm;
import ayuc;
import bbmx;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.BuiltInServlet;
import mqq.app.NewIntent;

public class ProtoReqManager
  implements ajuz
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ConcurrentHashMap<Intent, aytl> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public ProtoReqManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void a(Intent paramIntent, aytl paramaytl)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    paramaytl.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_b_of_type_Boolean = true;
    paramaytl.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  private void a(aytl paramaytl)
  {
    paramaytl.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < paramaytl.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramaytl.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramaytl.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i]);
      i += 1;
    }
  }
  
  private boolean a(aytk paramaytk)
  {
    return ("PttStore.GroupPttUp".equals(paramaytk.jdField_a_of_type_JavaLangString)) || ("PttStore.GroupPttDown".equals(paramaytk.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500".equals(paramaytk.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200".equals(paramaytk.jdField_a_of_type_JavaLangString));
  }
  
  private boolean a(aytl paramaytl)
  {
    int i = 0;
    while (i < paramaytl.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      if ((!paramaytl.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_b_of_type_Boolean) && ((paramaytl.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_Boolean == true) || (paramaytl.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void b()
  {
    if (DeviceProfileManager.a().a() == 4) {
      ayuc.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
  }
  
  private void c(aytk paramaytk)
  {
    paramaytk.jdField_a_of_type_Int = ayuc.c();
    paramaytk.jdField_b_of_type_Int = ayuc.a();
    paramaytk.c = ayuc.b();
  }
  
  private void d(aytk paramaytk)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      paramaytk.jdField_a_of_type_Int = avbx.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      paramaytk.jdField_b_of_type_Int = avbx.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      paramaytk.c = avbx.c((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.ProtoReqManager", 2, "ptt config from dpc:" + paramaytk.jdField_a_of_type_Int + paramaytk.jdField_b_of_type_Int + paramaytk.c);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.ProtoReqManager", 2, "onDestroy ");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
  
  public void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject = null;
    for (;;)
    {
      aytj localaytj;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive." + paramFromServiceMsg);
        }
        if ((paramIntent == null) || (paramFromServiceMsg == null)) {
          break label538;
        }
        localObject = (aytl)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localObject == null) {
          break label523;
        }
        if (((aytl)localObject).jdField_a_of_type_Boolean)
        {
          localaytk = null;
          paramIntent = null;
          paramFromServiceMsg = (FromServiceMsg)localObject;
          localObject = localaytk;
          if (localObject != null) {
            ((aytj)localObject).a(paramFromServiceMsg, paramIntent);
          }
          return;
        }
        a(paramIntent, (aytl)localObject);
        localaytk = ((aytl)localObject).jdField_a_of_type_Aytk;
        ((aytl)localObject).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
        ((aytl)localObject).jdField_a_of_type_Akau.jdField_b_of_type_Int = ((aytl)localObject).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
        int i = paramFromServiceMsg.getResultCode();
        if (i == 1000)
        {
          a((aytl)localObject);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (localaytk.jdField_a_of_type_Aytj != null)
          {
            i = paramFromServiceMsg.getWupBuffer().length - 4;
            paramIntent = new byte[i];
            bbmx.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
            paramFromServiceMsg.putWupBuffer(paramIntent);
            localaytj = localaytk.jdField_a_of_type_Aytj;
            paramFromServiceMsg = (FromServiceMsg)localObject;
            paramIntent = localaytk;
            localObject = localaytj;
          }
        }
        else
        {
          if (i == 2901)
          {
            long l1 = System.currentTimeMillis() - ((aytl)localObject).jdField_a_of_type_Long;
            if ((l1 < localaytk.e) && (((aytl)localObject).jdField_a_of_type_Int < localaytk.jdField_b_of_type_Int))
            {
              long l2 = localaytk.jdField_a_of_type_Int;
              paramIntent = localObject.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[localObject.jdField_a_of_type_Int];
              ((aytl)localObject).jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              localaytj = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localaytk;
              localObject = localaytj;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + ((aytl)localObject).jdField_a_of_type_Int);
            }
          }
          if (a((aytl)localObject))
          {
            a((aytl)localObject);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            if (i == 1013)
            {
              paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
              paramIntent.setObserver(new ayti(this, (aytl)localObject, localaytk));
              paramIntent.putExtra("action", 2201);
              this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
              localaytj = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localaytk;
              localObject = localaytj;
              continue;
            }
            if (localaytk.jdField_a_of_type_Aytj != null)
            {
              localaytj = localaytk.jdField_a_of_type_Aytj;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localaytk;
              localObject = localaytj;
              continue;
            }
          }
        }
        localaytj = null;
      }
      finally {}
      paramFromServiceMsg = (FromServiceMsg)localObject;
      paramIntent = localaytk;
      localObject = localaytj;
      continue;
      label523:
      aytk localaytk = null;
      paramIntent = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localaytk;
      continue;
      label538:
      paramIntent = null;
      localaytk = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localaytk;
    }
  }
  
  public void a(aytk paramaytk)
  {
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "req:" + paramaytk.jdField_a_of_type_JavaLangString);
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          b();
          this.jdField_a_of_type_Boolean = true;
        }
        localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        if (localObject1 == null) {
          return;
        }
        if (paramaytk == null) {
          continue;
        }
        if ((paramaytk.jdField_a_of_type_JavaLangString != null) && ((paramaytk.jdField_a_of_type_JavaLangString.equals("ImgStore.GroupPicUp")) || (paramaytk.jdField_a_of_type_JavaLangString.equals("LongConn.OffPicUp")))) {
          c(paramaytk);
        }
        if ((paramaytk.jdField_a_of_type_JavaLangString != null) && ((paramaytk.jdField_a_of_type_JavaLangString.equals("PttStore.GroupPttUp")) || (paramaytk.jdField_a_of_type_JavaLangString.equals("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500")))) {
          d(paramaytk);
        }
        localObject1 = new aytl();
        paramaytk.jdField_a_of_type_Aytl = ((aytl)localObject1);
        ((aytl)localObject1).jdField_a_of_type_Aytk = paramaytk;
        ((aytl)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        ((aytl)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable = new ProtoReqManager.ProtoReqRunnable[paramaytk.jdField_b_of_type_Int];
        byte[] arrayOfByte = paramaytk.jdField_a_of_type_ArrayOfByte;
        Object localObject2 = ByteBuffer.allocate(arrayOfByte.length + 4);
        ((ByteBuffer)localObject2).putInt(arrayOfByte.length + 4).put(arrayOfByte);
        arrayOfByte = ((ByteBuffer)localObject2).array();
        i = 0;
        if (i >= paramaytk.jdField_b_of_type_Int) {
          break label516;
        }
        localObject2 = new ProtoReqManager.ProtoReqRunnable(this);
        ((aytl)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i] = localObject2;
        ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_Aytl = ((aytl)localObject1);
        ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), aytm.class);
        localObject2 = ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent;
        ((NewIntent)localObject2).putExtra("key_body", arrayOfByte);
        ((NewIntent)localObject2).putExtra("key_cmd", paramaytk.jdField_a_of_type_JavaLangString);
        ((NewIntent)localObject2).putExtra("key_runnable_index", i);
        ((NewIntent)localObject2).putExtra("key_fastresend", paramaytk.jdField_a_of_type_Boolean);
        ((NewIntent)localObject2).putExtra("remind_slown_network", paramaytk.jdField_b_of_type_Boolean);
        if ((!a(paramaytk)) || (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) || (!avbx.d((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface))) {
          break label509;
        }
        ((NewIntent)localObject2).putExtra("quickSendEnable", true);
        ((NewIntent)localObject2).putExtra("quickSendStrategy", 1);
        if (!QLog.isColorLevel()) {
          break label509;
        }
        QLog.d("http_sideway", 2, "set");
      }
      finally {}
      if (i < paramaytk.c)
      {
        long l1 = paramaytk.jdField_a_of_type_Int * i / paramaytk.c;
        long l2 = paramaytk.jdField_a_of_type_Int;
        long l3 = paramaytk.d * i;
        localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_Long = (l2 - l1 - l3);
        a(localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i], l1);
        i += 1;
      }
      else
      {
        ((aytl)localObject1).jdField_a_of_type_Int = paramaytk.c;
        continue;
        label509:
        i += 1;
        continue;
        label516:
        i = 0;
      }
    }
  }
  
  void a(ProtoReqManager.ProtoReqRunnable paramProtoReqRunnable, long paramLong)
  {
    paramProtoReqRunnable.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramProtoReqRunnable, paramLong);
  }
  
  void a(NewIntent paramNewIntent)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramNewIntent);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ayuc.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
    DeviceProfileManager.b(this);
  }
  
  public void b(aytk paramaytk)
  {
    if (paramaytk != null) {}
    try
    {
      if (paramaytk.jdField_a_of_type_Aytl != null) {
        a(paramaytk.jdField_a_of_type_Aytl);
      }
      return;
    }
    finally
    {
      paramaytk = finally;
      throw paramaytk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoReqManager
 * JD-Core Version:    0.7.0.1
 */