package com.tencent.tmdownloader.internal.storage.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tmassistant.common.a.c;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.internal.storage.a.a;

public class d
  implements c
{
  /* Error */
  private static int a(String paramString1, String paramString2, String paramString3, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +95 -> 96
    //   4: aload_1
    //   5: ifnonnull +6 -> 11
    //   8: goto +88 -> 96
    //   11: new 17	android/content/ContentValues
    //   14: dup
    //   15: invokespecial 18	android/content/ContentValues:<init>	()V
    //   18: astore 5
    //   20: aload 5
    //   22: ldc 20
    //   24: aload_0
    //   25: invokevirtual 24	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload 5
    //   30: ldc 26
    //   32: aload_1
    //   33: invokevirtual 24	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload 5
    //   38: ldc 28
    //   40: aload_2
    //   41: invokevirtual 24	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload_3
    //   45: ldc 30
    //   47: aload 5
    //   49: ldc 32
    //   51: iconst_1
    //   52: anewarray 34	java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: aload_0
    //   58: aastore
    //   59: invokevirtual 40	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   62: istore 4
    //   64: iload 4
    //   66: ifle +6 -> 72
    //   69: iload 4
    //   71: ireturn
    //   72: iconst_0
    //   73: ireturn
    //   74: astore_0
    //   75: goto +19 -> 94
    //   78: astore_0
    //   79: ldc 42
    //   81: ldc 44
    //   83: aload_0
    //   84: invokestatic 50	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: aload_0
    //   88: invokevirtual 53	java/lang/Exception:printStackTrace	()V
    //   91: bipush 254
    //   93: ireturn
    //   94: aload_0
    //   95: athrow
    //   96: iconst_m1
    //   97: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	98	0	paramString1	String
    //   0	98	1	paramString2	String
    //   0	98	2	paramString3	String
    //   0	98	3	paramSQLiteDatabase	SQLiteDatabase
    //   62	8	4	i	int
    //   18	30	5	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   11	64	74	finally
    //   79	91	74	finally
    //   11	64	78	java/lang/Exception
  }
  
  /* Error */
  public static java.util.HashMap<String, String> a()
  {
    // Byte code:
    //   0: new 56	java/util/HashMap
    //   3: dup
    //   4: invokespecial 57	java/util/HashMap:<init>	()V
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 4
    //   12: aconst_null
    //   13: astore 5
    //   15: aconst_null
    //   16: astore_3
    //   17: aload 4
    //   19: astore_2
    //   20: aload 5
    //   22: astore_1
    //   23: invokestatic 62	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   26: invokevirtual 68	com/tencent/tmassistant/common/a/d:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   29: astore 7
    //   31: aload 7
    //   33: ifnull +123 -> 156
    //   36: aload 4
    //   38: astore_2
    //   39: aload 5
    //   41: astore_1
    //   42: aload 7
    //   44: ldc 70
    //   46: aconst_null
    //   47: invokevirtual 74	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   50: astore 4
    //   52: aload 4
    //   54: astore_3
    //   55: aload 4
    //   57: ifnull +99 -> 156
    //   60: aload 4
    //   62: astore_3
    //   63: aload 4
    //   65: astore_2
    //   66: aload 4
    //   68: astore_1
    //   69: aload 4
    //   71: invokeinterface 80 1 0
    //   76: ifeq +80 -> 156
    //   79: aload 4
    //   81: astore_2
    //   82: aload 4
    //   84: astore_1
    //   85: aload 6
    //   87: aload 4
    //   89: aload 4
    //   91: ldc 20
    //   93: invokeinterface 84 2 0
    //   98: invokeinterface 88 2 0
    //   103: aload 4
    //   105: aload 4
    //   107: ldc 26
    //   109: invokeinterface 84 2 0
    //   114: invokeinterface 88 2 0
    //   119: invokevirtual 91	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   122: pop
    //   123: aload 4
    //   125: astore_2
    //   126: aload 4
    //   128: astore_1
    //   129: aload 4
    //   131: invokeinterface 94 1 0
    //   136: istore_0
    //   137: iload_0
    //   138: ifne -59 -> 79
    //   141: aload 4
    //   143: ifnull +10 -> 153
    //   146: aload 4
    //   148: invokeinterface 97 1 0
    //   153: aload 6
    //   155: areturn
    //   156: aload_3
    //   157: ifnull +42 -> 199
    //   160: aload_3
    //   161: astore_1
    //   162: aload_1
    //   163: invokeinterface 97 1 0
    //   168: aload 6
    //   170: areturn
    //   171: astore_1
    //   172: goto +30 -> 202
    //   175: astore_3
    //   176: aload_1
    //   177: astore_2
    //   178: ldc 42
    //   180: ldc 44
    //   182: aload_3
    //   183: invokestatic 50	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   186: aload_1
    //   187: astore_2
    //   188: aload_3
    //   189: invokevirtual 53	java/lang/Exception:printStackTrace	()V
    //   192: aload_1
    //   193: ifnull +6 -> 199
    //   196: goto -34 -> 162
    //   199: aload 6
    //   201: areturn
    //   202: aload_2
    //   203: ifnull +9 -> 212
    //   206: aload_2
    //   207: invokeinterface 97 1 0
    //   212: goto +5 -> 217
    //   215: aload_1
    //   216: athrow
    //   217: goto -2 -> 215
    // Local variable table:
    //   start	length	slot	name	signature
    //   136	2	0	bool	boolean
    //   22	141	1	localObject1	Object
    //   171	45	1	localObject2	Object
    //   19	188	2	localObject3	Object
    //   16	145	3	localCursor1	android.database.Cursor
    //   175	14	3	localException	Exception
    //   10	137	4	localCursor2	android.database.Cursor
    //   13	27	5	localObject4	Object
    //   7	193	6	localHashMap	java.util.HashMap
    //   29	14	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   23	31	171	finally
    //   42	52	171	finally
    //   69	79	171	finally
    //   85	123	171	finally
    //   129	137	171	finally
    //   178	186	171	finally
    //   188	192	171	finally
    //   23	31	175	java/lang/Exception
    //   42	52	175	java/lang/Exception
    //   69	79	175	java/lang/Exception
    //   85	123	175	java/lang/Exception
    //   129	137	175	java/lang/Exception
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 != null) && (paramString2 != null)) {
      try
      {
        SQLiteDatabase localSQLiteDatabase = a.c().getWritableDatabase();
        if ((localSQLiteDatabase != null) && (a(paramString1, paramString2, paramString3, localSQLiteDatabase) <= 0))
        {
          ContentValues localContentValues = new ContentValues();
          localContentValues.put("settingField", paramString1);
          localContentValues.put("value", paramString2);
          localContentValues.put("type", paramString3);
          localSQLiteDatabase.insert("settingInfo", null, localContentValues);
          return;
        }
      }
      catch (Exception paramString1)
      {
        ab.c("DownloadSettingTable", "exception: ", paramString1);
        paramString1.printStackTrace();
      }
    }
  }
  
  public String createTableSQL()
  {
    return "CREATE TABLE if not exists settingInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, settingField TEXT , value TEXT,type TEXT);";
  }
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public String tableName()
  {
    return "settingInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.table.d
 * JD-Core Version:    0.7.0.1
 */