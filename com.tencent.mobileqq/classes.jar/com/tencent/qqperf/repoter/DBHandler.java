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
      while (!QLog.isColorLevel()) {}
      QLog.e("Magnifier_DBHandler", 2, paramContext, new Object[0]);
    }
  }
  
  private int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen())) {
      return -2;
    }
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
    }
    return -1;
  }
  
  public static DBHandler a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentQqperfRepoterDBHandler == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentQqperfRepoterDBHandler == null) {
        jdField_a_of_type_ComTencentQqperfRepoterDBHandler = new DBHandler(paramContext);
      }
      return jdField_a_of_type_ComTencentQqperfRepoterDBHandler;
    }
    finally {}
  }
  
  private ResultObject a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    ResultObject localResultObject = new ResultObject();
    localResultObject.dbId = paramCursor.getInt(paramCursor.getColumnIndex("_id"));
    localResultObject.params = new JSONObject(paramCursor.getString(paramCursor.getColumnIndex("params")));
    if (paramCursor.getInt(paramCursor.getColumnIndex("is_real_time")) > 0) {}
    for (boolean bool = true;; bool = false)
    {
      localResultObject.isRealTime = bool;
      localResultObject.uin = paramCursor.getLong(paramCursor.getColumnIndex("uin"));
      return localResultObject;
    }
  }
  
  public int a()
  {
    return a("result_objects", null, null);
  }
  
  public int a(String paramString, long paramLong, int paramInt)
  {
    int j = -1;
    int i;
    if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen())) {
      i = -2;
    }
    do
    {
      do
      {
        return i;
        if (paramInt == 1) {
          break;
        }
        i = j;
      } while (paramInt != 2);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("status", Integer.valueOf(paramInt));
      try
      {
        paramInt = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.update(paramString, localContentValues, "_id=" + paramLong, null);
        return paramInt;
      }
      catch (Exception paramString)
      {
        i = j;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Magnifier_DBHandler", 2, paramString, new Object[0]);
    return -1;
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
    if ((this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase == null) || (!this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.isOpen())) {
      return -2L;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("params", paramResultObject.params.toString());
    localContentValues.put("is_real_time", Boolean.valueOf(paramResultObject.isRealTime));
    localContentValues.put("uin", Long.valueOf(paramResultObject.uin));
    localContentValues.put("status", Integer.valueOf(1));
    try
    {
      l1 = paramResultObject.params.getJSONObject("clientinfo").optLong("event_time");
      long l2 = l1;
      if (l1 == 0L) {
        l2 = jdField_a_of_type_Long;
      }
      localContentValues.put("occur_time", Long.valueOf(l2));
    }
    catch (Exception paramResultObject)
    {
      for (;;)
      {
        try
        {
          l1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insert("result_objects", "name", localContentValues);
          return l1;
        }
        catch (Exception paramResultObject)
        {
          long l1;
          if (!QLog.isColorLevel()) {
            break label164;
          }
          QLog.e("Magnifier_DBHandler", 2, paramResultObject, new Object[0]);
        }
        paramResultObject = paramResultObject;
        l1 = 0L;
      }
    }
    label164:
    return -1L;
  }
  
  /* Error */
  public java.util.List<ResultObject> a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 17	java/lang/System:currentTimeMillis	()J
    //   6: lstore_2
    //   7: new 229	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 230	java/util/ArrayList:<init>	()V
    //   14: astore 7
    //   16: aload_0
    //   17: getfield 39	com/tencent/qqperf/repoter/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   20: ifnull +13 -> 33
    //   23: aload_0
    //   24: getfield 39	com/tencent/qqperf/repoter/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   27: invokevirtual 59	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   30: ifne +6 -> 36
    //   33: aload 7
    //   35: areturn
    //   36: iconst_1
    //   37: iload_1
    //   38: if_icmpne +62 -> 100
    //   41: aload_0
    //   42: getfield 39	com/tencent/qqperf/repoter/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   45: ldc 129
    //   47: aconst_null
    //   48: ldc 232
    //   50: iconst_2
    //   51: anewarray 172	java/lang/String
    //   54: dup
    //   55: iconst_0
    //   56: iconst_1
    //   57: invokestatic 174	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: aastore
    //   61: dup
    //   62: iconst_1
    //   63: lload_2
    //   64: ldc2_w 175
    //   67: lsub
    //   68: invokestatic 179	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   71: aastore
    //   72: aconst_null
    //   73: aconst_null
    //   74: aconst_null
    //   75: invokevirtual 236	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   78: astore 4
    //   80: aload 4
    //   82: ifnonnull +38 -> 120
    //   85: aload 4
    //   87: ifnull +10 -> 97
    //   90: aload 4
    //   92: invokeinterface 239 1 0
    //   97: aload 7
    //   99: areturn
    //   100: aload_0
    //   101: getfield 39	com/tencent/qqperf/repoter/DBHandler:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   104: ldc 129
    //   106: aconst_null
    //   107: aconst_null
    //   108: aconst_null
    //   109: aconst_null
    //   110: aconst_null
    //   111: aconst_null
    //   112: invokevirtual 236	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   115: astore 4
    //   117: goto -37 -> 80
    //   120: aload 4
    //   122: astore 5
    //   124: aload 4
    //   126: invokeinterface 242 1 0
    //   131: pop
    //   132: aload 4
    //   134: astore 5
    //   136: aload 4
    //   138: invokeinterface 245 1 0
    //   143: ifne +92 -> 235
    //   146: aload 4
    //   148: astore 5
    //   150: aload_0
    //   151: aload 4
    //   153: invokespecial 247	com/tencent/qqperf/repoter/DBHandler:a	(Landroid/database/Cursor;)Lcom/tencent/qqperf/repoter/ResultObject;
    //   156: astore 6
    //   158: aload 6
    //   160: ifnull +17 -> 177
    //   163: aload 4
    //   165: astore 5
    //   167: aload 7
    //   169: aload 6
    //   171: invokeinterface 253 2 0
    //   176: pop
    //   177: aload 4
    //   179: astore 5
    //   181: aload 4
    //   183: invokeinterface 256 1 0
    //   188: pop
    //   189: goto -57 -> 132
    //   192: astore 6
    //   194: aload 4
    //   196: astore 5
    //   198: invokestatic 45	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +19 -> 220
    //   204: aload 4
    //   206: astore 5
    //   208: ldc 47
    //   210: iconst_2
    //   211: aload 6
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokestatic 51	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   220: aload 4
    //   222: ifnull +10 -> 232
    //   225: aload 4
    //   227: invokeinterface 239 1 0
    //   232: aload 7
    //   234: areturn
    //   235: aload 4
    //   237: ifnull -5 -> 232
    //   240: aload 4
    //   242: invokeinterface 239 1 0
    //   247: goto -15 -> 232
    //   250: astore 4
    //   252: aload 5
    //   254: ifnull +10 -> 264
    //   257: aload 5
    //   259: invokeinterface 239 1 0
    //   264: aload 4
    //   266: athrow
    //   267: astore 4
    //   269: goto -17 -> 252
    //   272: astore 6
    //   274: aconst_null
    //   275: astore 4
    //   277: goto -83 -> 194
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	DBHandler
    //   0	280	1	paramBoolean	boolean
    //   6	58	2	l	long
    //   78	163	4	localCursor	Cursor
    //   250	15	4	localObject1	Object
    //   267	1	4	localObject2	Object
    //   275	1	4	localObject3	Object
    //   1	257	5	localObject4	Object
    //   156	14	6	localResultObject	ResultObject
    //   192	20	6	localException1	Exception
    //   272	1	6	localException2	Exception
    //   14	219	7	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   124	132	192	java/lang/Exception
    //   136	146	192	java/lang/Exception
    //   150	158	192	java/lang/Exception
    //   167	177	192	java/lang/Exception
    //   181	189	192	java/lang/Exception
    //   41	80	250	finally
    //   100	117	250	finally
    //   124	132	267	finally
    //   136	146	267	finally
    //   150	158	267	finally
    //   167	177	267	finally
    //   181	189	267	finally
    //   198	204	267	finally
    //   208	220	267	finally
    //   41	80	272	java/lang/Exception
    //   100	117	272	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqperf.repoter.DBHandler
 * JD-Core Version:    0.7.0.1
 */