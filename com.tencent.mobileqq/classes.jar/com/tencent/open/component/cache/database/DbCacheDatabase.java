package com.tencent.open.component.cache.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.open.base.MD5Utils;
import java.util.HashMap;
import java.util.HashSet;

public class DbCacheDatabase
  extends SQLiteOpenHelper
  implements Sessional
{
  protected static HashMap<Long, DbCacheDatabase> a;
  protected int a;
  protected Context a;
  protected String a;
  protected HashSet<Integer> a;
  protected volatile boolean a;
  protected boolean b = true;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  protected DbCacheDatabase(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static DbCacheDatabase a(Context paramContext, long paramLong)
  {
    try
    {
      DbCacheDatabase localDbCacheDatabase = (DbCacheDatabase)jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
      Object localObject = localDbCacheDatabase;
      if (localDbCacheDatabase == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(String.valueOf(paramLong));
        ((StringBuilder)localObject).append("_opensdk");
        localObject = new DbCacheDatabase(paramContext, MD5Utils.encodeHexStr(((StringBuilder)localObject).toString()), null, 74);
        jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localObject);
      }
      return localObject;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContext.deleteDatabase(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(int paramInt)
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(paramInt))) {
        this.jdField_a_of_type_Int += 1;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public SQLiteDatabase getWritableDatabase()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: invokespecial 106	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore_1
    //   9: aload_1
    //   10: astore_2
    //   11: aload_0
    //   12: getfield 38	com/tencent/open/component/cache/database/DbCacheDatabase:jdField_a_of_type_Boolean	Z
    //   15: ifeq +61 -> 76
    //   18: aload_1
    //   19: ifnull +7 -> 26
    //   22: aload_1
    //   23: invokevirtual 111	android/database/sqlite/SQLiteDatabase:close	()V
    //   26: aload_0
    //   27: invokevirtual 113	com/tencent/open/component/cache/database/DbCacheDatabase:a	()V
    //   30: aload_0
    //   31: invokespecial 106	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   34: astore_2
    //   35: aload_2
    //   36: astore_1
    //   37: aload_0
    //   38: iconst_0
    //   39: putfield 38	com/tencent/open/component/cache/database/DbCacheDatabase:jdField_a_of_type_Boolean	Z
    //   42: aload_1
    //   43: astore_2
    //   44: goto +32 -> 76
    //   47: astore_1
    //   48: goto +55 -> 103
    //   51: astore_1
    //   52: goto +28 -> 80
    //   55: aload_0
    //   56: invokevirtual 113	com/tencent/open/component/cache/database/DbCacheDatabase:a	()V
    //   59: aload_0
    //   60: invokespecial 106	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   63: astore_1
    //   64: aload_1
    //   65: astore_2
    //   66: aload_0
    //   67: getfield 38	com/tencent/open/component/cache/database/DbCacheDatabase:jdField_a_of_type_Boolean	Z
    //   70: ifeq +6 -> 76
    //   73: goto -36 -> 37
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_2
    //   79: areturn
    //   80: aload_0
    //   81: getfield 38	com/tencent/open/component/cache/database/DbCacheDatabase:jdField_a_of_type_Boolean	Z
    //   84: ifeq +17 -> 101
    //   87: aload_0
    //   88: invokevirtual 113	com/tencent/open/component/cache/database/DbCacheDatabase:a	()V
    //   91: aload_0
    //   92: invokespecial 106	android/database/sqlite/SQLiteOpenHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   95: pop
    //   96: aload_0
    //   97: iconst_0
    //   98: putfield 38	com/tencent/open/component/cache/database/DbCacheDatabase:jdField_a_of_type_Boolean	Z
    //   101: aload_1
    //   102: athrow
    //   103: aload_0
    //   104: monitorexit
    //   105: goto +5 -> 110
    //   108: aload_1
    //   109: athrow
    //   110: goto -2 -> 108
    //   113: astore_1
    //   114: goto -59 -> 55
    //   117: astore_2
    //   118: goto -81 -> 37
    //   121: astore_1
    //   122: aload_2
    //   123: astore_1
    //   124: goto -60 -> 64
    //   127: astore_2
    //   128: goto -32 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	DbCacheDatabase
    //   8	35	1	localObject1	Object
    //   47	1	1	localObject2	Object
    //   51	1	1	localObject3	Object
    //   63	46	1	localSQLiteDatabase	SQLiteDatabase
    //   113	1	1	localThrowable1	java.lang.Throwable
    //   121	1	1	localThrowable2	java.lang.Throwable
    //   123	1	1	localThrowable3	java.lang.Throwable
    //   3	76	2	localObject4	Object
    //   117	6	2	localThrowable4	java.lang.Throwable
    //   127	1	2	localThrowable5	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   11	18	47	finally
    //   22	26	47	finally
    //   26	30	47	finally
    //   30	35	47	finally
    //   37	42	47	finally
    //   66	73	47	finally
    //   76	78	47	finally
    //   80	91	47	finally
    //   91	96	47	finally
    //   96	101	47	finally
    //   101	103	47	finally
    //   103	105	47	finally
    //   4	9	51	finally
    //   55	59	51	finally
    //   59	64	51	finally
    //   4	9	113	java/lang/Throwable
    //   30	35	117	java/lang/Throwable
    //   59	64	121	java/lang/Throwable
    //   91	96	127	java/lang/Throwable
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.component.cache.database.DbCacheDatabase
 * JD-Core Version:    0.7.0.1
 */