package com.tencent.mobileqq.qqexpand.ipc;

import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.qqexpand.bean.common.GenericSerializable;
import com.tencent.mobileqq.qqexpand.bean.profile.ExpandForbiddenInfo;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;
import com.tencent.mobileqq.qqexpand.config.banner.ExpandBannerConfBean;
import com.tencent.mobileqq.qqexpand.config.banner.ExpandBannerProcessor;
import com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandChatRepository;
import com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExpandSecurityInfo;
import com.tencent.mobileqq.qqexpand.flutter.channel.chat.ExtendFriendInfo;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.mobileqq.qqexpand.manager.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.network.IExpandHandler;
import com.tencent.mobileqq.qqexpand.network.impl.ExpandHandlerImpl;
import com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLauncher;
import com.tencent.mobileqq.qqexpand.utils.CampusHelper;
import com.tencent.mobileqq.qqexpand.utils.ExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.ExpandSharePreUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandForbiddenUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ConfigUtil;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCServer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class ExpandFlutterIPCServer
  extends QIPCModule
{
  private static volatile ExpandFlutterIPCServer b;
  final IpcDispatchCenter a = new IpcDispatchCenter(this, new ExpandFlutterIPCServer.2(this));
  private final ExpandObserver c = new ExpandFlutterIPCServer.1(this);
  private String d = "";
  
  private ExpandFlutterIPCServer()
  {
    super("ExpandFlutterIPCServer");
    k();
    l();
    AppRuntime localAppRuntime = c();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)localAppRuntime).addObserver(this.c);
    }
  }
  
  private Bundle a(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    if (paramBundle == null)
    {
      QLog.w("expand.ipc.ExpandFlutterIPCServer", 1, "handleMessage params is null METHOD_CHAT_REMOVE_CONVERSATION");
      return localBundle;
    }
    paramBundle = paramBundle.getStringArrayList("uinList");
    if (paramBundle == null)
    {
      QLog.w("expand.ipc.ExpandFlutterIPCServer", 1, "handleMessage params uinList is null METHOD_CHAT_REMOVE_CONVERSATION");
      return localBundle;
    }
    ((ExpandManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).o().b(paramBundle);
    return localBundle;
  }
  
  private Bundle a(Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null)
    {
      QLog.w("expand.ipc.ExpandFlutterIPCServer", 1, "handleMessage params is null METHOD_CHAT_GET_CONVERSATION_LIST");
      return new Bundle();
    }
    ExpandManager localExpandManager = (ExpandManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    String str = paramBundle.getString("cursor");
    int i = paramBundle.getInt("count");
    localExpandManager.o().a(str, i, new ExpandFlutterIPCServer.6(this, paramInt));
    return null;
  }
  
  public static ExpandFlutterIPCServer a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new ExpandFlutterIPCServer();
        }
      }
      finally {}
    }
    return b;
  }
  
  private EIPCResult a(AppInterface paramAppInterface)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("redPointNum", MatchChatMsgUtil.b((QQAppInterface)paramAppInterface));
    return EIPCResult.createSuccessResult(localBundle);
  }
  
  private EIPCResult a(AppInterface paramAppInterface, Bundle paramBundle)
  {
    String str = paramBundle.getString("match_uin");
    int i = paramBundle.getInt("match_type");
    int j = paramBundle.getInt("from_page");
    int k = paramBundle.getInt("accost_type");
    int m = paramBundle.getInt("is_passive");
    int n = paramBundle.getInt("choose_condition");
    int i1 = paramBundle.getInt("dating_purpose");
    int i2 = paramBundle.getInt("matchRelationSource");
    paramBundle = paramBundle.getByteArray("sig");
    Bundle localBundle = new Bundle();
    if (j == 6)
    {
      LimitChatUtil.a((QQAppInterface)paramAppInterface, str, k, i1);
      return EIPCResult.createSuccessResult(localBundle);
    }
    ((ExtendFriendLimitChatManager)paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a(str, paramAppInterface.getCurrentAccountUin(), paramBundle);
    LimitChatUtil.a((QQAppInterface)paramAppInterface, str, j, i, m, k, n, i1, i2);
    return EIPCResult.createSuccessResult(localBundle);
  }
  
  private EIPCResult a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = ((ExtendFriendLimitChatManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a(paramQQAppInterface);
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("sp_match_switch_type", bool);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCall ACTION_GET_MATCH_SWITCH ,open = ");
      localStringBuilder.append(bool);
      QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, localStringBuilder.toString());
    }
    return EIPCResult.createSuccessResult(paramQQAppInterface);
  }
  
  private void a(AppInterface paramAppInterface, String paramString, byte[] paramArrayOfByte)
  {
    ExtendFriendLimitChatManager localExtendFriendLimitChatManager = (ExtendFriendLimitChatManager)paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
    if (localExtendFriendLimitChatManager == null)
    {
      QLog.w("expand.ipc.ExpandFlutterIPCServer", 1, "limitChatManager is null ");
      return;
    }
    LimitChatUtil.b((QQAppInterface)paramAppInterface, Long.valueOf(Long.parseLong(paramString)), new ExpandFlutterIPCServer.5(this, paramAppInterface, paramString));
    localExtendFriendLimitChatManager.a(paramString, paramAppInterface.getCurrentAccountUin(), paramArrayOfByte);
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    LimitChatUtil.a(paramQQAppInterface, Long.valueOf(paramQQAppInterface.getLongAccountUin()), new ExpandFlutterIPCServer.3(this, paramInt));
  }
  
  private void a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("data");
    if (TextUtils.isEmpty(paramBundle))
    {
      QLog.e("expand.ipc.ExpandFlutterIPCServer", 1, "openSchema error, schema is null!");
      return;
    }
    paramQQAppInterface = JumpParser.a(paramQQAppInterface, BaseApplication.getContext(), paramBundle);
    if (paramQQAppInterface == null)
    {
      QLog.e("expand.ipc.ExpandFlutterIPCServer", 1, new Object[] { "openSchema error, action is null! schema = ", paramBundle });
      return;
    }
    paramQQAppInterface.a();
  }
  
  private Bundle b(int paramInt)
  {
    Object localObject2 = ((FriendsManager)ExpandManager.b().getManager(QQManagerFactory.FRIENDS_MANAGER)).g(ExpandManager.b().getCurrentAccountUin());
    Object localObject1 = new ExtendFriendInfo();
    ((ExtendFriendInfo)localObject1).nickName = ((Card)localObject2).strNick;
    ((ExtendFriendInfo)localObject1).declaration = ((Card)localObject2).declaration;
    ((ExtendFriendInfo)localObject1).voiceUrl = ((Card)localObject2).voiceUrl;
    localObject2 = new Bundle();
    IExpandHandler localIExpandHandler = (IExpandHandler)ExpandManager.b().getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localIExpandHandler != null) {
      ((Bundle)localObject2).putInt("seqNum", localIExpandHandler.a(ExpandManager.b().getCurrentAccountUin(), false));
    }
    ((Bundle)localObject2).putString("data", new Gson().toJson(localObject1));
    localObject1 = new EIPCResult();
    ((EIPCResult)localObject1).data = ((Bundle)localObject2);
    callbackResult(paramInt, (EIPCResult)localObject1);
    return null;
  }
  
  private Bundle b(Bundle paramBundle)
  {
    Bundle localBundle1 = new Bundle();
    if (paramBundle == null)
    {
      QLog.w("expand.ipc.ExpandFlutterIPCServer", 1, "handleMessage params is null METHOD_SET_BIRTH_DATE");
      return null;
    }
    int i = paramBundle.getInt("birthdate");
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramBundle instanceof QQAppInterface))
    {
      paramBundle = (CardHandler)((QQAppInterface)paramBundle).getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      if ((paramBundle != null) && (i != 0))
      {
        Bundle localBundle2 = new Bundle();
        localBundle2.putInt("birthday", i);
        paramBundle.a(localBundle2);
      }
    }
    return localBundle1;
  }
  
  private Bundle b(Bundle paramBundle, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new ExpandFlutterIPCServer.7(this, paramBundle, paramInt));
    return null;
  }
  
  private EIPCResult b(AppInterface paramAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("match_uin");
    if (!TextUtils.isEmpty(paramBundle)) {
      LimitChatUtil.b((QQAppInterface)paramAppInterface, Long.valueOf(Long.parseLong(paramBundle)), new ExpandFlutterIPCServer.4(this, paramAppInterface, paramBundle));
    }
    return EIPCResult.createSuccessResult(new Bundle());
  }
  
  private EIPCResult b(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramQQAppInterface = paramBundle.getString("event");
    paramBundle = (GenericSerializable)paramBundle.getSerializable("params");
    if (paramBundle != null) {
      ExpandReportUtils.a(paramQQAppInterface, true, (Map)paramBundle.get());
    }
    return EIPCResult.createSuccessResult(new Bundle());
  }
  
  @NotNull
  public static String b()
  {
    if (((ExpandManager)c().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).F()) {
      return "com.tencent.mobileqq:plugins";
    }
    return "com.tencent.mobileqq:tool";
  }
  
  private Bundle c(int paramInt)
  {
    Object localObject2 = ((IExpandForbiddenUtils)QRoute.api(IExpandForbiddenUtils.class)).getForbiddenInfo();
    Object localObject1 = new ExpandSecurityInfo();
    ((ExpandSecurityInfo)localObject1).a = ((ExpandForbiddenInfo)localObject2);
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("data", new Gson().toJson(localObject1));
    localObject1 = new EIPCResult();
    ((EIPCResult)localObject1).data = ((Bundle)localObject2);
    callbackResult(paramInt, (EIPCResult)localObject1);
    return null;
  }
  
  private Bundle c(Bundle paramBundle, int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface))
    {
      localObject = (QQAppInterface)localObject;
      boolean bool = paramBundle.getBoolean("isChecked");
      ((QQAppInterface)localObject).addObserver(new ExpandFlutterIPCServer.26(this, (QQAppInterface)localObject, paramInt));
      ((ExpandHandlerImpl)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER)).b(((QQAppInterface)localObject).getCurrentUin(), bool);
    }
    return null;
  }
  
  private EIPCResult c(AppInterface paramAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("matchInfoMap");
    if (((ExtendFriendLimitChatManager)paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER) != null) && (!TextUtils.isEmpty(paramBundle))) {
      try
      {
        paramBundle = new JsonParser().parse(paramBundle).getAsJsonArray();
        int j = paramBundle.size();
        int i = 0;
        while (i < j)
        {
          a(paramAppInterface, paramBundle.get(i).getAsJsonObject().getAsJsonPrimitive("uin").getAsString(), paramBundle.get(i).getAsJsonObject().getAsJsonPrimitive("sig").getAsString().getBytes(StandardCharsets.ISO_8859_1));
          i += 1;
        }
        return EIPCResult.createSuccessResult(new Bundle());
      }
      catch (Exception paramAppInterface)
      {
        QLog.e("expand.ipc.ExpandFlutterIPCServer", 2, paramAppInterface, new Object[] { "batchCreateMessageNode error!" });
      }
    }
    return EIPCResult.createSuccessResult(new Bundle());
  }
  
  private EIPCResult c(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("plan");
    ((ExpandManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).b(paramBundle);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("onCall ACTION_SET_TAB_TEST_PLAN ,plan = ");
      paramQQAppInterface.append(paramBundle);
      QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, paramQQAppInterface.toString());
    }
    return EIPCResult.createSuccessResult(new Bundle());
  }
  
  private static AppRuntime c()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
  
  private Bundle d(int paramInt)
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface))
    {
      localObject1 = (QQAppInterface)localObject1;
      boolean bool = ((ExtendFriendLimitChatManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a((BaseQQAppInterface)localObject1);
      Object localObject2 = new Bundle();
      ((Bundle)localObject2).putBoolean("data", bool);
      localObject1 = new EIPCResult();
      ((EIPCResult)localObject1).data = ((Bundle)localObject2);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleGetQuietMode open:");
        ((StringBuilder)localObject2).append(bool);
        ((StringBuilder)localObject2).append(", result: ");
        ((StringBuilder)localObject2).append(localObject1);
        QLog.i("expand.ipc.ExpandFlutterIPCServer", 2, ((StringBuilder)localObject2).toString());
      }
      callbackResult(paramInt, (EIPCResult)localObject1);
    }
    return null;
  }
  
  private EIPCResult d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("expand.ipc.ExpandFlutterIPCServer", 2, "clearRedPoint() not implemented");
    }
    return EIPCResult.createSuccessResult(new Bundle());
  }
  
  private Bundle e()
  {
    String str = ((ExpandManager)c().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).g();
    if (QLog.isColorLevel()) {
      QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, String.format("getUnzipValidResourcePath=%s", new Object[] { str }));
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ret", str);
    return localBundle;
  }
  
  private Bundle f()
  {
    String str = ConfigUtil.a(BaseApplicationImpl.getApplication(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), "extend_friend_config_785");
    Bundle localBundle = new Bundle();
    localBundle.putString("ret", str);
    return localBundle;
  }
  
  private Bundle g()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("birthdate", ((FriendsManager)ExpandManager.b().getManager(QQManagerFactory.FRIENDS_MANAGER)).g(ExpandManager.b().getCurrentAccountUin()).lBirthday);
    return localBundle;
  }
  
  private Bundle h()
  {
    Bundle localBundle = new Bundle();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      CampusHelper.b((QQAppInterface)localAppRuntime);
    }
    return localBundle;
  }
  
  private Bundle i()
  {
    Bundle localBundle = new Bundle();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    boolean bool;
    if ((localAppRuntime instanceof QQAppInterface)) {
      bool = CampusHelper.a((QQAppInterface)localAppRuntime);
    } else {
      bool = false;
    }
    localBundle.putBoolean("showflag", bool);
    return localBundle;
  }
  
  private Bundle j()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("ret", "{}");
    ArrayList localArrayList = ExpandBannerProcessor.a().a();
    if (localArrayList != null)
    {
      if (localArrayList.size() == 0) {
        return localBundle;
      }
      localBundle.putString("ret", new Gson().toJson(localArrayList));
    }
    return localBundle;
  }
  
  private void k()
  {
    this.a.a("METHOD_GET_FLUTTER_RESOURCE_PATH", new ExpandFlutterIPCServer.8(this));
    this.a.a("METHOD_GET_EXPAND_CONFIG", new ExpandFlutterIPCServer.9(this));
    this.a.a("METHOD_CHAT_GET_CONVERSATION_LIST", new ExpandFlutterIPCServer.10(this));
    this.a.a("METHOD_CHAT_REMOVE_CONVERSATION", new ExpandFlutterIPCServer.11(this));
    this.a.a("METHOD_REFRESH_EXTEND_FRIEND_INFO", new ExpandFlutterIPCServer.12(this));
    this.a.a("METHOD_GET_BIRTH_DATE", new ExpandFlutterIPCServer.13(this));
    this.a.a("METHOD_SET_BIRTH_DATE", new ExpandFlutterIPCServer.14(this));
    this.a.a("METHOD_SET_BIRTH_DIALOG_FLAG", new ExpandFlutterIPCServer.15(this));
    this.a.a("METHOD_GET_BIRTH_DIALOG_FLAG", new ExpandFlutterIPCServer.16(this));
    this.a.a("METHOD_GET_SYS_EMOJI_FILE_PATH", new ExpandFlutterIPCServer.17(this));
    this.a.a("METHOD_GET_EXPAND_FRIEND_BANNER_CONFIG_LIST", new ExpandFlutterIPCServer.18(this));
    this.a.a("METHOD_GET_SECURITY_INFO", new ExpandFlutterIPCServer.19(this));
    this.a.a("METHOD_GET_ABTEST_INFO", new ExpandFlutterIPCServer.20(this));
    this.a.a("METHOD_SET_QUIET_MODE", new ExpandFlutterIPCServer.21(this));
    this.a.a("METHOD_GET_QUIET_MODE", new ExpandFlutterIPCServer.22(this));
    this.a.a("METHOD_CLEAR_ALL_MSGS", new ExpandFlutterIPCServer.23(this));
    this.a.a("getNetworkStatus", new ExpandFlutterIPCServer.24(this));
  }
  
  private void l()
  {
    if ((BaseApplication.getContext() != null) && (BaseApplication.getContext().getContentResolver() != null))
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
      localIntentFilter.addAction("mqq.intent.action.FORCE_LOGOUT");
      localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
      localIntentFilter.addAction("mqq.intent.action.LOGOUT");
      MobileQQ.sMobileQQ.registerReceiver(new ExpandFlutterIPCServer.25(this), localIntentFilter);
    }
  }
  
  private Bundle m()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (TextUtils.isEmpty(this.d))) {
      this.d = ExpandSharePreUtils.c((String)localObject);
    }
    localObject = new Bundle();
    ((Bundle)localObject).putString("data", this.d);
    return localObject;
  }
  
  private Bundle n()
  {
    ThreadManagerV2.excute(new ExpandFlutterIPCServer.27(this), 80, null, true);
    Bundle localBundle = new Bundle();
    localBundle.putString("data", "");
    return localBundle;
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("redPointNum", paramInt);
    QIPCServerHelper.getInstance().getServer().callClient(b(), 1, "ExpandFlutterIPCClient", "notifyRedPointEvent", localBundle, null);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("data", paramArrayOfByte);
    localBundle.putLong("pushType", paramLong);
    QIPCServerHelper.getInstance().getServer().callClient(b(), 1, "ExpandFlutterIPCClient", "notifyPushEvent", localBundle);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onCall, params=");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append(", action=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", callBackId=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = c();
    if (!(localObject instanceof QQAppInterface)) {
      return null;
    }
    localObject = (QQAppInterface)localObject;
    if ("notifySetTABTestPlan".equals(paramString))
    {
      paramString = c((QQAppInterface)localObject, paramBundle);
      callbackResult(paramInt, paramString);
      return paramString;
    }
    if ("notifyGetMatchSwitch".equals(paramString))
    {
      paramString = a((QQAppInterface)localObject);
      callbackResult(paramInt, paramString);
      return paramString;
    }
    if ("notifyDoReport".equals(paramString))
    {
      paramString = b((QQAppInterface)localObject, paramBundle);
      callbackResult(paramInt, paramString);
      return paramString;
    }
    if ("notifyOpenAio".equals(paramString))
    {
      paramString = a((AppInterface)localObject, paramBundle);
      callbackResult(paramInt, paramString);
      return paramString;
    }
    if ("getRedPoint".equals(paramString))
    {
      paramString = a((AppInterface)localObject);
      callbackResult(paramInt, paramString);
      return paramString;
    }
    if ("clearRedPoint".equals(paramString))
    {
      paramString = d();
      callbackResult(paramInt, paramString);
      return paramString;
    }
    if ("closeLoading".equals(paramString))
    {
      ExpandPluginLauncher.d().a(paramBundle);
    }
    else if ("preloadServiceStarted".equals(paramString))
    {
      int i = paramBundle.getInt("pluginPid", 0);
      ExpandPluginLauncher.d().a(i);
    }
    else if ("METHOD_CREATE_MESSAGE_NODE_IF_NEED".equals(paramString))
    {
      b((AppInterface)localObject, paramBundle);
    }
    else if ("notifyBatchCreateMessageNodeIfNeed".equals(paramString))
    {
      c((AppInterface)localObject, paramBundle);
    }
    else if ("getExpandUserInfo".equals(paramString))
    {
      a((QQAppInterface)localObject, paramInt);
    }
    else if ("notifyOpenSchema".equals(paramString))
    {
      a((QQAppInterface)localObject, paramBundle);
      return null;
    }
    try
    {
      paramString = this.a.a(paramString, paramBundle, paramInt);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("Exception happens");
      paramBundle.append(paramString.getMessage());
      QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, paramBundle.toString());
      callbackResult(paramInt, null);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCServer
 * JD-Core Version:    0.7.0.1
 */