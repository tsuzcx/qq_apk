package com.tencent.mobileqq.qwallet.hb.aio.impl;

import com.qwallet.temp.IBaseChatPieProxy;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.IHongBaoPanelHelper;
import com.tencent.mobileqq.qwallet.hb.aio.elem.ICustomizeStrategyFactory;

public class HongBaoPanelHelperImpl
  implements IHongBaoPanelHelper
{
  private static final String TAG = "HongbaoPanelHelper";
  private IBaseChatPieProxy chatPie;
  private PanelManager panelManager;
  
  private HongBaoPanel getPanel()
  {
    if (this.panelManager == null) {
      this.panelManager = this.chatPie.a();
    }
    return (HongBaoPanel)this.panelManager.b(10);
  }
  
  private void onDestroy()
  {
    ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(false);
    HongBaoPanel localHongBaoPanel = getPanel();
    if (localHongBaoPanel != null) {
      localHongBaoPanel.c();
    }
  }
  
  private void onShowFirst()
  {
    ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getCustomizeStrategyFactory().a(true);
  }
  
  public String getTag()
  {
    return "HongbaoPanelHelper";
  }
  
  public IHongBaoPanelHelper init(Object paramObject)
  {
    this.chatPie = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).createBaseChatPie(paramObject);
    return this;
  }
  
  public int[] interestedIn()
  {
    return new int[] { 9, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 9)
    {
      if (paramInt != 15) {
        return;
      }
      onDestroy();
      return;
    }
    onShowFirst();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.HongBaoPanelHelperImpl
 * JD-Core Version:    0.7.0.1
 */