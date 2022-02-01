package com.tencent.mobileqq.profile.PersonalityLabel;

import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.Vector;
import mqq.util.WeakReference;

public class PLTransProcessorHandler
  extends TransProcessorHandler
{
  public static String a = "PLTransProcessorHandler";
  WeakReference<PLUploadManager> a;
  
  public PLTransProcessorHandler(PLUploadManager paramPLUploadManager, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramPLUploadManager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (localFileMsg.fileType != 56) {
      return;
    }
    PLUploadManager localPLUploadManager = (PLUploadManager)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localPLUploadManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "PLUploadManager is null");
      }
      return;
    }
    Object localObject3 = localFileMsg.fileKey;
    Object localObject2 = null;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("personality_label handlemsg key:");
      localStringBuilder.append((String)localObject3);
      QLog.i((String)localObject1, 2, localStringBuilder.toString());
    }
    int i = 0;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= localPLUploadManager.jdField_a_of_type_JavaUtilVector.size()) {
        break;
      }
      if (((PLUploadManager.UploadItem)localPLUploadManager.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.getKeyForTransfer().equals(localObject3))
      {
        localObject1 = (PLUploadManager.UploadItem)localPLUploadManager.jdField_a_of_type_JavaUtilVector.get(i);
        break;
      }
      i += 1;
    }
    if (localObject1 == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = jdField_a_of_type_JavaLangString;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("personality_label handlemsg find:");
      ((StringBuilder)localObject3).append(((PLUploadManager.UploadItem)localObject1).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
      QLog.i((String)localObject2, 2, ((StringBuilder)localObject3).toString());
    }
    switch (paramMessage.what)
    {
    case 1004: 
    default: 
      break;
    case 1005: 
      ((PLUploadManager.UploadItem)localObject1).b = 3;
      break;
    case 1003: 
      ((PLUploadManager.UploadItem)localObject1).b = 4;
      ((PLUploadManager.UploadItem)localObject1).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.fileId = localFileMsg.fileID;
      ((PLUploadManager.UploadItem)localObject1).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url = localFileMsg.fileUrl;
      if (((PLUploadManager.UploadItem)localObject1).c < 100) {
        ((PLUploadManager.UploadItem)localObject1).c = 100;
      }
      localPLUploadManager.jdField_a_of_type_JavaUtilVector.remove(localObject1);
      break;
    case 1002: 
      ((PLUploadManager.UploadItem)localObject1).b = 2;
      ((PLUploadManager.UploadItem)localObject1).c = ((int)(localFileMsg.transferedSize * 100L / localFileMsg.fileSize));
      break;
    case 1001: 
      ((PLUploadManager.UploadItem)localObject1).c = 0;
      ((PLUploadManager.UploadItem)localObject1).b = 1;
    }
    if (QLog.isColorLevel())
    {
      paramMessage = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("personality_label handlemsg. state:");
      ((StringBuilder)localObject2).append(((PLUploadManager.UploadItem)localObject1).b);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(((PLUploadManager.UploadItem)localObject1).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
      QLog.i(paramMessage, 2, ((StringBuilder)localObject2).toString());
    }
    if ((((PLUploadManager.UploadItem)localObject1).b == 4) && (QLog.isColorLevel()))
    {
      paramMessage = jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("personality_label handlemsg url:");
      ((StringBuilder)localObject2).append(((PLUploadManager.UploadItem)localObject1).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url);
      QLog.i(paramMessage, 2, ((StringBuilder)localObject2).toString());
    }
    if (localPLUploadManager.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager$UploadListener != null) {
      localPLUploadManager.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager$UploadListener.a(((PLUploadManager.UploadItem)localObject1).jdField_a_of_type_Long, (PLUploadManager.UploadItem)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PLTransProcessorHandler
 * JD-Core Version:    0.7.0.1
 */