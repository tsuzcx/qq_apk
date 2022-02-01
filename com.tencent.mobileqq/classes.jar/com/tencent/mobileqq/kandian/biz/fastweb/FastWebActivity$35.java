package com.tencent.mobileqq.kandian.biz.fastweb;

import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebVideoPlayerManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;

class FastWebActivity$35
  implements INetInfoHandler
{
  FastWebActivity$35(FastWebActivity paramFastWebActivity) {}
  
  public void onNetMobile2None()
  {
    FastWebActivity.Z(this.a);
    ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).onNetMobile2None();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    FastWebActivity.Z(this.a);
    ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).onNetMobile2Wifi(paramString);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    FastWebActivity.Z(this.a);
    ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).onNetNone2Mobile(paramString);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    FastWebActivity.Z(this.a);
    ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).onNetNone2Wifi(paramString);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    FastWebActivity.Z(this.a);
    ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).onNetWifi2Mobile(paramString);
  }
  
  public void onNetWifi2None()
  {
    FastWebActivity.Z(this.a);
    ((IRIJFastWebVideoPlayerManager)QRoute.api(IRIJFastWebVideoPlayerManager.class)).onNetWifi2None();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.FastWebActivity.35
 * JD-Core Version:    0.7.0.1
 */