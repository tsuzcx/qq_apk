package com.tencent.mobileqq.emosm.web;

import alyx;
import ampj;
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
import aniz;
import anmu;
import anth;
import arsw;
import arsx;
import arsy;
import arsz;
import arta;
import artb;
import artc;
import artd;
import arte;
import artf;
import artg;
import arth;
import arti;
import aruh;
import aruo;
import arup;
import arva;
import arvc;
import bbad;
import bbck;
import bdin;
import bhhl;
import bhka;
import bjha;
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
import odp;

public class MessengerService
  extends AppService
  implements arsw
{
  public alyx a;
  public Bundle a;
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public Messenger a;
  public aniz a;
  public anmu a;
  public anth a;
  private arti jdField_a_of_type_Arti;
  public aruh a;
  public arva a;
  public arvc a;
  public bbad a;
  public bdin a;
  public bhhl a;
  public bhka a;
  public bjha a;
  public List<Bundle> a;
  odp jdField_a_of_type_Odp = new arsy(this);
  public Bundle b;
  Messenger b;
  public Bundle c = null;
  public Bundle d = null;
  
  public MessengerService()
  {
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_Arvc = new arsx(this);
    this.jdField_a_of_type_Arva = new arta(this);
    this.jdField_a_of_type_Bdin = new artb(this);
    this.jdField_a_of_type_Bhka = new artc(this);
    this.jdField_a_of_type_Bhhl = new artd(this);
    this.jdField_a_of_type_Aruh = new aruh(this);
    this.jdField_a_of_type_Anth = new anth(this.jdField_a_of_type_Aruh);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_Aniz = new arte(this);
    this.jdField_a_of_type_Alyx = new artf(this);
    this.jdField_b_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Bbad = new artg(this);
    this.jdField_a_of_type_Anmu = new arth(this);
    this.jdField_a_of_type_Bjha = new arsz(this);
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
      this.jdField_a_of_type_Arti = new arti(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      this.jdField_b_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Arti);
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Alyx);
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
    if (this.jdField_a_of_type_Arti != null)
    {
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        localObject = (VasQuickUpdateManager)((QQAppInterface)this.app).getManager(184);
        if (localObject != null) {
          ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_a_of_type_Arti.a);
        }
      }
      this.jdField_a_of_type_Arti.getLooper().quit();
      this.jdField_a_of_type_Arti = null;
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
      if ((arup)this.app.getManager(43) != null) {
        arup.a.b(this.jdField_a_of_type_Arvc);
      }
      if (this.jdField_a_of_type_Anth != null)
      {
        this.jdField_a_of_type_Anth.a();
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Anth);
        this.jdField_a_of_type_Anth = null;
      }
      this.jdField_a_of_type_Aruh = null;
      if (this.jdField_a_of_type_Aniz != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Aniz);
        this.jdField_a_of_type_Aniz = null;
      }
      if (this.jdField_a_of_type_Bhka != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Bhka);
        this.jdField_a_of_type_Bhka = null;
      }
      if (this.jdField_a_of_type_Bdin != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Bdin);
        this.jdField_a_of_type_Bdin = null;
      }
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Alyx);
      this.jdField_a_of_type_Alyx.a();
      if (this.jdField_a_of_type_Odp != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Odp);
        this.jdField_a_of_type_Odp = null;
      }
      if (this.jdField_a_of_type_Anmu != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Anmu);
        this.jdField_a_of_type_Anmu = null;
      }
      if (this.jdField_a_of_type_Bbad != null)
      {
        localObject = (bbck)((QQAppInterface)localObject).getManager(15);
        if (localObject != null)
        {
          ((bbck)localObject).b(this.jdField_a_of_type_Bbad);
          this.jdField_a_of_type_Bbad = null;
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
    ampj.b();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */