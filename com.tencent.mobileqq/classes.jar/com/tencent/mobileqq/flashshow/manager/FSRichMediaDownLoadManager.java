package com.tencent.mobileqq.flashshow.manager;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.biz.qcircleshadow.lib.variation.HostFileUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostHttpUtils;
import com.tencent.biz.qcircleshadow.lib.variation.HostNetworkUtils;
import com.tencent.mobileqq.flashshow.api.constants.FSConstants;
import com.tencent.mobileqq.flashshow.application.FSApplication;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class FSRichMediaDownLoadManager
{
  private static final String a;
  private static volatile FSRichMediaDownLoadManager b;
  private HandlerThread c = new HandlerThread("FSRichMediaDownLoadManager");
  private Handler d;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FSConstants.FS_DOWNLOAD_ROOT_PATH);
    localStringBuilder.append("feedRichMedia/");
    a = localStringBuilder.toString();
  }
  
  private FSRichMediaDownLoadManager()
  {
    this.c.start();
    this.d = new Handler(this.c.getLooper());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(".nomedia");
    HostFileUtils.createFileIfNotExits(localStringBuilder.toString());
    HostStaticInvokeHelper.registerNetworkMonitorReceiver();
  }
  
  public static FSRichMediaDownLoadManager a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new FSRichMediaDownLoadManager();
        }
      }
      finally {}
    }
    return b;
  }
  
  private boolean b(FSRichMediaDownLoadManager.DownLoadParams paramDownLoadParams)
  {
    if (HostFileUtils.moveFile(paramDownLoadParams.c(), FSRichMediaDownLoadManager.DownLoadParams.b(paramDownLoadParams)))
    {
      Object localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      ((Intent)localObject).setData(Uri.fromFile(new File(FSRichMediaDownLoadManager.DownLoadParams.b(paramDownLoadParams))));
      FSApplication.APP.sendBroadcast((Intent)localObject);
      if (FSRichMediaDownLoadManager.DownLoadParams.a(paramDownLoadParams) != null) {
        FSRichMediaDownLoadManager.DownLoadParams.a(paramDownLoadParams).a(true);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramDownLoadParams.a());
      ((StringBuilder)localObject).append(" ,move file to local album ");
      QLog.d("FSRichMediaDownLoadManager", 1, ((StringBuilder)localObject).toString());
      return true;
    }
    HostFileUtils.delete(paramDownLoadParams.c(), true);
    return false;
  }
  
  private void c(FSRichMediaDownLoadManager.DownLoadParams paramDownLoadParams)
  {
    this.d.post(new FSRichMediaDownLoadManager.2(this, paramDownLoadParams));
  }
  
  private void d(FSRichMediaDownLoadManager.DownLoadParams paramDownLoadParams)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramDownLoadParams.a());
    ((StringBuilder)localObject).append(",download start ");
    QLog.d("FSRichMediaDownLoadManager", 1, ((StringBuilder)localObject).toString());
    localObject = new HttpNetReq();
    ((HttpNetReq)localObject).mCallback = new FSRichMediaDownLoadManager.3(this, paramDownLoadParams);
    ((HttpNetReq)localObject).mReqUrl = paramDownLoadParams.a();
    ((HttpNetReq)localObject).mHttpMethod = 0;
    ((HttpNetReq)localObject).mOutPath = paramDownLoadParams.c();
    ((HttpNetReq)localObject).mContinuErrorLimit = HostNetworkUtils.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    HostHttpUtils.httpEngineServiceSendRequest((HttpNetReq)localObject);
    HostStaticInvokeHelper.addNetwortChangedObserver(new FSRichMediaDownLoadManager.DownLoadChangObserver(paramDownLoadParams, (HttpNetReq)localObject));
  }
  
  public void a(FSRichMediaDownLoadManager.DownLoadParams paramDownLoadParams)
  {
    if (paramDownLoadParams == null) {
      return;
    }
    this.d.post(new FSRichMediaDownLoadManager.1(this, paramDownLoadParams));
  }
  
  public void b()
  {
    this.d.removeCallbacks(null);
    HostFileUtils.deleteDirectory(a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.manager.FSRichMediaDownLoadManager
 * JD-Core Version:    0.7.0.1
 */