package com.tencent.mobileqq.troop.filemanager.download;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.HttpUrlProcessor;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class FtnDownloader
  implements IHttpCommunicatorListener
{
  private final QQAppInterface a;
  private final long b;
  private final int c;
  private final int d;
  private long e;
  private HttpMsg f;
  private boolean g = true;
  private FtnDownloader.IHttpDownloadSink h;
  private boolean i = false;
  private String j;
  
  public FtnDownloader(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, String paramString)
  {
    this.a = paramQQAppInterface;
    this.b = paramLong1;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramLong2;
    this.i = paramBoolean;
    this.j = paramString;
  }
  
  public void a()
  {
    this.g = true;
    if (this.f != null)
    {
      int k = TroopFileTransferUtil.Log.b;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("] cancel ftn download");
      TroopFileTransferUtil.Log.c("FtnDownloader", k, ((StringBuilder)localObject).toString());
      localObject = (IHttpEngineService)this.a.getRuntimeService(IHttpEngineService.class, "all");
      if (localObject == null)
      {
        this.f = null;
        return;
      }
      localObject = ((IHttpEngineService)localObject).getCommunicator();
      if (localObject == null)
      {
        this.f = null;
        return;
      }
      ((HttpCommunicator)localObject).cancelMsg(this.f);
      this.f = null;
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, HttpMsg paramHttpMsg)
  {
    int k = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("] ftn download err. errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" errMsg:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" rspHeader:");
    ((StringBuilder)localObject).append(paramString2);
    TroopFileTransferUtil.Log.a("FtnDownloader", k, ((StringBuilder)localObject).toString());
    this.g = true;
    localObject = this.h;
    if (localObject != null) {
      ((FtnDownloader.IHttpDownloadSink)localObject).a(paramInt, paramString1, paramString2, paramHttpMsg);
    }
  }
  
  public void a(FtnDownloader.IHttpDownloadSink paramIHttpDownloadSink)
  {
    this.h = paramIHttpDownloadSink;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    int k = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("] ftn download url:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" pos:");
    ((StringBuilder)localObject).append(paramLong);
    TroopFileTransferUtil.Log.c("FtnDownloader", k, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.g = false;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bytes=");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("-");
    String str = ((StringBuilder)localObject).toString();
    HttpMsg localHttpMsg = new HttpMsg(paramString, null, this, true);
    localHttpMsg.setInstanceFollowRedirects(false);
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      localObject = "wifi";
    } else {
      localObject = "gprs";
    }
    localHttpMsg.setRequestProperty("Net-type", (String)localObject);
    localHttpMsg.setRequestProperty("cache-control", "no-cache");
    if (paramLong != 0L) {
      localHttpMsg.setRequestProperty("Range", str);
    }
    localHttpMsg.setPriority(5);
    localHttpMsg.setDataSlice(true);
    localHttpMsg.fileType = this.d;
    localHttpMsg.busiType = this.c;
    localHttpMsg.msgId = String.valueOf(this.b);
    localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
    localObject = this.h;
    if (localObject != null) {
      ((FtnDownloader.IHttpDownloadSink)localObject).b(localHttpMsg);
    }
    if (paramString != null) {
      localObject = paramString.toLowerCase();
    } else {
      localObject = "";
    }
    if ((this.i) && (((String)localObject).startsWith("https")))
    {
      localHttpMsg.mIsHttps = true;
      localHttpMsg.mIsHostIP = HttpUrlProcessor.a(paramString);
      localHttpMsg.mReqHost = this.j;
    }
    localHttpMsg.timeoutParam = FileManagerUtil.h();
    paramString = ((IHttpEngineService)this.a.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator();
    if (paramString == null)
    {
      this.f = null;
      QLog.e("FtnDownloader", 1, "----IHttpEngineService getCommunicator return null!");
      return false;
    }
    ((HttpCommunicator)paramString).sendMsg(localHttpMsg);
    this.f = localHttpMsg;
    return true;
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.g) {
      return;
    }
    Object localObject = this.f;
    int k;
    if (paramHttpMsg1 != localObject)
    {
      if ((paramHttpMsg1 != null) && (localObject != null))
      {
        k = TroopFileTransferUtil.Log.b;
        paramHttpMsg2 = new StringBuilder();
        paramHttpMsg2.append("[");
        paramHttpMsg2.append(this.b);
        paramHttpMsg2.append("],Req Serial[");
        paramHttpMsg2.append(String.valueOf(paramHttpMsg1.getSerial()));
        paramHttpMsg2.append("], curRequest Serial[");
        paramHttpMsg2.append(String.valueOf(this.f.getSerial()));
        paramHttpMsg2.append("]");
        TroopFileTransferUtil.Log.a("FtnDownloader", k, paramHttpMsg2.toString());
        return;
      }
      if (paramHttpMsg1 != null)
      {
        k = TroopFileTransferUtil.Log.b;
        paramHttpMsg2 = new StringBuilder();
        paramHttpMsg2.append("[");
        paramHttpMsg2.append(this.b);
        paramHttpMsg2.append("],Req Serial[");
        paramHttpMsg2.append(String.valueOf(paramHttpMsg1.getSerial()));
        paramHttpMsg2.append("]");
        TroopFileTransferUtil.Log.a("FtnDownloader", k, paramHttpMsg2.toString());
        return;
      }
      if (this.f != null)
      {
        k = TroopFileTransferUtil.Log.b;
        paramHttpMsg1 = new StringBuilder();
        paramHttpMsg1.append("[");
        paramHttpMsg1.append(this.b);
        paramHttpMsg1.append("],curRequest Serial[");
        paramHttpMsg1.append(String.valueOf(this.f.getSerial()));
        paramHttpMsg1.append("]");
        TroopFileTransferUtil.Log.a("FtnDownloader", k, paramHttpMsg1.toString());
      }
      return;
    }
    if ((paramHttpMsg2.getResponseCode() != 206) && (paramHttpMsg2.getResponseCode() != 200))
    {
      k = TroopFileTransferUtil.Log.b;
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[");
      paramHttpMsg1.append(this.b);
      paramHttpMsg1.append("] ftn download decode resp code no 200|206");
      TroopFileTransferUtil.Log.a("FtnDownloader", k, paramHttpMsg1.toString());
      return;
    }
    paramHttpMsg1 = paramHttpMsg2.getRecvData();
    long l = paramHttpMsg2.getTotalLen();
    if (this.e == 0L) {
      this.e = l;
    }
    localObject = this.h;
    if (localObject != null) {
      ((FtnDownloader.IHttpDownloadSink)localObject).a(paramHttpMsg1, l, paramHttpMsg2.rawReqHeader);
    }
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.g) {
      return;
    }
    if (paramHttpMsg2 != null)
    {
      a(paramHttpMsg2.errCode, paramHttpMsg2.getErrorString(), paramHttpMsg2.rawRespHeader, paramHttpMsg2);
      return;
    }
    a(9001, "err no response", "", null);
  }
  
  public void handleRedirect(String paramString)
  {
    if (this.g) {
      return;
    }
    int k = TroopFileTransferUtil.Log.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("] ftn download Redirect. ");
    ((StringBuilder)localObject).append(paramString);
    TroopFileTransferUtil.Log.a("FtnDownloader", k, ((StringBuilder)localObject).toString());
    localObject = this.h;
    if (localObject != null) {
      ((FtnDownloader.IHttpDownloadSink)localObject).b(paramString);
    }
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (5 == paramInt)
    {
      if (this.g) {
        return true;
      }
      this.g = true;
      paramHttpMsg1 = this.h;
      if (paramHttpMsg1 != null)
      {
        paramHttpMsg1.b();
        return true;
      }
    }
    else if (3 == paramInt)
    {
      if (this.g) {
        return true;
      }
      paramHttpMsg1 = this.h;
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(paramHttpMsg2);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.FtnDownloader
 * JD-Core Version:    0.7.0.1
 */