package com.tencent.mobileqq.tribe.fragment;

import android.os.Handler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;

class TribeVideoListPlayerFragment$23
  implements ISuperPlayer.OnErrorListener
{
  TribeVideoListPlayerFragment$23(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.e("TribeVideoListPlayerFragment", 2, "ISuperPlayer.OnErrorListener module = " + paramInt1 + " errorType = " + paramInt2 + " errorCode = " + paramInt3 + " extraInfo = " + paramString);
    TribeVideoListPlayerFragment.a.post(new TribeVideoListPlayerFragment.23.1(this));
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment.23
 * JD-Core Version:    0.7.0.1
 */