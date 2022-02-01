package com.tencent.mobileqq.phonecontact.api.impl;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.phonecontact.constant.PhoneContactFlags;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.phonecontact.processor.IPhoneContactProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class PhoneContactServiceImpl$2
  extends ContactBindObserver
{
  PhoneContactServiceImpl$2(PhoneContactServiceImpl paramPhoneContactServiceImpl) {}
  
  void a()
  {
    ThreadManager.excute(new PhoneContactServiceImpl.2.2(this), 16, null, false);
  }
  
  void b()
  {
    if (PhoneContactServiceImpl.access$400(this.a)) {
      return;
    }
    int i = this.a.getSelfBindState();
    boolean bool2 = PhoneContactServiceImpl.access$1000(this.a);
    long l = PhoneContactServiceImpl.access$200(this.a).getLong("last_pop_time_for_switchphone", 0L);
    boolean bool1;
    if ((PhoneContactServiceImpl.access$1100(this.a)) && (System.currentTimeMillis() - l > 86400000L)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFirstRespQueryNotBindState bindState = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", needToJumpBind = ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(", phoneSwitchBefit = ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(l);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
    }
    if (((bool2) || (bool1)) && (PhoneContactServiceImpl.access$500(this.a).a(false))) {
      PhoneContactServiceImpl.access$1200(this.a, true);
    }
  }
  
  void c()
  {
    if (PhoneContactFlags.a) {
      return;
    }
    if (PhoneContactServiceImpl.access$400(this.a))
    {
      QLog.e("PhoneContact", 1, "onFirstRespQueryState app is null");
      return;
    }
    int i = this.a.getSelfBindState();
    boolean bool2 = PhoneContactServiceImpl.access$1300(this.a);
    long l = PhoneContactServiceImpl.access$200(this.a).getLong("last_pop_time_for_switchphone", 0L);
    boolean bool1;
    if ((PhoneContactServiceImpl.access$1100(this.a)) && (System.currentTimeMillis() - l > 86400000L)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bindState = ");
      localStringBuilder.append(i);
      localStringBuilder.append(", isFristRun = ");
      localStringBuilder.append(bool2);
      localStringBuilder.append(", attempPop = ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(l);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
    }
    if (((bool2) || (bool1)) && (PhoneContactServiceImpl.access$500(this.a).a(true))) {
      PhoneContactServiceImpl.access$1200(this.a, false);
    }
  }
  
  protected void onCancelBind(boolean paramBoolean)
  {
    if (PhoneContactServiceImpl.access$400(this.a)) {
      return;
    }
    if (paramBoolean)
    {
      PhoneContactServiceImpl.access$2300(this.a, true, true, 11L);
      PhoneContactServiceImpl.access$1402(this.a, 1);
      PhoneContactServiceImpl.access$2200(this.a);
      PhoneContactServiceImpl.access$500(this.a).c();
    }
  }
  
  protected void onHideContact(boolean paramBoolean)
  {
    if (PhoneContactServiceImpl.access$400(this.a)) {
      return;
    }
    if (paramBoolean) {
      PhoneContactServiceImpl.access$2000(this.a, 2);
    }
  }
  
  protected void onQueryBindState(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (PhoneContactServiceImpl.access$400(this.a)) {
      return;
    }
    if ((paramBoolean1) && (paramBoolean2)) {
      PhoneContactServiceImpl.access$500(this.a).b();
    }
    PhoneContactServiceImpl.access$602(this.a, false);
    PhoneContactServiceImpl.access$702(this.a, System.currentTimeMillis());
    QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 1, String.format("onQueryBindState [%s, %s, %s, %s]", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(PhoneContactServiceImpl.access$800(this.a)), Integer.valueOf(this.a.getSelfBindState()) }));
    PhoneContactServiceImpl.access$900(this.a, 6, paramBoolean1);
    if (paramBoolean1)
    {
      PhoneContactServiceImpl localPhoneContactServiceImpl = this.a;
      localPhoneContactServiceImpl.checkUpdateLocalContact(PhoneContactServiceImpl.access$800(localPhoneContactServiceImpl), 1);
      if (PhoneContactServiceImpl.access$800(this.a)) {
        ThreadManager.excute(new PhoneContactServiceImpl.2.1(this), 16, null, false);
      }
    }
    a();
  }
  
  protected void onQueryContactList(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactServiceImpl.access$400(this.a)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onQueryContactList, isSuc = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", updateFlag = ");
      localStringBuilder.append(paramInt);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      PhoneContactServiceImpl.access$2000(this.a, paramInt);
    }
    PhoneContactServiceImpl.access$2800(this.a);
  }
  
  protected void onQueryLastLoginInfo(boolean paramBoolean)
  {
    if (PhoneContactServiceImpl.access$400(this.a)) {
      return;
    }
    PhoneContactServiceImpl.access$2902(this.a, false);
    if (paramBoolean) {
      PhoneContactServiceImpl.access$2000(this.a, 2);
    }
  }
  
  protected void onUpdateContact(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactServiceImpl.access$400(this.a)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateContact, isSuc = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", reason = ");
      localStringBuilder.append(paramInt);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
    }
    PhoneContactServiceImpl.access$2502(this.a, false);
    if (paramBoolean)
    {
      PhoneContactServiceImpl.access$2000(this.a, 1);
      PhoneContactServiceImpl.access$1900(this.a, 0L, 0L);
    }
    else
    {
      if ((paramInt == 2) || (paramInt == 3)) {
        this.a.contactChanged = true;
      }
      PhoneContactServiceImpl.access$2702(this.a, System.currentTimeMillis());
    }
    PhoneContactServiceImpl.access$2300(this.a, true, true, 9L);
  }
  
  protected void onUpdateContactNotBind(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactServiceImpl.access$400(this.a)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateContactNotBind, isSuc = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", reason = ");
      localStringBuilder.append(paramInt);
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, localStringBuilder.toString());
    }
    PhoneContactServiceImpl.access$2502(this.a, false);
    if (paramBoolean)
    {
      PhoneContactServiceImpl.access$2000(this.a, 1);
      PhoneContactServiceImpl.access$2600(this.a, 0L);
    }
    else
    {
      PhoneContactServiceImpl.access$2702(this.a, System.currentTimeMillis());
      if ((paramInt != 2) && (paramInt != 3))
      {
        if ((paramInt == 5) || (paramInt == 4)) {
          if (PhoneContactServiceImpl.access$1400(this.a) != 8) {
            PhoneContactServiceImpl.access$2300(this.a, true, true, 8L);
          }
        }
      }
      else {
        this.a.contactChanged = true;
      }
    }
    PhoneContactServiceImpl.access$2300(this.a, true, true, 8L);
  }
  
  protected void onUploadContact(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactServiceImpl.access$400(this.a)) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUploadContact, isSuc = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", reason = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", currentState=");
      ((StringBuilder)localObject).append(PhoneContactServiceImpl.access$1400(this.a));
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (PhoneContactServiceImpl.access$1600(this.a))
    {
      localObject = this.a;
      int i;
      if (paramBoolean) {
        i = 3;
      } else {
        i = 4;
      }
      PhoneContactServiceImpl.access$1800((PhoneContactServiceImpl)localObject, i, PhoneContactServiceImpl.access$1700(this.a).size(), 100, 100);
    }
    if (PhoneContactServiceImpl.access$1500(this.a) != null)
    {
      PhoneContactServiceImpl.access$1500(this.a).b();
      PhoneContactServiceImpl.access$1502(this.a, null);
    }
    if (paramBoolean)
    {
      PhoneContactServiceImpl.access$1402(this.a, 9);
      PhoneContactServiceImpl.access$1900(this.a, 0L, 0L);
      PhoneContactServiceImpl.access$2000(this.a, 15);
    }
    else
    {
      PhoneContactServiceImpl.access$2102(this.a, System.currentTimeMillis());
      if (paramInt == 2)
      {
        PhoneContactServiceImpl.access$1402(this.a, 7);
      }
      else if (paramInt == 3)
      {
        PhoneContactServiceImpl.access$1402(this.a, 9);
        this.a.contactChanged = true;
      }
      else if (paramInt == 1)
      {
        PhoneContactServiceImpl.access$1402(this.a, 1);
        PhoneContactServiceImpl.access$2102(this.a, 0L);
      }
    }
    PhoneContactServiceImpl.access$2200(this.a);
    PhoneContactServiceImpl.access$2300(this.a, true, true, 7L);
  }
  
  protected void onUploadContactNotBind(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactServiceImpl.access$400(this.a)) {
      return;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUploadContactNotBind, isSuc = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", reason = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", currentState=");
      ((StringBuilder)localObject).append(PhoneContactServiceImpl.access$1400(this.a));
      QLog.d("IMCore.PhoneContact.PhoneContactServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (PhoneContactServiceImpl.access$1500(this.a) != null)
    {
      PhoneContactServiceImpl.access$1500(this.a).b();
      PhoneContactServiceImpl.access$1502(this.a, null);
    }
    if (PhoneContactServiceImpl.access$1600(this.a))
    {
      localObject = this.a;
      int i;
      if (paramBoolean) {
        i = 3;
      } else {
        i = 4;
      }
      PhoneContactServiceImpl.access$1800((PhoneContactServiceImpl)localObject, i, PhoneContactServiceImpl.access$1700(this.a).size(), 100, 100);
    }
    if (paramBoolean)
    {
      PhoneContactServiceImpl.access$1402(this.a, 2);
      PhoneContactServiceImpl.access$1900(this.a, 0L, 0L);
      PhoneContactServiceImpl.access$2000(this.a, 15);
    }
    else
    {
      PhoneContactServiceImpl.access$2102(this.a, System.currentTimeMillis());
      if ((paramInt != 2) && (paramInt != 3))
      {
        if (paramInt == 5)
        {
          PhoneContactServiceImpl.access$1402(this.a, 1);
          PhoneContactServiceImpl.access$2102(this.a, 0L);
          PhoneContactServiceImpl.access$2200(this.a);
          PhoneContactServiceImpl.access$2300(this.a, true, true, 6L);
          return;
        }
        if (paramInt == 4)
        {
          PhoneContactServiceImpl.access$1402(this.a, 9);
          localObject = this.a;
          ((PhoneContactServiceImpl)localObject).contactChanged = true;
          PhoneContactServiceImpl.access$2200((PhoneContactServiceImpl)localObject);
          PhoneContactServiceImpl.access$2300(this.a, true, true, 6L);
          return;
        }
        PhoneContactServiceImpl.access$1402(this.a, 0);
        PhoneContactServiceImpl.access$2200(this.a);
        PhoneContactServiceImpl.access$2300(this.a, true, true, 6L);
        return;
      }
      PhoneContactServiceImpl.access$1402(this.a, 0);
      this.a.contactChanged = true;
    }
    PhoneContactServiceImpl.access$2200(this.a);
    PhoneContactServiceImpl.access$2300(this.a, true, true, 6L);
  }
  
  protected void onUploadProgressUpdated(int paramInt1, int paramInt2)
  {
    if (PhoneContactServiceImpl.access$400(this.a)) {
      return;
    }
    PhoneContactServiceImpl localPhoneContactServiceImpl;
    if (PhoneContactServiceImpl.access$1500(this.a) == null)
    {
      localPhoneContactServiceImpl = this.a;
      PhoneContactServiceImpl.access$1502(localPhoneContactServiceImpl, new PhoneContactServiceImpl.UploadProgressGenerator(localPhoneContactServiceImpl, null));
    }
    PhoneContactServiceImpl.access$1500(this.a).a(paramInt1, paramInt2);
    if (PhoneContactServiceImpl.access$1600(this.a))
    {
      localPhoneContactServiceImpl = this.a;
      PhoneContactServiceImpl.access$1800(localPhoneContactServiceImpl, 2, PhoneContactServiceImpl.access$1700(localPhoneContactServiceImpl).size(), paramInt1, paramInt2);
    }
  }
  
  protected void onVerifyBindSms(boolean paramBoolean, int paramInt)
  {
    if (PhoneContactServiceImpl.access$400(this.a)) {
      return;
    }
    if ((paramBoolean) && (paramInt == 0)) {
      PhoneContactServiceImpl.access$2300(this.a, true, true, 10L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.impl.PhoneContactServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */