package com.tencent.mobileqq.kandian.base.msf;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class ReadInJoyOidbHelper
{
  public static int a(FromServiceMsg paramFromServiceMsg, Object paramObject, MessageMicro paramMessageMicro)
  {
    int i = paramFromServiceMsg.getResultCode();
    boolean bool = QLog.isDevelopLevel();
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = null;
    paramFromServiceMsg = null;
    StringBuilder localStringBuilder;
    if (bool) {
      localStringBuilder = new StringBuilder();
    } else {
      localStringBuilder = null;
    }
    label105:
    int j;
    if (i == 1000)
    {
      if (paramObject != null)
      {
        try
        {
          localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
          try
          {
            paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)localOIDBSSOPkg.mergeFrom((byte[])paramObject);
          }
          catch (Exception paramObject)
          {
            paramFromServiceMsg = localOIDBSSOPkg;
          }
          if (localStringBuilder == null) {
            break label105;
          }
        }
        catch (Exception paramObject) {}
        localStringBuilder.append("parseOIDBPkg, oidb_sso, parseFrom byte ");
        localStringBuilder.append(paramObject.toString());
        paramObject.printStackTrace();
      }
      else
      {
        paramFromServiceMsg = localOIDBSSOPkg;
        if (localStringBuilder != null)
        {
          localStringBuilder.append("parseOIDBPkg, data is null");
          paramFromServiceMsg = localOIDBSSOPkg;
        }
      }
      if (paramFromServiceMsg != null) {
        i = paramFromServiceMsg.uint32_result.get();
      }
      j = i;
      if (paramFromServiceMsg != null)
      {
        j = i;
        if (paramFromServiceMsg.bytes_bodybuffer.has())
        {
          j = i;
          if (paramFromServiceMsg.bytes_bodybuffer.get() != null)
          {
            j = i;
            if (paramMessageMicro != null)
            {
              try
              {
                paramMessageMicro.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
                j = i;
              }
              catch (Exception paramFromServiceMsg)
              {
                j = i;
                if (localStringBuilder == null) {
                  break label255;
                }
              }
              localStringBuilder.append(paramFromServiceMsg.toString());
              j = i;
            }
          }
        }
      }
    }
    else
    {
      j = i;
      if (localStringBuilder != null)
      {
        localStringBuilder.append("parseOIDBPkg, sso result: ");
        localStringBuilder.append(i);
        j = i;
      }
    }
    label255:
    if ((localStringBuilder != null) && (localStringBuilder.length() > 0)) {
      QLog.isDevelopLevel();
    }
    return j;
  }
  
  public static ToServiceMsg a(String paramString)
  {
    return new ToServiceMsg("mobileqq.service", RIJQQAppInterfaceUtil.a(), paramString);
  }
  
  public static ToServiceMsg a(String paramString, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(paramInt1);
    localOIDBSSOPkg.uint32_service_type.set(paramInt2);
    localOIDBSSOPkg.str_client_version.set(AppSetting.f());
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    paramString = a(paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.setTimeout(30000L);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.msf.ReadInJoyOidbHelper
 * JD-Core Version:    0.7.0.1
 */