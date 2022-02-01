package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.content.Context;
import android.view.View;
import com.qwallet.temp.IBaseChatPieProxy;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.aio.IHongbaoPanelProvider;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService.ShowInfo;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.XPanelContainer;

public class HongbaoPanelProviderImpl
  implements PanelProvider<HongBaoPanel>, IHongbaoPanelProvider
{
  private static final String TAG = "HongbaoPanelProvider";
  private BaseQQAppInterface app;
  private IBaseChatPieProxy chatPie;
  private HongBaoPanel mHongBaoPanel;
  
  public HongBaoPanel createPanel(Context paramContext)
  {
    this.mHongBaoPanel = ((HongBaoPanel)View.inflate(paramContext, R.layout.d, null));
    this.mHongBaoPanel.a(this.app, paramContext, this.chatPie);
    initHongBaoDtReport(this.app, this.mHongBaoPanel);
    return this.mHongBaoPanel;
  }
  
  public HongBaoPanel getPanel()
  {
    return this.mHongBaoPanel;
  }
  
  public int getPanelId()
  {
    return 10;
  }
  
  public IHongbaoPanelProvider init(Object paramObject)
  {
    this.chatPie = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).createBaseChatPie(paramObject);
    this.app = this.chatPie.a();
    return this;
  }
  
  public void initHongBaoDtReport(BaseQQAppInterface paramBaseQQAppInterface, View paramView)
  {
    VideoReport.setElementId(paramView, "em_aio_red_envelope_panel");
    VideoReport.setElementExposePolicy(paramView, ExposurePolicy.REPORT_ALL);
    paramBaseQQAppInterface = ((IQWalletRedService)paramBaseQQAppInterface.getRuntimeService(IQWalletRedService.class)).getShowInfo("2001");
    int i;
    if ((paramBaseQQAppInterface != null) && (paramBaseQQAppInterface.a)) {
      i = 1;
    } else {
      i = 0;
    }
    VideoReport.setElementParam(paramView, "is_red_tips_before", Integer.valueOf(i));
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 10)
    {
      HongBaoPanel localHongBaoPanel = this.mHongBaoPanel;
      if (localHongBaoPanel != null)
      {
        try
        {
          localHongBaoPanel.b();
          this.mHongBaoPanel.d();
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        this.mHongBaoPanel.e();
      }
    }
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    paramXPanelContainer.a(10);
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.aio.impl.HongbaoPanelProviderImpl
 * JD-Core Version:    0.7.0.1
 */