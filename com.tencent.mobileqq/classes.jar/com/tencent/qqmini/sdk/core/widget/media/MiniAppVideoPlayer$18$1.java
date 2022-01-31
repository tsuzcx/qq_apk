package com.tencent.qqmini.sdk.core.widget.media;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import bdju;
import bdnw;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy;
import com.tencent.qqmini.sdk.core.proxy.VideoPlayerProxy.OnCaptureImageListener;

public class MiniAppVideoPlayer$18$1
  implements Runnable
{
  public MiniAppVideoPlayer$18$1(bdju parambdju, Canvas paramCanvas, VideoPlayerProxy paramVideoPlayerProxy, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((MiniAppVideoPlayer.a(this.jdField_a_of_type_Bdju.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer) != null) && (MiniAppVideoPlayer.a(this.jdField_a_of_type_Bdju.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).getVisibility() == 0))
    {
      MiniAppVideoPlayer.a(this.jdField_a_of_type_Bdju.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).setDrawingCacheEnabled(true);
      MiniAppVideoPlayer.a(this.jdField_a_of_type_Bdju.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).buildDrawingCache();
      MiniAppVideoPlayer.a(this.jdField_a_of_type_Bdju.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).setDrawingCacheEnabled(false);
    }
    if ((MiniAppVideoPlayer.a(this.jdField_a_of_type_Bdju.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer) != null) && (MiniAppVideoPlayer.a(this.jdField_a_of_type_Bdju.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).getVisibility() == 0))
    {
      MiniAppVideoPlayer.a(this.jdField_a_of_type_Bdju.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).setDrawingCacheEnabled(true);
      MiniAppVideoPlayer.a(this.jdField_a_of_type_Bdju.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).buildDrawingCache();
      Bitmap localBitmap = MiniAppVideoPlayer.a(this.jdField_a_of_type_Bdju.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).getDrawingCache();
      if (localBitmap != null) {
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawBitmap(Bitmap.createBitmap(localBitmap), 0.0F, 0.0F, null);
      }
      MiniAppVideoPlayer.a(this.jdField_a_of_type_Bdju.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).setDrawingCacheEnabled(false);
    }
    if (this.jdField_a_of_type_Bdju.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy$OnCaptureImageListener != null) {
      this.jdField_a_of_type_Bdju.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy$OnCaptureImageListener.onCaptureImageSucceed(this.jdField_a_of_type_ComTencentQqminiSdkCoreProxyVideoPlayerProxy, this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    try
    {
      MiniAppVideoPlayer.a(this.jdField_a_of_type_Bdju.jdField_a_of_type_ComTencentQqminiSdkCoreWidgetMediaMiniAppVideoPlayer).setOnCaptureImageListener(null);
      bdju.a(this.jdField_a_of_type_Bdju, true);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        bdnw.d("MiniAppVideoPlayer", "onCaptureImageSucceed mVideoPlayer.setOnCaptureImageListener get a Throwable:", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.widget.media.MiniAppVideoPlayer.18.1
 * JD-Core Version:    0.7.0.1
 */