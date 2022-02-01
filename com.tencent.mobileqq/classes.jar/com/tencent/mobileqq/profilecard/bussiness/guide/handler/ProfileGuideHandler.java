package com.tencent.mobileqq.profilecard.bussiness.guide.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.profilecard.bussiness.guide.bean.ProfileGuide;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xf12.oidb_0xf12.ReqBody;
import tencent.im.oidb.cmd0xf12.oidb_0xf12.RspBody;
import tencent.im.oidb.cmd0xf13.oidb_0xf13.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/guide/handler/ProfileGuideHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "app", "Lcom/tencent/common/app/AppInterface;", "(Lcom/tencent/common/app/AppInterface;)V", "getCommandList", "", "", "getProfileGuide", "", "handleGetProfileGuide", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "handleReportProfileGuideRead", "observerClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "onReceive", "reportProfileGuideRead", "guideId", "", "guideType", "operation", "Companion", "profilecard-impl_release"}, k=1, mv={1, 1, 16})
public class ProfileGuideHandler
  extends BusinessHandler
{
  @NotNull
  public static final String CMD_GET_PROFILE_GUIDE = "OidbSvc.0xf12";
  @NotNull
  public static final String CMD_REPORT_PROFILE_GUIDE_READ = "OidbSvc.0xf13";
  public static final ProfileGuideHandler.Companion Companion = new ProfileGuideHandler.Companion(null);
  @NotNull
  public static final String TAG = "ProfileGuideHandler";
  private final AppInterface app;
  
  public ProfileGuideHandler(@NotNull AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    this.app = paramAppInterface;
  }
  
  @NotNull
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = ((Set)new HashSet());
      this.allowCmdSet.add("OidbSvc.0xf12");
      this.allowCmdSet.add("OidbSvc.0xf13");
    }
    Set localSet = this.allowCmdSet;
    Intrinsics.checkExpressionValueIsNotNull(localSet, "allowCmdSet");
    return localSet;
  }
  
  public final void getProfileGuide()
  {
    Object localObject = this.app;
    if (localObject != null) {
      localObject = Long.valueOf(((AppInterface)localObject).getLongAccountUin());
    } else {
      localObject = null;
    }
    long l = ((Long)localObject).longValue();
    if (QLog.isColorLevel())
    {
      localObject = StringCompanionObject.INSTANCE;
      localObject = new Object[1];
      localObject[0] = Long.valueOf(l);
      localObject = String.format("getProfileGuide uin=%s", Arrays.copyOf((Object[])localObject, localObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
      QLog.d("ProfileGuideHandler", 2, (String)localObject);
    }
    localObject = new oidb_0xf12.ReqBody();
    ((oidb_0xf12.ReqBody)localObject).uint64_uin.set(l);
    sendPbReq(makeOIDBPkg("OidbSvc.0xf12", 3858, 0, ((oidb_0xf12.ReqBody)localObject).toByteArray()));
  }
  
  public final void handleGetProfileGuide(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    int i;
    if (paramFromServiceMsg != null) {
      i = paramFromServiceMsg.getResultCode();
    } else {
      i = -1;
    }
    boolean bool1;
    if (paramFromServiceMsg != null) {
      bool1 = paramFromServiceMsg.isSuccess();
    } else {
      bool1 = false;
    }
    if ((bool1) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramFromServiceMsg = (ProfileGuide)null;
    int j;
    if (bool1) {
      j = i;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        if (paramObject != null)
        {
          j = i;
          paramToServiceMsg = paramToServiceMsg.mergeFrom((byte[])paramObject);
          j = i;
          Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "pkg.mergeFrom(data as ByteArray)");
          j = i;
          paramObject = (oidb_sso.OIDBSSOPkg)paramToServiceMsg;
          j = i;
          i = paramObject.uint32_result.get();
          if (i != 0) {
            break label462;
          }
          bool1 = true;
          paramToServiceMsg = paramFromServiceMsg;
          k = i;
          bool2 = bool1;
          if (!bool1) {
            break label392;
          }
          j = i;
          paramToServiceMsg = paramFromServiceMsg;
          k = i;
          bool2 = bool1;
          if (!paramObject.bytes_bodybuffer.has()) {
            break label392;
          }
          j = i;
          paramToServiceMsg = new oidb_0xf12.RspBody();
          j = i;
          paramToServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
          j = i;
          k = paramToServiceMsg.uint32_guidecardid.get();
          j = i;
          int m = paramToServiceMsg.uint32_guidecardtype.get();
          j = i;
          paramObject = paramToServiceMsg.str_main_msg.get();
          j = i;
          String str = paramToServiceMsg.str_secondary_msg.get();
          j = i;
          paramToServiceMsg = new ProfileGuide();
          try
          {
            paramToServiceMsg.setGuideId(k);
            paramToServiceMsg.setGuideType(m);
            paramToServiceMsg.setGuideMainMsg(paramObject);
            paramToServiceMsg.setGuideSecondaryMsg(str);
            k = i;
            bool2 = bool1;
          }
          catch (Exception paramObject)
          {
            continue;
          }
        }
        else
        {
          j = i;
          throw new TypeCastException("null cannot be cast to non-null type kotlin.ByteArray");
        }
      }
      catch (Exception paramObject)
      {
        i = j;
        paramToServiceMsg = paramFromServiceMsg;
        paramFromServiceMsg = StringCompanionObject.INSTANCE;
        paramFromServiceMsg = new Object[1];
        paramFromServiceMsg[0] = Integer.valueOf(i);
        paramFromServiceMsg = String.format("handleGetProfileGuide decode fail, resultCode=%s", Arrays.copyOf(paramFromServiceMsg, paramFromServiceMsg.length));
        Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "java.lang.String.format(format, *args)");
        QLog.e("ProfileGuideHandler", 1, paramFromServiceMsg, (Throwable)paramObject);
        bool2 = false;
        k = i;
      }
      boolean bool2 = bool1;
      int k = i;
      paramToServiceMsg = paramFromServiceMsg;
      label392:
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = StringCompanionObject.INSTANCE;
        paramFromServiceMsg = new Object[3];
        paramFromServiceMsg[0] = Integer.valueOf(k);
        paramFromServiceMsg[1] = Boolean.valueOf(bool2);
        paramFromServiceMsg[2] = paramToServiceMsg;
        paramFromServiceMsg = String.format("handleGetProfileGuide resultCode=%s success=%s profileGuide=%s", Arrays.copyOf(paramFromServiceMsg, paramFromServiceMsg.length));
        Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "java.lang.String.format(format, *args)");
        QLog.d("ProfileGuideHandler", 2, paramFromServiceMsg);
      }
      notifyUI(1, bool2, paramToServiceMsg);
      return;
      label462:
      bool1 = false;
    }
  }
  
  public final void handleReportProfileGuideRead(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    int i;
    if (paramFromServiceMsg != null) {
      i = paramFromServiceMsg.getResultCode();
    } else {
      i = -1;
    }
    boolean bool1;
    if (paramFromServiceMsg != null) {
      bool1 = paramFromServiceMsg.isSuccess();
    } else {
      bool1 = false;
    }
    if ((bool1) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int j = i;
    boolean bool2 = bool1;
    if (bool1) {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        if (paramObject != null)
        {
          paramToServiceMsg = paramToServiceMsg.mergeFrom((byte[])paramObject);
          Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "pkg.mergeFrom(data as ByteArray)");
          j = ((oidb_sso.OIDBSSOPkg)paramToServiceMsg).uint32_result.get();
          if (j != 0) {
            break label246;
          }
          bool2 = true;
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.ByteArray");
        }
      }
      catch (Exception paramToServiceMsg)
      {
        paramFromServiceMsg = StringCompanionObject.INSTANCE;
        paramFromServiceMsg = new Object[1];
        paramFromServiceMsg[0] = Integer.valueOf(i);
        paramFromServiceMsg = String.format("handleReportProfileGuideRead decode fail, resultCode=%s", Arrays.copyOf(paramFromServiceMsg, paramFromServiceMsg.length));
        Intrinsics.checkExpressionValueIsNotNull(paramFromServiceMsg, "java.lang.String.format(format, *args)");
        QLog.e("ProfileGuideHandler", 1, paramFromServiceMsg, (Throwable)paramToServiceMsg);
        bool2 = bool1;
        j = i;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = StringCompanionObject.INSTANCE;
        paramToServiceMsg = new Object[2];
        paramToServiceMsg[0] = Integer.valueOf(j);
        paramToServiceMsg[1] = Boolean.valueOf(bool2);
        paramToServiceMsg = String.format("handleReportProfileGuideRead resultCode=%s success=%s", Arrays.copyOf(paramToServiceMsg, paramToServiceMsg.length));
        Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "java.lang.String.format(format, *args)");
        QLog.d("ProfileGuideHandler", 2, paramToServiceMsg);
      }
      notifyUI(2, bool2, null);
      return;
      label246:
      bool2 = false;
    }
  }
  
  @NotNull
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ProfileGuideObserver.class;
  }
  
  public void onReceive(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    String str;
    if (paramToServiceMsg != null) {
      str = paramToServiceMsg.getServiceCmd();
    } else {
      str = null;
    }
    if (msgCmdFilter(str)) {
      return;
    }
    if (str == null) {
      return;
    }
    switch (str.hashCode())
    {
    default: 
    case 706605978: 
      if (str.equals("OidbSvc.0xf13"))
      {
        handleReportProfileGuideRead(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      break;
    case 706605977: 
      if (str.equals("OidbSvc.0xf12")) {
        handleGetProfileGuide(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      break;
    }
  }
  
  public final void reportProfileGuideRead(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.app;
    if (localObject != null) {
      localObject = Long.valueOf(((AppInterface)localObject).getLongAccountUin());
    } else {
      localObject = null;
    }
    long l = ((Long)localObject).longValue();
    if (QLog.isColorLevel())
    {
      localObject = StringCompanionObject.INSTANCE;
      localObject = new Object[4];
      localObject[0] = Long.valueOf(l);
      localObject[1] = Integer.valueOf(paramInt1);
      localObject[2] = Integer.valueOf(paramInt2);
      localObject[3] = Integer.valueOf(paramInt3);
      localObject = String.format("reportProfileGuideRead uin=%s guideId=%s guideType=%s guideOp=%s", Arrays.copyOf((Object[])localObject, localObject.length));
      Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
      QLog.d("ProfileGuideHandler", 2, (String)localObject);
    }
    localObject = new oidb_0xf13.ReqBody();
    ((oidb_0xf13.ReqBody)localObject).uint64_uin.set(l);
    ((oidb_0xf13.ReqBody)localObject).uint32_guidecardid.set(paramInt1);
    ((oidb_0xf13.ReqBody)localObject).uint32_guidecardtype.set(paramInt2);
    ((oidb_0xf13.ReqBody)localObject).uint32_operation.set(paramInt3);
    sendPbReq(makeOIDBPkg("OidbSvc.0xf13", 3859, 0, ((oidb_0xf13.ReqBody)localObject).toByteArray()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.guide.handler.ProfileGuideHandler
 * JD-Core Version:    0.7.0.1
 */