package com.tencent.mobileqq.dating;

import alpu;
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
    alpu localalpu = (alpu)this.this$0.app.a(35);
    Common.WifiPOIInfo localWifiPOIInfo = this.a;
    if (this.a.uint32_wifi_poi_type.get() == 1) {}
    for (;;)
    {
      localalpu.a(localWifiPOIInfo, bool, 4, NearbyTransitActivity.c(this.this$0));
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyTransitActivity.3
 * JD-Core Version:    0.7.0.1
 */