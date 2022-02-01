package com.tencent.qapmsdk.base.dbpersist.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.qapmsdk.base.dbpersist.BaseTable;
import com.tencent.qapmsdk.base.dbpersist.DBDataStatus;
import com.tencent.qapmsdk.base.meta.DropFrameResultMeta;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/table/DropFrameTable;", "Lcom/tencent/qapmsdk/base/dbpersist/BaseTable;", "pId", "", "processName", "", "version", "uin", "scene", "dropFrameResult", "Lcom/tencent/qapmsdk/base/meta/DropFrameResultMeta;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qapmsdk/base/meta/DropFrameResultMeta;)V", "lastTime", "", "curTime", "(ILjava/lang/String;Ljava/lang/String;JJ)V", "()V", "buildDropFrameJson", "Lorg/json/JSONObject;", "map", "Ljava/util/HashMap;", "buildSingleScene", "insert", "dataBase", "Landroid/database/sqlite/SQLiteDatabase;", "block", "Lkotlin/Function0;", "search", "", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class DropFrameTable
  extends BaseTable
{
  private static final String COLUMN_DROP_COUNT = "drop_count";
  private static final String COLUMN_DROP_DURATION = "drop_duration";
  private static final String COLUMN_ID = "_id";
  private static final String COLUMN_OCCUR_TIME = "occur_time";
  private static final String COLUMN_PROCESS_NAME = "process_name";
  private static final String COLUMN_PRODUCT_ID = "p_id";
  private static final String COLUMN_RANGE_0 = "range_0";
  private static final String COLUMN_RANGE_1 = "range_1";
  private static final String COLUMN_RANGE_2_4 = "range_2_4";
  private static final String COLUMN_RANGE_4_8 = "range_4_8";
  private static final String COLUMN_RANGE_8_15 = "range_8_15";
  private static final String COLUMN_RANGE_OVER_15 = "range_over_15";
  private static final String COLUMN_SCENE = "scene";
  private static final String COLUMN_STATE = "state";
  private static final String COLUMN_STATUS = "status";
  private static final String COLUMN_UIN = "uin";
  private static final String COLUMN_VERSION = "version";
  private static final String CREATE_DROP_FRAME = "CREATE TABLE drop_frame (_id INTEGER PRIMARY KEY AUTOINCREMENT,process_name TEXT,p_id INT,version TEXT,uin TEXT,scene TEXT,state TINYINT,drop_duration FLOAT,drop_count INT,range_0 INT,range_1 INT,range_2_4 INT,range_4_8 INT,range_8_15 INT,range_over_15 INT,status TINYINT,occur_time BIGINT);";
  public static final DropFrameTable.Companion Companion = new DropFrameTable.Companion(null);
  private static final String TABLE_DROP_FRAME = "drop_frame";
  private static final String TAG = "QAPM_table_DropFrameTable";
  private long curTime;
  private DropFrameResultMeta dropFrameResult = new DropFrameResultMeta(0, 0.0F, null, null, 0.0F, 31, null);
  private long lastTime;
  private int pId;
  private String processName = "";
  private String scene = "";
  private String uin = "";
  private String version = "";
  
  static
  {
    new DropFrameTable();
  }
  
  public DropFrameTable()
  {
    super("drop_frame", "CREATE TABLE drop_frame (_id INTEGER PRIMARY KEY AUTOINCREMENT,process_name TEXT,p_id INT,version TEXT,uin TEXT,scene TEXT,state TINYINT,drop_duration FLOAT,drop_count INT,range_0 INT,range_1 INT,range_2_4 INT,range_4_8 INT,range_8_15 INT,range_over_15 INT,status TINYINT,occur_time BIGINT);");
  }
  
  public DropFrameTable(int paramInt, @NotNull String paramString1, @NotNull String paramString2, long paramLong1, long paramLong2)
  {
    this();
    this.pId = paramInt;
    this.processName = paramString1;
    this.version = paramString2;
    this.lastTime = paramLong1;
    this.curTime = paramLong2;
  }
  
  public DropFrameTable(int paramInt, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull DropFrameResultMeta paramDropFrameResultMeta)
  {
    this();
    this.pId = paramInt;
    this.processName = paramString1;
    this.version = paramString2;
    this.uin = paramString3;
    this.scene = paramString4;
    this.dropFrameResult = paramDropFrameResultMeta;
  }
  
  private final JSONObject buildSingleScene(DropFrameResultMeta paramDropFrameResultMeta)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    if (paramDropFrameResultMeta != null)
    {
      localJSONObject2.put("dropDuration", paramDropFrameResultMeta.duration / 1.0E+009F);
      JSONArray localJSONArray = new JSONArray();
      int i = 0;
      while (i <= 5)
      {
        localJSONArray.put(i, paramDropFrameResultMeta.dropIntervals[i]);
        i += 1;
      }
      localJSONObject2.put("dropTimes", localJSONArray);
      localJSONObject1.put(String.valueOf(paramDropFrameResultMeta.state), localJSONObject2);
    }
    return localJSONObject1;
  }
  
  @NotNull
  public final JSONObject buildDropFrameJson(@NotNull HashMap<String, DropFrameResultMeta> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "map");
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localJSONObject.put(str, buildSingleScene((DropFrameResultMeta)paramHashMap.get(str)));
    }
    return localJSONObject;
  }
  
  public int insert(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<Integer> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramSQLiteDatabase, "dataBase");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    paramFunction0 = new ContentValues();
    paramFunction0.put("process_name", this.processName);
    paramFunction0.put("p_id", Integer.valueOf(this.pId));
    paramFunction0.put("version", this.version);
    paramFunction0.put("uin", this.uin);
    paramFunction0.put("scene", this.scene);
    paramFunction0.put("state", Integer.valueOf(this.dropFrameResult.state));
    paramFunction0.put("drop_duration", Float.valueOf(this.dropFrameResult.duration));
    paramFunction0.put("drop_count", Integer.valueOf(this.dropFrameResult.dropCount));
    paramFunction0.put("range_0", Long.valueOf(this.dropFrameResult.dropIntervals[0]));
    paramFunction0.put("range_1", Long.valueOf(this.dropFrameResult.dropIntervals[1]));
    paramFunction0.put("range_2_4", Long.valueOf(this.dropFrameResult.dropIntervals[2]));
    paramFunction0.put("range_4_8", Long.valueOf(this.dropFrameResult.dropIntervals[3]));
    paramFunction0.put("range_8_15", Long.valueOf(this.dropFrameResult.dropIntervals[4]));
    paramFunction0.put("range_over_15", Long.valueOf(this.dropFrameResult.dropIntervals[5]));
    paramFunction0.put("status", Integer.valueOf(DBDataStatus.TO_SEND.getValue()));
    paramFunction0.put("occur_time", Long.valueOf(System.currentTimeMillis()));
    return (int)paramSQLiteDatabase.insert("drop_frame", "name", paramFunction0);
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public java.lang.Object search(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<? extends java.lang.Object> paramFunction0)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 227
    //   3: invokestatic 143	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 228
    //   9: invokestatic 143	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: new 196	java/util/HashMap
    //   15: dup
    //   16: invokespecial 291	java/util/HashMap:<init>	()V
    //   19: astore 23
    //   21: aload_2
    //   22: invokeinterface 296 1 0
    //   27: astore 17
    //   29: aload 17
    //   31: iconst_3
    //   32: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   35: invokestatic 300	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   38: ifeq +11 -> 49
    //   41: ldc_w 302
    //   44: astore 17
    //   46: goto +1142 -> 1188
    //   49: aload 17
    //   51: iconst_4
    //   52: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: invokestatic 300	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   58: ifeq +11 -> 69
    //   61: ldc_w 304
    //   64: astore 17
    //   66: goto +1122 -> 1188
    //   69: aload 17
    //   71: iconst_5
    //   72: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: invokestatic 300	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   78: ifeq +1113 -> 1191
    //   81: ldc_w 306
    //   84: astore 17
    //   86: goto +1102 -> 1188
    //   89: aload_2
    //   90: invokeinterface 296 1 0
    //   95: astore 18
    //   97: aload 18
    //   99: iconst_3
    //   100: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: invokestatic 300	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   106: ifeq +39 -> 145
    //   109: iconst_3
    //   110: anewarray 188	java/lang/String
    //   113: astore 18
    //   115: aload 18
    //   117: iconst_0
    //   118: aload_0
    //   119: getfield 122	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:processName	Ljava/lang/String;
    //   122: aastore
    //   123: aload 18
    //   125: iconst_1
    //   126: aload_0
    //   127: getfield 145	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:pId	I
    //   130: invokestatic 192	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   133: aastore
    //   134: aload 18
    //   136: iconst_2
    //   137: aload_0
    //   138: getfield 124	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:version	Ljava/lang/String;
    //   141: aastore
    //   142: goto +1056 -> 1198
    //   145: aload 18
    //   147: iconst_4
    //   148: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   151: invokestatic 300	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   154: ifeq +52 -> 206
    //   157: iconst_4
    //   158: anewarray 188	java/lang/String
    //   161: astore 18
    //   163: aload 18
    //   165: iconst_0
    //   166: getstatic 266	com/tencent/qapmsdk/base/dbpersist/DBDataStatus:TO_SEND	Lcom/tencent/qapmsdk/base/dbpersist/DBDataStatus;
    //   169: invokevirtual 270	com/tencent/qapmsdk/base/dbpersist/DBDataStatus:getValue	()I
    //   172: invokestatic 192	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   175: aastore
    //   176: aload 18
    //   178: iconst_1
    //   179: aload_0
    //   180: getfield 122	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:processName	Ljava/lang/String;
    //   183: aastore
    //   184: aload 18
    //   186: iconst_2
    //   187: aload_0
    //   188: getfield 145	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:pId	I
    //   191: invokestatic 192	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   194: aastore
    //   195: aload 18
    //   197: iconst_3
    //   198: aload_0
    //   199: getfield 124	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:version	Ljava/lang/String;
    //   202: aastore
    //   203: goto +995 -> 1198
    //   206: aload 18
    //   208: iconst_5
    //   209: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   212: invokestatic 300	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   215: ifeq +986 -> 1201
    //   218: iconst_5
    //   219: anewarray 188	java/lang/String
    //   222: astore 18
    //   224: aload 18
    //   226: iconst_0
    //   227: aload_0
    //   228: getfield 122	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:processName	Ljava/lang/String;
    //   231: aastore
    //   232: aload 18
    //   234: iconst_1
    //   235: aload_0
    //   236: getfield 145	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:pId	I
    //   239: invokestatic 192	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   242: aastore
    //   243: aload 18
    //   245: iconst_2
    //   246: aload_0
    //   247: getfield 124	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:version	Ljava/lang/String;
    //   250: aastore
    //   251: aload 18
    //   253: iconst_3
    //   254: aload_0
    //   255: getfield 147	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:lastTime	J
    //   258: invokestatic 309	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   261: aastore
    //   262: aload 18
    //   264: iconst_4
    //   265: aload_0
    //   266: getfield 149	com/tencent/qapmsdk/base/dbpersist/table/DropFrameTable:curTime	J
    //   269: invokestatic 309	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   272: aastore
    //   273: goto +925 -> 1198
    //   276: aload_1
    //   277: ldc 99
    //   279: aconst_null
    //   280: aload 17
    //   282: aload 18
    //   284: aconst_null
    //   285: aconst_null
    //   286: aconst_null
    //   287: invokevirtual 313	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   290: astore 17
    //   292: aload 17
    //   294: ifnull +891 -> 1185
    //   297: aload 17
    //   299: checkcast 315	java/io/Closeable
    //   302: astore 17
    //   304: aconst_null
    //   305: checkcast 290	java/lang/Throwable
    //   308: astore 18
    //   310: aload 17
    //   312: astore 20
    //   314: aload 18
    //   316: astore 19
    //   318: aload 17
    //   320: astore 22
    //   322: aload 17
    //   324: checkcast 317	android/database/Cursor
    //   327: astore 21
    //   329: aload 17
    //   331: astore 20
    //   333: aload 18
    //   335: astore 19
    //   337: aload 17
    //   339: astore 22
    //   341: aload 21
    //   343: invokeinterface 320 1 0
    //   348: pop
    //   349: aload 17
    //   351: astore 20
    //   353: aload 18
    //   355: astore 19
    //   357: aload 17
    //   359: astore 22
    //   361: aload 21
    //   363: invokeinterface 323 1 0
    //   368: ifne +685 -> 1053
    //   371: aload 17
    //   373: astore 20
    //   375: aload 18
    //   377: astore 19
    //   379: aload 17
    //   381: astore 22
    //   383: aload 21
    //   385: aload 21
    //   387: ldc 82
    //   389: invokeinterface 327 2 0
    //   394: invokeinterface 330 2 0
    //   399: astore 24
    //   401: aload 17
    //   403: astore 20
    //   405: aload 18
    //   407: astore 19
    //   409: aload 17
    //   411: astore 22
    //   413: aload 21
    //   415: aload 21
    //   417: ldc 85
    //   419: invokeinterface 327 2 0
    //   424: invokeinterface 334 2 0
    //   429: istore 4
    //   431: aload 17
    //   433: astore 20
    //   435: aload 18
    //   437: astore 19
    //   439: aload 17
    //   441: astore 22
    //   443: aload 21
    //   445: aload 21
    //   447: ldc 50
    //   449: invokeinterface 327 2 0
    //   454: invokeinterface 338 2 0
    //   459: fstore_3
    //   460: aload 17
    //   462: astore 20
    //   464: aload 18
    //   466: astore 19
    //   468: aload 17
    //   470: astore 22
    //   472: aload 21
    //   474: aload 21
    //   476: ldc 47
    //   478: invokeinterface 327 2 0
    //   483: invokeinterface 342 2 0
    //   488: istore 5
    //   490: aload 17
    //   492: astore 20
    //   494: aload 18
    //   496: astore 19
    //   498: aload 17
    //   500: astore 22
    //   502: aload 21
    //   504: aload 21
    //   506: ldc 65
    //   508: invokeinterface 327 2 0
    //   513: invokeinterface 342 2 0
    //   518: istore 6
    //   520: aload 17
    //   522: astore 20
    //   524: aload 18
    //   526: astore 19
    //   528: aload 17
    //   530: astore 22
    //   532: aload 21
    //   534: aload 21
    //   536: ldc 68
    //   538: invokeinterface 327 2 0
    //   543: invokeinterface 342 2 0
    //   548: istore 7
    //   550: aload 17
    //   552: astore 20
    //   554: aload 18
    //   556: astore 19
    //   558: aload 17
    //   560: astore 22
    //   562: aload 21
    //   564: aload 21
    //   566: ldc 71
    //   568: invokeinterface 327 2 0
    //   573: invokeinterface 342 2 0
    //   578: istore 8
    //   580: aload 17
    //   582: astore 20
    //   584: aload 18
    //   586: astore 19
    //   588: aload 17
    //   590: astore 22
    //   592: aload 21
    //   594: aload 21
    //   596: ldc 74
    //   598: invokeinterface 327 2 0
    //   603: invokeinterface 342 2 0
    //   608: istore 9
    //   610: aload 17
    //   612: astore 20
    //   614: aload 18
    //   616: astore 19
    //   618: aload 17
    //   620: astore 22
    //   622: aload 21
    //   624: aload 21
    //   626: ldc 77
    //   628: invokeinterface 327 2 0
    //   633: invokeinterface 342 2 0
    //   638: istore 10
    //   640: aload 17
    //   642: astore 20
    //   644: aload 18
    //   646: astore 19
    //   648: aload 17
    //   650: astore 22
    //   652: aload 21
    //   654: aload 21
    //   656: ldc 80
    //   658: invokeinterface 327 2 0
    //   663: invokeinterface 342 2 0
    //   668: istore 11
    //   670: aload 17
    //   672: astore 20
    //   674: aload 18
    //   676: astore 19
    //   678: aload 17
    //   680: astore 22
    //   682: aload 23
    //   684: aload 24
    //   686: invokevirtual 346	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   689: istore 12
    //   691: iload 12
    //   693: ifeq +227 -> 920
    //   696: aload 17
    //   698: astore 22
    //   700: aload 23
    //   702: aload 24
    //   704: invokevirtual 220	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   707: checkcast 130	com/tencent/qapmsdk/base/meta/DropFrameResultMeta
    //   710: astore 19
    //   712: aload 19
    //   714: ifnull +497 -> 1211
    //   717: aload 17
    //   719: astore 22
    //   721: aload 19
    //   723: aload 19
    //   725: getfield 252	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropCount	I
    //   728: iload 5
    //   730: iadd
    //   731: putfield 252	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropCount	I
    //   734: aload 17
    //   736: astore 22
    //   738: aload 19
    //   740: aload 19
    //   742: getfield 164	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:duration	F
    //   745: fload_3
    //   746: fadd
    //   747: putfield 164	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:duration	F
    //   750: aload 17
    //   752: astore 22
    //   754: aload 19
    //   756: getfield 176	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropIntervals	[J
    //   759: astore 20
    //   761: aload 20
    //   763: iconst_0
    //   764: laload
    //   765: lstore 13
    //   767: iload 6
    //   769: i2l
    //   770: lstore 15
    //   772: aload 20
    //   774: iconst_0
    //   775: lload 13
    //   777: lload 15
    //   779: ladd
    //   780: lastore
    //   781: aload 19
    //   783: getfield 176	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropIntervals	[J
    //   786: astore 20
    //   788: aload 20
    //   790: iconst_1
    //   791: aload 20
    //   793: iconst_1
    //   794: laload
    //   795: iload 7
    //   797: i2l
    //   798: ladd
    //   799: lastore
    //   800: aload 19
    //   802: getfield 176	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropIntervals	[J
    //   805: astore 20
    //   807: aload 20
    //   809: iconst_2
    //   810: aload 20
    //   812: iconst_2
    //   813: laload
    //   814: iload 8
    //   816: i2l
    //   817: ladd
    //   818: lastore
    //   819: aload 19
    //   821: getfield 176	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropIntervals	[J
    //   824: astore 20
    //   826: aload 20
    //   828: iconst_3
    //   829: laload
    //   830: lstore 13
    //   832: iload 9
    //   834: i2l
    //   835: lstore 15
    //   837: aload 20
    //   839: iconst_3
    //   840: lload 13
    //   842: lload 15
    //   844: ladd
    //   845: lastore
    //   846: aload 19
    //   848: getfield 176	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropIntervals	[J
    //   851: astore 20
    //   853: aload 20
    //   855: iconst_4
    //   856: aload 20
    //   858: iconst_4
    //   859: laload
    //   860: iload 10
    //   862: i2l
    //   863: ladd
    //   864: lastore
    //   865: aload 19
    //   867: getfield 176	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:dropIntervals	[J
    //   870: astore 20
    //   872: aload 20
    //   874: iconst_5
    //   875: aload 20
    //   877: iconst_5
    //   878: laload
    //   879: iload 11
    //   881: i2l
    //   882: ladd
    //   883: lastore
    //   884: aload 23
    //   886: checkcast 348	java/util/Map
    //   889: astore 20
    //   891: aload 24
    //   893: ldc 82
    //   895: invokestatic 351	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   898: aload 19
    //   900: ldc 154
    //   902: invokestatic 351	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   905: aload 20
    //   907: aload 24
    //   909: aload 19
    //   911: invokeinterface 354 3 0
    //   916: pop
    //   917: goto +294 -> 1211
    //   920: iload 6
    //   922: i2l
    //   923: lstore 13
    //   925: aload 18
    //   927: astore 19
    //   929: new 130	com/tencent/qapmsdk/base/meta/DropFrameResultMeta
    //   932: dup
    //   933: iload 5
    //   935: fload_3
    //   936: bipush 6
    //   938: newarray long
    //   940: dup
    //   941: iconst_0
    //   942: lload 13
    //   944: lastore
    //   945: dup
    //   946: iconst_1
    //   947: iload 7
    //   949: i2l
    //   950: lastore
    //   951: dup
    //   952: iconst_2
    //   953: iload 8
    //   955: i2l
    //   956: lastore
    //   957: dup
    //   958: iconst_3
    //   959: iload 9
    //   961: i2l
    //   962: lastore
    //   963: dup
    //   964: iconst_4
    //   965: iload 10
    //   967: i2l
    //   968: lastore
    //   969: dup
    //   970: iconst_5
    //   971: iload 11
    //   973: i2l
    //   974: lastore
    //   975: aconst_null
    //   976: fconst_0
    //   977: bipush 24
    //   979: aconst_null
    //   980: invokespecial 133	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:<init>	(IF[JLjava/lang/String;FILkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   983: astore 20
    //   985: aload 18
    //   987: astore 19
    //   989: aload 20
    //   991: iload 4
    //   993: putfield 186	com/tencent/qapmsdk/base/meta/DropFrameResultMeta:state	I
    //   996: aload 18
    //   998: astore 19
    //   1000: aload 23
    //   1002: checkcast 348	java/util/Map
    //   1005: astore 22
    //   1007: aload 18
    //   1009: astore 19
    //   1011: aload 24
    //   1013: ldc 82
    //   1015: invokestatic 351	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   1018: aload 18
    //   1020: astore 19
    //   1022: aload 22
    //   1024: aload 24
    //   1026: aload 20
    //   1028: invokeinterface 354 3 0
    //   1033: pop
    //   1034: aload 18
    //   1036: astore 19
    //   1038: aload 21
    //   1040: invokeinterface 357 1 0
    //   1045: pop
    //   1046: goto -697 -> 349
    //   1049: astore_1
    //   1050: goto +80 -> 1130
    //   1053: aload 17
    //   1055: astore 20
    //   1057: aload 18
    //   1059: astore 19
    //   1061: aload_2
    //   1062: invokeinterface 296 1 0
    //   1067: iconst_5
    //   1068: invokestatic 238	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1071: invokestatic 300	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   1074: istore 12
    //   1076: iload 12
    //   1078: iconst_1
    //   1079: ixor
    //   1080: ifeq +27 -> 1107
    //   1083: aload 18
    //   1085: astore 19
    //   1087: aload_1
    //   1088: ldc 99
    //   1090: aconst_null
    //   1091: aconst_null
    //   1092: invokevirtual 361	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   1095: pop
    //   1096: goto +11 -> 1107
    //   1099: astore_1
    //   1100: aload 17
    //   1102: astore 20
    //   1104: goto +54 -> 1158
    //   1107: aload 18
    //   1109: astore 19
    //   1111: getstatic 367	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   1114: astore_1
    //   1115: aload 20
    //   1117: aload 18
    //   1119: invokestatic 373	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   1122: aload 23
    //   1124: areturn
    //   1125: astore_1
    //   1126: aload 19
    //   1128: astore 18
    //   1130: goto +33 -> 1163
    //   1133: astore_1
    //   1134: aload 20
    //   1136: astore 22
    //   1138: goto +16 -> 1154
    //   1141: astore_1
    //   1142: aload 20
    //   1144: astore 17
    //   1146: aload 19
    //   1148: astore 18
    //   1150: goto +13 -> 1163
    //   1153: astore_1
    //   1154: aload 22
    //   1156: astore 20
    //   1158: aload_1
    //   1159: astore 19
    //   1161: aload_1
    //   1162: athrow
    //   1163: aload 17
    //   1165: aload 18
    //   1167: invokestatic 373	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   1170: aload_1
    //   1171: athrow
    //   1172: astore_1
    //   1173: getstatic 378	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   1176: ldc 102
    //   1178: aload_1
    //   1179: checkcast 290	java/lang/Throwable
    //   1182: invokevirtual 382	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1185: aload 23
    //   1187: areturn
    //   1188: goto -1099 -> 89
    //   1191: ldc 120
    //   1193: astore 17
    //   1195: goto -7 -> 1188
    //   1198: goto -922 -> 276
    //   1201: aconst_null
    //   1202: astore 18
    //   1204: goto -928 -> 276
    //   1207: astore_1
    //   1208: goto -78 -> 1130
    //   1211: goto -177 -> 1034
    //   1214: astore_1
    //   1215: goto -52 -> 1163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1218	0	this	DropFrameTable
    //   0	1218	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	1218	2	paramFunction0	Function0<? extends java.lang.Object>
    //   459	477	3	f	float
    //   429	563	4	i	int
    //   488	446	5	j	int
    //   518	403	6	k	int
    //   548	400	7	m	int
    //   578	376	8	n	int
    //   608	352	9	i1	int
    //   638	328	10	i2	int
    //   668	304	11	i3	int
    //   689	391	12	bool	boolean
    //   765	178	13	l1	long
    //   770	73	15	l2	long
    //   27	1167	17	localObject1	java.lang.Object
    //   95	1108	18	localObject2	java.lang.Object
    //   316	844	19	localObject3	java.lang.Object
    //   312	845	20	localObject4	java.lang.Object
    //   327	712	21	localCursor	android.database.Cursor
    //   320	835	22	localObject5	java.lang.Object
    //   19	1167	23	localHashMap	HashMap
    //   399	626	24	str	String
    // Exception table:
    //   from	to	target	type
    //   846	853	1049	finally
    //   865	872	1049	finally
    //   884	917	1049	finally
    //   781	788	1099	java/lang/Throwable
    //   800	807	1099	java/lang/Throwable
    //   819	826	1099	java/lang/Throwable
    //   846	853	1099	java/lang/Throwable
    //   865	872	1099	java/lang/Throwable
    //   884	917	1099	java/lang/Throwable
    //   929	985	1099	java/lang/Throwable
    //   989	996	1099	java/lang/Throwable
    //   1000	1007	1099	java/lang/Throwable
    //   1011	1018	1099	java/lang/Throwable
    //   1022	1034	1099	java/lang/Throwable
    //   1038	1046	1099	java/lang/Throwable
    //   1087	1096	1099	java/lang/Throwable
    //   929	985	1125	finally
    //   989	996	1125	finally
    //   1000	1007	1125	finally
    //   1011	1018	1125	finally
    //   1022	1034	1125	finally
    //   1038	1046	1125	finally
    //   1061	1076	1125	finally
    //   1087	1096	1125	finally
    //   1111	1115	1125	finally
    //   1061	1076	1133	java/lang/Throwable
    //   1111	1115	1133	java/lang/Throwable
    //   322	329	1141	finally
    //   341	349	1141	finally
    //   361	371	1141	finally
    //   383	401	1141	finally
    //   413	431	1141	finally
    //   443	460	1141	finally
    //   472	490	1141	finally
    //   502	520	1141	finally
    //   532	550	1141	finally
    //   562	580	1141	finally
    //   592	610	1141	finally
    //   622	640	1141	finally
    //   652	670	1141	finally
    //   682	691	1141	finally
    //   1161	1163	1141	finally
    //   322	329	1153	java/lang/Throwable
    //   341	349	1153	java/lang/Throwable
    //   361	371	1153	java/lang/Throwable
    //   383	401	1153	java/lang/Throwable
    //   413	431	1153	java/lang/Throwable
    //   443	460	1153	java/lang/Throwable
    //   472	490	1153	java/lang/Throwable
    //   502	520	1153	java/lang/Throwable
    //   532	550	1153	java/lang/Throwable
    //   562	580	1153	java/lang/Throwable
    //   592	610	1153	java/lang/Throwable
    //   622	640	1153	java/lang/Throwable
    //   652	670	1153	java/lang/Throwable
    //   682	691	1153	java/lang/Throwable
    //   700	712	1153	java/lang/Throwable
    //   721	734	1153	java/lang/Throwable
    //   738	750	1153	java/lang/Throwable
    //   754	761	1153	java/lang/Throwable
    //   21	41	1172	java/lang/Exception
    //   49	61	1172	java/lang/Exception
    //   69	81	1172	java/lang/Exception
    //   89	142	1172	java/lang/Exception
    //   145	203	1172	java/lang/Exception
    //   206	273	1172	java/lang/Exception
    //   276	292	1172	java/lang/Exception
    //   297	310	1172	java/lang/Exception
    //   1115	1122	1172	java/lang/Exception
    //   1163	1172	1172	java/lang/Exception
    //   781	788	1207	finally
    //   800	807	1207	finally
    //   819	826	1207	finally
    //   700	712	1214	finally
    //   721	734	1214	finally
    //   738	750	1214	finally
    //   754	761	1214	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.table.DropFrameTable
 * JD-Core Version:    0.7.0.1
 */