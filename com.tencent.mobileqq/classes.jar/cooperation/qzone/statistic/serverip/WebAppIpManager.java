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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(((ILpReportUtils)QRoute.api(ILpReportUtils.class)).getInternalCacheDir());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("webapp_iplist");
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      if (!((File)localObject).getParentFile().exists())
      {
        if (((File)localObject).getParentFile().mkdirs())
        {
          ((File)localObject).createNewFile();
          return localObject;
        }
      }
      else {
        ((File)localObject).createNewFile();
      }
    }
    return localObject;
  }
  
  private LinkedHashMap<Long, WebAppIpRecord> filterIpRecord(LinkedHashMap<Long, WebAppIpRecord> paramLinkedHashMap, long paramLong)
  {
    if ((paramLinkedHashMap != null) && (!paramLinkedHashMap.isEmpty()))
    {
      if (paramLong == 0L) {
        return paramLinkedHashMap;
      }
      WebAppIpRecord[] arrayOfWebAppIpRecord = (WebAppIpRecord[])paramLinkedHashMap.values().toArray(new WebAppIpRecord[paramLinkedHashMap.size()]);
      long l = System.currentTimeMillis();
      int k = arrayOfWebAppIpRecord.length;
      int i = 0;
      while (i < k)
      {
        WebAppIpRecord localWebAppIpRecord = arrayOfWebAppIpRecord[i];
        WebAppIpRecord.FixedSizeLinkedHashMap localFixedSizeLinkedHashMap = localWebAppIpRecord.serverIpMap;
        if (!localFixedSizeLinkedHashMap.isEmpty())
        {
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
        i += 1;
      }
    }
    return paramLinkedHashMap;
  }
  
  public static WebAppIpManager getInstance()
  {
    return (WebAppIpManager)sSingleton.get(null);
  }
  
  public static boolean isValidServerInfo(QmfServerInfo paramQmfServerInfo)
  {
    if (paramQmfServerInfo != null)
    {
      if (paramQmfServerInfo.ipWebapp == null) {
        return false;
      }
      if (paramQmfServerInfo.changeTime == 0L) {
        return false;
      }
      return paramQmfServerInfo.ipWebapp.ClientIpv4 != 0;
    }
    return false;
  }
  
  public void addWebAppIpRecord(QmfServerInfo paramQmfServerInfo)
  {
    try
    {
      if (QZLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addWebAppIpRecord--changeTime:");
        ((StringBuilder)localObject).append(paramQmfServerInfo.changeTime);
        ((StringBuilder)localObject).append(", Ipv4:");
        ((StringBuilder)localObject).append(paramQmfServerInfo.ipWebapp.ClientIpv4);
        QZLog.d("WebAppIpManager", 2, ((StringBuilder)localObject).toString());
      }
      if (this.webAppIpMap == null) {
        this.webAppIpMap = new LinkedHashMap();
      }
      WebAppIpRecord localWebAppIpRecord = (WebAppIpRecord)this.webAppIpMap.get(Long.valueOf(paramQmfServerInfo.changeTime));
      Object localObject = localWebAppIpRecord;
      if (localWebAppIpRecord == null)
      {
        localObject = new WebAppIpRecord();
        this.webAppIpMap.put(Long.valueOf(paramQmfServerInfo.changeTime), localObject);
      }
      ((WebAppIpRecord)localObject).serverChangeTime = paramQmfServerInfo.changeTime;
      ((WebAppIpRecord)localObject).addIpAdress(paramQmfServerInfo.ipWebapp.ClientIpv4);
      return;
    }
    finally {}
  }
  
  /* Error */
  public void persistence()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 191	cooperation/qzone/statistic/serverip/WebAppIpManager:webAppIpMap	Ljava/util/LinkedHashMap;
    //   6: ifnull +666 -> 672
    //   9: aload_0
    //   10: getfield 191	cooperation/qzone/statistic/serverip/WebAppIpManager:webAppIpMap	Ljava/util/LinkedHashMap;
    //   13: invokevirtual 80	java/util/LinkedHashMap:isEmpty	()Z
    //   16: ifeq +6 -> 22
    //   19: goto +653 -> 672
    //   22: invokestatic 175	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   25: ifeq +44 -> 69
    //   28: new 32	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   35: astore 4
    //   37: aload 4
    //   39: ldc 209
    //   41: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 4
    //   47: aload_0
    //   48: getfield 191	cooperation/qzone/statistic/serverip/WebAppIpManager:webAppIpMap	Ljava/util/LinkedHashMap;
    //   51: invokevirtual 88	java/util/LinkedHashMap:size	()I
    //   54: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: ldc 11
    //   60: iconst_2
    //   61: aload 4
    //   63: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 189	cooperation/qzone/util/QZLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aconst_null
    //   70: astore 5
    //   72: aconst_null
    //   73: astore 7
    //   75: aconst_null
    //   76: astore 6
    //   78: aload 5
    //   80: astore 4
    //   82: invokestatic 214	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   85: ldc 216
    //   87: ldc 218
    //   89: bipush 60
    //   91: invokevirtual 222	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   94: istore_1
    //   95: aload 5
    //   97: astore 4
    //   99: aload_0
    //   100: aload_0
    //   101: getfield 191	cooperation/qzone/statistic/serverip/WebAppIpManager:webAppIpMap	Ljava/util/LinkedHashMap;
    //   104: iload_1
    //   105: sipush 1000
    //   108: imul
    //   109: i2l
    //   110: invokespecial 224	cooperation/qzone/statistic/serverip/WebAppIpManager:filterIpRecord	(Ljava/util/LinkedHashMap;J)Ljava/util/LinkedHashMap;
    //   113: astore 8
    //   115: aload 5
    //   117: astore 4
    //   119: invokestatic 175	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   122: ifeq +72 -> 194
    //   125: aload 5
    //   127: astore 4
    //   129: new 32	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   136: astore 9
    //   138: aload 5
    //   140: astore 4
    //   142: aload 9
    //   144: ldc 226
    //   146: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 8
    //   152: ifnull +536 -> 688
    //   155: aload 5
    //   157: astore 4
    //   159: aload 8
    //   161: invokevirtual 88	java/util/LinkedHashMap:size	()I
    //   164: istore_1
    //   165: goto +3 -> 168
    //   168: aload 5
    //   170: astore 4
    //   172: aload 9
    //   174: iload_1
    //   175: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 5
    //   181: astore 4
    //   183: ldc 11
    //   185: iconst_2
    //   186: aload 9
    //   188: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   191: invokestatic 189	cooperation/qzone/util/QZLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   194: aload 5
    //   196: astore 4
    //   198: invokestatic 214	common/config/service/QzoneConfig:getInstance	()Lcommon/config/service/QzoneConfig;
    //   201: ldc 216
    //   203: ldc 228
    //   205: iconst_3
    //   206: invokevirtual 222	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   209: istore_2
    //   210: aload 5
    //   212: astore 4
    //   214: aload 8
    //   216: invokevirtual 229	java/util/LinkedHashMap:keySet	()Ljava/util/Set;
    //   219: aload 8
    //   221: invokevirtual 88	java/util/LinkedHashMap:size	()I
    //   224: anewarray 129	java/lang/Long
    //   227: invokeinterface 121 2 0
    //   232: checkcast 231	[Ljava/lang/Long;
    //   235: astore 10
    //   237: aload 5
    //   239: astore 4
    //   241: aload 10
    //   243: invokestatic 237	java/util/Arrays:sort	([Ljava/lang/Object;)V
    //   246: aload 5
    //   248: astore 4
    //   250: aload 10
    //   252: arraylength
    //   253: istore_3
    //   254: iload_2
    //   255: istore_1
    //   256: iload_2
    //   257: iload_3
    //   258: if_icmple +5 -> 263
    //   261: iload_3
    //   262: istore_1
    //   263: aload 5
    //   265: astore 4
    //   267: new 239	java/util/ArrayList
    //   270: dup
    //   271: invokespecial 240	java/util/ArrayList:<init>	()V
    //   274: astore 9
    //   276: iload_3
    //   277: iconst_1
    //   278: isub
    //   279: istore_2
    //   280: iload_2
    //   281: iload_3
    //   282: iload_1
    //   283: isub
    //   284: if_icmplt +29 -> 313
    //   287: aload 5
    //   289: astore 4
    //   291: aload 9
    //   293: aload 8
    //   295: aload 10
    //   297: iload_2
    //   298: aaload
    //   299: invokevirtual 193	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   302: invokevirtual 244	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   305: pop
    //   306: iload_2
    //   307: iconst_1
    //   308: isub
    //   309: istore_2
    //   310: goto -30 -> 280
    //   313: aload 5
    //   315: astore 4
    //   317: invokestatic 250	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   320: astore 8
    //   322: aload 5
    //   324: astore 4
    //   326: aload 8
    //   328: iconst_0
    //   329: invokevirtual 253	android/os/Parcel:setDataPosition	(I)V
    //   332: aload 5
    //   334: astore 4
    //   336: aload 8
    //   338: aload 9
    //   340: invokevirtual 254	java/util/ArrayList:size	()I
    //   343: invokevirtual 257	android/os/Parcel:writeInt	(I)V
    //   346: aload 5
    //   348: astore 4
    //   350: aload 9
    //   352: invokevirtual 261	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   355: astore 9
    //   357: aload 5
    //   359: astore 4
    //   361: aload 9
    //   363: invokeinterface 266 1 0
    //   368: ifeq +131 -> 499
    //   371: aload 5
    //   373: astore 4
    //   375: aload 9
    //   377: invokeinterface 270 1 0
    //   382: checkcast 90	cooperation/qzone/statistic/serverip/WebAppIpRecord
    //   385: astore 10
    //   387: aload 5
    //   389: astore 4
    //   391: invokestatic 175	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   394: ifeq +90 -> 484
    //   397: aload 5
    //   399: astore 4
    //   401: new 32	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   408: astore 11
    //   410: aload 5
    //   412: astore 4
    //   414: aload 11
    //   416: ldc_w 272
    //   419: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: aload 5
    //   425: astore 4
    //   427: aload 11
    //   429: aload 10
    //   431: getfield 139	cooperation/qzone/statistic/serverip/WebAppIpRecord:serverChangeTime	J
    //   434: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload 5
    //   440: astore 4
    //   442: aload 11
    //   444: ldc_w 274
    //   447: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload 5
    //   453: astore 4
    //   455: aload 11
    //   457: aload 10
    //   459: getfield 108	cooperation/qzone/statistic/serverip/WebAppIpRecord:serverIpMap	Lcooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap;
    //   462: invokevirtual 277	cooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap:toString	()Ljava/lang/String;
    //   465: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: pop
    //   469: aload 5
    //   471: astore 4
    //   473: ldc 11
    //   475: iconst_2
    //   476: aload 11
    //   478: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   481: invokestatic 280	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   484: aload 5
    //   486: astore 4
    //   488: aload 10
    //   490: aload 8
    //   492: iconst_0
    //   493: invokevirtual 284	cooperation/qzone/statistic/serverip/WebAppIpRecord:writeToParcel	(Landroid/os/Parcel;I)V
    //   496: goto -139 -> 357
    //   499: aload 5
    //   501: astore 4
    //   503: aload 8
    //   505: invokevirtual 288	android/os/Parcel:marshall	()[B
    //   508: astore 9
    //   510: aload 5
    //   512: astore 4
    //   514: aload 8
    //   516: invokevirtual 291	android/os/Parcel:recycle	()V
    //   519: aload 5
    //   521: astore 4
    //   523: aload_0
    //   524: invokespecial 293	cooperation/qzone/statistic/serverip/WebAppIpManager:createFile	()Ljava/io/File;
    //   527: astore 8
    //   529: aload 6
    //   531: astore 4
    //   533: aload 8
    //   535: ifnull +50 -> 585
    //   538: aload 5
    //   540: astore 4
    //   542: new 295	java/io/FileOutputStream
    //   545: dup
    //   546: aload 8
    //   548: invokespecial 298	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   551: astore 5
    //   553: aload 5
    //   555: aload 9
    //   557: invokevirtual 302	java/io/FileOutputStream:write	([B)V
    //   560: aload 5
    //   562: astore 4
    //   564: goto +21 -> 585
    //   567: astore 6
    //   569: aload 5
    //   571: astore 4
    //   573: aload 6
    //   575: astore 5
    //   577: goto +72 -> 649
    //   580: astore 6
    //   582: goto +37 -> 619
    //   585: aload 4
    //   587: ifnull +59 -> 646
    //   590: aload 4
    //   592: invokevirtual 305	java/io/FileOutputStream:close	()V
    //   595: goto +51 -> 646
    //   598: astore 4
    //   600: aload 4
    //   602: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   605: goto +41 -> 646
    //   608: astore 5
    //   610: goto +39 -> 649
    //   613: astore 6
    //   615: aload 7
    //   617: astore 5
    //   619: aload 5
    //   621: astore 4
    //   623: aload 6
    //   625: invokestatic 312	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   628: aload 5
    //   630: ifnull +16 -> 646
    //   633: aload 5
    //   635: invokevirtual 305	java/io/FileOutputStream:close	()V
    //   638: goto +8 -> 646
    //   641: astore 4
    //   643: goto -43 -> 600
    //   646: aload_0
    //   647: monitorexit
    //   648: return
    //   649: aload 4
    //   651: ifnull +18 -> 669
    //   654: aload 4
    //   656: invokevirtual 305	java/io/FileOutputStream:close	()V
    //   659: goto +10 -> 669
    //   662: astore 4
    //   664: aload 4
    //   666: invokevirtual 308	java/io/IOException:printStackTrace	()V
    //   669: aload 5
    //   671: athrow
    //   672: aload_0
    //   673: monitorexit
    //   674: return
    //   675: astore 4
    //   677: aload_0
    //   678: monitorexit
    //   679: goto +6 -> 685
    //   682: aload 4
    //   684: athrow
    //   685: goto -3 -> 682
    //   688: iconst_0
    //   689: istore_1
    //   690: goto -522 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	693	0	this	WebAppIpManager
    //   94	596	1	i	int
    //   209	101	2	j	int
    //   253	31	3	k	int
    //   35	556	4	localObject1	Object
    //   598	3	4	localIOException1	java.io.IOException
    //   621	1	4	localObject2	Object
    //   641	14	4	localIOException2	java.io.IOException
    //   662	3	4	localIOException3	java.io.IOException
    //   675	8	4	localObject3	Object
    //   70	506	5	localObject4	Object
    //   608	1	5	localObject5	Object
    //   617	53	5	localObject6	Object
    //   76	454	6	localObject7	Object
    //   567	7	6	localObject8	Object
    //   580	1	6	localThrowable1	java.lang.Throwable
    //   613	11	6	localThrowable2	java.lang.Throwable
    //   73	543	7	localObject9	Object
    //   113	434	8	localObject10	Object
    //   136	420	9	localObject11	Object
    //   235	254	10	localObject12	Object
    //   408	69	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   553	560	567	finally
    //   553	560	580	java/lang/Throwable
    //   590	595	598	java/io/IOException
    //   82	95	608	finally
    //   99	115	608	finally
    //   119	125	608	finally
    //   129	138	608	finally
    //   142	150	608	finally
    //   159	165	608	finally
    //   172	179	608	finally
    //   183	194	608	finally
    //   198	210	608	finally
    //   214	237	608	finally
    //   241	246	608	finally
    //   250	254	608	finally
    //   267	276	608	finally
    //   291	306	608	finally
    //   317	322	608	finally
    //   326	332	608	finally
    //   336	346	608	finally
    //   350	357	608	finally
    //   361	371	608	finally
    //   375	387	608	finally
    //   391	397	608	finally
    //   401	410	608	finally
    //   414	423	608	finally
    //   427	438	608	finally
    //   442	451	608	finally
    //   455	469	608	finally
    //   473	484	608	finally
    //   488	496	608	finally
    //   503	510	608	finally
    //   514	519	608	finally
    //   523	529	608	finally
    //   542	553	608	finally
    //   623	628	608	finally
    //   82	95	613	java/lang/Throwable
    //   99	115	613	java/lang/Throwable
    //   119	125	613	java/lang/Throwable
    //   129	138	613	java/lang/Throwable
    //   142	150	613	java/lang/Throwable
    //   159	165	613	java/lang/Throwable
    //   172	179	613	java/lang/Throwable
    //   183	194	613	java/lang/Throwable
    //   198	210	613	java/lang/Throwable
    //   214	237	613	java/lang/Throwable
    //   241	246	613	java/lang/Throwable
    //   250	254	613	java/lang/Throwable
    //   267	276	613	java/lang/Throwable
    //   291	306	613	java/lang/Throwable
    //   317	322	613	java/lang/Throwable
    //   326	332	613	java/lang/Throwable
    //   336	346	613	java/lang/Throwable
    //   350	357	613	java/lang/Throwable
    //   361	371	613	java/lang/Throwable
    //   375	387	613	java/lang/Throwable
    //   391	397	613	java/lang/Throwable
    //   401	410	613	java/lang/Throwable
    //   414	423	613	java/lang/Throwable
    //   427	438	613	java/lang/Throwable
    //   442	451	613	java/lang/Throwable
    //   455	469	613	java/lang/Throwable
    //   473	484	613	java/lang/Throwable
    //   488	496	613	java/lang/Throwable
    //   503	510	613	java/lang/Throwable
    //   514	519	613	java/lang/Throwable
    //   523	529	613	java/lang/Throwable
    //   542	553	613	java/lang/Throwable
    //   633	638	641	java/io/IOException
    //   654	659	662	java/io/IOException
    //   2	19	675	finally
    //   22	69	675	finally
    //   590	595	675	finally
    //   600	605	675	finally
    //   633	638	675	finally
    //   654	659	675	finally
    //   664	669	675	finally
    //   669	672	675	finally
  }
  
  /* Error */
  public void report()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 8
    //   5: aconst_null
    //   6: astore 7
    //   8: new 32	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   15: astore_3
    //   16: aload_3
    //   17: ldc 35
    //   19: invokestatic 41	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   22: checkcast 35	com/tencent/qzonehub/api/report/lp/ILpReportUtils
    //   25: invokeinterface 45 1 0
    //   30: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_3
    //   35: getstatic 54	java/io/File:separator	Ljava/lang/String;
    //   38: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_3
    //   43: ldc 8
    //   45: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: new 51	java/io/File
    //   52: dup
    //   53: aload_3
    //   54: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore 9
    //   62: aload 9
    //   64: invokevirtual 64	java/io/File:exists	()Z
    //   67: ifeq +55 -> 122
    //   70: aload 9
    //   72: invokevirtual 318	java/io/File:length	()J
    //   75: l2i
    //   76: newarray byte
    //   78: astore 4
    //   80: new 320	java/io/FileInputStream
    //   83: dup
    //   84: aload 9
    //   86: invokespecial 321	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   89: astore_3
    //   90: aload_3
    //   91: astore 6
    //   93: aload_3
    //   94: astore 5
    //   96: aload_3
    //   97: aload 4
    //   99: invokevirtual 325	java/io/FileInputStream:read	([B)I
    //   102: pop
    //   103: aload_3
    //   104: astore 6
    //   106: aload_3
    //   107: astore 5
    //   109: aload 9
    //   111: invokestatic 331	cooperation/qzone/util/FileUtils:deleteFile	(Ljava/io/File;)Z
    //   114: pop
    //   115: aload 4
    //   117: astore 7
    //   119: goto +9 -> 128
    //   122: aconst_null
    //   123: astore 7
    //   125: aload 7
    //   127: astore_3
    //   128: aload 7
    //   130: ifnonnull +22 -> 152
    //   133: aload_3
    //   134: ifnull +15 -> 149
    //   137: aload_3
    //   138: invokevirtual 332	java/io/FileInputStream:close	()V
    //   141: goto +8 -> 149
    //   144: astore_3
    //   145: aload_3
    //   146: invokestatic 312	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   149: aload_0
    //   150: monitorexit
    //   151: return
    //   152: aload_3
    //   153: astore 6
    //   155: aload_3
    //   156: astore 5
    //   158: invokestatic 250	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   161: astore 4
    //   163: aload 7
    //   165: arraylength
    //   166: istore_2
    //   167: iconst_0
    //   168: istore_1
    //   169: aload 4
    //   171: aload 7
    //   173: iconst_0
    //   174: iload_2
    //   175: invokevirtual 336	android/os/Parcel:unmarshall	([BII)V
    //   178: aload 4
    //   180: iconst_0
    //   181: invokevirtual 253	android/os/Parcel:setDataPosition	(I)V
    //   184: aload 4
    //   186: invokevirtual 339	android/os/Parcel:readInt	()I
    //   189: istore_2
    //   190: invokestatic 175	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   193: ifeq +39 -> 232
    //   196: new 32	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   203: astore 5
    //   205: aload 5
    //   207: ldc_w 341
    //   210: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 5
    //   216: iload_2
    //   217: invokevirtual 185	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: ldc 11
    //   223: iconst_2
    //   224: aload 5
    //   226: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 280	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: new 239	java/util/ArrayList
    //   235: dup
    //   236: invokespecial 240	java/util/ArrayList:<init>	()V
    //   239: astore 7
    //   241: iload_1
    //   242: iload_2
    //   243: if_icmpge +42 -> 285
    //   246: aload 7
    //   248: getstatic 345	cooperation/qzone/statistic/serverip/WebAppIpRecord:CREATOR	Landroid/os/Parcelable$Creator;
    //   251: aload 4
    //   253: invokeinterface 351 2 0
    //   258: checkcast 90	cooperation/qzone/statistic/serverip/WebAppIpRecord
    //   261: invokevirtual 244	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   264: pop
    //   265: iload_1
    //   266: iconst_1
    //   267: iadd
    //   268: istore_1
    //   269: goto -28 -> 241
    //   272: astore 5
    //   274: aload 4
    //   276: astore 6
    //   278: aload 7
    //   280: astore 4
    //   282: goto +89 -> 371
    //   285: aload_3
    //   286: ifnull +366 -> 652
    //   289: aload_3
    //   290: invokevirtual 332	java/io/FileInputStream:close	()V
    //   293: goto +359 -> 652
    //   296: astore_3
    //   297: aload_3
    //   298: invokestatic 312	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   301: goto +351 -> 652
    //   304: aload_3
    //   305: invokevirtual 291	android/os/Parcel:recycle	()V
    //   308: aload 4
    //   310: astore 5
    //   312: goto +114 -> 426
    //   315: astore 5
    //   317: aload 4
    //   319: astore 6
    //   321: aload_3
    //   322: astore 4
    //   324: goto +280 -> 604
    //   327: astore 5
    //   329: aconst_null
    //   330: astore 7
    //   332: aload 4
    //   334: astore 6
    //   336: aload 7
    //   338: astore 4
    //   340: goto +31 -> 371
    //   343: astore 5
    //   345: aload 8
    //   347: astore_3
    //   348: aload 6
    //   350: astore 4
    //   352: goto +255 -> 607
    //   355: astore 7
    //   357: aconst_null
    //   358: astore 6
    //   360: aload 6
    //   362: astore 4
    //   364: aload 5
    //   366: astore_3
    //   367: aload 7
    //   369: astore 5
    //   371: aload_3
    //   372: astore 7
    //   374: aload 6
    //   376: astore_3
    //   377: goto +21 -> 398
    //   380: astore 5
    //   382: aconst_null
    //   383: astore 4
    //   385: aload 8
    //   387: astore_3
    //   388: goto +219 -> 607
    //   391: astore 5
    //   393: aconst_null
    //   394: astore_3
    //   395: aload_3
    //   396: astore 4
    //   398: aload 5
    //   400: invokestatic 312	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   403: aload 7
    //   405: ifnull +266 -> 671
    //   408: aload 7
    //   410: invokevirtual 332	java/io/FileInputStream:close	()V
    //   413: goto +258 -> 671
    //   416: astore 5
    //   418: aload 5
    //   420: invokestatic 312	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   423: goto +248 -> 671
    //   426: aload 5
    //   428: ifnull +164 -> 592
    //   431: aload 5
    //   433: invokevirtual 261	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   436: astore_3
    //   437: aload_3
    //   438: invokeinterface 266 1 0
    //   443: ifeq +149 -> 592
    //   446: aload_3
    //   447: invokeinterface 270 1 0
    //   452: checkcast 90	cooperation/qzone/statistic/serverip/WebAppIpRecord
    //   455: astore 4
    //   457: aload 4
    //   459: ifnull -22 -> 437
    //   462: aload 4
    //   464: getfield 108	cooperation/qzone/statistic/serverip/WebAppIpRecord:serverIpMap	Lcooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap;
    //   467: ifnonnull +6 -> 473
    //   470: goto -33 -> 437
    //   473: aload 4
    //   475: getfield 108	cooperation/qzone/statistic/serverip/WebAppIpRecord:serverIpMap	Lcooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap;
    //   478: invokevirtual 352	cooperation/qzone/statistic/serverip/WebAppIpRecord$FixedSizeLinkedHashMap:keySet	()Ljava/util/Set;
    //   481: invokeinterface 353 1 0
    //   486: astore 5
    //   488: aload 5
    //   490: invokeinterface 266 1 0
    //   495: ifeq -58 -> 437
    //   498: aload 5
    //   500: invokeinterface 270 1 0
    //   505: checkcast 118	java/lang/Integer
    //   508: astore 6
    //   510: invokestatic 175	cooperation/qzone/util/QZLog:isColorLevel	()Z
    //   513: ifeq +60 -> 573
    //   516: new 32	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   523: astore 7
    //   525: aload 7
    //   527: ldc_w 355
    //   530: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: aload 7
    //   536: aload 6
    //   538: invokevirtual 358	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload 7
    //   544: ldc_w 360
    //   547: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload 7
    //   553: aload 4
    //   555: getfield 139	cooperation/qzone/statistic/serverip/WebAppIpRecord:serverChangeTime	J
    //   558: invokevirtual 180	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: ldc 11
    //   564: iconst_2
    //   565: aload 7
    //   567: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 280	cooperation/qzone/util/QZLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: aload 6
    //   575: invokevirtual 363	java/lang/Integer:intValue	()I
    //   578: aload 4
    //   580: getfield 139	cooperation/qzone/statistic/serverip/WebAppIpRecord:serverChangeTime	J
    //   583: invokestatic 368	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   586: invokestatic 374	cooperation/qzone/statistic/AccManager:reportCrashRelatedServerIP	(ILjava/lang/String;)V
    //   589: goto -101 -> 488
    //   592: aload_0
    //   593: monitorexit
    //   594: return
    //   595: astore 5
    //   597: aload 7
    //   599: astore 4
    //   601: aload_3
    //   602: astore 6
    //   604: aload 6
    //   606: astore_3
    //   607: aload 4
    //   609: ifnull +22 -> 631
    //   612: aload 4
    //   614: invokevirtual 332	java/io/FileInputStream:close	()V
    //   617: goto +14 -> 631
    //   620: astore_3
    //   621: goto +21 -> 642
    //   624: astore 4
    //   626: aload 4
    //   628: invokestatic 312	cooperation/qzone/util/QZLog:w	(Ljava/lang/Throwable;)V
    //   631: aload_3
    //   632: ifnull +7 -> 639
    //   635: aload_3
    //   636: invokevirtual 291	android/os/Parcel:recycle	()V
    //   639: aload 5
    //   641: athrow
    //   642: aload_0
    //   643: monitorexit
    //   644: goto +5 -> 649
    //   647: aload_3
    //   648: athrow
    //   649: goto -2 -> 647
    //   652: aload 7
    //   654: astore 5
    //   656: aload 4
    //   658: ifnull -232 -> 426
    //   661: aload 4
    //   663: astore_3
    //   664: aload 7
    //   666: astore 4
    //   668: goto -364 -> 304
    //   671: aload 4
    //   673: astore 5
    //   675: aload_3
    //   676: ifnull -250 -> 426
    //   679: goto -375 -> 304
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	682	0	this	WebAppIpManager
    //   168	101	1	i	int
    //   166	78	2	j	int
    //   15	123	3	localObject1	Object
    //   144	146	3	localIOException1	java.io.IOException
    //   296	26	3	localIOException2	java.io.IOException
    //   347	260	3	localObject2	Object
    //   620	28	3	localObject3	Object
    //   663	13	3	localObject4	Object
    //   78	535	4	localObject5	Object
    //   624	38	4	localIOException3	java.io.IOException
    //   666	6	4	localObject6	Object
    //   94	131	5	localObject7	Object
    //   272	1	5	localException1	java.lang.Exception
    //   310	1	5	localObject8	Object
    //   315	1	5	localObject9	Object
    //   327	1	5	localException2	java.lang.Exception
    //   343	22	5	localObject10	Object
    //   369	1	5	localException3	java.lang.Exception
    //   380	1	5	localObject11	Object
    //   391	8	5	localException4	java.lang.Exception
    //   416	16	5	localIOException4	java.io.IOException
    //   486	13	5	localIterator	java.util.Iterator
    //   595	45	5	localObject12	Object
    //   654	20	5	localObject13	Object
    //   91	514	6	localObject14	Object
    //   6	331	7	localObject15	Object
    //   355	13	7	localException5	java.lang.Exception
    //   372	293	7	localObject16	Object
    //   3	383	8	localObject17	Object
    //   60	50	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   137	141	144	java/io/IOException
    //   246	265	272	java/lang/Exception
    //   289	293	296	java/io/IOException
    //   163	167	315	finally
    //   169	232	315	finally
    //   232	241	315	finally
    //   246	265	315	finally
    //   163	167	327	java/lang/Exception
    //   169	232	327	java/lang/Exception
    //   232	241	327	java/lang/Exception
    //   96	103	343	finally
    //   109	115	343	finally
    //   158	163	343	finally
    //   96	103	355	java/lang/Exception
    //   109	115	355	java/lang/Exception
    //   158	163	355	java/lang/Exception
    //   8	90	380	finally
    //   8	90	391	java/lang/Exception
    //   408	413	416	java/io/IOException
    //   398	403	595	finally
    //   137	141	620	finally
    //   145	149	620	finally
    //   289	293	620	finally
    //   297	301	620	finally
    //   304	308	620	finally
    //   408	413	620	finally
    //   418	423	620	finally
    //   431	437	620	finally
    //   437	457	620	finally
    //   462	470	620	finally
    //   473	488	620	finally
    //   488	573	620	finally
    //   573	589	620	finally
    //   612	617	620	finally
    //   626	631	620	finally
    //   635	639	620	finally
    //   639	642	620	finally
    //   612	617	624	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.statistic.serverip.WebAppIpManager
 * JD-Core Version:    0.7.0.1
 */