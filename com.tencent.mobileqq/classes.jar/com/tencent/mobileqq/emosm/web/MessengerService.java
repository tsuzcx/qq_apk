package com.tencent.mobileqq.emosm.web;

import aikb;
import ajae;
import ajtq;
import ajxl;
import akev;
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
import antz;
import anua;
import anub;
import anuc;
import anud;
import anue;
import anuf;
import anug;
import anuh;
import anui;
import anuj;
import anuk;
import anul;
import anvk;
import anvr;
import anvs;
import anwd;
import anwf;
import awcg;
import aweo;
import ayfb;
import bbwm;
import bbza;
import bduv;
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
import nrf;

public class MessengerService
  extends AppService
  implements antz
{
  public aikb a;
  public ajtq a;
  public ajxl a;
  public akev a;
  public Bundle a;
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public Messenger a;
  private anul jdField_a_of_type_Anul;
  public anvk a;
  public anwd a;
  public anwf a;
  public awcg a;
  public ayfb a;
  public bbwm a;
  public bbza a;
  public bduv a;
  public List<Bundle> a;
  nrf jdField_a_of_type_Nrf = new anub(this);
  public Bundle b;
  Messenger b;
  public Bundle c = null;
  public Bundle d = null;
  
  public MessengerService()
  {
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_Anwf = new anua(this);
    this.jdField_a_of_type_Anwd = new anud(this);
    this.jdField_a_of_type_Ayfb = new anue(this);
    this.jdField_a_of_type_Bbza = new anuf(this);
    this.jdField_a_of_type_Bbwm = new anug(this);
    this.jdField_a_of_type_Anvk = new anvk(this);
    this.jdField_a_of_type_Akev = new akev(this.jdField_a_of_type_Anvk);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_Ajtq = new anuh(this);
    this.jdField_a_of_type_Aikb = new anui(this);
    this.jdField_b_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Awcg = new anuj(this);
    this.jdField_a_of_type_Ajxl = new anuk(this);
    this.jdField_a_of_type_Bduv = new anuc(this);
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
      this.jdField_a_of_type_Anul = new anul(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      this.jdField_b_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Anul);
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Aikb);
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
    if (this.jdField_a_of_type_Anul != null)
    {
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        localObject = (VasQuickUpdateManager)((QQAppInterface)this.app).getManager(184);
        if (localObject != null) {
          ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_a_of_type_Anul.a);
        }
      }
      this.jdField_a_of_type_Anul.getLooper().quit();
      this.jdField_a_of_type_Anul = null;
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
      if ((anvs)this.app.getManager(43) != null) {
        anvs.a.b(this.jdField_a_of_type_Anwf);
      }
      if (this.jdField_a_of_type_Akev != null)
      {
        this.jdField_a_of_type_Akev.a();
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Akev);
        this.jdField_a_of_type_Akev = null;
      }
      this.jdField_a_of_type_Anvk = null;
      if (this.jdField_a_of_type_Ajtq != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Ajtq);
        this.jdField_a_of_type_Ajtq = null;
      }
      if (this.jdField_a_of_type_Bbza != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Bbza);
        this.jdField_a_of_type_Bbza = null;
      }
      if (this.jdField_a_of_type_Ayfb != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Ayfb);
        this.jdField_a_of_type_Ayfb = null;
      }
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Aikb);
      this.jdField_a_of_type_Aikb.a();
      if (this.jdField_a_of_type_Nrf != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Nrf);
        this.jdField_a_of_type_Nrf = null;
      }
      if (this.jdField_a_of_type_Ajxl != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Ajxl);
        this.jdField_a_of_type_Ajxl = null;
      }
      if (this.jdField_a_of_type_Awcg != null)
      {
        localObject = (aweo)((QQAppInterface)localObject).getManager(15);
        if (localObject != null)
        {
          ((aweo)localObject).b(this.jdField_a_of_type_Awcg);
          this.jdField_a_of_type_Awcg = null;
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
    ajae.b();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */