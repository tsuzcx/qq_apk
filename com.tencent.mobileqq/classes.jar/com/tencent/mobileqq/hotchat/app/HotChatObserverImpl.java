package com.tencent.mobileqq.hotchat.app;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.helper.HotGiftPanelHelper;
import com.tencent.mobileqq.activity.aio.rebuild.HotChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.NearbyFlowerManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatSCHelper;
import com.tencent.mobileqq.nearby.NearbyUtils;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.nearby.gift.ITroopGiftPanelForNearby;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public class HotChatObserverImpl
  extends HotChatObserver
{
  private final HotChatPie a;
  
  public HotChatObserverImpl(HotChatPie paramHotChatPie)
  {
    this.a = paramHotChatPie;
  }
  
  public void a(String paramString, HotChatManager.HotChatStateWrapper paramHotChatStateWrapper)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a(this.a.b, new Object[] { "onPushExitHotChat", paramString, paramHotChatStateWrapper });
    }
    if (!Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, paramString)) {
      return;
    }
    int i = paramHotChatStateWrapper.targetState;
    paramString = (IHotChatApi)QRoute.api(IHotChatApi.class);
    paramString.delHotChatRecentUserNotNotifyUi(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, i);
    paramString.invokeRecentUserChangedToConversation(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = this.a.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TroopChatPie.onExitHotChat  troopUin=");
      localStringBuilder.append(paramString1);
      QLog.i(paramString2, 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a.equals(paramString1)))
    {
      if (this.a.a().getIntent().getBooleanExtra("is_from_web", false)) {
        this.a.a().sendBroadcast(new Intent("com.tencent.mobileqq.refresh_hot_chat_list"));
      }
      paramString1 = (IHotChatApi)QRoute.api(IHotChatApi.class);
      paramString1.delHotChatRecentUserNotNotifyUi(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, 4);
      paramString1.invokeRecentUserChangedToConversation(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      paramString1 = this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
      this.a.jdField_a_of_type_ComTencentMobileqqAppHotChatManager.a(paramString1, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL_ACTION_DELETE_SHELL);
      this.a.b(1);
    }
  }
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a(this.a.b, new Object[] { "onQuickJoinHotChat", Boolean.valueOf(paramBoolean), paramString, paramHotChatInfo });
    }
    if (!paramBoolean)
    {
      if ((Utils.a(this.a.e, paramString)) || ((this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.uuid, paramString))))
      {
        paramHotChatInfo = ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).getJoinHotChatFailTip(paramInt);
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, paramHotChatInfo, 1).a();
      }
      return;
    }
    if ((Utils.a(this.a.e, paramString)) && (paramHotChatInfo != null) && (!Utils.a(paramHotChatInfo.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a(this.a.b, new Object[] { "onQuickJoinHotChat_not_same_aio", String.format("uuid:%s, new:%s, old:%s", new Object[] { paramString, paramHotChatInfo.troopUin, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a }) });
      }
      MediaPlayerManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(false);
      paramWifiPOIInfo = new Intent(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, SplashActivity.class);
      paramWifiPOIInfo.putExtra("uin", paramHotChatInfo.troopUin);
      paramWifiPOIInfo.putExtra("uintype", 1);
      paramWifiPOIInfo.putExtra("troop_uin", paramHotChatInfo.troopCode);
      paramWifiPOIInfo.putExtra("uinname", paramHotChatInfo.name);
      paramWifiPOIInfo.addFlags(67108864);
      paramWifiPOIInfo.putExtra("hotnamecode", paramHotChatInfo.uuid);
      if (paramHotChatInfo.supportDemo) {
        paramInt = 2;
      } else {
        paramInt = 0;
      }
      paramWifiPOIInfo.putExtra("HOTCHAT_EXTRA_FLAG", paramInt);
      paramHotChatInfo = AIOUtils.a(paramWifiPOIInfo, new int[] { 2 });
      paramHotChatInfo.setAction("com.tencent.mobileqq.action.MAINACTIVITY");
      this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity(paramHotChatInfo);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof ChatActivity)) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.finish();
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0))
    {
      paramString = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHotChatMng(true);
      HotChatPie localHotChatPie = this.a;
      localHotChatPie.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo = paramString.a(localHotChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, Long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetUserCreateHotChatAnnounce  isSuccess= ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", result=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", memo=");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", troopOwner=");
      localStringBuilder.append(paramLong);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    long l2 = 100L;
    long l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (paramInt == 0)
      {
        l1 = l2;
        if (this.a.a(paramString1, paramString2, null)) {
          l1 = 30000L;
        }
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatSCHelper != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatSCHelper.startCheck(l1);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.a.a(paramBoolean, paramString1, paramInt, paramString2, paramString3, "Q.hotchat.hotchat_kick_mem_by_admin");
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (paramString1 != null) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        ((HotGiftPanelHelper)this.a.a(136)).a.a(paramString2, paramString2);
        return;
      }
      paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {
        paramString1 = "507";
      } else {
        paramString1 = "503";
      }
      NearbyFlowerManager.a("gift_store", "cancel_list", paramString2, paramString1, "", "");
      return;
    }
    paramString2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a;
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.isBuLuoHotChat())) {
      paramString1 = "507";
    } else {
      paramString1 = "503";
    }
    NearbyFlowerManager.a("gift_store", "cancel_list", paramString2, paramString1, "", "");
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if ((paramBoolean) && (paramString1 != null) && (paramString1.equals(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a))) {
      this.a.a(paramString2, paramString3, true, 4);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, List<Long> paramList)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = this.a.b;
      paramList = new StringBuilder();
      paramList.append("onGetHotChatAnnounce  isSuccess= ");
      paramList.append(paramBoolean);
      paramList.append(", result=");
      paramList.append(paramInt);
      paramList.append(", memo=");
      paramList.append(paramString2);
      paramList.append(", jumpurl=");
      paramList.append(paramString3);
      QLog.d(paramArrayOfByte, 2, paramList.toString());
    }
    long l2 = 100L;
    long l1 = l2;
    if (paramBoolean)
    {
      l1 = l2;
      if (paramInt == 0)
      {
        l1 = l2;
        if (this.a.a(paramString1, paramString2, paramString3)) {
          l1 = 30000L;
        }
      }
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatSCHelper != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqHotchatApiIHotChatSCHelper.startCheck(l1);
    }
  }
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.a.a(paramBoolean, paramString1, paramInt, paramString2, paramString3, "Q.hotchat.hotchat_kick_mem_by_global_admin");
  }
  
  public void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).openHotChatMemberProfileCard(this.a.a(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.app.HotChatObserverImpl
 * JD-Core Version:    0.7.0.1
 */