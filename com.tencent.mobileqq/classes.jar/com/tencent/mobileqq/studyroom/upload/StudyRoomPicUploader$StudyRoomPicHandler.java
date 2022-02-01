package com.tencent.mobileqq.studyroom.upload;

import android.os.Message;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.studyroom.api.IStudyRoomPicUploadListener;
import com.tencent.mobileqq.transfile.BDHCommonUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class StudyRoomPicUploader$StudyRoomPicHandler
  extends TransProcessorHandler
{
  private static volatile StudyRoomPicHandler jdField_a_of_type_ComTencentMobileqqStudyroomUploadStudyRoomPicUploader$StudyRoomPicHandler;
  private static volatile boolean jdField_a_of_type_Boolean = false;
  private TransFileControllerImpl jdField_a_of_type_ComTencentMobileqqTransfileApiImplTransFileControllerImpl;
  private ConcurrentHashMap<Long, IStudyRoomPicUploadListener> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private StudyRoomPicUploader$StudyRoomPicHandler()
  {
    addFilter(new Class[] { BDHCommonUploadProcessor.class });
  }
  
  private void a(long paramLong)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramLong));
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.isEmpty()) {
      a();
    }
  }
  
  private static StudyRoomPicHandler b()
  {
    if (jdField_a_of_type_ComTencentMobileqqStudyroomUploadStudyRoomPicUploader$StudyRoomPicHandler == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqStudyroomUploadStudyRoomPicUploader$StudyRoomPicHandler == null) {
          jdField_a_of_type_ComTencentMobileqqStudyroomUploadStudyRoomPicUploader$StudyRoomPicHandler = new StudyRoomPicHandler();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqStudyroomUploadStudyRoomPicUploader$StudyRoomPicHandler;
  }
  
  public void a()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StudyRoomPicHandler release sHandlerInit=");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      QLog.d("StudyRoomPicUploader", 2, localStringBuilder.toString());
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileApiImplTransFileControllerImpl != null) && (jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiImplTransFileControllerImpl.removeHandle(this);
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiImplTransFileControllerImpl = null;
        jdField_a_of_type_Boolean = false;
      }
      return;
    }
    finally {}
  }
  
  public void a(long paramLong, IStudyRoomPicUploadListener paramIStudyRoomPicUploadListener)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramLong), paramIStudyRoomPicUploadListener);
  }
  
  public void a(ITransFileController paramITransFileController)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("StudyRoomPicHandler init sHandlerInit=");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      QLog.d("StudyRoomPicUploader", 2, localStringBuilder.toString());
      if (!jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiImplTransFileControllerImpl = ((TransFileControllerImpl)paramITransFileController);
        this.jdField_a_of_type_ComTencentMobileqqTransfileApiImplTransFileControllerImpl.addHandle(this);
        jdField_a_of_type_Boolean = true;
      }
      return;
    }
    finally {}
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    Object localObject1;
    Object localObject2;
    if (localFileMsg != null)
    {
      if (localFileMsg.commandId != 80) {
        return;
      }
      localObject1 = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
      if (localObject1 == null) {
        return;
      }
      localObject1 = (IStudyRoomPicUploadListener)((ConcurrentHashMap)localObject1).get(Long.valueOf(localFileMsg.uniseq));
      if (localObject1 == null)
      {
        QLog.d("StudyRoomPicUploader", 2, "uploadListener == null");
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localFileMsg.uniseq));
        return;
      }
      int i = paramMessage.what;
      if (i != 1002)
      {
        if (i != 1003)
        {
          if (i != 1005) {
            return;
          }
          ((IStudyRoomPicUploadListener)localObject1).a(localFileMsg.errorCode, "上传发生错误");
          a(localFileMsg.uniseq);
          return;
        }
        paramMessage = new StringBuilder();
        paramMessage.append("STATUS_SEND_FINISHED file uniseq:");
        paramMessage.append(localFileMsg.uniseq);
        QLog.d("StudyRoomPicUploader", 2, paramMessage.toString());
        localObject2 = new Bdh_extinfo.UploadPicExtInfo();
      }
    }
    try
    {
      ((Bdh_extinfo.UploadPicExtInfo)localObject2).mergeFrom(localFileMsg.bdhExtendInfo, 0, localFileMsg.bdhExtendInfo.length);
      paramMessage = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_download_url.get().toStringUtf8();
      localObject2 = ((Bdh_extinfo.UploadPicExtInfo)localObject2).bytes_thumb_download_url.get().toStringUtf8();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("STATUS_SEND_FINISHED picUrl:");
      localStringBuilder.append(paramMessage);
      QLog.d("StudyRoomPicUploader", 2, localStringBuilder.toString());
      ((IStudyRoomPicUploadListener)localObject1).a(paramMessage, (String)localObject2);
    }
    catch (InvalidProtocolBufferMicroException paramMessage)
    {
      label266:
      break label266;
    }
    ((IStudyRoomPicUploadListener)localObject1).a(101, "解析上传结果错误");
    a(localFileMsg.uniseq);
    return;
    ((IStudyRoomPicUploadListener)localObject1).a((int)((float)localFileMsg.transferedSize * 100.0F / (float)localFileMsg.fileSize));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.upload.StudyRoomPicUploader.StudyRoomPicHandler
 * JD-Core Version:    0.7.0.1
 */