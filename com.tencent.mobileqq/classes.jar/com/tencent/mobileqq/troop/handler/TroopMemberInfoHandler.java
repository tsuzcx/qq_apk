package com.tencent.mobileqq.troop.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.api.config.TroopMemberInfoHandlerProcessorConfig;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberInfoHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0x787.oidb_0x787.Filter;
import tencent.im.oidb.cmd0x787.oidb_0x787.ReqBody;
import tencent.im.oidb.oidb_0x783.oidb_0x783.RemarkInfo;
import tencent.im.oidb.oidb_0x783.oidb_0x783.ReqBody;
import tencent.im.oidb.oidb_0x783.oidb_0x783.RspBody;
import tencent.im.oidb.oidb_0x783.oidb_0x783.UinListInfo;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopMemberInfoHandler
  extends TroopBaseHandler
  implements ITroopMemberInfoHandler
{
  protected Set<String> a;
  
  public TroopMemberInfoHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
    TroopMemberInfoHandlerProcessorConfig.a();
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    try
    {
      oidb_0x783.RspBody localRspBody = new oidb_0x783.RspBody();
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
      if (i == 0)
      {
        i = localRspBody.uint32_result.get();
        if (i == 0)
        {
          paramFromServiceMsg = localRspBody.rpt_remark_infos.get();
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
          {
            paramFromServiceMsg = ((oidb_0x783.RemarkInfo)paramFromServiceMsg.get(0)).bytes_remark.get().toStringUtf8();
            paramToServiceMsg = (String)paramToServiceMsg.extraData.get("memberUin");
            notifyUI(TroopObserver.TYPE_GET_TROOP_MEMBER_AUTO_REMARK, true, new Object[] { paramToServiceMsg, paramFromServiceMsg });
          }
        }
        else
        {
          QLog.e("TroopMemberInfoHandler", 1, new Object[] { "handleGetAutoRemark result failed! result code = ", Integer.valueOf(i), localRspBody.str_errmsg.get() });
        }
      }
      else
      {
        QLog.e("TroopMemberInfoHandler", 1, new Object[] { "handleGetAutoRemark failed! retCode = ", Integer.valueOf(i) });
        return;
      }
    }
    catch (Exception paramToServiceMsg)
    {
      QLog.e("TroopMemberInfoHandler", 1, "handleGetAutoRemark exception. e=", paramToServiceMsg);
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg == null)
    {
      QLog.e("TroopMemberInfoHandler", 2, "handle0x787_1 failed. req is NULL!");
      return;
    }
    if (paramToServiceMsg.extraData.getInt("key_subcmd") != 1) {
      return;
    }
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  /* Error */
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 153	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 6
    //   6: iconst_1
    //   7: istore 4
    //   9: iconst_1
    //   10: istore 5
    //   12: iconst_0
    //   13: istore 9
    //   15: iconst_0
    //   16: istore 10
    //   18: iconst_0
    //   19: istore 8
    //   21: iload 6
    //   23: ifeq +13 -> 36
    //   26: aload_3
    //   27: ifnull +9 -> 36
    //   30: iconst_1
    //   31: istore 7
    //   33: goto +6 -> 39
    //   36: iconst_0
    //   37: istore 7
    //   39: iload 7
    //   41: ifeq +497 -> 538
    //   44: iload 5
    //   46: istore 4
    //   48: aload_1
    //   49: getfield 80	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   52: ldc 155
    //   54: iconst_0
    //   55: invokevirtual 159	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   58: istore 6
    //   60: iload 5
    //   62: istore 4
    //   64: aload_1
    //   65: getfield 80	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   68: ldc 161
    //   70: invokevirtual 165	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   73: invokestatic 170	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   76: invokevirtual 174	java/lang/Long:longValue	()J
    //   79: lstore 12
    //   81: iload 5
    //   83: istore 4
    //   85: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   88: ifeq +95 -> 183
    //   91: iload 5
    //   93: istore 4
    //   95: new 179	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   102: astore_2
    //   103: iload 5
    //   105: istore 4
    //   107: aload_2
    //   108: ldc 182
    //   110: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: iload 5
    //   116: istore 4
    //   118: aload_2
    //   119: iload 7
    //   121: invokevirtual 189	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: iload 5
    //   127: istore 4
    //   129: aload_2
    //   130: ldc 191
    //   132: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: iload 5
    //   138: istore 4
    //   140: aload_2
    //   141: lload 12
    //   143: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: iload 5
    //   149: istore 4
    //   151: aload_2
    //   152: ldc 196
    //   154: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: pop
    //   158: iload 5
    //   160: istore 4
    //   162: aload_2
    //   163: iload 6
    //   165: invokevirtual 189	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: iload 5
    //   171: istore 4
    //   173: ldc 103
    //   175: iconst_2
    //   176: aload_2
    //   177: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: iload 5
    //   185: istore 4
    //   187: new 204	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   190: dup
    //   191: invokespecial 205	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   194: astore_2
    //   195: iload 5
    //   197: istore 4
    //   199: aload_2
    //   200: aload_3
    //   201: checkcast 207	[B
    //   204: checkcast 207	[B
    //   207: invokevirtual 211	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   210: pop
    //   211: iload 5
    //   213: istore 4
    //   215: aload_2
    //   216: getfield 212	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   219: invokevirtual 40	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   222: istore 5
    //   224: iload 5
    //   226: istore 4
    //   228: aload_2
    //   229: getfield 215	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   232: invokevirtual 218	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   235: istore 11
    //   237: iload 5
    //   239: istore 4
    //   241: iload 9
    //   243: istore 6
    //   245: iload 11
    //   247: ifeq +295 -> 542
    //   250: aload_2
    //   251: getfield 215	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   254: invokevirtual 68	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   257: invokevirtual 222	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   260: astore_2
    //   261: new 224	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody
    //   264: dup
    //   265: invokespecial 225	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:<init>	()V
    //   268: astore_3
    //   269: aload_3
    //   270: aload_2
    //   271: invokevirtual 226	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   274: pop
    //   275: lload 12
    //   277: aload_3
    //   278: getfield 230	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   281: invokevirtual 234	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   284: lcmp
    //   285: ifne +110 -> 395
    //   288: aload_3
    //   289: getfield 237	tencent/im/oidb/cmd0x787/oidb_0x787$RspBody:rpt_msg_member_level_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   292: invokevirtual 49	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   295: astore_2
    //   296: new 239	java/util/HashMap
    //   299: dup
    //   300: aload_2
    //   301: invokeinterface 54 1 0
    //   306: invokespecial 242	java/util/HashMap:<init>	(I)V
    //   309: astore_3
    //   310: aload_0
    //   311: getfield 246	com/tencent/mobileqq/troop/handler/TroopMemberInfoHandler:appRuntime	Lcom/tencent/common/app/AppInterface;
    //   314: aload_1
    //   315: aload_3
    //   316: aload_2
    //   317: invokestatic 249	com/tencent/mobileqq/troop/api/config/TroopMemberInfoHandlerProcessorConfig:a	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/qphone/base/remote/ToServiceMsg;Ljava/util/Map;Ljava/util/List;)V
    //   320: aload_0
    //   321: getfield 246	com/tencent/mobileqq/troop/handler/TroopMemberInfoHandler:appRuntime	Lcom/tencent/common/app/AppInterface;
    //   324: ldc 251
    //   326: ldc 253
    //   328: invokevirtual 259	com/tencent/common/app/AppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   331: checkcast 251	com/tencent/mobileqq/troop/api/ITroopNameHelperService
    //   334: lload 12
    //   336: invokestatic 262	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   339: invokeinterface 266 2 0
    //   344: aload_0
    //   345: getstatic 269	com/tencent/mobileqq/troop/api/observer/TroopObserver:TYPE_BATCH_GET_TROOPCARD_DEAFULTNICK	I
    //   348: iload 7
    //   350: aload_3
    //   351: invokevirtual 101	com/tencent/mobileqq/troop/handler/TroopMemberInfoHandler:notifyUI	(IZLjava/lang/Object;)V
    //   354: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   357: ifeq +37 -> 394
    //   360: new 179	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   367: astore_1
    //   368: aload_1
    //   369: ldc_w 271
    //   372: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload_1
    //   377: invokestatic 276	java/lang/System:currentTimeMillis	()J
    //   380: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: ldc 103
    //   386: iconst_2
    //   387: aload_1
    //   388: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: return
    //   395: iconst_0
    //   396: istore 4
    //   398: iload 9
    //   400: istore 6
    //   402: goto +140 -> 542
    //   405: astore_1
    //   406: iconst_0
    //   407: istore 4
    //   409: goto +8 -> 417
    //   412: astore_1
    //   413: goto +83 -> 496
    //   416: astore_1
    //   417: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   420: ifeq +13 -> 433
    //   423: ldc 103
    //   425: iconst_2
    //   426: ldc_w 278
    //   429: aload_1
    //   430: invokestatic 281	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   433: iload 4
    //   435: istore 5
    //   437: iload 10
    //   439: istore 7
    //   441: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   444: ifeq +123 -> 567
    //   447: new 179	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   454: astore_1
    //   455: iload 8
    //   457: istore 6
    //   459: aload_1
    //   460: ldc_w 271
    //   463: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload_1
    //   468: invokestatic 276	java/lang/System:currentTimeMillis	()J
    //   471: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: ldc 103
    //   477: iconst_2
    //   478: aload_1
    //   479: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: iload 4
    //   487: istore 5
    //   489: iload 6
    //   491: istore 7
    //   493: goto +74 -> 567
    //   496: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   499: ifeq +37 -> 536
    //   502: new 179	java/lang/StringBuilder
    //   505: dup
    //   506: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   509: astore_2
    //   510: aload_2
    //   511: ldc_w 271
    //   514: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload_2
    //   519: invokestatic 276	java/lang/System:currentTimeMillis	()J
    //   522: invokevirtual 194	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   525: pop
    //   526: ldc 103
    //   528: iconst_2
    //   529: aload_2
    //   530: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: aload_1
    //   537: athrow
    //   538: iload 7
    //   540: istore 6
    //   542: iload 4
    //   544: istore 5
    //   546: iload 6
    //   548: istore 7
    //   550: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   553: ifeq +14 -> 567
    //   556: new 179	java/lang/StringBuilder
    //   559: dup
    //   560: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   563: astore_1
    //   564: goto -105 -> 459
    //   567: aload_0
    //   568: getstatic 269	com/tencent/mobileqq/troop/api/observer/TroopObserver:TYPE_BATCH_GET_TROOPCARD_DEAFULTNICK	I
    //   571: iload 7
    //   573: iload 5
    //   575: invokestatic 111	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   578: invokevirtual 101	com/tencent/mobileqq/troop/handler/TroopMemberInfoHandler:notifyUI	(IZLjava/lang/Object;)V
    //   581: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	TroopMemberInfoHandler
    //   0	582	1	paramToServiceMsg	ToServiceMsg
    //   0	582	2	paramFromServiceMsg	FromServiceMsg
    //   0	582	3	paramObject	Object
    //   7	536	4	i	int
    //   10	564	5	j	int
    //   4	543	6	bool1	boolean
    //   31	541	7	bool2	boolean
    //   19	437	8	bool3	boolean
    //   13	386	9	bool4	boolean
    //   16	422	10	bool5	boolean
    //   235	11	11	bool6	boolean
    //   79	256	12	l	long
    // Exception table:
    //   from	to	target	type
    //   250	354	405	java/lang/Exception
    //   48	60	412	finally
    //   64	81	412	finally
    //   85	91	412	finally
    //   95	103	412	finally
    //   107	114	412	finally
    //   118	125	412	finally
    //   129	136	412	finally
    //   140	147	412	finally
    //   151	158	412	finally
    //   162	169	412	finally
    //   173	183	412	finally
    //   187	195	412	finally
    //   199	211	412	finally
    //   215	224	412	finally
    //   228	237	412	finally
    //   250	354	412	finally
    //   417	433	412	finally
    //   48	60	416	java/lang/Exception
    //   64	81	416	java/lang/Exception
    //   85	91	416	java/lang/Exception
    //   95	103	416	java/lang/Exception
    //   107	114	416	java/lang/Exception
    //   118	125	416	java/lang/Exception
    //   129	136	416	java/lang/Exception
    //   140	147	416	java/lang/Exception
    //   151	158	416	java/lang/Exception
    //   162	169	416	java/lang/Exception
    //   173	183	416	java/lang/Exception
    //   187	195	416	java/lang/Exception
    //   199	211	416	java/lang/Exception
    //   215	224	416	java/lang/Exception
    //   228	237	416	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    try
    {
      Object localObject1 = new oidb_0x783.ReqBody();
      Object localObject2 = new oidb_0x783.UinListInfo();
      ((oidb_0x783.UinListInfo)localObject2).uint64_uin.set(Long.valueOf(paramString).longValue());
      ((oidb_0x783.ReqBody)localObject1).rpt_uinlist.add((MessageMicro)localObject2);
      ((oidb_0x783.ReqBody)localObject1).uint32_subcmd.set(3);
      ((oidb_0x783.ReqBody)localObject1).uint32_type.set(15);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1923);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(15);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x783.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("oidbSvc.0x783_15");
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).setTimeout(5000L);
      ((ToServiceMsg)localObject1).extraData.putString("memberUin", paramString);
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    catch (NumberFormatException paramString)
    {
      label135:
      break label135;
    }
    if (QLog.isColorLevel()) {
      QLog.e("TroopMemberInfoHandler", 2, "NumberFormatException");
    }
  }
  
  public boolean a(String paramString, ArrayList<String> paramArrayList, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1;
    short s;
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getTroopCardDefaultNickBatch uin=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(" size=");
        ((StringBuilder)localObject1).append(paramArrayList.size());
        ((StringBuilder)localObject1).append(" time=");
        ((StringBuilder)localObject1).append(System.currentTimeMillis());
        QLog.d("TroopMemberInfoHandler", 2, ((StringBuilder)localObject1).toString());
      }
      s = (short)paramArrayList.size();
      if (s > 500) {
        return false;
      }
    }
    try
    {
      long l = Long.parseLong(paramString);
      localObject1 = new oidb_0x787.ReqBody();
      ((oidb_0x787.ReqBody)localObject1).uint64_group_code.set(l);
      ((oidb_0x787.ReqBody)localObject1).uint64_begin_uin.set(0L);
      ((oidb_0x787.ReqBody)localObject1).uint64_data_time.set(0L);
      ((oidb_0x787.ReqBody)localObject1).uint32_rich_card_name_ver.set(1);
      Object localObject2 = paramArrayList.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        try
        {
          l = Long.parseLong((String)localObject3);
          ((oidb_0x787.ReqBody)localObject1).rpt_uin_list.add(Long.valueOf(l));
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getTroopCardDefaultNickBatch parseLong err uin=");
          localStringBuilder.append((String)localObject3);
          QLog.d("TroopMemberInfoHandler", 2, localStringBuilder.toString(), localException);
        }
      }
      localObject2 = new oidb_0x787.Filter();
      ((oidb_0x787.Filter)localObject2).uint32_member_level_info_uin.set(1);
      ((oidb_0x787.Filter)localObject2).uint32_member_level_info_name.set(1);
      ((oidb_0x787.Filter)localObject2).uint32_nick_name.set(1);
      ((oidb_0x787.ReqBody)localObject1).opt_filter.set((MessageMicro)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1927);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x787.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvc.0x787_1");
      if (paramBundle != null)
      {
        ((ToServiceMsg)localObject1).extraData.putAll(paramBundle);
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("extraNotifyParams:");
          ((StringBuilder)localObject3).append(paramBundle);
          QLog.d("TroopMemberInfoHandler.troop.revoked_msg_get_troop_mem_card", 2, ((StringBuilder)localObject3).toString());
        }
      }
      ((ToServiceMsg)localObject1).extraData.putString("troopUin", paramString);
      ((ToServiceMsg)localObject1).extraData.putStringArrayList("batchuin", paramArrayList);
      ((ToServiceMsg)localObject1).extraData.putShort("uincount", s);
      ((ToServiceMsg)localObject1).extraData.putBoolean("needRemark", paramBoolean);
      ((ToServiceMsg)localObject1).extraData.putInt("key_subcmd", 1);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject1);
      return true;
    }
    catch (Exception paramString) {}
    return false;
    return false;
  }
  
  protected String dv_()
  {
    return "TroopMemberInfoHandler";
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("oidbSvc.0x783_15");
      this.a.add("OidbSvc.0x787_1");
    }
    return this.a;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return TroopObserver.class;
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
          QLog.d("TroopMemberInfoHandler", 2, paramToServiceMsg.toString());
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
          QLog.d("TroopMemberInfoHandler", 2, paramToServiceMsg.toString());
        }
        return;
      }
      if ("oidbSvc.0x783_15".equals(paramFromServiceMsg.getServiceCmd()))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x787_1".equals(paramFromServiceMsg.getServiceCmd())) {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopMemberInfoHandler", 2, "onReceive,resp == null or req == null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopMemberInfoHandler
 * JD-Core Version:    0.7.0.1
 */