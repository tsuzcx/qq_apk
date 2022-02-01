package com.tencent.mobileqq.emosm.web;

import amdi;
import amwn;
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
import anvi;
import aobw;
import asgs;
import asgt;
import asgu;
import asgv;
import asgw;
import asgx;
import asgy;
import asgz;
import asha;
import ashb;
import ashc;
import ashd;
import ashe;
import ashu;
import asig;
import asih;
import asis;
import asiu;
import bbtg;
import bbvn;
import beby;
import bhyu;
import bibo;
import bjyh;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
import oof;

public class MessengerService
  extends AppService
  implements asgs
{
  public amdi a;
  public Bundle a;
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public Messenger a;
  public anvi a;
  public aobw a;
  private ashe jdField_a_of_type_Ashe;
  public ashu a;
  public asis a;
  public asiu a;
  public bbtg a;
  public beby a;
  public bhyu a;
  public bibo a;
  public bjyh a;
  public CardObserver a;
  public List<Bundle> a;
  oof jdField_a_of_type_Oof = new asgu(this);
  public Bundle b;
  Messenger b;
  public Bundle c = null;
  public Bundle d = null;
  
  public MessengerService()
  {
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_Asiu = new asgt(this);
    this.jdField_a_of_type_Asis = new asgw(this);
    this.jdField_a_of_type_Beby = new asgx(this);
    this.jdField_a_of_type_Bibo = new asgy(this);
    this.jdField_a_of_type_Bhyu = new asgz(this);
    this.jdField_a_of_type_Ashu = new ashu(this);
    this.jdField_a_of_type_Aobw = new aobw(this.jdField_a_of_type_Ashu);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new asha(this);
    this.jdField_a_of_type_Amdi = new ashb(this);
    this.jdField_b_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Bbtg = new ashc(this);
    this.jdField_a_of_type_Anvi = new ashd(this);
    this.jdField_a_of_type_Bjyh = new asgv(this);
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
      this.jdField_a_of_type_Ashe = new ashe(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      this.jdField_b_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Ashe);
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Amdi);
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
    if (this.jdField_a_of_type_Ashe != null)
    {
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        localObject = (VasQuickUpdateManager)((QQAppInterface)this.app).getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER);
        if (localObject != null) {
          ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_a_of_type_Ashe.a);
        }
      }
      this.jdField_a_of_type_Ashe.getLooper().quit();
      this.jdField_a_of_type_Ashe = null;
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
      if ((asih)this.app.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER) != null) {
        asih.a.b(this.jdField_a_of_type_Asiu);
      }
      if (this.jdField_a_of_type_Aobw != null)
      {
        this.jdField_a_of_type_Aobw.a();
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Aobw);
        this.jdField_a_of_type_Aobw = null;
      }
      this.jdField_a_of_type_Ashu = null;
      if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = null;
      }
      if (this.jdField_a_of_type_Bibo != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Bibo);
        this.jdField_a_of_type_Bibo = null;
      }
      if (this.jdField_a_of_type_Beby != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Beby);
        this.jdField_a_of_type_Beby = null;
      }
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Amdi);
      this.jdField_a_of_type_Amdi.a();
      if (this.jdField_a_of_type_Oof != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Oof);
        this.jdField_a_of_type_Oof = null;
      }
      if (this.jdField_a_of_type_Anvi != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Anvi);
        this.jdField_a_of_type_Anvi = null;
      }
      if (this.jdField_a_of_type_Bbtg != null)
      {
        localObject = (bbvn)((QQAppInterface)localObject).getManager(QQManagerFactory.STATUS_MANAGER);
        if (localObject != null)
        {
          ((bbvn)localObject).b(this.jdField_a_of_type_Bbtg);
          this.jdField_a_of_type_Bbtg = null;
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
    amwn.b();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */