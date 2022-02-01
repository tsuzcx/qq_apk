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
  implements INearbyGiftPanelDialog
{
  private static final String a;
  public int a;
  public Context a;
  public ViewGroup a;
  public TroopGiftPanel a;
  public AppInterface a;
  public SessionInfo a;
  public boolean a;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(NearbyGiftPanelDialog.class.getName());
    localStringBuilder.append("Q.nearby.video_chat.gift");
    jdField_a_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public NearbyGiftPanelDialog(AppInterface paramAppInterface, Context paramContext, Object paramObject1, Object paramObject2, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = ((SessionInfo)paramObject1);
    this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel = ((TroopGiftPanel)paramObject2);
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
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 3;
    }
    localTroopGiftManager.a("OidbSvc.0x7f8", 2040, paramInt2, str, 2, i, 0, new NearbyGiftPanelDialog.1(this, localTroopGiftManager, l, localAIOAnimationControlManager, paramInt1));
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel;
    int i = 0;
    if (localObject != null)
    {
      ((TroopGiftPanel)localObject).setIsShow(true);
      if (paramBoolean1)
      {
        this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.b(TroopGiftPanel.e);
        localObject = TroopGiftAioPanelData.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int);
        if (localObject != null) {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.setGiftData((TroopGiftAioPanelData)localObject, true);
        } else {
          this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.d();
        }
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
    paramInt = i;
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramInt = i;
      if (this.jdField_a_of_type_AndroidContentContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) {
        paramInt = 1;
      }
    }
    if (paramInt == 0) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new LocationListener(3, true, true, 60000L, true, false, "NearbyTroopsView"));
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizTroopgiftTroopGiftPanel.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gift.NearbyGiftPanelDialog
 * JD-Core Version:    0.7.0.1
 */