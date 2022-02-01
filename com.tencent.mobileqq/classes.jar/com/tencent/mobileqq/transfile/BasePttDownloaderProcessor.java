package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;

public class BasePttDownloaderProcessor
  extends BaseDownloadProcessor
{
  public BasePttDownloaderProcessor() {}
  
  public BasePttDownloaderProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
  }
  
  public String getPttStorePath(String paramString1, String paramString2, int paramInt)
  {
    return MessageForPtt.getLocalFilePath(paramInt, AppConstants.SDCARD_PATH + this.app.getAccount() + "/" + "ptt" + "/" + paramString1 + "_" + FileMsg.getTransFileDateTime() + ".amr");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BasePttDownloaderProcessor
 * JD-Core Version:    0.7.0.1
 */