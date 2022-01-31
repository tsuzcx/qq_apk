package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

import android.support.annotation.NonNull;

public class ExcitingTransferEngine$ExcitingSendInfo
{
  public ExcitingTransferUploadBizInfo mBusInfo;
  public ExcitingTransferUploadChnConfigInfo mConfig;
  public ExcitingTransferUploadFileEntry mFileEntry;
  public ExcitingTransferUploadReqInfo mReqInfo;
  
  @NonNull
  public String toString()
  {
    return "reqinfo:{" + this.mReqInfo.toString() + "} fileentry{" + this.mFileEntry.toString() + "} busInfo{" + this.mBusInfo.toString() + "} config {" + this.mConfig.toString() + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.ExcitingSendInfo
 * JD-Core Version:    0.7.0.1
 */