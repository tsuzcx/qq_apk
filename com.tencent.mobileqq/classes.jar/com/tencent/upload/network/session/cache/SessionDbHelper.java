package com.tencent.upload.network.session.cache;

import android.content.Context;

public class SessionDbHelper
{
  private static final String CREATE_TABLE = "CREATE TABLE session (_id INTEGER PRIMARY KEY AUTOINCREMENT,uin INTEGER,path TEXT,session TEXT,modified INTEGER,  UNIQUE (uin,path) ON CONFLICT REPLACE );";
  public static final String DATABASE_NAME = "upload_session";
  private static final int DATABASE_VERSION = 2;
  public static final String FILE_PATH = "path";
  public static final String MODIFIED_DATE = "modified";
  public static final String SESSION_ID = "session";
  private static final String SESSION_TABLE_NAME = "session";
  private static final String TAG = "SessionDbHelper";
  public static final String UIN = "uin";
  static String[] columns = { "_id", "uin", "path", "session", "modified" };
  private Context mContext = null;
  private SessionDbHelper.DatabaseHelper mOpenHelper;
  
  public SessionDbHelper(Context paramContext)
  {
    this.mContext = paramContext;
    open();
  }
  
  private void open()
  {
    this.mOpenHelper = new SessionDbHelper.DatabaseHelper(this.mContext);
  }
  
  /* Error */
  public void clearUserData(long paramLong)
  {
    // Byte code:
    //   0: lload_1
    //   1: invokestatic 70	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 4
    //   11: aload_0
    //   12: getfield 60	com/tencent/upload/network/session/cache/SessionDbHelper:mOpenHelper	Lcom/tencent/upload/network/session/cache/SessionDbHelper$DatabaseHelper;
    //   15: invokevirtual 74	com/tencent/upload/network/session/cache/SessionDbHelper$DatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore 5
    //   20: aload 5
    //   22: astore 4
    //   24: aload 5
    //   26: astore_3
    //   27: aload 5
    //   29: ldc 23
    //   31: ldc 76
    //   33: iconst_1
    //   34: anewarray 40	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload 6
    //   41: aastore
    //   42: invokevirtual 82	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   45: pop
    //   46: aload 5
    //   48: ifnull +89 -> 137
    //   51: aload 5
    //   53: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   56: ifeq +81 -> 137
    //   59: aload 5
    //   61: astore_3
    //   62: aload_3
    //   63: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   66: return
    //   67: astore_3
    //   68: goto +70 -> 138
    //   71: astore 5
    //   73: aload_3
    //   74: astore 4
    //   76: new 91	java/lang/StringBuilder
    //   79: dup
    //   80: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   83: astore 6
    //   85: aload_3
    //   86: astore 4
    //   88: aload 6
    //   90: ldc 94
    //   92: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_3
    //   97: astore 4
    //   99: aload 6
    //   101: aload 5
    //   103: invokevirtual 101	java/lang/Exception:toString	()Ljava/lang/String;
    //   106: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_3
    //   111: astore 4
    //   113: ldc 27
    //   115: aload 6
    //   117: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 108	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_3
    //   124: ifnull +13 -> 137
    //   127: aload_3
    //   128: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   131: ifeq +6 -> 137
    //   134: goto -72 -> 62
    //   137: return
    //   138: aload 4
    //   140: ifnull +16 -> 156
    //   143: aload 4
    //   145: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   148: ifeq +8 -> 156
    //   151: aload 4
    //   153: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   156: goto +5 -> 161
    //   159: aload_3
    //   160: athrow
    //   161: goto -2 -> 159
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	SessionDbHelper
    //   0	164	1	paramLong	long
    //   7	56	3	localObject1	Object
    //   67	93	3	localObject2	Object
    //   9	143	4	localObject3	Object
    //   18	42	5	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   71	31	5	localException	java.lang.Exception
    //   4	112	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   11	20	67	finally
    //   27	46	67	finally
    //   76	85	67	finally
    //   88	96	67	finally
    //   99	110	67	finally
    //   113	123	67	finally
    //   11	20	71	java/lang/Exception
    //   27	46	71	java/lang/Exception
  }
  
  public void close()
  {
    this.mOpenHelper.close();
  }
  
  /* Error */
  public void delete(long paramLong, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: lload_1
    //   1: invokestatic 70	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 5
    //   9: aconst_null
    //   10: astore 6
    //   12: aload_0
    //   13: getfield 60	com/tencent/upload/network/session/cache/SessionDbHelper:mOpenHelper	Lcom/tencent/upload/network/session/cache/SessionDbHelper$DatabaseHelper;
    //   16: invokevirtual 74	com/tencent/upload/network/session/cache/SessionDbHelper$DatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: astore 7
    //   21: aload 7
    //   23: astore 6
    //   25: aload 7
    //   27: astore 5
    //   29: aload 7
    //   31: ldc 23
    //   33: ldc 112
    //   35: iconst_2
    //   36: anewarray 40	java/lang/String
    //   39: dup
    //   40: iconst_0
    //   41: aload 8
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload_3
    //   47: aastore
    //   48: invokevirtual 82	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   51: pop
    //   52: aload 7
    //   54: ifnull +132 -> 186
    //   57: aload 7
    //   59: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   62: ifeq +124 -> 186
    //   65: aload 7
    //   67: astore 5
    //   69: aload 5
    //   71: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   74: return
    //   75: astore_3
    //   76: goto +111 -> 187
    //   79: astore 7
    //   81: aload 5
    //   83: astore 6
    //   85: new 91	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   92: astore 8
    //   94: aload 5
    //   96: astore 6
    //   98: aload 8
    //   100: ldc 114
    //   102: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 5
    //   108: astore 6
    //   110: aload 8
    //   112: aload_3
    //   113: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 5
    //   119: astore 6
    //   121: aload 8
    //   123: ldc 116
    //   125: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 5
    //   131: astore 6
    //   133: aload 8
    //   135: aload 4
    //   137: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: pop
    //   141: aload 5
    //   143: astore 6
    //   145: aload 8
    //   147: aload 7
    //   149: invokevirtual 101	java/lang/Exception:toString	()Ljava/lang/String;
    //   152: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 5
    //   158: astore 6
    //   160: ldc 27
    //   162: aload 8
    //   164: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 108	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   170: aload 5
    //   172: ifnull +14 -> 186
    //   175: aload 5
    //   177: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   180: ifeq +6 -> 186
    //   183: goto -114 -> 69
    //   186: return
    //   187: aload 6
    //   189: ifnull +16 -> 205
    //   192: aload 6
    //   194: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   197: ifeq +8 -> 205
    //   200: aload 6
    //   202: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   205: goto +5 -> 210
    //   208: aload_3
    //   209: athrow
    //   210: goto -2 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	SessionDbHelper
    //   0	213	1	paramLong	long
    //   0	213	3	paramString1	String
    //   0	213	4	paramString2	String
    //   7	169	5	localObject1	Object
    //   10	191	6	localObject2	Object
    //   19	47	7	localSQLiteDatabase	android.database.sqlite.SQLiteDatabase
    //   79	69	7	localException	java.lang.Exception
    //   4	159	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   12	21	75	finally
    //   29	52	75	finally
    //   85	94	75	finally
    //   98	106	75	finally
    //   110	117	75	finally
    //   121	129	75	finally
    //   133	141	75	finally
    //   145	156	75	finally
    //   160	170	75	finally
    //   12	21	79	java/lang/Exception
    //   29	52	79	java/lang/Exception
  }
  
  /* Error */
  public void insert(long paramLong, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 119	android/content/ContentValues
    //   3: dup
    //   4: invokespecial 120	android/content/ContentValues:<init>	()V
    //   7: astore 10
    //   9: invokestatic 126	java/lang/System:currentTimeMillis	()J
    //   12: lstore 5
    //   14: aload 10
    //   16: ldc 30
    //   18: lload_1
    //   19: invokestatic 130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   22: invokevirtual 134	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   25: aload 10
    //   27: ldc 17
    //   29: aload_3
    //   30: invokevirtual 136	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aload 10
    //   35: ldc 23
    //   37: aload 4
    //   39: invokevirtual 136	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload 10
    //   44: ldc 20
    //   46: lload 5
    //   48: invokestatic 130	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   51: invokevirtual 134	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   54: aconst_null
    //   55: astore 9
    //   57: aconst_null
    //   58: astore 7
    //   60: aload_0
    //   61: getfield 60	com/tencent/upload/network/session/cache/SessionDbHelper:mOpenHelper	Lcom/tencent/upload/network/session/cache/SessionDbHelper$DatabaseHelper;
    //   64: invokevirtual 74	com/tencent/upload/network/session/cache/SessionDbHelper$DatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   67: astore 8
    //   69: aload 8
    //   71: ldc 23
    //   73: aconst_null
    //   74: aload 10
    //   76: invokevirtual 139	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   79: pop2
    //   80: aload 8
    //   82: ifnull +124 -> 206
    //   85: aload 8
    //   87: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   90: ifeq +116 -> 206
    //   93: aload 8
    //   95: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   98: return
    //   99: astore_3
    //   100: aload 8
    //   102: astore 7
    //   104: goto +103 -> 207
    //   107: goto +7 -> 114
    //   110: astore_3
    //   111: goto +96 -> 207
    //   114: aload 8
    //   116: astore 7
    //   118: new 91	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   125: astore 9
    //   127: aload 8
    //   129: astore 7
    //   131: aload 9
    //   133: ldc 141
    //   135: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 8
    //   141: astore 7
    //   143: aload 9
    //   145: aload_3
    //   146: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload 8
    //   152: astore 7
    //   154: aload 9
    //   156: ldc 116
    //   158: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 8
    //   164: astore 7
    //   166: aload 9
    //   168: aload 4
    //   170: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 8
    //   176: astore 7
    //   178: ldc 27
    //   180: aload 9
    //   182: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 108	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload 8
    //   190: ifnull +16 -> 206
    //   193: aload 8
    //   195: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   198: ifeq +8 -> 206
    //   201: aload 8
    //   203: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   206: return
    //   207: aload 7
    //   209: ifnull +16 -> 225
    //   212: aload 7
    //   214: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   217: ifeq +8 -> 225
    //   220: aload 7
    //   222: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   225: aload_3
    //   226: athrow
    //   227: astore 7
    //   229: aload 9
    //   231: astore 8
    //   233: goto -119 -> 114
    //   236: astore 7
    //   238: goto -131 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	241	0	this	SessionDbHelper
    //   0	241	1	paramLong	long
    //   0	241	3	paramString1	String
    //   0	241	4	paramString2	String
    //   12	35	5	l	long
    //   58	163	7	localObject1	Object
    //   227	1	7	localException1	java.lang.Exception
    //   236	1	7	localException2	java.lang.Exception
    //   67	165	8	localObject2	Object
    //   55	175	9	localStringBuilder	java.lang.StringBuilder
    //   7	68	10	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   69	80	99	finally
    //   60	69	110	finally
    //   118	127	110	finally
    //   131	139	110	finally
    //   143	150	110	finally
    //   154	162	110	finally
    //   166	174	110	finally
    //   178	188	110	finally
    //   60	69	227	java/lang/Exception
    //   69	80	236	java/lang/Exception
  }
  
  /* Error */
  public String query(long paramLong, String paramString)
  {
    // Byte code:
    //   0: lload_1
    //   1: invokestatic 70	java/lang/Long:toString	(J)Ljava/lang/String;
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 10
    //   12: aconst_null
    //   13: astore 5
    //   15: aload_0
    //   16: getfield 60	com/tencent/upload/network/session/cache/SessionDbHelper:mOpenHelper	Lcom/tencent/upload/network/session/cache/SessionDbHelper$DatabaseHelper;
    //   19: invokevirtual 74	com/tencent/upload/network/session/cache/SessionDbHelper$DatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore 4
    //   24: aload 4
    //   26: ldc 23
    //   28: getstatic 44	com/tencent/upload/network/session/cache/SessionDbHelper:columns	[Ljava/lang/String;
    //   31: ldc 112
    //   33: iconst_2
    //   34: anewarray 40	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: aload 6
    //   41: aastore
    //   42: dup
    //   43: iconst_1
    //   44: aload_3
    //   45: aastore
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: invokevirtual 146	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   52: astore 6
    //   54: aload 5
    //   56: astore_3
    //   57: aload 6
    //   59: ifnull +60 -> 119
    //   62: aload 5
    //   64: astore_3
    //   65: aload 4
    //   67: astore 5
    //   69: aload 6
    //   71: astore 7
    //   73: aload 6
    //   75: invokeinterface 151 1 0
    //   80: ifeq +39 -> 119
    //   83: aload 4
    //   85: astore 5
    //   87: aload 6
    //   89: astore 7
    //   91: aload 6
    //   93: aload 6
    //   95: ldc 23
    //   97: invokeinterface 155 2 0
    //   102: invokeinterface 159 2 0
    //   107: astore_3
    //   108: goto +11 -> 119
    //   111: astore 8
    //   113: aload 6
    //   115: astore_3
    //   116: goto +88 -> 204
    //   119: aload 4
    //   121: ifnull +16 -> 137
    //   124: aload 4
    //   126: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   129: ifeq +8 -> 137
    //   132: aload 4
    //   134: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   137: aload_3
    //   138: astore 4
    //   140: aload 6
    //   142: ifnull +177 -> 319
    //   145: aload_3
    //   146: astore 4
    //   148: aload 6
    //   150: invokeinterface 162 1 0
    //   155: ifne +164 -> 319
    //   158: aload_3
    //   159: astore 4
    //   161: aload 6
    //   163: invokeinterface 163 1 0
    //   168: aload 4
    //   170: areturn
    //   171: astore_3
    //   172: aconst_null
    //   173: astore 7
    //   175: goto +152 -> 327
    //   178: astore 8
    //   180: aconst_null
    //   181: astore_3
    //   182: goto +22 -> 204
    //   185: astore_3
    //   186: aconst_null
    //   187: astore 7
    //   189: aload 7
    //   191: astore 4
    //   193: goto +134 -> 327
    //   196: astore 8
    //   198: aconst_null
    //   199: astore 4
    //   201: aload 4
    //   203: astore_3
    //   204: aload 4
    //   206: astore 5
    //   208: aload_3
    //   209: astore 7
    //   211: new 91	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   218: astore 6
    //   220: aload 4
    //   222: astore 5
    //   224: aload_3
    //   225: astore 7
    //   227: aload 6
    //   229: ldc 165
    //   231: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 4
    //   237: astore 5
    //   239: aload_3
    //   240: astore 7
    //   242: aload 6
    //   244: aload 8
    //   246: invokevirtual 101	java/lang/Exception:toString	()Ljava/lang/String;
    //   249: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 4
    //   255: astore 5
    //   257: aload_3
    //   258: astore 7
    //   260: ldc 27
    //   262: aload 6
    //   264: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 108	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload 4
    //   272: ifnull +16 -> 288
    //   275: aload 4
    //   277: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   280: ifeq +8 -> 288
    //   283: aload 4
    //   285: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   288: aload 10
    //   290: astore 4
    //   292: aload_3
    //   293: ifnull +26 -> 319
    //   296: aload 10
    //   298: astore 4
    //   300: aload_3
    //   301: invokeinterface 162 1 0
    //   306: ifne +13 -> 319
    //   309: aload 9
    //   311: astore 4
    //   313: aload_3
    //   314: astore 6
    //   316: goto -155 -> 161
    //   319: aload 4
    //   321: areturn
    //   322: astore_3
    //   323: aload 5
    //   325: astore 4
    //   327: aload 4
    //   329: ifnull +16 -> 345
    //   332: aload 4
    //   334: invokevirtual 86	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   337: ifeq +8 -> 345
    //   340: aload 4
    //   342: invokevirtual 89	android/database/sqlite/SQLiteDatabase:close	()V
    //   345: aload 7
    //   347: ifnull +20 -> 367
    //   350: aload 7
    //   352: invokeinterface 162 1 0
    //   357: ifne +10 -> 367
    //   360: aload 7
    //   362: invokeinterface 163 1 0
    //   367: goto +5 -> 372
    //   370: aload_3
    //   371: athrow
    //   372: goto -2 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	375	0	this	SessionDbHelper
    //   0	375	1	paramLong	long
    //   0	375	3	paramString	String
    //   22	319	4	localObject1	Object
    //   13	311	5	localObject2	Object
    //   4	311	6	localObject3	Object
    //   71	290	7	localObject4	Object
    //   111	1	8	localException1	java.lang.Exception
    //   178	1	8	localException2	java.lang.Exception
    //   196	49	8	localException3	java.lang.Exception
    //   7	303	9	localObject5	Object
    //   10	287	10	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   73	83	111	java/lang/Exception
    //   91	108	111	java/lang/Exception
    //   24	54	171	finally
    //   24	54	178	java/lang/Exception
    //   15	24	185	finally
    //   15	24	196	java/lang/Exception
    //   73	83	322	finally
    //   91	108	322	finally
    //   211	220	322	finally
    //   227	235	322	finally
    //   242	253	322	finally
    //   260	270	322	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.network.session.cache.SessionDbHelper
 * JD-Core Version:    0.7.0.1
 */