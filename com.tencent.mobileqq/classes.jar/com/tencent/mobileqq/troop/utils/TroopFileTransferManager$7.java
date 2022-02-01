package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopFileHandler;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class TroopFileTransferManager$7
  extends TroopFileReqDownloadFileObserver
{
  TroopFileTransferManager$7(TroopFileTransferManager paramTroopFileTransferManager) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    long l = paramBundle.getLong("troopUin");
    try
    {
      Object localObject2 = (TroopFileTransferManager)TroopFileTransferManager.t().get(Long.valueOf(l));
      if (localObject2 == null)
      {
        if (QLog.isDevelopLevel())
        {
          paramDownloadFileRspBody = new StringBuilder();
          paramDownloadFileRspBody.append("bad troopUin");
          paramDownloadFileRspBody.append(l);
          QLog.i("TroopFileTransferManager", 4, paramDownloadFileRspBody.toString());
        }
        return;
      }
      String str = paramBundle.getString("itemKey");
      if (str == null) {
        return;
      }
      Object localObject1 = UUID.fromString(str);
      int i;
      boolean bool2;
      label234:
      boolean bool1;
      label973:
      try
      {
        localObject1 = (TroopFileTransferManager.Item)((TroopFileTransferManager)localObject2).l.get(localObject1);
        if (localObject1 == null)
        {
          if (QLog.isDevelopLevel())
          {
            paramDownloadFileRspBody = new StringBuilder();
            paramDownloadFileRspBody.append("bad item key");
            paramDownloadFileRspBody.append(str);
            QLog.i("TroopFileTransferManager", 4, paramDownloadFileRspBody.toString());
          }
          return;
        }
        i = FileManagerUtil.c(FileUtil.a(((TroopFileTransferManager.Item)localObject1).FileName));
        paramInt = paramBundle.getInt("thumbNail");
        bool2 = paramBundle.getBoolean("isPreview", false);
        paramBundle = new TroopFileTransferManager.PreviewInfo();
        paramBundle.f = -1;
      }
      finally {}
    }
    finally {}
    try
    {
      paramBundle.g = ((TroopFileTransferManager.Item)localObject1).Id.toString();
    }
    catch (NullPointerException localNullPointerException)
    {
      break label234;
    }
    paramBundle.g = null;
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("isSuccess=");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(", resp=");
      if (paramDownloadFileRspBody != null) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      ((StringBuilder)localObject2).append(bool1);
      QLog.i("TroopFileTransferManager", 4, ((StringBuilder)localObject2).toString());
    }
    if ((paramDownloadFileRspBody != null) && (paramBoolean))
    {
      i = paramDownloadFileRspBody.int32_ret_code.get();
      paramBundle.f = i;
      if (bool2)
      {
        paramBundle.a = false;
        paramBundle.b = paramDownloadFileRspBody.str_download_ip.get();
        if ((TextUtils.isEmpty(paramBundle.b)) || (paramBundle.b.equals("0.0.0.0"))) {
          paramBundle.b = paramDownloadFileRspBody.str_download_dns.get().toString();
        }
        paramBundle.c = String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get());
        paramBundle.d = paramDownloadFileRspBody.str_ret_msg.get();
        paramBundle.e = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      }
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("mReqDownloadFileObserver, fn=");
        ((StringBuilder)localObject2).append(((TroopFileTransferManager.Item)localObject1).FileName);
        ((StringBuilder)localObject2).append(", retCode=");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(", bPreview=");
        ((StringBuilder)localObject2).append(bool2);
        QLog.d(".troop.troop_file_video.thumb", 2, ((StringBuilder)localObject2).toString());
      }
      ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Middle_Fail = false;
      if (i < 0)
      {
        if (paramInt == 128)
        {
          ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Small = false;
          return;
        }
        if (paramInt == 640)
        {
          ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Large = false;
          return;
        }
        if (paramInt == 383)
        {
          ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Middle = false;
          ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Middle_Fail = true;
          if ((i != -103) && (i != -302) && (i != -301))
          {
            this.a.d((TroopFileTransferManager.Item)localObject1);
            return;
          }
          TroopFileTransferManager.a(this.a, (TroopFileTransferManager.Item)localObject1);
          return;
        }
        if (bool2)
        {
          TroopFileError.a(this.a.j, this.a.k, 700);
          if (TextUtils.isEmpty(paramBundle.d)) {
            paramBundle.d = HardCodeUtil.a(2131912627);
          }
          paramBundle.a = false;
          ((TroopFileHandler)this.a.j.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER)).c(paramBundle);
          return;
        }
        localObject2 = (QQAppInterface)this.mApp.get();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("download_failed,troopUin=");
        ((StringBuilder)localObject2).append(this.a.k);
        ((StringBuilder)localObject2).append(",fileName=");
        ((StringBuilder)localObject2).append(((TroopFileTransferManager.Item)localObject1).FileName);
        ((StringBuilder)localObject2).append(",filePath=");
        ((StringBuilder)localObject2).append(((TroopFileTransferManager.Item)localObject1).FilePath);
        ((StringBuilder)localObject2).append(",retCode=");
        ((StringBuilder)localObject2).append(i);
        QLog.i("TroopFileTransferManager", 1, ((StringBuilder)localObject2).toString());
        if ((i != -302) && (i != -301))
        {
          if (i == -134) {
            break label973;
          }
          if (i != -107)
          {
            if (i != -103) {
              if (i != -102) {
                break label973;
              }
            }
          }
          else
          {
            this.a.a((TroopFileTransferManager.Item)localObject1, 10, 101);
            if (paramInt == 0) {
              TroopTechReportUtils.b(TroopTechReportUtils.TroopFileReportResultCode.c, i);
            }
            return;
          }
        }
        TroopFileTransferManager.a(this.a, (TroopFileTransferManager.Item)localObject1, 301);
        if (((TroopFileTransferManager.Item)localObject1).TmpFile != null) {
          new File(((TroopFileTransferManager.Item)localObject1).TmpFile).delete();
        }
        ((TroopFileTransferManager.Item)localObject1).deleteThumbnailFile(this.a.k, 128);
        ((TroopFileTransferManager.Item)localObject1).deleteThumbnailFile(this.a.k, 640);
        TroopFileTransferManager.a(this.a, (TroopFileTransferManager.Item)localObject1);
        if (paramInt == 0) {
          TroopTechReportUtils.b(TroopTechReportUtils.TroopFileReportResultCode.c, i);
        }
        return;
      }
      if (bool2)
      {
        paramBundle.a = true;
        ((TroopFileHandler)this.a.j.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER)).c(paramBundle);
        return;
      }
      ((TroopFileTransferManager.Item)localObject1).cookieValue = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
      if (((TroopFileTransferManager.Item)localObject1).cookieValue != null) {
        ((TroopFileTransferManager.Item)localObject1).cookieValue = ((TroopFileTransferManager.Item)localObject1).cookieValue.toLowerCase();
      }
      ((TroopFileTransferManager.Item)localObject1).DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
      ((TroopFileTransferManager.Item)localObject1).DownloadUrl = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      ((TroopFileTransferManager.Item)localObject1).Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
      ((TroopFileTransferManager.Item)localObject1).NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
      if (TextUtils.isEmpty(((TroopFileTransferManager.Item)localObject1).DownloadIp)) {
        TroopTechReportUtils.a("gfile", "ipnull", "", "", "", "");
      }
      if ((i != -133) && (i != -132))
      {
        if (i == -134)
        {
          this.a.a((TroopFileTransferManager.Item)localObject1, 10, 302);
          if (paramInt == 0) {
            TroopTechReportUtils.b(TroopTechReportUtils.TroopFileReportResultCode.c, i);
          }
        }
      }
      else {
        this.a.a((TroopFileTransferManager.Item)localObject1, ((TroopFileTransferManager.Item)localObject1).Status, 309);
      }
      if ((paramInt != 128) && (paramInt != 383) && (paramInt != 640))
      {
        if (this.a.h((TroopFileTransferManager.Item)localObject1)) {
          return;
        }
        this.a.i[3].a(new TroopFileTransferManager.TaskHttpDownload(this.a, (TroopFileTransferManager.Item)localObject1));
        return;
      }
      paramDownloadFileRspBody = new TroopFileTransferManager.TaskHttpDownloadThumbnail(this.a, (TroopFileTransferManager.Item)localObject1, paramInt, String.valueOf(paramDownloadFileRspBody.uint32_preview_port.get()));
      this.a.i[4].a(paramDownloadFileRspBody);
      return;
    }
    if ((i == 2) && (QLog.isColorLevel()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("mReqDownloadFileObserver failed return, fn=");
      ((StringBuilder)localObject2).append(((TroopFileTransferManager.Item)localObject1).FileName);
      ((StringBuilder)localObject2).append(", isSucc");
      ((StringBuilder)localObject2).append(paramBoolean);
      ((StringBuilder)localObject2).append(", resp=");
      if (paramDownloadFileRspBody != null) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
      ((StringBuilder)localObject2).append(paramBoolean);
      QLog.e(".troop.troop_file_video.thumb", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramInt == 128)
    {
      ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Small = false;
      return;
    }
    if (paramInt == 640)
    {
      ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Large = false;
      return;
    }
    if (paramInt == 383)
    {
      ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Middle = false;
      ((TroopFileTransferManager.Item)localObject1).ThumbnailDownloading_Middle_Fail = true;
      this.a.d((TroopFileTransferManager.Item)localObject1);
      return;
    }
    if (bool2)
    {
      TroopFileError.a(this.a.j, this.a.k, 700);
      paramBundle.a = false;
      ((TroopFileHandler)this.a.j.getBusinessHandler(BusinessHandlerFactory.TROOP_FILE_HANDLER)).c(paramBundle);
      return;
    }
    this.a.a((TroopFileTransferManager.Item)localObject1, 10, 103);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileTransferManager.7
 * JD-Core Version:    0.7.0.1
 */