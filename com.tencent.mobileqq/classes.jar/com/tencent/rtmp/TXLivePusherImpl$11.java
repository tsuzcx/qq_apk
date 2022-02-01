package com.tencent.rtmp;

import com.tencent.liteav.device.TXDeviceManager.TXSystemVolumeType;
import com.tencent.liteav.device.TXDeviceManagerImpl.TXDeviceManagerListener;

class TXLivePusherImpl$11
  implements TXDeviceManagerImpl.TXDeviceManagerListener
{
  TXLivePusherImpl$11(TXLivePusherImpl paramTXLivePusherImpl) {}
  
  public void onSwitchAutoFocus(boolean paramBoolean)
  {
    TXLivePusherImpl.c(this.a).L = (paramBoolean ^ true);
    TXLivePusherImpl.d(this.a).mTouchFocus = (paramBoolean ^ true);
  }
  
  public void onSwitchCamera(boolean paramBoolean)
  {
    TXLivePusherImpl.c(this.a).n = paramBoolean;
    TXLivePusherImpl.d(this.a).mFrontCamera = paramBoolean;
  }
  
  public void onSwitchSystemVolumeType(TXDeviceManager.TXSystemVolumeType paramTXSystemVolumeType)
  {
    int i = TXLivePusherImpl.9.a[paramTXSystemVolumeType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        TXLivePusherImpl.c(this.a).y = 1;
        TXLivePusherImpl.d(this.a).mVolumeType = 1;
        return;
      }
      TXLivePusherImpl.c(this.a).y = 2;
      TXLivePusherImpl.d(this.a).mVolumeType = 2;
      return;
    }
    TXLivePusherImpl.c(this.a).y = 0;
    TXLivePusherImpl.d(this.a).mVolumeType = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.TXLivePusherImpl.11
 * JD-Core Version:    0.7.0.1
 */