package com.tencent.mobileqq.weiyun;

import android.content.SharedPreferences;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IWeiyunApi;
import com.tencent.mobileqq.weiyun.api.impl.WeiyunApiImpl;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.DiskPicBackupReq;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.FileExtInfo;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.QqSdkFileUploadMsgReq;
import com.tencent.mobileqq.weiyun.utils.CRCUtil;
import com.tencent.mobileqq.weiyun.utils.StringUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.HostInterface;
import com.tencent.weiyun.transmission.WeiyunTransmissionGlobal.UploadServerInfoCallback;
import com.tencent.weiyun.transmission.upload.UploadFile;
import com.tencent.weiyun.transmission.upload.UploadType;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class TransmissionHelper$TransmissionHostInterfaceImpl
  implements WeiyunTransmissionGlobal.HostInterface
{
  private final String a;
  
  TransmissionHelper$TransmissionHostInterfaceImpl(String paramString)
  {
    this.a = paramString;
  }
  
  public void fetchUploadServerInfo(UploadFile paramUploadFile, UploadType paramUploadType, WeiyunTransmissionGlobal.UploadServerInfoCallback paramUploadServerInfoCallback)
  {
    WeiyunApiImpl localWeiyunApiImpl = (WeiyunApiImpl)QRoute.api(IWeiyunApi.class);
    Object localObject;
    if (paramUploadFile.cmdType == 1)
    {
      localObject = new WeiyunPB.DiskPicBackupReq();
      if (paramUploadFile.fileName != null) {
        ((WeiyunPB.DiskPicBackupReq)localObject).filename.set(paramUploadFile.fileName);
      }
      ((WeiyunPB.DiskPicBackupReq)localObject).file_exist_option.set(paramUploadType.ordinal());
      ((WeiyunPB.DiskPicBackupReq)localObject).upload_type.set(0);
      ((WeiyunPB.DiskPicBackupReq)localObject).auto_create_user.set(false);
      ((WeiyunPB.DiskPicBackupReq)localObject).auto_flag.set(paramUploadFile.autoBackupFlag);
      ((WeiyunPB.DiskPicBackupReq)localObject).backup_dir_name.set(Build.MODEL);
      if ((paramUploadFile.isCompress) && (!TextUtils.isEmpty(paramUploadFile.compressedPath)))
      {
        if (paramUploadFile.compressedSha != null) {
          ((WeiyunPB.DiskPicBackupReq)localObject).file_sha.set(StringUtils.a(paramUploadFile.compressedSha));
        }
        ((WeiyunPB.DiskPicBackupReq)localObject).file_size.set(paramUploadFile.compressedSize);
        ((WeiyunPB.DiskPicBackupReq)localObject).first_256k_crc.set((int)CRCUtil.a(paramUploadFile.compressedPath, 262144L));
      }
      else
      {
        if (paramUploadFile.sha != null) {
          ((WeiyunPB.DiskPicBackupReq)localObject).file_sha.set(StringUtils.a(paramUploadFile.sha));
        }
        ((WeiyunPB.DiskPicBackupReq)localObject).file_size.set(paramUploadFile.fileSize);
        ((WeiyunPB.DiskPicBackupReq)localObject).first_256k_crc.set((int)CRCUtil.a(paramUploadFile.localPath, 262144L));
      }
      if (!TextUtils.isEmpty(paramUploadFile.mimeType))
      {
        paramUploadType = new WeiyunPB.FileExtInfo();
        paramUploadType.take_time.set(paramUploadFile.takenTime);
        paramUploadType.latitude.set(paramUploadFile.latitude);
        paramUploadType.longitude.set(paramUploadFile.longitude);
        if (paramUploadFile.mimeType.startsWith("image")) {
          paramUploadType.group_id.set(1);
        } else {
          paramUploadFile.mimeType.startsWith("video");
        }
        ((WeiyunPB.DiskPicBackupReq)localObject).ext_info.set(paramUploadType);
      }
      localWeiyunApiImpl.fetchBackupAddress((WeiyunPB.DiskPicBackupReq)localObject, new TransmissionHelper.TransmissionHostInterfaceImpl.1(this, paramUploadServerInfoCallback, paramUploadFile));
      return;
    }
    if (paramUploadFile.cmdType == 0)
    {
      localObject = new WeiyunPB.QqSdkFileUploadMsgReq();
      if (paramUploadFile.fileName != null) {
        ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).filename.set(paramUploadFile.fileName);
      }
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).file_exist_option.set(paramUploadType.ordinal());
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).upload_type.set(0);
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).auto_create_user.set(false);
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).pdir_key.set(StringUtils.a(paramUploadFile.pDirKey));
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).ppdir_key.set(StringUtils.a(paramUploadFile.pPDirKey));
      ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).use_mutil_channel.set(WeiyunTransmissionGlobal.getInstance().isNativeUpload());
      if ((paramUploadFile.isCompress) && (!TextUtils.isEmpty(paramUploadFile.compressedPath)))
      {
        if (paramUploadFile.compressedSha != null) {
          ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).file_sha.set(StringUtils.a(paramUploadFile.compressedSha));
        }
        ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).file_size.set(paramUploadFile.compressedSize);
      }
      else
      {
        if (paramUploadFile.sha != null) {
          ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).file_sha.set(StringUtils.a(paramUploadFile.sha));
        }
        ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).file_size.set(paramUploadFile.fileSize);
      }
      if (!TextUtils.isEmpty(paramUploadFile.mimeType))
      {
        paramUploadType = new WeiyunPB.FileExtInfo();
        paramUploadType.take_time.set(paramUploadFile.takenTime);
        paramUploadType.latitude.set(paramUploadFile.latitude);
        paramUploadType.longitude.set(paramUploadFile.longitude);
        if (paramUploadFile.mimeType.startsWith("image")) {
          paramUploadType.group_id.set(1);
        } else {
          paramUploadFile.mimeType.startsWith("video");
        }
        ((WeiyunPB.QqSdkFileUploadMsgReq)localObject).ext_info.set(paramUploadType);
      }
      localWeiyunApiImpl.fetchUploadAddress((WeiyunPB.QqSdkFileUploadMsgReq)localObject, new TransmissionHelper.TransmissionHostInterfaceImpl.2(this, paramUploadServerInfoCallback, paramUploadFile));
    }
  }
  
  public int getCurrentIsp()
  {
    return 0;
  }
  
  public String getCurrentUid()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.a);
    localStringBuilder.append(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount());
    return localStringBuilder.toString();
  }
  
  public long getCurrentUin()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
  }
  
  public NetworkInfo getRecentNetworkInfo()
  {
    return AppNetConnInfo.getRecentNetworkInfo();
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return MobileQQ.getContext().getSharedPreferences(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.TransmissionHelper.TransmissionHostInterfaceImpl
 * JD-Core Version:    0.7.0.1
 */