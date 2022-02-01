package com.tencent.rtmp.ui;

import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import com.tencent.liteav.k;

class TXCloudVideoView$2
  implements ScaleGestureDetector.OnScaleGestureListener
{
  TXCloudVideoView$2(TXCloudVideoView paramTXCloudVideoView) {}
  
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    int j;
    if (TXCloudVideoView.access$400(this.a) != null) {
      j = TXCloudVideoView.access$400(this.a).e();
    } else {
      j = 0;
    }
    if (j > 0)
    {
      float f2 = paramScaleGestureDetector.getScaleFactor();
      float f1;
      if (f2 > 1.0F)
      {
        f2 = 0.2F / j * (j - TXCloudVideoView.access$500(this.a)) + 1.0F;
        f1 = f2;
        if (f2 <= 1.1F) {
          f1 = 1.1F;
        }
      }
      else
      {
        f1 = f2;
        if (f2 < 1.0F)
        {
          f2 = 1.0F - 0.2F / j * TXCloudVideoView.access$500(this.a);
          f1 = f2;
          if (f2 >= 0.9F) {
            f1 = 0.9F;
          }
        }
      }
      int k = Math.round(TXCloudVideoView.access$500(this.a) * f1);
      int i = k;
      if (k == TXCloudVideoView.access$500(this.a)) {
        if (f1 > 1.0F)
        {
          i = k + 1;
        }
        else
        {
          i = k;
          if (f1 < 1.0F) {
            i = k - 1;
          }
        }
      }
      if (i < j) {
        j = i;
      }
      i = j;
      if (j <= 1) {
        i = 1;
      }
      if (f1 > 1.0F)
      {
        j = i;
        if (i < TXCloudVideoView.access$500(this.a)) {
          j = TXCloudVideoView.access$500(this.a);
        }
      }
      else
      {
        j = i;
        if (f1 < 1.0F)
        {
          j = i;
          if (i > TXCloudVideoView.access$500(this.a)) {
            j = TXCloudVideoView.access$500(this.a);
          }
        }
      }
      TXCloudVideoView.access$502(this.a, j);
      if (TXCloudVideoView.access$400(this.a) != null) {
        TXCloudVideoView.access$400(this.a).a(TXCloudVideoView.access$500(this.a));
      }
    }
    return false;
  }
  
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    return true;
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rtmp.ui.TXCloudVideoView.2
 * JD-Core Version:    0.7.0.1
 */