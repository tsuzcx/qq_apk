package com.tencent.weiyun.uploader;

public class UploadRequest
{
  private Object mBusinessData;
  private int mChannelCount;
  private final String mCheckKey;
  private final String mFileId;
  private final IUploader.IUploadListener mListener;
  private final String mPath;
  private final String mRequestKey;
  private final String mServerIp;
  private final String mServerName;
  private final int mServerPort;
  private final String mSha;
  private final long mSize;
  private final String[] mSliceSha;
  private long[] mStatisticTimes;
  private final long mUin;
  private final long mUploadedSize;
  
  private UploadRequest(UploadRequest.Builder paramBuilder)
  {
    this.mRequestKey = UploadRequest.Builder.access$000(paramBuilder);
    this.mListener = UploadRequest.Builder.access$100(paramBuilder);
    this.mUin = UploadRequest.Builder.access$200(paramBuilder);
    this.mPath = UploadRequest.Builder.access$300(paramBuilder);
    this.mSha = UploadRequest.Builder.access$400(paramBuilder);
    this.mSliceSha = UploadRequest.Builder.access$500(paramBuilder);
    this.mSize = UploadRequest.Builder.access$600(paramBuilder);
    this.mUploadedSize = UploadRequest.Builder.access$700(paramBuilder);
    this.mFileId = UploadRequest.Builder.access$800(paramBuilder);
    this.mCheckKey = UploadRequest.Builder.access$900(paramBuilder);
    this.mServerName = UploadRequest.Builder.access$1000(paramBuilder);
    this.mServerIp = UploadRequest.Builder.access$1100(paramBuilder);
    this.mServerPort = UploadRequest.Builder.access$1200(paramBuilder);
    this.mChannelCount = UploadRequest.Builder.access$1300(paramBuilder);
    this.mBusinessData = UploadRequest.Builder.access$1400(paramBuilder);
    this.mStatisticTimes = UploadRequest.Builder.access$1500(paramBuilder);
  }
  
  public Object businessData()
  {
    return this.mBusinessData;
  }
  
  public int channelCount()
  {
    return this.mChannelCount;
  }
  
  public String checkKey()
  {
    return this.mCheckKey;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof UploadRequest)) {
        return false;
      }
      paramObject = (UploadRequest)paramObject;
      if (this.mRequestKey != null)
      {
        if (this.mRequestKey.equals(paramObject.mRequestKey)) {}
      }
      else {
        while (paramObject.mRequestKey != null) {
          return false;
        }
      }
      if (this.mListener != null) {
        return this.mListener.equals(paramObject.mListener);
      }
    } while (paramObject.mListener == null);
    return false;
  }
  
  public String fileId()
  {
    return this.mFileId;
  }
  
  public int hashCode()
  {
    int j = 0;
    if (this.mRequestKey != null) {}
    for (int i = this.mRequestKey.hashCode();; i = 0)
    {
      if (this.mListener != null) {
        j = this.mListener.hashCode();
      }
      return i * 31 + j;
    }
  }
  
  public IUploader.IUploadListener listener()
  {
    return this.mListener;
  }
  
  public UploadRequest.Builder newBuilder()
  {
    return new UploadRequest.Builder(this, null);
  }
  
  public String path()
  {
    return this.mPath;
  }
  
  public String requestKey()
  {
    return this.mRequestKey;
  }
  
  public String serverIp()
  {
    return this.mServerIp;
  }
  
  public String serverName()
  {
    return this.mServerName;
  }
  
  public int serverPort()
  {
    return this.mServerPort;
  }
  
  public String sha()
  {
    return this.mSha;
  }
  
  public long size()
  {
    return this.mSize;
  }
  
  public String[] sliceSha()
  {
    return this.mSliceSha;
  }
  
  public long[] statisticTimes()
  {
    return this.mStatisticTimes;
  }
  
  public String toString()
  {
    return "UploadRequest{requestKey='" + this.mRequestKey + '\'' + ", listener=" + this.mListener + ", uin=" + this.mUin + ", path='" + this.mPath + '\'' + ", sha='" + this.mSha + '\'' + ", size=" + this.mSize + ", uploadedSize=" + this.mUploadedSize + ", fileId='" + this.mFileId + '\'' + ", checkKey='" + this.mCheckKey + '\'' + ", serverName='" + this.mServerName + '\'' + ", serverIp='" + this.mServerIp + '\'' + ", serverPort=" + this.mServerPort + ", channelCount=" + this.mChannelCount + ", businessData=" + this.mBusinessData + '}';
  }
  
  public long uin()
  {
    return this.mUin;
  }
  
  public long uploadedSize()
  {
    return this.mUploadedSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.uploader.UploadRequest
 * JD-Core Version:    0.7.0.1
 */