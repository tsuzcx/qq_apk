package com.tencent.mobileqq.filemanageraux.link;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.WeiyunCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.weiyun.ResponseHandler;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

final class WeiyunShareProcessController$GetShareLinkCallback
  implements WeiYunLogicCenter.WeiyunCallback
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<WeiyunShareProcessController> jdField_a_of_type_MqqUtilWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  private final String b;
  
  private WeiyunShareProcessController$GetShareLinkCallback(WeiyunShareProcessController paramWeiyunShareProcessController, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramWeiyunShareProcessController == null) {}
    for (paramWeiyunShareProcessController = null;; paramWeiyunShareProcessController = new WeakReference(paramWeiyunShareProcessController))
    {
      this.jdField_a_of_type_MqqUtilWeakReference = paramWeiyunShareProcessController;
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_JavaLangString = paramString1;
      this.b = paramString2;
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (WeiyunShareProcessController localWeiyunShareProcessController = null; (localWeiyunShareProcessController == null) || (WeiyunShareProcessController.a(localWeiyunShareProcessController)); localWeiyunShareProcessController = (WeiyunShareProcessController)this.jdField_a_of_type_MqqUtilWeakReference.get()) {
      return;
    }
    if ((!ResponseHandler.b(paramInt)) && (!TextUtils.isEmpty(this.b)) && (WeiyunShareProcessController.a(localWeiyunShareProcessController) == null))
    {
      QLog.w("WeiyunShareProcessController<FileAssistant>", 2, "GetShareLink errorCode=" + paramInt + ", errorMsg=" + paramString);
      WeiyunShareProcessController.a(localWeiyunShareProcessController, this.b);
      return;
    }
    Message localMessage = new Message();
    localMessage.what = 6;
    localMessage.obj = new Object[] { Integer.valueOf(paramInt), paramString };
    WeiyunShareProcessController.a(localWeiyunShareProcessController).sendMessage(localMessage);
  }
  
  public void a(Object paramObject)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference == null) {}
    for (WeiyunShareProcessController localWeiyunShareProcessController = null; (paramObject == null) || (localWeiyunShareProcessController == null) || (WeiyunShareProcessController.a(localWeiyunShareProcessController)); localWeiyunShareProcessController = (WeiyunShareProcessController)this.jdField_a_of_type_MqqUtilWeakReference.get()) {
      return;
    }
    Object localObject = (String)paramObject;
    paramObject = localObject;
    if (this.jdField_a_of_type_Boolean)
    {
      paramObject = localObject;
      if (!((String)localObject).contains("?weiyun_qr_code=1")) {
        paramObject = (String)localObject + "?weiyun_qr_code=1";
      }
    }
    localObject = new Message();
    ((Message)localObject).what = 5;
    ((Message)localObject).obj = new Object[] { paramObject, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString };
    WeiyunShareProcessController.a(localWeiyunShareProcessController).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.WeiyunShareProcessController.GetShareLinkCallback
 * JD-Core Version:    0.7.0.1
 */