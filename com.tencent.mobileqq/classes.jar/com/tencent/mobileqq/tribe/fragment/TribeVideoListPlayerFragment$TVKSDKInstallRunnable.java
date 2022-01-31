package com.tencent.mobileqq.tribe.fragment;

import bazk;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;

public class TribeVideoListPlayerFragment$TVKSDKInstallRunnable
  implements Runnable
{
  protected TribeVideoListPlayerFragment$TVKSDKInstallRunnable(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void run()
  {
    if (this.this$0.getActivity() == null) {
      return;
    }
    TVK_SDKMgr.installPlugin(this.this$0.getActivity(), new bazk(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.TVKSDKInstallRunnable
 * JD-Core Version:    0.7.0.1
 */