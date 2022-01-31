package com.tencent.upload.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.upload.common.Const.UploadRetCode;
import com.tencent.upload.common.FileUtils;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.image.ImageCompressTask;
import com.tencent.upload.image.ImageProcessProxy;
import com.tencent.upload.image.ImageProcessProxy.ImageCompressorCallback;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadConfig.UploadImageSize;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.Utility;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class c
  extends a
{
  private static final AtomicInteger f = new AtomicInteger(10000);
  ImageProcessProxy.ImageCompressorCallback c = new ImageProcessProxy.ImageCompressorCallback()
  {
    public void onCompressFinish(int paramAnonymousInt, String arg2, String paramAnonymousString2)
    {
      paramAnonymousString2 = (AbstractUploadTask)c.b(c.this).get(paramAnonymousInt);
      if (paramAnonymousString2 != null)
      {
        if ((paramAnonymousString2 instanceof ImageUploadTask)) {
          ((ImageUploadTask)paramAnonymousString2).compressEndTime = System.currentTimeMillis();
        }
        com.tencent.upload.common.b.b("ImageUploadService", "Image compress complete,  originPath: " + paramAnonymousString2.getFilePath() + " tmpPath: " + ???);
        if (!TextUtils.isEmpty(???)) {
          break label220;
        }
        com.tencent.upload.common.b.b("ImageUploadService", "targetFilePath is empty !");
        ??? = paramAnonymousString2.getFilePath();
      }
      for (;;)
      {
        paramAnonymousString2.setTmpFilePath(???);
        com.tencent.upload.common.b.b("ImageUploadService", "taskId:" + paramAnonymousString2.flowId + ", final upload targetFilePath:" + ???);
        if (paramAnonymousString2.needWaitBatch())
        {
          c.b(c.this).remove(paramAnonymousInt);
          synchronized (c.c(c.this))
          {
            c.c(c.this).add(paramAnonymousString2);
            if ((c.c(c.this).size() >= c.this.f()) || (c.b(c.this).size() == 0)) {
              c.a(c.this);
            }
            return;
            label220:
            File localFile = new File(???);
            if (!localFile.exists())
            {
              com.tencent.upload.common.b.b("ImageUploadService", "targetFilePath file invalid !");
              ??? = paramAnonymousString2.getFilePath();
            }
            else if (localFile.length() <= 0L)
            {
              com.tencent.upload.common.b.b("ImageUploadService", "targetFilePath file size == 0 !");
              ??? = paramAnonymousString2.getFilePath();
            }
          }
        }
      }
      c.this.a.a(paramAnonymousString2);
      c.b(c.this).remove(paramAnonymousInt);
    }
    
    public void onPidObtained(int paramAnonymousInt)
    {
      c.a(c.this, paramAnonymousInt);
      com.tencent.upload.common.b.b("ImageUploadService", "ImageProcessProxy Service return Pid: " + paramAnonymousInt);
    }
    
    public void onServiceConnected()
    {
      com.tencent.upload.common.b.b("ImageUploadService", "ImageProcessProxy Service Connectted!");
    }
  };
  private ImageProcessProxy d = ImageProcessProxy.getInstance();
  private int e = 0;
  private SparseArray<AbstractUploadTask> g = new SparseArray();
  private List<AbstractUploadTask> h = new ArrayList();
  private Handler i;
  
  public c(com.tencent.upload.e.a.c paramc)
  {
    super(paramc);
    this.a = new g(paramc, e());
    new HandlerThread("image-upload-service").start();
    this.i = new Handler();
  }
  
  private final boolean a(int paramInt, String paramString1, String paramString2, IUploadConfig.UploadImageSize paramUploadImageSize, boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tencent.upload.common.b.b("ImageUploadService", "compressUploadTask[flowId: " + paramInt + ", path: " + paramString1 + ", md5: " + paramString2 + ", targetSize: " + paramUploadImageSize + ", autoRotate: " + paramBoolean1 + ", compressToWebp: " + paramBoolean2 + "]");
    paramString1 = new ImageCompressTask(paramInt, paramString1, paramString2, paramUploadImageSize, paramBoolean1, paramBoolean2);
    this.d.compressFile(paramString1, this.c);
    return true;
  }
  
  private void c(AbstractUploadTask paramAbstractUploadTask)
  {
    if ((paramAbstractUploadTask instanceof ImageUploadTask))
    {
      com.tencent.upload.common.b.d("ImageUploadService", "sendTask add task to queue: " + paramAbstractUploadTask.flowId);
      this.i.removeMessages(1000);
      this.h.add(paramAbstractUploadTask);
      paramAbstractUploadTask = Message.obtain(this.i, new Runnable()
      {
        public void run()
        {
          for (boolean bool = true; bool; bool = c.a(c.this)) {}
        }
      });
      paramAbstractUploadTask.what = 1000;
      this.i.sendMessageDelayed(paramAbstractUploadTask, 500L);
      return;
    }
    this.a.a(paramAbstractUploadTask);
  }
  
  private boolean d(AbstractUploadTask paramAbstractUploadTask)
  {
    Object localObject = paramAbstractUploadTask.getFilePath();
    if ((TextUtils.isEmpty((CharSequence)localObject)) || (!new File((String)localObject).exists()))
    {
      paramAbstractUploadTask.onError(Const.UploadRetCode.FILE_NOT_EXIST.getCode(), Const.UploadRetCode.FILE_NOT_EXIST.getDesc());
      com.tencent.upload.common.b.e("ImageUploadService", "upload error path invalid !");
      return false;
    }
    if (b.a((String)localObject))
    {
      b.a(paramAbstractUploadTask);
      this.a.a(paramAbstractUploadTask);
      return false;
    }
    boolean bool1;
    int j;
    if ((paramAbstractUploadTask instanceof ImageUploadTask))
    {
      bool1 = ((ImageUploadTask)paramAbstractUploadTask).autoRotate;
      j = ((ImageUploadTask)paramAbstractUploadTask).iUploadType;
    }
    for (;;)
    {
      IUploadConfig.UploadImageSize localUploadImageSize = b.a(paramAbstractUploadTask, j);
      if (localUploadImageSize == null) {
        break;
      }
      paramAbstractUploadTask.md5 = FileUtils.getMd5ByFile_REAL(new File((String)localObject));
      localObject = paramAbstractUploadTask.getUploadTaskType();
      int k;
      if ((localObject != null) && (((TaskTypeConfig)localObject).uploadType == 0))
      {
        k = 1;
        localObject = com.tencent.upload.common.a.b();
        if ((k == 0) || (!Utility.needCompress2Webp(((IUploadConfig)localObject).getCompressToWebpFlag(), j))) {
          break label221;
        }
      }
      label221:
      for (boolean bool2 = true;; bool2 = false)
      {
        if ((paramAbstractUploadTask instanceof ImageUploadTask)) {
          ((ImageUploadTask)paramAbstractUploadTask).compressStartTime = System.currentTimeMillis();
        }
        return a(paramAbstractUploadTask.flowId, paramAbstractUploadTask.getFilePath(), paramAbstractUploadTask.getMd5(), localUploadImageSize, bool1, bool2);
        k = 0;
        break;
      }
      j = 0;
      bool1 = false;
    }
  }
  
  /* Error */
  private boolean h()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_0
    //   5: monitorenter
    //   6: ldc 95
    //   8: ldc_w 294
    //   11: invokestatic 135	com/tencent/upload/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: aload_0
    //   15: getfield 68	com/tencent/upload/b/c:h	Ljava/util/List;
    //   18: invokeinterface 297 1 0
    //   23: istore_2
    //   24: iload_2
    //   25: ifgt +7 -> 32
    //   28: aload_0
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: aload_0
    //   33: invokevirtual 299	com/tencent/upload/b/c:f	()I
    //   36: istore_2
    //   37: ldc 95
    //   39: new 97	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   46: ldc_w 301
    //   49: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: getfield 68	com/tencent/upload/b/c:h	Ljava/util/List;
    //   56: invokeinterface 297 1 0
    //   61: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   64: ldc_w 303
    //   67: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_0
    //   71: getfield 63	com/tencent/upload/b/c:g	Landroid/util/SparseArray;
    //   74: invokevirtual 304	android/util/SparseArray:size	()I
    //   77: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   80: ldc_w 306
    //   83: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: iload_2
    //   87: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   90: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokestatic 135	com/tencent/upload/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: new 65	java/util/ArrayList
    //   99: dup
    //   100: invokespecial 66	java/util/ArrayList:<init>	()V
    //   103: astore 4
    //   105: aload_0
    //   106: getfield 68	com/tencent/upload/b/c:h	Ljava/util/List;
    //   109: astore 5
    //   111: aload 5
    //   113: monitorenter
    //   114: aload_0
    //   115: getfield 68	com/tencent/upload/b/c:h	Ljava/util/List;
    //   118: invokeinterface 297 1 0
    //   123: iload_2
    //   124: if_icmplt +33 -> 157
    //   127: iload_1
    //   128: iload_2
    //   129: if_icmpge +40 -> 169
    //   132: aload 4
    //   134: aload_0
    //   135: getfield 68	com/tencent/upload/b/c:h	Ljava/util/List;
    //   138: iload_1
    //   139: invokeinterface 310 2 0
    //   144: invokeinterface 171 2 0
    //   149: pop
    //   150: iload_1
    //   151: iconst_1
    //   152: iadd
    //   153: istore_1
    //   154: goto -27 -> 127
    //   157: aload 4
    //   159: aload_0
    //   160: getfield 68	com/tencent/upload/b/c:h	Ljava/util/List;
    //   163: invokeinterface 314 2 0
    //   168: pop
    //   169: aload_0
    //   170: getfield 68	com/tencent/upload/b/c:h	Ljava/util/List;
    //   173: aload 4
    //   175: invokeinterface 317 2 0
    //   180: pop
    //   181: aload 5
    //   183: monitorexit
    //   184: getstatic 34	com/tencent/upload/b/c:f	Ljava/util/concurrent/atomic/AtomicInteger;
    //   187: invokevirtual 320	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   190: istore_1
    //   191: aload 4
    //   193: invokeinterface 324 1 0
    //   198: astore 5
    //   200: aload 5
    //   202: invokeinterface 329 1 0
    //   207: ifeq +35 -> 242
    //   210: aload 5
    //   212: invokeinterface 333 1 0
    //   217: checkcast 157	com/tencent/upload/uinterface/AbstractUploadTask
    //   220: iload_1
    //   221: invokevirtual 336	com/tencent/upload/uinterface/AbstractUploadTask:setBatchId	(I)V
    //   224: goto -24 -> 200
    //   227: astore 4
    //   229: aload_0
    //   230: monitorexit
    //   231: aload 4
    //   233: athrow
    //   234: astore 4
    //   236: aload 5
    //   238: monitorexit
    //   239: aload 4
    //   241: athrow
    //   242: new 338	com/tencent/upload/uinterface/data/BatchControlTask
    //   245: dup
    //   246: aload 4
    //   248: aload_0
    //   249: getfield 57	com/tencent/upload/b/c:a	Lcom/tencent/upload/b/g;
    //   252: invokespecial 341	com/tencent/upload/uinterface/data/BatchControlTask:<init>	(Ljava/util/List;Lcom/tencent/upload/b/g;)V
    //   255: astore 4
    //   257: aload 4
    //   259: iload_1
    //   260: invokevirtual 342	com/tencent/upload/uinterface/data/BatchControlTask:setBatchId	(I)V
    //   263: aload_0
    //   264: getfield 57	com/tencent/upload/b/c:a	Lcom/tencent/upload/b/g;
    //   267: aload 4
    //   269: invokevirtual 190	com/tencent/upload/b/g:a	(Lcom/tencent/upload/uinterface/AbstractUploadTask;)Z
    //   272: pop
    //   273: ldc 95
    //   275: ldc_w 344
    //   278: invokestatic 135	com/tencent/upload/common/b:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: iconst_1
    //   282: istore_3
    //   283: goto -255 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	this	c
    //   1	259	1	j	int
    //   23	107	2	k	int
    //   3	280	3	bool	boolean
    //   103	89	4	localArrayList	ArrayList
    //   227	5	4	localObject1	Object
    //   234	13	4	localList	List
    //   255	13	4	localBatchControlTask	com.tencent.upload.uinterface.data.BatchControlTask
    // Exception table:
    //   from	to	target	type
    //   6	24	227	finally
    //   32	114	227	finally
    //   184	200	227	finally
    //   200	224	227	finally
    //   239	242	227	finally
    //   242	281	227	finally
    //   114	127	234	finally
    //   132	150	234	finally
    //   157	169	234	finally
    //   169	184	234	finally
    //   236	239	234	finally
  }
  
  protected boolean a()
  {
    return (this.g.size() == 0) && (this.a.d() == 0) && (this.h.size() == 0);
  }
  
  protected boolean a(AbstractUploadTask paramAbstractUploadTask)
  {
    int j = 0;
    if (paramAbstractUploadTask == null) {
      return false;
    }
    com.tencent.upload.common.b.d("ImageUploadService", "cancel task flowId: " + paramAbstractUploadTask.flowId + ", path:" + paramAbstractUploadTask.uploadFilePath);
    if (this.g.get(paramAbstractUploadTask.flowId) != null)
    {
      this.d.cancel(paramAbstractUploadTask.flowId);
      this.g.remove(paramAbstractUploadTask.flowId);
      com.tencent.upload.common.b.d("ImageUploadService", "cancel task from compress queue! flowId:" + paramAbstractUploadTask.flowId + ", path:" + paramAbstractUploadTask.uploadFilePath);
      j = 1;
    }
    label254:
    for (;;)
    {
      if (j == 0) {
        this.a.d(paramAbstractUploadTask);
      }
      h();
      return true;
      Iterator localIterator = this.h.iterator();
      AbstractUploadTask localAbstractUploadTask;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localAbstractUploadTask = (AbstractUploadTask)localIterator.next();
      } while (localAbstractUploadTask.flowId != paramAbstractUploadTask.flowId);
      for (;;)
      {
        if (localAbstractUploadTask == null) {
          break label254;
        }
        this.h.remove(localAbstractUploadTask);
        com.tencent.upload.common.b.d("ImageUploadService", "cancel task from ready queue! flowId:" + paramAbstractUploadTask.flowId + ", path:" + paramAbstractUploadTask.uploadFilePath);
        j = 1;
        break;
        localAbstractUploadTask = null;
      }
    }
  }
  
  protected void b()
  {
    this.a.c();
    this.g.clear();
    this.h.clear();
  }
  
  protected boolean b(AbstractUploadTask paramAbstractUploadTask)
  {
    if (paramAbstractUploadTask == null)
    {
      com.tencent.upload.common.b.e("ImageUploadService", "upload task == null !");
      return false;
    }
    paramAbstractUploadTask.onUploadProcessStart();
    int j;
    if ((paramAbstractUploadTask instanceof ImageUploadTask)) {
      if (((ImageUploadTask)paramAbstractUploadTask).iUploadType != 3)
      {
        j = 1;
        paramAbstractUploadTask.keepTmpFile(com.tencent.upload.common.a.h());
      }
    }
    for (;;)
    {
      SparseArray localSparseArray = this.g;
      if (j != 0) {
        try
        {
          if (UploadConfiguration.isPictureNeedToCompress(paramAbstractUploadTask.getFilePath()))
          {
            if (d(paramAbstractUploadTask)) {
              this.g.append(paramAbstractUploadTask.flowId, paramAbstractUploadTask);
            }
            return true;
          }
        }
        finally {}
      }
      c(paramAbstractUploadTask);
      return true;
      j = 0;
      break;
      j = 0;
    }
  }
  
  protected void c()
  {
    this.a.b();
    g();
  }
  
  public void g()
  {
    if (this.e == 0) {
      return;
    }
    ImageProcessProxy.close();
    Process.killProcess(this.e);
    com.tencent.upload.common.b.b("ImageUploadService", "kill compress process Pid:" + this.e);
    this.e = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.b.c
 * JD-Core Version:    0.7.0.1
 */