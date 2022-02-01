package com.tencent.mobileqq.dating;

import anwd;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

class NearbyTransitActivity$3
  implements Runnable
{
  NearbyTransitActivity$3(NearbyTransitActivity paramNearbyTransitActivity, Common.WifiPOIInfo paramWifiPOIInfo) {}
  
  public void run()
  {
    boolean bool = true;
    anwd localanwd = (anwd)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.HOT_CHAT_HANDLER);
    Common.WifiPOIInfo localWifiPOIInfo = this.a;
    if (this.a.uint32_wifi_poi_type.get() == 1) {}
    for (;;)
    {
      localanwd.a(localWifiPOIInfo, bool, 4, NearbyTransitActivity.c(this.this$0));
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyTransitActivity.3
 * JD-Core Version:    0.7.0.1
 */