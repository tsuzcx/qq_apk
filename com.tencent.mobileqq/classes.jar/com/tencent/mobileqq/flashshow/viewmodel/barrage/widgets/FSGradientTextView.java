package com.tencent.mobileqq.flashshow.viewmodel.barrage.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.ViewUtils;

@SuppressLint({"AppCompatCustomView"})
public class FSGradientTextView
  extends FSBlackStrokeTextView
{
  private int a;
  private int d;
  private int e;
  
  public FSGradientTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FSGradientTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FSGradientTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    TextPaint localTextPaint = getPaint();
    Object localObject = getText();
    if (localTextPaint != null)
    {
      if (localObject == null) {
        return;
      }
      float f1 = localTextPaint.getTextSize();
      float f2 = ((CharSequence)localObject).length();
      int i = ViewUtils.dpToPx(1.0F);
      localObject = Shader.TileMode.CLAMP;
      localTextPaint.setShader(new LinearGradient(0.0F, 0.0F, f1 * f2, 0.0F, this.a, this.d, (Shader.TileMode)localObject));
      localTextPaint.setShadowLayer(0.0F, 0.0F, i, this.e);
      invalidate();
    }
  }
  
  private void a(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    this.a = paramContext.getResources().getColor(2131166083);
    this.d = paramContext.getResources().getColor(2131166081);
    this.e = paramContext.getResources().getColor(2131166082);
    a(paramAttributeSet);
  }
  
  /* Error */
  private void a(AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore_3
    //   9: aload_0
    //   10: invokevirtual 104	com/tencent/mobileqq/flashshow/viewmodel/barrage/widgets/FSGradientTextView:getContext	()Landroid/content/Context;
    //   13: aload_1
    //   14: getstatic 110	com/tencent/biz/flashshow/impl/R$styleable:bc	[I
    //   17: invokevirtual 114	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;
    //   20: astore_1
    //   21: aload_1
    //   22: astore_3
    //   23: aload_1
    //   24: astore_2
    //   25: aload_0
    //   26: aload_1
    //   27: getstatic 117	com/tencent/biz/flashshow/impl/R$styleable:bf	I
    //   30: aload_0
    //   31: getfield 62	com/tencent/mobileqq/flashshow/viewmodel/barrage/widgets/FSGradientTextView:a	I
    //   34: invokevirtual 122	android/content/res/TypedArray:getColor	(II)I
    //   37: putfield 62	com/tencent/mobileqq/flashshow/viewmodel/barrage/widgets/FSGradientTextView:a	I
    //   40: aload_1
    //   41: astore_3
    //   42: aload_1
    //   43: astore_2
    //   44: aload_0
    //   45: aload_1
    //   46: getstatic 125	com/tencent/biz/flashshow/impl/R$styleable:bd	I
    //   49: aload_0
    //   50: getfield 64	com/tencent/mobileqq/flashshow/viewmodel/barrage/widgets/FSGradientTextView:d	I
    //   53: invokevirtual 122	android/content/res/TypedArray:getColor	(II)I
    //   56: putfield 64	com/tencent/mobileqq/flashshow/viewmodel/barrage/widgets/FSGradientTextView:d	I
    //   59: aload_1
    //   60: astore_3
    //   61: aload_1
    //   62: astore_2
    //   63: aload_0
    //   64: aload_1
    //   65: getstatic 128	com/tencent/biz/flashshow/impl/R$styleable:be	I
    //   68: aload_0
    //   69: getfield 73	com/tencent/mobileqq/flashshow/viewmodel/barrage/widgets/FSGradientTextView:e	I
    //   72: invokevirtual 122	android/content/res/TypedArray:getColor	(II)I
    //   75: putfield 73	com/tencent/mobileqq/flashshow/viewmodel/barrage/widgets/FSGradientTextView:e	I
    //   78: aload_1
    //   79: ifnull +32 -> 111
    //   82: goto +25 -> 107
    //   85: astore_1
    //   86: goto +26 -> 112
    //   89: astore_1
    //   90: aload_2
    //   91: astore_3
    //   92: ldc 130
    //   94: iconst_1
    //   95: ldc 132
    //   97: aload_1
    //   98: invokestatic 137	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   101: aload_2
    //   102: ifnull +9 -> 111
    //   105: aload_2
    //   106: astore_1
    //   107: aload_1
    //   108: invokevirtual 140	android/content/res/TypedArray:recycle	()V
    //   111: return
    //   112: aload_3
    //   113: ifnull +7 -> 120
    //   116: aload_3
    //   117: invokevirtual 140	android/content/res/TypedArray:recycle	()V
    //   120: aload_1
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	FSGradientTextView
    //   0	122	1	paramAttributeSet	AttributeSet
    //   6	100	2	localAttributeSet1	AttributeSet
    //   8	109	3	localAttributeSet2	AttributeSet
    // Exception table:
    //   from	to	target	type
    //   9	21	85	finally
    //   25	40	85	finally
    //   44	59	85	finally
    //   63	78	85	finally
    //   92	101	85	finally
    //   9	21	89	java/lang/Throwable
    //   25	40	89	java/lang/Throwable
    //   44	59	89	java/lang/Throwable
    //   63	78	89	java/lang/Throwable
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(paramCharSequence, paramBufferType);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.viewmodel.barrage.widgets.FSGradientTextView
 * JD-Core Version:    0.7.0.1
 */