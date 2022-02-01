package com.tencent.mobileqq.filemanager.fileviewer.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.dataline.util.DBNetworkUtil;
import com.dataline.util.QualityReportUtil;
import com.tencent.litetransfersdk.ReportItem;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileviewer.IFileBrowser;
import com.tencent.mobileqq.filemanager.fileviewer.IFileViewerAdapter;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqdataline.MpFileConstant;
import cooperation.qqdataline.ServerInfo;
import cooperation.qqdataline.ipc.DatalineRemoteManager;

class MPcFileModel$DataLineMPReceiver
  extends BroadcastReceiver
{
  MPcFileModel$DataLineMPReceiver(MPcFileModel paramMPcFileModel) {}
  
  private void a(Intent paramIntent, FileManagerEntity paramFileManagerEntity)
  {
    if (paramIntent.getLongExtra("token_task_id", 0L) != paramFileManagerEntity.uniseq) {
      return;
    }
    long l1 = paramIntent.getLongExtra("token_current_size", 0L);
    long l2 = paramIntent.getLongExtra("token_total_size", 0L);
    paramFileManagerEntity.status = 2;
    if (l2 != 0L) {
      paramFileManagerEntity.fProgress = ((float)l1 / (float)l2);
    } else {
      paramFileManagerEntity.fProgress = 1.0F;
    }
    if (this.a.q != null) {
      this.a.q.a(paramFileManagerEntity.fProgress);
    }
  }
  
  private void b(Intent paramIntent, FileManagerEntity paramFileManagerEntity)
  {
    long l1 = paramIntent.getLongExtra("token_task_id", 0L);
    if (l1 != paramFileManagerEntity.uniseq) {
      return;
    }
    MPcFileModel.b(this.a, NetConnInfoCenter.getServerTimeMillis());
    long l2 = paramIntent.getLongExtra("token_current_size", 0L);
    boolean bool = paramIntent.getBooleanExtra("token_is_success", false);
    int j = paramIntent.getIntExtra("token_http_code", 0);
    paramIntent = new StringBuilder();
    paramIntent.append("BROADCAST_MPFILE_DOWNLOAD_COMPLETED , currentSize:");
    paramIntent.append(l2);
    paramIntent.append(",isSucceed:");
    paramIntent.append(bool);
    paramIntent.append(",http_code:");
    paramIntent.append(j);
    QLog.d("MPcFileModel<FileAssistant>", 2, paramIntent.toString());
    paramIntent = new ReportItem();
    paramIntent.uSessionID = l1;
    paramIntent.uChannelType = 6;
    paramIntent.bSend = false;
    paramIntent.uNotifyTime = MPcFileModel.c(this.a);
    paramIntent.uFileSize = l2;
    paramIntent.bFileExist = false;
    paramIntent.uStartPos = 0L;
    paramIntent.uTaskStart = MPcFileModel.c(this.a);
    paramIntent.uTaskEnd = MPcFileModel.d(this.a);
    paramIntent.uDuration = (MPcFileModel.d(this.a) - MPcFileModel.c(this.a));
    paramIntent.bUserRetry = false;
    paramIntent.sSuffix = "";
    int i;
    if (bool) {
      i = 2;
    } else if (MPcFileModel.e(this.a)) {
      i = 32;
    } else {
      i = 41;
    }
    paramIntent.emResult = i;
    paramIntent.nFailCode = 0;
    paramIntent.nUserCode = j;
    Object localObject = ((DataLineHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a().c();
    if (localObject != null)
    {
      paramIntent.dwServerIP = DBNetworkUtil.a(((ServerInfo)localObject).a);
      paramIntent.wServerPort = ((short)((ServerInfo)localObject).b);
    }
    else
    {
      paramIntent.dwServerIP = 0;
      paramIntent.wServerPort = 0;
    }
    paramIntent.dwClientIP = DBNetworkUtil.a(DBNetworkUtil.a());
    localObject = this.a.a;
    if (paramFileManagerEntity.peerDin == 0L) {
      i = QualityReportUtil.b;
    } else {
      i = QualityReportUtil.d;
    }
    QualityReportUtil.a((QQAppInterface)localObject, paramIntent, i);
    if (!bool)
    {
      paramFileManagerEntity.status = 3;
      if ((j != 2) && (j != 3) && (j != 4) && (j != 5) && (j != 8))
      {
        if (j == 1) {
          FMToastUtil.a(2131891883);
        } else if (j == 1004) {
          FMToastUtil.a(2131891884);
        } else if (j == 11) {
          QLog.d("MPcFileModel<FileAssistant>", 2, "cancel file download!");
        } else if (j == 12) {
          QLog.d("MPcFileModel<FileAssistant>", 2, "cancel file predownload!");
        } else {
          MPcFileModel.a(this.a, j + 2100);
        }
      }
      else {
        FMToastUtil.a(2131891885);
      }
      if (this.a.q != null) {
        this.a.q.g();
      }
    }
    else
    {
      paramFileManagerEntity.status = 1;
      paramIntent = ((DataLineHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a().e();
      if (paramIntent == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
        }
      }
      else
      {
        paramFileManagerEntity.setFilePath(String.format("%s/%s", new Object[] { paramIntent, paramFileManagerEntity.fileName }));
        paramFileManagerEntity.setCloudType(3);
      }
      if (this.a.q != null) {
        this.a.q.f();
      }
    }
    ((DataLineHandler)this.a.a.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a().b(paramFileManagerEntity.strDataLineMPFileID);
    if (!MPcFileModel.b(this.a))
    {
      paramFileManagerEntity.mContext = "needMPFileC2C";
      paramIntent = new StringBuilder();
      paramIntent.append("mConnPCSuc:");
      paramIntent.append(MPcFileModel.b(this.a));
      paramIntent.append(",create mEntity.mContext");
      QLog.d("MPcFileModel<FileAssistant>", 2, paramIntent.toString());
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("mConnPCSuc:");
    paramIntent.append(MPcFileModel.b(this.a));
    paramIntent.append("mEntity.mContext = null");
    QLog.d("MPcFileModel<FileAssistant>", 2, paramIntent.toString());
    paramFileManagerEntity.mContext = null;
  }
  
  private void c(Intent paramIntent, FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramIntent.getExtras();
    long l = paramIntent.getLongExtra(MpFileConstant.f, 0L);
    int i = paramFileManagerEntity.getInt(MpFileConstant.e);
    int j = paramFileManagerEntity.getInt("result");
    if ((i == 0) && (j == 0)) {
      MPcFileModel.a(this.a, true);
    }
    paramIntent = new StringBuilder();
    paramIntent.append("mainReceiver MPFILE_ACTION_HOST_INFO_UPDATE,ret:");
    paramIntent.append(i);
    QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, paramIntent.toString());
    if (MPcFileModel.f(this.a) != l) {
      return;
    }
    if (i == 0)
    {
      i = paramFileManagerEntity.getInt("result");
      paramIntent = paramFileManagerEntity.getByteArray("bytes_json");
      j = paramFileManagerEntity.getInt("power");
      MPcFileModel.b(this.a, j);
      boolean bool = paramFileManagerEntity.getBoolean("inputPwdError", false);
      switch (i)
      {
      default: 
        paramIntent = new StringBuilder();
        paramIntent.append("andorid 6.3.0 accept valid C2C response:");
        paramIntent.append(i);
        QLog.d("MPcFileModel<FileAssistant>", 1, paramIntent.toString());
        return;
      case 8: 
        this.a.ay();
        return;
      case 7: 
        this.a.ax();
        return;
      case 6: 
        this.a.a(paramIntent);
        return;
      case 5: 
        this.a.a(paramIntent, bool);
        return;
      case 1: 
      case 2: 
      case 3: 
      case 4: 
        MPcFileModel.a(this.a, i + 2000);
        if (this.a.k == null) {
          break;
        }
        this.a.k.a(false);
        return;
      case 0: 
        this.a.aw();
        return;
      }
    }
    else
    {
      if (i == 1013)
      {
        FMToastUtil.a(2131891870);
        return;
      }
      if (i == 1014)
      {
        FMToastUtil.a(2131891912);
        return;
      }
      MPcFileModel.a(this.a, i);
      if (this.a.k != null) {
        this.a.k.a(false);
      }
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.c.r();
    if (paramIntent == null) {
      return;
    }
    String str = paramIntent.getAction();
    if (str == null) {
      return;
    }
    if (str.equals("com.dataline.mpfile.download_progress"))
    {
      a(paramIntent, paramContext);
      return;
    }
    if (str.equals("com.dataline.mpfile.download_completed"))
    {
      b(paramIntent, paramContext);
      return;
    }
    if (MpFileConstant.d.equalsIgnoreCase(str))
    {
      c(paramIntent, paramContext);
      return;
    }
    if (MpFileConstant.g.equalsIgnoreCase(str))
    {
      MPcFileModel.a(this.a, false);
      QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "channelReceiver MPFILE_ACTION_CHANNEL_DISCONNECT!");
      FMToastUtil.a(2131891884);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.MPcFileModel.DataLineMPReceiver
 * JD-Core Version:    0.7.0.1
 */