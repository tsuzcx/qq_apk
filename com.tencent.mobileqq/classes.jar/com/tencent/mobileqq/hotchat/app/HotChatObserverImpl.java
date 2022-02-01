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
      NearbyUtils.a(this.a.c, new Object[] { "onPushExitHotChat", paramString, paramHotChatStateWrapper });
    }
    if (!Utils.a(this.a.ah.b, paramString)) {
      return;
    }
    int i = paramHotChatStateWrapper.targetState;
    paramString = (IHotChatApi)QRoute.api(IHotChatApi.class);
    paramString.delHotChatRecentUserNotNotifyUi(this.a.d, this.a.ah.b, i);
    paramString.invokeRecentUserChangedToConversation(this.a.d);
  }
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = this.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TroopChatPie.onExitHotChat  troopUin=");
      localStringBuilder.append(paramString1);
      QLog.i(paramString2, 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (this.a.ah.b.equals(paramString1)))
    {
      if (this.a.aX().getIntent().getBooleanExtra("is_from_web", false)) {
        this.a.aX().sendBroadcast(new Intent("com.tencent.mobileqq.refresh_hot_chat_list"));
      }
      paramString1 = (IHotChatApi)QRoute.api(IHotChatApi.class);
      paramString1.delHotChatRecentUserNotNotifyUi(this.a.d, this.a.ah.b, 4);
      paramString1.invokeRecentUserChangedToConversation(this.a.d);
      paramString1 = this.a.bQ.c(this.a.ah.b);
      this.a.bQ.a(paramString1, HotChatManager.HotChatStateWrapper.STATE_LEFT_NORMAL_ACTION_DELETE_SHELL);
      this.a.f(1);
    }
  }
  
  public void a(boolean paramBoolean, HotChatInfo paramHotChatInfo, Common.WifiPOIInfo paramWifiPOIInfo, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      NearbyUtils.a(this.a.c, new Object[] { "onQuickJoinHotChat", Boolean.valueOf(paramBoolean), paramString, paramHotChatInfo });
    }
    if (!paramBoolean)
    {
      if ((Utils.a(this.a.bS, paramString)) || ((this.a.bR != null) && (Utils.a(this.a.bR.uuid, paramString))))
      {
        paramHotChatInfo = ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).getJoinHotChatFailTip(paramInt);
        QQToast.makeText(this.a.f, 1, paramHotChatInfo, 1).show();
      }
      return;
    }
    if ((Utils.a(this.a.bS, paramString)) && (paramHotChatInfo != null) && (!Utils.a(paramHotChatInfo.troopUin, this.a.ah.b)))
    {
      if (QLog.isColorLevel()) {
        NearbyUtils.a(this.a.c, new Object[] { "onQuickJoinHotChat_not_same_aio", String.format("uuid:%s, new:%s, old:%s", new Object[] { paramString, paramHotChatInfo.troopUin, this.a.ah.b }) });
      }
      MediaPlayerManager.a(this.a.d).a(false);
      paramWifiPOIInfo = new Intent(this.a.f, SplashActivity.class);
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
      this.a.f.startActivity(paramHotChatInfo);
      if ((this.a.f instanceof ChatActivity)) {
        this.a.f.finish();
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0))
    {
      paramString = this.a.d.getHotChatMng(true);
      HotChatPie localHotChatPie = this.a;
      localHotChatPie.bR = paramString.c(localHotChatPie.ah.b);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, Long paramLong)
  {
    if (QLog.isColorLevel())
    {
      String str = this.a.c;
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
    if (this.a.bU != null) {
      this.a.bU.startCheck(l1);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.a.a(paramBoolean, paramString1, paramInt, paramString2, paramString3, "Q.hotchat.hotchat_kick_mem_by_admin");
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) && (paramString1 != null) && (paramString1.equals(this.a.ah.b)))
    {
      if (!TextUtils.isEmpty(paramString2))
      {
        ((HotGiftPanelHelper)this.a.q(136)).h.a(paramString2, paramString2);
        return;
      }
      paramString2 = this.a.ah.b;
      if ((this.a.bR != null) && (this.a.bR.isBuLuoHotChat())) {
        paramString1 = "507";
      } else {
        paramString1 = "503";
      }
      NearbyFlowerManager.a("gift_store", "cancel_list", paramString2, paramString1, "", "");
      return;
    }
    paramString2 = this.a.ah.b;
    if ((this.a.bR != null) && (this.a.bR.isBuLuoHotChat())) {
      paramString1 = "507";
    } else {
      paramString1 = "503";
    }
    NearbyFlowerManager.a("gift_store", "cancel_list", paramString2, paramString1, "", "");
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    if ((paramBoolean) && (paramString1 != null) && (paramString1.equals(this.a.ah.b))) {
      this.a.a(paramString2, paramString3, true, 4);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, int paramInt, String paramString2, String paramString3, List<Long> paramList)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = this.a.c;
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
    if (this.a.bU != null) {
      this.a.bU.startCheck(l1);
    }
  }
  
  public void b(boolean paramBoolean, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.a.a(paramBoolean, paramString1, paramInt, paramString2, paramString3, "Q.hotchat.hotchat_kick_mem_by_global_admin");
  }
  
  public void b(boolean paramBoolean, String paramString1, String paramString2)
  {
    ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).openHotChatMemberProfileCard(this.a.aX(), this.a.d, paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.app.HotChatObserverImpl
 * JD-Core Version:    0.7.0.1
 */