package com.tencent.util;

import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class GLMemoryManager
{
  private static boolean LOG_ENABLE = false;
  private static boolean TEXTURE_CACHE_ENABLE = false;
  private static boolean TEXTURE_REF_COUNT_PRINT_ENABLE = false;
  private static GLMemoryManager mGLMemoryManager;
  private final String TAG = GLMemoryManager.class.getSimpleName();
  private Map<Long, Set<Integer>> mTextureAllocMap = new HashMap();
  private Map<Long, Map<Integer, Size>> mTextureIdSizeMap = new HashMap();
  private int mTextureRefCount = 0;
  private Map<Long, Map<Size, Queue<Integer>>> mTexturesCache = new HashMap();
  
  private String getCallFrom()
  {
    if (LOG_ENABLE)
    {
      Object localObject = Thread.currentThread().getStackTrace();
      if ((localObject == null) || (localObject.length == 0)) {
        return "unknown";
      }
      int i = 0;
      int j;
      for (;;)
      {
        j = i;
        if (i >= localObject.length) {
          break;
        }
        if (localObject[i].getMethodName().equals("getCallFrom")) {
          for (;;)
          {
            j = i;
            if (i >= localObject.length) {
              break;
            }
            j = i;
            if (!localObject[i].getClassName().contains("GLMemoryManager")) {
              break;
            }
            i += 1;
          }
        }
        i += 1;
      }
      if (j < localObject.length)
      {
        localObject = localObject[j];
        return ((StackTraceElement)localObject).getClassName() + " - " + ((StackTraceElement)localObject).getMethodName() + "()";
      }
    }
    return "unknown";
  }
  
  public static GLMemoryManager getInstance()
  {
    if (mGLMemoryManager == null) {}
    try
    {
      if (mGLMemoryManager == null) {
        mGLMemoryManager = new GLMemoryManager();
      }
      return mGLMemoryManager;
    }
    finally {}
  }
  
  /* Error */
  private Size getTextureSize(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 28	com/tencent/util/GLMemoryManager:TEXTURE_CACHE_ENABLE	Z
    //   5: ifeq +54 -> 59
    //   8: invokestatic 62	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11: invokevirtual 114	java/lang/Thread:getId	()J
    //   14: lstore_2
    //   15: aload_0
    //   16: getfield 53	com/tencent/util/GLMemoryManager:mTextureIdSizeMap	Ljava/util/Map;
    //   19: lload_2
    //   20: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   23: invokeinterface 126 2 0
    //   28: checkcast 122	java/util/Map
    //   31: astore 4
    //   33: aload 4
    //   35: ifnull +24 -> 59
    //   38: aload 4
    //   40: iload_1
    //   41: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   44: invokeinterface 126 2 0
    //   49: checkcast 6	com/tencent/util/GLMemoryManager$Size
    //   52: astore 4
    //   54: aload_0
    //   55: monitorexit
    //   56: aload 4
    //   58: areturn
    //   59: aconst_null
    //   60: astore 4
    //   62: goto -8 -> 54
    //   65: astore 4
    //   67: aload_0
    //   68: monitorexit
    //   69: aload 4
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	GLMemoryManager
    //   0	72	1	paramInt	int
    //   14	6	2	l	long
    //   31	30	4	localObject1	Object
    //   65	5	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	33	65	finally
    //   38	54	65	finally
  }
  
  private void logd(String paramString1, String paramString2)
  {
    if (LOG_ENABLE) {
      Log.d(paramString1, paramString2);
    }
  }
  
  private void loge(String paramString1, String paramString2)
  {
    if (LOG_ENABLE) {
      Log.e(paramString1, paramString2);
    }
  }
  
  private void printTextureRefCount()
  {
    if (TEXTURE_REF_COUNT_PRINT_ENABLE) {
      Log.e(this.TAG, String.format("texture reference count = %d", new Object[] { Integer.valueOf(this.mTextureRefCount) }));
    }
  }
  
  public static void setLogEnable(boolean paramBoolean)
  {
    LOG_ENABLE = paramBoolean;
  }
  
  public static void setPrintTextureRefCountEnable(boolean paramBoolean)
  {
    TEXTURE_REF_COUNT_PRINT_ENABLE = paramBoolean;
  }
  
  public static void setTextureCacheEnable(boolean paramBoolean)
  {
    TEXTURE_CACHE_ENABLE = paramBoolean;
  }
  
  public void clearThisGLThread()
  {
    clearThisGLThread(true);
  }
  
  public void clearThisGLThread(boolean paramBoolean)
  {
    long l = Thread.currentThread().getId();
    logd(this.TAG, String.format("clearThisGLThread(), GLThread id = %d, requestDelete = " + paramBoolean + ", called from: %s", new Object[] { Long.valueOf(l), getCallFrom() }));
    if (TEXTURE_CACHE_ENABLE)
    {
      Object localObject1 = (Map)this.mTexturesCache.get(Long.valueOf(l));
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Queue)((Map.Entry)((Iterator)localObject1).next()).getValue();
          if (localObject2 != null) {
            while (!((Queue)localObject2).isEmpty())
            {
              int i = ((Integer)((Queue)localObject2).poll()).intValue();
              if (paramBoolean) {
                deleteTexture(i, true);
              } else {
                this.mTextureRefCount -= 1;
              }
            }
          }
        }
      }
      localObject1 = (Set)this.mTextureAllocMap.get(Long.valueOf(l));
      if (localObject1 != null)
      {
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Integer)((Iterator)localObject1).next();
          if (paramBoolean) {
            deleteTexture(((Integer)localObject2).intValue(), true);
          } else {
            this.mTextureRefCount -= 1;
          }
        }
      }
      this.mTexturesCache.remove(Long.valueOf(l));
      this.mTextureIdSizeMap.remove(Long.valueOf(l));
      this.mTextureAllocMap.remove(Long.valueOf(l));
    }
    printTextureRefCount();
  }
  
  public void deleteTexture(int paramInt)
  {
    try
    {
      deleteTexture(paramInt, false);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public void deleteTexture(int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 62	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5: invokevirtual 114	java/lang/Thread:getId	()J
    //   8: lstore_3
    //   9: aload_0
    //   10: aload_0
    //   11: getfield 44	com/tencent/util/GLMemoryManager:TAG	Ljava/lang/String;
    //   14: new 91	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   21: ldc 217
    //   23: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: iload_2
    //   27: invokevirtual 162	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   30: ldc 164
    //   32: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: iconst_3
    //   39: anewarray 4	java/lang/Object
    //   42: dup
    //   43: iconst_0
    //   44: lload_3
    //   45: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   48: aastore
    //   49: dup
    //   50: iconst_1
    //   51: iload_1
    //   52: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: dup
    //   57: iconst_2
    //   58: aload_0
    //   59: invokespecial 166	com/tencent/util/GLMemoryManager:getCallFrom	()Ljava/lang/String;
    //   62: aastore
    //   63: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   66: invokespecial 168	com/tencent/util/GLMemoryManager:logd	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: iload_1
    //   70: ifne +30 -> 100
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 44	com/tencent/util/GLMemoryManager:TAG	Ljava/lang/String;
    //   78: ldc 219
    //   80: iconst_1
    //   81: anewarray 4	java/lang/Object
    //   84: dup
    //   85: iconst_0
    //   86: lload_3
    //   87: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   90: aastore
    //   91: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   94: invokespecial 168	com/tencent/util/GLMemoryManager:logd	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload_0
    //   98: monitorexit
    //   99: return
    //   100: iload_2
    //   101: ifne +210 -> 311
    //   104: getstatic 28	com/tencent/util/GLMemoryManager:TEXTURE_CACHE_ENABLE	Z
    //   107: ifeq +204 -> 311
    //   110: aload_0
    //   111: getfield 51	com/tencent/util/GLMemoryManager:mTexturesCache	Ljava/util/Map;
    //   114: lload_3
    //   115: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   118: invokeinterface 222 2 0
    //   123: ifne +24 -> 147
    //   126: aload_0
    //   127: getfield 51	com/tencent/util/GLMemoryManager:mTexturesCache	Ljava/util/Map;
    //   130: lload_3
    //   131: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   134: new 48	java/util/HashMap
    //   137: dup
    //   138: invokespecial 49	java/util/HashMap:<init>	()V
    //   141: invokeinterface 226 3 0
    //   146: pop
    //   147: aload_0
    //   148: getfield 51	com/tencent/util/GLMemoryManager:mTexturesCache	Ljava/util/Map;
    //   151: lload_3
    //   152: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   155: invokeinterface 126 2 0
    //   160: checkcast 122	java/util/Map
    //   163: astore 7
    //   165: aload_0
    //   166: iload_1
    //   167: invokespecial 228	com/tencent/util/GLMemoryManager:getTextureSize	(I)Lcom/tencent/util/GLMemoryManager$Size;
    //   170: astore 6
    //   172: aload 6
    //   174: astore 5
    //   176: aload 6
    //   178: ifnonnull +15 -> 193
    //   181: new 6	com/tencent/util/GLMemoryManager$Size
    //   184: dup
    //   185: aload_0
    //   186: iconst_m1
    //   187: iconst_m1
    //   188: invokespecial 231	com/tencent/util/GLMemoryManager$Size:<init>	(Lcom/tencent/util/GLMemoryManager;II)V
    //   191: astore 5
    //   193: aload 7
    //   195: aload 5
    //   197: invokeinterface 222 2 0
    //   202: ifne +20 -> 222
    //   205: aload 7
    //   207: aload 5
    //   209: new 233	java/util/LinkedList
    //   212: dup
    //   213: invokespecial 234	java/util/LinkedList:<init>	()V
    //   216: invokeinterface 226 3 0
    //   221: pop
    //   222: aload 7
    //   224: aload 5
    //   226: invokeinterface 126 2 0
    //   231: checkcast 195	java/util/Queue
    //   234: iload_1
    //   235: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   238: invokeinterface 237 2 0
    //   243: pop
    //   244: aload_0
    //   245: aload_0
    //   246: getfield 44	com/tencent/util/GLMemoryManager:TAG	Ljava/lang/String;
    //   249: ldc 239
    //   251: iconst_4
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: lload_3
    //   258: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   261: aastore
    //   262: dup
    //   263: iconst_1
    //   264: aload 5
    //   266: getfield 242	com/tencent/util/GLMemoryManager$Size:width	I
    //   269: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: aastore
    //   273: dup
    //   274: iconst_2
    //   275: aload 5
    //   277: getfield 245	com/tencent/util/GLMemoryManager$Size:height	I
    //   280: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   283: aastore
    //   284: dup
    //   285: iconst_3
    //   286: aload_0
    //   287: invokespecial 166	com/tencent/util/GLMemoryManager:getCallFrom	()Ljava/lang/String;
    //   290: aastore
    //   291: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   294: invokespecial 168	com/tencent/util/GLMemoryManager:logd	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload_0
    //   298: invokespecial 214	com/tencent/util/GLMemoryManager:printTextureRefCount	()V
    //   301: goto -204 -> 97
    //   304: astore 5
    //   306: aload_0
    //   307: monitorexit
    //   308: aload 5
    //   310: athrow
    //   311: aload_0
    //   312: aload_0
    //   313: getfield 44	com/tencent/util/GLMemoryManager:TAG	Ljava/lang/String;
    //   316: ldc 247
    //   318: iconst_3
    //   319: anewarray 4	java/lang/Object
    //   322: dup
    //   323: iconst_0
    //   324: lload_3
    //   325: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   328: aastore
    //   329: dup
    //   330: iconst_1
    //   331: iload_1
    //   332: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   335: aastore
    //   336: dup
    //   337: iconst_2
    //   338: aload_0
    //   339: invokespecial 166	com/tencent/util/GLMemoryManager:getCallFrom	()Ljava/lang/String;
    //   342: aastore
    //   343: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   346: invokespecial 168	com/tencent/util/GLMemoryManager:logd	(Ljava/lang/String;Ljava/lang/String;)V
    //   349: iconst_1
    //   350: iconst_1
    //   351: newarray int
    //   353: dup
    //   354: iconst_0
    //   355: iload_1
    //   356: iastore
    //   357: iconst_0
    //   358: invokestatic 253	android/opengl/GLES20:glDeleteTextures	(I[II)V
    //   361: aload_0
    //   362: getfield 55	com/tencent/util/GLMemoryManager:mTextureAllocMap	Ljava/util/Map;
    //   365: lload_3
    //   366: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   369: invokeinterface 126 2 0
    //   374: checkcast 174	java/util/Set
    //   377: astore 5
    //   379: aload 5
    //   381: ifnull +15 -> 396
    //   384: aload 5
    //   386: iload_1
    //   387: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   390: invokeinterface 255 2 0
    //   395: pop
    //   396: aload_0
    //   397: aload_0
    //   398: getfield 46	com/tencent/util/GLMemoryManager:mTextureRefCount	I
    //   401: iconst_1
    //   402: isub
    //   403: putfield 46	com/tencent/util/GLMemoryManager:mTextureRefCount	I
    //   406: getstatic 28	com/tencent/util/GLMemoryManager:TEXTURE_CACHE_ENABLE	Z
    //   409: ifeq -112 -> 297
    //   412: aload_0
    //   413: getfield 53	com/tencent/util/GLMemoryManager:mTextureIdSizeMap	Ljava/util/Map;
    //   416: lload_3
    //   417: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   420: invokeinterface 126 2 0
    //   425: checkcast 122	java/util/Map
    //   428: astore 5
    //   430: aload 5
    //   432: ifnull -135 -> 297
    //   435: aload 5
    //   437: iload_1
    //   438: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   441: invokeinterface 212 2 0
    //   446: pop
    //   447: goto -150 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	GLMemoryManager
    //   0	450	1	paramInt	int
    //   0	450	2	paramBoolean	boolean
    //   8	409	3	l	long
    //   174	102	5	localSize1	Size
    //   304	5	5	localObject1	Object
    //   377	59	5	localObject2	Object
    //   170	7	6	localSize2	Size
    //   163	60	7	localMap	Map
    // Exception table:
    //   from	to	target	type
    //   2	69	304	finally
    //   73	97	304	finally
    //   104	147	304	finally
    //   147	172	304	finally
    //   181	193	304	finally
    //   193	222	304	finally
    //   222	297	304	finally
    //   297	301	304	finally
    //   311	379	304	finally
    //   384	396	304	finally
    //   396	430	304	finally
    //   435	447	304	finally
  }
  
  public void deleteTexture(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    try
    {
      deleteTexture(paramInt1, paramArrayOfInt, paramInt2, false);
      return;
    }
    finally
    {
      paramArrayOfInt = finally;
      throw paramArrayOfInt;
    }
  }
  
  /* Error */
  public void deleteTexture(int paramInt1, int[] paramArrayOfInt, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: iload_3
    //   10: istore 5
    //   12: iload 5
    //   14: aload_2
    //   15: arraylength
    //   16: if_icmpge -10 -> 6
    //   19: iload 5
    //   21: iload_3
    //   22: isub
    //   23: iload_1
    //   24: if_icmpge -18 -> 6
    //   27: aload_0
    //   28: aload_2
    //   29: iload 5
    //   31: iaload
    //   32: iload 4
    //   34: invokevirtual 209	com/tencent/util/GLMemoryManager:deleteTexture	(IZ)V
    //   37: iload 5
    //   39: iconst_1
    //   40: iadd
    //   41: istore 5
    //   43: goto -31 -> 12
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	GLMemoryManager
    //   0	51	1	paramInt1	int
    //   0	51	2	paramArrayOfInt	int[]
    //   0	51	3	paramInt2	int
    //   0	51	4	paramBoolean	boolean
    //   10	32	5	i	int
    // Exception table:
    //   from	to	target	type
    //   12	19	46	finally
    //   27	37	46	finally
  }
  
  public int genTexture()
  {
    try
    {
      int i = genTexture(-1, -1);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int genTexture(int paramInt1, int paramInt2)
  {
    try
    {
      paramInt1 = genTexture(paramInt1, paramInt2, false);
      return paramInt1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public int genTexture(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 62	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   5: invokevirtual 114	java/lang/Thread:getId	()J
    //   8: lstore 4
    //   10: aload_0
    //   11: aload_0
    //   12: getfield 44	com/tencent/util/GLMemoryManager:TAG	Ljava/lang/String;
    //   15: new 91	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   22: ldc_w 267
    //   25: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_3
    //   29: invokevirtual 162	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   32: ldc_w 269
    //   35: invokevirtual 96	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: iconst_4
    //   42: anewarray 4	java/lang/Object
    //   45: dup
    //   46: iconst_0
    //   47: lload 4
    //   49: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   52: aastore
    //   53: dup
    //   54: iconst_1
    //   55: iload_1
    //   56: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   59: aastore
    //   60: dup
    //   61: iconst_2
    //   62: iload_2
    //   63: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   66: aastore
    //   67: dup
    //   68: iconst_3
    //   69: aload_0
    //   70: invokespecial 166	com/tencent/util/GLMemoryManager:getCallFrom	()Ljava/lang/String;
    //   73: aastore
    //   74: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   77: invokespecial 168	com/tencent/util/GLMemoryManager:logd	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: getstatic 28	com/tencent/util/GLMemoryManager:TEXTURE_CACHE_ENABLE	Z
    //   83: ifeq +255 -> 338
    //   86: iload_3
    //   87: ifne +251 -> 338
    //   90: aload_0
    //   91: getfield 51	com/tencent/util/GLMemoryManager:mTexturesCache	Ljava/util/Map;
    //   94: lload 4
    //   96: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   99: invokeinterface 126 2 0
    //   104: checkcast 122	java/util/Map
    //   107: astore 6
    //   109: aload 6
    //   111: ifnull +227 -> 338
    //   114: aload 6
    //   116: invokeinterface 270 1 0
    //   121: ifne +217 -> 338
    //   124: aload 6
    //   126: new 6	com/tencent/util/GLMemoryManager$Size
    //   129: dup
    //   130: aload_0
    //   131: iload_1
    //   132: iload_2
    //   133: invokespecial 231	com/tencent/util/GLMemoryManager$Size:<init>	(Lcom/tencent/util/GLMemoryManager;II)V
    //   136: invokeinterface 126 2 0
    //   141: checkcast 195	java/util/Queue
    //   144: astore 7
    //   146: aload 7
    //   148: ifnull +75 -> 223
    //   151: aload 7
    //   153: invokeinterface 198 1 0
    //   158: ifne +65 -> 223
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 44	com/tencent/util/GLMemoryManager:TAG	Ljava/lang/String;
    //   166: ldc_w 272
    //   169: iconst_3
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: lload 4
    //   177: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   180: aastore
    //   181: dup
    //   182: iconst_1
    //   183: iload_1
    //   184: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   187: aastore
    //   188: dup
    //   189: iconst_2
    //   190: iload_2
    //   191: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   198: invokespecial 168	com/tencent/util/GLMemoryManager:logd	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_0
    //   202: invokespecial 214	com/tencent/util/GLMemoryManager:printTextureRefCount	()V
    //   205: aload 7
    //   207: invokeinterface 201 1 0
    //   212: checkcast 128	java/lang/Integer
    //   215: invokevirtual 205	java/lang/Integer:intValue	()I
    //   218: istore_1
    //   219: aload_0
    //   220: monitorexit
    //   221: iload_1
    //   222: ireturn
    //   223: aload 6
    //   225: invokeinterface 172 1 0
    //   230: invokeinterface 178 1 0
    //   235: astore 6
    //   237: aload 6
    //   239: invokeinterface 184 1 0
    //   244: ifeq +94 -> 338
    //   247: aload 6
    //   249: invokeinterface 188 1 0
    //   254: checkcast 190	java/util/Map$Entry
    //   257: invokeinterface 193 1 0
    //   262: checkcast 195	java/util/Queue
    //   265: astore 7
    //   267: aload 7
    //   269: invokeinterface 198 1 0
    //   274: ifne -37 -> 237
    //   277: aload_0
    //   278: aload_0
    //   279: getfield 44	com/tencent/util/GLMemoryManager:TAG	Ljava/lang/String;
    //   282: ldc_w 274
    //   285: iconst_3
    //   286: anewarray 4	java/lang/Object
    //   289: dup
    //   290: iconst_0
    //   291: lload 4
    //   293: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   296: aastore
    //   297: dup
    //   298: iconst_1
    //   299: iload_1
    //   300: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: aastore
    //   304: dup
    //   305: iconst_2
    //   306: iload_2
    //   307: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   310: aastore
    //   311: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   314: invokespecial 168	com/tencent/util/GLMemoryManager:logd	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aload_0
    //   318: invokespecial 214	com/tencent/util/GLMemoryManager:printTextureRefCount	()V
    //   321: aload 7
    //   323: invokeinterface 201 1 0
    //   328: checkcast 128	java/lang/Integer
    //   331: invokevirtual 205	java/lang/Integer:intValue	()I
    //   334: istore_1
    //   335: goto -116 -> 219
    //   338: aload_0
    //   339: aload_0
    //   340: getfield 44	com/tencent/util/GLMemoryManager:TAG	Ljava/lang/String;
    //   343: ldc_w 276
    //   346: iconst_3
    //   347: anewarray 4	java/lang/Object
    //   350: dup
    //   351: iconst_0
    //   352: lload 4
    //   354: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   357: aastore
    //   358: dup
    //   359: iconst_1
    //   360: iload_1
    //   361: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   364: aastore
    //   365: dup
    //   366: iconst_2
    //   367: iload_2
    //   368: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   371: aastore
    //   372: invokestatic 150	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   375: invokespecial 168	com/tencent/util/GLMemoryManager:logd	(Ljava/lang/String;Ljava/lang/String;)V
    //   378: iconst_1
    //   379: newarray int
    //   381: astore 6
    //   383: iconst_1
    //   384: aload 6
    //   386: iconst_0
    //   387: invokestatic 279	android/opengl/GLES20:glGenTextures	(I[II)V
    //   390: aload_0
    //   391: getfield 55	com/tencent/util/GLMemoryManager:mTextureAllocMap	Ljava/util/Map;
    //   394: lload 4
    //   396: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   399: invokeinterface 222 2 0
    //   404: ifne +25 -> 429
    //   407: aload_0
    //   408: getfield 55	com/tencent/util/GLMemoryManager:mTextureAllocMap	Ljava/util/Map;
    //   411: lload 4
    //   413: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   416: new 281	java/util/HashSet
    //   419: dup
    //   420: invokespecial 282	java/util/HashSet:<init>	()V
    //   423: invokeinterface 226 3 0
    //   428: pop
    //   429: aload_0
    //   430: getfield 55	com/tencent/util/GLMemoryManager:mTextureAllocMap	Ljava/util/Map;
    //   433: lload 4
    //   435: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   438: invokeinterface 126 2 0
    //   443: checkcast 174	java/util/Set
    //   446: aload 6
    //   448: iconst_0
    //   449: iaload
    //   450: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   453: invokeinterface 285 2 0
    //   458: pop
    //   459: aload_0
    //   460: aload_0
    //   461: getfield 46	com/tencent/util/GLMemoryManager:mTextureRefCount	I
    //   464: iconst_1
    //   465: iadd
    //   466: putfield 46	com/tencent/util/GLMemoryManager:mTextureRefCount	I
    //   469: aload_0
    //   470: invokespecial 214	com/tencent/util/GLMemoryManager:printTextureRefCount	()V
    //   473: aload 6
    //   475: iconst_0
    //   476: iaload
    //   477: istore_1
    //   478: goto -259 -> 219
    //   481: astore 6
    //   483: aload_0
    //   484: monitorexit
    //   485: aload 6
    //   487: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	488	0	this	GLMemoryManager
    //   0	488	1	paramInt1	int
    //   0	488	2	paramInt2	int
    //   0	488	3	paramBoolean	boolean
    //   8	426	4	l	long
    //   107	367	6	localObject1	Object
    //   481	5	6	localObject2	Object
    //   144	178	7	localQueue	Queue
    // Exception table:
    //   from	to	target	type
    //   2	86	481	finally
    //   90	109	481	finally
    //   114	146	481	finally
    //   151	219	481	finally
    //   223	237	481	finally
    //   237	335	481	finally
    //   338	429	481	finally
    //   429	473	481	finally
  }
  
  public int genTexture(boolean paramBoolean)
  {
    try
    {
      int i = genTexture(-1, -1, paramBoolean);
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void genTexture(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    try
    {
      genTexture(paramInt1, paramArrayOfInt, paramInt2, false);
      return;
    }
    finally
    {
      paramArrayOfInt = finally;
      throw paramArrayOfInt;
    }
  }
  
  /* Error */
  public void genTexture(int paramInt1, int[] paramArrayOfInt, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: iload_3
    //   10: istore 5
    //   12: iload 5
    //   14: aload_2
    //   15: arraylength
    //   16: if_icmpge -10 -> 6
    //   19: iload 5
    //   21: iload_3
    //   22: isub
    //   23: iload_1
    //   24: if_icmpge -18 -> 6
    //   27: aload_2
    //   28: iload 5
    //   30: aload_0
    //   31: iload 4
    //   33: invokevirtual 290	com/tencent/util/GLMemoryManager:genTexture	(Z)I
    //   36: iastore
    //   37: iload 5
    //   39: iconst_1
    //   40: iadd
    //   41: istore 5
    //   43: goto -31 -> 12
    //   46: astore_2
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_2
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	GLMemoryManager
    //   0	51	1	paramInt1	int
    //   0	51	2	paramArrayOfInt	int[]
    //   0	51	3	paramInt2	int
    //   0	51	4	paramBoolean	boolean
    //   10	32	5	i	int
    // Exception table:
    //   from	to	target	type
    //   12	19	46	finally
    //   27	37	46	finally
  }
  
  /* Error */
  public boolean isTextureSizeMatched(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 28	com/tencent/util/GLMemoryManager:TEXTURE_CACHE_ENABLE	Z
    //   5: ifeq +98 -> 103
    //   8: invokestatic 62	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   11: invokevirtual 114	java/lang/Thread:getId	()J
    //   14: lstore 4
    //   16: aload_0
    //   17: getfield 53	com/tencent/util/GLMemoryManager:mTextureIdSizeMap	Ljava/util/Map;
    //   20: lload 4
    //   22: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   25: invokeinterface 222 2 0
    //   30: ifeq +73 -> 103
    //   33: aload_0
    //   34: getfield 53	com/tencent/util/GLMemoryManager:mTextureIdSizeMap	Ljava/util/Map;
    //   37: lload 4
    //   39: invokestatic 120	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   42: invokeinterface 126 2 0
    //   47: checkcast 122	java/util/Map
    //   50: iload_1
    //   51: invokestatic 131	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   54: invokeinterface 126 2 0
    //   59: checkcast 6	com/tencent/util/GLMemoryManager$Size
    //   62: astore 7
    //   64: aload 7
    //   66: ifnull +31 -> 97
    //   69: aload 7
    //   71: getfield 242	com/tencent/util/GLMemoryManager$Size:width	I
    //   74: iload_2
    //   75: if_icmpne +22 -> 97
    //   78: aload 7
    //   80: getfield 245	com/tencent/util/GLMemoryManager$Size:height	I
    //   83: istore_1
    //   84: iload_1
    //   85: iload_3
    //   86: if_icmpne +11 -> 97
    //   89: iconst_1
    //   90: istore 6
    //   92: aload_0
    //   93: monitorexit
    //   94: iload 6
    //   96: ireturn
    //   97: iconst_0
    //   98: istore 6
    //   100: goto -8 -> 92
    //   103: iconst_0
    //   104: istore 6
    //   106: goto -14 -> 92
    //   109: astore 7
    //   111: aload_0
    //   112: monitorexit
    //   113: aload 7
    //   115: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	this	GLMemoryManager
    //   0	116	1	paramInt1	int
    //   0	116	2	paramInt2	int
    //   0	116	3	paramInt3	int
    //   14	24	4	l	long
    //   90	15	6	bool	boolean
    //   62	17	7	localSize	Size
    //   109	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	64	109	finally
    //   69	84	109	finally
  }
  
  public void updateTextureSize(int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      if (TEXTURE_CACHE_ENABLE)
      {
        long l = Thread.currentThread().getId();
        logd(this.TAG, String.format("updateTextureSize(), GLThread id = %d, textureId = %d, width = %d, height = %d, called from: %s", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), getCallFrom() }));
        if (!this.mTextureIdSizeMap.containsKey(Long.valueOf(l))) {
          this.mTextureIdSizeMap.put(Long.valueOf(l), new HashMap());
        }
        ((Map)this.mTextureIdSizeMap.get(Long.valueOf(l))).put(Integer.valueOf(paramInt1), new Size(paramInt2, paramInt3));
      }
      return;
    }
    finally {}
  }
  
  public class Size
  {
    public int height;
    public int width;
    
    Size(int paramInt1, int paramInt2)
    {
      this.width = paramInt1;
      this.height = paramInt2;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (Size)paramObject;
        if (this.width != paramObject.width) {
          return false;
        }
      } while (this.height == paramObject.height);
      return false;
    }
    
    public int hashCode()
    {
      return this.width * 31 + this.height;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.util.GLMemoryManager
 * JD-Core Version:    0.7.0.1
 */