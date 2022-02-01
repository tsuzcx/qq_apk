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
  private long jdField_a_of_type_Long;
  TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new VideoUploadController.2(this);
  private TransferRequest jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = null;
  private String jdField_a_of_type_JavaLangString = null;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString = null;
  private String c = null;
  private String d = null;
  private String e = null;
  
  public VideoUploadController(Context paramContext, QQAppInterface paramQQAppInterface, FileUploadController.FileUploadListener paramFileUploadListener, String paramString)
  {
    super(paramContext, paramQQAppInterface, paramFileUploadListener);
    this.d = paramString;
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext);
    String str = RIJQQAppInterfaceUtil.a();
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    localStatisticCollector.collectPerformance(str, "actReadInJoyDeliverVideoUploadVideo", bool, this.jdField_b_of_type_Long - this.jdField_a_of_type_Long, 0L, localHashMap, "");
  }
  
  private void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("finish: retCode - ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" fileUrl : ");
    localStringBuilder.append(paramString1);
    QLog.d("VideoUploadController", 2, localStringBuilder.toString());
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    a(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoTransferFileUploadController$FileUploadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcVideoTransferFileUploadController$FileUploadListener.a(paramInt, paramString1, paramString2, paramString3);
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "cancelUploadVideo");
    }
    Object localObject = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    if (localObject != null)
    {
      TransferRequest localTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
      if (localTransferRequest != null)
      {
        localObject = (BaseTransProcessor)((ITransFileController)localObject).findProcessor(localTransferRequest.mPeerUin, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mUniseq);
        if (localObject != null)
        {
          ((BaseTransProcessor)localObject).cancel();
          this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = null;
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
      i = ((bigFileUpload.BigFileExtRsp)localObject).int32_retcode.get();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mVideoTransProcessorHandler rsp.errorCode:");
        localStringBuilder.append(i);
        QLog.d("VideoUploadController", 2, localStringBuilder.toString());
      }
      if (i == 0)
      {
        this.jdField_a_of_type_JavaLangString = paramFileMsg.fileMd5;
        if (((bigFileUpload.BigFileExtRsp)localObject).bytes_download_url.has()) {
          this.c = ((bigFileUpload.BigFileExtRsp)localObject).bytes_download_url.get().toStringUtf8();
        }
        if (((bigFileUpload.BigFileExtRsp)localObject).bytes_file_name.has()) {
          this.jdField_b_of_type_JavaLangString = ((bigFileUpload.BigFileExtRsp)localObject).bytes_file_name.get().toStringUtf8();
        }
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.c)))
        {
          i = 1;
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
    int i = 0;
    label277:
    if (i != 0)
    {
      a(0, this.c, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoUploadController", 2, "mVideoTransProcessorHandler send finish with error!");
    }
    a(1004, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = null;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    this.e = paramString;
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
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
    {
      QLog.d("VideoUploadController", 2, "upload: network not available");
      a(1003, null, null, null);
      return;
    }
    if ((!paramBoolean) && (!NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext)))
    {
      QLog.d("VideoUploadController", 2, "upload: wifi not connected and not upload with mobile");
      return;
    }
    Object localObject = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.getFilter().size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    }
    ((ITransFileController)localObject).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = new TransferRequest();
      TransferRequest localTransferRequest = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
      localTransferRequest.mIsUp = true;
      localTransferRequest.mCommandId = 54;
      localTransferRequest.mLocalPath = paramString;
      localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      paramString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
      paramString.mPeerUin = "0";
      paramString.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      paramString = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
      paramString.mFileType = 24;
      paramString.mRichTag = "KandianUGCVideoUpload";
    }
    ((ITransFileController)localObject).transferAsync(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
  }
  
  public void b()
  {
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    ThreadManager.executeOnFileThread(new VideoUploadController.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.video.transfer.VideoUploadController
 * JD-Core Version:    0.7.0.1
 */