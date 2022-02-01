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
  private final WeakReference<WeiyunShareProcessController> a;
  private final int b;
  private final String c;
  private final String d;
  private final boolean e;
  
  private WeiyunShareProcessController$GetShareLinkCallback(WeiyunShareProcessController paramWeiyunShareProcessController, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramWeiyunShareProcessController == null) {
      paramWeiyunShareProcessController = null;
    } else {
      paramWeiyunShareProcessController = new WeakReference(paramWeiyunShareProcessController);
    }
    this.a = paramWeiyunShareProcessController;
    this.b = paramInt;
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramBoolean;
  }
  
  public void a(int paramInt, String paramString)
  {
    Object localObject1 = this.a;
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
      if ((!((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).isSpaceOverErrorCode(paramInt)) && (!TextUtils.isEmpty(this.d)) && (WeiyunShareProcessController.d((WeiyunShareProcessController)localObject1) == null))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("GetShareLink errorCode=");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(", errorMsg=");
        ((StringBuilder)localObject2).append(paramString);
        QLog.w("WeiyunShareProcessController<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
        WeiyunShareProcessController.a((WeiyunShareProcessController)localObject1, this.d);
        return;
      }
      Object localObject2 = new Message();
      ((Message)localObject2).what = 6;
      ((Message)localObject2).obj = new Object[] { Integer.valueOf(paramInt), paramString };
      WeiyunShareProcessController.c((WeiyunShareProcessController)localObject1).sendMessage((Message)localObject2);
    }
  }
  
  public void a(Object paramObject)
  {
    Object localObject1 = this.a;
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
      if (this.e)
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
      ((Message)localObject2).obj = new Object[] { paramObject, Integer.valueOf(this.b), this.c };
      WeiyunShareProcessController.c((WeiyunShareProcessController)localObject1).sendMessage((Message)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.link.WeiyunShareProcessController.GetShareLinkCallback
 * JD-Core Version:    0.7.0.1
 */