package com.tencent.weiyun.poi;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.weiyun.data.PoiItem;
import com.tencent.weiyun.utils.WyLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class PoiHelper
{
  private static final String[] PROJ_ALL = { "longitude", "latitude", "nation_type", "nation_name", "city_id", "city_name", "poi_id", "poi_name", "address" };
  private static final String[] PROJ_KEY = { "longitude", "latitude" };
  private static final int SINGLE_QUERY_LIMIT = 200;
  private static final String TAG = "PoiHelper";
  
  public static String generateKey(double paramDouble1, double paramDouble2)
  {
    return paramDouble1 + ',' + paramDouble2;
  }
  
  public static void insertPoi(List<PoiItem> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    PoiDbWrapper localPoiDbWrapper = PoiDbManager.getInstance().openPoiDb(true);
    if (localPoiDbWrapper == null)
    {
      WyLog.e("PoiHelper", "insertPoi: Job db is null.");
      return;
    }
    localPoiDbWrapper.beginTransaction();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PoiItem localPoiItem = (PoiItem)paramList.next();
      if ((localPoiItem != null) && ((!TextUtils.isEmpty(localPoiItem.poiId)) || (!TextUtils.isEmpty(localPoiItem.poiName))))
      {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("longitude", Double.valueOf(localPoiItem.longitude));
        localContentValues.put("latitude", Double.valueOf(localPoiItem.latitude));
        localContentValues.put("nation_type", Integer.valueOf(localPoiItem.nationType));
        localContentValues.put("nation_name", localPoiItem.nationName);
        localContentValues.put("city_id", Integer.valueOf(localPoiItem.cityId));
        localContentValues.put("city_name", localPoiItem.cityName);
        localContentValues.put("poi_id", localPoiItem.poiId);
        localContentValues.put("poi_name", localPoiItem.poiName);
        localContentValues.put("address", localPoiItem.address);
        localPoiDbWrapper.insert("poi", null, localContentValues);
      }
    }
    localPoiDbWrapper.setTransactionSuccessful();
    localPoiDbWrapper.endTransaction();
    PoiDbManager.getInstance().closePoiDb(localPoiDbWrapper);
  }
  
  public static List<PoiItem> queryPoi(List<PoiItem> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    PoiDbWrapper localPoiDbWrapper = PoiDbManager.getInstance().openPoiDb(false);
    if (localPoiDbWrapper == null)
    {
      WyLog.e("PoiHelper", "queryPoi: Poi db is null.");
      return localArrayList;
    }
    Object localObject = (PoiItem)paramList.get(0);
    double d2 = ((PoiItem)localObject).longitude;
    double d4 = ((PoiItem)localObject).longitude;
    double d1 = ((PoiItem)localObject).latitude;
    double d3 = ((PoiItem)localObject).latitude;
    localObject = paramList.iterator();
    PoiItem localPoiItem;
    double d6;
    double d7;
    while (((Iterator)localObject).hasNext())
    {
      localPoiItem = (PoiItem)((Iterator)localObject).next();
      d5 = d2;
      if (localPoiItem.longitude < d2) {
        d5 = localPoiItem.longitude;
      }
      d6 = d4;
      if (localPoiItem.longitude > d4) {
        d6 = localPoiItem.longitude;
      }
      d7 = d1;
      if (localPoiItem.latitude < d1) {
        d7 = localPoiItem.latitude;
      }
      d2 = d5;
      d4 = d6;
      d1 = d7;
      if (localPoiItem.latitude > d3)
      {
        d3 = localPoiItem.latitude;
        d2 = d5;
        d4 = d6;
        d1 = d7;
      }
    }
    int i = 1;
    double d5 = d1;
    if (i != 0)
    {
      localObject = singleQuery(localPoiDbWrapper, d2, d4, d5, d3);
      int j;
      if ((localObject == null) || (((List)localObject).size() < 200))
      {
        j = 0;
        d7 = d5;
        d6 = d2;
      }
      for (;;)
      {
        d2 = d6;
        d5 = d7;
        i = j;
        if (localObject == null) {
          break;
        }
        d2 = d6;
        d5 = d7;
        i = j;
        if (((List)localObject).isEmpty()) {
          break;
        }
        ((List)localObject).retainAll(paramList);
        localArrayList.addAll((Collection)localObject);
        paramList.removeAll((Collection)localObject);
        d2 = d6;
        d5 = d7;
        i = j;
        if (!paramList.isEmpty()) {
          break;
        }
        i = 0;
        d2 = d6;
        d5 = d7;
        break;
        localPoiItem = (PoiItem)((List)localObject).get(((List)localObject).size() - 1);
        d1 = d2;
        if (localPoiItem.longitude > d2) {
          d1 = localPoiItem.longitude;
        }
        d6 = d1;
        d7 = d5;
        j = i;
        if (localPoiItem.longitude == d4)
        {
          d7 = localPoiItem.latitude;
          d6 = d1;
          j = i;
        }
      }
    }
    PoiDbManager.getInstance().closePoiDb(localPoiDbWrapper);
    return localArrayList;
  }
  
  /* Error */
  public static java.util.HashSet<String> queryPoiKeys()
  {
    // Byte code:
    //   0: new 213	java/util/HashSet
    //   3: dup
    //   4: invokespecial 214	java/util/HashSet:<init>	()V
    //   7: astore_3
    //   8: invokestatic 74	com/tencent/weiyun/poi/PoiDbManager:getInstance	()Lcom/tencent/weiyun/poi/PoiDbManager;
    //   11: iconst_0
    //   12: invokevirtual 78	com/tencent/weiyun/poi/PoiDbManager:openPoiDb	(Z)Lcom/tencent/weiyun/poi/PoiDbWrapper;
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +12 -> 31
    //   22: ldc 14
    //   24: ldc 216
    //   26: invokestatic 86	com/tencent/weiyun/utils/WyLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: aload_3
    //   30: areturn
    //   31: aconst_null
    //   32: astore_1
    //   33: aconst_null
    //   34: astore_0
    //   35: aload 4
    //   37: ldc 161
    //   39: getstatic 24	com/tencent/weiyun/poi/PoiHelper:PROJ_KEY	[Ljava/lang/String;
    //   42: aconst_null
    //   43: aconst_null
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: invokevirtual 220	com/tencent/weiyun/poi/PoiDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnull +68 -> 120
    //   55: aload_2
    //   56: astore_0
    //   57: aload_2
    //   58: astore_1
    //   59: aload_2
    //   60: invokeinterface 225 1 0
    //   65: ifeq +55 -> 120
    //   68: aload_2
    //   69: astore_0
    //   70: aload_2
    //   71: astore_1
    //   72: aload_3
    //   73: aload_2
    //   74: iconst_0
    //   75: invokeinterface 229 2 0
    //   80: aload_2
    //   81: iconst_1
    //   82: invokeinterface 229 2 0
    //   87: invokestatic 231	com/tencent/weiyun/poi/PoiHelper:generateKey	(DD)Ljava/lang/String;
    //   90: invokevirtual 235	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   93: pop
    //   94: goto -39 -> 55
    //   97: astore_2
    //   98: aload_0
    //   99: astore_1
    //   100: ldc 14
    //   102: aload_2
    //   103: invokestatic 238	com/tencent/weiyun/utils/WyLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload_0
    //   107: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   110: invokestatic 74	com/tencent/weiyun/poi/PoiDbManager:getInstance	()Lcom/tencent/weiyun/poi/PoiDbManager;
    //   113: aload 4
    //   115: invokevirtual 175	com/tencent/weiyun/poi/PoiDbManager:closePoiDb	(Lcom/tencent/weiyun/poi/PoiDbWrapper;)V
    //   118: aload_3
    //   119: areturn
    //   120: aload_2
    //   121: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   124: goto -14 -> 110
    //   127: astore_0
    //   128: aload_1
    //   129: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   132: aload_0
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	73	0	localObject1	Object
    //   127	6	0	localObject2	Object
    //   32	97	1	localObject3	Object
    //   50	31	2	localCursor	android.database.Cursor
    //   97	24	2	localThrowable	java.lang.Throwable
    //   7	112	3	localHashSet	java.util.HashSet
    //   15	99	4	localPoiDbWrapper	PoiDbWrapper
    // Exception table:
    //   from	to	target	type
    //   35	51	97	java/lang/Throwable
    //   59	68	97	java/lang/Throwable
    //   72	94	97	java/lang/Throwable
    //   35	51	127	finally
    //   59	68	127	finally
    //   72	94	127	finally
    //   100	106	127	finally
  }
  
  /* Error */
  private static List<PoiItem> singleQuery(PoiDbWrapper paramPoiDbWrapper, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 11
    //   3: aconst_null
    //   4: astore 12
    //   6: new 48	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   13: ldc 20
    //   15: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: ldc 250
    //   20: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 22
    //   25: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 252
    //   30: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: astore 21
    //   35: dload_1
    //   36: invokestatic 255	java/lang/Double:toString	(D)Ljava/lang/String;
    //   39: astore 15
    //   41: dload_3
    //   42: invokestatic 255	java/lang/Double:toString	(D)Ljava/lang/String;
    //   45: astore 16
    //   47: dload 5
    //   49: invokestatic 255	java/lang/Double:toString	(D)Ljava/lang/String;
    //   52: astore 17
    //   54: dload 7
    //   56: invokestatic 255	java/lang/Double:toString	(D)Ljava/lang/String;
    //   59: astore 18
    //   61: new 48	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   68: ldc 20
    //   70: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: bipush 44
    //   75: invokevirtual 56	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   78: ldc 22
    //   80: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 257
    //   86: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: sipush 200
    //   92: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: astore 20
    //   97: aconst_null
    //   98: astore 14
    //   100: aconst_null
    //   101: astore 13
    //   103: aload 13
    //   105: astore 9
    //   107: aload 14
    //   109: astore 10
    //   111: getstatic 40	com/tencent/weiyun/poi/PoiHelper:PROJ_ALL	[Ljava/lang/String;
    //   114: astore 19
    //   116: aload 13
    //   118: astore 9
    //   120: aload 14
    //   122: astore 10
    //   124: aload 21
    //   126: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: astore 21
    //   131: aload 13
    //   133: astore 9
    //   135: aload 14
    //   137: astore 10
    //   139: aload 20
    //   141: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: astore 20
    //   146: aload 13
    //   148: astore 9
    //   150: aload 14
    //   152: astore 10
    //   154: aload_0
    //   155: ldc 161
    //   157: aload 19
    //   159: aload 21
    //   161: iconst_4
    //   162: anewarray 18	java/lang/String
    //   165: dup
    //   166: iconst_0
    //   167: aload 15
    //   169: aastore
    //   170: dup
    //   171: iconst_1
    //   172: aload 16
    //   174: aastore
    //   175: dup
    //   176: iconst_2
    //   177: aload 17
    //   179: aastore
    //   180: dup
    //   181: iconst_3
    //   182: aload 18
    //   184: aastore
    //   185: aconst_null
    //   186: aconst_null
    //   187: aload 20
    //   189: invokevirtual 220	com/tencent/weiyun/poi/PoiDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   192: astore_0
    //   193: aload 11
    //   195: astore 9
    //   197: aload_0
    //   198: ifnull +175 -> 373
    //   201: aload_0
    //   202: astore 9
    //   204: aload_0
    //   205: astore 10
    //   207: new 181	java/util/ArrayList
    //   210: dup
    //   211: aload_0
    //   212: invokeinterface 263 1 0
    //   217: invokespecial 266	java/util/ArrayList:<init>	(I)V
    //   220: astore 11
    //   222: aload_0
    //   223: invokeinterface 225 1 0
    //   228: ifeq +141 -> 369
    //   231: aload_0
    //   232: iconst_0
    //   233: invokeinterface 229 2 0
    //   238: aload_0
    //   239: iconst_1
    //   240: invokeinterface 229 2 0
    //   245: invokestatic 270	com/tencent/weiyun/data/PoiItem:createGpsInfo	(DD)Lcom/tencent/weiyun/data/PoiItem;
    //   248: astore 9
    //   250: aload 9
    //   252: aload_0
    //   253: iconst_2
    //   254: invokeinterface 274 2 0
    //   259: putfield 138	com/tencent/weiyun/data/PoiItem:nationType	I
    //   262: aload 9
    //   264: aload_0
    //   265: iconst_3
    //   266: invokeinterface 278 2 0
    //   271: putfield 149	com/tencent/weiyun/data/PoiItem:nationName	Ljava/lang/String;
    //   274: aload 9
    //   276: aload_0
    //   277: iconst_4
    //   278: invokeinterface 274 2 0
    //   283: putfield 154	com/tencent/weiyun/data/PoiItem:cityId	I
    //   286: aload 9
    //   288: aload_0
    //   289: iconst_5
    //   290: invokeinterface 278 2 0
    //   295: putfield 157	com/tencent/weiyun/data/PoiItem:cityName	Ljava/lang/String;
    //   298: aload 9
    //   300: aload_0
    //   301: bipush 6
    //   303: invokeinterface 278 2 0
    //   308: putfield 109	com/tencent/weiyun/data/PoiItem:poiId	Ljava/lang/String;
    //   311: aload 9
    //   313: aload_0
    //   314: bipush 7
    //   316: invokeinterface 278 2 0
    //   321: putfield 117	com/tencent/weiyun/data/PoiItem:poiName	Ljava/lang/String;
    //   324: aload 9
    //   326: aload_0
    //   327: bipush 8
    //   329: invokeinterface 278 2 0
    //   334: putfield 159	com/tencent/weiyun/data/PoiItem:address	Ljava/lang/String;
    //   337: aload 11
    //   339: aload 9
    //   341: invokeinterface 279 2 0
    //   346: pop
    //   347: goto -125 -> 222
    //   350: astore 10
    //   352: aload_0
    //   353: astore 9
    //   355: ldc 14
    //   357: aload 10
    //   359: invokestatic 238	com/tencent/weiyun/utils/WyLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   362: aload_0
    //   363: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   366: aload 11
    //   368: areturn
    //   369: aload 11
    //   371: astore 9
    //   373: aload_0
    //   374: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   377: aload 9
    //   379: areturn
    //   380: astore 10
    //   382: aload 9
    //   384: astore_0
    //   385: aload 10
    //   387: astore 9
    //   389: aload_0
    //   390: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   393: aload 9
    //   395: athrow
    //   396: astore 9
    //   398: goto -9 -> 389
    //   401: astore 9
    //   403: aload 10
    //   405: astore_0
    //   406: aload 9
    //   408: astore 10
    //   410: aload 12
    //   412: astore 11
    //   414: goto -62 -> 352
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	417	0	paramPoiDbWrapper	PoiDbWrapper
    //   0	417	1	paramDouble1	double
    //   0	417	3	paramDouble2	double
    //   0	417	5	paramDouble3	double
    //   0	417	7	paramDouble4	double
    //   105	289	9	localObject1	Object
    //   396	1	9	localObject2	Object
    //   401	6	9	localThrowable1	java.lang.Throwable
    //   109	97	10	localObject3	Object
    //   350	8	10	localThrowable2	java.lang.Throwable
    //   380	24	10	localObject4	Object
    //   408	1	10	localThrowable3	java.lang.Throwable
    //   1	412	11	localObject5	Object
    //   4	407	12	localObject6	Object
    //   101	46	13	localObject7	Object
    //   98	53	14	localObject8	Object
    //   39	129	15	str1	String
    //   45	128	16	str2	String
    //   52	126	17	str3	String
    //   59	124	18	str4	String
    //   114	44	19	arrayOfString	String[]
    //   95	93	20	localObject9	Object
    //   33	127	21	localObject10	Object
    // Exception table:
    //   from	to	target	type
    //   222	347	350	java/lang/Throwable
    //   111	116	380	finally
    //   124	131	380	finally
    //   139	146	380	finally
    //   154	193	380	finally
    //   207	222	380	finally
    //   355	362	380	finally
    //   222	347	396	finally
    //   111	116	401	java/lang/Throwable
    //   124	131	401	java/lang/Throwable
    //   139	146	401	java/lang/Throwable
    //   154	193	401	java/lang/Throwable
    //   207	222	401	java/lang/Throwable
  }
  
  public static int updatePoi(PoiItem paramPoiItem)
  {
    if ((paramPoiItem == null) || ((TextUtils.isEmpty(paramPoiItem.poiId)) && (TextUtils.isEmpty(paramPoiItem.poiName)))) {
      return 0;
    }
    PoiDbWrapper localPoiDbWrapper = PoiDbManager.getInstance().openPoiDb(true);
    if (localPoiDbWrapper == null)
    {
      WyLog.e("PoiHelper", "updatePoi: Poi db is null.");
      return 0;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("longitude", Double.valueOf(paramPoiItem.longitude));
    localContentValues.put("latitude", Double.valueOf(paramPoiItem.latitude));
    localContentValues.put("nation_type", Integer.valueOf(paramPoiItem.nationType));
    localContentValues.put("nation_name", paramPoiItem.nationName);
    localContentValues.put("city_id", Integer.valueOf(paramPoiItem.cityId));
    localContentValues.put("city_name", paramPoiItem.cityName);
    localContentValues.put("poi_id", paramPoiItem.poiId);
    localContentValues.put("poi_name", paramPoiItem.poiName);
    localContentValues.put("address", paramPoiItem.address);
    StringBuilder localStringBuilder = new StringBuilder().append("longitude").append("=? AND ").append("latitude").append("=?");
    String str = Double.toString(paramPoiItem.longitude);
    paramPoiItem = Double.toString(paramPoiItem.latitude);
    localPoiDbWrapper.beginTransaction();
    int i = localPoiDbWrapper.update("poi", localContentValues, localStringBuilder.toString(), new String[] { str, paramPoiItem });
    localPoiDbWrapper.setTransactionSuccessful();
    localPoiDbWrapper.endTransaction();
    PoiDbManager.getInstance().closePoiDb(localPoiDbWrapper);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.weiyun.poi.PoiHelper
 * JD-Core Version:    0.7.0.1
 */