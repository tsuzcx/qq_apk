package com.tencent.mobileqq.studyroom.upload;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.UUID;

public class StudyRoomPicUploader
  implements IStudyRoomPicUploadListener, IStudyRoomPicUploader
{
  private long jdField_a_of_type_Long;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IStudyRoomPicUploadListener jdField_a_of_type_ComTencentMobileqqStudyroomUploadIStudyRoomPicUploadListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public StudyRoomPicUploader(String paramString, IStudyRoomPicUploadListener paramIStudyRoomPicUploadListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqStudyroomUploadIStudyRoomPicUploadListener = paramIStudyRoomPicUploadListener;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void a()
  {
    QLog.d("StudyRoomPicUploader", 2, "cancelUpload localPath=" + this.jdField_a_of_type_JavaLangString);
    StudyRoomPicUploader.StudyRoomPicHandler.a(StudyRoomPicUploader.StudyRoomPicHandler.a(), this.jdField_a_of_type_Long);
    if (this.jdField_a_of_type_ComTencentMobileqqStudyroomUploadIStudyRoomPicUploadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqStudyroomUploadIStudyRoomPicUploadListener.a(100, "已取消上传");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    QLog.d("StudyRoomPicUploader", 2, "onProgress localPath=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqStudyroomUploadIStudyRoomPicUploadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqStudyroomUploadIStudyRoomPicUploadListener.a(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    QLog.d("StudyRoomPicUploader", 2, "onFailed localPath=" + this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqStudyroomUploadIStudyRoomPicUploadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqStudyroomUploadIStudyRoomPicUploadListener.a(paramInt, paramString);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString1, String paramString2)
  {
    QLog.d("StudyRoomPicUploader", 2, "onSuccess localPath=" + this.jdField_a_of_type_JavaLangString);
    QLog.d("StudyRoomPicUploader", 2, "onSuccess downloadUrl=" + paramString1);
    if (this.jdField_a_of_type_ComTencentMobileqqStudyroomUploadIStudyRoomPicUploadListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqStudyroomUploadIStudyRoomPicUploadListener.a(paramString1, paramString2);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    try
    {
      ITransFileController localITransFileController = (ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class);
      StudyRoomPicUploader.StudyRoomPicHandler.a().a(localITransFileController);
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.mIsUp = true;
      localTransferRequest.mLocalPath = this.jdField_a_of_type_JavaLangString;
      localTransferRequest.mCommandId = 80;
      localTransferRequest.mPeerUin = "0";
      localTransferRequest.mRichTag = "studyRoomPicUpload";
      this.jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
      localTransferRequest.mUniseq = this.jdField_a_of_type_Long;
      QLog.d("StudyRoomPicUploader", 2, "startUpload transReq uniseq:" + this.jdField_a_of_type_Long);
      localTransferRequest.mFileType = 24;
      localTransferRequest.mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      localTransferRequest.mRequestLength = ((int)new File(this.jdField_a_of_type_JavaLangString).length());
      Bdh_extinfo.CommFileExtReq localCommFileExtReq = new Bdh_extinfo.CommFileExtReq();
      localCommFileExtReq.uint32_action_type.set(0);
      localCommFileExtReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
      localTransferRequest.mExtentionInfo = localCommFileExtReq.toByteArray();
      localITransFileController.transferAsync(localTransferRequest);
      StudyRoomPicUploader.StudyRoomPicHandler.a().a(this.jdField_a_of_type_Long, this);
      this.jdField_a_of_type_Boolean = true;
      QLog.d("StudyRoomPicUploader", 2, "startUpload");
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentMobileqqStudyroomUploadIStudyRoomPicUploadListener.a(-1, "error=" + localException.getLocalizedMessage());
      QLog.d("StudyRoomPicUploader", 2, "startUpload error:" + localException.getLocalizedMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.upload.StudyRoomPicUploader
 * JD-Core Version:    0.7.0.1
 */