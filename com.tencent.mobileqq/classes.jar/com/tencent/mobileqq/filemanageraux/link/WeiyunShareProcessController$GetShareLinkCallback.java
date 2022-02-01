package com.tencent.mobileqq.filemanageraux.link;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.WeiyunCallback;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

final class WeiyunShareProcessController$GetShareLinkCallback
  implements WeiyunCallback
{
  private final int jdField_a_of_type_Int;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<WeiyunShareProcessController> jdField_a_of_type_MqqUtilWeakReference;
  private final boolean jdField_a_of_type_Boolean;
  private final String b;
  
  private WeiyunShareProcessController$GetShareLinkCallback(WeiyunShareProcessController paramWeiyunShareProcessController, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramWeiyunShareProcessController == null) {
      paramWeiyunShareProcessController = null;
    } else {
      paramWeiyunShareProcessController = new WeakReference(paramWeiyunShareProcessController);
    }
    this.jdField_a_of_type_MqqUtilWeakReference = paramWeiyunShareProcessController;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject1 = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (WeiyunShareProcessController)((WeakReference)localObject1).get();
    }
    if (localObject1 != null)
    {
      if (WeiyunShareProcessController.a((WeiyunShareProcessController)localObject1)) {
        return;
      }
      if ((!((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).isSpaceOverErrorCode(paramInt)) && (!TextUtils.isEmpty(this.b)) && (WeiyunShareProcessController.a((WeiyunShareProcessController)localObject1) == null))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("GetShareLink errorCode=");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(", errorMsg=");
        ((StringBuilder)localObject2).append(paramString);
        QLog.w("WeiyunShareProcessController<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
        WeiyunShareProcessController.a((WeiyunShareProcessController)localObject1, this.b);
        return;
      }
      Object localObject2 = new Message();
      ((Message)localObject2).what = 6;
      ((Message)localObject2).obj = new Object[] { Integer.valueOf(paramInt), paramString };
      WeiyunShareProcessController.a((WeiyunShareProcessController)localObject1).sendMessage((Message)localObject2);
    }
  }
  
  public void a(Object paramObject)
  {
    Object localObject1 = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = (WeiyunShareProcessController)((WeakReference)localObject1).get();
    }
    if ((paramObject != null) && (localObject1 != null))
    {
      if (WeiyunShareProcessController.a((WeiyunShareProcessController)localObject1)) {
        return;
      }
      Object localObject2 = (String)paramObject;
      paramObject = localObject2;
      if (this.jdField_a_of_type_Boolean)
      {
        paramObject = localObject2;
        if (!((String)localObject2).contains("?weiyun_qr_code=1"))
        {
          paramObject = new StringBuilder();
          paramObject.append((String)localObject2);
          paramObject.append("?weiyun_qr_code=1");
          paramObject = paramObject.toString();
        }
      }
      localObject2 = new Message();
      ((Message)localObject2).what = 5;
      ((Message)localObject2).obj = new Object[] { paramObject, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString };
      WeiyunShareProcessController.a((WeiyunShareProcessController)localObject1).sendMessage((Message)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.WeiyunShareProcessController.GetShareLinkCallback
 * JD-Core Version:    0.7.0.1
 */