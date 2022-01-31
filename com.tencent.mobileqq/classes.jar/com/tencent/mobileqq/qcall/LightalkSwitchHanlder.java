package com.tencent.mobileqq.qcall;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class LightalkSwitchHanlder
  extends BusinessHandler
{
  public LightalkSwitchHanlder(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    int i;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("handle_oidb_0x5eb_15 ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte != null)
      {
        i = paramArrayOfByte.length;
        QLog.d("LightalkSwitchHanlder", 2, i);
      }
    }
    else
    {
      paramToServiceMsg = paramToServiceMsg.extraData;
      if (!paramFromServiceMsg.isSuccess()) {
        break label217;
      }
    }
    label217:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom(paramArrayOfByte);
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          paramFromServiceMsg = new oidb_0x5eb.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (paramFromServiceMsg.rpt_msg_uin_data.size() > 0)
          {
            i = ((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0)).uint32_lightalk_switch.get();
            if (i == 0)
            {
              bool1 = true;
              boolean bool3 = true;
              bool2 = bool1;
              bool1 = bool3;
              a(1, bool1, Boolean.valueOf(bool2));
              return;
              i = -1;
              break;
            }
            bool1 = false;
            continue;
          }
        }
        boolean bool1 = false;
      }
      catch (Throwable paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("LightalkSwitchHanlder", 2, "", paramToServiceMsg);
        }
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
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
            QLog.i("LightalkSwitchHanlder", 2, "handle_oidb_0x4ff_9 ret=" + i);
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
                  QLog.w("Q.dating", 2, "handle_oidb_0x4ff_9 uin error");
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
        paramToServiceMsg = (LightalkSwitchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(85);
        if (i != 0) {
          break label242;
        }
      }
      for (;;)
      {
        paramToServiceMsg.b(bool2);
        a(2, bool1, null);
        return;
        label242:
        bool2 = false;
      }
      bool1 = false;
    }
  }
  
  protected Class a()
  {
    return LightalkSwitchObserver.class;
  }
  
  public void a(byte paramByte)
  {
    try
    {
      long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      Object localObject = new byte[13];
      PkgTools.a((byte[])localObject, 0, l);
      localObject[4] = 0;
      PkgTools.a((byte[])localObject, 5, (short)1);
      PkgTools.a((byte[])localObject, 7, 40506);
      PkgTools.a((byte[])localObject, 9, (short)2);
      PkgTools.a((byte[])localObject, 11, (short)paramByte);
      localObject = a("OidbSvc.0x4ff_9", 1279, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putByte("lightalk_switch", paramByte);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromLightalkHanlder", true);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("LightalkSwitchHanlder", 2, "send_oidb_0x4ff_9 error", localException);
    }
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
      } while (!paramToServiceMsg.extraData.getBoolean("reqFromLightalkHanlder", false));
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    } while ((!"OidbSvc.0x5eb_15".equals(str)) || (!paramToServiceMsg.extraData.getBoolean("reqFromLightalkHanlder", false)));
    a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4ff_9");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5eb_15");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b()
  {
    Object localObject = new oidb_0x5eb.ReqBody();
    try
    {
      long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      ((oidb_0x5eb.ReqBody)localObject).uint32_req_lightalk_switch.set(1);
      localObject = a("OidbSvc.0x5eb_15", 1515, 15, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromLightalkHanlder", true);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("LightalkSwitchHanlder", 2, "send_oidb_0x5eb_15 error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qcall.LightalkSwitchHanlder
 * JD-Core Version:    0.7.0.1
 */