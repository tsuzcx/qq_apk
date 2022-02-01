package com.tencent.mobileqq.filemanager.fileviewer.data;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.troop.file.protocol.TroopFileReqDownloadFileObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.DomainInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo;
import com.tencent.mobileqq.filemanager.core.FileVideoDownloadManager.FileVideoManagerCallback;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TroopFileVideoOnlinePlayManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.Item;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x6d6.oidb_0x6d6.DownloadFileRspBody;

class VideoForTroop$1
  extends TroopFileReqDownloadFileObserver
{
  VideoForTroop$1(VideoForTroop paramVideoForTroop, FileVideoDownloadManager.FileVideoManagerCallback paramFileVideoManagerCallback) {}
  
  public void a(boolean paramBoolean, int paramInt, oidb_0x6d6.DownloadFileRspBody paramDownloadFileRspBody, Bundle paramBundle)
  {
    if (paramDownloadFileRspBody == null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("VideoForTroop<QFile>", 4, "error DownloadFileRspBody is null!!!!!");
      }
      this.a.a(-1, "");
      return;
    }
    paramBundle = TroopFileTransferManager.a(VideoForTroop.a(this.b).d);
    if (paramBundle == null)
    {
      QLog.e("VideoForTroop<QFile>", 1, "getUrl: onReqDownloadFileResult: get troopFileTransferManager failed.");
      return;
    }
    TroopFileTransferManager.Item localItem = paramBundle.i(VideoForTroop.b(this.b));
    if (localItem == null)
    {
      this.a.a(-2, "");
      return;
    }
    paramInt = paramDownloadFileRspBody.int32_ret_code.get();
    QLog.e("VideoForTroop<QFile>", 1, String.format("onRspDownload - retCode: %d", new Object[] { Integer.valueOf(paramInt) }));
    if (paramDownloadFileRspBody.bytes_cookie_val.has())
    {
      localItem.cookieValue = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_cookie_val.get().toByteArray());
      localItem.cookieValue = localItem.cookieValue.toLowerCase();
    }
    localItem.DownloadIp = paramDownloadFileRspBody.str_download_ip.get();
    localItem.DownloadUrl = HexUtil.bytes2HexStr(paramDownloadFileRspBody.bytes_download_url.get().toByteArray());
    localItem.Md5 = paramDownloadFileRspBody.bytes_md5.get().toByteArray();
    localItem.NameForSave = paramDownloadFileRspBody.str_save_file_name.get();
    if ((paramInt != -133) && (paramInt != -132) && (paramInt != -134))
    {
      if ((paramInt != -103) && (paramInt != -301))
      {
        paramBundle = localItem.DownloadIp;
        Object localObject = paramDownloadFileRspBody.str_download_dns.get().toStringUtf8();
        paramDownloadFileRspBody = paramBundle;
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          paramDownloadFileRspBody = paramBundle;
          if (FileIPv6StrateyController.b().isConfigEnableIPV6(this.b.a, 3))
          {
            paramDownloadFileRspBody = new StringBuilder();
            paramDownloadFileRspBody.append("[IPv6-File] troopVideo download. is config enable IPv6. domain[");
            paramDownloadFileRspBody.append((String)localObject);
            paramDownloadFileRspBody.append("]");
            QLog.i("VideoForTroop<QFile>", 1, paramDownloadFileRspBody.toString());
            paramDownloadFileRspBody = new FileIPv6StrateyController.DomainInfo((String)localObject, 0);
            paramDownloadFileRspBody = FileIPv6StrateyController.b().getIPlistForV6Domain(this.b.a, paramDownloadFileRspBody, 3);
            if ((paramDownloadFileRspBody != null) && (!paramDownloadFileRspBody.a()))
            {
              localObject = (FileIPv6StrateyController.IPInfo)paramDownloadFileRspBody.b.get(0);
              paramDownloadFileRspBody = paramBundle;
              if (localObject != null)
              {
                paramDownloadFileRspBody = paramBundle;
                if (!TextUtils.isEmpty(((FileIPv6StrateyController.IPInfo)localObject).a))
                {
                  paramDownloadFileRspBody = ((FileIPv6StrateyController.IPInfo)localObject).a;
                  paramBundle = new StringBuilder();
                  paramBundle.append("[IPv6-File] troopVideo download. use IPv6. hostlist:");
                  paramBundle.append(paramDownloadFileRspBody);
                  QLog.i("VideoForTroop<QFile>", 1, paramBundle.toString());
                }
              }
            }
            else
            {
              QLog.i("VideoForTroop<QFile>", 1, "[IPv6-File] troopVideo download. use IPv4");
              paramDownloadFileRspBody = paramBundle;
            }
          }
        }
        paramDownloadFileRspBody = TroopFileVideoOnlinePlayManager.a(paramDownloadFileRspBody, localItem.DownloadUrl, localItem.FilePath, localItem.cookieValue, "");
        paramBundle = new StringBuilder();
        paramBundle.append("troopVideo download. downloadUrl:");
        paramBundle.append(paramDownloadFileRspBody);
        QLog.i("VideoForTroop<QFile>", 1, paramBundle.toString());
        if (!TextUtils.isEmpty(paramDownloadFileRspBody))
        {
          this.a.a(paramDownloadFileRspBody, localItem.cookieValue);
          return;
        }
        this.a.a(-3, "");
        return;
      }
      paramDownloadFileRspBody = new StringBuilder();
      paramDownloadFileRspBody.append("file invalidate retCode = ");
      paramDownloadFileRspBody.append(paramInt);
      QLog.w("VideoForTroop<QFile>", 1, paramDownloadFileRspBody.toString());
      paramDownloadFileRspBody = String.format(this.b.a.getApp().getBaseContext().getString(2131895103), new Object[] { localItem.FileName });
      this.a.a(paramInt, paramDownloadFileRspBody);
      return;
    }
    paramDownloadFileRspBody = new StringBuilder();
    paramDownloadFileRspBody.append("file invalidate retCode = ");
    paramDownloadFileRspBody.append(paramInt);
    QLog.w("VideoForTroop<QFile>", 1, paramDownloadFileRspBody.toString());
    paramDownloadFileRspBody = String.format(this.b.a.getApp().getBaseContext().getString(2131895102), new Object[] { localItem.FileName });
    this.a.a(paramInt, paramDownloadFileRspBody);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.data.VideoForTroop.1
 * JD-Core Version:    0.7.0.1
 */