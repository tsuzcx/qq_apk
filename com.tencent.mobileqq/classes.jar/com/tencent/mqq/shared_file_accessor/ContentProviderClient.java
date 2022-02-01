package com.tencent.mqq.shared_file_accessor;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class ContentProviderClient
{
  private static final String CP_URI_BASE = "content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl";
  private static final String DEFAULT_SP_NAME = "default";
  private static final String LOG_TAG = "ContentProviderClient";
  private WeakReference<Context> mContext = null;
  private Uri mUri = null;
  
  public ContentProviderClient(WeakReference<Context> paramWeakReference, String paramString)
  {
    this.mContext = paramWeakReference;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("content://com.tencent.mqq.shared_file_accessor.ContentProviderImpl/params?file=");
    paramWeakReference = paramString;
    if (paramString == null) {
      paramWeakReference = "default";
    }
    localStringBuilder.append(paramWeakReference);
    this.mUri = Uri.parse(localStringBuilder.toString());
  }
  
  private static ContentValues castPair(String paramString, Object paramObject)
  {
    ContentValues localContentValues = new ContentValues(1);
    if ((paramObject instanceof Integer))
    {
      localContentValues.put(paramString, (Integer)paramObject);
      return localContentValues;
    }
    if ((paramObject instanceof Long))
    {
      localContentValues.put(paramString, (Long)paramObject);
      return localContentValues;
    }
    if ((paramObject instanceof Float))
    {
      localContentValues.put(paramString, (Float)paramObject);
      return localContentValues;
    }
    if ((paramObject instanceof String))
    {
      localContentValues.put(paramString, (String)paramObject);
      return localContentValues;
    }
    if ((paramObject instanceof Boolean))
    {
      localContentValues.put(paramString, (Boolean)paramObject);
      return localContentValues;
    }
    localContentValues.put(paramString, "");
    return localContentValues;
  }
  
  private static Object getDataFromCursor(Cursor paramCursor, CommonConstants.ValueType paramValueType)
  {
    if (paramCursor == null) {
      return null;
    }
    boolean bool1;
    try
    {
      int i = paramValueType.mEnumValue;
      bool2 = true;
      bool1 = true;
      switch (i)
      {
      case 6: 
        paramValueType = new HashSet();
        do
        {
          String str = paramCursor.getString(0);
          if (!TextUtils.isEmpty(str)) {
            paramValueType.add(str);
          }
        } while (paramCursor.moveToNext());
        return paramValueType;
      }
    }
    catch (Exception paramCursor)
    {
      boolean bool2;
      return null;
    }
    if (paramCursor.getInt(0) != 0)
    {
      return Boolean.valueOf(bool1);
      return paramCursor.getString(0);
      return Float.valueOf(paramCursor.getFloat(0));
      return Long.valueOf(paramCursor.getLong(0));
      return Integer.valueOf(paramCursor.getInt(0));
      if (paramCursor.getCount() == 0) {
        break label194;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return Boolean.valueOf(bool1);
      return null;
      bool1 = false;
      break;
      label194:
      bool1 = false;
    }
  }
  
  public void clear(String paramString)
  {
    delete("*");
  }
  
  public void commit()
  {
    Object localObject1 = this.mContext;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (Context)((WeakReference)localObject1).get();
    if (localObject2 == null) {
      return;
    }
    localObject1 = null;
    try
    {
      localObject2 = ((Context)localObject2).getContentResolver().query(this.mUri, new String[] { "cmd", "5" }, null, null, null);
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          ((Cursor)localObject1).close();
          return;
        }
        catch (Throwable localThrowable) {}
        localException = localException;
      }
    }
    if (localObject1 != null) {}
  }
  
  public void delete(String paramString)
  {
    Object localObject = this.mContext;
    if (localObject == null) {
      return;
    }
    localObject = (Context)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    try
    {
      ((Context)localObject).getContentResolver().delete(this.mUri, paramString, null);
      return;
    }
    catch (Exception paramString) {}
  }
  
  /* Error */
  public Object read(String paramString, CommonConstants.ValueType paramValueType, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/mqq/shared_file_accessor/ContentProviderClient:mContext	Ljava/lang/ref/WeakReference;
    //   4: astore 5
    //   6: aload 5
    //   8: ifnonnull +5 -> 13
    //   11: aload_3
    //   12: areturn
    //   13: aload 5
    //   15: invokevirtual 165	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   18: checkcast 167	android/content/Context
    //   21: astore 6
    //   23: aload 6
    //   25: ifnonnull +5 -> 30
    //   28: aload_3
    //   29: areturn
    //   30: aconst_null
    //   31: astore 5
    //   33: aload 6
    //   35: invokevirtual 171	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   38: astore 6
    //   40: aload_0
    //   41: getfield 28	com/tencent/mqq/shared_file_accessor/ContentProviderClient:mUri	Landroid/net/Uri;
    //   44: astore 7
    //   46: aload_2
    //   47: getfield 95	com/tencent/mqq/shared_file_accessor/CommonConstants$ValueType:mEnumValue	I
    //   50: invokestatic 191	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   53: astore 8
    //   55: new 30	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   62: astore 9
    //   64: aload 9
    //   66: ldc 85
    //   68: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 9
    //   74: aload_3
    //   75: invokevirtual 194	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 6
    //   81: aload 7
    //   83: bipush 8
    //   85: anewarray 75	java/lang/String
    //   88: dup
    //   89: iconst_0
    //   90: ldc 173
    //   92: aastore
    //   93: dup
    //   94: iconst_1
    //   95: ldc 196
    //   97: aastore
    //   98: dup
    //   99: iconst_2
    //   100: ldc 198
    //   102: aastore
    //   103: dup
    //   104: iconst_3
    //   105: aload_1
    //   106: aastore
    //   107: dup
    //   108: iconst_4
    //   109: ldc 200
    //   111: aastore
    //   112: dup
    //   113: iconst_5
    //   114: aload 8
    //   116: aastore
    //   117: dup
    //   118: bipush 6
    //   120: ldc 11
    //   122: aastore
    //   123: dup
    //   124: bipush 7
    //   126: aload 9
    //   128: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: aastore
    //   132: aconst_null
    //   133: aconst_null
    //   134: aconst_null
    //   135: invokevirtual 181	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   138: astore_1
    //   139: aload_1
    //   140: ifnonnull +5 -> 145
    //   143: aload_3
    //   144: areturn
    //   145: aload_1
    //   146: invokeinterface 203 1 0
    //   151: istore 4
    //   153: iload 4
    //   155: ifne +11 -> 166
    //   158: aload_1
    //   159: invokeinterface 184 1 0
    //   164: aload_3
    //   165: areturn
    //   166: aload_1
    //   167: aload_2
    //   168: invokestatic 205	com/tencent/mqq/shared_file_accessor/ContentProviderClient:getDataFromCursor	(Landroid/database/Cursor;Lcom/tencent/mqq/shared_file_accessor/CommonConstants$ValueType;)Ljava/lang/Object;
    //   171: astore_2
    //   172: aload_2
    //   173: ifnull +11 -> 184
    //   176: aload_1
    //   177: invokeinterface 184 1 0
    //   182: aload_2
    //   183: areturn
    //   184: aload_1
    //   185: invokeinterface 184 1 0
    //   190: aload_3
    //   191: areturn
    //   192: astore_2
    //   193: aload_1
    //   194: invokeinterface 184 1 0
    //   199: aload_2
    //   200: athrow
    //   201: aload_1
    //   202: invokeinterface 184 1 0
    //   207: aload_3
    //   208: areturn
    //   209: astore_1
    //   210: aload 5
    //   212: astore_1
    //   213: goto -74 -> 139
    //   216: astore_2
    //   217: goto -16 -> 201
    //   220: astore_1
    //   221: aload_3
    //   222: areturn
    //   223: astore_1
    //   224: aload_2
    //   225: areturn
    //   226: astore_1
    //   227: aload_3
    //   228: areturn
    //   229: astore_1
    //   230: goto -31 -> 199
    //   233: astore_1
    //   234: aload_3
    //   235: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	236	0	this	ContentProviderClient
    //   0	236	1	paramString	String
    //   0	236	2	paramValueType	CommonConstants.ValueType
    //   0	236	3	paramObject	Object
    //   151	3	4	bool	boolean
    //   4	207	5	localWeakReference	WeakReference
    //   21	59	6	localObject	Object
    //   44	38	7	localUri	Uri
    //   53	62	8	str	String
    //   62	65	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   145	153	192	finally
    //   166	172	192	finally
    //   33	139	209	java/lang/Exception
    //   145	153	216	java/lang/Throwable
    //   166	172	216	java/lang/Throwable
    //   158	164	220	java/lang/Throwable
    //   176	182	223	java/lang/Throwable
    //   184	190	226	java/lang/Throwable
    //   193	199	229	java/lang/Throwable
    //   201	207	233	java/lang/Throwable
  }
  
  public Map<String, ?> readAll()
  {
    return null;
  }
  
  public void write(String paramString, Object paramObject, CommonConstants.ValueType paramValueType)
  {
    paramValueType = this.mContext;
    if (paramValueType == null) {
      return;
    }
    paramValueType = (Context)paramValueType.get();
    if (paramValueType == null) {
      return;
    }
    if (paramObject == null)
    {
      delete(paramString);
      return;
    }
    try
    {
      paramValueType.getContentResolver().insert(this.mUri, castPair(paramString, paramObject));
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.ContentProviderClient
 * JD-Core Version:    0.7.0.1
 */