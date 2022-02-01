package com.tencent.mobileqq.transfile;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import ankk;
import azti;
import bdxc;
import bdxd;
import bdxe;
import bdxf;
import bdxg;
import bdxr;
import bgva;
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
  implements ankk
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ConcurrentHashMap<Intent, bdxf> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public ProtoReqManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void a(Intent paramIntent, bdxf parambdxf)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    parambdxf.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_b_of_type_Boolean = true;
    parambdxf.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  private void a(bdxf parambdxf)
  {
    parambdxf.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < parambdxf.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambdxf.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(parambdxf.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i]);
      i += 1;
    }
  }
  
  private boolean a(bdxe parambdxe)
  {
    return ("PttStore.GroupPttUp".equals(parambdxe.jdField_a_of_type_JavaLangString)) || ("PttStore.GroupPttDown".equals(parambdxe.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500".equals(parambdxe.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200".equals(parambdxe.jdField_a_of_type_JavaLangString));
  }
  
  private boolean a(bdxf parambdxf)
  {
    int i = 0;
    while (i < parambdxf.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      if ((!parambdxf.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_b_of_type_Boolean) && ((parambdxf.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_Boolean == true) || (parambdxf.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void b()
  {
    if (DeviceProfileManager.a().a() == 4) {
      bdxr.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
  }
  
  private void c(bdxe parambdxe)
  {
    parambdxe.jdField_a_of_type_Int = bdxr.c();
    parambdxe.jdField_b_of_type_Int = bdxr.a();
    parambdxe.c = bdxr.b();
  }
  
  private void d(bdxe parambdxe)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      parambdxe.jdField_a_of_type_Int = azti.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      parambdxe.jdField_b_of_type_Int = azti.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      parambdxe.c = azti.c((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.ProtoReqManager", 2, "ptt config from dpc:" + parambdxe.jdField_a_of_type_Int + parambdxe.jdField_b_of_type_Int + parambdxe.c);
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
      bdxd localbdxd;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive." + paramFromServiceMsg);
        }
        if ((paramIntent == null) || (paramFromServiceMsg == null)) {
          break label538;
        }
        localObject = (bdxf)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localObject == null) {
          break label523;
        }
        if (((bdxf)localObject).jdField_a_of_type_Boolean)
        {
          localbdxe = null;
          paramIntent = null;
          paramFromServiceMsg = (FromServiceMsg)localObject;
          localObject = localbdxe;
          if (localObject != null) {
            ((bdxd)localObject).a(paramFromServiceMsg, paramIntent);
          }
          return;
        }
        a(paramIntent, (bdxf)localObject);
        localbdxe = ((bdxf)localObject).jdField_a_of_type_Bdxe;
        ((bdxf)localObject).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
        ((bdxf)localObject).jdField_a_of_type_Anqe.jdField_b_of_type_Int = ((bdxf)localObject).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
        int i = paramFromServiceMsg.getResultCode();
        if (i == 1000)
        {
          a((bdxf)localObject);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (localbdxe.jdField_a_of_type_Bdxd != null)
          {
            i = paramFromServiceMsg.getWupBuffer().length - 4;
            paramIntent = new byte[i];
            bgva.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
            paramFromServiceMsg.putWupBuffer(paramIntent);
            localbdxd = localbdxe.jdField_a_of_type_Bdxd;
            paramFromServiceMsg = (FromServiceMsg)localObject;
            paramIntent = localbdxe;
            localObject = localbdxd;
          }
        }
        else
        {
          if (i == 2901)
          {
            long l1 = System.currentTimeMillis() - ((bdxf)localObject).jdField_a_of_type_Long;
            if ((l1 < localbdxe.e) && (((bdxf)localObject).jdField_a_of_type_Int < localbdxe.jdField_b_of_type_Int))
            {
              long l2 = localbdxe.jdField_a_of_type_Int;
              paramIntent = localObject.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[localObject.jdField_a_of_type_Int];
              ((bdxf)localObject).jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              localbdxd = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localbdxe;
              localObject = localbdxd;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + ((bdxf)localObject).jdField_a_of_type_Int);
            }
          }
          if (a((bdxf)localObject))
          {
            a((bdxf)localObject);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            if (i == 1013)
            {
              paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
              paramIntent.setObserver(new bdxc(this, (bdxf)localObject, localbdxe));
              paramIntent.putExtra("action", 2201);
              this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
              localbdxd = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localbdxe;
              localObject = localbdxd;
              continue;
            }
            if (localbdxe.jdField_a_of_type_Bdxd != null)
            {
              localbdxd = localbdxe.jdField_a_of_type_Bdxd;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localbdxe;
              localObject = localbdxd;
              continue;
            }
          }
        }
        localbdxd = null;
      }
      finally {}
      paramFromServiceMsg = (FromServiceMsg)localObject;
      paramIntent = localbdxe;
      localObject = localbdxd;
      continue;
      label523:
      bdxe localbdxe = null;
      paramIntent = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localbdxe;
      continue;
      label538:
      paramIntent = null;
      localbdxe = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localbdxe;
    }
  }
  
  public void a(bdxe parambdxe)
  {
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "req:" + parambdxe.jdField_a_of_type_JavaLangString);
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
        if (parambdxe == null) {
          continue;
        }
        if ((parambdxe.jdField_a_of_type_JavaLangString != null) && ((parambdxe.jdField_a_of_type_JavaLangString.equals("ImgStore.GroupPicUp")) || (parambdxe.jdField_a_of_type_JavaLangString.equals("LongConn.OffPicUp")))) {
          c(parambdxe);
        }
        if ((parambdxe.jdField_a_of_type_JavaLangString != null) && ((parambdxe.jdField_a_of_type_JavaLangString.equals("PttStore.GroupPttUp")) || (parambdxe.jdField_a_of_type_JavaLangString.equals("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500")))) {
          d(parambdxe);
        }
        localObject1 = new bdxf();
        parambdxe.jdField_a_of_type_Bdxf = ((bdxf)localObject1);
        ((bdxf)localObject1).jdField_a_of_type_Bdxe = parambdxe;
        ((bdxf)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        ((bdxf)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable = new ProtoReqManager.ProtoReqRunnable[parambdxe.jdField_b_of_type_Int];
        byte[] arrayOfByte = parambdxe.jdField_a_of_type_ArrayOfByte;
        Object localObject2 = ByteBuffer.allocate(arrayOfByte.length + 4);
        ((ByteBuffer)localObject2).putInt(arrayOfByte.length + 4).put(arrayOfByte);
        arrayOfByte = ((ByteBuffer)localObject2).array();
        i = 0;
        if (i >= parambdxe.jdField_b_of_type_Int) {
          break label516;
        }
        localObject2 = new ProtoReqManager.ProtoReqRunnable(this);
        ((bdxf)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i] = localObject2;
        ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_Bdxf = ((bdxf)localObject1);
        ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), bdxg.class);
        localObject2 = ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent;
        ((NewIntent)localObject2).putExtra("key_body", arrayOfByte);
        ((NewIntent)localObject2).putExtra("key_cmd", parambdxe.jdField_a_of_type_JavaLangString);
        ((NewIntent)localObject2).putExtra("key_runnable_index", i);
        ((NewIntent)localObject2).putExtra("key_fastresend", parambdxe.jdField_a_of_type_Boolean);
        ((NewIntent)localObject2).putExtra("remind_slown_network", parambdxe.jdField_b_of_type_Boolean);
        if ((!a(parambdxe)) || (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) || (!azti.d((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface))) {
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
      if (i < parambdxe.c)
      {
        long l1 = parambdxe.jdField_a_of_type_Int * i / parambdxe.c;
        long l2 = parambdxe.jdField_a_of_type_Int;
        long l3 = parambdxe.d * i;
        localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_Long = (l2 - l1 - l3);
        a(localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i], l1);
        i += 1;
      }
      else
      {
        ((bdxf)localObject1).jdField_a_of_type_Int = parambdxe.c;
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
      bdxr.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
    DeviceProfileManager.b(this);
  }
  
  public void b(bdxe parambdxe)
  {
    if (parambdxe != null) {}
    try
    {
      if (parambdxe.jdField_a_of_type_Bdxf != null) {
        a(parambdxe.jdField_a_of_type_Bdxf);
      }
      return;
    }
    finally
    {
      parambdxe = finally;
      throw parambdxe;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoReqManager
 * JD-Core Version:    0.7.0.1
 */