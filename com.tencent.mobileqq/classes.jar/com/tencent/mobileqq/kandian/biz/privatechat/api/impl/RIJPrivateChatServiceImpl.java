package com.tencent.mobileqq.kandian.biz.privatechat.api.impl;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.data.RecentItemRIJPrivateItemData;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.privatechat.RIJPrivateChatListFragment;
import com.tencent.mobileqq.kandian.biz.privatechat.api.IRIJPrivateChatService;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/privatechat/api/impl/RIJPrivateChatServiceImpl;", "Lcom/tencent/mobileqq/kandian/biz/privatechat/api/IRIJPrivateChatService;", "()V", "clearPrivateChatRedCount", "", "getAppRunTime", "Lmqq/app/AppRuntime;", "getConversationFacade", "Lcom/tencent/mobileqq/msg/api/IConversationFacade;", "getPrivateChatRedCount", "", "getRecentDataList", "", "Lcom/tencent/mobileqq/activity/recent/data/RecentItemRIJPrivateItemData;", "refreshUserCallBack", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyUserInfoModule$RefreshUserInfoCallBack;", "getTotalRedCount", "redPntInfo", "Lcom/tencent/mobileqq/kandian/repo/reddot/KandianMsgBoxRedPntInfo;", "isFriend", "", "uin", "", "isKanDianPrivateChat", "type", "isKanDianPrivateChatMsg", "messageRecord", "Lcom/tencent/mobileqq/data/MessageRecord;", "jumpKanDianProfilePage", "context", "Landroid/content/Context;", "onCreate", "appRuntime", "onDestroy", "openAIOIntent", "uinName", "openPrivateChatList", "updateRecentDataIsTop", "flag", "(Ljava/lang/String;Ljava/lang/Integer;Z)V", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJPrivateChatServiceImpl
  implements IRIJPrivateChatService
{
  public static final RIJPrivateChatServiceImpl.Companion Companion = new RIJPrivateChatServiceImpl.Companion(null);
  @NotNull
  private static final Lazy INSTANCE$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)RIJPrivateChatServiceImpl.Companion.INSTANCE.2.INSTANCE);
  
  private final AppRuntime getAppRunTime()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    Intrinsics.checkExpressionValueIsNotNull(localAppRuntime, "MobileQQ.sMobileQQ.waitAppRuntime(null)");
    return localAppRuntime;
  }
  
  public void clearPrivateChatRedCount()
  {
    IConversationFacade localIConversationFacade = getConversationFacade();
    Iterator localIterator = getRecentDataList(null).iterator();
    while (localIterator.hasNext())
    {
      RecentItemRIJPrivateItemData localRecentItemRIJPrivateItemData = (RecentItemRIJPrivateItemData)localIterator.next();
      long l = localIConversationFacade.getLastRead(localRecentItemRIJPrivateItemData.getRecentUserUin(), localRecentItemRIJPrivateItemData.getRecentUserType());
      localIConversationFacade.cleanUnread(localRecentItemRIJPrivateItemData.getRecentUserUin(), localRecentItemRIJPrivateItemData.getRecentUserType(), l, false);
    }
  }
  
  @NotNull
  public IConversationFacade getConversationFacade()
  {
    IRuntimeService localIRuntimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IConversationFacade.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "appRuntime.getRuntimeSer…va, ProcessConstant.MAIN)");
    return (IConversationFacade)localIRuntimeService;
  }
  
  public int getPrivateChatRedCount()
  {
    IConversationFacade localIConversationFacade = getConversationFacade();
    Iterator localIterator = getRecentDataList(null).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      RecentItemRIJPrivateItemData localRecentItemRIJPrivateItemData = (RecentItemRIJPrivateItemData)localIterator.next();
      i += localIConversationFacade.getUnreadCount(localRecentItemRIJPrivateItemData.getRecentUserUin(), localRecentItemRIJPrivateItemData.getRecentUserType());
    }
    return i;
  }
  
  @NotNull
  public final List<RecentItemRIJPrivateItemData> getRecentDataList(@Nullable IReadInJoyUserInfoModule.RefreshUserInfoCallBack paramRefreshUserInfoCallBack)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = getAppRunTime().getRuntimeService(IRecentUserProxyService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "getAppRunTime().getRunti…va, ProcessConstant.MAIN)");
    localObject1 = ((IRecentUserProxyService)localObject1).getRecentUserCache();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "getAppRunTime().getRunti…ant.MAIN).recentUserCache");
    int i = 0;
    localObject1 = ((RecentUserProxy)localObject1).a(true, false);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "inList");
    int j = ((Collection)localObject1).size();
    while (i < j)
    {
      Object localObject2 = (RecentUser)((List)localObject1).get(i);
      if (((RecentUser)localObject2).getType() == 10013)
      {
        localObject2 = new RecentItemRIJPrivateItemData((RecentUser)localObject2, paramRefreshUserInfoCallBack);
        Object localObject3 = getAppRunTime();
        if (localObject3 != null)
        {
          localObject3 = (BaseQQAppInterface)localObject3;
          MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
          Intrinsics.checkExpressionValueIsNotNull(localMobileQQ, "MobileQQ.sMobileQQ");
          ((RecentItemRIJPrivateItemData)localObject2).update((BaseQQAppInterface)localObject3, localMobileQQ.getApplicationContext());
          localArrayList.add(localObject2);
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.business.BaseQQAppInterface");
        }
      }
      i += 1;
    }
    return (List)localArrayList;
  }
  
  public final int getTotalRedCount(@NotNull KandianMsgBoxRedPntInfo paramKandianMsgBoxRedPntInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramKandianMsgBoxRedPntInfo, "redPntInfo");
    int i = paramKandianMsgBoxRedPntInfo.getMsgCnt() + getPrivateChatRedCount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[getTotalRedCount] mMsgCnt = ");
    localStringBuilder.append(paramKandianMsgBoxRedPntInfo.getMsgCnt());
    localStringBuilder.append(", totalRedCount = ");
    localStringBuilder.append(i);
    QLog.i("KandianMsgBoxRedPntInfoUtils", 1, localStringBuilder.toString());
    return i;
  }
  
  public final boolean isFriend(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    IRuntimeService localIRuntimeService = getAppRunTime().getRuntimeService(IFriendDataService.class, "");
    Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "getAppRunTime().getRunti…    ProcessConstant.MAIN)");
    return ((IFriendDataService)localIRuntimeService).isFriend(paramString);
  }
  
  public final boolean isKanDianPrivateChat(int paramInt)
  {
    return paramInt == 10013;
  }
  
  public boolean isKanDianPrivateChatMsg(@Nullable MessageRecord paramMessageRecord)
  {
    boolean bool = false;
    if (paramMessageRecord == null) {
      return false;
    }
    if (paramMessageRecord.istroop == 10013) {
      bool = true;
    }
    return bool;
  }
  
  public void jumpKanDianProfilePage(@Nullable Context paramContext, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(ReadInJoyConstants.h);
    if (paramString != null)
    {
      Charset localCharset = Charsets.UTF_8;
      if (paramString != null)
      {
        paramString = paramString.getBytes(localCharset);
        Intrinsics.checkExpressionValueIsNotNull(paramString, "(this as java.lang.String).getBytes(charset)");
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
    }
    else
    {
      paramString = null;
    }
    localStringBuilder.append(Base64Util.encodeToString(paramString, 2));
    ReadInJoyUtils.a(paramContext, localStringBuilder.toString());
  }
  
  public void onCreate(@NotNull AppRuntime paramAppRuntime)
  {
    Intrinsics.checkParameterIsNotNull(paramAppRuntime, "appRuntime");
  }
  
  public void onDestroy() {}
  
  public void openAIOIntent(@Nullable Context paramContext, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uin");
    Intrinsics.checkParameterIsNotNull(paramString2, "uinName");
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = (Context)QBaseActivity.sTopActivity;
    }
    if (localContext == null) {
      return;
    }
    paramContext = new Intent();
    paramContext.putExtra("open_chatfragment_withanim", true);
    paramContext.putExtra("uin", paramString1);
    paramContext.setClassName(localContext, ChatActivity.class.getName());
    if (isFriend(paramString1))
    {
      paramContext.putExtra("uintype", 0);
    }
    else
    {
      paramContext.putExtra("uintype", 10013);
      paramContext.putExtra("uinname", paramString2);
    }
    localContext.startActivity(paramContext);
  }
  
  public final void openPrivateChatList()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.context;
    Intent localIntent = new Intent();
    localIntent.setFlags(268435456);
    PublicFragmentActivity.a((Context)localBaseApplication, localIntent, RIJPrivateChatListFragment.class);
  }
  
  public final void updateRecentDataIsTop(@Nullable String paramString, @Nullable Integer paramInteger, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      if (paramInteger == null) {
        return;
      }
      Object localObject = getAppRunTime().getRuntimeService(IRecentUserProxyService.class, "");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "getAppRunTime().getRunti…va, ProcessConstant.MAIN)");
      localObject = ((IRecentUserProxyService)localObject).getRecentUserCache();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "getAppRunTime().getRunti…ant.MAIN).recentUserCache");
      paramString = ((RecentUserProxy)localObject).b(paramString, paramInteger.intValue());
      if (paramString != null)
      {
        long l;
        if (paramBoolean) {
          l = NetConnInfoCenter.getServerTime();
        } else {
          l = 0L;
        }
        paramString.showUpTime = l;
      }
      ((RecentUserProxy)localObject).b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl
 * JD-Core Version:    0.7.0.1
 */