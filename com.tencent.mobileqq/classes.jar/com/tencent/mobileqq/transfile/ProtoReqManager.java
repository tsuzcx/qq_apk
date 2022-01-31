package com.tencent.mobileqq.transfile;

import ajvb;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import avbv;
import aytg;
import ayth;
import ayti;
import aytj;
import aytk;
import ayua;
import bbmj;
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
  implements ajvb
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ConcurrentHashMap<Intent, aytj> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public ProtoReqManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void a(Intent paramIntent, aytj paramaytj)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    paramaytj.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_b_of_type_Boolean = true;
    paramaytj.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  private void a(aytj paramaytj)
  {
    paramaytj.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < paramaytj.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramaytj.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramaytj.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i]);
      i += 1;
    }
  }
  
  private boolean a(ayti paramayti)
  {
    return ("PttStore.GroupPttUp".equals(paramayti.jdField_a_of_type_JavaLangString)) || ("PttStore.GroupPttDown".equals(paramayti.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500".equals(paramayti.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200".equals(paramayti.jdField_a_of_type_JavaLangString));
  }
  
  private boolean a(aytj paramaytj)
  {
    int i = 0;
    while (i < paramaytj.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      if ((!paramaytj.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_b_of_type_Boolean) && ((paramaytj.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_Boolean == true) || (paramaytj.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void b()
  {
    if (DeviceProfileManager.a().a() == 4) {
      ayua.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
  }
  
  private void c(ayti paramayti)
  {
    paramayti.jdField_a_of_type_Int = ayua.c();
    paramayti.jdField_b_of_type_Int = ayua.a();
    paramayti.c = ayua.b();
  }
  
  private void d(ayti paramayti)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      paramayti.jdField_a_of_type_Int = avbv.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      paramayti.jdField_b_of_type_Int = avbv.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      paramayti.c = avbv.c((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.ProtoReqManager", 2, "ptt config from dpc:" + paramayti.jdField_a_of_type_Int + paramayti.jdField_b_of_type_Int + paramayti.c);
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
      ayth localayth;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive." + paramFromServiceMsg);
        }
        if ((paramIntent == null) || (paramFromServiceMsg == null)) {
          break label538;
        }
        localObject = (aytj)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localObject == null) {
          break label523;
        }
        if (((aytj)localObject).jdField_a_of_type_Boolean)
        {
          localayti = null;
          paramIntent = null;
          paramFromServiceMsg = (FromServiceMsg)localObject;
          localObject = localayti;
          if (localObject != null) {
            ((ayth)localObject).a(paramFromServiceMsg, paramIntent);
          }
          return;
        }
        a(paramIntent, (aytj)localObject);
        localayti = ((aytj)localObject).jdField_a_of_type_Ayti;
        ((aytj)localObject).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
        ((aytj)localObject).jdField_a_of_type_Akaw.jdField_b_of_type_Int = ((aytj)localObject).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
        int i = paramFromServiceMsg.getResultCode();
        if (i == 1000)
        {
          a((aytj)localObject);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (localayti.jdField_a_of_type_Ayth != null)
          {
            i = paramFromServiceMsg.getWupBuffer().length - 4;
            paramIntent = new byte[i];
            bbmj.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
            paramFromServiceMsg.putWupBuffer(paramIntent);
            localayth = localayti.jdField_a_of_type_Ayth;
            paramFromServiceMsg = (FromServiceMsg)localObject;
            paramIntent = localayti;
            localObject = localayth;
          }
        }
        else
        {
          if (i == 2901)
          {
            long l1 = System.currentTimeMillis() - ((aytj)localObject).jdField_a_of_type_Long;
            if ((l1 < localayti.e) && (((aytj)localObject).jdField_a_of_type_Int < localayti.jdField_b_of_type_Int))
            {
              long l2 = localayti.jdField_a_of_type_Int;
              paramIntent = localObject.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[localObject.jdField_a_of_type_Int];
              ((aytj)localObject).jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              localayth = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localayti;
              localObject = localayth;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + ((aytj)localObject).jdField_a_of_type_Int);
            }
          }
          if (a((aytj)localObject))
          {
            a((aytj)localObject);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            if (i == 1013)
            {
              paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
              paramIntent.setObserver(new aytg(this, (aytj)localObject, localayti));
              paramIntent.putExtra("action", 2201);
              this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
              localayth = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localayti;
              localObject = localayth;
              continue;
            }
            if (localayti.jdField_a_of_type_Ayth != null)
            {
              localayth = localayti.jdField_a_of_type_Ayth;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localayti;
              localObject = localayth;
              continue;
            }
          }
        }
        localayth = null;
      }
      finally {}
      paramFromServiceMsg = (FromServiceMsg)localObject;
      paramIntent = localayti;
      localObject = localayth;
      continue;
      label523:
      ayti localayti = null;
      paramIntent = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localayti;
      continue;
      label538:
      paramIntent = null;
      localayti = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localayti;
    }
  }
  
  public void a(ayti paramayti)
  {
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "req:" + paramayti.jdField_a_of_type_JavaLangString);
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
        if (paramayti == null) {
          continue;
        }
        if ((paramayti.jdField_a_of_type_JavaLangString != null) && ((paramayti.jdField_a_of_type_JavaLangString.equals("ImgStore.GroupPicUp")) || (paramayti.jdField_a_of_type_JavaLangString.equals("LongConn.OffPicUp")))) {
          c(paramayti);
        }
        if ((paramayti.jdField_a_of_type_JavaLangString != null) && ((paramayti.jdField_a_of_type_JavaLangString.equals("PttStore.GroupPttUp")) || (paramayti.jdField_a_of_type_JavaLangString.equals("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500")))) {
          d(paramayti);
        }
        localObject1 = new aytj();
        paramayti.jdField_a_of_type_Aytj = ((aytj)localObject1);
        ((aytj)localObject1).jdField_a_of_type_Ayti = paramayti;
        ((aytj)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        ((aytj)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable = new ProtoReqManager.ProtoReqRunnable[paramayti.jdField_b_of_type_Int];
        byte[] arrayOfByte = paramayti.jdField_a_of_type_ArrayOfByte;
        Object localObject2 = ByteBuffer.allocate(arrayOfByte.length + 4);
        ((ByteBuffer)localObject2).putInt(arrayOfByte.length + 4).put(arrayOfByte);
        arrayOfByte = ((ByteBuffer)localObject2).array();
        i = 0;
        if (i >= paramayti.jdField_b_of_type_Int) {
          break label516;
        }
        localObject2 = new ProtoReqManager.ProtoReqRunnable(this);
        ((aytj)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i] = localObject2;
        ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_Aytj = ((aytj)localObject1);
        ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), aytk.class);
        localObject2 = ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent;
        ((NewIntent)localObject2).putExtra("key_body", arrayOfByte);
        ((NewIntent)localObject2).putExtra("key_cmd", paramayti.jdField_a_of_type_JavaLangString);
        ((NewIntent)localObject2).putExtra("key_runnable_index", i);
        ((NewIntent)localObject2).putExtra("key_fastresend", paramayti.jdField_a_of_type_Boolean);
        ((NewIntent)localObject2).putExtra("remind_slown_network", paramayti.jdField_b_of_type_Boolean);
        if ((!a(paramayti)) || (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) || (!avbv.d((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface))) {
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
      if (i < paramayti.c)
      {
        long l1 = paramayti.jdField_a_of_type_Int * i / paramayti.c;
        long l2 = paramayti.jdField_a_of_type_Int;
        long l3 = paramayti.d * i;
        localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_Long = (l2 - l1 - l3);
        a(localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i], l1);
        i += 1;
      }
      else
      {
        ((aytj)localObject1).jdField_a_of_type_Int = paramayti.c;
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
      ayua.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
    DeviceProfileManager.b(this);
  }
  
  public void b(ayti paramayti)
  {
    if (paramayti != null) {}
    try
    {
      if (paramayti.jdField_a_of_type_Aytj != null) {
        a(paramayti.jdField_a_of_type_Aytj);
      }
      return;
    }
    finally
    {
      paramayti = finally;
      throw paramayti;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoReqManager
 * JD-Core Version:    0.7.0.1
 */