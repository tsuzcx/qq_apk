package com.tencent.mobileqq.transfile;

import alrb;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import awxt;
import bavo;
import bavp;
import bavq;
import bavr;
import bavs;
import bawk;
import bdqa;
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
  implements alrb
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ConcurrentHashMap<Intent, bavr> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public ProtoReqManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void a(Intent paramIntent, bavr parambavr)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    parambavr.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_b_of_type_Boolean = true;
    parambavr.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  private void a(bavr parambavr)
  {
    parambavr.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < parambavr.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambavr.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(parambavr.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i]);
      i += 1;
    }
  }
  
  private boolean a(bavq parambavq)
  {
    return ("PttStore.GroupPttUp".equals(parambavq.jdField_a_of_type_JavaLangString)) || ("PttStore.GroupPttDown".equals(parambavq.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500".equals(parambavq.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200".equals(parambavq.jdField_a_of_type_JavaLangString));
  }
  
  private boolean a(bavr parambavr)
  {
    int i = 0;
    while (i < parambavr.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      if ((!parambavr.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_b_of_type_Boolean) && ((parambavr.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_Boolean == true) || (parambavr.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void b()
  {
    if (DeviceProfileManager.a().a() == 4) {
      bawk.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
  }
  
  private void c(bavq parambavq)
  {
    parambavq.jdField_a_of_type_Int = bawk.c();
    parambavq.jdField_b_of_type_Int = bawk.a();
    parambavq.c = bawk.b();
  }
  
  private void d(bavq parambavq)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      parambavq.jdField_a_of_type_Int = awxt.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      parambavq.jdField_b_of_type_Int = awxt.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      parambavq.c = awxt.c((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.ProtoReqManager", 2, "ptt config from dpc:" + parambavq.jdField_a_of_type_Int + parambavq.jdField_b_of_type_Int + parambavq.c);
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
      bavp localbavp;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive." + paramFromServiceMsg);
        }
        if ((paramIntent == null) || (paramFromServiceMsg == null)) {
          break label538;
        }
        localObject = (bavr)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localObject == null) {
          break label523;
        }
        if (((bavr)localObject).jdField_a_of_type_Boolean)
        {
          localbavq = null;
          paramIntent = null;
          paramFromServiceMsg = (FromServiceMsg)localObject;
          localObject = localbavq;
          if (localObject != null) {
            ((bavp)localObject).a(paramFromServiceMsg, paramIntent);
          }
          return;
        }
        a(paramIntent, (bavr)localObject);
        localbavq = ((bavr)localObject).jdField_a_of_type_Bavq;
        ((bavr)localObject).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
        ((bavr)localObject).jdField_a_of_type_Alwy.jdField_b_of_type_Int = ((bavr)localObject).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
        int i = paramFromServiceMsg.getResultCode();
        if (i == 1000)
        {
          a((bavr)localObject);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (localbavq.jdField_a_of_type_Bavp != null)
          {
            i = paramFromServiceMsg.getWupBuffer().length - 4;
            paramIntent = new byte[i];
            bdqa.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
            paramFromServiceMsg.putWupBuffer(paramIntent);
            localbavp = localbavq.jdField_a_of_type_Bavp;
            paramFromServiceMsg = (FromServiceMsg)localObject;
            paramIntent = localbavq;
            localObject = localbavp;
          }
        }
        else
        {
          if (i == 2901)
          {
            long l1 = System.currentTimeMillis() - ((bavr)localObject).jdField_a_of_type_Long;
            if ((l1 < localbavq.e) && (((bavr)localObject).jdField_a_of_type_Int < localbavq.jdField_b_of_type_Int))
            {
              long l2 = localbavq.jdField_a_of_type_Int;
              paramIntent = localObject.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[localObject.jdField_a_of_type_Int];
              ((bavr)localObject).jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              localbavp = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localbavq;
              localObject = localbavp;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + ((bavr)localObject).jdField_a_of_type_Int);
            }
          }
          if (a((bavr)localObject))
          {
            a((bavr)localObject);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            if (i == 1013)
            {
              paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
              paramIntent.setObserver(new bavo(this, (bavr)localObject, localbavq));
              paramIntent.putExtra("action", 2201);
              this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
              localbavp = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localbavq;
              localObject = localbavp;
              continue;
            }
            if (localbavq.jdField_a_of_type_Bavp != null)
            {
              localbavp = localbavq.jdField_a_of_type_Bavp;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localbavq;
              localObject = localbavp;
              continue;
            }
          }
        }
        localbavp = null;
      }
      finally {}
      paramFromServiceMsg = (FromServiceMsg)localObject;
      paramIntent = localbavq;
      localObject = localbavp;
      continue;
      label523:
      bavq localbavq = null;
      paramIntent = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localbavq;
      continue;
      label538:
      paramIntent = null;
      localbavq = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localbavq;
    }
  }
  
  public void a(bavq parambavq)
  {
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "req:" + parambavq.jdField_a_of_type_JavaLangString);
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
        if (parambavq == null) {
          continue;
        }
        if ((parambavq.jdField_a_of_type_JavaLangString != null) && ((parambavq.jdField_a_of_type_JavaLangString.equals("ImgStore.GroupPicUp")) || (parambavq.jdField_a_of_type_JavaLangString.equals("LongConn.OffPicUp")))) {
          c(parambavq);
        }
        if ((parambavq.jdField_a_of_type_JavaLangString != null) && ((parambavq.jdField_a_of_type_JavaLangString.equals("PttStore.GroupPttUp")) || (parambavq.jdField_a_of_type_JavaLangString.equals("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500")))) {
          d(parambavq);
        }
        localObject1 = new bavr();
        parambavq.jdField_a_of_type_Bavr = ((bavr)localObject1);
        ((bavr)localObject1).jdField_a_of_type_Bavq = parambavq;
        ((bavr)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        ((bavr)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable = new ProtoReqManager.ProtoReqRunnable[parambavq.jdField_b_of_type_Int];
        byte[] arrayOfByte = parambavq.jdField_a_of_type_ArrayOfByte;
        Object localObject2 = ByteBuffer.allocate(arrayOfByte.length + 4);
        ((ByteBuffer)localObject2).putInt(arrayOfByte.length + 4).put(arrayOfByte);
        arrayOfByte = ((ByteBuffer)localObject2).array();
        i = 0;
        if (i >= parambavq.jdField_b_of_type_Int) {
          break label516;
        }
        localObject2 = new ProtoReqManager.ProtoReqRunnable(this);
        ((bavr)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i] = localObject2;
        ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_Bavr = ((bavr)localObject1);
        ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), bavs.class);
        localObject2 = ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent;
        ((NewIntent)localObject2).putExtra("key_body", arrayOfByte);
        ((NewIntent)localObject2).putExtra("key_cmd", parambavq.jdField_a_of_type_JavaLangString);
        ((NewIntent)localObject2).putExtra("key_runnable_index", i);
        ((NewIntent)localObject2).putExtra("key_fastresend", parambavq.jdField_a_of_type_Boolean);
        ((NewIntent)localObject2).putExtra("remind_slown_network", parambavq.jdField_b_of_type_Boolean);
        if ((!a(parambavq)) || (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) || (!awxt.d((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface))) {
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
      if (i < parambavq.c)
      {
        long l1 = parambavq.jdField_a_of_type_Int * i / parambavq.c;
        long l2 = parambavq.jdField_a_of_type_Int;
        long l3 = parambavq.d * i;
        localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_Long = (l2 - l1 - l3);
        a(localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i], l1);
        i += 1;
      }
      else
      {
        ((bavr)localObject1).jdField_a_of_type_Int = parambavq.c;
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
      bawk.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
    DeviceProfileManager.b(this);
  }
  
  public void b(bavq parambavq)
  {
    if (parambavq != null) {}
    try
    {
      if (parambavq.jdField_a_of_type_Bavr != null) {
        a(parambavq.jdField_a_of_type_Bavr);
      }
      return;
    }
    finally
    {
      parambavq = finally;
      throw parambavq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoReqManager
 * JD-Core Version:    0.7.0.1
 */