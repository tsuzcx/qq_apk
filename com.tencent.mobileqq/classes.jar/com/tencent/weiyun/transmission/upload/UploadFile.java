package com.tencent.weiyun.transmission.upload;

import android.text.TextUtils;
import com.tencent.weiyun.transmission.utils.TsLog;

public class UploadFile
  implements Cloneable
{
  private static final String TAG = "UploadFile";
  public String album;
  public String artist;
  public boolean autoBackupFlag;
  public final String batchDesc;
  public String batchId;
  public final int batchIndex;
  public final int batchTotal;
  public final int cmdType;
  public String compressedPath;
  public String compressedSha;
  public long compressedSize;
  public String[] compressedSliceSha;
  public String coverFileId;
  public String coverFileVersion;
  public long duration;
  public String fileName;
  public long fileSize;
  public String groupRootDirKey;
  public int height;
  public final boolean isCompress;
  public long lastModified;
  public double latitude;
  public String localPath;
  public double longitude;
  public String mimeType;
  public String pDirKey;
  public String pDirName;
  public String pPDirKey;
  public final String rootDirUid;
  public UploadFile.UploadServerInfo serverInfo;
  public String sha;
  public String[] sliceSha;
  public long takenTime;
  public String thumbUrl;
  public UploadType uploadType;
  public int width;
  
  private UploadFile(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, UploadFile.UploadBatch paramUploadBatch, int paramInt2)
  {
    this.cmdType = paramInt1;
    this.rootDirUid = paramString1;
    this.pDirName = paramString2;
    this.pDirKey = paramString3;
    this.pPDirKey = paramString4;
    this.localPath = paramString5;
    this.isCompress = paramBoolean;
    this.batchId = UploadFile.UploadBatch.access$000(paramUploadBatch);
    this.batchTotal = UploadFile.UploadBatch.access$100(paramUploadBatch);
    this.batchIndex = paramInt2;
    this.batchDesc = UploadFile.UploadBatch.access$200(paramUploadBatch);
  }
  
  public static UploadFile.UploadBatch createUploadBatch(int paramInt, String paramString)
  {
    if (paramInt <= 0) {
      return null;
    }
    UploadFile.UploadBatch localUploadBatch = new UploadFile.UploadBatch();
    UploadFile.UploadBatch.access$002(localUploadBatch, Long.toString(System.currentTimeMillis()));
    UploadFile.UploadBatch.access$102(localUploadBatch, paramInt);
    UploadFile.UploadBatch.access$202(localUploadBatch, paramString);
    return localUploadBatch;
  }
  
  public static UploadFile createUploadFile(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, UploadFile.UploadBatch paramUploadBatch, int paramInt2)
  {
    if ((TextUtils.isEmpty(paramString5)) || (paramUploadBatch == null) || (paramInt2 < 1) || (paramInt2 > UploadFile.UploadBatch.access$100(paramUploadBatch))) {
      throw new IllegalArgumentException("The params localPath, batch and batchIndex should be valid.");
    }
    return new UploadFile(paramInt1, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, paramUploadBatch, paramInt2);
  }
  
  public UploadFile clone()
  {
    try
    {
      UploadFile localUploadFile = (UploadFile)super.clone();
      return localUploadFile;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public void setServerInfo(boolean paramBoolean, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, String paramString5)
  {
    if ((!paramBoolean) && (TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3)))
    {
      TsLog.w("UploadFile", "UploadServerInfo create error: the params serverName and serverIp are all empty.");
      return;
    }
    this.serverInfo = new UploadFile.UploadServerInfo(this, paramBoolean, paramString1, paramString2, paramString3, paramInt1, paramString4, paramInt2, paramString5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.transmission.upload.UploadFile
 * JD-Core Version:    0.7.0.1
 */