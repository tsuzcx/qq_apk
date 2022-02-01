package com.tencent.mobileqq.friend.handler.recevier;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import friendlist.GetAutoInfoResp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GetAutoInfoReceiver
  extends BaseProtocolReceiver<FriendHandler>
{
  public GetAutoInfoReceiver(@NotNull AppInterface paramAppInterface, @NotNull FriendHandler paramFriendHandler)
  {
    super(paramAppInterface, paramFriendHandler);
  }
  
  @NotNull
  public String a()
  {
    return "friendlist.GetAutoInfoReq";
  }
  
  public void a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    paramObject = (GetAutoInfoResp)paramObject;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && (paramObject.errorCode == 0))
    {
      paramToServiceMsg.putInt("group_id", paramObject.cGroupID);
      paramToServiceMsg.putString("nick_name", paramObject.strRemark);
      ((FriendHandler)a()).notifyUI(33, true, paramToServiceMsg);
      return;
    }
    ((FriendHandler)a()).notifyUI(33, false, paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.handler.recevier.GetAutoInfoReceiver
 * JD-Core Version:    0.7.0.1
 */