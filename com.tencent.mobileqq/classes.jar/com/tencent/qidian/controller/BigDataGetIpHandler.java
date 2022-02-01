package com.tencent.qidian.controller;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.cs.cmd0x6ff.subcmd0x501.ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.RspBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501ReqBody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody.IpAddr;
import tencent.im.cs.cmd0x6ff.subcmd0x501.SubCmd0x501Rspbody.SrvAddrs;

public class BigDataGetIpHandler
  extends BusinessHandler
{
  private byte[] a = null;
  private byte[] b = null;
  private String[] c = null;
  private Object d = new Object();
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private boolean h = false;
  private Object i = new Object();
  private long j = 0L;
  
  public BigDataGetIpHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public BigDataGetIpHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private static String a(int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt1 >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt1 >> 16 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt1 >> 24 & 0xFF);
    return a(localStringBuilder.toString(), paramInt2);
  }
  
  private static String a(String paramString, int paramInt)
  {
    StringBuffer localStringBuffer = new StringBuffer(200);
    localStringBuffer.append("http://");
    localStringBuffer.append(paramString);
    if (paramInt != 80)
    {
      localStringBuffer.append(":");
      localStringBuffer.append(paramInt);
    }
    localStringBuffer.append("/");
    return localStringBuffer.toString();
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String[] paramArrayOfString)
  {
    for (;;)
    {
      Object localObject;
      boolean bool1;
      try
      {
        localObject = this.d;
        if (paramArrayOfByte1 == null) {
          break label160;
        }
      }
      finally {}
      try
      {
        if (paramArrayOfByte1.length <= 0) {
          break label160;
        }
        this.a = paramArrayOfByte1;
        bool2 = true;
        bool1 = bool2;
        if (paramArrayOfByte2 != null)
        {
          bool1 = bool2;
          if (paramArrayOfByte2.length > 0)
          {
            this.b = paramArrayOfByte2;
            bool1 = true;
          }
        }
        bool2 = bool1;
        if (paramArrayOfString != null)
        {
          bool2 = bool1;
          if (paramArrayOfString.length > 0)
          {
            this.e = 0;
            this.c = paramArrayOfString;
            bool2 = true;
          }
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfByte1 = new StringBuilder();
          paramArrayOfByte1.append("saveSrvParam | changed = ");
          paramArrayOfByte1.append(bool2);
          paramArrayOfByte1.append(" | usingIndex = ");
          paramArrayOfByte1.append(this.e);
          QLog.d("BigDataGetIpHandler", 2, paramArrayOfByte1.toString());
        }
        return;
      }
      finally
      {
        continue;
      }
      throw paramArrayOfByte1;
      label160:
      boolean bool2 = false;
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    label557:
    label562:
    label567:
    synchronized (this.i)
    {
      this.h = false;
      int k;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
        k = 1;
      } else {
        k = 0;
      }
      int m = paramToServiceMsg.extraData.getInt("big_data_cmd", -1);
      paramToServiceMsg.extraData.getInt("big_data_sub_cmd", -1);
      int n = paramToServiceMsg.extraData.getInt("big_data_cmd_seq", -1);
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetIPList ");
        paramToServiceMsg.append(m);
        paramToServiceMsg.append(" handler: ");
        paramToServiceMsg.append(getClass().getSimpleName());
        paramToServiceMsg.append(" reqSeq = ");
        paramToServiceMsg.append(n);
        QLog.d("BigDataGetIpHandler", 1, paramToServiceMsg.toString());
      }
      if (k != 0)
      {
        if (paramObject != null) {}
        try
        {
          paramToServiceMsg = new subcmd0x501.RspBody();
          paramToServiceMsg.mergeFrom((byte[])paramObject);
          paramObject = (subcmd0x501.SubCmd0x501Rspbody)paramToServiceMsg.msg_subcmd_0x501_rsp_body.get();
          paramToServiceMsg = paramObject.bytes_session_key.get();
          if ((paramToServiceMsg == null) || (paramToServiceMsg.toByteArray().length <= 0)) {
            break label557;
          }
          paramToServiceMsg = paramToServiceMsg.toByteArray();
          paramFromServiceMsg = paramObject.bytes_httpconn_sig_session.get();
          if ((paramFromServiceMsg == null) || (paramFromServiceMsg.toByteArray().length <= 0)) {
            break label562;
          }
          paramFromServiceMsg = paramFromServiceMsg.toByteArray();
          paramObject = paramObject.rpt_msg_httpconn_addrs.get();
          if ((paramObject == null) || (paramObject.size() == 0)) {
            break label567;
          }
          paramObject = paramObject.iterator();
          do
          {
            if (!paramObject.hasNext()) {
              break;
            }
            ??? = (subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)paramObject.next();
          } while (((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)???).uint32_service_type.get() != 1);
          List localList = ((subcmd0x501.SubCmd0x501Rspbody.SrvAddrs)???).rpt_msg_addrs.get();
          if ((localList == null) || (localList.size() == 0)) {
            break label567;
          }
          ??? = new String[localList.size()];
          k = 0;
          for (;;)
          {
            paramObject = ???;
            if (k >= localList.size()) {
              break;
            }
            paramObject = (subcmd0x501.SubCmd0x501Rspbody.IpAddr)localList.get(k);
            ???[k] = a(paramObject.uint32_ip.get(), paramObject.uint32_port.get());
            k += 1;
          }
          a(paramToServiceMsg, paramFromServiceMsg, paramObject);
          notifyUI(2001, true, null);
          return;
        }
        catch (Exception paramToServiceMsg)
        {
          if (!QLog.isColorLevel()) {
            break label458;
          }
          QLog.d("BigDataGetIpHandler", 1, "handleGetIPList fail, because exception", paramToServiceMsg);
          paramToServiceMsg.printStackTrace();
          notifyUI(2001, false, null);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 1, "handleRefreshGetAllTags fail, because data is null");
        }
        notifyUI(2001, false, null);
      }
      else
      {
        label458:
        if (paramFromServiceMsg == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BigDataGetIpHandler", 1, "getAllTags handleGetIPList fail, because res is null");
          }
        }
        else if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("getAllTags handleGetIPList fail, because res code: ");
          paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
          QLog.d("BigDataGetIpHandler", 1, paramToServiceMsg.toString());
        }
        notifyUI(2001, false, null);
        return;
      }
    }
  }
  
  public boolean a(int paramInt1, MessageMicro<?> arg2, int paramInt2, Object paramObject)
  {
    synchronized (this.i)
    {
      if (this.h) {
        return true;
      }
      long l1 = System.currentTimeMillis();
      if (l1 - this.j > 30000L) {
        this.g = 0;
      }
      if (this.g > 5)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BigDataGetIpHandler", 2, "req get ip too frequently");
        }
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BigDataGetIpHandler", 2, "req get ip list");
      }
      try
      {
        long l2 = Long.parseLong(this.appRuntime.getAccount());
        if (l2 <= 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("BigDataGetIpHandler", 2, "uin illegal");
          }
          return false;
        }
        this.j = l1;
        this.g += 1;
        this.h = true;
        paramObject = new subcmd0x501.SubCmd0x501ReqBody();
        paramObject.uint64_uin.set(l2);
        paramObject.uint32_idc_id.set(0);
        paramObject.uint32_appid.set(16);
        paramObject.uint32_login_sig_type.set(1);
        paramObject.uint32_request_flag.set(3);
        Object localObject = new ArrayList();
        ((List)localObject).add(Integer.valueOf(1));
        paramObject.rpt_uint32_service_types.set((List)localObject);
        localObject = new subcmd0x501.ReqBody();
        ((subcmd0x501.ReqBody)localObject).msg_subcmd_0x501_req_body.set(paramObject);
        paramObject = createToServiceMsg("HttpConn.0x6ff_501");
        paramObject.putWupBuffer(((subcmd0x501.ReqBody)localObject).toByteArray());
        paramObject.extraData.putInt("big_data_cmd", paramInt1);
        paramObject.extraData.putInt("big_data_sub_cmd", paramInt2);
        paramInt2 = this.f;
        this.f = (paramInt2 + 1);
        paramObject.extraData.putInt("big_data_cmd_seq", paramInt2);
        sendPbReq(paramObject);
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("getIPList ");
          paramObject.append(paramInt1);
          paramObject.append(" handler: ");
          paramObject.append(getClass().getSimpleName());
          paramObject.append(" reqSeq = ");
          paramObject.append(this.f);
          paramObject.append(" curSeq = ");
          paramObject.append(paramInt2);
          QLog.d("BigDataGetIpHandler", 1, paramObject.toString());
        }
        return true;
      }
      catch (Exception paramObject)
      {
        label420:
        break label420;
      }
      if (QLog.isColorLevel()) {
        QLog.d("BigDataGetIpHandler", 2, "req get ip list case long fail");
      }
      return false;
    }
  }
  
  public byte[] a()
  {
    synchronized (this.d)
    {
      byte[] arrayOfByte = this.a;
      return arrayOfByte;
    }
  }
  
  public String b()
  {
    synchronized (this.d)
    {
      Object localObject2 = this.c;
      if ((localObject2 != null) && (localObject2.length != 0))
      {
        this.e %= localObject2.length;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getSrvUrl | usingIndex = ");
          localStringBuilder.append(this.e);
          localStringBuilder.append(" | count = ");
          localStringBuilder.append(localObject2.length);
          localStringBuilder.append(" | result = ");
          localStringBuilder.append(localObject2[this.e]);
          QLog.d("BigDataGetIpHandler", 2, localStringBuilder.toString());
        }
        localObject2 = localObject2[this.e];
        return localObject2;
      }
      return null;
    }
  }
  
  public byte[] c()
  {
    synchronized (this.d)
    {
      byte[] arrayOfByte = this.b;
      return arrayOfByte;
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return QidianBusinessObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ("HttpConn.0x6ff_501".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BigDataGetIpHandler", 2, "CMD_GET_IP_LIST");
      }
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.controller.BigDataGetIpHandler
 * JD-Core Version:    0.7.0.1
 */