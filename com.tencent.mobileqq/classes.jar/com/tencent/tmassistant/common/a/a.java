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
    //   0: new 17	com/tencent/tmassistant/common/a/b
    //   3: dup
    //   4: invokespecial 18	com/tencent/tmassistant/common/a/b:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: new 20	java/util/ArrayList
    //   14: dup
    //   15: invokespecial 21	java/util/ArrayList:<init>	()V
    //   18: putfield 24	com/tencent/tmassistant/common/a/b:a	Ljava/util/List;
    //   21: aload 7
    //   23: new 20	java/util/ArrayList
    //   26: dup
    //   27: invokespecial 21	java/util/ArrayList:<init>	()V
    //   30: putfield 27	com/tencent/tmassistant/common/a/b:b	Ljava/util/List;
    //   33: iload_1
    //   34: ifle +37 -> 71
    //   37: new 29	java/lang/StringBuilder
    //   40: dup
    //   41: invokespecial 30	java/lang/StringBuilder:<init>	()V
    //   44: astore 5
    //   46: aload 5
    //   48: ldc 32
    //   50: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload 5
    //   56: iload_1
    //   57: invokevirtual 39	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 5
    //   63: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore 5
    //   68: goto +6 -> 74
    //   71: aconst_null
    //   72: astore 5
    //   74: aload_0
    //   75: invokevirtual 46	com/tencent/tmassistant/common/a/a:a	()Lcom/tencent/tmassistant/common/a/d;
    //   78: invokevirtual 52	com/tencent/tmassistant/common/a/d:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   81: astore 6
    //   83: aload 6
    //   85: ifnull +236 -> 321
    //   88: aload 6
    //   90: aload_0
    //   91: invokevirtual 54	com/tencent/tmassistant/common/a/a:b	()Ljava/lang/String;
    //   94: aconst_null
    //   95: aconst_null
    //   96: aconst_null
    //   97: aconst_null
    //   98: aconst_null
    //   99: ldc 56
    //   101: aload 5
    //   103: invokevirtual 62	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   106: astore 6
    //   108: aload 6
    //   110: ifnull +122 -> 232
    //   113: aload 6
    //   115: astore 5
    //   117: aload 6
    //   119: invokeinterface 68 1 0
    //   124: ifeq +108 -> 232
    //   127: aload 6
    //   129: astore 5
    //   131: aload 6
    //   133: aload 6
    //   135: ldc 70
    //   137: invokeinterface 74 2 0
    //   142: invokeinterface 78 2 0
    //   147: lstore_2
    //   148: aload 6
    //   150: astore 5
    //   152: aload 7
    //   154: getfield 24	com/tencent/tmassistant/common/a/b:a	Ljava/util/List;
    //   157: lload_2
    //   158: invokestatic 84	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   161: invokeinterface 90 2 0
    //   166: pop
    //   167: aload 6
    //   169: astore 5
    //   171: aload 6
    //   173: aload 6
    //   175: ldc 92
    //   177: invokeinterface 74 2 0
    //   182: invokeinterface 96 2 0
    //   187: astore 8
    //   189: aload 6
    //   191: astore 5
    //   193: aload 7
    //   195: getfield 27	com/tencent/tmassistant/common/a/b:b	Ljava/util/List;
    //   198: aload 8
    //   200: invokeinterface 90 2 0
    //   205: pop
    //   206: aload 6
    //   208: astore 5
    //   210: aload 6
    //   212: invokeinterface 99 1 0
    //   217: istore 4
    //   219: iload 4
    //   221: ifne -94 -> 127
    //   224: goto +8 -> 232
    //   227: astore 7
    //   229: goto +31 -> 260
    //   232: aload 6
    //   234: ifnull +87 -> 321
    //   237: aload 6
    //   239: invokeinterface 102 1 0
    //   244: aload 7
    //   246: areturn
    //   247: astore 5
    //   249: aconst_null
    //   250: astore 6
    //   252: goto +54 -> 306
    //   255: astore 7
    //   257: aconst_null
    //   258: astore 6
    //   260: aload 6
    //   262: astore 5
    //   264: ldc 104
    //   266: ldc 106
    //   268: aload 7
    //   270: invokestatic 112	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   273: aload 6
    //   275: astore 5
    //   277: aload 7
    //   279: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   282: aload 6
    //   284: ifnull +10 -> 294
    //   287: aload 6
    //   289: invokeinterface 102 1 0
    //   294: aconst_null
    //   295: areturn
    //   296: astore 7
    //   298: aload 5
    //   300: astore 6
    //   302: aload 7
    //   304: astore 5
    //   306: aload 6
    //   308: ifnull +10 -> 318
    //   311: aload 6
    //   313: invokeinterface 102 1 0
    //   318: aload 5
    //   320: athrow
    //   321: aload 7
    //   323: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	324	0	this	a
    //   0	324	1	paramInt	int
    //   147	11	2	l	long
    //   217	3	4	bool	boolean
    //   44	165	5	localObject1	Object
    //   247	1	5	localObject2	Object
    //   262	57	5	localObject3	Object
    //   81	231	6	localObject4	Object
    //   7	187	7	localb1	b
    //   227	18	7	localException1	java.lang.Exception
    //   255	23	7	localException2	java.lang.Exception
    //   296	26	7	localb2	b
    //   187	12	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   117	127	227	java/lang/Exception
    //   131	148	227	java/lang/Exception
    //   152	167	227	java/lang/Exception
    //   171	189	227	java/lang/Exception
    //   193	206	227	java/lang/Exception
    //   210	219	227	java/lang/Exception
    //   88	108	247	finally
    //   88	108	255	java/lang/Exception
    //   117	127	296	finally
    //   131	148	296	finally
    //   152	167	296	finally
    //   171	189	296	finally
    //   193	206	296	finally
    //   210	219	296	finally
    //   264	273	296	finally
    //   277	282	296	finally
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
    //   9: ifnull +93 -> 102
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
    //   38: ifeq +25 -> 63
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
    //   63: aload_2
    //   64: invokevirtual 161	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   67: aload_2
    //   68: invokevirtual 164	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   71: iconst_1
    //   72: ireturn
    //   73: astore_1
    //   74: goto +22 -> 96
    //   77: astore_1
    //   78: aload_1
    //   79: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   82: ldc 104
    //   84: ldc 106
    //   86: aload_1
    //   87: invokestatic 112	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   90: aload_2
    //   91: invokevirtual 164	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   94: iconst_0
    //   95: ireturn
    //   96: aload_2
    //   97: invokevirtual 164	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   100: aload_1
    //   101: athrow
    //   102: iconst_1
    //   103: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	a
    //   0	104	1	paramList	List<byte[]>
    //   7	90	2	localSQLiteDatabase	SQLiteDatabase
    //   24	32	3	localSQLiteStatement	android.database.sqlite.SQLiteStatement
    // Exception table:
    //   from	to	target	type
    //   12	32	73	finally
    //   32	60	73	finally
    //   63	67	73	finally
    //   78	90	73	finally
    //   12	32	77	java/lang/Exception
    //   32	60	77	java/lang/Exception
    //   63	67	77	java/lang/Exception
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
    if ((paramList != null) && (paramList.size() > 0))
    {
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
      if (paramList != null)
      {
        String str = b();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("_id in ");
        localStringBuilder.append(localStringBuffer);
        paramList.delete(str, localStringBuilder.toString(), null);
      }
      return true;
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistant.common.a.a
 * JD-Core Version:    0.7.0.1
 */