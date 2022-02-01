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
  private static final int i = Color.parseColor("#6BCB1F");
  private static final int j = Color.parseColor("#9CF05B");
  private static final int k = Color.parseColor("#50A80C");
  private static final int l = Color.parseColor("#FA4242");
  private static final int m = Color.parseColor("#FFA194");
  private static final int n = Color.parseColor("#E91D32");
  private int jdField_a_of_type_Int;
  private LinearGradient jdField_a_of_type_AndroidGraphicsLinearGradient;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private BitmapDrawable jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  private int jdField_b_of_type_Int;
  private LinearGradient jdField_b_of_type_AndroidGraphicsLinearGradient;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  
  private int a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != 0) {
      if ((paramInt1 != 1) && (paramInt1 == 2)) {
        paramInt2 = paramInt4;
      } else {
        paramInt2 = paramInt3;
      }
    }
    return Utils.a(paramInt2, paramContext.getResources());
  }
  
  private void a(int paramInt)
  {
    this.h = paramInt;
    Object localObject = MobileQQ.sMobileQQ;
    this.jdField_a_of_type_Int = a((Context)localObject, paramInt, 1, 5, 7);
    this.jdField_b_of_type_Int = a((Context)localObject, paramInt, 3, 8, 10);
    this.c = a((Context)localObject, paramInt, 3, 8, 10);
    int i1 = a((Context)localObject, paramInt, 2, 6, 8);
    paramInt = a((Context)localObject, paramInt, 12, 24, 32);
    this.e = paramInt;
    this.d = paramInt;
    paramInt = this.d;
    int i2 = this.jdField_a_of_type_Int;
    this.f = (paramInt - i2 - i1);
    float f1 = i2;
    float f2 = this.jdField_b_of_type_Int;
    float f3 = i2;
    float f4 = this.e - this.c;
    paramInt = i;
    i1 = j;
    i2 = k;
    localObject = Shader.TileMode.MIRROR;
    this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(f1, f2, f3, f4, new int[] { paramInt, i1, i2, i2 }, null, (Shader.TileMode)localObject);
    paramInt = this.jdField_a_of_type_Int;
    f1 = paramInt;
    f2 = this.jdField_b_of_type_Int;
    f3 = paramInt;
    f4 = this.e - this.c;
    paramInt = l;
    i1 = m;
    i2 = n;
    localObject = Shader.TileMode.MIRROR;
    this.jdField_b_of_type_AndroidGraphicsLinearGradient = new LinearGradient(f1, f2, f3, f4, new int[] { paramInt, i1, i2, i2 }, null, (Shader.TileMode)localObject);
  }
  
  private void a(Canvas paramCanvas, int paramInt)
  {
    paramInt = Math.min(Math.max(paramInt, 1), 100);
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    LinearGradient localLinearGradient;
    if (paramInt > 20) {
      localLinearGradient = this.jdField_a_of_type_AndroidGraphicsLinearGradient;
    } else {
      localLinearGradient = this.jdField_b_of_type_AndroidGraphicsLinearGradient;
    }
    localPaint.setShader(localLinearGradient);
    paramInt = this.f * paramInt / 100;
    int i1 = this.jdField_a_of_type_Int;
    paramCanvas.drawRect(new Rect(i1, this.jdField_b_of_type_Int, paramInt + i1, this.e - this.c), this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void a(Canvas paramCanvas, Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i1;
    if (this.h == 0) {
      i1 = 2130838049;
    } else {
      i1 = 2130839425;
    }
    paramContext = paramContext.getDrawable(i1);
    paramContext.setBounds(0, 0, this.d, this.e);
    paramContext.draw(paramCanvas);
  }
  
  public Drawable a(int paramInt1, int paramInt2)
  {
    if (this.g == paramInt1)
    {
      localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
      if ((localObject1 != null) && (paramInt2 == this.h)) {
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
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable = new BitmapDrawable(((Context)localObject1).getResources(), localBitmap);
    this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setBounds(0, 0, this.d, this.e);
    return this.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.OnlineBatteryProducer
 * JD-Core Version:    0.7.0.1
 */