package com.tencent.mobileqq.relation.api.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.AddRequestActivity;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ContactBindedActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactSecCheckWebPlugin;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgSuspiciousFragment;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.phone.BindNumberActivity;
import com.tencent.mobileqq.activity.phone.DenyRunnable;
import com.tencent.mobileqq.activity.phone.DenyRunnable.JumpSettingAction;
import com.tencent.mobileqq.activity.qcircle.widget.QCircleFollowView;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QIMNewFriendManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.config.QConfigLocalLoader;
import com.tencent.mobileqq.config.business.QConfLogBean;
import com.tencent.mobileqq.config.business.newfriend.SysSuspiciousConfBean;
import com.tencent.mobileqq.config.business.newfriend.SysSuspiciousConfProcessor;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MayKnowRecommend.MayKnowRecommendLabel;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.nearby.QQNearbyManager;
import com.tencent.mobileqq.newfriend.msg.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.profile.SchoolInfo;
import com.tencent.mobileqq.profilecard.api.IProfileCardApi;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingMng;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.systemmsg.SystemMsgUtils;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.CustomWidgetUtil;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qzone.QzonePluginProxyActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class AddFriendTempApiImpl
  implements IAddFriendTempApi
{
  private static final String TAG = "AddFriendTempApiImpl";
  
  public void addBatchQIMFriends(List<QIMNotifyAddFriend> paramList, AppInterface paramAppInterface)
  {
    ((FriendListHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).addBatchQIMFriends(paramList);
  }
  
  public void addFriendToFriendList(AppInterface paramAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    ((FriendListHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).addFriendToFriendList(paramString1, 0, 3999, "", true, false, -1L);
  }
  
  public void addListener(Object paramObject, AppInterface paramAppInterface)
  {
    ((StatusManager)paramAppInterface.getManager(QQManagerFactory.STATUS_MANAGER)).a(paramObject);
  }
  
  public void cancelMayKnowRecommend(String paramString, AppInterface paramAppInterface)
  {
    ((FriendListHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).cancelMayKnowRecommend(paramString);
  }
  
  public void changeStructMsgActions(structmsg.StructMsg paramStructMsg, int paramInt1, String paramString, int paramInt2)
  {
    SystemMsgUtils.a(paramStructMsg, paramInt1, paramString, paramInt2);
  }
  
  public boolean changeStructMsgActionsWhenFail(structmsg.StructMsg paramStructMsg, int paramInt, String paramString1, String paramString2)
  {
    return SystemMsgUtils.a(paramStructMsg, paramInt, paramString1, paramString2);
  }
  
  public void checkReadContactPermission(Runnable paramRunnable, Context paramContext, AppInterface paramAppInterface)
  {
    paramAppInterface = new DenyRunnable(paramContext, new DenyRunnable.JumpSettingAction((QQAppInterface)paramAppInterface));
    PermissionChecker.a((Activity)paramContext, paramRunnable, paramAppInterface);
  }
  
  public void checkUpdate(AppInterface paramAppInterface, String paramString)
  {
    AntiFraudConfigFileUtil.a().a((QQAppInterface)paramAppInterface, paramString);
  }
  
  public void clearAllSystemMsg(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      ((QQAppInterface)paramAppInterface).getMsgHandler().a().f();
    }
  }
  
  public void clickQIMSource(Context paramContext, MessageRecord paramMessageRecord, AppInterface paramAppInterface)
  {
    ((FlashChatManager)paramAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a(paramContext, null);
  }
  
  public Intent composeReturnIntent(Class<?> paramClass, String paramString, Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName("com.tencent.mobileqq", paramClass.getName()));
    if ((!paramClass.equals(((IProfileCardApi)QRoute.api(IProfileCardApi.class)).getProfileCardActivityClass())) && (!paramClass.equals(QidianProfileCardActivity.class)))
    {
      if (paramClass.equals(QQNearbyManager.b()))
      {
        localIntent.putExtra("AllInOne", new AllInOne(paramString, 41));
        localIntent.putExtra("param_mode", 3);
      }
    }
    else {
      ProfileActivity.a(paramActivity, paramString, localIntent);
    }
    localIntent.setFlags(67108864);
    localIntent.putExtra("key_back_from_add_friend", true);
    return localIntent;
  }
  
  public void deleteAllSuspiciousMsg(AppInterface paramAppInterface)
  {
    ((FriendListHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).deleteAllSuspiciousMsg();
  }
  
  public void deleteQIMNotifyAddFriendData(QIMNotifyAddFriend paramQIMNotifyAddFriend, AppInterface paramAppInterface)
  {
    ((QIMNewFriendManager)paramAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).b(paramQIMNotifyAddFriend);
  }
  
  public boolean enableCheckPermission()
  {
    return QConfigLocalLoader.a(BaseApplicationImpl.getApplication()).b();
  }
  
  public void followUser(String paramString, boolean paramBoolean)
  {
    QCircleFollowView.a(paramString, paramBoolean);
  }
  
  public Intent getAddRequestIntent(Context paramContext)
  {
    return new Intent(paramContext, AddRequestActivity.class);
  }
  
  public Intent getBindNumberIntent(Context paramContext)
  {
    return new Intent(paramContext, BindNumberActivity.class);
  }
  
  public Intent getChatActivityIntent(Context paramContext)
  {
    return new Intent(paramContext, ChatActivity.class);
  }
  
  public ArrayList<MayKnowRecommend> getConnectionsPersonLocal(int paramInt, AppInterface paramAppInterface)
  {
    return ((MayknowRecommendManager)paramAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a(paramInt);
  }
  
  public void getConnectionsPersonRemoteNextPage(int paramInt, AppInterface paramAppInterface)
  {
    paramAppInterface = (MayknowRecommendManager)paramAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    Bundle localBundle = new Bundle();
    localBundle.putString("from", "4");
    paramAppInterface.b(4, paramInt, localBundle);
  }
  
  public ArrayList<ConnectionsTabInfo> getConnectionsTabInfoListLocal(AppInterface paramAppInterface)
  {
    return ((MayknowRecommendManager)paramAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a();
  }
  
  public void getDiscussInfo(long paramLong, AppInterface paramAppInterface)
  {
    paramAppInterface = (DiscussionHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER);
    if (paramAppInterface != null) {
      paramAppInterface.a(paramLong);
    }
  }
  
  public String getDiscussionNameCanNull(AppInterface paramAppInterface, String paramString)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return ContactUtils.b((QQAppInterface)paramAppInterface, paramString);
    }
    return null;
  }
  
  public int getForwardSelectionRequest()
  {
    return 20000;
  }
  
  public Intent getFriendProfileMoreInfoIntent(Context paramContext)
  {
    return new Intent(paramContext, FriendProfileMoreInfoActivity.class);
  }
  
  public int getMayKnowLoadConnectionBizTypeFirstLoad()
  {
    return 1;
  }
  
  public boolean getMayKnowRecommendRemoteFromNewFrd(AppInterface paramAppInterface)
  {
    paramAppInterface = (MayknowRecommendManager)paramAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    if (paramAppInterface != null) {
      return paramAppInterface.a(4);
    }
    return false;
  }
  
  public String getQIMNewFriendSource(AppInterface paramAppInterface)
  {
    return ((FlashChatManager)paramAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c();
  }
  
  public ArrayList<QIMNotifyAddFriendMsg> getQIMNotifyAddFriendsMsg(boolean paramBoolean, AppInterface paramAppInterface)
  {
    return ((QIMNewFriendManager)paramAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a(paramBoolean);
  }
  
  public String getQQInfoFromQQUin(long paramLong1, long paramLong2, AppInterface paramAppInterface)
  {
    return ((QIMNewFriendManager)paramAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).a(paramLong1, paramLong2);
  }
  
  public HashMap<String, String> getQidianExternal(HashMap<String, Object> paramHashMap)
  {
    if (hasQidianExternal(paramHashMap))
    {
      paramHashMap = (QidianExternalInfo)paramHashMap.get("external");
      HashMap localHashMap = new HashMap();
      localHashMap.put("qidian_uin", paramHashMap.uin);
      localHashMap.put("qidian_nickname", paramHashMap.nickname);
      return localHashMap;
    }
    return null;
  }
  
  public String getRecommendLabelString(List<MayKnowRecommend.MayKnowRecommendLabel> paramList)
  {
    return ContactReportUtils.a(paramList);
  }
  
  public int getRequestForSetting()
  {
    return 9999;
  }
  
  public ArrayList<SchoolInfo> getSelfProfileSchoolInfo(AppInterface paramAppInterface)
  {
    return ((BusinessCardManager)paramAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a();
  }
  
  public int getSizeSmall()
  {
    return 200;
  }
  
  public void getSuspiciousFriendsUnreadNum(AppInterface paramAppInterface)
  {
    ((FriendListHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getSuspiciousFriendsUnreadNum();
  }
  
  public int getTypeSetConnectionsSwitch()
  {
    return 109;
  }
  
  public Object getValue(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return AntiFraudConfigFileUtil.a().a(paramString1, paramString2, paramInt1, paramInt2);
  }
  
  public void gotoFriendSettingBrowser(Context paramContext)
  {
    PermisionPrivacyActivity.a(paramContext);
  }
  
  public boolean hasQidianExternal(HashMap<String, Object> paramHashMap)
  {
    return (paramHashMap != null) && (paramHashMap.containsKey("external")) && (paramHashMap.get("external") != null);
  }
  
  public boolean hasQimSource(AppInterface paramAppInterface)
  {
    return ((FlashChatManager)paramAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).b();
  }
  
  public void insertCommonHobbyIfNeeded(AppInterface paramAppInterface, String paramString)
  {
    ChatActivityFacade.a((QQAppInterface)paramAppInterface, paramString);
  }
  
  public boolean isMayKnowConnectionsUserClosed(AppInterface paramAppInterface)
  {
    return ((CTEntryMng)paramAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).c();
  }
  
  public boolean isNewFrdMiniCardSwitchOn(AppInterface paramAppInterface)
  {
    return ((IceBreakingMng)paramAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).a();
  }
  
  public boolean isPhoneContactEnabled(AppInterface paramAppInterface)
  {
    return ((MayknowRecommendManager)paramAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a();
  }
  
  public boolean isQidianMaster(AppInterface paramAppInterface, String paramString)
  {
    return QidianManager.a((QQAppInterface)paramAppInterface, paramString);
  }
  
  public boolean isSuspiciousSwitchOpen()
  {
    return SysSuspiciousConfProcessor.a().a();
  }
  
  public void jumpToMoveGroup(Activity paramActivity, QBaseFragment paramQBaseFragment, String paramString, int paramInt1, int paramInt2)
  {
    paramActivity = new Intent(paramActivity, MoveToGroupActivity.class).putExtra("friendUin", paramString).putExtra("mgid", (byte)paramInt1);
    paramActivity.putExtra("PARAM_EXECUTE_IMMEDIATELY", false);
    paramQBaseFragment.startActivityForResult(paramActivity, paramInt2);
  }
  
  public void jumpToNewFriendMoreSysMsgSuspiciousFragment(Context paramContext)
  {
    PublicFragmentActivity.a(paramContext, NewFriendMoreSysMsgSuspiciousFragment.class);
  }
  
  public void jumpToQidianProfile(String paramString, Activity paramActivity)
  {
    paramString = new AllInOne(paramString, 1);
    Intent localIntent = new Intent(paramActivity, QidianProfileCardActivity.class);
    localIntent.putExtra("AllInOne", paramString);
    localIntent.addFlags(536870912);
    paramActivity.startActivity(localIntent);
  }
  
  public void jumpToSplash(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    Intent localIntent = new Intent(paramActivity, SplashActivity.class);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    localIntent.setFlags(67108864);
    paramActivity.startActivity(localIntent);
  }
  
  public void launchPluginBroadcastWhenToggleSwitch(String paramString, AppInterface paramAppInterface, boolean paramBoolean)
  {
    Intent localIntent = new Intent("com.tencent.qzone.action.OperateQZonePermission");
    localIntent.setPackage(MobileQQ.getContext().getPackageName());
    localIntent.putExtra("qzone_permission_uin", paramString);
    localIntent.putExtra("qzone_permission_operateType", 1);
    localIntent.putExtra("qzone_permission_value", paramBoolean);
    paramString = new IPluginManager.PluginParams(0);
    paramString.e = "QQ空间";
    paramString.b = QzonePluginProxyActivity.getQZonePluginName();
    paramString.jdField_a_of_type_JavaLangString = paramAppInterface.getCurrentAccountUin();
    paramString.f = "com.qzone.permissionsetting.business.QZonePermissionReciver";
    paramString.jdField_a_of_type_AndroidContentIntent = localIntent;
    IPluginManager.b(paramAppInterface.getApp(), paramString);
  }
  
  public void loadConnectionsTabData(AppInterface paramAppInterface, int paramInt1, int paramInt2)
  {
    paramAppInterface = (MayknowRecommendManager)paramAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
    Bundle localBundle = new Bundle();
    localBundle.putString("from", "3");
    if (paramInt1 <= 0)
    {
      localBundle.putInt("load_biz_type", 1);
      paramAppInterface.a(4, paramInt2, localBundle);
      return;
    }
    if (paramInt1 < 5)
    {
      localBundle.putInt("load_biz_type", 3);
      paramAppInterface.b(4, paramInt2, localBundle);
    }
  }
  
  public void markQIMNotifyAddFriendsRead(AppInterface paramAppInterface)
  {
    ((QIMNewFriendManager)paramAppInterface.getManager(QQManagerFactory.QIM_NEW_FRIEND_MANAGER)).b();
  }
  
  public void openSecCheckWebForFragment(AppInterface paramAppInterface, Context paramContext, QBaseFragment paramQBaseFragment, int paramInt, String paramString1, String paramString2)
  {
    AddContactSecCheckWebPlugin.a(paramAppInterface, paramContext, paramQBaseFragment, paramInt, paramString1);
  }
  
  public void recordStartExpose(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3, AppInterface paramAppInterface)
  {
    ((MayknowRecommendManager)paramAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a(paramMayKnowRecommend, paramInt1, paramInt2, paramInt3);
  }
  
  public void recordStopExpose(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3, AppInterface paramAppInterface)
  {
    ((MayknowRecommendManager)paramAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).b(paramMayKnowRecommend, paramInt1, paramInt2, paramInt3);
  }
  
  public void removeListener(Object paramObject, AppInterface paramAppInterface)
  {
    ((StatusManager)paramAppInterface.getManager(QQManagerFactory.STATUS_MANAGER)).b(paramObject);
  }
  
  public void reportExtendFriend(int paramInt, String paramString, Intent paramIntent)
  {
    if (paramInt == 3094)
    {
      paramInt = paramIntent.getIntExtra("sub_source_id", 8);
      paramIntent = new HashMap();
      paramIntent.put("frompage", String.valueOf(paramInt));
      paramIntent.put("to_uid", paramString);
      ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("click#data_page#send_request_all", true, -1L, -1L, paramIntent, true, true);
    }
  }
  
  public void reportRecommend(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, byte[] paramArrayOfByte, String paramString4, int paramInt4)
  {
    ContactReportUtils.a((QQAppInterface)paramAppInterface, paramString1, paramString2, paramInt1, paramInt2, paramString3, paramInt3, paramArrayOfByte, paramString4, paramInt4, "3");
  }
  
  public void reportRecommendExpose(AppInterface paramAppInterface, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Integer> paramArrayList, ArrayList<byte[]> paramArrayList3, int paramInt2)
  {
    ContactReportUtils.a((QQAppInterface)paramAppInterface, paramInt1, paramArrayList1, paramArrayList2, paramArrayList, paramArrayList3, paramInt2, "3");
  }
  
  public void sendAddFriendNoticeForBaby(AppInterface paramAppInterface, Intent paramIntent)
  {
    ((BabyQHandler)paramAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER)).a(paramIntent);
  }
  
  public void sendDelSingleSystemMsg(structmsg.StructMsg paramStructMsg, String paramString, int paramInt, long paramLong, AppInterface paramAppInterface)
  {
    ((QQAppInterface)paramAppInterface).getMsgHandler().a().a(paramStructMsg, paramString, paramInt, paramLong);
  }
  
  public void sendFriendSystemMsgAction(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6, structmsg.StructMsg paramStructMsg, boolean paramBoolean, AppInterface paramAppInterface)
  {
    ((QQAppInterface)paramAppInterface).getMsgHandler().a().a(paramInt1, paramLong1, paramLong2, paramInt2, paramInt3, paramInt4, paramInt5, paramSystemMsgActionInfo, paramInt6, paramStructMsg, paramBoolean);
  }
  
  public void sendFriendSystemMsgReadedReport(AppInterface paramAppInterface)
  {
    ((QQAppInterface)paramAppInterface).getMsgHandler().a().b();
  }
  
  public void sendGetNextFriendSystemMsg(AppInterface paramAppInterface)
  {
    ((QQAppInterface)paramAppInterface).getMsgHandler().a().g();
  }
  
  public void sendPokeMsg(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_JavaLangString = String.valueOf(paramString);
    localSessionInfo.b = localSessionInfo.jdField_a_of_type_JavaLangString;
    ChatActivityFacade.b((QQAppInterface)paramAppInterface, paramContext, localSessionInfo);
  }
  
  public void setConnectionsSwitch(boolean paramBoolean, AppInterface paramAppInterface)
  {
    paramAppInterface = (CTEntryMng)paramAppInterface.getManager(QQManagerFactory.CTENTRY_MNG);
    if (paramAppInterface != null) {
      paramAppInterface.b(true);
    }
  }
  
  public boolean shouldShowMayKnowInNewFriend(AppInterface paramAppInterface)
  {
    return ((MayknowRecommendManager)paramAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).e();
  }
  
  public void startAddContactsActivity(Context paramContext, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, AddContactsActivity.class);
    localIntent.putExtra("entrence_data_report", paramInt1);
    localIntent.putExtra("EntranceId", 6);
    ((Activity)paramContext).startActivityForResult(localIntent, 226);
  }
  
  public void startContactBindFromOther(AppInterface paramAppInterface, int paramInt1, int paramInt2, Intent paramIntent)
  {
    ContactBindedActivity.a((QQAppInterface)paramAppInterface, paramInt1, paramInt2, paramIntent);
  }
  
  public void startContactBindFromOther(AppInterface paramAppInterface, int paramInt, ArrayList<PhoneContact> paramArrayList)
  {
    ContactBindedActivity.a((QQAppInterface)paramAppInterface, paramInt, paramArrayList);
  }
  
  public void startRemarkAfterAgree(Activity paramActivity, int paramInt, String paramString, long paramLong, Bundle paramBundle)
  {
    AutoRemarkActivity.a(paramActivity, paramInt, paramString, paramLong, paramBundle);
  }
  
  public void updateCustomNoteTxt(TextView paramTextView, int paramInt1, int paramInt2)
  {
    CustomWidgetUtil.a(paramTextView, 3, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.impl.AddFriendTempApiImpl
 * JD-Core Version:    0.7.0.1
 */