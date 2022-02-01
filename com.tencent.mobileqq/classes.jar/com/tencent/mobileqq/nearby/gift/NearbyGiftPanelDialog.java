package com.tencent.mobileqq.nearby.gift;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.troopgift.TroopGiftAioPanelData;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;
import com.tencent.mobileqq.utils.AIOAnimationControlManager;

public class NearbyGiftPanelDialog
  implements INearbyGiftPanelDialog
{
  private static final String j;
  public TroopGiftPanel c;
  public SessionInfo d;
  public AppInterface e;
  public ViewGroup f;
  public Context g;
  public boolean h;
  public int i;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NearbyGiftPanelDialog.class.getName());
    localStringBuilder.append("Q.nearby.video_chat.gift");
    j = localStringBuilder.toString();
  }
  
  public NearbyGiftPanelDialog(AppInterface paramAppInterface, Context paramContext, Object paramObject1, Object paramObject2, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.e = paramAppInterface;
    this.g = paramContext;
    this.d = ((SessionInfo)paramObject1);
    this.c = ((TroopGiftPanel)paramObject2);
    this.f = paramViewGroup;
    this.h = paramBoolean1;
    this.i = 3;
    d();
  }
  
  private void d()
  {
    this.c.a(this.e, this.d, this.h);
    this.c.setIsShow(true);
    TroopGiftAioPanelData localTroopGiftAioPanelData = TroopGiftAioPanelData.b(this.g, this.i);
    if (localTroopGiftAioPanelData != null)
    {
      this.c.setGiftData(localTroopGiftAioPanelData, true);
      return;
    }
    this.c.e();
  }
  
  public void a()
  {
    if (this.f.findViewWithTag("mTroopGiftPanel") != null)
    {
      this.f.removeView(this.c);
      this.c.setIsShow(false);
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    long l = System.currentTimeMillis();
    AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)this.e.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    TroopGiftManager localTroopGiftManager = (TroopGiftManager)this.e.getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
    String str = this.d.b;
    int k;
    if (paramBoolean) {
      k = 4;
    } else {
      k = 3;
    }
    localTroopGiftManager.a("OidbSvc.0x7f8", 2040, paramInt2, str, 2, k, 0, new NearbyGiftPanelDialog.1(this, localTroopGiftManager, l, localAIOAnimationControlManager, paramInt1));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    Object localObject = this.c;
    int k = 0;
    if (localObject != null)
    {
      ((TroopGiftPanel)localObject).setIsShow(true);
      if (paramBoolean1)
      {
        this.c.b(TroopGiftPanel.e);
        localObject = TroopGiftAioPanelData.b(this.g, this.i);
        if (localObject != null) {
          this.c.setGiftData((TroopGiftAioPanelData)localObject, true);
        } else {
          this.c.e();
        }
        a(0, paramBoolean2, paramInt);
      }
      if (this.f.findViewWithTag("mTroopGiftPanel") == null)
      {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(8);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        this.f.addView(this.c, (ViewGroup.LayoutParams)localObject);
        this.c.setTag("mTroopGiftPanel");
      }
    }
    paramInt = k;
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramInt = k;
      if (this.g.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
        paramInt = 1;
      }
    }
    if (paramInt == 0) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new LocationListener(3, true, true, 60000L, true, false, "NearbyTroopsView"));
    }
  }
  
  public boolean b()
  {
    return this.c.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gift.NearbyGiftPanelDialog
 * JD-Core Version:    0.7.0.1
 */