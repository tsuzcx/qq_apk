package com.tencent.mobileqq.uftransfer.common.transfer.download;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadCompletedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferDownloadSpeedInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferOneSlotComplete;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferRecvListener;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileDownloader;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileDownloaderProp.ExtfDownloadFileInfo;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileDownloaderProp.ExtfFDlderProp;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;

public class UFTExtfFileDownloader
  extends UFTFileDownloaderCbWrapper
  implements IExcitingTransferRecvListener, IUFTFileDownloader
{
  protected int a;
  protected final long a;
  protected ExcitingTransferDownloadCompletedInfo a;
  protected UFTFileDownloaderProp.ExtfFDlderProp a;
  protected String a;
  protected boolean a;
  protected long b;
  protected long c;
  
  private void a(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.b != 0L)
    {
      ExcitingTransferEngine.getInstance().cancelRecvFile(this.b);
      this.b = 0L;
    }
    a(true, paramInt, this.c, "", "", paramExcitingTransferDownloadCompletedInfo);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onOneSlotComplete(int paramInt, ExcitingTransferOneSlotComplete paramExcitingTransferOneSlotComplete)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] ^_^ OnOneSlotComplete:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" RP:");
    String str2 = "";
    if (paramExcitingTransferOneSlotComplete != null) {
      str1 = paramExcitingTransferOneSlotComplete.toString();
    } else {
      str1 = "";
    }
    localStringBuilder.append(str1);
    UFTLog.b("[UFTTransfer] UFTExtfFileDownloader", 1, localStringBuilder.toString());
    String str1 = str2;
    if (paramExcitingTransferOneSlotComplete != null) {
      str1 = paramExcitingTransferOneSlotComplete.mstrIp;
    }
    this.jdField_a_of_type_JavaLangString = str1;
    int i;
    if (paramExcitingTransferOneSlotComplete != null) {
      i = paramExcitingTransferOneSlotComplete.mPort;
    } else {
      i = 0;
    }
    this.jdField_a_of_type_Int = i;
    if (paramInt == 0)
    {
      a(paramExcitingTransferOneSlotComplete);
      return;
    }
    a(false, paramInt, this.c, "", "", paramExcitingTransferOneSlotComplete);
  }
  
  public void onRecvComplete(int paramInt, ExcitingTransferDownloadCompletedInfo paramExcitingTransferDownloadCompletedInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] onExcitingDownloadResult suc:");
    localStringBuilder.append(bool);
    localStringBuilder.append(" errcode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" RP:");
    String str2 = "";
    String str1;
    if (paramExcitingTransferDownloadCompletedInfo != null) {
      str1 = paramExcitingTransferDownloadCompletedInfo.toString();
    } else {
      str1 = "";
    }
    localStringBuilder.append(str1);
    UFTLog.b("[UFTTransfer] UFTExtfFileDownloader", 1, localStringBuilder.toString());
    if ((bool) && (this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileDownloaderProp$ExtfFDlderProp.a() != null)) {
      this.c = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileDownloaderProp$ExtfFDlderProp.a().a();
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferDownloadCompletedInfo = paramExcitingTransferDownloadCompletedInfo;
    this.b = 0L;
    if (paramExcitingTransferDownloadCompletedInfo != null) {
      str1 = paramExcitingTransferDownloadCompletedInfo.mstrLastServerHost;
    } else {
      str1 = "";
    }
    this.jdField_a_of_type_JavaLangString = str1;
    if (bool)
    {
      str1 = str2;
      if (paramExcitingTransferDownloadCompletedInfo != null) {
        str1 = paramExcitingTransferDownloadCompletedInfo.mstrFileSavePath;
      }
      a(str1, paramExcitingTransferDownloadCompletedInfo);
      return;
    }
    a(paramInt, paramExcitingTransferDownloadCompletedInfo);
  }
  
  public void onRecvProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.c = paramLong2;
    a(paramLong2, this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileDownloaderProp$ExtfFDlderProp.a().a());
  }
  
  public void onRecvStart()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] onExcitingSendStart.");
    UFTLog.b("[UFTTransfer] UFTExtfFileDownloader", 1, localStringBuilder.toString());
    a(0L, this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileDownloaderProp$ExtfFDlderProp.a().a());
  }
  
  public void onSpeed(ExcitingTransferDownloadSpeedInfo paramExcitingTransferDownloadSpeedInfo)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i;
    if (paramExcitingTransferDownloadSpeedInfo != null) {
      i = paramExcitingTransferDownloadSpeedInfo.mTotalSpeed;
    } else {
      i = 0;
    }
    a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.download.UFTExtfFileDownloader
 * JD-Core Version:    0.7.0.1
 */