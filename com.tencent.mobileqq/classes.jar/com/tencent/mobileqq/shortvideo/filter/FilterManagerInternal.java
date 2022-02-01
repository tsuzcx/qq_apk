package com.tencent.mobileqq.shortvideo.filter;

import android.annotation.TargetApi;
import android.opengl.EGL14;
import android.opengl.GLES20;
import com.tencent.aekit.openrender.internal.FrameBufferCache;
import com.tencent.sveffects.SLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

final class FilterManagerInternal
{
  public static final String TAG = "FilterManagerInternal";
  private volatile boolean isCaptureMode = false;
  private final FilterCacheQueue mCacheQueue = new FilterCacheQueue();
  private Stack<FilterManagerInternal.FilterChain> mChains = new Stack();
  private QQFilterRenderManager mCommonParam;
  private QQFaceDetectBase mFaceDetect;
  private volatile boolean mReleased = false;
  private boolean needFaceDetect = false;
  
  private void checkStackIsLeakage()
  {
    try
    {
      if (this.mChains.size() >= 10)
      {
        Object localObject1 = new HashMap();
        Object localObject3 = this.mChains.iterator();
        Object localObject4;
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FilterManagerInternal.FilterChain)((Iterator)localObject3).next();
          if (((HashMap)localObject1).containsKey(((FilterManagerInternal.FilterChain)localObject4).getId()))
          {
            i = ((Integer)((HashMap)localObject1).get(((FilterManagerInternal.FilterChain)localObject4).getId())).intValue();
            ((HashMap)localObject1).put(((FilterManagerInternal.FilterChain)localObject4).getId(), Integer.valueOf(i + 1));
          }
          else
          {
            ((HashMap)localObject1).put(((FilterManagerInternal.FilterChain)localObject4).getId(), Integer.valueOf(1));
          }
        }
        int i = 0;
        localObject3 = ((HashMap)localObject1).keySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (String)((Iterator)localObject3).next();
          int j = ((Integer)((HashMap)localObject1).get(localObject4)).intValue();
          if (j >= 2)
          {
            i += 1;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(" key=");
            localStringBuilder.append((String)localObject4);
            localStringBuilder.append(" value=");
            localStringBuilder.append(j);
            printLog("checkStackIsLeakage", localStringBuilder.toString(), null);
          }
        }
        localObject1 = generateStackTrace();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(" count=");
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append(" traceInfo=");
        ((StringBuilder)localObject3).append((String)localObject1);
        printLog("checkStackIsLeakage", ((StringBuilder)localObject3).toString(), null);
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void checkThreadSecurity(String paramString)
  {
    if (isExeInGlThread()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("在非渲染线程执行: [");
    localStringBuilder.append(paramString);
    localStringBuilder.append("] threadName=");
    localStringBuilder.append(Thread.currentThread().getName());
    throw new RuntimeException(localStringBuilder.toString());
  }
  
  private void decQuote(FilterManagerInternal.FilterChain paramFilterChain)
  {
    if (paramFilterChain.mFilters != null)
    {
      Iterator localIterator = paramFilterChain.mHighCache.iterator();
      while (localIterator.hasNext()) {
        ((QQBaseFilter)localIterator.next()).mQuoteCount.decrementAndGet();
      }
    }
    paramFilterChain.mHighCache.clear();
  }
  
  private void initHighCache(FilterManagerInternal.FilterChain paramFilterChain)
  {
    if (paramFilterChain.mFilters != null)
    {
      int i = 0;
      while (i < paramFilterChain.mFilters.length)
      {
        int j = paramFilterChain.mFilters[i];
        QQBaseFilter localQQBaseFilter = this.mCacheQueue.getFilterByType(j);
        paramFilterChain.mHighCache.add(localQQBaseFilter);
        i += 1;
      }
    }
  }
  
  private void insertFollowSerial(int paramInt, Object paramObject, ArrayList<Integer> paramArrayList, ArrayList<Object> paramArrayList1)
  {
    int m = paramArrayList.size();
    int k = 0;
    int j = 0;
    int i = 0;
    while ((j < m) && (paramInt >= ((Integer)paramArrayList.get(j)).intValue()))
    {
      i = j + 1;
      j = i;
    }
    paramArrayList.add(i, Integer.valueOf(paramInt));
    if (i > paramArrayList1.size())
    {
      j = paramArrayList1.size();
      paramInt = k;
      while (paramInt < i - j)
      {
        paramArrayList1.add(null);
        paramInt += 1;
      }
    }
    paramArrayList1.add(i, paramObject);
  }
  
  @TargetApi(17)
  private boolean isExeInGlThread()
  {
    return EGL14.eglGetCurrentContext() != EGL14.EGL_NO_CONTEXT;
  }
  
  private boolean isOldChainFollowSerial(ArrayList<Integer> paramArrayList)
  {
    int j = ((Integer)paramArrayList.get(0)).intValue();
    int i = 1;
    while (i < paramArrayList.size())
    {
      int k = ((Integer)paramArrayList.get(i)).intValue();
      if (j > k) {
        return false;
      }
      i += 1;
      j = k;
    }
    return true;
  }
  
  private void newAddQuote(FilterManagerInternal.FilterChain paramFilterChain)
  {
    if (paramFilterChain.mFilters != null)
    {
      int i = 0;
      while (i < paramFilterChain.mFilters.length)
      {
        int j = paramFilterChain.mFilters[i];
        QQBaseFilter localQQBaseFilter = this.mCacheQueue.getFilterByTypeWithCreate(j, this.mCommonParam);
        localQQBaseFilter.mQuoteCount.getAndIncrement();
        localQQBaseFilter.setSpecificParam(paramFilterChain.getParam(i));
        i += 1;
      }
    }
  }
  
  /* Error */
  private void popAndReleaseInternal(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: ldc 236
    //   5: invokespecial 238	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:checkThreadSecurity	(Ljava/lang/String;)V
    //   8: aload_0
    //   9: getfield 39	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:mChains	Ljava/util/Stack;
    //   12: invokevirtual 241	java/util/Stack:peek	()Ljava/lang/Object;
    //   15: checkcast 66	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain
    //   18: astore_3
    //   19: aload_3
    //   20: ifnonnull +22 -> 42
    //   23: aload_0
    //   24: getfield 39	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:mChains	Ljava/util/Stack;
    //   27: invokevirtual 244	java/util/Stack:pop	()Ljava/lang/Object;
    //   30: pop
    //   31: ldc 236
    //   33: ldc 246
    //   35: aconst_null
    //   36: invokestatic 122	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:printLog	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_1
    //   43: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   46: ifne +172 -> 218
    //   49: aload_3
    //   50: getfield 255	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain:mId	Ljava/lang/String;
    //   53: aload_1
    //   54: invokevirtual 259	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   57: ifeq +104 -> 161
    //   60: aload_0
    //   61: getfield 39	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:mChains	Ljava/util/Stack;
    //   64: invokevirtual 244	java/util/Stack:pop	()Ljava/lang/Object;
    //   67: pop
    //   68: new 102	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   75: astore_1
    //   76: aload_1
    //   77: ldc_w 261
    //   80: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_1
    //   85: aload_3
    //   86: getfield 264	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain:info	Ljava/lang/String;
    //   89: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc 236
    //   95: aload_1
    //   96: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: aconst_null
    //   100: invokestatic 122	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:printLog	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_0
    //   104: aload_3
    //   105: invokespecial 267	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:runChainPauseInternal	(Lcom/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain;)V
    //   108: aload_0
    //   109: aload_3
    //   110: invokespecial 269	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:decQuote	(Lcom/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain;)V
    //   113: aload_0
    //   114: invokespecial 272	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:recoveryTopChainParams	()V
    //   117: new 102	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   124: astore_1
    //   125: aload_1
    //   126: ldc_w 274
    //   129: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_1
    //   134: iload_2
    //   135: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: ldc 236
    //   141: aload_1
    //   142: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: aconst_null
    //   146: invokestatic 122	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:printLog	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   149: iload_2
    //   150: ifeq +8 -> 158
    //   153: aload_0
    //   154: aload_3
    //   155: invokespecial 280	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:releaseChainResource	(Lcom/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain;)V
    //   158: aload_0
    //   159: monitorexit
    //   160: return
    //   161: new 102	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   168: astore 4
    //   170: aload 4
    //   172: ldc_w 282
    //   175: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 4
    //   181: aload_1
    //   182: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 4
    //   188: ldc_w 284
    //   191: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 4
    //   197: aload_3
    //   198: getfield 255	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain:mId	Ljava/lang/String;
    //   201: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: new 149	java/lang/RuntimeException
    //   208: dup
    //   209: aload 4
    //   211: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokespecial 151	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   217: athrow
    //   218: new 102	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   225: astore 4
    //   227: aload 4
    //   229: ldc_w 282
    //   232: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 4
    //   238: aload_1
    //   239: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 4
    //   245: ldc_w 286
    //   248: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 4
    //   254: iload_2
    //   255: invokevirtual 277	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload 4
    //   261: ldc_w 288
    //   264: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 4
    //   270: aload_3
    //   271: getfield 255	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain:mId	Ljava/lang/String;
    //   274: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: pop
    //   278: new 149	java/lang/RuntimeException
    //   281: dup
    //   282: aload 4
    //   284: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokespecial 151	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   290: athrow
    //   291: astore_1
    //   292: ldc 236
    //   294: ldc_w 290
    //   297: aload_1
    //   298: invokestatic 122	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:printLog	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   301: aload_0
    //   302: monitorexit
    //   303: return
    //   304: astore_1
    //   305: aload_0
    //   306: monitorexit
    //   307: aload_1
    //   308: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	FilterManagerInternal
    //   0	309	1	paramString	String
    //   0	309	2	paramBoolean	boolean
    //   18	253	3	localFilterChain	FilterManagerInternal.FilterChain
    //   168	115	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   8	19	291	java/util/EmptyStackException
    //   2	8	304	finally
    //   8	19	304	finally
    //   23	39	304	finally
    //   42	149	304	finally
    //   153	158	304	finally
    //   161	218	304	finally
    //   218	291	304	finally
    //   292	301	304	finally
  }
  
  private static void printLog(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      if (SLog.isEnable())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append(": ");
        localStringBuilder.append(paramString2);
        SLog.e("FilterManagerInternal", localStringBuilder.toString(), paramThrowable);
      }
    }
    else if (SLog.isEnable())
    {
      paramThrowable = new StringBuilder();
      paramThrowable.append(paramString1);
      paramThrowable.append(": ");
      paramThrowable.append(paramString2);
      SLog.i("FilterManagerInternal", paramThrowable.toString());
    }
  }
  
  private void printStackReleaseInfo()
  {
    try
    {
      try
      {
        Object localObject1 = (FilterManagerInternal.FilterChain)this.mChains.peek();
        Object localObject3;
        if (localObject1 != null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("top ");
          ((StringBuilder)localObject3).append(((FilterManagerInternal.FilterChain)localObject1).info);
          printLog("printReleaseInfo", ((StringBuilder)localObject3).toString(), null);
        }
        if (this.mChains.size() > 0)
        {
          localObject1 = this.mChains.iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject3 = (FilterManagerInternal.FilterChain)((Iterator)localObject1).next();
            if (localObject3 != null)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("For ");
              localStringBuilder.append(((FilterManagerInternal.FilterChain)localObject3).info);
              printLog("printReleaseInfo", localStringBuilder.toString(), null);
            }
          }
        }
        printLog("printReleaseInfo", " mChains.size()=0", null);
      }
      finally
      {
        break label163;
      }
    }
    catch (EmptyStackException localEmptyStackException)
    {
      label150:
      label163:
      break label150;
    }
    printLog("printReleaseInfo", " EmptyStackException", null);
    return;
    for (;;)
    {
      throw localObject2;
    }
  }
  
  /* Error */
  private String pushChainInternal(int[] paramArrayOfInt, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:mChains	Ljava/util/Stack;
    //   6: invokevirtual 241	java/util/Stack:peek	()Ljava/lang/Object;
    //   9: checkcast 66	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain
    //   12: astore_3
    //   13: goto +53 -> 66
    //   16: astore_1
    //   17: goto +103 -> 120
    //   20: astore_3
    //   21: aload_3
    //   22: invokevirtual 320	java/util/EmptyStackException:printStackTrace	()V
    //   25: new 102	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   32: astore_3
    //   33: aload_3
    //   34: ldc_w 322
    //   37: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_3
    //   42: aload_0
    //   43: getfield 39	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:mChains	Ljava/util/Stack;
    //   46: invokevirtual 47	java/util/Stack:size	()I
    //   49: invokevirtual 114	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: ldc_w 323
    //   56: aload_3
    //   57: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: aconst_null
    //   61: invokestatic 122	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:printLog	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   64: aconst_null
    //   65: astore_3
    //   66: new 66	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain
    //   69: dup
    //   70: aload_0
    //   71: aload_1
    //   72: aload_2
    //   73: invokespecial 326	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain:<init>	(Lcom/tencent/mobileqq/shortvideo/filter/FilterManagerInternal;[I[Ljava/lang/Object;)V
    //   76: astore_1
    //   77: aload_1
    //   78: aload_3
    //   79: putfield 330	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain:oldTopChain	Lcom/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain;
    //   82: aload_0
    //   83: aload_1
    //   84: invokespecial 332	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:newAddQuote	(Lcom/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain;)V
    //   87: aload_0
    //   88: getfield 39	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:mChains	Ljava/util/Stack;
    //   91: aload_1
    //   92: invokevirtual 335	java/util/Stack:push	(Ljava/lang/Object;)Ljava/lang/Object;
    //   95: pop
    //   96: ldc_w 323
    //   99: aload_1
    //   100: getfield 264	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain:info	Ljava/lang/String;
    //   103: aconst_null
    //   104: invokestatic 122	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:printLog	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_0
    //   108: invokespecial 337	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal:checkStackIsLeakage	()V
    //   111: aload_1
    //   112: invokevirtual 70	com/tencent/mobileqq/shortvideo/filter/FilterManagerInternal$FilterChain:getId	()Ljava/lang/String;
    //   115: astore_1
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_1
    //   119: areturn
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	this	FilterManagerInternal
    //   0	124	1	paramArrayOfInt	int[]
    //   0	124	2	paramArrayOfObject	Object[]
    //   12	1	3	localFilterChain	FilterManagerInternal.FilterChain
    //   20	2	3	localEmptyStackException	EmptyStackException
    //   32	47	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	13	16	finally
    //   21	64	16	finally
    //   66	116	16	finally
    //   2	13	20	java/util/EmptyStackException
  }
  
  private void pushChainRunSecurity(FilterManagerInternal.FilterChain paramFilterChain1, FilterManagerInternal.FilterChain paramFilterChain2)
  {
    initHighCache(paramFilterChain1);
    if (paramFilterChain2 != null) {
      runChainPauseInternal(paramFilterChain2);
    }
  }
  
  private void recoveryTopChainParams()
  {
    try
    {
      FilterManagerInternal.FilterChain localFilterChain = (FilterManagerInternal.FilterChain)this.mChains.peek();
      if (localFilterChain == null)
      {
        this.mChains.pop();
        printLog("recoveryTopChainParams", "peek currentChain=null", null);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("peek ");
      localStringBuilder.append(localFilterChain.info);
      printLog("recoveryTopChainParams", localStringBuilder.toString(), null);
      if (localFilterChain.mFilters != null)
      {
        int i = 0;
        while (i < localFilterChain.mFilters.length)
        {
          ((QQBaseFilter)localFilterChain.mHighCache.get(i)).setSpecificParam(localFilterChain.getParam(i));
          i += 1;
        }
      }
      runChainResumeInternal(localFilterChain);
      return;
    }
    catch (EmptyStackException localEmptyStackException)
    {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", "recoveryTopChainParams: peek=null", localEmptyStackException);
      }
    }
  }
  
  private void releaseChainResource(FilterManagerInternal.FilterChain paramFilterChain)
  {
    printLog("releaseChainResource", paramFilterChain.info, null);
    if (paramFilterChain.mFilters != null)
    {
      paramFilterChain = paramFilterChain.mFilters;
      int j = paramFilterChain.length;
      int i = 0;
      while (i < j)
      {
        int k = paramFilterChain[i];
        QQBaseFilter localQQBaseFilter = this.mCacheQueue.getFilterByType(k);
        if (localQQBaseFilter.mQuoteCount.get() == 0)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(" [cnt=0] name=");
          localStringBuilder.append(localQQBaseFilter.getClass().getName());
          printLog("releaseChainResource", localStringBuilder.toString(), null);
          localQQBaseFilter.onSurfaceDestroy();
          localQQBaseFilter.mStatus = 0;
          this.mCacheQueue.removeFilter(k);
        }
        i += 1;
      }
    }
  }
  
  private void runChainPauseInternal(FilterManagerInternal.FilterChain paramFilterChain)
  {
    if ((paramFilterChain != null) && (paramFilterChain.mFilters != null))
    {
      Iterator localIterator = paramFilterChain.mHighCache.iterator();
      while (localIterator.hasNext()) {
        ((QQBaseFilter)localIterator.next()).onPause();
      }
      printLog("runChainPauseInternal ", paramFilterChain.info, null);
    }
  }
  
  private void runChainResumeInternal(FilterManagerInternal.FilterChain paramFilterChain)
  {
    if ((paramFilterChain != null) && (paramFilterChain.mFilters != null))
    {
      Iterator localIterator = paramFilterChain.mHighCache.iterator();
      while (localIterator.hasNext()) {
        ((QQBaseFilter)localIterator.next()).onResume();
      }
      printLog("runChainResumeInternal ", paramFilterChain.info, null);
    }
  }
  
  void changeCamera(int paramInt)
  {
    if (!this.mReleased)
    {
      Iterator localIterator = this.mCacheQueue.getFilterList().iterator();
      while (localIterator.hasNext()) {
        ((QQBaseFilter)localIterator.next()).onChangeCamera(paramInt);
      }
    }
  }
  
  QQBaseFilter currentChainGetFilter(int paramInt)
  {
    try
    {
      Object localObject = (FilterManagerInternal.FilterChain)this.mChains.peek();
      if ((localObject == null) || (!((FilterManagerInternal.FilterChain)localObject).hasFilterType(paramInt))) {
        break label49;
      }
      localObject = this.mCacheQueue.getFilterByType(paramInt);
      return localObject;
    }
    catch (EmptyStackException localEmptyStackException)
    {
      label34:
      label49:
      break label34;
    }
    if (SLog.isEnable()) {
      SLog.e("FilterManagerInternal", "currentChainGetFilter: EmptyStackException ", null);
    }
    return null;
  }
  
  boolean currentChinaHasFilter(int paramInt)
  {
    try
    {
      FilterManagerInternal.FilterChain localFilterChain = (FilterManagerInternal.FilterChain)this.mChains.peek();
      if (localFilterChain != null)
      {
        boolean bool = localFilterChain.hasFilterType(paramInt);
        return bool;
      }
    }
    catch (EmptyStackException localEmptyStackException)
    {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", "currentChinaHasFilter: EmptyStackException ", localEmptyStackException);
      }
    }
    return false;
  }
  
  final String generateStackTrace()
  {
    try
    {
      localObject1 = new StringBuilder();
    }
    finally
    {
      Object localObject1;
      FilterManagerInternal.FilterChain localFilterChain;
      int i;
      label137:
      label145:
      for (;;)
      {
        label97:
        throw localObject2;
      }
    }
    try
    {
      localFilterChain = (FilterManagerInternal.FilterChain)this.mChains.peek();
      ((StringBuilder)localObject1).append("current: ");
      if (localFilterChain != null) {
        ((StringBuilder)localObject1).append(localFilterChain.info);
      } else {
        ((StringBuilder)localObject1).append("null");
      }
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append("stacktrace: ");
      i = this.mChains.size();
      ((StringBuilder)localObject1).append(i);
      if (i <= 0) {
        break label145;
      }
      i = this.mChains.size() - 1;
      if (i < 0) {
        break label145;
      }
      localFilterChain = (FilterManagerInternal.FilterChain)this.mChains.get(i);
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append(localFilterChain.info);
      i -= 1;
      break label97;
    }
    catch (EmptyStackException localEmptyStackException)
    {
      break label137;
    }
    ((StringBuilder)localObject1).append("stack empty!");
    localObject1 = ((StringBuilder)localObject1).toString();
    return localObject1;
  }
  
  void getAllActiveFilter(List<QQBaseFilter> paramList)
  {
    Iterator localIterator = this.mCacheQueue.getFilterList().iterator();
    while (localIterator.hasNext())
    {
      QQBaseFilter localQQBaseFilter = (QQBaseFilter)localIterator.next();
      if (localQQBaseFilter.isFilterWork()) {
        paramList.add(localQQBaseFilter);
      }
    }
  }
  
  String getCacheFilterInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.mCacheQueue.getFilterList();
    int i = ((Collection)localObject).size();
    localStringBuilder.append(i);
    localStringBuilder.append(" : ");
    if (i > 0)
    {
      localObject = ((Collection)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        localStringBuilder.append(FilterCreateFactory.getFilterTag(((QQBaseFilter)((Iterator)localObject).next()).mFilterType));
        localStringBuilder.append('|');
      }
      return localStringBuilder.substring(0, localStringBuilder.length() - 1);
    }
    return "empty!";
  }
  
  final boolean getCurrentChainData(ArrayList<Integer> paramArrayList, ArrayList<Object> paramArrayList1)
  {
    try
    {
      FilterManagerInternal.FilterChain localFilterChain = (FilterManagerInternal.FilterChain)this.mChains.peek();
      if (localFilterChain != null)
      {
        localFilterChain.getFilterTypes(paramArrayList);
        localFilterChain.getFilterParams(paramArrayList1);
        return true;
      }
    }
    catch (EmptyStackException paramArrayList)
    {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", "getCurrentChainData: EmptyStackException ", paramArrayList);
      }
    }
    return false;
  }
  
  final String getCurrentChainId()
  {
    try
    {
      Object localObject = (FilterManagerInternal.FilterChain)this.mChains.peek();
      if (localObject != null)
      {
        localObject = ((FilterManagerInternal.FilterChain)localObject).getId();
        return localObject;
      }
    }
    catch (EmptyStackException localEmptyStackException)
    {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", "getCurrentChainId: EmptyStackException ", localEmptyStackException);
      }
    }
    return null;
  }
  
  Object getFilterSpecificParam(int paramInt)
  {
    try
    {
      Object localObject = (FilterManagerInternal.FilterChain)this.mChains.peek();
      if ((localObject != null) && (((FilterManagerInternal.FilterChain)localObject).hasFilterType(paramInt)))
      {
        localObject = this.mCacheQueue.getFilterByType(paramInt).getSpecificParam();
        return localObject;
      }
    }
    catch (EmptyStackException localEmptyStackException)
    {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", "getFilterSpecificParam: EmptyStackException ", localEmptyStackException);
      }
    }
    return null;
  }
  
  final boolean hasAllResourceActiveFilter()
  {
    Iterator localIterator = this.mCacheQueue.getFilterList().iterator();
    while (localIterator.hasNext()) {
      if (((QQBaseFilter)localIterator.next()).isFilterWork()) {
        return true;
      }
    }
    return false;
  }
  
  String insertNewFilterToOldChain_pushChain(int paramInt, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((getCurrentChainData(localArrayList1, localArrayList2)) && (localArrayList1.size() > 0))
    {
      if (isOldChainFollowSerial(localArrayList1))
      {
        insertFollowSerial(paramInt, paramObject, localArrayList1, localArrayList2);
      }
      else
      {
        int j = localArrayList1.size();
        int k = localArrayList2.size();
        int i = 0;
        while (i < j - k)
        {
          localArrayList2.add(null);
          i += 1;
        }
        localArrayList1.add(Integer.valueOf(paramInt));
        localArrayList2.add(paramObject);
      }
    }
    else
    {
      localArrayList1.add(Integer.valueOf(paramInt));
      localArrayList2.add(paramObject);
    }
    return push(localArrayList1, localArrayList2);
  }
  
  boolean isFilterWork(int paramInt)
  {
    try
    {
      FilterManagerInternal.FilterChain localFilterChain = (FilterManagerInternal.FilterChain)this.mChains.peek();
      if ((localFilterChain != null) && (localFilterChain.hasFilterType(paramInt)))
      {
        boolean bool = this.mCacheQueue.getFilterByType(paramInt).isFilterWork();
        return bool;
      }
    }
    catch (EmptyStackException localEmptyStackException)
    {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", "isFilterWork: EmptyStackException ", localEmptyStackException);
      }
    }
    return false;
  }
  
  boolean needFaceDetect()
  {
    return this.needFaceDetect;
  }
  
  final void onCurrentChainPause()
  {
    try
    {
      checkThreadSecurity("onCurrentChainPause");
      runChainPauseInternal((FilterManagerInternal.FilterChain)this.mChains.peek());
      return;
    }
    catch (EmptyStackException localEmptyStackException)
    {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", "onCurrentChainPause: EmptyStackException ", localEmptyStackException);
      }
    }
  }
  
  final void onCurrentChainResume()
  {
    try
    {
      checkThreadSecurity("onCurrentChainResume");
      runChainResumeInternal((FilterManagerInternal.FilterChain)this.mChains.peek());
      return;
    }
    catch (EmptyStackException localEmptyStackException)
    {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", "onCurrentChainResume: EmptyStackException ", localEmptyStackException);
      }
    }
  }
  
  void pop(String paramString)
  {
    popAndReleaseInternal(paramString, false);
  }
  
  void popAndRelease(String paramString)
  {
    popAndReleaseInternal(paramString, true);
  }
  
  String push(ArrayList<Integer> paramArrayList, ArrayList<Object> paramArrayList1)
  {
    Object localObject = null;
    if (paramArrayList != null)
    {
      int[] arrayOfInt = new int[paramArrayList.size()];
      int i = 0;
      while (i < paramArrayList.size())
      {
        arrayOfInt[i] = ((Integer)paramArrayList.get(i)).intValue();
        i += 1;
      }
      paramArrayList = localObject;
      if (paramArrayList1 != null) {
        paramArrayList = paramArrayList1.toArray();
      }
      return push(arrayOfInt, paramArrayList);
    }
    return null;
  }
  
  String push(int[] paramArrayOfInt)
  {
    return push(paramArrayOfInt, null);
  }
  
  String push(int[] paramArrayOfInt, Object[] paramArrayOfObject)
  {
    return pushChainInternal(paramArrayOfInt, paramArrayOfObject);
  }
  
  void releaseAllResource()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("releaseAllResource currentThreadName=");
    ((StringBuilder)localObject).append(Thread.currentThread().getName());
    printLog("releaseAllResource", ((StringBuilder)localObject).toString(), null);
    this.mReleased = true;
    printStackReleaseInfo();
    this.mChains.clear();
    localObject = this.mCacheQueue.getFilterList().iterator();
    while (((Iterator)localObject).hasNext())
    {
      QQBaseFilter localQQBaseFilter = (QQBaseFilter)((Iterator)localObject).next();
      localQQBaseFilter.onSurfaceDestroy();
      localQQBaseFilter.mStatus = 0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("releaseAllResource ");
      localStringBuilder.append(localQQBaseFilter.getClass().getName());
      printLog("releaseAllResource", localStringBuilder.toString(), null);
    }
    this.mCacheQueue.clearAll();
  }
  
  int runChain(int paramInt)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("runChain currentThreadName=");
    ((StringBuilder)localObject1).append(Thread.currentThread().getName());
    printLog("runChain", ((StringBuilder)localObject1).toString(), null);
    if (this.mReleased)
    {
      SLog.e("FilterManagerInternal", "runChain: mReleased=true");
      return paramInt;
    }
    try
    {
      localObject1 = (FilterManagerInternal.FilterChain)this.mChains.peek();
    }
    catch (EmptyStackException localEmptyStackException)
    {
      label74:
      Object localObject2;
      int i;
      Object localObject3;
      break label74;
    }
    printLog("FilterManagerInternal", "peek == null", null);
    localObject1 = null;
    if (localObject1 == null)
    {
      printLog("runChain", "peek currentChain=null", null);
      return paramInt;
    }
    if (((FilterManagerInternal.FilterChain)localObject1).mFilters == null) {
      return paramInt;
    }
    if (((FilterManagerInternal.FilterChain)localObject1).mCreateResume) {
      pushChainRunSecurity((FilterManagerInternal.FilterChain)localObject1, ((FilterManagerInternal.FilterChain)localObject1).oldTopChain);
    }
    localObject2 = ((FilterManagerInternal.FilterChain)localObject1).mHighCache.iterator();
    for (;;)
    {
      boolean bool = ((Iterator)localObject2).hasNext();
      i = 2;
      if (!bool) {
        break;
      }
      localObject3 = (QQBaseFilter)((Iterator)localObject2).next();
      if (((QQBaseFilter)localObject3).mStatus == 0)
      {
        ((QQBaseFilter)localObject3).onSurfaceCreate();
        ((QQBaseFilter)localObject3).onSurfaceChange(this.mCommonParam.getFilterWidth(), this.mCommonParam.getFilterHeight());
        ((QQBaseFilter)localObject3).mStatus = 2;
      }
      else if (((QQBaseFilter)localObject3).mStatus == 1)
      {
        ((QQBaseFilter)localObject3).onSurfaceChange(this.mCommonParam.getFilterWidth(), this.mCommonParam.getFilterHeight());
        ((QQBaseFilter)localObject3).mStatus = 2;
      }
    }
    if (((FilterManagerInternal.FilterChain)localObject1).mCreateResume)
    {
      runChainResumeInternal((FilterManagerInternal.FilterChain)localObject1);
      ((FilterManagerInternal.FilterChain)localObject1).mCreateResume = false;
    }
    this.needFaceDetect = false;
    localObject2 = ((FilterManagerInternal.FilterChain)localObject1).mHighCache.iterator();
    while (((Iterator)localObject2).hasNext()) {
      if (((QQBaseFilter)((Iterator)localObject2).next()).needFaceDetect()) {
        this.needFaceDetect = true;
      }
    }
    QQFilterLogManager.setLogStart("mFaceDetect");
    localObject2 = this.mFaceDetect;
    if (this.needFaceDetect) {
      i = 1;
    }
    ((QQFaceDetectBase)localObject2).setFaceDetectType(i);
    this.mFaceDetect.setCaptureMode(this.isCaptureMode);
    i = paramInt;
    if (this.needFaceDetect)
    {
      this.mFaceDetect.setInputTextureID(paramInt);
      this.mFaceDetect.onDrawFrame();
      i = this.mFaceDetect.getOutputTextureID();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("mFaceDetect: needFaceDetect=");
    ((StringBuilder)localObject2).append(this.needFaceDetect);
    QQFilterLogManager.setLogEnd(((StringBuilder)localObject2).toString());
    localObject1 = ((FilterManagerInternal.FilterChain)localObject1).mHighCache.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (QQBaseFilter)((Iterator)localObject1).next();
      ((QQBaseFilter)localObject2).setCaptureMode(this.isCaptureMode);
      QQFilterLogManager.setOnDrawFilterStart();
      ((QQBaseFilter)localObject2).setInputTextureID(i);
      ((QQBaseFilter)localObject2).onDrawFrame();
      i = ((QQBaseFilter)localObject2).getOutputTextureID();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("runChain: ");
      ((StringBuilder)localObject3).append(localObject2.getClass().getName());
      QQFilterLogManager.setOnDrawFilterEnd(((StringBuilder)localObject3).toString());
    }
    GLES20.glDisable(2929);
    FrameBufferCache.getInstance().forceRecycle();
    return i;
  }
  
  public void setCaptureMode(boolean paramBoolean)
  {
    this.isCaptureMode = paramBoolean;
  }
  
  void setCommonParam(QQFilterRenderManager paramQQFilterRenderManager)
  {
    this.mCommonParam = paramQQFilterRenderManager;
    this.mFaceDetect = new QQFaceDetectBase(paramQQFilterRenderManager);
  }
  
  void setFilterSpecificParam(int paramInt, Object paramObject)
  {
    Object localObject;
    try
    {
      FilterManagerInternal.FilterChain localFilterChain = (FilterManagerInternal.FilterChain)this.mChains.peek();
    }
    catch (EmptyStackException localEmptyStackException)
    {
      if (SLog.isEnable()) {
        SLog.e("FilterManagerInternal", "setFilterSpecificParam: EmptyStackException ", localEmptyStackException);
      }
      localObject = null;
    }
    if ((localObject != null) && (localObject.hasFilterType(paramInt))) {
      this.mCacheQueue.getFilterByType(paramInt).setSpecificParam(paramObject);
    }
  }
  
  void setNeedFaceDetectFlip(boolean paramBoolean)
  {
    this.mFaceDetect.setNeedFlip(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.FilterManagerInternal
 * JD-Core Version:    0.7.0.1
 */