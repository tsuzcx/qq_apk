package com.tencent.upload.network.route;

import android.content.Context;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.utils.UploadLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class RecentRouteRecordStorage
{
  private static final String RECORD_FILE_NAME_PREFIX = "upload_recent_route";
  private static final String RECORD_FILE_VER = "_v2.0.2";
  private static final String TAG = "RouteSetStorage";
  private HashMap<String, RecentRouteRecord> mRecentRouteRecordMap = new HashMap();
  private final ServerRouteTable mServerRouteTable;
  
  public RecentRouteRecordStorage(ServerRouteTable paramServerRouteTable)
  {
    this.mServerRouteTable = paramServerRouteTable;
    load();
  }
  
  private void dump()
  {
    Iterator localIterator = this.mRecentRouteRecordMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      RecentRouteRecord localRecentRouteRecord = (RecentRouteRecord)this.mRecentRouteRecordMap.get(str);
      if (localRecentRouteRecord != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mRecentRouteRecordMap key=");
        localStringBuilder.append(str);
        localStringBuilder.append(",value=");
        localStringBuilder.append(localRecentRouteRecord);
        UploadLog.d("RouteSetStorage", localStringBuilder.toString());
      }
    }
  }
  
  private String getRecentRouteSetFilePath(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("upload_recent_route_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append("_v2.0.2");
    return localStringBuilder.toString();
  }
  
  /* Error */
  private boolean load()
  {
    // Byte code:
    //   0: ldc 14
    //   2: ldc 102
    //   4: invokestatic 105	com/tencent/upload/utils/UploadLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: invokestatic 111	com/tencent/upload/common/UploadGlobalConfig:getContext	()Landroid/content/Context;
    //   10: astore 9
    //   12: aload 9
    //   14: ifnonnull +12 -> 26
    //   17: ldc 14
    //   19: ldc 113
    //   21: invokestatic 116	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: iconst_0
    //   25: ireturn
    //   26: aconst_null
    //   27: astore 4
    //   29: aconst_null
    //   30: astore 5
    //   32: aconst_null
    //   33: astore 7
    //   35: aload 9
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 31	com/tencent/upload/network/route/RecentRouteRecordStorage:mServerRouteTable	Lcom/tencent/upload/network/route/ServerRouteTable;
    //   42: getfield 122	com/tencent/upload/network/route/ServerRouteTable:code	I
    //   45: invokespecial 124	com/tencent/upload/network/route/RecentRouteRecordStorage:getRecentRouteSetFilePath	(I)Ljava/lang/String;
    //   48: invokevirtual 130	android/content/Context:openFileInput	(Ljava/lang/String;)Ljava/io/FileInputStream;
    //   51: astore_1
    //   52: new 132	java/io/BufferedInputStream
    //   55: dup
    //   56: aload_1
    //   57: sipush 8192
    //   60: invokespecial 135	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   63: astore_2
    //   64: aload_1
    //   65: astore 6
    //   67: aload_2
    //   68: astore_3
    //   69: new 137	java/io/ObjectInputStream
    //   72: dup
    //   73: aload_2
    //   74: invokespecial 140	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   77: astore 5
    //   79: aload_1
    //   80: astore 6
    //   82: aload_2
    //   83: astore 4
    //   85: aload 5
    //   87: astore 8
    //   89: aload 5
    //   91: invokevirtual 143	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   94: astore_3
    //   95: aload_1
    //   96: astore 6
    //   98: aload_2
    //   99: astore 4
    //   101: aload 5
    //   103: astore 8
    //   105: aload_3
    //   106: instanceof 26
    //   109: ifeq +21 -> 130
    //   112: aload_1
    //   113: astore 6
    //   115: aload_2
    //   116: astore 4
    //   118: aload 5
    //   120: astore 8
    //   122: aload_0
    //   123: aload_3
    //   124: checkcast 26	java/util/HashMap
    //   127: putfield 29	com/tencent/upload/network/route/RecentRouteRecordStorage:mRecentRouteRecordMap	Ljava/util/HashMap;
    //   130: aload_1
    //   131: astore 6
    //   133: aload_2
    //   134: astore 4
    //   136: aload 5
    //   138: astore 8
    //   140: aload_0
    //   141: getfield 29	com/tencent/upload/network/route/RecentRouteRecordStorage:mRecentRouteRecordMap	Ljava/util/HashMap;
    //   144: ifnonnull +65 -> 209
    //   147: aload_1
    //   148: astore 6
    //   150: aload_2
    //   151: astore 4
    //   153: aload 5
    //   155: astore 8
    //   157: aload_0
    //   158: new 26	java/util/HashMap
    //   161: dup
    //   162: invokespecial 27	java/util/HashMap:<init>	()V
    //   165: putfield 29	com/tencent/upload/network/route/RecentRouteRecordStorage:mRecentRouteRecordMap	Ljava/util/HashMap;
    //   168: aload_1
    //   169: astore 6
    //   171: aload_2
    //   172: astore 4
    //   174: aload 5
    //   176: astore 8
    //   178: aload 5
    //   180: invokevirtual 146	java/io/ObjectInputStream:close	()V
    //   183: aload 5
    //   185: invokevirtual 146	java/io/ObjectInputStream:close	()V
    //   188: aload_2
    //   189: invokevirtual 147	java/io/BufferedInputStream:close	()V
    //   192: aload_1
    //   193: ifnull +14 -> 207
    //   196: aload_1
    //   197: invokevirtual 150	java/io/FileInputStream:close	()V
    //   200: iconst_0
    //   201: ireturn
    //   202: astore_1
    //   203: aload_1
    //   204: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   207: iconst_0
    //   208: ireturn
    //   209: aload_1
    //   210: astore 6
    //   212: aload_2
    //   213: astore 4
    //   215: aload 5
    //   217: astore 8
    //   219: aload_0
    //   220: invokespecial 155	com/tencent/upload/network/route/RecentRouteRecordStorage:dump	()V
    //   223: aload 5
    //   225: invokevirtual 146	java/io/ObjectInputStream:close	()V
    //   228: aload_2
    //   229: invokevirtual 147	java/io/BufferedInputStream:close	()V
    //   232: aload_1
    //   233: ifnull +15 -> 248
    //   236: aload_1
    //   237: invokevirtual 150	java/io/FileInputStream:close	()V
    //   240: goto +8 -> 248
    //   243: astore_1
    //   244: aload_1
    //   245: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   248: iconst_1
    //   249: ireturn
    //   250: astore_3
    //   251: aload_1
    //   252: astore 7
    //   254: aload 5
    //   256: astore_1
    //   257: goto +66 -> 323
    //   260: goto +189 -> 449
    //   263: astore_3
    //   264: aconst_null
    //   265: astore 4
    //   267: aload_1
    //   268: astore 7
    //   270: aload 4
    //   272: astore_1
    //   273: goto +50 -> 323
    //   276: astore_2
    //   277: aconst_null
    //   278: astore_3
    //   279: goto +295 -> 574
    //   282: astore_3
    //   283: aconst_null
    //   284: astore 4
    //   286: aload 4
    //   288: astore_2
    //   289: aload_1
    //   290: astore 7
    //   292: aload 4
    //   294: astore_1
    //   295: goto +28 -> 323
    //   298: aconst_null
    //   299: astore_2
    //   300: aload 7
    //   302: astore 5
    //   304: goto +145 -> 449
    //   307: astore_2
    //   308: aconst_null
    //   309: astore_1
    //   310: aload_1
    //   311: astore_3
    //   312: goto +262 -> 574
    //   315: astore_3
    //   316: aconst_null
    //   317: astore_2
    //   318: aload_2
    //   319: astore_1
    //   320: aload_1
    //   321: astore 7
    //   323: aload 7
    //   325: astore 6
    //   327: aload_2
    //   328: astore 4
    //   330: aload_1
    //   331: astore 8
    //   333: ldc 14
    //   335: ldc 157
    //   337: aload_3
    //   338: invokestatic 160	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   341: aload 7
    //   343: astore 6
    //   345: aload_2
    //   346: astore 4
    //   348: aload_1
    //   349: astore 8
    //   351: aload 9
    //   353: aload_0
    //   354: aload_0
    //   355: getfield 31	com/tencent/upload/network/route/RecentRouteRecordStorage:mServerRouteTable	Lcom/tencent/upload/network/route/ServerRouteTable;
    //   358: getfield 122	com/tencent/upload/network/route/ServerRouteTable:code	I
    //   361: invokespecial 124	com/tencent/upload/network/route/RecentRouteRecordStorage:getRecentRouteSetFilePath	(I)Ljava/lang/String;
    //   364: invokevirtual 164	android/content/Context:deleteFile	(Ljava/lang/String;)Z
    //   367: pop
    //   368: goto +36 -> 404
    //   371: astore_2
    //   372: aload 8
    //   374: astore 5
    //   376: aload 6
    //   378: astore_1
    //   379: aload 4
    //   381: astore_3
    //   382: goto +192 -> 574
    //   385: astore_3
    //   386: aload 7
    //   388: astore 6
    //   390: aload_2
    //   391: astore 4
    //   393: aload_1
    //   394: astore 8
    //   396: ldc 14
    //   398: ldc 166
    //   400: aload_3
    //   401: invokestatic 160	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   404: aload_1
    //   405: ifnull +10 -> 415
    //   408: aload_1
    //   409: invokevirtual 146	java/io/ObjectInputStream:close	()V
    //   412: goto +3 -> 415
    //   415: aload_2
    //   416: ifnull +7 -> 423
    //   419: aload_2
    //   420: invokevirtual 147	java/io/BufferedInputStream:close	()V
    //   423: aload 7
    //   425: ifnull +14 -> 439
    //   428: aload 7
    //   430: invokevirtual 150	java/io/FileInputStream:close	()V
    //   433: iconst_0
    //   434: ireturn
    //   435: aload_1
    //   436: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   439: iconst_0
    //   440: ireturn
    //   441: aconst_null
    //   442: astore_1
    //   443: aload_1
    //   444: astore_2
    //   445: aload 7
    //   447: astore 5
    //   449: aload 5
    //   451: astore 4
    //   453: aload_1
    //   454: astore 6
    //   456: aload_2
    //   457: astore_3
    //   458: new 66	java/lang/StringBuilder
    //   461: dup
    //   462: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   465: astore 7
    //   467: aload 5
    //   469: astore 4
    //   471: aload_1
    //   472: astore 6
    //   474: aload_2
    //   475: astore_3
    //   476: aload 7
    //   478: ldc 168
    //   480: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload 5
    //   486: astore 4
    //   488: aload_1
    //   489: astore 6
    //   491: aload_2
    //   492: astore_3
    //   493: aload 7
    //   495: aload_0
    //   496: aload_0
    //   497: getfield 31	com/tencent/upload/network/route/RecentRouteRecordStorage:mServerRouteTable	Lcom/tencent/upload/network/route/ServerRouteTable;
    //   500: getfield 122	com/tencent/upload/network/route/ServerRouteTable:code	I
    //   503: invokespecial 124	com/tencent/upload/network/route/RecentRouteRecordStorage:getRecentRouteSetFilePath	(I)Ljava/lang/String;
    //   506: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: pop
    //   510: aload 5
    //   512: astore 4
    //   514: aload_1
    //   515: astore 6
    //   517: aload_2
    //   518: astore_3
    //   519: ldc 14
    //   521: aload 7
    //   523: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 171	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   529: aload 5
    //   531: ifnull +11 -> 542
    //   534: aload 5
    //   536: invokevirtual 146	java/io/ObjectInputStream:close	()V
    //   539: goto +3 -> 542
    //   542: aload_2
    //   543: ifnull +7 -> 550
    //   546: aload_2
    //   547: invokevirtual 147	java/io/BufferedInputStream:close	()V
    //   550: aload_1
    //   551: ifnull +13 -> 564
    //   554: aload_1
    //   555: invokevirtual 150	java/io/FileInputStream:close	()V
    //   558: iconst_0
    //   559: ireturn
    //   560: aload_1
    //   561: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   564: iconst_0
    //   565: ireturn
    //   566: astore_2
    //   567: aload 6
    //   569: astore_1
    //   570: aload 4
    //   572: astore 5
    //   574: aload 5
    //   576: ifnull +11 -> 587
    //   579: aload 5
    //   581: invokevirtual 146	java/io/ObjectInputStream:close	()V
    //   584: goto +3 -> 587
    //   587: aload_3
    //   588: ifnull +7 -> 595
    //   591: aload_3
    //   592: invokevirtual 147	java/io/BufferedInputStream:close	()V
    //   595: aload_1
    //   596: ifnull +14 -> 610
    //   599: aload_1
    //   600: invokevirtual 150	java/io/FileInputStream:close	()V
    //   603: goto +7 -> 610
    //   606: aload_1
    //   607: invokevirtual 153	java/lang/Exception:printStackTrace	()V
    //   610: aload_2
    //   611: athrow
    //   612: astore_1
    //   613: goto -172 -> 441
    //   616: astore_2
    //   617: goto -319 -> 298
    //   620: astore_3
    //   621: aload 7
    //   623: astore 5
    //   625: goto -176 -> 449
    //   628: astore_3
    //   629: goto -369 -> 260
    //   632: astore_1
    //   633: goto -198 -> 435
    //   636: astore_1
    //   637: goto -77 -> 560
    //   640: astore_1
    //   641: goto -35 -> 606
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	644	0	this	RecentRouteRecordStorage
    //   51	146	1	localFileInputStream	java.io.FileInputStream
    //   202	35	1	localException1	Exception
    //   243	9	1	localException2	Exception
    //   256	351	1	localObject1	Object
    //   612	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   632	1	1	localException3	Exception
    //   636	1	1	localException4	Exception
    //   640	1	1	localException5	Exception
    //   63	166	2	localBufferedInputStream	java.io.BufferedInputStream
    //   276	1	2	localObject2	Object
    //   288	12	2	localObject3	Object
    //   307	1	2	localObject4	Object
    //   317	29	2	localObject5	Object
    //   371	49	2	localObject6	Object
    //   444	103	2	localObject7	Object
    //   566	45	2	localObject8	Object
    //   616	1	2	localFileNotFoundException2	java.io.FileNotFoundException
    //   68	56	3	localObject9	Object
    //   250	1	3	localException6	Exception
    //   263	1	3	localException7	Exception
    //   278	1	3	localObject10	Object
    //   282	1	3	localException8	Exception
    //   311	1	3	localObject11	Object
    //   315	23	3	localException9	Exception
    //   381	1	3	localObject12	Object
    //   385	16	3	localException10	Exception
    //   457	135	3	localObject13	Object
    //   620	1	3	localFileNotFoundException3	java.io.FileNotFoundException
    //   628	1	3	localFileNotFoundException4	java.io.FileNotFoundException
    //   27	544	4	localObject14	Object
    //   30	594	5	localObject15	Object
    //   65	503	6	localObject16	Object
    //   33	589	7	localObject17	Object
    //   87	308	8	localObject18	Object
    //   10	342	9	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   183	192	202	java/lang/Exception
    //   196	200	202	java/lang/Exception
    //   223	232	243	java/lang/Exception
    //   236	240	243	java/lang/Exception
    //   89	95	250	java/lang/Exception
    //   105	112	250	java/lang/Exception
    //   122	130	250	java/lang/Exception
    //   140	147	250	java/lang/Exception
    //   157	168	250	java/lang/Exception
    //   178	183	250	java/lang/Exception
    //   219	223	250	java/lang/Exception
    //   69	79	263	java/lang/Exception
    //   52	64	276	finally
    //   52	64	282	java/lang/Exception
    //   35	52	307	finally
    //   35	52	315	java/lang/Exception
    //   89	95	371	finally
    //   105	112	371	finally
    //   122	130	371	finally
    //   140	147	371	finally
    //   157	168	371	finally
    //   178	183	371	finally
    //   219	223	371	finally
    //   333	341	371	finally
    //   351	368	371	finally
    //   396	404	371	finally
    //   333	341	385	java/lang/Exception
    //   351	368	385	java/lang/Exception
    //   69	79	566	finally
    //   458	467	566	finally
    //   476	484	566	finally
    //   493	510	566	finally
    //   519	529	566	finally
    //   35	52	612	java/io/FileNotFoundException
    //   52	64	616	java/io/FileNotFoundException
    //   69	79	620	java/io/FileNotFoundException
    //   89	95	628	java/io/FileNotFoundException
    //   105	112	628	java/io/FileNotFoundException
    //   122	130	628	java/io/FileNotFoundException
    //   140	147	628	java/io/FileNotFoundException
    //   157	168	628	java/io/FileNotFoundException
    //   178	183	628	java/io/FileNotFoundException
    //   219	223	628	java/io/FileNotFoundException
    //   408	412	632	java/lang/Exception
    //   419	423	632	java/lang/Exception
    //   428	433	632	java/lang/Exception
    //   534	539	636	java/lang/Exception
    //   546	550	636	java/lang/Exception
    //   554	558	636	java/lang/Exception
    //   579	584	640	java/lang/Exception
    //   591	595	640	java/lang/Exception
    //   599	603	640	java/lang/Exception
  }
  
  private void removeExpired()
  {
    Object localObject1 = this.mRecentRouteRecordMap;
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((HashMap)localObject1).keySet();
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((Set)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      String str = (String)((Iterator)localObject1).next();
      Object localObject2 = (RecentRouteRecord)this.mRecentRouteRecordMap.get(str);
      if (localObject2 != null)
      {
        long l = ((RecentRouteRecord)localObject2).getTimeStamp();
        if ((l != 0L) && (System.currentTimeMillis() > l + UploadConfiguration.getRecentRouteExpire()))
        {
          ((Iterator)localObject1).remove();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("removeExpired key:");
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append(" contains:");
          ((StringBuilder)localObject2).append(this.mRecentRouteRecordMap.containsKey(str));
          UploadLog.d("RouteSetStorage", ((StringBuilder)localObject2).toString());
        }
      }
    }
  }
  
  /* Error */
  private boolean save()
  {
    // Byte code:
    //   0: ldc 14
    //   2: ldc 202
    //   4: invokestatic 105	com/tencent/upload/utils/UploadLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: invokestatic 111	com/tencent/upload/common/UploadGlobalConfig:getContext	()Landroid/content/Context;
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +12 -> 24
    //   15: ldc 14
    //   17: ldc 204
    //   19: invokestatic 116	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: iconst_0
    //   23: ireturn
    //   24: aload_0
    //   25: invokespecial 206	com/tencent/upload/network/route/RecentRouteRecordStorage:removeExpired	()V
    //   28: aconst_null
    //   29: astore_3
    //   30: aconst_null
    //   31: astore_1
    //   32: new 208	java/io/ObjectOutputStream
    //   35: dup
    //   36: new 210	java/io/BufferedOutputStream
    //   39: dup
    //   40: aload_2
    //   41: aload_0
    //   42: aload_0
    //   43: getfield 31	com/tencent/upload/network/route/RecentRouteRecordStorage:mServerRouteTable	Lcom/tencent/upload/network/route/ServerRouteTable;
    //   46: getfield 122	com/tencent/upload/network/route/ServerRouteTable:code	I
    //   49: invokespecial 124	com/tencent/upload/network/route/RecentRouteRecordStorage:getRecentRouteSetFilePath	(I)Ljava/lang/String;
    //   52: iconst_0
    //   53: invokevirtual 214	android/content/Context:openFileOutput	(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    //   56: invokespecial 217	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   59: invokespecial 218	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   62: astore_2
    //   63: aload_2
    //   64: aload_0
    //   65: getfield 29	com/tencent/upload/network/route/RecentRouteRecordStorage:mRecentRouteRecordMap	Ljava/util/HashMap;
    //   68: invokevirtual 222	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   71: aload_0
    //   72: invokespecial 155	com/tencent/upload/network/route/RecentRouteRecordStorage:dump	()V
    //   75: aload_2
    //   76: invokevirtual 223	java/io/ObjectOutputStream:close	()V
    //   79: goto +54 -> 133
    //   82: astore_3
    //   83: aload_2
    //   84: astore_1
    //   85: aload_3
    //   86: astore_2
    //   87: goto +48 -> 135
    //   90: astore_3
    //   91: goto +12 -> 103
    //   94: astore_2
    //   95: goto +40 -> 135
    //   98: astore_1
    //   99: aload_3
    //   100: astore_2
    //   101: aload_1
    //   102: astore_3
    //   103: aload_2
    //   104: astore_1
    //   105: ldc 14
    //   107: ldc 225
    //   109: aload_3
    //   110: invokestatic 160	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload_2
    //   114: ifnull +19 -> 133
    //   117: aload_2
    //   118: invokevirtual 223	java/io/ObjectOutputStream:close	()V
    //   121: goto +12 -> 133
    //   124: astore_1
    //   125: ldc 14
    //   127: ldc 227
    //   129: aload_1
    //   130: invokestatic 160	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   133: iconst_1
    //   134: ireturn
    //   135: aload_1
    //   136: ifnull +19 -> 155
    //   139: aload_1
    //   140: invokevirtual 223	java/io/ObjectOutputStream:close	()V
    //   143: goto +12 -> 155
    //   146: astore_1
    //   147: ldc 14
    //   149: ldc 227
    //   151: aload_1
    //   152: invokestatic 160	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   155: aload_2
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	RecentRouteRecordStorage
    //   31	54	1	localObject1	Object
    //   98	4	1	localException1	Exception
    //   104	1	1	localObject2	Object
    //   124	16	1	localException2	Exception
    //   146	6	1	localException3	Exception
    //   10	77	2	localObject3	Object
    //   94	1	2	localObject4	Object
    //   100	56	2	localObject5	Object
    //   29	1	3	localObject6	Object
    //   82	4	3	localObject7	Object
    //   90	10	3	localException4	Exception
    //   102	8	3	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   63	75	82	finally
    //   63	75	90	java/lang/Exception
    //   32	63	94	finally
    //   105	113	94	finally
    //   32	63	98	java/lang/Exception
    //   75	79	124	java/lang/Exception
    //   117	121	124	java/lang/Exception
    //   139	143	146	java/lang/Exception
  }
  
  public void clear(int paramInt)
  {
    Context localContext = UploadGlobalConfig.getContext();
    if (localContext == null)
    {
      UploadLog.e("RouteSetStorage", "clear() UploadGlobalConfig.getContext() == null");
      return;
    }
    try
    {
      localContext.deleteFile(getRecentRouteSetFilePath(paramInt));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clear() deleteFile ");
      localStringBuilder.append(localException);
      UploadLog.e("RouteSetStorage", localStringBuilder.toString());
    }
  }
  
  public RecentRouteRecord getData(String paramString)
  {
    return (RecentRouteRecord)this.mRecentRouteRecordMap.get(paramString);
  }
  
  public void setData(String paramString, RecentRouteRecord paramRecentRouteRecord)
  {
    this.mRecentRouteRecordMap.put(paramString, paramRecentRouteRecord);
    save();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.route.RecentRouteRecordStorage
 * JD-Core Version:    0.7.0.1
 */