package com.tencent.mobileqq.studyroom.upload;

import android.os.Message;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
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
    if (jdField_a_of_type_ComTencentMobileqqStudyroomUploadStudyRoomPicUploader$StudyRoomPicHandler == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqStudyroomUploadStudyRoomPicUploader$StudyRoomPicHandler == null) {
        jdField_a_of_type_ComTencentMobileqqStudyroomUploadStudyRoomPicUploader$StudyRoomPicHandler = new StudyRoomPicHandler();
      }
      return jdField_a_of_type_ComTencentMobileqqStudyroomUploadStudyRoomPicUploader$StudyRoomPicHandler;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      QLog.d("StudyRoomPicUploader", 2, "StudyRoomPicHandler release sHandlerInit=" + jdField_a_of_type_Boolean);
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
      QLog.d("StudyRoomPicUploader", 2, "StudyRoomPicHandler init sHandlerInit=" + jdField_a_of_type_Boolean);
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
    if ((localFileMsg == null) || (localFileMsg.commandId != 80)) {}
    while (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
      return;
    }
    IStudyRoomPicUploadListener localIStudyRoomPicUploadListener = (IStudyRoomPicUploadListener)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(localFileMsg.uniseq));
    if (localIStudyRoomPicUploadListener == null)
    {
      QLog.d("StudyRoomPicUploader", 2, "uploadListener == null");
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(localFileMsg.uniseq));
      return;
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      return;
    case 1002: 
      localIStudyRoomPicUploadListener.a((int)((float)localFileMsg.transferedSize * 100.0F / (float)localFileMsg.fileSize));
      return;
    case 1003: 
      QLog.d("StudyRoomPicUploader", 2, "STATUS_SEND_FINISHED file uniseq:" + localFileMsg.uniseq);
      Object localObject = new Bdh_extinfo.UploadPicExtInfo();
      try
      {
        ((Bdh_extinfo.UploadPicExtInfo)localObject).mergeFrom(localFileMsg.bdhExtendInfo, 0, localFileMsg.bdhExtendInfo.length);
        paramMessage = ((Bdh_extinfo.UploadPicExtInfo)localObject).bytes_download_url.get().toStringUtf8();
        localObject = ((Bdh_extinfo.UploadPicExtInfo)localObject).bytes_thumb_download_url.get().toStringUtf8();
        QLog.d("StudyRoomPicUploader", 2, "STATUS_SEND_FINISHED picUrl:" + paramMessage);
        localIStudyRoomPicUploadListener.a(paramMessage, (String)localObject);
        a(localFileMsg.uniseq);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramMessage)
      {
        for (;;)
        {
          localIStudyRoomPicUploadListener.a(101, "解析上传结果错误");
        }
      }
    }
    localIStudyRoomPicUploadListener.a(localFileMsg.errorCode, "上传发生错误");
    a(localFileMsg.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.studyroom.upload.StudyRoomPicUploader.StudyRoomPicHandler
 * JD-Core Version:    0.7.0.1
 */