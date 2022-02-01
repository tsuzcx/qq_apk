package com.tencent.mobileqq.qqguildsdk.wrapper;

import com.tencent.mobileqq.qqguildsdk.data.CategoryChannelSortInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserInfo;
import com.tencent.mobileqq.qqguildsdk.data.GProUserProfileInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildInitInfo;
import com.tencent.mobileqq.qqguildsdk.data.GuildUserAvatar;
import com.tencent.mobileqq.qqguildsdk.data.IGProClientIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGuildMemberCountInfos;
import com.tencent.mobileqq.qqguildsdk.data.ILiveChannelMemberInfo;
import com.tencent.mobileqq.qqguildsdk.data.MemberNickNameInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract interface IGProSdkWrapperListener
{
  public abstract void a(int paramInt, GProChannelInfo paramGProChannelInfo);
  
  public abstract void a(int paramInt, GProGuildInfo paramGProGuildInfo, boolean paramBoolean);
  
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(int paramInt, String paramString1, String paramString2, String paramString3, GProUserProfileInfo paramGProUserProfileInfo);
  
  public abstract void a(int paramInt, String paramString, HashMap<String, GProChannelInfo> paramHashMap, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList);
  
  public abstract void a(int paramInt, boolean paramBoolean, ArrayList<String> paramArrayList, ArrayList<GProGuildInfo> paramArrayList1);
  
  public abstract void a(IGuildMemberCountInfos paramIGuildMemberCountInfos);
  
  public abstract void a(String paramString);
  
  public abstract void a(String paramString, GProGuildInfo paramGProGuildInfo, HashMap<String, GProChannelInfo> paramHashMap, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList);
  
  public abstract void a(String paramString, GuildInitInfo paramGuildInitInfo);
  
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(String paramString1, String paramString2, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public abstract void a(String paramString1, String paramString2, int paramInt, long paramLong);
  
  public abstract void a(String paramString1, String paramString2, GProUserInfo paramGProUserInfo);
  
  public abstract void a(String paramString1, String paramString2, GuildInitInfo paramGuildInitInfo);
  
  public abstract void a(String paramString1, String paramString2, IGProClientIdentityInfo paramIGProClientIdentityInfo);
  
  public abstract void a(String paramString1, String paramString2, String paramString3);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5);
  
  public abstract void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, List<String> paramList);
  
  public abstract void a(String paramString1, String paramString2, List<ILiveChannelMemberInfo> paramList, int paramInt);
  
  public abstract void a(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void a(String paramString, List<MemberNickNameInfo> paramList);
  
  public abstract void a(ArrayList<String> paramArrayList, String paramString);
  
  public abstract void a(List<GuildUserAvatar> paramList);
  
  public abstract void b(String paramString, GProGuildInfo paramGProGuildInfo, HashMap<String, GProChannelInfo> paramHashMap, CategoryChannelSortInfo paramCategoryChannelSortInfo, List<CategoryChannelSortInfo> paramList);
  
  public abstract void b(String paramString1, String paramString2, int paramInt);
  
  public abstract void b(String paramString1, String paramString2, String paramString3);
  
  public abstract void b(String paramString1, String paramString2, List<String> paramList);
  
  public abstract void b(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract void b(List<MemberNickNameInfo> paramList);
  
  public abstract void c(String paramString1, String paramString2);
  
  public abstract void c(String paramString1, String paramString2, int paramInt);
  
  public abstract void c(String paramString1, String paramString2, String paramString3);
  
  public abstract void c(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.wrapper.IGProSdkWrapperListener
 * JD-Core Version:    0.7.0.1
 */