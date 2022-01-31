package com.tencent.mobileqq.transfile;

import almm;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import awtk;
import barf;
import barg;
import barh;
import bari;
import barj;
import basb;
import bdlr;
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
  implements almm
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ConcurrentHashMap<Intent, bari> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public ProtoReqManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void a(Intent paramIntent, bari parambari)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    parambari.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_b_of_type_Boolean = true;
    parambari.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  private void a(bari parambari)
  {
    parambari.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < parambari.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambari.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(parambari.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i]);
      i += 1;
    }
  }
  
  private boolean a(barh parambarh)
  {
    return ("PttStore.GroupPttUp".equals(parambarh.jdField_a_of_type_JavaLangString)) || ("PttStore.GroupPttDown".equals(parambarh.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500".equals(parambarh.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200".equals(parambarh.jdField_a_of_type_JavaLangString));
  }
  
  private boolean a(bari parambari)
  {
    int i = 0;
    while (i < parambari.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      if ((!parambari.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_b_of_type_Boolean) && ((parambari.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_Boolean == true) || (parambari.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void b()
  {
    if (DeviceProfileManager.a().a() == 4) {
      basb.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
  }
  
  private void c(barh parambarh)
  {
    parambarh.jdField_a_of_type_Int = basb.c();
    parambarh.jdField_b_of_type_Int = basb.a();
    parambarh.c = basb.b();
  }
  
  private void d(barh parambarh)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      parambarh.jdField_a_of_type_Int = awtk.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      parambarh.jdField_b_of_type_Int = awtk.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      parambarh.c = awtk.c((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.ProtoReqManager", 2, "ptt config from dpc:" + parambarh.jdField_a_of_type_Int + parambarh.jdField_b_of_type_Int + parambarh.c);
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
      barg localbarg;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive." + paramFromServiceMsg);
        }
        if ((paramIntent == null) || (paramFromServiceMsg == null)) {
          break label538;
        }
        localObject = (bari)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localObject == null) {
          break label523;
        }
        if (((bari)localObject).jdField_a_of_type_Boolean)
        {
          localbarh = null;
          paramIntent = null;
          paramFromServiceMsg = (FromServiceMsg)localObject;
          localObject = localbarh;
          if (localObject != null) {
            ((barg)localObject).a(paramFromServiceMsg, paramIntent);
          }
          return;
        }
        a(paramIntent, (bari)localObject);
        localbarh = ((bari)localObject).jdField_a_of_type_Barh;
        ((bari)localObject).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
        ((bari)localObject).jdField_a_of_type_Alsj.jdField_b_of_type_Int = ((bari)localObject).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
        int i = paramFromServiceMsg.getResultCode();
        if (i == 1000)
        {
          a((bari)localObject);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (localbarh.jdField_a_of_type_Barg != null)
          {
            i = paramFromServiceMsg.getWupBuffer().length - 4;
            paramIntent = new byte[i];
            bdlr.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
            paramFromServiceMsg.putWupBuffer(paramIntent);
            localbarg = localbarh.jdField_a_of_type_Barg;
            paramFromServiceMsg = (FromServiceMsg)localObject;
            paramIntent = localbarh;
            localObject = localbarg;
          }
        }
        else
        {
          if (i == 2901)
          {
            long l1 = System.currentTimeMillis() - ((bari)localObject).jdField_a_of_type_Long;
            if ((l1 < localbarh.e) && (((bari)localObject).jdField_a_of_type_Int < localbarh.jdField_b_of_type_Int))
            {
              long l2 = localbarh.jdField_a_of_type_Int;
              paramIntent = localObject.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[localObject.jdField_a_of_type_Int];
              ((bari)localObject).jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              localbarg = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localbarh;
              localObject = localbarg;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + ((bari)localObject).jdField_a_of_type_Int);
            }
          }
          if (a((bari)localObject))
          {
            a((bari)localObject);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            if (i == 1013)
            {
              paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
              paramIntent.setObserver(new barf(this, (bari)localObject, localbarh));
              paramIntent.putExtra("action", 2201);
              this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
              localbarg = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localbarh;
              localObject = localbarg;
              continue;
            }
            if (localbarh.jdField_a_of_type_Barg != null)
            {
              localbarg = localbarh.jdField_a_of_type_Barg;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localbarh;
              localObject = localbarg;
              continue;
            }
          }
        }
        localbarg = null;
      }
      finally {}
      paramFromServiceMsg = (FromServiceMsg)localObject;
      paramIntent = localbarh;
      localObject = localbarg;
      continue;
      label523:
      barh localbarh = null;
      paramIntent = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localbarh;
      continue;
      label538:
      paramIntent = null;
      localbarh = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localbarh;
    }
  }
  
  public void a(barh parambarh)
  {
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "req:" + parambarh.jdField_a_of_type_JavaLangString);
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
        if (parambarh == null) {
          continue;
        }
        if ((parambarh.jdField_a_of_type_JavaLangString != null) && ((parambarh.jdField_a_of_type_JavaLangString.equals("ImgStore.GroupPicUp")) || (parambarh.jdField_a_of_type_JavaLangString.equals("LongConn.OffPicUp")))) {
          c(parambarh);
        }
        if ((parambarh.jdField_a_of_type_JavaLangString != null) && ((parambarh.jdField_a_of_type_JavaLangString.equals("PttStore.GroupPttUp")) || (parambarh.jdField_a_of_type_JavaLangString.equals("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500")))) {
          d(parambarh);
        }
        localObject1 = new bari();
        parambarh.jdField_a_of_type_Bari = ((bari)localObject1);
        ((bari)localObject1).jdField_a_of_type_Barh = parambarh;
        ((bari)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        ((bari)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable = new ProtoReqManager.ProtoReqRunnable[parambarh.jdField_b_of_type_Int];
        byte[] arrayOfByte = parambarh.jdField_a_of_type_ArrayOfByte;
        Object localObject2 = ByteBuffer.allocate(arrayOfByte.length + 4);
        ((ByteBuffer)localObject2).putInt(arrayOfByte.length + 4).put(arrayOfByte);
        arrayOfByte = ((ByteBuffer)localObject2).array();
        i = 0;
        if (i >= parambarh.jdField_b_of_type_Int) {
          break label516;
        }
        localObject2 = new ProtoReqManager.ProtoReqRunnable(this);
        ((bari)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i] = localObject2;
        ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_Bari = ((bari)localObject1);
        ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), barj.class);
        localObject2 = ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent;
        ((NewIntent)localObject2).putExtra("key_body", arrayOfByte);
        ((NewIntent)localObject2).putExtra("key_cmd", parambarh.jdField_a_of_type_JavaLangString);
        ((NewIntent)localObject2).putExtra("key_runnable_index", i);
        ((NewIntent)localObject2).putExtra("key_fastresend", parambarh.jdField_a_of_type_Boolean);
        ((NewIntent)localObject2).putExtra("remind_slown_network", parambarh.jdField_b_of_type_Boolean);
        if ((!a(parambarh)) || (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) || (!awtk.d((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface))) {
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
      if (i < parambarh.c)
      {
        long l1 = parambarh.jdField_a_of_type_Int * i / parambarh.c;
        long l2 = parambarh.jdField_a_of_type_Int;
        long l3 = parambarh.d * i;
        localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_Long = (l2 - l1 - l3);
        a(localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i], l1);
        i += 1;
      }
      else
      {
        ((bari)localObject1).jdField_a_of_type_Int = parambarh.c;
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
      basb.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
    DeviceProfileManager.b(this);
  }
  
  public void b(barh parambarh)
  {
    if (parambarh != null) {}
    try
    {
      if (parambarh.jdField_a_of_type_Bari != null) {
        a(parambarh.jdField_a_of_type_Bari);
      }
      return;
    }
    finally
    {
      parambarh = finally;
      throw parambarh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoReqManager
 * JD-Core Version:    0.7.0.1
 */