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
  
  /* Error */
  private boolean commitCache(String arg1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +130 -> 134
    //   7: aload_0
    //   8: invokevirtual 131	com/tencent/qqmini/sdk/cache/Storage:getCurrentSize	()J
    //   11: ldc2_w 132
    //   14: lmul
    //   15: aload_2
    //   16: invokevirtual 139	java/lang/String:length	()I
    //   19: i2l
    //   20: ladd
    //   21: ldc2_w 80
    //   24: lcmp
    //   25: ifle +32 -> 57
    //   28: ldc 15
    //   30: ldc 141
    //   32: invokestatic 104	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +14 -> 55
    //   44: aload_1
    //   45: invokevirtual 144	com/tencent/qqmini/sdk/cache/DiskLruCache:flush	()V
    //   48: iconst_1
    //   49: ireturn
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   55: iconst_1
    //   56: ireturn
    //   57: aload_0
    //   58: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   61: aload_1
    //   62: invokevirtual 151	com/tencent/qqmini/sdk/cache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/tencent/qqmini/sdk/cache/DiskLruCache$Editor;
    //   65: astore_3
    //   66: aload_3
    //   67: ifnull +13 -> 80
    //   70: aload_3
    //   71: iconst_0
    //   72: aload_2
    //   73: invokevirtual 157	com/tencent/qqmini/sdk/cache/DiskLruCache$Editor:set	(ILjava/lang/String;)V
    //   76: aload_3
    //   77: invokevirtual 160	com/tencent/qqmini/sdk/cache/DiskLruCache$Editor:commit	()V
    //   80: aload_0
    //   81: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   84: ifnull +50 -> 134
    //   87: aload_0
    //   88: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   91: aload_1
    //   92: aload_2
    //   93: invokevirtual 166	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   96: pop
    //   97: getstatic 40	com/tencent/qqmini/sdk/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   100: astore_1
    //   101: aload_1
    //   102: monitorenter
    //   103: aload_0
    //   104: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   107: ldc 11
    //   109: getstatic 40	com/tencent/qqmini/sdk/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   112: invokevirtual 170	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   115: invokeinterface 175 1 0
    //   120: idiv
    //   121: invokevirtual 179	android/util/LruCache:trimToSize	(I)V
    //   124: aload_1
    //   125: monitorexit
    //   126: goto +8 -> 134
    //   129: astore_2
    //   130: aload_1
    //   131: monitorexit
    //   132: aload_2
    //   133: athrow
    //   134: aload_0
    //   135: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   138: astore_1
    //   139: aload_1
    //   140: ifnull +14 -> 154
    //   143: aload_1
    //   144: invokevirtual 144	com/tencent/qqmini/sdk/cache/DiskLruCache:flush	()V
    //   147: iconst_0
    //   148: ireturn
    //   149: astore_1
    //   150: aload_1
    //   151: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   154: iconst_0
    //   155: ireturn
    //   156: astore_1
    //   157: goto +36 -> 193
    //   160: astore_1
    //   161: ldc 15
    //   163: aload_1
    //   164: invokevirtual 107	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   167: aload_1
    //   168: invokestatic 110	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   171: aload_0
    //   172: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   175: astore_1
    //   176: aload_1
    //   177: ifnull +14 -> 191
    //   180: aload_1
    //   181: invokevirtual 144	com/tencent/qqmini/sdk/cache/DiskLruCache:flush	()V
    //   184: iconst_1
    //   185: ireturn
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   191: iconst_1
    //   192: ireturn
    //   193: aload_0
    //   194: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   197: astore_2
    //   198: aload_2
    //   199: ifnull +15 -> 214
    //   202: aload_2
    //   203: invokevirtual 144	com/tencent/qqmini/sdk/cache/DiskLruCache:flush	()V
    //   206: goto +8 -> 214
    //   209: astore_2
    //   210: aload_2
    //   211: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   214: aload_1
    //   215: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	Storage
    //   0	216	2	paramString2	String
    //   65	12	3	localEditor	DiskLruCache.Editor
    // Exception table:
    //   from	to	target	type
    //   44	48	50	java/io/IOException
    //   103	126	129	finally
    //   130	132	129	finally
    //   143	147	149	java/io/IOException
    //   0	35	156	finally
    //   57	66	156	finally
    //   70	80	156	finally
    //   80	103	156	finally
    //   132	134	156	finally
    //   161	171	156	finally
    //   0	35	160	java/lang/Throwable
    //   57	66	160	java/lang/Throwable
    //   70	80	160	java/lang/Throwable
    //   80	103	160	java/lang/Throwable
    //   132	134	160	java/lang/Throwable
    //   180	184	186	java/io/IOException
    //   202	206	209	java/io/IOException
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
      mMapList.clear();
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  /* Error */
  private void flushCache(String arg1, Storage.StorageCallback paramStorageCallback, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +127 -> 131
    //   7: aload_0
    //   8: invokevirtual 131	com/tencent/qqmini/sdk/cache/Storage:getCurrentSize	()J
    //   11: ldc2_w 132
    //   14: lmul
    //   15: aload_1
    //   16: invokevirtual 139	java/lang/String:length	()I
    //   19: i2l
    //   20: ladd
    //   21: ldc2_w 80
    //   24: lcmp
    //   25: ifle +23 -> 48
    //   28: ldc 15
    //   30: ldc 141
    //   32: invokestatic 104	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_2
    //   36: ifnull +12 -> 48
    //   39: aload_2
    //   40: aload_3
    //   41: ldc 141
    //   43: invokeinterface 211 3 0
    //   48: aload_0
    //   49: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   52: aload_3
    //   53: invokevirtual 151	com/tencent/qqmini/sdk/cache/DiskLruCache:edit	(Ljava/lang/String;)Lcom/tencent/qqmini/sdk/cache/DiskLruCache$Editor;
    //   56: astore 4
    //   58: aload 4
    //   60: ifnull +15 -> 75
    //   63: aload 4
    //   65: iconst_0
    //   66: aload_1
    //   67: invokevirtual 157	com/tencent/qqmini/sdk/cache/DiskLruCache$Editor:set	(ILjava/lang/String;)V
    //   70: aload 4
    //   72: invokevirtual 160	com/tencent/qqmini/sdk/cache/DiskLruCache$Editor:commit	()V
    //   75: aload_0
    //   76: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   79: ifnull +52 -> 131
    //   82: aload_0
    //   83: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   86: aload_3
    //   87: aload_1
    //   88: invokevirtual 166	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   91: pop
    //   92: getstatic 40	com/tencent/qqmini/sdk/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   95: astore_1
    //   96: aload_1
    //   97: monitorenter
    //   98: aload_0
    //   99: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   102: ldc 11
    //   104: getstatic 40	com/tencent/qqmini/sdk/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   107: invokevirtual 170	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   110: invokeinterface 175 1 0
    //   115: idiv
    //   116: invokevirtual 179	android/util/LruCache:trimToSize	(I)V
    //   119: aload_1
    //   120: monitorexit
    //   121: goto +10 -> 131
    //   124: astore 4
    //   126: aload_1
    //   127: monitorexit
    //   128: aload 4
    //   130: athrow
    //   131: aload_2
    //   132: ifnull +12 -> 144
    //   135: aload_2
    //   136: aload_3
    //   137: ldc 213
    //   139: invokeinterface 216 3 0
    //   144: aload_0
    //   145: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   148: astore_1
    //   149: aload_1
    //   150: ifnull +57 -> 207
    //   153: aload_1
    //   154: invokevirtual 144	com/tencent/qqmini/sdk/cache/DiskLruCache:flush	()V
    //   157: return
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 217	java/lang/Throwable:printStackTrace	()V
    //   163: return
    //   164: astore_1
    //   165: goto +43 -> 208
    //   168: astore_1
    //   169: aload_2
    //   170: ifnull +14 -> 184
    //   173: aload_2
    //   174: aload_3
    //   175: aload_1
    //   176: invokevirtual 107	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   179: invokeinterface 211 3 0
    //   184: ldc 15
    //   186: aload_1
    //   187: invokevirtual 107	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   190: aload_1
    //   191: invokestatic 110	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   194: aload_0
    //   195: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   198: astore_1
    //   199: aload_1
    //   200: ifnull +7 -> 207
    //   203: aload_1
    //   204: invokevirtual 144	com/tencent/qqmini/sdk/cache/DiskLruCache:flush	()V
    //   207: return
    //   208: aload_0
    //   209: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   212: astore_2
    //   213: aload_2
    //   214: ifnull +15 -> 229
    //   217: aload_2
    //   218: invokevirtual 144	com/tencent/qqmini/sdk/cache/DiskLruCache:flush	()V
    //   221: goto +8 -> 229
    //   224: astore_2
    //   225: aload_2
    //   226: invokevirtual 217	java/lang/Throwable:printStackTrace	()V
    //   229: aload_1
    //   230: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	Storage
    //   0	231	2	paramStorageCallback	Storage.StorageCallback
    //   0	231	3	paramString2	String
    //   56	15	4	localEditor	DiskLruCache.Editor
    //   124	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   98	121	124	finally
    //   126	128	124	finally
    //   153	157	158	java/lang/Throwable
    //   203	207	158	java/lang/Throwable
    //   0	35	164	finally
    //   39	48	164	finally
    //   48	58	164	finally
    //   63	75	164	finally
    //   75	98	164	finally
    //   128	131	164	finally
    //   135	144	164	finally
    //   173	184	164	finally
    //   184	194	164	finally
    //   0	35	168	java/lang/Throwable
    //   39	48	168	java/lang/Throwable
    //   48	58	168	java/lang/Throwable
    //   63	75	168	java/lang/Throwable
    //   75	98	168	java/lang/Throwable
    //   128	131	168	java/lang/Throwable
    //   135	144	168	java/lang/Throwable
    //   217	221	224	java/lang/Throwable
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
      QMLog.i("Storage", paramString2.toString());
      return paramString1;
    }
    return null;
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
          synchronized (LOCK)
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
          QMLog.e("Storage", localThrowable.getMessage(), localThrowable);
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
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("Storage", localThrowable.getMessage(), localThrowable);
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
        QMLog.e("Storage", "------mDiskCache.closed-----");
        this.mDiskCache.close();
      }
      catch (Throwable localThrowable)
      {
        QMLog.e("Storage", localThrowable.getMessage(), localThrowable);
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
    //   1: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 6
    //   8: aload 6
    //   10: astore_2
    //   11: aload_3
    //   12: ifnull +244 -> 256
    //   15: aload_3
    //   16: aload_1
    //   17: invokevirtual 322	android/util/LruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 135	java/lang/String
    //   23: astore_2
    //   24: aload_2
    //   25: astore_3
    //   26: aload_2
    //   27: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   30: ifeq +211 -> 241
    //   33: aload_0
    //   34: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   37: astore 4
    //   39: aload_2
    //   40: astore_3
    //   41: aload 4
    //   43: ifnull +198 -> 241
    //   46: aload 4
    //   48: invokevirtual 314	com/tencent/qqmini/sdk/cache/DiskLruCache:isClosed	()Z
    //   51: ifeq +7 -> 58
    //   54: aload_0
    //   55: invokespecial 117	com/tencent/qqmini/sdk/cache/Storage:reCreateCache	()V
    //   58: aload_0
    //   59: getfield 89	com/tencent/qqmini/sdk/cache/Storage:mDiskCache	Lcom/tencent/qqmini/sdk/cache/DiskLruCache;
    //   62: aload_1
    //   63: invokevirtual 325	com/tencent/qqmini/sdk/cache/DiskLruCache:get	(Ljava/lang/String;)Lcom/tencent/qqmini/sdk/cache/DiskLruCache$Snapshot;
    //   66: astore 5
    //   68: aload_2
    //   69: astore 4
    //   71: aload 5
    //   73: ifnull +96 -> 169
    //   76: aload 5
    //   78: astore_3
    //   79: aload 5
    //   81: iconst_0
    //   82: invokevirtual 331	com/tencent/qqmini/sdk/cache/DiskLruCache$Snapshot:getString	(I)Ljava/lang/String;
    //   85: astore 4
    //   87: aload 4
    //   89: astore_2
    //   90: aload 5
    //   92: astore_3
    //   93: aload_0
    //   94: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   97: aload_1
    //   98: aload 4
    //   100: invokevirtual 166	android/util/LruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   103: pop
    //   104: aload 4
    //   106: astore_2
    //   107: aload 5
    //   109: astore_3
    //   110: getstatic 40	com/tencent/qqmini/sdk/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   113: astore_1
    //   114: aload 4
    //   116: astore_2
    //   117: aload 5
    //   119: astore_3
    //   120: aload_1
    //   121: monitorenter
    //   122: aload_0
    //   123: getfield 96	com/tencent/qqmini/sdk/cache/Storage:mLruCache	Landroid/util/LruCache;
    //   126: ldc 11
    //   128: getstatic 40	com/tencent/qqmini/sdk/cache/Storage:mMapList	Ljava/util/concurrent/ConcurrentHashMap;
    //   131: invokevirtual 170	java/util/concurrent/ConcurrentHashMap:keySet	()Ljava/util/Set;
    //   134: invokeinterface 175 1 0
    //   139: idiv
    //   140: invokevirtual 179	android/util/LruCache:trimToSize	(I)V
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
    //   184: invokevirtual 332	com/tencent/qqmini/sdk/cache/DiskLruCache$Snapshot:close	()V
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
    //   209: ldc 15
    //   211: aload 4
    //   213: invokevirtual 107	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   216: aload 4
    //   218: invokestatic 110	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   221: aload_2
    //   222: astore_3
    //   223: aload_1
    //   224: ifnull +17 -> 241
    //   227: goto -44 -> 183
    //   230: astore_1
    //   231: aload_3
    //   232: ifnull +7 -> 239
    //   235: aload_3
    //   236: invokevirtual 332	com/tencent/qqmini/sdk/cache/DiskLruCache$Snapshot:close	()V
    //   239: aload_1
    //   240: athrow
    //   241: aload 6
    //   243: astore_2
    //   244: aload_3
    //   245: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   248: ifne +8 -> 256
    //   251: aload_3
    //   252: invokestatic 337	com/tencent/qqmini/sdk/cache/DiskLruCacheUtil:decode	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   203	14	4	localThrowable3	Throwable
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
        }
        catch (Throwable paramString)
        {
          QMLog.e("Storage", paramString.getMessage(), paramString);
          return false;
        }
      }
      return true;
    }
    return false;
  }
  
  public void write(String paramString1, String paramString2, String paramString3, Storage.StorageCallback paramStorageCallback)
  {
    ThreadManager.executeOnDiskIOThreadPool(new Storage.2(this, paramString2, paramString3, paramStorageCallback, paramString1));
  }
  
  public boolean writeSync(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString2 = DiskLruCacheUtil.encode(paramString3, paramString2);
      if ((paramString2 != null) && (paramString2.length() >= 1048576))
      {
        QMLog.e("Storage", "exceeded the limit size");
        return false;
      }
      paramString3 = this.mDiskCache;
      if (paramString3 != null)
      {
        if (paramString3.isClosed()) {
          reCreateCache();
        }
        if (commitCache(paramString1, paramString2)) {
          return false;
        }
      }
      return true;
    }
    catch (Throwable paramString1)
    {
      QMLog.e("Storage", "data encode failed.", paramString1);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.cache.Storage
 * JD-Core Version:    0.7.0.1
 */