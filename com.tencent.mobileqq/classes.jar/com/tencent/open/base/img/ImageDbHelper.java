package com.tencent.open.base.img;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ImageDbHelper
  extends SQLiteOpenHelper
{
  protected static String a = "sys_image";
  protected static final String[] b = { "key", "maxage", "updatetime", "modified", "local" };
  protected static final byte[] c = new byte[1];
  
  public ImageDbHelper(Context paramContext)
  {
    super(paramContext, "appcenterImagedb.db", null, 4);
  }
  
  protected ImageInfo a(Cursor paramCursor)
  {
    ImageInfo localImageInfo = new ImageInfo();
    localImageInfo.a = paramCursor.getString(0);
    localImageInfo.c = paramCursor.getLong(1);
    localImageInfo.d = paramCursor.getLong(2);
    localImageInfo.e = paramCursor.getLong(3);
    localImageInfo.f = paramCursor.getString(4);
    return localImageInfo;
  }
  
  /* Error */
  public ImageInfo a(String paramString)
  {
    // Byte code:
    //   0: getstatic 30	com/tencent/open/base/img/ImageDbHelper:c	[B
    //   3: astore 9
    //   5: aload 9
    //   7: monitorenter
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 8
    //   14: aconst_null
    //   15: astore 4
    //   17: aconst_null
    //   18: astore_3
    //   19: aload_0
    //   20: invokevirtual 74	com/tencent/open/base/img/ImageDbHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore_2
    //   24: aload_2
    //   25: getstatic 75	com/tencent/open/base/img/ImageDbHelper:a	Ljava/lang/String;
    //   28: getstatic 28	com/tencent/open/base/img/ImageDbHelper:b	[Ljava/lang/String;
    //   31: ldc 77
    //   33: iconst_1
    //   34: anewarray 16	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload_1
    //   40: aastore
    //   41: aconst_null
    //   42: aconst_null
    //   43: aconst_null
    //   44: invokevirtual 83	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore 6
    //   49: aload_3
    //   50: astore_1
    //   51: aload_2
    //   52: astore_3
    //   53: aload 6
    //   55: astore 4
    //   57: aload 6
    //   59: invokeinterface 87 1 0
    //   64: ifle +30 -> 94
    //   67: aload_2
    //   68: astore_3
    //   69: aload 6
    //   71: astore 4
    //   73: aload 6
    //   75: invokeinterface 91 1 0
    //   80: pop
    //   81: aload_2
    //   82: astore_3
    //   83: aload 6
    //   85: astore 4
    //   87: aload_0
    //   88: aload 6
    //   90: invokevirtual 93	com/tencent/open/base/img/ImageDbHelper:a	(Landroid/database/Cursor;)Lcom/tencent/open/base/img/ImageInfo;
    //   93: astore_1
    //   94: aload 6
    //   96: ifnull +117 -> 213
    //   99: aload 6
    //   101: invokeinterface 96 1 0
    //   106: goto +107 -> 213
    //   109: aload_2
    //   110: invokevirtual 97	android/database/sqlite/SQLiteDatabase:close	()V
    //   113: aload_1
    //   114: astore_3
    //   115: goto +57 -> 172
    //   118: astore 5
    //   120: aload 6
    //   122: astore_1
    //   123: goto +26 -> 149
    //   126: astore_1
    //   127: goto +50 -> 177
    //   130: astore 5
    //   132: aconst_null
    //   133: astore_1
    //   134: goto +15 -> 149
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_2
    //   140: goto +37 -> 177
    //   143: astore 5
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_1
    //   148: astore_2
    //   149: aload_2
    //   150: astore_3
    //   151: aload_1
    //   152: astore 4
    //   154: aload 5
    //   156: invokevirtual 100	java/lang/Exception:printStackTrace	()V
    //   159: aload_1
    //   160: ifnull +62 -> 222
    //   163: aload_1
    //   164: invokeinterface 96 1 0
    //   169: goto +53 -> 222
    //   172: aload 9
    //   174: monitorexit
    //   175: aload_3
    //   176: areturn
    //   177: aload 4
    //   179: ifnull +13 -> 192
    //   182: aload 4
    //   184: invokeinterface 96 1 0
    //   189: goto +3 -> 192
    //   192: aload_2
    //   193: ifnull +7 -> 200
    //   196: aload_2
    //   197: invokevirtual 97	android/database/sqlite/SQLiteDatabase:close	()V
    //   200: aload_1
    //   201: athrow
    //   202: aload 9
    //   204: monitorexit
    //   205: goto +5 -> 210
    //   208: aload_1
    //   209: athrow
    //   210: goto -2 -> 208
    //   213: aload_1
    //   214: astore_3
    //   215: aload_2
    //   216: ifnull -44 -> 172
    //   219: goto -110 -> 109
    //   222: aload 8
    //   224: astore_3
    //   225: aload_2
    //   226: ifnull -54 -> 172
    //   229: aload 7
    //   231: astore_1
    //   232: goto -123 -> 109
    //   235: astore_1
    //   236: aload_3
    //   237: astore_2
    //   238: goto -61 -> 177
    //   241: astore_1
    //   242: goto -40 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	ImageDbHelper
    //   0	245	1	paramString	String
    //   23	215	2	localObject1	java.lang.Object
    //   18	219	3	localObject2	java.lang.Object
    //   15	168	4	localObject3	java.lang.Object
    //   118	1	5	localException1	Exception
    //   130	1	5	localException2	Exception
    //   143	12	5	localException3	Exception
    //   47	74	6	localCursor	Cursor
    //   9	221	7	localObject4	java.lang.Object
    //   12	211	8	localObject5	java.lang.Object
    //   3	200	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   57	67	118	java/lang/Exception
    //   73	81	118	java/lang/Exception
    //   87	94	118	java/lang/Exception
    //   24	49	126	finally
    //   24	49	130	java/lang/Exception
    //   19	24	137	finally
    //   19	24	143	java/lang/Exception
    //   57	67	235	finally
    //   73	81	235	finally
    //   87	94	235	finally
    //   154	159	235	finally
    //   99	106	241	finally
    //   109	113	241	finally
    //   163	169	241	finally
    //   172	175	241	finally
    //   182	189	241	finally
    //   196	200	241	finally
    //   200	202	241	finally
    //   202	205	241	finally
  }
  
  /* Error */
  public void a(ImageInfo paramImageInfo)
  {
    // Byte code:
    //   0: getstatic 30	com/tencent/open/base/img/ImageDbHelper:c	[B
    //   3: astore 5
    //   5: aload 5
    //   7: monitorenter
    //   8: aload_1
    //   9: ifnonnull +11 -> 20
    //   12: aload 5
    //   14: monitorexit
    //   15: return
    //   16: astore_1
    //   17: goto +270 -> 287
    //   20: aconst_null
    //   21: astore 4
    //   23: aconst_null
    //   24: astore_2
    //   25: aload_0
    //   26: invokevirtual 104	com/tencent/open/base/img/ImageDbHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore_3
    //   30: new 106	android/content/ContentValues
    //   33: dup
    //   34: invokespecial 107	android/content/ContentValues:<init>	()V
    //   37: astore 4
    //   39: aload 4
    //   41: ldc 18
    //   43: aload_1
    //   44: getfield 51	com/tencent/open/base/img/ImageInfo:a	Ljava/lang/String;
    //   47: invokevirtual 111	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload 4
    //   52: ldc 20
    //   54: aload_1
    //   55: getfield 58	com/tencent/open/base/img/ImageInfo:c	J
    //   58: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   61: invokevirtual 120	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   64: aload 4
    //   66: ldc 22
    //   68: aload_1
    //   69: getfield 61	com/tencent/open/base/img/ImageInfo:d	J
    //   72: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   75: invokevirtual 120	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   78: aload 4
    //   80: ldc 24
    //   82: aload_1
    //   83: getfield 64	com/tencent/open/base/img/ImageInfo:e	J
    //   86: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: invokevirtual 120	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   92: aload 4
    //   94: ldc 26
    //   96: aload_1
    //   97: getfield 67	com/tencent/open/base/img/ImageInfo:f	Ljava/lang/String;
    //   100: invokevirtual 111	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: new 122	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   110: astore 6
    //   112: aload 6
    //   114: ldc 125
    //   116: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload_1
    //   121: ifnonnull +9 -> 130
    //   124: ldc 131
    //   126: astore_2
    //   127: goto +8 -> 135
    //   130: aload_1
    //   131: getfield 51	com/tencent/open/base/img/ImageInfo:a	Ljava/lang/String;
    //   134: astore_2
    //   135: aload 6
    //   137: aload_2
    //   138: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: ldc 133
    //   144: aload 6
    //   146: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 141	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: getstatic 75	com/tencent/open/base/img/ImageDbHelper:a	Ljava/lang/String;
    //   155: astore_2
    //   156: new 122	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   163: astore 6
    //   165: aload 6
    //   167: ldc 143
    //   169: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 6
    //   175: aload_1
    //   176: getfield 51	com/tencent/open/base/img/ImageInfo:a	Ljava/lang/String;
    //   179: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 6
    //   185: ldc 145
    //   187: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_3
    //   192: aload_2
    //   193: aload 6
    //   195: invokevirtual 137	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: aconst_null
    //   199: invokevirtual 149	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   202: pop
    //   203: goto +8 -> 211
    //   206: astore_1
    //   207: aload_1
    //   208: invokevirtual 100	java/lang/Exception:printStackTrace	()V
    //   211: aload_3
    //   212: getstatic 75	com/tencent/open/base/img/ImageDbHelper:a	Ljava/lang/String;
    //   215: aconst_null
    //   216: aload 4
    //   218: invokevirtual 153	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   221: pop2
    //   222: aload_3
    //   223: ifnull +50 -> 273
    //   226: aload_3
    //   227: invokevirtual 97	android/database/sqlite/SQLiteDatabase:close	()V
    //   230: goto +43 -> 273
    //   233: astore_1
    //   234: goto +43 -> 277
    //   237: astore_2
    //   238: aload_3
    //   239: astore_1
    //   240: aload_2
    //   241: astore_3
    //   242: goto +13 -> 255
    //   245: astore_1
    //   246: aload_2
    //   247: astore_3
    //   248: goto +29 -> 277
    //   251: astore_3
    //   252: aload 4
    //   254: astore_1
    //   255: aload_1
    //   256: astore_2
    //   257: ldc 133
    //   259: ldc 155
    //   261: aload_3
    //   262: invokestatic 158	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   265: aload_1
    //   266: ifnull +7 -> 273
    //   269: aload_1
    //   270: invokevirtual 97	android/database/sqlite/SQLiteDatabase:close	()V
    //   273: aload 5
    //   275: monitorexit
    //   276: return
    //   277: aload_3
    //   278: ifnull +7 -> 285
    //   281: aload_3
    //   282: invokevirtual 97	android/database/sqlite/SQLiteDatabase:close	()V
    //   285: aload_1
    //   286: athrow
    //   287: aload 5
    //   289: monitorexit
    //   290: aload_1
    //   291: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	ImageDbHelper
    //   0	292	1	paramImageInfo	ImageInfo
    //   24	169	2	str	String
    //   237	10	2	localException1	Exception
    //   256	1	2	localImageInfo	ImageInfo
    //   29	219	3	localObject	java.lang.Object
    //   251	31	3	localException2	Exception
    //   21	232	4	localContentValues	android.content.ContentValues
    //   3	285	5	arrayOfByte	byte[]
    //   110	84	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   12	15	16	finally
    //   226	230	16	finally
    //   269	273	16	finally
    //   273	276	16	finally
    //   281	285	16	finally
    //   285	287	16	finally
    //   287	290	16	finally
    //   152	203	206	java/lang/Exception
    //   30	120	233	finally
    //   130	135	233	finally
    //   135	152	233	finally
    //   152	203	233	finally
    //   207	211	233	finally
    //   211	222	233	finally
    //   30	120	237	java/lang/Exception
    //   130	135	237	java/lang/Exception
    //   135	152	237	java/lang/Exception
    //   207	211	237	java/lang/Exception
    //   211	222	237	java/lang/Exception
    //   25	30	245	finally
    //   257	265	245	finally
    //   25	30	251	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CREATE TABLE ");
      localStringBuilder.append(a);
      localStringBuilder.append(" (");
      localStringBuilder.append("key");
      localStringBuilder.append(" VARCHAR(50),");
      localStringBuilder.append("local");
      localStringBuilder.append(" VARCHAR(50),");
      localStringBuilder.append("maxage");
      localStringBuilder.append(" BIGINT,");
      localStringBuilder.append("updatetime");
      localStringBuilder.append(" BIGINT,");
      localStringBuilder.append("modified");
      localStringBuilder.append(" BIGINT,PRIMARY KEY(");
      localStringBuilder.append("key");
      localStringBuilder.append("))");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DROP TABLE IF EXISTS ");
      localStringBuilder.append(a);
      localStringBuilder.append(";");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.base.img.ImageDbHelper
 * JD-Core Version:    0.7.0.1
 */