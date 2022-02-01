package com.tencent.mobileqq.kandian.biz.ugc.video.transfer;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.mp.bigFileUpload.BigFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class VideoUploadController
  extends FileUploadController
{
  TransProcessorHandler d = new VideoUploadController.2(this);
  private TransferRequest e = null;
  private String f = null;
  private String g = null;
  private String h = null;
  private String i = null;
  private String j = null;
  private long k;
  private long l;
  
  public VideoUploadController(Context paramContext, QQAppInterface paramQQAppInterface, FileUploadController.FileUploadListener paramFileUploadListener, String paramString)
  {
    super(paramContext, paramQQAppInterface, paramFileUploadListener);
    this.i = paramString;
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.a);
    String str = RIJQQAppInterfaceUtil.d();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverVideoUploadVideo", bool, this.l - this.k, 0L, localHashMap, "");
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("finish: retCode - ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" fileUrl : ");
    localStringBuilder.append(paramString1);
    QLog.d("VideoUploadController", 2, localStringBuilder.toString());
    this.l = System.currentTimeMillis();
    a(paramInt);
    if (this.c != null) {
      this.c.a(paramInt, paramString1, paramString2, paramString3);
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "cancelUploadVideo");
    }
    Object localObject = (ITransFileController)this.b.getRuntimeService(ITransFileController.class);
    if (localObject != null)
    {
      TransferRequest localTransferRequest = this.e;
      if (localTransferRequest != null)
      {
        localObject = (BaseTransProcessor)((ITransFileController)localObject).findProcessor(localTransferRequest.mPeerUin, this.e.mUniseq);
        if (localObject != null)
        {
          ((BaseTransProcessor)localObject).cancel();
          this.e = null;
        }
      }
    }
  }
  
  public void a(FileMsg paramFileMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send finished!");
    }
    Object localObject = new bigFileUpload.BigFileExtRsp();
    try
    {
      ((bigFileUpload.BigFileExtRsp)localObject).mergeFrom(paramFileMsg.bdhExtendInfo);
      m = ((bigFileUpload.BigFileExtRsp)localObject).int32_retcode.get();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mVideoTransProcessorHandler rsp.errorCode:");
        localStringBuilder.append(m);
        QLog.d("VideoUploadController", 2, localStringBuilder.toString());
      }
      if (m == 0)
      {
        this.f = paramFileMsg.fileMd5;
        if (((bigFileUpload.BigFileExtRsp)localObject).bytes_download_url.has()) {
          this.h = ((bigFileUpload.BigFileExtRsp)localObject).bytes_download_url.get().toStringUtf8();
        }
        if (((bigFileUpload.BigFileExtRsp)localObject).bytes_file_name.has()) {
          this.g = ((bigFileUpload.BigFileExtRsp)localObject).bytes_file_name.get().toStringUtf8();
        }
        if ((!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.g)) && (!TextUtils.isEmpty(this.h)))
        {
          m = 1;
          break label277;
        }
      }
      else if ((QLog.isColorLevel()) && (((bigFileUpload.BigFileExtRsp)localObject).bytes_msg.has()))
      {
        paramFileMsg = new StringBuilder();
        paramFileMsg.append("mVideoTransProcessorHandler rsp.error info:");
        paramFileMsg.append(((bigFileUpload.BigFileExtRsp)localObject).bytes_msg.get().toStringUtf8());
        QLog.d("VideoUploadController", 2, paramFileMsg.toString());
      }
    }
    catch (Exception paramFileMsg)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleMsgStatusSendFinish error = ");
        ((StringBuilder)localObject).append(paramFileMsg.toString());
        QLog.e("VideoUploadController", 2, ((StringBuilder)localObject).toString());
      }
    }
    int m = 0;
    label277:
    if (m != 0)
    {
      a(0, this.h, this.f, this.g);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send finish with error!");
    }
    a(1004, null, null, null);
    this.e = null;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.j = paramString;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startUploadVideo path=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("VideoUploadController", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoUploadController", 2, "startUploadVideo empty path!");
      }
      a(1001, null, null, null);
      return;
    }
    if (!new File(paramString).exists())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("startUploadVideo file not exist, path=");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("VideoUploadController", 2, ((StringBuilder)localObject).toString());
      }
      a(1002, null, null, null);
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(this.a))
    {
      QLog.d("VideoUploadController", 2, "upload: network not available");
      a(1003, null, null, null);
      return;
    }
    if ((!paramBoolean) && (!NetworkUtil.isWifiConnected(this.a)))
    {
      QLog.d("VideoUploadController", 2, "upload: wifi not connected and not upload with mobile");
      return;
    }
    Object localObject = (ITransFileController)this.b.getRuntimeService(ITransFileController.class);
    if (this.d.getFilter().size() == 0) {
      this.d.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    }
    ((ITransFileController)localObject).addHandle(this.d);
    if (this.e == null)
    {
      this.e = new TransferRequest();
      TransferRequest localTransferRequest = this.e;
      localTransferRequest.mIsUp = true;
      localTransferRequest.mCommandId = 54;
      localTransferRequest.mLocalPath = paramString;
      localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      paramString = this.e;
      paramString.mPeerUin = "0";
      paramString.mSelfUin = this.b.getCurrentAccountUin();
      paramString = this.e;
      paramString.mFileType = 24;
      paramString.mRichTag = "KandianUGCVideoUpload";
    }
    ((ITransFileController)localObject).transferAsync(this.e);
  }
  
  public void b()
  {
    ((ITransFileController)this.b.getRuntimeService(ITransFileController.class)).removeHandle(this.d);
    ThreadManager.executeOnFileThread(new VideoUploadController.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.transfer.VideoUploadController
 * JD-Core Version:    0.7.0.1
 */