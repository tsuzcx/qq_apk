package com.tencent.tmassistant.common.a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.util.Iterator;
import java.util.List;

public abstract class a
  implements c
{
  /* Error */
  public b a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: new 17	com/tencent/tmassistant/common/a/b
    //   6: dup
    //   7: invokespecial 18	com/tencent/tmassistant/common/a/b:<init>	()V
    //   10: astore 7
    //   12: aload 7
    //   14: new 20	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 21	java/util/ArrayList:<init>	()V
    //   21: putfield 24	com/tencent/tmassistant/common/a/b:a	Ljava/util/List;
    //   24: aload 7
    //   26: new 20	java/util/ArrayList
    //   29: dup
    //   30: invokespecial 21	java/util/ArrayList:<init>	()V
    //   33: putfield 27	com/tencent/tmassistant/common/a/b:b	Ljava/util/List;
    //   36: iload_1
    //   37: ifle +268 -> 305
    //   40: new 29	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   47: ldc 32
    //   49: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: iload_1
    //   53: invokevirtual 39	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: astore 5
    //   61: aload_0
    //   62: invokevirtual 46	com/tencent/tmassistant/common/a/a:a	()Lcom/tencent/tmassistant/common/a/d;
    //   65: invokevirtual 52	com/tencent/tmassistant/common/a/d:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   68: astore 6
    //   70: aload 6
    //   72: ifnull +151 -> 223
    //   75: aload 6
    //   77: aload_0
    //   78: invokevirtual 54	com/tencent/tmassistant/common/a/a:b	()Ljava/lang/String;
    //   81: aconst_null
    //   82: aconst_null
    //   83: aconst_null
    //   84: aconst_null
    //   85: aconst_null
    //   86: ldc 56
    //   88: aload 5
    //   90: invokevirtual 62	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   93: astore 6
    //   95: aload 6
    //   97: ifnull +114 -> 211
    //   100: aload 6
    //   102: astore 5
    //   104: aload 6
    //   106: invokeinterface 68 1 0
    //   111: ifeq +100 -> 211
    //   114: aload 6
    //   116: astore 5
    //   118: aload 6
    //   120: aload 6
    //   122: ldc 70
    //   124: invokeinterface 74 2 0
    //   129: invokeinterface 78 2 0
    //   134: lstore_2
    //   135: aload 6
    //   137: astore 5
    //   139: aload 7
    //   141: getfield 24	com/tencent/tmassistant/common/a/b:a	Ljava/util/List;
    //   144: lload_2
    //   145: invokestatic 84	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   148: invokeinterface 90 2 0
    //   153: pop
    //   154: aload 6
    //   156: astore 5
    //   158: aload 6
    //   160: aload 6
    //   162: ldc 92
    //   164: invokeinterface 74 2 0
    //   169: invokeinterface 96 2 0
    //   174: astore 9
    //   176: aload 6
    //   178: astore 5
    //   180: aload 7
    //   182: getfield 27	com/tencent/tmassistant/common/a/b:b	Ljava/util/List;
    //   185: aload 9
    //   187: invokeinterface 90 2 0
    //   192: pop
    //   193: aload 6
    //   195: astore 5
    //   197: aload 6
    //   199: invokeinterface 99 1 0
    //   204: istore 4
    //   206: iload 4
    //   208: ifne -94 -> 114
    //   211: aload 6
    //   213: ifnull +10 -> 223
    //   216: aload 6
    //   218: invokeinterface 102 1 0
    //   223: aload 7
    //   225: astore 5
    //   227: aload 5
    //   229: areturn
    //   230: astore 7
    //   232: aconst_null
    //   233: astore 6
    //   235: aload 6
    //   237: astore 5
    //   239: ldc 104
    //   241: ldc 106
    //   243: aload 7
    //   245: invokestatic 112	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   248: aload 6
    //   250: astore 5
    //   252: aload 7
    //   254: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   257: aload 8
    //   259: astore 5
    //   261: aload 6
    //   263: ifnull -36 -> 227
    //   266: aload 6
    //   268: invokeinterface 102 1 0
    //   273: aconst_null
    //   274: areturn
    //   275: astore 6
    //   277: aconst_null
    //   278: astore 5
    //   280: aload 5
    //   282: ifnull +10 -> 292
    //   285: aload 5
    //   287: invokeinterface 102 1 0
    //   292: aload 6
    //   294: athrow
    //   295: astore 6
    //   297: goto -17 -> 280
    //   300: astore 7
    //   302: goto -67 -> 235
    //   305: aconst_null
    //   306: astore 5
    //   308: goto -247 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	a
    //   0	311	1	paramInt	int
    //   134	11	2	l	long
    //   204	3	4	bool	boolean
    //   59	248	5	localObject1	Object
    //   68	199	6	localObject2	Object
    //   275	18	6	localObject3	Object
    //   295	1	6	localObject4	Object
    //   10	214	7	localb	b
    //   230	23	7	localException1	java.lang.Exception
    //   300	1	7	localException2	java.lang.Exception
    //   1	257	8	localObject5	Object
    //   174	12	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   75	95	230	java/lang/Exception
    //   75	95	275	finally
    //   104	114	295	finally
    //   118	135	295	finally
    //   139	154	295	finally
    //   158	176	295	finally
    //   180	193	295	finally
    //   197	206	295	finally
    //   239	248	295	finally
    //   252	257	295	finally
    //   104	114	300	java/lang/Exception
    //   118	135	300	java/lang/Exception
    //   139	154	300	java/lang/Exception
    //   158	176	300	java/lang/Exception
    //   180	193	300	java/lang/Exception
    //   197	206	300	java/lang/Exception
  }
  
  public d a()
  {
    return com.tencent.tmdownloader.internal.storage.a.a.c();
  }
  
  /* Error */
  public boolean a(List<byte[]> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 46	com/tencent/tmassistant/common/a/a:a	()Lcom/tencent/tmassistant/common/a/d;
    //   4: invokevirtual 123	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   7: astore_2
    //   8: aload_2
    //   9: ifnull +81 -> 90
    //   12: aload_2
    //   13: invokevirtual 126	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   16: aload_2
    //   17: aload_0
    //   18: invokevirtual 129	com/tencent/tmassistant/common/a/a:d	()Ljava/lang/String;
    //   21: invokevirtual 133	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   24: astore_3
    //   25: aload_1
    //   26: invokeinterface 137 1 0
    //   31: astore_1
    //   32: aload_1
    //   33: invokeinterface 142 1 0
    //   38: ifeq +44 -> 82
    //   41: aload_3
    //   42: iconst_1
    //   43: aload_1
    //   44: invokeinterface 146 1 0
    //   49: checkcast 148	[B
    //   52: invokevirtual 154	android/database/sqlite/SQLiteStatement:bindBlob	(I[B)V
    //   55: aload_3
    //   56: invokevirtual 158	android/database/sqlite/SQLiteStatement:executeInsert	()J
    //   59: pop2
    //   60: goto -28 -> 32
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   68: ldc 104
    //   70: ldc 106
    //   72: aload_1
    //   73: invokestatic 112	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   76: aload_2
    //   77: invokevirtual 161	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   80: iconst_0
    //   81: ireturn
    //   82: aload_2
    //   83: invokevirtual 164	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   86: aload_2
    //   87: invokevirtual 161	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   90: iconst_1
    //   91: ireturn
    //   92: astore_1
    //   93: aload_2
    //   94: invokevirtual 161	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   97: aload_1
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	a
    //   0	99	1	paramList	List<byte[]>
    //   7	87	2	localSQLiteDatabase	SQLiteDatabase
    //   24	32	3	localSQLiteStatement	android.database.sqlite.SQLiteStatement
    // Exception table:
    //   from	to	target	type
    //   12	32	63	java/lang/Exception
    //   32	60	63	java/lang/Exception
    //   82	86	63	java/lang/Exception
    //   12	32	92	finally
    //   32	60	92	finally
    //   64	76	92	finally
    //   82	86	92	finally
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("logData", paramArrayOfByte);
    return a().getWritableDatabase().insert(b(), null, localContentValues) > 0L;
  }
  
  protected abstract String b();
  
  public boolean b(List<Long> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return false;
    }
    StringBuffer localStringBuffer = new StringBuffer("(");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localStringBuffer.append((Long)paramList.next());
      localStringBuffer.append(",");
    }
    if (localStringBuffer.length() > 0) {
      localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
    }
    localStringBuffer.append(")");
    paramList = a().getWritableDatabase();
    if (paramList != null) {
      paramList.delete(b(), "_id in " + localStringBuffer, null);
    }
    return true;
  }
  
  protected abstract String[] b(int paramInt);
  
  protected abstract String c();
  
  public String createTableSQL()
  {
    return c();
  }
  
  protected abstract String d();
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    return b(paramInt2);
  }
  
  public String tableName()
  {
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmassistant.common.a.a
 * JD-Core Version:    0.7.0.1
 */