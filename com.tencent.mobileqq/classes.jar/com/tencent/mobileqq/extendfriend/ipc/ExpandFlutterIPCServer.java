package com.tencent.mobileqq.extendfriend.ipc;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.tencent.biz.expand.api.GenericSerializable;
import com.tencent.biz.expand.ui.ExpandPluginLauncher;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.business.extendfriend.ExtendFriendBannerConfBean;
import com.tencent.mobileqq.config.business.extendfriend.ExtendFriendBannerProcessor;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.limitchat.ExtendFriendLimitChatManager;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendHandler;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.CampusHelper;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.extendfriend.utils.ExpandSharePreUtils;
import com.tencent.mobileqq.flutter.channel.expand.chat.ExpandChatRepository;
import com.tencent.mobileqq.flutter.channel.expand.chat.ExpandForbiddenInfo;
import com.tencent.mobileqq.flutter.channel.expand.chat.ExpandSecurityInfo;
import com.tencent.mobileqq.flutter.channel.expand.chat.ExtendFriendInfo;
import com.tencent.mobileqq.limitchat.LimitChatUtil;
import com.tencent.mobileqq.matchchat.MatchChatMsgUtil;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.utils.ConfigUtil;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCServer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;

public class ExpandFlutterIPCServer
  extends QIPCModule
{
  private static volatile ExpandFlutterIPCServer jdField_a_of_type_ComTencentMobileqqExtendfriendIpcExpandFlutterIPCServer;
  final IpcDispatchCenter jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter = new IpcDispatchCenter(this, new ExpandFlutterIPCServer.2(this));
  private ExtendFriendObserver jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver = new ExpandFlutterIPCServer.1(this);
  private String jdField_a_of_type_JavaLangString = "";
  
  private ExpandFlutterIPCServer()
  {
    super("ExpandFlutterIPCServer");
    a();
    AppRuntime localAppRuntime = a();
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)localAppRuntime).addObserver(this.jdField_a_of_type_ComTencentMobileqqExtendfriendNetworkExtendFriendObserver);
    }
  }
  
  private Bundle a()
  {
    String str = ((ExtendFriendManager)a().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).b();
    if (QLog.isColorLevel()) {
      QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, String.format("getUnzipValidResourcePath=%s", new Object[] { str }));
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("ret", str);
    return localBundle;
  }
  
  private Bundle a(int paramInt)
  {
    Object localObject2 = ((FriendsManager)ExtendFriendManager.a().getManager(QQManagerFactory.FRIENDS_MANAGER)).b(ExtendFriendManager.a().getCurrentAccountUin());
    Object localObject1 = new ExtendFriendInfo();
    ((ExtendFriendInfo)localObject1).nickName = ((Card)localObject2).strNick;
    ((ExtendFriendInfo)localObject1).declaration = ((Card)localObject2).declaration;
    ((ExtendFriendInfo)localObject1).voiceUrl = ((Card)localObject2).voiceUrl;
    localObject2 = new Bundle();
    ExtendFriendHandler localExtendFriendHandler = (ExtendFriendHandler)ExtendFriendManager.a().getBusinessHandler(BusinessHandlerFactory.EXTEND_FRIEND_HANDLER);
    if (localExtendFriendHandler != null) {
      ((Bundle)localObject2).putInt("seqNum", localExtendFriendHandler.a(ExtendFriendManager.a().getCurrentAccountUin(), false));
    }
    ((Bundle)localObject2).putString("data", new Gson().toJson(localObject1));
    localObject1 = new EIPCResult();
    ((EIPCResult)localObject1).data = ((Bundle)localObject2);
    callbackResult(paramInt, (EIPCResult)localObject1);
    return null;
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
    ((ExtendFriendManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a().a(paramBundle);
    return localBundle;
  }
  
  private Bundle a(Bundle paramBundle, int paramInt)
  {
    if (paramBundle == null)
    {
      QLog.w("expand.ipc.ExpandFlutterIPCServer", 1, "handleMessage params is null METHOD_CHAT_GET_CONVERSATION_LIST");
      return new Bundle();
    }
    ExtendFriendManager localExtendFriendManager = (ExtendFriendManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    String str = paramBundle.getString("cursor");
    int i = paramBundle.getInt("count");
    localExtendFriendManager.a().a(str, i, new ExpandFlutterIPCServer.5(this, paramInt));
    return null;
  }
  
  public static ExpandFlutterIPCServer a()
  {
    if (jdField_a_of_type_ComTencentMobileqqExtendfriendIpcExpandFlutterIPCServer == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqExtendfriendIpcExpandFlutterIPCServer == null) {
        jdField_a_of_type_ComTencentMobileqqExtendfriendIpcExpandFlutterIPCServer = new ExpandFlutterIPCServer();
      }
      return jdField_a_of_type_ComTencentMobileqqExtendfriendIpcExpandFlutterIPCServer;
    }
    finally {}
  }
  
  private EIPCResult a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("expand.ipc.ExpandFlutterIPCServer", 2, "clearRedPoint() not implemented");
    }
    return EIPCResult.createSuccessResult(new Bundle());
  }
  
  private EIPCResult a(AppInterface paramAppInterface)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("redPointNum", MatchChatMsgUtil.a((QQAppInterface)paramAppInterface));
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
    paramBundle = paramBundle.getByteArray("sig");
    Bundle localBundle = new Bundle();
    if (j == 6)
    {
      LimitChatUtil.a((QQAppInterface)paramAppInterface, str, k);
      return EIPCResult.createSuccessResult(localBundle);
    }
    ((ExtendFriendLimitChatManager)paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER)).a(str, paramAppInterface.getCurrentAccountUin(), paramBundle);
    LimitChatUtil.a((QQAppInterface)paramAppInterface, str, j, i, m, k, n, i1);
    return EIPCResult.createSuccessResult(localBundle);
  }
  
  private EIPCResult a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = ExtendFriendLimitChatManager.a(paramQQAppInterface).booleanValue();
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putBoolean("sp_match_switch_type", bool);
    if (QLog.isColorLevel()) {
      QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, "onCall ACTION_GET_MATCH_SWITCH ,open = " + bool);
    }
    return EIPCResult.createSuccessResult(paramQQAppInterface);
  }
  
  private EIPCResult a(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramQQAppInterface = paramBundle.getString("event");
    paramBundle = (GenericSerializable)paramBundle.getSerializable("params");
    if (paramBundle != null) {
      ExpandReportUtils.a(paramQQAppInterface, true, (Map)paramBundle.get());
    }
    return EIPCResult.createSuccessResult(new Bundle());
  }
  
  @NotNull
  public static String a()
  {
    if (((ExtendFriendManager)a().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).g()) {
      return "com.tencent.mobileqq:plugins";
    }
    return "com.tencent.mobileqq:tool";
  }
  
  private static AppRuntime a()
  {
    return BaseApplicationImpl.getApplication().getRuntime();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter.a("METHOD_GET_FLUTTER_RESOURCE_PATH", new ExpandFlutterIPCServer.7(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter.a("METHOD_GET_EXPAND_CONFIG", new ExpandFlutterIPCServer.8(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter.a("METHOD_CHAT_GET_CONVERSATION_LIST", new ExpandFlutterIPCServer.9(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter.a("METHOD_CHAT_REMOVE_CONVERSATION", new ExpandFlutterIPCServer.10(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter.a("METHOD_REFRESH_EXTEND_FRIEND_INFO", new ExpandFlutterIPCServer.11(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter.a("METHOD_GET_BIRTH_DATE", new ExpandFlutterIPCServer.12(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter.a("METHOD_SET_BIRTH_DATE", new ExpandFlutterIPCServer.13(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter.a("METHOD_SET_BIRTH_DIALOG_FLAG", new ExpandFlutterIPCServer.14(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter.a("METHOD_GET_BIRTH_DIALOG_FLAG", new ExpandFlutterIPCServer.15(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter.a("METHOD_GET_SYS_EMOJI_FILE_PATH", new ExpandFlutterIPCServer.16(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter.a("METHOD_GET_EXPAND_FRIEND_BANNER_CONFIG_LIST", new ExpandFlutterIPCServer.17(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter.a("METHOD_GET_SECURITY_INFO", new ExpandFlutterIPCServer.18(this));
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter.a("METHOD_GET_ABTEST_INFO", new ExpandFlutterIPCServer.19(this));
  }
  
  private void a(AppInterface paramAppInterface, String paramString, byte[] paramArrayOfByte)
  {
    ExtendFriendLimitChatManager localExtendFriendLimitChatManager = (ExtendFriendLimitChatManager)paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
    if (localExtendFriendLimitChatManager == null)
    {
      QLog.w("expand.ipc.ExpandFlutterIPCServer", 1, "limitChatManager is null ");
      return;
    }
    LimitChatUtil.a((QQAppInterface)paramAppInterface, Long.valueOf(Long.parseLong(paramString)), new ExpandFlutterIPCServer.4(this, paramAppInterface, paramString));
    localExtendFriendLimitChatManager.a(paramString, paramAppInterface.getCurrentAccountUin(), paramArrayOfByte);
  }
  
  private Bundle b()
  {
    String str = ConfigUtil.a(BaseApplicationImpl.getApplication(), BaseApplicationImpl.getApplication().getRuntime().getAccount(), "extend_friend_config_785");
    Bundle localBundle = new Bundle();
    localBundle.putString("ret", str);
    return localBundle;
  }
  
  private Bundle b(int paramInt)
  {
    Object localObject2 = (ExtendFriendManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    Object localObject1 = new ExpandSecurityInfo();
    ExpandForbiddenInfo localExpandForbiddenInfo = new ExpandForbiddenInfo();
    localExpandForbiddenInfo.isForbidden = ((ExtendFriendManager)localObject2).p();
    localExpandForbiddenInfo.forbiddenEndTime = ((ExtendFriendManager)localObject2).d();
    ((ExpandSecurityInfo)localObject1).forbiddenInfo = localExpandForbiddenInfo;
    localObject2 = new Bundle();
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
    ThreadManager.getSubThreadHandler().post(new ExpandFlutterIPCServer.6(this, paramBundle, paramInt));
    return null;
  }
  
  private EIPCResult b(AppInterface paramAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("match_uin");
    if (!TextUtils.isEmpty(paramBundle)) {
      LimitChatUtil.a((QQAppInterface)paramAppInterface, Long.valueOf(Long.parseLong(paramBundle)), new ExpandFlutterIPCServer.3(this, paramAppInterface, paramBundle));
    }
    return EIPCResult.createSuccessResult(new Bundle());
  }
  
  private EIPCResult b(QQAppInterface paramQQAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("plan");
    ((ExtendFriendManager)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, "onCall ACTION_SET_TAB_TEST_PLAN ,plan = " + paramBundle);
    }
    return EIPCResult.createSuccessResult(new Bundle());
  }
  
  private Bundle c()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("birthdate", ((FriendsManager)ExtendFriendManager.a().getManager(QQManagerFactory.FRIENDS_MANAGER)).b(ExtendFriendManager.a().getCurrentAccountUin()).lBirthday);
    return localBundle;
  }
  
  private EIPCResult c(AppInterface paramAppInterface, Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("matchInfoMap");
    if (((ExtendFriendLimitChatManager)paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER) == null) || (TextUtils.isEmpty(paramBundle))) {
      return EIPCResult.createSuccessResult(new Bundle());
    }
    try
    {
      paramBundle = new JsonParser().parse(paramBundle).getAsJsonArray();
      int j = paramBundle.size();
      int i = 0;
      while (i < j)
      {
        a(paramAppInterface, paramBundle.get(i).getAsJsonObject().getAsJsonPrimitive("uin").getAsString(), paramBundle.get(i).getAsJsonObject().getAsJsonPrimitive("sig").getAsString().getBytes(Charset.forName("ISO-8859-1")));
        i += 1;
      }
      return EIPCResult.createSuccessResult(new Bundle());
    }
    catch (Exception paramAppInterface)
    {
      QLog.e("expand.ipc.ExpandFlutterIPCServer", 2, paramAppInterface, new Object[] { "batchCreateMessageNode error!" });
    }
  }
  
  private Bundle d()
  {
    Bundle localBundle = new Bundle();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      CampusHelper.a((QQAppInterface)localAppRuntime);
    }
    return localBundle;
  }
  
  private Bundle e()
  {
    Bundle localBundle = new Bundle();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {}
    for (boolean bool = CampusHelper.a((QQAppInterface)localAppRuntime);; bool = false)
    {
      localBundle.putBoolean("showflag", bool);
      return localBundle;
    }
  }
  
  private Bundle f()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("ret", "{}");
    ArrayList localArrayList = ExtendFriendBannerProcessor.a().a();
    if ((localArrayList == null) || (localArrayList.size() == 0)) {
      return localBundle;
    }
    localBundle.putString("ret", new Gson().toJson(localArrayList));
    return localBundle;
  }
  
  private Bundle g()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = ExpandSharePreUtils.b(BaseApplicationImpl.getApplication().getRuntime().getAccount());
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("data", this.jdField_a_of_type_JavaLangString);
    return localBundle;
  }
  
  public void a(int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("redPointNum", paramInt);
    QIPCServerHelper.getInstance().getServer().callClient(a(), 1, "ExpandFlutterIPCClient", "notifyRedPointEvent", localBundle, null);
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("data", paramArrayOfByte);
    localBundle.putLong("pushType", paramLong);
    QIPCServerHelper.getInstance().getServer().callClient(a(), 1, "ExpandFlutterIPCClient", "notifyPushEvent", localBundle);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, "onCall, params=" + paramBundle + ", action=" + paramString + ", callBackId=" + paramInt);
    }
    Object localObject = a();
    if (!(localObject instanceof QQAppInterface)) {
      return null;
    }
    localObject = (QQAppInterface)localObject;
    if ("notifySetTABTestPlan".equals(paramString))
    {
      paramString = b((QQAppInterface)localObject, paramBundle);
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
      paramString = a((QQAppInterface)localObject, paramBundle);
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
      paramString = a();
      callbackResult(paramInt, paramString);
      return paramString;
    }
    if ("closeLoading".equals(paramString)) {
      ExpandPluginLauncher.a().a(paramBundle);
    }
    for (;;)
    {
      try
      {
        paramString = this.jdField_a_of_type_ComTencentMobileqqExtendfriendIpcIpcDispatchCenter.a(paramString, paramBundle, paramInt);
        return paramString;
      }
      catch (Exception paramString)
      {
        QLog.d("expand.ipc.ExpandFlutterIPCServer", 2, "Exception happens" + paramString.getMessage());
        callbackResult(paramInt, null);
      }
      if ("METHOD_CREATE_MESSAGE_NODE_IF_NEED".equals(paramString)) {
        b((AppInterface)localObject, paramBundle);
      } else if ("notifyBatchCreateMessageNodeIfNeed".equals(paramString)) {
        c((AppInterface)localObject, paramBundle);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCServer
 * JD-Core Version:    0.7.0.1
 */