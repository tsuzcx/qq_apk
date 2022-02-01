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
    int j = -1;
    boolean bool = true;
    int i;
    try
    {
      localQSecPushSeriveBody = new QSecPushSeriveMsg.QSecPushSeriveBody();
      localQSecPushSeriveBody.mergeFrom(paramArrayOfByte);
      if ((localQSecPushSeriveBody.ver == null) || (!localQSecPushSeriveBody.ver.has())) {
        break label411;
      }
      i = localQSecPushSeriveBody.ver.get();
    }
    catch (Exception paramArrayOfByte)
    {
      QSecPushSeriveMsg.QSecPushSeriveBody localQSecPushSeriveBody;
      label80:
      paramArrayOfByte.printStackTrace();
      return null;
    }
    if ((localQSecPushSeriveBody.platform != null) && (localQSecPushSeriveBody.platform.has()))
    {
      i = localQSecPushSeriveBody.platform.get();
      if ((i & 0x1) == 0) {
        break label418;
      }
      if ((localQSecPushSeriveBody.qsecJavaVer != null) && (localQSecPushSeriveBody.qsecJavaVer.has()))
      {
        i = localQSecPushSeriveBody.qsecJavaVer.get();
        break label420;
      }
    }
    for (;;)
    {
      i = j;
      if (localQSecPushSeriveBody.qsecNativeVer != null)
      {
        i = j;
        if (localQSecPushSeriveBody.qsecNativeVer.has()) {
          i = localQSecPushSeriveBody.qsecNativeVer.get();
        }
      }
      if ((i == 0) || (i == QSecFramework.a().a()))
      {
        if ((localQSecPushSeriveBody.packageName != null) && (localQSecPushSeriveBody.packageName.has())) {
          paramArrayOfByte = localQSecPushSeriveBody.packageName.get();
        }
        for (;;)
        {
          if ((TextUtils.isEmpty(paramArrayOfByte)) || (paramArrayOfByte.equalsIgnoreCase(QPMiscUtils.c())))
          {
            paramArrayOfByte = new QSecPushServiceMgr.PushCmdData(null);
            if ((localQSecPushSeriveBody.pluginId != null) && (localQSecPushSeriveBody.pluginId.has()))
            {
              paramArrayOfByte.jdField_a_of_type_Int = localQSecPushSeriveBody.pluginId.get();
              if ((localQSecPushSeriveBody.pluginCmd != null) && (localQSecPushSeriveBody.pluginCmd.has()))
              {
                paramArrayOfByte.c = localQSecPushSeriveBody.pluginCmd.get();
                if ((localQSecPushSeriveBody.pluginVer != null) && (localQSecPushSeriveBody.pluginVer.has()))
                {
                  paramArrayOfByte.b = localQSecPushSeriveBody.pluginVer.get();
                  if ((localQSecPushSeriveBody.canCache != null) && (localQSecPushSeriveBody.canCache.has())) {
                    if (localQSecPushSeriveBody.canCache.get() != 1) {
                      break label383;
                    }
                  }
                  for (;;)
                  {
                    paramArrayOfByte.jdField_a_of_type_Boolean = bool;
                    if ((localQSecPushSeriveBody.extraInfo != null) && (localQSecPushSeriveBody.extraInfo.has())) {
                      paramArrayOfByte.jdField_a_of_type_ArrayOfByte = localQSecPushSeriveBody.extraInfo.get().toByteArray();
                    }
                    return paramArrayOfByte;
                    label383:
                    bool = false;
                  }
                  paramArrayOfByte = null;
                  continue;
                  i = -1;
                  break label420;
                  i = 0;
                  break label80;
                  label411:
                  i = 0;
                  if (i == 1) {
                    break;
                  }
                }
              }
            }
          }
        }
      }
      label418:
      label420:
      do
      {
        return null;
        if (i == 0) {
          break;
        }
      } while (i != 33751040);
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
    switch (paramPushCmdData.c)
    {
    }
    do
    {
      for (;;)
      {
        return;
        this.jdField_a_of_type_ComTencentQqprotectQsecQSecCbMgr.a(true);
        return;
        try
        {
          paramPushCmdData = (QQAppInterface)BaseApplicationImpl.sMobileQQ.waitAppRuntime(null);
          if (paramPushCmdData != null)
          {
            ((QPUpdateManager)paramPushCmdData.getManager(QQManagerFactory.QQPROTECT_UPDATE_MANAGER)).b(0);
            return;
          }
        }
        catch (Exception paramPushCmdData)
        {
          return;
        }
      }
      paramPushCmdData = paramPushCmdData.jdField_a_of_type_ArrayOfByte;
    } while (!FilterManager.a().a(paramPushCmdData));
    FilterManager.a().a();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    QSecFramework.a().post(new QSecPushServiceMgr.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.QSecPushServiceMgr
 * JD-Core Version:    0.7.0.1
 */