package io.flutter.plugins.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import java.io.IOException;
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
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: new 54	java/io/ObjectInputStream
    //   7: dup
    //   8: new 56	java/io/ByteArrayInputStream
    //   11: dup
    //   12: aload_1
    //   13: iconst_0
    //   14: invokestatic 62	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   17: invokespecial 65	java/io/ByteArrayInputStream:<init>	([B)V
    //   20: invokespecial 68	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual 72	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   28: checkcast 74	java/util/List
    //   31: astore_2
    //   32: aload_1
    //   33: invokevirtual 77	java/io/ObjectInputStream:close	()V
    //   36: aload_2
    //   37: areturn
    //   38: astore_2
    //   39: goto +31 -> 70
    //   42: astore_3
    //   43: aload_1
    //   44: astore_2
    //   45: aload_3
    //   46: astore_1
    //   47: goto +14 -> 61
    //   50: astore_3
    //   51: aload_2
    //   52: astore_1
    //   53: aload_3
    //   54: astore_2
    //   55: goto +15 -> 70
    //   58: astore_1
    //   59: aload_3
    //   60: astore_2
    //   61: new 79	java/io/IOException
    //   64: dup
    //   65: aload_1
    //   66: invokespecial 82	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   69: athrow
    //   70: aload_1
    //   71: ifnull +7 -> 78
    //   74: aload_1
    //   75: invokevirtual 77	java/io/ObjectInputStream:close	()V
    //   78: aload_2
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	MethodCallHandlerImpl
    //   0	80	1	paramString	String
    //   3	34	2	localList	List
    //   38	1	2	localObject1	Object
    //   44	35	2	localObject2	Object
    //   1	1	3	localObject3	Object
    //   42	4	3	localClassNotFoundException	java.lang.ClassNotFoundException
    //   50	10	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   24	32	38	finally
    //   24	32	42	java/lang/ClassNotFoundException
    //   4	24	50	finally
    //   61	70	50	finally
    //   4	24	58	java/lang/ClassNotFoundException
  }
  
  /* Error */
  private String encodeList(List<String> paramList)
  {
    // Byte code:
    //   0: new 88	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 89	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: new 91	java/io/ObjectOutputStream
    //   11: dup
    //   12: aload_3
    //   13: invokespecial 94	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_1
    //   19: invokevirtual 98	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   22: aload_2
    //   23: invokevirtual 101	java/io/ObjectOutputStream:flush	()V
    //   26: aload_3
    //   27: invokevirtual 105	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   30: iconst_0
    //   31: invokestatic 109	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   34: astore_1
    //   35: aload_2
    //   36: invokevirtual 110	java/io/ObjectOutputStream:close	()V
    //   39: aload_1
    //   40: areturn
    //   41: astore_3
    //   42: aload_2
    //   43: astore_1
    //   44: aload_3
    //   45: astore_2
    //   46: goto +6 -> 52
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_1
    //   52: aload_1
    //   53: ifnull +7 -> 60
    //   56: aload_1
    //   57: invokevirtual 110	java/io/ObjectOutputStream:close	()V
    //   60: aload_2
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	MethodCallHandlerImpl
    //   0	62	1	paramList	List<String>
    //   16	30	2	localObject1	Object
    //   49	12	2	localObject2	Object
    //   7	20	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   41	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   17	35	41	finally
    //   0	17	49	finally
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
            localObject1 = decodeList(((String)localObject3).substring(40));
          }
          else if (((String)localObject3).startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy"))
          {
            localObject1 = new BigInteger(((String)localObject3).substring(44), 36);
          }
          else
          {
            localObject1 = localObject2;
            if (((String)localObject3).startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
              localObject1 = Double.valueOf(((String)localObject3).substring(40));
            }
          }
        }
        else
        {
          localObject1 = localObject2;
          if ((localObject2 instanceof Set))
          {
            localObject1 = new ArrayList((Set)localObject2);
            localObject2 = this.preferences.edit().remove(str);
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu");
            ((StringBuilder)localObject3).append(encodeList((List)localObject1));
            if (!((SharedPreferences.Editor)localObject2).putString(str, ((StringBuilder)localObject3).toString()).commit()) {
              throw new IOException("Could not migrate set to list");
            }
          }
        }
        localHashMap.put(str, localObject1);
      }
    }
    return localHashMap;
  }
  
  public void onMethodCall(MethodCall paramMethodCall, MethodChannel.Result paramResult)
  {
    Object localObject1 = (String)paramMethodCall.argument("key");
    try
    {
      Object localObject2 = paramMethodCall.method;
      int i = -1;
      switch (((String)localObject2).hashCode())
      {
      case 1984457324: 
        if (((String)localObject2).equals("setBool")) {
          i = 0;
        }
        break;
      case 589412115: 
        if (((String)localObject2).equals("setString")) {
          i = 3;
        }
        break;
      case 155439827: 
        if (((String)localObject2).equals("setDouble")) {
          i = 1;
        }
        break;
      case 94746189: 
        if (((String)localObject2).equals("clear")) {
          i = 8;
        }
        break;
      case -905809875: 
        if (((String)localObject2).equals("setInt")) {
          i = 2;
        }
        break;
      case -934610812: 
        if (((String)localObject2).equals("remove")) {
          i = 7;
        }
        break;
      case -1096934831: 
        if (((String)localObject2).equals("setStringList")) {
          i = 4;
        }
        break;
      case -1249367445: 
        if (((String)localObject2).equals("getAll")) {
          i = 6;
        }
        break;
      case -1354815177: 
        boolean bool = ((String)localObject2).equals("commit");
        if (bool) {
          i = 5;
        }
        break;
      }
      for (;;)
      {
        switch (i)
        {
        default: 
          paramResult.notImplemented();
          return;
        case 8: 
          localObject2 = getAllPrefs().keySet();
          localObject1 = this.preferences.edit();
          localObject2 = ((Set)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((SharedPreferences.Editor)localObject1).remove((String)((Iterator)localObject2).next());
          }
          commitAsync((SharedPreferences.Editor)localObject1, paramResult);
          return;
        case 7: 
          localObject1 = this.preferences.edit().remove((String)localObject1);
        }
        for (;;)
        {
          commitAsync((SharedPreferences.Editor)localObject1, paramResult);
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
          localObject1 = localEditor.putString((String)localObject1, localStringBuilder.toString());
          continue;
          localObject2 = (String)paramMethodCall.argument("value");
          if ((!((String)localObject2).startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu")) && (!((String)localObject2).startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy")))
          {
            localObject1 = this.preferences.edit().putString((String)localObject1, (String)localObject2);
          }
          else
          {
            paramResult.error("StorageError", "This string cannot be stored as it clashes with special identifier prefixes.", null);
            return;
            localObject2 = (Number)paramMethodCall.argument("value");
            if ((localObject2 instanceof BigInteger))
            {
              localObject2 = (BigInteger)localObject2;
              localEditor = this.preferences.edit();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy");
              localStringBuilder.append(((BigInteger)localObject2).toString(36));
              localObject1 = localEditor.putString((String)localObject1, localStringBuilder.toString());
            }
            else
            {
              localObject1 = this.preferences.edit().putLong((String)localObject1, ((Number)localObject2).longValue());
              continue;
              localObject2 = Double.toString(((Number)paramMethodCall.argument("value")).doubleValue());
              localEditor = this.preferences.edit();
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu");
              localStringBuilder.append((String)localObject2);
              localObject1 = localEditor.putString((String)localObject1, localStringBuilder.toString());
              continue;
              localObject1 = this.preferences.edit().putBoolean((String)localObject1, ((Boolean)paramMethodCall.argument("value")).booleanValue());
            }
          }
        }
      }
    }
    catch (IOException localIOException)
    {
      paramResult.error("IOException encountered", paramMethodCall.method, localIOException);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugins.sharedpreferences.MethodCallHandlerImpl
 * JD-Core Version:    0.7.0.1
 */