package com.tencent.open.agent.report;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;

public class ReportDatabaseHelper
  extends SQLiteOpenHelper
{
  protected static ReportDatabaseHelper a;
  protected static final String[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "key" };
  }
  
  public ReportDatabaseHelper(Context paramContext)
  {
    super(paramContext, "agent_report.db", null, 2);
  }
  
  public static ReportDatabaseHelper a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenAgentReportReportDatabaseHelper == null) {
        jdField_a_of_type_ComTencentOpenAgentReportReportDatabaseHelper = new ReportDatabaseHelper(CommonDataAdapter.a().a());
      }
      ReportDatabaseHelper localReportDatabaseHelper = jdField_a_of_type_ComTencentOpenAgentReportReportDatabaseHelper;
      return localReportDatabaseHelper;
    }
    finally {}
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore_3
    //   7: iconst_0
    //   8: istore_2
    //   9: iload_3
    //   10: ifeq +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iconst_0
    //   16: ireturn
    //   17: aload_0
    //   18: invokevirtual 47	com/tencent/open/agent/report/ReportDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore 5
    //   23: aload 5
    //   25: ifnonnull +7 -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: iconst_0
    //   31: ireturn
    //   32: aconst_null
    //   33: astore 4
    //   35: aload 5
    //   37: ldc 49
    //   39: getstatic 15	com/tencent/open/agent/report/ReportDatabaseHelper:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   42: ldc 51
    //   44: iconst_1
    //   45: anewarray 11	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: aload_1
    //   51: aastore
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 57	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +13 -> 73
    //   63: aload_1
    //   64: astore 4
    //   66: aload_1
    //   67: invokeinterface 63 1 0
    //   72: istore_2
    //   73: aload_1
    //   74: ifnull +9 -> 83
    //   77: aload_1
    //   78: invokeinterface 66 1 0
    //   83: aload 5
    //   85: ifnull +8 -> 93
    //   88: aload 5
    //   90: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   93: aload_0
    //   94: monitorexit
    //   95: iload_2
    //   96: ireturn
    //   97: astore_1
    //   98: aload 4
    //   100: ifnull +10 -> 110
    //   103: aload 4
    //   105: invokeinterface 66 1 0
    //   110: aload 5
    //   112: ifnull +8 -> 120
    //   115: aload 5
    //   117: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   120: aload_1
    //   121: athrow
    //   122: astore_1
    //   123: aload_0
    //   124: monitorexit
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	ReportDatabaseHelper
    //   0	127	1	paramString	String
    //   8	88	2	i	int
    //   6	4	3	bool	boolean
    //   33	71	4	str	String
    //   21	95	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   35	59	97	finally
    //   66	73	97	finally
    //   2	7	122	finally
    //   17	23	122	finally
    //   77	83	122	finally
    //   88	93	122	finally
    //   103	110	122	finally
    //   115	120	122	finally
    //   120	122	122	finally
  }
  
  /* Error */
  public java.util.List<java.lang.Integer> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 72	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 74	java/util/ArrayList:<init>	()V
    //   9: astore_3
    //   10: aload_0
    //   11: invokevirtual 77	com/tencent/open/agent/report/ReportDatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 4
    //   16: aload 4
    //   18: ifnonnull +7 -> 25
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_3
    //   24: areturn
    //   25: aload 4
    //   27: ldc 79
    //   29: aconst_null
    //   30: invokevirtual 83	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +67 -> 102
    //   38: aload_2
    //   39: invokeinterface 87 1 0
    //   44: ifeq +58 -> 102
    //   47: aload_2
    //   48: aload_2
    //   49: ldc 89
    //   51: invokeinterface 92 2 0
    //   56: invokeinterface 96 2 0
    //   61: astore 5
    //   63: aload_3
    //   64: aload 5
    //   66: invokestatic 102	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   69: invokevirtual 105	java/lang/Integer:intValue	()I
    //   72: invokestatic 108	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   75: invokeinterface 114 2 0
    //   80: pop
    //   81: aload_2
    //   82: invokeinterface 117 1 0
    //   87: istore_1
    //   88: iload_1
    //   89: ifne -42 -> 47
    //   92: goto +10 -> 102
    //   95: astore_3
    //   96: goto +33 -> 129
    //   99: goto +52 -> 151
    //   102: aload 4
    //   104: ifnull +8 -> 112
    //   107: aload 4
    //   109: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   112: aload_2
    //   113: ifnull +9 -> 122
    //   116: aload_2
    //   117: invokeinterface 66 1 0
    //   122: aload_0
    //   123: monitorexit
    //   124: aload_3
    //   125: areturn
    //   126: astore_3
    //   127: aconst_null
    //   128: astore_2
    //   129: aload 4
    //   131: ifnull +8 -> 139
    //   134: aload 4
    //   136: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   139: aload_2
    //   140: ifnull +9 -> 149
    //   143: aload_2
    //   144: invokeinterface 66 1 0
    //   149: aload_3
    //   150: athrow
    //   151: aload 4
    //   153: ifnull +8 -> 161
    //   156: aload 4
    //   158: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   161: aload_2
    //   162: ifnull +9 -> 171
    //   165: aload_2
    //   166: invokeinterface 66 1 0
    //   171: aload_0
    //   172: monitorexit
    //   173: aconst_null
    //   174: areturn
    //   175: astore_2
    //   176: aload_0
    //   177: monitorexit
    //   178: goto +5 -> 183
    //   181: aload_2
    //   182: athrow
    //   183: goto -2 -> 181
    //   186: astore_2
    //   187: goto +12 -> 199
    //   190: astore_3
    //   191: goto -92 -> 99
    //   194: astore 5
    //   196: goto -115 -> 81
    //   199: aconst_null
    //   200: astore_2
    //   201: goto -50 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	204	0	this	ReportDatabaseHelper
    //   87	2	1	bool	boolean
    //   33	133	2	localCursor	android.database.Cursor
    //   175	7	2	localObject1	Object
    //   186	1	2	localException1	Exception
    //   200	1	2	localObject2	Object
    //   9	55	3	localArrayList	java.util.ArrayList
    //   95	30	3	localList	java.util.List<java.lang.Integer>
    //   126	24	3	localObject3	Object
    //   190	1	3	localException2	Exception
    //   14	143	4	localSQLiteDatabase	SQLiteDatabase
    //   61	4	5	str	String
    //   194	1	5	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   38	47	95	finally
    //   47	63	95	finally
    //   63	81	95	finally
    //   81	88	95	finally
    //   25	34	126	finally
    //   2	16	175	finally
    //   107	112	175	finally
    //   116	122	175	finally
    //   134	139	175	finally
    //   143	149	175	finally
    //   149	151	175	finally
    //   156	161	175	finally
    //   165	171	175	finally
    //   25	34	186	java/lang/Exception
    //   38	47	190	java/lang/Exception
    //   47	63	190	java/lang/Exception
    //   81	88	190	java/lang/Exception
    //   63	81	194	java/lang/Exception
  }
  
  /* Error */
  public java.util.List<java.io.Serializable> a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 72	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 74	java/util/ArrayList:<init>	()V
    //   9: astore 7
    //   11: aload_1
    //   12: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: istore_2
    //   16: iload_2
    //   17: ifeq +8 -> 25
    //   20: aload_0
    //   21: monitorexit
    //   22: aload 7
    //   24: areturn
    //   25: aload_0
    //   26: invokevirtual 47	com/tencent/open/agent/report/ReportDatabaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore 5
    //   31: aload 5
    //   33: ifnonnull +8 -> 41
    //   36: aload_0
    //   37: monitorexit
    //   38: aload 7
    //   40: areturn
    //   41: aload 5
    //   43: ldc 49
    //   45: aconst_null
    //   46: ldc 51
    //   48: iconst_1
    //   49: anewarray 11	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload_1
    //   55: aastore
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: invokevirtual 57	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   62: astore 4
    //   64: aload 4
    //   66: ifnull +152 -> 218
    //   69: aload 4
    //   71: invokeinterface 63 1 0
    //   76: ifle +142 -> 218
    //   79: aload 4
    //   81: invokeinterface 87 1 0
    //   86: pop
    //   87: new 124	java/io/ByteArrayInputStream
    //   90: dup
    //   91: aload 4
    //   93: aload 4
    //   95: ldc 126
    //   97: invokeinterface 92 2 0
    //   102: invokeinterface 130 2 0
    //   107: invokespecial 133	java/io/ByteArrayInputStream:<init>	([B)V
    //   110: astore 6
    //   112: new 135	java/io/ObjectInputStream
    //   115: dup
    //   116: aload 6
    //   118: invokespecial 138	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   121: astore_1
    //   122: aload_1
    //   123: invokevirtual 142	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   126: checkcast 144	java/io/Serializable
    //   129: astore_3
    //   130: aload_1
    //   131: invokevirtual 145	java/io/ObjectInputStream:close	()V
    //   134: aload 6
    //   136: invokevirtual 146	java/io/ByteArrayInputStream:close	()V
    //   139: aload_3
    //   140: astore_1
    //   141: goto +42 -> 183
    //   144: astore_3
    //   145: goto +6 -> 151
    //   148: astore_3
    //   149: aconst_null
    //   150: astore_1
    //   151: aload_1
    //   152: ifnull +7 -> 159
    //   155: aload_1
    //   156: invokevirtual 145	java/io/ObjectInputStream:close	()V
    //   159: aload 6
    //   161: invokevirtual 146	java/io/ByteArrayInputStream:close	()V
    //   164: aload_3
    //   165: athrow
    //   166: aconst_null
    //   167: astore_1
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 145	java/io/ObjectInputStream:close	()V
    //   176: aload 6
    //   178: invokevirtual 146	java/io/ByteArrayInputStream:close	()V
    //   181: aconst_null
    //   182: astore_1
    //   183: aload_1
    //   184: ifnull +12 -> 196
    //   187: aload 7
    //   189: aload_1
    //   190: invokeinterface 114 2 0
    //   195: pop
    //   196: aload 4
    //   198: invokeinterface 117 1 0
    //   203: istore_2
    //   204: iload_2
    //   205: ifne -118 -> 87
    //   208: goto +10 -> 218
    //   211: astore_1
    //   212: aload 4
    //   214: astore_3
    //   215: goto +33 -> 248
    //   218: aload 4
    //   220: ifnull +10 -> 230
    //   223: aload 4
    //   225: invokeinterface 66 1 0
    //   230: aload 5
    //   232: ifnull +8 -> 240
    //   235: aload 5
    //   237: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   240: aload_0
    //   241: monitorexit
    //   242: aload 7
    //   244: areturn
    //   245: astore_1
    //   246: aconst_null
    //   247: astore_3
    //   248: aload_3
    //   249: ifnull +9 -> 258
    //   252: aload_3
    //   253: invokeinterface 66 1 0
    //   258: aload 5
    //   260: ifnull +8 -> 268
    //   263: aload 5
    //   265: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   268: aload_1
    //   269: athrow
    //   270: astore_1
    //   271: aload_0
    //   272: monitorexit
    //   273: goto +5 -> 278
    //   276: aload_1
    //   277: athrow
    //   278: goto -2 -> 276
    //   281: astore_1
    //   282: goto -116 -> 166
    //   285: astore_3
    //   286: goto -118 -> 168
    //   289: astore_1
    //   290: goto -156 -> 134
    //   293: astore_1
    //   294: aload_3
    //   295: astore_1
    //   296: goto -113 -> 183
    //   299: astore_1
    //   300: goto -141 -> 159
    //   303: astore_1
    //   304: goto -140 -> 164
    //   307: astore_1
    //   308: goto -132 -> 176
    //   311: astore_1
    //   312: goto -131 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	ReportDatabaseHelper
    //   0	315	1	paramString	String
    //   15	190	2	bool	boolean
    //   129	11	3	localSerializable	java.io.Serializable
    //   144	1	3	localObject1	Object
    //   148	17	3	localObject2	Object
    //   214	39	3	localCursor1	android.database.Cursor
    //   285	10	3	localException	Exception
    //   62	162	4	localCursor2	android.database.Cursor
    //   29	235	5	localSQLiteDatabase	SQLiteDatabase
    //   110	67	6	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   9	234	7	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   122	130	144	finally
    //   112	122	148	finally
    //   69	87	211	finally
    //   87	112	211	finally
    //   130	134	211	finally
    //   134	139	211	finally
    //   155	159	211	finally
    //   159	164	211	finally
    //   164	166	211	finally
    //   172	176	211	finally
    //   176	181	211	finally
    //   187	196	211	finally
    //   196	204	211	finally
    //   41	64	245	finally
    //   2	16	270	finally
    //   25	31	270	finally
    //   223	230	270	finally
    //   235	240	270	finally
    //   252	258	270	finally
    //   263	268	270	finally
    //   268	270	270	finally
    //   112	122	281	java/lang/Exception
    //   122	130	285	java/lang/Exception
    //   130	134	289	java/io/IOException
    //   134	139	293	java/io/IOException
    //   155	159	299	java/io/IOException
    //   159	164	303	java/io/IOException
    //   172	176	307	java/io/IOException
    //   176	181	311	java/io/IOException
  }
  
  public void a(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      SQLiteDatabase localSQLiteDatabase = getWritableDatabase();
      if (localSQLiteDatabase == null) {
        return;
      }
      localSQLiteDatabase.delete("via_cgi_report", "type = ?", new String[] { paramString });
      localSQLiteDatabase.close();
      return;
    }
    finally {}
  }
  
  /* Error */
  public void a(String paramString, java.util.List<java.io.Serializable> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokeinterface 156 1 0
    //   8: istore_3
    //   9: aload_1
    //   10: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifne +234 -> 247
    //   16: iload_3
    //   17: ifne +272 -> 289
    //   20: goto +227 -> 247
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 158	com/tencent/open/agent/report/ReportDatabaseHelper:a	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: invokevirtual 77	com/tencent/open/agent/report/ReportDatabaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: astore 7
    //   34: aload 7
    //   36: ifnonnull +6 -> 42
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload 7
    //   44: invokevirtual 161	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   47: new 163	android/content/ContentValues
    //   50: dup
    //   51: invokespecial 164	android/content/ContentValues:<init>	()V
    //   54: astore 9
    //   56: iconst_0
    //   57: istore 4
    //   59: iload 4
    //   61: iload_3
    //   62: if_icmpge +154 -> 216
    //   65: aload_2
    //   66: iload 4
    //   68: invokeinterface 168 2 0
    //   73: checkcast 144	java/io/Serializable
    //   76: astore 10
    //   78: aload 10
    //   80: ifnull +122 -> 202
    //   83: aload 9
    //   85: ldc 89
    //   87: aload_1
    //   88: invokevirtual 172	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: new 174	java/io/ByteArrayOutputStream
    //   94: dup
    //   95: sipush 512
    //   98: invokespecial 177	java/io/ByteArrayOutputStream:<init>	(I)V
    //   101: astore 8
    //   103: aconst_null
    //   104: astore 6
    //   106: new 179	java/io/ObjectOutputStream
    //   109: dup
    //   110: aload 8
    //   112: invokespecial 182	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   115: astore 5
    //   117: aload 5
    //   119: aload 10
    //   121: invokevirtual 186	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   124: aload 5
    //   126: invokevirtual 187	java/io/ObjectOutputStream:close	()V
    //   129: aload 8
    //   131: invokevirtual 188	java/io/ByteArrayOutputStream:close	()V
    //   134: goto +45 -> 179
    //   137: astore_1
    //   138: aload 5
    //   140: astore_2
    //   141: goto +7 -> 148
    //   144: astore_1
    //   145: aload 6
    //   147: astore_2
    //   148: aload_2
    //   149: ifnull +7 -> 156
    //   152: aload_2
    //   153: invokevirtual 187	java/io/ObjectOutputStream:close	()V
    //   156: aload 8
    //   158: invokevirtual 188	java/io/ByteArrayOutputStream:close	()V
    //   161: aload_1
    //   162: athrow
    //   163: aconst_null
    //   164: astore 5
    //   166: aload 5
    //   168: ifnull -39 -> 129
    //   171: aload 5
    //   173: invokevirtual 187	java/io/ObjectOutputStream:close	()V
    //   176: goto -47 -> 129
    //   179: aload 9
    //   181: ldc 126
    //   183: aload 8
    //   185: invokevirtual 192	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   188: invokevirtual 195	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   191: aload 7
    //   193: ldc 49
    //   195: aconst_null
    //   196: aload 9
    //   198: invokevirtual 199	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   201: pop2
    //   202: aload 9
    //   204: invokevirtual 202	android/content/ContentValues:clear	()V
    //   207: iload 4
    //   209: iconst_1
    //   210: iadd
    //   211: istore 4
    //   213: goto -154 -> 59
    //   216: aload 7
    //   218: invokevirtual 205	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   221: aload 7
    //   223: invokevirtual 208	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   226: aload 7
    //   228: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   231: aload_0
    //   232: monitorexit
    //   233: return
    //   234: astore_1
    //   235: aload 7
    //   237: invokevirtual 208	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   240: aload 7
    //   242: invokevirtual 67	android/database/sqlite/SQLiteDatabase:close	()V
    //   245: aload_1
    //   246: athrow
    //   247: aload_0
    //   248: monitorexit
    //   249: return
    //   250: astore_1
    //   251: aload_0
    //   252: monitorexit
    //   253: goto +5 -> 258
    //   256: aload_1
    //   257: athrow
    //   258: goto -2 -> 256
    //   261: astore 5
    //   263: goto -100 -> 163
    //   266: astore 6
    //   268: goto -102 -> 166
    //   271: astore 5
    //   273: goto -144 -> 129
    //   276: astore 5
    //   278: goto -99 -> 179
    //   281: astore_2
    //   282: goto -126 -> 156
    //   285: astore_2
    //   286: goto -125 -> 161
    //   289: iload_3
    //   290: bipush 20
    //   292: if_icmpgt +6 -> 298
    //   295: goto -272 -> 23
    //   298: bipush 20
    //   300: istore_3
    //   301: goto -278 -> 23
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	this	ReportDatabaseHelper
    //   0	304	1	paramString	String
    //   0	304	2	paramList	java.util.List<java.io.Serializable>
    //   8	293	3	i	int
    //   57	155	4	j	int
    //   115	57	5	localObjectOutputStream	java.io.ObjectOutputStream
    //   261	1	5	localIOException1	java.io.IOException
    //   271	1	5	localIOException2	java.io.IOException
    //   276	1	5	localIOException3	java.io.IOException
    //   104	42	6	localObject	Object
    //   266	1	6	localIOException4	java.io.IOException
    //   32	209	7	localSQLiteDatabase	SQLiteDatabase
    //   101	83	8	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   54	149	9	localContentValues	android.content.ContentValues
    //   76	44	10	localSerializable	java.io.Serializable
    // Exception table:
    //   from	to	target	type
    //   117	124	137	finally
    //   106	117	144	finally
    //   47	56	234	finally
    //   65	78	234	finally
    //   83	103	234	finally
    //   124	129	234	finally
    //   129	134	234	finally
    //   152	156	234	finally
    //   156	161	234	finally
    //   161	163	234	finally
    //   171	176	234	finally
    //   179	202	234	finally
    //   202	207	234	finally
    //   216	221	234	finally
    //   2	16	250	finally
    //   23	34	250	finally
    //   42	47	250	finally
    //   221	231	250	finally
    //   235	247	250	finally
    //   106	117	261	java/io/IOException
    //   117	124	266	java/io/IOException
    //   124	129	271	java/io/IOException
    //   171	176	271	java/io/IOException
    //   129	134	276	java/io/IOException
    //   152	156	281	java/io/IOException
    //   156	161	285	java/io/IOException
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getReadableDatabase();
      return localSQLiteDatabase;
    }
    catch (Exception localException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public SQLiteDatabase getWritableDatabase()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = super.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (Exception localException)
    {
      label7:
      break label7;
    }
    return null;
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS via_cgi_report( _id INTEGER PRIMARY KEY,key TEXT,type TEXT,blob BLOB);");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS via_cgi_report");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.report.ReportDatabaseHelper
 * JD-Core Version:    0.7.0.1
 */