package com.tencent.timi.game.userinfo.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.timi.game.databasecore.impl.YesDataBaseHelper;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiDatabaseTableHandler;
import com.tencent.timi.game.databasecore.impl.base.BaseTimiGameEntity;
import com.tencent.timi.game.databasecore.impl.livedata.IDbLiveData;
import com.tencent.timi.game.userinfo.api.IUserInfo;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.userinfo.api.NetRspUserData;
import com.tencent.timi.game.userinfo.api.view.IUserInfoView;
import com.tencent.timi.game.userinfo.api.view.UserInfoViewWrapper;
import com.tencent.timi.game.userinfo.impl.db.UserInfoCacheManager;
import com.tencent.timi.game.userinfo.impl.db.UserInfoCacheManager.Companion;
import com.tencent.timi.game.userinfo.impl.db.UserInfoEntity;
import com.tencent.timi.game.userinfo.impl.db.UserInfoLiveData;
import com.tencent.timi.game.userinfo.impl.db.UserInfoTableHandler;
import com.tencent.timi.game.userinfo.impl.loader.UserRoleInfoAutoLoader;
import com.tencent.timi.game.userinfo.impl.loader.UserRoleInfoAutoLoader.Companion;
import com.tencent.timi.game.userinfo.impl.net.GetUserInfoRequest;
import com.tencent.timi.game.userinfo.impl.util.UserInfoDbUtil;
import com.tencent.timi.game.userinfo.impl.util.UserInfoUtil;
import com.tencent.timi.game.userinfo.impl.view.UserInfoViewWrapperImpl;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.Logger;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass.QQUserId;
import trpc.yes.common.UserProxyCmdOuterClass.BaseInfo;
import trpc.yes.common.UserProxyCmdOuterClass.MiniInfo;
import trpc.yes.common.UserProxyCmdOuterClass.QQUserInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/UserInfoServiceImpl;", "Lcom/tencent/timi/game/userinfo/api/IUserInfoService;", "()V", "convertToUserInfo", "Lcom/tencent/timi/game/userinfo/api/IUserInfo;", "qqUserInfo", "Ltrpc/yes/common/UserProxyCmdOuterClass$QQUserInfo;", "createCommunityUerId", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "", "guildId", "createPCDDUerId", "createView", "Landroid/view/View;", "viewName", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "getUserInfoAndUpdate", "Lcom/tencent/timi/game/databasecore/impl/livedata/IDbLiveData;", "uid", "getUserInfoFromDB", "", "callback", "Lcom/tencent/timi/game/utils/IResultListener;", "getUserInfoFromDBOrNet", "getUserInfoFromNet", "getUserInfoFromNetWithRsp", "Lcom/tencent/timi/game/userinfo/api/NetRspUserData;", "getUserInfoOrUpdate", "getUserInfoWrapper", "Lcom/tencent/timi/game/userinfo/api/view/UserInfoViewWrapper;", "iUserInfoView", "Lcom/tencent/timi/game/userinfo/api/view/IUserInfoView;", "init", "initRegisterDatabaseModelClass", "onTGDestroy", "provideViews", "", "serviceDestroy", "updateAllUserInfo", "ret", "Lcom/tencent/timi/game/userinfo/impl/db/UserInfoLiveData;", "updateQQUserInfoToDB", "info", "Companion", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class UserInfoServiceImpl
  implements IUserInfoService
{
  public static final UserInfoServiceImpl.Companion a = new UserInfoServiceImpl.Companion(null);
  private static boolean b;
  
  @Nullable
  public View a(@Nullable String paramString, @Nullable Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    return null;
  }
  
  @NotNull
  public IDbLiveData<? extends IUserInfo> a(long paramLong)
  {
    return (IDbLiveData)new UserInfoLiveData(paramLong);
  }
  
  @NotNull
  public IUserInfo a(@NotNull UserProxyCmdOuterClass.QQUserInfo paramQQUserInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserInfo, "qqUserInfo");
    return (IUserInfo)new AllUserInfoModel(UserInfoUtil.a.a(paramQQUserInfo));
  }
  
  @NotNull
  public UserInfoViewWrapper a(@NotNull IUserInfoView paramIUserInfoView)
  {
    Intrinsics.checkParameterIsNotNull(paramIUserInfoView, "iUserInfoView");
    return (UserInfoViewWrapper)new UserInfoViewWrapperImpl(paramIUserInfoView);
  }
  
  @NotNull
  public List<String> a()
  {
    List localList = Arrays.asList(new String[0]);
    Intrinsics.checkExpressionValueIsNotNull(localList, "Arrays.asList()");
    return localList;
  }
  
  @NotNull
  public CommonOuterClass.QQUserId a(long paramLong1, long paramLong2)
  {
    CommonOuterClass.QQUserId localQQUserId = new CommonOuterClass.QQUserId();
    localQQUserId.uid.set(paramLong1);
    localQQUserId.user_from.set(2);
    localQQUserId.guild_id.set(paramLong2);
    return localQQUserId;
  }
  
  public void a(long paramLong, @Nullable IResultListener<IUserInfo> paramIResultListener)
  {
    UserInfoDbUtil.a.a(paramLong, (IResultListener)new UserInfoServiceImpl.getUserInfoFromDB.1(paramIResultListener));
  }
  
  public void a(@Nullable Context paramContext) {}
  
  @NotNull
  public CommonOuterClass.QQUserId b(long paramLong)
  {
    CommonOuterClass.QQUserId localQQUserId = new CommonOuterClass.QQUserId();
    localQQUserId.uid.set(paramLong);
    localQQUserId.user_from.set(1);
    return localQQUserId;
  }
  
  public void b()
  {
    YesDataBaseHelper.a((BaseTimiGameEntity)new UserInfoEntity(), (BaseTimiDatabaseTableHandler)new UserInfoTableHandler());
  }
  
  public void b(long paramLong, @Nullable IResultListener<IUserInfo> paramIResultListener)
  {
    UserInfoDbUtil.a.a(paramLong, (IResultListener)new UserInfoServiceImpl.getUserInfoFromDBOrNet.1(paramIResultListener, paramLong));
  }
  
  public void b(@NotNull UserProxyCmdOuterClass.QQUserInfo paramQQUserInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramQQUserInfo, "info");
    Object localObject = UserInfoUtil.a.a(paramQQUserInfo);
    UserInfoDbUtil.a.a((UserInfoEntity)localObject);
    localObject = paramQQUserInfo.mini_info.avatar.get();
    String str = paramQQUserInfo.mini_info.base_info.nick.get();
    paramQQUserInfo = Logger.b(paramQQUserInfo.uid.get());
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!TextUtils.isEmpty((CharSequence)str)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateQQUserInfoToDB - ");
      ((StringBuilder)localObject).append(paramQQUserInfo);
      Logger.a("UserInfoServiceImpl ", ((StringBuilder)localObject).toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateQQUserInfoToDB - avatar or nick error  ");
    localStringBuilder.append(paramQQUserInfo);
    localStringBuilder.append(',');
    localStringBuilder.append(str);
    localStringBuilder.append(',');
    localStringBuilder.append((String)localObject);
    Logger.c("UserInfoServiceImpl ", localStringBuilder.toString());
  }
  
  public void c()
  {
    UserInfoCacheManager.a.a().a();
    UserRoleInfoAutoLoader.a.a().b().clear();
    b = false;
  }
  
  public void c(long paramLong, @Nullable IResultListener<IUserInfo> paramIResultListener)
  {
    GetUserInfoRequest.a.a(paramLong, paramIResultListener);
  }
  
  public void d(long paramLong, @Nullable IResultListener<NetRspUserData> paramIResultListener)
  {
    GetUserInfoRequest.a.a(paramLong, null, paramIResultListener);
  }
  
  public void g() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.UserInfoServiceImpl
 * JD-Core Version:    0.7.0.1
 */