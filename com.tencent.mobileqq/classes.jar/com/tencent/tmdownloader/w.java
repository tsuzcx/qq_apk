package com.tencent.tmdownloader;

import android.os.Handler;
import android.os.Message;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.downloadclient.c;

class w
  extends Handler
{
  w(TMAssistantDownloadService paramTMAssistantDownloadService) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 0: 
      do
      {
        return;
        r.c("TMADownloadSDKService", "MSG_INIT_YYBMG......");
      } while ((GlobalUtil.getInstance().getQQDownloaderAPILevel() < 5) && (GlobalUtil.getInstance().getQQDownloaderConnectLevel() < 1));
      if (TMAssistantDownloadService.access$200(this.a) == null) {
        TMAssistantDownloadService.access$202(this.a, new c());
      }
      TMAssistantDownloadService.access$200(this.a).a(this.a.getApplicationContext(), "TMAssistantYYBManager");
      TMAssistantDownloadService.access$200(this.a).b(this.a.getApplicationContext(), "open_sdkcom.tencent.mobileqq:web");
      sendEmptyMessage(1);
      return;
    }
    r.c("TMADownloadSDKService", "MSG_HANDSHAKE_YYB......");
    TMAssistantDownloadService.access$200(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.w
 * JD-Core Version:    0.7.0.1
 */