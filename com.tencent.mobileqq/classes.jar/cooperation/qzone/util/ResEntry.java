package cooperation.qzone.util;

import java.lang.ref.WeakReference;

public class ResEntry
{
  private static final int MAX_POOL_SIZE = 100;
  private static ResEntry sPool;
  private static int sPoolSize = 0;
  private static final Object sPoolSync = new Object();
  public String fileName;
  public String mPath;
  public WeakReference<ResDownloadManger.ResLoadListener> mResLoadListener;
  public String mUrl;
  public String mUrlKey;
  private ResEntry next;
  public int type;
  
  public ResEntry(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString);
    this.mUrlKey = localStringBuilder.toString();
  }
  
  private void clearForRecycle()
  {
    this.mUrl = null;
    this.mUrlKey = null;
    this.mPath = null;
    this.fileName = null;
    this.mResLoadListener = null;
  }
  
  public static ResEntry obtain(int paramInt, String paramString)
  {
    synchronized (sPoolSync)
    {
      if (sPool != null)
      {
        ResEntry localResEntry = sPool;
        sPool = localResEntry.next;
        localResEntry.next = null;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramString);
        localResEntry.mUrlKey = localStringBuilder.toString();
        localResEntry.type = paramInt;
        sPoolSize -= 1;
        return localResEntry;
      }
      return new ResEntry(paramInt, paramString);
    }
  }
  
  public void recycle()
  {
    clearForRecycle();
    synchronized (sPoolSync)
    {
      if (sPoolSize < 100)
      {
        this.next = sPool;
        sPool = this;
        sPoolSize += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.util.ResEntry
 * JD-Core Version:    0.7.0.1
 */