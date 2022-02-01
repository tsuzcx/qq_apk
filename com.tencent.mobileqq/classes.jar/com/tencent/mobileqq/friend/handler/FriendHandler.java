package com.tencent.mobileqq.friend.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AddBatchPhoneFriendResult;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.friend.config.FriendConfig;
import com.tencent.mobileqq.friend.data.FriendListRequestData;
import com.tencent.mobileqq.friend.data.GroupRequestData;
import com.tencent.mobileqq.friend.handler.recevier.AddBatchPhoneFriendReceiver;
import com.tencent.mobileqq.friend.handler.recevier.BaseProtocolReceiver;
import com.tencent.mobileqq.friend.handler.recevier.FriendAddReceiver;
import com.tencent.mobileqq.friend.handler.recevier.FriendListReceiver;
import com.tencent.mobileqq.friend.handler.recevier.GetAutoInfoReceiver;
import com.tencent.mobileqq.friend.handler.recevier.GetInfoWithOpenIdReceiver;
import com.tencent.mobileqq.friend.handler.recevier.GetUserAddFriendSettingReceiver;
import com.tencent.mobileqq.friend.handler.recevier.QueryUinFlagReceiver;
import com.tencent.mobileqq.friend.handler.recevier.SetGroupReceiver;
import com.tencent.mobileqq.friend.helper.AddFrdTokenHelper;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.friend.processor.FriendBusinessProcessorFactory;
import com.tencent.mobileqq.friend.servlet.FriendService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0x829.oidb_0x829.ReqBody;
import tencent.im.oidb.oidb_0x5e1.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/friend/handler/FriendHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "app", "Lcom/tencent/common/app/AppInterface;", "(Lcom/tencent/common/app/AppInterface;)V", "addFrdTokenHelper", "Lcom/tencent/mobileqq/friend/helper/AddFrdTokenHelper;", "getAddFrdTokenHelper", "()Lcom/tencent/mobileqq/friend/helper/AddFrdTokenHelper;", "mBusinessProcessorFactory", "Lcom/tencent/mobileqq/friend/processor/FriendBusinessProcessorFactory;", "mBusinessProcessors", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/friend/processor/BaseFriendProcessor;", "getMBusinessProcessors", "()Ljava/util/ArrayList;", "setMBusinessProcessors", "(Ljava/util/ArrayList;)V", "mConfig", "Lcom/tencent/mobileqq/friend/config/FriendConfig;", "getMConfig", "()Lcom/tencent/mobileqq/friend/config/FriendConfig;", "mProtocolProcessors", "Lcom/tencent/mobileqq/friend/handler/recevier/BaseProtocolReceiver;", "Lkotlin/collections/ArrayList;", "mRequestFriendListTimestamp", "", "getMRequestFriendListTimestamp", "()J", "setMRequestFriendListTimestamp", "(J)V", "mService", "Lcom/tencent/mobileqq/friend/servlet/FriendService;", "getMService", "()Lcom/tencent/mobileqq/friend/servlet/FriendService;", "getCommandList", "", "", "initProtocolProcessors", "", "isRequestingFriendList", "", "observerClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "onReceive", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "requestAddBatchPhoneFriend", "phoneArr", "Lcom/tencent/mobileqq/data/PhoneContact;", "verifyMsg", "pkgIndex", "", "sourceId", "resultList", "Lcom/tencent/mobileqq/app/AddBatchPhoneFriendResult;", "requestAddFriendReal", "friendUin", "extraUin", "friendSetting", "groupId", "", "msg", "sourceID", "subSourceId", "autoSend", "sig", "", "isContactBothWay", "remark", "sourceName", "myCard", "ticket", "extraParam", "Landroid/os/Bundle;", "isSupportSecurityTips", "requestAutoInfo", "requestFriendGroup", "requestData", "Lcom/tencent/mobileqq/friend/data/GroupRequestData;", "requestFriendList", "Lcom/tencent/mobileqq/friend/data/FriendListRequestData;", "checkFreq", "requestInfoWithOpenId", "openId", "appId", "requestUinSafetyFlag", "uin", "requestUserAddFriendSetting", "sourceSubID", "ranKey", "Companion", "IMCore_release"}, k=1, mv={1, 1, 16})
public final class FriendHandler
  extends BusinessHandler
{
  public static final FriendHandler.Companion a = new FriendHandler.Companion(null);
  @NotNull
  private final FriendService b;
  @NotNull
  private final FriendConfig c;
  @NotNull
  private final AddFrdTokenHelper d;
  private final FriendBusinessProcessorFactory e;
  @NotNull
  private ArrayList<BaseFriendProcessor> f;
  private final ArrayList<BaseProtocolReceiver<FriendHandler>> g;
  private long h;
  
  public FriendHandler(@NotNull AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.b = new FriendService(paramAppInterface);
    this.c = new FriendConfig((AppRuntime)paramAppInterface);
    this.d = new AddFrdTokenHelper();
    this.e = new FriendBusinessProcessorFactory();
    this.g = new ArrayList();
    paramAppInterface = this.e.a((AppRuntime)this.appRuntime);
    Intrinsics.checkExpressionValueIsNotNull(paramAppInterface, "mBusinessProcessorFactor…getProcessors(appRuntime)");
    this.f = paramAppInterface;
    g();
  }
  
  private final void g()
  {
    ArrayList localArrayList = this.g;
    AppInterface localAppInterface = this.appRuntime;
    Intrinsics.checkExpressionValueIsNotNull(localAppInterface, "appRuntime");
    localArrayList.add(new FriendListReceiver(localAppInterface, this));
    localArrayList = this.g;
    localAppInterface = this.appRuntime;
    Intrinsics.checkExpressionValueIsNotNull(localAppInterface, "appRuntime");
    localArrayList.add(new SetGroupReceiver(localAppInterface, this));
    localArrayList = this.g;
    localAppInterface = this.appRuntime;
    Intrinsics.checkExpressionValueIsNotNull(localAppInterface, "appRuntime");
    localArrayList.add(new FriendAddReceiver(localAppInterface, this));
    this.g.add(new QueryUinFlagReceiver(this.appRuntime, this));
    this.g.add(new GetUserAddFriendSettingReceiver(this.appRuntime, this));
    this.g.add(new GetAutoInfoReceiver(this.appRuntime, this));
    this.g.add(new GetInfoWithOpenIdReceiver(this.appRuntime, this));
    this.g.add(new AddBatchPhoneFriendReceiver(this.appRuntime, this));
  }
  
  @NotNull
  public final FriendService a()
  {
    return this.b;
  }
  
  public final void a(long paramLong)
  {
    this.h = paramLong;
  }
  
  public final void a(@NotNull FriendListRequestData paramFriendListRequestData, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramFriendListRequestData, "requestData");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestFriendList| requestData: ");
      ((StringBuilder)localObject).append(paramFriendListRequestData);
      ((StringBuilder)localObject).append(", checkFreq: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("IMCore.friend.FriendHandler", 2, ((StringBuilder)localObject).toString());
    }
    long l = System.currentTimeMillis();
    if (!paramFriendListRequestData.isRequestSingle())
    {
      if ((paramBoolean) && (f()) && (l - this.h < 300000L))
      {
        QLog.d("IMCore.friend.FriendHandler", 1, "requestFriendList| request too busy");
        return;
      }
      this.h = l;
    }
    Object localObject = createToServiceMsg("friendlist.getFriendGroupList");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "createToServiceMsg(Frien…MD.GET_FRIEND_GROUP_LIST)");
    ((ToServiceMsg)localObject).setEnableFastResend(true);
    ((ToServiceMsg)localObject).extraData.putSerializable(Reflection.getOrCreateKotlinClass(FriendListRequestData.class).getSimpleName(), (Serializable)paramFriendListRequestData);
    this.b.a((ToServiceMsg)localObject);
  }
  
  public final void a(@NotNull GroupRequestData paramGroupRequestData)
  {
    Intrinsics.checkParameterIsNotNull(paramGroupRequestData, "requestData");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestFriendGroup| requestData: ");
      ((StringBuilder)localObject).append(paramGroupRequestData);
      QLog.d("IMCore.friend.FriendHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = createToServiceMsg("friendlist.SetGroupReq");
    ((ToServiceMsg)localObject).extraData.putSerializable(Reflection.getOrCreateKotlinClass(GroupRequestData.class).getSimpleName(), (Serializable)paramGroupRequestData);
    paramGroupRequestData = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "request");
    paramGroupRequestData.a((ToServiceMsg)localObject);
  }
  
  public final void a(@Nullable String paramString, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.GetAutoInfoReq");
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("cType", (byte)1);
    localToServiceMsg.extraData.putInt("source_id", paramInt1);
    localToServiceMsg.extraData.putInt("sub_source_id", paramInt2);
    paramString = this.b;
    Intrinsics.checkExpressionValueIsNotNull(localToServiceMsg, "request");
    paramString.a(localToServiceMsg);
  }
  
  public final void a(@NotNull String paramString1, int paramInt1, int paramInt2, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uin");
    a(paramString1, paramInt1, paramInt2, paramString2, 0);
  }
  
  public final void a(@NotNull String paramString1, int paramInt1, int paramInt2, @Nullable String paramString2, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uin");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getUserAddFriendSetting ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("IMCore.friend.FriendHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.appRuntime;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "appRuntime");
    localObject = new ToServiceMsg("mobileqq.service", ((AppInterface)localObject).getCurrentAccountUin(), "friendlist.getUserAddFriendSetting");
    ((ToServiceMsg)localObject).extraData.putString("uin", paramString1);
    ((ToServiceMsg)localObject).extraData.putInt("source_id", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("sub_source_id", paramInt2);
    ((ToServiceMsg)localObject).extraData.putInt("random_key", paramInt3);
    if (paramString2 != null)
    {
      if (((CharSequence)paramString2).length() > 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if (paramInt1 != 0) {
        ((ToServiceMsg)localObject).extraData.putString("extra", paramString2);
      }
    }
    this.b.a((ToServiceMsg)localObject);
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "openId");
    Intrinsics.checkParameterIsNotNull(paramString2, "appId");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("infoOpenId ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("IMCore.friend.FriendHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1505);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(8);
    oidb_0x5e1.ReqBody localReqBody = new oidb_0x5e1.ReqBody();
    PBRepeatField localPBRepeatField = localReqBody.rpt_bytes_openid;
    byte[] arrayOfByte = paramString1.getBytes(Charsets.UTF_8);
    Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "(this as java.lang.String).getBytes(charset)");
    localPBRepeatField.add(ByteStringMicro.copyFrom(arrayOfByte));
    localReqBody.uint32_appid.set((int)Long.parseLong(paramString2));
    localReqBody.uint32_req_nick.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString2 = this.appRuntime;
    Intrinsics.checkExpressionValueIsNotNull(paramString2, "appRuntime");
    paramString2 = new ToServiceMsg("mobileqq.service", paramString2.getCurrentAccountUin(), "OidbSvc.0x5e1_8");
    paramString2.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    paramString2.extraData.putString("uin", paramString1);
    sendPbReq(paramString2);
  }
  
  public final void a(@Nullable String paramString1, @Nullable String paramString2, int paramInt1, byte paramByte1, @Nullable String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, @Nullable byte[] paramArrayOfByte, boolean paramBoolean2, @Nullable String paramString4, @Nullable String paramString5, byte paramByte2, @Nullable String paramString6, @Nullable Bundle paramBundle, boolean paramBoolean3)
  {
    if (QLog.isColorLevel())
    {
      if (paramBundle != null) {
        paramBundle.getString("troop_uin");
      }
      StringBuilder localStringBuilder = new StringBuilder(300);
      localStringBuilder.append("addFriendInternal, uin:");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", sourceID:");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", subSourceId:");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(", extraUin:");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", friendSetting:");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", groupId:");
      localStringBuilder.append(paramByte1);
      localStringBuilder.append(", msg:");
      localStringBuilder.append(paramString3);
      localStringBuilder.append(", autoSend:");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(", isContactBothWay:");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append(", remark:");
      localStringBuilder.append(paramString4);
      localStringBuilder.append(", sourceName:");
      localStringBuilder.append(paramString5);
      localStringBuilder.append(", myCard:");
      localStringBuilder.append(paramByte2);
      localStringBuilder.append(", extraParam:");
      localStringBuilder.append(paramBundle);
      localStringBuilder.append(", isSupportSecurityTips:");
      localStringBuilder.append(paramBoolean3);
      localStringBuilder.append(", sig:");
      localObject1 = "null";
      localObject2 = paramArrayOfByte;
      if (localObject2 != null) {
        localObject1 = Integer.valueOf(localObject2.length);
      }
      localStringBuilder.append(localObject1);
      localStringBuilder.append(", ticket:");
      if (paramString6 != null) {
        localObject1 = Integer.valueOf(paramString6.length());
      } else {
        localObject1 = "null";
      }
      localStringBuilder.append(localObject1);
      QLog.d("addFriendTag", 2, localStringBuilder.toString());
    }
    Object localObject1 = this.appRuntime;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "appRuntime");
    localObject1 = new ToServiceMsg("mobileqq.service", ((AppInterface)localObject1).getAccount(), "friendlist.addFriend");
    Object localObject2 = ((ToServiceMsg)localObject1).extraData;
    ((Bundle)localObject2).putString("uin", paramString1);
    ((Bundle)localObject2).putInt("friend_setting", paramInt1);
    ((Bundle)localObject2).putByte("group_id", paramByte1);
    ((Bundle)localObject2).putString("msg", paramString3);
    ((Bundle)localObject2).putInt("source_id", paramInt2);
    ((Bundle)localObject2).putByte("show_my_card", paramByte2);
    ((Bundle)localObject2).putInt("sub_source_id", paramInt3);
    ((Bundle)localObject2).putString("extra", paramString2);
    ((Bundle)localObject2).putBoolean("auto_send", paramBoolean1);
    ((Bundle)localObject2).putByteArray("sig", paramArrayOfByte);
    ((Bundle)localObject2).putBoolean("contact_bothway", paramBoolean2);
    ((Bundle)localObject2).putString("remark", paramString4);
    ((Bundle)localObject2).putString("src_name", paramString5);
    if (paramBundle != null)
    {
      ((Bundle)localObject2).putString("troop_uin", paramBundle.getString("troop_uin"));
      ((Bundle)localObject2).putString("troop_code", paramBundle.getString("troop_code"));
      ((Bundle)localObject2).putInt("flc_notify_type", paramBundle.getInt("flc_notify_type"));
      ((Bundle)localObject2).putString("flc_recommend_uin", paramBundle.getString("flc_recommend_uin"));
      paramString2 = paramBundle.getByteArray("friend_src_desc");
      if (paramString2 != null) {
        ((Bundle)localObject2).putByteArray("friend_src_desc", paramString2);
      }
    }
    paramString1 = this.d.a(paramString1, paramInt2, paramInt3);
    if (paramString1 != null)
    {
      if (paramString1.length == 0) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
      if ((paramInt1 ^ 0x1) != 0) {
        ((Bundle)localObject2).putByteArray("flc_add_frd_token", paramString1);
      }
    }
    ((Bundle)localObject2).putString("security_ticket", paramString6);
    ((Bundle)localObject2).putBoolean("security_ticket_support", paramBoolean3);
    this.b.a((ToServiceMsg)localObject1);
  }
  
  public final void a(@NotNull ArrayList<PhoneContact> paramArrayList, @NotNull String paramString, int paramInt1, int paramInt2, @Nullable ArrayList<AddBatchPhoneFriendResult> paramArrayList1)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayList, "phoneArr");
    Intrinsics.checkParameterIsNotNull(paramString, "verifyMsg");
    if ((paramInt2 != 3078) && (paramInt2 != 3079))
    {
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("addBatchPhoneFriend, sourceId=");
        paramArrayList.append(paramInt2);
        paramArrayList.append(" is invalid.");
        QLog.d("IMCore.friend.FriendHandler", 2, paramArrayList.toString());
      }
      return;
    }
    Object localObject1 = (List)new ArrayList(30);
    int j = paramInt1 * 30;
    int i = paramArrayList.size() - j;
    int k = -1;
    if (i > 30)
    {
      i = j + 30;
      k = paramInt1 + 1;
    }
    else if (i == 30)
    {
      i = j + 30;
    }
    else
    {
      i += j;
    }
    while (j < i)
    {
      localObject2 = ((PhoneContact)paramArrayList.get(j)).unifiedCode;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "phoneArr[i].unifiedCode");
      localObject3 = Charsets.UTF_8;
      if (localObject2 != null)
      {
        localObject2 = ((String)localObject2).getBytes((Charset)localObject3);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.String).getBytes(charset)");
        localObject2 = ByteStringMicro.copyFrom((byte[])localObject2);
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "ByteStringMicro.copyFrom…nifiedCode.toByteArray())");
        ((List)localObject1).add(localObject2);
        j += 1;
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = StringCompanionObject.INSTANCE;
      localObject2 = new Object[3];
      localObject2[0] = Integer.valueOf(paramInt2);
      localObject2[1] = Integer.valueOf(paramInt1);
      localObject2[2] = paramString;
      localObject2 = String.format("addBatchPhoneFriend sourceId:%s, pkgIndex:%s, verifyMsg:%s ", Arrays.copyOf((Object[])localObject2, localObject2.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.lang.String.format(format, *args)");
      QLog.d("addFriendTag", 2, (String)localObject2);
    }
    Object localObject2 = new oidb_0x829.ReqBody();
    ((oidb_0x829.ReqBody)localObject2).uint32_source_id.set(paramInt2);
    ((oidb_0x829.ReqBody)localObject2).uint32_sub_source_id.set(1);
    Object localObject3 = ((oidb_0x829.ReqBody)localObject2).bytes_msg;
    byte[] arrayOfByte = paramString.getBytes(Charsets.UTF_8);
    Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "(this as java.lang.String).getBytes(charset)");
    ((PBBytesField)localObject3).set(ByteStringMicro.copyFrom(arrayOfByte));
    ((oidb_0x829.ReqBody)localObject2).rpt_bytes_mobiles.set((List)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(2089);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x829.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0x829_1");
    ((ToServiceMsg)localObject2).extraData.putSerializable("phones", (Serializable)paramArrayList);
    ((ToServiceMsg)localObject2).extraData.putInt("package", k);
    ((ToServiceMsg)localObject2).extraData.putString("verifyMsg", paramString);
    ((ToServiceMsg)localObject2).extraData.putSerializable("resultList", (Serializable)paramArrayList1);
    ((ToServiceMsg)localObject2).extraData.putInt("sourceId", paramInt2);
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "request");
    ((ToServiceMsg)localObject2).setTimeout(30000);
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  @NotNull
  public final FriendConfig b()
  {
    return this.c;
  }
  
  public final void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("requestUinSafetyFlag ");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.d("IMCore.friend.FriendHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1142);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(147);
    Object localObject2 = ByteBuffer.allocate(6);
    ((ByteBuffer)localObject2).putShort((short)1);
    ((ByteBuffer)localObject2).putInt((int)paramLong);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.setHasFlag(true);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
    localObject2 = this.appRuntime;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "appRuntime");
    localObject2 = new ToServiceMsg("mobileqq.service", ((AppInterface)localObject2).getCurrentAccountUin(), "OidbSvc.0x476_147");
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    ((ToServiceMsg)localObject2).extraData.putLong("uin", paramLong);
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  @NotNull
  public final AddFrdTokenHelper c()
  {
    return this.d;
  }
  
  @NotNull
  public final ArrayList<BaseFriendProcessor> d()
  {
    return this.f;
  }
  
  public final long e()
  {
    return this.h;
  }
  
  public final boolean f()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isRequestingFriendList, timestamp: ");
      localStringBuilder.append(this.h);
      QLog.d("IMCore.friend.FriendHandler", 2, localStringBuilder.toString());
    }
    return this.h > 0L;
  }
  
  @NotNull
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = ((Set)new HashSet());
      this.allowCmdSet.add("friendlist.addFriend");
      this.allowCmdSet.add("OidbSvc.0x476_147");
      this.allowCmdSet.add("friendlist.getUserAddFriendSetting");
      this.allowCmdSet.add("friendlist.GetAutoInfoReq");
      this.allowCmdSet.add("OidbSvc.0x5e1_8");
      this.allowCmdSet.add("OidbSvc.0x829_1");
    }
    Set localSet = this.allowCmdSet;
    Intrinsics.checkExpressionValueIsNotNull(localSet, "allowCmdSet");
    return localSet;
  }
  
  @NotNull
  protected Class<? extends BusinessObserver> observerClass()
  {
    return IFriendObserver.class;
  }
  
  public void onReceive(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onReceive| ");
        ((StringBuilder)localObject).append(paramToServiceMsg.getServiceCmd());
        QLog.d("IMCore.friend.FriendHandler", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.g.iterator();
      while (((Iterator)localObject).hasNext())
      {
        BaseProtocolReceiver localBaseProtocolReceiver = (BaseProtocolReceiver)((Iterator)localObject).next();
        String str = paramToServiceMsg.getServiceCmd();
        Intrinsics.checkExpressionValueIsNotNull(str, "req.serviceCmd");
        if (localBaseProtocolReceiver.a(str)) {
          localBaseProtocolReceiver.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        }
      }
      return;
    }
    QLog.e("IMCore.friend.FriendHandler", 1, "onReceive| req == null || res == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.handler.FriendHandler
 * JD-Core Version:    0.7.0.1
 */