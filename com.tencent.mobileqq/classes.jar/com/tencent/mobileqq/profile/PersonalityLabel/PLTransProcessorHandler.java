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
  public static String a;
  WeakReference<PLUploadManager> a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "PLTransProcessorHandler";
  }
  
  public PLTransProcessorHandler(PLUploadManager paramPLUploadManager, Looper paramLooper)
  {
    super(paramLooper);
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramPLUploadManager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    FileMsg localFileMsg = (FileMsg)paramMessage.obj;
    if (localFileMsg.fileType != 56) {}
    label460:
    for (;;)
    {
      return;
      PLUploadManager localPLUploadManager = (PLUploadManager)this.jdField_a_of_type_MqqUtilWeakReference.get();
      if (localPLUploadManager == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "PLUploadManager is null");
        }
      }
      else
      {
        Object localObject = localFileMsg.fileKey;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg key:" + (String)localObject);
        }
        int i = 0;
        label93:
        if (i < localPLUploadManager.jdField_a_of_type_JavaUtilVector.size()) {
          if (!((PLUploadManager.UploadItem)localPLUploadManager.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.getKeyForTransfer().equals(localObject)) {}
        }
        for (localObject = (PLUploadManager.UploadItem)localPLUploadManager.jdField_a_of_type_JavaUtilVector.get(i);; localObject = null)
        {
          if (localObject == null) {
            break label460;
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg find:" + ((PLUploadManager.UploadItem)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
          }
          switch (paramMessage.what)
          {
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg. state:" + ((PLUploadManager.UploadItem)localObject).b + " " + ((PLUploadManager.UploadItem)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
            }
            if ((((PLUploadManager.UploadItem)localObject).b == 4) && (QLog.isColorLevel())) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg url:" + ((PLUploadManager.UploadItem)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url);
            }
            if (localPLUploadManager.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager$UploadListener == null) {
              break;
            }
            localPLUploadManager.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager$UploadListener.a(((PLUploadManager.UploadItem)localObject).jdField_a_of_type_Long, (PLUploadManager.UploadItem)localObject);
            return;
            i += 1;
            break label93;
            ((PLUploadManager.UploadItem)localObject).c = 0;
            ((PLUploadManager.UploadItem)localObject).b = 1;
            continue;
            ((PLUploadManager.UploadItem)localObject).b = 4;
            ((PLUploadManager.UploadItem)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.fileId = localFileMsg.fileID;
            ((PLUploadManager.UploadItem)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url = localFileMsg.fileUrl;
            if (((PLUploadManager.UploadItem)localObject).c < 100) {
              ((PLUploadManager.UploadItem)localObject).c = 100;
            }
            localPLUploadManager.jdField_a_of_type_JavaUtilVector.remove(localObject);
            continue;
            ((PLUploadManager.UploadItem)localObject).b = 3;
            continue;
            ((PLUploadManager.UploadItem)localObject).b = 2;
            ((PLUploadManager.UploadItem)localObject).c = ((int)(localFileMsg.transferedSize * 100L / localFileMsg.fileSize));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PLTransProcessorHandler
 * JD-Core Version:    0.7.0.1
 */