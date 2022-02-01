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
            RecentUser localRecentUser = ((RecentUserProxy)localObject).c(String.valueOf(l), 0);
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
    //   3: invokestatic 116	com/tencent/mobileqq/stranger/handler/StrangerHandler:c	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/qphone/base/remote/FromServiceMsg;Ljava/lang/Object;)Ltencent/im/oidb/oidb_sso$OIDBSSOPkg;
    //   6: astore_3
    //   7: aconst_null
    //   8: astore 10
    //   10: aconst_null
    //   11: astore_2
    //   12: aload_3
    //   13: ifnull +648 -> 661
    //   16: new 118	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody
    //   19: dup
    //   20: invokespecial 121	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:<init>	()V
    //   23: astore 7
    //   25: aload 7
    //   27: aload_3
    //   28: getfield 127	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   31: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   34: invokevirtual 138	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   37: invokevirtual 142	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   40: pop
    //   41: aload_1
    //   42: ldc 144
    //   44: invokevirtual 150	com/tencent/qphone/base/remote/ToServiceMsg:getAttribute	(Ljava/lang/String;)Ljava/lang/Object;
    //   47: checkcast 152	java/lang/Integer
    //   50: invokevirtual 155	java/lang/Integer:intValue	()I
    //   53: istore 4
    //   55: aload 7
    //   57: getfield 159	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   60: getfield 165	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   63: invokevirtual 168	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   66: istore 5
    //   68: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +639 -> 710
    //   74: ldc 102
    //   76: iconst_2
    //   77: ldc 173
    //   79: iconst_2
    //   80: anewarray 175	java/lang/Object
    //   83: dup
    //   84: iconst_0
    //   85: iload 4
    //   87: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: iload 5
    //   95: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: invokestatic 182	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   102: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: goto +605 -> 710
    //   108: aload_0
    //   109: getfield 15	com/tencent/mobileqq/stranger/handler/StrangerHandler:appRuntime	Lcom/tencent/common/app/AppInterface;
    //   112: invokevirtual 190	com/tencent/common/app/AppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   115: invokevirtual 196	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   118: astore_1
    //   119: aload_1
    //   120: astore_2
    //   121: aload_1
    //   122: ldc 198
    //   124: invokevirtual 204	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   127: astore_3
    //   128: aload_3
    //   129: astore 8
    //   131: aload_3
    //   132: ifnonnull +14 -> 146
    //   135: aload_1
    //   136: astore_2
    //   137: new 206	java/util/ArrayList
    //   140: dup
    //   141: invokespecial 207	java/util/ArrayList:<init>	()V
    //   144: astore 8
    //   146: aload_1
    //   147: astore_2
    //   148: aload 7
    //   150: getfield 159	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspBody:rsp_get_list	Ltencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList;
    //   153: getfield 211	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$RspGetList:list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   156: invokevirtual 45	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   159: invokeinterface 51 1 0
    //   164: astore 11
    //   166: aconst_null
    //   167: astore_3
    //   168: aload_1
    //   169: astore_2
    //   170: aload 11
    //   172: invokeinterface 57 1 0
    //   177: ifeq +255 -> 432
    //   180: aload_1
    //   181: astore_2
    //   182: aload 11
    //   184: invokeinterface 61 1 0
    //   189: checkcast 213	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList
    //   192: astore 9
    //   194: aload_1
    //   195: astore_2
    //   196: aload 9
    //   198: getfield 214	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   201: invokevirtual 81	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   204: invokestatic 91	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   207: astore 7
    //   209: aload_1
    //   210: astore_2
    //   211: aload 9
    //   213: getfield 217	tencent/im/oidb/cmd0x5d2/oidb_0x5d2$FriendList:nick	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   216: invokevirtual 132	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   219: invokevirtual 220	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   222: astore 12
    //   224: aload_1
    //   225: astore_2
    //   226: aload_1
    //   227: ldc 198
    //   229: aload 7
    //   231: invokevirtual 224	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   234: checkcast 198	com/tencent/mobileqq/stranger/data/Stranger
    //   237: astore 9
    //   239: aload 9
    //   241: ifnonnull +46 -> 287
    //   244: aload_1
    //   245: astore_2
    //   246: new 198	com/tencent/mobileqq/stranger/data/Stranger
    //   249: dup
    //   250: invokespecial 225	com/tencent/mobileqq/stranger/data/Stranger:<init>	()V
    //   253: astore 9
    //   255: aload_1
    //   256: astore_2
    //   257: aload 9
    //   259: aload 7
    //   261: putfield 228	com/tencent/mobileqq/stranger/data/Stranger:uin	Ljava/lang/String;
    //   264: aload_1
    //   265: astore_2
    //   266: aload 9
    //   268: aload 12
    //   270: putfield 231	com/tencent/mobileqq/stranger/data/Stranger:name	Ljava/lang/String;
    //   273: aload_1
    //   274: astore_2
    //   275: aload_1
    //   276: aload 9
    //   278: invokevirtual 235	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   281: aload_3
    //   282: astore 7
    //   284: goto +91 -> 375
    //   287: aload_1
    //   288: astore_2
    //   289: aload 9
    //   291: aload 12
    //   293: putfield 231	com/tencent/mobileqq/stranger/data/Stranger:name	Ljava/lang/String;
    //   296: aload_1
    //   297: astore_2
    //   298: aload_1
    //   299: aload 9
    //   301: invokevirtual 239	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   304: pop
    //   305: aload_1
    //   306: astore_2
    //   307: aload 8
    //   309: invokeinterface 51 1 0
    //   314: astore 12
    //   316: aload_3
    //   317: astore 7
    //   319: aload_1
    //   320: astore_2
    //   321: aload 12
    //   323: invokeinterface 57 1 0
    //   328: ifeq +35 -> 363
    //   331: aload_1
    //   332: astore_2
    //   333: aload 12
    //   335: invokeinterface 61 1 0
    //   340: checkcast 198	com/tencent/mobileqq/stranger/data/Stranger
    //   343: astore 7
    //   345: aload_1
    //   346: astore_2
    //   347: aload 7
    //   349: getfield 228	com/tencent/mobileqq/stranger/data/Stranger:uin	Ljava/lang/String;
    //   352: aload 9
    //   354: getfield 228	com/tencent/mobileqq/stranger/data/Stranger:uin	Ljava/lang/String;
    //   357: invokestatic 245	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   360: ifeq -44 -> 316
    //   363: aload_1
    //   364: astore_2
    //   365: aload 8
    //   367: aload 7
    //   369: invokeinterface 249 2 0
    //   374: pop
    //   375: aload 7
    //   377: astore_3
    //   378: aload_1
    //   379: astore_2
    //   380: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq -215 -> 168
    //   386: aload_1
    //   387: astore_2
    //   388: new 251	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   395: astore_3
    //   396: aload_1
    //   397: astore_2
    //   398: aload_3
    //   399: ldc 254
    //   401: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_1
    //   406: astore_2
    //   407: aload_3
    //   408: aload 9
    //   410: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: aload_1
    //   415: astore_2
    //   416: ldc 102
    //   418: iconst_2
    //   419: aload_3
    //   420: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: aload 7
    //   428: astore_3
    //   429: goto -261 -> 168
    //   432: aload_1
    //   433: astore_2
    //   434: aload 8
    //   436: invokeinterface 51 1 0
    //   441: astore_3
    //   442: aload_1
    //   443: astore_2
    //   444: aload_3
    //   445: invokeinterface 57 1 0
    //   450: ifeq +81 -> 531
    //   453: aload_1
    //   454: astore_2
    //   455: aload_3
    //   456: invokeinterface 61 1 0
    //   461: checkcast 198	com/tencent/mobileqq/stranger/data/Stranger
    //   464: astore 7
    //   466: aload_1
    //   467: astore_2
    //   468: aload_1
    //   469: aload 7
    //   471: invokevirtual 266	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   474: pop
    //   475: aload_1
    //   476: astore_2
    //   477: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   480: ifeq -38 -> 442
    //   483: aload_1
    //   484: astore_2
    //   485: new 251	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 252	java/lang/StringBuilder:<init>	()V
    //   492: astore 8
    //   494: aload_1
    //   495: astore_2
    //   496: aload 8
    //   498: ldc_w 268
    //   501: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload_1
    //   506: astore_2
    //   507: aload 8
    //   509: aload 7
    //   511: invokevirtual 261	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   514: pop
    //   515: aload_1
    //   516: astore_2
    //   517: ldc 102
    //   519: iconst_2
    //   520: aload 8
    //   522: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: goto -86 -> 442
    //   531: aload_1
    //   532: astore_2
    //   533: aload_0
    //   534: getfield 15	com/tencent/mobileqq/stranger/handler/StrangerHandler:appRuntime	Lcom/tencent/common/app/AppInterface;
    //   537: invokevirtual 272	com/tencent/common/app/AppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   540: invokeinterface 278 1 0
    //   545: astore_3
    //   546: aload_1
    //   547: astore_2
    //   548: aload_3
    //   549: ldc_w 280
    //   552: iload 5
    //   554: invokeinterface 286 3 0
    //   559: pop
    //   560: aload_1
    //   561: astore_2
    //   562: aload_3
    //   563: invokeinterface 289 1 0
    //   568: pop
    //   569: aload_1
    //   570: astore_2
    //   571: aload_1
    //   572: ldc 198
    //   574: invokevirtual 204	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;)Ljava/util/List;
    //   577: astore_3
    //   578: aload_3
    //   579: astore_2
    //   580: aload_3
    //   581: ifnonnull +15 -> 596
    //   584: aload_1
    //   585: astore_2
    //   586: new 206	java/util/ArrayList
    //   589: dup
    //   590: invokespecial 207	java/util/ArrayList:<init>	()V
    //   593: astore_3
    //   594: aload_3
    //   595: astore_2
    //   596: aload_1
    //   597: astore_3
    //   598: aload_2
    //   599: astore_1
    //   600: aload_3
    //   601: ifnull +7 -> 608
    //   604: aload_3
    //   605: invokevirtual 292	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   608: iconst_1
    //   609: istore 6
    //   611: goto +56 -> 667
    //   614: astore_3
    //   615: goto +12 -> 627
    //   618: astore_1
    //   619: aconst_null
    //   620: astore_2
    //   621: goto +30 -> 651
    //   624: astore_3
    //   625: aconst_null
    //   626: astore_1
    //   627: aload_1
    //   628: astore_2
    //   629: ldc 102
    //   631: iconst_1
    //   632: ldc_w 294
    //   635: aload_3
    //   636: invokestatic 110	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   639: aload_1
    //   640: ifnull +21 -> 661
    //   643: aload_1
    //   644: invokevirtual 292	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   647: goto +14 -> 661
    //   650: astore_1
    //   651: aload_2
    //   652: ifnull +7 -> 659
    //   655: aload_2
    //   656: invokevirtual 292	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   659: aload_1
    //   660: athrow
    //   661: iconst_0
    //   662: istore 6
    //   664: aload 10
    //   666: astore_1
    //   667: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   670: ifeq +31 -> 701
    //   673: ldc 102
    //   675: iconst_2
    //   676: ldc_w 296
    //   679: iconst_2
    //   680: anewarray 175	java/lang/Object
    //   683: dup
    //   684: iconst_0
    //   685: iload 6
    //   687: invokestatic 301	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   690: aastore
    //   691: dup
    //   692: iconst_1
    //   693: aload_1
    //   694: aastore
    //   695: invokestatic 182	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   698: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   701: aload_0
    //   702: iconst_2
    //   703: iload 6
    //   705: aload_1
    //   706: invokevirtual 305	com/tencent/mobileqq/stranger/handler/StrangerHandler:notifyUI	(IZLjava/lang/Object;)V
    //   709: return
    //   710: iload 4
    //   712: iload 5
    //   714: if_icmpne -606 -> 108
    //   717: aconst_null
    //   718: astore_3
    //   719: aload_2
    //   720: astore_1
    //   721: goto -121 -> 600
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	724	0	this	StrangerHandler
    //   0	724	1	paramToServiceMsg	ToServiceMsg
    //   0	724	2	paramFromServiceMsg	FromServiceMsg
    //   0	724	3	paramObject	Object
    //   53	662	4	i	int
    //   66	649	5	j	int
    //   609	95	6	bool	boolean
    //   23	487	7	localObject1	Object
    //   129	392	8	localObject2	Object
    //   192	217	9	localObject3	Object
    //   8	657	10	localObject4	Object
    //   164	19	11	localIterator	Iterator
    //   222	112	12	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   121	128	614	java/lang/Exception
    //   137	146	614	java/lang/Exception
    //   148	166	614	java/lang/Exception
    //   170	180	614	java/lang/Exception
    //   182	194	614	java/lang/Exception
    //   196	209	614	java/lang/Exception
    //   211	224	614	java/lang/Exception
    //   226	239	614	java/lang/Exception
    //   246	255	614	java/lang/Exception
    //   257	264	614	java/lang/Exception
    //   266	273	614	java/lang/Exception
    //   275	281	614	java/lang/Exception
    //   289	296	614	java/lang/Exception
    //   298	305	614	java/lang/Exception
    //   307	316	614	java/lang/Exception
    //   321	331	614	java/lang/Exception
    //   333	345	614	java/lang/Exception
    //   347	363	614	java/lang/Exception
    //   365	375	614	java/lang/Exception
    //   380	386	614	java/lang/Exception
    //   388	396	614	java/lang/Exception
    //   398	405	614	java/lang/Exception
    //   407	414	614	java/lang/Exception
    //   416	426	614	java/lang/Exception
    //   434	442	614	java/lang/Exception
    //   444	453	614	java/lang/Exception
    //   455	466	614	java/lang/Exception
    //   468	475	614	java/lang/Exception
    //   477	483	614	java/lang/Exception
    //   485	494	614	java/lang/Exception
    //   496	505	614	java/lang/Exception
    //   507	515	614	java/lang/Exception
    //   517	528	614	java/lang/Exception
    //   533	546	614	java/lang/Exception
    //   548	560	614	java/lang/Exception
    //   562	569	614	java/lang/Exception
    //   571	578	614	java/lang/Exception
    //   586	594	614	java/lang/Exception
    //   16	105	618	finally
    //   108	119	618	finally
    //   16	105	624	java/lang/Exception
    //   108	119	624	java/lang/Exception
    //   121	128	650	finally
    //   137	146	650	finally
    //   148	166	650	finally
    //   170	180	650	finally
    //   182	194	650	finally
    //   196	209	650	finally
    //   211	224	650	finally
    //   226	239	650	finally
    //   246	255	650	finally
    //   257	264	650	finally
    //   266	273	650	finally
    //   275	281	650	finally
    //   289	296	650	finally
    //   298	305	650	finally
    //   307	316	650	finally
    //   321	331	650	finally
    //   333	345	650	finally
    //   347	363	650	finally
    //   365	375	650	finally
    //   380	386	650	finally
    //   388	396	650	finally
    //   398	405	650	finally
    //   407	414	650	finally
    //   416	426	650	finally
    //   434	442	650	finally
    //   444	453	650	finally
    //   455	466	650	finally
    //   468	475	650	finally
    //   477	483	650	finally
    //   485	494	650	finally
    //   496	505	650	finally
    //   507	515	650	finally
    //   517	528	650	finally
    //   533	546	650	finally
    //   548	560	650	finally
    //   562	569	650	finally
    //   571	578	650	finally
    //   586	594	650	finally
    //   629	639	650	finally
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = c(paramToServiceMsg, paramFromServiceMsg, paramObject);
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
  
  private static oidb_sso.OIDBSSOPkg c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.stranger.handler.StrangerHandler
 * JD-Core Version:    0.7.0.1
 */