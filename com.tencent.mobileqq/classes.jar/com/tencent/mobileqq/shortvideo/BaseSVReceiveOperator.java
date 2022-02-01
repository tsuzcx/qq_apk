package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicInfoInterface.ErrInfo;
import com.tencent.mobileqq.shortvideo.api.IShortVideoOperator;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class BaseSVReceiveOperator
  implements DownCallBack, IShortVideoOperator
{
  public BaseQQAppInterface a;
  public ShortVideoReq b;
  protected UiCallBack c;
  public String d;
  public String e;
  protected Handler f;
  
  public BaseSVReceiveOperator() {}
  
  public BaseSVReceiveOperator(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.a = paramBaseQQAppInterface;
    if (this.f == null) {
      this.f = new BaseSVReceiveOperator.1(this, Looper.getMainLooper());
    }
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, ShortVideoReq paramShortVideoReq)
  {
    ThreadManager.post(new BaseSVReceiveOperator.2(paramBaseQQAppInterface, paramShortVideoReq), 8, null, false);
  }
  
  public MessageRecord a(ShortVideoForwardInfo paramShortVideoForwardInfo)
  {
    return null;
  }
  
  public MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    return null;
  }
  
  public ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    return null;
  }
  
  protected void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.f.sendMessage(localMessage);
  }
  
  protected void a(int paramInt, PicInfoInterface.ErrInfo paramErrInfo)
  {
    ShortVideoResult localShortVideoResult = new ShortVideoResult();
    localShortVideoResult.c = this.b;
    localShortVideoResult.b = paramErrInfo;
    localShortVideoResult.a = -1;
    a(paramInt, -1, localShortVideoResult);
    if (paramErrInfo != null)
    {
      Logger.b(this.e, this.d, paramErrInfo.a, paramErrInfo.b);
      return;
    }
    Logger.b(this.e, this.d, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    Object localObject = paramShortVideoResult;
    if (paramShortVideoResult == null) {
      localObject = new ShortVideoResult();
    }
    ((ShortVideoResult)localObject).a = 0;
    ((ShortVideoResult)localObject).c = this.b;
    a(paramInt, 0, localObject);
    paramShortVideoResult = this.e;
    localObject = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("what:");
    localStringBuilder.append(paramInt);
    Logger.a(paramShortVideoResult, (String)localObject, "handleSuccess", localStringBuilder.toString());
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    ShortVideoResult localShortVideoResult = new ShortVideoResult();
    localShortVideoResult.a = 0;
    localShortVideoResult.d = Integer.valueOf(paramInt);
    a(1, 0, localShortVideoResult);
  }
  
  public void a(Message paramMessage)
  {
    String str1 = this.e;
    String str2 = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("what:");
    localStringBuilder.append(paramMessage.what);
    localStringBuilder.append(",result:");
    localStringBuilder.append(paramMessage.arg1);
    localStringBuilder.append(",obj:");
    localStringBuilder.append(paramMessage.obj);
    Logger.a(str1, str2, "dispatchMessage", localStringBuilder.toString());
    if (this.c == null) {
      return;
    }
    int i = paramMessage.arg1;
    int j = paramMessage.what;
    if (j != 0)
    {
      if (j != 1) {
        return;
      }
      paramMessage = (ShortVideoResult)paramMessage.obj;
      if ((paramMessage.d instanceof Integer)) {
        this.c.a(((Integer)paramMessage.d).intValue());
      }
    }
    else
    {
      paramMessage = (ShortVideoResult)paramMessage.obj;
      this.c.a(i, paramMessage);
    }
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.a = paramBaseQQAppInterface;
  }
  
  public void a(MessageRecord paramMessageRecord) {}
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    if (paramDownResult == null)
    {
      paramDownResult = new PicInfoInterface.ErrInfo();
      paramDownResult.b = "result == null";
      paramDownResult.a = "onDownload";
      a(0, paramDownResult);
      return;
    }
    a(this.a, this.b);
    Object localObject1 = this.e;
    Object localObject2 = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("result:");
    localStringBuilder.append(paramDownResult.a);
    Logger.a((String)localObject1, (String)localObject2, "onDownload", localStringBuilder.toString());
    localObject1 = new ShortVideoResult();
    ((ShortVideoResult)localObject1).a = paramDownResult.a;
    ((ShortVideoResult)localObject1).d = paramDownResult;
    if (paramDownResult.a == 0)
    {
      a(0, (ShortVideoResult)localObject1);
      return;
    }
    if (paramDownResult.d == null)
    {
      localObject1 = new PicInfoInterface.ErrInfo();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramDownResult.b);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramDownResult.c);
      ((PicInfoInterface.ErrInfo)localObject1).b = ((StringBuilder)localObject2).toString();
      ((PicInfoInterface.ErrInfo)localObject1).a = "onDownload";
      a(0, (PicInfoInterface.ErrInfo)localObject1);
      return;
    }
    a(0, paramDownResult.d);
  }
  
  public void a(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    Object localObject = this.e;
    String str = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start ");
    localStringBuilder.append(Thread.currentThread().getId());
    Logger.a((String)localObject, str, "downloadShortVideo", localStringBuilder.toString());
    if (b(paramShortVideoDownloadInfo))
    {
      c(paramShortVideoDownloadInfo);
      return;
    }
    localObject = new DownCallBack.DownResult();
    ((DownCallBack.DownResult)localObject).a = -1;
    ((DownCallBack.DownResult)localObject).d = paramShortVideoDownloadInfo.V;
    a((DownCallBack.DownResult)localObject);
  }
  
  public void a(ShortVideoReq paramShortVideoReq)
  {
    this.b = paramShortVideoReq;
  }
  
  public void a(UiCallBack paramUiCallBack) {}
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public void a(ArrayList<ShortVideoForwardInfo> paramArrayList) {}
  
  public ShortVideoForwardInfo b(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    return null;
  }
  
  public void b(ShortVideoForwardInfo paramShortVideoForwardInfo) {}
  
  public void b(ShortVideoUploadInfo paramShortVideoUploadInfo) {}
  
  public void b(String paramString)
  {
    this.e = paramString;
  }
  
  boolean b(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    if (paramShortVideoDownloadInfo != null)
    {
      String str1 = this.e;
      String str2 = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("info:");
      localStringBuilder.append(paramShortVideoDownloadInfo);
      Logger.a(str1, str2, "checkShortVideoDownloadInfo", localStringBuilder.toString());
      return paramShortVideoDownloadInfo.b();
    }
    Logger.b(this.e, this.d, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  void c(ShortVideoDownloadInfo paramShortVideoDownloadInfo)
  {
    long l = System.currentTimeMillis();
    paramShortVideoDownloadInfo.d = this.a.getCurrentAccountUin();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = paramShortVideoDownloadInfo.d;
    localTransferRequest.mPeerUin = paramShortVideoDownloadInfo.e;
    localTransferRequest.mSecondId = paramShortVideoDownloadInfo.f;
    localTransferRequest.mUinType = paramShortVideoDownloadInfo.c;
    localTransferRequest.mUniseq = paramShortVideoDownloadInfo.g;
    localTransferRequest.mIsUp = false;
    localTransferRequest.mBusiType = paramShortVideoDownloadInfo.b;
    localTransferRequest.mDownMode = paramShortVideoDownloadInfo.r;
    localTransferRequest.mExtraObj = Integer.valueOf(paramShortVideoDownloadInfo.s);
    localTransferRequest.mIsOnlyGetUrl = paramShortVideoDownloadInfo.t;
    if ((paramShortVideoDownloadInfo.q == 1001) || (paramShortVideoDownloadInfo.q == 1003) || (paramShortVideoDownloadInfo.q == 1005) || (paramShortVideoDownloadInfo.q == 1007) || (paramShortVideoDownloadInfo.q == 1002) || (paramShortVideoDownloadInfo.q == 1004) || (paramShortVideoDownloadInfo.q == 1006) || (paramShortVideoDownloadInfo.q == 1008)) {
      localTransferRequest.mMd5 = paramShortVideoDownloadInfo.i;
    }
    if (this.c != null) {
      localTransferRequest.mDownCallBack = this;
    }
    switch (paramShortVideoDownloadInfo.q)
    {
    default: 
      break;
    case 1008: 
      localTransferRequest.mFileType = 68;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.p);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.a);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.q);
      localTransferRequest.mLocalPath = ((StringBuilder)localObject).toString();
      break;
    case 1007: 
      localTransferRequest.mFileType = 67;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.o);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.a);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.q);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.l);
      localTransferRequest.mLocalPath = ((StringBuilder)localObject).toString();
      break;
    case 1006: 
      localTransferRequest.mFileType = 18;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.p);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.a);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.q);
      localTransferRequest.mLocalPath = ((StringBuilder)localObject).toString();
      break;
    case 1005: 
      localTransferRequest.mFileType = 17;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.o);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.a);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.q);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.l);
      localTransferRequest.mLocalPath = ((StringBuilder)localObject).toString();
      break;
    case 1004: 
      localTransferRequest.mFileType = 16;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.p);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.a);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.q);
      localTransferRequest.mLocalPath = ((StringBuilder)localObject).toString();
      break;
    case 1003: 
      localTransferRequest.mFileType = 9;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.o);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.a);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.q);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.l);
      localTransferRequest.mLocalPath = ((StringBuilder)localObject).toString();
      break;
    case 1002: 
      localTransferRequest.mFileType = 7;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.p);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.a);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.q);
      localTransferRequest.mLocalPath = ((StringBuilder)localObject).toString();
      break;
    case 1001: 
      localTransferRequest.mFileType = 6;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.o);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.a);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.q);
      ((StringBuilder)localObject).append("QQ_&_MoblieQQ_&_QQ");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.l);
      localTransferRequest.mLocalPath = ((StringBuilder)localObject).toString();
    }
    Object localObject = this.b;
    if ((localObject != null) && (((ShortVideoReq)localObject).j != null)) {
      localTransferRequest.mRec = this.b.j;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" startDownloadVideo downloadvideo fileType==");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.q);
      ((StringBuilder)localObject).append("downloadvideo MD5==");
      ((StringBuilder)localObject).append(paramShortVideoDownloadInfo.i);
      QLog.d("ShortVideoItemBuilder", 2, ((StringBuilder)localObject).toString());
    }
    ((ITransFileController)this.a.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
    paramShortVideoDownloadInfo = this.e;
    localObject = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cost:");
    localStringBuilder.append(System.currentTimeMillis() - l);
    Logger.a(paramShortVideoDownloadInfo, (String)localObject, "doDownloadShortVideo", localStringBuilder.toString());
    paramShortVideoDownloadInfo = this.e;
    localObject = this.d;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("TransferRequest: ");
    localStringBuilder.append(localTransferRequest.toString());
    Logger.a(paramShortVideoDownloadInfo, (String)localObject, "doDownloadShortVideo.start", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseSVReceiveOperator
 * JD-Core Version:    0.7.0.1
 */