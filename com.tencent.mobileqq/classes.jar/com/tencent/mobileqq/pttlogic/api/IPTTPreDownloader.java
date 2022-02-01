package com.tencent.mobileqq.pttlogic.api;

import android.os.Handler.Callback;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.transfile.TransferRequest.PttDownExtraInfo;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IPTTPreDownloader
  extends Handler.Callback, IRuntimeService
{
  public static final int CONSUME_ERROR = 3;
  public static final int CONSUME_PLAY = 2;
  public static final int CONSUME_VIEW = 1;
  
  public abstract void onAddrProviderReady(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void onDownloadFinish(boolean paramBoolean, int paramInt, TransferRequest.PttDownExtraInfo paramPttDownExtraInfo, MessageForPtt paramMessageForPtt);
  
  public abstract boolean onPlayPTT(MessageForPtt paramMessageForPtt);
  
  public abstract boolean onReceivedPTTMsg(MessageForPtt paramMessageForPtt);
  
  public abstract boolean onViewPTT(MessageForPtt paramMessageForPtt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.IPTTPreDownloader
 * JD-Core Version:    0.7.0.1
 */