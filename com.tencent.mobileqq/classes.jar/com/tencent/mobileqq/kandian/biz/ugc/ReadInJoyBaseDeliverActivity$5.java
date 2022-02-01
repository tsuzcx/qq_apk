package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticonview.IEmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.api.IAIOEmoticonPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelService.PanelBuilder;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;
import com.tencent.mobileqq.kandian.biz.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.widget.XPanelContainer;
import com.tencent.widget.XPanelContainer.PanelCallback;

class ReadInJoyBaseDeliverActivity$5
  implements XPanelContainer.PanelCallback
{
  ReadInJoyBaseDeliverActivity$5(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 24) && (ReadInJoyBaseDeliverActivity.b(this.a) != null))
    {
      boolean bool;
      if (paramInt2 == 1) {
        bool = true;
      } else {
        bool = false;
      }
      ReadInJoyBaseDeliverActivity.b(this.a).a(bool);
    }
    else if ((paramInt2 == 24) && (ReadInJoyBaseDeliverActivity.b(this.a) != null))
    {
      ReadInJoyBaseDeliverActivity.b(this.a).g();
    }
    if (paramInt2 == 1)
    {
      this.a.d(1);
      return;
    }
    if (paramInt2 == 3)
    {
      ((IAIOEmoticonPanelService)QRoute.api(IAIOEmoticonPanelService.class)).setOpenStartTime(System.currentTimeMillis());
      StartupTracker.a(null, "AIO_EmoticonPanel_OpenDuration");
      this.a.d(2);
      return;
    }
    if (paramInt2 == 0)
    {
      this.a.d(0);
      return;
    }
    if (paramInt2 == 24) {
      this.a.d(3);
    }
  }
  
  public View b(int paramInt)
  {
    Object localObject;
    if (paramInt == 3)
    {
      if (ReadInJoyBaseDeliverActivity.c(this.a) == null)
      {
        localObject = this.a;
        ReadInJoyBaseDeliverActivity.a((ReadInJoyBaseDeliverActivity)localObject, ((IEmoticonMainPanelService)((ReadInJoyBaseDeliverActivity)localObject).app.getRuntimeService(IEmoticonMainPanelService.class)).newBuilder(this.a, 99999).setCallBack(ReadInJoyBaseDeliverActivity.d(this.a)).setOnlySysAndEmoji(true).setKanDianBiu(this.a instanceof ReadInJoyDeliverBiuActivity).setToastOffset(this.a.getTitleBarHeight()).create());
        ReadInJoyBaseDeliverActivity.c(this.a).hideAllTabs();
      }
      return ReadInJoyBaseDeliverActivity.c(this.a).getView();
    }
    if (paramInt == 24)
    {
      if (ReadInJoyBaseDeliverActivity.b(this.a) == null)
      {
        localObject = this.a;
        ReadInJoyBaseDeliverActivity.a((ReadInJoyBaseDeliverActivity)localObject, (PublicAccountHotPicPanel)View.inflate((Context)localObject, 2131625633, null));
        localObject = ReadInJoyBaseDeliverActivity.b(this.a);
        QQAppInterface localQQAppInterface = this.a.app;
        ReadInJoyBaseDeliverActivity localReadInJoyBaseDeliverActivity = this.a;
        ((PublicAccountHotPicPanel)localObject).a(localQQAppInterface, localReadInJoyBaseDeliverActivity, null, localReadInJoyBaseDeliverActivity.j);
        ReadInJoyBaseDeliverActivity.b(this.a).setPublicAccountGifListener(ReadInJoyBaseDeliverActivity.e(this.a));
      }
      return ReadInJoyBaseDeliverActivity.b(this.a);
    }
    return null;
  }
  
  public boolean c(int paramInt)
  {
    return false;
  }
  
  public void v()
  {
    ((IAIOEmoticonPanelService)QRoute.api(IAIOEmoticonPanelService.class)).removeStickerMask(this.a.j.getCurrentPanelView());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.ReadInJoyBaseDeliverActivity.5
 * JD-Core Version:    0.7.0.1
 */