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
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.QWalletAuthObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerRecallListener;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo;
import com.tencent.mobileqq.profile.VipProfileCardPhotoHandlerActivity;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.IStatusListener;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportObserver;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.vipav.VipFunCallObserver;
import com.tencent.mobileqq.vip.IPCDownloadListener;
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
  VipFunCallObserver jdField_a_of_type_ComTencentMobileqqVasVipavVipFunCallObserver = new MessengerService.4(this);
  IPCDownloadListener jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = new MessengerService.5(this);
  QidianBusinessObserver jdField_a_of_type_ComTencentQidianControllerQidianBusinessObserver = new MessengerService.11(this);
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
    Object localObject = (IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("result", 0);
    paramQQAppInterface.putInt("cnt", ((IGameMsgManagerService)localObject).getUnreadCnt4MsgTab());
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[handleMessage] cmd:ipc_cmd_gamecenter_get_unread_total,data:");
      ((StringBuilder)localObject).append(paramQQAppInterface);
      QLog.i("Q.emoji.web.MessengerService", 2, ((StringBuilder)localObject).toString());
    }
    return paramQQAppInterface;
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Bundle localBundle = new Bundle();
    try
    {
      Object localObject2 = ((IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSessionInfoList(paramInt, "");
      localObject1 = new JSONArray();
      paramQQAppInterface = new JSONObject();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          JSONObject localJSONObject = ((GameCenterSessionInfo)((Iterator)localObject2).next()).a();
          if (localJSONObject != null) {
            ((JSONArray)localObject1).put(localJSONObject);
          }
        }
      }
      paramQQAppInterface.put("session", localObject1);
      localBundle.putInt("result", 0);
      localBundle.putString("data", paramQQAppInterface.toString());
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("[handleMessage] cmd:ipc_cmd_gamecenter_get_session_info,data:");
        ((StringBuilder)localObject1).append(paramQQAppInterface.toString());
        QLog.i("Q.emoji.web.MessengerService", 2, ((StringBuilder)localObject1).toString());
        return localBundle;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      localBundle.putInt("result", -1);
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getGameCenterSessionInfo e:");
      ((StringBuilder)localObject1).append(paramQQAppInterface);
      QLog.e("Q.emoji.web.MessengerService", 1, ((StringBuilder)localObject1).toString());
    }
    return localBundle;
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, String paramString)
  {
    Object localObject = (IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    paramQQAppInterface = paramQQAppInterface.getApp().getApplicationContext();
    GameCenterSessionInfo localGameCenterSessionInfo = ((IGameMsgManagerService)localObject).getSessionInfoByUin(paramString);
    localObject = new Bundle();
    if (localGameCenterSessionInfo == null)
    {
      ((Bundle)localObject).putInt("result", -1);
    }
    else
    {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(paramQQAppInterface, paramString, localGameCenterSessionInfo.c(), localGameCenterSessionInfo.b());
      ((Bundle)localObject).putInt("result", 0);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("[handleMessage] cmd:ipc_cmd_gamecenter_open_aio,data:");
      paramQQAppInterface.append(localObject);
      QLog.i("Q.emoji.web.MessengerService", 2, paramQQAppInterface.toString());
    }
    return localObject;
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = (IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    paramQQAppInterface.onGameSwitchChange(paramString, paramInt1, paramInt2);
    paramString = new Bundle();
    paramString.putInt("result", 0);
    paramQQAppInterface.notifySessionChangedBySwitch();
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.web.MessengerService", 2, "[delGameSession]");
    }
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).delGameSession(paramString);
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("result", 0);
    return paramQQAppInterface;
  }
  
  @TargetApi(11)
  static void b(MessengerService paramMessengerService)
  {
    if (paramMessengerService != null) {
      int i = Build.VERSION.SDK_INT;
    }
  }
  
  public static Bundle c(QQAppInterface paramQQAppInterface, String paramString)
  {
    Bundle localBundle = new Bundle();
    try
    {
      Object localObject = ((IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSessionInfoList(3, paramString);
      paramString = new JSONArray();
      paramQQAppInterface = new JSONObject();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          JSONObject localJSONObject = ((GameCenterSessionInfo)((Iterator)localObject).next()).a();
          if (localJSONObject != null) {
            paramString.put(localJSONObject);
          }
        }
      }
      paramQQAppInterface.put("session", paramString);
      localBundle.putInt("result", 0);
      localBundle.putString("data", paramQQAppInterface.toString());
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("[handleMessage] cmd:ipc_cmd_gamecenter_get_request_info,data:");
        paramString.append(paramQQAppInterface.toString());
        QLog.i("Q.emoji.web.MessengerService", 2, paramString.toString());
        return localBundle;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      localBundle.putInt("result", -1);
      paramString = new StringBuilder();
      paramString.append("getGameCenterRequestInfo e:");
      paramString.append(paramQQAppInterface);
      QLog.e("Q.emoji.web.MessengerService", 1, paramString.toString());
    }
    return localBundle;
  }
  
  public void a(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidOsMessenger != null) {
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
  }
  
  void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.emoji.web.MessengerService", 2, paramString);
    }
  }
  
  void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Intent localIntent = new Intent(this, VipProfileCardPhotoHandlerActivity.class);
      localIntent.setFlags(268435456);
      if (paramString.equals("selectPhoto")) {
        localIntent.putExtra("action", "select_photo");
      } else if (paramString.equals("takePhoto")) {
        localIntent.putExtra("action", "take_photo");
      }
      startActivity(localIntent);
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService onBind");
    }
    paramIntent = this.jdField_b_of_type_AndroidOsMessenger;
    if (paramIntent != null) {
      return paramIntent.getBinder();
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
      if (this.app == null)
      {
        a("-->app is null");
        return;
      }
      a("-->app is not qqappinterface");
      return;
    }
    catch (Throwable localThrowable)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate error! ");
      localStringBuilder.append(QLog.getStackTraceString(localThrowable));
      QLog.e("Q.emoji.web.MessengerService", 1, localStringBuilder.toString());
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCreate OutOfMemoryError ");
      localStringBuilder.append(localOutOfMemoryError);
      QLog.e("MessengerService", 1, localStringBuilder.toString());
    }
  }
  
  public void onDestroy()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService$IncomingHandler != null)
    {
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        localObject1 = (QQAppInterface)this.app;
        localObject1 = (IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "");
        if (localObject1 != null) {
          ((IVasQuickUpdateService)localObject1).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService$IncomingHandler.a);
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
      localObject1 = (QQAppInterface)this.app;
      Object localObject2 = (IEmojiManagerService)((QQAppInterface)localObject1).getRuntimeService(IEmojiManagerService.class);
      if (localObject2 != null) {
        ((IEmojiManagerService)localObject2).getEmojiListenerManager().removeEmoticonPackageDownloadListener(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver;
      if (localObject2 != null)
      {
        ((QWalletAuthObserver)localObject2).a();
        ((QQAppInterface)localObject1).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver);
        this.jdField_a_of_type_ComTencentMobileqqAppQWalletAuthObserver = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmWebMessengerService$QWalletMsgHandler = null;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppCardObserver;
      if (localObject2 != null)
      {
        ((QQAppInterface)localObject1).removeObserver((BusinessObserver)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqAppCardObserver = null;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver;
      if (localObject2 != null)
      {
        ((QQAppInterface)localObject1).removeObserver((BusinessObserver)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqProfilecardObserverProfileCardObserver = null;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFunCallObserver;
      if (localObject2 != null)
      {
        ((QQAppInterface)localObject1).removeObserver((BusinessObserver)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqVasVipavVipFunCallObserver = null;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver;
      if (localObject2 != null)
      {
        ((QQAppInterface)localObject1).removeObserver((BusinessObserver)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqTeamworkTeamWorkFileImportObserver = null;
      }
      ((QQAppInterface)this.app).removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialCareHandler);
      this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareVipSpecialCareHandler.a();
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver;
      if (localObject2 != null)
      {
        ((QQAppInterface)localObject1).removeObserver((BusinessObserver)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener != null)
      {
        localObject1 = (StatusManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.STATUS_MANAGER);
        if (localObject1 != null)
        {
          ((StatusManager)localObject1).b(this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener);
          this.jdField_a_of_type_ComTencentMobileqqRichstatusIStatusListener = null;
        }
      }
      localObject1 = this.jdField_a_of_type_AndroidOsHandler;
      if (localObject1 != null)
      {
        ((Handler)localObject1).removeCallbacksAndMessages(null);
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
    ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).onGameCrashed();
    return super.onUnbind(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */