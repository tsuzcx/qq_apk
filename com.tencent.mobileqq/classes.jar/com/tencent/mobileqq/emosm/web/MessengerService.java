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
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.AppService;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class MessengerService
  extends AppService
  implements IPCConstants
{
  Messenger b = null;
  Messenger c;
  public EmoticonPackageDownloadListener d = new MessengerService.1(this);
  public EmojiStickerManager.StickerRecallListener e = new MessengerService.2(this);
  TeamWorkFileImportObserver f = new MessengerService.3(this);
  VipFunCallObserver g = new MessengerService.4(this);
  IPCDownloadListener h = new MessengerService.5(this);
  MessengerService.QWalletMsgHandler i = new MessengerService.QWalletMsgHandler(this);
  QWalletAuthObserver j = new QWalletAuthObserver(this.i);
  public List<Bundle> k = Collections.synchronizedList(new ArrayList());
  Bundle l = null;
  CardObserver m = new MessengerService.6(this);
  ProfileCardObserver n = new MessengerService.7(this);
  VipSpecialCareHandler o = new MessengerService.8(this);
  Bundle p = null;
  Bundle q = null;
  Handler r = new Handler(Looper.getMainLooper());
  IStatusListener s = new MessengerService.9(this);
  FriendListObserver t = new MessengerService.10(this);
  QidianBusinessObserver u = new MessengerService.11(this);
  Bundle v = null;
  private HandlerThread w;
  private MessengerService.IncomingHandler x;
  
  public static Bundle a(QQAppInterface paramQQAppInterface)
  {
    String str1 = "";
    paramQQAppInterface = (IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    Bundle localBundle = new Bundle();
    localBundle.putInt("result", 0);
    localBundle.putInt("cnt", paramQQAppInterface.getUnreadCnt4MsgTab());
    try
    {
      JSONObject localJSONObject = new JSONObject();
      HashMap localHashMap = paramQQAppInterface.getUnreadForEachGame();
      paramQQAppInterface = str1;
      if (localHashMap != null)
      {
        paramQQAppInterface = localHashMap.keySet().iterator();
        while (paramQQAppInterface.hasNext())
        {
          String str2 = (String)paramQQAppInterface.next();
          localJSONObject.put(str2, localHashMap.get(str2));
        }
        paramQQAppInterface = localJSONObject.toString();
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      QLog.e("Q.emoji.web.MessengerService", 1, paramQQAppInterface, new Object[0]);
      paramQQAppInterface = str1;
    }
    if (!TextUtils.isEmpty(paramQQAppInterface)) {
      localBundle.putString("singleUnread", paramQQAppInterface);
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("[handleMessage] cmd:ipc_cmd_gamecenter_get_unread_total,data:");
      paramQQAppInterface.append(localBundle);
      QLog.i("Q.emoji.web.MessengerService", 2, paramQQAppInterface.toString());
    }
    return localBundle;
  }
  
  public static Bundle a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    Bundle localBundle = new Bundle();
    try
    {
      Object localObject = ((IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "")).getSessionInfoList(paramInt, paramString);
      paramString = new JSONArray();
      paramQQAppInterface = new JSONObject();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          JSONObject localJSONObject = ((GameCenterSessionInfo)((Iterator)localObject).next()).p();
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
        paramString.append("[handleMessage] cmd:ipc_cmd_gamecenter_get_session_info,data:");
        paramString.append(paramQQAppInterface.toString());
        QLog.i("Q.emoji.web.MessengerService", 2, paramString.toString());
        return localBundle;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      localBundle.putInt("result", -1);
      paramString = new StringBuilder();
      paramString.append("getGameCenterSessionInfo e:");
      paramString.append(paramQQAppInterface);
      QLog.e("Q.emoji.web.MessengerService", 1, paramString.toString());
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
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(paramQQAppInterface, paramString, localGameCenterSessionInfo.e(), localGameCenterSessionInfo.b(), 1);
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
      int i1 = Build.VERSION.SDK_INT;
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
          JSONObject localJSONObject = ((GameCenterSessionInfo)((Iterator)localObject).next()).p();
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
    if (this.b != null) {
      try
      {
        Message localMessage = Message.obtain(null, 4);
        localMessage.setData(paramBundle);
        this.b.send(localMessage);
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
    paramIntent = this.c;
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
      this.w = ThreadManager.newFreeHandlerThread("Vas_MessengerServiceWorkerThread", -2);
      this.w.start();
      this.x = new MessengerService.IncomingHandler(this.w.getLooper(), this);
      this.c = new Messenger(this.x);
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        ((QQAppInterface)this.app).addObserver(this.o);
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
    if (this.x != null)
    {
      if ((this.app != null) && ((this.app instanceof QQAppInterface)))
      {
        localObject1 = (QQAppInterface)this.app;
        localObject1 = (IVasQuickUpdateService)this.app.getRuntimeService(IVasQuickUpdateService.class, "");
        if (localObject1 != null) {
          ((IVasQuickUpdateService)localObject1).removeCallBacker(this.x.a);
        }
      }
      this.x.getLooper().quit();
      this.x = null;
    }
    if (this.w != null) {
      this.w = null;
    }
    this.b = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.web.MessengerService", 2, "MessengerService destroied");
    }
    if ((this.app != null) && ((this.app instanceof QQAppInterface)))
    {
      localObject1 = (QQAppInterface)this.app;
      Object localObject2 = (IEmojiManagerService)((QQAppInterface)localObject1).getRuntimeService(IEmojiManagerService.class);
      if (localObject2 != null) {
        ((IEmojiManagerService)localObject2).getEmojiListenerManager().removeEmoticonPackageDownloadListener(this.d);
      }
      localObject2 = this.j;
      if (localObject2 != null)
      {
        ((QWalletAuthObserver)localObject2).a();
        ((QQAppInterface)localObject1).removeObserver(this.j);
        this.j = null;
      }
      this.i = null;
      localObject2 = this.m;
      if (localObject2 != null)
      {
        ((QQAppInterface)localObject1).removeObserver((BusinessObserver)localObject2);
        this.m = null;
      }
      localObject2 = this.n;
      if (localObject2 != null)
      {
        ((QQAppInterface)localObject1).removeObserver((BusinessObserver)localObject2);
        this.n = null;
      }
      localObject2 = this.g;
      if (localObject2 != null)
      {
        ((QQAppInterface)localObject1).removeObserver((BusinessObserver)localObject2);
        this.g = null;
      }
      localObject2 = this.f;
      if (localObject2 != null)
      {
        ((QQAppInterface)localObject1).removeObserver((BusinessObserver)localObject2);
        this.f = null;
      }
      ((QQAppInterface)this.app).removeObserver(this.o);
      this.o.a();
      localObject2 = this.t;
      if (localObject2 != null)
      {
        ((QQAppInterface)localObject1).removeObserver((BusinessObserver)localObject2);
        this.t = null;
      }
      if (this.s != null)
      {
        localObject1 = (StatusManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.STATUS_MANAGER);
        if (localObject1 != null)
        {
          ((StatusManager)localObject1).b(this.s);
          this.s = null;
        }
      }
      localObject1 = this.r;
      if (localObject1 != null)
      {
        ((Handler)localObject1).removeCallbacksAndMessages(null);
        this.r = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService
 * JD-Core Version:    0.7.0.1
 */