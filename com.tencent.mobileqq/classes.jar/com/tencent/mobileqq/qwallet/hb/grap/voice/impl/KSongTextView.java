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
  private LinearGradient a;
  private Matrix b;
  private float c = 0.0F;
  private long d = 50L;
  private float e = 0.0F;
  private int f = 1;
  private KSHelper.KListener g;
  private int h;
  private long i = 0L;
  
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
    //   2: getstatic 53	com/tencent/mobileqq/qqpay/ui/R$styleable:aT	[I
    //   5: iload_3
    //   6: iconst_0
    //   7: invokevirtual 59	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   10: astore_1
    //   11: aload_0
    //   12: aload_1
    //   13: getstatic 62	com/tencent/mobileqq/qqpay/ui/R$styleable:aV	I
    //   16: sipush -256
    //   19: invokevirtual 68	android/content/res/TypedArray:getColor	(II)I
    //   22: aload_1
    //   23: getstatic 71	com/tencent/mobileqq/qqpay/ui/R$styleable:aU	I
    //   26: iconst_m1
    //   27: invokevirtual 68	android/content/res/TypedArray:getColor	(II)I
    //   30: invokevirtual 74	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongTextView:a	(II)V
    //   33: aload_0
    //   34: aload_0
    //   35: invokevirtual 78	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongTextView:getCurrentTextColor	()I
    //   38: putfield 80	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongTextView:h	I
    //   41: goto +10 -> 51
    //   44: astore_2
    //   45: aload_1
    //   46: invokevirtual 84	android/content/res/TypedArray:recycle	()V
    //   49: aload_2
    //   50: athrow
    //   51: aload_1
    //   52: invokevirtual 84	android/content/res/TypedArray:recycle	()V
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
    a(0.0F, 14, this.h);
  }
  
  public void a(float paramFloat, int paramInt1, int paramInt2)
  {
    float f1 = getPaint().measureText(getText().toString());
    this.c = (paramFloat * f1);
    if (this.c > f1) {
      this.c = f1;
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
    this.a = ((LinearGradient)localObject2);
    ((TextPaint)localObject1).setShader((Shader)localObject2);
    localObject1 = this.a;
    localObject2 = new Matrix();
    this.b = ((Matrix)localObject2);
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
    this.f = 0;
    this.g = paramKListener;
    this.c = getPaint().measureText(getText().toString());
    paramLong /= this.d;
    this.e = (this.c / (float)paramLong);
    this.i = System.currentTimeMillis();
    postInvalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.b == null) {
      return;
    }
    paramCanvas = new StringBuilder();
    paramCanvas.append("type = ");
    paramCanvas.append(this.f);
    QLog.i("KSongTextView", 2, paramCanvas.toString());
    if (this.f == 0)
    {
      this.c -= this.e;
      if (this.c <= 0.0F)
      {
        paramCanvas = this.g;
        if (paramCanvas != null) {
          paramCanvas.a();
        }
        setVisibility(4);
        return;
      }
      paramCanvas = this.g;
      if (paramCanvas != null) {
        paramCanvas.a(System.currentTimeMillis() - this.i);
      }
      postInvalidateDelayed(this.d);
    }
    this.b.setTranslate(this.c, 0.0F);
    this.a.setLocalMatrix(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongTextView
 * JD-Core Version:    0.7.0.1
 */