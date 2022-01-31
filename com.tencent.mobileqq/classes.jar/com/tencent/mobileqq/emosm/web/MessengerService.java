package com.tencent.mobileqq.emosm.web;

import abtr;
import abts;
import abtt;
import abtu;
import abtv;
import abtw;
import abtx;
import abty;
import abtz;
import abua;
import abub;
import abuc;
import abue;
import abvk;
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
import com.tencent.gdtad.net.GdtAdObserver;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerRecallListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver;
import com.tencent.mobileqq.theme.ThemeDownloader.ThemeDownloadListener;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.mobileqq.vipav.VipFunCallObserver;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.os.MqqHandler;

public class MessengerService
  extends AppService
  implements IPCConstants
{
  private abue jdField_a_of_type_Abue;
  public abvk a;
  public Bundle a;
  public Handler a;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  public Messenger a;
  GdtAdObserver jdField_a_of_type_ComTencentGdtadNetGdtAdObserver = new abtt(this);
  public VipSpecialCareHandler a;
  public CardObserver a;
  public FriendListObserver a;
  public QWalletAuthObserver a;
  public EmojiStickerManager.StickerRecallListener a;
  public EmoticonPackageDownloadListener a;
  public IStatusListener a;
  public TeamWorkFileImportObserver a;
  public ThemeDownloader.ThemeDownloadListener a;
  public IPCDownloadListener a;
  public VipFunCallObserver a;
  public QidianBusinessObserver a;
  public List a;
  public Bundle b;
  Messenger b;
  public Bundle c = null;
  
  public MessengerService()
  {
    this.jdField_a_of_type_AndroidOsMessenger = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new abtr(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerRecallListener = new abtv(this);
    this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver = new abtw(this);
    this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver = new abtx(this);
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = new abty(this);
    this.jdField_a_of_type_Abvk = new abvk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver = new QWalletAuthObserver(this.jdField_a_of_type_Abvk);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = new abtz(this);
    this.jdField_a_of_type_ComTencentMobileqqThemeThemeDownloader$ThemeDownloadListener = new abua(this);
    this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialCareHandler = new abub(this);
    this.jdField_b_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new abuc(this);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new abts(this);
    this.jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new abtu(this);
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
    super.onCreate();
    try
    {
      this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("MessengerServiceWorkerThread", -2);
      this.jdField_a_of_type_AndroidOsHandlerThread.start();
      this.jdField_a_of_type_Abue = new abue(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      this.jdField_b_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_Abue);
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        ((QQAppInterface)this.app).addObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialCareHandler);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("MessengerService", 1, "onCreate OutOfMemoryError " + localOutOfMemoryError);
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
    if (this.jdField_a_of_type_Abue != null)
    {
      this.jdField_a_of_type_Abue.getLooper().quit();
      this.jdField_a_of_type_Abue = null;
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
      Object localObject = (QQAppInterface)this.app;
      if ((EmojiManager)this.app.getManager(42) != null) {
        EmojiManager.a.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver.a();
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver = null;
      }
      this.jdField_a_of_type_Abvk = null;
      if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver);
        this.jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver);
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver = null;
      }
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialCareHandler);
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialCareHandler.a();
      if (this.jdField_a_of_type_ComTencentGdtadNetGdtAdObserver != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentGdtadNetGdtAdObserver);
        this.jdField_a_of_type_ComTencentGdtadNetGdtAdObserver = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener != null)
      {
        localObject = (StatusManager)((QQAppInterface)localObject).getManager(14);
        if (localObject != null)
        {
          ((StatusManager)localObject).b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
          this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = null;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */