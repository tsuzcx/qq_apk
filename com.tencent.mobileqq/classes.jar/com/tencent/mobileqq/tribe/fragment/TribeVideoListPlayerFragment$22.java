package com.tencent.mobileqq.tribe.fragment;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;

class TribeVideoListPlayerFragment$22
  implements ISuperPlayer.OnCompletionListener
{
  TribeVideoListPlayerFragment$22(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TribeVideoListPlayerFragment", 2, "onCompletion");
    }
    TribeVideoListPlayerFragment.a.post(new TribeVideoListPlayerFragment.22.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.22
 * JD-Core Version:    0.7.0.1
 */