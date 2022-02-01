package com.tencent.mobileqq.shortvideo;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;

public class ShortVideoPreDownloaderWithSdkSupport$PreDownloadHandler
  implements Callback
{
  public View a;
  private ShortVideoReq c;
  private String[] d;
  private String e;
  
  public ShortVideoPreDownloaderWithSdkSupport$PreDownloadHandler(ShortVideoPreDownloaderWithSdkSupport paramShortVideoPreDownloaderWithSdkSupport, ShortVideoReq paramShortVideoReq)
  {
    this.c = paramShortVideoReq;
    this.a = new View(BaseApplicationImpl.getApplication());
  }
  
  private void a()
  {
    if (!QQVideoPlaySDKManager.isSDKReady()) {
      QQVideoPlaySDKManager.initSDKAsync(this.b.a.getApplication(), new ShortVideoPreDownloaderWithSdkSupport.PreDownloadHandler.1(this));
    }
    b();
    BaseSVReceiveOperator.a(this.b.a, this.c);
  }
  
  private void b()
  {
    if (this.b.q == null) {
      this.b.q = SuperPlayerFactory.createPreDownloader(BaseApplicationImpl.getContext(), 101);
    }
    String str = SVUtils.a(this.c.j, "mp4");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.c.j.getMd5());
    ((StringBuilder)localObject).append(this.c.j.uniseq);
    localObject = ((StringBuilder)localObject).toString();
    localObject = SuperPlayerFactory.createVideoInfoForUrl(this.d, 101, (String)localObject, str);
    long l1 = this.c.j.videoFileTime;
    int i = this.c.j.videoFileSize;
    long l2 = ShortVideoUtils.getPreDownloadTime();
    this.b.q.startPreDownload((SuperPlayerVideoInfo)localObject, l1 * 1000L, l2 * 1000L);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("pre-download handle short video:");
      ((StringBuilder)localObject).append(str);
      QLog.d("ShortVideoPreDownloader", 2, ((StringBuilder)localObject).toString());
    }
    this.c.j.setBitValue(0, (byte)1);
    this.c.j.serial();
    this.b.a.getMessageFacade().a(this.c.j.frienduin, this.c.j.istroop, this.c.j.uniseq, this.c.j.msgData);
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    if (paramFileMsg.uniseq != this.c.j.uniseq) {
      return;
    }
    if ((paramFileMsg.fileType == 6) || (paramFileMsg.fileType == 17) || (paramFileMsg.fileType == 9) || (paramFileMsg.fileType == 20))
    {
      paramInt1 = paramFileMsg.status;
      if (paramInt1 != 2002)
      {
        if ((paramInt1 != 2004) && (paramInt1 != 2005) && (paramInt1 != 5001) && (paramInt1 != 5002)) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_FAILED");
        }
        if (this.c.o != null) {
          this.c.o.a(paramFileMsg.status);
        }
        ShortVideoPreDownloaderWithSdkSupport.a(this.b).remove(this);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoPreDownloader", 2, "STATUS_RECV_PROCESS: get url finished");
      }
      if (paramFileMsg.urls != null)
      {
        this.d = paramFileMsg.urls;
        this.e = paramFileMsg.domain;
        paramInt1 = 0;
        while (paramInt1 < 1)
        {
          if (!StringUtil.isEmpty(this.e))
          {
            paramView = new StringBuilder();
            paramFileMsg = this.d;
            paramView.append(paramFileMsg[paramInt1]);
            paramView.append("&txhost=");
            paramView.append(this.e);
            paramFileMsg[paramInt1] = paramView.toString();
          }
          paramInt1 += 1;
        }
        paramView = this.c;
        paramView.q = this.d;
        if (paramView.n) {
          ShortVideoPreDownloaderWithSdkSupport.a(this.b, this.c);
        } else {
          a();
        }
      }
      ShortVideoPreDownloaderWithSdkSupport.a(this.b).remove(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoPreDownloaderWithSdkSupport.PreDownloadHandler
 * JD-Core Version:    0.7.0.1
 */