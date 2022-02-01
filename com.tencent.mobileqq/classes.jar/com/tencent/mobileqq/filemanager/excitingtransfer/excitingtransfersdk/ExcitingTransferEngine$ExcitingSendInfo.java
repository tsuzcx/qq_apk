package com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk;

public class ExcitingTransferEngine$ExcitingSendInfo
{
  public ExcitingTransferUploadBizInfo mBusInfo;
  public ExcitingTransferUploadChnConfigInfo mConfig;
  public ExcitingTransferUploadFileEntry mFileEntry;
  public ExcitingTransferUploadReqInfo mReqInfo;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reqinfo:{");
    localStringBuilder.append(this.mReqInfo.toString());
    localStringBuilder.append("} fileentry{");
    localStringBuilder.append(this.mFileEntry.toString());
    localStringBuilder.append("} busInfo{");
    localStringBuilder.append(this.mBusInfo.toString());
    localStringBuilder.append("} config {");
    localStringBuilder.append(this.mConfig.toString());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.ExcitingSendInfo
 * JD-Core Version:    0.7.0.1
 */