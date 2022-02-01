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
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopGiftManager;

public class NearbyGiftPanelDialog
{
  public static long a;
  private static final String jdField_a_of_type_JavaLangString = NearbyGiftPanelDialog.class.getName() + "Q.nearby.video_chat.gift";
  public static long[] a;
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TroopGiftPanel jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private boolean jdField_a_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_ArrayOfLong = new long[2];
  }
  
  public NearbyGiftPanelDialog(AppInterface paramAppInterface, Context paramContext, SessionInfo paramSessionInfo, TroopGiftPanel paramTroopGiftPanel, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = paramTroopGiftPanel;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Int = 3;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
    TroopGiftAioPanelData localTroopGiftAioPanelData = TroopGiftAioPanelData.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
    if (localTroopGiftAioPanelData != null)
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setGiftData(localTroopGiftAioPanelData, true);
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup.findViewWithTag("mTroopGiftPanel") != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel);
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(false);
    }
  }
  
  public void a(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    long l = System.currentTimeMillis();
    AIOAnimationControlManager localAIOAnimationControlManager = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    TroopGiftManager localTroopGiftManager = (TroopGiftManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.TROOP_GIFT_MANAGER);
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    if (paramBoolean) {}
    for (int i = 4;; i = 3)
    {
      localTroopGiftManager.a("OidbSvc.0x7f8", 2040, paramInt2, str, 2, i, 0, new NearbyGiftPanelDialog.1(this, localTroopGiftManager, l, localAIOAnimationControlManager, paramInt1));
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel != null)
    {
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setIsShow(true);
      Object localObject;
      if (paramBoolean1)
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b(TroopGiftPanel.e);
        localObject = TroopGiftAioPanelData.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
        if (localObject == null) {
          break label182;
        }
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setGiftData((TroopGiftAioPanelData)localObject, true);
        a(0, paramBoolean2, paramInt);
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup.findViewWithTag("mTroopGiftPanel") == null)
      {
        localObject = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(8);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel, (ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setTag("mTroopGiftPanel");
      }
    }
    if ((Build.VERSION.SDK_INT >= 23) && (this.jdField_a_of_type_AndroidContentContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {}
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new NearbyGiftPanelDialog.LocationListener(3, true, true, 60000L, true, false, "NearbyTroopsView"));
      }
      return;
      label182:
      this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d();
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gift.NearbyGiftPanelDialog
 * JD-Core Version:    0.7.0.1
 */