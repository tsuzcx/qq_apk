package com.tencent.mobileqq.emosm.web;

import akfy;
import akwd;
import alpq;
import altm;
import amaz;
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
import appv;
import appw;
import appx;
import appy;
import appz;
import apqa;
import apqb;
import apqc;
import apqd;
import apqe;
import apqf;
import apqg;
import apqh;
import aprg;
import aprn;
import apro;
import aprz;
import apsb;
import aybu;
import ayec;
import bahj;
import beak;
import becy;
import bfzo;
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
import num;

public class MessengerService
  extends AppService
  implements appv
{
  public akfy a;
  public alpq a;
  public altm a;
  public amaz a;
  public Bundle a;
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public Messenger a;
  private apqh jdField_a_of_type_Apqh;
  public aprg a;
  public aprz a;
  public apsb a;
  public aybu a;
  public bahj a;
  public beak a;
  public becy a;
  public bfzo a;
  public List<Bundle> a;
  num jdField_a_of_type_Num = new appx(this);
  public Bundle b;
  Messenger b;
  public Bundle c = null;
  public Bundle d = null;
  
  public MessengerService()
  {
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_Apsb = new appw(this);
    this.jdField_a_of_type_Aprz = new appz(this);
    this.jdField_a_of_type_Bahj = new apqa(this);
    this.jdField_a_of_type_Becy = new apqb(this);
    this.jdField_a_of_type_Beak = new apqc(this);
    this.jdField_a_of_type_Aprg = new aprg(this);
    this.jdField_a_of_type_Amaz = new amaz(this.jdField_a_of_type_Aprg);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_Alpq = new apqd(this);
    this.jdField_a_of_type_Akfy = new apqe(this);
    this.jdField_b_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Aybu = new apqf(this);
    this.jdField_a_of_type_Altm = new apqg(this);
    this.jdField_a_of_type_Bfzo = new appy(this);
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
      this.jdField_a_of_type_Apqh = new apqh(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      this.jdField_b_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Apqh);
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Akfy);
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
    if (this.jdField_a_of_type_Apqh != null)
    {
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        localObject = (VasQuickUpdateManager)((QQAppInterface)this.app).getManager(184);
        if (localObject != null) {
          ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_a_of_type_Apqh.a);
        }
      }
      this.jdField_a_of_type_Apqh.getLooper().quit();
      this.jdField_a_of_type_Apqh = null;
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
      if ((apro)this.app.getManager(43) != null) {
        apro.a.b(this.jdField_a_of_type_Apsb);
      }
      if (this.jdField_a_of_type_Amaz != null)
      {
        this.jdField_a_of_type_Amaz.a();
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Amaz);
        this.jdField_a_of_type_Amaz = null;
      }
      this.jdField_a_of_type_Aprg = null;
      if (this.jdField_a_of_type_Alpq != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Alpq);
        this.jdField_a_of_type_Alpq = null;
      }
      if (this.jdField_a_of_type_Becy != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Becy);
        this.jdField_a_of_type_Becy = null;
      }
      if (this.jdField_a_of_type_Bahj != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Bahj);
        this.jdField_a_of_type_Bahj = null;
      }
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Akfy);
      this.jdField_a_of_type_Akfy.a();
      if (this.jdField_a_of_type_Num != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Num);
        this.jdField_a_of_type_Num = null;
      }
      if (this.jdField_a_of_type_Altm != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Altm);
        this.jdField_a_of_type_Altm = null;
      }
      if (this.jdField_a_of_type_Aybu != null)
      {
        localObject = (ayec)((QQAppInterface)localObject).getManager(15);
        if (localObject != null)
        {
          ((ayec)localObject).b(this.jdField_a_of_type_Aybu);
          this.jdField_a_of_type_Aybu = null;
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
    akwd.b();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */