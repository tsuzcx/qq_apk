package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.DelayAction;
import com.tencent.mobileqq.surfaceviewaction.action.MoveToAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Node;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.Texture;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class RainView
  extends SpriteGLView
  implements Runnable
{
  private static int a = 4000;
  private static int b = 200;
  private static int c = 100;
  private static int d = 3;
  private static int e = 6;
  private Texture f;
  private Context g;
  private int h;
  private int i;
  private int j;
  private int k = 0;
  private int l;
  private RainView.AnimationEndListener m;
  private AtomicInteger n;
  private AtomicInteger o;
  
  public RainView(Context paramContext)
  {
    super(paramContext, 1);
    this.g = paramContext;
    this.u = false;
    this.o = new AtomicInteger(0);
  }
  
  private Bitmap a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!new File(paramString).exists()) {
        return null;
      }
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ImageUtil.a(paramString, (BitmapFactory.Options)localObject);
      int i4 = ((BitmapFactory.Options)localObject).outHeight;
      int i1 = ((BitmapFactory.Options)localObject).outWidth;
      int i2 = DisplayUtil.a(getContext(), 80.0F);
      int i3 = DisplayUtil.a(getContext(), 80.0F);
      if ((i4 <= i2) && (i1 <= i3))
      {
        i2 = 1;
      }
      else
      {
        i4 /= 2;
        int i5 = i1 / 2;
        i1 = 2;
        while ((i4 / i1 >= i2) && (i5 / i1 >= i3)) {
          i1 *= 2;
        }
        i2 = i1;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("inSampleSize = ");
          localStringBuilder.append(i1);
          QLog.d("SpriteGLView", 2, localStringBuilder.toString());
          i2 = i1;
        }
      }
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject).inSampleSize = i2;
      ((BitmapFactory.Options)localObject).inTargetDensity = this.g.getResources().getDisplayMetrics().densityDpi;
      ((BitmapFactory.Options)localObject).inDensity = 320;
      ((BitmapFactory.Options)localObject).inScaled = true;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      try
      {
        paramString = ImageUtil.a(paramString, (BitmapFactory.Options)localObject);
        if (paramString != null) {
          return paramString;
        }
        QLog.e("SpriteGLView", 1, "getPngDrawable bitmap = null");
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getPngDrawable oom = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("SpriteGLView", 1, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  private int c(int paramInt)
  {
    int i1 = new Random().nextInt(5);
    double d1;
    double d2;
    double d3;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 != 3) {
            return paramInt;
          }
          d1 = paramInt;
          d2 = this.l;
          d3 = Math.tan(0.349065850398866D);
          Double.isNaN(d2);
          Double.isNaN(d1);
          d1 += d2 * d3;
        }
        else
        {
          d1 = paramInt;
          d2 = this.l;
          d3 = Math.tan(0.174532925199433D);
          Double.isNaN(d2);
          Double.isNaN(d1);
          d1 += d2 * d3;
          break label195;
        }
      }
      else
      {
        d1 = paramInt;
        d2 = this.l;
        d3 = Math.tan(0.349065850398866D);
        Double.isNaN(d2);
        Double.isNaN(d1);
        d1 -= d2 * d3;
      }
      return (int)d1;
    }
    else
    {
      d1 = paramInt;
      d2 = this.l;
      d3 = Math.tan(0.174532925199433D);
      Double.isNaN(d2);
      Double.isNaN(d1);
      d1 -= d2 * d3;
    }
    label195:
    return (int)d1;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    int i1 = this.o.incrementAndGet();
    if (i1 == 1)
    {
      paramString = a(paramString);
      if (paramString != null) {
        this.f = new Texture(this, paramString);
      }
      if (this.f != null)
      {
        this.h = (paramInt1 / d);
        this.i = paramInt2;
        this.j = (DisplayUtil.a(getContext(), 20.0F) + paramInt3);
        this.l = (paramInt3 - paramInt2);
        this.n = new AtomicInteger(0);
        b(this);
      }
    }
    else if ((i1 > 1) && (this.f != null))
    {
      b(this);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("rain animation run initCount = ");
      paramString.append(i1);
      paramString.append(" mTexture = ");
      paramString.append(this.f);
      QLog.d("SpriteGLView", 2, paramString.toString());
    }
  }
  
  public void run()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("rain animation run mLoopNum = ");
      ((StringBuilder)localObject1).append(this.k);
      QLog.d("SpriteGLView", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.k >= e)
    {
      this.k = 0;
      return;
    }
    int i1 = 0;
    while (i1 < d)
    {
      localObject1 = new Sprite(this);
      ((Sprite)localObject1).a(this.f);
      ((Sprite)localObject1).f = ((new Random().nextInt(2) * 2 + 8) / 10.0F);
      int i2 = this.i;
      int i3 = new Random().nextInt(DisplayUtil.a(getContext(), c));
      int i4 = this.j;
      int i5 = this.h * i1 + new Random().nextInt(this.h + 1);
      float f1 = i5;
      float f2 = i2 - i3;
      ((Sprite)localObject1).a(f1, f2);
      Object localObject2 = new MoveToAction(a, f1, f2, c(i5), i4);
      ((Sprite)localObject1).a(new Action[] { localObject2 });
      ((MoveToAction)localObject2).a(new RainView.1(this, (Sprite)localObject1));
      if (i1 == 0)
      {
        localObject2 = new DelayAction(b);
        ((Sprite)localObject1).a(new Action[] { localObject2 });
        ((DelayAction)localObject2).a(new RainView.2(this));
      }
      a((Node)localObject1);
      i1 += 1;
    }
    this.k += 1;
  }
  
  public void setAnimationEndListener(RainView.AnimationEndListener paramAnimationEndListener)
  {
    this.m = paramAnimationEndListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.RainView
 * JD-Core Version:    0.7.0.1
 */