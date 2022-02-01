package com.tencent.mobileqq.friend.servlet.coder;

import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.mobileqq.friend.data.FriendListRequestData;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.GetFriendListReq;
import friendlist.GetFriendListResp;
import friendlist.SetGroupResp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
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
    Object localObject = paramToServiceMsg.extraData.getSerializable(Reflection.getOrCreateKotlinClass(FriendListRequestData.class).getSimpleName());
    if ((localObject instanceof FriendListRequestData))
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
      localObject = (FriendListRequestData)localObject;
      localGetFriendListReq.ifReflush = ((FriendListRequestData)localObject).getIfReflushParam();
      paramToServiceMsg = paramToServiceMsg.getUin();
      Intrinsics.checkExpressionValueIsNotNull(paramToServiceMsg, "request.uin");
      localGetFriendListReq.uin = Long.parseLong(paramToServiceMsg);
      localGetFriendListReq.startIndex = ((short)((FriendListRequestData)localObject).getFriendStartIndex());
      localGetFriendListReq.getfriendCount = ((short)((FriendListRequestData)localObject).getFriendCount());
      localGetFriendListReq.groupid = 0;
      localGetFriendListReq.ifGetGroupInfo = ((FriendListRequestData)localObject).getIfGetGroupInfoParam();
      localGetFriendListReq.groupstartIndex = ((byte)((FriendListRequestData)localObject).getGroupStartIndex());
      localGetFriendListReq.getgroupCount = ((byte)((FriendListRequestData)localObject).getGroupCount());
      localGetFriendListReq.ifGetMSFGroup = 0;
      localGetFriendListReq.ifShowTermType = ((byte)((FriendListRequestData)localObject).getShowTermType());
      localGetFriendListReq.version = 31L;
      localGetFriendListReq.uinList = ((FriendListRequestData)localObject).getUinListParam();
      localGetFriendListReq.eAppType = 0;
      localGetFriendListReq.ifGetDOVId = 0;
      localGetFriendListReq.ifGetBothFlag = 0;
      localGetFriendListReq.vec0xd50Req = localReqBody.toByteArray();
      localGetFriendListReq.vec0xd6bReq = localReqBody1.toByteArray();
      localGetFriendListReq.vecSnsTypelist = ((FriendListRequestData)localObject).getSNSTypeList();
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
  
  /* Error */
  private final boolean c(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 263
    //   4: invokevirtual 269	com/qq/jce/wup/UniPacket:setServantName	(Ljava/lang/String;)V
    //   7: aload_2
    //   8: ldc_w 295
    //   11: invokevirtual 274	com/qq/jce/wup/UniPacket:setFuncName	(Ljava/lang/String;)V
    //   14: new 297	friendlist/SetGroupReq
    //   17: dup
    //   18: invokespecial 298	friendlist/SetGroupReq:<init>	()V
    //   21: astore 4
    //   23: aload_1
    //   24: invokevirtual 160	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   27: astore 5
    //   29: aload 5
    //   31: ldc 162
    //   33: invokestatic 168	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   36: aload 4
    //   38: aload 5
    //   40: invokestatic 174	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   43: putfield 299	friendlist/SetGroupReq:uin	J
    //   46: aload_1
    //   47: getfield 85	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   50: ldc_w 301
    //   53: invokestatic 93	kotlin/jvm/internal/Reflection:getOrCreateKotlinClass	(Ljava/lang/Class;)Lkotlin/reflect/KClass;
    //   56: invokeinterface 99 1 0
    //   61: invokevirtual 105	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   64: astore 6
    //   66: aload 6
    //   68: instanceof 301
    //   71: ifne +14 -> 85
    //   74: ldc 59
    //   76: iconst_1
    //   77: ldc_w 303
    //   80: invokestatic 306	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: iconst_0
    //   84: ireturn
    //   85: aload 4
    //   87: aload 6
    //   89: checkcast 301	com/tencent/mobileqq/friend/data/GroupRequestData
    //   92: invokevirtual 309	com/tencent/mobileqq/friend/data/GroupRequestData:getReqType	()I
    //   95: putfield 310	friendlist/SetGroupReq:reqtype	I
    //   98: new 312	java/io/ByteArrayOutputStream
    //   101: dup
    //   102: bipush 10
    //   104: invokespecial 314	java/io/ByteArrayOutputStream:<init>	(I)V
    //   107: astore_1
    //   108: new 316	java/io/DataOutputStream
    //   111: dup
    //   112: aload_1
    //   113: checkcast 318	java/io/OutputStream
    //   116: invokespecial 321	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   119: astore 5
    //   121: aload 6
    //   123: checkcast 301	com/tencent/mobileqq/friend/data/GroupRequestData
    //   126: invokevirtual 309	com/tencent/mobileqq/friend/data/GroupRequestData:getReqType	()I
    //   129: istore_3
    //   130: iload_3
    //   131: ifeq +303 -> 434
    //   134: iload_3
    //   135: iconst_1
    //   136: if_icmpeq +171 -> 307
    //   139: iload_3
    //   140: iconst_2
    //   141: if_icmpeq +131 -> 272
    //   144: iload_3
    //   145: iconst_3
    //   146: if_icmpeq +5 -> 151
    //   149: iconst_0
    //   150: ireturn
    //   151: new 323	friendlist/ReSortGroup
    //   154: dup
    //   155: invokespecial 324	friendlist/ReSortGroup:<init>	()V
    //   158: astore 7
    //   160: aload 7
    //   162: aload 6
    //   164: checkcast 301	com/tencent/mobileqq/friend/data/GroupRequestData
    //   167: invokevirtual 327	com/tencent/mobileqq/friend/data/GroupRequestData:getGroupIdList	()[B
    //   170: putfield 330	friendlist/ReSortGroup:cGroupId	[B
    //   173: aload 7
    //   175: aload 6
    //   177: checkcast 301	com/tencent/mobileqq/friend/data/GroupRequestData
    //   180: invokevirtual 333	com/tencent/mobileqq/friend/data/GroupRequestData:getSortIdList	()[B
    //   183: putfield 336	friendlist/ReSortGroup:cSortId	[B
    //   186: aload 7
    //   188: aload 7
    //   190: getfield 330	friendlist/ReSortGroup:cGroupId	[B
    //   193: arraylength
    //   194: i2b
    //   195: putfield 339	friendlist/ReSortGroup:cNum	B
    //   198: aload 5
    //   200: aload 7
    //   202: getfield 339	friendlist/ReSortGroup:cNum	B
    //   205: invokevirtual 342	java/io/DataOutputStream:writeByte	(I)V
    //   208: aload 7
    //   210: getfield 330	friendlist/ReSortGroup:cGroupId	[B
    //   213: astore 6
    //   215: aload 6
    //   217: ldc_w 344
    //   220: invokestatic 168	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   223: aload 7
    //   225: getfield 336	friendlist/ReSortGroup:cSortId	[B
    //   228: astore 7
    //   230: aload 7
    //   232: ldc_w 346
    //   235: invokestatic 168	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   238: iconst_0
    //   239: istore_3
    //   240: iload_3
    //   241: aload 6
    //   243: arraylength
    //   244: if_icmpge +303 -> 547
    //   247: aload 5
    //   249: aload 6
    //   251: iload_3
    //   252: baload
    //   253: invokevirtual 342	java/io/DataOutputStream:writeByte	(I)V
    //   256: aload 5
    //   258: aload 7
    //   260: iload_3
    //   261: baload
    //   262: invokevirtual 342	java/io/DataOutputStream:writeByte	(I)V
    //   265: iload_3
    //   266: iconst_1
    //   267: iadd
    //   268: istore_3
    //   269: goto -29 -> 240
    //   272: new 348	friendlist/DelGroup
    //   275: dup
    //   276: invokespecial 349	friendlist/DelGroup:<init>	()V
    //   279: astore 7
    //   281: aload 7
    //   283: aload 6
    //   285: checkcast 301	com/tencent/mobileqq/friend/data/GroupRequestData
    //   288: invokevirtual 352	com/tencent/mobileqq/friend/data/GroupRequestData:getGroupId	()B
    //   291: putfield 354	friendlist/DelGroup:cGroupId	B
    //   294: aload 5
    //   296: aload 7
    //   298: getfield 354	friendlist/DelGroup:cGroupId	B
    //   301: invokevirtual 342	java/io/DataOutputStream:writeByte	(I)V
    //   304: goto +243 -> 547
    //   307: new 356	friendlist/RenameGroup
    //   310: dup
    //   311: invokespecial 357	friendlist/RenameGroup:<init>	()V
    //   314: astore 7
    //   316: aload 7
    //   318: aload 6
    //   320: checkcast 301	com/tencent/mobileqq/friend/data/GroupRequestData
    //   323: invokevirtual 352	com/tencent/mobileqq/friend/data/GroupRequestData:getGroupId	()B
    //   326: putfield 358	friendlist/RenameGroup:cGroupId	B
    //   329: aload 7
    //   331: aload 6
    //   333: checkcast 301	com/tencent/mobileqq/friend/data/GroupRequestData
    //   336: invokevirtual 361	com/tencent/mobileqq/friend/data/GroupRequestData:getName	()Ljava/lang/String;
    //   339: putfield 365	friendlist/RenameGroup:sGroupName	Ljava/lang/String;
    //   342: aload 7
    //   344: getfield 365	friendlist/RenameGroup:sGroupName	Ljava/lang/String;
    //   347: astore 6
    //   349: aload 6
    //   351: ldc_w 367
    //   354: invokestatic 168	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   357: getstatic 373	kotlin/text/Charsets:UTF_8	Ljava/nio/charset/Charset;
    //   360: astore 8
    //   362: aload 6
    //   364: ifnull +59 -> 423
    //   367: aload 6
    //   369: aload 8
    //   371: invokevirtual 379	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   374: astore 6
    //   376: aload 6
    //   378: ldc_w 381
    //   381: invokestatic 168	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   384: aload 7
    //   386: aload 6
    //   388: arraylength
    //   389: i2b
    //   390: putfield 384	friendlist/RenameGroup:cLen	B
    //   393: aload 5
    //   395: aload 7
    //   397: getfield 358	friendlist/RenameGroup:cGroupId	B
    //   400: invokevirtual 387	java/io/DataOutputStream:write	(I)V
    //   403: aload 5
    //   405: aload 7
    //   407: getfield 384	friendlist/RenameGroup:cLen	B
    //   410: invokevirtual 342	java/io/DataOutputStream:writeByte	(I)V
    //   413: aload 5
    //   415: aload 6
    //   417: invokevirtual 390	java/io/DataOutputStream:write	([B)V
    //   420: goto +127 -> 547
    //   423: new 392	kotlin/TypeCastException
    //   426: dup
    //   427: ldc_w 394
    //   430: invokespecial 396	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   433: athrow
    //   434: new 398	friendlist/AddGroup
    //   437: dup
    //   438: invokespecial 399	friendlist/AddGroup:<init>	()V
    //   441: astore 7
    //   443: aload 7
    //   445: aload 6
    //   447: checkcast 301	com/tencent/mobileqq/friend/data/GroupRequestData
    //   450: invokevirtual 402	com/tencent/mobileqq/friend/data/GroupRequestData:getSortId	()B
    //   453: putfield 404	friendlist/AddGroup:cSortId	B
    //   456: aload 7
    //   458: aload 6
    //   460: checkcast 301	com/tencent/mobileqq/friend/data/GroupRequestData
    //   463: invokevirtual 361	com/tencent/mobileqq/friend/data/GroupRequestData:getName	()Ljava/lang/String;
    //   466: putfield 405	friendlist/AddGroup:sGroupName	Ljava/lang/String;
    //   469: aload 7
    //   471: getfield 405	friendlist/AddGroup:sGroupName	Ljava/lang/String;
    //   474: astore 6
    //   476: aload 6
    //   478: ldc_w 407
    //   481: invokestatic 168	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   484: getstatic 373	kotlin/text/Charsets:UTF_8	Ljava/nio/charset/Charset;
    //   487: astore 8
    //   489: aload 6
    //   491: ifnull +81 -> 572
    //   494: aload 6
    //   496: aload 8
    //   498: invokevirtual 379	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   501: astore 6
    //   503: aload 6
    //   505: ldc_w 381
    //   508: invokestatic 168	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   511: aload 7
    //   513: aload 6
    //   515: arraylength
    //   516: i2b
    //   517: putfield 408	friendlist/AddGroup:cLen	B
    //   520: aload 5
    //   522: aload 7
    //   524: getfield 404	friendlist/AddGroup:cSortId	B
    //   527: invokevirtual 342	java/io/DataOutputStream:writeByte	(I)V
    //   530: aload 5
    //   532: aload 7
    //   534: getfield 408	friendlist/AddGroup:cLen	B
    //   537: invokevirtual 342	java/io/DataOutputStream:writeByte	(I)V
    //   540: aload 5
    //   542: aload 6
    //   544: invokevirtual 390	java/io/DataOutputStream:write	([B)V
    //   547: aload 5
    //   549: invokevirtual 411	java/io/DataOutputStream:close	()V
    //   552: aload 4
    //   554: aload_1
    //   555: invokevirtual 412	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   558: putfield 415	friendlist/SetGroupReq:vecBody	[B
    //   561: aload_2
    //   562: ldc_w 295
    //   565: aload 4
    //   567: invokevirtual 280	com/qq/jce/wup/UniPacket:put	(Ljava/lang/String;Ljava/lang/Object;)V
    //   570: iconst_1
    //   571: ireturn
    //   572: new 392	kotlin/TypeCastException
    //   575: dup
    //   576: ldc_w 394
    //   579: invokespecial 396	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   582: athrow
    //   583: astore_1
    //   584: ldc 59
    //   586: iconst_1
    //   587: ldc_w 416
    //   590: aload_1
    //   591: checkcast 418	java/lang/Throwable
    //   594: invokestatic 421	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   597: iconst_0
    //   598: ireturn
    //   599: astore_1
    //   600: iconst_0
    //   601: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	602	0	this	FriendListJCECoder
    //   0	602	1	paramToServiceMsg	ToServiceMsg
    //   0	602	2	paramUniPacket	UniPacket
    //   129	140	3	i	int
    //   21	545	4	localSetGroupReq	friendlist.SetGroupReq
    //   27	521	5	localObject1	Object
    //   64	479	6	localObject2	Object
    //   158	375	7	localObject3	Object
    //   360	137	8	localCharset	java.nio.charset.Charset
    // Exception table:
    //   from	to	target	type
    //   23	46	583	java/lang/NumberFormatException
    //   121	130	599	java/io/IOException
    //   151	238	599	java/io/IOException
    //   240	265	599	java/io/IOException
    //   272	304	599	java/io/IOException
    //   307	362	599	java/io/IOException
    //   367	420	599	java/io/IOException
    //   423	434	599	java/io/IOException
    //   434	489	599	java/io/IOException
    //   494	547	599	java/io/IOException
    //   547	552	599	java/io/IOException
    //   572	583	599	java/io/IOException
  }
  
  @Nullable
  public Object a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "request");
    Intrinsics.checkParameterIsNotNull(paramFromServiceMsg, "response");
    String str = paramFromServiceMsg.getServiceCmd();
    if (str != null)
    {
      int i = str.hashCode();
      if (i != -484913285)
      {
        if ((i == 1017644367) && (str.equals("friendlist.SetGroupReq"))) {
          return c(paramToServiceMsg, paramFromServiceMsg);
        }
      }
      else if (str.equals("friendlist.getFriendGroupList")) {
        return b(paramToServiceMsg, paramFromServiceMsg);
      }
    }
    return Boolean.valueOf(false);
  }
  
  public boolean a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull UniPacket paramUniPacket)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "request");
    Intrinsics.checkParameterIsNotNull(paramUniPacket, "client");
    String str = paramToServiceMsg.getServiceCmd();
    if (str != null)
    {
      int i = str.hashCode();
      if (i != -484913285)
      {
        if ((i == 1017644367) && (str.equals("friendlist.SetGroupReq"))) {
          return c(paramToServiceMsg, paramUniPacket);
        }
      }
      else if (str.equals("friendlist.getFriendGroupList")) {
        return b(paramToServiceMsg, paramUniPacket);
      }
    }
    return false;
  }
  
  @NotNull
  public String[] a()
  {
    return new String[] { "friendlist.getFriendGroupList", "friendlist.SetGroupReq" };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.servlet.coder.FriendListJCECoder
 * JD-Core Version:    0.7.0.1
 */