package com.tencent.mobileqq.filemanageraux.link;

import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.upload.UploadJobContext.StatusInfo;
import com.tencent.weiyun.transmission.upload.UploadManager.IUploadStatusListener;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

final class WeiyunShareProcessController$UploadStatusListener
  implements UploadManager.IUploadStatusListener
{
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<WeiyunShareProcessController> jdField_a_of_type_MqqUtilWeakReference;
  
  private WeiyunShareProcessController$UploadStatusListener(WeiyunShareProcessController paramWeiyunShareProcessController, String paramString)
  {
    if (paramWeiyunShareProcessController == null) {}
    for (paramWeiyunShareProcessController = null;; paramWeiyunShareProcessController = new WeakReference(paramWeiyunShareProcessController))
    {
      this.jdField_a_of_type_MqqUtilWeakReference = paramWeiyunShareProcessController;
      this.jdField_a_of_type_JavaLangString = paramString;
      return;
    }
  }
  
  public void onUploadJobAdded(String paramString, long paramLong) {}
  
  public void onUploadStatusChanged(String paramString, long paramLong, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
  {
    WeiyunShareProcessController localWeiyunShareProcessController;
    if (this.jdField_a_of_type_MqqUtilWeakReference == null)
    {
      localWeiyunShareProcessController = null;
      if ((localWeiyunShareProcessController != null) && (!WeiyunShareProcessController.a(localWeiyunShareProcessController))) {
        break label39;
      }
    }
    label39:
    while (WeiyunShareProcessController.a(localWeiyunShareProcessController) == null)
    {
      return;
      localWeiyunShareProcessController = (WeiyunShareProcessController)this.jdField_a_of_type_MqqUtilWeakReference.get();
      break;
    }
    if (paramBoolean)
    {
      switch (paramStatusInfo.state)
      {
      default: 
        label80:
        paramString = null;
      }
      while (paramString != null)
      {
        WeiyunShareProcessController.a(localWeiyunShareProcessController).sendMessage(paramString);
        return;
        if (paramStatusInfo.errorCode == 1810002)
        {
          if (!QLog.isColorLevel()) {
            break label80;
          }
          QLog.i("WeiyunShareProcessController<FileAssistant>", 2, "upload is canceled, for file:" + this.jdField_a_of_type_JavaLangString);
          paramString = null;
          continue;
        }
        paramString = new Message();
        paramString.what = 3;
        paramString.obj = new Object[] { Integer.valueOf(paramStatusInfo.errorCode), paramStatusInfo.errorMsg };
        continue;
        paramString = new Message();
        paramString.what = 2;
        paramString.obj = new Object[] { paramStatusInfo, this.jdField_a_of_type_JavaLangString };
      }
    }
    if (paramStatusInfo.totalSize <= 0L) {}
    for (float f = 0.0F;; f = (float)paramStatusInfo.currSize / (float)paramStatusInfo.totalSize)
    {
      paramString = new Message();
      paramString.what = 4;
      paramString.obj = new Object[] { Float.valueOf(f) };
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.WeiyunShareProcessController.UploadStatusListener
 * JD-Core Version:    0.7.0.1
 */