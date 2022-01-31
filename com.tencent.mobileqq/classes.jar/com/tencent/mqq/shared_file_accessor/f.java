package com.tencent.mqq.shared_file_accessor;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import java.lang.ref.WeakReference;
import java.util.Map;

final class f
  implements h
{
  private WeakReference a = null;
  private Uri b = null;
  
  public f(WeakReference paramWeakReference, String paramString)
  {
    this.a = paramWeakReference;
    StringBuilder localStringBuilder = new StringBuilder("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/params?file=");
    paramWeakReference = paramString;
    if (paramString == null) {
      paramWeakReference = "default";
    }
    this.b = Uri.parse(paramWeakReference);
  }
  
  private static Object a(Cursor paramCursor, e parame)
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
        switch (parame.a)
        {
        case 0: 
          if (paramCursor.getCount() != 0) {
            return Boolean.valueOf(bool1);
          }
        case 5: 
          if (paramCursor.getInt(0) == 0) {
            break label136;
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
          paramCursor = paramCursor.getString(0);
          return paramCursor;
          bool1 = false;
          break;
        }
        return null;
      }
      catch (Exception paramCursor)
      {
        return null;
      }
      label136:
      bool1 = false;
    }
  }
  
  /* Error */
  public final Object a(String paramString, e parame, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/tencent/mqq/shared_file_accessor/f:a	Ljava/lang/ref/WeakReference;
    //   4: ifnonnull +5 -> 9
    //   7: aload_3
    //   8: areturn
    //   9: aload_0
    //   10: getfield 17	com/tencent/mqq/shared_file_accessor/f:a	Ljava/lang/ref/WeakReference;
    //   13: invokevirtual 103	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   16: checkcast 105	android/content/Context
    //   19: astore 5
    //   21: aload 5
    //   23: ifnull -16 -> 7
    //   26: aload 5
    //   28: invokevirtual 109	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   31: aload_0
    //   32: getfield 19	com/tencent/mqq/shared_file_accessor/f:b	Landroid/net/Uri;
    //   35: bipush 6
    //   37: anewarray 111	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: ldc 113
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: aload_1
    //   48: aastore
    //   49: dup
    //   50: iconst_2
    //   51: ldc 115
    //   53: aastore
    //   54: dup
    //   55: iconst_3
    //   56: aload_2
    //   57: getfield 51	com/tencent/mqq/shared_file_accessor/e:a	I
    //   60: invokestatic 117	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   63: aastore
    //   64: dup
    //   65: iconst_4
    //   66: ldc 28
    //   68: aastore
    //   69: dup
    //   70: iconst_5
    //   71: new 21	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 118	java/lang/StringBuilder:<init>	()V
    //   78: aload_3
    //   79: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: aastore
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: invokevirtual 127	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull -87 -> 7
    //   97: aload_1
    //   98: invokeinterface 131 1 0
    //   103: istore 4
    //   105: iload 4
    //   107: ifne +20 -> 127
    //   110: aload_1
    //   111: invokeinterface 134 1 0
    //   116: aload_3
    //   117: areturn
    //   118: astore_1
    //   119: aload_3
    //   120: areturn
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_1
    //   124: goto -31 -> 93
    //   127: aload_1
    //   128: aload_2
    //   129: invokestatic 136	com/tencent/mqq/shared_file_accessor/f:a	(Landroid/database/Cursor;Lcom/tencent/mqq/shared_file_accessor/e;)Ljava/lang/Object;
    //   132: astore_2
    //   133: aload_2
    //   134: ifnull +11 -> 145
    //   137: aload_1
    //   138: invokeinterface 134 1 0
    //   143: aload_2
    //   144: areturn
    //   145: aload_1
    //   146: invokeinterface 134 1 0
    //   151: aload_3
    //   152: areturn
    //   153: astore_1
    //   154: aload_3
    //   155: areturn
    //   156: astore_2
    //   157: aload_1
    //   158: invokeinterface 134 1 0
    //   163: aload_3
    //   164: areturn
    //   165: astore_1
    //   166: aload_3
    //   167: areturn
    //   168: astore_2
    //   169: aload_1
    //   170: invokeinterface 134 1 0
    //   175: aload_2
    //   176: athrow
    //   177: astore_1
    //   178: goto -35 -> 143
    //   181: astore_1
    //   182: goto -7 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	f
    //   0	185	1	paramString	String
    //   0	185	2	parame	e
    //   0	185	3	paramObject	Object
    //   103	3	4	bool	boolean
    //   19	8	5	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   110	116	118	java/lang/Throwable
    //   26	93	121	java/lang/Exception
    //   145	151	153	java/lang/Throwable
    //   97	105	156	java/lang/Throwable
    //   127	133	156	java/lang/Throwable
    //   157	163	165	java/lang/Throwable
    //   97	105	168	finally
    //   127	133	168	finally
    //   137	143	177	java/lang/Throwable
    //   169	175	181	java/lang/Throwable
  }
  
  public final void a() {}
  
  public final void a(String paramString)
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
  
  public final void a(String paramString, Object paramObject, e parame)
  {
    if (this.a == null) {}
    do
    {
      return;
      parame = (Context)this.a.get();
    } while (parame == null);
    if (paramObject == null)
    {
      a(paramString);
      return;
    }
    try
    {
      parame = parame.getContentResolver();
      Uri localUri = this.b;
      ContentValues localContentValues = new ContentValues(1);
      if ((paramObject instanceof Integer)) {
        localContentValues.put(paramString, (Integer)paramObject);
      }
      for (;;)
      {
        parame.insert(localUri, localContentValues);
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
  
  public final Map b()
  {
    return null;
  }
  
  public final void b(String paramString)
  {
    a("*");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.f
 * JD-Core Version:    0.7.0.1
 */