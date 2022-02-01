package com.tencent.mobileqq.kandian.biz.ugc.upload;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJUgcVideoUploader
  implements IVideoUploader
{
  private QQAppInterface a;
  private long b;
  private String c;
  private IVideoUploadListener<String> d;
  @SuppressLint({"HandlerLeak"})
  private TransProcessorHandler e = new RIJUgcVideoUploader.1(this);
  
  public RIJUgcVideoUploader(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void c()
  {
    ((ITransFileController)this.a.getRuntimeService(ITransFileController.class)).removeHandle(this.e);
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pause, path=");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(",uniSeq=");
    ((StringBuilder)localObject).append(this.b);
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, ((StringBuilder)localObject).toString());
    localObject = (ITransFileController)this.a.getRuntimeService(ITransFileController.class);
    if (localObject != null)
    {
      localObject = (BaseTransProcessor)((ITransFileController)localObject).findProcessor("0", this.b);
      if (localObject != null) {
        ((BaseTransProcessor)localObject).pause();
      }
    }
    c();
  }
  
  public void a(IVideoUploadListener<String> paramIVideoUploadListener)
  {
    this.d = paramIVideoUploadListener;
  }
  
  public void a(String paramString)
  {
    Object localObject = (ITransFileController)this.a.getRuntimeService(ITransFileController.class);
    if (this.e.getFilter().size() == 0) {
      this.e.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    }
    ((ITransFileController)localObject).addHandle(this.e);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mCommandId = 54;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localTransferRequest.mPeerUin = "0";
    localTransferRequest.mSelfUin = this.a.getCurrentAccountUin();
    localTransferRequest.mFileType = 24;
    localTransferRequest.mRichTag = "KandianUGCVideoUpload";
    ((ITransFileController)localObject).transferAsync(localTransferRequest);
    this.b = localTransferRequest.mUniseq;
    this.c = paramString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("upload, path=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",uniSeq=");
    ((StringBuilder)localObject).append(this.b);
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, ((StringBuilder)localObject).toString());
  }
  
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cancel, path=");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append(",uniSeq=");
    ((StringBuilder)localObject).append(this.b);
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, ((StringBuilder)localObject).toString());
    localObject = (ITransFileController)this.a.getRuntimeService(ITransFileController.class);
    if (localObject != null)
    {
      localObject = (BaseTransProcessor)((ITransFileController)localObject).findProcessor("0", this.b);
      if (localObject != null) {
        ((BaseTransProcessor)localObject).cancel();
      }
    }
    c();
  }
  
  public void b(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("resume, uploadKey=");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, ((StringBuilder)localObject).toString());
    if (this.e.getFilter().isEmpty()) {
      this.e.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    }
    localObject = (ITransFileController)this.a.getRuntimeService(ITransFileController.class);
    ((ITransFileController)localObject).addHandle(this.e);
    try
    {
      paramString = new JSONObject(paramString);
      if (this.b == 0L)
      {
        this.b = paramString.optInt("uniseq", 0);
        this.c = paramString.optString("localPath", "");
        QLog.i("RIJUGC.RIJUgcVideoUploader", 1, "resume from app reboot");
      }
    }
    catch (JSONException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resume, e=");
      localStringBuilder.append(QLog.getStackTraceString(paramString));
      QLog.e("RIJUGC.RIJUgcVideoUploader", 1, localStringBuilder.toString());
    }
    paramString = (BaseTransProcessor)((ITransFileController)localObject).findProcessor("0", this.b);
    if (paramString != null)
    {
      paramString.resume();
      return;
    }
    a(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.upload.RIJUgcVideoUploader
 * JD-Core Version:    0.7.0.1
 */