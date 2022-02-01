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
    if (paramWeiyunShareProcessController == null) {
      paramWeiyunShareProcessController = null;
    } else {
      paramWeiyunShareProcessController = new WeakReference(paramWeiyunShareProcessController);
    }
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeiyunShareProcessController;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onUploadJobAdded(String paramString, long paramLong) {}
  
  public void onUploadStatusChanged(String paramString, long paramLong, UploadJobContext.StatusInfo paramStatusInfo, boolean paramBoolean)
  {
    paramString = this.jdField_a_of_type_MqqUtilWeakReference;
    Object localObject = null;
    WeiyunShareProcessController localWeiyunShareProcessController;
    if (paramString == null) {
      localWeiyunShareProcessController = null;
    } else {
      localWeiyunShareProcessController = (WeiyunShareProcessController)paramString.get();
    }
    if (localWeiyunShareProcessController != null)
    {
      if (WeiyunShareProcessController.a(localWeiyunShareProcessController)) {
        return;
      }
      if (WeiyunShareProcessController.a(localWeiyunShareProcessController) == null) {
        return;
      }
      if (paramBoolean)
      {
        int i = paramStatusInfo.state;
        if (i != 5)
        {
          if (i != 6)
          {
            paramString = localObject;
          }
          else if (paramStatusInfo.errorCode == 1810002)
          {
            paramString = localObject;
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("upload is canceled, for file:");
              paramString.append(this.jdField_a_of_type_JavaLangString);
              QLog.i("WeiyunShareProcessController<FileAssistant>", 2, paramString.toString());
              paramString = localObject;
            }
          }
          else
          {
            paramString = new Message();
            paramString.what = 3;
            paramString.obj = new Object[] { Integer.valueOf(paramStatusInfo.errorCode), paramStatusInfo.errorMsg };
          }
        }
        else
        {
          paramString = new Message();
          paramString.what = 2;
          paramString.obj = new Object[] { paramStatusInfo, this.jdField_a_of_type_JavaLangString };
        }
      }
      else
      {
        float f;
        if (paramStatusInfo.totalSize <= 0L) {
          f = 0.0F;
        } else {
          f = (float)paramStatusInfo.currSize / (float)paramStatusInfo.totalSize;
        }
        paramString = new Message();
        paramString.what = 4;
        paramString.obj = new Object[] { Float.valueOf(f) };
      }
      if (paramString != null) {
        WeiyunShareProcessController.a(localWeiyunShareProcessController).sendMessage(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.WeiyunShareProcessController.UploadStatusListener
 * JD-Core Version:    0.7.0.1
 */