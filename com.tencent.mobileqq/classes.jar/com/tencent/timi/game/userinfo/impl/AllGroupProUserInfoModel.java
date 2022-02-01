package com.tencent.timi.game.userinfo.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.userinfo.api.GroupProUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.UserProxyCmdOuterClass.JoinedGuildInfo;
import trpc.yes.common.UserProxyCmdOuterClass.QQGroupProInfo;
import trpc.yes.common.UserProxyCmdOuterClass.QQGroupProUserInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/AllGroupProUserInfoModel;", "Lcom/tencent/timi/game/userinfo/api/GroupProUserInfo;", "groupProInfo", "Ltrpc/yes/common/UserProxyCmdOuterClass$QQGroupProInfo;", "(Ltrpc/yes/common/UserProxyCmdOuterClass$QQGroupProInfo;)V", "getGroupProInfo", "()Ltrpc/yes/common/UserProxyCmdOuterClass$QQGroupProInfo;", "avatar", "", "gender", "", "joinedGuildList", "", "Ltrpc/yes/common/UserProxyCmdOuterClass$JoinedGuildInfo;", "nick", "guildId", "", "tinyid", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AllGroupProUserInfoModel
  implements GroupProUserInfo
{
  @Nullable
  private final UserProxyCmdOuterClass.QQGroupProInfo a;
  
  public AllGroupProUserInfoModel(@Nullable UserProxyCmdOuterClass.QQGroupProInfo paramQQGroupProInfo)
  {
    this.a = paramQQGroupProInfo;
  }
  
  @NotNull
  public String a()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((UserProxyCmdOuterClass.QQGroupProInfo)localObject).group_pro_user_info;
      if (localObject != null)
      {
        localObject = ((UserProxyCmdOuterClass.QQGroupProUserInfo)localObject).avatar;
        if (localObject != null)
        {
          localObject = ((PBStringField)localObject).get();
          if (localObject != null)
          {
            localObject = ((String)localObject).toString();
            if (localObject != null) {
              return localObject;
            }
          }
        }
      }
    }
    return "";
  }
  
  @NotNull
  public String a(long paramLong)
  {
    Iterator localIterator = ((Iterable)c()).iterator();
    while (localIterator.hasNext())
    {
      localObject = (UserProxyCmdOuterClass.JoinedGuildInfo)localIterator.next();
      if (paramLong == ((UserProxyCmdOuterClass.JoinedGuildInfo)localObject).guild_id.get())
      {
        localObject = ((UserProxyCmdOuterClass.JoinedGuildInfo)localObject).member_nick.get();
        if (localObject == null) {
          localObject = "";
        }
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          return localObject;
        }
      }
    }
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((UserProxyCmdOuterClass.QQGroupProInfo)localObject).group_pro_user_info;
      if (localObject != null)
      {
        localObject = ((UserProxyCmdOuterClass.QQGroupProUserInfo)localObject).nick;
        if (localObject != null)
        {
          localObject = ((PBStringField)localObject).get();
          if (localObject != null) {
            return localObject;
          }
        }
      }
    }
    return "";
  }
  
  public int b()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((UserProxyCmdOuterClass.QQGroupProInfo)localObject).group_pro_user_info;
      if (localObject != null)
      {
        localObject = ((UserProxyCmdOuterClass.QQGroupProUserInfo)localObject).gender;
        if (localObject != null) {
          return ((PBUInt32Field)localObject).get();
        }
      }
    }
    return 0;
  }
  
  @NotNull
  public List<UserProxyCmdOuterClass.JoinedGuildInfo> c()
  {
    List localList = (List)new ArrayList();
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((UserProxyCmdOuterClass.QQGroupProInfo)localObject).joined_guild_info_list;
      if (localObject != null)
      {
        localObject = ((PBRepeatMessageField)localObject).get();
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            UserProxyCmdOuterClass.JoinedGuildInfo localJoinedGuildInfo = (UserProxyCmdOuterClass.JoinedGuildInfo)((Iterator)localObject).next();
            Intrinsics.checkExpressionValueIsNotNull(localJoinedGuildInfo, "it");
            localList.add(localJoinedGuildInfo);
          }
        }
      }
    }
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.AllGroupProUserInfoModel
 * JD-Core Version:    0.7.0.1
 */