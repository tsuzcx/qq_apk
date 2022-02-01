package com.tencent.mobileqq.kandian.ad.api.impl;

import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.FastWebVideoPlayManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebVideoPlayerManager;

public class RIJFastWebVideoPlayerManagerImpl
  implements IRIJFastWebVideoPlayerManager
{
  public void onCreate()
  {
    FastWebVideoPlayManager.a.a();
  }
  
  public void onDestroy()
  {
    FastWebVideoPlayManager.a.d();
  }
  
  public void onNetMobile2None()
  {
    FastWebVideoPlayManager.a.onNetMobile2None();
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    FastWebVideoPlayManager.a.onNetMobile2Wifi(paramString);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    FastWebVideoPlayManager.a.onNetNone2Mobile(paramString);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    FastWebVideoPlayManager.a.onNetNone2Wifi(paramString);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    FastWebVideoPlayManager.a.onNetWifi2Mobile(paramString);
  }
  
  public void onNetWifi2None()
  {
    FastWebVideoPlayManager.a.onNetWifi2None();
  }
  
  public void onPause()
  {
    FastWebVideoPlayManager.a.c();
  }
  
  public void onResume()
  {
    FastWebVideoPlayManager.a.b();
  }
  
  public void onStart() {}
  
  public void onStop() {}
  
  public void setVideoPauseType(ReportConstants.VideoEndType paramVideoEndType)
  {
    FastWebVideoPlayManager.a.a(paramVideoEndType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJFastWebVideoPlayerManagerImpl
 * JD-Core Version:    0.7.0.1
 */