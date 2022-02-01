package com.tencent.weiyun.transmission.upload;

import android.text.TextUtils;
import com.tencent.weiyun.uploader.IUploader.IUploadListener;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.uploader.UploadRequest.Builder;
import com.tencent.weiyun.uploader.xplatform.UploadNative.CanceledFlag;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.WeakHashMap;

public class UploadJobContext
  implements Comparable<UploadJobContext>
{
  private volatile long mBirthTime;
  private volatile boolean mCanceled;
  private UploadNative.CanceledFlag mCanceledFlag;
  private long mDbId;
  private final UploadFile mFile;
  private String mFileVersion;
  private volatile boolean mIgnoreNetLimit;
  private final String mJobOwnerUid;
  private final Set<UploadManager.IUploadStatusListener> mListeners;
  private volatile boolean mPriority;
  private volatile int mRank;
  private UploadRequest mRequest;
  private final UploadJobContext.StatisticsTimes mStatisticsTimes;
  private final UploadJobContext.StatusInfo mStatusInfo;
  
  private UploadJobContext(String paramString, UploadFile paramUploadFile, UploadJobContext.StatusInfo paramStatusInfo)
  {
    this.mJobOwnerUid = paramString;
    this.mFile = paramUploadFile;
    this.mStatusInfo = paramStatusInfo;
    this.mListeners = Collections.newSetFromMap(new WeakHashMap());
    this.mStatisticsTimes = new UploadJobContext.StatisticsTimes(this);
    this.mCanceledFlag = new UploadNative.CanceledFlag(false);
  }
  
  public static UploadJobContext createInstance(String paramString, UploadFile paramUploadFile, UploadJobContext.StatusInfo paramStatusInfo)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramUploadFile != null) && (paramStatusInfo != null)) {
      return new UploadJobContext(paramString, paramUploadFile, paramStatusInfo);
    }
    throw new IllegalArgumentException("The params jobOwnerUid, file, destDirKey and statusInfo should be valid.");
  }
  
  public void addListener(UploadManager.IUploadStatusListener paramIUploadStatusListener)
  {
    if (paramIUploadStatusListener != null) {
      synchronized (this.mListeners)
      {
        this.mListeners.add(paramIUploadStatusListener);
        return;
      }
    }
  }
  
  public void addListeners(Collection<UploadManager.IUploadStatusListener> paramCollection)
  {
    if (paramCollection != null) {
      synchronized (this.mListeners)
      {
        this.mListeners.addAll(paramCollection);
        return;
      }
    }
  }
  
  public long birthTime()
  {
    return this.mBirthTime;
  }
  
  public UploadJobContext.StatusInfo cloneStatusInfo()
  {
    return this.mStatusInfo.clone();
  }
  
  public int compareTo(UploadJobContext paramUploadJobContext)
  {
    boolean bool1 = this.mStatusInfo.canRunning();
    boolean bool2 = paramUploadJobContext.mStatusInfo.canRunning();
    if ((bool1) && (!bool2)) {
      return -1;
    }
    if ((!bool1) && (bool2)) {
      return 1;
    }
    if ((!bool1) && (!bool2)) {
      return 0;
    }
    if (this.mRank > paramUploadJobContext.mRank) {
      return -1;
    }
    if (this.mRank < paramUploadJobContext.mRank) {
      return 1;
    }
    if ((this.mPriority) && (!paramUploadJobContext.mPriority)) {
      return -1;
    }
    if ((!this.mPriority) && (paramUploadJobContext.mPriority)) {
      return 1;
    }
    if (this.mBirthTime < paramUploadJobContext.mBirthTime) {
      return -1;
    }
    if (this.mBirthTime > paramUploadJobContext.mBirthTime) {
      return 1;
    }
    return 0;
  }
  
  public void createUploadRequest(UploadFile.UploadServerInfo paramUploadServerInfo, IUploader.IUploadListener paramIUploadListener)
  {
    if (paramUploadServerInfo == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("report", "Weiyun-Report");
    localHashMap.put("uid", this.mJobOwnerUid);
    localHashMap.put("db_id", Long.toString(dbId()));
    localHashMap.put("file_name", this.mFile.fileName);
    localHashMap.put("p_dir_key", this.mFile.pDirKey);
    localHashMap.put("file_id", paramUploadServerInfo.fileId);
    localHashMap.put("sha", this.mFile.sha);
    if (paramUploadServerInfo.fileExist)
    {
      paramUploadServerInfo.checkKey = "empty";
      paramUploadServerInfo.serverName = "empty";
      paramUploadServerInfo.serverIp = "empty";
    }
    Object localObject2 = this.mJobOwnerUid;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int m = ((String)localObject1).length();
    int i = 0;
    int k;
    for (int j = -1;; j = k)
    {
      k = m;
      if (i >= m) {
        break;
      }
      if (j == -1)
      {
        k = j;
        if (Character.isDigit(((String)localObject1).charAt(i))) {
          k = i;
        }
      }
      else
      {
        k = j;
        if (!Character.isDigit(((String)localObject1).charAt(i)))
        {
          k = i;
          break;
        }
      }
      i += 1;
    }
    if ((j > -1) && (k > j)) {
      localObject1 = ((String)localObject1).substring(j, k);
    } else {
      localObject1 = "0";
    }
    UploadRequest.Builder localBuilder = new UploadRequest.Builder();
    if (TextUtils.isEmpty(paramUploadServerInfo.fileId))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.mFile.localPath);
      ((StringBuilder)localObject2).append(this.mFile.pDirKey);
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = paramUploadServerInfo.fileId;
    }
    paramUploadServerInfo = localBuilder.requestKey((String)localObject2).listener(paramIUploadListener).uin(Long.parseLong((String)localObject1)).fileId(paramUploadServerInfo.fileId).checkKey(paramUploadServerInfo.checkKey).serverName(paramUploadServerInfo.serverName).serverIp(paramUploadServerInfo.serverIp).serverPort(paramUploadServerInfo.serverPort).channelCount(paramUploadServerInfo.channelCount).businessData(localHashMap).uploadedSize(this.mStatusInfo.currSize);
    paramIUploadListener = this.mStatisticsTimes.getStatisticsTimes();
    paramUploadServerInfo.statisticTime(paramIUploadListener[0], paramIUploadListener[1], paramIUploadListener[2]);
    if (TextUtils.isEmpty(this.mFile.compressedPath)) {
      paramUploadServerInfo.path(this.mFile.localPath).sha(this.mFile.sha).sliceSha(this.mFile.sliceSha).size(this.mFile.fileSize);
    } else {
      paramUploadServerInfo.path(this.mFile.compressedPath).sha(this.mFile.compressedSha).sliceSha(this.mFile.compressedSliceSha).size(this.mFile.compressedSize);
    }
    this.mRequest = paramUploadServerInfo.build();
  }
  
  public long dbId()
  {
    return this.mDbId;
  }
  
  public UploadFile file()
  {
    return this.mFile;
  }
  
  public String fileVersion()
  {
    return this.mFileVersion;
  }
  
  public UploadNative.CanceledFlag getCanceledFlag()
  {
    return this.mCanceledFlag;
  }
  
  public void increaseRank()
  {
    this.mRank += 1;
  }
  
  public boolean isCanceled()
  {
    return this.mCanceled;
  }
  
  public boolean isIgnoreNetLimit()
  {
    return this.mIgnoreNetLimit;
  }
  
  public boolean isPriority()
  {
    return this.mPriority;
  }
  
  public Set<UploadManager.IUploadStatusListener> listeners()
  {
    Set localSet2 = Collections.newSetFromMap(new WeakHashMap());
    synchronized (this.mListeners)
    {
      localSet2.addAll(this.mListeners);
      return localSet2;
    }
  }
  
  public void removeListener(UploadManager.IUploadStatusListener paramIUploadStatusListener)
  {
    if (paramIUploadStatusListener != null) {
      synchronized (this.mListeners)
      {
        this.mListeners.remove(paramIUploadStatusListener);
        return;
      }
    }
  }
  
  public void resetRank()
  {
    this.mRank = 0;
  }
  
  public void setBirthTime(long paramLong)
  {
    this.mBirthTime = paramLong;
  }
  
  public void setCanceled(boolean paramBoolean)
  {
    this.mCanceled = paramBoolean;
    this.mCanceledFlag.setCanceled(paramBoolean);
  }
  
  public void setDbId(long paramLong)
  {
    this.mDbId = paramLong;
  }
  
  public void setFileVersion(String paramString)
  {
    this.mFileVersion = paramString;
  }
  
  public void setIgnoreNetLimit(boolean paramBoolean)
  {
    this.mIgnoreNetLimit = paramBoolean;
  }
  
  public void setPriority(boolean paramBoolean)
  {
    this.mPriority = paramBoolean;
  }
  
  public UploadJobContext.StatisticsTimes statisticsTimes()
  {
    return this.mStatisticsTimes;
  }
  
  public UploadJobContext.StatusInfo statusInfo()
  {
    return this.mStatusInfo;
  }
  
  public String uid()
  {
    return this.mJobOwnerUid;
  }
  
  public UploadRequest uploadRequest()
  {
    return this.mRequest;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadJobContext
 * JD-Core Version:    0.7.0.1
 */