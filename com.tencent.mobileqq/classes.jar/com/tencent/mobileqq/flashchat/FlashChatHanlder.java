package com.tencent.mobileqq.flashchat;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
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
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "handleReqSetSwitch ");
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = paramObject;
      }
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
      {
        int i = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handleReqSetSwitch ret=");
          paramObject.append(i);
          QLog.i("FlashChat", 2, paramObject.toString());
        }
        if ((i == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
          i = paramFromServiceMsg.length;
          boolean bool2 = true;
          bool1 = bool2;
          if (4 > i) {
            break label221;
          }
          paramFromServiceMsg = String.valueOf(PkgTools.getLongData(paramFromServiceMsg, 0));
          if (paramFromServiceMsg != null)
          {
            bool1 = bool2;
            if (paramFromServiceMsg.equals(this.appRuntime.getAccount())) {
              break label221;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.w("FlashChat", 2, "handleReqSetSwitch uin error");
          }
          return;
        }
      }
    }
    boolean bool1 = false;
    label221:
    paramToServiceMsg.extraData.getByte("lightalk_switch", (byte)0).byteValue();
    notifyUI(2, bool1, null);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "requestGetSwitch begin...");
    }
    try
    {
      long l = Long.parseLong(this.appRuntime.getAccount());
      Object localObject = new byte[9];
      PkgTools.dWord2Byte((byte[])localObject, 0, l);
      localObject[4] = 0;
      PkgTools.word2Byte((byte[])localObject, 5, (short)1);
      PkgTools.dWordTo2Bytes((byte[])localObject, 7, 40352);
      localObject = makeOIDBPkg("OidbSvc.0x480_9", 1152, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putBoolean("FlashChatHanlder", true);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("FlashChat", 2, "send_oidb_0x480_9 error", localException);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        paramToServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        i = -1;
        if (paramFromServiceMsg.uint32_result.has()) {
          i = paramFromServiceMsg.uint32_result.get();
        }
        if (i == 0)
        {
          long l = paramToServiceMsg.getInt();
          paramToServiceMsg.get();
          int j = paramToServiceMsg.getShort();
          if (!QLog.isColorLevel()) {
            break label391;
          }
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleReqGetSwitch, request success, tlvCount = ");
          paramFromServiceMsg.append(j);
          paramFromServiceMsg.append(" uin:");
          paramFromServiceMsg.append(Long.valueOf(l));
          QLog.d("FlashChat", 2, paramFromServiceMsg.toString());
          break label391;
          if ((paramToServiceMsg.hasRemaining()) && (i < j))
          {
            int k = paramToServiceMsg.getShort();
            int m = paramToServiceMsg.getShort();
            if (QLog.isColorLevel())
            {
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("handleReqGetSwitch, TLV type: ");
              paramFromServiceMsg.append(k);
              paramFromServiceMsg.append(",legnth: ");
              paramFromServiceMsg.append(m);
              QLog.d("FlashChat", 2, paramFromServiceMsg.toString());
            }
            if (k == -25184)
            {
              i = paramToServiceMsg.getShort();
              if (QLog.isColorLevel())
              {
                paramToServiceMsg = new StringBuilder();
                paramToServiceMsg.append("handleReqGetSwitch switchValue");
                paramToServiceMsg.append(i);
                QLog.i("FlashChat", 2, paramToServiceMsg.toString());
              }
            }
            else
            {
              if (!QLog.isColorLevel()) {
                break label397;
              }
              paramFromServiceMsg = new StringBuilder();
              paramFromServiceMsg.append("handleReqGetSwitch");
              paramFromServiceMsg.append(k);
              QLog.i("FlashChat", 2, paramFromServiceMsg.toString());
              break label397;
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleReqGetSwitch");
          paramToServiceMsg.append(i);
          QLog.d("FlashChat", 2, paramToServiceMsg.toString());
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleReqGetSwitch exception: ");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.d("FlashChat", 2, paramFromServiceMsg.toString());
        }
      }
      return;
      label391:
      int i = 0;
      continue;
      label397:
      i += 1;
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x4ff_9");
      this.allowCmdSet.add("OidbSvc.0x480_9");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return FlashChatHandlerObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      String str = paramFromServiceMsg.getServiceCmd();
      if ("OidbSvc.0x4ff_9".equals(str))
      {
        if (paramToServiceMsg.extraData.getBoolean("FlashChatHanlder", false)) {
          b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
      else if (("OidbSvc.0x480_9".equals(str)) && (paramToServiceMsg.extraData.getBoolean("FlashChatHanlder", false))) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatHanlder
 * JD-Core Version:    0.7.0.1
 */