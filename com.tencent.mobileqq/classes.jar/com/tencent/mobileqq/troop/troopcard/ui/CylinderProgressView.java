package com.tencent.mobileqq.troop.troopcard.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.impl.R.styleable;
import mqq.os.MqqHandler;

public class CylinderProgressView
  extends View
{
  Runnable a = new CylinderProgressView.1(this);
  private Paint b = new Paint();
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private float i = 100.0F;
  private int j;
  private RectF k = new RectF();
  private RectF l = new RectF();
  private RectF m = new RectF();
  private Shader n;
  private int o;
  private int p;
  private int q;
  private int r;
  private TextView s;
  
  public CylinderProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CylinderProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CylinderProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.K);
    this.j = paramContext.getColor(R.styleable.O, 0);
    this.c = paramContext.getColor(R.styleable.O, 0);
    this.d = paramContext.getColor(R.styleable.N, -16776961);
    this.e = paramContext.getColor(R.styleable.L, Color.parseColor("#F5F6FA"));
    this.h = paramContext.getInt(R.styleable.M, 1);
    paramContext.recycle();
  }
  
  public static int a(String paramString)
  {
    if (paramString.contains("00")) {
      return 2;
    }
    if ((!paramString.contains("80")) && (!paramString.contains("90"))) {
      return 0;
    }
    return 1;
  }
  
  public static int[] a(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return arrayOfInt;
        }
        arrayOfInt[0] = Color.parseColor("#00D96D");
        arrayOfInt[1] = Color.parseColor("#4D00D96D");
        return arrayOfInt;
      }
      arrayOfInt[0] = Color.parseColor("#21D9C6");
      arrayOfInt[1] = Color.parseColor("#4D21D9C6");
      return arrayOfInt;
    }
    arrayOfInt[0] = Color.parseColor("#00CAFC");
    arrayOfInt[1] = Color.parseColor("#4D00CAFC");
    return arrayOfInt;
  }
  
  public static int[] a(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = "#4D94FF";
    } else {
      str = "#FF5CBE";
    }
    int i1 = Color.parseColor(str);
    if (paramBoolean) {
      str = "#4D4D94FF";
    } else {
      str = "#4DFF5CBE";
    }
    return new int[] { i1, Color.parseColor(str) };
  }
  
  private void b(int paramInt)
  {
    this.r = paramInt;
    ThreadManager.getUIHandler().postDelayed(this.a, 15L);
  }
  
  public static int[] getActiveProgressShaderColors()
  {
    return new int[] { Color.parseColor("#FF596A"), Color.parseColor("#4DFF596A") };
  }
  
  public static int[] getLocationProgressShaderColors()
  {
    return new int[] { Color.parseColor("#333B5A"), Color.parseColor("#4D333B5A") };
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.b.setAntiAlias(true);
    this.b.setColor(this.c);
    int i1;
    RectF localRectF;
    float f1;
    float f2;
    float f3;
    if (this.h == 0) {
      try
      {
        i1 = this.g / 2;
        this.k.set(0.0F, 0.0F, this.f, this.g);
        localRectF = this.k;
        f1 = i1;
        paramCanvas.drawRoundRect(localRectF, f1, f1, this.b);
        this.b.setColor(this.e);
        this.l.set(this.j, this.j, this.f - this.j, this.g - this.j);
        paramCanvas.drawRoundRect(this.l, f1, f1, this.b);
        f2 = this.q / this.i;
        f3 = (this.f - this.j) * f2;
        this.m.set(this.j, this.j, f3, this.g - this.j);
        if (f2 != 0.0F)
        {
          this.n = new LinearGradient(this.j, this.j, f3, this.g - this.j, this.p, this.o, Shader.TileMode.CLAMP);
          this.b.setShader(this.n);
        }
        paramCanvas.drawRoundRect(this.m, f1, f1, this.b);
        this.b.setShader(null);
        return;
      }
      catch (Exception paramCanvas)
      {
        paramCanvas.printStackTrace();
        return;
      }
    }
    try
    {
      i1 = this.f / 2;
      this.k.set(0.0F, 0.0F, this.f, this.g);
      localRectF = this.k;
      f1 = i1;
      paramCanvas.drawRoundRect(localRectF, f1, f1, this.b);
      this.b.setColor(this.e);
      this.l.set(this.j, this.j, this.f - this.j, this.g - this.j);
      paramCanvas.drawRoundRect(this.l, f1, f1, this.b);
      f2 = this.q / this.i;
      f3 = this.g - this.j - (this.g - this.j * 2) * f2;
      this.m.set(this.j, f3, this.f - this.j, this.g - this.j);
      if (f2 != 0.0F)
      {
        this.n = new LinearGradient(this.j, f3, this.f - this.j, this.g - this.j, this.p, this.o, Shader.TileMode.CLAMP);
        this.b.setShader(this.n);
      }
      paramCanvas.drawRoundRect(this.m, f1, f1, this.b);
      this.b.setShader(null);
      return;
    }
    catch (Exception paramCanvas)
    {
      paramCanvas.printStackTrace();
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((i1 != 1073741824) && (i1 != -2147483648)) {
      this.f = 0;
    } else {
      this.f = paramInt1;
    }
    if ((i2 != 1073741824) && (i2 != -2147483648)) {
      this.g = 0;
    } else {
      this.g = paramInt2;
    }
    setMeasuredDimension(this.f, this.g);
  }
  
  public void setMax(int paramInt)
  {
    if (paramInt >= 0)
    {
      float f1 = paramInt;
      try
      {
        this.i = f1;
        return;
      }
      finally
      {
        break label32;
      }
    }
    throw new IllegalArgumentException("value can not be negative");
    label32:
    throw localObject;
  }
  
  public void setProgress(int paramInt, TextView paramTextView)
  {
    if (paramInt >= 0)
    {
      float f1 = paramInt;
      try
      {
        if (f1 > this.i) {
          paramInt = (int)this.i;
        }
        this.s = paramTextView;
        if (this.q != paramInt) {
          b(paramInt);
        } else {
          this.s.setText(String.valueOf(paramInt));
        }
        return;
      }
      finally
      {
        break label74;
      }
    }
    throw new IllegalArgumentException("value can not be negative");
    label74:
    throw paramTextView;
  }
  
  public void setProgressEndColor(int paramInt)
  {
    try
    {
      this.p = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setProgressStartColor(int paramInt)
  {
    try
    {
      this.o = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.CylinderProgressView
 * JD-Core Version:    0.7.0.1
 */