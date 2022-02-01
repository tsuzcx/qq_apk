package com.tencent.mobileqq.wink.pick.circle.widget;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;

class WinkCircleVideoPreviewItemView$1
  implements VideoPlayerCallback
{
  WinkCircleVideoPreviewItemView$1(WinkCircleVideoPreviewItemView paramWinkCircleVideoPreviewItemView, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap) {}
  
  public void onDownloadComplete(long paramLong) {}
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong) {}
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    if (WinkCircleVideoPreviewItemView.c(this.b) != null)
    {
      int i = (int)(WinkCircleVideoPreviewItemView.c(this.b).getMax() * ((float)paramLong2 / (float)this.a.mDuration));
      if (i >= WinkCircleVideoPreviewItemView.d(this.b))
      {
        WinkCircleVideoPreviewItemView.c(this.b).setProgress(i);
        WinkCircleVideoPreviewItemView.a(this.b, -1);
      }
    }
    if (WinkCircleVideoPreviewItemView.e(this.b) != null) {
      WinkCircleVideoPreviewItemView.e(this.b).setText(WinkCircleVideoPreviewItemView.a(this.b, paramLong2));
    }
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (paramInt == 4)
    {
      WinkCircleVideoPreviewItemView.a(this.b).setVisibility(8);
      WinkCircleVideoPreviewItemView.b(this.b).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.pick.circle.widget.WinkCircleVideoPreviewItemView.1
 * JD-Core Version:    0.7.0.1
 */