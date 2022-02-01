package com.tencent.qqmini.sdk.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.LoginManager;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Storage
{
  public static final int CACHE_VERSION = 1;
  public static final Object LOCK = new Object();
  public static final int MAX_SIZE = 10485760;
  private static final String TAG = "Storage";
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
      QMLog.e("Storage", "[Storage] can not create dir");
      return;
    }
    catch (Throwable paramContext)
    {
      QMLog.e("Storage", paramContext.getMessage(), paramContext);
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
          QMLog.e("Storage", "------destroy mDiskCache.closed-----");
          ((Storage)localObject2).close();
        }
      }
    }
    mMapList.clear();
  }
  
  public static String getCacheDir(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = paramString1 + "/mini";
      StringBuilder localStringBuilder = new StringBuilder().append(paramString1).append("/");
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = "default";
      }
      paramString1 = paramString1;
      paramString1 = paramString1 + "/" + paramString3;
      paramString2 = new File(paramString1);
      if ((paramString2.exists()) || (paramString2.mkdirs())) {}
    }
    else
    {
      return null;
    }
    QMLog.i("Storage", "[Storage] getCacheDir: " + paramString1);
    return paramString1;
  }
  
  public static long getCurrentStorageSize(String paramString)
  {
    try
    {
      paramString = getToken(String.valueOf(LoginManager.getInstance().getAccount()), paramString);
      paramString = (Storage)mMapList.get(paramString);
      if (paramString == null) {
        return -1L;
      }
      long l = paramString.getCurrentSizeBytes();
      return l;
    }
    catch (Exception paramString)
    {
      QMLog.e("Storage", "getCurrentStorageSize failed:", paramString);
    }
    return -1L;
  }
  
  private static String getToken(String paramString1, String paramString2)
  {
    return paramString1 + "_" + paramString2;
  }
  
  /* Error */
  public static Storage open(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: getstatic 40	com/tencent/qqmini/sdk/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   5: astore 5
    //   7: aload 5
    //   9: monitorenter
    //   10: aload_0
    //   11: ifnull +87 -> 98
    //   14: aload_1
    //   15: aload_2
    //   16: invokestatic 204	com/tencent/qqmini/sdk/cache/Storage:getToken	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   19: astore 6
    //   21: getstatic 40	com/tencent/qqmini/sdk/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   24: aload 6
    //   26: invokevirtual 148	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: checkcast 2	com/tencent/qqmini/sdk/cache/Storage
    //   32: astore 4
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: ifnonnull +59 -> 98
    //   42: getstatic 35	com/tencent/qqmini/sdk/cache/Storage:LOCK	Ljava/lang/Object;
    //   45: astore 7
    //   47: aload 7
    //   49: monitorenter
    //   50: getstatic 40	com/tencent/qqmini/sdk/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   53: aload_1
    //   54: aload_2
    //   55: invokestatic 204	com/tencent/qqmini/sdk/cache/Storage:getToken	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   58: invokevirtual 148	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   61: checkcast 2	com/tencent/qqmini/sdk/cache/Storage
    //   64: astore 4
    //   66: aload 4
    //   68: astore_3
    //   69: aload 4
    //   71: ifnonnull +24 -> 95
    //   74: new 2	com/tencent/qqmini/sdk/cache/Storage
    //   77: dup
    //   78: aload_0
    //   79: aload_1
    //   80: aload_2
    //   81: invokespecial 217	com/tencent/qqmini/sdk/cache/Storage:<init>	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   84: astore_3
    //   85: getstatic 40	com/tencent/qqmini/sdk/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   88: aload 6
    //   90: aload_3
    //   91: invokevirtual 221	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: aload 7
    //   97: monitorexit
    //   98: aload 5
    //   100: monitorexit
    //   101: aload_3
    //   102: areturn
    //   103: astore_0
    //   104: aload 7
    //   106: monitorexit
    //   107: aload_0
    //   108: athrow
    //   109: astore_0
    //   110: aload 5
    //   112: monitorexit
    //   113: aload_0
    //   114: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	115	0	paramContext	Context
    //   0	115	1	paramString1	String
    //   0	115	2	paramString2	String
    //   1	101	3	localObject1	Object
    //   32	38	4	localStorage	Storage
    //   5	106	5	localConcurrentHashMap	ConcurrentHashMap
    //   19	70	6	str	String
    // Exception table:
    //   from	to	target	type
    //   50	66	103	finally
    //   74	95	103	finally
    //   95	98	103	finally
    //   104	107	103	finally
    //   14	34	109	finally
    //   42	50	109	finally
    //   98	101	109	finally
    //   107	109	109	finally
    //   110	113	109	finally
  }
  
  private void reCreateCache()
  {
    String str;
    if ((this.mContextRef != null) && (this.mContextRef.get() != null))
    {
      str = getCacheDir(((Context)this.mContextRef.get()).getCacheDir().getAbsolutePath(), this.mUin, this.mApkname);
      if (!TextUtils.isEmpty(str)) {
        this.mContextRef = new WeakReference(this.mContextRef.get());
      }
    }
    try
    {
      this.mDiskCache = DiskLruCache.open(new File(str), 1, 1, 10485760L);
      return;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("Storage", localThrowable.getMessage(), localThrowable);
    }
  }
  
  public boolean clearStorage()
  {
    if (this.mLruCache != null) {
      this.mLruCache.trimToSize(0);
    }
    if (this.mDiskCache != null) {}
    try
    {
      this.mDiskCache.delete();
      return true;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("Storage", localThrowable.getMessage(), localThrowable);
    }
    return false;
  }
  
  public void close()
  {
    if (this.mDiskCache != null) {}
    try
    {
      QMLog.e("Storage", "------mDiskCache.closed-----");
      this.mDiskCache.close();
      if (this.mLruCache != null) {
        this.mLruCache.evictAll();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QMLog.e("Storage", localThrowable.getMessage(), localThrowable);
      }
    }
  }
  
  public long getCurrentSize()
  {
    if (this.mDiskCache != null) {
      return (int)Math.ceil(this.mDiskCache.size() / 1000.0D);
    }
    return -1L;
  }
  
  public long getCurrentSizeBytes()
  {
    if (this.mDiskCache != null) {
      return this.mDiskCache.size();
    }
    return -1L;
  }
  
  public int getLimitSize()
  {
    if (this.mDiskCache != null) {
      return (int)Math.ceil(this.mDiskCache.getMaxSize() / 1000L);
    }
    return -1;
  }
  
  public Set<String> keys()
  {
    if ((this.mDiskCache != null) && (!this.mDiskCache.isClosed())) {
      return this.mDiskCache.getKeys();
    }
    return null;
  }
  
  /* Error */
  public String[] read(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   4: ifnull +237 -> 241
    //   7: aload_0
    //   8: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   11: aload_1
    //   12: invokevirtual 270	android/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   15: checkcast 144	java/lang/String
    //   18: astore 4
    //   20: aload 4
    //   22: astore_3
    //   23: aload 4
    //   25: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: ifeq +113 -> 141
    //   31: aload 4
    //   33: astore_3
    //   34: aload_0
    //   35: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   38: ifnull +103 -> 141
    //   41: aload_0
    //   42: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   45: invokevirtual 262	com/tencent/qqmini/sdk/cache/DiskLruCache:isClosed	()Z
    //   48: ifeq +7 -> 55
    //   51: aload_0
    //   52: invokespecial 117	com/tencent/qqmini/sdk/cache/Storage:reCreateCache	()V
    //   55: aload_0
    //   56: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   59: aload_1
    //   60: invokevirtual 273	com/tencent/qqmini/sdk/cache/DiskLruCache:get	(Ljava/lang/String;)Lcom/tencent/qqmini/sdk/cache/DiskLruCache$Snapshot;
    //   63: astore_2
    //   64: aload 4
    //   66: astore 5
    //   68: aload_2
    //   69: ifnull +58 -> 127
    //   72: aload_2
    //   73: astore_3
    //   74: aload_2
    //   75: iconst_0
    //   76: invokevirtual 279	com/tencent/qqmini/sdk/cache/DiskLruCache$Snapshot:getString	(I)Ljava/lang/String;
    //   79: astore 5
    //   81: aload_2
    //   82: astore_3
    //   83: aload_0
    //   84: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   87: aload_1
    //   88: aload 5
    //   90: invokevirtual 280	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   93: pop
    //   94: aload_2
    //   95: astore_3
    //   96: getstatic 40	com/tencent/qqmini/sdk/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   99: astore_1
    //   100: aload_2
    //   101: astore_3
    //   102: aload_1
    //   103: monitorenter
    //   104: aload_0
    //   105: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   108: ldc 11
    //   110: getstatic 40	com/tencent/qqmini/sdk/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   113: invokevirtual 126	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   116: invokeinterface 282 1 0
    //   121: idiv
    //   122: invokevirtual 230	android/util/LruCache:trimToSize	(I)V
    //   125: aload_1
    //   126: monitorexit
    //   127: aload 5
    //   129: astore_3
    //   130: aload_2
    //   131: ifnull +10 -> 141
    //   134: aload_2
    //   135: invokevirtual 283	com/tencent/qqmini/sdk/cache/DiskLruCache$Snapshot:close	()V
    //   138: aload 5
    //   140: astore_3
    //   141: aload_3
    //   142: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   145: ifne +96 -> 241
    //   148: aload_3
    //   149: invokestatic 288	com/tencent/qqmini/sdk/cache/DiskLruCacheUtil:decode	(Ljava/lang/String;)[Ljava/lang/String;
    //   152: areturn
    //   153: astore 4
    //   155: aload_1
    //   156: monitorexit
    //   157: aload_2
    //   158: astore_3
    //   159: aload 4
    //   161: athrow
    //   162: astore_1
    //   163: aload 5
    //   165: astore 4
    //   167: aload_2
    //   168: astore_3
    //   169: ldc 15
    //   171: aload_1
    //   172: invokevirtual 107	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   175: aload_1
    //   176: invokestatic 110	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   179: aload 4
    //   181: astore_3
    //   182: aload_2
    //   183: ifnull -42 -> 141
    //   186: aload_2
    //   187: invokevirtual 283	com/tencent/qqmini/sdk/cache/DiskLruCache$Snapshot:close	()V
    //   190: aload 4
    //   192: astore_3
    //   193: goto -52 -> 141
    //   196: astore_1
    //   197: aload 4
    //   199: astore_3
    //   200: goto -59 -> 141
    //   203: astore_1
    //   204: aconst_null
    //   205: astore_3
    //   206: aload_3
    //   207: ifnull +7 -> 214
    //   210: aload_3
    //   211: invokevirtual 283	com/tencent/qqmini/sdk/cache/DiskLruCache$Snapshot:close	()V
    //   214: aload_1
    //   215: athrow
    //   216: astore_1
    //   217: aload 5
    //   219: astore_3
    //   220: goto -79 -> 141
    //   223: astore_2
    //   224: goto -10 -> 214
    //   227: astore_1
    //   228: goto -22 -> 206
    //   231: astore_1
    //   232: aconst_null
    //   233: astore_2
    //   234: goto -67 -> 167
    //   237: astore_1
    //   238: goto -71 -> 167
    //   241: aconst_null
    //   242: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	this	Storage
    //   0	243	1	paramString	String
    //   63	124	2	localSnapshot	DiskLruCache.Snapshot
    //   223	1	2	localThrowable	Throwable
    //   233	1	2	localObject1	Object
    //   22	198	3	localObject2	Object
    //   18	47	4	str1	String
    //   153	7	4	localObject3	Object
    //   165	33	4	localObject4	Object
    //   66	152	5	str2	String
    // Exception table:
    //   from	to	target	type
    //   104	127	153	finally
    //   155	157	153	finally
    //   83	94	162	java/lang/Throwable
    //   96	100	162	java/lang/Throwable
    //   102	104	162	java/lang/Throwable
    //   159	162	162	java/lang/Throwable
    //   186	190	196	java/lang/Throwable
    //   41	55	203	finally
    //   55	64	203	finally
    //   134	138	216	java/lang/Throwable
    //   210	214	223	java/lang/Throwable
    //   74	81	227	finally
    //   83	94	227	finally
    //   96	100	227	finally
    //   102	104	227	finally
    //   159	162	227	finally
    //   169	179	227	finally
    //   41	55	231	java/lang/Throwable
    //   55	64	231	java/lang/Throwable
    //   74	81	237	java/lang/Throwable
  }
  
  public boolean removeStorage(String paramString)
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.mLruCache != null) {
        this.mLruCache.remove(paramString);
      }
      if (this.mDiskCache != null) {
        if (this.mDiskCache.isClosed()) {
          reCreateCache();
        }
      }
    }
    try
    {
      this.mDiskCache.remove(paramString);
      bool = true;
      return bool;
    }
    catch (Throwable paramString)
    {
      QMLog.e("Storage", paramString.getMessage(), paramString);
    }
    return false;
  }
  
  public void write(String paramString1, String paramString2, String paramString3, Storage.StorageCallback paramStorageCallback)
  {
    ThreadManager.executeOnDiskIOThreadPool(new Storage.2(this, paramString2, paramString3, paramStorageCallback, paramString1));
  }
  
  /* Error */
  public boolean writeSync(String arg1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_3
    //   1: aload_2
    //   2: invokestatic 315	com/tencent/qqmini/sdk/cache/DiskLruCacheUtil:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   5: astore_2
    //   6: aload_2
    //   7: ifnull +35 -> 42
    //   10: aload_2
    //   11: invokevirtual 318	java/lang/String:length	()I
    //   14: ldc_w 319
    //   17: if_icmplt +25 -> 42
    //   20: ldc 15
    //   22: ldc_w 321
    //   25: invokestatic 104	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: iconst_0
    //   29: ireturn
    //   30: astore_1
    //   31: ldc 15
    //   33: ldc_w 323
    //   36: aload_1
    //   37: invokestatic 110	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   40: iconst_0
    //   41: ireturn
    //   42: aload_0
    //   43: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   46: ifnull +159 -> 205
    //   49: aload_0
    //   50: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   53: invokevirtual 262	com/tencent/qqmini/sdk/cache/DiskLruCache:isClosed	()Z
    //   56: ifeq +7 -> 63
    //   59: aload_0
    //   60: invokespecial 117	com/tencent/qqmini/sdk/cache/Storage:reCreateCache	()V
    //   63: aload_2
    //   64: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifne +124 -> 191
    //   70: aload_0
    //   71: invokevirtual 325	com/tencent/qqmini/sdk/cache/Storage:getCurrentSize	()J
    //   74: ldc2_w 257
    //   77: lmul
    //   78: aload_2
    //   79: invokevirtual 318	java/lang/String:length	()I
    //   82: i2l
    //   83: ladd
    //   84: ldc2_w 80
    //   87: lcmp
    //   88: ifle +34 -> 122
    //   91: ldc 15
    //   93: ldc_w 321
    //   96: invokestatic 104	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   99: aload_0
    //   100: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   103: ifnull -75 -> 28
    //   106: aload_0
    //   107: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   110: invokevirtual 328	com/tencent/qqmini/sdk/cache/DiskLruCache:flush	()V
    //   113: iconst_0
    //   114: ireturn
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   120: iconst_0
    //   121: ireturn
    //   122: aload_0
    //   123: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   126: aload_1
    //   127: invokevirtual 335	com/tencent/qqmini/sdk/cache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/tencent/qqmini/sdk/cache/DiskLruCache$Editor;
    //   130: astore_3
    //   131: aload_3
    //   132: ifnull +13 -> 145
    //   135: aload_3
    //   136: iconst_0
    //   137: aload_2
    //   138: invokevirtual 341	com/tencent/qqmini/sdk/cache/DiskLruCache$Editor:set	(ILjava/lang/String;)V
    //   141: aload_3
    //   142: invokevirtual 344	com/tencent/qqmini/sdk/cache/DiskLruCache$Editor:commit	()V
    //   145: aload_0
    //   146: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   149: ifnull +42 -> 191
    //   152: aload_0
    //   153: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   156: aload_1
    //   157: aload_2
    //   158: invokevirtual 280	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   161: pop
    //   162: getstatic 40	com/tencent/qqmini/sdk/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   165: astore_1
    //   166: aload_1
    //   167: monitorenter
    //   168: aload_0
    //   169: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   172: ldc 11
    //   174: getstatic 40	com/tencent/qqmini/sdk/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   177: invokevirtual 126	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   180: invokeinterface 282 1 0
    //   185: idiv
    //   186: invokevirtual 230	android/util/LruCache:trimToSize	(I)V
    //   189: aload_1
    //   190: monitorexit
    //   191: aload_0
    //   192: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   195: ifnull +10 -> 205
    //   198: aload_0
    //   199: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   202: invokevirtual 328	com/tencent/qqmini/sdk/cache/DiskLruCache:flush	()V
    //   205: iconst_1
    //   206: ireturn
    //   207: astore_2
    //   208: aload_1
    //   209: monitorexit
    //   210: aload_2
    //   211: athrow
    //   212: astore_1
    //   213: ldc 15
    //   215: aload_1
    //   216: invokevirtual 107	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   219: aload_1
    //   220: invokestatic 110	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   223: aload_0
    //   224: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   227: ifnull -199 -> 28
    //   230: aload_0
    //   231: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   234: invokevirtual 328	com/tencent/qqmini/sdk/cache/DiskLruCache:flush	()V
    //   237: iconst_0
    //   238: ireturn
    //   239: astore_1
    //   240: aload_1
    //   241: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   244: iconst_0
    //   245: ireturn
    //   246: astore_1
    //   247: aload_1
    //   248: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   251: goto -46 -> 205
    //   254: astore_1
    //   255: aload_0
    //   256: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   259: ifnull +10 -> 269
    //   262: aload_0
    //   263: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   266: invokevirtual 328	com/tencent/qqmini/sdk/cache/DiskLruCache:flush	()V
    //   269: aload_1
    //   270: athrow
    //   271: astore_2
    //   272: aload_2
    //   273: invokevirtual 331	java/io/IOException:printStackTrace	()V
    //   276: goto -7 -> 269
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	Storage
    //   0	279	2	paramString2	String
    //   0	279	3	paramString3	String
    // Exception table:
    //   from	to	target	type
    //   0	6	30	java/lang/Throwable
    //   106	113	115	java/io/IOException
    //   168	191	207	finally
    //   208	210	207	finally
    //   63	99	212	java/lang/Throwable
    //   122	131	212	java/lang/Throwable
    //   135	145	212	java/lang/Throwable
    //   145	168	212	java/lang/Throwable
    //   210	212	212	java/lang/Throwable
    //   230	237	239	java/io/IOException
    //   198	205	246	java/io/IOException
    //   63	99	254	finally
    //   122	131	254	finally
    //   135	145	254	finally
    //   145	168	254	finally
    //   210	212	254	finally
    //   213	223	254	finally
    //   262	269	271	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.cache.Storage
 * JD-Core Version:    0.7.0.1
 */