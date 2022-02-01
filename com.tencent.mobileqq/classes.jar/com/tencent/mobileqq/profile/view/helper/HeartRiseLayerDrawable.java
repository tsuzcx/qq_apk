package com.tencent.mobileqq.profile.view.helper;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.LayerDrawable;
import android.os.Handler;
import android.util.DisplayMetrics;

public class HeartRiseLayerDrawable
  extends LayerDrawable
{
  public HeartRiseLayerDrawable(int paramInt, Resources paramResources)
  {
    super(HeartRiseLayerDrawable.HeartRiseDrawable.a(paramInt, paramResources, a(paramResources)));
  }
  
  public static Bitmap a(Resources paramResources)
  {
    Paint localPaint = new Paint();
    localPaint.setColor(paramResources.getColor(2131166618));
    Bitmap localBitmap = Bitmap.createBitmap(126, 126, Bitmap.Config.ARGB_4444);
    localBitmap.setDensity(paramResources.getDisplayMetrics().densityDpi);
    paramResources = new Canvas(localBitmap);
    paramResources.rotate(45.0F);
    paramResources.translate(0.0F, -88.0F);
    float f1 = 56;
    float f2 = 126;
    paramResources.drawRect(f1, f1, f2, f2, localPaint);
    f2 = 91;
    float f3 = 35;
    paramResources.drawCircle(f1, f2, f3, localPaint);
    paramResources.drawCircle(f2, f1, f3, localPaint);
    return localBitmap;
  }
  
  public void a(Handler paramHandler, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < getNumberOfLayers())
    {
      HeartRiseLayerDrawable.1 local1 = new HeartRiseLayerDrawable.1(this, i, paramInt1, paramInt2);
      int j;
      if (i % 2 == 0) {
        j = i * 200;
      } else {
        j = i * 130;
      }
      paramHandler.postDelayed(local1, j);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.view.helper.HeartRiseLayerDrawable
 * JD-Core Version:    0.7.0.1
 */