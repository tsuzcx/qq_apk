package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

class ContactImpl$2
  extends ContactBindObserver
{
  ContactImpl$2(ContactImpl paramContactImpl, IRegisterView paramIRegisterView) {}
  
  protected void onGetBindUinWithPhone(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RegisterQQNumberActivity onGetBindUinWithPhone isSuccess = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append("; isBindOk = ");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(";hadbind = ");
      ((StringBuilder)localObject).append(paramBoolean3);
      ((StringBuilder)localObject).append(";uin =");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("ContactImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        ContactImpl.a(this.b, true);
        this.a.m();
        return;
      }
      if ((paramBoolean3) && (!TextUtils.isEmpty(paramString)))
      {
        this.a.n();
        if (ContactImpl.a(this.b) != null)
        {
          localObject = new Intent(ContactImpl.a(this.b), VerifyPhoneNumActivity.class);
          ((Intent)localObject).putExtra("phonenum", ContactImpl.b(this.b));
          ((Intent)localObject).putExtra("key", ContactImpl.c(this.b));
          ((Intent)localObject).putExtra("uin", ContactImpl.d(this.b));
          ((Intent)localObject).putExtra("key_register_sign", ContactImpl.e(this.b));
          ((Intent)localObject).putExtra("key_register_binduin", paramString);
          ContactImpl.a(this.b).startActivity((Intent)localObject);
          ContactImpl.a(this.b).finish();
        }
      }
      else
      {
        this.a.m();
      }
    }
    else
    {
      this.a.m();
    }
  }
  
  protected void onUploadContact(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUploadContact  isSuccess = ");
      localStringBuilder.append(paramBoolean);
      QLog.d("ContactImpl", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.ContactImpl.2
 * JD-Core Version:    0.7.0.1
 */