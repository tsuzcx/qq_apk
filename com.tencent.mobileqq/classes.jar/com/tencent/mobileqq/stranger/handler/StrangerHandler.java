package com.tencent.mobileqq.stranger.handler;

import android.content.SharedPreferences;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.stranger.observer.StrangerObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.ReqBody;
import tencent.im.oidb.cmd0x5d2.oidb_0x5d2.ReqGetList;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.DelResult;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.ReqBody;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class StrangerHandler
  extends BusinessHandler
{
  public StrangerHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public static StrangerHandler a(AppRuntime paramAppRuntime)
  {
    return (StrangerHandler)((AppInterface)paramAppRuntime).getBusinessHandler(StrangerHandler.class.getName());
  }
  
  private static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (paramFromServiceMsg.getResultCode() != 1000) {
        return null;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        QLog.e("StrangerHandler", 1, "parseSSOPkg fail.", paramFromServiceMsg);
      }
      if (paramToServiceMsg.uint32_result.get() == 0)
      {
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          return null;
        }
        return paramToServiceMsg;
      }
    }
    return null;
  }
  
  private void a(PBRepeatMessageField<oidb_0x5d4.DelResult> paramPBRepeatMessageField)
  {
    try
    {
      IRecentUserProxyService localIRecentUserProxyService = (IRecentUserProxyService)this.appRuntime.getRuntimeService(IRecentUserProxyService.class, "");
      if (localIRecentUserProxyService != null)
      {
        paramPBRepeatMessageField = paramPBRepeatMessageField.get().iterator();
        while (paramPBRepeatMessageField.hasNext())
        {
          Object localObject = (oidb_0x5d4.DelResult)paramPBRepeatMessageField.next();
          if (((oidb_0x5d4.DelResult)localObject).res.get() == 0)
          {
            long l = ((oidb_0x5d4.DelResult)localObject).uin.get();
            localObject = localIRecentUserProxyService.getRecentUserCache();
            RecentUser localRecentUser = ((RecentUserProxy)localObject).b(String.valueOf(l), 0);
            if (localRecentUser != null) {
              ((RecentUserProxy)localObject).a(localRecentUser);
            }
          }
        }
      }
      return;
    }
    catch (Exception paramPBRepeatMessageField)
    {
      QLog.e("StrangerHandler", 1, "notifyDeleteRecentUser fail.", paramPBRepeatMessageField);
    }
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: aload_3
    //   3: invokestatic 152	com/tencent/mobileqq/stranger/handler/StrangerHandler:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;
    //   6: astore_3
    //   7: aconst_null
    //   8: astore 10
    //   10: aconst_null
    //   11: astore_2
    //   12: aload_3
    //   13: ifnull +649 -> 662
    //   16: new 154	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody
    //   19: dup
    //   20: invokespecial 155	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:<init>	()V
    //   23: astore 7
    //   25: aload 7
    //   27: aload_3
    //   28: getfield 71	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   31: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   34: invokevirtual 161	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   37: invokevirtual 162	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   40: pop
    //   41: aload_1
    //   42: ldc 164
    //   44: invokevirtual 170	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   47: checkcast 172	java/lang/Integer
    //   50: invokevirtual 175	java/lang/Integer:intValue	()I
    //   53: istore 4
    //   55: aload 7
    //   57: getfield 179	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   60: getfield 184	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   63: invokevirtual 67	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   66: istore 5
    //   68: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +640 -> 711
    //   74: ldc 50
    //   76: iconst_2
    //   77: ldc 189
    //   79: iconst_2
    //   80: anewarray 191	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: iload 4
    //   87: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: iload 5
    //   95: invokestatic 194	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: invokestatic 198	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   102: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: goto +606 -> 711
    //   108: aload_0
    //   109: getfield 15	com/tencent/mobileqq/stranger/handler/StrangerHandler:appRuntime	Lcom/tencent/common/app/AppInterface;
    //   112: invokevirtual 206	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   115: invokevirtual 212	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   118: astore_1
    //   119: aload_1
    //   120: astore_2
    //   121: aload_1
    //   122: ldc 214
    //   124: invokevirtual 220	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   127: astore_3
    //   128: aload_3
    //   129: astore 8
    //   131: aload_3
    //   132: ifnonnull +14 -> 146
    //   135: aload_1
    //   136: astore_2
    //   137: new 222	java/util/ArrayList
    //   140: dup
    //   141: invokespecial 223	java/util/ArrayList:<init>	()V
    //   144: astore 8
    //   146: aload_1
    //   147: astore_2
    //   148: aload 7
    //   150: getfield 179	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   153: getfield 227	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   156: invokevirtual 92	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   159: invokeinterface 98 1 0
    //   164: astore 11
    //   166: aconst_null
    //   167: astore_3
    //   168: aload_1
    //   169: astore_2
    //   170: aload 11
    //   172: invokeinterface 104 1 0
    //   177: ifeq +256 -> 433
    //   180: aload_1
    //   181: astore_2
    //   182: aload 11
    //   184: invokeinterface 108 1 0
    //   189: checkcast 229	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList
    //   192: astore 9
    //   194: aload_1
    //   195: astore_2
    //   196: aload 9
    //   198: getfield 230	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   201: invokevirtual 126	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   204: invokestatic 136	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   207: astore 7
    //   209: aload_1
    //   210: astore_2
    //   211: aload 9
    //   213: getfield 233	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   216: invokevirtual 76	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   219: invokevirtual 236	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   222: astore 12
    //   224: aload_1
    //   225: astore_2
    //   226: aload_1
    //   227: ldc 214
    //   229: aload 7
    //   231: invokevirtual 240	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   234: checkcast 214	com/tencent/mobileqq/stranger/data/Stranger
    //   237: astore 9
    //   239: aload 9
    //   241: ifnonnull +46 -> 287
    //   244: aload_1
    //   245: astore_2
    //   246: new 214	com/tencent/mobileqq/stranger/data/Stranger
    //   249: dup
    //   250: invokespecial 241	com/tencent/mobileqq/stranger/data/Stranger:<init>	()V
    //   253: astore 9
    //   255: aload_1
    //   256: astore_2
    //   257: aload 9
    //   259: aload 7
    //   261: putfield 244	com/tencent/mobileqq/stranger/data/Stranger:uin	Ljava/lang/String;
    //   264: aload_1
    //   265: astore_2
    //   266: aload 9
    //   268: aload 12
    //   270: putfield 247	com/tencent/mobileqq/stranger/data/Stranger:name	Ljava/lang/String;
    //   273: aload_1
    //   274: astore_2
    //   275: aload_1
    //   276: aload 9
    //   278: invokevirtual 251	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   281: aload_3
    //   282: astore 7
    //   284: goto +91 -> 375
    //   287: aload_1
    //   288: astore_2
    //   289: aload 9
    //   291: aload 12
    //   293: putfield 247	com/tencent/mobileqq/stranger/data/Stranger:name	Ljava/lang/String;
    //   296: aload_1
    //   297: astore_2
    //   298: aload_1
    //   299: aload 9
    //   301: invokevirtual 255	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   304: pop
    //   305: aload_1
    //   306: astore_2
    //   307: aload 8
    //   309: invokeinterface 98 1 0
    //   314: astore 12
    //   316: aload_3
    //   317: astore 7
    //   319: aload_1
    //   320: astore_2
    //   321: aload 12
    //   323: invokeinterface 104 1 0
    //   328: ifeq +35 -> 363
    //   331: aload_1
    //   332: astore_2
    //   333: aload 12
    //   335: invokeinterface 108 1 0
    //   340: checkcast 214	com/tencent/mobileqq/stranger/data/Stranger
    //   343: astore 7
    //   345: aload_1
    //   346: astore_2
    //   347: aload 7
    //   349: getfield 244	com/tencent/mobileqq/stranger/data/Stranger:uin	Ljava/lang/String;
    //   352: aload 9
    //   354: getfield 244	com/tencent/mobileqq/stranger/data/Stranger:uin	Ljava/lang/String;
    //   357: invokestatic 261	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   360: ifeq -44 -> 316
    //   363: aload_1
    //   364: astore_2
    //   365: aload 8
    //   367: aload 7
    //   369: invokeinterface 265 2 0
    //   374: pop
    //   375: aload 7
    //   377: astore_3
    //   378: aload_1
    //   379: astore_2
    //   380: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq -215 -> 168
    //   386: aload_1
    //   387: astore_2
    //   388: new 267	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   395: astore_3
    //   396: aload_1
    //   397: astore_2
    //   398: aload_3
    //   399: ldc_w 270
    //   402: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload_1
    //   407: astore_2
    //   408: aload_3
    //   409: aload 9
    //   411: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload_1
    //   416: astore_2
    //   417: ldc 50
    //   419: iconst_2
    //   420: aload_3
    //   421: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: aload 7
    //   429: astore_3
    //   430: goto -262 -> 168
    //   433: aload_1
    //   434: astore_2
    //   435: aload 8
    //   437: invokeinterface 98 1 0
    //   442: astore_3
    //   443: aload_1
    //   444: astore_2
    //   445: aload_3
    //   446: invokeinterface 104 1 0
    //   451: ifeq +81 -> 532
    //   454: aload_1
    //   455: astore_2
    //   456: aload_3
    //   457: invokeinterface 108 1 0
    //   462: checkcast 214	com/tencent/mobileqq/stranger/data/Stranger
    //   465: astore 7
    //   467: aload_1
    //   468: astore_2
    //   469: aload_1
    //   470: aload 7
    //   472: invokevirtual 282	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   475: pop
    //   476: aload_1
    //   477: astore_2
    //   478: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   481: ifeq -38 -> 443
    //   484: aload_1
    //   485: astore_2
    //   486: new 267	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   493: astore 8
    //   495: aload_1
    //   496: astore_2
    //   497: aload 8
    //   499: ldc_w 284
    //   502: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload_1
    //   507: astore_2
    //   508: aload 8
    //   510: aload 7
    //   512: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload_1
    //   517: astore_2
    //   518: ldc 50
    //   520: iconst_2
    //   521: aload 8
    //   523: invokevirtual 280	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: goto -86 -> 443
    //   532: aload_1
    //   533: astore_2
    //   534: aload_0
    //   535: getfield 15	com/tencent/mobileqq/stranger/handler/StrangerHandler:appRuntime	Lcom/tencent/common/app/AppInterface;
    //   538: invokevirtual 288	com/tencent/common/app/AppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   541: invokeinterface 294 1 0
    //   546: astore_3
    //   547: aload_1
    //   548: astore_2
    //   549: aload_3
    //   550: ldc_w 296
    //   553: iload 5
    //   555: invokeinterface 302 3 0
    //   560: pop
    //   561: aload_1
    //   562: astore_2
    //   563: aload_3
    //   564: invokeinterface 305 1 0
    //   569: pop
    //   570: aload_1
    //   571: astore_2
    //   572: aload_1
    //   573: ldc 214
    //   575: invokevirtual 220	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   578: astore_3
    //   579: aload_3
    //   580: astore_2
    //   581: aload_3
    //   582: ifnonnull +15 -> 597
    //   585: aload_1
    //   586: astore_2
    //   587: new 222	java/util/ArrayList
    //   590: dup
    //   591: invokespecial 223	java/util/ArrayList:<init>	()V
    //   594: astore_3
    //   595: aload_3
    //   596: astore_2
    //   597: aload_1
    //   598: astore_3
    //   599: aload_2
    //   600: astore_1
    //   601: aload_3
    //   602: ifnull +7 -> 609
    //   605: aload_3
    //   606: invokevirtual 308	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   609: iconst_1
    //   610: istore 6
    //   612: goto +56 -> 668
    //   615: astore_3
    //   616: goto +12 -> 628
    //   619: astore_1
    //   620: aconst_null
    //   621: astore_2
    //   622: goto +30 -> 652
    //   625: astore_3
    //   626: aconst_null
    //   627: astore_1
    //   628: aload_1
    //   629: astore_2
    //   630: ldc 50
    //   632: iconst_1
    //   633: ldc_w 310
    //   636: aload_3
    //   637: invokestatic 58	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   640: aload_1
    //   641: ifnull +21 -> 662
    //   644: aload_1
    //   645: invokevirtual 308	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   648: goto +14 -> 662
    //   651: astore_1
    //   652: aload_2
    //   653: ifnull +7 -> 660
    //   656: aload_2
    //   657: invokevirtual 308	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   660: aload_1
    //   661: athrow
    //   662: iconst_0
    //   663: istore 6
    //   665: aload 10
    //   667: astore_1
    //   668: invokestatic 187	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   671: ifeq +31 -> 702
    //   674: ldc 50
    //   676: iconst_2
    //   677: ldc_w 312
    //   680: iconst_2
    //   681: anewarray 191	java/lang/Object
    //   684: dup
    //   685: iconst_0
    //   686: iload 6
    //   688: invokestatic 317	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   691: aastore
    //   692: dup
    //   693: iconst_1
    //   694: aload_1
    //   695: aastore
    //   696: invokestatic 198	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   699: invokestatic 202	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: aload_0
    //   703: iconst_2
    //   704: iload 6
    //   706: aload_1
    //   707: invokevirtual 321	com/tencent/mobileqq/stranger/handler/StrangerHandler:notifyUI	(IZLjava/lang/Object;)V
    //   710: return
    //   711: iload 4
    //   713: iload 5
    //   715: if_icmpne -607 -> 108
    //   718: aconst_null
    //   719: astore_3
    //   720: aload_2
    //   721: astore_1
    //   722: goto -121 -> 601
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	725	0	this	StrangerHandler
    //   0	725	1	paramToServiceMsg	ToServiceMsg
    //   0	725	2	paramFromServiceMsg	FromServiceMsg
    //   0	725	3	paramObject	Object
    //   53	663	4	i	int
    //   66	650	5	j	int
    //   610	95	6	bool	boolean
    //   23	488	7	localObject1	Object
    //   129	393	8	localObject2	Object
    //   192	218	9	localObject3	Object
    //   8	658	10	localObject4	Object
    //   164	19	11	localIterator	Iterator
    //   222	112	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   121	128	615	java/lang/Exception
    //   137	146	615	java/lang/Exception
    //   148	166	615	java/lang/Exception
    //   170	180	615	java/lang/Exception
    //   182	194	615	java/lang/Exception
    //   196	209	615	java/lang/Exception
    //   211	224	615	java/lang/Exception
    //   226	239	615	java/lang/Exception
    //   246	255	615	java/lang/Exception
    //   257	264	615	java/lang/Exception
    //   266	273	615	java/lang/Exception
    //   275	281	615	java/lang/Exception
    //   289	296	615	java/lang/Exception
    //   298	305	615	java/lang/Exception
    //   307	316	615	java/lang/Exception
    //   321	331	615	java/lang/Exception
    //   333	345	615	java/lang/Exception
    //   347	363	615	java/lang/Exception
    //   365	375	615	java/lang/Exception
    //   380	386	615	java/lang/Exception
    //   388	396	615	java/lang/Exception
    //   398	406	615	java/lang/Exception
    //   408	415	615	java/lang/Exception
    //   417	427	615	java/lang/Exception
    //   435	443	615	java/lang/Exception
    //   445	454	615	java/lang/Exception
    //   456	467	615	java/lang/Exception
    //   469	476	615	java/lang/Exception
    //   478	484	615	java/lang/Exception
    //   486	495	615	java/lang/Exception
    //   497	506	615	java/lang/Exception
    //   508	516	615	java/lang/Exception
    //   518	529	615	java/lang/Exception
    //   534	547	615	java/lang/Exception
    //   549	561	615	java/lang/Exception
    //   563	570	615	java/lang/Exception
    //   572	579	615	java/lang/Exception
    //   587	595	615	java/lang/Exception
    //   16	105	619	finally
    //   108	119	619	finally
    //   16	105	625	java/lang/Exception
    //   108	119	625	java/lang/Exception
    //   121	128	651	finally
    //   137	146	651	finally
    //   148	166	651	finally
    //   170	180	651	finally
    //   182	194	651	finally
    //   196	209	651	finally
    //   211	224	651	finally
    //   226	239	651	finally
    //   246	255	651	finally
    //   257	264	651	finally
    //   266	273	651	finally
    //   275	281	651	finally
    //   289	296	651	finally
    //   298	305	651	finally
    //   307	316	651	finally
    //   321	331	651	finally
    //   333	345	651	finally
    //   347	363	651	finally
    //   365	375	651	finally
    //   380	386	651	finally
    //   388	396	651	finally
    //   398	406	651	finally
    //   408	415	651	finally
    //   417	427	651	finally
    //   435	443	651	finally
    //   445	454	651	finally
    //   456	467	651	finally
    //   469	476	651	finally
    //   478	484	651	finally
    //   486	495	651	finally
    //   497	506	651	finally
    //   508	516	651	finally
    //   518	529	651	finally
    //   534	547	651	finally
    //   549	561	651	finally
    //   563	570	651	finally
    //   572	579	651	finally
    //   587	595	651	finally
    //   630	640	651	finally
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    paramFromServiceMsg = null;
    boolean bool;
    if (paramToServiceMsg != null)
    {
      try
      {
        paramObject = new oidb_0x5d4.RspBody();
        paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        a(paramObject.result);
        try
        {
          paramToServiceMsg = paramObject.result;
          bool = true;
        }
        catch (Exception paramToServiceMsg)
        {
          bool = true;
        }
        QLog.e("StrangerHandler", 1, "handleDeleteStranger fail.", paramToServiceMsg);
      }
      catch (Exception paramToServiceMsg)
      {
        bool = false;
      }
      paramToServiceMsg = paramFromServiceMsg;
    }
    else
    {
      bool = false;
      paramToServiceMsg = paramFromServiceMsg;
    }
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, String.format("handleDeleteStranger success=%s result=%s", new Object[] { Boolean.valueOf(bool), paramToServiceMsg }));
    }
    notifyUI(3, bool, paramToServiceMsg);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, "getLocalList");
    }
    ThreadManager.executeOnSubThread(new StrangerHandler.1(this));
  }
  
  public void a(List<Long> paramList)
  {
    if (QLog.isColorLevel())
    {
      if (paramList != null) {
        localObject = Arrays.toString(paramList.toArray());
      } else {
        localObject = null;
      }
      QLog.d("StrangerHandler", 2, String.format("deleteStrangers uinList=%s", new Object[] { localObject }));
    }
    Object localObject = new oidb_0x5d4.ReqBody();
    ((oidb_0x5d4.ReqBody)localObject).uin_list.set(paramList);
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(1492);
    paramList.uint32_service_type.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d4.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5d4_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, String.format("getRemoteList force=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    int i = this.appRuntime.getPreferences().getInt("strange_oidb_get_list_seq_id", 0);
    if (paramBoolean) {
      i = 0;
    }
    Object localObject = new oidb_0x5d2.ReqBody();
    ((oidb_0x5d2.ReqBody)localObject).sub_cmd.set(1);
    ((oidb_0x5d2.ReqBody)localObject).req_get_list.setHasFlag(true);
    ((oidb_0x5d2.ReqBody)localObject).req_get_list.seq.set(i);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1490);
    localOIDBSSOPkg.uint32_service_type.set(0);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d2.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x5d2_0");
    ((ToServiceMsg)localObject).addAttribute("extra_sub_cmd", Integer.valueOf(1));
    ((ToServiceMsg)localObject).addAttribute("extra_seq_id", Integer.valueOf(i));
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("OidbSvc.0x5d2_0");
      this.allowCmdSet.add("OidbSvc.0x5d4_0");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return StrangerObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("StrangerHandler", 2, String.format("onReceive cmd=%s", new Object[] { str }));
    }
    if ("OidbSvc.0x5d2_0".equals(str))
    {
      if (((Integer)paramToServiceMsg.getAttribute("extra_sub_cmd", Integer.valueOf(1))).intValue() == 1) {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    else if ("OidbSvc.0x5d4_0".equals(str)) {
      b(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.stranger.handler.StrangerHandler
 * JD-Core Version:    0.7.0.1
 */