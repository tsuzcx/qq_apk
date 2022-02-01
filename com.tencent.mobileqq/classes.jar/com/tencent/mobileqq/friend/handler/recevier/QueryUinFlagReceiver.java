package com.tencent.mobileqq.friend.handler.recevier;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class QueryUinFlagReceiver
  extends BaseProtocolReceiver<FriendHandler>
{
  public QueryUinFlagReceiver(@NotNull AppInterface paramAppInterface, @NotNull FriendHandler paramFriendHandler)
  {
    super(paramAppInterface, paramFriendHandler);
  }
  
  @NotNull
  public String a()
  {
    return "OidbSvc.0x476_147";
  }
  
  public void a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramToServiceMsg.extraData.getLong("uin"));
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess())) {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramToServiceMsg.getInt();
          paramToServiceMsg.getShort();
          paramFromServiceMsg = new byte[4];
          paramToServiceMsg.get(paramFromServiceMsg);
          long l = Utils.a(paramFromServiceMsg, 0);
          int i = paramToServiceMsg.get();
          localBundle.putLong("uin", l);
          localBundle.putInt("safety_flag", i & 0x1F);
          ((FriendHandler)a()).notifyUI(71, true, localBundle);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handle_oidb_0x476 error:");
          paramFromServiceMsg.append(paramToServiceMsg.getMessage());
          QLog.d("QueryUinFlagReceiver", 2, paramFromServiceMsg.toString());
        }
        ((FriendHandler)a()).notifyUI(71, false, localBundle);
        return;
      }
    }
    ((FriendHandler)a()).notifyUI(71, false, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.handler.recevier.QueryUinFlagReceiver
 * JD-Core Version:    0.7.0.1
 */