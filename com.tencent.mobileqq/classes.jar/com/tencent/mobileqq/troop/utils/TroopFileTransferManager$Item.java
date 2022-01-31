package com.tencent.mobileqq.troop.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.filemanager.util.IForwardCallBack;
import com.tencent.mobileqq.troop.data.TroopFileInfo;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.qphone.base.util.QLog;
import java.security.MessageDigest;
import java.util.UUID;

public class TroopFileTransferManager$Item
  extends TroopFileTansferItemEntity
{
  public static final String ThumbnailFilePrefix = "[Thumb]";
  public transient byte[] CheckKey;
  public transient MessageDigest DigestMd5;
  public transient MessageDigest DigestSha;
  public transient MessageDigest DigestSha3;
  public transient String DownloadIp;
  public transient String DownloadUrl;
  public transient boolean IsNewStatus;
  public transient int Pausing;
  public transient long ScanPos;
  public transient long StatusUpdateTimeMs;
  public transient boolean ThumbnailDownloading_Large;
  public transient boolean ThumbnailDownloading_Middle;
  public transient boolean ThumbnailDownloading_Middle_Fail;
  public transient boolean ThumbnailDownloading_Small;
  public transient String TmpFile;
  public transient String UploadIp;
  public transient TroopFileTransferManager.Item.W2MPauseEnum W2MPause;
  public transient String cookieValue;
  public transient String downUrlStr4Report;
  public int duration;
  public int height;
  public transient boolean isFileExist;
  public boolean isZipInnerFile;
  public IForwardCallBack mForwardCallback;
  public transient int retryTimes;
  public transient String rspHeadStr;
  public transient long transferBeginTime;
  public transient long transferedSize;
  public transient String uploadUrl;
  public int width;
  
  public TroopFileTransferManager$Item(TroopFileTansferItemEntity paramTroopFileTansferItemEntity)
  {
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
    this.NickName = paramTroopFileTansferItemEntity.NickName;
    this.RandomNum = paramTroopFileTansferItemEntity.RandomNum;
    this.NameForSave = paramTroopFileTansferItemEntity.NameForSave;
    this.SafeCheckRes = paramTroopFileTansferItemEntity.SafeCheckRes;
    this.ForwardPath = paramTroopFileTansferItemEntity.ForwardPath;
    this.ForwardBusId = paramTroopFileTansferItemEntity.ForwardBusId;
    this.ForwardTroopuin = paramTroopFileTansferItemEntity.ForwardTroopuin;
    this.mParentId = paramTroopFileTansferItemEntity.mParentId;
  }
  
  public TroopFileTransferManager$Item(TroopFileInfo paramTroopFileInfo)
  {
    this.Id = paramTroopFileInfo.jdField_a_of_type_JavaUtilUUID;
    this.LocalFile = paramTroopFileInfo.h;
    this.Status = paramTroopFileInfo.jdField_e_of_type_Int;
    this.FilePath = paramTroopFileInfo.jdField_b_of_type_JavaLangString;
    this.FileName = paramTroopFileInfo.jdField_c_of_type_JavaLangString;
    this.ProgressTotal = paramTroopFileInfo.jdField_a_of_type_Long;
    this.UploadTime = paramTroopFileInfo.a();
    this.BusId = paramTroopFileInfo.jdField_a_of_type_Int;
    if ((paramTroopFileInfo.i != null) && (paramTroopFileInfo.i.length() > 0))
    {
      bool1 = true;
      this.HasThumbnailFile_Small = bool1;
      if ((paramTroopFileInfo.j == null) || (paramTroopFileInfo.j.length() <= 0)) {
        break label140;
      }
    }
    label140:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.HasThumbnailFile_Large = bool1;
      this.NickName = paramTroopFileInfo.n;
      this.mParentId = paramTroopFileInfo.f;
      return;
      bool1 = false;
      break;
    }
  }
  
  public final boolean canFetchThumbnailFile(int paramInt)
  {
    if (this.Status == 4) {}
    long l;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return false;
                if (QLog.isColorLevel()) {
                  QLog.i("TroopFileTransferManager", 1, "canFetchThumbnailFile : fileId[" + this.Id + "] thumbSize[" + paramInt + "]");
                }
                if (paramInt != 128) {
                  break;
                }
              } while (this.ThumbnailDownloading_Small);
              l = SystemClock.uptimeMillis() - this.ThumbnailFileTimeMS_Small;
            } while ((this.ThumbnailFileTimeMS_Small != 0L) && (l <= 300000L) && (l >= 0L));
            return true;
            if (paramInt != 640) {
              break;
            }
          } while (this.ThumbnailDownloading_Large);
          l = SystemClock.uptimeMillis() - this.ThumbnailFileTimeMS_Large;
        } while ((this.ThumbnailFileTimeMS_Large != 0L) && (l <= 300000L) && (l >= 0L));
        return true;
      } while (paramInt != 383);
      l = SystemClock.uptimeMillis() - this.ThumbnailFileTimeMS_Middle;
      if (l > 30000L) {
        this.ThumbnailDownloading_Middle = false;
      }
    } while ((this.ThumbnailDownloading_Middle) || ((this.ThumbnailFileTimeMS_Middle != 0L) && (l <= 300000L) && (l >= 0L)));
    return true;
  }
  
  public final TroopFileStatusInfo getInfo(long paramLong)
  {
    TroopFileStatusInfo localTroopFileStatusInfo = new TroopFileStatusInfo();
    localTroopFileStatusInfo.jdField_a_of_type_Long = paramLong;
    localTroopFileStatusInfo.jdField_a_of_type_JavaUtilUUID = this.Id;
    localTroopFileStatusInfo.jdField_c_of_type_Long = this.ProgressValue;
    localTroopFileStatusInfo.jdField_b_of_type_Int = this.Status;
    localTroopFileStatusInfo.jdField_a_of_type_Boolean = this.IsNewStatus;
    localTroopFileStatusInfo.jdField_c_of_type_Int = this.ErrorCode;
    localTroopFileStatusInfo.jdField_e_of_type_Int = this.BusId;
    if (this.HasThumbnailFile_Small)
    {
      str = getThumbnailFile(paramLong, 128);
      localTroopFileStatusInfo.jdField_b_of_type_JavaLangString = str;
      if (!this.HasThumbnailFile_Large) {
        break label284;
      }
      str = getThumbnailFile(paramLong, 640);
      label107:
      localTroopFileStatusInfo.jdField_c_of_type_JavaLangString = str;
      if (!this.HasThumbnailFile_Middle) {
        break label306;
      }
      str = getThumbnailFile(paramLong, 383);
      label129:
      localTroopFileStatusInfo.jdField_d_of_type_JavaLangString = str;
      localTroopFileStatusInfo.jdField_b_of_type_Long = this.ProgressTotal;
      localTroopFileStatusInfo.jdField_d_of_type_Int = this.UploadTime;
      localTroopFileStatusInfo.jdField_e_of_type_JavaLangString = this.FilePath;
      if ((TextUtils.isEmpty(this.NameForSave)) || (this.SafeCheckRes != 2)) {
        break label328;
      }
      localTroopFileStatusInfo.g = this.NameForSave;
      label189:
      localTroopFileStatusInfo.jdField_a_of_type_JavaLangString = this.LocalFile;
      localTroopFileStatusInfo.h = this.NickName;
      localTroopFileStatusInfo.jdField_d_of_type_Long = this.entrySessionID;
      if (!TextUtils.isEmpty(this.mParentId)) {
        break label340;
      }
    }
    label284:
    label306:
    label328:
    label340:
    for (String str = "/";; str = this.mParentId)
    {
      localTroopFileStatusInfo.i = str;
      localTroopFileStatusInfo.jdField_b_of_type_Boolean = this.ThumbnailDownloading_Middle_Fail;
      if (localTroopFileStatusInfo.jdField_b_of_type_Boolean) {
        localTroopFileStatusInfo.jdField_d_of_type_JavaLangString = null;
      }
      return localTroopFileStatusInfo;
      if (canFetchThumbnailFile(128))
      {
        str = null;
        break;
      }
      str = "";
      break;
      if (canFetchThumbnailFile(640))
      {
        str = null;
        break label107;
      }
      str = "";
      break label107;
      if (canFetchThumbnailFile(383))
      {
        str = null;
        break label129;
      }
      str = "";
      break label129;
      localTroopFileStatusInfo.g = this.FileName;
      break label189;
    }
  }
  
  public final String getThumbnailFile(long paramLong, int paramInt)
  {
    if (paramInt == 128) {
      return AppConstants.ba + "[Thumb]" + paramLong + "-" + this.Id.toString();
    }
    if (paramInt == 383) {
      return AppConstants.ba + "[Thumb]" + 320 + paramLong + "-" + this.Id.toString();
    }
    return AppConstants.ba + "[Thumb]" + paramInt + paramLong + "-" + this.Id.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item
 * JD-Core Version:    0.7.0.1
 */