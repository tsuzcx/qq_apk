package com.tencent.mobileqq.tribe.fragment;

import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class TribeVideoListPlayerFragment$20
  implements INetInfoHandler
{
  TribeVideoListPlayerFragment$20(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString) {}
  
  public void onNetNone2Mobile(String paramString)
  {
    TribeVideoListPlayerFragment.a.post(new TribeVideoListPlayerFragment.20.1(this));
  }
  
  public void onNetNone2Wifi(String paramString) {}
  
  public void onNetWifi2Mobile(String paramString)
  {
    TribeVideoListPlayerFragment.a.post(new TribeVideoListPlayerFragment.20.2(this));
  }
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.20
 * JD-Core Version:    0.7.0.1
 */