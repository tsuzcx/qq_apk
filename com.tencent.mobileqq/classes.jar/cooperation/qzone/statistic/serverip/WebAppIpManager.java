package cooperation.qzone.statistic.serverip;

import QMF_PROTOCAL.QmfClientIpInfo;
import QMF_PROTOCAL.QmfServerInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.qzone.statistic.Singleton;
import cooperation.qzone.util.QZLog;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class WebAppIpManager
{
  public static final String FILE_CACH = "webapp_iplist";
  public static final String TAG = "WebAppIpManager";
  private static final Singleton<WebAppIpManager, Void> sSingleton = new WebAppIpManager.1();
  private LinkedHashMap<Long, WebAppIpRecord> webAppIpMap;
  
  private File createFile()
  {
    File localFile = new File(((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getInternalCacheDir() + File.separator + "webapp_iplist");
    if (!localFile.exists())
    {
      if (localFile.getParentFile().exists()) {
        break label79;
      }
      if (localFile.getParentFile().mkdirs()) {
        localFile.createNewFile();
      }
    }
    return localFile;
    label79:
    localFile.createNewFile();
    return localFile;
  }
  
  private LinkedHashMap<Long, WebAppIpRecord> filterIpRecord(LinkedHashMap<Long, WebAppIpRecord> paramLinkedHashMap, long paramLong)
  {
    if ((paramLinkedHashMap == null) || (paramLinkedHashMap.isEmpty()) || (paramLong == 0L)) {
      return paramLinkedHashMap;
    }
    WebAppIpRecord[] arrayOfWebAppIpRecord = (WebAppIpRecord[])paramLinkedHashMap.values().toArray(new WebAppIpRecord[paramLinkedHashMap.size()]);
    long l = System.currentTimeMillis();
    int k = arrayOfWebAppIpRecord.length;
    int i = 0;
    label53:
    WebAppIpRecord localWebAppIpRecord;
    WebAppIpRecord.FixedSizeLinkedHashMap localFixedSizeLinkedHashMap;
    if (i < k)
    {
      localWebAppIpRecord = arrayOfWebAppIpRecord[i];
      localFixedSizeLinkedHashMap = localWebAppIpRecord.serverIpMap;
      if (!localFixedSizeLinkedHashMap.isEmpty()) {
        break label91;
      }
    }
    for (;;)
    {
      i += 1;
      break label53;
      break;
      label91:
      Integer[] arrayOfInteger = (Integer[])localFixedSizeLinkedHashMap.keySet().toArray(new Integer[localFixedSizeLinkedHashMap.size()]);
      int m = arrayOfInteger.length;
      int j = 0;
      while (j < m)
      {
        Integer localInteger = arrayOfInteger[j];
        if (l - ((Long)localFixedSizeLinkedHashMap.get(localInteger)).longValue() > paramLong) {
          localFixedSizeLinkedHashMap.remove(localInteger);
        }
        if ((j == m - 1) && (localFixedSizeLinkedHashMap.isEmpty())) {
          paramLinkedHashMap.remove(Long.valueOf(localWebAppIpRecord.serverChangeTime));
        }
        j += 1;
      }
    }
  }
  
  public static WebAppIpManager getInstance()
  {
    return (WebAppIpManager)sSingleton.get(null);
  }
  
  public static boolean isValidServerInfo(QmfServerInfo paramQmfServerInfo)
  {
    if ((paramQmfServerInfo == null) || (paramQmfServerInfo.ipWebapp == null)) {}
    while ((paramQmfServerInfo.changeTime == 0L) || (paramQmfServerInfo.ipWebapp.ClientIpv4 == 0)) {
      return false;
    }
    return true;
  }
  
  public void addWebAppIpRecord(QmfServerInfo paramQmfServerInfo)
  {
    try
    {
      if (QZLog.isColorLevel()) {
        QZLog.d("WebAppIpManager", 2, "addWebAppIpRecord--changeTime:" + paramQmfServerInfo.changeTime + ", Ipv4:" + paramQmfServerInfo.ipWebapp.ClientIpv4);
      }
      if (this.webAppIpMap == null) {
        this.webAppIpMap = new LinkedHashMap();
      }
      WebAppIpRecord localWebAppIpRecord2 = (WebAppIpRecord)this.webAppIpMap.get(Long.valueOf(paramQmfServerInfo.changeTime));
      WebAppIpRecord localWebAppIpRecord1 = localWebAppIpRecord2;
      if (localWebAppIpRecord2 == null)
      {
        localWebAppIpRecord1 = new WebAppIpRecord();
        this.webAppIpMap.put(Long.valueOf(paramQmfServerInfo.changeTime), localWebAppIpRecord1);
      }
      localWebAppIpRecord1.serverChangeTime = paramQmfServerInfo.changeTime;
      localWebAppIpRecord1.addIpAdress(paramQmfServerInfo.ipWebapp.ClientIpv4);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void persistence()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 191	cooperation/qzone/statistic/serverip/WebAppIpManager:webAppIpMap	Ljava/util/LinkedHashMap;
    //   8: ifnull +17 -> 25
    //   11: aload_0
    //   12: getfield 191	cooperation/qzone/statistic/serverip/WebAppIpManager:webAppIpMap	Ljava/util/LinkedHashMap;
    //   15: invokevirtual 80	java/util/LinkedHashMap:isEmpty	()Z
    //   18: istore 4
    //   20: iload 4
    //   22: ifeq +6 -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: invokestatic 175	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   31: ifeq +34 -> 65
    //   34: ldc 11
    //   36: iconst_2
    //   37: new 34	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   44: ldc 209
    //   46: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_0
    //   50: getfield 191	cooperation/qzone/statistic/serverip/WebAppIpManager:webAppIpMap	Ljava/util/LinkedHashMap;
    //   53: invokevirtual 88	java/util/LinkedHashMap:size	()I
    //   56: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   59: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 189	cooperation/qzone/util/QZLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   65: aconst_null
    //   66: astore 6
    //   68: aconst_null
    //   69: astore 7
    //   71: aload 6
    //   73: astore 5
    //   75: invokestatic 214	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   78: ldc 216
    //   80: ldc 218
    //   82: bipush 60
    //   84: invokevirtual 222	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   87: istore_2
    //   88: aload 6
    //   90: astore 5
    //   92: aload_0
    //   93: aload_0
    //   94: getfield 191	cooperation/qzone/statistic/serverip/WebAppIpManager:webAppIpMap	Ljava/util/LinkedHashMap;
    //   97: iload_2
    //   98: sipush 1000
    //   101: imul
    //   102: i2l
    //   103: invokespecial 224	cooperation/qzone/statistic/serverip/WebAppIpManager:filterIpRecord	(Ljava/util/LinkedHashMap;J)Ljava/util/LinkedHashMap;
    //   106: astore 8
    //   108: aload 6
    //   110: astore 5
    //   112: invokestatic 175	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   115: ifeq +55 -> 170
    //   118: aload 6
    //   120: astore 5
    //   122: new 34	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   129: ldc 226
    //   131: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: astore 9
    //   136: aload 8
    //   138: ifnull +13 -> 151
    //   141: aload 6
    //   143: astore 5
    //   145: aload 8
    //   147: invokevirtual 88	java/util/LinkedHashMap:size	()I
    //   150: istore_1
    //   151: aload 6
    //   153: astore 5
    //   155: ldc 11
    //   157: iconst_2
    //   158: aload 9
    //   160: iload_1
    //   161: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   164: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 189	cooperation/qzone/util/QZLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload 6
    //   172: astore 5
    //   174: invokestatic 214	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   177: ldc 216
    //   179: ldc 228
    //   181: iconst_3
    //   182: invokevirtual 222	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   185: istore_1
    //   186: aload 6
    //   188: astore 5
    //   190: aload 8
    //   192: invokevirtual 229	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   195: aload 8
    //   197: invokevirtual 88	java/util/LinkedHashMap:size	()I
    //   200: anewarray 129	java/lang/Long
    //   203: invokeinterface 121 2 0
    //   208: checkcast 231	[Ljava/lang/Long;
    //   211: astore 10
    //   213: aload 6
    //   215: astore 5
    //   217: aload 10
    //   219: invokestatic 237	java/util/Arrays:sort	([Ljava/lang/Object;)V
    //   222: aload 6
    //   224: astore 5
    //   226: aload 10
    //   228: arraylength
    //   229: istore_3
    //   230: iload_1
    //   231: iload_3
    //   232: if_icmple +383 -> 615
    //   235: iload_3
    //   236: istore_1
    //   237: aload 6
    //   239: astore 5
    //   241: new 239	java/util/ArrayList
    //   244: dup
    //   245: invokespecial 240	java/util/ArrayList:<init>	()V
    //   248: astore 9
    //   250: iload_3
    //   251: iconst_1
    //   252: isub
    //   253: istore_2
    //   254: iload_2
    //   255: iload_3
    //   256: iload_1
    //   257: isub
    //   258: if_icmplt +29 -> 287
    //   261: aload 6
    //   263: astore 5
    //   265: aload 9
    //   267: aload 8
    //   269: aload 10
    //   271: iload_2
    //   272: aaload
    //   273: invokevirtual 193	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   276: invokevirtual 244	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   279: pop
    //   280: iload_2
    //   281: iconst_1
    //   282: isub
    //   283: istore_2
    //   284: goto -30 -> 254
    //   287: aload 6
    //   289: astore 5
    //   291: invokestatic 250	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   294: astore 8
    //   296: aload 6
    //   298: astore 5
    //   300: aload 8
    //   302: iconst_0
    //   303: invokevirtual 253	android/os/Parcel:setDataPosition	(I)V
    //   306: aload 6
    //   308: astore 5
    //   310: aload 8
    //   312: aload 9
    //   314: invokevirtual 254	java/util/ArrayList:size	()I
    //   317: invokevirtual 257	android/os/Parcel:writeInt	(I)V
    //   320: aload 6
    //   322: astore 5
    //   324: aload 9
    //   326: invokevirtual 261	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   329: astore 9
    //   331: aload 6
    //   333: astore 5
    //   335: aload 9
    //   337: invokeinterface 266 1 0
    //   342: ifeq +144 -> 486
    //   345: aload 6
    //   347: astore 5
    //   349: aload 9
    //   351: invokeinterface 270 1 0
    //   356: checkcast 90	cooperation/qzone/statistic/serverip/WebAppIpRecord
    //   359: astore 10
    //   361: aload 6
    //   363: astore 5
    //   365: invokestatic 175	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   368: ifeq +54 -> 422
    //   371: aload 6
    //   373: astore 5
    //   375: ldc 11
    //   377: iconst_2
    //   378: new 34	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   385: ldc_w 272
    //   388: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: aload 10
    //   393: getfield 139	cooperation/qzone/statistic/serverip/WebAppIpRecord:serverChangeTime	J
    //   396: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   399: ldc_w 274
    //   402: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: aload 10
    //   407: getfield 108	cooperation/qzone/statistic/serverip/WebAppIpRecord:serverIpMap	Lcooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap;
    //   410: invokevirtual 277	cooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap:toString	()Ljava/lang/String;
    //   413: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 280	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: aload 6
    //   424: astore 5
    //   426: aload 10
    //   428: aload 8
    //   430: iconst_0
    //   431: invokevirtual 284	cooperation/qzone/statistic/serverip/WebAppIpRecord:writeToParcel	(Landroid/os/Parcel;I)V
    //   434: goto -103 -> 331
    //   437: astore 5
    //   439: aload 7
    //   441: astore 6
    //   443: aload 5
    //   445: astore 7
    //   447: aload 6
    //   449: astore 5
    //   451: aload 7
    //   453: invokestatic 288	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   456: aload 6
    //   458: ifnull -433 -> 25
    //   461: aload 6
    //   463: invokevirtual 293	java/io/FileOutputStream:close	()V
    //   466: goto -441 -> 25
    //   469: astore 5
    //   471: aload 5
    //   473: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   476: goto -451 -> 25
    //   479: astore 5
    //   481: aload_0
    //   482: monitorexit
    //   483: aload 5
    //   485: athrow
    //   486: aload 6
    //   488: astore 5
    //   490: aload 8
    //   492: invokevirtual 300	android/os/Parcel:marshall	()[B
    //   495: astore 9
    //   497: aload 6
    //   499: astore 5
    //   501: aload 8
    //   503: invokevirtual 303	android/os/Parcel:recycle	()V
    //   506: aload 6
    //   508: astore 5
    //   510: aload_0
    //   511: invokespecial 305	cooperation/qzone/statistic/serverip/WebAppIpManager:createFile	()Ljava/io/File;
    //   514: astore 8
    //   516: aload 8
    //   518: ifnull +91 -> 609
    //   521: aload 6
    //   523: astore 5
    //   525: new 290	java/io/FileOutputStream
    //   528: dup
    //   529: aload 8
    //   531: invokespecial 308	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   534: astore 6
    //   536: aload 6
    //   538: aload 9
    //   540: invokevirtual 312	java/io/FileOutputStream:write	([B)V
    //   543: aload 6
    //   545: ifnull -520 -> 25
    //   548: aload 6
    //   550: invokevirtual 293	java/io/FileOutputStream:close	()V
    //   553: goto -528 -> 25
    //   556: astore 5
    //   558: aload 5
    //   560: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   563: goto -538 -> 25
    //   566: astore 7
    //   568: aload 5
    //   570: astore 6
    //   572: aload 7
    //   574: astore 5
    //   576: aload 6
    //   578: ifnull +8 -> 586
    //   581: aload 6
    //   583: invokevirtual 293	java/io/FileOutputStream:close	()V
    //   586: aload 5
    //   588: athrow
    //   589: astore 6
    //   591: aload 6
    //   593: invokevirtual 296	java/io/IOException:printStackTrace	()V
    //   596: goto -10 -> 586
    //   599: astore 5
    //   601: goto -25 -> 576
    //   604: astore 7
    //   606: goto -159 -> 447
    //   609: aconst_null
    //   610: astore 6
    //   612: goto -69 -> 543
    //   615: goto -378 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	618	0	this	WebAppIpManager
    //   1	257	1	i	int
    //   87	197	2	j	int
    //   229	29	3	k	int
    //   18	3	4	bool	boolean
    //   73	352	5	localObject1	Object
    //   437	7	5	localThrowable1	java.lang.Throwable
    //   449	1	5	localObject2	Object
    //   469	3	5	localIOException1	java.io.IOException
    //   479	5	5	localObject3	Object
    //   488	36	5	localObject4	Object
    //   556	13	5	localIOException2	java.io.IOException
    //   574	13	5	localObject5	Object
    //   599	1	5	localObject6	Object
    //   66	516	6	localObject7	Object
    //   589	3	6	localIOException3	java.io.IOException
    //   610	1	6	localObject8	Object
    //   69	383	7	localObject9	Object
    //   566	7	7	localObject10	Object
    //   604	1	7	localThrowable2	java.lang.Throwable
    //   106	424	8	localObject11	Object
    //   134	405	9	localObject12	Object
    //   211	216	10	localObject13	Object
    // Exception table:
    //   from	to	target	type
    //   75	88	437	java/lang/Throwable
    //   92	108	437	java/lang/Throwable
    //   112	118	437	java/lang/Throwable
    //   122	136	437	java/lang/Throwable
    //   145	151	437	java/lang/Throwable
    //   155	170	437	java/lang/Throwable
    //   174	186	437	java/lang/Throwable
    //   190	213	437	java/lang/Throwable
    //   217	222	437	java/lang/Throwable
    //   226	230	437	java/lang/Throwable
    //   241	250	437	java/lang/Throwable
    //   265	280	437	java/lang/Throwable
    //   291	296	437	java/lang/Throwable
    //   300	306	437	java/lang/Throwable
    //   310	320	437	java/lang/Throwable
    //   324	331	437	java/lang/Throwable
    //   335	345	437	java/lang/Throwable
    //   349	361	437	java/lang/Throwable
    //   365	371	437	java/lang/Throwable
    //   375	422	437	java/lang/Throwable
    //   426	434	437	java/lang/Throwable
    //   490	497	437	java/lang/Throwable
    //   501	506	437	java/lang/Throwable
    //   510	516	437	java/lang/Throwable
    //   525	536	437	java/lang/Throwable
    //   461	466	469	java/io/IOException
    //   4	20	479	finally
    //   28	65	479	finally
    //   461	466	479	finally
    //   471	476	479	finally
    //   548	553	479	finally
    //   558	563	479	finally
    //   581	586	479	finally
    //   586	589	479	finally
    //   591	596	479	finally
    //   548	553	556	java/io/IOException
    //   75	88	566	finally
    //   92	108	566	finally
    //   112	118	566	finally
    //   122	136	566	finally
    //   145	151	566	finally
    //   155	170	566	finally
    //   174	186	566	finally
    //   190	213	566	finally
    //   217	222	566	finally
    //   226	230	566	finally
    //   241	250	566	finally
    //   265	280	566	finally
    //   291	296	566	finally
    //   300	306	566	finally
    //   310	320	566	finally
    //   324	331	566	finally
    //   335	345	566	finally
    //   349	361	566	finally
    //   365	371	566	finally
    //   375	422	566	finally
    //   426	434	566	finally
    //   451	456	566	finally
    //   490	497	566	finally
    //   501	506	566	finally
    //   510	516	566	finally
    //   525	536	566	finally
    //   581	586	589	java/io/IOException
    //   536	543	599	finally
    //   536	543	604	java/lang/Throwable
  }
  
  /* Error */
  public void report()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aload_0
    //   7: monitorenter
    //   8: new 32	java/io/File
    //   11: dup
    //   12: new 34	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   19: ldc 37
    //   21: invokestatic 43	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   24: checkcast 37	com/tencent/qzonehub/api/report/lp/ILpReportUtils
    //   27: invokeinterface 47 1 0
    //   32: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: getstatic 54	java/io/File:separator	Ljava/lang/String;
    //   38: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc 8
    //   43: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   52: astore 4
    //   54: aload 4
    //   56: invokevirtual 64	java/io/File:exists	()Z
    //   59: ifeq +546 -> 605
    //   62: aload 4
    //   64: invokevirtual 318	java/io/File:length	()J
    //   67: l2i
    //   68: newarray byte
    //   70: astore 5
    //   72: new 320	java/io/FileInputStream
    //   75: dup
    //   76: aload 4
    //   78: invokespecial 321	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   81: astore_3
    //   82: aload_3
    //   83: aload 5
    //   85: invokevirtual 325	java/io/FileInputStream:read	([B)I
    //   88: pop
    //   89: aload 4
    //   91: invokestatic 331	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   94: pop
    //   95: aload 5
    //   97: ifnonnull +39 -> 136
    //   100: aload_3
    //   101: ifnull +7 -> 108
    //   104: aload_3
    //   105: invokevirtual 332	java/io/FileInputStream:close	()V
    //   108: iconst_0
    //   109: ifeq +11 -> 120
    //   112: new 334	java/lang/NullPointerException
    //   115: dup
    //   116: invokespecial 335	java/lang/NullPointerException:<init>	()V
    //   119: athrow
    //   120: aload_0
    //   121: monitorexit
    //   122: return
    //   123: astore_3
    //   124: aload_3
    //   125: invokestatic 288	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   128: goto -20 -> 108
    //   131: astore_3
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_3
    //   135: athrow
    //   136: invokestatic 250	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   139: astore 4
    //   141: aload 4
    //   143: aload 5
    //   145: iconst_0
    //   146: aload 5
    //   148: arraylength
    //   149: invokevirtual 339	android/os/Parcel:unmarshall	([BII)V
    //   152: aload 4
    //   154: iconst_0
    //   155: invokevirtual 253	android/os/Parcel:setDataPosition	(I)V
    //   158: aload 4
    //   160: invokevirtual 342	android/os/Parcel:readInt	()I
    //   163: istore_2
    //   164: invokestatic 175	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   167: ifeq +29 -> 196
    //   170: ldc 11
    //   172: iconst_2
    //   173: new 34	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 344
    //   183: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: iload_2
    //   187: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 280	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: new 239	java/util/ArrayList
    //   199: dup
    //   200: invokespecial 240	java/util/ArrayList:<init>	()V
    //   203: astore 5
    //   205: iconst_0
    //   206: istore_1
    //   207: iload_1
    //   208: iload_2
    //   209: if_icmpge +29 -> 238
    //   212: aload 5
    //   214: getstatic 348	cooperation/qzone/statistic/serverip/WebAppIpRecord:CREATOR	Landroid/os/Parcelable$Creator;
    //   217: aload 4
    //   219: invokeinterface 354 2 0
    //   224: checkcast 90	cooperation/qzone/statistic/serverip/WebAppIpRecord
    //   227: invokevirtual 244	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   230: pop
    //   231: iload_1
    //   232: iconst_1
    //   233: iadd
    //   234: istore_1
    //   235: goto -28 -> 207
    //   238: aload_3
    //   239: ifnull +7 -> 246
    //   242: aload_3
    //   243: invokevirtual 332	java/io/FileInputStream:close	()V
    //   246: aload 5
    //   248: astore_3
    //   249: aload 4
    //   251: ifnull +11 -> 262
    //   254: aload 4
    //   256: invokevirtual 303	android/os/Parcel:recycle	()V
    //   259: aload 5
    //   261: astore_3
    //   262: aload_3
    //   263: ifnull -143 -> 120
    //   266: aload_3
    //   267: invokevirtual 261	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   270: astore 6
    //   272: aload 6
    //   274: invokeinterface 266 1 0
    //   279: ifeq -159 -> 120
    //   282: aload 6
    //   284: invokeinterface 270 1 0
    //   289: checkcast 90	cooperation/qzone/statistic/serverip/WebAppIpRecord
    //   292: astore_3
    //   293: aload_3
    //   294: ifnull -22 -> 272
    //   297: aload_3
    //   298: getfield 108	cooperation/qzone/statistic/serverip/WebAppIpRecord:serverIpMap	Lcooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap;
    //   301: ifnull -29 -> 272
    //   304: aload_3
    //   305: getfield 108	cooperation/qzone/statistic/serverip/WebAppIpRecord:serverIpMap	Lcooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap;
    //   308: invokevirtual 355	cooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap:keySet	()Ljava/util/Set;
    //   311: invokeinterface 356 1 0
    //   316: astore 5
    //   318: aload 5
    //   320: invokeinterface 266 1 0
    //   325: ifeq -53 -> 272
    //   328: aload 5
    //   330: invokeinterface 270 1 0
    //   335: checkcast 118	java/lang/Integer
    //   338: astore 4
    //   340: invokestatic 175	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   343: ifeq +43 -> 386
    //   346: ldc 11
    //   348: iconst_2
    //   349: new 34	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   356: ldc_w 358
    //   359: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: aload 4
    //   364: invokevirtual 361	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   367: ldc_w 363
    //   370: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_3
    //   374: getfield 139	cooperation/qzone/statistic/serverip/WebAppIpRecord:serverChangeTime	J
    //   377: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   380: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   383: invokestatic 280	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   386: aload 4
    //   388: invokevirtual 366	java/lang/Integer:intValue	()I
    //   391: aload_3
    //   392: getfield 139	cooperation/qzone/statistic/serverip/WebAppIpRecord:serverChangeTime	J
    //   395: invokestatic 371	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   398: invokestatic 377	cooperation/qzone/statistic/AccManager:reportCrashRelatedServerIP	(ILjava/lang/String;)V
    //   401: goto -83 -> 318
    //   404: astore_3
    //   405: aload_3
    //   406: invokestatic 288	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   409: goto -163 -> 246
    //   412: astore 5
    //   414: aconst_null
    //   415: astore_3
    //   416: aconst_null
    //   417: astore 4
    //   419: aload 5
    //   421: invokestatic 288	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   424: aload 4
    //   426: ifnull +8 -> 434
    //   429: aload 4
    //   431: invokevirtual 332	java/io/FileInputStream:close	()V
    //   434: aload 6
    //   436: ifnull +166 -> 602
    //   439: aload 6
    //   441: invokevirtual 303	android/os/Parcel:recycle	()V
    //   444: goto -182 -> 262
    //   447: astore 4
    //   449: aload 4
    //   451: invokestatic 288	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   454: goto -20 -> 434
    //   457: astore 4
    //   459: aconst_null
    //   460: astore_3
    //   461: aload 7
    //   463: astore 6
    //   465: aload_3
    //   466: ifnull +7 -> 473
    //   469: aload_3
    //   470: invokevirtual 332	java/io/FileInputStream:close	()V
    //   473: aload 6
    //   475: ifnull +8 -> 483
    //   478: aload 6
    //   480: invokevirtual 303	android/os/Parcel:recycle	()V
    //   483: aload 4
    //   485: athrow
    //   486: astore_3
    //   487: aload_3
    //   488: invokestatic 288	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   491: goto -18 -> 473
    //   494: astore 4
    //   496: aload 7
    //   498: astore 6
    //   500: goto -35 -> 465
    //   503: astore 4
    //   505: aload 7
    //   507: astore 6
    //   509: goto -44 -> 465
    //   512: astore 5
    //   514: aload 4
    //   516: astore 6
    //   518: aload 5
    //   520: astore 4
    //   522: goto -57 -> 465
    //   525: astore 5
    //   527: aload 4
    //   529: astore_3
    //   530: aload 5
    //   532: astore 4
    //   534: goto -69 -> 465
    //   537: astore 5
    //   539: aload_3
    //   540: astore 4
    //   542: aconst_null
    //   543: astore_3
    //   544: goto -125 -> 419
    //   547: astore 5
    //   549: aconst_null
    //   550: astore 7
    //   552: aload_3
    //   553: astore 4
    //   555: aload 7
    //   557: astore_3
    //   558: goto -139 -> 419
    //   561: astore 5
    //   563: aload_3
    //   564: astore 7
    //   566: aconst_null
    //   567: astore_3
    //   568: aload 4
    //   570: astore 6
    //   572: aload 7
    //   574: astore 4
    //   576: goto -157 -> 419
    //   579: astore 8
    //   581: aload 4
    //   583: astore 6
    //   585: aload 5
    //   587: astore 7
    //   589: aload_3
    //   590: astore 4
    //   592: aload 8
    //   594: astore 5
    //   596: aload 7
    //   598: astore_3
    //   599: goto -180 -> 419
    //   602: goto -340 -> 262
    //   605: aconst_null
    //   606: astore 5
    //   608: aconst_null
    //   609: astore_3
    //   610: goto -515 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	this	WebAppIpManager
    //   206	29	1	i	int
    //   163	47	2	j	int
    //   81	24	3	localFileInputStream	java.io.FileInputStream
    //   123	2	3	localIOException1	java.io.IOException
    //   131	112	3	localObject1	Object
    //   248	144	3	localObject2	Object
    //   404	2	3	localIOException2	java.io.IOException
    //   415	55	3	localObject3	Object
    //   486	2	3	localIOException3	java.io.IOException
    //   529	81	3	localObject4	Object
    //   52	378	4	localObject5	Object
    //   447	3	4	localIOException4	java.io.IOException
    //   457	27	4	localObject6	Object
    //   494	1	4	localObject7	Object
    //   503	12	4	localObject8	Object
    //   520	71	4	localObject9	Object
    //   70	259	5	localObject10	Object
    //   412	8	5	localException1	java.lang.Exception
    //   512	7	5	localObject11	Object
    //   525	6	5	localObject12	Object
    //   537	1	5	localException2	java.lang.Exception
    //   547	1	5	localException3	java.lang.Exception
    //   561	25	5	localException4	java.lang.Exception
    //   594	13	5	localObject13	Object
    //   4	580	6	localObject14	Object
    //   1	596	7	localObject15	Object
    //   579	14	8	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   104	108	123	java/io/IOException
    //   104	108	131	finally
    //   112	120	131	finally
    //   124	128	131	finally
    //   242	246	131	finally
    //   254	259	131	finally
    //   266	272	131	finally
    //   272	293	131	finally
    //   297	318	131	finally
    //   318	386	131	finally
    //   386	401	131	finally
    //   405	409	131	finally
    //   429	434	131	finally
    //   439	444	131	finally
    //   449	454	131	finally
    //   469	473	131	finally
    //   478	483	131	finally
    //   483	486	131	finally
    //   487	491	131	finally
    //   242	246	404	java/io/IOException
    //   8	82	412	java/lang/Exception
    //   429	434	447	java/io/IOException
    //   8	82	457	finally
    //   469	473	486	java/io/IOException
    //   82	95	494	finally
    //   136	141	503	finally
    //   141	196	512	finally
    //   196	205	512	finally
    //   212	231	512	finally
    //   419	424	525	finally
    //   82	95	537	java/lang/Exception
    //   136	141	547	java/lang/Exception
    //   141	196	561	java/lang/Exception
    //   196	205	561	java/lang/Exception
    //   212	231	579	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.statistic.serverip.WebAppIpManager
 * JD-Core Version:    0.7.0.1
 */