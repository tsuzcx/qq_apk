package com.tencent.rmonitor.base.db.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.rmonitor.base.db.BaseTable;
import com.tencent.rmonitor.base.db.DBDataStatus;
import com.tencent.rmonitor.base.meta.DropFrameResultMeta;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/db/table/DropFrameTable;", "Lcom/tencent/rmonitor/base/db/BaseTable;", "pId", "", "processName", "version", "uin", "dropFrameResult", "Lcom/tencent/rmonitor/base/meta/DropFrameResultMeta;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/rmonitor/base/meta/DropFrameResultMeta;)V", "lastTime", "", "curTime", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "()V", "buildDropFrameJson", "Lorg/json/JSONObject;", "map", "Ljava/util/HashMap;", "buildSingleScene", "dealDataFromDB", "", "data", "sceneMap", "insert", "", "dataBase", "Landroid/database/sqlite/SQLiteDatabase;", "block", "Lkotlin/Function0;", "makeStringFromArray", "value", "", "parseStringToArray", "size", "search", "", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DropFrameTable
  extends BaseTable
{
  public static final DropFrameTable.Companion b = new DropFrameTable.Companion(null);
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private DropFrameResultMeta g = new DropFrameResultMeta(null, 0, 0.0F, null, 0L, null, null, 0L, 0, 511, null);
  private long h;
  private long i;
  
  static
  {
    new DropFrameTable();
  }
  
  public DropFrameTable()
  {
    super("drop_frame", "CREATE TABLE drop_frame (_id INTEGER PRIMARY KEY AUTOINCREMENT,process_name TEXT,p_id TEXT,version TEXT,uin TEXT,scene TEXT,state TINYINT,drop_duration FLOAT,drop_count INT,drop_intervals TEXT,total_duration BIGINT,refresh_duration TEXT,refresh_count TEXT,hitches_duration BIGINT,status TINYINT,occur_time BIGINT);");
  }
  
  public DropFrameTable(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, long paramLong1, long paramLong2)
  {
    this();
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramString3;
    this.h = paramLong1;
    this.i = paramLong2;
  }
  
  public int a(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<Integer> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramSQLiteDatabase, "dataBase");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    paramFunction0 = new ContentValues();
    paramFunction0.put("process_name", this.d);
    paramFunction0.put("p_id", this.c);
    paramFunction0.put("version", this.e);
    paramFunction0.put("uin", this.f);
    paramFunction0.put("scene", this.g.scene);
    paramFunction0.put("state", Integer.valueOf(this.g.state));
    paramFunction0.put("drop_duration", Float.valueOf(this.g.duration));
    paramFunction0.put("drop_count", Integer.valueOf(this.g.dropCount));
    paramFunction0.put("drop_intervals", a(this.g.dropIntervals));
    paramFunction0.put("total_duration", Long.valueOf(this.g.totalDuration));
    paramFunction0.put("refresh_count", a(this.g.refreshCount));
    paramFunction0.put("refresh_duration", a(this.g.refreshDuration));
    paramFunction0.put("hitches_duration", Long.valueOf(this.g.hitchesDuration));
    paramFunction0.put("status", Integer.valueOf(DBDataStatus.TO_SEND.getValue()));
    paramFunction0.put("occur_time", Long.valueOf(System.currentTimeMillis()));
    return (int)paramSQLiteDatabase.insert("drop_frame", "name", paramFunction0);
  }
  
  @NotNull
  public final String a(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "value");
    StringBuilder localStringBuilder = new StringBuilder();
    int m = paramArrayOfLong.length;
    int j = 0;
    while (j < m)
    {
      long l = paramArrayOfLong[j];
      int k;
      if (((CharSequence)localStringBuilder).length() > 0) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(l);
      j += 1;
    }
    paramArrayOfLong = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfLong, "sb.toString()");
    return paramArrayOfLong;
  }
  
  @NotNull
  public final JSONObject a(@Nullable DropFrameResultMeta paramDropFrameResultMeta)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    if (paramDropFrameResultMeta != null)
    {
      localJSONObject2.put("dropDuration", paramDropFrameResultMeta.duration / 1.0E+009F);
      JSONArray localJSONArray = new JSONArray();
      int m = paramDropFrameResultMeta.dropIntervals.length;
      int k = 0;
      int j = 0;
      while (j < m)
      {
        localJSONArray.put(j, paramDropFrameResultMeta.dropIntervals[j]);
        j += 1;
      }
      localJSONObject2.put("dropTimes", localJSONArray);
      localJSONObject2.put("totalDuration", paramDropFrameResultMeta.totalDuration);
      localJSONObject2.put("hitchesDuration", paramDropFrameResultMeta.hitchesDuration);
      localJSONArray = new JSONArray();
      m = paramDropFrameResultMeta.refreshCount.length;
      j = 0;
      while (j < m)
      {
        localJSONArray.put(j, paramDropFrameResultMeta.refreshCount[j]);
        j += 1;
      }
      localJSONObject2.put("refreshCount", localJSONArray);
      localJSONArray = new JSONArray();
      m = paramDropFrameResultMeta.refreshDuration.length;
      j = k;
      while (j < m)
      {
        localJSONArray.put(j, paramDropFrameResultMeta.refreshDuration[j]);
        j += 1;
      }
      localJSONObject2.put("refreshDuration", localJSONArray);
      localJSONObject1.put(String.valueOf(paramDropFrameResultMeta.state), localJSONObject2);
    }
    return localJSONObject1;
  }
  
  @NotNull
  public final JSONObject a(@NotNull HashMap<String, DropFrameResultMeta> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "map");
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localJSONObject.put(str, a((DropFrameResultMeta)paramHashMap.get(str)));
    }
    return localJSONObject;
  }
  
  public final void a(@NotNull DropFrameResultMeta paramDropFrameResultMeta, @NotNull HashMap<String, DropFrameResultMeta> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramDropFrameResultMeta, "data");
    Intrinsics.checkParameterIsNotNull(paramHashMap, "sceneMap");
    if (paramHashMap.containsKey(paramDropFrameResultMeta.scene))
    {
      DropFrameResultMeta localDropFrameResultMeta = (DropFrameResultMeta)paramHashMap.get(paramDropFrameResultMeta.scene);
      if (localDropFrameResultMeta != null)
      {
        localDropFrameResultMeta.dropCount += paramDropFrameResultMeta.dropCount;
        localDropFrameResultMeta.duration += paramDropFrameResultMeta.duration;
        int m = localDropFrameResultMeta.dropIntervals.length;
        int k = 0;
        int j = 0;
        long[] arrayOfLong;
        while (j < m)
        {
          arrayOfLong = localDropFrameResultMeta.dropIntervals;
          arrayOfLong[j] += paramDropFrameResultMeta.dropIntervals[j];
          j += 1;
        }
        localDropFrameResultMeta.totalDuration += paramDropFrameResultMeta.totalDuration;
        m = localDropFrameResultMeta.refreshDuration.length;
        j = 0;
        while (j < m)
        {
          arrayOfLong = localDropFrameResultMeta.refreshDuration;
          arrayOfLong[j] += paramDropFrameResultMeta.refreshDuration[j];
          j += 1;
        }
        m = localDropFrameResultMeta.refreshCount.length;
        j = k;
        while (j < m)
        {
          arrayOfLong = localDropFrameResultMeta.refreshCount;
          arrayOfLong[j] += paramDropFrameResultMeta.refreshCount[j];
          j += 1;
        }
        localDropFrameResultMeta.hitchesDuration += paramDropFrameResultMeta.hitchesDuration;
        paramHashMap = (Map)paramHashMap;
        paramDropFrameResultMeta = paramDropFrameResultMeta.scene;
        Intrinsics.checkExpressionValueIsNotNull(localDropFrameResultMeta, "dropFrameResult");
        paramHashMap.put(paramDropFrameResultMeta, localDropFrameResultMeta);
      }
    }
    else
    {
      ((Map)paramHashMap).put(paramDropFrameResultMeta.scene, paramDropFrameResultMeta);
    }
  }
  
  @NotNull
  public final long[] a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    long[] arrayOfLong = new long[paramInt];
    paramString = (CharSequence)paramString;
    paramInt = 0;
    List localList = StringsKt.split$default(paramString, new char[] { ',' }, false, 0, 6, null);
    paramString = (Long)null;
    int j = ((Collection)localList).size();
    while (paramInt < j)
    {
      try
      {
        paramString = (String)localList.get(paramInt);
        if (paramString != null)
        {
          paramString = Long.valueOf(Long.parseLong(StringsKt.trim((CharSequence)paramString).toString()));
          break label107;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
      }
      catch (Throwable paramString)
      {
        label105:
        label107:
        break label105;
      }
      paramString = null;
      if (paramString != null) {
        arrayOfLong[paramInt] = ((Number)paramString).longValue();
      }
      paramInt += 1;
    }
    return arrayOfLong;
  }
  
  /* Error */
  @Nullable
  public Object b(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<? extends Object> paramFunction0)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 116
    //   3: invokestatic 103	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 117
    //   9: invokestatic 103	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: new 297	java/util/HashMap
    //   15: dup
    //   16: invokespecial 383	java/util/HashMap:<init>	()V
    //   19: astore 12
    //   21: aload_2
    //   22: invokeinterface 388 1 0
    //   27: astore 10
    //   29: aload 10
    //   31: iconst_3
    //   32: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: invokestatic 392	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   38: ifeq +11 -> 49
    //   41: ldc_w 394
    //   44: astore 10
    //   46: goto +725 -> 771
    //   49: aload 10
    //   51: iconst_4
    //   52: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: invokestatic 392	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   58: ifeq +11 -> 69
    //   61: ldc_w 396
    //   64: astore 10
    //   66: goto +705 -> 771
    //   69: aload 10
    //   71: iconst_5
    //   72: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: invokestatic 392	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   78: ifeq +696 -> 774
    //   81: ldc_w 398
    //   84: astore 10
    //   86: goto +685 -> 771
    //   89: aload_2
    //   90: invokeinterface 388 1 0
    //   95: astore 11
    //   97: aload 11
    //   99: iconst_3
    //   100: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: invokestatic 392	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   106: ifeq +39 -> 145
    //   109: iconst_3
    //   110: anewarray 290	java/lang/String
    //   113: astore 11
    //   115: aload 11
    //   117: iconst_0
    //   118: aload_0
    //   119: getfield 84	com/tencent/rmonitor/base/db/table/DropFrameTable:d	Ljava/lang/String;
    //   122: aastore
    //   123: aload 11
    //   125: iconst_1
    //   126: aload_0
    //   127: getfield 82	com/tencent/rmonitor/base/db/table/DropFrameTable:c	Ljava/lang/String;
    //   130: invokevirtual 399	java/lang/String:toString	()Ljava/lang/String;
    //   133: aastore
    //   134: aload 11
    //   136: iconst_2
    //   137: aload_0
    //   138: getfield 86	com/tencent/rmonitor/base/db/table/DropFrameTable:e	Ljava/lang/String;
    //   141: aastore
    //   142: goto +639 -> 781
    //   145: aload 11
    //   147: iconst_4
    //   148: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: invokestatic 392	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   154: ifeq +52 -> 206
    //   157: iconst_4
    //   158: anewarray 290	java/lang/String
    //   161: astore 11
    //   163: aload 11
    //   165: iconst_0
    //   166: getstatic 210	com/tencent/rmonitor/base/db/DBDataStatus:TO_SEND	Lcom/tencent/rmonitor/base/db/DBDataStatus;
    //   169: invokevirtual 214	com/tencent/rmonitor/base/db/DBDataStatus:getValue	()I
    //   172: invokestatic 293	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   175: aastore
    //   176: aload 11
    //   178: iconst_1
    //   179: aload_0
    //   180: getfield 84	com/tencent/rmonitor/base/db/table/DropFrameTable:d	Ljava/lang/String;
    //   183: aastore
    //   184: aload 11
    //   186: iconst_2
    //   187: aload_0
    //   188: getfield 82	com/tencent/rmonitor/base/db/table/DropFrameTable:c	Ljava/lang/String;
    //   191: invokevirtual 399	java/lang/String:toString	()Ljava/lang/String;
    //   194: aastore
    //   195: aload 11
    //   197: iconst_3
    //   198: aload_0
    //   199: getfield 86	com/tencent/rmonitor/base/db/table/DropFrameTable:e	Ljava/lang/String;
    //   202: aastore
    //   203: goto +578 -> 781
    //   206: aload 11
    //   208: iconst_5
    //   209: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: invokestatic 392	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   215: ifeq +569 -> 784
    //   218: iconst_5
    //   219: anewarray 290	java/lang/String
    //   222: astore 11
    //   224: aload 11
    //   226: iconst_0
    //   227: aload_0
    //   228: getfield 84	com/tencent/rmonitor/base/db/table/DropFrameTable:d	Ljava/lang/String;
    //   231: aastore
    //   232: aload 11
    //   234: iconst_1
    //   235: aload_0
    //   236: getfield 82	com/tencent/rmonitor/base/db/table/DropFrameTable:c	Ljava/lang/String;
    //   239: invokevirtual 399	java/lang/String:toString	()Ljava/lang/String;
    //   242: aastore
    //   243: aload 11
    //   245: iconst_2
    //   246: aload_0
    //   247: getfield 86	com/tencent/rmonitor/base/db/table/DropFrameTable:e	Ljava/lang/String;
    //   250: aastore
    //   251: aload 11
    //   253: iconst_3
    //   254: aload_0
    //   255: getfield 107	com/tencent/rmonitor/base/db/table/DropFrameTable:h	J
    //   258: invokestatic 402	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   261: aastore
    //   262: aload 11
    //   264: iconst_4
    //   265: aload_0
    //   266: getfield 109	com/tencent/rmonitor/base/db/table/DropFrameTable:i	J
    //   269: invokestatic 402	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   272: aastore
    //   273: goto +508 -> 781
    //   276: aload_1
    //   277: ldc 74
    //   279: aconst_null
    //   280: aload 10
    //   282: aload 11
    //   284: aconst_null
    //   285: aconst_null
    //   286: aconst_null
    //   287: invokevirtual 406	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   290: astore 10
    //   292: aload 10
    //   294: ifnull +474 -> 768
    //   297: aload 10
    //   299: checkcast 408	java/io/Closeable
    //   302: astore 13
    //   304: aconst_null
    //   305: checkcast 341	java/lang/Throwable
    //   308: astore 11
    //   310: aload 11
    //   312: astore 10
    //   314: aload 13
    //   316: checkcast 410	android/database/Cursor
    //   319: astore 14
    //   321: aload 11
    //   323: astore 10
    //   325: aload 14
    //   327: invokeinterface 413 1 0
    //   332: pop
    //   333: aload 11
    //   335: astore 10
    //   337: aload 14
    //   339: invokeinterface 416 1 0
    //   344: ifne +338 -> 682
    //   347: aload 11
    //   349: astore 10
    //   351: aload 14
    //   353: aload 14
    //   355: ldc 130
    //   357: invokeinterface 420 2 0
    //   362: invokeinterface 423 2 0
    //   367: astore 15
    //   369: aload 11
    //   371: astore 10
    //   373: aload 14
    //   375: aload 14
    //   377: ldc 134
    //   379: invokeinterface 420 2 0
    //   384: invokeinterface 427 2 0
    //   389: istore 4
    //   391: aload 11
    //   393: astore 10
    //   395: aload 14
    //   397: aload 14
    //   399: ldc 148
    //   401: invokeinterface 420 2 0
    //   406: invokeinterface 431 2 0
    //   411: fstore_3
    //   412: aload 11
    //   414: astore 10
    //   416: aload 14
    //   418: aload 14
    //   420: ldc 162
    //   422: invokeinterface 420 2 0
    //   427: invokeinterface 435 2 0
    //   432: istore 5
    //   434: aload 11
    //   436: astore 10
    //   438: aload 14
    //   440: aload 14
    //   442: ldc 167
    //   444: invokeinterface 420 2 0
    //   449: invokeinterface 423 2 0
    //   454: astore 16
    //   456: aload 11
    //   458: astore 10
    //   460: aload 16
    //   462: ldc_w 437
    //   465: invokestatic 258	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   468: aload 11
    //   470: astore 10
    //   472: aload_0
    //   473: bipush 6
    //   475: aload 16
    //   477: invokevirtual 439	com/tencent/rmonitor/base/db/table/DropFrameTable:a	(ILjava/lang/String;)[J
    //   480: astore 16
    //   482: aload 11
    //   484: astore 10
    //   486: aload 14
    //   488: aload 14
    //   490: ldc 176
    //   492: invokeinterface 420 2 0
    //   497: invokeinterface 443 2 0
    //   502: lstore 6
    //   504: aload 11
    //   506: astore 10
    //   508: aload 14
    //   510: aload 14
    //   512: ldc 194
    //   514: invokeinterface 420 2 0
    //   519: invokeinterface 423 2 0
    //   524: astore 17
    //   526: aload 11
    //   528: astore 10
    //   530: aload 17
    //   532: ldc_w 445
    //   535: invokestatic 258	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   538: aload 11
    //   540: astore 10
    //   542: aload_0
    //   543: bipush 60
    //   545: aload 17
    //   547: invokevirtual 439	com/tencent/rmonitor/base/db/table/DropFrameTable:a	(ILjava/lang/String;)[J
    //   550: astore 17
    //   552: aload 11
    //   554: astore 10
    //   556: aload 14
    //   558: aload 14
    //   560: ldc 189
    //   562: invokeinterface 420 2 0
    //   567: invokeinterface 423 2 0
    //   572: astore 18
    //   574: aload 11
    //   576: astore 10
    //   578: aload 18
    //   580: ldc_w 447
    //   583: invokestatic 258	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   586: aload 11
    //   588: astore 10
    //   590: aload_0
    //   591: bipush 60
    //   593: aload 18
    //   595: invokevirtual 439	com/tencent/rmonitor/base/db/table/DropFrameTable:a	(ILjava/lang/String;)[J
    //   598: astore 18
    //   600: aload 11
    //   602: astore 10
    //   604: aload 14
    //   606: aload 14
    //   608: ldc 199
    //   610: invokeinterface 420 2 0
    //   615: invokeinterface 443 2 0
    //   620: lstore 8
    //   622: aload 11
    //   624: astore 10
    //   626: aload 15
    //   628: ldc 130
    //   630: invokestatic 258	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   633: aload 11
    //   635: astore 10
    //   637: aload_0
    //   638: new 90	com/tencent/rmonitor/base/meta/DropFrameResultMeta
    //   641: dup
    //   642: aload 15
    //   644: iload 5
    //   646: fload_3
    //   647: aload 16
    //   649: lload 6
    //   651: aload 17
    //   653: aload 18
    //   655: lload 8
    //   657: iload 4
    //   659: invokespecial 450	com/tencent/rmonitor/base/meta/DropFrameResultMeta:<init>	(Ljava/lang/String;IF[JJ[J[JJI)V
    //   662: aload 12
    //   664: invokevirtual 452	com/tencent/rmonitor/base/db/table/DropFrameTable:a	(Lcom/tencent/rmonitor/base/meta/DropFrameResultMeta;Ljava/util/HashMap;)V
    //   667: aload 11
    //   669: astore 10
    //   671: aload 14
    //   673: invokeinterface 455 1 0
    //   678: pop
    //   679: goto -346 -> 333
    //   682: aload 11
    //   684: astore 10
    //   686: aload_2
    //   687: invokeinterface 388 1 0
    //   692: iconst_5
    //   693: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   696: invokestatic 392	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   699: iconst_1
    //   700: ixor
    //   701: ifeq +16 -> 717
    //   704: aload 11
    //   706: astore 10
    //   708: aload_1
    //   709: ldc 74
    //   711: aconst_null
    //   712: aconst_null
    //   713: invokevirtual 459	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   716: pop
    //   717: aload 11
    //   719: astore 10
    //   721: getstatic 465	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   724: astore_1
    //   725: aload 13
    //   727: aload 11
    //   729: invokestatic 471	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   732: aload 12
    //   734: areturn
    //   735: astore_1
    //   736: goto +9 -> 745
    //   739: astore_1
    //   740: aload_1
    //   741: astore 10
    //   743: aload_1
    //   744: athrow
    //   745: aload 13
    //   747: aload 10
    //   749: invokestatic 471	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   752: aload_1
    //   753: athrow
    //   754: astore_1
    //   755: getstatic 476	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   758: ldc_w 478
    //   761: aload_1
    //   762: checkcast 341	java/lang/Throwable
    //   765: invokevirtual 481	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   768: aload 12
    //   770: areturn
    //   771: goto -682 -> 89
    //   774: ldc 80
    //   776: astore 10
    //   778: goto -7 -> 771
    //   781: goto -505 -> 276
    //   784: aconst_null
    //   785: astore 11
    //   787: goto -511 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	790	0	this	DropFrameTable
    //   0	790	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	790	2	paramFunction0	Function0<? extends Object>
    //   411	236	3	f1	float
    //   389	269	4	j	int
    //   432	213	5	k	int
    //   502	148	6	l1	long
    //   620	36	8	l2	long
    //   27	750	10	localObject1	Object
    //   95	691	11	localObject2	Object
    //   19	750	12	localHashMap	HashMap
    //   302	444	13	localCloseable	java.io.Closeable
    //   319	353	14	localCursor	android.database.Cursor
    //   367	276	15	str	String
    //   454	194	16	localObject3	Object
    //   524	128	17	localObject4	Object
    //   572	82	18	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   314	321	735	finally
    //   325	333	735	finally
    //   337	347	735	finally
    //   351	369	735	finally
    //   373	391	735	finally
    //   395	412	735	finally
    //   416	434	735	finally
    //   438	456	735	finally
    //   460	468	735	finally
    //   472	482	735	finally
    //   486	504	735	finally
    //   508	526	735	finally
    //   530	538	735	finally
    //   542	552	735	finally
    //   556	574	735	finally
    //   578	586	735	finally
    //   590	600	735	finally
    //   604	622	735	finally
    //   626	633	735	finally
    //   637	667	735	finally
    //   671	679	735	finally
    //   686	704	735	finally
    //   708	717	735	finally
    //   721	725	735	finally
    //   743	745	735	finally
    //   314	321	739	java/lang/Throwable
    //   325	333	739	java/lang/Throwable
    //   337	347	739	java/lang/Throwable
    //   351	369	739	java/lang/Throwable
    //   373	391	739	java/lang/Throwable
    //   395	412	739	java/lang/Throwable
    //   416	434	739	java/lang/Throwable
    //   438	456	739	java/lang/Throwable
    //   460	468	739	java/lang/Throwable
    //   472	482	739	java/lang/Throwable
    //   486	504	739	java/lang/Throwable
    //   508	526	739	java/lang/Throwable
    //   530	538	739	java/lang/Throwable
    //   542	552	739	java/lang/Throwable
    //   556	574	739	java/lang/Throwable
    //   578	586	739	java/lang/Throwable
    //   590	600	739	java/lang/Throwable
    //   604	622	739	java/lang/Throwable
    //   626	633	739	java/lang/Throwable
    //   637	667	739	java/lang/Throwable
    //   671	679	739	java/lang/Throwable
    //   686	704	739	java/lang/Throwable
    //   708	717	739	java/lang/Throwable
    //   721	725	739	java/lang/Throwable
    //   21	41	754	java/lang/Exception
    //   49	61	754	java/lang/Exception
    //   69	81	754	java/lang/Exception
    //   89	142	754	java/lang/Exception
    //   145	203	754	java/lang/Exception
    //   206	273	754	java/lang/Exception
    //   276	292	754	java/lang/Exception
    //   297	310	754	java/lang/Exception
    //   725	732	754	java/lang/Exception
    //   745	754	754	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.db.table.DropFrameTable
 * JD-Core Version:    0.7.0.1
 */