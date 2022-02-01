package com.tencent.mobileqq.phonecontact.api.impl;

import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class PhoneContactServiceImpl$MyContentObserver
  extends ContentObserver
{
  WeakReference<PhoneContactServiceImpl> a;
  
  public PhoneContactServiceImpl$MyContentObserver(Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void a(PhoneContactServiceImpl paramPhoneContactServiceImpl)
  {
    WeakReference localWeakReference = this.a;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    if (paramPhoneContactServiceImpl != null) {
      this.a = new WeakReference(paramPhoneContactServiceImpl);
    }
  }
  
  public void onChange(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, "Contact changed.");
    }
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (PhoneContactServiceImpl)((WeakReference)localObject).get();
    }
    if (localObject != null) {
      ((PhoneContactServiceImpl)localObject).contactChanged = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.MyContentObserver
 * JD-Core Version:    0.7.0.1
 */