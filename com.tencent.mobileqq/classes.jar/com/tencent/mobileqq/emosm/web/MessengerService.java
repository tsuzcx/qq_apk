package com.tencent.mobileqq.emosm.web;

import akbj;
import akro;
import allb;
import alox;
import alwk;
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
import aplm;
import apln;
import aplo;
import aplp;
import aplq;
import aplr;
import apls;
import aplt;
import aplu;
import aplv;
import aplw;
import aplx;
import aply;
import apmx;
import apne;
import apnf;
import apnq;
import apns;
import axxl;
import axzt;
import bada;
import bdwb;
import bdyp;
import bfvh;
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
  implements aplm
{
  public akbj a;
  public allb a;
  public alox a;
  public alwk a;
  public Bundle a;
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public Messenger a;
  private aply jdField_a_of_type_Aply;
  public apmx a;
  public apnq a;
  public apns a;
  public axxl a;
  public bada a;
  public bdwb a;
  public bdyp a;
  public bfvh a;
  public List<Bundle> a;
  num jdField_a_of_type_Num = new aplo(this);
  public Bundle b;
  Messenger b;
  public Bundle c = null;
  public Bundle d = null;
  
  public MessengerService()
  {
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_Apns = new apln(this);
    this.jdField_a_of_type_Apnq = new aplq(this);
    this.jdField_a_of_type_Bada = new aplr(this);
    this.jdField_a_of_type_Bdyp = new apls(this);
    this.jdField_a_of_type_Bdwb = new aplt(this);
    this.jdField_a_of_type_Apmx = new apmx(this);
    this.jdField_a_of_type_Alwk = new alwk(this.jdField_a_of_type_Apmx);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_Allb = new aplu(this);
    this.jdField_a_of_type_Akbj = new aplv(this);
    this.jdField_b_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Axxl = new aplw(this);
    this.jdField_a_of_type_Alox = new aplx(this);
    this.jdField_a_of_type_Bfvh = new aplp(this);
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
      this.jdField_a_of_type_Aply = new aply(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      this.jdField_b_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Aply);
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Akbj);
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
    if (this.jdField_a_of_type_Aply != null)
    {
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        localObject = (VasQuickUpdateManager)((QQAppInterface)this.app).getManager(184);
        if (localObject != null) {
          ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_a_of_type_Aply.a);
        }
      }
      this.jdField_a_of_type_Aply.getLooper().quit();
      this.jdField_a_of_type_Aply = null;
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
      if ((apnf)this.app.getManager(43) != null) {
        apnf.a.b(this.jdField_a_of_type_Apns);
      }
      if (this.jdField_a_of_type_Alwk != null)
      {
        this.jdField_a_of_type_Alwk.a();
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Alwk);
        this.jdField_a_of_type_Alwk = null;
      }
      this.jdField_a_of_type_Apmx = null;
      if (this.jdField_a_of_type_Allb != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Allb);
        this.jdField_a_of_type_Allb = null;
      }
      if (this.jdField_a_of_type_Bdyp != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Bdyp);
        this.jdField_a_of_type_Bdyp = null;
      }
      if (this.jdField_a_of_type_Bada != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Bada);
        this.jdField_a_of_type_Bada = null;
      }
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Akbj);
      this.jdField_a_of_type_Akbj.a();
      if (this.jdField_a_of_type_Num != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Num);
        this.jdField_a_of_type_Num = null;
      }
      if (this.jdField_a_of_type_Alox != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Alox);
        this.jdField_a_of_type_Alox = null;
      }
      if (this.jdField_a_of_type_Axxl != null)
      {
        localObject = (axzt)((QQAppInterface)localObject).getManager(15);
        if (localObject != null)
        {
          ((axzt)localObject).b(this.jdField_a_of_type_Axxl);
          this.jdField_a_of_type_Axxl = null;
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
    akro.b();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */