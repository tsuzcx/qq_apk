package com.tencent.mobileqq.emosm.web;

import aijz;
import ajac;
import ajto;
import ajxj;
import akeu;
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
import anue;
import anuf;
import anug;
import anuh;
import anui;
import anuj;
import anuk;
import anul;
import anum;
import anun;
import anuo;
import anup;
import anuq;
import anvp;
import anvw;
import anvx;
import anwi;
import anwk;
import awci;
import aweq;
import ayfd;
import bbxa;
import bbzo;
import bdvm;
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
import nrc;

public class MessengerService
  extends AppService
  implements anue
{
  public aijz a;
  public ajto a;
  public ajxj a;
  public akeu a;
  public Bundle a;
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public Messenger a;
  private anuq jdField_a_of_type_Anuq;
  public anvp a;
  public anwi a;
  public anwk a;
  public awci a;
  public ayfd a;
  public bbxa a;
  public bbzo a;
  public bdvm a;
  public List<Bundle> a;
  nrc jdField_a_of_type_Nrc = new anug(this);
  public Bundle b;
  Messenger b;
  public Bundle c = null;
  public Bundle d = null;
  
  public MessengerService()
  {
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_Anwk = new anuf(this);
    this.jdField_a_of_type_Anwi = new anui(this);
    this.jdField_a_of_type_Ayfd = new anuj(this);
    this.jdField_a_of_type_Bbzo = new anuk(this);
    this.jdField_a_of_type_Bbxa = new anul(this);
    this.jdField_a_of_type_Anvp = new anvp(this);
    this.jdField_a_of_type_Akeu = new akeu(this.jdField_a_of_type_Anvp);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_Ajto = new anum(this);
    this.jdField_a_of_type_Aijz = new anun(this);
    this.jdField_b_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Awci = new anuo(this);
    this.jdField_a_of_type_Ajxj = new anup(this);
    this.jdField_a_of_type_Bdvm = new anuh(this);
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
      this.jdField_a_of_type_Anuq = new anuq(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      this.jdField_b_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Anuq);
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Aijz);
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
    if (this.jdField_a_of_type_Anuq != null)
    {
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        localObject = (VasQuickUpdateManager)((QQAppInterface)this.app).getManager(184);
        if (localObject != null) {
          ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_a_of_type_Anuq.a);
        }
      }
      this.jdField_a_of_type_Anuq.getLooper().quit();
      this.jdField_a_of_type_Anuq = null;
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
      if ((anvx)this.app.getManager(43) != null) {
        anvx.a.b(this.jdField_a_of_type_Anwk);
      }
      if (this.jdField_a_of_type_Akeu != null)
      {
        this.jdField_a_of_type_Akeu.a();
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Akeu);
        this.jdField_a_of_type_Akeu = null;
      }
      this.jdField_a_of_type_Anvp = null;
      if (this.jdField_a_of_type_Ajto != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Ajto);
        this.jdField_a_of_type_Ajto = null;
      }
      if (this.jdField_a_of_type_Bbzo != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Bbzo);
        this.jdField_a_of_type_Bbzo = null;
      }
      if (this.jdField_a_of_type_Ayfd != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Ayfd);
        this.jdField_a_of_type_Ayfd = null;
      }
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Aijz);
      this.jdField_a_of_type_Aijz.a();
      if (this.jdField_a_of_type_Nrc != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Nrc);
        this.jdField_a_of_type_Nrc = null;
      }
      if (this.jdField_a_of_type_Ajxj != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Ajxj);
        this.jdField_a_of_type_Ajxj = null;
      }
      if (this.jdField_a_of_type_Awci != null)
      {
        localObject = (aweq)((QQAppInterface)localObject).getManager(15);
        if (localObject != null)
        {
          ((aweq)localObject).b(this.jdField_a_of_type_Awci);
          this.jdField_a_of_type_Awci = null;
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
    ajac.b();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */