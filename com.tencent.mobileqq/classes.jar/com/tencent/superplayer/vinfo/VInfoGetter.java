package com.tencent.superplayer.vinfo;

import android.content.Context;
import android.os.Looper;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;

public class VInfoGetter
{
  private VInfoGetter.VInfoGetterListener mListener;
  private TVideoImpl mTVideoImpl;
  
  public VInfoGetter(Context paramContext, Looper paramLooper)
  {
    this.mTVideoImpl = new TVideoImpl(paramContext, paramLooper);
  }
  
  public void doGetVInfo(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (paramSuperPlayerVideoInfo.getVideoSource() != 1) {
      return;
    }
    this.mTVideoImpl.doGetVInfo(paramSuperPlayerVideoInfo);
  }
  
  public void setListener(VInfoGetter.VInfoGetterListener paramVInfoGetterListener)
  {
    this.mTVideoImpl.setListener(paramVInfoGetterListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.vinfo.VInfoGetter
 * JD-Core Version:    0.7.0.1
 */