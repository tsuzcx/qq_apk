package com.tencent.mobileqq.emosm.web;

import amkp;
import anbd;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import anuw;
import anyu;
import aofr;
import asik;
import asil;
import asim;
import asin;
import asio;
import asip;
import asiq;
import asir;
import asis;
import asit;
import asiu;
import asiv;
import asiw;
import asjv;
import askc;
import askd;
import asko;
import askq;
import bbsw;
import bbvd;
import bebi;
import biia;
import bikp;
import bkia;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.os.MqqHandler;
import oez;

public class MessengerService
  extends AppService
  implements asik
{
  public amkp a;
  public Bundle a;
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public Messenger a;
  public anuw a;
  public anyu a;
  public aofr a;
  private asiw jdField_a_of_type_Asiw;
  public asjv a;
  public asko a;
  public askq a;
  public bbsw a;
  public bebi a;
  public biia a;
  public bikp a;
  public bkia a;
  public List<Bundle> a;
  oez jdField_a_of_type_Oez = new asim(this);
  public Bundle b;
  Messenger b;
  public Bundle c = null;
  public Bundle d = null;
  
  public MessengerService()
  {
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_Askq = new asil(this);
    this.jdField_a_of_type_Asko = new asio(this);
    this.jdField_a_of_type_Bebi = new asip(this);
    this.jdField_a_of_type_Bikp = new asiq(this);
    this.jdField_a_of_type_Biia = new asir(this);
    this.jdField_a_of_type_Asjv = new asjv(this);
    this.jdField_a_of_type_Aofr = new aofr(this.jdField_a_of_type_Asjv);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_Anuw = new asis(this);
    this.jdField_a_of_type_Amkp = new asit(this);
    this.jdField_b_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Bbsw = new asiu(this);
    this.jdField_a_of_type_Anyu = new asiv(this);
    this.jdField_a_of_type_Bkia = new asin(this);
  }
  
  public static void a(MessengerService paramMessengerService)
  {
    if ((paramMessengerService != null) && ((paramMessengerService.app instanceof QQAppInterface)))
    {
      paramMessengerService = ((QQAppInterface)paramMessengerService.app).getHandler(Conversation.class);
      if (paramMessengerService != null) {
        paramMessengerService.sendMessage(paramMessengerService.obtainMessage(1134042));
      }
    }
  }
  
  @TargetApi(11)
  public static void b(MessengerService paramMessengerService)
  {
    if ((paramMessengerService != null) && (Build.VERSION.SDK_INT >= 11)) {}
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidOsMessenger != null) {}
    try
    {
      Message localMessage = Message.obtain(null, 4);
      localMessage.setData(paramBundle);
      this.jdField_a_of_type_AndroidOsMessenger.send(localMessage);
      return;
    }
    catch (RemoteException paramBundle)
    {
      paramBundle.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.web.MessengerService", 2, paramString);
    }
  }
  
  public void b(String paramString)
  {
    Intent localIntent;
    if (!TextUtils.isEmpty(paramString))
    {
      localIntent = new Intent(this, VipProfileCardPhotoHandlerActivity.class);
      localIntent.setFlags(268435456);
      if (!paramString.equals("selectPhoto")) {
        break label49;
      }
      localIntent.putExtra("action", "select_photo");
    }
    for (;;)
    {
      startActivity(localIntent);
      return;
      label49:
      if (paramString.equals("takePhoto")) {
        localIntent.putExtra("action", "take_photo");
      }
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService onBind");
    }
    if (this.jdField_b_of_type_AndroidOsMessenger != null) {
      return this.jdField_b_of_type_AndroidOsMessenger.getBinder();
    }
    return null;
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService oncreate");
    }
    try
    {
      super.onCreate();
      this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("Vas_MessengerServiceWorkerThread", -2);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_Asiw = new asiw(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      this.jdField_b_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Asiw);
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Amkp);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("MessengerService", 1, "onCreate OutOfMemoryError " + localOutOfMemoryError);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("Q.emoji.web.MessengerService", 1, "onCreate error! " + QLog.getStackTraceString(localThrowable));
      return;
    }
    if (this.app == null)
    {
      a("-->app is null");
      return;
    }
    a("-->app is not qqappinterface");
  }
  
  public void onDestroy()
  {
    Object localObject;
    if (this.jdField_a_of_type_Asiw != null)
    {
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        localObject = (VasQuickUpdateManager)((QQAppInterface)this.app).getManager(184);
        if (localObject != null) {
          ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_a_of_type_Asiw.a);
        }
      }
      this.jdField_a_of_type_Asiw.getLooper().quit();
      this.jdField_a_of_type_Asiw = null;
    }
    if (this.jdField_a_of_type_AndroidOsHandlerThread != null) {
      this.jdField_a_of_type_AndroidOsHandlerThread = null;
    }
    this.jdField_a_of_type_AndroidOsMessenger = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService destroied");
    }
    if ((this.app != null) && ((this.app instanceof QQAppInterface)))
    {
      localObject = (QQAppInterface)this.app;
      if ((askd)this.app.getManager(43) != null) {
        askd.a.b(this.jdField_a_of_type_Askq);
      }
      if (this.jdField_a_of_type_Aofr != null)
      {
        this.jdField_a_of_type_Aofr.a();
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Aofr);
        this.jdField_a_of_type_Aofr = null;
      }
      this.jdField_a_of_type_Asjv = null;
      if (this.jdField_a_of_type_Anuw != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Anuw);
        this.jdField_a_of_type_Anuw = null;
      }
      if (this.jdField_a_of_type_Bikp != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Bikp);
        this.jdField_a_of_type_Bikp = null;
      }
      if (this.jdField_a_of_type_Bebi != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Bebi);
        this.jdField_a_of_type_Bebi = null;
      }
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Amkp);
      this.jdField_a_of_type_Amkp.a();
      if (this.jdField_a_of_type_Oez != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Oez);
        this.jdField_a_of_type_Oez = null;
      }
      if (this.jdField_a_of_type_Anyu != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Anyu);
        this.jdField_a_of_type_Anyu = null;
      }
      if (this.jdField_a_of_type_Bbsw != null)
      {
        localObject = (bbvd)((QQAppInterface)localObject).getManager(15);
        if (localObject != null)
        {
          ((bbvd)localObject).b(this.jdField_a_of_type_Bbsw);
          this.jdField_a_of_type_Bbsw = null;
        }
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
        this.jdField_a_of_type_AndroidOsHandler = null;
      }
    }
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService onUnbind");
    }
    anbd.b();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */