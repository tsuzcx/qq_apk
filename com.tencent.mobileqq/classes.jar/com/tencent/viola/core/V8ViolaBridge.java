package com.tencent.viola.core;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Function;
import com.eclipsesource.v8.V8Object;
import com.eclipsesource.v8.V8ScriptException;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class V8ViolaBridge
  implements IViolaBridge
{
  private static final String TAG = "V8ViolaBridge";
  private final V8ViolaBridge.CallNative callNative = new V8ViolaBridge.CallNative(this);
  private final V8ViolaBridge.SetTimeout setTimeout = new V8ViolaBridge.SetTimeout(this);
  private V8ViolaBridge.V8RefHandler v8RefHandler;
  private V8 violaRuntime;
  
  private int initMainJS(String paramString1, String paramString2)
  {
    safeRunOnV8(new V8ViolaBridge.1(this, paramString2, paramString1));
    return 1;
  }
  
  private int initV8()
  {
    if (this.violaRuntime == null) {
      this.violaRuntime = V8.createV8Runtime();
    }
    return 1;
  }
  
  public static V8Object jSONObject2V8Object(V8 paramV8, JSONObject paramJSONObject, List<V8Object> paramList)
  {
    if (paramJSONObject == null) {
      return new V8Object(paramV8);
    }
    Iterator localIterator = paramJSONObject.keys();
    V8Object localV8Object = new V8Object(paramV8);
    if (paramList != null) {
      paramList.add(localV8Object);
    }
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.opt(str);
      if ((localObject instanceof Integer)) {
        localV8Object.add(str, ((Integer)localObject).intValue());
      } else if ((localObject instanceof Boolean)) {
        localV8Object.add(str, ((Boolean)localObject).booleanValue());
      } else if ((!(localObject instanceof Double)) && (!(localObject instanceof Float)))
      {
        if ((localObject instanceof JSONObject)) {
          localV8Object.add(str, jSONObject2V8Object(paramV8, (JSONObject)localObject, paramList));
        } else if ((localObject instanceof JSONArray)) {
          localV8Object.add(str, jsonArray2V8Array(paramV8, (JSONArray)localObject, paramList));
        } else if ((localObject instanceof String)) {
          localV8Object.add(str, (String)localObject);
        }
      }
      else {
        localV8Object.add(str, ((Double)localObject).doubleValue());
      }
    }
    return localV8Object;
  }
  
  public static V8Array jsonArray2V8Array(V8 paramV8, JSONArray paramJSONArray, List<V8Object> paramList)
  {
    if (paramJSONArray == null) {
      return new V8Array(paramV8);
    }
    V8Array localV8Array = new V8Array(paramV8);
    if (paramList != null) {
      paramList.add(localV8Array);
    }
    int j = paramJSONArray.length();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramJSONArray.opt(i);
      if ((localObject instanceof JSONArray)) {
        localV8Array.push(jsonArray2V8Array(paramV8, (JSONArray)localObject, paramList));
      } else if ((localObject instanceof JSONObject)) {
        localV8Array.push(jSONObject2V8Object(paramV8, (JSONObject)localObject, paramList));
      } else {
        localV8Array.push(localObject);
      }
      i += 1;
    }
    return localV8Array;
  }
  
  private void releaseV8Objects(List<V8Object> paramList)
  {
    if (paramList == null) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((V8Object)paramList.next()).close();
    }
  }
  
  private void safeRunOnV8(Runnable paramRunnable)
  {
    Object localObject = this.violaRuntime;
    if (localObject != null)
    {
      if (((V8)localObject).isReleased()) {
        return;
      }
      try
      {
        paramRunnable.run();
        return;
      }
      catch (Throwable paramRunnable)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[v8 exception]: ");
        ((StringBuilder)localObject).append(paramRunnable.getMessage());
        ViolaLogUtils.e("V8ViolaBridge", ((StringBuilder)localObject).toString());
        return;
      }
      catch (V8ScriptException paramRunnable)
      {
        ViolaBridge.callError(2, paramRunnable.getJSStackTrace());
      }
    }
  }
  
  public static JSONArray v8Array2JSONArray(V8Array paramV8Array)
  {
    if (paramV8Array == null) {
      return new JSONArray();
    }
    JSONArray localJSONArray = new JSONArray();
    int j = paramV8Array.length();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramV8Array.get(i);
      if ((localObject instanceof V8Array))
      {
        localObject = (V8Array)localObject;
        localJSONArray.put(v8Array2JSONArray((V8Array)localObject));
        ((V8Array)localObject).close();
      }
      else if ((localObject instanceof V8Function))
      {
        localJSONArray.put(localObject);
      }
      else if ((localObject instanceof V8Object))
      {
        localObject = (V8Object)localObject;
        localJSONArray.put(v8Object2JSONObject((V8Object)localObject));
        ((V8Object)localObject).close();
      }
      else
      {
        localJSONArray.put(localObject);
      }
      i += 1;
    }
    return localJSONArray;
  }
  
  public static JSONObject v8Object2JSONObject(V8Object paramV8Object)
  {
    JSONObject localJSONObject;
    if ((paramV8Object != null) && (paramV8Object.getV8Type() != 99) && (paramV8Object.getV8Type() != 0))
    {
      localJSONObject = new JSONObject();
      String[] arrayOfString = paramV8Object.getKeys();
      int i = 0;
      try
      {
        while (i < arrayOfString.length)
        {
          String str = arrayOfString[i];
          Object localObject = paramV8Object.get(str);
          if ((localObject instanceof V8Array))
          {
            localObject = (V8Array)localObject;
            localJSONObject.put(str, v8Array2JSONArray((V8Array)localObject));
            ((V8Array)localObject).close();
          }
          else if ((localObject instanceof V8Object))
          {
            localObject = (V8Object)localObject;
            localJSONObject.put(str, v8Object2JSONObject((V8Object)localObject));
            ((V8Object)localObject).close();
          }
          else
          {
            localJSONObject.put(str, localObject);
          }
          i += 1;
        }
        return localJSONObject;
      }
      catch (Exception paramV8Object)
      {
        ViolaLogUtils.e("V8ViolaBridge", paramV8Object.getMessage());
      }
    }
    return null;
  }
  
  public void addGlobalVar(String paramString, JSONObject paramJSONObject)
  {
    safeRunOnV8(new V8ViolaBridge.9(this, paramJSONObject, paramString));
  }
  
  public int callJS(String paramString1, String paramString2)
  {
    safeRunOnV8(new V8ViolaBridge.3(this, paramString1, paramString2));
    return 1;
  }
  
  public int createInstance(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    safeRunOnV8(new V8ViolaBridge.4(this, paramString1, paramString2, paramString3, paramString4));
    return 1;
  }
  
  public V8Array createV8Array()
  {
    return new V8Array(this.violaRuntime);
  }
  
  public V8Object createV8Object()
  {
    return new V8Object(this.violaRuntime);
  }
  
  public int destroy()
  {
    safeRunOnV8(new V8ViolaBridge.7(this));
    return 1;
  }
  
  public int destroyInstance(String paramString)
  {
    safeRunOnV8(new V8ViolaBridge.6(this, paramString));
    return 1;
  }
  
  public int execJSFunc(String paramString1, String paramString2)
  {
    safeRunOnV8(new V8ViolaBridge.2(this, paramString2, paramString1));
    return 1;
  }
  
  /* Error */
  public com.tencent.viola.commons.JSParam execJSFuncWithResult(String paramString, List<com.tencent.viola.commons.JSParam> paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +298 -> 299
    //   4: aload_0
    //   5: getfield 39	com/tencent/viola/core/V8ViolaBridge:violaRuntime	Lcom/eclipsesource/v8/V8;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnull +289 -> 299
    //   13: aload_3
    //   14: invokevirtual 181	com/eclipsesource/v8/V8:isReleased	()Z
    //   17: ifeq +5 -> 22
    //   20: aconst_null
    //   21: areturn
    //   22: aload_2
    //   23: invokeinterface 170 1 0
    //   28: astore 5
    //   30: aload 5
    //   32: invokeinterface 97 1 0
    //   37: ifeq +262 -> 299
    //   40: aload 5
    //   42: invokeinterface 101 1 0
    //   47: checkcast 294	com/tencent/viola/commons/JSParam
    //   50: astore_2
    //   51: aload_2
    //   52: getfield 298	com/tencent/viola/commons/JSParam:type	I
    //   55: iconst_3
    //   56: if_icmpne -26 -> 30
    //   59: new 300	java/util/ArrayList
    //   62: dup
    //   63: invokespecial 301	java/util/ArrayList:<init>	()V
    //   66: astore_3
    //   67: aload_0
    //   68: invokevirtual 303	com/tencent/viola/core/V8ViolaBridge:createV8Array	()Lcom/eclipsesource/v8/V8Array;
    //   71: astore 4
    //   73: aload 4
    //   75: aload_0
    //   76: getfield 39	com/tencent/viola/core/V8ViolaBridge:violaRuntime	Lcom/eclipsesource/v8/V8;
    //   79: new 81	org/json/JSONObject
    //   82: dup
    //   83: aload_2
    //   84: getfield 307	com/tencent/viola/commons/JSParam:data	Ljava/lang/Object;
    //   87: invokevirtual 308	java/lang/Object:toString	()Ljava/lang/String;
    //   90: invokespecial 311	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   93: aload_3
    //   94: invokestatic 129	com/tencent/viola/core/V8ViolaBridge:jSONObject2V8Object	(Lcom/eclipsesource/v8/V8;Lorg/json/JSONObject;Ljava/util/List;)Lcom/eclipsesource/v8/V8Object;
    //   97: invokevirtual 163	com/eclipsesource/v8/V8Array:push	(Lcom/eclipsesource/v8/V8Value;)Lcom/eclipsesource/v8/V8Array;
    //   100: pop
    //   101: aload_0
    //   102: getfield 39	com/tencent/viola/core/V8ViolaBridge:violaRuntime	Lcom/eclipsesource/v8/V8;
    //   105: aload_1
    //   106: aload 4
    //   108: invokevirtual 315	com/eclipsesource/v8/V8:executeFunction	(Ljava/lang/String;Lcom/eclipsesource/v8/V8Array;)Ljava/lang/Object;
    //   111: astore_2
    //   112: aload_2
    //   113: instanceof 103
    //   116: ifeq +27 -> 143
    //   119: new 294	com/tencent/viola/commons/JSParam
    //   122: dup
    //   123: iconst_2
    //   124: aload_2
    //   125: invokespecial 318	com/tencent/viola/commons/JSParam:<init>	(ILjava/lang/Object;)V
    //   128: astore_2
    //   129: aload_2
    //   130: astore_1
    //   131: aload_0
    //   132: aload_3
    //   133: invokespecial 49	com/tencent/viola/core/V8ViolaBridge:releaseV8Objects	(Ljava/util/List;)V
    //   136: aload 4
    //   138: invokevirtual 231	com/eclipsesource/v8/V8Array:close	()V
    //   141: aload_1
    //   142: areturn
    //   143: aload_2
    //   144: instanceof 125
    //   147: ifeq +59 -> 206
    //   150: new 188	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   157: astore 6
    //   159: aload 6
    //   161: ldc_w 320
    //   164: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 6
    //   170: aload_2
    //   171: invokevirtual 308	java/lang/Object:toString	()Ljava/lang/String;
    //   174: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: ldc 10
    //   180: aload 6
    //   182: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 208	com/tencent/viola/utils/ViolaLogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: new 294	com/tencent/viola/commons/JSParam
    //   191: dup
    //   192: iconst_2
    //   193: aload_2
    //   194: invokevirtual 308	java/lang/Object:toString	()Ljava/lang/String;
    //   197: invokespecial 318	com/tencent/viola/commons/JSParam:<init>	(ILjava/lang/Object;)V
    //   200: astore_2
    //   201: aload_2
    //   202: astore_1
    //   203: goto -72 -> 131
    //   206: aload_2
    //   207: instanceof 109
    //   210: ifeq +64 -> 274
    //   213: new 294	com/tencent/viola/commons/JSParam
    //   216: dup
    //   217: iconst_2
    //   218: aload_2
    //   219: invokevirtual 308	java/lang/Object:toString	()Ljava/lang/String;
    //   222: invokespecial 318	com/tencent/viola/commons/JSParam:<init>	(ILjava/lang/Object;)V
    //   225: astore_2
    //   226: aload_2
    //   227: astore_1
    //   228: goto -97 -> 131
    //   231: astore_1
    //   232: goto +55 -> 287
    //   235: astore_2
    //   236: new 188	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 189	java/lang/StringBuilder:<init>	()V
    //   243: astore 6
    //   245: aload 6
    //   247: ldc_w 320
    //   250: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 6
    //   256: aload_2
    //   257: invokevirtual 199	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   260: invokevirtual 195	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: ldc 10
    //   266: aload 6
    //   268: invokevirtual 202	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 208	com/tencent/viola/utils/ViolaLogUtils:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   274: aload_0
    //   275: aload_3
    //   276: invokespecial 49	com/tencent/viola/core/V8ViolaBridge:releaseV8Objects	(Ljava/util/List;)V
    //   279: aload 4
    //   281: invokevirtual 231	com/eclipsesource/v8/V8Array:close	()V
    //   284: goto -254 -> 30
    //   287: aload_0
    //   288: aload_3
    //   289: invokespecial 49	com/tencent/viola/core/V8ViolaBridge:releaseV8Objects	(Ljava/util/List;)V
    //   292: aload 4
    //   294: invokevirtual 231	com/eclipsesource/v8/V8Array:close	()V
    //   297: aload_1
    //   298: athrow
    //   299: aconst_null
    //   300: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	V8ViolaBridge
    //   0	301	1	paramString	String
    //   0	301	2	paramList	List<com.tencent.viola.commons.JSParam>
    //   8	281	3	localObject	Object
    //   71	222	4	localV8Array	V8Array
    //   28	13	5	localIterator	Iterator
    //   157	110	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   73	129	231	finally
    //   143	201	231	finally
    //   206	226	231	finally
    //   236	274	231	finally
    //   73	129	235	java/lang/Throwable
    //   143	201	235	java/lang/Throwable
    //   206	226	235	java/lang/Throwable
  }
  
  public JSONObject getGlobalVar(String paramString)
  {
    JSONObject[] arrayOfJSONObject = new JSONObject[1];
    arrayOfJSONObject[0] = null;
    safeRunOnV8(new V8ViolaBridge.8(this, paramString, arrayOfJSONObject));
    return arrayOfJSONObject[0];
  }
  
  public int init()
  {
    return initV8();
  }
  
  public int initJsFramework(String paramString1, String paramString2)
  {
    return initMainJS(paramString1, paramString2);
  }
  
  public void initV8RefHandler()
  {
    this.v8RefHandler = new V8ViolaBridge.V8RefHandler(null);
    this.violaRuntime.addReferenceHandler(this.v8RefHandler);
  }
  
  public void preloadTest(String paramString1, String paramString2) {}
  
  public void releaseAllV8Objects()
  {
    V8ViolaBridge.V8RefHandler localV8RefHandler = this.v8RefHandler;
    if (localV8RefHandler != null) {
      localV8RefHandler.tryReleasePendingV8Object();
    }
  }
  
  public int updateInstance(String paramString1, String paramString2)
  {
    safeRunOnV8(new V8ViolaBridge.5(this, paramString1, paramString2));
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.core.V8ViolaBridge
 * JD-Core Version:    0.7.0.1
 */