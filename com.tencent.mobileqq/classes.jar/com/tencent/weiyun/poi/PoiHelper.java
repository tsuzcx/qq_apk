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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramDouble1);
    localStringBuilder.append(',');
    localStringBuilder.append(paramDouble2);
    return localStringBuilder.toString();
  }
  
  public static void insertPoi(List<PoiItem> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
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
  }
  
  public static List<PoiItem> queryPoi(List<PoiItem> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
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
        d1 = d7;
        d4 = d6;
        if (localPoiItem.latitude > d3)
        {
          d3 = localPoiItem.latitude;
          d2 = d5;
          d1 = d7;
          d4 = d6;
        }
      }
      int i = 1;
      double d5 = d1;
      while (i != 0)
      {
        localObject = singleQuery(localPoiDbWrapper, d2, d4, d5, d3);
        int j;
        if ((localObject != null) && (((List)localObject).size() >= 200))
        {
          localPoiItem = (PoiItem)((List)localObject).get(((List)localObject).size() - 1);
          d1 = d2;
          if (localPoiItem.longitude > d2) {
            d1 = localPoiItem.longitude;
          }
          j = i;
          d6 = d1;
          d7 = d5;
          if (localPoiItem.longitude == d4)
          {
            d7 = localPoiItem.latitude;
            j = i;
            d6 = d1;
          }
        }
        else
        {
          j = 0;
          d7 = d5;
          d6 = d2;
        }
        i = j;
        d2 = d6;
        d5 = d7;
        if (localObject != null)
        {
          i = j;
          d2 = d6;
          d5 = d7;
          if (!((List)localObject).isEmpty())
          {
            ((List)localObject).retainAll(paramList);
            localArrayList.addAll((Collection)localObject);
            paramList.removeAll((Collection)localObject);
            i = j;
            d2 = d6;
            d5 = d7;
            if (paramList.isEmpty())
            {
              i = 0;
              d2 = d6;
              d5 = d7;
            }
          }
        }
      }
      PoiDbManager.getInstance().closePoiDb(localPoiDbWrapper);
      return localArrayList;
    }
    return null;
  }
  
  /* Error */
  public static java.util.HashSet<String> queryPoiKeys()
  {
    // Byte code:
    //   0: new 213	java/util/HashSet
    //   3: dup
    //   4: invokespecial 214	java/util/HashSet:<init>	()V
    //   7: astore 4
    //   9: invokestatic 74	com/tencent/weiyun/poi/PoiDbManager:getInstance	()Lcom/tencent/weiyun/poi/PoiDbManager;
    //   12: iconst_0
    //   13: invokevirtual 78	com/tencent/weiyun/poi/PoiDbManager:openPoiDb	(Z)Lcom/tencent/weiyun/poi/PoiDbWrapper;
    //   16: astore 5
    //   18: aload 5
    //   20: ifnonnull +13 -> 33
    //   23: ldc 14
    //   25: ldc 216
    //   27: invokestatic 86	com/tencent/weiyun/utils/WyLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   30: aload 4
    //   32: areturn
    //   33: aconst_null
    //   34: astore_0
    //   35: aconst_null
    //   36: astore_1
    //   37: aload 5
    //   39: ldc 161
    //   41: getstatic 24	com/tencent/weiyun/poi/PoiHelper:PROJ_KEY	[Ljava/lang/String;
    //   44: aconst_null
    //   45: aconst_null
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: invokevirtual 220	com/tencent/weiyun/poi/PoiDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore_2
    //   53: aload_2
    //   54: astore_3
    //   55: aload_2
    //   56: ifnull +63 -> 119
    //   59: aload_2
    //   60: astore_1
    //   61: aload_2
    //   62: astore_0
    //   63: aload_2
    //   64: astore_3
    //   65: aload_2
    //   66: invokeinterface 225 1 0
    //   71: ifeq +48 -> 119
    //   74: aload_2
    //   75: astore_1
    //   76: aload_2
    //   77: astore_0
    //   78: aload 4
    //   80: aload_2
    //   81: iconst_0
    //   82: invokeinterface 229 2 0
    //   87: aload_2
    //   88: iconst_1
    //   89: invokeinterface 229 2 0
    //   94: invokestatic 231	com/tencent/weiyun/poi/PoiHelper:generateKey	(DD)Ljava/lang/String;
    //   97: invokevirtual 235	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   100: pop
    //   101: goto -42 -> 59
    //   104: astore_0
    //   105: goto +29 -> 134
    //   108: astore_2
    //   109: aload_0
    //   110: astore_1
    //   111: ldc 14
    //   113: aload_2
    //   114: invokestatic 238	com/tencent/weiyun/utils/WyLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   117: aload_0
    //   118: astore_3
    //   119: aload_3
    //   120: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   123: invokestatic 74	com/tencent/weiyun/poi/PoiDbManager:getInstance	()Lcom/tencent/weiyun/poi/PoiDbManager;
    //   126: aload 5
    //   128: invokevirtual 175	com/tencent/weiyun/poi/PoiDbManager:closePoiDb	(Lcom/tencent/weiyun/poi/PoiDbWrapper;)V
    //   131: aload 4
    //   133: areturn
    //   134: aload_1
    //   135: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   138: goto +5 -> 143
    //   141: aload_0
    //   142: athrow
    //   143: goto -2 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	44	0	localObject1	Object
    //   104	38	0	localObject2	Object
    //   36	99	1	localObject3	Object
    //   52	36	2	localCursor	android.database.Cursor
    //   108	6	2	localThrowable	java.lang.Throwable
    //   54	66	3	localObject4	Object
    //   7	125	4	localHashSet	java.util.HashSet
    //   16	111	5	localPoiDbWrapper	PoiDbWrapper
    // Exception table:
    //   from	to	target	type
    //   37	53	104	finally
    //   65	74	104	finally
    //   78	101	104	finally
    //   111	117	104	finally
    //   37	53	108	java/lang/Throwable
    //   65	74	108	java/lang/Throwable
    //   78	101	108	java/lang/Throwable
  }
  
  /* Error */
  private static List<PoiItem> singleQuery(PoiDbWrapper paramPoiDbWrapper, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    // Byte code:
    //   0: new 48	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   7: astore 19
    //   9: aload 19
    //   11: ldc 20
    //   13: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 19
    //   19: ldc 250
    //   21: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload 19
    //   27: ldc 22
    //   29: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: pop
    //   33: aload 19
    //   35: ldc 252
    //   37: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: dload_1
    //   42: invokestatic 255	java/lang/Double:toString	(D)Ljava/lang/String;
    //   45: astore 13
    //   47: dload_3
    //   48: invokestatic 255	java/lang/Double:toString	(D)Ljava/lang/String;
    //   51: astore 14
    //   53: dload 5
    //   55: invokestatic 255	java/lang/Double:toString	(D)Ljava/lang/String;
    //   58: astore 15
    //   60: dload 7
    //   62: invokestatic 255	java/lang/Double:toString	(D)Ljava/lang/String;
    //   65: astore 16
    //   67: new 48	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   74: astore 18
    //   76: aload 18
    //   78: ldc 20
    //   80: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 18
    //   86: bipush 44
    //   88: invokevirtual 56	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload 18
    //   94: ldc 22
    //   96: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 18
    //   102: ldc_w 257
    //   105: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload 18
    //   111: sipush 200
    //   114: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aconst_null
    //   119: astore 10
    //   121: aconst_null
    //   122: astore 11
    //   124: aconst_null
    //   125: astore 12
    //   127: aload 10
    //   129: astore 9
    //   131: getstatic 40	com/tencent/weiyun/poi/PoiHelper:PROJ_ALL	[Ljava/lang/String;
    //   134: astore 17
    //   136: aload 10
    //   138: astore 9
    //   140: aload 19
    //   142: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: astore 19
    //   147: aload 10
    //   149: astore 9
    //   151: aload 18
    //   153: invokevirtual 60	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: astore 18
    //   158: aload 10
    //   160: astore 9
    //   162: aload_0
    //   163: ldc 161
    //   165: aload 17
    //   167: aload 19
    //   169: iconst_4
    //   170: anewarray 18	java/lang/String
    //   173: dup
    //   174: iconst_0
    //   175: aload 13
    //   177: aastore
    //   178: dup
    //   179: iconst_1
    //   180: aload 14
    //   182: aastore
    //   183: dup
    //   184: iconst_2
    //   185: aload 15
    //   187: aastore
    //   188: dup
    //   189: iconst_3
    //   190: aload 16
    //   192: aastore
    //   193: aconst_null
    //   194: aconst_null
    //   195: aload 18
    //   197: invokevirtual 220	com/tencent/weiyun/poi/PoiDbWrapper:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   200: astore 10
    //   202: aload 12
    //   204: astore_0
    //   205: aload 10
    //   207: ifnull +182 -> 389
    //   210: new 181	java/util/ArrayList
    //   213: dup
    //   214: aload 10
    //   216: invokeinterface 263 1 0
    //   221: invokespecial 266	java/util/ArrayList:<init>	(I)V
    //   224: astore_0
    //   225: aload 10
    //   227: invokeinterface 225 1 0
    //   232: ifeq +130 -> 362
    //   235: aload 10
    //   237: iconst_0
    //   238: invokeinterface 229 2 0
    //   243: aload 10
    //   245: iconst_1
    //   246: invokeinterface 229 2 0
    //   251: invokestatic 270	com/tencent/weiyun/data/PoiItem:createGpsInfo	(DD)Lcom/tencent/weiyun/data/PoiItem;
    //   254: astore 9
    //   256: aload 9
    //   258: aload 10
    //   260: iconst_2
    //   261: invokeinterface 274 2 0
    //   266: putfield 138	com/tencent/weiyun/data/PoiItem:nationType	I
    //   269: aload 9
    //   271: aload 10
    //   273: iconst_3
    //   274: invokeinterface 278 2 0
    //   279: putfield 149	com/tencent/weiyun/data/PoiItem:nationName	Ljava/lang/String;
    //   282: aload 9
    //   284: aload 10
    //   286: iconst_4
    //   287: invokeinterface 274 2 0
    //   292: putfield 154	com/tencent/weiyun/data/PoiItem:cityId	I
    //   295: aload 9
    //   297: aload 10
    //   299: iconst_5
    //   300: invokeinterface 278 2 0
    //   305: putfield 157	com/tencent/weiyun/data/PoiItem:cityName	Ljava/lang/String;
    //   308: aload 9
    //   310: aload 10
    //   312: bipush 6
    //   314: invokeinterface 278 2 0
    //   319: putfield 109	com/tencent/weiyun/data/PoiItem:poiId	Ljava/lang/String;
    //   322: aload 9
    //   324: aload 10
    //   326: bipush 7
    //   328: invokeinterface 278 2 0
    //   333: putfield 117	com/tencent/weiyun/data/PoiItem:poiName	Ljava/lang/String;
    //   336: aload 9
    //   338: aload 10
    //   340: bipush 8
    //   342: invokeinterface 278 2 0
    //   347: putfield 159	com/tencent/weiyun/data/PoiItem:address	Ljava/lang/String;
    //   350: aload_0
    //   351: aload 9
    //   353: invokeinterface 279 2 0
    //   358: pop
    //   359: goto -134 -> 225
    //   362: goto +27 -> 389
    //   365: astore 9
    //   367: goto +15 -> 382
    //   370: astore_0
    //   371: aload 10
    //   373: astore 9
    //   375: goto +55 -> 430
    //   378: astore 9
    //   380: aconst_null
    //   381: astore_0
    //   382: aload 9
    //   384: astore 11
    //   386: goto +26 -> 412
    //   389: aload 10
    //   391: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   394: aload_0
    //   395: areturn
    //   396: astore_0
    //   397: goto +33 -> 430
    //   400: astore 9
    //   402: aconst_null
    //   403: astore_0
    //   404: aload 11
    //   406: astore 10
    //   408: aload 9
    //   410: astore 11
    //   412: aload 10
    //   414: astore 9
    //   416: ldc 14
    //   418: aload 11
    //   420: invokestatic 238	com/tencent/weiyun/utils/WyLog:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   423: aload 10
    //   425: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   428: aload_0
    //   429: areturn
    //   430: aload 9
    //   432: invokestatic 244	com/tencent/weiyun/utils/IOUtils:closeSilently	(Landroid/database/Cursor;)V
    //   435: goto +5 -> 440
    //   438: aload_0
    //   439: athrow
    //   440: goto -2 -> 438
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	443	0	paramPoiDbWrapper	PoiDbWrapper
    //   0	443	1	paramDouble1	double
    //   0	443	3	paramDouble2	double
    //   0	443	5	paramDouble3	double
    //   0	443	7	paramDouble4	double
    //   129	223	9	localObject1	Object
    //   365	1	9	localThrowable1	java.lang.Throwable
    //   373	1	9	localObject2	Object
    //   378	5	9	localThrowable2	java.lang.Throwable
    //   400	9	9	localThrowable3	java.lang.Throwable
    //   414	17	9	localObject3	Object
    //   119	305	10	localObject4	Object
    //   122	297	11	localObject5	Object
    //   125	78	12	localObject6	Object
    //   45	131	13	str1	String
    //   51	130	14	str2	String
    //   58	128	15	str3	String
    //   65	126	16	str4	String
    //   134	32	17	arrayOfString	String[]
    //   74	122	18	localObject7	Object
    //   7	161	19	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   225	359	365	java/lang/Throwable
    //   210	225	370	finally
    //   225	359	370	finally
    //   210	225	378	java/lang/Throwable
    //   131	136	396	finally
    //   140	147	396	finally
    //   151	158	396	finally
    //   162	202	396	finally
    //   416	423	396	finally
    //   131	136	400	java/lang/Throwable
    //   140	147	400	java/lang/Throwable
    //   151	158	400	java/lang/Throwable
    //   162	202	400	java/lang/Throwable
  }
  
  public static int updatePoi(PoiItem paramPoiItem)
  {
    if (paramPoiItem != null)
    {
      if ((TextUtils.isEmpty(paramPoiItem.poiId)) && (TextUtils.isEmpty(paramPoiItem.poiName))) {
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("longitude");
      localStringBuilder.append("=? AND ");
      localStringBuilder.append("latitude");
      localStringBuilder.append("=?");
      String str = Double.toString(paramPoiItem.longitude);
      paramPoiItem = Double.toString(paramPoiItem.latitude);
      localPoiDbWrapper.beginTransaction();
      int i = localPoiDbWrapper.update("poi", localContentValues, localStringBuilder.toString(), new String[] { str, paramPoiItem });
      localPoiDbWrapper.setTransactionSuccessful();
      localPoiDbWrapper.endTransaction();
      PoiDbManager.getInstance().closePoiDb(localPoiDbWrapper);
      return i;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.poi.PoiHelper
 * JD-Core Version:    0.7.0.1
 */