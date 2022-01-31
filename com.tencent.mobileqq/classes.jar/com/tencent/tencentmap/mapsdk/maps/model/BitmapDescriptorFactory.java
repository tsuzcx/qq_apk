package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.map.sdk.a.fy;
import com.tencent.map.sdk.a.hf;

public final class BitmapDescriptorFactory
{
  public static final float HUE_AZURE = 210.0F;
  public static final float HUE_BLUE = 240.0F;
  public static final float HUE_CYAN = 180.0F;
  public static final float HUE_GREEN = 120.0F;
  public static final float HUE_MAGENTA = 300.0F;
  public static final float HUE_ORANGE = 30.0F;
  public static final float HUE_RED = 0.0F;
  public static final float HUE_ROSE = 330.0F;
  public static final float HUE_VIOLET = 270.0F;
  public static final float HUE_YELLOW = 60.0F;
  
  public static BitmapDescriptor defaultMarker()
  {
    return new BitmapDescriptor(new hf(5));
  }
  
  public static BitmapDescriptor defaultMarker(float paramFloat)
  {
    hf localhf = new hf(6);
    localhf.e = paramFloat;
    return new BitmapDescriptor(localhf);
  }
  
  public static BitmapDescriptor fromAsset(String paramString)
  {
    hf localhf = new hf(2);
    localhf.b = paramString;
    return new BitmapDescriptor(localhf);
  }
  
  public static BitmapDescriptor fromBitmap(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    paramBitmap = fy.b(paramBitmap);
    hf localhf = new hf(7);
    localhf.f = paramBitmap;
    return new BitmapDescriptor(localhf);
  }
  
  public static BitmapDescriptor fromFile(String paramString)
  {
    hf localhf = new hf(3);
    localhf.c = paramString;
    return new BitmapDescriptor(localhf);
  }
  
  public static BitmapDescriptor fromPath(String paramString)
  {
    hf localhf = new hf(4);
    localhf.d = paramString;
    return new BitmapDescriptor(localhf);
  }
  
  public static BitmapDescriptor fromResource(int paramInt)
  {
    hf localhf = new hf(1);
    localhf.a = paramInt;
    return new BitmapDescriptor(localhf);
  }
  
  public static BitmapDescriptor fromView(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    try
    {
      paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      paramView.layout(0, 0, paramView.getMeasuredWidth(), paramView.getMeasuredHeight());
      paramView.buildDrawingCache();
      Bitmap localBitmap = paramView.getDrawingCache();
      BitmapDescriptor localBitmapDescriptor = fromBitmap(localBitmap);
      if (localBitmap != null) {
        localBitmap.recycle();
      }
      paramView.destroyDrawingCache();
      return localBitmapDescriptor;
    }
    catch (Exception paramView) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory
 * JD-Core Version:    0.7.0.1
 */