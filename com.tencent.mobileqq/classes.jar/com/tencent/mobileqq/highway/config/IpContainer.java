package com.tencent.mobileqq.highway.config;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.iplearning.IpLearning;
import com.tencent.mobileqq.highway.iplearning.IpLearningImpl;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.EndPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class IpContainer
{
  private static final String SUB_TAG = "IpContainer";
  public static ConcurrentHashMap<String, IpLearning> mIpLearners = new ConcurrentHashMap();
  private IpContainer.PersistentConfig mCfg;
  private String mFileName;
  
  public IpContainer(Context paramContext, String paramString, AppRuntime paramAppRuntime)
  {
    this.mFileName = paramString;
    this.mCfg = readDiskOrCreateNew(paramContext, paramString);
  }
  
  private boolean findNRemove(ArrayList<EndPoint> paramArrayList, String paramString)
  {
    boolean bool2 = false;
    if (paramArrayList == null) {
      return false;
    }
    EndPoint localEndPoint = null;
    int i = 0;
    boolean bool1;
    label115:
    label121:
    for (;;)
    {
      bool1 = bool2;
      try
      {
        if (i < paramArrayList.size())
        {
          localEndPoint = (EndPoint)paramArrayList.get(i);
          if (!localEndPoint.host.equalsIgnoreCase(paramString)) {
            break label121;
          }
          if (paramArrayList.size() <= i) {
            break label115;
          }
          paramArrayList.remove(i);
        }
      }
      finally
      {
        for (;;)
        {
          for (;;)
          {
            throw paramArrayList;
          }
          bool1 = true;
        }
        i += 1;
      }
      if ((bool1) && (localEndPoint.protoType == 1))
      {
        localEndPoint.protoType = 2;
        paramArrayList.add(paramArrayList.size(), localEndPoint);
      }
      return bool1;
    }
  }
  
  private IpLearning getOrCreateIpLearnerByKey(String paramString)
  {
    if (IpLearningImpl.sEnableIpLearning == 1)
    {
      IpLearningImpl localIpLearningImpl = new IpLearningImpl();
      paramString = (IpLearning)mIpLearners.putIfAbsent(paramString, localIpLearningImpl);
      if (paramString != null) {
        return paramString;
      }
      return localIpLearningImpl;
    }
    return null;
  }
  
  private void insertOrReplace(Context paramContext, ConcurrentHashMap<String, ArrayList<EndPoint>> paramConcurrentHashMap, ArrayList<EndPoint> paramArrayList, boolean paramBoolean)
  {
    paramContext = BdhUtils.getCurNetKey(paramContext).iterator();
    while (paramContext.hasNext())
    {
      String str = (String)paramContext.next();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      Object localObject1;
      if (paramArrayList != null)
      {
        localObject1 = paramArrayList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (EndPoint)((Iterator)localObject1).next();
          EndPoint localEndPoint = new EndPoint(((EndPoint)localObject2).host, ((EndPoint)localObject2).port, ((EndPoint)localObject2).type);
          localEndPoint.ipIndex = i;
          localEndPoint.keyOfAPN = str;
          localEndPoint.isSameIsp = ((EndPoint)localObject2).isSameIsp;
          localEndPoint.timestamp = ((EndPoint)localObject2).timestamp;
          localArrayList.add(localEndPoint);
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("IpContainer, insert() key= ");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("   value= ");
          ((StringBuilder)localObject2).append(localEndPoint.toString());
          BdhLogUtil.LogEvent("C", ((StringBuilder)localObject2).toString());
          i += 1;
        }
      }
      if (paramBoolean)
      {
        localObject1 = getOrCreateIpLearnerByKey(str);
        if (localObject1 != null) {
          paramConcurrentHashMap.put(str, ((IpLearning)localObject1).adjustNewIpList(localArrayList));
        }
      }
      else
      {
        paramConcurrentHashMap.put(str, localArrayList);
      }
    }
  }
  
  /* Error */
  private IpContainer.PersistentConfig loadFromDisk(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 174	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokevirtual 180	android/content/Context:getFilesDir	()Ljava/io/File;
    //   8: invokevirtual 183	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   11: aload_2
    //   12: invokespecial 185	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   15: invokevirtual 188	java/io/File:exists	()Z
    //   18: istore 4
    //   20: aconst_null
    //   21: astore 6
    //   23: aconst_null
    //   24: astore 7
    //   26: iload 4
    //   28: ifne +35 -> 63
    //   31: new 135	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   38: astore_1
    //   39: aload_1
    //   40: ldc 190
    //   42: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_1
    //   47: aload_2
    //   48: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: ldc 150
    //   54: aload_1
    //   55: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 157	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aconst_null
    //   62: areturn
    //   63: new 192	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB
    //   66: dup
    //   67: invokespecial 193	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:<init>	()V
    //   70: astore 8
    //   72: aload_1
    //   73: aload_2
    //   74: invokevirtual 197	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   77: astore 5
    //   79: new 199	java/io/ByteArrayOutputStream
    //   82: dup
    //   83: invokespecial 200	java/io/ByteArrayOutputStream:<init>	()V
    //   86: astore 6
    //   88: sipush 1024
    //   91: newarray byte
    //   93: astore_1
    //   94: aload 5
    //   96: aload_1
    //   97: iconst_0
    //   98: aload_1
    //   99: arraylength
    //   100: invokevirtual 206	java/io/FileInputStream:read	([BII)I
    //   103: istore_3
    //   104: iload_3
    //   105: iconst_m1
    //   106: if_icmpeq +14 -> 120
    //   109: aload 6
    //   111: aload_1
    //   112: iconst_0
    //   113: iload_3
    //   114: invokevirtual 210	java/io/ByteArrayOutputStream:write	([BII)V
    //   117: goto -23 -> 94
    //   120: aload 6
    //   122: invokevirtual 213	java/io/ByteArrayOutputStream:flush	()V
    //   125: aload 8
    //   127: aload 6
    //   129: invokevirtual 217	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   132: invokevirtual 221	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   135: pop
    //   136: new 223	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig
    //   139: dup
    //   140: aload_0
    //   141: aconst_null
    //   142: invokespecial 226	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:<init>	(Lcom/tencent/mobileqq/highway/config/IpContainer;Lcom/tencent/mobileqq/highway/config/IpContainer$1;)V
    //   145: astore_1
    //   146: aload_1
    //   147: new 18	java/util/concurrent/ConcurrentHashMap
    //   150: dup
    //   151: invokespecial 21	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   154: putfield 229	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
    //   157: aload_1
    //   158: new 18	java/util/concurrent/ConcurrentHashMap
    //   161: dup
    //   162: invokespecial 21	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   165: putfield 232	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpv6List	Ljava/util/concurrent/ConcurrentHashMap;
    //   168: aload_1
    //   169: new 38	java/util/ArrayList
    //   172: dup
    //   173: invokespecial 107	java/util/ArrayList:<init>	()V
    //   176: putfield 236	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mSegConf	Ljava/util/ArrayList;
    //   179: aload_1
    //   180: new 38	java/util/ArrayList
    //   183: dup
    //   184: invokespecial 107	java/util/ArrayList:<init>	()V
    //   187: putfield 239	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mShortVideoSegConf	Ljava/util/ArrayList;
    //   190: aload 8
    //   192: getfield 243	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_config_item_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   195: invokevirtual 248	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   198: invokeinterface 251 1 0
    //   203: astore_2
    //   204: aload_2
    //   205: invokeinterface 102 1 0
    //   210: ifeq +130 -> 340
    //   213: aload_2
    //   214: invokeinterface 106 1 0
    //   219: checkcast 253	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB
    //   222: astore 9
    //   224: aload 9
    //   226: getfield 257	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:string_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   229: invokevirtual 261	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   232: astore 7
    //   234: aload 9
    //   236: getfield 264	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:rpt_end_point_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   239: invokevirtual 248	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   242: checkcast 38	java/util/ArrayList
    //   245: astore 10
    //   247: new 38	java/util/ArrayList
    //   250: dup
    //   251: invokespecial 107	java/util/ArrayList:<init>	()V
    //   254: astore 9
    //   256: aload 10
    //   258: invokevirtual 96	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   261: astore 10
    //   263: aload 10
    //   265: invokeinterface 102 1 0
    //   270: ifeq +55 -> 325
    //   273: aload 10
    //   275: invokeinterface 106 1 0
    //   280: checkcast 266	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB
    //   283: astore 11
    //   285: aload 9
    //   287: new 48	com/tencent/mobileqq/highway/utils/EndPoint
    //   290: dup
    //   291: aload 11
    //   293: getfield 269	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:string_host	Lcom/tencent/mobileqq/pb/PBStringField;
    //   296: invokevirtual 261	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   299: aload 11
    //   301: getfield 273	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int32_port	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   304: invokevirtual 277	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   307: aload 11
    //   309: getfield 281	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int64_timestampe	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   312: invokevirtual 286	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   315: invokespecial 289	com/tencent/mobileqq/highway/utils/EndPoint:<init>	(Ljava/lang/String;IJ)V
    //   318: invokevirtual 133	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   321: pop
    //   322: goto -59 -> 263
    //   325: aload_1
    //   326: getfield 229	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
    //   329: aload 7
    //   331: aload 9
    //   333: invokevirtual 166	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   336: pop
    //   337: goto -133 -> 204
    //   340: aload 8
    //   342: getfield 292	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_config_item_list_ip6	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   345: invokevirtual 248	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   348: invokeinterface 251 1 0
    //   353: astore_2
    //   354: aload_2
    //   355: invokeinterface 102 1 0
    //   360: ifeq +130 -> 490
    //   363: aload_2
    //   364: invokeinterface 106 1 0
    //   369: checkcast 253	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB
    //   372: astore 9
    //   374: aload 9
    //   376: getfield 257	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:string_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   379: invokevirtual 261	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   382: astore 7
    //   384: aload 9
    //   386: getfield 264	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:rpt_end_point_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   389: invokevirtual 248	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   392: checkcast 38	java/util/ArrayList
    //   395: astore 10
    //   397: new 38	java/util/ArrayList
    //   400: dup
    //   401: invokespecial 107	java/util/ArrayList:<init>	()V
    //   404: astore 9
    //   406: aload 10
    //   408: invokevirtual 96	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   411: astore 10
    //   413: aload 10
    //   415: invokeinterface 102 1 0
    //   420: ifeq +55 -> 475
    //   423: aload 10
    //   425: invokeinterface 106 1 0
    //   430: checkcast 266	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB
    //   433: astore 11
    //   435: aload 9
    //   437: new 48	com/tencent/mobileqq/highway/utils/EndPoint
    //   440: dup
    //   441: aload 11
    //   443: getfield 269	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:string_host	Lcom/tencent/mobileqq/pb/PBStringField;
    //   446: invokevirtual 261	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   449: aload 11
    //   451: getfield 273	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int32_port	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   454: invokevirtual 277	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   457: aload 11
    //   459: getfield 281	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int64_timestampe	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   462: invokevirtual 286	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   465: invokespecial 289	com/tencent/mobileqq/highway/utils/EndPoint:<init>	(Ljava/lang/String;IJ)V
    //   468: invokevirtual 133	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   471: pop
    //   472: goto -59 -> 413
    //   475: aload_1
    //   476: getfield 232	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpv6List	Ljava/util/concurrent/ConcurrentHashMap;
    //   479: aload 7
    //   481: aload 9
    //   483: invokevirtual 166	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   486: pop
    //   487: goto -133 -> 354
    //   490: aload 8
    //   492: getfield 295	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_net_seg_conf_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   495: invokevirtual 248	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   498: invokeinterface 251 1 0
    //   503: astore_2
    //   504: aload_2
    //   505: invokeinterface 102 1 0
    //   510: ifeq +68 -> 578
    //   513: aload_2
    //   514: invokeinterface 106 1 0
    //   519: checkcast 297	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
    //   522: astore 7
    //   524: new 299	com/tencent/mobileqq/highway/config/HwNetSegConf
    //   527: dup
    //   528: aload 7
    //   530: getfield 302	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   533: invokevirtual 286	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   536: aload 7
    //   538: getfield 305	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   541: invokevirtual 286	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   544: aload 7
    //   546: getfield 308	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   549: invokevirtual 286	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   552: aload 7
    //   554: getfield 311	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   557: invokevirtual 286	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   560: invokespecial 314	com/tencent/mobileqq/highway/config/HwNetSegConf:<init>	(JJJJ)V
    //   563: astore 7
    //   565: aload_1
    //   566: getfield 236	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mSegConf	Ljava/util/ArrayList;
    //   569: aload 7
    //   571: invokevirtual 133	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   574: pop
    //   575: goto -71 -> 504
    //   578: aload 8
    //   580: getfield 317	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_short_video_net_conf	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   583: invokevirtual 248	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   586: invokeinterface 251 1 0
    //   591: astore_2
    //   592: aload_2
    //   593: invokeinterface 102 1 0
    //   598: ifeq +68 -> 666
    //   601: aload_2
    //   602: invokeinterface 106 1 0
    //   607: checkcast 297	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
    //   610: astore 7
    //   612: new 299	com/tencent/mobileqq/highway/config/HwNetSegConf
    //   615: dup
    //   616: aload 7
    //   618: getfield 302	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   621: invokevirtual 286	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   624: aload 7
    //   626: getfield 305	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   629: invokevirtual 286	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   632: aload 7
    //   634: getfield 308	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   637: invokevirtual 286	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   640: aload 7
    //   642: getfield 311	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   645: invokevirtual 286	com/tencent/mobileqq/pb/PBInt64Field:get	()J
    //   648: invokespecial 314	com/tencent/mobileqq/highway/config/HwNetSegConf:<init>	(JJJJ)V
    //   651: astore 7
    //   653: aload_1
    //   654: getfield 239	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mShortVideoSegConf	Ljava/util/ArrayList;
    //   657: aload 7
    //   659: invokevirtual 133	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   662: pop
    //   663: goto -71 -> 592
    //   666: aload 5
    //   668: ifnull +16 -> 684
    //   671: aload 5
    //   673: invokevirtual 320	java/io/FileInputStream:close	()V
    //   676: goto +8 -> 684
    //   679: astore_2
    //   680: aload_2
    //   681: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   684: aload_1
    //   685: astore_2
    //   686: aload 6
    //   688: invokevirtual 324	java/io/ByteArrayOutputStream:close	()V
    //   691: aload_1
    //   692: areturn
    //   693: astore_1
    //   694: aload_1
    //   695: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   698: aload_2
    //   699: areturn
    //   700: astore_2
    //   701: goto +51 -> 752
    //   704: astore_2
    //   705: goto +68 -> 773
    //   708: astore_1
    //   709: goto +12 -> 721
    //   712: astore_2
    //   713: goto +15 -> 728
    //   716: astore_2
    //   717: goto +17 -> 734
    //   720: astore_1
    //   721: aload 6
    //   723: astore_2
    //   724: goto +202 -> 926
    //   727: astore_2
    //   728: aconst_null
    //   729: astore_1
    //   730: goto +22 -> 752
    //   733: astore_2
    //   734: aconst_null
    //   735: astore_1
    //   736: goto +37 -> 773
    //   739: astore_1
    //   740: aconst_null
    //   741: astore_2
    //   742: goto +184 -> 926
    //   745: astore_2
    //   746: aconst_null
    //   747: astore 6
    //   749: aload 6
    //   751: astore_1
    //   752: aload_2
    //   753: astore 8
    //   755: aload 5
    //   757: astore 7
    //   759: aload 6
    //   761: astore 5
    //   763: goto +42 -> 805
    //   766: astore_2
    //   767: aconst_null
    //   768: astore 6
    //   770: aload 6
    //   772: astore_1
    //   773: aload_2
    //   774: astore 8
    //   776: aload 5
    //   778: astore 7
    //   780: aload 6
    //   782: astore 5
    //   784: goto +84 -> 868
    //   787: astore_1
    //   788: aconst_null
    //   789: astore 5
    //   791: aload 5
    //   793: astore_2
    //   794: goto +132 -> 926
    //   797: astore 8
    //   799: aconst_null
    //   800: astore 5
    //   802: aload 5
    //   804: astore_1
    //   805: aload 7
    //   807: astore 6
    //   809: aload 5
    //   811: astore_2
    //   812: ldc 150
    //   814: ldc_w 326
    //   817: aload 8
    //   819: invokestatic 330	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   822: aload 7
    //   824: ifnull +16 -> 840
    //   827: aload 7
    //   829: invokevirtual 320	java/io/FileInputStream:close	()V
    //   832: goto +8 -> 840
    //   835: astore_2
    //   836: aload_2
    //   837: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   840: aload_1
    //   841: astore_2
    //   842: aload 5
    //   844: ifnull +75 -> 919
    //   847: aload_1
    //   848: astore_2
    //   849: aload 5
    //   851: invokevirtual 324	java/io/ByteArrayOutputStream:close	()V
    //   854: aload_1
    //   855: areturn
    //   856: astore 8
    //   858: aconst_null
    //   859: astore 5
    //   861: aload 5
    //   863: astore_1
    //   864: aload 6
    //   866: astore 7
    //   868: aload 7
    //   870: astore 6
    //   872: aload 5
    //   874: astore_2
    //   875: ldc 150
    //   877: ldc_w 332
    //   880: aload 8
    //   882: invokestatic 330	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   885: aload 7
    //   887: ifnull +16 -> 903
    //   890: aload 7
    //   892: invokevirtual 320	java/io/FileInputStream:close	()V
    //   895: goto +8 -> 903
    //   898: astore_2
    //   899: aload_2
    //   900: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   903: aload_1
    //   904: astore_2
    //   905: aload 5
    //   907: ifnull +12 -> 919
    //   910: aload_1
    //   911: astore_2
    //   912: aload 5
    //   914: invokevirtual 324	java/io/ByteArrayOutputStream:close	()V
    //   917: aload_1
    //   918: astore_2
    //   919: aload_2
    //   920: areturn
    //   921: astore_1
    //   922: aload 6
    //   924: astore 5
    //   926: aload 5
    //   928: ifnull +18 -> 946
    //   931: aload 5
    //   933: invokevirtual 320	java/io/FileInputStream:close	()V
    //   936: goto +10 -> 946
    //   939: astore 5
    //   941: aload 5
    //   943: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   946: aload_2
    //   947: ifnull +15 -> 962
    //   950: aload_2
    //   951: invokevirtual 324	java/io/ByteArrayOutputStream:close	()V
    //   954: goto +8 -> 962
    //   957: astore_2
    //   958: aload_2
    //   959: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   962: goto +5 -> 967
    //   965: aload_1
    //   966: athrow
    //   967: goto -2 -> 965
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	970	0	this	IpContainer
    //   0	970	1	paramContext	Context
    //   0	970	2	paramString	String
    //   103	11	3	i	int
    //   18	9	4	bool	boolean
    //   77	855	5	localObject1	Object
    //   939	3	5	localIOException1	java.io.IOException
    //   21	902	6	localObject2	Object
    //   24	867	7	localObject3	Object
    //   70	705	8	localObject4	Object
    //   797	21	8	localIOException2	java.io.IOException
    //   856	25	8	localInvalidProtocolBufferMicroException	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   222	260	9	localObject5	Object
    //   245	179	10	localObject6	Object
    //   283	175	11	localHwEndPointPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwEndPointPB
    // Exception table:
    //   from	to	target	type
    //   671	676	679	java/io/IOException
    //   686	691	693	java/io/IOException
    //   849	854	693	java/io/IOException
    //   912	917	693	java/io/IOException
    //   146	204	700	java/io/IOException
    //   204	263	700	java/io/IOException
    //   263	322	700	java/io/IOException
    //   325	337	700	java/io/IOException
    //   340	354	700	java/io/IOException
    //   354	413	700	java/io/IOException
    //   413	472	700	java/io/IOException
    //   475	487	700	java/io/IOException
    //   490	504	700	java/io/IOException
    //   504	575	700	java/io/IOException
    //   578	592	700	java/io/IOException
    //   592	663	700	java/io/IOException
    //   146	204	704	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   204	263	704	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   263	322	704	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   325	337	704	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   340	354	704	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   354	413	704	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   413	472	704	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   475	487	704	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   490	504	704	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   504	575	704	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   578	592	704	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   592	663	704	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   136	146	708	finally
    //   146	204	708	finally
    //   204	263	708	finally
    //   263	322	708	finally
    //   325	337	708	finally
    //   340	354	708	finally
    //   354	413	708	finally
    //   413	472	708	finally
    //   475	487	708	finally
    //   490	504	708	finally
    //   504	575	708	finally
    //   578	592	708	finally
    //   592	663	708	finally
    //   136	146	712	java/io/IOException
    //   136	146	716	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   88	94	720	finally
    //   94	104	720	finally
    //   109	117	720	finally
    //   120	136	720	finally
    //   88	94	727	java/io/IOException
    //   94	104	727	java/io/IOException
    //   109	117	727	java/io/IOException
    //   120	136	727	java/io/IOException
    //   88	94	733	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   94	104	733	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   109	117	733	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   120	136	733	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   79	88	739	finally
    //   79	88	745	java/io/IOException
    //   79	88	766	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   72	79	787	finally
    //   72	79	797	java/io/IOException
    //   827	832	835	java/io/IOException
    //   72	79	856	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   890	895	898	java/io/IOException
    //   812	822	921	finally
    //   875	885	921	finally
    //   931	936	939	java/io/IOException
    //   950	954	957	java/io/IOException
  }
  
  private IpContainer.PersistentConfig readDiskOrCreateNew(Context paramContext, String paramString)
  {
    paramContext = loadFromDisk(paramContext, paramString);
    if (paramContext == null)
    {
      paramContext = new IpContainer.PersistentConfig(this, null);
      paramContext.mIpList = new ConcurrentHashMap();
      paramContext.mIpv6List = new ConcurrentHashMap();
      paramContext.mSegConf = new ArrayList();
      paramContext.mShortVideoSegConf = new ArrayList();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("IpContainer, ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" does NOT exists.");
      BdhLogUtil.LogEvent("C", localStringBuilder.toString());
      return paramContext;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("IpContainer, ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" does exists.");
    BdhLogUtil.LogEvent("C", localStringBuilder.toString());
    return paramContext;
  }
  
  public static void refreshIpLearning()
  {
    ConcurrentHashMap localConcurrentHashMap = mIpLearners;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
  }
  
  /* Error */
  private void write2disk(Context paramContext, String paramString, IpContainer.PersistentConfig paramPersistentConfig)
  {
    // Byte code:
    //   0: new 192	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB
    //   3: dup
    //   4: invokespecial 193	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:<init>	()V
    //   7: astore 4
    //   9: aload_3
    //   10: getfield 229	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpList	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: invokevirtual 352	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   16: invokeinterface 355 1 0
    //   21: astore 5
    //   23: aload 5
    //   25: invokeinterface 102 1 0
    //   30: ifeq +178 -> 208
    //   33: aload 5
    //   35: invokeinterface 106 1 0
    //   40: checkcast 357	java/util/Map$Entry
    //   43: astore 7
    //   45: aload 7
    //   47: invokeinterface 360 1 0
    //   52: checkcast 53	java/lang/String
    //   55: astore 6
    //   57: aload 7
    //   59: invokeinterface 363 1 0
    //   64: checkcast 38	java/util/ArrayList
    //   67: astore 8
    //   69: new 38	java/util/ArrayList
    //   72: dup
    //   73: invokespecial 107	java/util/ArrayList:<init>	()V
    //   76: astore 7
    //   78: aload 8
    //   80: invokevirtual 96	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   83: astore 8
    //   85: aload 8
    //   87: invokeinterface 102 1 0
    //   92: ifeq +74 -> 166
    //   95: aload 8
    //   97: invokeinterface 106 1 0
    //   102: checkcast 48	com/tencent/mobileqq/highway/utils/EndPoint
    //   105: astore 9
    //   107: new 266	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB
    //   110: dup
    //   111: invokespecial 364	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:<init>	()V
    //   114: astore 10
    //   116: aload 10
    //   118: getfield 269	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:string_host	Lcom/tencent/mobileqq/pb/PBStringField;
    //   121: aload 9
    //   123: getfield 51	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   126: invokevirtual 368	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   129: aload 10
    //   131: getfield 273	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int32_port	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   134: aload 9
    //   136: getfield 110	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   139: invokevirtual 371	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   142: aload 10
    //   144: getfield 281	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int64_timestampe	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   147: aload 9
    //   149: getfield 130	com/tencent/mobileqq/highway/utils/EndPoint:timestamp	J
    //   152: invokevirtual 374	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   155: aload 7
    //   157: aload 10
    //   159: invokevirtual 133	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   162: pop
    //   163: goto -78 -> 85
    //   166: new 253	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB
    //   169: dup
    //   170: invokespecial 375	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:<init>	()V
    //   173: astore 8
    //   175: aload 8
    //   177: getfield 257	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:string_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   180: aload 6
    //   182: invokevirtual 368	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   185: aload 8
    //   187: getfield 264	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:rpt_end_point_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   190: aload 7
    //   192: invokevirtual 378	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   195: aload 4
    //   197: getfield 243	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_config_item_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   200: aload 8
    //   202: invokevirtual 381	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   205: goto -182 -> 23
    //   208: aload_3
    //   209: getfield 232	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mIpv6List	Ljava/util/concurrent/ConcurrentHashMap;
    //   212: invokevirtual 352	java/util/concurrent/ConcurrentHashMap:entrySet	()Ljava/util/Set;
    //   215: invokeinterface 355 1 0
    //   220: astore 5
    //   222: aload 5
    //   224: invokeinterface 102 1 0
    //   229: ifeq +178 -> 407
    //   232: aload 5
    //   234: invokeinterface 106 1 0
    //   239: checkcast 357	java/util/Map$Entry
    //   242: astore 7
    //   244: aload 7
    //   246: invokeinterface 360 1 0
    //   251: checkcast 53	java/lang/String
    //   254: astore 6
    //   256: aload 7
    //   258: invokeinterface 363 1 0
    //   263: checkcast 38	java/util/ArrayList
    //   266: astore 8
    //   268: new 38	java/util/ArrayList
    //   271: dup
    //   272: invokespecial 107	java/util/ArrayList:<init>	()V
    //   275: astore 7
    //   277: aload 8
    //   279: invokevirtual 96	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   282: astore 8
    //   284: aload 8
    //   286: invokeinterface 102 1 0
    //   291: ifeq +74 -> 365
    //   294: aload 8
    //   296: invokeinterface 106 1 0
    //   301: checkcast 48	com/tencent/mobileqq/highway/utils/EndPoint
    //   304: astore 9
    //   306: new 266	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB
    //   309: dup
    //   310: invokespecial 364	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:<init>	()V
    //   313: astore 10
    //   315: aload 10
    //   317: getfield 269	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:string_host	Lcom/tencent/mobileqq/pb/PBStringField;
    //   320: aload 9
    //   322: getfield 51	com/tencent/mobileqq/highway/utils/EndPoint:host	Ljava/lang/String;
    //   325: invokevirtual 368	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   328: aload 10
    //   330: getfield 273	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int32_port	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   333: aload 9
    //   335: getfield 110	com/tencent/mobileqq/highway/utils/EndPoint:port	I
    //   338: invokevirtual 371	com/tencent/mobileqq/pb/PBInt32Field:set	(I)V
    //   341: aload 10
    //   343: getfield 281	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwEndPointPB:int64_timestampe	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   346: aload 9
    //   348: getfield 130	com/tencent/mobileqq/highway/utils/EndPoint:timestamp	J
    //   351: invokevirtual 374	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   354: aload 7
    //   356: aload 10
    //   358: invokevirtual 133	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   361: pop
    //   362: goto -78 -> 284
    //   365: new 253	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB
    //   368: dup
    //   369: invokespecial 375	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:<init>	()V
    //   372: astore 8
    //   374: aload 8
    //   376: getfield 257	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:string_key	Lcom/tencent/mobileqq/pb/PBStringField;
    //   379: aload 6
    //   381: invokevirtual 368	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   384: aload 8
    //   386: getfield 264	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigItemPB:rpt_end_point_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   389: aload 7
    //   391: invokevirtual 378	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   394: aload 4
    //   396: getfield 292	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_config_item_list_ip6	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   399: aload 8
    //   401: invokevirtual 381	com/tencent/mobileqq/pb/PBRepeatMessageField:add	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   404: goto -182 -> 222
    //   407: new 38	java/util/ArrayList
    //   410: dup
    //   411: invokespecial 107	java/util/ArrayList:<init>	()V
    //   414: astore 5
    //   416: aload_3
    //   417: getfield 236	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mSegConf	Ljava/util/ArrayList;
    //   420: invokevirtual 96	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   423: astore 6
    //   425: aload 6
    //   427: invokeinterface 102 1 0
    //   432: ifeq +87 -> 519
    //   435: aload 6
    //   437: invokeinterface 106 1 0
    //   442: checkcast 299	com/tencent/mobileqq/highway/config/HwNetSegConf
    //   445: astore 7
    //   447: new 297	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
    //   450: dup
    //   451: invokespecial 382	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:<init>	()V
    //   454: astore 8
    //   456: aload 8
    //   458: getfield 302	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   461: aload 7
    //   463: getfield 385	com/tencent/mobileqq/highway/config/HwNetSegConf:netType	J
    //   466: invokevirtual 374	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   469: aload 8
    //   471: getfield 305	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   474: aload 7
    //   476: getfield 388	com/tencent/mobileqq/highway/config/HwNetSegConf:segSize	J
    //   479: invokevirtual 374	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   482: aload 8
    //   484: getfield 308	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   487: aload 7
    //   489: getfield 391	com/tencent/mobileqq/highway/config/HwNetSegConf:segNum	J
    //   492: invokevirtual 374	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   495: aload 8
    //   497: getfield 311	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   500: aload 7
    //   502: getfield 394	com/tencent/mobileqq/highway/config/HwNetSegConf:curConnNum	J
    //   505: invokevirtual 374	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   508: aload 5
    //   510: aload 8
    //   512: invokevirtual 133	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   515: pop
    //   516: goto -91 -> 425
    //   519: aload 4
    //   521: getfield 295	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_net_seg_conf_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   524: aload 5
    //   526: invokevirtual 378	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   529: new 38	java/util/ArrayList
    //   532: dup
    //   533: invokespecial 107	java/util/ArrayList:<init>	()V
    //   536: astore 5
    //   538: aload_3
    //   539: getfield 236	com/tencent/mobileqq/highway/config/IpContainer$PersistentConfig:mSegConf	Ljava/util/ArrayList;
    //   542: invokevirtual 96	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   545: astore_3
    //   546: aload_3
    //   547: invokeinterface 102 1 0
    //   552: ifeq +86 -> 638
    //   555: aload_3
    //   556: invokeinterface 106 1 0
    //   561: checkcast 299	com/tencent/mobileqq/highway/config/HwNetSegConf
    //   564: astore 6
    //   566: new 297	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB
    //   569: dup
    //   570: invokespecial 382	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:<init>	()V
    //   573: astore 7
    //   575: aload 7
    //   577: getfield 302	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_net_type	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   580: aload 6
    //   582: getfield 385	com/tencent/mobileqq/highway/config/HwNetSegConf:netType	J
    //   585: invokevirtual 374	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   588: aload 7
    //   590: getfield 305	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_size	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   593: aload 6
    //   595: getfield 388	com/tencent/mobileqq/highway/config/HwNetSegConf:segSize	J
    //   598: invokevirtual 374	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   601: aload 7
    //   603: getfield 308	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_seg_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   606: aload 6
    //   608: getfield 391	com/tencent/mobileqq/highway/config/HwNetSegConf:segNum	J
    //   611: invokevirtual 374	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   614: aload 7
    //   616: getfield 311	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwNetSegConfPB:int64_cur_conn_num	Lcom/tencent/mobileqq/pb/PBInt64Field;
    //   619: aload 6
    //   621: getfield 394	com/tencent/mobileqq/highway/config/HwNetSegConf:curConnNum	J
    //   624: invokevirtual 374	com/tencent/mobileqq/pb/PBInt64Field:set	(J)V
    //   627: aload 5
    //   629: aload 7
    //   631: invokevirtual 133	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   634: pop
    //   635: goto -89 -> 546
    //   638: aload 4
    //   640: getfield 317	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:rpt_short_video_net_conf	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   643: aload 5
    //   645: invokevirtual 378	com/tencent/mobileqq/pb/PBRepeatMessageField:set	(Ljava/util/List;)V
    //   648: new 174	java/io/File
    //   651: dup
    //   652: aload_1
    //   653: invokevirtual 180	android/content/Context:getFilesDir	()Ljava/io/File;
    //   656: invokevirtual 183	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   659: aload_2
    //   660: invokespecial 185	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   663: astore_1
    //   664: new 396	java/io/FileOutputStream
    //   667: dup
    //   668: aload_1
    //   669: invokespecial 399	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   672: astore_3
    //   673: aload_3
    //   674: astore_1
    //   675: aload_3
    //   676: aload 4
    //   678: invokevirtual 400	com/tencent/mobileqq/highway/protocol/HwConfigPersistentPB$HwConfigPB:toByteArray	()[B
    //   681: invokevirtual 403	java/io/FileOutputStream:write	([B)V
    //   684: aload_3
    //   685: astore_1
    //   686: new 135	java/lang/StringBuilder
    //   689: dup
    //   690: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   693: astore 4
    //   695: aload_3
    //   696: astore_1
    //   697: aload 4
    //   699: ldc_w 405
    //   702: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: pop
    //   706: aload_3
    //   707: astore_1
    //   708: aload 4
    //   710: aload_2
    //   711: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: pop
    //   715: aload_3
    //   716: astore_1
    //   717: ldc 150
    //   719: aload 4
    //   721: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   724: invokestatic 157	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   727: aload_3
    //   728: invokevirtual 406	java/io/FileOutputStream:close	()V
    //   731: return
    //   732: astore_2
    //   733: goto +105 -> 838
    //   736: astore_2
    //   737: goto +17 -> 754
    //   740: astore 4
    //   742: goto +42 -> 784
    //   745: astore_2
    //   746: aconst_null
    //   747: astore_1
    //   748: goto +90 -> 838
    //   751: astore_2
    //   752: aconst_null
    //   753: astore_3
    //   754: aload_3
    //   755: astore_1
    //   756: ldc 150
    //   758: ldc_w 408
    //   761: aload_2
    //   762: invokestatic 330	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   765: aload_3
    //   766: ifnull +71 -> 837
    //   769: aload_3
    //   770: invokevirtual 406	java/io/FileOutputStream:close	()V
    //   773: return
    //   774: astore_1
    //   775: aload_1
    //   776: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   779: return
    //   780: astore 4
    //   782: aconst_null
    //   783: astore_3
    //   784: aload_3
    //   785: astore_1
    //   786: new 135	java/lang/StringBuilder
    //   789: dup
    //   790: invokespecial 136	java/lang/StringBuilder:<init>	()V
    //   793: astore 5
    //   795: aload_3
    //   796: astore_1
    //   797: aload 5
    //   799: ldc_w 410
    //   802: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   805: pop
    //   806: aload_3
    //   807: astore_1
    //   808: aload 5
    //   810: aload_2
    //   811: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload_3
    //   816: astore_1
    //   817: ldc 150
    //   819: aload 5
    //   821: invokevirtual 151	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   824: aload 4
    //   826: invokestatic 330	com/tencent/mobileqq/highway/utils/BdhLogUtil:LogException	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   829: aload_3
    //   830: ifnull +7 -> 837
    //   833: aload_3
    //   834: invokevirtual 406	java/io/FileOutputStream:close	()V
    //   837: return
    //   838: aload_1
    //   839: ifnull +15 -> 854
    //   842: aload_1
    //   843: invokevirtual 406	java/io/FileOutputStream:close	()V
    //   846: goto +8 -> 854
    //   849: astore_1
    //   850: aload_1
    //   851: invokevirtual 323	java/io/IOException:printStackTrace	()V
    //   854: goto +5 -> 859
    //   857: aload_2
    //   858: athrow
    //   859: goto -2 -> 857
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	862	0	this	IpContainer
    //   0	862	1	paramContext	Context
    //   0	862	2	paramString	String
    //   0	862	3	paramPersistentConfig	IpContainer.PersistentConfig
    //   7	713	4	localObject1	Object
    //   740	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   780	45	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   21	799	5	localObject2	Object
    //   55	565	6	localObject3	Object
    //   43	587	7	localObject4	Object
    //   67	444	8	localObject5	Object
    //   105	242	9	localEndPoint	EndPoint
    //   114	243	10	localHwEndPointPB	com.tencent.mobileqq.highway.protocol.HwConfigPersistentPB.HwEndPointPB
    // Exception table:
    //   from	to	target	type
    //   675	684	732	finally
    //   686	695	732	finally
    //   697	706	732	finally
    //   708	715	732	finally
    //   717	727	732	finally
    //   756	765	732	finally
    //   786	795	732	finally
    //   797	806	732	finally
    //   808	815	732	finally
    //   817	829	732	finally
    //   675	684	736	java/io/IOException
    //   686	695	736	java/io/IOException
    //   697	706	736	java/io/IOException
    //   708	715	736	java/io/IOException
    //   717	727	736	java/io/IOException
    //   675	684	740	java/io/FileNotFoundException
    //   686	695	740	java/io/FileNotFoundException
    //   697	706	740	java/io/FileNotFoundException
    //   708	715	740	java/io/FileNotFoundException
    //   717	727	740	java/io/FileNotFoundException
    //   664	673	745	finally
    //   664	673	751	java/io/IOException
    //   727	731	774	java/io/IOException
    //   769	773	774	java/io/IOException
    //   833	837	774	java/io/IOException
    //   664	673	780	java/io/FileNotFoundException
    //   842	846	849	java/io/IOException
  }
  
  public boolean addNew(Context paramContext, HwConfig paramHwConfig, AppRuntime paramAppRuntime, ConfigManager paramConfigManager)
  {
    try
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("IpContainer, addNew() ");
      paramAppRuntime.append(paramHwConfig.ipList2String());
      BdhLogUtil.LogEvent("C", paramAppRuntime.toString());
      long l = SystemClock.uptimeMillis();
      paramAppRuntime = paramHwConfig.ipList.iterator();
      while (paramAppRuntime.hasNext()) {
        ((EndPoint)paramAppRuntime.next()).timestamp = l;
      }
      paramAppRuntime = readDiskOrCreateNew(paramContext, this.mFileName);
      bool3 = true;
      if ((paramHwConfig == null) || (paramHwConfig.ipList == null) || (paramHwConfig.ipList.isEmpty())) {
        break label398;
      }
      insertOrReplace(paramContext, paramAppRuntime.mIpList, paramHwConfig.ipList, false);
      insertOrReplace(paramContext, this.mCfg.mIpList, paramHwConfig.ipList, true);
      bool2 = true;
    }
    finally
    {
      for (;;)
      {
        boolean bool3;
        for (;;)
        {
          throw paramContext;
        }
        label398:
        boolean bool2 = false;
        continue;
        boolean bool1 = bool2;
      }
    }
    bool1 = bool2;
    if (paramHwConfig != null)
    {
      bool1 = bool2;
      if (paramHwConfig.ipv6List != null)
      {
        bool1 = bool2;
        if (!paramHwConfig.ipv6List.isEmpty())
        {
          insertOrReplace(paramContext, paramAppRuntime.mIpv6List, paramHwConfig.ipv6List, false);
          insertOrReplace(paramContext, this.mCfg.mIpv6List, paramHwConfig.ipv6List, true);
          bool1 = true;
        }
      }
    }
    bool2 = bool1;
    if (paramHwConfig != null)
    {
      bool2 = bool1;
      if (paramHwConfig.ipList != null)
      {
        bool2 = bool1;
        if (!paramHwConfig.ipList.isEmpty()) {
          if (paramHwConfig.ipv6List != null)
          {
            bool2 = bool1;
            if (!paramHwConfig.ipv6List.isEmpty()) {}
          }
          else
          {
            insertOrReplace(paramContext, paramAppRuntime.mIpv6List, paramHwConfig.ipv6List, false);
            insertOrReplace(paramContext, this.mCfg.mIpv6List, paramHwConfig.ipv6List, true);
            bool2 = true;
          }
        }
      }
    }
    if ((paramHwConfig != null) && (paramHwConfig.netSegConfList != null) && (!paramHwConfig.netSegConfList.isEmpty()))
    {
      paramAppRuntime.mSegConf = paramHwConfig.netSegConfList;
      paramAppRuntime.mShortVideoSegConf = paramHwConfig.shortVideoSegConfList;
      this.mCfg.mSegConf = paramHwConfig.netSegConfList;
      this.mCfg.mShortVideoSegConf = paramHwConfig.shortVideoSegConfList;
      bool1 = bool3;
      if (bool1) {
        write2disk(paramContext, this.mFileName, paramAppRuntime);
      }
      return bool1;
    }
  }
  
  public void cleanIpv6Cfg(Context paramContext)
  {
    this.mCfg.mIpv6List.clear();
    write2disk(paramContext, this.mFileName, this.mCfg);
  }
  
  public boolean fail(String paramString, boolean paramBoolean)
  {
    try
    {
      Object localObject1 = this.mCfg;
      boolean bool1 = false;
      if (localObject1 == null)
      {
        BdhLogUtil.LogEvent("C", "IpContainer, fail() found due to mCfg == null");
        return false;
      }
      if ((paramBoolean) && ((this.mCfg.mIpv6List == null) || (this.mCfg.mIpv6List.isEmpty())))
      {
        BdhLogUtil.LogEvent("C", "IpContainer, fail() found due to mCfg.mIpv6List == null || mCfg.mIpv6List.isEmpty()");
        return false;
      }
      if ((!paramBoolean) && ((this.mCfg.mIpList == null) || (this.mCfg.mIpList.isEmpty())))
      {
        BdhLogUtil.LogEvent("C", "IpContainer, fail() found due to mCfg.mIpList == null || mCfg.mIpList.isEmpty()");
        return false;
      }
      ArrayList localArrayList = new ArrayList();
      if (paramBoolean) {
        localObject1 = this.mCfg.mIpv6List.keySet().iterator();
      } else {
        localObject1 = this.mCfg.mIpList.keySet().iterator();
      }
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        String str = (String)((Iterator)localObject1).next();
        if (paramBoolean) {
          localObject2 = (ArrayList)this.mCfg.mIpv6List.get(str);
        } else {
          localObject2 = (ArrayList)this.mCfg.mIpList.get(str);
        }
        boolean bool2 = bool1;
        if (findNRemove((ArrayList)localObject2, paramString))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("IpContainer, fail() remove ip ");
          localStringBuilder.append(paramString);
          localStringBuilder.append(" in ");
          localStringBuilder.append(str);
          localStringBuilder.append(" which has ");
          localStringBuilder.append(((ArrayList)localObject2).size() + 1);
          localStringBuilder.append(" IPs");
          BdhLogUtil.LogEvent("C", localStringBuilder.toString());
          bool2 = true;
        }
        bool1 = bool2;
        if (((ArrayList)localObject2).isEmpty())
        {
          localArrayList.add(str);
          bool1 = bool2;
        }
      }
      paramString = localArrayList.iterator();
      while (paramString.hasNext())
      {
        localObject1 = (String)paramString.next();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("IpContainer, fail() ");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" is empty, remove it");
        BdhLogUtil.LogEvent("C", ((StringBuilder)localObject2).toString());
        if (paramBoolean) {
          this.mCfg.mIpv6List.remove(localObject1);
        } else {
          this.mCfg.mIpList.remove(localObject1);
        }
      }
      if (!bool1) {
        BdhLogUtil.LogEvent("C", "IpContainer, fail() found NONE");
      }
      return bool1;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public EndPoint findIpCurNet(Context paramContext, boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = BdhUtils.getCurNetKey(paramContext).iterator();
      while (localIterator.hasNext())
      {
        paramContext = (String)localIterator.next();
        if (paramBoolean) {
          paramContext = (ArrayList)this.mCfg.mIpv6List.get(paramContext);
        } else {
          paramContext = (ArrayList)this.mCfg.mIpList.get(paramContext);
        }
        if ((paramContext != null) && (!paramContext.isEmpty()))
        {
          paramContext = (EndPoint)paramContext.get(0);
          return paramContext;
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramContext;
    }
  }
  
  public ArrayList<EndPoint> findIpCurNetList(Context paramContext, boolean paramBoolean)
  {
    try
    {
      Iterator localIterator = BdhUtils.getCurNetKey(paramContext).iterator();
      while (localIterator.hasNext())
      {
        paramContext = (String)localIterator.next();
        if (paramBoolean) {
          paramContext = (ArrayList)this.mCfg.mIpv6List.get(paramContext);
        } else {
          paramContext = (ArrayList)this.mCfg.mIpList.get(paramContext);
        }
        if (paramContext != null)
        {
          boolean bool = paramContext.isEmpty();
          if (!bool) {
            return paramContext;
          }
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramContext;
    }
  }
  
  public EndPoint findIpRecent(Context paramContext, boolean paramBoolean)
  {
    long l = -1L;
    Object localObject1 = null;
    if (paramBoolean) {}
    try
    {
      paramContext = this.mCfg.mIpv6List.entrySet().iterator();
      break label48;
      paramContext = this.mCfg.mIpList.entrySet().iterator();
      label48:
      while (paramContext.hasNext())
      {
        Object localObject2 = (ArrayList)((Map.Entry)paramContext.next()).getValue();
        if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty()))
        {
          localObject2 = (EndPoint)((ArrayList)localObject2).get(0);
          if ((localObject2 != null) && (((EndPoint)localObject2).timestamp > l))
          {
            l = ((EndPoint)localObject2).timestamp;
            localObject1 = localObject2;
          }
        }
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw paramContext;
    }
  }
  
  public ArrayList<HwNetSegConf> getNetSegConf(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return this.mCfg.mSegConf;
      }
      return this.mCfg.mShortVideoSegConf;
    }
    return this.mCfg.mSegConf;
  }
  
  public ArrayList<HwNetSegConf> getNetSegConf(Context paramContext)
  {
    return getNetSegConf(0);
  }
  
  public boolean isEmpty()
  {
    IpContainer.PersistentConfig localPersistentConfig = this.mCfg;
    if (localPersistentConfig == null) {
      return true;
    }
    if ((localPersistentConfig.mIpv6List == null) || (this.mCfg.mIpv6List.isEmpty()))
    {
      if (this.mCfg.mIpList == null) {
        break label58;
      }
      if (this.mCfg.mIpList.isEmpty()) {
        return true;
      }
    }
    return false;
    label58:
    return true;
  }
  
  public boolean isEmpty(boolean paramBoolean)
  {
    IpContainer.PersistentConfig localPersistentConfig = this.mCfg;
    if (localPersistentConfig == null) {
      return true;
    }
    if (paramBoolean)
    {
      if ((localPersistentConfig.mIpv6List == null) || (this.mCfg.mIpv6List.isEmpty())) {
        return true;
      }
    }
    else
    {
      if (localPersistentConfig.mIpList == null) {
        break label61;
      }
      if (this.mCfg.mIpList.isEmpty()) {
        return true;
      }
    }
    return false;
    label61:
    return true;
  }
  
  public void onConnFailed(EndPoint paramEndPoint)
  {
    if (paramEndPoint != null)
    {
      if ("".equalsIgnoreCase(paramEndPoint.keyOfAPN)) {
        return;
      }
      IpLearning localIpLearning = getOrCreateIpLearnerByKey(paramEndPoint.keyOfAPN);
      if (localIpLearning != null) {
        localIpLearning.onIpConnFail(paramEndPoint.host, paramEndPoint.port);
      }
    }
  }
  
  public void onConnSuccess(EndPoint paramEndPoint)
  {
    if (paramEndPoint != null)
    {
      if ("".equalsIgnoreCase(paramEndPoint.keyOfAPN)) {
        return;
      }
      IpLearning localIpLearning = getOrCreateIpLearnerByKey(paramEndPoint.keyOfAPN);
      if (localIpLearning != null) {
        localIpLearning.onIpConnSucc(paramEndPoint.host, paramEndPoint.port, paramEndPoint.isSameIsp);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.config.IpContainer
 * JD-Core Version:    0.7.0.1
 */