package com.tencent.mobileqq.uftransfer.depend;

import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFileManagerUtil;
import com.tencent.mobileqq.filemanager.api.IFileUtil;
import com.tencent.mobileqq.filemanager.api.IQFileUtils;
import com.tencent.mobileqq.filemanager.api.IQQFileEngine;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.api.QQFileHostInfo;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.uftransfer.api.UFTHost;
import com.tencent.mobileqq.uftransfer.common.transfer.urlprovider.UFTHttpUrlProcessor.FileHttpProxyIp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.ProxyIpManager;
import mqq.manager.ProxyIpManager.ProxyIp;

public class UFTDependFeatureApi
{
  public static int a()
  {
    return NetworkUtil.getNetworkType(BaseApplication.getContext());
  }
  
  public static int a(String paramString)
  {
    return ((IQFileUtils)QRoute.api(IQFileUtils.class)).getIpAddrTypeOfUrl(paramString);
  }
  
  public static int a(AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2, List<String> paramList)
  {
    if (paramAppRuntime == null)
    {
      UFTLog.d("[UFTTransfer] UFTDependFeatureApi", 1, "getIPv6HostsFromDns. app = null");
      return -1;
    }
    paramAppRuntime = (IQQFileEngine)paramAppRuntime.getRuntimeService(IQQFileEngine.class, "");
    if (paramAppRuntime == null)
    {
      UFTLog.d("[UFTTransfer] UFTDependFeatureApi", 1, "getIPv6HostsFromDns. fileEngine = null");
      return -1;
    }
    return paramAppRuntime.getIPv6HostsFromDns(paramString, paramInt1, paramInt2, paramList);
  }
  
  public static int a(AppRuntime paramAppRuntime, boolean paramBoolean, int paramInt, List<UFTHost> paramList)
  {
    Object localObject = new ArrayList();
    if (paramAppRuntime == null)
    {
      UFTLog.d("[UFTTransfer] UFTDependFeatureApi", 1, "getBigDataHostList. app = null");
      return -1;
    }
    paramAppRuntime = (IQQFileEngine)paramAppRuntime.getRuntimeService(IQQFileEngine.class, "");
    if (paramAppRuntime == null)
    {
      UFTLog.d("[UFTTransfer] UFTDependFeatureApi", 1, "getBigDataHostList. fileEngine = null");
      return -1;
    }
    paramInt = paramAppRuntime.getBigDataHostList(paramBoolean, paramInt, (List)localObject);
    if (((List)localObject).size() > 0)
    {
      paramAppRuntime = ((List)localObject).iterator();
      while (paramAppRuntime.hasNext())
      {
        localObject = (QQFileHostInfo)paramAppRuntime.next();
        paramList.add(new UFTHost(((QQFileHostInfo)localObject).jdField_a_of_type_JavaLangString, ((QQFileHostInfo)localObject).jdField_a_of_type_Int));
      }
    }
    return paramInt;
  }
  
  public static UFTDependFeatureApi.FileMediaInfo a(String paramString)
  {
    paramString = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getFileMediaInfo(paramString);
    if ((paramString != null) && (paramString.length == 3)) {
      return new UFTDependFeatureApi.FileMediaInfo(paramString[0], paramString[1], paramString[2]);
    }
    return null;
  }
  
  public static String a()
  {
    if (!AppNetConnInfo.isNetSupport()) {
      return "none";
    }
    if (AppNetConnInfo.isWifiConn()) {
      return "wifi";
    }
    if (AppNetConnInfo.isMobileConn())
    {
      int i = AppNetConnInfo.getMobileInfo();
      if (i != -1)
      {
        if ((i != 0) && (i != 1))
        {
          if (i != 2)
          {
            if (i != 3) {
              return "unkonw";
            }
            return "4g";
          }
          return "3g";
        }
        return "2g";
      }
    }
    return "none";
  }
  
  public static String a(String paramString)
  {
    return FileUtils.getFileName(paramString);
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return HexUtil.bytes2HexStr(paramArrayOfByte);
  }
  
  public static List<UFTHttpUrlProcessor.FileHttpProxyIp> a(AppRuntime paramAppRuntime)
  {
    ArrayList localArrayList = null;
    if (paramAppRuntime == null)
    {
      UFTLog.d("[UFTTransfer] UFTDependFeatureApi", 1, "getHttpFileProxy. app = null");
      return null;
    }
    paramAppRuntime = (ProxyIpManager)paramAppRuntime.getManager(3);
    if (paramAppRuntime == null)
    {
      UFTLog.d("[UFTTransfer] UFTDependFeatureApi", 1, "getHttpFileProxy. ProxyIpManager = null");
      return null;
    }
    List localList = paramAppRuntime.getProxyIp(5);
    paramAppRuntime = localArrayList;
    if (localList != null)
    {
      localArrayList = new ArrayList();
      int i = 0;
      for (;;)
      {
        paramAppRuntime = localArrayList;
        if (i >= localList.size()) {
          break;
        }
        paramAppRuntime = (ProxyIpManager.ProxyIp)localList.get(i);
        UFTHttpUrlProcessor.FileHttpProxyIp localFileHttpProxyIp = new UFTHttpUrlProcessor.FileHttpProxyIp();
        localFileHttpProxyIp.jdField_a_of_type_JavaLangString = paramAppRuntime.ip;
        localFileHttpProxyIp.jdField_a_of_type_Int = paramAppRuntime.port;
        localFileHttpProxyIp.b = paramAppRuntime.type;
        localArrayList.add(localFileHttpProxyIp);
        i += 1;
      }
    }
    return paramAppRuntime;
  }
  
  public static void a(Runnable paramRunnable, int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(paramRunnable, paramInt, null, paramBoolean);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong1, long paramLong2, HashMap<String, String> paramHashMap, String paramString3)
  {
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramString1, paramString2, paramBoolean, paramLong1, paramLong2, paramHashMap, paramString3);
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    HwServlet.getConfig(paramAppRuntime, paramAppRuntime.getCurrentUin());
  }
  
  public static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    PkgTools.dWord2Byte(paramArrayOfByte, paramInt, paramLong);
  }
  
  public static void a(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    PkgTools.copyData(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
  }
  
  public static boolean a()
  {
    return NetworkUtil.isNetSupport(BaseApplication.getContext());
  }
  
  public static byte[] a(String paramString)
  {
    return HexUtil.hexStr2Bytes(paramString);
  }
  
  public static int b()
  {
    return ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getMsfConnectedNetType();
  }
  
  public static int b(String paramString)
  {
    return ((IQFileUtils)QRoute.api(IQFileUtils.class)).getIpAddrType(paramString);
  }
  
  public static String b()
  {
    return AppSetting.g();
  }
  
  public static String b(String paramString)
  {
    return ((IFileUtil)QRoute.api(IFileUtil.class)).getExtension(paramString);
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    return QQFileManagerUtil.a(paramArrayOfByte);
  }
  
  public static byte[] b(String paramString)
  {
    for (;;)
    {
      try
      {
        SessionInfo localSessionInfo = SessionInfo.getInstance(paramString);
        if (localSessionInfo.getHttpconn_sig_session() != null)
        {
          int i = localSessionInfo.getHttpconn_sig_session().length;
          paramString = new byte[i];
          System.arraycopy(localSessionInfo.getHttpconn_sig_session(), 0, paramString, 0, i);
          return paramString;
        }
      }
      finally {}
      paramString = null;
    }
  }
  
  public static int c()
  {
    return ((IQFileUtils)QRoute.api(IQFileUtils.class)).getIPStackType();
  }
  
  public static String c()
  {
    return AppSetting.f();
  }
  
  public static String c(String paramString)
  {
    return ((IFileManagerUtil)QRoute.api(IFileManagerUtil.class)).getFileSuffix(paramString);
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    return MD5.toMD5(paramArrayOfByte);
  }
  
  /* Error */
  public static byte[] c(String paramString)
  {
    // Byte code:
    //   0: new 304	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 307	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_3
    //   9: aload_3
    //   10: invokevirtual 310	java/io/File:exists	()Z
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: aload_3
    //   19: invokevirtual 314	java/io/File:length	()J
    //   22: lstore_1
    //   23: new 316	java/io/FileInputStream
    //   26: dup
    //   27: aload_0
    //   28: invokespecial 317	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   31: astore 4
    //   33: lload_1
    //   34: ldc2_w 318
    //   37: lcmp
    //   38: ifge +6 -> 44
    //   41: goto +7 -> 48
    //   44: ldc2_w 318
    //   47: lstore_1
    //   48: aload 4
    //   50: astore_3
    //   51: aload_0
    //   52: lload_1
    //   53: invokestatic 323	com/tencent/qphone/base/util/MD5:getPartfileMd5	(Ljava/lang/String;J)[B
    //   56: astore_0
    //   57: aload 4
    //   59: invokevirtual 326	java/io/FileInputStream:close	()V
    //   62: aload_0
    //   63: areturn
    //   64: astore_3
    //   65: new 328	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 329	java/lang/StringBuilder:<init>	()V
    //   72: astore 4
    //   74: aload 4
    //   76: ldc_w 331
    //   79: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload 4
    //   85: aload_3
    //   86: invokevirtual 338	java/io/IOException:toString	()Ljava/lang/String;
    //   89: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc 38
    //   95: iconst_1
    //   96: aload 4
    //   98: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 46	com/tencent/mobileqq/uftransfer/depend/UFTLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   104: aload_0
    //   105: areturn
    //   106: astore_3
    //   107: aload 4
    //   109: astore_0
    //   110: aload_3
    //   111: astore 4
    //   113: goto +13 -> 126
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_3
    //   119: goto +104 -> 223
    //   122: astore 4
    //   124: aconst_null
    //   125: astore_0
    //   126: aload_0
    //   127: astore_3
    //   128: new 328	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 329	java/lang/StringBuilder:<init>	()V
    //   135: astore 5
    //   137: aload_0
    //   138: astore_3
    //   139: aload 5
    //   141: ldc_w 341
    //   144: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_0
    //   149: astore_3
    //   150: aload 5
    //   152: aload 4
    //   154: invokevirtual 338	java/io/IOException:toString	()Ljava/lang/String;
    //   157: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: pop
    //   161: aload_0
    //   162: astore_3
    //   163: ldc 38
    //   165: iconst_1
    //   166: aload 5
    //   168: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 46	com/tencent/mobileqq/uftransfer/depend/UFTLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   174: aload_0
    //   175: ifnull +45 -> 220
    //   178: aload_0
    //   179: invokevirtual 326	java/io/FileInputStream:close	()V
    //   182: aconst_null
    //   183: areturn
    //   184: astore_0
    //   185: new 328	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 329	java/lang/StringBuilder:<init>	()V
    //   192: astore_3
    //   193: aload_3
    //   194: ldc_w 331
    //   197: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_3
    //   202: aload_0
    //   203: invokevirtual 338	java/io/IOException:toString	()Ljava/lang/String;
    //   206: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: ldc 38
    //   212: iconst_1
    //   213: aload_3
    //   214: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 46	com/tencent/mobileqq/uftransfer/depend/UFTLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aconst_null
    //   221: areturn
    //   222: astore_0
    //   223: aload_3
    //   224: ifnull +50 -> 274
    //   227: aload_3
    //   228: invokevirtual 326	java/io/FileInputStream:close	()V
    //   231: goto +43 -> 274
    //   234: astore_3
    //   235: new 328	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 329	java/lang/StringBuilder:<init>	()V
    //   242: astore 4
    //   244: aload 4
    //   246: ldc_w 331
    //   249: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 4
    //   255: aload_3
    //   256: invokevirtual 338	java/io/IOException:toString	()Ljava/lang/String;
    //   259: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: ldc 38
    //   265: iconst_1
    //   266: aload 4
    //   268: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 46	com/tencent/mobileqq/uftransfer/depend/UFTLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_0
    //   275: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramString	String
    //   22	31	1	l	long
    //   8	43	3	localObject1	Object
    //   64	22	3	localIOException1	java.io.IOException
    //   106	5	3	localIOException2	java.io.IOException
    //   118	110	3	localObject2	Object
    //   234	22	3	localIOException3	java.io.IOException
    //   31	81	4	localObject3	Object
    //   122	31	4	localIOException4	java.io.IOException
    //   242	25	4	localStringBuilder1	java.lang.StringBuilder
    //   135	32	5	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   57	62	64	java/io/IOException
    //   51	57	106	java/io/IOException
    //   23	33	116	finally
    //   23	33	122	java/io/IOException
    //   178	182	184	java/io/IOException
    //   51	57	222	finally
    //   128	137	222	finally
    //   139	148	222	finally
    //   150	161	222	finally
    //   163	174	222	finally
    //   227	231	234	java/io/IOException
  }
  
  public static int d()
  {
    return ((IQFileUtils)QRoute.api(IQFileUtils.class)).getReportIPStackType();
  }
  
  public static byte[] d(String paramString)
  {
    return QQFileManagerUtil.a(paramString);
  }
  
  public static int e()
  {
    return ((IQFileUtils)QRoute.api(IQFileUtils.class)).getReportLoginIPStackType();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi
 * JD-Core Version:    0.7.0.1
 */