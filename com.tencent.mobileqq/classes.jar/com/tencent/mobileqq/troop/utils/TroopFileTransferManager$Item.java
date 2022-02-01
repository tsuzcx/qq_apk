package com.tencent.mobileqq.troop.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.security.MessageDigest;
import java.util.UUID;

public class TroopFileTransferManager$Item
  extends TroopFileTansferItemEntity
{
  public static final String ThumbnailFilePrefix = "[Thumb]";
  public static final int W2M_PAUSE_CAN_RESUME = 2;
  public static final int W2M_PAUSE_NONE = 0;
  public static final int W2M_PAUSE_NO_RESUME = 1;
  public transient byte[] CheckKey;
  public transient MessageDigest DigestMd5;
  public transient MessageDigest DigestSha;
  public transient MessageDigest DigestSha3;
  public transient String DownloadDNS;
  public transient String DownloadIp;
  public transient String DownloadUrl;
  public transient boolean IsNewStatus;
  public transient int Pausing;
  public transient long ScanPos;
  public transient String ServerDns;
  public transient long StatusUpdateTimeMs;
  public transient boolean ThumbnailDownloading_Large;
  public transient boolean ThumbnailDownloading_Middle;
  public transient boolean ThumbnailDownloading_Middle_Fail;
  public transient boolean ThumbnailDownloading_Small;
  public transient String TmpFile;
  public transient String UploadIp;
  public transient int W2MPause;
  public transient boolean bExtfTransfer;
  public transient String cookieValue;
  public transient String downUrlStr4Report;
  public transient boolean genThumb_Middle_OnGettedLargeOrOrigPic;
  public transient boolean isFileExist;
  public transient String mExcitingSpeed;
  public IForwardCallBack mForwardCallback = null;
  public transient int retryTimes;
  public transient String rspHeadStr;
  public transient int thumbInvalidCode;
  public transient long transferBeginTime;
  public transient long transferedSize;
  public transient String uploadUrl;
  
  public TroopFileTransferManager$Item()
  {
    this.ThumbnailDownloading_Middle_Fail = false;
    this.genThumb_Middle_OnGettedLargeOrOrigPic = false;
    this.transferBeginTime = 0L;
    this.transferedSize = 0L;
    this.retryTimes = 0;
    this.bExtfTransfer = false;
  }
  
  public TroopFileTransferManager$Item(TroopFileTansferItemEntity paramTroopFileTansferItemEntity)
  {
    this.ThumbnailDownloading_Middle_Fail = false;
    this.genThumb_Middle_OnGettedLargeOrOrigPic = false;
    this.transferBeginTime = 0L;
    this.transferedSize = 0L;
    this.retryTimes = 0;
    this.bExtfTransfer = false;
    this.Id = paramTroopFileTansferItemEntity.Id;
    this.LocalFile = paramTroopFileTansferItemEntity.LocalFile;
    this.Status = paramTroopFileTansferItemEntity.Status;
    this.FilePath = paramTroopFileTansferItemEntity.FilePath;
    this.FileName = paramTroopFileTansferItemEntity.FileName;
    this.ProgressTotal = paramTroopFileTansferItemEntity.ProgressTotal;
    this.UploadTime = paramTroopFileTansferItemEntity.UploadTime;
    this.BusId = paramTroopFileTansferItemEntity.BusId;
    this.ErrorCode = paramTroopFileTansferItemEntity.ErrorCode;
    this.ProgressValue = paramTroopFileTansferItemEntity.ProgressValue;
    this.Md5 = paramTroopFileTansferItemEntity.Md5;
    this.Sha = paramTroopFileTansferItemEntity.Sha;
    this.isFromAIO = paramTroopFileTansferItemEntity.isFromAIO;
    this.HasThumbnailFile_Small = paramTroopFileTansferItemEntity.HasThumbnailFile_Small;
    this.ThumbnailFileTimeMS_Small = paramTroopFileTansferItemEntity.ThumbnailFileTimeMS_Small;
    this.HasThumbnailFile_Large = paramTroopFileTansferItemEntity.HasThumbnailFile_Large;
    this.ThumbnailFileTimeMS_Large = paramTroopFileTansferItemEntity.ThumbnailFileTimeMS_Large;
    this.HasThumbnailFile_Middle = paramTroopFileTansferItemEntity.HasThumbnailFile_Middle;
    this.ThumbnailFileTimeMS_Middle = paramTroopFileTansferItemEntity.ThumbnailFileTimeMS_Middle;
    this.PreviewUrl = paramTroopFileTansferItemEntity.PreviewUrl;
    this.NickName = paramTroopFileTansferItemEntity.NickName;
    this.RandomNum = paramTroopFileTansferItemEntity.RandomNum;
    this.NameForSave = paramTroopFileTansferItemEntity.NameForSave;
    this.SafeCheckRes = paramTroopFileTansferItemEntity.SafeCheckRes;
    this.ForwardPath = paramTroopFileTansferItemEntity.ForwardPath;
    this.ForwardBusId = paramTroopFileTansferItemEntity.ForwardBusId;
    this.ForwardTroopuin = paramTroopFileTansferItemEntity.ForwardTroopuin;
    this.mParentId = paramTroopFileTansferItemEntity.mParentId;
    this.width = paramTroopFileTansferItemEntity.width;
    this.height = paramTroopFileTansferItemEntity.height;
    this.duration = paramTroopFileTansferItemEntity.duration;
    this.isZipInnerFile = paramTroopFileTansferItemEntity.isZipInnerFile;
    this.zipType = paramTroopFileTansferItemEntity.zipType;
    this.zipFilePath = paramTroopFileTansferItemEntity.zipFilePath;
    this.zipBusId = paramTroopFileTansferItemEntity.zipBusId;
    this.zipInnerPath = paramTroopFileTansferItemEntity.zipInnerPath;
    this.smallThumbFile = paramTroopFileTansferItemEntity.smallThumbFile;
    this.largeThumbnailFile = paramTroopFileTansferItemEntity.largeThumbnailFile;
    this.middleThumbnailFile = paramTroopFileTansferItemEntity.middleThumbnailFile;
    this.yybApkPackageName = paramTroopFileTansferItemEntity.yybApkPackageName;
    this.yybApkName = paramTroopFileTansferItemEntity.yybApkName;
    this.yybApkIconUrl = paramTroopFileTansferItemEntity.yybApkIconUrl;
    this.apkSafeLevel = paramTroopFileTansferItemEntity.apkSafeLevel;
    this.apkSafeMsg = paramTroopFileTansferItemEntity.apkSafeMsg;
    this.apkSafeDetailUrl = paramTroopFileTansferItemEntity.apkSafeDetailUrl;
  }
  
  public TroopFileTransferManager$Item(TroopFileInfo paramTroopFileInfo)
  {
    boolean bool2 = false;
    this.ThumbnailDownloading_Middle_Fail = false;
    this.genThumb_Middle_OnGettedLargeOrOrigPic = false;
    this.transferBeginTime = 0L;
    this.transferedSize = 0L;
    this.retryTimes = 0;
    this.bExtfTransfer = false;
    this.Id = paramTroopFileInfo.b;
    this.LocalFile = paramTroopFileInfo.t;
    this.Status = paramTroopFileInfo.p;
    this.FilePath = paramTroopFileInfo.c;
    this.FileName = paramTroopFileInfo.d;
    this.ProgressTotal = paramTroopFileInfo.e;
    this.UploadTime = paramTroopFileInfo.d();
    this.BusId = paramTroopFileInfo.f;
    if ((paramTroopFileInfo.w != null) && (paramTroopFileInfo.w.length() > 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.HasThumbnailFile_Small = bool1;
    boolean bool1 = bool2;
    if (paramTroopFileInfo.x != null)
    {
      bool1 = bool2;
      if (paramTroopFileInfo.x.length() > 0) {
        bool1 = true;
      }
    }
    this.HasThumbnailFile_Large = bool1;
    this.NickName = paramTroopFileInfo.G;
    this.mParentId = paramTroopFileInfo.o;
  }
  
  public final boolean canFetchThumbnailFile(int paramInt)
  {
    int i = this.Status;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    if (i == 4) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("canFetchThumbnailFile : fileId[");
      localStringBuilder.append(this.Id);
      localStringBuilder.append("] thumbSize[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i("TroopFileTransferManager", 1, localStringBuilder.toString());
    }
    long l;
    if (paramInt == 128)
    {
      if (this.ThumbnailDownloading_Small) {
        return false;
      }
      l = SystemClock.uptimeMillis() - this.ThumbnailFileTimeMS_Small;
      if ((this.ThumbnailFileTimeMS_Small == 0L) || (l > 300000L) || (l < 0L)) {
        bool1 = true;
      }
      return bool1;
    }
    if (paramInt == 640)
    {
      if (this.ThumbnailDownloading_Large) {
        return false;
      }
      l = SystemClock.uptimeMillis() - this.ThumbnailFileTimeMS_Large;
      if ((this.ThumbnailFileTimeMS_Large != 0L) && (l <= 300000L))
      {
        bool1 = bool3;
        if (l >= 0L) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    bool1 = bool2;
    if (paramInt == 383)
    {
      l = SystemClock.uptimeMillis() - this.ThumbnailFileTimeMS_Middle;
      if (l > 30000L) {
        this.ThumbnailDownloading_Middle = false;
      }
      if (this.ThumbnailDownloading_Middle) {
        return false;
      }
      if ((this.ThumbnailFileTimeMS_Middle != 0L) && (l <= 300000L))
      {
        bool1 = bool2;
        if (l >= 0L) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void deleteThumbnailFile(long paramLong, int paramInt)
  {
    if (paramInt == 128)
    {
      if (this.HasThumbnailFile_Small) {
        new File(getThumbnailFile(paramLong, 128)).delete();
      }
    }
    else if (paramInt == 383)
    {
      if (this.HasThumbnailFile_Middle) {
        new File(getThumbnailFile(paramLong, 383)).delete();
      }
    }
    else if ((paramInt == 640) && (this.HasThumbnailFile_Large)) {
      new File(getThumbnailFile(paramLong, 640)).delete();
    }
  }
  
  public final TroopFileStatusInfo getInfo(long paramLong)
  {
    TroopFileStatusInfo localTroopFileStatusInfo = new TroopFileStatusInfo();
    localTroopFileStatusInfo.d = paramLong;
    localTroopFileStatusInfo.a = this.Id;
    localTroopFileStatusInfo.j = this.ProgressValue;
    localTroopFileStatusInfo.e = this.Status;
    localTroopFileStatusInfo.f = this.IsNewStatus;
    localTroopFileStatusInfo.g = this.ErrorCode;
    localTroopFileStatusInfo.u = this.BusId;
    boolean bool = this.HasThumbnailFile_Small;
    String str2 = "";
    String str1;
    if (bool) {
      str1 = getThumbnailFile(paramLong, 128);
    } else if (canFetchThumbnailFile(128)) {
      str1 = null;
    } else {
      str1 = "";
    }
    localTroopFileStatusInfo.l = str1;
    if (this.HasThumbnailFile_Large) {
      str1 = getThumbnailFile(paramLong, 640);
    } else if (canFetchThumbnailFile(640)) {
      str1 = null;
    } else {
      str1 = "";
    }
    localTroopFileStatusInfo.m = str1;
    if (this.HasThumbnailFile_Middle)
    {
      str1 = getThumbnailFile(paramLong, 383);
    }
    else
    {
      str1 = str2;
      if (canFetchThumbnailFile(383)) {
        str1 = null;
      }
    }
    localTroopFileStatusInfo.n = str1;
    localTroopFileStatusInfo.i = this.ProgressTotal;
    localTroopFileStatusInfo.h = this.UploadTime;
    localTroopFileStatusInfo.r = this.FilePath;
    if ((!TextUtils.isEmpty(this.NameForSave)) && (this.SafeCheckRes == 2)) {
      localTroopFileStatusInfo.t = this.NameForSave;
    } else {
      localTroopFileStatusInfo.t = this.FileName;
    }
    localTroopFileStatusInfo.k = this.LocalFile;
    localTroopFileStatusInfo.w = this.NickName;
    localTroopFileStatusInfo.v = this.entrySessionID;
    if (TextUtils.isEmpty(this.mParentId)) {
      str1 = "/";
    } else {
      str1 = this.mParentId;
    }
    localTroopFileStatusInfo.x = str1;
    localTroopFileStatusInfo.y = this.ThumbnailDownloading_Middle_Fail;
    if ((localTroopFileStatusInfo.y) && (!FileUtil.b(localTroopFileStatusInfo.n))) {
      localTroopFileStatusInfo.n = null;
    }
    localTroopFileStatusInfo.o = this.width;
    localTroopFileStatusInfo.p = this.height;
    localTroopFileStatusInfo.q = this.duration;
    localTroopFileStatusInfo.z = this.mExcitingSpeed;
    localTroopFileStatusInfo.H = this.thumbInvalidCode;
    localTroopFileStatusInfo.G = this.genThumb_Middle_OnGettedLargeOrOrigPic;
    localTroopFileStatusInfo.A = this.yybApkPackageName;
    localTroopFileStatusInfo.B = this.yybApkName;
    localTroopFileStatusInfo.C = this.yybApkIconUrl;
    localTroopFileStatusInfo.D = this.apkSafeLevel;
    localTroopFileStatusInfo.E = this.apkSafeMsg;
    localTroopFileStatusInfo.F = this.apkSafeDetailUrl;
    return localTroopFileStatusInfo;
  }
  
  public final String getThumbnailFile(long paramLong, int paramInt)
  {
    if (paramInt == 128)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH);
      localStringBuilder.append("[Thumb]");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("-");
      localStringBuilder.append(this.Id.toString());
      return localStringBuilder.toString();
    }
    if (paramInt == 383)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH);
      localStringBuilder.append("[Thumb]");
      localStringBuilder.append(320);
      localStringBuilder.append(paramLong);
      localStringBuilder.append("-");
      localStringBuilder.append(this.Id.toString());
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_FILE_SAVE_TROOPTMP_PATH);
    localStringBuilder.append("[Thumb]");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(paramLong);
    localStringBuilder.append("-");
    localStringBuilder.append(this.Id.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item
 * JD-Core Version:    0.7.0.1
 */