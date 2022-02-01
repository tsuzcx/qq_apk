package com.tencent.oskplayer.proxy;

import com.tencent.oskplayer.PlayerConfig;
import com.tencent.oskplayer.datasource.HttpHeader;
import com.tencent.oskplayer.util.ContentTypeFixer;
import com.tencent.oskplayer.util.Fixer;
import com.tencent.oskplayer.util.PlayerUtils;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoRequest
{
  private static final int CANCEL_STATE_END_SUCCESS = 3;
  private static final int CANCEL_STATE_IDLE = 0;
  private static final int CANCEL_STATE_PROCCEED = 2;
  private static final int CANCEL_STATE_START = 1;
  private static AtomicInteger SEQ_NUM = new AtomicInteger(10000);
  private static final int STOPPED_REASON_CANCEL = 1;
  public static final int STOPPED_REASON_NORMAL = 16;
  public static final int STOPPED_REASON_OTHER = 257;
  public static final int STOPPED_REASON_THREAD_INTERRUPT = 256;
  private static final int STOPPED_REASON_UNSET = 0;
  private String TAG = "VideoRequest";
  private int cancelState = 0;
  private int contentFormatFlag = 0;
  private String dataSourceType = "-1";
  private int downloadedBytes;
  private String extraLogTag = "";
  private FileType fileType = FileType.UNKNOWN;
  private HttpHeader httpHeader;
  private boolean isCacheEnabled;
  private boolean isStopped;
  private int mPrority = -1;
  private int mSeqNum = SEQ_NUM.incrementAndGet();
  private long mStartTime = System.currentTimeMillis();
  private VideoCancelListener mVideoCancelListener;
  private String preferredContentType;
  private long rangeEnd;
  private long rangeStart;
  private String requestMethod;
  private int sentBytes;
  private String sourceUrl;
  private final Object stateLock = new Object();
  private int stoppedReason = 0;
  private Future<?> task;
  private long totalLength = -1L;
  private String uuid;
  private String videoKey;
  
  private boolean checkCancelState(int paramInt)
  {
    for (;;)
    {
      synchronized (this.stateLock)
      {
        if (this.cancelState == paramInt)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  private void enterCancelStartState()
  {
    if (transCancelState(0, 1))
    {
      if (this.mVideoCancelListener != null) {
        this.mVideoCancelListener.onVideoCancelStart(this);
      }
      if (PlayerConfig.g().isDebugVersion()) {
        PlayerUtils.log(3, getLogTag(), this + "cancel start");
      }
    }
  }
  
  private boolean transCancelState(int paramInt1, int paramInt2)
  {
    synchronized (this.stateLock)
    {
      if (this.cancelState == paramInt1)
      {
        this.cancelState = paramInt2;
        return true;
      }
      PlayerUtils.log(5, getLogTag(), String.format(Locale.getDefault(), "transState error, current %d, condition %d, newState %d", new Object[] { Integer.valueOf(this.cancelState), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
      return false;
    }
  }
  
  public void cancel()
  {
    cancel(true);
  }
  
  public void cancel(VideoCancelListener paramVideoCancelListener)
  {
    cancel(true, paramVideoCancelListener);
  }
  
  public void cancel(boolean paramBoolean)
  {
    if (this.task != null)
    {
      enterCancelStartState();
      setStoppedReason(1);
      this.task.cancel(paramBoolean);
    }
  }
  
  public void cancel(boolean paramBoolean, VideoCancelListener paramVideoCancelListener)
  {
    this.mVideoCancelListener = paramVideoCancelListener;
    cancel(paramBoolean);
  }
  
  public void enterCancelProceedState()
  {
    if (transCancelState(1, 2))
    {
      if (this.mVideoCancelListener != null) {
        this.mVideoCancelListener.onVideoCancelProceed(this, 100);
      }
      if (PlayerConfig.g().isDebugVersion()) {
        PlayerUtils.log(3, getLogTag(), this + "cancel proceeding");
      }
    }
  }
  
  public void enterCancelSuccessState()
  {
    if (transCancelState(2, 3))
    {
      if (this.mVideoCancelListener != null) {
        this.mVideoCancelListener.onVideoCancelSuccess(this);
      }
      if (PlayerConfig.g().isDebugVersion()) {
        PlayerUtils.log(3, getLogTag(), this + "cancel success");
      }
    }
  }
  
  int getContentFormatFlag()
  {
    return this.contentFormatFlag;
  }
  
  public Fixer<Map<String, List<String>>> getContentTypeFixer()
  {
    return new ContentTypeFixer(this.preferredContentType, getLogTag());
  }
  
  public String getDataSourceType()
  {
    return this.dataSourceType;
  }
  
  public int getDownloadedBytes()
  {
    try
    {
      int i = this.downloadedBytes;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public HttpHeader getExtraHeader()
  {
    return this.httpHeader;
  }
  
  public FileType getFileType()
  {
    try
    {
      FileType localFileType = this.fileType;
      return localFileType;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getLogTag()
  {
    return this.extraLogTag + this.TAG;
  }
  
  public int getPrority()
  {
    return this.mPrority;
  }
  
  public long getRangeEnd()
  {
    return this.rangeEnd;
  }
  
  public long getRangeStart()
  {
    return this.rangeStart;
  }
  
  public int getSentBytes()
  {
    try
    {
      int i = this.sentBytes;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getSeqNum()
  {
    return this.mSeqNum;
  }
  
  public String getSourceUrl()
  {
    return this.sourceUrl;
  }
  
  public String getSpeedInfo()
  {
    try
    {
      String str = toString();
      long l = System.currentTimeMillis();
      float f = (float)(this.sentBytes * 1000L) / (float)((l - this.mStartTime) * 1024L);
      str = str + ", startTime=" + this.mStartTime;
      str = str + ", sentBytes=" + this.sentBytes;
      str = str + ", totalLength=" + this.totalLength;
      str = str + ", downloadSpeedKBs=" + f;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long getTotalLength()
  {
    try
    {
      long l = this.totalLength;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String getUuid()
  {
    return this.uuid;
  }
  
  public String getVideoKey()
  {
    return this.videoKey;
  }
  
  public boolean isCacheEnabled()
  {
    return this.isCacheEnabled;
  }
  
  public boolean isCancelProcceed()
  {
    return checkCancelState(2);
  }
  
  public boolean isHeadRequest()
  {
    return (this.requestMethod != null) && (this.requestMethod.toLowerCase().equals("head"));
  }
  
  public boolean isIdle()
  {
    return checkCancelState(0);
  }
  
  public void setCacheEnabled(boolean paramBoolean)
  {
    this.isCacheEnabled = paramBoolean;
  }
  
  void setContentFormatFlag(int paramInt)
  {
    this.contentFormatFlag = paramInt;
  }
  
  public void setDataSourceType(String paramString)
  {
    this.dataSourceType = paramString;
  }
  
  public void setDownloadedBytes(int paramInt)
  {
    try
    {
      this.downloadedBytes = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setExtraHeader(HttpHeader paramHttpHeader)
  {
    this.httpHeader = paramHttpHeader;
  }
  
  public void setIsStopped(boolean paramBoolean)
  {
    this.isStopped = paramBoolean;
  }
  
  public void setLogTag(String paramString)
  {
    this.extraLogTag = paramString;
  }
  
  public void setPreferredContentType(String paramString)
  {
    this.preferredContentType = paramString;
  }
  
  public void setPrority(int paramInt)
  {
    this.mPrority = paramInt;
  }
  
  public void setRangeEnd(long paramLong)
  {
    this.rangeEnd = paramLong;
  }
  
  public void setRangeStart(long paramLong)
  {
    this.rangeStart = paramLong;
  }
  
  public void setRequestMethod(String paramString)
  {
    this.requestMethod = paramString;
  }
  
  public void setSourceUrl(String paramString)
  {
    this.sourceUrl = paramString;
    this.videoKey = PlayerUtils.parseVideoKey(this.sourceUrl);
  }
  
  public void setStoppedReason(int paramInt)
  {
    if ((this.stoppedReason & paramInt) == 0) {
      this.stoppedReason += paramInt;
    }
  }
  
  public void setTask(Future<?> paramFuture)
  {
    this.task = paramFuture;
  }
  
  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }
  
  public boolean shouldCancel()
  {
    return checkCancelState(1);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append(super.toString()).append("{sourceUrl=").append(this.sourceUrl).append(",seq=").append(this.mSeqNum).append(",uuid=").append(getUuid()).append(",priority=").append(getPrority()).append(",requestProperty=");
    if (this.httpHeader != null)
    {
      str = this.httpHeader.toString();
      localStringBuilder = localStringBuilder.append(str).append(",range=[").append(getRangeStart()).append(",").append(getRangeEnd()).append("],preferredContentType=").append(this.preferredContentType).append(",cancelState=").append(this.cancelState).append(",task=");
      if (this.task != null) {
        break label185;
      }
    }
    label185:
    for (String str = "null";; str = this.task.toString())
    {
      return str + "}";
      str = "null";
      break;
    }
  }
  
  public void updateInfo(long paramLong, FileType paramFileType)
  {
    try
    {
      this.totalLength = paramLong;
      this.fileType = paramFileType;
      if (this.fileType.equals(FileType.VIDEO_MP4)) {
        this.contentFormatFlag |= 0x8;
      }
      return;
    }
    finally
    {
      paramFileType = finally;
      throw paramFileType;
    }
  }
  
  public void updateSentBytes(int paramInt)
  {
    try
    {
      this.sentBytes += paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.oskplayer.proxy.VideoRequest
 * JD-Core Version:    0.7.0.1
 */