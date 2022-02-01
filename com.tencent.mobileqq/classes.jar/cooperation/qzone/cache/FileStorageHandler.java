package cooperation.qzone.cache;

import android.os.StatFs;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzoneResLoader;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class FileStorageHandler
  implements FileCacheService.StorageHandler
{
  private static final int COUNT_OF_HALF_INTERVAL = 6;
  private static final int MAX_WARN_INTERVAL = 1800000;
  private static final long MEGABYTES = 1048576L;
  private static final int MINUTE = 60000;
  private static final float STORAGE_EXIST_PERCENTAGE_OFFSET = 0.02F;
  private static final long STORAGE_LOW_BOUNDS = 20971520L;
  private static final int STORAGE_OP_INTERVAL = 2;
  private static final float STORAGE_REMAIN_PERCENTAGE = 0.1F;
  private static final float STORAGE_REMAIN_PERCENTAGE_EXTREME = 0.05F;
  private static final float STORAGE_WARNING_PERCENTAGE = 0.1F;
  private static Comparator<File> fileTimeComparator = new FileStorageHandler.3();
  private static FilenameFilter filenameFilter = new FileStorageHandler.2();
  private static final float remainSizeFactor = 0.8F;
  private final FileStorageHandler.Collector mCollector;
  private final AtomicInteger mCounter = new AtomicInteger(0);
  private long mLastWarnTime;
  private Future mPendingFuture;
  private int mWarnCount;
  
  public FileStorageHandler(FileStorageHandler.Collector paramCollector)
  {
    this.mCollector = paramCollector;
  }
  
  private int calculateRemainSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {
      return paramInt1;
    }
    float f1 = paramInt2;
    float f2 = paramInt1;
    if (f1 / f2 < 0.12F) {
      f1 = 0.05F;
    } else {
      f1 = 0.1F;
    }
    return (int)(f2 * f1);
  }
  
  private int calculateUsedSize(String paramString)
  {
    paramString = new File(paramString);
    boolean bool = paramString.exists();
    int k = 0;
    if ((bool) && (paramString.isDirectory()))
    {
      paramString = paramString.listFiles(filenameFilter);
      if ((paramString != null) && (paramString.length > 0)) {
        for (int i = 0;; i = j)
        {
          j = i;
          if (k >= paramString.length) {
            break;
          }
          j = i;
          if (paramString[k] != null)
          {
            j = i;
            if (paramString[k].getName() != null) {
              if (paramString[k].isDirectory()) {
                j = i + calculateUsedSize(paramString[k].getAbsolutePath());
              } else {
                j = (int)(i + paramString[k].length());
              }
            }
          }
          k += 1;
        }
      }
    }
    int j = 0;
    return j;
  }
  
  private long deleteFile(String paramString)
  {
    paramString = new File(paramString);
    boolean bool = paramString.exists();
    long l1 = 0L;
    long l2 = l1;
    if (bool)
    {
      if (paramString.isFile())
      {
        l1 = paramString.length();
        FileUtils.delete(paramString);
        return 0L + l1;
      }
      l2 = l1;
      if (paramString.isDirectory())
      {
        paramString = paramString.listFiles();
        int i = 0;
        for (;;)
        {
          l2 = l1;
          if (i >= paramString.length) {
            break;
          }
          l1 += deleteFile(paramString[i].getAbsolutePath());
          i += 1;
        }
      }
    }
    return l2;
  }
  
  public static boolean isStorageSizeLow(String paramString)
  {
    for (;;)
    {
      try
      {
        StatFs localStatFs = new StatFs(paramString);
        long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
        if (l < 20971520L)
        {
          bool = true;
          if (bool)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("low storage: totalSize=");
            localStringBuilder.append(localStatFs.getBlockCount() * localStatFs.getBlockSize());
            localStringBuilder.append(", availableSize=");
            localStringBuilder.append(l);
            localStringBuilder.append(", external=");
            localStringBuilder.append(paramString);
            QLog.w("CacheManager", 1, localStringBuilder.toString());
          }
          return bool;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("CacheManager", 1, "", paramString);
        return false;
      }
      boolean bool = false;
    }
  }
  
  private void notifyStorageWarning()
  {
    if (!shouldShowWarning()) {
      return;
    }
    QQToast.a(BaseApplication.getContext(), ((IQzoneResLoader)QRoute.api(IQzoneResLoader.class)).getStringId(1), 1).a();
  }
  
  private boolean shouldShowWarning()
  {
    long l1 = ((1.0F - 1.0F / (this.mWarnCount / 6.0F + 1.0F)) * 1800000.0F);
    long l2 = System.currentTimeMillis();
    boolean bool;
    if (l2 - this.mLastWarnTime >= l1) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      int i = this.mWarnCount;
      if (i < 2147483647) {
        this.mWarnCount = (i + 1);
      }
      this.mLastWarnTime = l2;
    }
    return bool;
  }
  
  /* Error */
  public void checkFileAndClean(String paramString, int paramInt)
  {
    // Byte code:
    //   0: new 93	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 100	java/io/File:exists	()Z
    //   13: ifeq +278 -> 291
    //   16: aload_1
    //   17: invokevirtual 103	java/io/File:isDirectory	()Z
    //   20: ifeq +271 -> 291
    //   23: aload_1
    //   24: getstatic 54	cooperation/qzone/cache/FileStorageHandler:filenameFilter	Ljava/io/FilenameFilter;
    //   27: invokevirtual 107	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   30: astore 11
    //   32: aload 11
    //   34: ifnull +257 -> 291
    //   37: aload 11
    //   39: arraylength
    //   40: ifle +251 -> 291
    //   43: iconst_0
    //   44: istore 4
    //   46: lconst_0
    //   47: lstore 5
    //   49: iconst_0
    //   50: istore_3
    //   51: iload_3
    //   52: aload 11
    //   54: arraylength
    //   55: if_icmpge +22 -> 77
    //   58: lload 5
    //   60: aload 11
    //   62: iload_3
    //   63: aaload
    //   64: invokevirtual 118	java/io/File:length	()J
    //   67: ladd
    //   68: lstore 5
    //   70: iload_3
    //   71: iconst_1
    //   72: iadd
    //   73: istore_3
    //   74: goto -23 -> 51
    //   77: lload 5
    //   79: iload_2
    //   80: i2l
    //   81: lcmp
    //   82: ifle +209 -> 291
    //   85: ldc 169
    //   87: iconst_1
    //   88: ldc 232
    //   90: invokestatic 178	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: iload_2
    //   94: i2f
    //   95: ldc 37
    //   97: fmul
    //   98: f2l
    //   99: lstore 9
    //   101: new 234	java/util/ArrayList
    //   104: dup
    //   105: aload 11
    //   107: arraylength
    //   108: invokespecial 235	java/util/ArrayList:<init>	(I)V
    //   111: astore_1
    //   112: iload 4
    //   114: istore_2
    //   115: iload_2
    //   116: aload 11
    //   118: arraylength
    //   119: if_icmpge +19 -> 138
    //   122: aload_1
    //   123: aload 11
    //   125: iload_2
    //   126: aaload
    //   127: invokevirtual 239	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   130: pop
    //   131: iload_2
    //   132: iconst_1
    //   133: iadd
    //   134: istore_2
    //   135: goto -20 -> 115
    //   138: aload_1
    //   139: getstatic 59	cooperation/qzone/cache/FileStorageHandler:fileTimeComparator	Ljava/util/Comparator;
    //   142: invokestatic 245	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   145: aload_1
    //   146: invokevirtual 248	java/util/ArrayList:size	()I
    //   149: iconst_1
    //   150: isub
    //   151: istore_2
    //   152: iload_2
    //   153: ifle +138 -> 291
    //   156: aload_1
    //   157: iload_2
    //   158: invokevirtual 252	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   161: checkcast 93	java/io/File
    //   164: astore 12
    //   166: aload 12
    //   168: invokevirtual 114	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   171: astore 11
    //   173: lload 5
    //   175: lstore 7
    //   177: aload 12
    //   179: invokevirtual 100	java/io/File:exists	()Z
    //   182: ifeq +19 -> 201
    //   185: lload 5
    //   187: aload 12
    //   189: invokevirtual 118	java/io/File:length	()J
    //   192: lsub
    //   193: lstore 7
    //   195: aload 12
    //   197: invokevirtual 254	java/io/File:delete	()Z
    //   200: pop
    //   201: new 150	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   208: astore 12
    //   210: aload 12
    //   212: aload 11
    //   214: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 12
    //   220: ldc_w 256
    //   223: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: new 93	java/io/File
    //   230: dup
    //   231: aload 12
    //   233: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   239: astore 11
    //   241: aload 11
    //   243: invokevirtual 100	java/io/File:exists	()Z
    //   246: ifeq +9 -> 255
    //   249: aload 11
    //   251: invokevirtual 254	java/io/File:delete	()Z
    //   254: pop
    //   255: lload 7
    //   257: lload 9
    //   259: lcmp
    //   260: ifge +4 -> 264
    //   263: return
    //   264: iload_2
    //   265: iconst_1
    //   266: isub
    //   267: istore_2
    //   268: lload 7
    //   270: lstore 5
    //   272: goto -120 -> 152
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 259	java/lang/Exception:printStackTrace	()V
    //   280: return
    //   281: astore_1
    //   282: ldc 169
    //   284: iconst_1
    //   285: ldc 180
    //   287: aload_1
    //   288: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   291: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	FileStorageHandler
    //   0	292	1	paramString	String
    //   0	292	2	paramInt	int
    //   50	24	3	i	int
    //   44	69	4	j	int
    //   47	224	5	l1	long
    //   175	94	7	l2	long
    //   99	159	9	l3	long
    //   30	220	11	localObject1	Object
    //   164	68	12	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   145	152	275	java/lang/Exception
    //   156	173	275	java/lang/Exception
    //   177	201	275	java/lang/Exception
    //   201	255	275	java/lang/Exception
    //   0	32	281	java/lang/Throwable
    //   37	43	281	java/lang/Throwable
    //   51	70	281	java/lang/Throwable
    //   85	93	281	java/lang/Throwable
    //   101	112	281	java/lang/Throwable
    //   115	131	281	java/lang/Throwable
    //   138	145	281	java/lang/Throwable
    //   145	152	281	java/lang/Throwable
    //   156	173	281	java/lang/Throwable
    //   177	201	281	java/lang/Throwable
    //   201	255	281	java/lang/Throwable
    //   276	280	281	java/lang/Throwable
  }
  
  public void cleanOldFile(int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      paramString = new File(paramString);
      long l2;
      if ((paramString.exists()) && (paramString.isDirectory()))
      {
        Object localObject = paramString.listFiles(filenameFilter);
        if ((localObject != null) && (localObject.length > 0))
        {
          paramString = new ArrayList(localObject.length);
          int i = 0;
          while (i < localObject.length)
          {
            paramString.add(localObject[i]);
            i += 1;
          }
          Collections.sort(paramString, fileTimeComparator);
          try
          {
            i = paramString.size() - 1;
            while (i > 0)
            {
              localObject = ((File)paramString.get(i)).getAbsolutePath();
              l2 = deleteFile((String)localObject);
              paramInt1 = (int)(paramInt1 - l2);
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(".headers");
              localObject = new File(localStringBuilder.toString());
              if (((File)localObject).exists()) {
                ((File)localObject).delete();
              }
              if (paramInt1 < paramInt2) {
                break;
              }
              i -= 1;
            }
            l2 = System.currentTimeMillis();
          }
          catch (Exception paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
      paramString = new StringBuilder();
      paramString.append("onLowStorage time:");
      paramString.append(l2 - l1);
      QLog.w("CacheManager", 1, paramString.toString());
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("CacheManager", 1, "", paramString);
    }
  }
  
  public void onCheckAndCleanStorage()
  {
    try
    {
      if ((this.mPendingFuture != null) && (!this.mPendingFuture.isDone())) {
        return;
      }
      boolean bool = CacheManager.isExternalAvailable();
      this.mPendingFuture = PriorityThreadPool.getDefault().submit(new FileStorageHandler.4(this, bool));
      return;
    }
    finally {}
  }
  
  public void onLowStorage(FileCacheService paramFileCacheService, boolean paramBoolean)
  {
    if (this.mCounter.getAndIncrement() < 2) {
      return;
    }
    this.mCounter.set(0);
    try
    {
      if ((this.mPendingFuture != null) && (!this.mPendingFuture.isDone())) {
        return;
      }
      this.mPendingFuture = PriorityThreadPool.getDefault().submit(new FileStorageHandler.1(this, paramBoolean));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.cache.FileStorageHandler
 * JD-Core Version:    0.7.0.1
 */