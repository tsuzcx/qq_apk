package com.tencent.timi.game.userinfo.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.userinfo.api.GroupProUserInfo;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.impl.db.UserInfoEntity;
import com.tencent.timi.game.userinfo.impl.util.UserInfoEntityUtil;
import com.tencent.timi.game.userinfo.impl.util.UserInfoUtil;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.GameDataServerOuterClass.SmobaGameRoleInfo;
import trpc.yes.common.UserProxyCmdOuterClass.BaseInfo;
import trpc.yes.common.UserProxyCmdOuterClass.QQUserInfo;
import trpc.yes.common.UserProxyCmdOuterClass.UserGameOpenid;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/AllUserInfoModel;", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "entity", "Lcom/tencent/timi/game/userinfo/impl/db/UserInfoEntity;", "(Lcom/tencent/timi/game/userinfo/impl/db/UserInfoEntity;)V", "CPDD_SEX_FEMALE", "", "CPDD_SEX_MALE", "CPDD_SEX_NONE", "allGroupProUserInfoModel", "Lcom/tencent/timi/game/userinfo/impl/AllGroupProUserInfoModel;", "createdRoomList", "", "Ltrpc/yes/common/UserProxyCmdOuterClass$UserRoom;", "getEntity", "()Lcom/tencent/timi/game/userinfo/impl/db/UserInfoEntity;", "setEntity", "qqBaseInfo", "Ltrpc/yes/common/UserProxyCmdOuterClass$BaseInfo;", "smobaGameRoleExtInfo", "Ltrpc/yes/common/GameDataServerOuterClass$SmobaGameRoleInfo;", "userGameOpenid", "Ltrpc/yes/common/UserProxyCmdOuterClass$UserGameOpenid;", "acquireCPDDGender", "", "acquireCommunityGender", "age", "qqUserId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "avatar", "birthday", "Ltrpc/yes/common/UserProxyCmdOuterClass$Birthday;", "city", "constellation", "convertToNonString", "content", "convertToQQUserInfo", "Ltrpc/yes/common/UserProxyCmdOuterClass$QQUserInfo;", "defaultSmobaRole", "gameAuthStatus", "gender", "groupProUserInfo", "Lcom/tencent/timi/game/userinfo/api/GroupProUserInfo;", "hasDefaultSmobaRole", "", "initGameOpenid", "", "initQQBaseInfo", "isUserFromCPDD", "isUserFromCommunity", "nick", "toString", "uid", "", "userNotes", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class AllUserInfoModel
  implements IUserInfo
{
  private UserProxyCmdOuterClass.BaseInfo a;
  private UserProxyCmdOuterClass.UserGameOpenid b;
  private AllGroupProUserInfoModel c;
  private GameDataServerOuterClass.SmobaGameRoleInfo d;
  private int e;
  private int f;
  private int g;
  @Nullable
  private UserInfoEntity h;
  
  public AllUserInfoModel(@Nullable UserInfoEntity paramUserInfoEntity)
  {
    this.h = paramUserInfoEntity;
    this.f = 1;
    this.g = 2;
    h();
    i();
  }
  
  private final String a(String paramString)
  {
    if (paramString != null) {
      return paramString;
    }
    return "";
  }
  
  private final boolean f(CommonOuterClass.QQUserId paramQQUserId)
  {
    if (paramQQUserId != null)
    {
      paramQQUserId = paramQQUserId.user_from;
      if ((paramQQUserId != null) && (paramQQUserId.get() == 1)) {
        return true;
      }
    }
    return false;
  }
  
  private final boolean g(CommonOuterClass.QQUserId paramQQUserId)
  {
    if (paramQQUserId != null)
    {
      paramQQUserId = paramQQUserId.user_from;
      if ((paramQQUserId != null) && (paramQQUserId.get() == 2)) {
        return true;
      }
    }
    return false;
  }
  
  private final void h()
  {
    this.a = UserInfoEntityUtil.a.a(this.h);
  }
  
  private final void i()
  {
    this.b = UserInfoEntityUtil.a.b(this.h);
  }
  
  private final String j()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((UserProxyCmdOuterClass.BaseInfo)localObject).gender;
      if (localObject != null)
      {
        i = ((PBUInt32Field)localObject).get();
        break label31;
      }
    }
    int i = this.e;
    label31:
    if (i == this.f) {
      return "男";
    }
    if (i == this.g) {
      return "女";
    }
    return "未知";
  }
  
  private final String k()
  {
    Object localObject = g();
    if (localObject != null) {
      localObject = Integer.valueOf(((GroupProUserInfo)localObject).b());
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((Integer)localObject).intValue() == 1)) {
      return "男";
    }
    if ((localObject != null) && (((Integer)localObject).intValue() == 2)) {
      return "女";
    }
    return "未知";
  }
  
  @NotNull
  public String a(@Nullable CommonOuterClass.QQUserId paramQQUserId)
  {
    paramQQUserId = this.a;
    if (paramQQUserId != null)
    {
      paramQQUserId = paramQQUserId.constellation;
      if (paramQQUserId != null)
      {
        paramQQUserId = paramQQUserId.get();
        break label28;
      }
    }
    paramQQUserId = null;
    label28:
    return a(paramQQUserId);
  }
  
  @NotNull
  public String b(@Nullable CommonOuterClass.QQUserId paramQQUserId)
  {
    paramQQUserId = this.a;
    if (paramQQUserId != null)
    {
      paramQQUserId = paramQQUserId.city;
      if (paramQQUserId != null)
      {
        paramQQUserId = paramQQUserId.get();
        break label28;
      }
    }
    paramQQUserId = null;
    label28:
    return a(paramQQUserId);
  }
  
  @Nullable
  public UserProxyCmdOuterClass.UserGameOpenid b()
  {
    return this.b;
  }
  
  @NotNull
  public String c(@Nullable CommonOuterClass.QQUserId paramQQUserId)
  {
    boolean bool = f(paramQQUserId);
    Object localObject2 = null;
    Object localObject1 = null;
    if (bool)
    {
      localObject2 = this.a;
      paramQQUserId = (CommonOuterClass.QQUserId)localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((UserProxyCmdOuterClass.BaseInfo)localObject2).nick;
        paramQQUserId = (CommonOuterClass.QQUserId)localObject1;
        if (localObject2 != null) {
          paramQQUserId = ((PBStringField)localObject2).get();
        }
      }
      return a(paramQQUserId);
    }
    if (g(paramQQUserId))
    {
      GroupProUserInfo localGroupProUserInfo = g();
      if (localGroupProUserInfo != null)
      {
        localObject1 = localObject2;
        if (paramQQUserId != null)
        {
          paramQQUserId = paramQQUserId.guild_id;
          localObject1 = localObject2;
          if (paramQQUserId != null) {
            localObject1 = Long.valueOf(paramQQUserId.get());
          }
        }
        paramQQUserId = localGroupProUserInfo.a((Long)localObject1);
        if (paramQQUserId != null) {
          return paramQQUserId;
        }
      }
      return "";
    }
    return "";
  }
  
  @Nullable
  public GameDataServerOuterClass.SmobaGameRoleInfo c()
  {
    if (this.d == null) {
      this.d = UserInfoEntityUtil.a.d(this.h);
    }
    return this.d;
  }
  
  @NotNull
  public String d(@Nullable CommonOuterClass.QQUserId paramQQUserId)
  {
    if (f(paramQQUserId)) {
      return j();
    }
    if (g(paramQQUserId)) {
      return k();
    }
    return "未知";
  }
  
  @Nullable
  public UserProxyCmdOuterClass.QQUserInfo d()
  {
    return UserInfoUtil.a.a(this.h);
  }
  
  @NotNull
  public String e(@Nullable CommonOuterClass.QQUserId paramQQUserId)
  {
    boolean bool = f(paramQQUserId);
    UserInfoEntity localUserInfoEntity = null;
    GroupProUserInfo localGroupProUserInfo = null;
    if (bool)
    {
      localUserInfoEntity = this.h;
      paramQQUserId = localGroupProUserInfo;
      if (localUserInfoEntity != null) {
        paramQQUserId = localUserInfoEntity.extensionAvatar;
      }
      return a(paramQQUserId);
    }
    if (g(paramQQUserId))
    {
      localGroupProUserInfo = g();
      paramQQUserId = localUserInfoEntity;
      if (localGroupProUserInfo != null) {
        paramQQUserId = localGroupProUserInfo.a();
      }
      return a(paramQQUserId);
    }
    return "";
  }
  
  public boolean e()
  {
    GameDataServerOuterClass.SmobaGameRoleInfo localSmobaGameRoleInfo = c();
    return (localSmobaGameRoleInfo != null) && (!TextUtils.isEmpty((CharSequence)localSmobaGameRoleInfo.role_name.get()));
  }
  
  public long f()
  {
    UserInfoEntity localUserInfoEntity = this.h;
    if (localUserInfoEntity != null) {
      return localUserInfoEntity.uid;
    }
    return 0L;
  }
  
  @Nullable
  public GroupProUserInfo g()
  {
    if (this.c == null) {
      this.c = new AllGroupProUserInfoModel(UserInfoEntityUtil.a.c(this.h));
    }
    return (GroupProUserInfo)this.c;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = ((UserInfoEntity)localObject).toString();
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.AllUserInfoModel
 * JD-Core Version:    0.7.0.1
 */