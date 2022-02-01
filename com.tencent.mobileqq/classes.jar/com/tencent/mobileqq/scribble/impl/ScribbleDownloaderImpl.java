package com.tencent.mobileqq.scribble.impl;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.pic.BasePicPreDownloadUtils;
import com.tencent.mobileqq.scribble.IScribbleDownloader;
import com.tencent.mobileqq.scribble.ScribbleDownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class ScribbleDownloaderImpl
  implements Handler.Callback, IScribbleDownloader
{
  static final int MAX_HANDLING_DOWNLOADING = 2;
  static final int MSG_OPEN_PRE_DOWNLOADING = 111;
  public String TAG = "ScribbleDownloader";
  AppRuntime mApp;
  AtomicBoolean mIsPreDownloaderOpen = new AtomicBoolean(true);
  public ScribbleDownloaderImpl.DownloadListManager mListManager = new ScribbleDownloaderImpl.DownloadListManager(this);
  protected Handler subHandler;
  
  private void addDownload(ScribbleDownloadInfo paramScribbleDownloadInfo)
  {
    int i = this.mListManager.a(paramScribbleDownloadInfo);
    paramScribbleDownloadInfo = new StringBuilder();
    paramScribbleDownloadInfo.append("result is ");
    paramScribbleDownloadInfo.append(i);
    log("addDownload", paramScribbleDownloadInfo.toString());
    consumeDownload();
  }
  
  private void consumeDownload()
  {
    if (this.mListManager.a() < 2)
    {
      ScribbleDownloadInfo localScribbleDownloadInfo = this.mListManager.a();
      if (localScribbleDownloadInfo == null)
      {
        log("consumeDownload", "removeOneFromWaitToDowning is null");
        return;
      }
      doDownload(localScribbleDownloadInfo);
      return;
    }
    log("consumeDownload", "donwloading is max threads");
  }
  
  private void doDownload(ScribbleDownloadInfo paramScribbleDownloadInfo)
  {
    ThreadManager.post(new ScribbleDownloaderImpl.1(this, paramScribbleDownloadInfo), 5, null, false);
  }
  
  private boolean isNeedPreDownload()
  {
    int i = BasePicPreDownloadUtils.a();
    if (i != 0)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Not Wifi, networkType=");
      localStringBuilder.append(i);
      localStringBuilder.append(", no need to predownload");
      log("isNeedPreDownload", localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  private void log(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = paramString2;
      if (paramString2 == null) {
        str = "";
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append("(): ");
      paramString2.append(str);
      QLog.d(this.TAG, 2, paramString2.toString());
    }
  }
  
  private void logE(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append("(): ");
    paramString2.append(str);
    QLog.e(this.TAG, 2, paramString2.toString());
  }
  
  public void DownloadFromAio(MessageForScribble paramMessageForScribble)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uniseq=");
    localStringBuilder.append(paramMessageForScribble.uniseq);
    log("DownloadFromAio", localStringBuilder.toString());
    addDownload(new ScribbleDownloadInfo(paramMessageForScribble, 201));
  }
  
  public void PreDownloadFromMsg(MessageForScribble paramMessageForScribble)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uniseq=");
    localStringBuilder.append(paramMessageForScribble.uniseq);
    log("PreDownloadFromMsg", localStringBuilder.toString());
    if (isNeedPreDownload())
    {
      addDownload(new ScribbleDownloadInfo(paramMessageForScribble, 200));
      return;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("no NeedPreDownload uniseq=");
    localStringBuilder.append(paramMessageForScribble.uniseq);
    log("PreDownloadFromMsg", localStringBuilder.toString());
  }
  
  public void checkBDHsessionkey()
  {
    int i = 0;
    try
    {
      if (SessionInfo.getInstance(this.mApp.getCurrentUin()).getHttpconn_sig_session() != null) {
        i = SessionInfo.getInstance(this.mApp.getCurrentUin()).getHttpconn_sig_session().length;
      }
      if (i == 0) {
        HwServlet.getConfig(this.mApp, this.mApp.getCurrentUin());
      }
      return;
    }
    finally {}
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 111)
    {
      if (!this.mIsPreDownloaderOpen.get())
      {
        this.mIsPreDownloaderOpen.set(true);
        paramMessage = new StringBuilder();
        paramMessage.append("MSG_OPEN_PRE_DOWNLOADING, mIsPreDownloaderOpen=");
        paramMessage.append(this.mIsPreDownloaderOpen.get());
        log("handleMessage", paramMessage.toString());
      }
      return true;
    }
    return false;
  }
  
  public void off()
  {
    this.mIsPreDownloaderOpen.set(false);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mIsPreDownloaderOpen=");
    localStringBuilder.append(this.mIsPreDownloaderOpen.get());
    log("off", localStringBuilder.toString());
    this.subHandler.sendEmptyMessageDelayed(111, 60000L);
  }
  
  public void on()
  {
    this.mIsPreDownloaderOpen.set(true);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" mIsPreDownloaderOpen=");
    localStringBuilder.append(this.mIsPreDownloaderOpen.get());
    log("on", localStringBuilder.toString());
    consumeDownload();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
    this.subHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
  }
  
  public void onDestroy()
  {
    log("onDestroy", null);
  }
  
  public int removeDownloadedMsg(MessageForScribble paramMessageForScribble)
  {
    int i = this.mListManager.a(paramMessageForScribble);
    paramMessageForScribble = new StringBuilder();
    paramMessageForScribble.append(" result is ");
    paramMessageForScribble.append(i);
    log("removeDownloadedMsg", paramMessageForScribble.toString());
    consumeDownload();
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.scribble.impl.ScribbleDownloaderImpl
 * JD-Core Version:    0.7.0.1
 */