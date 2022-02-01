package com.tencent.mobileqq.colornote.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ColorNoteHandler
  extends BusinessHandler
{
  private short a = -23193;
  
  public ColorNoteHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (bool1)
    {
      paramFromServiceMsg = (byte[])paramObject;
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        QLog.e("ColorNoteHandler", 1, "pkg.mergeFrom error: ", paramFromServiceMsg);
      }
      if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
      {
        if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = new oidb_0x5eb.RspBody();
          try
          {
            paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg)
          {
            QLog.e("ColorNoteHandler", 1, "response.mergeFrom error: ", paramToServiceMsg);
          }
          if (paramFromServiceMsg.rpt_msg_uin_data.size() > 0)
          {
            if (((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0)).uint32_flag_color_note_recent_switch.get() == 1) {
              bool1 = true;
            } else {
              bool1 = false;
            }
            bool2 = true;
            bool3 = bool1;
            break label302;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ColorNoteHandler", 2, "handleReqGetColorNoteRecentSwitch: response.rpt_msg_uin_data.size() < 0");
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("ColorNoteHandler", 2, "handleReqGetColorNoteRecentSwitch: pkg.bytes_bodybuffer is null");
        }
      }
      else if (QLog.isColorLevel()) {
        if (paramToServiceMsg.uint32_result.has())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleReqGetColorNoteRecentSwitch: pkg.uint32_result error code: ");
          paramFromServiceMsg.append(paramToServiceMsg.uint32_result.get());
          QLog.d("ColorNoteHandler", 2, paramFromServiceMsg.toString());
        }
        else
        {
          QLog.d("ColorNoteHandler", 2, "handleReqGetColorNoteRecentSwitch: pkg.uint32_result do not have");
        }
      }
      bool1 = false;
    }
    boolean bool3 = true;
    boolean bool2 = bool1;
    label302:
    notifyUI(1, bool2, new Object[] { Boolean.valueOf(bool3) });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool1 = bool2;
    boolean bool3;
    if (bool2) {
      bool3 = bool2;
    }
    for (;;)
    {
      int i;
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool3 = bool2;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label263;
        }
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          bool3 = bool2;
          bool1 = bool2;
          if (paramToServiceMsg.bytes_bodybuffer.has())
          {
            bool3 = bool2;
            bool1 = bool2;
            if (paramToServiceMsg.bytes_bodybuffer.get() != null)
            {
              bool3 = bool2;
              i = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
              if (i >= 0) {
                break label269;
              }
              l = i + 4294967296L;
              bool3 = bool2;
              if (this.appRuntime.getCurrentAccountUin().equals(String.valueOf(l)))
              {
                bool3 = bool2;
                bool1 = bool2;
                if (QLog.isColorLevel())
                {
                  bool3 = bool2;
                  QLog.d("ColorNoteHandler", 2, "handleReqSetColorNoteRecentSwitch: set switch success");
                  bool1 = bool2;
                }
              }
              else
              {
                try
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("ColorNoteHandler", 2, "handleReqSetColorNoteRecentSwitch: set switch failed");
                  }
                  bool1 = false;
                }
                catch (Exception paramToServiceMsg)
                {
                  bool1 = false;
                }
                QLog.e("ColorNoteHandler", 1, "handleReqSetColorNoteRecentSwitch: oidb_sso errors", paramToServiceMsg);
              }
            }
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = bool3;
      }
      notifyUI(2, bool1, null);
      return;
      label263:
      bool2 = false;
      continue;
      label269:
      long l = i;
    }
  }
  
  public void a()
  {
    String str = this.appRuntime.getCurrentAccountUin();
    Object localObject = new oidb_0x5eb.ReqBody();
    try
    {
      long l = Long.parseLong(str);
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
    }
    catch (Exception localException)
    {
      QLog.e("ColorNoteHandler", 1, "reqGetColorNoteRecentSwitch: parseLongError: ", localException);
    }
    ((oidb_0x5eb.ReqBody)localObject).uint32_flag_color_note_recent_switch.set(1);
    localObject = makeOIDBPkg("OidbSvc.0x5eb_cn_switch", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("uin", str);
    ((ToServiceMsg)localObject).extraData.putBoolean("uint32_flag_color_note_recent_switch", true);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean)
  {
    paramBoolean ^= true;
    Object localObject1 = this.appRuntime.getCurrentAccountUin();
    for (;;)
    {
      try
      {
        long l = Long.parseLong((String)localObject1);
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
        Object localObject2 = ByteBuffer.allocate(13);
        if (!paramBoolean) {
          break label204;
        }
        s = 1;
        ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort(this.a).putShort((short)2).putShort(s);
        ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
        localObject2 = createToServiceMsg("OidbSvc.0x4ff_cn_switch");
        ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
        ((ToServiceMsg)localObject2).setTimeout(30000L);
        sendPbReq((ToServiceMsg)localObject2);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("reqSetColorNoteRecentSwitch: request sent, switch: ");
          ((StringBuilder)localObject1).append(paramBoolean);
          QLog.d("ColorNoteHandler", 2, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("ColorNoteHandler", 1, "reqSetColorNoteRecentSwitch error: ", localException);
      }
      return;
      label204:
      short s = 0;
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ColorNoteObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (TextUtils.equals("OidbSvc.0x5eb_cn_switch", paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHandler", 2, "onReceive: receive CMD_REQ_GET_SWITCH message");
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (TextUtils.equals("OidbSvc.0x4ff_cn_switch", paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ColorNoteHandler", 2, "onReceive: receive CMD_REQ_SET_SWITCH message");
      }
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNoteHandler
 * JD-Core Version:    0.7.0.1
 */