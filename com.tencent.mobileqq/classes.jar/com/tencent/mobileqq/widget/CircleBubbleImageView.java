package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;

public class CircleBubbleImageView
  extends ChatThumbView
{
  protected Paint e;
  protected Bitmap f;
  protected Canvas g;
  protected BitmapShader h;
  protected Bitmap i;
  protected Canvas j;
  protected Paint k;
  protected Path l;
  protected Path m;
  protected int n;
  protected int o;
  protected Resources p;
  public boolean q;
  public boolean r = true;
  protected boolean s = false;
  protected boolean t = false;
  protected int u = 1610612736;
  
  public CircleBubbleImageView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    this.p = getResources();
    this.e = new Paint();
    this.e.setAntiAlias(true);
    this.e.setFilterBitmap(true);
    this.e.setStyle(Paint.Style.FILL);
    this.l = new Path();
    this.m = new Path();
  }
  
  private void a(Canvas paramCanvas)
  {
    Object localObject = this.p;
    int i1 = this.n;
    int i2 = this.o;
    i2 = i1 / 2;
    Path localPath;
    float f1;
    float f2;
    if (this.q)
    {
      localPath = this.l;
      if (localPath != null)
      {
        localPath.reset();
        localPath.moveTo(i1 - a(23.0F, (Resources)localObject), a(26.0F, (Resources)localObject));
        f1 = i1 - a(9.0F, (Resources)localObject);
        f2 = a(23.0F, (Resources)localObject);
        localPath.quadTo(i1 - a(13.0F, (Resources)localObject), a(28.0F, (Resources)localObject), f1, f2);
        f1 = i1 - a(19.0F, (Resources)localObject);
        f2 = a(34.0F, (Resources)localObject);
        localPath.quadTo(i1 - a(10.0F, (Resources)localObject), a(32.0F, (Resources)localObject), f1, f2);
        localPath.close();
        this.l = localPath;
      }
    }
    else
    {
      localPath = this.m;
      if (localPath != null)
      {
        localPath.reset();
        localPath.moveTo(a(23.0F, (Resources)localObject), a(26.0F, (Resources)localObject));
        f1 = a(9.0F, (Resources)localObject);
        f2 = a(23.0F, (Resources)localObject);
        localPath.quadTo(a(13.0F, (Resources)localObject), a(28.0F, (Resources)localObject), f1, f2);
        f1 = a(19.0F, (Resources)localObject);
        f2 = a(34.0F, (Resources)localObject);
        localPath.quadTo(a(10.0F, (Resources)localObject), a(32.0F, (Resources)localObject), f1, f2);
        localPath.close();
        this.m = localPath;
      }
    }
    if (this.q)
    {
      f1 = i2;
      paramCanvas.drawCircle(f1, f1, f1, this.e);
      if (this.r)
      {
        localObject = this.l;
        if (localObject != null) {
          paramCanvas.drawPath((Path)localObject, this.e);
        }
      }
    }
    else
    {
      f1 = i2;
      paramCanvas.drawCircle(f1, f1, f1, this.e);
      if (this.r)
      {
        localObject = this.m;
        if (localObject != null) {
          paramCanvas.drawPath((Path)localObject, this.e);
        }
      }
    }
  }
  
  public int a(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.n = getWidth();
    this.o = getHeight();
    int i1 = this.n;
    int i2;
    if (i1 > 0)
    {
      i2 = this.o;
      if ((i2 > 0) && (this.f != null)) {}
    }
    try
    {
      this.f = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError localOutOfMemoryError3)
    {
      try
      {
        this.f = Bitmap.createBitmap(this.n, this.o, Bitmap.Config.ARGB_4444);
        break label104;
        URLDrawable.clearMemoryCache();
      }
      catch (OutOfMemoryError localOutOfMemoryError3)
      {
        try
        {
          this.f = Bitmap.createBitmap(this.n, this.o, Bitmap.Config.ARGB_4444);
          label104:
          localObject = this.g;
          if (localObject != null) {
            ((Canvas)localObject).setBitmap(this.f);
          }
          localObject = this.f;
          if (localObject == null)
          {
            super.draw(paramCanvas);
            return;
          }
          if (this.g == null)
          {
            this.g = new Canvas((Bitmap)localObject);
            this.g.setBitmap(this.f);
          }
          if (this.h == null)
          {
            this.h = new BitmapShader(this.f, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            this.e.setShader(this.h);
          }
          this.f.eraseColor(16711680);
          super.draw(this.g);
          if (this.t) {
            this.g.drawColor(this.u);
          }
          if ((!this.s) || (this.i != null)) {}
        }
        catch (OutOfMemoryError localOutOfMemoryError3)
        {
          try
          {
            for (;;)
            {
              this.i = Bitmap.createBitmap(this.n, this.o, Bitmap.Config.ARGB_8888);
              label279:
              Object localObject = this.j;
              if (localObject != null) {
                ((Canvas)localObject).setBitmap(this.i);
              }
              if (this.s)
              {
                localObject = this.i;
                if (localObject != null)
                {
                  if (this.j == null) {
                    this.j = new Canvas((Bitmap)localObject);
                  }
                  this.i.eraseColor(0);
                  a(this.j);
                  paramCanvas.drawBitmap(this.i, 0.0F, 0.0F, this.k);
                  return;
                }
              }
              a(paramCanvas);
              return;
              super.draw(paramCanvas);
              return;
              localOutOfMemoryError1 = localOutOfMemoryError1;
              continue;
              localOutOfMemoryError2 = localOutOfMemoryError2;
            }
            localOutOfMemoryError3 = localOutOfMemoryError3;
          }
          catch (OutOfMemoryError localOutOfMemoryError4)
          {
            break label279;
          }
        }
      }
    }
  }
  
  public void setColorMask(int paramInt)
  {
    this.u = paramInt;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    if (paramDrawable == getDrawable()) {
      super.setImageDrawable(null);
    }
    super.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CircleBubbleImageView
 * JD-Core Version:    0.7.0.1
 */