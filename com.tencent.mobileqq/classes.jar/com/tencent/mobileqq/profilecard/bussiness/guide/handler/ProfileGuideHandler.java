package com.tencent.mobileqq.profilecard.bussiness.guide.handler;

import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
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
import tencent.im.oidb.cmd0xf13.oidb_0xf13.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/profilecard/bussiness/guide/handler/ProfileGuideHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "getCommandList", "", "", "getProfileGuide", "", "handleGetProfileGuide", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "handleReportProfileGuideRead", "observerClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "onReceive", "reportProfileGuideRead", "guideId", "", "guideType", "operation", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
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
  private final QQAppInterface app;
  
  public ProfileGuideHandler(@NotNull QQAppInterface paramQQAppInterface)
  {
    super((AppInterface)paramQQAppInterface);
    this.app = paramQQAppInterface;
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
    if (localObject != null) {}
    for (localObject = Long.valueOf(((QQAppInterface)localObject).getLongAccountUin());; localObject = null)
    {
      long l = ((Long)localObject).longValue();
      if (QLog.isColorLevel())
      {
        localObject = StringCompanionObject.INSTANCE;
        localObject = new Object[1];
        localObject[0] = Long.valueOf(l);
        localObject = String.format("getProfileGuide uin=%s", Arrays.copyOf((Object[])localObject, localObject.length));
        Intrinsics.checkExpressionValueIsNotNull(localObject, "java.lang.String.format(format, *args)");
        QLog.d("ProfileGuideHandler", 0, (String)localObject);
      }
      localObject = new oidb_0xf12.ReqBody();
      ((oidb_0xf12.ReqBody)localObject).uint64_uin.set(l);
      sendPbReq(makeOIDBPkg("OidbSvc.0xf12", 3858, 0, ((oidb_0xf12.ReqBody)localObject).toByteArray()));
      return;
    }
  }
  
  /* Error */
  public final void handleGetProfileGuide(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +198 -> 199
    //   4: aload_2
    //   5: invokevirtual 184	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   8: istore 5
    //   10: aload_2
    //   11: ifnull +194 -> 205
    //   14: aload_2
    //   15: invokevirtual 187	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   18: istore 7
    //   20: iload 7
    //   22: ifeq +189 -> 211
    //   25: aload_3
    //   26: ifnull +185 -> 211
    //   29: iconst_1
    //   30: istore 8
    //   32: aconst_null
    //   33: checkcast 189	com/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide
    //   36: astore 9
    //   38: aload 9
    //   40: astore_1
    //   41: iload 8
    //   43: istore 7
    //   45: iload 5
    //   47: istore 4
    //   49: iload 8
    //   51: ifeq +79 -> 130
    //   54: new 191	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   57: dup
    //   58: invokespecial 192	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   61: astore_1
    //   62: aload_3
    //   63: ifnonnull +154 -> 217
    //   66: new 194	kotlin/TypeCastException
    //   69: dup
    //   70: ldc 196
    //   72: invokespecial 199	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   75: athrow
    //   76: astore_2
    //   77: iload 5
    //   79: istore 4
    //   81: aload 9
    //   83: astore_1
    //   84: getstatic 127	kotlin/jvm/internal/StringCompanionObject:INSTANCE	Lkotlin/jvm/internal/StringCompanionObject;
    //   87: astore_3
    //   88: iconst_1
    //   89: anewarray 129	java/lang/Object
    //   92: astore_3
    //   93: aload_3
    //   94: iconst_0
    //   95: iload 4
    //   97: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   100: aastore
    //   101: ldc 206
    //   103: aload_3
    //   104: aload_3
    //   105: arraylength
    //   106: invokestatic 137	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   109: invokestatic 143	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   112: astore_3
    //   113: aload_3
    //   114: ldc 145
    //   116: invokestatic 97	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   119: ldc 52
    //   121: iconst_1
    //   122: aload_3
    //   123: aload_2
    //   124: invokestatic 210	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   127: iconst_0
    //   128: istore 7
    //   130: invokestatic 121	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   133: ifeq +57 -> 190
    //   136: getstatic 127	kotlin/jvm/internal/StringCompanionObject:INSTANCE	Lkotlin/jvm/internal/StringCompanionObject;
    //   139: astore_2
    //   140: iconst_3
    //   141: anewarray 129	java/lang/Object
    //   144: astore_2
    //   145: aload_2
    //   146: iconst_0
    //   147: iload 4
    //   149: invokestatic 204	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   152: aastore
    //   153: aload_2
    //   154: iconst_1
    //   155: iload 7
    //   157: invokestatic 215	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   160: aastore
    //   161: aload_2
    //   162: iconst_2
    //   163: aload_1
    //   164: aastore
    //   165: ldc 217
    //   167: aload_2
    //   168: aload_2
    //   169: arraylength
    //   170: invokestatic 137	java/util/Arrays:copyOf	([Ljava/lang/Object;I)[Ljava/lang/Object;
    //   173: invokestatic 143	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   176: astore_2
    //   177: aload_2
    //   178: ldc 145
    //   180: invokestatic 97	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   183: ldc 52
    //   185: iconst_0
    //   186: aload_2
    //   187: invokestatic 149	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: aload_0
    //   191: iconst_1
    //   192: iload 7
    //   194: aload_1
    //   195: invokevirtual 221	com/tencent/mobileqq/profilecard/bussiness/guide/handler/ProfileGuideHandler:notifyUI	(IZLjava/lang/Object;)V
    //   198: return
    //   199: iconst_m1
    //   200: istore 5
    //   202: goto -192 -> 10
    //   205: iconst_0
    //   206: istore 7
    //   208: goto -188 -> 20
    //   211: iconst_0
    //   212: istore 8
    //   214: goto -182 -> 32
    //   217: aload_1
    //   218: aload_3
    //   219: checkcast 223	[B
    //   222: invokevirtual 227	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   225: astore_1
    //   226: aload_1
    //   227: ldc 229
    //   229: invokestatic 97	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   232: aload_1
    //   233: checkcast 191	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   236: astore_2
    //   237: aload_2
    //   238: getfield 233	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   241: invokevirtual 238	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   244: istore 4
    //   246: iload 4
    //   248: ifne +111 -> 359
    //   251: iconst_1
    //   252: istore 7
    //   254: iload 7
    //   256: ifeq +120 -> 376
    //   259: aload_2
    //   260: getfield 242	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   263: invokevirtual 247	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   266: ifeq +110 -> 376
    //   269: new 249	tencent/im/oidb/cmd0xf12/oidb_0xf12$RspBody
    //   272: dup
    //   273: invokespecial 250	tencent/im/oidb/cmd0xf12/oidb_0xf12$RspBody:<init>	()V
    //   276: astore_1
    //   277: aload_1
    //   278: aload_2
    //   279: getfield 242	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   282: invokevirtual 253	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   285: invokevirtual 256	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   288: invokevirtual 257	tencent/im/oidb/cmd0xf12/oidb_0xf12$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   291: pop
    //   292: aload_1
    //   293: getfield 260	tencent/im/oidb/cmd0xf12/oidb_0xf12$RspBody:uint32_guidecardid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   296: invokevirtual 238	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   299: istore 5
    //   301: aload_1
    //   302: getfield 263	tencent/im/oidb/cmd0xf12/oidb_0xf12$RspBody:uint32_guidecardtype	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   305: invokevirtual 238	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   308: istore 6
    //   310: aload_1
    //   311: getfield 267	tencent/im/oidb/cmd0xf12/oidb_0xf12$RspBody:str_main_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   314: invokevirtual 272	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   317: astore_2
    //   318: aload_1
    //   319: getfield 275	tencent/im/oidb/cmd0xf12/oidb_0xf12$RspBody:str_secondary_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   322: invokevirtual 272	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   325: astore_3
    //   326: new 189	com/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide
    //   329: dup
    //   330: invokespecial 276	com/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide:<init>	()V
    //   333: astore_1
    //   334: aload_1
    //   335: iload 5
    //   337: invokevirtual 280	com/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide:setGuideId	(I)V
    //   340: aload_1
    //   341: iload 6
    //   343: invokevirtual 283	com/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide:setGuideType	(I)V
    //   346: aload_1
    //   347: aload_2
    //   348: invokevirtual 286	com/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide:setGuideMainMsg	(Ljava/lang/String;)V
    //   351: aload_1
    //   352: aload_3
    //   353: invokevirtual 289	com/tencent/mobileqq/profilecard/bussiness/guide/bean/ProfileGuide:setGuideSecondaryMsg	(Ljava/lang/String;)V
    //   356: goto -226 -> 130
    //   359: iconst_0
    //   360: istore 7
    //   362: goto -108 -> 254
    //   365: astore_2
    //   366: aload 9
    //   368: astore_1
    //   369: goto -285 -> 84
    //   372: astore_2
    //   373: goto -289 -> 84
    //   376: aload 9
    //   378: astore_1
    //   379: goto -249 -> 130
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	this	ProfileGuideHandler
    //   0	382	1	paramToServiceMsg	ToServiceMsg
    //   0	382	2	paramFromServiceMsg	FromServiceMsg
    //   0	382	3	paramObject	Object
    //   47	200	4	i	int
    //   8	328	5	j	int
    //   308	34	6	k	int
    //   18	343	7	bool1	boolean
    //   30	183	8	bool2	boolean
    //   36	341	9	localProfileGuide	com.tencent.mobileqq.profilecard.bussiness.guide.bean.ProfileGuide
    // Exception table:
    //   from	to	target	type
    //   54	62	76	java/lang/Exception
    //   66	76	76	java/lang/Exception
    //   217	246	76	java/lang/Exception
    //   259	334	365	java/lang/Exception
    //   334	356	372	java/lang/Exception
  }
  
  public final void handleReportProfileGuideRead(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    int i;
    boolean bool;
    if (paramFromServiceMsg != null)
    {
      i = paramFromServiceMsg.getResultCode();
      if (paramFromServiceMsg == null) {
        break label176;
      }
      bool = paramFromServiceMsg.isSuccess();
      label20:
      if ((!bool) || (paramObject == null)) {
        break label182;
      }
      bool = true;
      label32:
      if (bool) {
        try
        {
          paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
          if (paramObject == null) {
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
          QLog.e("ProfileGuideHandler", 1, paramFromServiceMsg, paramToServiceMsg);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = StringCompanionObject.INSTANCE;
        paramToServiceMsg = new Object[2];
        paramToServiceMsg[0] = Integer.valueOf(i);
        paramToServiceMsg[1] = Boolean.valueOf(bool);
        paramToServiceMsg = String.format("handleReportProfileGuideRead resultCode=%s success=%s", Arrays.copyOf(paramToServiceMsg, paramToServiceMsg.length));
        Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "java.lang.String.format(format, *args)");
        QLog.d("ProfileGuideHandler", 0, paramToServiceMsg);
      }
      notifyUI(2, bool, null);
      return;
      i = -1;
      break;
      label176:
      bool = false;
      break label20;
      label182:
      bool = false;
      break label32;
      paramToServiceMsg = paramToServiceMsg.mergeFrom((byte[])paramObject);
      Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "pkg.mergeFrom(data as ByteArray)");
      int j = ((oidb_sso.OIDBSSOPkg)paramToServiceMsg).uint32_result.get();
      i = j;
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  @NotNull
  public Class<? extends BusinessObserver> observerClass()
  {
    return ProfileGuideObserver.class;
  }
  
  public void onReceive(@Nullable ToServiceMsg paramToServiceMsg, @Nullable FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    String str;
    if (paramToServiceMsg != null)
    {
      str = paramToServiceMsg.getServiceCmd();
      if (!msgCmdFilter(str)) {
        break label26;
      }
    }
    label26:
    do
    {
      do
      {
        do
        {
          return;
          str = null;
          break;
        } while (str == null);
        switch (str.hashCode())
        {
        default: 
          return;
        }
      } while (!str.equals("OidbSvc.0xf12"));
      handleGetProfileGuide(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    } while (!str.equals("OidbSvc.0xf13"));
    handleReportProfileGuideRead(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public final void reportProfileGuideRead(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.app;
    if (localObject != null) {}
    for (localObject = Long.valueOf(((QQAppInterface)localObject).getLongAccountUin());; localObject = null)
    {
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
        QLog.d("ProfileGuideHandler", 0, (String)localObject);
      }
      localObject = new oidb_0xf13.ReqBody();
      ((oidb_0xf13.ReqBody)localObject).uint64_uin.set(l);
      ((oidb_0xf13.ReqBody)localObject).uint32_guidecardid.set(paramInt1);
      ((oidb_0xf13.ReqBody)localObject).uint32_guidecardtype.set(paramInt2);
      ((oidb_0xf13.ReqBody)localObject).uint32_operation.set(paramInt3);
      sendPbReq(makeOIDBPkg("OidbSvc.0xf13", 3859, 0, ((oidb_0xf13.ReqBody)localObject).toByteArray()));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.bussiness.guide.handler.ProfileGuideHandler
 * JD-Core Version:    0.7.0.1
 */