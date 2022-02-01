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
    if (TroopFileModel.a(this.a) == null) {
      return;
    }
    if (paramDownloadFileRspBody == null)
    {
      QLog.i("TroopFileModel<FileAssistant>", 1, "requestOnlinePreviewDownloadUrl: error DownloadFileRspBody is null!");
      TroopFileModel.a(this.a).c();
      return;
    }
    long l = paramBundle.getLong("troopUin");
    Object localObject2 = TroopFileTransferManager.a(l);
    if (localObject2 == null)
    {
      paramDownloadFileRspBody = new StringBuilder();
      paramDownloadFileRspBody.append("requestOnlinePreviewDownloadUrl: error bad troopUin[");
      paramDownloadFileRspBody.append(l);
      paramDownloadFileRspBody.append("]");
      QLog.i("TroopFileModel<FileAssistant>", 1, paramDownloadFileRspBody.toString());
      TroopFileModel.a(this.a).c();
      return;
    }
    Object localObject1 = paramBundle.getString("itemKey");
    if (localObject1 == null)
    {
      TroopFileModel.a(this.a).c();
      return;
    }
    paramBundle = ((TroopFileTransferManager)localObject2).a(UUID.fromString((String)localObject1));
    if (paramBundle == null)
    {
      paramDownloadFileRspBody = new StringBuilder();
      paramDownloadFileRspBody.append("requestOnlinePreviewDownloadUrl: error bad item key");
      paramDownloadFileRspBody.append((String)localObject1);
      paramDownloadFileRspBody.append("]");
      QLog.i("TroopFileModel<FileAssistant>", 1, paramDownloadFileRspBody.toString());
      TroopFileModel.a(this.a).c();
      return;
    }
    paramInt = paramDownloadFileRspBody.int32_ret_code.get();
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("requestOnlinePreviewDownloadUrl: onRspDownload - retCode[");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append("]");
      QLog.i("TroopFileModel<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = this.a;
    if (TroopFileModel.a((TroopFileModel)localObject1, paramInt, TroopFileModel.a((TroopFileModel)localObject1))) {
      return;
    }
    paramBundle.cookieValue = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
    if (paramBundle.cookieValue != null) {
      paramBundle.cookieValue = paramBundle.cookieValue.toLowerCase();
    }
    paramBundle.DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
    paramBundle.DownloadUrl = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
    paramBundle.Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
    paramBundle.NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
    localObject1 = paramBundle.DownloadIp;
    localObject2 = paramBundle.DownloadUrl;
    String str1 = paramBundle.FilePath;
    String str2 = paramBundle.cookieValue;
    paramDownloadFileRspBody = "";
    localObject1 = TroopFileVideoOnlinePlayManager.a((String)localObject1, (String)localObject2, str1, str2, "");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      TroopFileModel.a(this.a).a((String)localObject1, paramBundle.cookieValue);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("requestOnlinePreviewDownloadUrl: url[");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("], cookies [");
        ((StringBuilder)localObject2).append(paramBundle.cookieValue);
        ((StringBuilder)localObject2).append("]");
        QLog.i("TroopFileModel<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
      }
      if (this.a.a.a() != null) {
        paramDownloadFileRspBody = String.valueOf(this.a.a.a().TroopUin);
      }
      if (this.a.a.a() != null) {
        paramBundle = FileManagerUtil.b(this.a.a.a().nFileType);
      } else {
        paramBundle = "unknow";
      }
      ReportController.b(null, "dc00899", "Grp_files", "", "oper", "Clk_pre_video", 0, 0, paramDownloadFileRspBody, "", paramBundle, "1");
      return;
    }
    TroopFileModel.a(this.a).c();
    if (QLog.isColorLevel())
    {
      paramDownloadFileRspBody = new StringBuilder();
      paramDownloadFileRspBody.append("requestOnlinePreviewDownloadUrl: url[");
      paramDownloadFileRspBody.append((String)localObject1);
      paramDownloadFileRspBody.append("], cookies [");
      paramDownloadFileRspBody.append(paramBundle.cookieValue);
      paramDownloadFileRspBody.append("]");
      QLog.i("TroopFileModel<FileAssistant>", 2, paramDownloadFileRspBody.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.TroopFileModel.16
 * JD-Core Version:    0.7.0.1
 */