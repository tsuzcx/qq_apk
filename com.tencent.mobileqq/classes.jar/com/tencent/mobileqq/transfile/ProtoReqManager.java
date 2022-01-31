package com.tencent.mobileqq.transfile;

import ajgy;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import aucp;
import axsz;
import axta;
import axtb;
import axtc;
import axtd;
import axtt;
import bakz;
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
  implements ajgy
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ConcurrentHashMap<Intent, axtc> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public ProtoReqManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void a(Intent paramIntent, axtc paramaxtc)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    paramaxtc.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_b_of_type_Boolean = true;
    paramaxtc.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  private void a(axtc paramaxtc)
  {
    paramaxtc.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < paramaxtc.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramaxtc.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(paramaxtc.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i]);
      i += 1;
    }
  }
  
  private boolean a(axtb paramaxtb)
  {
    return ("PttStore.GroupPttUp".equals(paramaxtb.jdField_a_of_type_JavaLangString)) || ("PttStore.GroupPttDown".equals(paramaxtb.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500".equals(paramaxtb.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200".equals(paramaxtb.jdField_a_of_type_JavaLangString));
  }
  
  private boolean a(axtc paramaxtc)
  {
    int i = 0;
    while (i < paramaxtc.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      if ((!paramaxtc.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_b_of_type_Boolean) && ((paramaxtc.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_Boolean == true) || (paramaxtc.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void b()
  {
    if (DeviceProfileManager.a().a() == 4) {
      axtt.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
  }
  
  private void c(axtb paramaxtb)
  {
    paramaxtb.jdField_a_of_type_Int = axtt.c();
    paramaxtb.jdField_b_of_type_Int = axtt.a();
    paramaxtb.c = axtt.b();
  }
  
  private void d(axtb paramaxtb)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      paramaxtb.jdField_a_of_type_Int = aucp.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      paramaxtb.jdField_b_of_type_Int = aucp.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      paramaxtb.c = aucp.c((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.ProtoReqManager", 2, "ptt config from dpc:" + paramaxtb.jdField_a_of_type_Int + paramaxtb.jdField_b_of_type_Int + paramaxtb.c);
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
      axta localaxta;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive." + paramFromServiceMsg);
        }
        if ((paramIntent == null) || (paramFromServiceMsg == null)) {
          break label538;
        }
        localObject = (axtc)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localObject == null) {
          break label523;
        }
        if (((axtc)localObject).jdField_a_of_type_Boolean)
        {
          localaxtb = null;
          paramIntent = null;
          paramFromServiceMsg = (FromServiceMsg)localObject;
          localObject = localaxtb;
          if (localObject != null) {
            ((axta)localObject).a(paramFromServiceMsg, paramIntent);
          }
          return;
        }
        a(paramIntent, (axtc)localObject);
        localaxtb = ((axtc)localObject).jdField_a_of_type_Axtb;
        ((axtc)localObject).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
        ((axtc)localObject).jdField_a_of_type_Ajmn.jdField_b_of_type_Int = ((axtc)localObject).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
        int i = paramFromServiceMsg.getResultCode();
        if (i == 1000)
        {
          a((axtc)localObject);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (localaxtb.jdField_a_of_type_Axta != null)
          {
            i = paramFromServiceMsg.getWupBuffer().length - 4;
            paramIntent = new byte[i];
            bakz.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
            paramFromServiceMsg.putWupBuffer(paramIntent);
            localaxta = localaxtb.jdField_a_of_type_Axta;
            paramFromServiceMsg = (FromServiceMsg)localObject;
            paramIntent = localaxtb;
            localObject = localaxta;
          }
        }
        else
        {
          if (i == 2901)
          {
            long l1 = System.currentTimeMillis() - ((axtc)localObject).jdField_a_of_type_Long;
            if ((l1 < localaxtb.e) && (((axtc)localObject).jdField_a_of_type_Int < localaxtb.jdField_b_of_type_Int))
            {
              long l2 = localaxtb.jdField_a_of_type_Int;
              paramIntent = localObject.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[localObject.jdField_a_of_type_Int];
              ((axtc)localObject).jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              localaxta = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localaxtb;
              localObject = localaxta;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + ((axtc)localObject).jdField_a_of_type_Int);
            }
          }
          if (a((axtc)localObject))
          {
            a((axtc)localObject);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            if (i == 1013)
            {
              paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
              paramIntent.setObserver(new axsz(this, (axtc)localObject, localaxtb));
              paramIntent.putExtra("action", 2201);
              this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
              localaxta = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localaxtb;
              localObject = localaxta;
              continue;
            }
            if (localaxtb.jdField_a_of_type_Axta != null)
            {
              localaxta = localaxtb.jdField_a_of_type_Axta;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localaxtb;
              localObject = localaxta;
              continue;
            }
          }
        }
        localaxta = null;
      }
      finally {}
      paramFromServiceMsg = (FromServiceMsg)localObject;
      paramIntent = localaxtb;
      localObject = localaxta;
      continue;
      label523:
      axtb localaxtb = null;
      paramIntent = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localaxtb;
      continue;
      label538:
      paramIntent = null;
      localaxtb = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localaxtb;
    }
  }
  
  public void a(axtb paramaxtb)
  {
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "req:" + paramaxtb.jdField_a_of_type_JavaLangString);
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
        if (paramaxtb == null) {
          continue;
        }
        if ((paramaxtb.jdField_a_of_type_JavaLangString != null) && ((paramaxtb.jdField_a_of_type_JavaLangString.equals("ImgStore.GroupPicUp")) || (paramaxtb.jdField_a_of_type_JavaLangString.equals("LongConn.OffPicUp")))) {
          c(paramaxtb);
        }
        if ((paramaxtb.jdField_a_of_type_JavaLangString != null) && ((paramaxtb.jdField_a_of_type_JavaLangString.equals("PttStore.GroupPttUp")) || (paramaxtb.jdField_a_of_type_JavaLangString.equals("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500")))) {
          d(paramaxtb);
        }
        localObject1 = new axtc();
        paramaxtb.jdField_a_of_type_Axtc = ((axtc)localObject1);
        ((axtc)localObject1).jdField_a_of_type_Axtb = paramaxtb;
        ((axtc)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        ((axtc)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable = new ProtoReqManager.ProtoReqRunnable[paramaxtb.jdField_b_of_type_Int];
        byte[] arrayOfByte = paramaxtb.jdField_a_of_type_ArrayOfByte;
        Object localObject2 = ByteBuffer.allocate(arrayOfByte.length + 4);
        ((ByteBuffer)localObject2).putInt(arrayOfByte.length + 4).put(arrayOfByte);
        arrayOfByte = ((ByteBuffer)localObject2).array();
        i = 0;
        if (i >= paramaxtb.jdField_b_of_type_Int) {
          break label516;
        }
        localObject2 = new ProtoReqManager.ProtoReqRunnable(this);
        ((axtc)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i] = localObject2;
        ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_Axtc = ((axtc)localObject1);
        ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), axtd.class);
        localObject2 = ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent;
        ((NewIntent)localObject2).putExtra("key_body", arrayOfByte);
        ((NewIntent)localObject2).putExtra("key_cmd", paramaxtb.jdField_a_of_type_JavaLangString);
        ((NewIntent)localObject2).putExtra("key_runnable_index", i);
        ((NewIntent)localObject2).putExtra("key_fastresend", paramaxtb.jdField_a_of_type_Boolean);
        ((NewIntent)localObject2).putExtra("remind_slown_network", paramaxtb.jdField_b_of_type_Boolean);
        if ((!a(paramaxtb)) || (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) || (!aucp.d((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface))) {
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
      if (i < paramaxtb.c)
      {
        long l1 = paramaxtb.jdField_a_of_type_Int * i / paramaxtb.c;
        long l2 = paramaxtb.jdField_a_of_type_Int;
        long l3 = paramaxtb.d * i;
        localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_Long = (l2 - l1 - l3);
        a(localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i], l1);
        i += 1;
      }
      else
      {
        ((axtc)localObject1).jdField_a_of_type_Int = paramaxtb.c;
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
      axtt.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
    DeviceProfileManager.b(this);
  }
  
  public void b(axtb paramaxtb)
  {
    if (paramaxtb != null) {}
    try
    {
      if (paramaxtb.jdField_a_of_type_Axtc != null) {
        a(paramaxtb.jdField_a_of_type_Axtc);
      }
      return;
    }
    finally
    {
      paramaxtb = finally;
      throw paramaxtb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoReqManager
 * JD-Core Version:    0.7.0.1
 */