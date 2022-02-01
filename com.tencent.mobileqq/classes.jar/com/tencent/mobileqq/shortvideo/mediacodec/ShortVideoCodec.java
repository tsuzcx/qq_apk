package com.tencent.mobileqq.shortvideo.mediacodec;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.av.mediacodec.AndroidCodec;
import com.tencent.av.mediacodec.DeviceCheck;

public class ShortVideoCodec
  extends AndroidCodec
{
  public static String TAG = "ShortVideoCodec";
  public static int mMediaCodecFeature = -1;
  
  public static int checkSupportMediaCodecFeature(Context paramContext)
  {
    int i = mMediaCodecFeature;
    if (i >= 0) {
      return i;
    }
    mMediaCodecFeature = 0;
    if (paramContext == null) {
      return mMediaCodecFeature;
    }
    if (Build.VERSION.SDK_INT < 16) {
      return mMediaCodecFeature;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      invoke21Apis();
      if (!fInvokeAPILevel21)
      {
        mMediaCodecFeature = 0;
        return mMediaCodecFeature;
      }
    }
    if (DeviceCheck.e()) {
      mMediaCodecFeature = 1;
    }
    if (DeviceCheck.f()) {
      mMediaCodecFeature += 2;
    }
    return mMediaCodecFeature;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.mediacodec.ShortVideoCodec
 * JD-Core Version:    0.7.0.1
 */