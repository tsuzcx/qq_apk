package com.tencent.mobileqq.profile.PersonalityLabel;

import agni;
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
  WeakReference a;
  
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
    if (localFileMsg.b != 56) {}
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
        Object localObject = localFileMsg.jdField_a_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg key:" + (String)localObject);
        }
        int i = 0;
        label93:
        if (i < localPLUploadManager.jdField_a_of_type_JavaUtilVector.size()) {
          if (!((agni)localPLUploadManager.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.a().equals(localObject)) {}
        }
        for (localObject = (agni)localPLUploadManager.jdField_a_of_type_JavaUtilVector.get(i);; localObject = null)
        {
          if (localObject == null) {
            break label460;
          }
          if (QLog.isColorLevel()) {
            QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg find:" + ((agni)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
          }
          switch (paramMessage.what)
          {
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg. state:" + ((agni)localObject).b + " " + ((agni)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq);
            }
            if ((((agni)localObject).b == 4) && (QLog.isColorLevel())) {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "personality_label handlemsg url:" + ((agni)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url);
            }
            if (localPLUploadManager.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager$UploadListener == null) {
              break;
            }
            localPLUploadManager.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager$UploadListener.a(((agni)localObject).jdField_a_of_type_Long, (agni)localObject);
            return;
            i += 1;
            break label93;
            ((agni)localObject).c = 0;
            ((agni)localObject).b = 1;
            continue;
            ((agni)localObject).b = 4;
            ((agni)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.fileId = localFileMsg.d;
            ((agni)localObject).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.url = localFileMsg.i;
            if (((agni)localObject).c < 100) {
              ((agni)localObject).c = 100;
            }
            localPLUploadManager.jdField_a_of_type_JavaUtilVector.remove(localObject);
            continue;
            ((agni)localObject).b = 3;
            continue;
            ((agni)localObject).b = 2;
            ((agni)localObject).c = ((int)(localFileMsg.e * 100L / localFileMsg.jdField_a_of_type_Long));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PLTransProcessorHandler
 * JD-Core Version:    0.7.0.1
 */