package cooperation.qzone.cache;

import android.os.StatFs;
import com.tencent.component.network.utils.FileUtils;
import com.tencent.component.network.utils.thread.Future;
import com.tencent.component.network.utils.thread.PriorityThreadPool;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
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
    if (paramInt2 / paramInt1 < 0.12F) {}
    for (float f = 0.05F;; f = 0.1F) {
      return (int)(f * paramInt1);
    }
  }
  
  private int calculateUsedSize(String paramString)
  {
    int j = 0;
    int k = 0;
    paramString = new File(paramString);
    int i = j;
    if (paramString.exists())
    {
      i = j;
      if (paramString.isDirectory())
      {
        paramString = paramString.listFiles(filenameFilter);
        i = j;
        if (paramString != null)
        {
          i = j;
          if (paramString.length > 0)
          {
            i = 0;
            if (k < paramString.length)
            {
              j = i;
              if (paramString[k] != null)
              {
                j = i;
                if (paramString[k].getName() != null) {
                  if (!paramString[k].isDirectory()) {
                    break label118;
                  }
                }
              }
              label118:
              for (j = i + calculateUsedSize(paramString[k].getAbsolutePath());; j = (int)(i + paramString[k].length()))
              {
                k += 1;
                i = j;
                break;
              }
            }
          }
        }
      }
    }
    return i;
  }
  
  private long deleteFile(String paramString)
  {
    long l2 = 0L;
    paramString = new File(paramString);
    long l1 = l2;
    if (paramString.exists())
    {
      if (!paramString.isFile()) {
        break label42;
      }
      l1 = 0L + paramString.length();
      FileUtils.delete(paramString);
    }
    label42:
    do
    {
      return l1;
      l1 = l2;
    } while (!paramString.isDirectory());
    paramString = paramString.listFiles();
    int i = 0;
    for (;;)
    {
      l1 = l2;
      if (i >= paramString.length) {
        break;
      }
      l2 += deleteFile(paramString[i].getAbsolutePath());
      i += 1;
    }
  }
  
  public static boolean isStorageSizeLow(String paramString)
  {
    try
    {
      StatFs localStatFs = new StatFs(paramString);
      long l = localStatFs.getAvailableBlocks() * localStatFs.getBlockSize();
      if (l < 20971520L) {}
      for (boolean bool = true;; bool = false)
      {
        if (bool) {
          QLog.w("CacheManager", 1, "low storage: totalSize=" + localStatFs.getBlockCount() * localStatFs.getBlockSize() + ", availableSize=" + l + ", external=" + paramString);
        }
        return bool;
      }
      return false;
    }
    catch (Throwable paramString)
    {
      QLog.e("CacheManager", 1, "", paramString);
    }
  }
  
  private void notifyStorageWarning()
  {
    if (!shouldShowWarning()) {
      return;
    }
    QQToast.a(BaseApplication.getContext(), 2131689937, 1).a();
  }
  
  private boolean shouldShowWarning()
  {
    long l1 = ((1.0F - 1.0F / (this.mWarnCount / 6.0F + 1.0F)) * 1800000.0F);
    long l2 = System.currentTimeMillis();
    if (l2 - this.mLastWarnTime >= l1) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        if (this.mWarnCount < 2147483647) {
          this.mWarnCount += 1;
        }
        this.mLastWarnTime = l2;
      }
      return bool;
    }
  }
  
  /* Error */
  public void checkFileAndClean(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: new 93	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore_1
    //   12: aload_1
    //   13: invokevirtual 100	java/io/File:exists	()Z
    //   16: ifeq +236 -> 252
    //   19: aload_1
    //   20: invokevirtual 103	java/io/File:isDirectory	()Z
    //   23: ifeq +229 -> 252
    //   26: aload_1
    //   27: getstatic 54	cooperation/qzone/cache/FileStorageHandler:filenameFilter	Ljava/io/FilenameFilter;
    //   30: invokevirtual 107	java/io/File:listFiles	(Ljava/io/FilenameFilter;)[Ljava/io/File;
    //   33: astore 11
    //   35: aload 11
    //   37: ifnull +215 -> 252
    //   40: aload 11
    //   42: arraylength
    //   43: ifle +209 -> 252
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
    //   82: ifle +170 -> 252
    //   85: ldc 150
    //   87: iconst_1
    //   88: ldc 221
    //   90: invokestatic 178	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   93: iload_2
    //   94: i2f
    //   95: ldc 37
    //   97: fmul
    //   98: f2l
    //   99: lstore 9
    //   101: new 223	java/util/ArrayList
    //   104: dup
    //   105: aload 11
    //   107: arraylength
    //   108: invokespecial 224	java/util/ArrayList:<init>	(I)V
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
    //   127: invokevirtual 228	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   130: pop
    //   131: iload_2
    //   132: iconst_1
    //   133: iadd
    //   134: istore_2
    //   135: goto -20 -> 115
    //   138: aload_1
    //   139: getstatic 59	cooperation/qzone/cache/FileStorageHandler:fileTimeComparator	Ljava/util/Comparator;
    //   142: invokestatic 234	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   145: aload_1
    //   146: invokevirtual 237	java/util/ArrayList:size	()I
    //   149: iconst_1
    //   150: isub
    //   151: istore_2
    //   152: iload_2
    //   153: ifle +99 -> 252
    //   156: aload_1
    //   157: iload_2
    //   158: invokevirtual 241	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   161: checkcast 93	java/io/File
    //   164: astore 11
    //   166: aload 11
    //   168: invokevirtual 114	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   171: astore 12
    //   173: lload 5
    //   175: lstore 7
    //   177: aload 11
    //   179: invokevirtual 100	java/io/File:exists	()Z
    //   182: ifeq +19 -> 201
    //   185: lload 5
    //   187: aload 11
    //   189: invokevirtual 118	java/io/File:length	()J
    //   192: lsub
    //   193: lstore 7
    //   195: aload 11
    //   197: invokevirtual 243	java/io/File:delete	()Z
    //   200: pop
    //   201: new 93	java/io/File
    //   204: dup
    //   205: new 152	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   212: aload 12
    //   214: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: ldc 245
    //   219: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokespecial 96	java/io/File:<init>	(Ljava/lang/String;)V
    //   228: astore 11
    //   230: aload 11
    //   232: invokevirtual 100	java/io/File:exists	()Z
    //   235: ifeq +9 -> 244
    //   238: aload 11
    //   240: invokevirtual 243	java/io/File:delete	()Z
    //   243: pop
    //   244: lload 7
    //   246: lload 9
    //   248: lcmp
    //   249: ifge +4 -> 253
    //   252: return
    //   253: iload_2
    //   254: iconst_1
    //   255: isub
    //   256: istore_2
    //   257: lload 7
    //   259: lstore 5
    //   261: goto -109 -> 152
    //   264: astore_1
    //   265: aload_1
    //   266: invokevirtual 248	java/lang/Exception:printStackTrace	()V
    //   269: return
    //   270: astore_1
    //   271: ldc 150
    //   273: iconst_1
    //   274: ldc 180
    //   276: aload_1
    //   277: invokestatic 184	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   280: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	FileStorageHandler
    //   0	281	1	paramString	String
    //   0	281	2	paramInt	int
    //   50	24	3	i	int
    //   1	112	4	j	int
    //   47	213	5	l1	long
    //   175	83	7	l2	long
    //   99	148	9	l3	long
    //   33	206	11	localObject	Object
    //   171	42	12	str	String
    // Exception table:
    //   from	to	target	type
    //   145	152	264	java/lang/Exception
    //   156	173	264	java/lang/Exception
    //   177	201	264	java/lang/Exception
    //   201	244	264	java/lang/Exception
    //   3	35	270	java/lang/Throwable
    //   40	46	270	java/lang/Throwable
    //   51	70	270	java/lang/Throwable
    //   85	93	270	java/lang/Throwable
    //   101	112	270	java/lang/Throwable
    //   115	131	270	java/lang/Throwable
    //   138	145	270	java/lang/Throwable
    //   145	152	270	java/lang/Throwable
    //   156	173	270	java/lang/Throwable
    //   177	201	270	java/lang/Throwable
    //   201	244	270	java/lang/Throwable
    //   265	269	270	java/lang/Throwable
  }
  
  public void cleanOldFile(int paramInt1, int paramInt2, String paramString)
  {
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        paramString = new File(paramString);
        Object localObject;
        int i;
        if ((paramString.exists()) && (paramString.isDirectory()))
        {
          localObject = paramString.listFiles(filenameFilter);
          if ((localObject != null) && (localObject.length > 0))
          {
            paramString = new ArrayList(localObject.length);
            i = 0;
            if (i < localObject.length)
            {
              paramString.add(localObject[i]);
              i += 1;
              continue;
            }
            Collections.sort(paramString, fileTimeComparator);
          }
        }
        try
        {
          int j = paramString.size() - 1;
          i = paramInt1;
          paramInt1 = j;
          if (paramInt1 > 0)
          {
            localObject = ((File)paramString.get(paramInt1)).getAbsolutePath();
            l2 = deleteFile((String)localObject);
            i = (int)(i - l2);
            localObject = new File((String)localObject + ".headers");
            if (((File)localObject).exists()) {
              ((File)localObject).delete();
            }
            if (i >= paramInt2) {
              break label247;
            }
          }
        }
        catch (Exception paramString)
        {
          long l2;
          paramString.printStackTrace();
          continue;
        }
        l2 = System.currentTimeMillis();
        QLog.w("CacheManager", 1, "onLowStorage time:" + (l2 - l1));
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("CacheManager", 1, "", paramString);
        return;
      }
      label247:
      paramInt1 -= 1;
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
    }
    finally {}
    this.mPendingFuture = PriorityThreadPool.getDefault().submit(new FileStorageHandler.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.cache.FileStorageHandler
 * JD-Core Version:    0.7.0.1
 */