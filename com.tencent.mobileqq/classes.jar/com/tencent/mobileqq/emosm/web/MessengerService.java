package com.tencent.mobileqq.emosm.web;

import ahxi;
import aing;
import ajfo;
import ajjh;
import ajql;
import andr;
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
import ands;
import andt;
import andu;
import andv;
import andw;
import andx;
import andy;
import andz;
import anea;
import aneb;
import anec;
import aned;
import anfb;
import anfi;
import anfj;
import anfu;
import anfw;
import avcn;
import avev;
import axey;
import bats;
import bawg;
import bcqu;
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
import nge;

public class MessengerService
  extends AppService
  implements andr
{
  public ahxi a;
  public ajfo a;
  public ajjh a;
  public ajql a;
  public Bundle a;
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public Messenger a;
  private aned jdField_a_of_type_Aned;
  public anfb a;
  public anfu a;
  public anfw a;
  public avcn a;
  public axey a;
  public bats a;
  public bawg a;
  public bcqu a;
  public List<Bundle> a;
  nge jdField_a_of_type_Nge = new andt(this);
  public Bundle b;
  Messenger b;
  public Bundle c = null;
  public Bundle d = null;
  
  public MessengerService()
  {
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_Anfw = new ands(this);
    this.jdField_a_of_type_Anfu = new andv(this);
    this.jdField_a_of_type_Axey = new andw(this);
    this.jdField_a_of_type_Bawg = new andx(this);
    this.jdField_a_of_type_Bats = new andy(this);
    this.jdField_a_of_type_Anfb = new anfb(this);
    this.jdField_a_of_type_Ajql = new ajql(this.jdField_a_of_type_Anfb);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_Ajfo = new andz(this);
    this.jdField_a_of_type_Ahxi = new anea(this);
    this.jdField_b_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Avcn = new aneb(this);
    this.jdField_a_of_type_Ajjh = new anec(this);
    this.jdField_a_of_type_Bcqu = new andu(this);
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
      this.jdField_a_of_type_Aned = new aned(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      this.jdField_b_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Aned);
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Ahxi);
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
    if (this.jdField_a_of_type_Aned != null)
    {
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        localObject = (VasQuickUpdateManager)((QQAppInterface)this.app).getManager(184);
        if (localObject != null) {
          ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_a_of_type_Aned.a);
        }
      }
      this.jdField_a_of_type_Aned.getLooper().quit();
      this.jdField_a_of_type_Aned = null;
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
      if ((anfj)this.app.getManager(43) != null) {
        anfj.a.b(this.jdField_a_of_type_Anfw);
      }
      if (this.jdField_a_of_type_Ajql != null)
      {
        this.jdField_a_of_type_Ajql.a();
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Ajql);
        this.jdField_a_of_type_Ajql = null;
      }
      this.jdField_a_of_type_Anfb = null;
      if (this.jdField_a_of_type_Ajfo != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Ajfo);
        this.jdField_a_of_type_Ajfo = null;
      }
      if (this.jdField_a_of_type_Bawg != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Bawg);
        this.jdField_a_of_type_Bawg = null;
      }
      if (this.jdField_a_of_type_Axey != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Axey);
        this.jdField_a_of_type_Axey = null;
      }
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Ahxi);
      this.jdField_a_of_type_Ahxi.a();
      if (this.jdField_a_of_type_Nge != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Nge);
        this.jdField_a_of_type_Nge = null;
      }
      if (this.jdField_a_of_type_Ajjh != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Ajjh);
        this.jdField_a_of_type_Ajjh = null;
      }
      if (this.jdField_a_of_type_Avcn != null)
      {
        localObject = (avev)((QQAppInterface)localObject).getManager(15);
        if (localObject != null)
        {
          ((avev)localObject).b(this.jdField_a_of_type_Avcn);
          this.jdField_a_of_type_Avcn = null;
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
    aing.b();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */