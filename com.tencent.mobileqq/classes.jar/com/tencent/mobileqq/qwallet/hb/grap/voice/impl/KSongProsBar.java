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
  private Paint a = new Paint();
  private Paint b = new Paint();
  private Paint c = new Paint();
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private String i;
  private String j;
  private int k;
  private KSHelper.Config l;
  private RectF m = new RectF();
  private int n = 3;
  private int o = 10;
  
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
  
  private void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext.getResources();
    paramContext = new Paint();
    paramContext.setAntiAlias(true);
    paramContext.setStrokeJoin(Paint.Join.ROUND);
    paramContext.setStrokeCap(Paint.Cap.ROUND);
    paramContext.setStyle(Paint.Style.FILL);
    this.c = new Paint(paramContext);
    this.c.setColor(paramInt1);
    this.a = new Paint(paramContext);
    this.a.setColor(paramInt2);
    this.b = new Paint(paramContext);
    this.b.setColor(paramInt3);
    this.b.setTextSize(a(10.0F));
  }
  
  /* Error */
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: aload_2
    //   2: getstatic 121	com/tencent/mobileqq/qqpay/ui/R$styleable:aT	[I
    //   5: iload_3
    //   6: iconst_0
    //   7: invokevirtual 125	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   10: astore_2
    //   11: aload_0
    //   12: aload_1
    //   13: aload_2
    //   14: getstatic 128	com/tencent/mobileqq/qqpay/ui/R$styleable:aV	I
    //   17: sipush -256
    //   20: invokevirtual 134	android/content/res/TypedArray:getColor	(II)I
    //   23: aload_2
    //   24: getstatic 137	com/tencent/mobileqq/qqpay/ui/R$styleable:aU	I
    //   27: iconst_m1
    //   28: invokevirtual 134	android/content/res/TypedArray:getColor	(II)I
    //   31: aload_2
    //   32: getstatic 140	com/tencent/mobileqq/qqpay/ui/R$styleable:aW	I
    //   35: sipush -256
    //   38: invokevirtual 134	android/content/res/TypedArray:getColor	(II)I
    //   41: invokespecial 142	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongProsBar:a	(Landroid/content/Context;III)V
    //   44: aload_0
    //   45: aload_0
    //   46: getfield 53	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongProsBar:n	I
    //   49: putfield 144	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongProsBar:f	I
    //   52: aload_0
    //   53: aload_0
    //   54: ldc 145
    //   56: invokevirtual 109	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongProsBar:a	(F)I
    //   59: putfield 147	com/tencent/mobileqq/qwallet/hb/grap/voice/impl/KSongProsBar:g	I
    //   62: goto +10 -> 72
    //   65: astore_1
    //   66: aload_2
    //   67: invokevirtual 150	android/content/res/TypedArray:recycle	()V
    //   70: aload_1
    //   71: athrow
    //   72: aload_2
    //   73: invokevirtual 150	android/content/res/TypedArray:recycle	()V
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
  
  private String b(long paramLong)
  {
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat("mm:ss").format(localDate);
  }
  
  protected final int a(float paramFloat)
  {
    return DisplayUtil.a(getContext(), paramFloat);
  }
  
  public void a(long paramLong)
  {
    if ((this.d > 0) && (this.l != null))
    {
      this.i = b(paramLong);
      float f1 = (float)paramLong / (float)this.l.g;
      this.f = ((int)(this.d * f1));
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
    this.l = paramConfig;
    this.j = b(paramConfig.g);
    this.i = b(0L);
    postInvalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    RectF localRectF = this.m;
    int i1 = this.h;
    localRectF.set(0.0F, i1, this.d, i1 + this.o);
    localRectF = this.m;
    i1 = this.n;
    paramCanvas.drawRoundRect(localRectF, i1, i1, this.a);
    localRectF = this.m;
    i1 = this.h;
    localRectF.set(0.0F, i1, this.f, i1 + this.o);
    localRectF = this.m;
    i1 = this.n;
    paramCanvas.drawRoundRect(localRectF, i1, i1, this.c);
    if (!TextUtils.isEmpty(this.i)) {
      paramCanvas.drawText(this.i, 0.0F, this.h + this.g, this.b);
    }
    if (!TextUtils.isEmpty(this.j)) {
      paramCanvas.drawText(this.j, this.d - this.k, this.h + this.g, this.b);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.d = getMeasuredWidth();
    paramInt1 = getMeasuredHeight();
    this.e = paramInt1;
    this.h = (paramInt1 / 3);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("w = ");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(" h = ");
    ((StringBuilder)localObject).append(this.e);
    QLog.i("KSongProsBar", 2, ((StringBuilder)localObject).toString());
    if ((this.d > 0) || (this.e > 0))
    {
      localObject = new Rect();
      this.b.getTextBounds("00:00", 0, 5, (Rect)localObject);
      this.k = ((Rect)localObject).width();
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongProsBar
 * JD-Core Version:    0.7.0.1
 */