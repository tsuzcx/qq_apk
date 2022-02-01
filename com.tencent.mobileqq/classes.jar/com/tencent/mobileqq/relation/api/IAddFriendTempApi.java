package com.tencent.mobileqq.relation.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.contact.connections.ConnectionsTabInfo;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MayKnowRecommend.MayKnowRecommendLabel;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.newfriend.msg.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.profile.SchoolInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

@QAPI(process={""})
public abstract interface IAddFriendTempApi
  extends QRouteApi
{
  public abstract void addBatchQIMFriends(List<QIMNotifyAddFriend> paramList, AppInterface paramAppInterface);
  
  public abstract void addFriendToFriendList(AppInterface paramAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long paramLong);
  
  public abstract void addListener(Object paramObject, AppInterface paramAppInterface);
  
  public abstract void cancelMayKnowRecommend(String paramString, AppInterface paramAppInterface);
  
  public abstract void changeStructMsgActions(structmsg.StructMsg paramStructMsg, int paramInt1, String paramString, int paramInt2);
  
  public abstract boolean changeStructMsgActionsWhenFail(structmsg.StructMsg paramStructMsg, int paramInt, String paramString1, String paramString2);
  
  public abstract void checkReadContactPermission(Runnable paramRunnable, Context paramContext, AppInterface paramAppInterface);
  
  public abstract void checkUpdate(AppInterface paramAppInterface, String paramString);
  
  public abstract void clearAllSystemMsg(AppInterface paramAppInterface);
  
  public abstract void clickQIMSource(Context paramContext, MessageRecord paramMessageRecord, AppInterface paramAppInterface);
  
  public abstract Intent composeReturnIntent(Class<?> paramClass, String paramString, Activity paramActivity);
  
  public abstract void deleteAllSuspiciousMsg(AppInterface paramAppInterface);
  
  public abstract void deleteQIMNotifyAddFriendData(QIMNotifyAddFriend paramQIMNotifyAddFriend, AppInterface paramAppInterface);
  
  public abstract boolean enableCheckPermission();
  
  public abstract void followUser(String paramString, boolean paramBoolean);
  
  public abstract Intent getAddRequestIntent(Context paramContext);
  
  public abstract Intent getBindNumberIntent(Context paramContext);
  
  public abstract Intent getChatActivityIntent(Context paramContext);
  
  public abstract ArrayList<MayKnowRecommend> getConnectionsPersonLocal(int paramInt, AppInterface paramAppInterface);
  
  public abstract void getConnectionsPersonRemoteNextPage(int paramInt, AppInterface paramAppInterface);
  
  public abstract ArrayList<ConnectionsTabInfo> getConnectionsTabInfoListLocal(AppInterface paramAppInterface);
  
  public abstract void getDiscussInfo(long paramLong, AppInterface paramAppInterface);
  
  public abstract String getDiscussionNameCanNull(AppInterface paramAppInterface, String paramString);
  
  public abstract int getForwardSelectionRequest();
  
  public abstract Intent getFriendProfileMoreInfoIntent(Context paramContext);
  
  public abstract int getMayKnowLoadConnectionBizTypeFirstLoad();
  
  public abstract boolean getMayKnowRecommendRemoteFromNewFrd(AppInterface paramAppInterface);
  
  public abstract String getQIMNewFriendSource(AppInterface paramAppInterface);
  
  public abstract ArrayList<QIMNotifyAddFriendMsg> getQIMNotifyAddFriendsMsg(boolean paramBoolean, AppInterface paramAppInterface);
  
  public abstract String getQQInfoFromQQUin(long paramLong1, long paramLong2, AppInterface paramAppInterface);
  
  public abstract HashMap<String, String> getQidianExternal(HashMap<String, Object> paramHashMap);
  
  public abstract String getRecommendLabelString(List<MayKnowRecommend.MayKnowRecommendLabel> paramList);
  
  public abstract int getRequestForSetting();
  
  public abstract ArrayList<SchoolInfo> getSelfProfileSchoolInfo(AppInterface paramAppInterface);
  
  public abstract int getSizeSmall();
  
  public abstract void getSuspiciousFriendsUnreadNum(AppInterface paramAppInterface);
  
  public abstract int getTypeSetConnectionsSwitch();
  
  public abstract Object getValue(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void gotoFriendSettingBrowser(Context paramContext);
  
  public abstract boolean hasQidianExternal(HashMap<String, Object> paramHashMap);
  
  public abstract boolean hasQimSource(AppInterface paramAppInterface);
  
  public abstract void insertCommonHobbyIfNeeded(AppInterface paramAppInterface, String paramString);
  
  public abstract boolean isMayKnowConnectionsUserClosed(AppInterface paramAppInterface);
  
  public abstract boolean isNewFrdMiniCardSwitchOn(AppInterface paramAppInterface);
  
  public abstract boolean isPhoneContactEnabled(AppInterface paramAppInterface);
  
  public abstract boolean isQidianMaster(AppInterface paramAppInterface, String paramString);
  
  public abstract boolean isSuspiciousSwitchOpen();
  
  public abstract void jumpToMoveGroup(Activity paramActivity, QBaseFragment paramQBaseFragment, String paramString, int paramInt1, int paramInt2);
  
  public abstract void jumpToNewFriendMoreSysMsgSuspiciousFragment(Context paramContext);
  
  public abstract void jumpToQidianProfile(String paramString, Activity paramActivity);
  
  public abstract void jumpToSplash(Activity paramActivity);
  
  public abstract void launchPluginBroadcastWhenToggleSwitch(String paramString, AppInterface paramAppInterface, boolean paramBoolean);
  
  public abstract void loadConnectionsTabData(AppInterface paramAppInterface, int paramInt1, int paramInt2);
  
  public abstract void markQIMNotifyAddFriendsRead(AppInterface paramAppInterface);
  
  public abstract void openSecCheckWebForFragment(AppInterface paramAppInterface, Context paramContext, QBaseFragment paramQBaseFragment, int paramInt, String paramString1, String paramString2);
  
  public abstract void recordStartExpose(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3, AppInterface paramAppInterface);
  
  public abstract void recordStopExpose(MayKnowRecommend paramMayKnowRecommend, int paramInt1, int paramInt2, int paramInt3, AppInterface paramAppInterface);
  
  public abstract void removeListener(Object paramObject, AppInterface paramAppInterface);
  
  public abstract void reportExtendFriend(int paramInt, String paramString, Intent paramIntent);
  
  public abstract void reportRecommend(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, int paramInt3, byte[] paramArrayOfByte, String paramString4, int paramInt4);
  
  public abstract void reportRecommendExpose(AppInterface paramAppInterface, int paramInt1, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, ArrayList<Integer> paramArrayList, ArrayList<byte[]> paramArrayList3, int paramInt2);
  
  public abstract void sendAddFriendNoticeForBaby(AppInterface paramAppInterface, Intent paramIntent);
  
  public abstract void sendDelSingleSystemMsg(structmsg.StructMsg paramStructMsg, String paramString, int paramInt, long paramLong, AppInterface paramAppInterface);
  
  public abstract void sendFriendSystemMsgAction(int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, structmsg.SystemMsgActionInfo paramSystemMsgActionInfo, int paramInt6, structmsg.StructMsg paramStructMsg, boolean paramBoolean, AppInterface paramAppInterface);
  
  public abstract void sendFriendSystemMsgReadedReport(AppInterface paramAppInterface);
  
  public abstract void sendGetNextFriendSystemMsg(AppInterface paramAppInterface);
  
  public abstract void sendPokeMsg(AppInterface paramAppInterface, Context paramContext, String paramString);
  
  public abstract void setConnectionsSwitch(boolean paramBoolean, AppInterface paramAppInterface);
  
  public abstract boolean shouldShowMayKnowInNewFriend(AppInterface paramAppInterface);
  
  public abstract void startAddContactsActivity(Context paramContext, int paramInt1, int paramInt2);
  
  public abstract void startContactBindFromOther(AppInterface paramAppInterface, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void startContactBindFromOther(AppInterface paramAppInterface, int paramInt, ArrayList<PhoneContact> paramArrayList);
  
  public abstract void startRemarkAfterAgree(Activity paramActivity, int paramInt, String paramString, long paramLong, Bundle paramBundle);
  
  public abstract void updateCustomNoteTxt(TextView paramTextView, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.relation.api.IAddFriendTempApi
 * JD-Core Version:    0.7.0.1
 */