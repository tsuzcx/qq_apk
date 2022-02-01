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
    if (paramIntent.getLongExtra("token_task_id", 0L) != paramFileManagerEntity.uniseq) {}
    for (;;)
    {
      return;
      long l1 = paramIntent.getLongExtra("token_current_size", 0L);
      long l2 = paramIntent.getLongExtra("token_total_size", 0L);
      paramFileManagerEntity.status = 2;
      if (l2 != 0L) {}
      for (paramFileManagerEntity.fProgress = ((float)l1 / (float)l2); this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null; paramFileManagerEntity.fProgress = 1.0F)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.a(paramFileManagerEntity.fProgress);
        return;
      }
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
    QLog.d("MPcFileModel<FileAssistant>", 2, "BROADCAST_MPFILE_DOWNLOAD_COMPLETED , currentSize:" + l2 + ",isSucceed:" + bool + ",http_code:" + j);
    paramIntent = new ReportItem();
    paramIntent.uSessionID = l1;
    paramIntent.uChannelType = 6;
    paramIntent.bSend = false;
    paramIntent.uNotifyTime = MPcFileModel.a(this.a);
    paramIntent.uFileSize = l2;
    paramIntent.bFileExist = false;
    paramIntent.uStartPos = 0L;
    paramIntent.uTaskStart = MPcFileModel.a(this.a);
    paramIntent.uTaskEnd = MPcFileModel.b(this.a);
    paramIntent.uDuration = (MPcFileModel.b(this.a) - MPcFileModel.a(this.a));
    paramIntent.bUserRetry = false;
    paramIntent.sSuffix = "";
    int i;
    if (bool)
    {
      i = 2;
      paramIntent.emResult = i;
      paramIntent.nFailCode = 0;
      paramIntent.nUserCode = j;
      Object localObject = ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a().a();
      if (localObject == null) {
        break label491;
      }
      paramIntent.dwServerIP = DBNetworkUtil.a(((ServerInfo)localObject).jdField_a_of_type_JavaLangString);
      paramIntent.wServerPort = ((short)((ServerInfo)localObject).jdField_a_of_type_Int);
      label282:
      paramIntent.dwClientIP = DBNetworkUtil.a(DBNetworkUtil.a());
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (paramFileManagerEntity.peerDin != 0L) {
        break label504;
      }
      i = QualityReportUtil.b;
      label314:
      QualityReportUtil.a((QQAppInterface)localObject, paramIntent, i);
      if (bool) {
        break label596;
      }
      paramFileManagerEntity.status = 3;
      if ((j != 2) && (j != 3) && (j != 4) && (j != 5) && (j != 8)) {
        break label511;
      }
      FMToastUtil.a(2131694282);
      label367:
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.g();
      }
    }
    label699:
    for (;;)
    {
      ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a().a(paramFileManagerEntity.strDataLineMPFileID);
      if (MPcFileModel.a(this.a)) {
        break label701;
      }
      paramFileManagerEntity.mContext = "needMPFileC2C";
      QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + MPcFileModel.a(this.a) + ",create mEntity.mContext");
      return;
      if (MPcFileModel.b(this.a))
      {
        i = 32;
        break;
      }
      i = 41;
      break;
      label491:
      paramIntent.dwServerIP = 0;
      paramIntent.wServerPort = 0;
      break label282;
      label504:
      i = QualityReportUtil.d;
      break label314;
      label511:
      if (j == 1)
      {
        FMToastUtil.a(2131694280);
        break label367;
      }
      if (j == 1004)
      {
        FMToastUtil.a(2131694281);
        break label367;
      }
      if (j == 11)
      {
        QLog.d("MPcFileModel<FileAssistant>", 2, "cancel file download!");
        break label367;
      }
      if (j == 12)
      {
        QLog.d("MPcFileModel<FileAssistant>", 2, "cancel file predownload!");
        break label367;
      }
      MPcFileModel.a(this.a, j + 2100);
      break label367;
      label596:
      paramFileManagerEntity.status = 1;
      paramIntent = ((DataLineHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a().b();
      if (paramIntent == null) {
        if (QLog.isColorLevel()) {
          QLog.d("MPcFileModel<FileAssistant>", 2, "doDownload , plugin service not started");
        }
      }
      for (;;)
      {
        if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener == null) {
          break label699;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerModelFileBrowserModelBase$OnTransEventListener.f();
        break;
        paramFileManagerEntity.setFilePath(String.format("%s/%s", new Object[] { paramIntent, paramFileManagerEntity.fileName }));
        paramFileManagerEntity.setCloudType(3);
      }
    }
    label701:
    QLog.d("MPcFileModel<FileAssistant>", 2, "mConnPCSuc:" + MPcFileModel.a(this.a) + "mEntity.mContext = null");
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
    QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "mainReceiver MPFILE_ACTION_HOST_INFO_UPDATE,ret:" + i);
    if (MPcFileModel.c(this.a) != l) {}
    do
    {
      boolean bool;
      do
      {
        return;
        if (i != 0) {
          break;
        }
        i = paramFileManagerEntity.getInt("result");
        paramIntent = paramFileManagerEntity.getByteArray("bytes_json");
        j = paramFileManagerEntity.getInt("power");
        MPcFileModel.b(this.a, j);
        bool = paramFileManagerEntity.getBoolean("inputPwdError", false);
        switch (i)
        {
        default: 
          QLog.d("MPcFileModel<FileAssistant>", 1, "andorid 6.3.0 accept valid C2C response:" + i);
          return;
        case 0: 
          this.a.r();
          return;
        case 1: 
        case 2: 
        case 3: 
        case 4: 
          MPcFileModel.a(this.a, i + 2000);
        }
      } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser == null);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(false);
      return;
      this.a.a(paramIntent, bool);
      return;
      this.a.a(paramIntent);
      return;
      this.a.s();
      return;
      this.a.t();
      return;
      if (i == 1013)
      {
        FMToastUtil.a(2131694267);
        return;
      }
      if (i == 1014)
      {
        FMToastUtil.a(2131694309);
        return;
      }
      MPcFileModel.a(this.a, i);
    } while (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser == null);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileBrowser.a(false);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerIFileViewerAdapter.a();
    if (paramIntent == null) {}
    String str;
    do
    {
      do
      {
        return;
        str = paramIntent.getAction();
      } while (str == null);
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
    } while (!MpFileConstant.g.equalsIgnoreCase(str));
    MPcFileModel.a(this.a, false);
    QLog.d("MPcFileModel<FileAssistant>[MPFile]", 1, "channelReceiver MPFILE_ACTION_CHANNEL_DISCONNECT!");
    FMToastUtil.a(2131694281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.model.MPcFileModel.DataLineMPReceiver
 * JD-Core Version:    0.7.0.1
 */