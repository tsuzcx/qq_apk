package com.tencent.open.model;

import alrd;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.OpenConst;
import com.tencent.open.OpenLog;
import com.tencent.open.data.SharedPrefs;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import mqq.manager.WtloginManager;
import mqq.observer.SSOAccountObserver;

public class AccountManage
  implements OpenConst
{
  private static AccountManage jdField_a_of_type_ComTencentOpenModelAccountManage;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication();
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
  private WtloginManager jdField_a_of_type_MqqManagerWtloginManager = (WtloginManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(1);
  
  public static AccountManage a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenModelAccountManage == null) {
        jdField_a_of_type_ComTencentOpenModelAccountManage = new AccountManage();
      }
      AccountManage localAccountManage = jdField_a_of_type_ComTencentOpenModelAccountManage;
      return localAccountManage;
    }
    finally {}
  }
  
  public void a()
  {
    Object localObject = SharedPrefs.a();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (this.jdField_a_of_type_MqqManagerWtloginManager.IsNeedLoginWithPasswd(str, 16)) {
          SharedPrefs.b(str);
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt, SSOAccountObserver paramSSOAccountObserver, boolean paramBoolean)
  {
    Object localObject2;
    Object localObject1;
    if ((!SharedPrefs.a(paramString)) && (!paramBoolean))
    {
      localObject2 = (TicketManager)this.jdField_a_of_type_MqqAppAppRuntime.getManager(2);
      switch (paramInt)
      {
      default: 
        localObject1 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          Object localObject3 = ((TicketManager)localObject2).getSt(paramString, 16);
          byte[] arrayOfByte = ((TicketManager)localObject2).getStkey(paramString, 16);
          if ((localObject3 != null) && (arrayOfByte != null))
          {
            OpenLog.a(null, 2, "delegateGetTicketNoPasswd fake SSOAccountObserver success.");
            localObject2 = new Bundle();
            ((Bundle)localObject2).putBoolean("fake_callback", true);
            ((Bundle)localObject2).putByteArray("st_temp", (byte[])localObject3);
            ((Bundle)localObject2).putByteArray("st_temp_key", arrayOfByte);
            localObject3 = new WeakReference(paramSSOAccountObserver);
            this.jdField_a_of_type_AndroidOsHandler.post(new alrd(this, (WeakReference)localObject3, paramString, (String)localObject1, paramInt, (Bundle)localObject2));
          }
        }
        break;
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i != 0) {
        this.jdField_a_of_type_MqqAppAppRuntime.ssoGetTicketNoPasswd(paramString, paramInt, paramSSOAccountObserver);
      }
      return;
      localObject1 = ((TicketManager)localObject2).getSkey(paramString);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.open.model.AccountManage
 * JD-Core Version:    0.7.0.1
 */