package com.tencent.mobileqq.transfile;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import anwh;
import baly;
import bevv;
import bevw;
import bevx;
import bevy;
import bevz;
import bewk;
import bhvd;
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
  implements anwh
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  ConcurrentHashMap<Intent, bevy> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  
  public ProtoReqManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private void a(Intent paramIntent, bevy parambevy)
  {
    int i = paramIntent.getIntExtra("key_runnable_index", 0);
    parambevy.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_b_of_type_Boolean = true;
    parambevy.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_c_of_type_Long = System.currentTimeMillis();
  }
  
  private void a(bevy parambevy)
  {
    parambevy.jdField_a_of_type_Boolean = true;
    int i = 0;
    while (i < parambevy.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(parambevy.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_MqqAppNewIntent);
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(parambevy.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i]);
      i += 1;
    }
  }
  
  private boolean a(bevx parambevx)
  {
    return ("PttStore.GroupPttUp".equals(parambevx.jdField_a_of_type_JavaLangString)) || ("PttStore.GroupPttDown".equals(parambevx.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500".equals(parambevx.jdField_a_of_type_JavaLangString)) || ("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_DOWNLOAD-1200".equals(parambevx.jdField_a_of_type_JavaLangString));
  }
  
  private boolean a(bevy parambevy)
  {
    int i = 0;
    while (i < parambevy.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable.length)
    {
      if ((!parambevy.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_b_of_type_Boolean) && ((parambevy.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_Boolean == true) || (parambevy.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_c_of_type_Boolean == true))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private void b()
  {
    if (DeviceProfileManager.a().a() == 4) {
      bewk.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
  }
  
  private void c(bevx parambevx)
  {
    parambevx.jdField_a_of_type_Int = bewk.c();
    parambevx.jdField_b_of_type_Int = bewk.a();
    parambevx.c = bewk.b();
  }
  
  private void d(bevx parambevx)
  {
    if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))
    {
      parambevx.jdField_a_of_type_Int = baly.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      parambevx.jdField_b_of_type_Int = baly.b((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      parambevx.c = baly.c((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.ProtoReqManager", 2, "ptt config from dpc:" + parambevx.jdField_a_of_type_Int + parambevx.jdField_b_of_type_Int + parambevx.c);
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
      bevw localbevw;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive." + paramFromServiceMsg);
        }
        if ((paramIntent == null) || (paramFromServiceMsg == null)) {
          break label538;
        }
        localObject = (bevy)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramIntent);
        if (localObject == null) {
          break label523;
        }
        if (((bevy)localObject).jdField_a_of_type_Boolean)
        {
          localbevx = null;
          paramIntent = null;
          paramFromServiceMsg = (FromServiceMsg)localObject;
          localObject = localbevx;
          if (localObject != null) {
            ((bevw)localObject).a(paramFromServiceMsg, paramIntent);
          }
          return;
        }
        a(paramIntent, (bevy)localObject);
        localbevx = ((bevy)localObject).jdField_a_of_type_Bevx;
        ((bevy)localObject).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg = paramFromServiceMsg;
        ((bevy)localObject).jdField_a_of_type_Aock.jdField_b_of_type_Int = ((bevy)localObject).jdField_a_of_type_ComTencentQphoneBaseRemoteFromServiceMsg.getResultCode();
        int i = paramFromServiceMsg.getResultCode();
        if (i == 1000)
        {
          a((bevy)localObject);
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
          if (localbevx.jdField_a_of_type_Bevw != null)
          {
            i = paramFromServiceMsg.getWupBuffer().length - 4;
            paramIntent = new byte[i];
            bhvd.a(paramIntent, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
            paramFromServiceMsg.putWupBuffer(paramIntent);
            localbevw = localbevx.jdField_a_of_type_Bevw;
            paramFromServiceMsg = (FromServiceMsg)localObject;
            paramIntent = localbevx;
            localObject = localbevw;
          }
        }
        else
        {
          if (i == 2901)
          {
            long l1 = System.currentTimeMillis() - ((bevy)localObject).jdField_a_of_type_Long;
            if ((l1 < localbevx.e) && (((bevy)localObject).jdField_a_of_type_Int < localbevx.jdField_b_of_type_Int))
            {
              long l2 = localbevx.jdField_a_of_type_Int;
              paramIntent = localObject.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[localObject.jdField_a_of_type_Int];
              ((bevy)localObject).jdField_a_of_type_Int += 1;
              paramIntent.jdField_a_of_type_Long = (l2 - l1 - 5000L);
              a(paramIntent, 0L);
              localbevw = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localbevx;
              localObject = localbevw;
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.ProtoReqManager", 2, "onReceive found 2901 but do not retry : elapse:" + l1 + " index:" + ((bevy)localObject).jdField_a_of_type_Int);
            }
          }
          if (a((bevy)localObject))
          {
            a((bevy)localObject);
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramIntent);
            if (i == 1013)
            {
              paramIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), BuiltInServlet.class);
              paramIntent.setObserver(new bevv(this, (bevy)localObject, localbevx));
              paramIntent.putExtra("action", 2201);
              this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet(paramIntent);
              localbevw = null;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localbevx;
              localObject = localbevw;
              continue;
            }
            if (localbevx.jdField_a_of_type_Bevw != null)
            {
              localbevw = localbevx.jdField_a_of_type_Bevw;
              paramFromServiceMsg = (FromServiceMsg)localObject;
              paramIntent = localbevx;
              localObject = localbevw;
              continue;
            }
          }
        }
        localbevw = null;
      }
      finally {}
      paramFromServiceMsg = (FromServiceMsg)localObject;
      paramIntent = localbevx;
      localObject = localbevw;
      continue;
      label523:
      bevx localbevx = null;
      paramIntent = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localbevx;
      continue;
      label538:
      paramIntent = null;
      localbevx = null;
      paramFromServiceMsg = (FromServiceMsg)localObject;
      localObject = localbevx;
    }
  }
  
  public void a(bevx parambevx)
  {
    for (;;)
    {
      Object localObject1;
      int i;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.ProtoReqManager", 2, "req:" + parambevx.jdField_a_of_type_JavaLangString);
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
        if (parambevx == null) {
          continue;
        }
        if ((parambevx.jdField_a_of_type_JavaLangString != null) && ((parambevx.jdField_a_of_type_JavaLangString.equals("ImgStore.GroupPicUp")) || (parambevx.jdField_a_of_type_JavaLangString.equals("LongConn.OffPicUp")))) {
          c(parambevx);
        }
        if ((parambevx.jdField_a_of_type_JavaLangString != null) && ((parambevx.jdField_a_of_type_JavaLangString.equals("PttStore.GroupPttUp")) || (parambevx.jdField_a_of_type_JavaLangString.equals("PttCenterSvr.pb_pttCenter_CMD_REQ_APPLY_UPLOAD-500")))) {
          d(parambevx);
        }
        localObject1 = new bevy();
        parambevx.jdField_a_of_type_Bevy = ((bevy)localObject1);
        ((bevy)localObject1).jdField_a_of_type_Bevx = parambevx;
        ((bevy)localObject1).jdField_a_of_type_Long = System.currentTimeMillis();
        ((bevy)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable = new ProtoReqManager.ProtoReqRunnable[parambevx.jdField_b_of_type_Int];
        byte[] arrayOfByte = parambevx.jdField_a_of_type_ArrayOfByte;
        Object localObject2 = ByteBuffer.allocate(arrayOfByte.length + 4);
        ((ByteBuffer)localObject2).putInt(arrayOfByte.length + 4).put(arrayOfByte);
        arrayOfByte = ((ByteBuffer)localObject2).array();
        i = 0;
        if (i >= parambevx.jdField_b_of_type_Int) {
          break label516;
        }
        localObject2 = new ProtoReqManager.ProtoReqRunnable(this);
        ((bevy)localObject1).jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i] = localObject2;
        ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_Bevy = ((bevy)localObject1);
        ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp(), bevz.class);
        localObject2 = ((ProtoReqManager.ProtoReqRunnable)localObject2).jdField_a_of_type_MqqAppNewIntent;
        ((NewIntent)localObject2).putExtra("key_body", arrayOfByte);
        ((NewIntent)localObject2).putExtra("key_cmd", parambevx.jdField_a_of_type_JavaLangString);
        ((NewIntent)localObject2).putExtra("key_runnable_index", i);
        ((NewIntent)localObject2).putExtra("key_fastresend", parambevx.jdField_a_of_type_Boolean);
        ((NewIntent)localObject2).putExtra("remind_slown_network", parambevx.jdField_b_of_type_Boolean);
        if ((!a(parambevx)) || (!(this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) || (!baly.d((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface))) {
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
      if (i < parambevx.c)
      {
        long l1 = parambevx.jdField_a_of_type_Int * i / parambevx.c;
        long l2 = parambevx.jdField_a_of_type_Int;
        long l3 = parambevx.d * i;
        localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i].jdField_a_of_type_Long = (l2 - l1 - l3);
        a(localObject1.jdField_a_of_type_ArrayOfComTencentMobileqqTransfileProtoReqManager$ProtoReqRunnable[i], l1);
        i += 1;
      }
      else
      {
        ((bevy)localObject1).jdField_a_of_type_Int = parambevx.c;
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
      bewk.a(DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.RichProReqCfg.name()));
    }
    DeviceProfileManager.b(this);
  }
  
  public void b(bevx parambevx)
  {
    if (parambevx != null) {}
    try
    {
      if (parambevx.jdField_a_of_type_Bevy != null) {
        a(parambevx.jdField_a_of_type_Bevy);
      }
      return;
    }
    finally
    {
      parambevx = finally;
      throw parambevx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ProtoReqManager
 * JD-Core Version:    0.7.0.1
 */