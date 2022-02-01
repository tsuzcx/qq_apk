package com.tencent.qqprotect.qsec;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.QSecPushSeriveMsg.QSecPushSeriveBody;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqprotect.common.QPMiscUtils;
import com.tencent.qqprotect.singleupdate.QPUpdateManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import mqq.app.MobileQQ;

public class QSecPushServiceMgr
{
  private int jdField_a_of_type_Int = 0;
  private QSecCbMgr jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr = null;
  private QSecLibMgr jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr = null;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private HashMap<Integer, List<QSecPushServiceMgr.PushCmdData>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public QSecPushServiceMgr(QSecLibMgr paramQSecLibMgr, QSecCbMgr paramQSecCbMgr)
  {
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr = paramQSecLibMgr;
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr = paramQSecCbMgr;
    this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr.a(new QSecPushServiceMgr.2(this));
  }
  
  private QSecPushServiceMgr.PushCmdData a(byte[] paramArrayOfByte)
  {
    int i;
    try
    {
      localQSecPushSeriveBody = new QSecPushSeriveMsg.QSecPushSeriveBody();
      localQSecPushSeriveBody.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localQSecPushSeriveBody.ver;
      bool = false;
      if ((paramArrayOfByte == null) || (!localQSecPushSeriveBody.ver.has())) {
        break label409;
      }
      i = localQSecPushSeriveBody.ver.get();
    }
    catch (Exception paramArrayOfByte)
    {
      QSecPushSeriveMsg.QSecPushSeriveBody localQSecPushSeriveBody;
      boolean bool;
      label83:
      int j;
      label118:
      paramArrayOfByte.printStackTrace();
      return null;
    }
    if ((localQSecPushSeriveBody.platform != null) && (localQSecPushSeriveBody.platform.has()))
    {
      i = localQSecPushSeriveBody.platform.get();
      break label420;
      paramArrayOfByte = localQSecPushSeriveBody.qsecJavaVer;
      j = -1;
      if ((paramArrayOfByte == null) || (!localQSecPushSeriveBody.qsecJavaVer.has())) {
        break label428;
      }
      i = localQSecPushSeriveBody.qsecJavaVer.get();
      break label430;
      i = j;
      if (localQSecPushSeriveBody.qsecNativeVer != null)
      {
        i = j;
        if (localQSecPushSeriveBody.qsecNativeVer.has()) {
          i = localQSecPushSeriveBody.qsecNativeVer.get();
        }
      }
      if ((i != 0) && (i != QSecFramework.a().a())) {
        return null;
      }
      if ((localQSecPushSeriveBody.packageName == null) || (!localQSecPushSeriveBody.packageName.has())) {
        break label442;
      }
      paramArrayOfByte = localQSecPushSeriveBody.packageName.get();
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(paramArrayOfByte)) && (!paramArrayOfByte.equalsIgnoreCase(QPMiscUtils.a()))) {
        return null;
      }
      paramArrayOfByte = new QSecPushServiceMgr.PushCmdData(null);
      if (localQSecPushSeriveBody.pluginId != null)
      {
        if (!localQSecPushSeriveBody.pluginId.has()) {
          return null;
        }
        paramArrayOfByte.jdField_a_of_type_Int = localQSecPushSeriveBody.pluginId.get();
        if (localQSecPushSeriveBody.pluginCmd != null)
        {
          if (!localQSecPushSeriveBody.pluginCmd.has()) {
            return null;
          }
          paramArrayOfByte.c = localQSecPushSeriveBody.pluginCmd.get();
          if (localQSecPushSeriveBody.pluginVer != null)
          {
            if (!localQSecPushSeriveBody.pluginVer.has()) {
              return null;
            }
            paramArrayOfByte.b = localQSecPushSeriveBody.pluginVer.get();
            if ((localQSecPushSeriveBody.canCache != null) && (localQSecPushSeriveBody.canCache.has()))
            {
              if (localQSecPushSeriveBody.canCache.get() == 1) {
                bool = true;
              }
              paramArrayOfByte.jdField_a_of_type_Boolean = bool;
            }
            if ((localQSecPushSeriveBody.extraInfo != null) && (localQSecPushSeriveBody.extraInfo.has())) {
              paramArrayOfByte.jdField_a_of_type_ArrayOfByte = localQSecPushSeriveBody.extraInfo.get().toByteArray();
            }
            return paramArrayOfByte;
          }
        }
      }
      return null;
      label409:
      i = 0;
      if (i == 1) {
        break;
      }
      return null;
      i = 0;
      label420:
      if ((i & 0x1) != 0) {
        break label83;
      }
      return null;
      label428:
      i = -1;
      label430:
      if ((i == 0) || (i == 33751040)) {
        break label118;
      }
      return null;
      label442:
      paramArrayOfByte = null;
    }
  }
  
  private void a(QSecPushServiceMgr.PushCmdData paramPushCmdData)
  {
    if (paramPushCmdData.jdField_a_of_type_Int == 0)
    {
      c(paramPushCmdData);
      return;
    }
    b(paramPushCmdData);
  }
  
  private void b(QSecPushServiceMgr.PushCmdData paramPushCmdData)
  {
    int i = this.jdField_a_of_type_ComTencentQqprotectQsecQSecLibMgr.a(paramPushCmdData.jdField_a_of_type_Int, paramPushCmdData.b, paramPushCmdData.c, new Object[] { paramPushCmdData.jdField_a_of_type_ArrayOfByte }, null);
    if (((i == 17) || (i == 7) || (i == 4)) && (paramPushCmdData.jdField_a_of_type_Boolean)) {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_Int < 50)
        {
          List localList = (List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramPushCmdData.jdField_a_of_type_Int));
          Object localObject1 = localList;
          if (localList == null)
          {
            localObject1 = new LinkedList();
            this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramPushCmdData.jdField_a_of_type_Int), localObject1);
          }
          ((List)localObject1).add(paramPushCmdData);
          this.jdField_a_of_type_Int += 1;
        }
        return;
      }
    }
  }
  
  private void c(QSecPushServiceMgr.PushCmdData paramPushCmdData)
  {
    int i = paramPushCmdData.c;
    if (i != 1) {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        paramPushCmdData = paramPushCmdData.jdField_a_of_type_ArrayOfByte;
        if (!FilterManager.a().a(paramPushCmdData)) {
          break label81;
        }
        FilterManager.a().a();
        return;
      }
    }
    try
    {
      paramPushCmdData = (QQAppInterface)BaseApplicationImpl.sMobileQQ.waitAppRuntime(null);
      if (paramPushCmdData != null)
      {
        ((QPUpdateManager)paramPushCmdData.getManager(QQManagerFactory.QQPROTECT_UPDATE_MANAGER)).b(0);
        return;
        this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr.a(true);
      }
      label81:
      return;
    }
    catch (Exception paramPushCmdData) {}
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    QSecFramework.a().post(new QSecPushServiceMgr.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecPushServiceMgr
 * JD-Core Version:    0.7.0.1
 */