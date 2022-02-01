package com.tencent.mobileqq.mini.cache;

import android.content.Context;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;

public class Storage
{
  public static final int CACHE_VERSION = 1;
  private static final String TAG = "RequestHandler";
  public static final Object lock = new Object();
  private static final ConcurrentHashMap<String, Storage> mMapList = new ConcurrentHashMap();
  private String mApkname;
  private WeakReference<Context> mContextRef;
  private DiskLruCache mDiskCache;
  private LruCache<String, String> mLruCache;
  private String mUin;
  
  private Storage(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      String str = getCacheDir(paramContext.getCacheDir().getAbsolutePath(), paramString1, paramString2);
      if (!TextUtils.isEmpty(str))
      {
        this.mContextRef = new WeakReference(paramContext);
        this.mUin = paramString1;
        this.mApkname = paramString2;
        this.mDiskCache = DiskLruCache.open(new File(str), 1, 1, 10485760L);
        this.mLruCache = new Storage.1(this, 10485760);
        return;
      }
      QLog.e("RequestHandler", 1, "[Storage] can not create dir");
      return;
    }
    catch (Throwable paramContext)
    {
      QLog.e("RequestHandler", 1, paramContext, new Object[0]);
    }
  }
  
  public static void destroy()
  {
    synchronized (mMapList)
    {
      Iterator localIterator = mMapList.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        localObject2 = (Storage)mMapList.get(localObject2);
        if (localObject2 != null)
        {
          QLog.e("StoragePlugin", 1, "------destroy mDiskCache.closed-----");
          ((Storage)localObject2).close();
        }
      }
      mMapList.clear();
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public static String getCacheDir(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/mini");
      paramString1 = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/");
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = "default";
      }
      localStringBuilder.append(paramString1);
      paramString1 = localStringBuilder.toString();
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("/");
      paramString2.append(paramString3);
      paramString1 = paramString2.toString();
      paramString2 = new File(paramString1);
      if ((!paramString2.exists()) && (!paramString2.mkdirs())) {
        return null;
      }
      paramString2 = new StringBuilder();
      paramString2.append("[Storage] getCacheDir: ");
      paramString2.append(paramString1);
      QLog.i("StoragePlugin", 1, paramString2.toString());
      return paramString1;
    }
    return null;
  }
  
  public static long getCurrentStorageSize(String paramString)
  {
    try
    {
      paramString = getToken(String.valueOf(BaseApplicationImpl.getApplication().waitAppRuntime(null).getLongAccountUin()), paramString);
      paramString = (Storage)mMapList.get(paramString);
      if (paramString == null) {
        return -1L;
      }
      long l = paramString.getCurrentSizeBytes();
      return l;
    }
    catch (Exception paramString)
    {
      QLog.e("RequestHandler", 2, "getCurrentStorageSize failed:", paramString);
    }
    return -1L;
  }
  
  private static String getToken(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  public static Storage open(Context paramContext, String paramString1, String paramString2)
  {
    ConcurrentHashMap localConcurrentHashMap = mMapList;
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        String str = getToken(paramString1, paramString2);
        Storage localStorage2 = (Storage)mMapList.get(str);
        localStorage1 = localStorage2;
        if (localStorage2 == null) {
          synchronized (lock)
          {
            localStorage2 = (Storage)mMapList.get(getToken(paramString1, paramString2));
            localStorage1 = localStorage2;
            if (localStorage2 == null)
            {
              localStorage1 = new Storage(paramContext, paramString1, paramString2);
              mMapList.put(str, localStorage1);
            }
          }
        }
        return localStorage1;
      }
      finally {}
      Storage localStorage1 = null;
    }
  }
  
  private void reCreateCache()
  {
    Object localObject = this.mContextRef;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = getCacheDir(((Context)this.mContextRef.get()).getCacheDir().getAbsolutePath(), this.mUin, this.mApkname);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.mContextRef = new WeakReference(this.mContextRef.get());
        try
        {
          this.mDiskCache = DiskLruCache.open(new File((String)localObject), 1, 1, 10485760L);
          return;
        }
        catch (Throwable localThrowable)
        {
          QLog.e("RequestHandler", 1, localThrowable, new Object[0]);
        }
      }
    }
  }
  
  public boolean clearStorage()
  {
    Object localObject = this.mLruCache;
    if (localObject != null) {
      ((LruCache)localObject).trimToSize(0);
    }
    localObject = this.mDiskCache;
    if (localObject != null) {
      try
      {
        ((DiskLruCache)localObject).delete();
        return true;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("RequestHandler", 1, localThrowable, new Object[0]);
        return false;
      }
    }
    return true;
  }
  
  public void close()
  {
    if (this.mDiskCache != null)
    {
      try
      {
        QLog.e("StoragePlugin", 1, "------mDiskCache.closed-----");
        this.mDiskCache.close();
      }
      catch (Throwable localThrowable)
      {
        QLog.e("RequestHandler", 1, localThrowable, new Object[0]);
      }
      LruCache localLruCache = this.mLruCache;
      if (localLruCache != null) {
        localLruCache.evictAll();
      }
    }
  }
  
  public long getCurrentSize()
  {
    DiskLruCache localDiskLruCache = this.mDiskCache;
    if (localDiskLruCache != null)
    {
      double d = localDiskLruCache.size();
      Double.isNaN(d);
      return (int)Math.ceil(d / 1000.0D);
    }
    return -1L;
  }
  
  public long getCurrentSizeBytes()
  {
    DiskLruCache localDiskLruCache = this.mDiskCache;
    if (localDiskLruCache != null) {
      return localDiskLruCache.size();
    }
    return -1L;
  }
  
  public int getLimitSize()
  {
    DiskLruCache localDiskLruCache = this.mDiskCache;
    if (localDiskLruCache != null) {
      return (int)Math.ceil(localDiskLruCache.getMaxSize() / 1000L);
    }
    return -1;
  }
  
  public Set<String> keys()
  {
    DiskLruCache localDiskLruCache = this.mDiskCache;
    if ((localDiskLruCache != null) && (!localDiskLruCache.isClosed())) {
      return this.mDiskCache.getKeys();
    }
    return null;
  }
  
  /* Error */
  public String[] read(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 95	com/tencent/mobileqq/mini/cache/Storage:mLruCache	Landroid/support/v4/util/LruCache;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 6
    //   8: aload 6
    //   10: astore_2
    //   11: aload_3
    //   12: ifnull +244 -> 256
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 283	android/support/v4/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 140	java/lang/String
    //   23: astore_2
    //   24: aload_2
    //   25: astore_3
    //   26: aload_2
    //   27: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifeq +211 -> 241
    //   33: aload_0
    //   34: getfield 87	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   37: astore 4
    //   39: aload_2
    //   40: astore_3
    //   41: aload 4
    //   43: ifnull +198 -> 241
    //   46: aload 4
    //   48: invokevirtual 275	com/tencent/mobileqq/mini/cache/DiskLruCache:isClosed	()Z
    //   51: ifeq +7 -> 58
    //   54: aload_0
    //   55: invokespecial 113	com/tencent/mobileqq/mini/cache/Storage:reCreateCache	()V
    //   58: aload_0
    //   59: getfield 87	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   62: aload_1
    //   63: invokevirtual 286	com/tencent/mobileqq/mini/cache/DiskLruCache:get	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache$Snapshot;
    //   66: astore 5
    //   68: aload_2
    //   69: astore 4
    //   71: aload 5
    //   73: ifnull +96 -> 169
    //   76: aload 5
    //   78: astore_3
    //   79: aload 5
    //   81: iconst_0
    //   82: invokevirtual 292	com/tencent/mobileqq/mini/cache/DiskLruCache$Snapshot:getString	(I)Ljava/lang/String;
    //   85: astore 4
    //   87: aload 4
    //   89: astore_2
    //   90: aload 5
    //   92: astore_3
    //   93: aload_0
    //   94: getfield 95	com/tencent/mobileqq/mini/cache/Storage:mLruCache	Landroid/support/v4/util/LruCache;
    //   97: aload_1
    //   98: aload 4
    //   100: invokevirtual 293	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: aload 4
    //   106: astore_2
    //   107: aload 5
    //   109: astore_3
    //   110: getstatic 35	com/tencent/mobileqq/mini/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   113: astore_1
    //   114: aload 4
    //   116: astore_2
    //   117: aload 5
    //   119: astore_3
    //   120: aload_1
    //   121: monitorenter
    //   122: aload_0
    //   123: getfield 95	com/tencent/mobileqq/mini/cache/Storage:mLruCache	Landroid/support/v4/util/LruCache;
    //   126: ldc 90
    //   128: getstatic 35	com/tencent/mobileqq/mini/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   131: invokevirtual 122	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   134: invokeinterface 295 1 0
    //   139: idiv
    //   140: invokevirtual 237	android/support/v4/util/LruCache:trimToSize	(I)V
    //   143: aload_1
    //   144: monitorexit
    //   145: goto +24 -> 169
    //   148: astore 7
    //   150: aload_1
    //   151: monitorexit
    //   152: aload 4
    //   154: astore_2
    //   155: aload 5
    //   157: astore_3
    //   158: aload 7
    //   160: athrow
    //   161: astore 4
    //   163: aload 5
    //   165: astore_1
    //   166: goto +41 -> 207
    //   169: aload 4
    //   171: astore_3
    //   172: aload 5
    //   174: ifnull +67 -> 241
    //   177: aload 5
    //   179: astore_1
    //   180: aload 4
    //   182: astore_2
    //   183: aload_1
    //   184: invokevirtual 296	com/tencent/mobileqq/mini/cache/DiskLruCache$Snapshot:close	()V
    //   187: aload_2
    //   188: astore_3
    //   189: goto +52 -> 241
    //   192: aload_2
    //   193: astore_3
    //   194: goto +47 -> 241
    //   197: astore_1
    //   198: aconst_null
    //   199: astore_3
    //   200: goto +31 -> 231
    //   203: astore 4
    //   205: aconst_null
    //   206: astore_1
    //   207: aload_1
    //   208: astore_3
    //   209: ldc 11
    //   211: iconst_1
    //   212: aload 4
    //   214: iconst_0
    //   215: anewarray 4	java/lang/Object
    //   218: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   221: aload_2
    //   222: astore_3
    //   223: aload_1
    //   224: ifnull +17 -> 241
    //   227: goto -44 -> 183
    //   230: astore_1
    //   231: aload_3
    //   232: ifnull +7 -> 239
    //   235: aload_3
    //   236: invokevirtual 296	com/tencent/mobileqq/mini/cache/DiskLruCache$Snapshot:close	()V
    //   239: aload_1
    //   240: athrow
    //   241: aload 6
    //   243: astore_2
    //   244: aload_3
    //   245: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   248: ifne +8 -> 256
    //   251: aload_3
    //   252: invokestatic 301	com/tencent/mobileqq/mini/cache/Util:decode	(Ljava/lang/String;)[Ljava/lang/String;
    //   255: astore_2
    //   256: aload_2
    //   257: areturn
    //   258: astore_1
    //   259: goto -67 -> 192
    //   262: astore_2
    //   263: goto -24 -> 239
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	266	0	this	Storage
    //   0	266	1	paramString	String
    //   10	247	2	localObject1	Object
    //   262	1	2	localThrowable1	Throwable
    //   4	248	3	localObject2	Object
    //   37	116	4	localObject3	Object
    //   161	20	4	localThrowable2	Throwable
    //   203	10	4	localThrowable3	Throwable
    //   66	112	5	localSnapshot	DiskLruCache.Snapshot
    //   6	236	6	localObject4	Object
    //   148	11	7	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   122	145	148	finally
    //   150	152	148	finally
    //   79	87	161	java/lang/Throwable
    //   93	104	161	java/lang/Throwable
    //   110	114	161	java/lang/Throwable
    //   120	122	161	java/lang/Throwable
    //   158	161	161	java/lang/Throwable
    //   46	58	197	finally
    //   58	68	197	finally
    //   46	58	203	java/lang/Throwable
    //   58	68	203	java/lang/Throwable
    //   79	87	230	finally
    //   93	104	230	finally
    //   110	114	230	finally
    //   120	122	230	finally
    //   158	161	230	finally
    //   209	221	230	finally
    //   183	187	258	java/lang/Throwable
    //   235	239	262	java/lang/Throwable
  }
  
  public boolean removeStorage(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject = this.mLruCache;
      if (localObject != null) {
        ((LruCache)localObject).remove(paramString);
      }
      localObject = this.mDiskCache;
      if (localObject != null)
      {
        if (((DiskLruCache)localObject).isClosed()) {
          reCreateCache();
        }
        try
        {
          this.mDiskCache.remove(paramString);
          return true;
        }
        catch (Throwable paramString)
        {
          QLog.e("RequestHandler", 1, paramString, new Object[0]);
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public void write(String paramString1, String paramString2, String paramString3, Storage.StorageCallback paramStorageCallback)
  {
    ThreadManagerV2.executeOnSubThread(new Storage.2(this, paramString2, paramString3, paramStorageCallback, paramString1));
  }
  
  /* Error */
  public boolean writeSync(String arg1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: invokestatic 331	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   3: invokevirtual 334	java/lang/Thread:getName	()Ljava/lang/String;
    //   6: invokestatic 340	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   9: invokevirtual 343	android/os/Looper:getThread	()Ljava/lang/Thread;
    //   12: invokevirtual 334	java/lang/Thread:getName	()Ljava/lang/String;
    //   15: invokevirtual 347	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifne +288 -> 306
    //   21: aload_3
    //   22: aload_2
    //   23: invokestatic 350	com/tencent/mobileqq/mini/cache/Util:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull +24 -> 52
    //   31: aload_2
    //   32: invokevirtual 353	java/lang/String:length	()I
    //   35: ldc_w 354
    //   38: if_icmplt +14 -> 52
    //   41: ldc 11
    //   43: iconst_1
    //   44: ldc_w 356
    //   47: invokestatic 103	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: iconst_0
    //   51: ireturn
    //   52: aload_0
    //   53: getfield 87	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   56: astore_3
    //   57: aload_3
    //   58: ifnull +233 -> 291
    //   61: aload_3
    //   62: invokevirtual 275	com/tencent/mobileqq/mini/cache/DiskLruCache:isClosed	()Z
    //   65: ifeq +7 -> 72
    //   68: aload_0
    //   69: invokespecial 113	com/tencent/mobileqq/mini/cache/Storage:reCreateCache	()V
    //   72: aload_2
    //   73: invokestatic 63	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   76: ifne +132 -> 208
    //   79: aload_0
    //   80: invokevirtual 358	com/tencent/mobileqq/mini/cache/Storage:getCurrentSize	()J
    //   83: ldc2_w 270
    //   86: lmul
    //   87: aload_2
    //   88: invokevirtual 353	java/lang/String:length	()I
    //   91: i2l
    //   92: ladd
    //   93: ldc2_w 78
    //   96: lcmp
    //   97: ifle +34 -> 131
    //   100: ldc 11
    //   102: iconst_1
    //   103: ldc_w 356
    //   106: invokestatic 103	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   109: aload_0
    //   110: getfield 87	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull +14 -> 129
    //   118: aload_1
    //   119: invokevirtual 361	com/tencent/mobileqq/mini/cache/DiskLruCache:flush	()V
    //   122: iconst_0
    //   123: ireturn
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   129: iconst_0
    //   130: ireturn
    //   131: aload_0
    //   132: getfield 87	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   135: aload_1
    //   136: invokevirtual 368	com/tencent/mobileqq/mini/cache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/tencent/mobileqq/mini/cache/DiskLruCache$Editor;
    //   139: astore_3
    //   140: aload_3
    //   141: ifnull +13 -> 154
    //   144: aload_3
    //   145: iconst_0
    //   146: aload_2
    //   147: invokevirtual 374	com/tencent/mobileqq/mini/cache/DiskLruCache$Editor:set	(ILjava/lang/String;)V
    //   150: aload_3
    //   151: invokevirtual 377	com/tencent/mobileqq/mini/cache/DiskLruCache$Editor:commit	()V
    //   154: aload_0
    //   155: getfield 95	com/tencent/mobileqq/mini/cache/Storage:mLruCache	Landroid/support/v4/util/LruCache;
    //   158: ifnull +50 -> 208
    //   161: aload_0
    //   162: getfield 95	com/tencent/mobileqq/mini/cache/Storage:mLruCache	Landroid/support/v4/util/LruCache;
    //   165: aload_1
    //   166: aload_2
    //   167: invokevirtual 293	android/support/v4/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   170: pop
    //   171: getstatic 35	com/tencent/mobileqq/mini/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   174: astore_1
    //   175: aload_1
    //   176: monitorenter
    //   177: aload_0
    //   178: getfield 95	com/tencent/mobileqq/mini/cache/Storage:mLruCache	Landroid/support/v4/util/LruCache;
    //   181: ldc 90
    //   183: getstatic 35	com/tencent/mobileqq/mini/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   186: invokevirtual 122	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   189: invokeinterface 295 1 0
    //   194: idiv
    //   195: invokevirtual 237	android/support/v4/util/LruCache:trimToSize	(I)V
    //   198: aload_1
    //   199: monitorexit
    //   200: goto +8 -> 208
    //   203: astore_2
    //   204: aload_1
    //   205: monitorexit
    //   206: aload_2
    //   207: athrow
    //   208: aload_0
    //   209: getfield 87	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   212: astore_1
    //   213: aload_1
    //   214: ifnull +77 -> 291
    //   217: aload_1
    //   218: invokevirtual 361	com/tencent/mobileqq/mini/cache/DiskLruCache:flush	()V
    //   221: iconst_1
    //   222: ireturn
    //   223: astore_1
    //   224: aload_1
    //   225: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   228: iconst_1
    //   229: ireturn
    //   230: astore_1
    //   231: goto +37 -> 268
    //   234: astore_1
    //   235: ldc 11
    //   237: iconst_1
    //   238: aload_1
    //   239: iconst_0
    //   240: anewarray 4	java/lang/Object
    //   243: invokestatic 106	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   246: aload_0
    //   247: getfield 87	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   250: astore_1
    //   251: aload_1
    //   252: ifnull +14 -> 266
    //   255: aload_1
    //   256: invokevirtual 361	com/tencent/mobileqq/mini/cache/DiskLruCache:flush	()V
    //   259: iconst_0
    //   260: ireturn
    //   261: astore_1
    //   262: aload_1
    //   263: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   266: iconst_0
    //   267: ireturn
    //   268: aload_0
    //   269: getfield 87	com/tencent/mobileqq/mini/cache/Storage:mDiskCache	Lcom/tencent/mobileqq/mini/cache/DiskLruCache;
    //   272: astore_2
    //   273: aload_2
    //   274: ifnull +15 -> 289
    //   277: aload_2
    //   278: invokevirtual 361	com/tencent/mobileqq/mini/cache/DiskLruCache:flush	()V
    //   281: goto +8 -> 289
    //   284: astore_2
    //   285: aload_2
    //   286: invokevirtual 364	java/io/IOException:printStackTrace	()V
    //   289: aload_1
    //   290: athrow
    //   291: iconst_1
    //   292: ireturn
    //   293: astore_1
    //   294: ldc 11
    //   296: iconst_1
    //   297: ldc_w 379
    //   300: aload_1
    //   301: invokestatic 219	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   304: iconst_0
    //   305: ireturn
    //   306: new 381	java/lang/IllegalStateException
    //   309: dup
    //   310: ldc_w 383
    //   313: invokespecial 384	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   316: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	Storage
    //   0	317	2	paramString2	String
    //   0	317	3	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   118	122	124	java/io/IOException
    //   177	200	203	finally
    //   204	206	203	finally
    //   217	221	223	java/io/IOException
    //   72	109	230	finally
    //   131	140	230	finally
    //   144	154	230	finally
    //   154	177	230	finally
    //   206	208	230	finally
    //   235	246	230	finally
    //   72	109	234	java/lang/Throwable
    //   131	140	234	java/lang/Throwable
    //   144	154	234	java/lang/Throwable
    //   154	177	234	java/lang/Throwable
    //   206	208	234	java/lang/Throwable
    //   255	259	261	java/io/IOException
    //   277	281	284	java/io/IOException
    //   21	27	293	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.Storage
 * JD-Core Version:    0.7.0.1
 */