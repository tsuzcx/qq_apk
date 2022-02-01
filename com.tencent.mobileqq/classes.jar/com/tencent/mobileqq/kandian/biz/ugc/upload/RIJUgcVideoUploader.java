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
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IVideoUploadListener<String> jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIVideoUploadListener;
  @SuppressLint({"HandlerLeak"})
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new RIJUgcVideoUploader.1(this);
  private String jdField_a_of_type_JavaLangString;
  
  public RIJUgcVideoUploader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void c()
  {
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("pause, path=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(",uniSeq=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, ((StringBuilder)localObject).toString());
    localObject = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    if (localObject != null)
    {
      localObject = (BaseTransProcessor)((ITransFileController)localObject).findProcessor("0", this.jdField_a_of_type_Long);
      if (localObject != null) {
        ((BaseTransProcessor)localObject).pause();
      }
    }
    c();
  }
  
  public void a(IVideoUploadListener<String> paramIVideoUploadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizUgcUploadIVideoUploadListener = paramIVideoUploadListener;
  }
  
  public void a(String paramString)
  {
    Object localObject = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.getFilter().size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    }
    ((ITransFileController)localObject).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mCommandId = 54;
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mUniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localTransferRequest.mPeerUin = "0";
    localTransferRequest.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    localTransferRequest.mFileType = 24;
    localTransferRequest.mRichTag = "KandianUGCVideoUpload";
    ((ITransFileController)localObject).transferAsync(localTransferRequest);
    this.jdField_a_of_type_Long = localTransferRequest.mUniseq;
    this.jdField_a_of_type_JavaLangString = paramString;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("upload, path=");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(",uniSeq=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, ((StringBuilder)localObject).toString());
  }
  
  public void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cancel, path=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(",uniSeq=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    QLog.i("RIJUGC.RIJUgcVideoUploader", 1, ((StringBuilder)localObject).toString());
    localObject = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    if (localObject != null)
    {
      localObject = (BaseTransProcessor)((ITransFileController)localObject).findProcessor("0", this.jdField_a_of_type_Long);
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
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.getFilter().isEmpty()) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { BDHCommonUploadProcessor.class });
    }
    localObject = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
    ((ITransFileController)localObject).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    try
    {
      paramString = new JSONObject(paramString);
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = paramString.optInt("uniseq", 0);
        this.jdField_a_of_type_JavaLangString = paramString.optString("localPath", "");
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
    paramString = (BaseTransProcessor)((ITransFileController)localObject).findProcessor("0", this.jdField_a_of_type_Long);
    if (paramString != null)
    {
      paramString.resume();
      return;
    }
    a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.upload.RIJUgcVideoUploader
 * JD-Core Version:    0.7.0.1
 */