package com.tencent.mobileqq.widget.ksong;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import bhky;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KSongProsBar
  extends View
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private bhky jdField_a_of_type_Bhky;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint = new Paint();
  private int d;
  private int e;
  private int f;
  private int g = 3;
  private int h = 10;
  
  public KSongProsBar(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public KSongProsBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @SuppressLint({"NewApi"})
  public KSongProsBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private String a(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat("mm:ss").format(localDate);
  }
  
  private void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext.getResources();
    paramContext = new Paint();
    paramContext.setAntiAlias(true);
    paramContext.setStrokeJoin(Paint.Join.ROUND);
    paramContext.setStrokeCap(Paint.Cap.ROUND);
    paramContext.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(paramContext);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt2);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(paramContext);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt3);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(a(10.0F));
  }
  
  /* Error */
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: getstatic 131	com/tencent/mobileqq/R$styleable:Qwsong	[I
    //   5: iload_3
    //   6: iconst_0
    //   7: invokevirtual 135	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   10: astore_2
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: iconst_1
    //   15: sipush -256
    //   18: invokevirtual 141	android/content/res/TypedArray:getColor	(II)I
    //   21: aload_2
    //   22: iconst_0
    //   23: iconst_m1
    //   24: invokevirtual 141	android/content/res/TypedArray:getColor	(II)I
    //   27: aload_2
    //   28: iconst_2
    //   29: sipush -256
    //   32: invokevirtual 141	android/content/res/TypedArray:getColor	(II)I
    //   35: invokespecial 143	com/tencent/mobileqq/widget/ksong/KSongProsBar:a	(Landroid/content/Context;III)V
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 46	com/tencent/mobileqq/widget/ksong/KSongProsBar:g	I
    //   43: putfield 145	com/tencent/mobileqq/widget/ksong/KSongProsBar:jdField_c_of_type_Int	I
    //   46: aload_0
    //   47: aload_0
    //   48: ldc 146
    //   50: invokevirtual 119	com/tencent/mobileqq/widget/ksong/KSongProsBar:a	(F)I
    //   53: putfield 148	com/tencent/mobileqq/widget/ksong/KSongProsBar:d	I
    //   56: aload_2
    //   57: invokevirtual 151	android/content/res/TypedArray:recycle	()V
    //   60: return
    //   61: astore_1
    //   62: aload_2
    //   63: invokevirtual 151	android/content/res/TypedArray:recycle	()V
    //   66: return
    //   67: astore_1
    //   68: aload_2
    //   69: invokevirtual 151	android/content/res/TypedArray:recycle	()V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	KSongProsBar
    //   0	74	1	paramContext	Context
    //   0	74	2	paramAttributeSet	AttributeSet
    //   0	74	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   11	56	61	java/lang/Exception
    //   11	56	67	finally
  }
  
  protected final int a(float paramFloat)
  {
    return AIOUtils.dp2px(paramFloat, getResources());
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_Int <= 0) || (this.jdField_a_of_type_Bhky == null))
    {
      QLog.i("KSongProsBar", 2, "error call, not initialized...");
      return;
    }
    this.jdField_a_of_type_JavaLangString = a(paramLong);
    this.jdField_c_of_type_Int = ((int)((float)paramLong / (float)this.jdField_a_of_type_Bhky.e * this.jdField_a_of_type_Int));
    postInvalidate();
  }
  
  public void a(bhky parambhky)
  {
    if (parambhky == null) {
      return;
    }
    this.jdField_a_of_type_Bhky = parambhky;
    this.jdField_b_of_type_JavaLangString = a(parambhky.e);
    this.jdField_a_of_type_JavaLangString = a(0L);
    postInvalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, this.e, this.jdField_a_of_type_Int, this.e + this.h);
    paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.g, this.g, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, this.e, this.jdField_c_of_type_Int, this.e + this.h);
    paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.g, this.g, this.jdField_c_of_type_AndroidGraphicsPaint);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, 0.0F, this.e + this.d, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      paramCanvas.drawText(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Int - this.f, this.e + this.d, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = getMeasuredWidth();
    paramInt1 = getMeasuredHeight();
    this.jdField_b_of_type_Int = paramInt1;
    this.e = (paramInt1 / 3);
    QLog.i("KSongProsBar", 2, "w = " + this.jdField_a_of_type_Int + " h = " + this.jdField_b_of_type_Int);
    if ((this.jdField_a_of_type_Int > 0) || (this.jdField_b_of_type_Int > 0))
    {
      Rect localRect = new Rect();
      this.jdField_b_of_type_AndroidGraphicsPaint.getTextBounds("00:00", 0, "00:00".length(), localRect);
      this.f = localRect.width();
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ksong.KSongProsBar
 * JD-Core Version:    0.7.0.1
 */