package com.tencent.mobileqq.hotchat.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Build.VERSION;
import com.tencent.mobileqq.hotchat.anim.HeartAnimator;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import java.util.Random;

public class FloatViewBuilder
  extends BaseFloatViewBuilder
{
  private Paint e;
  private Canvas f;
  private int[] g = { Color.parseColor("#c797ff"), Color.parseColor("#80b9f4"), Color.parseColor("#67d0d7"), Color.parseColor("#67d78e"), Color.parseColor("#b5e255"), Color.parseColor("#f2c64f"), Color.parseColor("#f6a455"), Color.parseColor("#ff96b9"), Color.parseColor("#ff6a6a") };
  private Random h = new Random(System.currentTimeMillis());
  
  public FloatViewBuilder(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public FloatViewBuilder(Context paramContext, int paramInt, HeartAnimator paramHeartAnimator)
  {
    super(paramContext, paramInt, paramHeartAnimator);
  }
  
  public static void a(HeartLayout paramHeartLayout)
  {
    if (paramHeartLayout != null)
    {
      if (paramHeartLayout.getAnimatorConfig() == null) {
        return;
      }
      paramHeartLayout = paramHeartLayout.getAnimatorConfig();
      if (paramHeartLayout != null)
      {
        paramHeartLayout.k = 2400;
        com.tencent.mobileqq.hotchat.anim.HeartAnimator.Config.l = 0.05F;
      }
    }
  }
  
  public Bitmap a()
  {
    super.a();
    return b();
  }
  
  public Bitmap b()
  {
    if (this.a == null) {}
    try
    {
      this.a = BitmapFactory.decodeResource(this.c.getResources(), this.b);
      if (this.a == null) {
        return null;
      }
      if (this.e == null) {
        this.e = new Paint(3);
      }
      if (this.f == null) {
        this.f = new Canvas();
      }
      Bitmap localBitmap1 = this.a;
      Bitmap localBitmap2 = HeartView.a(this.a.getWidth(), this.a.getHeight());
      if (localBitmap2 == null) {
        return null;
      }
      Canvas localCanvas = this.f;
      localCanvas.setBitmap(localBitmap2);
      Paint localPaint = this.e;
      int[] arrayOfInt = this.g;
      localPaint.setColorFilter(new PorterDuffColorFilter(arrayOfInt[this.h.nextInt(arrayOfInt.length)], PorterDuff.Mode.SRC_ATOP));
      localCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, localPaint);
      localPaint.setColorFilter(null);
      if (Build.VERSION.SDK_INT >= 11) {
        localCanvas.setBitmap(null);
      }
      return localBitmap2;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.ui.FloatViewBuilder
 * JD-Core Version:    0.7.0.1
 */