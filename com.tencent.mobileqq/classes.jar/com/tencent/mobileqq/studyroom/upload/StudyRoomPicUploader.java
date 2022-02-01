package com.tencent.mobileqq.studyroom.upload;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtReq;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.studyroom.api.IStudyRoomPicUploadListener;
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
  private IStudyRoomPicUploadListener jdField_a_of_type_ComTencentMobileqqStudyroomApiIStudyRoomPicUploadListener;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public StudyRoomPicUploader(String paramString, IStudyRoomPicUploadListener paramIStudyRoomPicUploadListener)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqStudyroomApiIStudyRoomPicUploadListener = paramIStudyRoomPicUploadListener;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
  }
  
  public void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cancelUpload localPath=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    QLog.d("StudyRoomPicUploader", 2, ((StringBuilder)localObject).toString());
    StudyRoomPicUploader.StudyRoomPicHandler.a(StudyRoomPicUploader.StudyRoomPicHandler.a(), this.jdField_a_of_type_Long);
    localObject = this.jdField_a_of_type_ComTencentMobileqqStudyroomApiIStudyRoomPicUploadListener;
    if (localObject != null) {
      ((IStudyRoomPicUploadListener)localObject).a(100, "已取消上传");
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onProgress localPath=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    QLog.d("StudyRoomPicUploader", 2, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqStudyroomApiIStudyRoomPicUploadListener;
    if (localObject != null) {
      ((IStudyRoomPicUploadListener)localObject).a(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onFailed localPath=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    QLog.d("StudyRoomPicUploader", 2, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqStudyroomApiIStudyRoomPicUploadListener;
    if (localObject != null) {
      ((IStudyRoomPicUploadListener)localObject).a(paramInt, paramString);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSuccess localPath=");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    QLog.d("StudyRoomPicUploader", 2, ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onSuccess downloadUrl=");
    ((StringBuilder)localObject).append(paramString1);
    QLog.d("StudyRoomPicUploader", 2, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqStudyroomApiIStudyRoomPicUploadListener;
    if (localObject != null) {
      ((IStudyRoomPicUploadListener)localObject).a(paramString1, paramString2);
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
      localObject1 = new TransferRequest();
      ((TransferRequest)localObject1).mIsUp = true;
      ((TransferRequest)localObject1).mLocalPath = this.jdField_a_of_type_JavaLangString;
      ((TransferRequest)localObject1).mCommandId = 80;
      ((TransferRequest)localObject1).mPeerUin = "0";
      ((TransferRequest)localObject1).mRichTag = "studyRoomPicUpload";
      this.jdField_a_of_type_Long = ((Math.random() * 1000000.0D));
      ((TransferRequest)localObject1).mUniseq = this.jdField_a_of_type_Long;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startUpload transReq uniseq:");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
      QLog.d("StudyRoomPicUploader", 2, ((StringBuilder)localObject2).toString());
      ((TransferRequest)localObject1).mFileType = 24;
      ((TransferRequest)localObject1).mSelfUin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      ((TransferRequest)localObject1).mRequestLength = ((int)new File(this.jdField_a_of_type_JavaLangString).length());
      localObject2 = new Bdh_extinfo.CommFileExtReq();
      ((Bdh_extinfo.CommFileExtReq)localObject2).uint32_action_type.set(0);
      ((Bdh_extinfo.CommFileExtReq)localObject2).bytes_uuid.set(ByteStringMicro.copyFromUtf8(UUID.randomUUID().toString()));
      ((TransferRequest)localObject1).mExtentionInfo = ((Bdh_extinfo.CommFileExtReq)localObject2).toByteArray();
      localITransFileController.transferAsync((TransferRequest)localObject1);
      StudyRoomPicUploader.StudyRoomPicHandler.a().a(this.jdField_a_of_type_Long, this);
      this.jdField_a_of_type_Boolean = true;
      QLog.d("StudyRoomPicUploader", 2, "startUpload");
      return;
    }
    catch (Exception localException)
    {
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqStudyroomApiIStudyRoomPicUploadListener;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("error=");
      ((StringBuilder)localObject2).append(localException.getLocalizedMessage());
      ((IStudyRoomPicUploadListener)localObject1).a(-1, ((StringBuilder)localObject2).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startUpload error:");
      ((StringBuilder)localObject1).append(localException.getLocalizedMessage());
      QLog.d("StudyRoomPicUploader", 2, ((StringBuilder)localObject1).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.upload.StudyRoomPicUploader
 * JD-Core Version:    0.7.0.1
 */