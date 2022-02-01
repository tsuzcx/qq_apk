package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class OnlineBatteryProducer
{
  private static final int m = Color.parseColor("#6BCB1F");
  private static final int n = Color.parseColor("#9CF05B");
  private static final int o = Color.parseColor("#50A80C");
  private static final int p = Color.parseColor("#FA4242");
  private static final int q = Color.parseColor("#FFA194");
  private static final int r = Color.parseColor("#E91D32");
  private int a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private BitmapDrawable h;
  private Paint i = new Paint(1);
  private LinearGradient j;
  private LinearGradient k;
  private int l;
  
  private int a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 1) {
        if (paramInt1 != 2)
        {
          if (paramInt1 == 3)
          {
            paramInt2 = paramInt3;
            break label37;
          }
        }
        else
        {
          paramInt2 = paramInt5;
          break label37;
        }
      }
      paramInt2 = paramInt4;
    }
    label37:
    return Utils.a(paramInt2, paramContext.getResources());
  }
  
  private void a(int paramInt)
  {
    this.l = paramInt;
    Object localObject = MobileQQ.sMobileQQ;
    this.a = a((Context)localObject, paramInt, 1, 4, 5, 7);
    this.b = a((Context)localObject, paramInt, 3, 6, 8, 10);
    this.c = a((Context)localObject, paramInt, 3, 6, 8, 10);
    int i1 = a((Context)localObject, paramInt, 2, 5, 6, 8);
    paramInt = a((Context)localObject, paramInt, 12, 19, 24, 32);
    this.e = paramInt;
    this.d = paramInt;
    paramInt = this.d;
    int i2 = this.a;
    this.f = (paramInt - i2 - i1);
    float f1 = i2;
    float f2 = this.b;
    float f3 = i2;
    float f4 = this.e - this.c;
    paramInt = m;
    i1 = n;
    i2 = o;
    localObject = Shader.TileMode.MIRROR;
    this.j = new LinearGradient(f1, f2, f3, f4, new int[] { paramInt, i1, i2, i2 }, null, (Shader.TileMode)localObject);
    paramInt = this.a;
    f1 = paramInt;
    f2 = this.b;
    f3 = paramInt;
    f4 = this.e - this.c;
    paramInt = p;
    i1 = q;
    i2 = r;
    localObject = Shader.TileMode.MIRROR;
    this.k = new LinearGradient(f1, f2, f3, f4, new int[] { paramInt, i1, i2, i2 }, null, (Shader.TileMode)localObject);
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    paramInt = Math.min(Math.max(paramInt, 1), 100);
    Paint localPaint = this.i;
    LinearGradient localLinearGradient;
    if (paramInt > 20) {
      localLinearGradient = this.j;
    } else {
      localLinearGradient = this.k;
    }
    localPaint.setShader(localLinearGradient);
    paramInt = this.f * paramInt / 100;
    int i1 = this.a;
    paramCanvas.drawRect(new Rect(i1, this.b, paramInt + i1, this.e - this.c), this.i);
  }
  
  private void a(Canvas paramCanvas, Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i1;
    if (this.l == 0) {
      i1 = 2130838091;
    } else {
      i1 = 2130839609;
    }
    paramContext = paramContext.getDrawable(i1);
    paramContext.setBounds(0, 0, this.d, this.e);
    paramContext.draw(paramCanvas);
  }
  
  public Drawable a(int paramInt1, int paramInt2)
  {
    if (this.g == paramInt1)
    {
      localObject1 = this.h;
      if ((localObject1 != null) && (paramInt2 == this.l)) {
        return localObject1;
      }
    }
    a(paramInt2);
    this.g = paramInt1;
    long l1 = System.currentTimeMillis();
    Object localObject1 = MobileQQ.sMobileQQ;
    Bitmap localBitmap = Bitmap.createBitmap(this.d, this.e, Bitmap.Config.ARGB_8888);
    Object localObject2 = new Canvas(localBitmap);
    a((Canvas)localObject2, (Context)localObject1);
    a((Canvas)localObject2, paramInt1);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("createBatteryDrawable cost time : ");
      ((StringBuilder)localObject2).append(System.currentTimeMillis() - l1);
      QLog.d("OnlineBatteryProducer", 2, ((StringBuilder)localObject2).toString());
    }
    this.h = new BitmapDrawable(((Context)localObject1).getResources(), localBitmap);
    this.h.setBounds(0, 0, this.d, this.e);
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.OnlineBatteryProducer
 * JD-Core Version:    0.7.0.1
 */