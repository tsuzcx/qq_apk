package com.tencent.mobileqq.widget;

import adra;
import ahpm;
import ahpo;
import almt;
import alok;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.DynamicDrawableSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView.BufferType;
import axkd;
import axkk;
import axkm;
import bbgb;
import bbgc;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;

public class AnimationTextView
  extends PatchedTextView
  implements ahpm
{
  public float a;
  private int jdField_a_of_type_Int;
  protected ahpo a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  public bbgb a;
  public bbgc a;
  private boolean jdField_a_of_type_Boolean;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  private Drawable[] jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  public float b;
  private int jdField_b_of_type_Int;
  private MotionEvent jdField_b_of_type_AndroidViewMotionEvent;
  Runnable jdField_b_of_type_JavaLangRunnable = new AnimationTextView.1(this);
  private boolean jdField_b_of_type_Boolean;
  private Drawable[] jdField_b_of_type_ArrayOfAndroidGraphicsDrawableDrawable;
  private int jdField_c_of_type_Int = -5250572;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  public boolean g = true;
  public boolean h;
  
  public AnimationTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AnimationTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AnimationTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    int i = 0;
    float f1 = this.jdField_a_of_type_Float;
    float f3 = adra.e;
    float f2 = this.jdField_b_of_type_Float - adra.jdField_c_of_type_Int;
    almt localalmt = (almt)getTag(2131298155);
    Object localObject = (ChatMessage)getTag(2131298595);
    if (localObject != null) {}
    for (boolean bool = ((ChatMessage)localObject).isSend();; bool = false)
    {
      if (bool) {}
      for (f1 = this.jdField_a_of_type_Float - adra.f;; f1 -= f3)
      {
        localObject = getText();
        if ((localObject instanceof axkd))
        {
          localObject = (axkd)localObject;
          localObject = (axkk[])((axkd)localObject).getSpans(0, ((axkd)localObject).length(), axkk.class);
          int k;
          for (int j = 0; i < localObject.length; j = k)
          {
            axkm localaxkm = localObject[i];
            k = j;
            if ((localaxkm instanceof axkm))
            {
              localaxkm = (axkm)localaxkm;
              f3 = localaxkm.jdField_a_of_type_Float;
              float f4 = localaxkm.jdField_b_of_type_Float;
              float f5 = localaxkm.c;
              float f6 = localaxkm.d;
              k = j;
              if (f1 >= f3)
              {
                k = j;
                if (f1 <= f5)
                {
                  k = j;
                  if (f2 >= f4)
                  {
                    k = j;
                    if (f2 <= f6)
                    {
                      k = j;
                      if (j == 0) {
                        k = 1;
                      }
                    }
                  }
                }
              }
            }
            i += 1;
          }
          if (j != 0)
          {
            localObject = getBackground();
            if ((localObject == null) || (!(localObject instanceof alok))) {
              break label277;
            }
            ((alok)localObject).jdField_a_of_type_Boolean = true;
          }
        }
        label277:
        while ((localObject == null) || (localalmt == null)) {
          return;
        }
        localObject = getResources();
        if (bool) {}
        for (i = 2130848702;; i = 2130848509)
        {
          localalmt.a(this, ((Resources)localObject).getDrawable(i));
          return;
        }
      }
    }
  }
  
  private void a(Object paramObject)
  {
    Object localObject = getText();
    if ((localObject instanceof Spannable))
    {
      localObject = (Spannable)localObject;
      int j = ((Spannable)localObject).getSpanStart(paramObject);
      int k = ((Spannable)localObject).getSpanEnd(paramObject);
      SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])((Spannable)localObject).getSpans(j, k, SpanWatcher.class);
      if ((arrayOfSpanWatcher != null) && (arrayOfSpanWatcher.length > 0))
      {
        int m = arrayOfSpanWatcher.length;
        int i = 0;
        for (;;)
        {
          if (i < m)
          {
            SpanWatcher localSpanWatcher = arrayOfSpanWatcher[i];
            try
            {
              localSpanWatcher.onSpanChanged((Spannable)localObject, paramObject, j, k, j, k);
              i += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("AnimationTextView", 2, "Exception: " + localException.getMessage());
                }
              }
            }
          }
        }
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    Layout localLayout = getLayout();
    if (localLayout == null) {
      throw new RuntimeException("Has no layout.");
    }
    return (paramInt > 0) && (localLayout.getLineForOffset(paramInt) == localLayout.getLineForOffset(paramInt - 1) + 1);
  }
  
  public static boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, MotionEvent paramMotionEvent3)
  {
    if (paramMotionEvent3.getEventTime() - paramMotionEvent2.getEventTime() > 200L) {}
    int i;
    int j;
    do
    {
      return false;
      i = (int)paramMotionEvent2.getX() - (int)paramMotionEvent3.getX();
      j = (int)paramMotionEvent2.getY() - (int)paramMotionEvent3.getY();
    } while (i * i + j * j >= 10000);
    return true;
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    Layout localLayout = getLayout();
    if (localLayout != null)
    {
      int i = localLayout.getOffsetForHorizontal(localLayout.getLineForVertical(paramInt2), paramInt1);
      paramInt2 = i;
      if ((int)localLayout.getPrimaryHorizontal(i) > paramInt1) {
        paramInt2 = localLayout.getOffsetToLeftOf(i);
      }
      return paramInt2;
    }
    return -1;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    }
  }
  
  private int c(int paramInt1, int paramInt2)
  {
    int i = -1;
    d();
    int j = this.jdField_a_of_type_Ahpo.d();
    if (j == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AnimationTextView", 2, "detectIndexByOffsetSpring backport to detectIndexByOffset");
      }
      i = b(paramInt1, paramInt2);
    }
    Layout localLayout;
    do
    {
      return i;
      localLayout = getLayout();
    } while (localLayout == null);
    int k;
    if (j == 1)
    {
      i = this.jdField_a_of_type_Ahpo.b();
      k = localLayout.getLineForVertical(paramInt2);
      j = i;
      if (a(i))
      {
        m = (int)localLayout.getPrimaryHorizontal(i - 1);
        n = (int)localLayout.getLineRight(k);
        j = i;
        if (paramInt1 > n - (n - m) / 2) {
          j = i - 1;
        }
      }
      j = localLayout.getLineForOffset(j);
      int m = localLayout.getLineTop(j);
      int n = localLayout.getLineBottom(j);
      int i1 = (n - m) / 2;
      if (k == j + 1)
      {
        i = j;
        if (paramInt2 - n < i1) {}
      }
      else
      {
        if ((k != j - 1) || (m - paramInt2 >= i1)) {
          break label290;
        }
      }
    }
    label290:
    for (i = j;; i = k)
    {
      paramInt2 = localLayout.getOffsetForHorizontal(i, paramInt1);
      if ((paramInt2 < a() - 1) && (a(paramInt2 + 1)))
      {
        j = (int)localLayout.getPrimaryHorizontal(paramInt2);
        i = (int)localLayout.getLineRight(i);
        if (paramInt1 > i - (i - j) / 2)
        {
          return paramInt2 + 1;
          i = this.jdField_a_of_type_Ahpo.c();
          break;
        }
      }
      return paramInt2;
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    }
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Ahpo == null) {
      throw new RuntimeException("Select delegate has not bound.");
    }
  }
  
  public int a()
  {
    return getText().length();
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    paramInt1 = paramInt1 - this.jdField_a_of_type_ArrayOfInt[0] - getPaddingLeft();
    paramInt2 = paramInt2 - this.jdField_a_of_type_ArrayOfInt[1] - getPaddingTop();
    if (this.jdField_a_of_type_Ahpo == null) {
      return b(paramInt1, paramInt2);
    }
    return c(paramInt1, paramInt2);
  }
  
  @Nullable
  public ahpo a()
  {
    return this.jdField_a_of_type_Ahpo;
  }
  
  @Nullable
  public View a()
  {
    return this;
  }
  
  @Nullable
  public CharSequence a()
  {
    CharSequence localCharSequence = getText();
    if (localCharSequence != null) {
      return localCharSequence.toString();
    }
    return null;
  }
  
  public void a(@ColorInt int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == -1) || (paramInt2 == -1))
    {
      this.jdField_a_of_type_Int = -1;
      this.jdField_b_of_type_Int = -1;
      this.jdField_b_of_type_Boolean = false;
    }
    for (;;)
    {
      return;
      if (paramInt1 > paramInt2) {
        this.jdField_a_of_type_Int = paramInt2;
      }
      for (this.jdField_b_of_type_Int = paramInt1; this.jdField_b_of_type_Int - this.jdField_a_of_type_Int > 0; this.jdField_b_of_type_Int = paramInt2)
      {
        this.jdField_b_of_type_Boolean = true;
        return;
        this.jdField_a_of_type_Int = paramInt1;
      }
    }
  }
  
  public void a(int paramInt, @NonNull int[] paramArrayOfInt, boolean paramBoolean)
  {
    Layout localLayout = getLayout();
    if (localLayout == null)
    {
      paramArrayOfInt[0] = -1;
      paramArrayOfInt[1] = -1;
      return;
    }
    getLocationInWindow(paramArrayOfInt);
    paramArrayOfInt[0] = (paramArrayOfInt[0] + (int)localLayout.getPrimaryHorizontal(paramInt) + getPaddingLeft());
    int i = paramArrayOfInt[1];
    paramArrayOfInt[1] = (localLayout.getLineBottom(localLayout.getLineForOffset(paramInt)) + i + getPaddingTop());
  }
  
  public void a(@Nullable ahpo paramahpo)
  {
    this.jdField_a_of_type_Ahpo = paramahpo;
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (this.jdField_a_of_type_Ahpo == null) {
      throw new IllegalStateException("Has no bound delegate!");
    }
    this.jdField_a_of_type_Ahpo.a(paramChatMessage);
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  @Nullable
  public CharSequence b()
  {
    CharSequence localCharSequence = a();
    if (localCharSequence != null) {
      return localCharSequence.subSequence(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    }
    return null;
  }
  
  public int c()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int d()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void f()
  {
    if (!h()) {
      g();
    }
    Layout localLayout = getLayout();
    if (localLayout == null) {
      return;
    }
    b();
    c();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    localLayout.getSelectionPath(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPath);
    invalidate();
  }
  
  public void g()
  {
    this.jdField_a_of_type_Boolean = false;
    invalidate();
  }
  
  public boolean h()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    super.invalidateDrawable(paramDrawable);
    Object localObject1 = getText();
    if ((localObject1 instanceof Spannable))
    {
      localObject1 = (Spannable)localObject1;
      localObject1 = (axkk[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), axkk.class);
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        this.jdField_d_of_type_Boolean = true;
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (localObject2.a() == paramDrawable) {
            a(localObject2);
          }
          i += 1;
        }
        this.jdField_d_of_type_Boolean = false;
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      paramCanvas.translate(getPaddingLeft(), getPaddingTop());
      paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.translate(-getPaddingLeft(), -getPaddingTop());
    }
    if (this.e)
    {
      int i = getCurrentTextColor();
      getPaint().setStyle(Paint.Style.STROKE);
      getPaint().setStrokeWidth(3.0F);
      setTextColor(this.jdField_d_of_type_Int);
      super.onDraw(paramCanvas);
      getPaint().setStyle(Paint.Style.FILL);
      setTextColor(i);
      super.onDraw(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Bbgb != null) {
      if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (paramMotionEvent.getAction() == 0))
      {
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
        a();
        this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) && (this.jdField_a_of_type_AndroidViewMotionEvent != null) && (a(this.jdField_a_of_type_AndroidViewMotionEvent, this.jdField_b_of_type_AndroidViewMotionEvent, paramMotionEvent)))
        {
          this.g = false;
          this.jdField_a_of_type_AndroidViewMotionEvent = null;
          this.jdField_b_of_type_AndroidViewMotionEvent = null;
          if (this.jdField_a_of_type_Bbgb != null)
          {
            this.jdField_a_of_type_Bbgb.a(this);
            this.h = true;
            if (QLog.isColorLevel()) {
              QLog.d("AnimationTextView", 2, "DoubleClick invoked");
            }
            return true;
          }
        }
      }
      else
      {
        if ((this.jdField_b_of_type_AndroidViewMotionEvent != null) || (paramMotionEvent.getAction() != 0)) {
          break label192;
        }
        this.g = true;
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
        this.jdField_b_of_type_Float = paramMotionEvent.getY();
        a();
        if (QLog.isColorLevel()) {
          QLog.d("AnimationTextView", 2, "reserve to initial status");
        }
      }
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      label192:
      if (paramMotionEvent.getAction() == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("AnimationTextView", 2, "action up");
        }
        if (getLayout() == null) {
          return super.onTouchEvent(paramMotionEvent);
        }
        this.jdField_b_of_type_AndroidViewMotionEvent = MotionEvent.obtain(paramMotionEvent);
        if (this.h)
        {
          this.h = false;
          this.jdField_b_of_type_AndroidViewMotionEvent = null;
        }
        postDelayed(this.jdField_b_of_type_JavaLangRunnable, 200L);
      }
    }
  }
  
  public void requestLayout()
  {
    if (!this.jdField_d_of_type_Boolean) {
      super.requestLayout();
    }
  }
  
  public void setStrokeColor(boolean paramBoolean, int paramInt)
  {
    this.e = paramBoolean;
    this.jdField_d_of_type_Int = paramInt;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    int j = 0;
    Object localObject = getText();
    super.setText(paramCharSequence, paramBufferType);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_ArrayOfAndroidGraphicsDrawableDrawable = null;
    if ((localObject != paramCharSequence) && ((getText() instanceof Spanned)))
    {
      paramCharSequence = (Spanned)getText();
      paramBufferType = (axkk[])paramCharSequence.getSpans(0, paramCharSequence.length(), axkk.class);
      localObject = new Drawable[paramBufferType.length];
      int i = 0;
      while (i < paramBufferType.length)
      {
        localObject[i] = paramBufferType[i].a();
        if (localObject[i] != null) {
          localObject[i].setCallback(this);
        }
        i += 1;
      }
      this.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = ((Drawable[])localObject);
      paramCharSequence = (DynamicDrawableSpan[])paramCharSequence.getSpans(0, paramCharSequence.length(), DynamicDrawableSpan.class);
      paramBufferType = new Drawable[paramCharSequence.length];
      i = j;
      while (i < paramCharSequence.length)
      {
        paramBufferType[i] = paramCharSequence[i].getDrawable();
        if (paramBufferType[i] != null) {
          paramBufferType[i].setCallback(this);
        }
        i += 1;
      }
      this.jdField_b_of_type_ArrayOfAndroidGraphicsDrawableDrawable = paramBufferType;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationTextView
 * JD-Core Version:    0.7.0.1
 */