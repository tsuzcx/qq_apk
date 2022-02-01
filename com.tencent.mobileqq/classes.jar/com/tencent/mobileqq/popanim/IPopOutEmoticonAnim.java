package com.tencent.mobileqq.popanim;

import android.view.ViewGroup;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface IPopOutEmoticonAnim
  extends QRouteApi
{
  public abstract void playPopEmoAnimation(ViewGroup paramViewGroup, PopOutAnimConfig paramPopOutAnimConfig, int paramInt1, int paramInt2);
  
  public abstract void stopAndCleanPopOutAnim();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.IPopOutEmoticonAnim
 * JD-Core Version:    0.7.0.1
 */