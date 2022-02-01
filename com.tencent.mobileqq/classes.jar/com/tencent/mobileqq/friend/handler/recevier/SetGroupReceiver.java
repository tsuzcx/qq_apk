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
    QLog.d("IMCore.friend.SetGroupReceiver", 1, "handleSetGroupRequestFailed| reqType: " + paramInt);
    switch (paramInt)
    {
    default: 
      QLog.e("IMCore.friend.SetGroupReceiver", 1, "handleSetGroupFail| error reqType: " + paramInt);
      return;
    case 0: 
      ((FriendHandler)a()).notifyUI(18, false, null);
      return;
    case 1: 
      ((FriendHandler)a()).notifyUI(19, false, null);
      return;
    case 2: 
      ((FriendHandler)a()).notifyUI(21, false, null);
      return;
    }
    ((FriendHandler)a()).notifyUI(22, false, null);
  }
  
  private final void a(int paramInt, String paramString, ByteBuffer paramByteBuffer, GroupRequestData paramGroupRequestData)
  {
    boolean bool = true;
    AddGroupResp localAddGroupResp = new AddGroupResp();
    if (paramInt == 0)
    {
      FriendDataServiceImpl localFriendDataServiceImpl = FriendDataServiceImpl.getService((AppRuntime)a());
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
    paramGroupRequestData = (FriendHandler)a();
    if (paramInt == 0) {}
    for (;;)
    {
      paramGroupRequestData.notifyUI(18, bool, paramByteBuffer);
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.SetGroupReceiver", 2, "handleAddGroup| resultCode = " + paramInt + ", errorStr = " + paramString);
      }
      return;
      bool = false;
    }
  }
  
  private final void b(int paramInt, String paramString, ByteBuffer paramByteBuffer, GroupRequestData paramGroupRequestData)
  {
    boolean bool = true;
    RenameGroupResp localRenameGroupResp = new RenameGroupResp();
    if (paramInt == 0)
    {
      FriendDataServiceImpl localFriendDataServiceImpl = FriendDataServiceImpl.getService((AppRuntime)a());
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
    paramGroupRequestData = (FriendHandler)a();
    if (paramInt == 0) {}
    for (;;)
    {
      paramGroupRequestData.notifyUI(19, bool, paramByteBuffer);
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.SetGroupReceiver", 2, "handleRenameGroup| resultCode = " + paramInt + ", errorStr = " + paramString);
      }
      return;
      bool = false;
    }
  }
  
  private final void c(int paramInt, String paramString, ByteBuffer paramByteBuffer, GroupRequestData paramGroupRequestData)
  {
    boolean bool = false;
    paramGroupRequestData = new DelGroupResp();
    if (paramInt == 0)
    {
      FriendDataServiceImpl localFriendDataServiceImpl = FriendDataServiceImpl.getService((AppRuntime)a());
      paramGroupRequestData.dwToUin = paramByteBuffer.getInt();
      paramGroupRequestData.dwSequence = paramByteBuffer.getInt();
      paramGroupRequestData.cGroupid = paramByteBuffer.get();
      localFriendDataServiceImpl.moveGroup(paramGroupRequestData.cGroupid, 0);
    }
    paramByteBuffer = new GroupActionResp(paramInt, paramString, paramGroupRequestData);
    paramGroupRequestData = (FriendHandler)a();
    if (paramInt == 0) {
      bool = true;
    }
    paramGroupRequestData.notifyUI(21, bool, paramByteBuffer);
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.SetGroupReceiver", 2, "handleDelGroup| resultCode = " + paramInt + ", errorStr = " + paramString);
    }
  }
  
  private final void d(int paramInt, String paramString, ByteBuffer paramByteBuffer, GroupRequestData paramGroupRequestData)
  {
    ReSortGroupResp localReSortGroupResp = new ReSortGroupResp();
    if (paramInt == 0)
    {
      FriendDataServiceImpl localFriendDataServiceImpl = FriendDataServiceImpl.getService((AppRuntime)a());
      localReSortGroupResp.dwToUin = paramByteBuffer.getInt();
      localReSortGroupResp.dwSequence = paramByteBuffer.getInt();
      localFriendDataServiceImpl.updateGroupSortIds(paramGroupRequestData.getGroupIdList(), paramGroupRequestData.getSortIdList());
    }
    paramByteBuffer = new GroupActionResp(paramInt, paramString, localReSortGroupResp);
    paramGroupRequestData = (FriendHandler)a();
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramGroupRequestData.notifyUI(22, bool, paramByteBuffer);
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.SetGroupReceiver", 2, "handleResortGroup| resultCode = " + paramInt + ", errorStr = " + paramString);
      }
      return;
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
    paramToServiceMsg = paramToServiceMsg.extraData.getSerializable(Reflection.getOrCreateKotlinClass(GroupRequestData.class).getSimpleName());
    if (!(paramToServiceMsg instanceof GroupRequestData))
    {
      QLog.e("IMCore.friend.SetGroupReceiver", 1, "encodeGroupRequest, requestData is not GroupRequestData");
      return;
    }
    if ((!paramFromServiceMsg.isSuccess()) || (!(paramObject instanceof SetGroupResp)))
    {
      QLog.d("IMCore.friend.SetGroupReceiver", 1, "receiveSetGroupResponse| fail " + paramFromServiceMsg.getResultCode());
      a(((GroupRequestData)paramToServiceMsg).getReqType());
      return;
    }
    paramFromServiceMsg = ByteBuffer.wrap(((SetGroupResp)paramObject).vecBody);
    switch (((GroupRequestData)paramToServiceMsg).getReqType())
    {
    default: 
      QLog.e("IMCore.friend.SetGroupReceiver", 1, "receiveSetGroupResponse| error reqType: " + ((GroupRequestData)paramToServiceMsg).getReqType());
      return;
    case 0: 
      i = ((SetGroupResp)paramObject).result;
      paramObject = ((SetGroupResp)paramObject).ErrorString;
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "data.ErrorString");
      Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "buffer");
      a(i, paramObject, paramFromServiceMsg, (GroupRequestData)paramToServiceMsg);
      return;
    case 1: 
      i = ((SetGroupResp)paramObject).result;
      paramObject = ((SetGroupResp)paramObject).ErrorString;
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "data.ErrorString");
      Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "buffer");
      b(i, paramObject, paramFromServiceMsg, (GroupRequestData)paramToServiceMsg);
      return;
    case 2: 
      i = ((SetGroupResp)paramObject).result;
      paramObject = ((SetGroupResp)paramObject).ErrorString;
      Intrinsics.checkExpressionValueIsNotNull(paramObject, "data.ErrorString");
      Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "buffer");
      c(i, paramObject, paramFromServiceMsg, (GroupRequestData)paramToServiceMsg);
      return;
    }
    int i = ((SetGroupResp)paramObject).result;
    paramObject = ((SetGroupResp)paramObject).ErrorString;
    Intrinsics.checkExpressionValueIsNotNull(paramObject, "data.ErrorString");
    Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "buffer");
    d(i, paramObject, paramFromServiceMsg, (GroupRequestData)paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.handler.recevier.SetGroupReceiver
 * JD-Core Version:    0.7.0.1
 */