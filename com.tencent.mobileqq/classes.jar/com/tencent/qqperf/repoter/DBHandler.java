package com.tencent.qqperf.repoter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class DBHandler
{
  private static final long jdField_a_of_type_Long = ;
  private static DBHandler jdField_a_of_type_ComTencentQqperfRepoterDBHandler;
  private SQLiteDatabase jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
  private DBHelper jdField_a_of_type_ComTencentQqperfRepoterDBHelper;
  
  private DBHandler(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentQqperfRepoterDBHelper = DBHelper.a(paramContext);
    try
    {
      this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentQqperfRepoterDBHelper.getWritableDatabase();
      return;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Magnifier_DBHandler", 2, paramContext, new Object[0]);
      }
    }
  }
  
  private int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
    if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen())) {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Magnifier_DBHandler", 2, new Object[] { "dropframe delete table", paramString1 });
        }
        int i = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
        return i;
      }
      catch (Throwable paramString1)
      {
        QLog.e("Magnifier_DBHandler", 1, "delete dropframe table has a exception", paramString1);
        return -1;
      }
    }
    return -2;
  }
  
  public static DBHandler a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentQqperfRepoterDBHandler == null) {
      try
      {
        if (jdField_a_of_type_ComTencentQqperfRepoterDBHandler == null) {
          jdField_a_of_type_ComTencentQqperfRepoterDBHandler = new DBHandler(paramContext);
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentQqperfRepoterDBHandler;
  }
  
  private ResultObject a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    ResultObject localResultObject = new ResultObject();
    localResultObject.dbId = paramCursor.getInt(paramCursor.getColumnIndex("_id"));
    localResultObject.params = new JSONObject(paramCursor.getString(paramCursor.getColumnIndex("params")));
    boolean bool;
    if (paramCursor.getInt(paramCursor.getColumnIndex("is_real_time")) > 0) {
      bool = true;
    } else {
      bool = false;
    }
    localResultObject.isRealTime = bool;
    localResultObject.uin = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
    return localResultObject;
  }
  
  public int a()
  {
    return a("result_objects", null, null);
  }
  
  public int a(String paramString, long paramLong, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
    if ((localObject != null) && (((SQLiteDatabase)localObject).isOpen()))
    {
      if ((paramInt != 1) && (paramInt != 2)) {
        return -1;
      }
      localObject = new ContentValues();
      ((ContentValues)localObject).put("status", Integer.valueOf(paramInt));
      try
      {
        SQLiteDatabase localSQLiteDatabase = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("_id=");
        localStringBuilder.append(paramLong);
        paramInt = localSQLiteDatabase.update(paramString, (ContentValues)localObject, localStringBuilder.toString(), null);
        return paramInt;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Magnifier_DBHandler", 2, paramString, new Object[0]);
        }
        return -1;
      }
    }
    return -2;
  }
  
  public int a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return a(paramString, "status=? OR occur_time<?", new String[] { String.valueOf(2), String.valueOf(System.currentTimeMillis() - 86400000L) });
    }
    return a(paramString, "status=?", new String[] { String.valueOf(2) });
  }
  
  public long a(ResultObject paramResultObject)
  {
    Object localObject = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase;
    if ((localObject != null) && (((SQLiteDatabase)localObject).isOpen()))
    {
      localObject = new ContentValues();
      ((ContentValues)localObject).put("params", paramResultObject.params.toString());
      ((ContentValues)localObject).put("is_real_time", Boolean.valueOf(paramResultObject.isRealTime));
      ((ContentValues)localObject).put("uin", Long.valueOf(paramResultObject.uin));
      ((ContentValues)localObject).put("status", Integer.valueOf(1));
    }
    try
    {
      l1 = paramResultObject.params.getJSONObject("clientinfo").optLong("event_time");
    }
    catch (Exception paramResultObject)
    {
      long l1;
      label102:
      long l2;
      break label102;
    }
    l1 = 0L;
    l2 = l1;
    if (l1 == 0L) {
      l2 = jdField_a_of_type_Long;
    }
    ((ContentValues)localObject).put("occur_time", Long.valueOf(l2));
    try
    {
      l1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insert("result_objects", "name", (ContentValues)localObject);
      return l1;
    }
    catch (Exception paramResultObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Magnifier_DBHandler", 2, paramResultObject, new Object[0]);
      }
      return -1L;
    }
    return -2L;
  }
  
  /* Error */
  public java.util.List<ResultObject> a(boolean paramBoolean)
  {
    // Byte code:
    //   0: invokestatic 17	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: new 229	java/util/ArrayList
    //   7: dup
    //   8: invokespecial 230	java/util/ArrayList:<init>	()V
    //   11: astore 7
    //   13: aload_0
    //   14: getfield 39	com/tencent/qqperf/repoter/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 4
    //   19: aload 4
    //   21: ifnull +271 -> 292
    //   24: aload 4
    //   26: invokevirtual 59	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   29: ifne +6 -> 35
    //   32: aload 7
    //   34: areturn
    //   35: aconst_null
    //   36: astore 4
    //   38: aconst_null
    //   39: astore 6
    //   41: iconst_1
    //   42: iload_1
    //   43: if_icmpne +45 -> 88
    //   46: aload_0
    //   47: getfield 39	com/tencent/qqperf/repoter/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   50: ldc 129
    //   52: aconst_null
    //   53: ldc 232
    //   55: iconst_2
    //   56: anewarray 172	java/lang/String
    //   59: dup
    //   60: iconst_0
    //   61: iconst_1
    //   62: invokestatic 174	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: lload_2
    //   69: ldc2_w 175
    //   72: lsub
    //   73: invokestatic 179	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   76: aastore
    //   77: aconst_null
    //   78: aconst_null
    //   79: aconst_null
    //   80: invokevirtual 236	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   83: astore 5
    //   85: goto +20 -> 105
    //   88: aload_0
    //   89: getfield 39	com/tencent/qqperf/repoter/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   92: ldc 129
    //   94: aconst_null
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: aconst_null
    //   99: aconst_null
    //   100: invokevirtual 236	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   103: astore 5
    //   105: aload 5
    //   107: ifnonnull +18 -> 125
    //   110: aload 5
    //   112: ifnull +10 -> 122
    //   115: aload 5
    //   117: invokeinterface 239 1 0
    //   122: aload 7
    //   124: areturn
    //   125: aload 5
    //   127: astore 6
    //   129: aload 5
    //   131: astore 4
    //   133: aload 5
    //   135: invokeinterface 242 1 0
    //   140: pop
    //   141: aload 5
    //   143: astore 6
    //   145: aload 5
    //   147: astore 4
    //   149: aload 5
    //   151: invokeinterface 245 1 0
    //   156: ifne +61 -> 217
    //   159: aload 5
    //   161: astore 6
    //   163: aload 5
    //   165: astore 4
    //   167: aload_0
    //   168: aload 5
    //   170: invokespecial 247	com/tencent/qqperf/repoter/DBHandler:a	(Landroid/database/Cursor;)Lcom/tencent/qqperf/repoter/ResultObject;
    //   173: astore 8
    //   175: aload 8
    //   177: ifnull +21 -> 198
    //   180: aload 5
    //   182: astore 6
    //   184: aload 5
    //   186: astore 4
    //   188: aload 7
    //   190: aload 8
    //   192: invokeinterface 253 2 0
    //   197: pop
    //   198: aload 5
    //   200: astore 6
    //   202: aload 5
    //   204: astore 4
    //   206: aload 5
    //   208: invokeinterface 256 1 0
    //   213: pop
    //   214: goto -73 -> 141
    //   217: aload 5
    //   219: ifnull +55 -> 274
    //   222: aload 5
    //   224: astore 4
    //   226: goto +41 -> 267
    //   229: astore 4
    //   231: goto +46 -> 277
    //   234: astore 5
    //   236: aload 4
    //   238: astore 6
    //   240: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +19 -> 262
    //   246: aload 4
    //   248: astore 6
    //   250: ldc 47
    //   252: iconst_2
    //   253: aload 5
    //   255: iconst_0
    //   256: anewarray 4	java/lang/Object
    //   259: invokestatic 51	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   262: aload 4
    //   264: ifnull +10 -> 274
    //   267: aload 4
    //   269: invokeinterface 239 1 0
    //   274: aload 7
    //   276: areturn
    //   277: aload 6
    //   279: ifnull +10 -> 289
    //   282: aload 6
    //   284: invokeinterface 239 1 0
    //   289: aload 4
    //   291: athrow
    //   292: aload 7
    //   294: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	DBHandler
    //   0	295	1	paramBoolean	boolean
    //   3	66	2	l	long
    //   17	208	4	localObject1	Object
    //   229	61	4	localObject2	Object
    //   83	140	5	localCursor	Cursor
    //   234	20	5	localException	Exception
    //   39	244	6	localObject3	Object
    //   11	282	7	localArrayList	java.util.ArrayList
    //   173	18	8	localResultObject	ResultObject
    // Exception table:
    //   from	to	target	type
    //   46	85	229	finally
    //   88	105	229	finally
    //   133	141	229	finally
    //   149	159	229	finally
    //   167	175	229	finally
    //   188	198	229	finally
    //   206	214	229	finally
    //   240	246	229	finally
    //   250	262	229	finally
    //   46	85	234	java/lang/Exception
    //   88	105	234	java/lang/Exception
    //   133	141	234	java/lang/Exception
    //   149	159	234	java/lang/Exception
    //   167	175	234	java/lang/Exception
    //   188	198	234	java/lang/Exception
    //   206	214	234	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqperf.repoter.DBHandler
 * JD-Core Version:    0.7.0.1
 */