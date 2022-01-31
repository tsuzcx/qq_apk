package com.tencent.mqq.shared_file_accessor;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Set;

class b
{
  private WeakReference a = null;
  private Uri b = null;
  
  public b(WeakReference paramWeakReference, String paramString)
  {
    this.a = paramWeakReference;
    StringBuilder localStringBuilder = new StringBuilder("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/params?file=");
    paramWeakReference = paramString;
    if (paramString == null) {
      paramWeakReference = "default";
    }
    this.b = Uri.parse(paramWeakReference);
  }
  
  private static Object a(Cursor paramCursor, c paramc)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramCursor == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        switch (paramc.a)
        {
        case 0: 
          if (paramCursor.getCount() != 0) {
            return Boolean.valueOf(bool1);
          }
        case 5: 
          if (paramCursor.getInt(0) == 0) {
            break label185;
          }
          bool1 = bool2;
          return Boolean.valueOf(bool1);
        case 3: 
          return Float.valueOf(paramCursor.getFloat(0));
        case 1: 
          return Integer.valueOf(paramCursor.getInt(0));
        case 2: 
          return Long.valueOf(paramCursor.getLong(0));
        case 4: 
          return paramCursor.getString(0);
        case 6: 
          paramc = new HashSet();
          String str = paramCursor.getString(0);
          if (!TextUtils.isEmpty(str)) {
            paramc.add(str);
          }
          bool1 = paramCursor.moveToNext();
          if (bool1) {
            continue;
          }
          return paramc;
          bool1 = false;
          break;
        }
        return null;
      }
      catch (Exception paramCursor)
      {
        return null;
      }
      label185:
      bool1 = false;
    }
  }
  
  /* Error */
  public Object a(String paramString, c paramc, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/tencent/mqq/shared_file_accessor/b:a	Ljava/lang/ref/WeakReference;
    //   4: ifnonnull +5 -> 9
    //   7: aload_3
    //   8: areturn
    //   9: aload_0
    //   10: getfield 15	com/tencent/mqq/shared_file_accessor/b:a	Ljava/lang/ref/WeakReference;
    //   13: invokevirtual 120	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   16: checkcast 122	android/content/Context
    //   19: astore 5
    //   21: aload 5
    //   23: ifnull -16 -> 7
    //   26: aload 5
    //   28: invokevirtual 126	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   31: aload_0
    //   32: getfield 17	com/tencent/mqq/shared_file_accessor/b:b	Landroid/net/Uri;
    //   35: bipush 8
    //   37: anewarray 128	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: ldc 130
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: ldc 132
    //   49: aastore
    //   50: dup
    //   51: iconst_2
    //   52: ldc 134
    //   54: aastore
    //   55: dup
    //   56: iconst_3
    //   57: aload_1
    //   58: aastore
    //   59: dup
    //   60: iconst_4
    //   61: ldc 136
    //   63: aastore
    //   64: dup
    //   65: iconst_5
    //   66: aload_2
    //   67: getfield 49	com/tencent/mqq/shared_file_accessor/c:a	I
    //   70: invokestatic 138	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   73: aastore
    //   74: dup
    //   75: bipush 6
    //   77: ldc 26
    //   79: aastore
    //   80: dup
    //   81: bipush 7
    //   83: new 19	java/lang/StringBuilder
    //   86: dup
    //   87: invokespecial 139	java/lang/StringBuilder:<init>	()V
    //   90: aload_3
    //   91: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 34	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: aastore
    //   98: aconst_null
    //   99: aconst_null
    //   100: aconst_null
    //   101: invokevirtual 148	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   104: astore_1
    //   105: aload_1
    //   106: ifnull -99 -> 7
    //   109: aload_1
    //   110: invokeinterface 151 1 0
    //   115: istore 4
    //   117: iload 4
    //   119: ifne +20 -> 139
    //   122: aload_1
    //   123: invokeinterface 154 1 0
    //   128: aload_3
    //   129: areturn
    //   130: astore_1
    //   131: aload_3
    //   132: areturn
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_1
    //   136: goto -31 -> 105
    //   139: aload_1
    //   140: aload_2
    //   141: invokestatic 156	com/tencent/mqq/shared_file_accessor/b:a	(Landroid/database/Cursor;Lcom/tencent/mqq/shared_file_accessor/c;)Ljava/lang/Object;
    //   144: astore_2
    //   145: aload_2
    //   146: ifnull +11 -> 157
    //   149: aload_1
    //   150: invokeinterface 154 1 0
    //   155: aload_2
    //   156: areturn
    //   157: aload_1
    //   158: invokeinterface 154 1 0
    //   163: aload_3
    //   164: areturn
    //   165: astore_1
    //   166: aload_3
    //   167: areturn
    //   168: astore_2
    //   169: aload_1
    //   170: invokeinterface 154 1 0
    //   175: aload_3
    //   176: areturn
    //   177: astore_1
    //   178: aload_3
    //   179: areturn
    //   180: astore_2
    //   181: aload_1
    //   182: invokeinterface 154 1 0
    //   187: aload_2
    //   188: athrow
    //   189: astore_1
    //   190: goto -35 -> 155
    //   193: astore_1
    //   194: goto -7 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	b
    //   0	197	1	paramString	String
    //   0	197	2	paramc	c
    //   0	197	3	paramObject	Object
    //   115	3	4	bool	boolean
    //   19	8	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   122	128	130	java/lang/Throwable
    //   26	105	133	java/lang/Exception
    //   157	163	165	java/lang/Throwable
    //   109	117	168	java/lang/Throwable
    //   139	145	168	java/lang/Throwable
    //   169	175	177	java/lang/Throwable
    //   109	117	180	finally
    //   139	145	180	finally
    //   149	155	189	java/lang/Throwable
    //   181	187	193	java/lang/Throwable
  }
  
  public void a()
  {
    a("*");
  }
  
  public void a(String paramString)
  {
    if (this.a == null) {}
    Context localContext;
    do
    {
      return;
      localContext = (Context)this.a.get();
    } while (localContext == null);
    try
    {
      localContext.getContentResolver().delete(this.b, paramString, null);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (this.a == null) {}
    Object localObject;
    do
    {
      return;
      localObject = (Context)this.a.get();
    } while (localObject == null);
    if (paramObject == null)
    {
      a(paramString);
      return;
    }
    try
    {
      localObject = ((Context)localObject).getContentResolver();
      Uri localUri = this.b;
      ContentValues localContentValues = new ContentValues(1);
      if ((paramObject instanceof Integer)) {
        localContentValues.put(paramString, (Integer)paramObject);
      }
      for (;;)
      {
        ((ContentResolver)localObject).insert(localUri, localContentValues);
        return;
        if ((paramObject instanceof Long)) {
          localContentValues.put(paramString, (Long)paramObject);
        } else if ((paramObject instanceof Float)) {
          localContentValues.put(paramString, (Float)paramObject);
        } else if ((paramObject instanceof String)) {
          localContentValues.put(paramString, (String)paramObject);
        } else if ((paramObject instanceof Boolean)) {
          localContentValues.put(paramString, (Boolean)paramObject);
        } else {
          localContentValues.put(paramString, "");
        }
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void b()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      Object localObject1 = (Context)this.a.get();
      if (localObject1 == null) {
        continue;
      }
      try
      {
        localObject1 = ((Context)localObject1).getContentResolver().query(this.b, new String[] { "cmd", "5" }, null, null, null);
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((Cursor)localObject1).close();
          return;
        }
        catch (Throwable localThrowable) {}
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.b
 * JD-Core Version:    0.7.0.1
 */