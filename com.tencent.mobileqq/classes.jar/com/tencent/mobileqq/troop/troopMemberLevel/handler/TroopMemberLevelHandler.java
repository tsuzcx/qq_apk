package com.tencent.mobileqq.troop.troopmemberlevel.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.TroopMemberLevelObserver;
import com.tencent.mobileqq.troop.troopmemberlevel.api.ITroopMemberLevelHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.LevelName;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;
import tencent.im.oidb.cmd0x787.oidb_0x787.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopMemberLevelHandler
  extends TroopBaseHandler
  implements ITroopMemberLevelHandler
{
  protected Set<String> a;
  protected ConcurrentHashMap<String, Long> b = new ConcurrentHashMap();
  
  public TroopMemberLevelHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(oidb_0x787.RspBody paramRspBody, List<oidb_0x787.LevelName> paramList1, List<oidb_0x787.LevelName> paramList2)
  {
    ITroopInfoService localITroopInfoService = (ITroopInfoService)this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
    long l = paramRspBody.uint64_group_code.get();
    TroopInfo localTroopInfo2 = localITroopInfoService.findTroopInfo(String.valueOf(l));
    TroopInfo localTroopInfo1 = localTroopInfo2;
    if (localTroopInfo2 == null)
    {
      localTroopInfo1 = new TroopInfo();
      localTroopInfo1.troopuin = String.valueOf(l);
    }
    int i;
    if (localTroopInfo1 != null)
    {
      localTroopInfo1.setTroopLevelMap787(paramList1, paramList2);
      if (paramRspBody.uint32_level_name_seq.has())
      {
        i = paramRspBody.uint32_level_name_seq.get();
        localTroopInfo1.dwGroupLevelSeq = i;
        if (QLog.isColorLevel())
        {
          paramList1 = new StringBuilder();
          paramList1.append("levelMap seq=");
          paramList1.append(i);
          QLog.d("Q.getTroopMemberLevelInfo", 2, paramList1.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("Q.getTroopMemberLevelInfo", 2, "has levelMap but no seq");
      }
      if (paramRspBody.bytes_owner_name == null) {}
    }
    try
    {
      localTroopInfo1.ownerNameShow = paramRspBody.bytes_owner_name.get().toStringUtf8();
    }
    catch (Exception paramList1)
    {
      label186:
      break label186;
    }
    if (paramRspBody.bytes_admin_name != null) {}
    try
    {
      localTroopInfo1.adminNameShow = paramRspBody.bytes_admin_name.get().toStringUtf8();
    }
    catch (Exception paramList1)
    {
      label211:
      boolean bool;
      int k;
      int j;
      break label211;
    }
    bool = paramRspBody.uint32_sys_show_flag.has();
    k = -1;
    if (bool)
    {
      localTroopInfo1.cGroupRankSysFlag = ((byte)paramRspBody.uint32_sys_show_flag.get());
      i = localTroopInfo1.cGroupRankSysFlag;
    }
    else
    {
      i = -1;
    }
    if (paramRspBody.uint32_user_show_flag.has())
    {
      localTroopInfo1.cGroupRankUserFlag = ((byte)paramRspBody.uint32_user_show_flag.get());
      j = localTroopInfo1.cGroupRankUserFlag;
    }
    else
    {
      j = -1;
    }
    if (paramRspBody.uint32_user_show_flag_new.has())
    {
      localTroopInfo1.cNewGroupRankUserFlag = ((byte)paramRspBody.uint32_user_show_flag_new.get());
      k = localTroopInfo1.cNewGroupRankUserFlag;
    }
    if (QLog.isColorLevel())
    {
      paramRspBody = new StringBuilder();
      paramRspBody.append(l);
      paramRspBody.append(", sysFlag:");
      paramRspBody.append(i);
      paramRspBody.append(", userFlag:");
      paramRspBody.append(j);
      paramRspBody.append(", newUserFlag:");
      paramRspBody.append(k);
      QLog.d("Q.getTroopMemberLevelInfo", 2, paramRspBody.toString());
    }
    localITroopInfoService.saveTroopInfo(localTroopInfo1);
  }
  
  /* Error */
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 185	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +443 -> 447
    //   7: new 187	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   10: dup
    //   11: invokespecial 188	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   14: astore_1
    //   15: aload_1
    //   16: aload_3
    //   17: checkcast 190	[B
    //   20: checkcast 190	[B
    //   23: invokevirtual 194	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   26: checkcast 187	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   29: astore_2
    //   30: aload_2
    //   31: astore_1
    //   32: goto +48 -> 80
    //   35: astore_2
    //   36: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +37 -> 76
    //   42: new 98	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   49: astore_3
    //   50: aload_3
    //   51: ldc 196
    //   53: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_3
    //   58: aload_2
    //   59: invokevirtual 197	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:toString	()Ljava/lang/String;
    //   62: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: ldc 110
    //   68: iconst_2
    //   69: aload_3
    //   70: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_2
    //   77: invokevirtual 203	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   80: iconst_m1
    //   81: istore 4
    //   83: aload_1
    //   84: ifnull +58 -> 142
    //   87: aload_1
    //   88: getfield 206	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   91: invokevirtual 87	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   94: istore 5
    //   96: iload 5
    //   98: istore 4
    //   100: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +39 -> 142
    //   106: new 98	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   113: astore_2
    //   114: aload_2
    //   115: ldc 208
    //   117: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload_2
    //   122: iload 5
    //   124: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: ldc 110
    //   130: iconst_2
    //   131: aload_2
    //   132: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: iload 5
    //   140: istore 4
    //   142: iload 4
    //   144: ifne +344 -> 488
    //   147: aload_1
    //   148: ifnull +340 -> 488
    //   151: aload_1
    //   152: getfield 211	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   155: invokevirtual 212	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   158: ifeq +330 -> 488
    //   161: aload_1
    //   162: getfield 211	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   165: invokevirtual 129	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   168: ifnull +320 -> 488
    //   171: aload_1
    //   172: getfield 211	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   175: invokevirtual 129	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   178: invokevirtual 216	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   181: astore_3
    //   182: aload_0
    //   183: getfield 31	com/tencent/mobileqq/troop/troopmemberlevel/handler/TroopMemberLevelHandler:appRuntime	Lcom/tencent/common/app/AppInterface;
    //   186: ldc 33
    //   188: ldc 35
    //   190: invokevirtual 41	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   193: checkcast 33	com/tencent/mobileqq/troop/api/ITroopInfoService
    //   196: invokeinterface 220 1 0
    //   201: astore_1
    //   202: new 43	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   205: dup
    //   206: invokespecial 221	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   209: astore_2
    //   210: aload_2
    //   211: aload_3
    //   212: invokevirtual 222	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   215: pop
    //   216: aload_1
    //   217: invokevirtual 227	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   220: aload_2
    //   221: getfield 47	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   224: invokevirtual 228	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   227: ifeq +209 -> 436
    //   230: aload_2
    //   231: getfield 232	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   234: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   237: ifne +199 -> 436
    //   240: aload_2
    //   241: getfield 240	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   244: invokevirtual 237	com/tencent/mobileqq/pb/PBRepeatMessageField:isEmpty	()Z
    //   247: ifne +189 -> 436
    //   250: aload_2
    //   251: getfield 232	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   254: invokevirtual 243	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   257: astore_3
    //   258: aload_2
    //   259: getfield 240	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_level_name_new	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   262: invokevirtual 243	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   265: astore 6
    //   267: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   270: ifeq +96 -> 366
    //   273: new 98	java/lang/StringBuilder
    //   276: dup
    //   277: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   280: astore 7
    //   282: aload 7
    //   284: ldc 245
    //   286: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: iconst_0
    //   291: istore 5
    //   293: aload_3
    //   294: ifnonnull +9 -> 303
    //   297: iconst_0
    //   298: istore 4
    //   300: goto +11 -> 311
    //   303: aload_3
    //   304: invokeinterface 250 1 0
    //   309: istore 4
    //   311: aload 7
    //   313: iload 4
    //   315: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload 7
    //   321: ldc 252
    //   323: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   326: pop
    //   327: aload_3
    //   328: ifnonnull +10 -> 338
    //   331: iload 5
    //   333: istore 4
    //   335: goto +12 -> 347
    //   338: aload 6
    //   340: invokeinterface 250 1 0
    //   345: istore 4
    //   347: aload 7
    //   349: iload 4
    //   351: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   354: pop
    //   355: ldc 110
    //   357: iconst_2
    //   358: aload 7
    //   360: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   366: aload_3
    //   367: ifnull +16 -> 383
    //   370: aload 6
    //   372: ifnull +11 -> 383
    //   375: aload_0
    //   376: aload_2
    //   377: aload_3
    //   378: aload 6
    //   380: invokespecial 254	com/tencent/mobileqq/troop/troopmemberlevel/handler/TroopMemberLevelHandler:a	(Ltencent/im/oidb/cmd0x787/oidb_0x787$RspBody;Ljava/util/List;Ljava/util/List;)V
    //   383: aload_1
    //   384: invokevirtual 257	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   387: goto +49 -> 436
    //   390: astore_2
    //   391: goto +50 -> 441
    //   394: astore_2
    //   395: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq +38 -> 436
    //   401: new 98	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   408: astore_3
    //   409: aload_3
    //   410: ldc_w 259
    //   413: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_3
    //   418: aload_2
    //   419: invokevirtual 260	java/lang/Exception:toString	()Ljava/lang/String;
    //   422: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: ldc 110
    //   428: iconst_2
    //   429: aload_3
    //   430: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: aload_1
    //   437: invokevirtual 263	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   440: return
    //   441: aload_1
    //   442: invokevirtual 263	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   445: aload_2
    //   446: athrow
    //   447: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +38 -> 488
    //   453: new 98	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   460: astore_1
    //   461: aload_1
    //   462: ldc_w 265
    //   465: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload_1
    //   470: aload_2
    //   471: invokevirtual 268	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   474: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   477: pop
    //   478: ldc 110
    //   480: iconst_2
    //   481: aload_1
    //   482: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   485: invokestatic 200	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   488: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	489	0	this	TroopMemberLevelHandler
    //   0	489	1	paramToServiceMsg	ToServiceMsg
    //   0	489	2	paramFromServiceMsg	FromServiceMsg
    //   0	489	3	paramObject	Object
    //   81	269	4	i	int
    //   94	238	5	j	int
    //   265	114	6	localList	List
    //   280	79	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   15	30	35	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   202	290	390	finally
    //   303	311	390	finally
    //   311	327	390	finally
    //   338	347	390	finally
    //   347	366	390	finally
    //   375	383	390	finally
    //   383	387	390	finally
    //   395	436	390	finally
    //   202	290	394	java/lang/Exception
    //   303	311	394	java/lang/Exception
    //   311	327	394	java/lang/Exception
    //   338	347	394	java/lang/Exception
    //   347	366	394	java/lang/Exception
    //   375	383	394	java/lang/Exception
    //   383	387	394	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    a(paramString, true);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getTroopLevelSwitchAndMap net disabble, return:");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("Q.getTroopMemberLevelInfo", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      long l;
      if (this.b.containsKey(paramString)) {
        l = ((Long)this.b.get(paramString)).longValue();
      } else {
        l = 0L;
      }
      if (System.currentTimeMillis() - l < 30000L)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getTroopLevelSwitchAndMap: lastReq < 30s, return:");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("Q.getTroopMemberLevelInfo", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      this.b.put(paramString, Long.valueOf(System.currentTimeMillis()));
    }
    Object localObject2 = new oidb_0x787.Filter();
    ((oidb_0x787.Filter)localObject2).uint32_member_level_info_uin.set(0);
    ((oidb_0x787.Filter)localObject2).uint32_member_level_info_point.set(0);
    ((oidb_0x787.Filter)localObject2).uint32_member_level_info_active_day.set(0);
    ((oidb_0x787.Filter)localObject2).uint32_member_level_info_level.set(0);
    ((oidb_0x787.Filter)localObject2).uint32_level_name.set(1);
    ((oidb_0x787.Filter)localObject2).uint32_data_time.set(0);
    ((oidb_0x787.Filter)localObject2).uint32_sys_show_flag.set(0);
    ((oidb_0x787.Filter)localObject2).uint32_user_show_flag.set(0);
    ((oidb_0x787.Filter)localObject2).uint32_user_show_flag_new.set(0);
    ((oidb_0x787.Filter)localObject2).uint32_level_name_new.set(1);
    Object localObject1 = new oidb_0x787.ReqBody();
    ((oidb_0x787.ReqBody)localObject1).uint64_group_code.set(Long.parseLong(paramString));
    ((oidb_0x787.ReqBody)localObject1).uint64_begin_uin.set(0L);
    ((oidb_0x787.ReqBody)localObject1).uint64_data_time.set(0L);
    ((oidb_0x787.ReqBody)localObject1).rpt_uin_list.add(Long.valueOf(this.appRuntime.getLongAccountUin()));
    ((oidb_0x787.ReqBody)localObject1).opt_filter.set((MessageMicro)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1927);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x787.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0x787_0");
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject1);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getTroopLevelSwitchAndMap: troopCode=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", isForceReq=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q.getTroopMemberLevelInfo", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  protected String dv_()
  {
    return "TroopMemberLevelHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null) {
      this.a = new HashSet();
    }
    this.a.add("OidbSvc.0x787_0");
    return this.a;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopMemberLevelObserver.class;
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
          QLog.d("TroopMemberLevelHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if (!dv_().equals(paramToServiceMsg.extraData.getString("REQ_TAG")))
      {
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("REQ_TAG doesn't match. cmd:  ");
          paramToServiceMsg.append(str);
          QLog.d("TroopMemberLevelHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("OidbSvc.0x787_0".equals(paramFromServiceMsg.getServiceCmd())) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberLevelHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopmemberlevel.handler.TroopMemberLevelHandler
 * JD-Core Version:    0.7.0.1
 */