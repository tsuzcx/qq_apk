package com.tencent.mobileqq.nearby.gift;

import android.content.Context;
import com.tencent.biz.troopgift.TroopGiftAioItemData;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.biz.troopgift.TroopGiftPanel.OnGetGiveGiftCallback;
import com.tencent.biz.troopgift.TroopGiftPanel.OnShowOrHideListerner;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import java.lang.ref.WeakReference;

public class TroopGiftPanelForNearby
  extends TroopGiftPanel
  implements ITroopGiftPanelForNearby
{
  protected WeakReference<QQAppInterface> ab = null;
  protected boolean ac = false;
  protected boolean ad = false;
  
  public TroopGiftPanelForNearby(QQAppInterface paramQQAppInterface, Context paramContext, TroopGiftPanel.OnShowOrHideListerner paramOnShowOrHideListerner, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, BaseChatPie paramBaseChatPie)
  {
    super(paramContext, paramOnShowOrHideListerner, false);
    this.ab = new WeakReference(paramQQAppInterface);
    this.h = "OidbSvc.0x7f8";
    this.i = 2040;
    this.ac = paramBoolean1;
    this.ad = paramBoolean3;
    this.j = true;
    this.C = new WeakReference(paramBaseChatPie);
    if (paramBoolean3) {
      this.V = 8;
    } else if (this.ac) {
      this.V = 6;
    } else if (paramBoolean2) {
      this.V = 5;
    } else {
      this.V = 4;
    }
    setBackgroundColor(-1);
  }
  
  public void a(Object paramObject)
  {
    super.a((TroopGiftPanel.OnGetGiveGiftCallback)paramObject);
  }
  
  public void d(String paramString)
  {
    Object localObject = (AppInterface)this.l.get();
    if (localObject == null) {
      return;
    }
    localObject = (TroopGiftManager)((AppInterface)localObject).getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
    TroopGiftAioItemData localTroopGiftAioItemData = this.A;
    int j = localTroopGiftAioItemData.e;
    if (localTroopGiftAioItemData.e == 0) {
      j = getGiftNum();
    }
    int i;
    if (this.ac) {
      i = 4;
    } else {
      i = 2;
    }
    if (this.ad) {
      i = 5;
    }
    int m = this.V;
    String str = getTroopUin();
    long l = Long.parseLong(paramString);
    int n = localTroopGiftAioItemData.f;
    int k;
    if (localTroopGiftAioItemData.e == 0) {
      k = 1;
    } else {
      k = 0;
    }
    ((TroopGiftManager)localObject).a("OidbSvc.0x7f6", 2038, i, m, str, 2, j, l, n, k, localTroopGiftAioItemData.d, 0, new TroopGiftPanelForNearby.1(this), localTroopGiftAioItemData.i);
    this.A.k = false;
    this.A = null;
  }
  
  protected void f()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.ab.get();
    if (localQQAppInterface == null) {
      return;
    }
    Object localObject = (HotChatManager)localQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    if (localObject != null) {
      localObject = ((HotChatManager)localObject).c(this.n.b);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).startTroopMemberChooseForFlowerActivity(localObject, localQQAppInterface, getActivity(), 0);
    } else {
      d(this.n.b);
    }
    if (this.G != null) {
      this.G.b();
    }
  }
  
  public void setIsPttRoom(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.V = 5;
      return;
    }
    this.V = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gift.TroopGiftPanelForNearby
 * JD-Core Version:    0.7.0.1
 */