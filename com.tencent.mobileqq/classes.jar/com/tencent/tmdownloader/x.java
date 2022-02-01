package com.tencent.tmdownloader;

import android.os.Handler;
import android.os.Message;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.internal.downloadclient.c;

class x
  extends Handler
{
  x(TMAssistantDownloadService paramTMAssistantDownloadService) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      ab.c("TMADownloadSDKService", "MSG_HANDSHAKE_YYB......");
      TMAssistantDownloadService.access$200(this.a).a();
      return;
    }
    ab.c("TMADownloadSDKService", "MSG_INIT_YYBMG......");
    if ((GlobalUtil.getInstance().getQQDownloaderAPILevel() < 5) && (GlobalUtil.getInstance().getQQDownloaderConnectLevel() < 1)) {
      return;
    }
    if (TMAssistantDownloadService.access$200(this.a) == null) {
      TMAssistantDownloadService.access$202(this.a, new c());
    }
    TMAssistantDownloadService.access$200(this.a).a(this.a.getApplicationContext(), "TMAssistantYYBManager");
    TMAssistantDownloadService.access$200(this.a).b(this.a.getApplicationContext(), "open_sdkcom.tencent.mobileqq:web");
    sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.x
 * JD-Core Version:    0.7.0.1
 */