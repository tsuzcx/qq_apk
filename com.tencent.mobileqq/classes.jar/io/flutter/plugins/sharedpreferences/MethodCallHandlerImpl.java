package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MethodCallHandlerImpl
  implements MethodChannel.MethodCallHandler
{
  private static final String BIG_INTEGER_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy";
  private static final String DOUBLE_PREFIX = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu";
  private static final String LIST_IDENTIFIER = "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu";
  private static final String SHARED_PREFERENCES_NAME = "FlutterSharedPreferences";
  private final SharedPreferences preferences;
  
  MethodCallHandlerImpl(Context paramContext)
  {
    this.preferences = paramContext.getSharedPreferences("FlutterSharedPreferences", 0);
  }
  
  private void commitAsync(SharedPreferences.Editor paramEditor, MethodChannel.Result paramResult)
  {
    new MethodCallHandlerImpl.1(this, paramEditor, paramResult).execute(new Void[0]);
  }
  
  /* Error */
  private List<String> decodeList(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 54	java/io/ObjectInputStream
    //   5: dup
    //   6: new 56	java/io/ByteArrayInputStream
    //   9: dup
    //   10: aload_1
    //   11: iconst_0
    //   12: invokestatic 62	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   15: invokespecial 65	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: invokespecial 68	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   21: astore_1
    //   22: aload_1
    //   23: invokevirtual 72	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   26: checkcast 74	java/util/List
    //   29: astore_2
    //   30: aload_1
    //   31: invokevirtual 77	java/io/ObjectInputStream:close	()V
    //   34: aload_2
    //   35: areturn
    //   36: astore_1
    //   37: aload_2
    //   38: astore_3
    //   39: aload_1
    //   40: astore_2
    //   41: aload_3
    //   42: ifnull +7 -> 49
    //   45: aload_3
    //   46: invokevirtual 77	java/io/ObjectInputStream:close	()V
    //   49: aload_2
    //   50: athrow
    //   51: astore_2
    //   52: aconst_null
    //   53: astore_1
    //   54: new 79	java/io/IOException
    //   57: dup
    //   58: aload_2
    //   59: invokespecial 82	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   62: athrow
    //   63: astore_3
    //   64: aload_1
    //   65: astore_2
    //   66: aload_3
    //   67: astore_1
    //   68: goto -31 -> 37
    //   71: astore_2
    //   72: goto -18 -> 54
    //   75: astore_2
    //   76: aload_1
    //   77: astore_3
    //   78: goto -37 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	MethodCallHandlerImpl
    //   0	81	1	paramString	String
    //   1	49	2	localObject1	Object
    //   51	8	2	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   65	1	2	str1	String
    //   71	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   75	1	2	localObject2	Object
    //   38	8	3	localObject3	Object
    //   63	4	3	localObject4	Object
    //   77	1	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	22	36	finally
    //   2	22	51	java/lang/ClassNotFoundException
    //   54	63	63	finally
    //   22	30	71	java/lang/ClassNotFoundException
    //   22	30	75	finally
  }
  
  private String encodeList(List<String> paramList)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      try
      {
        localObjectOutputStream.writeObject(paramList);
        localObjectOutputStream.flush();
        paramList = Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 0);
        localObjectOutputStream.close();
        return paramList;
      }
      finally {}
    }
    finally
    {
      ObjectOutputStream localObjectOutputStream = null;
    }
    if (localObjectOutputStream != null) {
      localObjectOutputStream.close();
    }
    throw paramList;
  }
  
  private Map<String, Object> getAllPrefs()
  {
    Map localMap = this.preferences.getAll();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (str.startsWith("flutter."))
      {
        Object localObject2 = localMap.get(str);
        Object localObject3;
        Object localObject1;
        if ((localObject2 instanceof String))
        {
          localObject3 = (String)localObject2;
          if (((String)localObject3).startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu"))
          {
            localObject1 = decodeList(((String)localObject3).substring("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu".length()));
            localHashMap.put(str, localObject1);
            continue;
          }
          if (((String)localObject3).startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy")) {
            localObject1 = new BigInteger(((String)localObject3).substring("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy".length()), 36);
          }
        }
        do
        {
          break;
          localObject1 = localObject2;
          if (!((String)localObject3).startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
            break;
          }
          localObject1 = Double.valueOf(((String)localObject3).substring("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu".length()));
          break;
          localObject1 = localObject2;
          if (!(localObject2 instanceof Set)) {
            break;
          }
          localObject1 = new ArrayList((Set)localObject2);
          localObject2 = this.preferences.edit().remove(str);
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu");
          ((StringBuilder)localObject3).append(encodeList((List)localObject1));
        } while (((SharedPreferences.Editor)localObject2).putString(str, ((StringBuilder)localObject3).toString()).commit());
        throw new IOException("Could not migrate set to list");
      }
    }
    return localHashMap;
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    Object localObject1 = (String)paramMethodCall.argument("key");
    for (;;)
    {
      Object localObject2;
      int i;
      try
      {
        localObject2 = paramMethodCall.method;
        i = -1;
        switch (((String)localObject2).hashCode())
        {
        case 1984457324: 
          paramResult.notImplemented();
          return;
        }
      }
      catch (IOException localIOException)
      {
        paramResult.error("IOException encountered", paramMethodCall.method, localIOException);
        return;
      }
      if (((String)localObject2).equals("setBool"))
      {
        i = 0;
        break label755;
        if (((String)localObject2).equals("setString"))
        {
          i = 3;
          break label755;
          if (((String)localObject2).equals("setDouble"))
          {
            i = 1;
            break label755;
            if (((String)localObject2).equals("clear"))
            {
              i = 8;
              break label755;
              if (((String)localObject2).equals("setInt"))
              {
                i = 2;
                break label755;
                if (((String)localObject2).equals("remove"))
                {
                  i = 7;
                  break label755;
                  if (((String)localObject2).equals("setStringList"))
                  {
                    i = 4;
                    break label755;
                    if (((String)localObject2).equals("getAll"))
                    {
                      i = 6;
                      break label755;
                      if (((String)localObject2).equals("commit"))
                      {
                        i = 5;
                        break label755;
                        localObject2 = getAllPrefs().keySet();
                        localObject1 = this.preferences.edit();
                        localObject2 = ((Set)localObject2).iterator();
                        if (((Iterator)localObject2).hasNext())
                        {
                          ((SharedPreferences.Editor)localObject1).remove((String)((Iterator)localObject2).next());
                          continue;
                        }
                        commitAsync(localIOException, paramResult);
                        return;
                        commitAsync(this.preferences.edit().remove(localIOException), paramResult);
                        return;
                        paramResult.success(getAllPrefs());
                        return;
                        paramResult.success(Boolean.valueOf(true));
                        return;
                        localObject2 = (List)paramMethodCall.argument("value");
                        SharedPreferences.Editor localEditor = this.preferences.edit();
                        StringBuilder localStringBuilder = new StringBuilder();
                        localStringBuilder.append("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu");
                        localStringBuilder.append(encodeList((List)localObject2));
                        commitAsync(localEditor.putString(localIOException, localStringBuilder.toString()), paramResult);
                        return;
                        localObject2 = (String)paramMethodCall.argument("value");
                        if ((((String)localObject2).startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu")) || (((String)localObject2).startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy")))
                        {
                          paramResult.error("StorageError", "This string cannot be stored as it clashes with special identifier prefixes.", null);
                          return;
                        }
                        commitAsync(this.preferences.edit().putString(localIOException, (String)localObject2), paramResult);
                        return;
                        localObject2 = (Number)paramMethodCall.argument("value");
                        if ((localObject2 instanceof BigInteger))
                        {
                          localObject2 = (BigInteger)localObject2;
                          localEditor = this.preferences.edit();
                          localStringBuilder = new StringBuilder();
                          localStringBuilder.append("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy");
                          localStringBuilder.append(((BigInteger)localObject2).toString(36));
                          commitAsync(localEditor.putString(localIOException, localStringBuilder.toString()), paramResult);
                          return;
                        }
                        commitAsync(this.preferences.edit().putLong(localIOException, ((Number)localObject2).longValue()), paramResult);
                        return;
                        localObject2 = Double.toString(((Number)paramMethodCall.argument("value")).doubleValue());
                        localEditor = this.preferences.edit();
                        localStringBuilder = new StringBuilder();
                        localStringBuilder.append("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu");
                        localStringBuilder.append((String)localObject2);
                        commitAsync(localEditor.putString(localIOException, localStringBuilder.toString()), paramResult);
                        return;
                        commitAsync(this.preferences.edit().putBoolean(localIOException, ((Boolean)paramMethodCall.argument("value")).booleanValue()), paramResult);
                        return;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label755:
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.plugins.sharedpreferences.MethodCallHandlerImpl
 * JD-Core Version:    0.7.0.1
 */