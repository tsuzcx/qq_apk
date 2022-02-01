package com.tencent.mobileqq.friend.handler.recevier;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.friend.api.impl.FriendDataServiceImpl;
import com.tencent.mobileqq.friend.data.GroupRequestData;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.ReSortGroupResp;
import friendlist.RenameGroupResp;
import friendlist.SetGroupResp;
import java.io.Serializable;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/friend/handler/recevier/SetGroupReceiver;", "Lcom/tencent/mobileqq/friend/handler/recevier/BaseProtocolReceiver;", "Lcom/tencent/mobileqq/friend/handler/FriendHandler;", "appRuntime", "Lcom/tencent/common/app/AppInterface;", "handler", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/friend/handler/FriendHandler;)V", "getCmd", "", "handleAddGroup", "", "resultCode", "", "errorStr", "buffer", "Ljava/nio/ByteBuffer;", "requestData", "Lcom/tencent/mobileqq/friend/data/GroupRequestData;", "handleDelGroup", "handleRenameGroup", "handleResortGroup", "handleSetGroupRequestFailed", "reqType", "receive", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "Companion", "IMCore_release"}, k=1, mv={1, 1, 16})
public final class SetGroupReceiver
  extends BaseProtocolReceiver<FriendHandler>
{
  public static final SetGroupReceiver.Companion a = new SetGroupReceiver.Companion(null);
  
  public SetGroupReceiver(@NotNull AppInterface paramAppInterface, @NotNull FriendHandler paramFriendHandler)
  {
    super(paramAppInterface, (BusinessHandler)paramFriendHandler);
  }
  
  private final void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleSetGroupRequestFailed| reqType: ");
    localStringBuilder.append(paramInt);
    QLog.d("IMCore.friend.SetGroupReceiver", 1, localStringBuilder.toString());
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleSetGroupFail| error reqType: ");
            localStringBuilder.append(paramInt);
            QLog.e("IMCore.friend.SetGroupReceiver", 1, localStringBuilder.toString());
            return;
          }
          ((FriendHandler)c()).notifyUI(22, false, null);
          return;
        }
        ((FriendHandler)c()).notifyUI(21, false, null);
        return;
      }
      ((FriendHandler)c()).notifyUI(19, false, null);
      return;
    }
    ((FriendHandler)c()).notifyUI(18, false, null);
  }
  
  private final void a(int paramInt, String paramString, ByteBuffer paramByteBuffer, GroupRequestData paramGroupRequestData)
  {
    AddGroupResp localAddGroupResp = new AddGroupResp();
    boolean bool = true;
    if (paramInt == 0)
    {
      FriendDataServiceImpl localFriendDataServiceImpl = FriendDataServiceImpl.getService((AppRuntime)b());
      localAddGroupResp.dwToUin = paramByteBuffer.getInt();
      localAddGroupResp.dwSequence = paramByteBuffer.getInt();
      localAddGroupResp.cGroupId = paramByteBuffer.get();
      localAddGroupResp.cSortId = paramByteBuffer.get();
      Groups localGroups = localFriendDataServiceImpl.getGroup(localAddGroupResp.cGroupId, true);
      paramByteBuffer = localGroups;
      if (localGroups == null) {
        paramByteBuffer = new Groups();
      }
      paramByteBuffer.group_id = localAddGroupResp.cGroupId;
      paramByteBuffer.seqid = localAddGroupResp.cSortId;
      paramByteBuffer.group_name = paramGroupRequestData.getName();
      localFriendDataServiceImpl.saveGroup(paramByteBuffer);
    }
    paramByteBuffer = new GroupActionResp(paramInt, paramString, localAddGroupResp);
    paramGroupRequestData = (FriendHandler)c();
    if (paramInt != 0) {
      bool = false;
    }
    paramGroupRequestData.notifyUI(18, bool, paramByteBuffer);
    if (QLog.isColorLevel())
    {
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("handleAddGroup| resultCode = ");
      paramByteBuffer.append(paramInt);
      paramByteBuffer.append(", errorStr = ");
      paramByteBuffer.append(paramString);
      QLog.d("IMCore.friend.SetGroupReceiver", 2, paramByteBuffer.toString());
    }
  }
  
  private final void b(int paramInt, String paramString, ByteBuffer paramByteBuffer, GroupRequestData paramGroupRequestData)
  {
    RenameGroupResp localRenameGroupResp = new RenameGroupResp();
    boolean bool = true;
    if (paramInt == 0)
    {
      FriendDataServiceImpl localFriendDataServiceImpl = FriendDataServiceImpl.getService((AppRuntime)b());
      localRenameGroupResp.dwToUin = paramByteBuffer.getInt();
      localRenameGroupResp.dwSequence = paramByteBuffer.getInt();
      int i = paramByteBuffer.get();
      localRenameGroupResp.cLen = paramByteBuffer.get();
      paramGroupRequestData = new byte[localRenameGroupResp.cLen];
      paramByteBuffer.get(paramGroupRequestData, 0, localRenameGroupResp.cLen);
      localRenameGroupResp.sGroupName = new String(paramGroupRequestData, Charsets.UTF_8);
      paramGroupRequestData = localFriendDataServiceImpl.getGroup(i, true);
      paramByteBuffer = paramGroupRequestData;
      if (paramGroupRequestData == null)
      {
        paramByteBuffer = new Groups();
        paramByteBuffer.group_id = ((int)localRenameGroupResp.dwSequence);
      }
      paramByteBuffer.group_name = localRenameGroupResp.sGroupName;
      localFriendDataServiceImpl.saveGroup(paramByteBuffer);
    }
    paramByteBuffer = new GroupActionResp(paramInt, paramString, localRenameGroupResp);
    paramGroupRequestData = (FriendHandler)c();
    if (paramInt != 0) {
      bool = false;
    }
    paramGroupRequestData.notifyUI(19, bool, paramByteBuffer);
    if (QLog.isColorLevel())
    {
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("handleRenameGroup| resultCode = ");
      paramByteBuffer.append(paramInt);
      paramByteBuffer.append(", errorStr = ");
      paramByteBuffer.append(paramString);
      QLog.d("IMCore.friend.SetGroupReceiver", 2, paramByteBuffer.toString());
    }
  }
  
  private final void c(int paramInt, String paramString, ByteBuffer paramByteBuffer, GroupRequestData paramGroupRequestData)
  {
    paramGroupRequestData = new DelGroupResp();
    boolean bool = false;
    if (paramInt == 0)
    {
      FriendDataServiceImpl localFriendDataServiceImpl = FriendDataServiceImpl.getService((AppRuntime)b());
      paramGroupRequestData.dwToUin = paramByteBuffer.getInt();
      paramGroupRequestData.dwSequence = paramByteBuffer.getInt();
      paramGroupRequestData.cGroupid = paramByteBuffer.get();
      localFriendDataServiceImpl.moveGroup(paramGroupRequestData.cGroupid, 0);
    }
    paramByteBuffer = new GroupActionResp(paramInt, paramString, paramGroupRequestData);
    paramGroupRequestData = (FriendHandler)c();
    if (paramInt == 0) {
      bool = true;
    }
    paramGroupRequestData.notifyUI(21, bool, paramByteBuffer);
    if (QLog.isColorLevel())
    {
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("handleDelGroup| resultCode = ");
      paramByteBuffer.append(paramInt);
      paramByteBuffer.append(", errorStr = ");
      paramByteBuffer.append(paramString);
      QLog.d("IMCore.friend.SetGroupReceiver", 2, paramByteBuffer.toString());
    }
  }
  
  private final void d(int paramInt, String paramString, ByteBuffer paramByteBuffer, GroupRequestData paramGroupRequestData)
  {
    ReSortGroupResp localReSortGroupResp = new ReSortGroupResp();
    if (paramInt == 0)
    {
      FriendDataServiceImpl localFriendDataServiceImpl = FriendDataServiceImpl.getService((AppRuntime)b());
      localReSortGroupResp.dwToUin = paramByteBuffer.getInt();
      localReSortGroupResp.dwSequence = paramByteBuffer.getInt();
      localFriendDataServiceImpl.updateGroupSortIds(paramGroupRequestData.getGroupIdList(), paramGroupRequestData.getSortIdList());
    }
    paramByteBuffer = new GroupActionResp(paramInt, paramString, localReSortGroupResp);
    paramGroupRequestData = (FriendHandler)c();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramGroupRequestData.notifyUI(22, bool, paramByteBuffer);
    if (QLog.isColorLevel())
    {
      paramByteBuffer = new StringBuilder();
      paramByteBuffer.append("handleResortGroup| resultCode = ");
      paramByteBuffer.append(paramInt);
      paramByteBuffer.append(", errorStr = ");
      paramByteBuffer.append(paramString);
      QLog.d("IMCore.friend.SetGroupReceiver", 2, paramByteBuffer.toString());
    }
  }
  
  @NotNull
  public String a()
  {
    return "friendlist.SetGroupReq";
  }
  
  public void a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "req");
    Intrinsics.checkParameterIsNotNull(paramFromServiceMsg, "res");
    Serializable localSerializable = paramToServiceMsg.extraData.getSerializable(Reflection.getOrCreateKotlinClass(GroupRequestData.class).getSimpleName());
    if (!(localSerializable instanceof GroupRequestData))
    {
      QLog.e("IMCore.friend.SetGroupReceiver", 1, "encodeGroupRequest, requestData is not GroupRequestData");
      return;
    }
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof SetGroupResp)))
    {
      paramObject = (SetGroupResp)paramObject;
      paramToServiceMsg = ByteBuffer.wrap(paramObject.vecBody);
      paramFromServiceMsg = (GroupRequestData)localSerializable;
      int i = paramFromServiceMsg.getReqType();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              paramToServiceMsg = new StringBuilder();
              paramToServiceMsg.append("receiveSetGroupResponse| error reqType: ");
              paramToServiceMsg.append(paramFromServiceMsg.getReqType());
              QLog.e("IMCore.friend.SetGroupReceiver", 1, paramToServiceMsg.toString());
              return;
            }
            i = paramObject.result;
            paramObject = paramObject.ErrorString;
            Intrinsics.checkExpressionValueIsNotNull(paramObject, "data.ErrorString");
            Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "buffer");
            d(i, paramObject, paramToServiceMsg, paramFromServiceMsg);
            return;
          }
          i = paramObject.result;
          paramObject = paramObject.ErrorString;
          Intrinsics.checkExpressionValueIsNotNull(paramObject, "data.ErrorString");
          Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "buffer");
          c(i, paramObject, paramToServiceMsg, paramFromServiceMsg);
          return;
        }
        i = paramObject.result;
        paramObject = paramObject.ErrorString;
        Intrinsics.checkExpressionValueIsNotNull(paramObject, "data.ErrorString");
        Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "buffer");
        b(i, paramObject, paramToServiceMsg, paramFromServiceMsg);
        return;
      }
      i = paramObject.result;
      paramObject = paramObject.ErrorString;
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "data.ErrorString");
      Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "buffer");
      a(i, paramObject, paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    paramToServiceMsg = new StringBuilder();
    paramToServiceMsg.append("receiveSetGroupResponse| fail ");
    paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
    QLog.d("IMCore.friend.SetGroupReceiver", 1, paramToServiceMsg.toString());
    a(((GroupRequestData)localSerializable).getReqType());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.handler.recevier.SetGroupReceiver
 * JD-Core Version:    0.7.0.1
 */