package com.tencent.mobileqq.troop.troopcard;

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
  private float jdField_a_of_type_Float = 100.0F;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private Shader jdField_a_of_type_AndroidGraphicsShader;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  Runnable jdField_a_of_type_JavaLangRunnable = new CylinderProgressView.1(this);
  private int jdField_b_of_type_Int;
  private RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  private int jdField_c_of_type_Int;
  private RectF jdField_c_of_type_AndroidGraphicsRectF = new RectF();
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  
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
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.J);
    this.g = paramContext.getColor(R.styleable.d, 0);
    this.jdField_a_of_type_Int = paramContext.getColor(R.styleable.d, 0);
    this.jdField_b_of_type_Int = paramContext.getColor(R.styleable.jdField_c_of_type_Int, -16776961);
    this.jdField_c_of_type_Int = paramContext.getColor(R.styleable.jdField_a_of_type_Int, Color.parseColor("#F5F6FA"));
    this.f = paramContext.getInt(R.styleable.jdField_b_of_type_Int, 1);
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
  
  private void a(int paramInt)
  {
    this.k = paramInt;
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 15L);
  }
  
  public static int[] a()
  {
    return new int[] { Color.parseColor("#FF596A"), Color.parseColor("#4DFF596A") };
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
    int m = Color.parseColor(str);
    if (paramBoolean) {
      str = "#4D4D94FF";
    } else {
      str = "#4DFF5CBE";
    }
    return new int[] { m, Color.parseColor(str) };
  }
  
  public static int[] b()
  {
    return new int[] { Color.parseColor("#333B5A"), Color.parseColor("#4D333B5A") };
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    int m;
    RectF localRectF;
    float f1;
    float f2;
    float f3;
    if (this.f == 0) {
      try
      {
        m = this.e / 2;
        this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.d, this.e);
        localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
        f1 = m;
        paramCanvas.drawRoundRect(localRectF, f1, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
        this.jdField_b_of_type_AndroidGraphicsRectF.set(this.g, this.g, this.d - this.g, this.e - this.g);
        paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, f1, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
        f2 = this.j / this.jdField_a_of_type_Float;
        f3 = (this.d - this.g) * f2;
        this.jdField_c_of_type_AndroidGraphicsRectF.set(this.g, this.g, f3, this.e - this.g);
        if (f2 != 0.0F)
        {
          this.jdField_a_of_type_AndroidGraphicsShader = new LinearGradient(this.g, this.g, f3, this.e - this.g, this.i, this.h, Shader.TileMode.CLAMP);
          this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsShader);
        }
        paramCanvas.drawRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, f1, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
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
      m = this.d / 2;
      this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, this.d, this.e);
      localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      f1 = m;
      paramCanvas.drawRoundRect(localRectF, f1, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.g, this.g, this.d - this.g, this.e - this.g);
      paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, f1, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
      f2 = this.j / this.jdField_a_of_type_Float;
      f3 = this.e - this.g - (this.e - this.g * 2) * f2;
      this.jdField_c_of_type_AndroidGraphicsRectF.set(this.g, f3, this.d - this.g, this.e - this.g);
      if (f2 != 0.0F)
      {
        this.jdField_a_of_type_AndroidGraphicsShader = new LinearGradient(this.g, f3, this.d - this.g, this.e - this.g, this.i, this.h, Shader.TileMode.CLAMP);
        this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsShader);
      }
      paramCanvas.drawRoundRect(this.jdField_c_of_type_AndroidGraphicsRectF, f1, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setShader(null);
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
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if ((m != 1073741824) && (m != -2147483648)) {
      this.d = 0;
    } else {
      this.d = paramInt1;
    }
    if ((n != 1073741824) && (n != -2147483648)) {
      this.e = 0;
    } else {
      this.e = paramInt2;
    }
    setMeasuredDimension(this.d, this.e);
  }
  
  public void setMax(int paramInt)
  {
    if (paramInt >= 0)
    {
      float f1 = paramInt;
      try
      {
        this.jdField_a_of_type_Float = f1;
        return;
      }
      finally
      {
        break label31;
      }
    }
    throw new IllegalArgumentException("value can not be negative");
    label31:
    throw localObject;
  }
  
  public void setProgress(int paramInt, TextView paramTextView)
  {
    if (paramInt >= 0)
    {
      float f1 = paramInt;
      try
      {
        if (f1 > this.jdField_a_of_type_Float) {
          paramInt = (int)this.jdField_a_of_type_Float;
        }
        this.jdField_a_of_type_AndroidWidgetTextView = paramTextView;
        if (this.j != paramInt) {
          a(paramInt);
        } else {
          this.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramInt));
        }
        return;
      }
      finally
      {
        break label73;
      }
    }
    throw new IllegalArgumentException("value can not be negative");
    label73:
    throw paramTextView;
  }
  
  public void setProgressEndColor(int paramInt)
  {
    try
    {
      this.i = paramInt;
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
      this.h = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.CylinderProgressView
 * JD-Core Version:    0.7.0.1
 */