package com.tencent.mobileqq.hiboom.api.impl;

import android.content.Context;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasCommonAdapter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class HiBoomAuthObserver
  extends MessageObserver
{
  private WeakReference<Context> a;
  
  public HiBoomAuthObserver(Context paramContext)
  {
    this.a = new WeakReference(paramContext);
  }
  
  protected void onHiBoomAuthResult(int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHiBoomAuthResult errorCode = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("HiBoom", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (Context)this.a.get();
    if ((paramInt != 0) && (localObject != null)) {
      ((IVasCommonAdapter)QRoute.api(IVasCommonAdapter.class)).handleHiBoomTipsInfo((Context)localObject, paramArrayOfByte, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.api.impl.HiBoomAuthObserver
 * JD-Core Version:    0.7.0.1
 */