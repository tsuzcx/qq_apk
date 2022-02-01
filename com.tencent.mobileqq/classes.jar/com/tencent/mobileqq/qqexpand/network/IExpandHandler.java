package com.tencent.mobileqq.qqexpand.network;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/network/IExpandHandler;", "", "calcMatchChatBoxUnreadCount", "", "cancleUnlimitMatch", "", "uin", "", "closeSignalBomb", "editExtendFriendInfo", "declaration", "url", "duration", "", "fontId", "fontType", "clothesId", "getExpandHandlerClassName", "getExtendFriendInfo", "vipInfoOnly", "getExtendFriendOnlineState", "reqList", "", "", "reqTag", "getNewReqNum", "getSigBy0xb4cCode", "selfUin", "friendUin", "friendNick", "_0xb4cCode", "", "getSquareStrangerList", "reqCookies", "reqCount", "searchKey", "ts", "searchKeyMask", "isConfigTag", "getUnlimitMatchBaseInfo", "handleC2CConfirmMsg", "message", "Lcom/tencent/mobileqq/data/MessageRecord;", "handleGetUnlimitMatchOfflinePush", "msgBody", "subType", "notifyUI", "type", "isSuccess", "data", "reportUser", "reqThrowToColdPalace", "uinType", "requestCampusCertificateStatus", "getSearchKeywords", "getOnlineNumber", "requestLimitChatSettingOnPlusPanel", "bFromLoginStep", "requestUnlimitMatch", "sexType", "tagId", "setUnlimitMatchStatus", "bOpen", "updateExtendFriendCampusSchoolInfo", "info", "updateRedPoint", "qqexpand-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IExpandHandler
{
  public abstract int a();
  
  public abstract int a(@Nullable String paramString, boolean paramBoolean);
  
  public abstract void a();
  
  public abstract void a(@Nullable MessageRecord paramMessageRecord);
  
  public abstract void a(@Nullable Object paramObject);
  
  public abstract void a(@Nullable Object paramObject, long paramLong);
  
  public abstract void a(@Nullable String paramString);
  
  public abstract void a(@Nullable String paramString, int paramInt);
  
  public abstract void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(@Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable byte[] paramArrayOfByte);
  
  public abstract void a(@Nullable String paramString1, @Nullable byte[] paramArrayOfByte, int paramInt, @Nullable String paramString2, long paramLong, @Nullable String paramString3, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a(@Nullable String paramString);
  
  public abstract boolean a(@Nullable String paramString, int paramInt1, int paramInt2);
  
  public abstract boolean a(@Nullable String paramString, boolean paramBoolean);
  
  public abstract boolean a(@Nullable List<Long> paramList);
  
  public abstract boolean a(@Nullable List<Long> paramList, int paramInt);
  
  public abstract void b();
  
  public abstract boolean b(@Nullable String paramString);
  
  public abstract void notifyUI(int paramInt, boolean paramBoolean, @Nullable Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.IExpandHandler
 * JD-Core Version:    0.7.0.1
 */