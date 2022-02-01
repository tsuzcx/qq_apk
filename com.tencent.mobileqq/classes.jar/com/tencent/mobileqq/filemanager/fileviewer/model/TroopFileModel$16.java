package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopFileVideoOnlinePlayManager;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.UUID;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class TroopFileModel$16
  extends TroopFileReqDownloadFileObserver
{
  TroopFileModel$16(TroopFileModel paramTroopFileModel) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (TroopFileModel.a(this.a) == null) {}
    Object localObject;
    label546:
    do
    {
      do
      {
        return;
        if (paramDownloadFileRspBody == null)
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl: error DownloadFileRspBody is null!");
          TroopFileModel.a(this.a).c();
          return;
        }
        long l = paramBundle.getLong("troopUin");
        localObject = TroopFileTransferManager.a(l);
        if (localObject == null)
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl: error bad troopUin[" + l + "]");
          TroopFileModel.a(this.a).c();
          return;
        }
        paramBundle = paramBundle.getString("itemKey");
        if (paramBundle == null)
        {
          TroopFileModel.a(this.a).c();
          return;
        }
        localObject = ((TroopFileTransferManager)localObject).a(UUID.fromString(paramBundle));
        if (localObject == null)
        {
          QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl: error bad item key" + paramBundle + "]");
          TroopFileModel.a(this.a).c();
          return;
        }
        paramInt = paramDownloadFileRspBody.int32_ret_code.get();
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileModel<FileAssistant>", 2, "requestOnlinePreviewDownloadUrl: onRspDownload - retCode[" + paramInt + "]");
        }
      } while (TroopFileModel.a(this.a, paramInt, TroopFileModel.a(this.a)));
      ((TroopFileTransferManager.Item)localObject).cookieValue = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
      if (((TroopFileTransferManager.Item)localObject).cookieValue != null) {
        ((TroopFileTransferManager.Item)localObject).cookieValue = ((TroopFileTransferManager.Item)localObject).cookieValue.toLowerCase();
      }
      ((TroopFileTransferManager.Item)localObject).DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
      ((TroopFileTransferManager.Item)localObject).DownloadUrl = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
      ((TroopFileTransferManager.Item)localObject).Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
      ((TroopFileTransferManager.Item)localObject).NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
      paramDownloadFileRspBody = TroopFileVideoOnlinePlayManager.a(((TroopFileTransferManager.Item)localObject).DownloadIp, ((TroopFileTransferManager.Item)localObject).DownloadUrl, ((TroopFileTransferManager.Item)localObject).FilePath, ((TroopFileTransferManager.Item)localObject).cookieValue, "");
      if (!TextUtils.isEmpty(paramDownloadFileRspBody))
      {
        TroopFileModel.a(this.a).a(paramDownloadFileRspBody, ((TroopFileTransferManager.Item)localObject).cookieValue);
        if (QLog.isColorLevel()) {
          QLog.i("TroopFileModel<FileAssistant>", 2, "requestOnlinePreviewDownloadUrl: url[" + paramDownloadFileRspBody + "], cookies [" + ((TroopFileTransferManager.Item)localObject).cookieValue + "]");
        }
        if (this.a.a.a() != null)
        {
          paramDownloadFileRspBody = String.valueOf(this.a.a.a().TroopUin);
          if (this.a.a.a() == null) {
            break label546;
          }
        }
        for (paramBundle = FileManagerUtil.b(this.a.a.a().nFileType);; paramBundle = "unknow")
        {
          ReportController.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, paramDownloadFileRspBody, "", paramBundle, "1");
          return;
          paramDownloadFileRspBody = "";
          break;
        }
      }
      TroopFileModel.a(this.a).c();
    } while (!QLog.isColorLevel());
    QLog.i("TroopFileModel<FileAssistant>", 2, "requestOnlinePreviewDownloadUrl: url[" + paramDownloadFileRspBody + "], cookies [" + ((TroopFileTransferManager.Item)localObject).cookieValue + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.16
 * JD-Core Version:    0.7.0.1
 */