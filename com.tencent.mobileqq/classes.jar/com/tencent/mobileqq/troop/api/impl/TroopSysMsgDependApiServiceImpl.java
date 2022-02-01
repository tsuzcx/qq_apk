package com.tencent.mobileqq.troop.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.profile.TroopMemberCardUtils;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService.ITransitTroopProtocolOnFollowObserver;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService.ITransitTroopProtocolOnGetInfoObserver;
import com.tencent.mobileqq.troop.data.NearbyTroops;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.AnimationTextView;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class TroopSysMsgDependApiServiceImpl
  implements ITroopSysMsgDependApiService
{
  private AppRuntime app;
  
  private void prepareTroopNotifyData(long paramLong1, long paramLong2, int paramInt, AllInOne paramAllInOne)
  {
    if (paramAllInOne == null) {
      return;
    }
    String str2 = null;
    String str1;
    if (paramLong1 != 0L) {
      str1 = String.valueOf(paramLong1);
    } else {
      str1 = null;
    }
    if (paramLong2 != 0L) {
      str2 = String.valueOf(paramLong2);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("troop_uin", str1);
    localBundle.putInt("flc_notify_type", paramInt);
    if ((paramInt == 2) || (paramInt == 22)) {
      localBundle.putString("flc_recommend_uin", str2);
    }
    paramAllInOne.extras.putBundle("flc_extra_param", localBundle);
  }
  
  public void addSystemMsgSeq(String paramString, long paramLong)
  {
    AppRuntime localAppRuntime = this.app;
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)localAppRuntime).getMsgCache().e(paramString, paramLong);
    }
  }
  
  public void clearGroupSuspiciousMsg()
  {
    AppRuntime localAppRuntime = this.app;
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)localAppRuntime).clearGroupSuspiciousMsg();
    }
  }
  
  public void clearGroupSystemMsg()
  {
    AppRuntime localAppRuntime = this.app;
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)localAppRuntime).clearGroupSystemMsg();
    }
  }
  
  public void clearGroupSystemMsgHistory()
  {
    AppRuntime localAppRuntime = this.app;
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((QQAppInterface)localAppRuntime).clearGroupSystemMsgHistory();
    }
  }
  
  public void followPublicAccountReq(AppRuntime paramAppRuntime, long paramLong, ITroopSysMsgDependApiService.ITransitTroopProtocolOnFollowObserver paramITransitTroopProtocolOnFollowObserver, Bundle paramBundle)
  {
    TroopBindPubAccountProtocol.a((QQAppInterface)paramAppRuntime, paramLong, new TroopSysMsgDependApiServiceImpl.1(this, paramITransitTroopProtocolOnFollowObserver), paramBundle);
  }
  
  public TextView getAnimationTextInstance(Context paramContext)
  {
    return new AnimationTextView(paramContext);
  }
  
  public void getFriendInfo(String paramString)
  {
    AppRuntime localAppRuntime = this.app;
    if ((localAppRuntime instanceof QQAppInterface)) {
      ((FriendListHandler)((QQAppInterface)localAppRuntime).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(String.valueOf(paramString));
    }
  }
  
  public String getSubscriptName(AppRuntime paramAppRuntime, Context paramContext)
  {
    return ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName((QQAppInterface)paramAppRuntime, paramContext);
  }
  
  public long getSystemMsgSeq(String paramString)
  {
    AppRuntime localAppRuntime = this.app;
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((QQAppInterface)localAppRuntime).getMsgCache().e(paramString);
    }
    return 0L;
  }
  
  public String getTroopNickName(String paramString1, String paramString2, String paramString3, boolean paramBoolean, Bundle paramBundle)
  {
    return ContactUtils.a((AppInterface)this.app, paramString1, paramString2, paramString3, paramBoolean, paramBundle);
  }
  
  public boolean isBrowserAppInterface(AppRuntime paramAppRuntime)
  {
    return paramAppRuntime instanceof BrowserAppInterface;
  }
  
  public boolean isQQAppInterface(AppRuntime paramAppRuntime)
  {
    return paramAppRuntime instanceof QQAppInterface;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
  }
  
  public void onDestroy() {}
  
  public void openNearTroopActivity(Context paramContext, AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof AppInterface)) {
      NearbyTroops.a(paramContext, (AppInterface)paramAppRuntime);
    }
  }
  
  public void openProfileCardForTroopSysMsg(Context paramContext, String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString)) {
      paramString = new AllInOne(paramString, 1);
    }
    for (;;)
    {
      break;
      if (!paramBoolean)
      {
        if ((paramInt1 == 2) && (paramInt2 == 3))
        {
          paramString = new AllInOne(paramString, 26);
          paramString.chatAbility = 1;
        }
        else
        {
          paramString = new AllInOne(paramString, 24);
          prepareTroopNotifyData(paramLong1, paramLong2, paramInt1, paramString);
          if ((paramInt1 != 1) && (paramInt1 != 22))
          {
            if (paramInt1 != 12)
            {
              if (paramInt1 == 13) {
                paramString.subSourceId = 3;
              }
            }
            else {
              paramString.subSourceId = 2;
            }
          }
          else {
            paramString.subSourceId = 1;
          }
        }
      }
      else
      {
        paramString = new AllInOne(paramString, 24);
        prepareTroopNotifyData(paramLong1, paramLong2, paramInt1, paramString);
      }
    }
    ProfileUtils.openProfileCard(paramContext, paramString);
  }
  
  public void openTroopMemberCard(Activity paramActivity, String paramString1, String paramString2)
  {
    AppRuntime localAppRuntime = this.app;
    if ((localAppRuntime instanceof QQAppInterface)) {
      TroopMemberCardUtils.a((QQAppInterface)localAppRuntime, paramActivity, paramString1, paramString2, -1, 1);
    }
  }
  
  public void openTroopProfile(Context paramContext, Bundle paramBundle)
  {
    ((ITroopInfoActivityApi)QRoute.api(ITroopInfoActivityApi.class)).openTroopProfile(paramContext, paramBundle);
  }
  
  public void refreshConversationList()
  {
    Object localObject = this.app;
    if ((localObject instanceof QQAppInterface))
    {
      localObject = ((QQAppInterface)localObject).getHandler(Conversation.class);
      if (localObject != null) {
        ((MqqHandler)localObject).sendMessage(((MqqHandler)localObject).obtainMessage(1009));
      }
    }
  }
  
  public void requestForPubAccountInfo(AppRuntime paramAppRuntime, long paramLong, ITroopSysMsgDependApiService.ITransitTroopProtocolOnGetInfoObserver paramITransitTroopProtocolOnGetInfoObserver)
  {
    TroopBindPubAccountProtocol.a((QQAppInterface)paramAppRuntime, paramLong, new TroopSysMsgDependApiServiceImpl.2(this, paramITransitTroopProtocolOnGetInfoObserver));
  }
  
  public void showOnePicture(Activity paramActivity, String paramString)
  {
    TroopNoticeJsHandler.a(paramActivity, paramString);
  }
  
  public Intent startJoinTroop(Context paramContext, String paramString1, String paramString2, short paramShort, int paramInt, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return AddFriendLogicActivity.a(paramContext, paramString1, paramString2, paramShort, paramInt, paramString3, paramString4, paramString5, paramString6, paramString7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopSysMsgDependApiServiceImpl
 * JD-Core Version:    0.7.0.1
 */