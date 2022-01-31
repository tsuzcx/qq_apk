package com.tencent.mobileqq.flashchat;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class FlashChatHanlder
  extends BusinessHandler
{
  public FlashChatHanlder(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "handleReqSetSwitch ");
    }
    int i;
    boolean bool1;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          i = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("FlashChat", 2, "handleReqSetSwitch ret=" + i);
          }
          if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
            if (4 <= paramFromServiceMsg.length)
            {
              paramFromServiceMsg = String.valueOf(PkgTools.a(paramFromServiceMsg, 0));
              if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())))
              {
                if (QLog.isColorLevel()) {
                  QLog.w("FlashChat", 2, "handleReqSetSwitch uin error");
                }
                return;
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          paramFromServiceMsg = paramObject;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      i = paramToServiceMsg.extraData.getByte("lightalk_switch", (byte)0).byteValue();
      if (bool1)
      {
        paramToServiceMsg = (FlashChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216);
        if (i != 0) {
          break label257;
        }
      }
      for (;;)
      {
        paramToServiceMsg.a(bool2);
        a(2, bool1, null);
        return;
        label257:
        bool2 = false;
      }
      bool1 = false;
    }
  }
  
  protected Class a()
  {
    return FlashChatHandlerObserver.class;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramFromServiceMsg.getServiceCmd();
        if (!"OidbSvc.0x4ff_9".equals(str)) {
          break;
        }
      } while (!paramToServiceMsg.extraData.getBoolean("FlashChatHanlder", false));
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    } while ((!"OidbSvc.0x480_9".equals(str)) || (!paramToServiceMsg.extraData.getBoolean("FlashChatHanlder", false)));
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (byte b = 0;; b = 1) {
      try
      {
        long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
        if (QLog.isColorLevel()) {
          QLog.d("FlashChat", 2, "requestSetSwitch " + b);
        }
        Object localObject = new byte[13];
        PkgTools.a((byte[])localObject, 0, l);
        localObject[4] = 0;
        PkgTools.a((byte[])localObject, 5, (short)1);
        PkgTools.a((byte[])localObject, 7, 40352);
        PkgTools.a((byte[])localObject, 9, (short)2);
        PkgTools.a((byte[])localObject, 11, (short)b);
        localObject = a("OidbSvc.0x4ff_9", 1279, 9, (byte[])localObject);
        ((ToServiceMsg)localObject).extraData.putByte("lightalk_switch", b);
        ((ToServiceMsg)localObject).extraData.putBoolean("FlashChatHanlder", true);
        b((ToServiceMsg)localObject);
        return;
      }
      catch (Exception localException)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w("FlashChat", 2, "reqSetSwitch error", localException);
        return;
      }
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4ff_9");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x480_9");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "requestGetSwitch begin...");
    }
    try
    {
      long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      Object localObject = new byte[9];
      PkgTools.a((byte[])localObject, 0, l);
      localObject[4] = 0;
      PkgTools.a((byte[])localObject, 5, (short)1);
      PkgTools.a((byte[])localObject, 7, 40352);
      localObject = a("OidbSvc.0x480_9", 1152, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putBoolean("FlashChatHanlder", true);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("FlashChat", 2, "send_oidb_0x480_9 error", localException);
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    for (;;)
    {
      int i;
      int k;
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        paramFromServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if ((paramToServiceMsg == null) || (!paramToServiceMsg.uint32_result.has())) {
          break label418;
        }
        i = paramToServiceMsg.uint32_result.get();
        if (i != 0) {
          break label384;
        }
        long l = paramFromServiceMsg.getInt();
        paramFromServiceMsg.get();
        j = paramFromServiceMsg.getShort();
        if (!QLog.isColorLevel()) {
          break label424;
        }
        QLog.d("FlashChat", 2, "handleReqGetSwitch, request success, tlvCount = " + j + " uin:" + Long.valueOf(l));
      }
      catch (Exception paramToServiceMsg)
      {
        int j;
        int m;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FlashChat", 2, "handleReqGetSwitch exception: " + paramToServiceMsg.getMessage());
        return;
      }
      if ((paramFromServiceMsg.hasRemaining()) && (i < j))
      {
        k = paramFromServiceMsg.getShort();
        m = paramFromServiceMsg.getShort();
        if (QLog.isColorLevel()) {
          QLog.d("FlashChat", 2, "handleReqGetSwitch, TLV type: " + k + ",legnth: " + m);
        }
        if (k != -25184) {
          break label348;
        }
        i = paramFromServiceMsg.getShort();
        if (QLog.isColorLevel()) {
          QLog.i("FlashChat", 2, "handleReqGetSwitch switchValue" + i);
        }
      }
      try
      {
        paramToServiceMsg = (FlashChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216);
        if (i == 0) {
          bool = true;
        }
        paramToServiceMsg.a(bool);
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.w("FlashChat", 2, "er : " + paramToServiceMsg.getMessage(), paramToServiceMsg);
        return;
      }
      label348:
      if (QLog.isColorLevel())
      {
        QLog.i("FlashChat", 2, "handleReqGetSwitch" + k);
        break label430;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FlashChat", 2, "handleReqGetSwitch" + i);
        return;
        i = -1;
        continue;
        i = 0;
        continue;
      }
      label384:
      label418:
      label424:
      label430:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatHanlder
 * JD-Core Version:    0.7.0.1
 */