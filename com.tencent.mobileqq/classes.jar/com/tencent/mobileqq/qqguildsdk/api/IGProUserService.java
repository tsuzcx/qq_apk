package com.tencent.mobileqq.qqguildsdk.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqguildsdk.callback.IFetchVisibleMemberListByTinyIdCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetGProUserListPaginationCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetInvisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetUserListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetVisibleMemberCountCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IGetVisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ILoadUserProfileInfoCallback;
import com.tencent.mobileqq.qqguildsdk.callback.IResultWithSecurityCallback;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchSink;
import com.tencent.mobileqq.qqguildsdk.callback.ISearchVisibleMemberListCallback;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;
import java.util.Map;

public abstract interface IGProUserService
{
  public abstract void fetchUserInfo(String paramString, List<String> paramList, boolean paramBoolean, IGetUserInfoCallback paramIGetUserInfoCallback);
  
  public abstract void fetchVisibleMemberListByTinyId(String paramString1, String paramString2, @NonNull List<String> paramList, @NonNull IFetchVisibleMemberListByTinyIdCallback paramIFetchVisibleMemberListByTinyIdCallback);
  
  public abstract String getFullAvatarUrl(GuildUserAvatar paramGuildUserAvatar, int paramInt);
  
  public abstract String getGuildMemberName(String paramString1, String paramString2);
  
  public abstract Map<String, String> getGuildMemberNames(String paramString, List<String> paramList);
  
  public abstract String getGuildUserNick(String paramString);
  
  public abstract GuildUserAvatar getGuildUsersAvatarUrl(String paramString);
  
  public abstract Map<String, GuildUserAvatar> getGuildUsersAvatarUrls(List<String> paramList);
  
  public abstract Map<String, String> getGuildUsersNicks(List<String> paramList);
  
  public abstract void getInvisibleMemberList(String paramString1, String paramString2, int paramInt, boolean paramBoolean, @NonNull IGetInvisibleMemberListCallback paramIGetInvisibleMemberListCallback);
  
  public abstract String getSelfGuildMemberName(String paramString);
  
  public abstract void getUserList(String paramString, long paramLong, boolean paramBoolean, IGetUserListCallback paramIGetUserListCallback);
  
  public abstract void getUserList(String paramString, Object paramObject, boolean paramBoolean, @NonNull IGetGProUserListPaginationCallback paramIGetGProUserListPaginationCallback);
  
  public abstract void getVisibleMemberCount(@NonNull String paramString1, @NonNull String paramString2, @NonNull IGetVisibleMemberCountCallback paramIGetVisibleMemberCountCallback);
  
  public abstract void getVisibleMemberList(String paramString1, String paramString2, int paramInt, boolean paramBoolean, @NonNull IGetVisibleMemberListCallback paramIGetVisibleMemberListCallback);
  
  public abstract void kickGuildUsers(String paramString, List<String> paramList, boolean paramBoolean, IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void loadGProUserProfileInfo(String paramString1, String paramString2, ILoadUserProfileInfoCallback paramILoadUserProfileInfoCallback);
  
  public abstract void refreshGuildUserProfileInfo(String paramString1, String paramString2);
  
  public abstract void searchGuildUserByGuildNickname(String paramString1, String paramString2, int paramInt, ISearchSink<IGProUserInfo> paramISearchSink);
  
  public abstract void searchVisibleMemberList(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, ISearchVisibleMemberListCallback paramISearchVisibleMemberListCallback);
  
  public abstract void setGuildMemberName(String paramString1, String paramString2, IResultWithSecurityCallback paramIResultWithSecurityCallback);
  
  public abstract void setMemberNameForMsg(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.api.IGProUserService
 * JD-Core Version:    0.7.0.1
 */