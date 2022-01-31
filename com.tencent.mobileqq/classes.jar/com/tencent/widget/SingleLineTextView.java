package com.tencent.widget;

import amky;
import amkz;
import amla;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.text.QQText.EmoticonSpan;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.qphone.base.util.QLog;

public class SingleLineTextView
  extends View
  implements Handler.Callback
{
  private static final BoringLayout.Metrics jdField_a_of_type_AndroidTextBoringLayout$Metrics = new BoringLayout.Metrics();
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private amky jdField_a_of_type_Amky;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private BoringLayout jdField_a_of_type_AndroidTextBoringLayout;
  protected Layout a;
  private final TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private TextUtils.TruncateAt jdField_a_of_type_AndroidTextTextUtils$TruncateAt;
  private TransformationMethod jdField_a_of_type_AndroidTextMethodTransformationMethod;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private final amkz[] jdField_a_of_type_ArrayOfAmkz;
  private amla[] jdField_a_of_type_ArrayOfAmla;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = -16777216;
  private BoringLayout.Metrics jdField_b_of_type_AndroidTextBoringLayout$Metrics;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  private int e = 2147483647;
  private int f = 16;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  
  public SingleLineTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SingleLineTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SingleLineTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = getResources();
    this.jdField_a_of_type_JavaLangCharSequence = "";
    this.jdField_b_of_type_JavaLangCharSequence = "";
    this.jdField_a_of_type_AndroidTextTextPaint = new TextPaint(1);
    this.jdField_a_of_type_AndroidTextTextPaint.density = ((Resources)localObject).getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidTextMethodTransformationMethod = SingleLineTransformationMethod.getInstance();
    this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt = TextUtils.TruncateAt.END;
    this.jdField_a_of_type_Boolean = true;
    this.g = -1;
    this.jdField_a_of_type_ArrayOfAmkz = new amkz[3];
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_c_of_type_Int = 0;
    this.d = 0;
    this.k = 0;
    this.j = 0;
    this.i = 0;
    this.h = 0;
    this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-16777216);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SingleLineTextView);
      paramInt = paramAttributeSet.getDimensionPixelSize(0, (int)DisplayUtils.a(paramContext, 12.0F));
      paramContext = paramAttributeSet.getColorStateList(1);
      localObject = paramAttributeSet.getString(3);
      this.e = paramAttributeSet.getDimensionPixelSize(2, 2147483647);
      this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramInt);
      setTextColor(paramContext);
      setText((CharSequence)localObject);
      this.jdField_b_of_type_Boolean = paramAttributeSet.getBoolean(4, true);
      paramAttributeSet.recycle();
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams.width != -2)
    {
      int i1 = getWidth() - a() - b();
      if (i1 > 0)
      {
        int i2 = this.jdField_a_of_type_AndroidTextLayout.getHeight();
        a(this.jdField_a_of_type_AndroidTextLayout.getWidth(), jdField_a_of_type_AndroidTextBoringLayout$Metrics, i1);
        if ((localLayoutParams.height != -2) && (localLayoutParams.height != -1))
        {
          invalidate();
          return;
        }
        if (this.jdField_a_of_type_AndroidTextLayout.getHeight() == i2)
        {
          invalidate();
          return;
        }
        requestLayout();
        invalidate();
        return;
      }
    }
    b();
    requestLayout();
    invalidate();
  }
  
  private void a(Object paramObject)
  {
    Object localObject = a();
    if ((localObject instanceof Spannable))
    {
      localObject = (Spannable)localObject;
      int i2 = ((Spannable)localObject).getSpanStart(paramObject);
      int i3 = ((Spannable)localObject).getSpanEnd(paramObject);
      SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])((Spannable)localObject).getSpans(i2, i3, SpanWatcher.class);
      if ((arrayOfSpanWatcher != null) && (arrayOfSpanWatcher.length > 0))
      {
        int i4 = arrayOfSpanWatcher.length;
        int i1 = 0;
        for (;;)
        {
          if (i1 < i4)
          {
            SpanWatcher localSpanWatcher = arrayOfSpanWatcher[i1];
            try
            {
              localSpanWatcher.onSpanChanged((Spannable)localObject, paramObject, i2, i3, i2, i3);
              i1 += 1;
            }
            catch (Exception localException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("SingleLineTextView", 2, "Exception: " + localException.getMessage());
                }
              }
            }
          }
        }
      }
    }
  }
  
  private void b()
  {
    if (((this.jdField_a_of_type_AndroidTextLayout instanceof BoringLayout)) && (this.jdField_a_of_type_AndroidTextBoringLayout == null)) {
      this.jdField_a_of_type_AndroidTextBoringLayout = ((BoringLayout)this.jdField_a_of_type_AndroidTextLayout);
    }
    this.jdField_a_of_type_AndroidTextLayout = null;
  }
  
  private void c()
  {
    int[] arrayOfInt = getDrawableState();
    int i1 = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(arrayOfInt, this.jdField_b_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("SingleLineTextView", 2, "updateTextColors, color=" + i1 + ", cur=" + this.jdField_a_of_type_Int);
    }
    if (i1 != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = i1;
      invalidate();
    }
  }
  
  private int g()
  {
    int i2 = 0;
    int i3 = this.f & 0x70;
    Layout localLayout = this.jdField_a_of_type_AndroidTextLayout;
    int i1 = i2;
    int i4;
    int i5;
    if (i3 != 48)
    {
      i4 = getMeasuredHeight() - e() - f();
      i5 = localLayout.getHeight();
      i1 = i2;
      if (i5 < i4)
      {
        if (i3 != 80) {
          break label70;
        }
        i1 = i4 - i5;
      }
    }
    return i1;
    label70:
    return i4 - i5 >> 1;
  }
  
  private int h()
  {
    if (this.g < 0) {
      this.g = ((int)Math.ceil(Layout.getDesiredWidth(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint)));
    }
    return this.g;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_AndroidTextTextPaint.getTextSize();
  }
  
  public int a()
  {
    int i2 = getPaddingLeft();
    Object localObject = this.jdField_a_of_type_Amky;
    int i1 = i2;
    if (localObject != null)
    {
      i1 = i2;
      if (((amky)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        i1 = ((amky)localObject).e;
        i1 = i2 + (((amky)localObject).jdField_a_of_type_Int + i1);
      }
    }
    localObject = this.jdField_a_of_type_ArrayOfAmkz[1];
    i2 = i1;
    if (localObject != null)
    {
      i2 = i1;
      if (!((amkz)localObject).jdField_a_of_type_Boolean)
      {
        i2 = ((amkz)localObject).jdField_b_of_type_Int;
        i2 = i1 + (((amkz)localObject).a() + i2);
      }
    }
    return i2;
  }
  
  public final CharSequence a()
  {
    return this.jdField_a_of_type_JavaLangCharSequence;
  }
  
  protected void a(int paramInt1, BoringLayout.Metrics paramMetrics, int paramInt2)
  {
    if (paramInt1 < 0) {
      paramInt1 = 0;
    }
    for (;;)
    {
      Layout.Alignment localAlignment;
      switch (this.f & 0x7)
      {
      default: 
        localAlignment = Layout.Alignment.ALIGN_NORMAL;
      }
      while ((this.jdField_a_of_type_JavaLangCharSequence instanceof Spannable))
      {
        this.jdField_a_of_type_AndroidTextLayout = new SingleLineTextView.ExtraDynamicLayout(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramInt2);
        return;
        localAlignment = Layout.Alignment.ALIGN_CENTER;
        continue;
        localAlignment = Layout.Alignment.ALIGN_OPPOSITE;
      }
      if (paramMetrics == jdField_a_of_type_AndroidTextBoringLayout$Metrics)
      {
        BoringLayout.Metrics localMetrics = BoringLayout.isBoring(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_b_of_type_AndroidTextBoringLayout$Metrics);
        paramMetrics = localMetrics;
        if (localMetrics != null)
        {
          this.jdField_b_of_type_AndroidTextBoringLayout$Metrics = localMetrics;
          paramMetrics = localMetrics;
        }
      }
      for (;;)
      {
        if (paramMetrics != null)
        {
          if ((paramMetrics.width <= paramInt1) && (paramMetrics.width <= paramInt2))
          {
            if (this.jdField_a_of_type_AndroidTextBoringLayout != null) {}
            for (this.jdField_a_of_type_AndroidTextLayout = this.jdField_a_of_type_AndroidTextBoringLayout.replaceOrMake(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, paramMetrics, this.jdField_b_of_type_Boolean);; this.jdField_a_of_type_AndroidTextLayout = BoringLayout.make(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, paramMetrics, this.jdField_b_of_type_Boolean))
            {
              this.jdField_a_of_type_AndroidTextBoringLayout = ((BoringLayout)this.jdField_a_of_type_AndroidTextLayout);
              return;
            }
          }
          if (paramMetrics.width <= paramInt1)
          {
            if (this.jdField_a_of_type_AndroidTextBoringLayout != null)
            {
              this.jdField_a_of_type_AndroidTextLayout = this.jdField_a_of_type_AndroidTextBoringLayout.replaceOrMake(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, paramMetrics, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramInt2);
              return;
            }
            this.jdField_a_of_type_AndroidTextLayout = BoringLayout.make(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, paramMetrics, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramInt2);
            return;
          }
          this.jdField_a_of_type_AndroidTextLayout = new SingleLineTextView.ExtraStaticLayout(this.jdField_b_of_type_JavaLangCharSequence, 0, this.jdField_b_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramInt2);
          return;
        }
        this.jdField_a_of_type_AndroidTextLayout = new SingleLineTextView.ExtraStaticLayout(this.jdField_b_of_type_JavaLangCharSequence, 0, this.jdField_b_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramInt2);
        return;
      }
    }
  }
  
  public int b()
  {
    int i2 = getPaddingRight();
    Object localObject1 = this.jdField_a_of_type_Amky;
    int i1 = i2;
    if (localObject1 != null)
    {
      i1 = i2;
      if (((amky)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        i1 = ((amky)localObject1).e;
        i1 = i2 + (((amky)localObject1).jdField_b_of_type_Int + i1);
      }
    }
    localObject1 = this.jdField_a_of_type_ArrayOfAmkz[2];
    i2 = i1;
    if (localObject1 != null)
    {
      i2 = i1;
      if (!((amkz)localObject1).jdField_a_of_type_Boolean)
      {
        i2 = ((amkz)localObject1).jdField_b_of_type_Int;
        i2 = i1 + (((amkz)localObject1).a() + i2);
      }
    }
    localObject1 = this.jdField_a_of_type_ArrayOfAmkz[0];
    i1 = i2;
    if (localObject1 != null)
    {
      i1 = i2;
      if (!((amkz)localObject1).jdField_a_of_type_Boolean)
      {
        i1 = ((amkz)localObject1).jdField_b_of_type_Int;
        i1 = i2 + (((amkz)localObject1).a() + i1);
      }
    }
    localObject1 = this.jdField_a_of_type_ArrayOfAmla;
    if (localObject1 != null)
    {
      int i5 = localObject1.length;
      i2 = 0;
      int i4 = 0;
      while (i2 < i5)
      {
        Object localObject2 = localObject1[i2];
        int i3 = i1;
        if (localObject2.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          i3 = i1 + (this.n + localObject2.jdField_a_of_type_Int);
          i4 = 1;
        }
        i2 += 1;
        i1 = i3;
      }
      i2 = i1;
      if (i4 != 0) {
        i2 = i1 + this.m;
      }
      return i2;
    }
    return i1;
  }
  
  public int c()
  {
    return getPaddingTop();
  }
  
  public int d()
  {
    return getPaddingBottom();
  }
  
  protected void drawableStateChanged()
  {
    int i2 = 0;
    super.drawableStateChanged();
    if ((this.jdField_a_of_type_AndroidContentResColorStateList != null) && (this.jdField_a_of_type_AndroidContentResColorStateList.isStateful())) {
      c();
    }
    int[] arrayOfInt = getDrawableState();
    Object localObject1 = this.jdField_a_of_type_Amky;
    if (localObject1 != null)
    {
      if ((((amky)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (((amky)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
        ((amky)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
      }
      if ((((amky)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (((amky)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
        ((amky)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
      }
    }
    localObject1 = this.jdField_a_of_type_ArrayOfAmla;
    if (localObject1 != null)
    {
      int i3 = localObject1.length;
      i1 = 0;
      while (i1 < i3)
      {
        Object localObject2 = localObject1[i1];
        if ((localObject2.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (localObject2.jdField_a_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
          localObject2.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
        }
        i1 += 1;
      }
    }
    int i1 = 0;
    if (i1 < this.jdField_a_of_type_ArrayOfAmkz.length)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfAmkz[i1];
      if (localObject1 == null) {}
      for (;;)
      {
        i1 += 1;
        break;
        if (((amkz)localObject1).a(arrayOfInt)) {
          i2 = 1;
        }
      }
    }
    if (i2 != 0) {
      invalidate();
    }
  }
  
  public int e()
  {
    int i1;
    if (this.jdField_a_of_type_AndroidTextLayout.getLineCount() <= 1) {
      i1 = c();
    }
    int i2;
    int i3;
    int i4;
    int i5;
    do
    {
      do
      {
        return i1;
        i2 = c();
        i1 = d();
        i3 = getHeight() - i2 - i1;
        i4 = this.jdField_a_of_type_AndroidTextLayout.getLineTop(1);
        i1 = i2;
      } while (i4 >= i3);
      i5 = this.f & 0x70;
      i1 = i2;
    } while (i5 == 48);
    if (i5 == 80) {
      return i2 + i3 - i4;
    }
    return i2 + (i3 - i4) / 2;
  }
  
  public int f()
  {
    int i1;
    if (this.jdField_a_of_type_AndroidTextLayout.getLineCount() <= 1) {
      i1 = d();
    }
    int i2;
    int i3;
    int i4;
    int i5;
    do
    {
      do
      {
        return i1;
        i1 = c();
        i2 = d();
        i3 = getHeight() - i1 - i2;
        i4 = this.jdField_a_of_type_AndroidTextLayout.getLineTop(1);
        i1 = i2;
      } while (i4 >= i3);
      i5 = this.f & 0x70;
      if (i5 == 48) {
        return i2 + i3 - i4;
      }
      i1 = i2;
    } while (i5 == 80);
    return i2 + (i3 - i4) / 2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_a_of_type_AndroidTextLayout != null) {
        a();
      }
    }
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (verifyDrawable(paramDrawable))
    {
      Object localObject1 = paramDrawable.getBounds();
      int i4 = getScrollX();
      int i2 = getScrollY();
      Object localObject2 = this.jdField_a_of_type_Amky;
      int i3 = i2;
      int i1 = i4;
      int i5;
      int i6;
      if (localObject2 != null)
      {
        if (paramDrawable == ((amky)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable)
        {
          i3 = c();
          i5 = d();
          i6 = getHeight();
          i1 = i4 + getPaddingLeft();
          i3 = i2 + ((i6 - i5 - i3 - ((amky)localObject2).jdField_c_of_type_Int) / 2 + i3);
        }
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ArrayOfAmla;
        i5 = i3;
        i4 = i1;
        if (localObject2 != null)
        {
          amkz localamkz = this.jdField_a_of_type_ArrayOfAmkz[0];
          i4 = getWidth() - getPaddingRight() - this.m;
          i2 = i4;
          if (localamkz != null)
          {
            i2 = i4;
            if (!localamkz.jdField_a_of_type_Boolean)
            {
              i2 = localamkz.a();
              i2 = i4 - (localamkz.jdField_b_of_type_Int + i2);
            }
          }
          i6 = 0;
        }
      }
      for (;;)
      {
        i5 = i3;
        i4 = i1;
        int i8;
        int i9;
        int i10;
        int i7;
        if (i6 < localObject2.length)
        {
          if (paramDrawable != localObject2[i6].jdField_a_of_type_AndroidGraphicsDrawableDrawable) {
            break label622;
          }
          i8 = c();
          i9 = d();
          i10 = getHeight();
          if (i6 != 1) {
            break label542;
          }
          i4 = i2;
          if (localObject2[2].jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            i4 = i2 - (localObject2[2].jdField_a_of_type_Int - this.n);
          }
          i7 = i1 + (i4 - localObject2[i6].jdField_a_of_type_Int - this.n);
        }
        for (;;)
        {
          i4 = i7 + (i4 - localObject2[i6].jdField_a_of_type_Int - this.n);
          i5 = i3 + ((i10 - i9 - i8 - localObject2[i6].jdField_b_of_type_Int) / 2 + i8);
          invalidate(((Rect)localObject1).left + i4, ((Rect)localObject1).top + i5, i4 + ((Rect)localObject1).right, i5 + ((Rect)localObject1).bottom);
          localObject1 = a();
          if (!(localObject1 instanceof Spannable)) {
            return;
          }
          localObject1 = (Spannable)localObject1;
          localObject1 = (QQText.EmoticonSpan[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), QQText.EmoticonSpan.class);
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            return;
          }
          this.jdField_c_of_type_Boolean = true;
          i2 = localObject1.length;
          i1 = 0;
          while (i1 < i2)
          {
            localObject2 = localObject1[i1];
            if (((QQText.EmoticonSpan)localObject2).a() == paramDrawable) {
              a(localObject2);
            }
            i1 += 1;
          }
          i3 = i2;
          i1 = i4;
          if (paramDrawable != ((amky)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable) {
            break;
          }
          i3 = c();
          i5 = d();
          i6 = getHeight();
          i1 = i4 + (getWidth() - getPaddingRight() - ((amky)localObject2).jdField_b_of_type_Int);
          i3 = i2 + ((i6 - i5 - i3 - ((amky)localObject2).d) / 2 + i3);
          break;
          label542:
          i7 = i1;
          i4 = i2;
          if (i6 == 0)
          {
            i5 = i2;
            if (localObject2[2].jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
              i5 = i2 - (localObject2[2].jdField_a_of_type_Int - this.n);
            }
            i7 = i1;
            i4 = i5;
            if (localObject2[1].jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
            {
              i4 = i5 - (localObject2[1].jdField_a_of_type_Int - this.n);
              i7 = i1;
            }
          }
        }
        label622:
        i6 += 1;
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i4 = a();
    int i5 = c();
    int i13 = b();
    int i3 = d();
    int i8 = getScrollX();
    int i6 = getScrollY();
    int i9 = getRight();
    int i10 = getLeft();
    int i14 = getBottom();
    int i15 = getTop();
    int i1;
    if (this.jdField_a_of_type_AndroidTextLayout == null)
    {
      i2 = i9 - i10 - i4 - i13;
      i1 = i2;
      if (i2 < 1) {
        i1 = 0;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label1039;
      }
    }
    label1029:
    label1032:
    label1039:
    for (int i2 = 16384;; i2 = i1)
    {
      a(i2, jdField_a_of_type_AndroidTextBoringLayout$Metrics, i1);
      int i11 = e();
      int i16 = f();
      int i7 = i14 - i15 - i3 - i5;
      int i12 = this.jdField_a_of_type_AndroidTextLayout.getLineTop(1) - this.jdField_a_of_type_AndroidTextLayout.getLineDescent(0);
      i3 = 0;
      i1 = 0;
      i2 = 0;
      if ((this.f & 0x70) != 48)
      {
        i1 = g();
        i2 = g();
      }
      Object localObject1 = getDrawableState();
      Object localObject2 = this.jdField_a_of_type_Amky;
      if ((localObject2 != null) && (((amky)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
      {
        paramCanvas.save();
        int i17 = getPaddingLeft();
        int i18 = (i7 - ((amky)localObject2).jdField_c_of_type_Int) / 2;
        paramCanvas.translate(i17 + i8, i6 + i5 + i18);
        ((amky)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        paramCanvas.restore();
      }
      Object localObject3 = this.jdField_a_of_type_ArrayOfAmkz[1];
      Paint.FontMetrics localFontMetrics;
      float f2;
      float f1;
      if ((localObject3 != null) && (!((amkz)localObject3).jdField_a_of_type_Boolean))
      {
        paramCanvas.save();
        paramCanvas.translate(i8 + i4 - ((amkz)localObject3).a(), i11 + i1);
        localFontMetrics = ((amkz)localObject3).a();
        f2 = i12;
        f1 = f2;
        if (localFontMetrics != null)
        {
          f1 = f2;
          if (f2 > getMeasuredHeight() - localFontMetrics.bottom) {
            f1 = (int)(getMeasuredHeight() - localFontMetrics.bottom);
          }
        }
        ((amkz)localObject3).a(paramCanvas, (int[])localObject1, 0.0F, f1);
        paramCanvas.restore();
      }
      localObject3 = this.jdField_a_of_type_AndroidTextLayout;
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.drawableState = getDrawableState();
      paramCanvas.save();
      paramCanvas.clipRect(i4 + i8, i11 + i6, i9 - i10 - i13 + i8, i14 - i15 - i16 + i6);
      paramCanvas.translate(i4, i11 + i1);
      ((Layout)localObject3).draw(paramCanvas, null, null, i2 - i1);
      paramCanvas.restore();
      localObject3 = this.jdField_a_of_type_ArrayOfAmkz[2];
      i2 = i3;
      if (localObject3 != null)
      {
        i2 = i3;
        if (!((amkz)localObject3).jdField_a_of_type_Boolean)
        {
          paramCanvas.save();
          i2 = h() + 0 + ((amkz)localObject3).jdField_b_of_type_Int;
          i4 = i8 + i9 - i10 - i13 + 0;
          i3 = 0 + (((amkz)localObject3).a() + ((amkz)localObject3).jdField_b_of_type_Int);
          if (i4 <= i2) {
            break label1032;
          }
        }
      }
      for (;;)
      {
        paramCanvas.translate(i2, i11 + i1);
        localFontMetrics = ((amkz)localObject3).a();
        f2 = i12;
        f1 = f2;
        if (localFontMetrics != null)
        {
          f1 = f2;
          if (f2 > getMeasuredHeight() - localFontMetrics.bottom) {
            f1 = (int)(((amkz)localObject3).b() - localFontMetrics.bottom);
          }
        }
        ((amkz)localObject3).a(paramCanvas, (int[])localObject1, 0.0F, f1);
        paramCanvas.restore();
        i2 = i3;
        if ((localObject2 != null) && (((amky)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null))
        {
          paramCanvas.save();
          i3 = h() + i2 + ((amky)localObject2).e;
          i2 = i8 + i9 - i10 - i13 + i2 + ((amky)localObject2).e;
          i4 = ((amky)localObject2).jdField_b_of_type_Int;
          i4 = ((amky)localObject2).e;
          if (i2 <= i3) {
            break label1029;
          }
          i2 = i3;
        }
        for (;;)
        {
          i3 = (i7 - ((amky)localObject2).d) / 2;
          paramCanvas.translate(i2, i6 + i5 + i3);
          ((amky)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
          paramCanvas.restore();
          localObject2 = this.jdField_a_of_type_ArrayOfAmkz[0];
          i3 = 0;
          i2 = i3;
          if (localObject2 != null)
          {
            i2 = i3;
            if (!((amkz)localObject2).jdField_a_of_type_Boolean)
            {
              paramCanvas.save();
              paramCanvas.translate(i8 + i9 - i10 - ((amkz)localObject2).a() - getPaddingRight(), i1 + i11);
              ((amkz)localObject2).a(paramCanvas, (int[])localObject1, 0.0F, i12);
              paramCanvas.restore();
              i2 = ((amkz)localObject2).a();
            }
          }
          localObject1 = this.jdField_a_of_type_ArrayOfAmla;
          if (localObject1 != null)
          {
            i3 = getPaddingRight();
            i4 = this.m;
            i1 = localObject1.length;
            i2 = i8 + i9 - i10 - i2 - i3 - i4;
            i1 -= 1;
            while (i1 >= 0)
            {
              i3 = i2;
              if (localObject1[i1].jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
              {
                paramCanvas.save();
                i3 = i2 - this.n - localObject1[i1].jdField_a_of_type_Int;
                i2 = (i7 - localObject1[i1].jdField_b_of_type_Int) / 2;
                paramCanvas.translate(i3, i6 + i5 + i2);
                localObject1[i1].jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
                paramCanvas.restore();
              }
              i1 -= 1;
              i2 = i3;
            }
          }
          return;
        }
        i2 = i4;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = 0;
    if (Build.VERSION.SDK_INT < 21) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    int i2 = View.MeasureSpec.getMode(paramInt1);
    int i4 = View.MeasureSpec.getMode(paramInt2);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    Object localObject = jdField_a_of_type_AndroidTextBoringLayout$Metrics;
    if (i2 == 1073741824) {}
    for (;;)
    {
      i2 = i1 - a() - b();
      if (this.jdField_a_of_type_Boolean) {}
      for (paramInt1 = 16384;; paramInt1 = i2)
      {
        if (this.jdField_a_of_type_AndroidTextLayout == null) {
          a(paramInt1, (BoringLayout.Metrics)localObject, i2);
        }
        for (;;)
        {
          if (i4 != 1073741824) {
            break label244;
          }
          paramInt1 = paramInt2;
          setMeasuredDimension(i1, paramInt1);
          return;
          localObject = BoringLayout.isBoring(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_b_of_type_AndroidTextBoringLayout$Metrics);
          if (localObject != null) {
            this.jdField_b_of_type_AndroidTextBoringLayout$Metrics = ((BoringLayout.Metrics)localObject);
          }
          if ((localObject == null) || (localObject == jdField_a_of_type_AndroidTextBoringLayout$Metrics)) {}
          for (paramInt1 = h();; paramInt1 = ((BoringLayout.Metrics)localObject).width)
          {
            paramInt1 = Math.max(Math.min(paramInt1 + (a() + b()), this.e), getSuggestedMinimumWidth());
            if (i2 != -2147483648) {
              break label472;
            }
            i1 = Math.min(i1, paramInt1);
            break;
          }
          if ((this.jdField_a_of_type_AndroidTextLayout.getWidth() != paramInt1) || (this.jdField_a_of_type_AndroidTextLayout.getEllipsizedWidth() != i2)) {
            a(paramInt1, (BoringLayout.Metrics)localObject, i2);
          }
        }
        label244:
        i4 = c() + d();
        if (this.jdField_a_of_type_AndroidTextLayout != null)
        {
          paramInt2 = this.jdField_a_of_type_AndroidTextLayout.getLineCount();
          paramInt1 = paramInt2;
          if (paramInt2 > 1) {
            paramInt1 = 1;
          }
        }
        for (paramInt1 = this.jdField_a_of_type_AndroidTextLayout.getLineTop(paramInt1);; paramInt1 = 0)
        {
          paramInt1 += i4;
          localObject = this.jdField_a_of_type_Amky;
          paramInt2 = paramInt1;
          if (localObject != null) {
            paramInt2 = Math.max(Math.max(paramInt1, ((amky)localObject).jdField_c_of_type_Int), ((amky)localObject).d);
          }
          localObject = this.jdField_a_of_type_ArrayOfAmla;
          paramInt1 = paramInt2;
          if (localObject != null)
          {
            int i5 = localObject.length;
            i2 = 0;
            for (;;)
            {
              paramInt1 = paramInt2;
              if (i2 >= i5) {
                break;
              }
              paramInt2 = Math.max(paramInt2, localObject[i2].jdField_b_of_type_Int);
              i2 += 1;
            }
          }
          i2 = paramInt1;
          if (paramInt1 == i4)
          {
            paramInt2 = i3;
            for (;;)
            {
              i2 = paramInt1;
              if (paramInt2 >= this.jdField_a_of_type_ArrayOfAmkz.length) {
                break;
              }
              localObject = this.jdField_a_of_type_ArrayOfAmkz[paramInt2];
              i2 = paramInt1;
              if (localObject != null)
              {
                i2 = paramInt1;
                if (!((amkz)localObject).jdField_a_of_type_Boolean) {
                  i2 = Math.max(paramInt1, ((amkz)localObject).b());
                }
              }
              paramInt2 += 1;
              paramInt1 = i2;
            }
          }
          paramInt1 = Math.max(i2, getSuggestedMinimumHeight());
          break;
        }
      }
      label472:
      i1 = paramInt1;
    }
  }
  
  public void requestLayout()
  {
    if (!this.jdField_c_of_type_Boolean) {
      super.requestLayout();
    }
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    amky localamky2 = this.jdField_a_of_type_Amky;
    if (paramInt == 0) {
      if (localamky2 == null) {}
    }
    amky localamky1;
    for (localamky2.e = paramInt;; localamky1.e = paramInt)
    {
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
      localamky1 = localamky2;
      if (localamky2 == null)
      {
        localamky1 = new amky(null);
        this.jdField_a_of_type_Amky = localamky1;
      }
    }
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    Object localObject2 = this.jdField_a_of_type_Amky;
    int i1;
    if ((paramDrawable1 != null) || (paramDrawable2 != null))
    {
      i1 = 1;
      if (i1 != 0) {
        break label137;
      }
      if (localObject2 != null)
      {
        if (((amky)localObject2).e != 0) {
          break label64;
        }
        this.jdField_a_of_type_Amky = null;
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
      i1 = 0;
      break;
      label64:
      if (((amky)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        ((amky)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((amky)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      if (((amky)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
        ((amky)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((amky)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
      ((amky)localObject2).jdField_c_of_type_Int = 0;
      ((amky)localObject2).jdField_a_of_type_Int = 0;
      ((amky)localObject2).d = 0;
      ((amky)localObject2).jdField_b_of_type_Int = 0;
      continue;
      label137:
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new amky(null);
        this.jdField_a_of_type_Amky = ((amky)localObject1);
      }
      if ((((amky)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != paramDrawable1) && (((amky)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
        ((amky)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((amky)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable1;
      if ((((amky)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable != paramDrawable1) && (((amky)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)) {
        ((amky)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((amky)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable2;
      localObject2 = ((amky)localObject1).jdField_a_of_type_AndroidGraphicsRect;
      int[] arrayOfInt = getDrawableState();
      if (paramDrawable1 != null)
      {
        paramDrawable1.setState(arrayOfInt);
        paramDrawable1.copyBounds((Rect)localObject2);
        paramDrawable1.setCallback(this);
        ((amky)localObject1).jdField_a_of_type_Int = ((Rect)localObject2).width();
        ((amky)localObject1).jdField_c_of_type_Int = ((Rect)localObject2).height();
      }
      for (;;)
      {
        if (paramDrawable2 == null) {
          break label341;
        }
        paramDrawable2.setState(arrayOfInt);
        paramDrawable2.copyBounds((Rect)localObject2);
        paramDrawable2.setCallback(this);
        ((amky)localObject1).jdField_b_of_type_Int = ((Rect)localObject2).width();
        ((amky)localObject1).d = ((Rect)localObject2).height();
        break;
        ((amky)localObject1).jdField_c_of_type_Int = 0;
        ((amky)localObject1).jdField_a_of_type_Int = 0;
      }
      label341:
      ((amky)localObject1).d = 0;
      ((amky)localObject1).jdField_b_of_type_Int = 0;
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2)
  {
    Drawable localDrawable2 = null;
    if ((this.jdField_c_of_type_Int == paramInt1) && (this.d == paramInt2)) {
      return;
    }
    this.jdField_c_of_type_Int = paramInt1;
    this.d = paramInt2;
    Resources localResources = getContext().getResources();
    if (paramInt1 != 0) {}
    for (Drawable localDrawable1 = localResources.getDrawable(paramInt1);; localDrawable1 = null)
    {
      if (paramInt2 != 0) {
        localDrawable2 = localResources.getDrawable(paramInt2);
      }
      setCompoundDrawablesWithIntrinsicBounds(localDrawable1, localDrawable2);
      return;
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null) {
      paramDrawable1.setBounds(0, 0, paramDrawable1.getIntrinsicWidth(), paramDrawable1.getIntrinsicHeight());
    }
    if (paramDrawable2 != null) {
      paramDrawable2.setBounds(0, 0, paramDrawable2.getIntrinsicWidth(), paramDrawable2.getIntrinsicHeight());
    }
    setCompoundDrawables(paramDrawable1, paramDrawable2);
  }
  
  public void setDefaultTextColor(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    c();
  }
  
  public void setExtendText(String paramString, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfAmkz.length)) {}
    amkz localamkz2;
    boolean bool;
    do
    {
      return;
      localamkz2 = this.jdField_a_of_type_ArrayOfAmkz[paramInt];
      bool = TextUtils.isEmpty(paramString);
    } while ((bool) && ((localamkz2 == null) || (localamkz2.jdField_a_of_type_Boolean)));
    int i1;
    if ((bool) && (localamkz2 != null) && (!localamkz2.jdField_a_of_type_Boolean))
    {
      localamkz2.a();
      i1 = 1;
    }
    for (;;)
    {
      if ((paramInt == 0) && (i1 != 0)) {
        postInvalidate();
      }
      if ((i1 == 0) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (!bool)
      {
        amkz localamkz1 = localamkz2;
        if (localamkz2 == null)
        {
          localamkz1 = new amkz(getResources());
          this.jdField_a_of_type_ArrayOfAmkz[paramInt] = localamkz1;
        }
        if (!paramString.equals(localamkz1.jdField_a_of_type_JavaLangString))
        {
          localamkz1.jdField_a_of_type_JavaLangString = paramString;
          localamkz1.jdField_c_of_type_Int = -1;
          localamkz1.jdField_a_of_type_Boolean = false;
          i1 = 1;
          continue;
        }
      }
      i1 = 0;
    }
  }
  
  public void setExtendTextColor(ColorStateList paramColorStateList, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfAmkz.length)) {}
    amkz localamkz1;
    do
    {
      return;
      amkz localamkz2 = this.jdField_a_of_type_ArrayOfAmkz[paramInt];
      localamkz1 = localamkz2;
      if (localamkz2 == null)
      {
        localamkz1 = new amkz(getResources());
        this.jdField_a_of_type_ArrayOfAmkz[paramInt] = localamkz1;
      }
    } while (!localamkz1.a(paramColorStateList, getDrawableState()));
    postInvalidate();
  }
  
  public void setExtendTextPadding(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_ArrayOfAmkz.length)) {}
    amkz localamkz2;
    do
    {
      return;
      localamkz2 = this.jdField_a_of_type_ArrayOfAmkz[paramInt2];
    } while ((paramInt1 <= 0) && ((localamkz2 == null) || (localamkz2.jdField_a_of_type_Boolean)));
    amkz localamkz1 = localamkz2;
    if (localamkz2 == null)
    {
      localamkz1 = new amkz(getResources());
      this.jdField_a_of_type_ArrayOfAmkz[paramInt2] = localamkz1;
    }
    localamkz1.jdField_b_of_type_Int = paramInt1;
  }
  
  public void setExtendTextSize(float paramFloat, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfAmkz.length)) {}
    amkz localamkz1;
    do
    {
      return;
      amkz localamkz2 = this.jdField_a_of_type_ArrayOfAmkz[paramInt];
      localamkz1 = localamkz2;
      if (localamkz2 == null)
      {
        localamkz1 = new amkz(getResources());
        this.jdField_a_of_type_ArrayOfAmkz[paramInt] = localamkz1;
      }
    } while ((!localamkz1.a(paramFloat, getContext())) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void setGravity(int paramInt)
  {
    if ((paramInt & 0x7) == 0) {
      paramInt |= 0x3;
    }
    for (;;)
    {
      int i1 = paramInt;
      if ((paramInt & 0x70) == 0) {
        i1 = paramInt | 0x30;
      }
      paramInt = 0;
      if ((i1 & 0x7) != (this.f & 0x7)) {
        paramInt = 1;
      }
      if (i1 != this.f) {
        invalidate();
      }
      this.f = i1;
      if ((this.jdField_a_of_type_AndroidTextLayout != null) && (paramInt != 0))
      {
        paramInt = this.jdField_a_of_type_AndroidTextLayout.getWidth();
        i1 = getWidth();
        int i2 = a();
        int i3 = b();
        a(paramInt, jdField_a_of_type_AndroidTextBoringLayout$Metrics, i1 - i2 - i3);
      }
      return;
    }
  }
  
  public void setIconDrawablePadding(int paramInt1, int paramInt2)
  {
    this.n = paramInt1;
    this.m = paramInt2;
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void setIconDrawables(Drawable[] paramArrayOfDrawable, boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_ArrayOfAmla;
    if (!paramBoolean)
    {
      if (localObject2 != null)
      {
        if (this.m != 0) {
          break label48;
        }
        this.jdField_a_of_type_ArrayOfAmla = null;
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        }
        return;
        label48:
        int i2 = localObject2.length;
        i1 = 0;
        while (i1 < i2)
        {
          paramArrayOfDrawable = localObject2[i1];
          if (paramArrayOfDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            paramArrayOfDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
          }
          paramArrayOfDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
          paramArrayOfDrawable.jdField_a_of_type_Int = 0;
          paramArrayOfDrawable.jdField_b_of_type_Int = 0;
          i1 += 1;
        }
      }
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new amla[paramArrayOfDrawable.length];
      this.jdField_a_of_type_ArrayOfAmla = ((amla[])localObject1);
      i1 = 0;
      while (i1 < localObject1.length)
      {
        localObject1[i1] = new amla(null);
        i1 += 1;
      }
    }
    localObject2 = getDrawableState();
    int i1 = 0;
    label161:
    Rect localRect;
    if (i1 < localObject1.length)
    {
      if ((localObject1[i1].jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (localObject1[i1].jdField_a_of_type_AndroidGraphicsDrawableDrawable != paramArrayOfDrawable[i1])) {
        localObject1[i1].jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      localObject1[i1].jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramArrayOfDrawable[i1];
      localRect = localObject1[i1].jdField_a_of_type_AndroidGraphicsRect;
      if (paramArrayOfDrawable[i1] == null) {
        break label282;
      }
      paramArrayOfDrawable[i1].setState((int[])localObject2);
      paramArrayOfDrawable[i1].copyBounds(localRect);
      paramArrayOfDrawable[i1].setCallback(this);
      localObject1[i1].jdField_a_of_type_Int = localRect.width();
      localObject1[i1].jdField_b_of_type_Int = localRect.height();
    }
    for (;;)
    {
      i1 += 1;
      break label161;
      break;
      label282:
      localRect = localObject1[i1];
      localObject1[i1].jdField_b_of_type_Int = 0;
      localRect.jdField_a_of_type_Int = 0;
    }
  }
  
  public void setIconDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    Drawable localDrawable5 = null;
    if ((this.h == paramInt1) && (this.i == paramInt2) && (this.j == paramInt3) && (this.k == paramInt4) && (this.l == paramInt5)) {
      return;
    }
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
    this.l = paramInt5;
    Resources localResources = getContext().getResources();
    Drawable localDrawable1;
    Drawable localDrawable2;
    label106:
    Drawable localDrawable3;
    if (paramInt1 != 0)
    {
      localDrawable1 = localResources.getDrawable(paramInt1);
      if (paramInt2 == 0) {
        break label167;
      }
      localDrawable2 = localResources.getDrawable(paramInt2);
      if (paramInt3 == 0) {
        break label173;
      }
      localDrawable3 = localResources.getDrawable(paramInt3);
      label118:
      if (paramInt4 == 0) {
        break label179;
      }
    }
    label167:
    label173:
    label179:
    for (Drawable localDrawable4 = localResources.getDrawable(paramInt4);; localDrawable4 = null)
    {
      if (paramInt5 != 0) {
        localDrawable5 = localResources.getDrawable(paramInt5);
      }
      setIconDrawablesWithIntrinsicBounds(localDrawable1, localDrawable2, localDrawable3, localDrawable4, localDrawable5);
      return;
      localDrawable1 = null;
      break;
      localDrawable2 = null;
      break label106;
      localDrawable3 = null;
      break label118;
    }
  }
  
  public void setIconDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4, Drawable paramDrawable5)
  {
    Drawable[] arrayOfDrawable = new Drawable[5];
    arrayOfDrawable[0] = paramDrawable1;
    arrayOfDrawable[1] = paramDrawable2;
    arrayOfDrawable[2] = paramDrawable5;
    arrayOfDrawable[3] = paramDrawable3;
    arrayOfDrawable[4] = paramDrawable4;
    int i2 = arrayOfDrawable.length;
    int i1 = 0;
    boolean bool = false;
    while (i1 < i2)
    {
      paramDrawable1 = arrayOfDrawable[i1];
      if (paramDrawable1 != null)
      {
        paramDrawable1.setBounds(0, 0, paramDrawable1.getIntrinsicWidth(), paramDrawable1.getIntrinsicHeight());
        bool = true;
      }
      i1 += 1;
    }
    setIconDrawables(arrayOfDrawable, bool);
  }
  
  public final void setMaxWidth(int paramInt)
  {
    if (this.e != paramInt)
    {
      this.e = paramInt;
      requestLayout();
      invalidate();
    }
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    int i1 = 0;
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if (localObject.equals(this.jdField_a_of_type_JavaLangCharSequence)) {
      return;
    }
    if (((CharSequence)localObject).length() > 168) {}
    for (;;)
    {
      try
      {
        paramCharSequence = ((CharSequence)localObject).subSequence(0, 168);
        this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
        this.jdField_b_of_type_JavaLangCharSequence = this.jdField_a_of_type_AndroidTextMethodTransformationMethod.getTransformation(paramCharSequence, this);
        if ((paramCharSequence instanceof Spannable))
        {
          int i2 = paramCharSequence.length();
          ((Spannable)paramCharSequence).setSpan(this.jdField_a_of_type_AndroidTextMethodTransformationMethod, 0, i2, 18);
        }
        this.g = -1;
        if (this.jdField_a_of_type_AndroidTextLayout != null) {
          a();
        }
        a();
        if (!(a() instanceof Spannable)) {
          break;
        }
        paramCharSequence = (Spannable)a();
        paramCharSequence = (QQText.EmoticonSpan[])paramCharSequence.getSpans(0, paramCharSequence.length(), QQText.EmoticonSpan.class);
        if (i1 >= paramCharSequence.length) {
          break;
        }
        localObject = paramCharSequence[i1].a();
        if (localObject != null) {
          ((Drawable)localObject).setCallback(this);
        }
        i1 += 1;
        continue;
        paramCharSequence = (CharSequence)localObject;
      }
      catch (Exception paramCharSequence)
      {
        if (QLog.isDevelopLevel()) {
          paramCharSequence.printStackTrace();
        }
      }
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(paramInt);
    c();
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    if (paramColorStateList == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
    c();
  }
  
  public void setTextSize(float paramFloat)
  {
    Object localObject = getContext();
    if (localObject == null) {}
    for (localObject = Resources.getSystem();; localObject = ((Context)localObject).getResources())
    {
      paramFloat = TypedValue.applyDimension(1, paramFloat, ((Resources)localObject).getDisplayMetrics());
      if (paramFloat != this.jdField_a_of_type_AndroidTextTextPaint.getTextSize())
      {
        this.jdField_a_of_type_AndroidTextTextPaint.setTextSize(paramFloat);
        this.g = -1;
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        }
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.widget.SingleLineTextView
 * JD-Core Version:    0.7.0.1
 */