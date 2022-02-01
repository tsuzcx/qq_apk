package com.tencent.xweb.xwalk;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import org.xwalk.core.Log;

public class b
{
  private static final String[] b = { "_id" };
  private SQLiteDatabase a;
  private boolean c;
  private final Object d = new Object();
  
  public static b a(Context paramContext, String paramString)
  {
    b localb = new b();
    new b.1(localb, paramContext, paramString).start();
    return localb;
  }
  
  private void a()
  {
    this.a.execSQL("CREATE TABLE httpauth (_id INTEGER PRIMARY KEY, host TEXT, realm TEXT, username TEXT, password TEXT, UNIQUE (host, realm) ON CONFLICT REPLACE);");
    this.a.setVersion(1);
  }
  
  private void b(Context paramContext, String paramString)
  {
    synchronized (this.d)
    {
      if (this.c) {
        return;
      }
      c(paramContext, paramString);
      this.c = true;
      this.d.notifyAll();
      return;
    }
  }
  
  private boolean b()
  {
    synchronized (this.d)
    {
      for (;;)
      {
        boolean bool = this.c;
        if (bool) {
          break;
        }
        try
        {
          this.d.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          Log.e("HttpAuthDatabase", "Caught exception while checking initialization", localInterruptedException);
        }
      }
      return this.a != null;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void c(Context paramContext, String paramString)
  {
    try
    {
      this.a = paramContext.openOrCreateDatabase(paramString, 0, null);
    }
    catch (SQLiteException localSQLiteException)
    {
      label14:
      break label14;
    }
    if (paramContext.deleteDatabase(paramString)) {
      this.a = paramContext.openOrCreateDatabase(paramString, 0, null);
    }
    paramContext = this.a;
    if (paramContext == null)
    {
      paramContext = new StringBuilder();
      paramContext.append("Unable to open or create ");
      paramContext.append(paramString);
      Log.e("HttpAuthDatabase", paramContext.toString());
      return;
    }
    if (paramContext.getVersion() != 1)
    {
      this.a.beginTransactionNonExclusive();
      try
      {
        a();
        this.a.setTransactionSuccessful();
        return;
      }
      finally
      {
        this.a.endTransaction();
      }
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      if (!b()) {
        return;
      }
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("host", paramString1);
      localContentValues.put("realm", paramString2);
      localContentValues.put("username", paramString3);
      localContentValues.put("password", paramString4);
      this.a.insert("httpauth", "host", localContentValues);
    }
  }
  
  /* Error */
  public String[] a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_3
    //   8: aload_1
    //   9: ifnull +196 -> 205
    //   12: aload_2
    //   13: ifnull +192 -> 205
    //   16: aload_0
    //   17: invokespecial 122	com/tencent/xweb/xwalk/b:b	()Z
    //   20: ifne +6 -> 26
    //   23: goto +182 -> 205
    //   26: aload_0
    //   27: getfield 38	com/tencent/xweb/xwalk/b:a	Landroid/database/sqlite/SQLiteDatabase;
    //   30: ldc 138
    //   32: iconst_2
    //   33: anewarray 16	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc 134
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: ldc 136
    //   45: aastore
    //   46: ldc 147
    //   48: iconst_2
    //   49: anewarray 16	java/lang/String
    //   52: dup
    //   53: iconst_0
    //   54: aload_1
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: aload_2
    //   59: aastore
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: invokevirtual 151	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   66: astore_2
    //   67: aload_3
    //   68: astore_1
    //   69: aload_2
    //   70: astore_3
    //   71: aload_2
    //   72: invokeinterface 156 1 0
    //   77: ifeq +52 -> 129
    //   80: aload_2
    //   81: astore_3
    //   82: aload_2
    //   83: aload_2
    //   84: ldc 134
    //   86: invokeinterface 160 2 0
    //   91: invokeinterface 164 2 0
    //   96: astore_1
    //   97: aload_2
    //   98: astore_3
    //   99: aload_2
    //   100: aload_2
    //   101: ldc 136
    //   103: invokeinterface 160 2 0
    //   108: invokeinterface 164 2 0
    //   113: astore 4
    //   115: iconst_2
    //   116: anewarray 16	java/lang/String
    //   119: dup
    //   120: iconst_0
    //   121: aload_1
    //   122: aastore
    //   123: dup
    //   124: iconst_1
    //   125: aload 4
    //   127: aastore
    //   128: astore_1
    //   129: aload_1
    //   130: astore_3
    //   131: aload_2
    //   132: ifnull +58 -> 190
    //   135: aload_2
    //   136: astore_3
    //   137: aload_1
    //   138: astore_2
    //   139: aload_3
    //   140: invokeinterface 167 1 0
    //   145: aload_2
    //   146: areturn
    //   147: astore 4
    //   149: aload_2
    //   150: astore_1
    //   151: goto +13 -> 164
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_3
    //   157: goto +36 -> 193
    //   160: astore 4
    //   162: aconst_null
    //   163: astore_1
    //   164: aload_1
    //   165: astore_3
    //   166: ldc 68
    //   168: ldc 169
    //   170: aload 4
    //   172: invokestatic 76	org/xwalk/core/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   175: aload 6
    //   177: astore_3
    //   178: aload_1
    //   179: ifnull +11 -> 190
    //   182: aload 5
    //   184: astore_2
    //   185: aload_1
    //   186: astore_3
    //   187: goto -48 -> 139
    //   190: aload_3
    //   191: areturn
    //   192: astore_1
    //   193: aload_3
    //   194: ifnull +9 -> 203
    //   197: aload_3
    //   198: invokeinterface 167 1 0
    //   203: aload_1
    //   204: athrow
    //   205: aconst_null
    //   206: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	b
    //   0	207	1	paramString1	String
    //   0	207	2	paramString2	String
    //   7	191	3	localObject1	Object
    //   113	13	4	str	String
    //   147	1	4	localIllegalStateException1	java.lang.IllegalStateException
    //   160	11	4	localIllegalStateException2	java.lang.IllegalStateException
    //   1	182	5	localObject2	Object
    //   4	172	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   71	80	147	java/lang/IllegalStateException
    //   82	97	147	java/lang/IllegalStateException
    //   99	115	147	java/lang/IllegalStateException
    //   26	67	154	finally
    //   26	67	160	java/lang/IllegalStateException
    //   71	80	192	finally
    //   82	97	192	finally
    //   99	115	192	finally
    //   166	175	192	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b
 * JD-Core Version:    0.7.0.1
 */