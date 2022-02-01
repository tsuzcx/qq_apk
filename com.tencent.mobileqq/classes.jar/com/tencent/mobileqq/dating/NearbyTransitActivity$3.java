package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

class NearbyTransitActivity$3
  implements Runnable
{
  NearbyTransitActivity$3(NearbyTransitActivity paramNearbyTransitActivity, Common.WifiPOIInfo paramWifiPOIInfo) {}
  
  public void run()
  {
    IHotChatHandler localIHotChatHandler = (IHotChatHandler)this.this$0.app.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
    Common.WifiPOIInfo localWifiPOIInfo = this.a;
    int i = localWifiPOIInfo.uint32_wifi_poi_type.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    localIHotChatHandler.joinHotChat(localWifiPOIInfo, bool, 4, NearbyTransitActivity.g(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.NearbyTransitActivity.3
 * JD-Core Version:    0.7.0.1
 */