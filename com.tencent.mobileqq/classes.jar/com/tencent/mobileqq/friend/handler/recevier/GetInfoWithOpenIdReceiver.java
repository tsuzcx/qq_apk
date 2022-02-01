package com.tencent.mobileqq.friend.handler.recevier;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_0x5e1.RspBody;
import tencent.im.oidb.oidb_0x5e1.UdcUinData;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class GetInfoWithOpenIdReceiver
  extends BaseProtocolReceiver<FriendHandler>
{
  public GetInfoWithOpenIdReceiver(@NotNull AppInterface paramAppInterface, @NotNull FriendHandler paramFriendHandler)
  {
    super(paramAppInterface, paramFriendHandler);
  }
  
  @NotNull
  public String a()
  {
    return "OidbSvc.0x5e1_8";
  }
  
  public void a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleInfoOpenId ");
      localStringBuilder.append(paramFromServiceMsg.isSuccess());
      localStringBuilder.append(", ");
      int i;
      if (paramArrayOfByte != null) {
        i = paramArrayOfByte.length;
      } else {
        i = -1;
      }
      localStringBuilder.append(i);
      QLog.d("GetInfoWithOpenIdReceiver", 2, localStringBuilder.toString());
    }
    paramToServiceMsg = paramToServiceMsg.extraData;
    boolean bool3 = paramFromServiceMsg.isSuccess();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3) {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        bool1 = bool2;
        if (paramFromServiceMsg.uint32_result.has())
        {
          bool1 = bool2;
          if (paramFromServiceMsg.uint32_result.get() == 0)
          {
            paramArrayOfByte = new oidb_0x5e1.RspBody();
            paramArrayOfByte.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
            bool1 = bool2;
            if (paramArrayOfByte.rpt_msg_uin_data.size() > 0)
            {
              paramFromServiceMsg = new String(((oidb_0x5e1.UdcUinData)paramArrayOfByte.rpt_msg_uin_data.get(0)).bytes_nick.get().toByteArray());
              paramToServiceMsg.putString("nick_name", paramFromServiceMsg);
              if (QLog.isColorLevel())
              {
                paramArrayOfByte = new StringBuilder();
                paramArrayOfByte.append("handleInfoOpenId ");
                paramArrayOfByte.append(paramFromServiceMsg);
                QLog.d("GetInfoWithOpenIdReceiver", 2, paramArrayOfByte.toString());
              }
              bool1 = true;
            }
          }
        }
      }
      catch (Throwable paramFromServiceMsg)
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("GetInfoWithOpenIdReceiver", 2, "", paramFromServiceMsg);
          bool1 = bool2;
        }
      }
    }
    ((FriendHandler)a()).notifyUI(73, bool1, paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.handler.recevier.GetInfoWithOpenIdReceiver
 * JD-Core Version:    0.7.0.1
 */