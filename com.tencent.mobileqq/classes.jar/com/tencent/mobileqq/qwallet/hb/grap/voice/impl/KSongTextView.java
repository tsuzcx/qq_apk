package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

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
import com.tencent.qphone.base.util.QLog;

public class KSongTextView
  extends TextView
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long = 50L;
  private LinearGradient jdField_a_of_type_AndroidGraphicsLinearGradient;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix;
  private KSHelper.KListener jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$KListener;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = 0L;
  
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
    //   2: getstatic 46	com/tencent/mobileqq/qqpay/ui/R$styleable:aO	[I
    //   5: iload_3
    //   6: iconst_0
    //   7: invokevirtual 52	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   10: astore_1
    //   11: aload_0
    //   12: aload_1
    //   13: getstatic 54	com/tencent/mobileqq/qqpay/ui/R$styleable:jdField_b_of_type_Int	I
    //   16: sipush -256
    //   19: invokevirtual 60	android/content/res/TypedArray:getColor	(II)I
    //   22: aload_1
    //   23: getstatic 61	com/tencent/mobileqq/qqpay/ui/R$styleable:jdField_a_of_type_Int	I
    //   26: iconst_m1
    //   27: invokevirtual 60	android/content/res/TypedArray:getColor	(II)I
    //   30: invokevirtual 64	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongTextView:a	(II)V
    //   33: aload_0
    //   34: aload_0
    //   35: invokevirtual 68	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongTextView:getCurrentTextColor	()I
    //   38: putfield 69	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongTextView:jdField_b_of_type_Int	I
    //   41: goto +10 -> 51
    //   44: astore_2
    //   45: aload_1
    //   46: invokevirtual 73	android/content/res/TypedArray:recycle	()V
    //   49: aload_2
    //   50: athrow
    //   51: aload_1
    //   52: invokevirtual 73	android/content/res/TypedArray:recycle	()V
    //   55: return
    //   56: astore_2
    //   57: goto -6 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	KSongTextView
    //   0	60	1	paramContext	Context
    //   0	60	2	paramAttributeSet	AttributeSet
    //   0	60	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   11	41	44	finally
    //   11	41	56	java/lang/Exception
  }
  
  public void a()
  {
    a(0.0F, 14, this.jdField_b_of_type_Int);
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2)
  {
    float f = getPaint().measureText(getText().toString());
    this.jdField_a_of_type_Float = (paramFloat * f);
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
  
  public void a(long paramLong, KSHelper.KListener paramKListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startDownTime = ");
    localStringBuilder.append(paramLong);
    QLog.i("KSongTextView", 2, localStringBuilder.toString());
    if (4 == getVisibility()) {
      setVisibility(0);
    }
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$KListener = paramKListener;
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
    paramCanvas = new StringBuilder();
    paramCanvas.append("type = ");
    paramCanvas.append(this.jdField_a_of_type_Int);
    QLog.i("KSongTextView", 2, paramCanvas.toString());
    if (this.jdField_a_of_type_Int == 0)
    {
      this.jdField_a_of_type_Float -= this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_Float <= 0.0F)
      {
        paramCanvas = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$KListener;
        if (paramCanvas != null) {
          paramCanvas.a();
        }
        setVisibility(4);
        return;
      }
      paramCanvas = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$KListener;
      if (paramCanvas != null) {
        paramCanvas.a(System.currentTimeMillis() - this.jdField_b_of_type_Long);
      }
      postInvalidateDelayed(this.jdField_a_of_type_Long);
    }
    this.jdField_a_of_type_AndroidGraphicsMatrix.setTranslate(this.jdField_a_of_type_Float, 0.0F);
    this.jdField_a_of_type_AndroidGraphicsLinearGradient.setLocalMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongTextView
 * JD-Core Version:    0.7.0.1
 */