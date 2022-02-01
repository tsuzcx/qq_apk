package com.tencent.mobileqq.friend.handler.recevier;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetUserAddFriendSettingResp;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class GetUserAddFriendSettingReceiver
  extends BaseProtocolReceiver<FriendHandler>
{
  public GetUserAddFriendSettingReceiver(@NotNull AppInterface paramAppInterface, @NotNull FriendHandler paramFriendHandler)
  {
    super(paramAppInterface, paramFriendHandler);
  }
  
  @NotNull
  public String a()
  {
    return "friendlist.getUserAddFriendSetting";
  }
  
  public void a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    a(paramToServiceMsg, (GetUserAddFriendSettingResp)paramObject);
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, GetUserAddFriendSettingResp paramGetUserAddFriendSettingResp)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    StringBuilder localStringBuilder;
    if ((paramGetUserAddFriendSettingResp != null) && (paramGetUserAddFriendSettingResp.result == 0))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleAddFriendSetting ");
        localStringBuilder.append(paramGetUserAddFriendSettingResp.queryuinsetting);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramGetUserAddFriendSettingResp.contact_bothway_friend);
        localStringBuilder.append(", ");
        localStringBuilder.append(paramGetUserAddFriendSettingResp.vecStrUserQuestion);
        QLog.d("GetUserAddFriendSettingReceiver", 2, localStringBuilder.toString());
      }
      paramToServiceMsg.putInt("friend_setting", paramGetUserAddFriendSettingResp.queryuinsetting);
      paramToServiceMsg.putLong("query_friend_uin", paramGetUserAddFriendSettingResp.queryuin);
      paramToServiceMsg.putStringArrayList("user_question", paramGetUserAddFriendSettingResp.vecStrUserQuestion);
      paramToServiceMsg.putBoolean("contact_bothway", paramGetUserAddFriendSettingResp.contact_bothway_friend);
      ((FriendHandler)a()).notifyUI(12, true, paramToServiceMsg);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleAddFriendSetting ");
      int i;
      if (paramGetUserAddFriendSettingResp != null) {
        i = paramGetUserAddFriendSettingResp.result;
      } else {
        i = -10000;
      }
      localStringBuilder.append(i);
      QLog.d("GetUserAddFriendSettingReceiver", 2, localStringBuilder.toString());
    }
    ((FriendHandler)a()).notifyUI(12, false, paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.handler.recevier.GetUserAddFriendSettingReceiver
 * JD-Core Version:    0.7.0.1
 */