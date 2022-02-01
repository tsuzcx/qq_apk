package com.tencent.mobileqq.tribe.fragment;

import android.os.Handler;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;

class TribeVideoListPlayerFragment$12
  implements ISuperPlayer.OnVideoPreparedListener
{
  TribeVideoListPlayerFragment$12(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment, TribeVideoListPlayerFragment.BaseVideoViewHolder paramBaseVideoViewHolder) {}
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    TribeVideoListPlayerFragment.a.post(new TribeVideoListPlayerFragment.12.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.12
 * JD-Core Version:    0.7.0.1
 */