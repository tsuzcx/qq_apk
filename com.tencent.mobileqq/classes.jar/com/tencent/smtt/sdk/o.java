package com.tencent.smtt.sdk;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

class o
{
  public boolean a = false;
  public boolean b = false;
  private Map<String, String> c = null;
  
  public JSONObject a()
  {
    localJSONObject = new JSONObject();
    if (this.c != null) {
      try
      {
        Iterator localIterator = this.c.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
        }
        return localJSONObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, byte paramByte)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString);
        if (bool) {
          return;
        }
        str = "";
        if (paramByte == 1)
        {
          str = "_begin";
          this.c.put(paramString + str, String.valueOf(System.currentTimeMillis()));
          continue;
        }
        if (paramByte != 2) {
          continue;
        }
      }
      finally {}
      String str = "_end";
    }
  }
  
  /* Error */
  public void a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 20	com/tencent/smtt/sdk/o:c	Ljava/util/Map;
    //   20: aload_1
    //   21: lload_2
    //   22: invokestatic 101	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   25: invokeinterface 104 3 0
    //   30: pop
    //   31: goto -18 -> 13
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	o
    //   0	39	1	paramString	String
    //   0	39	2	paramLong	long
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	34	finally
    //   16	31	34	finally
  }
  
  /* Error */
  public boolean a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 113	com/tencent/smtt/sdk/x:a	()Lcom/tencent/smtt/sdk/x;
    //   7: astore 4
    //   9: aload 4
    //   11: invokevirtual 115	com/tencent/smtt/sdk/x:b	()Z
    //   14: ifeq +202 -> 216
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 18	com/tencent/smtt/sdk/o:b	Z
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 16	com/tencent/smtt/sdk/o:a	Z
    //   27: aload_0
    //   28: getfield 20	com/tencent/smtt/sdk/o:c	Ljava/util/Map;
    //   31: ldc 117
    //   33: aload_0
    //   34: getfield 18	com/tencent/smtt/sdk/o:b	Z
    //   37: invokestatic 120	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   40: invokeinterface 104 3 0
    //   45: pop
    //   46: aload_0
    //   47: getfield 20	com/tencent/smtt/sdk/o:c	Ljava/util/Map;
    //   50: ldc 122
    //   52: aload_0
    //   53: getfield 16	com/tencent/smtt/sdk/o:a	Z
    //   56: invokestatic 120	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   59: invokeinterface 104 3 0
    //   64: pop
    //   65: aload_0
    //   66: getfield 20	com/tencent/smtt/sdk/o:c	Ljava/util/Map;
    //   69: ldc 124
    //   71: iload_1
    //   72: invokestatic 129	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   75: invokeinterface 104 3 0
    //   80: pop
    //   81: aload_0
    //   82: getfield 20	com/tencent/smtt/sdk/o:c	Ljava/util/Map;
    //   85: ldc 131
    //   87: aload_2
    //   88: invokeinterface 104 3 0
    //   93: pop
    //   94: getstatic 136	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   97: ifnull +56 -> 153
    //   100: getstatic 136	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   103: ldc 138
    //   105: invokeinterface 142 2 0
    //   110: ifeq +43 -> 153
    //   113: aload_0
    //   114: getfield 20	com/tencent/smtt/sdk/o:c	Ljava/util/Map;
    //   117: ldc 138
    //   119: new 82	java/lang/StringBuilder
    //   122: dup
    //   123: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   126: ldc 78
    //   128: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: getstatic 136	com/tencent/smtt/sdk/QbSdk:n	Ljava/util/Map;
    //   134: ldc 138
    //   136: invokeinterface 146 2 0
    //   141: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   144: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: invokeinterface 104 3 0
    //   152: pop
    //   153: aload 4
    //   155: invokevirtual 152	com/tencent/smtt/sdk/x:c	()Lcom/tencent/smtt/sdk/y;
    //   158: invokevirtual 157	com/tencent/smtt/sdk/y:b	()Lcom/tencent/smtt/export/external/DexLoader;
    //   161: astore_2
    //   162: getstatic 161	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   165: astore 4
    //   167: aload_0
    //   168: getfield 20	com/tencent/smtt/sdk/o:c	Ljava/util/Map;
    //   171: astore 5
    //   173: aload_2
    //   174: ldc 163
    //   176: ldc 165
    //   178: iconst_2
    //   179: anewarray 167	java/lang/Class
    //   182: dup
    //   183: iconst_0
    //   184: aload 4
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: ldc 32
    //   191: aastore
    //   192: iconst_2
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: iload_1
    //   199: invokestatic 170	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   202: aastore
    //   203: dup
    //   204: iconst_1
    //   205: aload 5
    //   207: aastore
    //   208: invokevirtual 176	com/tencent/smtt/export/external/DexLoader:invokeStaticMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;[Ljava/lang/Object;)Ljava/lang/Object;
    //   211: pop
    //   212: aload_0
    //   213: monitorexit
    //   214: iload_3
    //   215: ireturn
    //   216: iconst_0
    //   217: istore_3
    //   218: goto -6 -> 212
    //   221: astore_2
    //   222: aload_0
    //   223: monitorexit
    //   224: aload_2
    //   225: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	o
    //   0	226	1	paramInt	int
    //   0	226	2	paramString	String
    //   1	217	3	bool	boolean
    //   7	178	4	localObject	Object
    //   171	35	5	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   4	153	221	finally
    //   153	212	221	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.smtt.sdk.o
 * JD-Core Version:    0.7.0.1
 */