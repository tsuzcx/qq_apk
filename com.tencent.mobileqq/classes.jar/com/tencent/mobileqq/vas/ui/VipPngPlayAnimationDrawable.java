package com.tencent.mobileqq.vas.ui;

import android.annotation.TargetApi;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.util.Utils;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class VipPngPlayAnimationDrawable
  extends Drawable
  implements Runnable
{
  public int A = 0;
  public boolean B = false;
  public boolean C = false;
  public int D;
  public int E;
  private int a = -1;
  private int b = 0;
  private Rect c = new Rect();
  public int m = -1;
  public Object n;
  protected Paint o = new Paint(6);
  public INinePathBitmap p = new VipPngBitmap();
  public Bitmap q;
  public int r = -1;
  public int s = 50;
  public int t;
  public int u;
  public Handler v = new Handler(Looper.getMainLooper());
  public boolean w = true;
  public VipPngPlayAnimationDrawable.DecodeNextFrameTask x;
  public boolean y = false;
  public Resources z;
  
  public VipPngPlayAnimationDrawable(Resources paramResources)
  {
    this.z = paramResources;
  }
  
  @TargetApi(11)
  protected Bitmap a(int paramInt1, Object paramObject, int paramInt2)
  {
    Object localObject = new BitmapFactory.Options();
    if (paramInt1 != 0)
    {
      if ((paramInt1 != 1) && (paramInt1 != 2)) {
        return null;
      }
      paramObject = (int[])paramObject;
      paramInt1 = paramObject[((paramInt2 + 1) % paramObject.length)];
      return BitmapFactory.decodeResource(this.z, paramInt1, (BitmapFactory.Options)localObject);
    }
    paramObject = (String[])paramObject;
    paramObject = paramObject[((paramInt2 + 1) % paramObject.length)];
    ((BitmapFactory.Options)localObject).inDensity = 320;
    ((BitmapFactory.Options)localObject).inTargetDensity = this.z.getDisplayMetrics().densityDpi;
    if (paramObject.startsWith("file:///android_assets/bubbles/"))
    {
      paramObject = paramObject.substring(23);
      paramObject = new BufferedInputStream(this.z.getAssets().open(paramObject));
    }
    else
    {
      paramObject = new BufferedInputStream(new FileInputStream(paramObject));
    }
    localObject = BitmapFactory.decodeStream(paramObject, null, (BitmapFactory.Options)localObject);
    try
    {
      paramObject.close();
      return localObject;
    }
    catch (IOException paramObject)
    {
      paramObject.printStackTrace();
    }
    return localObject;
  }
  
  public void a(boolean paramBoolean)
  {
    this.y = paramBoolean;
    if (!paramBoolean) {
      super.invalidateSelf();
    }
  }
  
  public void a(String[] paramArrayOfString)
  {
    if ((this.m == 0) && (Arrays.equals((String[])this.n, paramArrayOfString))) {
      return;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    String str = paramArrayOfString[0];
    if (str.startsWith("file:///android_assets/bubbles/"))
    {
      paramArrayOfString = str.substring(23);
      paramArrayOfString = this.z.getAssets().open(paramArrayOfString);
      BitmapFactory.decodeStream(paramArrayOfString, null, localOptions);
      if (paramArrayOfString != null) {
        try
        {
          paramArrayOfString.close();
        }
        catch (IOException paramArrayOfString)
        {
          paramArrayOfString.printStackTrace();
        }
      }
    }
    else
    {
      paramArrayOfString = new BufferedInputStream(new FileInputStream(paramArrayOfString[0]));
      BitmapFactory.decodeStream(paramArrayOfString, null, localOptions);
      paramArrayOfString.close();
    }
    this.t = Utils.a(localOptions.outWidth, 320, this.z.getDisplayMetrics().densityDpi);
    this.u = Utils.a(localOptions.outHeight, 320, this.z.getDisplayMetrics().densityDpi);
    this.D = this.t;
    this.E = this.u;
  }
  
  public void a(String[] paramArrayOfString, int paramInt)
  {
    if (paramArrayOfString != null)
    {
      if ((this.m == 0) && (Arrays.equals((String[])this.n, paramArrayOfString))) {
        return;
      }
      c();
      this.m = 0;
      this.n = paramArrayOfString;
      this.b = paramArrayOfString.length;
      this.s = paramInt;
      this.C = false;
    }
  }
  
  public void b(int paramInt)
  {
    this.a = paramInt;
  }
  
  protected int c(int paramInt)
  {
    if (paramInt == this.b - 1)
    {
      this.A -= 1;
      return 0;
    }
    return paramInt + 1;
  }
  
  public void c()
  {
    Object localObject = this.p;
    if (localObject != null) {
      ((INinePathBitmap)localObject).b();
    }
    localObject = this.q;
    if (localObject != null)
    {
      ((Bitmap)localObject).recycle();
      this.q = null;
    }
    localObject = this.x;
    if (localObject != null)
    {
      ((VipPngPlayAnimationDrawable.DecodeNextFrameTask)localObject).cancel(false);
      this.x = null;
    }
    this.m = -1;
    this.w = true;
    this.r = -1;
    this.s = 50;
    this.A = -1;
    this.C = true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.m == -1) {
      return;
    }
    int i;
    if (this.r != -1)
    {
      Rect localRect2 = super.getBounds();
      if (this.B)
      {
        i = paramCanvas.save();
        paramCanvas.scale(-1.0F, 1.0F, localRect2.centerX(), localRect2.centerY());
      }
      else
      {
        i = 0;
      }
      int j = this.m;
      if ((j != 1) && ((j == 0) || (j == 2)) && (this.p != null))
      {
        Rect localRect1 = null;
        j = this.D;
        if (j > 0) {
          localRect1 = new Rect(0, 0, j, getIntrinsicHeight());
        }
        this.p.a(paramCanvas, localRect1, localRect2, this.o);
      }
      if (this.B) {
        paramCanvas.restoreToCount(i);
      }
    }
    if (this.A == 0)
    {
      i = this.a;
      if ((102 != i) && (103 != i)) {
        c();
      }
      super.invalidateSelf();
      this.C = true;
      return;
    }
    f();
  }
  
  protected void f()
  {
    if ((this.m == 1) && (this.r >= 0))
    {
      this.v.postDelayed(this, this.s);
      return;
    }
    if ((this.w) && (!this.y))
    {
      this.w = false;
      long l1 = SystemClock.uptimeMillis();
      long l2 = this.s;
      this.x = new VipPngPlayAnimationDrawable.DecodeNextFrameTask(this, this.n);
      this.x.execute(new Long[] { Long.valueOf(l1 + l2), Long.valueOf(this.r), Long.valueOf(this.m) });
    }
  }
  
  public boolean g()
  {
    return (!this.C) && (this.r >= 0);
  }
  
  public int getIntrinsicHeight()
  {
    return this.u;
  }
  
  public int getIntrinsicWidth()
  {
    return this.t;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void run()
  {
    if (this.q == null) {
      return;
    }
    this.w = true;
    this.r = c(this.r);
    if ((this.m != -1) && (this.q != null) && (this.p.a() != this.q))
    {
      this.p.b();
      this.p.a(this.q);
      this.q = null;
      super.invalidateSelf();
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.o.getAlpha())
    {
      this.o.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.o.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.o.setDither(paramBoolean);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VipPngPlayAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */