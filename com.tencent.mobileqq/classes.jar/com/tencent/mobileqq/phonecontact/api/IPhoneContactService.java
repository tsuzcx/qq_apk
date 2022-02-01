package com.tencent.mobileqq.phonecontact.api;

import SecurityAccountServer.AddressBookItem;
import SecurityAccountServer.MobileContactsFriendInfo;
import SecurityAccountServer.MobileContactsNotFriendInfo;
import SecurityAccountServer.NotBindContactFriendInfo;
import SecurityAccountServer.NotBindContactNotFriendInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.phonecontact.data.ContactBindedData;
import com.tencent.mobileqq.phonecontact.data.ContactMatch;
import com.tencent.mobileqq.phonecontact.data.PhoneContactAdd;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.qroute.annotation.Service;
import friendlist.GetOnlineInfoResp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IPhoneContactService
  extends IRuntimeService
{
  public abstract void OnDisableMobileBindSuc();
  
  public abstract boolean addContactAndUpload(String paramString1, String paramString2);
  
  public abstract void addFriendSuccessNotify(String paramString1, String paramString2);
  
  public abstract void addListener(IPhoneContactListener paramIPhoneContactListener);
  
  public abstract void addUinByPhoneNum(String paramString1, String paramString2);
  
  public abstract ContactBindedData asyncInitContactBindedData(List<PhoneContact> paramList);
  
  public abstract void changeHidenStatus(String paramString, boolean paramBoolean);
  
  public abstract boolean checkAndUploadContact(boolean paramBoolean);
  
  public abstract void checkUpdateBindStateAndListIgnoreBindState(boolean paramBoolean1, boolean paramBoolean2, int paramInt);
  
  public abstract void checkUpdateLocalContact(boolean paramBoolean, int paramInt);
  
  public abstract void clearRecommendBadge();
  
  public abstract void deleteContactMatch(ContactMatch paramContactMatch);
  
  public abstract void deletePhoneContactAddInfo(PhoneContactAdd paramPhoneContactAdd);
  
  public abstract boolean deletePhoneContactAddInfo(String paramString);
  
  public abstract void disableMobileMatch(String paramString1, String paramString2);
  
  public abstract boolean existContact(String paramString1, String paramString2);
  
  public abstract void fillToMaxCountIfNeeded(ArrayList<PhoneContact> paramArrayList, int paramInt);
  
  public abstract ArrayList<PhoneContact> generateRandomList();
  
  public abstract int getBannerState();
  
  public abstract List<PhoneContact> getBindAllFriendList();
  
  public abstract List<PhoneContact> getBindHideNoneFriendList(boolean paramBoolean);
  
  public abstract List<PhoneContact> getBindNonfriendList();
  
  public abstract List<PhoneContact> getBindNonfriendList(int[] paramArrayOfInt);
  
  public abstract int getBindStateForServer();
  
  public abstract ContactBindedData getContactBoundDataCache();
  
  public abstract List<PhoneContact> getContactList();
  
  public abstract List<PhoneContact> getContactListForContactListView(Map<String, PhoneContact> paramMap, boolean paramBoolean);
  
  public abstract List<PhoneContact> getContactListForContactListView(boolean paramBoolean);
  
  public abstract List<List<PhoneContact>> getContactListForDisplay();
  
  public abstract List<PhoneContact> getContactListForPhoneSelector();
  
  public abstract List<PhoneContact> getContactListForSelector();
  
  public abstract Object[] getFriendHasBindPhone();
  
  public abstract long getLastLoginType(String paramString);
  
  public abstract ArrayList<PhoneContactAdd> getPhoneContactAddList();
  
  public abstract PhoneContact getPhoneContactByMD5(String paramString);
  
  public abstract String getPhoneNumByUin(String paramString);
  
  public abstract ArrayList<Entity> getRecommendContact();
  
  public abstract int getRecommendUnreadCount();
  
  public abstract List<PhoneContact> getRecommendUnreadList();
  
  public abstract RespondQueryQQBindingStat getSelfBindInfo();
  
  public abstract int getSelfBindState();
  
  public abstract long getUIBits();
  
  public abstract String getUNIQUE_NO();
  
  public abstract String getUinByPhoneNum(String paramString);
  
  public abstract int getUploadPackages();
  
  public abstract int getsAllEntranceConfigVersion();
  
  public abstract void hideContact(String paramString, boolean paramBoolean);
  
  public abstract void initContactCache();
  
  public abstract boolean isAutoUploadContacts();
  
  public abstract boolean isBindContactOk();
  
  public abstract boolean isBindNoneFriendListEmpty();
  
  public abstract boolean isBindedIgnoreUpload();
  
  public abstract boolean isDestroyed();
  
  public abstract int loadContactFriendList(List<String> paramList);
  
  public abstract Map<String, PhoneContact> loadContactFromPhoneWithoutCaches();
  
  public abstract void makePhoneContactAddInfo(String paramString1, int paramInt, String paramString2);
  
  public abstract void markAndUploadForNewGuide();
  
  public abstract void markOrClearUserSettingFlag(boolean paramBoolean);
  
  public abstract void markRecommendReaded();
  
  public abstract void markUploadedContact(List<AddressBookItem> paramList);
  
  public abstract void markUploadedContactNotBind(List<AddressBookItem> paramList);
  
  public abstract boolean needUploadContact();
  
  public abstract void notifyContactChanged();
  
  public abstract void onAppRunBackground();
  
  public abstract void onAppRunForeground();
  
  public abstract void onFriendListChanged();
  
  public abstract void onGetFriendsHasBindPhone(int paramInt, List<String> paramList);
  
  public abstract void onStepAction(boolean paramBoolean);
  
  public abstract PhoneContact queryContactByCodeNumber(String paramString);
  
  public abstract PhoneContact queryPhoneContactByMobile(String paramString);
  
  public abstract PhoneContact queryPhoneContactByUin(String paramString);
  
  public abstract void removeListener(IPhoneContactListener paramIPhoneContactListener);
  
  public abstract void saveBindConfig(int paramInt, String paramString1, String paramString2);
  
  public abstract boolean saveBindInfo(RespondQueryQQBindingStat paramRespondQueryQQBindingStat, String paramString);
  
  public abstract int saveContactFromServer(boolean paramBoolean1, int paramInt, long paramLong1, boolean paramBoolean2, long paramLong2, long paramLong3, List<MobileContactsFriendInfo> paramList, List<MobileContactsNotFriendInfo> paramList1);
  
  public abstract int saveContactFromServerNotBind(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2, ArrayList<NotBindContactFriendInfo> paramArrayList, ArrayList<NotBindContactNotFriendInfo> paramArrayList1);
  
  public abstract void saveLastLoginList(List<String> paramList, long paramLong1, long paramLong2);
  
  public abstract void saveQueryInterval(long paramLong1, long paramLong2, long paramLong3);
  
  public abstract void saveUIBits(long paramLong);
  
  public abstract void sendBindMobile(String paramString1, String paramString2);
  
  public abstract void sendBindMobile(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void sendBindMobileEncrypt(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void sendRebindMobile(String paramString1, String paramString2);
  
  public abstract void sendRebindMobile(String paramString1, String paramString2, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void sendRebindMobileEncrypt(String paramString, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void sendVerifySmsCode(String paramString);
  
  public abstract void sendVerifySmsCode(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void setContactBoundDataCache(ContactBindedData paramContactBindedData);
  
  public abstract void setNeedUploadResultTip(boolean paramBoolean);
  
  public abstract void setOpeningShareFlag(boolean paramBoolean);
  
  public abstract boolean shouldBlockMessageTips();
  
  public abstract void unbindMobile();
  
  public abstract void unbindMobile(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void unbindMobileEncrypt(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void updateAllEntranceConfig(int paramInt, String paramString);
  
  public abstract void updateOnlineStatus(String paramString, GetOnlineInfoResp paramGetOnlineInfoResp);
  
  public abstract void updateRenameList(ArrayList<PhoneContact> paramArrayList);
  
  public abstract void updateSessionId(byte[] paramArrayOfByte);
  
  public abstract void uploadOrUpdateContact();
  
  public abstract boolean uploadPhoneContact();
  
  public abstract boolean uploadPhoneContactNotBind();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.phonecontact.api.IPhoneContactService
 * JD-Core Version:    0.7.0.1
 */