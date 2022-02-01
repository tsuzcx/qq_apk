package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

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
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

public class KSongProsBar
  extends View
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private KSHelper.Config jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$Config;
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
    //   2: getstatic 131	com/tencent/mobileqq/qqpay/ui/R$styleable:aO	[I
    //   5: iload_3
    //   6: iconst_0
    //   7: invokevirtual 135	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   10: astore_2
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: getstatic 137	com/tencent/mobileqq/qqpay/ui/R$styleable:jdField_b_of_type_Int	I
    //   17: sipush -256
    //   20: invokevirtual 143	android/content/res/TypedArray:getColor	(II)I
    //   23: aload_2
    //   24: getstatic 145	com/tencent/mobileqq/qqpay/ui/R$styleable:jdField_a_of_type_Int	I
    //   27: iconst_m1
    //   28: invokevirtual 143	android/content/res/TypedArray:getColor	(II)I
    //   31: aload_2
    //   32: getstatic 147	com/tencent/mobileqq/qqpay/ui/R$styleable:jdField_c_of_type_Int	I
    //   35: sipush -256
    //   38: invokevirtual 143	android/content/res/TypedArray:getColor	(II)I
    //   41: invokespecial 149	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongProsBar:a	(Landroid/content/Context;III)V
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 46	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongProsBar:g	I
    //   49: putfield 150	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongProsBar:jdField_c_of_type_Int	I
    //   52: aload_0
    //   53: aload_0
    //   54: ldc 151
    //   56: invokevirtual 119	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongProsBar:a	(F)I
    //   59: putfield 153	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongProsBar:d	I
    //   62: goto +10 -> 72
    //   65: astore_1
    //   66: aload_2
    //   67: invokevirtual 156	android/content/res/TypedArray:recycle	()V
    //   70: aload_1
    //   71: athrow
    //   72: aload_2
    //   73: invokevirtual 156	android/content/res/TypedArray:recycle	()V
    //   76: return
    //   77: astore_1
    //   78: goto -6 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	KSongProsBar
    //   0	81	1	paramContext	Context
    //   0	81	2	paramAttributeSet	AttributeSet
    //   0	81	3	paramInt	int
    // Exception table:
    //   from	to	target	type
    //   11	62	65	finally
    //   11	62	77	java/lang/Exception
  }
  
  protected final int a(float paramFloat)
  {
    return DisplayUtil.a(getContext(), paramFloat);
  }
  
  public void a(long paramLong)
  {
    if ((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$Config != null))
    {
      this.jdField_a_of_type_JavaLangString = a(paramLong);
      float f1 = (float)paramLong / (float)this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$Config.e;
      this.jdField_c_of_type_Int = ((int)(this.jdField_a_of_type_Int * f1));
      postInvalidate();
      return;
    }
    QLog.i("KSongProsBar", 2, "error call, not initialized...");
  }
  
  public void a(KSHelper.Config paramConfig)
  {
    if (paramConfig == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapVoiceImplKSHelper$Config = paramConfig;
    this.jdField_b_of_type_JavaLangString = a(paramConfig.e);
    this.jdField_a_of_type_JavaLangString = a(0L);
    postInvalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    int i = this.e;
    localRectF.set(0.0F, i, this.jdField_a_of_type_Int, i + this.h);
    localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    i = this.g;
    paramCanvas.drawRoundRect(localRectF, i, i, this.jdField_a_of_type_AndroidGraphicsPaint);
    localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    i = this.e;
    localRectF.set(0.0F, i, this.jdField_c_of_type_Int, i + this.h);
    localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    i = this.g;
    paramCanvas.drawRoundRect(localRectF, i, i, this.jdField_c_of_type_AndroidGraphicsPaint);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("w = ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject).append(" h = ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Int);
    QLog.i("KSongProsBar", 2, ((StringBuilder)localObject).toString());
    if ((this.jdField_a_of_type_Int > 0) || (this.jdField_b_of_type_Int > 0))
    {
      localObject = new Rect();
      this.jdField_b_of_type_AndroidGraphicsPaint.getTextBounds("00:00", 0, 5, (Rect)localObject);
      this.f = ((Rect)localObject).width();
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongProsBar
 * JD-Core Version:    0.7.0.1
 */