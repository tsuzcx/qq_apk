package com.tencent.mobileqq.friend.servlet.coder;

import android.os.Bundle;
import android.text.TextUtils;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.AddFriendReq;
import friendlist.AddFriendResp;
import friendlist.EAddFriendSourceID;
import friendlist.GetAutoInfoReq;
import friendlist.GetAutoInfoResp;
import friendlist.GetUserAddFriendSettingReq;
import friendlist.GetUserAddFriendSettingResp;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.DiscussInfo;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.FriendSysMsg;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.GroupInfo;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.GroupInfoExt;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.InviteInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/friend/servlet/coder/FriendAddJCECoder;", "Lcom/tencent/mobileqq/friend/servlet/coder/BaseJCECoder;", "()V", "convertUin", "", "uin", "", "decode", "", "request", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "decodeAddFriendResponse", "decodeGetAutoInfo", "req", "resp", "decodeGetUserAddFriendSetting", "responseWUP", "encode", "", "client", "Lcom/qq/jce/wup/UniPacket;", "encodeAddFriendRequest", "encodeGetAutoInfoReq", "encodeGetUserAddFriendSetting", "getCmdList", "", "()[Ljava/lang/String;", "Companion", "IMCore_release"}, k=1, mv={1, 1, 16})
public final class FriendAddJCECoder
  extends BaseJCECoder
{
  public static final FriendAddJCECoder.Companion a = new FriendAddJCECoder.Companion(null);
  
  private final long a(String paramString)
  {
    long l = 0L;
    if (paramString != null)
    {
      int i;
      if (((CharSequence)paramString).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        return 0L;
      }
    }
    try
    {
      l = Long.parseLong(paramString);
      if (l < 10000) {
        return 0L;
      }
      return l;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
  
  private final Object b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return a(paramFromServiceMsg.getWupBuffer(), "GAIRESP", new GetAutoInfoResp());
  }
  
  private final Object c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    return a(paramFromServiceMsg.getWupBuffer(), "FSRESP", new GetUserAddFriendSettingResp());
  }
  
  private final Object d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.friend.FriendAddJCECoder", 2, "decodeAddFriendResponse");
    }
    return a(paramFromServiceMsg.getWupBuffer(), "AFRESP", new AddFriendResp());
  }
  
  @Nullable
  public Object a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "request");
    Intrinsics.checkParameterIsNotNull(paramFromServiceMsg, "response");
    String str = paramToServiceMsg.getServiceCmd();
    if (str != null)
    {
      int i = str.hashCode();
      if (i != 78555965)
      {
        if (i != 843392877)
        {
          if ((i == 1200127328) && (str.equals("friendlist.getUserAddFriendSetting"))) {
            return c(paramToServiceMsg, paramFromServiceMsg);
          }
        }
        else if (str.equals("friendlist.addFriend")) {
          return d(paramToServiceMsg, paramFromServiceMsg);
        }
      }
      else if (str.equals("friendlist.GetAutoInfoReq")) {
        return b(paramToServiceMsg, paramFromServiceMsg);
      }
    }
    QLog.e("IMCore.friend.FriendAddJCECoder", 1, "can not decode for this cmd");
    return null;
  }
  
  public boolean a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull UniPacket paramUniPacket)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "request");
    Intrinsics.checkParameterIsNotNull(paramUniPacket, "client");
    String str = paramToServiceMsg.getServiceCmd();
    if (str != null)
    {
      int i = str.hashCode();
      if (i != 78555965)
      {
        if (i != 843392877)
        {
          if ((i == 1200127328) && (str.equals("friendlist.getUserAddFriendSetting"))) {
            return c(paramToServiceMsg, paramUniPacket);
          }
        }
        else if (str.equals("friendlist.addFriend")) {
          return d(paramToServiceMsg, paramUniPacket);
        }
      }
      else if (str.equals("friendlist.GetAutoInfoReq")) {
        return b(paramToServiceMsg, paramUniPacket);
      }
    }
    QLog.e("IMCore.friend.FriendAddJCECoder", 1, "can not encode for this cmd");
    return false;
  }
  
  @NotNull
  public String[] a()
  {
    return new String[] { "friendlist.addFriend", "friendlist.getUserAddFriendSetting", "friendlist.GetAutoInfoReq" };
  }
  
  public final boolean b(@NotNull ToServiceMsg paramToServiceMsg, @NotNull UniPacket paramUniPacket)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "request");
    Intrinsics.checkParameterIsNotNull(paramUniPacket, "client");
    GetAutoInfoReq localGetAutoInfoReq = new GetAutoInfoReq();
    localGetAutoInfoReq.uin = a(paramToServiceMsg.getUin());
    localGetAutoInfoReq.dwFriendUin = a(paramToServiceMsg.extraData.getString("uin"));
    localGetAutoInfoReq.cType = paramToServiceMsg.extraData.getByte("cType");
    localGetAutoInfoReq.sourceID = paramToServiceMsg.extraData.getInt("source_id", 3999);
    localGetAutoInfoReq.sourceSubID = paramToServiceMsg.extraData.getInt("sub_source_id", 0);
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetAutoInfoReq");
    paramUniPacket.put("GAIREQ", localGetAutoInfoReq);
    return true;
  }
  
  public final boolean c(@NotNull ToServiceMsg paramToServiceMsg, @NotNull UniPacket paramUniPacket)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "request");
    Intrinsics.checkParameterIsNotNull(paramUniPacket, "client");
    long l = a(paramToServiceMsg.getUin());
    if (l == 0L) {
      return false;
    }
    paramToServiceMsg = paramToServiceMsg.extraData;
    int i = paramToServiceMsg.getInt("source_id");
    int j = paramToServiceMsg.getInt("sub_source_id");
    Object localObject1 = paramToServiceMsg.getString("uin");
    Object localObject2 = paramToServiceMsg.getString("extra");
    paramToServiceMsg = new GetUserAddFriendSettingReq();
    paramToServiceMsg.version = 1L;
    paramToServiceMsg.uin = l;
    paramToServiceMsg.sourceID = i;
    if (EAddFriendSourceID.a(i))
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "friendUin");
      localObject2 = Charsets.UTF_8;
      if (localObject1 != null)
      {
        localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
        paramToServiceMsg.name = ((byte[])localObject1);
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    else if ((i != 3016) && (i != 3090) && (i != 3024))
    {
      if (i == 3026)
      {
        paramToServiceMsg.sourceSubID = j;
        if (j == 0)
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "friendUin");
          localObject2 = Charsets.UTF_8;
          if (localObject1 != null)
          {
            localObject1 = ((String)localObject1).getBytes((Charset)localObject2);
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
            paramToServiceMsg.name = ((byte[])localObject1);
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
          }
        }
        else
        {
          l = a((String)localObject1);
          if (l == 0L) {
            return false;
          }
          paramToServiceMsg.queryuin = l;
        }
      }
      else
      {
        l = a((String)localObject1);
        if (l == 0L) {
          return false;
        }
        paramToServiceMsg.queryuin = l;
      }
    }
    else
    {
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        return false;
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "friendUin");
      Charset localCharset = Charsets.UTF_8;
      if (localObject1 == null) {
        break label434;
      }
      localObject1 = ((String)localObject1).getBytes(localCharset);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
      paramToServiceMsg.name = ((byte[])localObject1);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "extraUin");
      localObject1 = Charsets.UTF_8;
      if (localObject2 == null) {
        break label423;
      }
      localObject1 = ((String)localObject2).getBytes((Charset)localObject1);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
      paramToServiceMsg.name1 = ((byte[])localObject1);
      paramToServiceMsg.sourceSubID = j;
    }
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("GetUserAddFriendSettingReq");
    paramUniPacket.put("FS", paramToServiceMsg);
    return true;
    label423:
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    label434:
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public final boolean d(@NotNull ToServiceMsg paramToServiceMsg, @NotNull UniPacket paramUniPacket)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "request");
    Intrinsics.checkParameterIsNotNull(paramUniPacket, "client");
    long l1 = a(paramToServiceMsg.getUin());
    if (l1 == 0L) {
      return false;
    }
    Bundle localBundle = paramToServiceMsg.extraData;
    Object localObject1 = localBundle.getString("uin");
    int i = localBundle.getInt("source_id", 3999);
    int j = localBundle.getInt("sub_source_id", 0);
    AddFriendReq localAddFriendReq = new AddFriendReq();
    localAddFriendReq.uin = l1;
    localAddFriendReq.sourceID = i;
    localAddFriendReq.sourceSubID = j;
    if ((i != 3016) && (i != 3090) && (i != 3024))
    {
      if (EAddFriendSourceID.a(i)) {
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "addUin");
          paramToServiceMsg = Charsets.UTF_8;
          if (localObject1 != null)
          {
            paramToServiceMsg = ((String)localObject1).getBytes(paramToServiceMsg);
            Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "(this as java.lang.String).getBytes(charset)");
          }
        }
      }
      for (localAddFriendReq.name = paramToServiceMsg;; localAddFriendReq.name = paramToServiceMsg)
      {
        paramToServiceMsg = "(this as java.lang.String).getBytes(charset)";
        break label988;
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        return false;
        if (i != 3026) {
          break label316;
        }
        if (j != 0) {
          break label278;
        }
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label276;
        }
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "addUin");
        paramToServiceMsg = Charsets.UTF_8;
        if (localObject1 == null) {
          break;
        }
        paramToServiceMsg = ((String)localObject1).getBytes(paramToServiceMsg);
        Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "(this as java.lang.String).getBytes(charset)");
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      label276:
      return false;
      label278:
      long l2 = a((String)localObject1);
      if ((l2 != 0L) && (l1 != l2))
      {
        localAddFriendReq.adduin = l2;
      }
      else
      {
        return false;
        label316:
        paramToServiceMsg = "troop_uin";
        l1 = a((String)localObject1);
        if (l1 == 0L) {
          return false;
        }
        localAddFriendReq.adduin = l1;
        if (i != 3004) {
          break label410;
        }
        paramToServiceMsg = localBundle.getString("extra");
        if ((paramToServiceMsg != null) && (paramToServiceMsg.length() > 0))
        {
          localObject2 = new FrdSysMsg.GroupInfo();
          ((FrdSysMsg.GroupInfo)localObject2).uint64_group_uin.set(a(paramToServiceMsg));
          localAddFriendReq.friend_src_desc = ((FrdSysMsg.GroupInfo)localObject2).toByteArray();
        }
      }
      for (;;)
      {
        paramToServiceMsg = "(this as java.lang.String).getBytes(charset)";
        break label988;
        label410:
        if (i == 3005)
        {
          paramToServiceMsg = localBundle.getString("extra");
          localObject2 = new FrdSysMsg.DiscussInfo();
          ((FrdSysMsg.DiscussInfo)localObject2).uint64_discuss_uin.set(a(paramToServiceMsg));
          localAddFriendReq.friend_src_desc = ((FrdSysMsg.DiscussInfo)localObject2).toByteArray();
        }
        else
        {
          if (i != 3037) {
            break;
          }
          paramToServiceMsg = localBundle.getString(paramToServiceMsg);
          if (!TextUtils.isEmpty((CharSequence)paramToServiceMsg))
          {
            localObject2 = new FrdSysMsg.FriendSysMsg();
            localObject4 = new FrdSysMsg.GroupInfoExt();
            ((FrdSysMsg.GroupInfoExt)localObject4).uint64_group_code.set(a(paramToServiceMsg));
            ((FrdSysMsg.FriendSysMsg)localObject2).msg_group_ext.set((MessageMicro)localObject4);
            localAddFriendReq.friend_src_desc = ((FrdSysMsg.FriendSysMsg)localObject2).toByteArray();
            break label860;
          }
        }
      }
      if (i == 3042)
      {
        paramToServiceMsg = localBundle.getString(paramToServiceMsg);
        int k = localBundle.getInt("flc_notify_type");
        localObject2 = localBundle.getString("flc_recommend_uin");
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)paramToServiceMsg)))
        {
          localObject4 = new FrdSysMsg.FriendSysMsg();
          localObject5 = new FrdSysMsg.GroupInfoExt();
          ((FrdSysMsg.GroupInfoExt)localObject5).uint64_group_code.set(a(paramToServiceMsg));
          ((FrdSysMsg.GroupInfoExt)localObject5).uint32_notify_type.set(k);
          paramToServiceMsg = new FrdSysMsg.InviteInfo();
          paramToServiceMsg.uint64_recommend_uin.set(a((String)localObject2));
          ((FrdSysMsg.FriendSysMsg)localObject4).msg_group_ext.set((MessageMicro)localObject5);
          ((FrdSysMsg.FriendSysMsg)localObject4).msg_intite_info.set((MessageMicro)paramToServiceMsg);
          localAddFriendReq.friend_src_desc = ((FrdSysMsg.FriendSysMsg)localObject4).toByteArray();
        }
        else if (!TextUtils.isEmpty((CharSequence)paramToServiceMsg))
        {
          localObject2 = new FrdSysMsg.FriendSysMsg();
          localObject4 = new FrdSysMsg.GroupInfoExt();
          ((FrdSysMsg.GroupInfoExt)localObject4).uint64_group_code.set(a(paramToServiceMsg));
          ((FrdSysMsg.GroupInfoExt)localObject4).uint32_notify_type.set(k);
          ((FrdSysMsg.FriendSysMsg)localObject2).msg_group_ext.set((MessageMicro)localObject4);
          localAddFriendReq.friend_src_desc = ((FrdSysMsg.FriendSysMsg)localObject2).toByteArray();
        }
      }
      else if (i == 3022)
      {
        paramToServiceMsg = localBundle.getString("flc_recommend_uin");
        if (!TextUtils.isEmpty((CharSequence)paramToServiceMsg))
        {
          localObject2 = new FrdSysMsg.FriendSysMsg();
          localObject4 = new FrdSysMsg.InviteInfo();
          ((FrdSysMsg.InviteInfo)localObject4).uint64_recommend_uin.set(a(paramToServiceMsg));
          ((FrdSysMsg.FriendSysMsg)localObject2).msg_intite_info.set((MessageMicro)localObject4);
          localAddFriendReq.friend_src_desc = ((FrdSysMsg.FriendSysMsg)localObject2).toByteArray();
        }
      }
      label860:
      paramToServiceMsg = "(this as java.lang.String).getBytes(charset)";
    }
    else
    {
      localObject2 = "null cannot be cast to non-null type java.lang.String";
      localObject4 = localBundle.getString("extra");
      if ((TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty((CharSequence)localObject4))) {
        break label2064;
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "addUin");
      paramToServiceMsg = Charsets.UTF_8;
      if (localObject1 == null) {
        break label2054;
      }
      localObject5 = ((String)localObject1).getBytes(paramToServiceMsg);
      paramToServiceMsg = "(this as java.lang.String).getBytes(charset)";
      Intrinsics.checkExpressionValueIsNotNull(localObject5, paramToServiceMsg);
      localAddFriendReq.name = ((byte[])localObject5);
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "troopUin");
      localObject5 = Charsets.UTF_8;
      if (localObject4 == null) {
        break label2044;
      }
      localObject2 = ((String)localObject4).getBytes((Charset)localObject5);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, paramToServiceMsg);
      localAddFriendReq.name1 = ((byte[])localObject2);
    }
    label988:
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder(300);
      ((StringBuilder)localObject2).append("handleAddFriend [uin: ");
      ((StringBuilder)localObject2).append(Utils.a((String)localObject1));
      ((StringBuilder)localObject2).append(", source_id: ");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(", sub_source_id: ");
      ((StringBuilder)localObject2).append(j);
      if (i == 3004)
      {
        ((StringBuilder)localObject2).append(", group_uin: ");
        ((StringBuilder)localObject2).append(localBundle.getString("extra"));
      }
      else if (i == 3005)
      {
        ((StringBuilder)localObject2).append(", discuss_uin: ");
        ((StringBuilder)localObject2).append(localBundle.getString("extra"));
      }
      else if (i == 3037)
      {
        ((StringBuilder)localObject2).append(", group_code: ");
        ((StringBuilder)localObject2).append(localBundle.getString("troop_uin"));
      }
      else if (i == 3042)
      {
        ((StringBuilder)localObject2).append(", group_code: ");
        ((StringBuilder)localObject2).append(localBundle.getString("troop_uin"));
        ((StringBuilder)localObject2).append(", notify_type: ");
        ((StringBuilder)localObject2).append(localBundle.getInt("flc_notify_type"));
        ((StringBuilder)localObject2).append(", recommend_uin: ");
        ((StringBuilder)localObject2).append(localBundle.getString("flc_recommend_uin"));
      }
      else if (i == 3022)
      {
        ((StringBuilder)localObject2).append(", recommend_uin: ");
        ((StringBuilder)localObject2).append(localBundle.getString("flc_recommend_uin"));
      }
      ((StringBuilder)localObject2).append(", friend_src_desc: ");
      if (localAddFriendReq.friend_src_desc == null) {
        i = 0;
      } else {
        i = localAddFriendReq.friend_src_desc.length;
      }
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("]");
      QLog.i("addFriendTag", 2, ((StringBuilder)localObject2).toString());
    }
    i = localBundle.getInt("friend_setting");
    byte b2 = localBundle.getByte("group_id");
    Object localObject2 = localBundle.getString("msg");
    boolean bool = localBundle.getBoolean("auto_send");
    Object localObject5 = localBundle.getByteArray("sig");
    byte b1;
    if ((localObject2 != null) && (((String)localObject2).length() > 0))
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() >= 127)
      {
        localObject1 = ((String)localObject2).substring(0, 126);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      localObject2 = Charsets.UTF_8;
      if (localObject1 != null)
      {
        localObject2 = ((String)localObject1).getBytes((Charset)localObject2);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, paramToServiceMsg);
        b1 = (byte)localObject2.length;
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    else
    {
      b1 = (byte)0;
      localObject1 = localObject2;
    }
    Object localObject4 = "null cannot be cast to non-null type java.lang.String";
    localAddFriendReq.adduinsetting = i;
    localAddFriendReq.myAllowFlag = ((byte)1);
    localAddFriendReq.msgLen = b1;
    if (localObject1 != null) {
      localAddFriendReq.msg = ((String)localObject1);
    }
    localAddFriendReq.myfriendgroupid = b2;
    localAddFriendReq.contact_bothway_friend = localBundle.getBoolean("contact_bothway", false);
    localAddFriendReq.showMyCard = localBundle.getByte("show_my_card");
    localObject2 = localBundle.getString("remark");
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = (byte[])null;
      try
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "remark");
        Charset localCharset = Charset.forName("utf-8");
        Intrinsics.checkExpressionValueIsNotNull(localCharset, "Charset.forName(charsetName)");
        if (localObject2 != null)
        {
          localObject2 = ((String)localObject2).getBytes(localCharset);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, paramToServiceMsg);
          localObject1 = localObject2;
        }
        else
        {
          throw new TypeCastException((String)localObject4);
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        localAddFriendReq.remark = ((byte[])localObject1);
      }
    }
    localAddFriendReq.autoSend = ((byte)bool);
    if (localObject5 != null) {
      localAddFriendReq.sig = ((byte[])localObject5);
    }
    localObject1 = localBundle.getByteArray("flc_add_frd_token");
    Object localObject3;
    if ((localObject1 != null) && (localObject1.length > 0))
    {
      localAddFriendReq.token = ((byte[])localObject1);
      if (QLog.isColorLevel())
      {
        localObject3 = StringCompanionObject.INSTANCE;
        localObject3 = new Object[1];
        localObject3[0] = Integer.valueOf(localObject1.length);
        localObject1 = String.format("handleAddFriend token: %s", Arrays.copyOf((Object[])localObject3, localObject3.length));
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
        QLog.i("addFriendTag", 2, (String)localObject1);
      }
    }
    localObject1 = localBundle.getString("security_ticket", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      try
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "ticket");
        localObject3 = Charset.forName("utf-8");
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "Charset.forName(charsetName)");
        if (localObject1 != null)
        {
          localObject3 = ((String)localObject1).getBytes((Charset)localObject3);
          Intrinsics.checkExpressionValueIsNotNull(localObject3, paramToServiceMsg);
          localAddFriendReq.verify = ((byte[])localObject3);
        }
        else
        {
          throw new TypeCastException((String)localObject4);
        }
      }
      catch (UnsupportedEncodingException paramToServiceMsg)
      {
        QLog.e("IMCore.friend.FriendAddJCECoder", 1, "handleAddFriend, ", (Throwable)paramToServiceMsg);
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = StringCompanionObject.INSTANCE;
          paramToServiceMsg = new Object[1];
          paramToServiceMsg[0] = Integer.valueOf(((String)localObject1).length());
          paramToServiceMsg = String.format("handleAddFriend token: %s", Arrays.copyOf(paramToServiceMsg, paramToServiceMsg.length));
          Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "java.lang.String.format(format, *args)");
          QLog.i("IMCore.friend.FriendAddJCECoder", 2, paramToServiceMsg);
        }
      }
    }
    if (localAddFriendReq.friend_src_desc == null)
    {
      paramToServiceMsg = localBundle.getByteArray("friend_src_desc");
      if (paramToServiceMsg != null)
      {
        localAddFriendReq.friend_src_desc = paramToServiceMsg;
        if (QLog.isColorLevel()) {
          QLog.i("IMCore.friend.FriendAddJCECoder", 2, "handleAddFriend has friend_src_desc extra");
        }
      }
    }
    localAddFriendReq.bSupportSecureTips = localBundle.getBoolean("security_ticket_support", false);
    localAddFriendReq.bSupportAddRelief = true;
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleAddFriend bSupportSecureTips: ");
      paramToServiceMsg.append(localAddFriendReq.bSupportSecureTips);
      QLog.i("IMCore.friend.FriendAddJCECoder", 2, paramToServiceMsg.toString());
    }
    paramUniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
    paramUniPacket.setFuncName("AddFriendReq");
    paramUniPacket.put("AF", localAddFriendReq);
    return true;
    label2044:
    throw new TypeCastException((String)localObject3);
    label2054:
    throw new TypeCastException((String)localObject3);
    label2064:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.friend.servlet.coder.FriendAddJCECoder
 * JD-Core Version:    0.7.0.1
 */