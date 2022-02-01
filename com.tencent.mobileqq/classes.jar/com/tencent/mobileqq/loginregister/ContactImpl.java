package com.tencent.mobileqq.loginregister;

import android.content.Intent;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.phonecontact.handler.ContactBindServlet;
import com.tencent.mobileqq.phonecontact.observer.ContactBindObserver;
import com.tencent.mobileqq.util.BusinessUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;

public class ContactImpl
  implements IContactInterface
{
  private ContactBindObserver a;
  private boolean b;
  private QBaseActivity c;
  private String d;
  private String e;
  private String f;
  private byte[] g;
  
  private ContactBindObserver b(IRegisterView paramIRegisterView)
  {
    return new ContactImpl.2(this, paramIRegisterView);
  }
  
  public BusinessObserver a(IRegisterView paramIRegisterView)
  {
    if (this.a == null) {
      this.a = b(paramIRegisterView);
    }
    return this.a;
  }
  
  public void a(QBaseActivity paramQBaseActivity, Intent paramIntent)
  {
    this.c = paramQBaseActivity;
    this.d = paramIntent.getStringExtra("phonenum");
    this.e = paramIntent.getStringExtra("key");
    this.g = paramIntent.getByteArrayExtra("key_register_sign");
    this.f = paramIntent.getStringExtra("uin");
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    if (this.b)
    {
      ThreadManager.executeOnNetWorkThread(new ContactImpl.1(this, paramAppRuntime));
      QQToast.makeText(BaseApplication.getContext(), HardCodeUtil.a(2131899080), 0).show();
    }
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString)
  {
    BusinessUtils.a(paramAppRuntime, paramString);
  }
  
  public void a(AppRuntime paramAppRuntime, byte[] paramArrayOfByte, String paramString)
  {
    ContactBindServlet.a(paramAppRuntime, this.g, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.loginregister.ContactImpl
 * JD-Core Version:    0.7.0.1
 */