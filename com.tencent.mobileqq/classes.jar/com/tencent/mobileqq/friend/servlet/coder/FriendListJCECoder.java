package com.tencent.mobileqq.friend.servlet.coder;

import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.friend.data.FriendListRequestData;
import com.tencent.mobileqq.friend.data.GroupRequestData;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.AddGroup;
import friendlist.DelGroup;
import friendlist.GetFriendListReq;
import friendlist.GetFriendListResp;
import friendlist.ReSortGroup;
import friendlist.RenameGroup;
import friendlist.SetGroupReq;
import friendlist.SetGroupResp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xd50.Oidb_0xd50.ReqBody;
import tencent.im.oidb.cmd0xd6b.Oidb_0xd6b.ReqBody;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/friend/servlet/coder/FriendListJCECoder;", "Lcom/tencent/mobileqq/friend/servlet/coder/BaseJCECoder;", "()V", "decode", "", "request", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "decodeFriendListResponse", "decodeGroupResponse", "encode", "", "client", "Lcom/qq/jce/wup/UniPacket;", "encodeFriendListRequest", "encodeGroupRequest", "getCmdList", "", "", "()[Ljava/lang/String;", "Companion", "IMCore_release"}, k=1, mv={1, 1, 16})
public final class FriendListJCECoder
  extends BaseJCECoder
{
  public static final FriendListJCECoder.Companion a = new FriendListJCECoder.Companion(null);
  
  private final Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendListJCECoder", 2, "decodeFriendListResponse");
    }
    return a(paramFromServiceMsg.getWupBuffer(), "FLRESP", new GetFriendListResp());
  }
  
  private final boolean b(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    Serializable localSerializable = paramToServiceMsg.extraData.getSerializable(Reflection.getOrCreateKotlinClass(FriendListRequestData.class).getSimpleName());
    if ((localSerializable instanceof FriendListRequestData))
    {
      Oidb_0xd50.ReqBody localReqBody = new Oidb_0xd50.ReqBody();
      localReqBody.appid.set(10002);
      localReqBody.req_music_switch.set(1);
      localReqBody.req_ksing_switch.set(1);
      localReqBody.req_mutualmark_lbsshare.set(1);
      localReqBody.req_mutualmark_alienation.set(1);
      localReqBody.req_aio_quick_app.set(1);
      Oidb_0xd6b.ReqBody localReqBody1 = new Oidb_0xd6b.ReqBody();
      GetFriendListReq localGetFriendListReq = new GetFriendListReq();
      localGetFriendListReq.reqtype = 3;
      localGetFriendListReq.ifReflush = ((FriendListRequestData)localSerializable).getIfReflushParam();
      paramToServiceMsg = paramToServiceMsg.getUin();
      Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "request.uin");
      localGetFriendListReq.uin = Long.parseLong(paramToServiceMsg);
      localGetFriendListReq.startIndex = ((short)((FriendListRequestData)localSerializable).getFriendStartIndex());
      localGetFriendListReq.getfriendCount = ((short)((FriendListRequestData)localSerializable).getFriendCount());
      localGetFriendListReq.groupid = 0;
      localGetFriendListReq.ifGetGroupInfo = ((FriendListRequestData)localSerializable).getIfGetGroupInfoParam();
      localGetFriendListReq.groupstartIndex = ((byte)((FriendListRequestData)localSerializable).getGroupStartIndex());
      localGetFriendListReq.getgroupCount = ((byte)((FriendListRequestData)localSerializable).getGroupCount());
      localGetFriendListReq.ifGetMSFGroup = 0;
      localGetFriendListReq.ifShowTermType = ((byte)((FriendListRequestData)localSerializable).getShowTermType());
      localGetFriendListReq.version = 31L;
      localGetFriendListReq.uinList = ((FriendListRequestData)localSerializable).getUinListParam();
      localGetFriendListReq.eAppType = 0;
      localGetFriendListReq.ifGetDOVId = 0;
      localGetFriendListReq.ifGetBothFlag = 0;
      localGetFriendListReq.vec0xd50Req = localReqBody.toByteArray();
      localGetFriendListReq.vec0xd6bReq = localReqBody1.toByteArray();
      localGetFriendListReq.vecSnsTypelist = ((FriendListRequestData)localSerializable).getSNSTypeList();
      paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
      paramUniPacket.setFuncName("GetFriendListReq");
      paramUniPacket.put("FL", localGetFriendListReq);
      if (QLog.isColorLevel()) {
        QLog.d("IMCore.friend.FriendListJCECoder", 2, "encodeFriendListRequest");
      }
      return true;
    }
    QLog.d("IMCore.friend.FriendListJCECoder", 1, "encodeFriendListRequest| requestData is not FriendListRequestData");
    return false;
  }
  
  private final Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return a(paramFromServiceMsg.getWupBuffer(), "SetGroupResp", new SetGroupResp());
  }
  
  private final boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("SetGroupReq");
    SetGroupReq localSetGroupReq = new SetGroupReq();
    Object localObject2;
    try
    {
      localObject1 = paramToServiceMsg.getUin();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "request.uin");
      localSetGroupReq.uin = Long.parseLong((String)localObject1);
      localObject2 = paramToServiceMsg.extraData.getSerializable(Reflection.getOrCreateKotlinClass(GroupRequestData.class).getSimpleName());
      if (!(localObject2 instanceof GroupRequestData))
      {
        QLog.e("IMCore.friend.FriendListJCECoder", 1, "encodeGroupRequest, requestData is not GroupRequestData");
        return false;
      }
    }
    catch (NumberFormatException paramToServiceMsg)
    {
      QLog.e("IMCore.friend.FriendListJCECoder", 1, "encodeGroupRequest", (Throwable)paramToServiceMsg);
      return false;
    }
    localSetGroupReq.reqtype = ((GroupRequestData)localObject2).getReqType();
    paramToServiceMsg = new ByteArrayOutputStream(10);
    Object localObject1 = new DataOutputStream((OutputStream)paramToServiceMsg);
    try
    {
      Object localObject3;
      Charset localCharset;
      switch (((GroupRequestData)localObject2).getReqType())
      {
      case 0: 
        localObject3 = new AddGroup();
        ((AddGroup)localObject3).cSortId = ((GroupRequestData)localObject2).getSortId();
        ((AddGroup)localObject3).sGroupName = ((GroupRequestData)localObject2).getName();
        localObject2 = ((AddGroup)localObject3).sGroupName;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "addreq.sGroupName");
        localCharset = Charsets.UTF_8;
        if (localObject2 == null) {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        localObject2 = ((String)localObject2).getBytes(localCharset);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.String).getBytes(charset)");
        ((AddGroup)localObject3).cLen = ((byte)localObject2.length);
        ((DataOutputStream)localObject1).writeByte(((AddGroup)localObject3).cSortId);
        ((DataOutputStream)localObject1).writeByte(((AddGroup)localObject3).cLen);
        ((DataOutputStream)localObject1).write((byte[])localObject2);
      case 1: 
      case 2: 
        for (;;)
        {
          ((DataOutputStream)localObject1).close();
          localSetGroupReq.vecBody = paramToServiceMsg.toByteArray();
          paramUniPacket.put("SetGroupReq", localSetGroupReq);
          return true;
          localObject3 = new RenameGroup();
          ((RenameGroup)localObject3).cGroupId = ((GroupRequestData)localObject2).getGroupId();
          ((RenameGroup)localObject3).sGroupName = ((GroupRequestData)localObject2).getName();
          localObject2 = ((RenameGroup)localObject3).sGroupName;
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "renamereq.sGroupName");
          localCharset = Charsets.UTF_8;
          if (localObject2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
          }
          localObject2 = ((String)localObject2).getBytes(localCharset);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.String).getBytes(charset)");
          ((RenameGroup)localObject3).cLen = ((byte)localObject2.length);
          ((DataOutputStream)localObject1).write(((RenameGroup)localObject3).cGroupId);
          ((DataOutputStream)localObject1).writeByte(((RenameGroup)localObject3).cLen);
          ((DataOutputStream)localObject1).write((byte[])localObject2);
          continue;
          localObject3 = new DelGroup();
          ((DelGroup)localObject3).cGroupId = ((GroupRequestData)localObject2).getGroupId();
          ((DataOutputStream)localObject1).writeByte(((DelGroup)localObject3).cGroupId);
        }
      case 3: 
        localObject3 = new ReSortGroup();
        ((ReSortGroup)localObject3).cGroupId = ((GroupRequestData)localObject2).getGroupIdList();
        ((ReSortGroup)localObject3).cSortId = ((GroupRequestData)localObject2).getSortIdList();
        ((ReSortGroup)localObject3).cNum = ((byte)((ReSortGroup)localObject3).cGroupId.length);
        ((DataOutputStream)localObject1).writeByte(((ReSortGroup)localObject3).cNum);
        localObject2 = ((ReSortGroup)localObject3).cGroupId;
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "resortreq.cGroupId");
        localObject3 = ((ReSortGroup)localObject3).cSortId;
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "resortreq.cSortId");
        int i = 0;
        while (i < localObject2.length)
        {
          ((DataOutputStream)localObject1).writeByte(localObject2[i]);
          ((DataOutputStream)localObject1).writeByte(localObject3[i]);
          i += 1;
        }
      }
      return false;
    }
    catch (IOException paramToServiceMsg) {}
    return false;
  }
  
  @Nullable
  public Object a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "request");
    Intrinsics.checkParameterIsNotNull(paramFromServiceMsg, "response");
    String str = paramFromServiceMsg.getServiceCmd();
    if (str == null) {}
    do
    {
      do
      {
        for (;;)
        {
          return Boolean.valueOf(false);
          switch (str.hashCode())
          {
          }
        }
      } while (!str.equals("friendlist.getFriendGroupList"));
      return b(paramToServiceMsg, paramFromServiceMsg);
    } while (!str.equals("friendlist.SetGroupReq"));
    return c(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public boolean a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull UniPacket paramUniPacket)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "request");
    Intrinsics.checkParameterIsNotNull(paramUniPacket, "client");
    String str = paramToServiceMsg.getServiceCmd();
    if (str == null) {}
    do
    {
      do
      {
        for (;;)
        {
          return false;
          switch (str.hashCode())
          {
          }
        }
      } while (!str.equals("friendlist.getFriendGroupList"));
      return b(paramToServiceMsg, paramUniPacket);
    } while (!str.equals("friendlist.SetGroupReq"));
    return c(paramToServiceMsg, paramUniPacket);
  }
  
  @NotNull
  public String[] a()
  {
    return new String[] { "friendlist.getFriendGroupList", "friendlist.SetGroupReq" };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.friend.servlet.coder.FriendListJCECoder
 * JD-Core Version:    0.7.0.1
 */