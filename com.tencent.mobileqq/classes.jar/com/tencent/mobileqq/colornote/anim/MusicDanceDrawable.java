package com.tencent.mobileqq.colornote.anim;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.config.api.IAppSettingApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class MusicDanceDrawable
  extends Drawable
  implements FloatingWindowDrawable, Runnable
{
  private static List<Double>[] i;
  private Paint a;
  private List<MusicDanceDrawable.MusicBar> b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private boolean h;
  private int j = 0;
  
  private static int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public void a(int paramInt)
  {
    if (i == null)
    {
      i = new ArrayList[3];
      paramInt = 0;
      while (paramInt < 3)
      {
        i[paramInt] = new ArrayList();
        paramInt += 1;
      }
      for (double d1 = 0.0D; d1 < 3.141592653589793D; d1 += 0.05D)
      {
        i[0].add(Double.valueOf(Math.abs(Math.sin(d1 + 0.0D))));
        i[1].add(Double.valueOf(Math.abs(Math.sin(1.0D + d1))));
        i[2].add(Double.valueOf(Math.abs(Math.sin(2.0D + d1))));
      }
    }
    if (!this.h)
    {
      scheduleSelf(this, 0L);
      invalidateSelf();
      this.h = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MusicDanceView", 2, "start music animation");
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.b.add(new MusicDanceDrawable.MusicBar(this, paramInt1, paramInt2, paramInt3, paramInt4, null));
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2)
  {
    a(paramContext, paramInt1, paramInt2, -16777216);
  }
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.b = new ArrayList();
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setColor(paramInt3);
    this.d = paramInt2;
    this.e = a(2.0F, paramContext.getResources());
    paramContext = (IAppSettingApi)QRoute.api(IAppSettingApi.class);
    if ((this.e < 0) && (paramContext.isDebugVersion())) {
      throw new IllegalStateException("MusicDanceView#mBarPadding mast > 0");
    }
    paramInt3 = (paramInt1 - this.e * 2) / 3;
    paramInt1 = 0;
    while ((this.b.size() < 3) && (paramInt1 < 3))
    {
      a(0, paramInt2, paramInt3, -1);
      paramInt1 += 1;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 0;
    this.c = 0;
    while (k < this.b.size())
    {
      MusicDanceDrawable.MusicBar localMusicBar = (MusicDanceDrawable.MusicBar)this.b.get(k);
      paramCanvas.drawRect(this.c, this.d - MusicDanceDrawable.MusicBar.a(localMusicBar), this.c + MusicDanceDrawable.MusicBar.b(localMusicBar), this.d, this.a);
      this.c += MusicDanceDrawable.MusicBar.b(localMusicBar) + this.e;
      k += 1;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.g;
  }
  
  public int getIntrinsicWidth()
  {
    return this.f;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public void run()
  {
    if (this.h)
    {
      int k = 0;
      while (k < this.b.size())
      {
        double d1 = ((Double)i[k].get(this.j)).doubleValue();
        MusicDanceDrawable.MusicBar localMusicBar = (MusicDanceDrawable.MusicBar)this.b.get(k);
        double d2 = MusicDanceDrawable.MusicBar.c(localMusicBar);
        Double.isNaN(d2);
        localMusicBar.a((int)(d2 * d1));
        k += 1;
      }
      scheduleSelf(this, 50L);
      invalidateSelf();
      this.j += 1;
      if (this.j >= i[0].size()) {
        this.j = 0;
      }
    }
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void stop()
  {
    this.h = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.anim.MusicDanceDrawable
 * JD-Core Version:    0.7.0.1
 */