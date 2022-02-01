package com.tencent.ttpic.videoshelf.libpag;

import android.os.Build.VERSION;
import android.util.Log;
import org.libpag.VideoDecoder;

public class PagUtil
{
  private static final String TAG = "PagUtil";
  
  public static boolean isSupportPag()
  {
    return Build.VERSION.SDK_INT >= 21;
  }
  
  public static boolean isSupportPagForVideo()
  {
    return Build.VERSION.SDK_INT > 18;
  }
  
  public static void useSoftDecode()
  {
    Log.i("PagUtil", "硬解解有问题，使用软解");
    VideoDecoder.SetMaxHardwareDecoderCount(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.libpag.PagUtil
 * JD-Core Version:    0.7.0.1
 */