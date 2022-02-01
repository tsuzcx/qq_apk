package cooperation.qzone.thread;

import android.support.annotation.NonNull;

class QzoneThreadMonitor$MessageInfo
  implements Comparable<MessageInfo>
{
  public static final int TYPE_NORMAL = 1;
  public static final int TYPE_REAL_TIME = 2;
  public static final int TYPE_SLOW = 3;
  public long actualHandleTime = -1L;
  public String callback;
  public long expectedHandleTime;
  public long finishTime = -1L;
  public String id;
  public String target;
  public String threadName;
  public int type;
  public int what;
  
  public QzoneThreadMonitor$MessageInfo(QzoneThreadMonitor paramQzoneThreadMonitor, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, long paramLong, int paramInt2)
  {
    this.id = paramString1;
    this.threadName = paramString2;
    this.what = paramInt1;
    this.target = paramString3;
    this.callback = paramString4;
    this.expectedHandleTime = paramLong;
    this.type = paramInt2;
  }
  
  public int compareTo(@NonNull MessageInfo paramMessageInfo)
  {
    return (int)(this.expectedHandleTime - paramMessageInfo.expectedHandleTime);
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof MessageInfo)) && (this.id.equals(((MessageInfo)paramObject).id));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.thread.QzoneThreadMonitor.MessageInfo
 * JD-Core Version:    0.7.0.1
 */