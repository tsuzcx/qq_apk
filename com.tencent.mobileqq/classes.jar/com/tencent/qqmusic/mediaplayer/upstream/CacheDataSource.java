package com.tencent.qqmusic.mediaplayer.upstream;

import android.annotation.SuppressLint;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.DataRangeTracker;
import com.tencent.qqmusic.mediaplayer.downstream.IDataSink;
import com.tencent.qqmusic.mediaplayer.formatdetector.FormatDetector;
import com.tencent.qqmusic.mediaplayer.perf.Collectable;
import com.tencent.qqmusic.mediaplayer.perf.ErrorUploadCollector;
import com.tencent.qqmusic.mediaplayer.perf.PlayerInfoCollector;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Timer;
import java.util.TimerTask;

public class CacheDataSource
  implements Collectable, IDataSource
{
  private static final int CHUNK_LOAD_BUFFER_SIZE = 8192;
  private static final int DISCONTINUITY_THRESHOLD = 8192;
  static final long NO_RESET_PENDING = -9223372036854775808L;
  private static final int PROFILE_ending = 10;
  private static final int PROFILE_isCached = 8;
  private static final int PROFILE_lock = 5;
  private static final int PROFILE_onBufferEnd = 7;
  private static final int PROFILE_onBufferStarted = 4;
  private static final int PROFILE_onBytesTransferred = 9;
  private static final int PROFILE_onBytesTransferring = 3;
  private static final int PROFILE_onReadContinuity = 1;
  private static final int PROFILE_onReadDiscontinuity = 2;
  private static final int PROFILE_readAt = 6;
  private static final int PROFILE_total = 0;
  private static final int READ_WAIT_TIMEOUT = 30000;
  private static final String TAG = "CacheDataSource";
  private static final String[] profiles = { "total", "onReadContinuity", "onReadDiscontinuity", "onBytesTransferring", "onBufferStarted", "lock", "readAt", "onBufferEnd", "isCached", "onBytesTransferred", "ending" };
  @NonNull
  private final IDataSource cacheSource;
  @NonNull
  private final DataRangeTracker cachedDataTracker;
  private long[] costs = new long[profiles.length];
  private long currentLoadStartPosition = -9223372036854775808L;
  @Nullable
  private Chunk currentLoadingChunk;
  @Nullable
  private CacheDataSource.Listener listener;
  private boolean loadFinished;
  private final Loader loader;
  private long nextContinuousPosition;
  private boolean opened;
  protected long pendingRestartPositionByte;
  protected long pendingStartPositionByte;
  private TimerTask pendingTask;
  private Timer restartHandler;
  
  public CacheDataSource(@NonNull IDataSource paramIDataSource1, @NonNull IDataSource paramIDataSource2, @NonNull IDataSink paramIDataSink, @NonNull Looper paramLooper)
  {
    this(paramIDataSource2, new CacheDataSource.1(paramLooper, paramIDataSource1, paramIDataSink));
  }
  
  public CacheDataSource(@NonNull IDataSource paramIDataSource, @NonNull Loader.Factory paramFactory)
  {
    this.cacheSource = paramIDataSource;
    this.cachedDataTracker = new DataRangeTracker();
    this.opened = false;
    this.loadFinished = false;
    this.loader = paramFactory.createLoader(new CacheDataSource.LoaderListener(this, null));
  }
  
  private void clearState()
  {
    this.loadFinished = false;
  }
  
  private boolean isCached(long paramLong, int paramInt)
  {
    long l2 = this.loader.getUpstreamSize();
    long l1 = paramLong;
    int i = paramInt;
    if (l2 > 0L)
    {
      l1 = paramLong;
      i = paramInt;
      if (paramInt + paramLong > l2 - 1L)
      {
        paramInt = (int)(l2 - paramLong - 1L);
        l1 = paramLong;
        i = paramInt;
        if (paramInt < 0)
        {
          l1 = paramLong + paramInt;
          i = 0;
        }
      }
    }
    return this.cachedDataTracker.isCached(l1, i);
  }
  
  private void onReadContinuity(long paramLong) {}
  
  private void onReadDiscontinuity(long paramLong, boolean paramBoolean)
  {
    long l = this.currentLoadStartPosition;
    if (paramLong == l) {
      return;
    }
    l = paramLong - l;
    if ((l >= 0L) && (l < 8192L)) {
      return;
    }
    synchronized (this.cachedDataTracker)
    {
      paramLong = Math.max(paramLong, this.cachedDataTracker.findStart(paramLong));
      l = this.currentLoadStartPosition;
      if (l == paramLong) {
        return;
      }
      l = paramLong - l;
      if ((l >= 0L) && (l < 8192L)) {
        return;
      }
      if (paramLong == getSize()) {
        return;
      }
      ??? = this.currentLoadingChunk;
      if ((paramBoolean) && (??? != null) && (((Chunk)???).contains(paramLong))) {
        return;
      }
      restartLoading(paramLong);
      return;
    }
  }
  
  private void reportProfiling() {}
  
  private void restartLoading(long paramLong)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[restartLoading] from: ");
      localStringBuilder.append(paramLong);
      Logger.i("CacheDataSource", localStringBuilder.toString());
      this.pendingStartPositionByte = paramLong;
      this.loadFinished = false;
      if (this.loader.isLoading())
      {
        this.cachedDataTracker.block();
        this.loader.cancelLoading();
      }
      else
      {
        clearState();
        startLoadingIfNeeded();
      }
      return;
    }
    finally {}
  }
  
  @SuppressLint({"DefaultLocale"})
  private void scheduleRestart(long paramLong1, long paramLong2)
  {
    try
    {
      Logger.i("CacheDataSource", String.format("[scheduleRestart] position: %d, delay: %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
      if (this.restartHandler == null) {
        this.restartHandler = new Timer("CacheDataSource.Restart");
      }
      if (this.pendingTask != null)
      {
        this.pendingTask.cancel();
        this.restartHandler.purge();
      }
      this.pendingTask = new CacheDataSource.2(this, paramLong1);
      this.restartHandler.schedule(this.pendingTask, paramLong2);
      return;
    }
    finally {}
  }
  
  private boolean startLoadingIfNeeded()
  {
    try
    {
      boolean bool = this.loadFinished;
      if (bool) {
        return false;
      }
      long l = this.pendingStartPositionByte;
      this.pendingStartPositionByte = -9223372036854775808L;
      Object localObject1;
      if (!this.opened)
      {
        if (l == -9223372036854775808L)
        {
          Logger.i("CacheDataSource", "[startLoadingIfNeeded] start a fresh load");
          localObject1 = new Chunk(8192, 0L, -1L);
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[startLoadingIfNeeded] start a pending load: ");
          ((StringBuilder)localObject1).append(l);
          Logger.i("CacheDataSource", ((StringBuilder)localObject1).toString());
          localObject1 = new Chunk(8192, l, -1L);
        }
      }
      else
      {
        if (l == -9223372036854775808L) {
          break label219;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[startLoadingIfNeeded] restart a pending load: ");
        ((StringBuilder)localObject1).append(l);
        Logger.i("CacheDataSource", ((StringBuilder)localObject1).toString());
        localObject1 = new Chunk(8192, l, -1L);
      }
      this.currentLoadingChunk = ((Chunk)localObject1);
      this.currentLoadStartPosition = ((Chunk)localObject1).start;
      this.cachedDataTracker.unblock();
      this.loader.startLoading((Chunk)localObject1);
      return true;
      label219:
      throw new IllegalStateException("pendingStartPositionByte must be set!");
    }
    finally {}
  }
  
  public void accept(@NonNull ErrorUploadCollector paramErrorUploadCollector) {}
  
  public void accept(@NonNull PlayerInfoCollector paramPlayerInfoCollector)
  {
    int k = 1;
    long l = 0L;
    int i = 1;
    while (i < profiles.length)
    {
      l += this.costs[i];
      i += 1;
    }
    Object localObject = this.costs;
    double d1 = localObject[0] - l;
    double d2 = localObject.length;
    Double.isNaN(d1);
    Double.isNaN(d2);
    d1 /= d2;
    long[] arrayOfLong = new long[localObject.length];
    System.arraycopy(localObject, 0, arrayOfLong, 0, localObject.length);
    i = 1;
    int j;
    for (;;)
    {
      j = k;
      if (i >= arrayOfLong.length) {
        break;
      }
      arrayOfLong[i] = Math.max(arrayOfLong[i] - d1, 0L);
      l = arrayOfLong[i];
      i += 1;
    }
    while (j < profiles.length)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("CacheDataSource.");
      ((StringBuilder)localObject).append(profiles[j]);
      paramPlayerInfoCollector.putLong(((StringBuilder)localObject).toString(), arrayOfLong[j] / 1000000L);
      j += 1;
    }
  }
  
  public void close()
  {
    Logger.i("CacheDataSource", "[close] enter.");
    if (!this.opened) {
      return;
    }
    this.cachedDataTracker.abandonLock();
    try
    {
      this.loader.shutdown();
      label32:
      this.cacheSource.close();
      CacheDataSource.Listener localListener = this.listener;
      if (localListener != null) {
        localListener.onTransferEnd();
      }
      reportProfiling();
      this.opened = false;
      Logger.i("CacheDataSource", "[close] exit");
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label32;
    }
  }
  
  public boolean continueLoadIfNeeded()
  {
    try
    {
      if (!this.opened)
      {
        Logger.w("CacheDataSource", "[continueLoadIfNeeded] not opened!");
        return false;
      }
      long l = this.pendingRestartPositionByte;
      if (l == -9223372036854775808L) {
        return false;
      }
      boolean bool = this.loadFinished;
      if (bool) {
        return false;
      }
      l = this.pendingRestartPositionByte;
      this.pendingRestartPositionByte = -9223372036854775808L;
      scheduleRestart(l, 0L);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[continueLoadIfNeeded] schedule restart from: ");
      localStringBuilder.append(l);
      Logger.i("CacheDataSource", localStringBuilder.toString());
      return true;
    }
    finally {}
  }
  
  public AudioFormat.AudioType getAudioType()
  {
    return FormatDetector.getAudioFormat(this, false);
  }
  
  protected long getBufferTimeout(long paramLong, int paramInt)
  {
    return 30000L;
  }
  
  @NonNull
  public Loader getLoader()
  {
    return this.loader;
  }
  
  public long getSize()
  {
    Loader localLoader = this.loader;
    if (localLoader != null) {
      return localLoader.getUpstreamSize();
    }
    return 0L;
  }
  
  public boolean isCacheFileComplete()
  {
    long l1 = this.cachedDataTracker.getContinuousStart();
    long l2 = this.cachedDataTracker.getContinuousEnd();
    return (l2 != -1L) && (l2 == this.loader.getUpstreamSize() - 1L) && (l1 == 0L);
  }
  
  public void open()
  {
    Logger.i("CacheDataSource", "[open] enter.");
    if (this.opened) {
      return;
    }
    this.nextContinuousPosition = 0L;
    this.pendingRestartPositionByte = -9223372036854775808L;
    this.cacheSource.open();
    this.loader.prepare();
    startLoadingIfNeeded();
    CacheDataSource.Listener localListener = this.listener;
    if (localListener != null) {
      localListener.onTransferStart();
    }
    this.opened = true;
    Logger.i("CacheDataSource", "[open] exit");
  }
  
  /* Error */
  public int readAt(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: iflt +500 -> 503
    //   6: aload_0
    //   7: getfield 124	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:cachedDataTracker	Lcom/tencent/qqmusic/mediaplayer/DataRangeTracker;
    //   10: aload_0
    //   11: invokevirtual 201	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:getSize	()J
    //   14: invokevirtual 412	com/tencent/qqmusic/mediaplayer/DataRangeTracker:setFileTotalSize	(J)V
    //   17: aload_0
    //   18: lload_1
    //   19: iload 5
    //   21: invokespecial 413	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:isCached	(JI)Z
    //   24: istore 8
    //   26: lload_1
    //   27: aload_0
    //   28: getfield 396	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:nextContinuousPosition	J
    //   31: lcmp
    //   32: ifne +11 -> 43
    //   35: aload_0
    //   36: lload_1
    //   37: invokespecial 415	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:onReadContinuity	(J)V
    //   40: goto +10 -> 50
    //   43: aload_0
    //   44: lload_1
    //   45: iload 8
    //   47: invokespecial 417	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:onReadDiscontinuity	(JZ)V
    //   50: aload_0
    //   51: getfield 167	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:listener	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$Listener;
    //   54: ifnull +16 -> 70
    //   57: aload_0
    //   58: getfield 167	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:listener	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$Listener;
    //   61: lload_1
    //   62: iload 5
    //   64: i2l
    //   65: invokeinterface 419 5 0
    //   70: iload 8
    //   72: ifeq +534 -> 606
    //   75: aload_0
    //   76: getfield 119	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:cacheSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   79: lload_1
    //   80: aload_3
    //   81: iload 4
    //   83: iload 5
    //   85: invokeinterface 421 6 0
    //   90: istore 6
    //   92: goto +3 -> 95
    //   95: iload 6
    //   97: istore 7
    //   99: iload 6
    //   101: ifge +253 -> 354
    //   104: aload_0
    //   105: getfield 141	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:loader	Lcom/tencent/qqmusic/mediaplayer/upstream/Loader;
    //   108: invokeinterface 235 1 0
    //   113: istore 8
    //   115: iload 8
    //   117: ifne +84 -> 201
    //   120: aload_0
    //   121: getfield 119	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:cacheSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   124: lload_1
    //   125: aload_3
    //   126: iload 4
    //   128: iload 5
    //   130: invokeinterface 421 6 0
    //   135: istore 7
    //   137: new 210	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   144: astore_3
    //   145: aload_3
    //   146: ldc_w 423
    //   149: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: aload_3
    //   154: lload_1
    //   155: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_3
    //   160: ldc_w 425
    //   163: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_3
    //   168: iload 5
    //   170: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload_3
    //   175: ldc_w 430
    //   178: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_3
    //   183: iload 7
    //   185: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: ldc 44
    //   191: aload_3
    //   192: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   195: invokestatic 433	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   198: goto +156 -> 354
    //   201: new 210	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   208: astore 10
    //   210: aload 10
    //   212: ldc_w 435
    //   215: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 10
    //   221: lload_1
    //   222: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload 10
    //   228: ldc_w 425
    //   231: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 10
    //   237: iload 5
    //   239: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload 10
    //   245: ldc_w 430
    //   248: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 10
    //   254: iload 6
    //   256: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: ldc 44
    //   262: aload 10
    //   264: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 366	com/tencent/qqmusic/mediaplayer/util/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload_0
    //   271: getfield 167	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:listener	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$Listener;
    //   274: ifnull +13 -> 287
    //   277: aload_0
    //   278: getfield 167	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:listener	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$Listener;
    //   281: lload_1
    //   282: invokeinterface 437 3 0
    //   287: aload_0
    //   288: getfield 124	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:cachedDataTracker	Lcom/tencent/qqmusic/mediaplayer/DataRangeTracker;
    //   291: lload_1
    //   292: iload 5
    //   294: aload_0
    //   295: lload_1
    //   296: iload 5
    //   298: invokevirtual 439	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:getBufferTimeout	(JI)J
    //   301: invokevirtual 442	com/tencent/qqmusic/mediaplayer/DataRangeTracker:lock	(JIJ)Z
    //   304: pop
    //   305: aload_0
    //   306: getfield 167	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:listener	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$Listener;
    //   309: ifnull +12 -> 321
    //   312: aload_0
    //   313: getfield 167	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:listener	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$Listener;
    //   316: invokeinterface 445 1 0
    //   321: aload_0
    //   322: getfield 119	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:cacheSource	Lcom/tencent/qqmusic/mediaplayer/upstream/IDataSource;
    //   325: lload_1
    //   326: aload_3
    //   327: iload 4
    //   329: iload 5
    //   331: invokeinterface 421 6 0
    //   336: istore 7
    //   338: goto +16 -> 354
    //   341: astore_3
    //   342: new 447	java/io/IOException
    //   345: dup
    //   346: ldc_w 449
    //   349: aload_3
    //   350: invokespecial 452	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   353: athrow
    //   354: iconst_0
    //   355: istore 9
    //   357: iconst_0
    //   358: istore 8
    //   360: iload 7
    //   362: ifle +19 -> 381
    //   365: aload_0
    //   366: iload 7
    //   368: i2l
    //   369: lload_1
    //   370: ladd
    //   371: putfield 396	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:nextContinuousPosition	J
    //   374: iload 9
    //   376: istore 8
    //   378: goto +78 -> 456
    //   381: iload 7
    //   383: ifge +229 -> 612
    //   386: new 210	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   393: astore_3
    //   394: aload_3
    //   395: ldc_w 454
    //   398: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: aload_3
    //   403: iload 7
    //   405: invokevirtual 428	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   408: pop
    //   409: ldc 44
    //   411: aload_3
    //   412: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 433	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   418: iconst_1
    //   419: istore 8
    //   421: goto +35 -> 456
    //   424: new 210	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   431: astore_3
    //   432: aload_3
    //   433: ldc_w 456
    //   436: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: pop
    //   440: aload_3
    //   441: iload 8
    //   443: invokevirtual 459	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   446: pop
    //   447: ldc 44
    //   449: aload_3
    //   450: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 433	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   456: aload_0
    //   457: getfield 167	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:listener	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$Listener;
    //   460: ifnull +163 -> 623
    //   463: iload 8
    //   465: ifeq +22 -> 487
    //   468: aload_0
    //   469: getfield 167	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:listener	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$Listener;
    //   472: lload_1
    //   473: iload 5
    //   475: i2l
    //   476: iload 7
    //   478: i2l
    //   479: invokeinterface 463 7 0
    //   484: iload 7
    //   486: ireturn
    //   487: aload_0
    //   488: getfield 167	com/tencent/qqmusic/mediaplayer/upstream/CacheDataSource:listener	Lcom/tencent/qqmusic/mediaplayer/upstream/CacheDataSource$Listener;
    //   491: lload_1
    //   492: iload 7
    //   494: i2l
    //   495: invokeinterface 465 5 0
    //   500: iload 7
    //   502: ireturn
    //   503: new 210	java/lang/StringBuilder
    //   506: dup
    //   507: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   510: astore_3
    //   511: aload_3
    //   512: ldc_w 467
    //   515: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: pop
    //   519: aload_3
    //   520: lload_1
    //   521: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: ldc 44
    //   527: aload_3
    //   528: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 433	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: new 210	java/lang/StringBuilder
    //   537: dup
    //   538: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   541: astore_3
    //   542: aload_3
    //   543: ldc_w 469
    //   546: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload_3
    //   551: lload_1
    //   552: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: new 447	java/io/IOException
    //   559: dup
    //   560: aload_3
    //   561: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   564: invokespecial 470	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   567: athrow
    //   568: new 210	java/lang/StringBuilder
    //   571: dup
    //   572: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   575: astore_3
    //   576: aload_3
    //   577: ldc_w 472
    //   580: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload_3
    //   585: lload_1
    //   586: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   589: pop
    //   590: ldc 44
    //   592: aload_3
    //   593: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: aload 10
    //   598: invokestatic 475	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   601: aload 10
    //   603: athrow
    //   604: aload_3
    //   605: athrow
    //   606: iconst_m1
    //   607: istore 6
    //   609: goto -514 -> 95
    //   612: iload 5
    //   614: ifeq -190 -> 424
    //   617: iconst_1
    //   618: istore 8
    //   620: goto -196 -> 424
    //   623: iload 7
    //   625: ireturn
    //   626: astore_3
    //   627: goto -23 -> 604
    //   630: astore 10
    //   632: goto -64 -> 568
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	635	0	this	CacheDataSource
    //   0	635	1	paramLong	long
    //   0	635	3	paramArrayOfByte	byte[]
    //   0	635	4	paramInt1	int
    //   0	635	5	paramInt2	int
    //   90	518	6	i	int
    //   97	527	7	j	int
    //   24	595	8	bool1	boolean
    //   355	20	9	bool2	boolean
    //   208	394	10	localStringBuilder	StringBuilder
    //   630	1	10	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   287	305	341	java/lang/InterruptedException
    //   6	40	626	finally
    //   43	50	626	finally
    //   50	70	626	finally
    //   75	92	626	finally
    //   104	115	626	finally
    //   120	198	626	finally
    //   201	287	626	finally
    //   287	305	626	finally
    //   305	321	626	finally
    //   321	338	626	finally
    //   342	354	626	finally
    //   365	374	626	finally
    //   386	418	626	finally
    //   424	456	626	finally
    //   456	463	626	finally
    //   468	484	626	finally
    //   487	500	626	finally
    //   503	568	626	finally
    //   568	604	626	finally
    //   6	40	630	java/lang/Throwable
    //   43	50	630	java/lang/Throwable
    //   50	70	630	java/lang/Throwable
    //   75	92	630	java/lang/Throwable
    //   104	115	630	java/lang/Throwable
    //   120	198	630	java/lang/Throwable
    //   201	287	630	java/lang/Throwable
    //   287	305	630	java/lang/Throwable
    //   305	321	630	java/lang/Throwable
    //   321	338	630	java/lang/Throwable
    //   342	354	630	java/lang/Throwable
    //   365	374	630	java/lang/Throwable
    //   386	418	630	java/lang/Throwable
    //   424	456	630	java/lang/Throwable
    //   456	463	630	java/lang/Throwable
    //   468	484	630	java/lang/Throwable
    //   487	500	630	java/lang/Throwable
    //   503	568	630	java/lang/Throwable
  }
  
  public void setListener(@Nullable CacheDataSource.Listener paramListener)
  {
    this.listener = paramListener;
  }
  
  public boolean wait(int paramInt, long paramLong)
  {
    return this.cachedDataTracker.lock(0L, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.upstream.CacheDataSource
 * JD-Core Version:    0.7.0.1
 */