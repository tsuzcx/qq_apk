package com.tencent.mobileqq.troop.utils;

import ajsd;
import android.os.SystemClock;
import android.text.TextUtils;
import apvd;
import apvh;
import azpi;
import azqv;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
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
  public apvh mForwardCallback;
  public transient int retryTimes;
  public transient String rspHeadStr;
  public transient int thumbInvalidCode;
  public transient long transferBeginTime;
  public transient long transferedSize;
  public transient String uploadUrl;
  
  public TroopFileTransferManager$Item() {}
  
  public TroopFileTransferManager$Item(azpi paramazpi)
  {
    this.Id = paramazpi.jdField_a_of_type_JavaUtilUUID;
    this.LocalFile = paramazpi.jdField_h_of_type_JavaLangString;
    this.Status = paramazpi.jdField_e_of_type_Int;
    this.FilePath = paramazpi.jdField_b_of_type_JavaLangString;
    this.FileName = paramazpi.jdField_c_of_type_JavaLangString;
    this.ProgressTotal = paramazpi.jdField_a_of_type_Long;
    this.UploadTime = paramazpi.a();
    this.BusId = paramazpi.jdField_a_of_type_Int;
    if ((paramazpi.jdField_i_of_type_JavaLangString != null) && (paramazpi.jdField_i_of_type_JavaLangString.length() > 0))
    {
      bool1 = true;
      this.HasThumbnailFile_Small = bool1;
      if ((paramazpi.j == null) || (paramazpi.j.length() <= 0)) {
        break label140;
      }
    }
    label140:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.HasThumbnailFile_Large = bool1;
      this.NickName = paramazpi.n;
      this.mParentId = paramazpi.f;
      return;
      bool1 = false;
      break;
    }
  }
  
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
  
  public final void deleteThumbnailFile(long paramLong, int paramInt)
  {
    if (paramInt == 128) {
      if (this.HasThumbnailFile_Small) {
        new File(getThumbnailFile(paramLong, 128)).delete();
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt != 383) {
          break;
        }
      } while (!this.HasThumbnailFile_Middle);
      new File(getThumbnailFile(paramLong, 383)).delete();
      return;
    } while ((paramInt != 640) || (!this.HasThumbnailFile_Large));
    new File(getThumbnailFile(paramLong, 640)).delete();
  }
  
  public final azqv getInfo(long paramLong)
  {
    azqv localazqv = new azqv();
    localazqv.jdField_b_of_type_Long = paramLong;
    localazqv.jdField_a_of_type_JavaUtilUUID = this.Id;
    localazqv.jdField_d_of_type_Long = this.ProgressValue;
    localazqv.jdField_b_of_type_Int = this.Status;
    localazqv.jdField_a_of_type_Boolean = this.IsNewStatus;
    localazqv.jdField_c_of_type_Int = this.ErrorCode;
    localazqv.jdField_h_of_type_Int = this.BusId;
    if (this.HasThumbnailFile_Small)
    {
      str = getThumbnailFile(paramLong, 128);
      localazqv.jdField_b_of_type_JavaLangString = str;
      if (!this.HasThumbnailFile_Large) {
        break label349;
      }
      str = getThumbnailFile(paramLong, 640);
      label107:
      localazqv.jdField_c_of_type_JavaLangString = str;
      if (!this.HasThumbnailFile_Middle) {
        break label371;
      }
      str = getThumbnailFile(paramLong, 383);
      label129:
      localazqv.jdField_d_of_type_JavaLangString = str;
      localazqv.jdField_c_of_type_Long = this.ProgressTotal;
      localazqv.jdField_d_of_type_Int = this.UploadTime;
      localazqv.jdField_e_of_type_JavaLangString = this.FilePath;
      if ((TextUtils.isEmpty(this.NameForSave)) || (this.SafeCheckRes != 2)) {
        break label393;
      }
      localazqv.jdField_g_of_type_JavaLangString = this.NameForSave;
      label189:
      localazqv.jdField_a_of_type_JavaLangString = this.LocalFile;
      localazqv.jdField_h_of_type_JavaLangString = this.NickName;
      localazqv.jdField_e_of_type_Long = this.entrySessionID;
      if (!TextUtils.isEmpty(this.mParentId)) {
        break label405;
      }
    }
    label393:
    label405:
    for (String str = "/";; str = this.mParentId)
    {
      localazqv.jdField_i_of_type_JavaLangString = str;
      localazqv.jdField_b_of_type_Boolean = this.ThumbnailDownloading_Middle_Fail;
      if ((localazqv.jdField_b_of_type_Boolean) && (!apvd.b(localazqv.jdField_d_of_type_JavaLangString))) {
        localazqv.jdField_d_of_type_JavaLangString = null;
      }
      localazqv.jdField_e_of_type_Int = this.width;
      localazqv.f = this.height;
      localazqv.jdField_g_of_type_Int = this.duration;
      localazqv.j = this.mExcitingSpeed;
      localazqv.jdField_i_of_type_Int = this.thumbInvalidCode;
      localazqv.jdField_c_of_type_Boolean = this.genThumb_Middle_OnGettedLargeOrOrigPic;
      return localazqv;
      if (canFetchThumbnailFile(128))
      {
        str = null;
        break;
      }
      str = "";
      break;
      label349:
      if (canFetchThumbnailFile(640))
      {
        str = null;
        break label107;
      }
      str = "";
      break label107;
      label371:
      if (canFetchThumbnailFile(383))
      {
        str = null;
        break label129;
      }
      str = "";
      break label129;
      localazqv.jdField_g_of_type_JavaLangString = this.FileName;
      break label189;
    }
  }
  
  public final String getThumbnailFile(long paramLong, int paramInt)
  {
    if (paramInt == 128) {
      return ajsd.bo + "[Thumb]" + paramLong + "-" + this.Id.toString();
    }
    if (paramInt == 383) {
      return ajsd.bo + "[Thumb]" + 320 + paramLong + "-" + this.Id.toString();
    }
    return ajsd.bo + "[Thumb]" + paramInt + paramLong + "-" + this.Id.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item
 * JD-Core Version:    0.7.0.1
 */