package com.tencent.mobileqq.widget.ksong;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;
import bidw;
import com.tencent.qphone.base.util.QLog;

public class KSongTextView
  extends TextView
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 50L;
  private LinearGradient jdField_a_of_type_AndroidGraphicsLinearGradient;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private bidw jdField_a_of_type_Bidw;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  public KSongTextView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public KSongTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @SuppressLint({"NewApi"})
  public KSongTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  /* Error */
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: getstatic 42	com/tencent/mobileqq/R$styleable:Qwsong	[I
    //   5: iload_3
    //   6: iconst_0
    //   7: invokevirtual 48	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   10: astore_1
    //   11: aload_0
    //   12: aload_1
    //   13: iconst_1
    //   14: sipush -256
    //   17: invokevirtual 54	android/content/res/TypedArray:getColor	(II)I
    //   20: aload_1
    //   21: iconst_0
    //   22: iconst_m1
    //   23: invokevirtual 54	android/content/res/TypedArray:getColor	(II)I
    //   26: invokevirtual 57	com/tencent/mobileqq/widget/ksong/KSongTextView:a	(II)V
    //   29: aload_0
    //   30: aload_0
    //   31: invokevirtual 61	com/tencent/mobileqq/widget/ksong/KSongTextView:getCurrentTextColor	()I
    //   34: putfield 63	com/tencent/mobileqq/widget/ksong/KSongTextView:jdField_b_of_type_Int	I
    //   37: aload_1
    //   38: invokevirtual 67	android/content/res/TypedArray:recycle	()V
    //   41: return
    //   42: astore_2
    //   43: aload_1
    //   44: invokevirtual 67	android/content/res/TypedArray:recycle	()V
    //   47: return
    //   48: astore_2
    //   49: aload_1
    //   50: invokevirtual 67	android/content/res/TypedArray:recycle	()V
    //   53: aload_2
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	KSongTextView
    //   0	55	1	paramContext	Context
    //   0	55	2	paramAttributeSet	AttributeSet
    //   0	55	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   11	37	42	java/lang/Exception
    //   11	37	48	finally
  }
  
  public void a()
  {
    a(0.0F, 14, this.jdField_b_of_type_Int);
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2)
  {
    float f = getPaint().measureText(getText().toString());
    this.jdField_a_of_type_Float = (f * paramFloat);
    if (this.jdField_a_of_type_Float > f) {
      this.jdField_a_of_type_Float = f;
    }
    if (paramInt1 > 0) {
      setTextSize(2, paramInt1);
    }
    setTextColor(paramInt2);
    postInvalidate();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = getPaint();
    Object localObject2 = Shader.TileMode.CLAMP;
    localObject2 = new LinearGradient(-1.0F, 0.0F, 0.0F, 0.0F, new int[] { paramInt1, paramInt2 }, null, (Shader.TileMode)localObject2);
    this.jdField_a_of_type_AndroidGraphicsLinearGradient = ((LinearGradient)localObject2);
    ((TextPaint)localObject1).setShader((Shader)localObject2);
    localObject1 = this.jdField_a_of_type_AndroidGraphicsLinearGradient;
    localObject2 = new Matrix();
    this.jdField_a_of_type_AndroidGraphicsMatrix = ((Matrix)localObject2);
    ((LinearGradient)localObject1).setLocalMatrix((Matrix)localObject2);
  }
  
  public void a(long paramLong, bidw parambidw)
  {
    QLog.i("KSongTextView", 2, "startDownTime = " + paramLong);
    if (4 == getVisibility()) {
      setVisibility(0);
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Bidw = parambidw;
    this.jdField_a_of_type_Float = getPaint().measureText(getText().toString());
    paramLong /= this.jdField_a_of_type_Long;
    this.jdField_b_of_type_Float = (this.jdField_a_of_type_Float / (float)paramLong);
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    postInvalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_AndroidGraphicsMatrix == null) {
      return;
    }
    QLog.i("KSongTextView", 2, "type = " + this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Float -= this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_Float <= 0.0F)
      {
        if (this.jdField_a_of_type_Bidw != null) {
          this.jdField_a_of_type_Bidw.a();
        }
        setVisibility(4);
        return;
      }
      if (this.jdField_a_of_type_Bidw != null) {
        this.jdField_a_of_type_Bidw.a(System.currentTimeMillis() - this.jdField_b_of_type_Long);
      }
      postInvalidateDelayed(this.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(this.jdField_a_of_type_Float, 0.0F);
    this.jdField_a_of_type_AndroidGraphicsLinearGradient.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ksong.KSongTextView
 * JD-Core Version:    0.7.0.1
 */