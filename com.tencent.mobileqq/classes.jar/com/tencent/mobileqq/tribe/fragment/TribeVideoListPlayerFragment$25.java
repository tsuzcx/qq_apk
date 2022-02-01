package com.tencent.mobileqq.tribe.fragment;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;

class TribeVideoListPlayerFragment$25
  implements ISPlayerVideoView.IVideoViewCallBack
{
  TribeVideoListPlayerFragment$25(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onSurfaceChanged(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceChanged");
    }
  }
  
  public void onSurfaceCreated(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceCreated");
    }
  }
  
  public void onSurfaceDestroy(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "IVideoViewBase.IVideoViewCallBack onSurfaceDestory");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.25
 * JD-Core Version:    0.7.0.1
 */