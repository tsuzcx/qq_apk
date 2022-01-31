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
    if ((TextUtils.isEmpty(paramString)) || (paramUploadFile == null) || (paramStatusInfo == null)) {
      throw new IllegalArgumentException("The params jobOwnerUid, file, destDirKey and statusInfo should be valid.");
    }
    return new UploadJobContext(paramString, paramUploadFile, paramStatusInfo);
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
    if ((bool1) && (!bool2)) {}
    do
    {
      do
      {
        do
        {
          return -1;
          if ((!bool1) && (bool2)) {
            return 1;
          }
          if ((!bool1) && (!bool2)) {
            return 0;
          }
        } while (this.mRank > paramUploadJobContext.mRank);
        if (this.mRank < paramUploadJobContext.mRank) {
          return 1;
        }
      } while ((this.mPriority) && (!paramUploadJobContext.mPriority));
      if ((!this.mPriority) && (paramUploadJobContext.mPriority)) {
        return 1;
      }
    } while (this.mBirthTime < paramUploadJobContext.mBirthTime);
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
    String str1;
    int m;
    int i;
    int j;
    label156:
    int k;
    if (this.mJobOwnerUid == null)
    {
      str1 = "";
      m = str1.length();
      i = 0;
      j = -1;
      if (i >= m) {
        break label521;
      }
      if (j != -1) {
        break label207;
      }
      k = j;
      if (Character.isDigit(str1.charAt(i))) {
        k = i;
      }
    }
    label207:
    do
    {
      i += 1;
      j = k;
      break label156;
      str1 = this.mJobOwnerUid;
      break;
      k = j;
    } while (Character.isDigit(str1.charAt(i)));
    for (;;)
    {
      String str2;
      if ((j > -1) && (i > j))
      {
        str1 = str1.substring(j, i);
        UploadRequest.Builder localBuilder = new UploadRequest.Builder();
        if (!TextUtils.isEmpty(paramUploadServerInfo.fileId)) {
          break label467;
        }
        str2 = this.mFile.localPath + this.mFile.pDirKey;
        label296:
        paramUploadServerInfo = localBuilder.requestKey(str2).listener(paramIUploadListener).uin(Long.parseLong(str1)).fileId(paramUploadServerInfo.fileId).checkKey(paramUploadServerInfo.checkKey).serverName(paramUploadServerInfo.serverName).serverIp(paramUploadServerInfo.serverIp).serverPort(paramUploadServerInfo.serverPort).channelCount(paramUploadServerInfo.channelCount).businessData(localHashMap).uploadedSize(this.mStatusInfo.currSize);
        paramIUploadListener = this.mStatisticsTimes.getStatisticsTimes();
        paramUploadServerInfo.statisticTime(paramIUploadListener[0], paramIUploadListener[1], paramIUploadListener[2]);
        if (!TextUtils.isEmpty(this.mFile.compressedPath)) {
          break label476;
        }
        paramUploadServerInfo.path(this.mFile.localPath).sha(this.mFile.sha).sliceSha(this.mFile.sliceSha).size(this.mFile.fileSize);
      }
      for (;;)
      {
        this.mRequest = paramUploadServerInfo.build();
        return;
        str1 = "0";
        break;
        label467:
        str2 = paramUploadServerInfo.fileId;
        break label296;
        label476:
        paramUploadServerInfo.path(this.mFile.compressedPath).sha(this.mFile.compressedSha).sliceSha(this.mFile.compressedSliceSha).size(this.mFile.compressedSize);
      }
      label521:
      i = m;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadJobContext
 * JD-Core Version:    0.7.0.1
 */