package com.tencent.mobileqq.troop.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.data.troop.TroopClipPic;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.handler.ITroopAvatarHandler;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortrait;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupHeadPortraitInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.DelPicReq;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.GroupPicListInfo;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.ModifyOrderReq;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.ReqBody;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.RspBody;
import tencent.im.oidb.cmd0x8b8.oidb_0x8b8.SetDefaultReq;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopAvatarHandler
  extends TroopBaseHandler
  implements ITroopAvatarHandler
{
  public TroopAvatarHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private static int a(oidb_0x88d.GroupHeadPortrait paramGroupHeadPortrait, List<TroopClipPic> paramList)
  {
    int n = paramGroupHeadPortrait.uint32_default_id.get();
    paramGroupHeadPortrait = paramGroupHeadPortrait.rpt_msg_info.get().iterator();
    for (;;)
    {
      boolean bool = paramGroupHeadPortrait.hasNext();
      int m = 0;
      if (!bool) {
        break;
      }
      oidb_0x88d.GroupHeadPortraitInfo localGroupHeadPortraitInfo = (oidb_0x88d.GroupHeadPortraitInfo)paramGroupHeadPortrait.next();
      TroopClipPic localTroopClipPic = new TroopClipPic();
      localTroopClipPic.id = String.valueOf(localGroupHeadPortraitInfo.rpt_uint32_pic_id.get());
      int i;
      if (localGroupHeadPortraitInfo.uint32_left_x.has()) {
        i = localGroupHeadPortraitInfo.uint32_left_x.get();
      } else {
        i = 0;
      }
      int j;
      if (localGroupHeadPortraitInfo.uint32_left_y.has()) {
        j = localGroupHeadPortraitInfo.uint32_left_y.get();
      } else {
        j = 0;
      }
      int k;
      if (localGroupHeadPortraitInfo.uint32_right_x.has()) {
        k = localGroupHeadPortraitInfo.uint32_right_x.get();
      } else {
        k = 0;
      }
      if (localGroupHeadPortraitInfo.uint32_right_y.has()) {
        m = localGroupHeadPortraitInfo.uint32_right_y.get();
      }
      if ((i >= 0) && (j >= 0) && (k >= 0) && (m >= 0)) {
        localTroopClipPic.clipInfo = a(i, j, k, m);
      }
      if (n == localGroupHeadPortraitInfo.rpt_uint32_pic_id.get()) {
        localTroopClipPic.type = 1;
      }
      paramList.add(localTroopClipPic);
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopAvatarHandler", 2, String.format("getPicsFrom88d avatarId=%d %s", new Object[] { Integer.valueOf(n), Arrays.toString(paramList.toArray()) }));
    }
    return n;
  }
  
  private static int a(oidb_0x8b8.RspBody paramRspBody, List<TroopClipPic> paramList)
  {
    int n = paramRspBody.uint32_default_id.get();
    if ((paramRspBody.rpt_msg_pic_list_info.has()) && (paramRspBody.rpt_msg_pic_list_info.get().size() > 0))
    {
      paramRspBody = paramRspBody.rpt_msg_pic_list_info.get().iterator();
      while (paramRspBody.hasNext())
      {
        oidb_0x8b8.GroupPicListInfo localGroupPicListInfo = (oidb_0x8b8.GroupPicListInfo)paramRspBody.next();
        if (localGroupPicListInfo.uint32_pic_id.get() > 0)
        {
          TroopClipPic localTroopClipPic = new TroopClipPic();
          localTroopClipPic.id = String.valueOf(localGroupPicListInfo.uint32_pic_id.get());
          int i;
          if (localGroupPicListInfo.uint32_left_x.has()) {
            i = localGroupPicListInfo.uint32_left_x.get();
          } else {
            i = 0;
          }
          int j;
          if (localGroupPicListInfo.uint32_left_y.has()) {
            j = localGroupPicListInfo.uint32_left_y.get();
          } else {
            j = 0;
          }
          int k;
          if (localGroupPicListInfo.uint32_right_x.has()) {
            k = localGroupPicListInfo.uint32_right_x.get();
          } else {
            k = 0;
          }
          int m;
          if (localGroupPicListInfo.uint32_right_y.has()) {
            m = localGroupPicListInfo.uint32_right_y.get();
          } else {
            m = 0;
          }
          if ((i >= 0) && (j >= 0) && (k >= 0) && (m >= 0)) {
            localTroopClipPic.clipInfo = a(i, j, k, m);
          }
          if (n == localGroupPicListInfo.uint32_pic_id.get()) {
            localTroopClipPic.type = 1;
          }
          paramList.add(localTroopClipPic);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopAvatarHandler", 2, String.format("getPicsFrom8b8 avatarId=%d %s", new Object[] { Integer.valueOf(n), Arrays.toString(paramList.toArray()) }));
    }
    return n;
  }
  
  private static String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt4);
    return localStringBuilder.toString();
  }
  
  private static Set<String> a(oidb_0x88d.GroupHeadPortrait paramGroupHeadPortrait)
  {
    int i = paramGroupHeadPortrait.uint32_verifying_pic_cnt.get();
    int j = paramGroupHeadPortrait.rpt_msg_verifyingpic_info.size();
    if ((i != j) && (QLog.isColorLevel())) {
      QLog.d("TroopInfo", 2, String.format("wrong data from server! uint32_verifying_pic_cnt = %d not equals rpt_msg_verifyingpic_info's size = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
    }
    HashSet localHashSet = new HashSet();
    paramGroupHeadPortrait = paramGroupHeadPortrait.rpt_msg_verifyingpic_info.get().iterator();
    while (paramGroupHeadPortrait.hasNext()) {
      localHashSet.add(String.valueOf(((oidb_0x88d.GroupHeadPortraitInfo)paramGroupHeadPortrait.next()).rpt_uint32_pic_id.get()));
    }
    return localHashSet;
  }
  
  protected String a()
  {
    return "TroopAvatarHandler";
  }
  
  /* Error */
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 206	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc 208
    //   6: invokevirtual 214	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   9: lstore 9
    //   11: aload_1
    //   12: getfield 206	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   15: ldc 216
    //   17: invokevirtual 220	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   20: pop
    //   21: new 222	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 223	java/util/ArrayList:<init>	()V
    //   28: astore 14
    //   30: aload_2
    //   31: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   34: istore 4
    //   36: aconst_null
    //   37: astore_1
    //   38: aconst_null
    //   39: astore_1
    //   40: iload 4
    //   42: sipush 1000
    //   45: if_icmpne +481 -> 526
    //   48: new 230	com/tencent/mobileqq/troop/handler/TroopAvatarHandler$DecodeGetTroopAvatarWallPkg
    //   51: dup
    //   52: aload_0
    //   53: aload_3
    //   54: checkcast 232	[B
    //   57: checkcast 232	[B
    //   60: iconst_m1
    //   61: invokespecial 235	com/tencent/mobileqq/troop/handler/TroopAvatarHandler$DecodeGetTroopAvatarWallPkg:<init>	(Lcom/tencent/mobileqq/troop/handler/TroopAvatarHandler;[BI)V
    //   64: invokevirtual 238	com/tencent/mobileqq/troop/handler/TroopAvatarHandler$DecodeGetTroopAvatarWallPkg:a	()Lcom/tencent/mobileqq/troop/handler/TroopAvatarHandler$DecodeGetTroopAvatarWallPkg;
    //   67: astore_3
    //   68: aload_3
    //   69: invokevirtual 240	com/tencent/mobileqq/troop/handler/TroopAvatarHandler$DecodeGetTroopAvatarWallPkg:a	()I
    //   72: istore 5
    //   74: aload_3
    //   75: invokevirtual 243	com/tencent/mobileqq/troop/handler/TroopAvatarHandler$DecodeGetTroopAvatarWallPkg:a	()Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;
    //   78: astore_3
    //   79: aload_3
    //   80: ifnull +439 -> 519
    //   83: aload_3
    //   84: getfield 249	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   87: invokevirtual 252	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   90: ifeq +429 -> 519
    //   93: aload_3
    //   94: getfield 249	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   97: invokevirtual 255	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   100: ifnull +419 -> 519
    //   103: aload_3
    //   104: getfield 249	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   107: invokevirtual 255	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   110: invokevirtual 261	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   113: astore 12
    //   115: aload_1
    //   116: astore_3
    //   117: new 263	com/tencent/mobileqq/troop/handler/TroopAvatarHandler$HandleGetTroopAvatarWallGetGroupInfo
    //   120: dup
    //   121: aload_0
    //   122: aconst_null
    //   123: lload 9
    //   125: iload 5
    //   127: aload 12
    //   129: invokespecial 266	com/tencent/mobileqq/troop/handler/TroopAvatarHandler$HandleGetTroopAvatarWallGetGroupInfo:<init>	(Lcom/tencent/mobileqq/troop/handler/TroopAvatarHandler;Ljava/lang/String;JI[B)V
    //   132: invokevirtual 269	com/tencent/mobileqq/troop/handler/TroopAvatarHandler$HandleGetTroopAvatarWallGetGroupInfo:a	()Lcom/tencent/mobileqq/troop/handler/TroopAvatarHandler$HandleGetTroopAvatarWallGetGroupInfo;
    //   135: astore 12
    //   137: aload_1
    //   138: astore_3
    //   139: aload 12
    //   141: invokevirtual 271	com/tencent/mobileqq/troop/handler/TroopAvatarHandler$HandleGetTroopAvatarWallGetGroupInfo:a	()Ljava/lang/String;
    //   144: astore_1
    //   145: aload_1
    //   146: astore_3
    //   147: aload 12
    //   149: invokevirtual 272	com/tencent/mobileqq/troop/handler/TroopAvatarHandler$HandleGetTroopAvatarWallGetGroupInfo:a	()I
    //   152: istore 4
    //   154: aload 12
    //   156: invokevirtual 275	com/tencent/mobileqq/troop/handler/TroopAvatarHandler$HandleGetTroopAvatarWallGetGroupInfo:a	()Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo;
    //   159: astore 13
    //   161: aload 13
    //   163: ifnull +248 -> 411
    //   166: aload_0
    //   167: getfield 279	com/tencent/mobileqq/troop/handler/TroopAvatarHandler:appRuntime	Lcom/tencent/common/app/AppInterface;
    //   170: ldc_w 281
    //   173: ldc 163
    //   175: invokevirtual 287	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   178: checkcast 281	com/tencent/mobileqq/troop/api/ITroopInfoService
    //   181: astore 12
    //   183: aload 12
    //   185: lload 9
    //   187: invokestatic 290	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   190: invokeinterface 294 2 0
    //   195: astore_3
    //   196: aload 13
    //   198: getfield 300	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:msg_head_portrait	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupHeadPortrait;
    //   201: invokevirtual 301	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupHeadPortrait:has	()Z
    //   204: ifeq +152 -> 356
    //   207: aload 13
    //   209: getfield 304	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_head_portrait_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   212: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   215: ifeq +141 -> 356
    //   218: aload 13
    //   220: getfield 300	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:msg_head_portrait	Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupHeadPortrait;
    //   223: astore 15
    //   225: aload 13
    //   227: getfield 304	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_head_portrait_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   230: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   233: istore 5
    //   235: aload 15
    //   237: aload 14
    //   239: invokestatic 306	com/tencent/mobileqq/troop/handler/TroopAvatarHandler:a	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupHeadPortrait;Ljava/util/List;)I
    //   242: istore 8
    //   244: aload 15
    //   246: invokestatic 308	com/tencent/mobileqq/troop/handler/TroopAvatarHandler:a	(Ltencent/im/oidb/cmd0x88d/oidb_0x88d$GroupHeadPortrait;)Ljava/util/Set;
    //   249: astore 13
    //   251: aload_3
    //   252: ifnull +59 -> 311
    //   255: aload_3
    //   256: getfield 314	com/tencent/mobileqq/data/troop/TroopInfo:mTroopPicList	Ljava/util/List;
    //   259: invokeinterface 317 1 0
    //   264: aload_3
    //   265: getfield 314	com/tencent/mobileqq/data/troop/TroopInfo:mTroopPicList	Ljava/util/List;
    //   268: aload 14
    //   270: invokeinterface 321 2 0
    //   275: pop
    //   276: aload_3
    //   277: getfield 325	com/tencent/mobileqq/data/troop/TroopInfo:mTroopVerifyingPics	Ljava/util/Set;
    //   280: invokeinterface 326 1 0
    //   285: aload_3
    //   286: getfield 325	com/tencent/mobileqq/data/troop/TroopInfo:mTroopVerifyingPics	Ljava/util/Set;
    //   289: aload 13
    //   291: invokeinterface 327 2 0
    //   296: pop
    //   297: aload_3
    //   298: iload 8
    //   300: putfield 330	com/tencent/mobileqq/data/troop/TroopInfo:mTroopAvatarId	I
    //   303: aload 12
    //   305: aload_3
    //   306: invokeinterface 334 2 0
    //   311: iconst_1
    //   312: istore 11
    //   314: iload 4
    //   316: istore 6
    //   318: iload 5
    //   320: istore 4
    //   322: iload 8
    //   324: istore 5
    //   326: goto +186 -> 512
    //   329: astore 12
    //   331: iconst_1
    //   332: istore 11
    //   334: iload 4
    //   336: istore 6
    //   338: iload 5
    //   340: istore 7
    //   342: goto +144 -> 486
    //   345: astore 12
    //   347: iconst_1
    //   348: istore 11
    //   350: aload_3
    //   351: astore 13
    //   353: goto +119 -> 472
    //   356: aload 13
    //   358: getfield 304	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_head_portrait_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   361: invokevirtual 76	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   364: ifeq +19 -> 383
    //   367: aload 13
    //   369: getfield 304	tencent/im/oidb/cmd0x88d/oidb_0x88d$GroupInfo:uint32_head_portrait_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   372: invokevirtual 25	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   375: istore 5
    //   377: iconst_1
    //   378: istore 11
    //   380: goto +39 -> 419
    //   383: iconst_1
    //   384: istore 11
    //   386: goto +30 -> 416
    //   389: astore 13
    //   391: aload_3
    //   392: astore 12
    //   394: goto +8 -> 402
    //   397: astore 13
    //   399: aconst_null
    //   400: astore 12
    //   402: iconst_1
    //   403: istore 11
    //   405: aload 13
    //   407: astore_3
    //   408: goto +54 -> 462
    //   411: aconst_null
    //   412: astore_3
    //   413: iconst_0
    //   414: istore 11
    //   416: iconst_m1
    //   417: istore 5
    //   419: iconst_m1
    //   420: istore 7
    //   422: iload 4
    //   424: istore 6
    //   426: iload 5
    //   428: istore 4
    //   430: iload 7
    //   432: istore 5
    //   434: goto +78 -> 512
    //   437: astore_3
    //   438: goto +18 -> 456
    //   441: astore 12
    //   443: aload_3
    //   444: astore_1
    //   445: goto +4 -> 449
    //   448: astore_3
    //   449: iload 5
    //   451: istore 4
    //   453: aload 12
    //   455: astore_3
    //   456: aconst_null
    //   457: astore 12
    //   459: iconst_0
    //   460: istore 11
    //   462: iconst_m1
    //   463: istore 5
    //   465: aload 12
    //   467: astore 13
    //   469: aload_3
    //   470: astore 12
    //   472: iconst_m1
    //   473: istore 8
    //   475: iload 5
    //   477: istore 7
    //   479: aload 13
    //   481: astore_3
    //   482: iload 4
    //   484: istore 6
    //   486: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq +15 -> 504
    //   492: ldc_w 336
    //   495: iconst_2
    //   496: aload 12
    //   498: invokevirtual 337	java/lang/Exception:toString	()Ljava/lang/String;
    //   501: invokestatic 133	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   504: iload 8
    //   506: istore 5
    //   508: iload 7
    //   510: istore 4
    //   512: iload 4
    //   514: istore 7
    //   516: goto +30 -> 546
    //   519: iload 5
    //   521: istore 4
    //   523: goto +6 -> 529
    //   526: iconst_m1
    //   527: istore 4
    //   529: aconst_null
    //   530: astore_3
    //   531: aconst_null
    //   532: astore_1
    //   533: iconst_0
    //   534: istore 11
    //   536: iconst_m1
    //   537: istore 7
    //   539: iconst_m1
    //   540: istore 5
    //   542: iload 4
    //   544: istore 6
    //   546: aload_3
    //   547: ifnull +51 -> 598
    //   550: aload_0
    //   551: getstatic 342	com/tencent/mobileqq/troop/api/observer/TroopAvatarObserver:TYPE_GET_TROOP_AVATAR	I
    //   554: iload 11
    //   556: iconst_5
    //   557: anewarray 110	java/lang/Object
    //   560: dup
    //   561: iconst_0
    //   562: lload 9
    //   564: invokestatic 290	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   567: aastore
    //   568: dup
    //   569: iconst_1
    //   570: iload 6
    //   572: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   575: aastore
    //   576: dup
    //   577: iconst_2
    //   578: aload_1
    //   579: aastore
    //   580: dup
    //   581: iconst_3
    //   582: iload 7
    //   584: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   587: aastore
    //   588: dup
    //   589: iconst_4
    //   590: aconst_null
    //   591: aastore
    //   592: invokevirtual 346	com/tencent/mobileqq/troop/handler/TroopAvatarHandler:notifyUI	(IZLjava/lang/Object;)V
    //   595: goto +49 -> 644
    //   598: aload_0
    //   599: getstatic 342	com/tencent/mobileqq/troop/api/observer/TroopAvatarObserver:TYPE_GET_TROOP_AVATAR	I
    //   602: iload 11
    //   604: iconst_5
    //   605: anewarray 110	java/lang/Object
    //   608: dup
    //   609: iconst_0
    //   610: lload 9
    //   612: invokestatic 290	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: iload 6
    //   620: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   623: aastore
    //   624: dup
    //   625: iconst_2
    //   626: aload_1
    //   627: aastore
    //   628: dup
    //   629: iconst_3
    //   630: iload 7
    //   632: invokestatic 115	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   635: aastore
    //   636: dup
    //   637: iconst_4
    //   638: aload 14
    //   640: aastore
    //   641: invokevirtual 346	com/tencent/mobileqq/troop/handler/TroopAvatarHandler:notifyUI	(IZLjava/lang/Object;)V
    //   644: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   647: ifeq +139 -> 786
    //   650: new 160	java/lang/StringBuilder
    //   653: dup
    //   654: sipush 150
    //   657: invokespecial 349	java/lang/StringBuilder:<init>	(I)V
    //   660: astore_3
    //   661: aload_3
    //   662: ldc_w 351
    //   665: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload_3
    //   670: ldc_w 353
    //   673: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload_3
    //   678: iload 11
    //   680: invokevirtual 356	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload_3
    //   685: ldc_w 358
    //   688: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   691: pop
    //   692: aload_3
    //   693: aload_2
    //   694: invokevirtual 228	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   697: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: aload_3
    //   702: ldc_w 360
    //   705: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: pop
    //   709: aload_3
    //   710: lload 9
    //   712: invokevirtual 363	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   715: pop
    //   716: aload_3
    //   717: ldc_w 365
    //   720: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: pop
    //   724: aload_3
    //   725: iload 5
    //   727: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   730: pop
    //   731: aload_3
    //   732: ldc_w 367
    //   735: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: aload_3
    //   740: iload 7
    //   742: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: aload_3
    //   747: ldc_w 369
    //   750: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload_3
    //   755: iload 6
    //   757: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   760: pop
    //   761: aload_3
    //   762: ldc_w 371
    //   765: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: pop
    //   769: aload_3
    //   770: aload_1
    //   771: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: ldc_w 336
    //   778: iconst_2
    //   779: aload_3
    //   780: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: invokestatic 133	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   786: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	787	0	this	TroopAvatarHandler
    //   0	787	1	paramToServiceMsg	ToServiceMsg
    //   0	787	2	paramFromServiceMsg	FromServiceMsg
    //   0	787	3	paramObject	Object
    //   34	395	4	i	int
    //   72	361	5	j	int
    //   316	109	6	k	int
    //   340	91	7	m	int
    //   242	81	8	n	int
    //   9	177	9	l	long
    //   312	103	11	i1	int
    //   113	191	12	localObject1	Object
    //   329	1	12	localException1	Exception
    //   345	1	12	localException2	Exception
    //   392	9	12	localObject2	Object
    //   441	1	12	localException3	Exception
    //   159	209	13	localObject3	Object
    //   389	1	13	localException4	Exception
    //   397	9	13	localException5	Exception
    //   28	241	14	localArrayList	ArrayList
    //   223	22	15	localGroupHeadPortrait	oidb_0x88d.GroupHeadPortrait
    // Exception table:
    //   from	to	target	type
    //   244	251	329	java/lang/Exception
    //   255	311	329	java/lang/Exception
    //   235	244	345	java/lang/Exception
    //   196	235	389	java/lang/Exception
    //   356	377	389	java/lang/Exception
    //   166	196	397	java/lang/Exception
    //   154	161	437	java/lang/Exception
    //   117	137	441	java/lang/Exception
    //   139	145	441	java/lang/Exception
    //   147	154	441	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    Object localObject1 = new oidb_0x88d.GroupInfo();
    ((oidb_0x88d.GroupInfo)localObject1).uint32_head_portrait_seq.set(0);
    Object localObject2 = new oidb_0x88d.GroupHeadPortrait();
    ((oidb_0x88d.GroupInfo)localObject1).msg_head_portrait.set((MessageMicro)localObject2);
    localObject2 = new oidb_0x88d.ReqGroupInfo();
    try
    {
      ((oidb_0x88d.ReqGroupInfo)localObject2).uint64_group_code.set(Long.parseLong(paramString));
      ((oidb_0x88d.ReqGroupInfo)localObject2).stgroupinfo.set((MessageMicro)localObject1);
      localObject1 = new oidb_0x88d.ReqBody();
      ((oidb_0x88d.ReqBody)localObject1).uint32_appid.set(this.appRuntime.getAppid());
      ((oidb_0x88d.ReqBody)localObject1).stzreqgroupinfo.add((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2189);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(7);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x88d.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvc.0x88d_7");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString));
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public void a(String paramString, int paramInt, ArrayList<Integer> paramArrayList)
  {
    Object localObject1 = new oidb_0x8b8.ReqBody();
    if (paramArrayList != null) {
      if (paramInt > 2) {
        return;
      }
    }
    try
    {
      ((oidb_0x8b8.ReqBody)localObject1).uint64_group_uin.set(Long.parseLong(paramString));
      ((oidb_0x8b8.ReqBody)localObject1).uint32_subcmd.set(paramInt + 1);
      ((oidb_0x8b8.ReqBody)localObject1).uint32_client_ver.set(AppSetting.a());
      ((oidb_0x8b8.ReqBody)localObject1).uint32_sequence.set(23);
      Object localObject2;
      if (paramInt == 0)
      {
        localObject2 = new oidb_0x8b8.ModifyOrderReq();
        ((oidb_0x8b8.ModifyOrderReq)localObject2).rpt_uint32_pic_list.set(paramArrayList);
        ((oidb_0x8b8.ModifyOrderReq)localObject2).uint32_pic_cnt.set(paramArrayList.size());
        ((oidb_0x8b8.ReqBody)localObject1).msg_modify_order.set((MessageMicro)localObject2);
      }
      else
      {
        int i;
        if (paramInt == 1)
        {
          localObject2 = new oidb_0x8b8.SetDefaultReq();
          paramArrayList = paramArrayList.iterator();
          while (paramArrayList.hasNext())
          {
            i = ((Integer)paramArrayList.next()).intValue();
            ((oidb_0x8b8.SetDefaultReq)localObject2).uint32_default_id.set(i);
          }
          ((oidb_0x8b8.ReqBody)localObject1).msg_set_default.set((MessageMicro)localObject2);
        }
        else if (paramInt == 2)
        {
          localObject2 = new oidb_0x8b8.DelPicReq();
          Iterator localIterator = paramArrayList.iterator();
          while (localIterator.hasNext())
          {
            i = ((Integer)localIterator.next()).intValue();
            ((oidb_0x8b8.DelPicReq)localObject2).rpt_uint32_del_list.add(Integer.valueOf(i));
          }
          ((oidb_0x8b8.DelPicReq)localObject2).uint32_del_cnt.set(paramArrayList.size());
          ((oidb_0x8b8.ReqBody)localObject1).msg_del_pic.set((MessageMicro)localObject2);
        }
      }
      paramArrayList = new oidb_sso.OIDBSSOPkg();
      paramArrayList.uint32_command.set(2232);
      paramArrayList.uint32_service_type.set(1);
      paramArrayList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x8b8.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvc.0x8b8_1");
      ((ToServiceMsg)localObject1).putWupBuffer(paramArrayList.toByteArray());
      ((ToServiceMsg)localObject1).extraData.putInt("subCmd", paramInt);
      ((ToServiceMsg)localObject1).extraData.putLong("troop_uin", Long.parseLong(paramString));
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (NumberFormatException paramString) {}
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("troop_uin");
    int k = paramToServiceMsg.extraData.getInt("subCmd");
    Object localObject;
    int i;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handle_oidb_0x8b8_1|oidb_sso parseFrom byte ");
          ((StringBuilder)localObject).append(paramObject.toString());
          QLog.d("Q.troopdisband.", 2, ((StringBuilder)localObject).toString());
        }
      }
      i = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("handle_oidb_0x8b8_1|oidb_sso.OIDBSSOPkg.result ");
        paramObject.append(i);
        QLog.d("Q.troopdisband.", 2, paramObject.toString());
      }
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("oidb_sso.OIDBSSOPkg(0x8b8):{");
        paramObject.append(OidbWrapper.proto2String(paramToServiceMsg));
        paramObject.append("}");
        QLog.d("TroopAvatarHandler", 2, paramObject.toString());
      }
      if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
    }
    for (;;)
    {
      try
      {
        paramObject = new oidb_0x8b8.RspBody();
        paramObject.mergeFrom(paramToServiceMsg);
        i = -1;
        if (!paramObject.uint32_result.has()) {
          break label646;
        }
        int j = paramObject.uint32_result.get();
        i = j;
        if (j != 0) {
          break label646;
        }
        bool = true;
        i = j;
        localObject = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
        paramToServiceMsg = ((ITroopInfoService)localObject).findTroopInfo(String.valueOf(l));
        ArrayList localArrayList = new ArrayList();
        j = a(paramObject, localArrayList);
        if (paramToServiceMsg != null)
        {
          paramToServiceMsg.mTroopAvatarId = j;
          paramToServiceMsg.mTroopPicList.clear();
          paramToServiceMsg.mTroopPicList.addAll(localArrayList);
          ((ITroopInfoService)localObject).saveTroopInfo(paramToServiceMsg);
        }
        notifyUI(TroopAvatarObserver.TYPE_CMD_TROOP_AVATAR, bool, new Object[] { String.valueOf(l), Integer.valueOf(i), null, Integer.valueOf(k), localArrayList });
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder(150);
          ((StringBuilder)localObject).append("handle_oidb_0x8b8_1");
          ((StringBuilder)localObject).append("|isSuccess = ");
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append("|resultcode = ");
          ((StringBuilder)localObject).append(paramFromServiceMsg.getResultCode());
          ((StringBuilder)localObject).append("|troopuin = ");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append("|avatarId = ");
          if (paramToServiceMsg == null) {
            paramToServiceMsg = null;
          } else {
            paramToServiceMsg = Integer.valueOf(paramToServiceMsg.mTroopAvatarId);
          }
          ((StringBuilder)localObject).append(paramToServiceMsg);
          ((StringBuilder)localObject).append("|result = ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("|strErrorMsg = ");
          ((StringBuilder)localObject).append(null);
          QLog.i("Q.troopdisband.", 2, ((StringBuilder)localObject).toString());
        }
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("oidb_0x8b8.RspBody:{");
          paramToServiceMsg.append(OidbWrapper.proto2String(paramObject));
          paramToServiceMsg.append("}");
          QLog.d("TroopAvatarHandler", 2, paramToServiceMsg.toString());
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.troopdisband.", 2, paramToServiceMsg.toString());
        }
      }
      return;
      label646:
      boolean bool = false;
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x88d_7");
      this.allowCmdSet.add("OidbSvc.0x8b8_1");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopAvatarObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramToServiceMsg != null))
    {
      String str = paramFromServiceMsg.getServiceCmd();
      if (msgCmdFilter(str))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("cmdfilter error=");
          paramToServiceMsg.append(str);
          QLog.d("TroopAvatarHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!a().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.d("TroopAvatarHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0x88d_7".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x8b8_1".equals(paramFromServiceMsg.getServiceCmd())) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopAvatarHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopAvatarHandler
 * JD-Core Version:    0.7.0.1
 */