package com.tencent.mobileqq.emosm.web;

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
import com.tencent.biz.pubaccount.ecshopassit.EcshopAdObserver;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerRecallListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.gamecenter.data.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.message.GameMsgManager;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.mobileqq.vipav.VipFunCallObserver;
import com.tencent.qidian.controller.QidianBusinessObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessengerService
  extends AppService
  implements IPCConstants
{
  Bundle jdField_a_of_type_AndroidOsBundle = null;
  Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  Messenger jdField_a_of_type_AndroidOsMessenger = null;
  EcshopAdObserver jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdObserver = new MessengerService.11(this);
  VipSpecialCareHandler jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialCareHandler = new MessengerService.8(this);
  CardObserver jdField_a_of_type_ComTencentMobileqqAppCardObserver = new MessengerService.6(this);
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new MessengerService.10(this);
  QWalletAuthObserver jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver = new QWalletAuthObserver(this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService$QWalletMsgHandler);
  private MessengerService.IncomingHandler jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService$IncomingHandler;
  MessengerService.QWalletMsgHandler jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService$QWalletMsgHandler = new MessengerService.QWalletMsgHandler(this);
  public EmojiStickerManager.StickerRecallListener a;
  public EmoticonPackageDownloadListener a;
  ProfileCardObserver jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = new MessengerService.7(this);
  IStatusListener jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = new MessengerService.9(this);
  TeamWorkFileImportObserver jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver = new MessengerService.3(this);
  IPCDownloadListener jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = new MessengerService.5(this);
  VipFunCallObserver jdField_a_of_type_ComTencentMobileqqVipavVipFunCallObserver = new MessengerService.4(this);
  QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new MessengerService.12(this);
  public List<Bundle> a;
  Bundle jdField_b_of_type_AndroidOsBundle = null;
  Messenger jdField_b_of_type_AndroidOsMessenger;
  Bundle c = null;
  Bundle d = null;
  
  public MessengerService()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new MessengerService.1(this);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerRecallListener = new MessengerService.2(this);
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (GameMsgManager)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", 0);
    localBundle.putInt("cnt", paramQQAppInterface.b());
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "[handleMessage] cmd:ipc_cmd_gamecenter_get_unread_total,data:" + localBundle);
    }
    return localBundle;
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject1;
    do
    {
      try
      {
        Object localObject = ((GameMsgManager)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a(paramInt, "");
        paramQQAppInterface = new JSONArray();
        localJSONObject1 = new JSONObject();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            JSONObject localJSONObject2 = ((GameCenterSessionInfo)((Iterator)localObject).next()).a();
            if (localJSONObject2 != null) {
              paramQQAppInterface.put(localJSONObject2);
            }
          }
        }
        localJSONObject1.put("session", paramQQAppInterface);
      }
      catch (Throwable paramQQAppInterface)
      {
        localBundle.putInt("result", -1);
        QLog.e("Q.emoji.web.MessengerService", 1, "getGameCenterSessionInfo e:" + paramQQAppInterface);
        return localBundle;
      }
      localBundle.putInt("result", 0);
      localBundle.putString("data", localJSONObject1.toString());
    } while (!QLog.isColorLevel());
    QLog.i("Q.emoji.web.MessengerService", 2, "[handleMessage] cmd:ipc_cmd_gamecenter_get_session_info,data:" + localJSONObject1.toString());
    return localBundle;
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = (GameMsgManager)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
    paramQQAppInterface = paramQQAppInterface.getApp().getApplicationContext();
    localObject = ((GameMsgManager)localObject).a(paramString);
    Bundle localBundle = new Bundle();
    if (localObject == null) {
      localBundle.putInt("result", -1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.web.MessengerService", 2, "[handleMessage] cmd:ipc_cmd_gamecenter_open_aio,data:" + localBundle);
      }
      return localBundle;
      GameMsgUtil.a(paramQQAppInterface, paramString, ((GameCenterSessionInfo)localObject).c(), ((GameCenterSessionInfo)localObject).b());
      localBundle.putInt("result", 0);
    }
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = (GameMsgManager)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
    paramQQAppInterface.a(paramString, paramInt1, paramInt2);
    paramString = new Bundle();
    paramString.putInt("result", 0);
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "[handleMessage] cmd:ipc_cmd_gamecenter_toggle_changed,data:" + paramString);
    }
    paramQQAppInterface.b();
    return paramString;
  }
  
  static void a(MessengerService paramMessengerService)
  {
    if ((paramMessengerService != null) && ((paramMessengerService.app instanceof QQAppInterface)))
    {
      paramMessengerService = ((QQAppInterface)paramMessengerService.app).getHandler(Conversation.class);
      if (paramMessengerService != null) {
        paramMessengerService.sendMessage(paramMessengerService.obtainMessage(1134042));
      }
    }
  }
  
  public static Bundle b(QQAppInterface paramQQAppInterface, String paramString)
  {
    Bundle localBundle = new Bundle();
    do
    {
      try
      {
        Object localObject = ((GameMsgManager)paramQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER)).a(3, paramString);
        paramQQAppInterface = new JSONArray();
        paramString = new JSONObject();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            JSONObject localJSONObject = ((GameCenterSessionInfo)((Iterator)localObject).next()).a();
            if (localJSONObject != null) {
              paramQQAppInterface.put(localJSONObject);
            }
          }
        }
        paramString.put("session", paramQQAppInterface);
      }
      catch (Throwable paramQQAppInterface)
      {
        localBundle.putInt("result", -1);
        QLog.e("Q.emoji.web.MessengerService", 1, "getGameCenterRequestInfo e:" + paramQQAppInterface);
        return localBundle;
      }
      localBundle.putInt("result", 0);
      localBundle.putString("data", paramString.toString());
    } while (!QLog.isColorLevel());
    QLog.i("Q.emoji.web.MessengerService", 2, "[handleMessage] cmd:ipc_cmd_gamecenter_get_request_info,data:" + paramString.toString());
    return localBundle;
  }
  
  @TargetApi(11)
  static void b(MessengerService paramMessengerService)
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
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.web.MessengerService", 2, paramString);
    }
  }
  
  void b(String paramString)
  {
    Intent localIntent;
    if (!TextUtils.isEmpty(paramString))
    {
      localIntent = new Intent(this, VipProfileCardPhotoHandlerActivity.class);
      localIntent.setFlags(268435456);
      if (!paramString.equals("selectPhoto")) {
        break label54;
      }
      localIntent.putExtra("action", "select_photo");
    }
    for (;;)
    {
      startActivity(localIntent);
      return;
      label54:
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
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService$IncomingHandler = new MessengerService.IncomingHandler(this.jdField_a_of_type_AndroidOsHandlerThread.getLooper(), this);
      this.jdField_b_of_type_AndroidOsMessenger = new Messenger(this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService$IncomingHandler);
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
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService$IncomingHandler != null)
    {
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        localObject = (QQAppInterface)this.app;
        localObject = (IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "");
        if (localObject != null) {
          ((IVasQuickUpdateService)localObject).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService$IncomingHandler.a);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService$IncomingHandler.getLooper().quit();
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService$IncomingHandler = null;
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
      if ((EmojiManager)this.app.getManager(QQManagerFactory.CHAT_EMOTION_MANAGER) != null) {
        EmojiManager.a.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver.a();
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService$QWalletMsgHandler = null;
      if (this.jdField_a_of_type_ComTencentMobileqqAppCardObserver != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppCardObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver);
        this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = null;
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
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdObserver != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdObserver);
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcshopAdObserver = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver != null)
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener != null)
      {
        localObject = (StatusManager)((QQAppInterface)localObject).getManager(QQManagerFactory.STATUS_MANAGER);
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
  
  public boolean onUnbind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService onUnbind");
    }
    CmGameUtil.b();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */