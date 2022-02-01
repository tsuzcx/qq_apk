package com.tencent.mobileqq.emosm.web;

import alfm;
import alvx;
import amsu;
import amzh;
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
import arci;
import arcj;
import arck;
import arcl;
import arcm;
import arcn;
import arco;
import arcp;
import arcq;
import arcr;
import arcs;
import arct;
import arcu;
import ardt;
import area;
import areb;
import arem;
import areo;
import bamr;
import baoy;
import bcuz;
import bgok;
import bgqy;
import binf;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.CardObserver;
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
import ogm;

public class MessengerService
  extends AppService
  implements arci
{
  public alfm a;
  public amsu a;
  public amzh a;
  public Bundle a;
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public Messenger a;
  private arcu jdField_a_of_type_Arcu;
  public ardt a;
  public arem a;
  public areo a;
  public bamr a;
  public bcuz a;
  public bgok a;
  public bgqy a;
  public binf a;
  public CardObserver a;
  public List<Bundle> a;
  ogm jdField_a_of_type_Ogm = new arck(this);
  public Bundle b;
  Messenger b;
  public Bundle c = null;
  public Bundle d = null;
  
  public MessengerService()
  {
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_Areo = new arcj(this);
    this.jdField_a_of_type_Arem = new arcm(this);
    this.jdField_a_of_type_Bcuz = new arcn(this);
    this.jdField_a_of_type_Bgqy = new arco(this);
    this.jdField_a_of_type_Bgok = new arcp(this);
    this.jdField_a_of_type_Ardt = new ardt(this);
    this.jdField_a_of_type_Amzh = new amzh(this.jdField_a_of_type_Ardt);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new arcq(this);
    this.jdField_a_of_type_Alfm = new arcr(this);
    this.jdField_b_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_Bamr = new arcs(this);
    this.jdField_a_of_type_Amsu = new arct(this);
    this.jdField_a_of_type_Binf = new arcl(this);
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
      this.jdField_a_of_type_Arcu = new arcu(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      this.jdField_b_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Arcu);
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_Alfm);
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
    if (this.jdField_a_of_type_Arcu != null)
    {
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        localObject = (VasQuickUpdateManager)((QQAppInterface)this.app).getManager(184);
        if (localObject != null) {
          ((VasQuickUpdateManager)localObject).removeCallBacker(this.jdField_a_of_type_Arcu.a);
        }
      }
      this.jdField_a_of_type_Arcu.getLooper().quit();
      this.jdField_a_of_type_Arcu = null;
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
      if ((areb)this.app.getManager(43) != null) {
        areb.a.b(this.jdField_a_of_type_Areo);
      }
      if (this.jdField_a_of_type_Amzh != null)
      {
        this.jdField_a_of_type_Amzh.a();
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Amzh);
        this.jdField_a_of_type_Amzh = null;
      }
      this.jdField_a_of_type_Ardt = null;
      if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = null;
      }
      if (this.jdField_a_of_type_Bgqy != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Bgqy);
        this.jdField_a_of_type_Bgqy = null;
      }
      if (this.jdField_a_of_type_Bcuz != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Bcuz);
        this.jdField_a_of_type_Bcuz = null;
      }
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_Alfm);
      this.jdField_a_of_type_Alfm.a();
      if (this.jdField_a_of_type_Ogm != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Ogm);
        this.jdField_a_of_type_Ogm = null;
      }
      if (this.jdField_a_of_type_Amsu != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Amsu);
        this.jdField_a_of_type_Amsu = null;
      }
      if (this.jdField_a_of_type_Bamr != null)
      {
        localObject = (baoy)((QQAppInterface)localObject).getManager(15);
        if (localObject != null)
        {
          ((baoy)localObject).b(this.jdField_a_of_type_Bamr);
          this.jdField_a_of_type_Bamr = null;
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
    alvx.b();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */