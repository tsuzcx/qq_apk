package com.tencent.mobileqq.transfile;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForPtt;

public class BasePttDownloaderProcessor
  extends BaseDownloadProcessor
{
  AppInterface app;
  
  public BasePttDownloaderProcessor() {}
  
  public BasePttDownloaderProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.app = this.app;
  }
  
  public String getPttStorePath(String paramString1, String paramString2, int paramInt)
  {
    paramString2 = new StringBuilder();
    paramString2.append(AppConstants.SDCARD_PATH);
    paramString2.append(this.app.getAccount());
    paramString2.append("/");
    paramString2.append("ptt");
    paramString2.append("/");
    paramString2.append(paramString1);
    paramString2.append("_");
    paramString2.append(FileMsg.getTransFileDateTime());
    paramString2.append(".amr");
    return MessageForPtt.getLocalFilePath(paramInt, paramString2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BasePttDownloaderProcessor
 * JD-Core Version:    0.7.0.1
 */