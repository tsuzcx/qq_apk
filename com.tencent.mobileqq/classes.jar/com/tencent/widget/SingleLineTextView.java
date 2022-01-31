package com.tencent.widget;

import amdo;
import amdp;
import amdq;
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
  private amdo jdField_a_of_type_Amdo;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private BoringLayout jdField_a_of_type_AndroidTextBoringLayout;
  protected Layout a;
  private final TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private TextUtils.TruncateAt jdField_a_of_type_AndroidTextTextUtils$TruncateAt;
  private TransformationMethod jdField_a_of_type_AndroidTextMethodTransformationMethod;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private boolean jdField_a_of_type_Boolean;
  private final amdp[] jdField_a_of_type_ArrayOfAmdp;
  private amdq[] jdField_a_of_type_ArrayOfAmdq;
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
    this.jdField_a_of_type_ArrayOfAmdp = new amdp[3];
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_c_of_type_Int = 0;
    this.d = 0;
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
      int n = getWidth() - a() - b();
      if (n > 0)
      {
        int i1 = this.jdField_a_of_type_AndroidTextLayout.getHeight();
        a(this.jdField_a_of_type_AndroidTextLayout.getWidth(), jdField_a_of_type_AndroidTextBoringLayout$Metrics, n);
        if ((localLayoutParams.height != -2) && (localLayoutParams.height != -1))
        {
          invalidate();
          return;
        }
        if (this.jdField_a_of_type_AndroidTextLayout.getHeight() == i1)
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
      int i1 = ((Spannable)localObject).getSpanStart(paramObject);
      int i2 = ((Spannable)localObject).getSpanEnd(paramObject);
      SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])((Spannable)localObject).getSpans(i1, i2, SpanWatcher.class);
      if ((arrayOfSpanWatcher != null) && (arrayOfSpanWatcher.length > 0))
      {
        int i3 = arrayOfSpanWatcher.length;
        int n = 0;
        for (;;)
        {
          if (n < i3)
          {
            SpanWatcher localSpanWatcher = arrayOfSpanWatcher[n];
            try
            {
              localSpanWatcher.onSpanChanged((Spannable)localObject, paramObject, i1, i2, i1, i2);
              n += 1;
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
    int n = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(arrayOfInt, this.jdField_b_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("SingleLineTextView", 2, "updateTextColors, color=" + n + ", cur=" + this.jdField_a_of_type_Int);
    }
    if (n != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = n;
      invalidate();
    }
  }
  
  private int g()
  {
    int i1 = 0;
    int i2 = this.f & 0x70;
    Layout localLayout = this.jdField_a_of_type_AndroidTextLayout;
    int n = i1;
    int i3;
    int i4;
    if (i2 != 48)
    {
      i3 = getMeasuredHeight() - e() - f();
      i4 = localLayout.getHeight();
      n = i1;
      if (i4 < i3)
      {
        if (i2 != 80) {
          break label70;
        }
        n = i3 - i4;
      }
    }
    return n;
    label70:
    return i3 - i4 >> 1;
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
    int i1 = getPaddingLeft();
    Object localObject = this.jdField_a_of_type_Amdo;
    int n = i1;
    if (localObject != null)
    {
      n = i1;
      if (((amdo)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        n = ((amdo)localObject).e;
        n = i1 + (((amdo)localObject).jdField_a_of_type_Int + n);
      }
    }
    localObject = this.jdField_a_of_type_ArrayOfAmdp[1];
    i1 = n;
    if (localObject != null)
    {
      i1 = n;
      if (!((amdp)localObject).jdField_a_of_type_Boolean)
      {
        i1 = ((amdp)localObject).jdField_b_of_type_Int;
        i1 = n + (((amdp)localObject).a() + i1);
      }
    }
    return i1;
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
    int i1 = getPaddingRight();
    Object localObject1 = this.jdField_a_of_type_Amdo;
    int n = i1;
    if (localObject1 != null)
    {
      n = i1;
      if (((amdo)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        n = ((amdo)localObject1).e;
        n = i1 + (((amdo)localObject1).jdField_b_of_type_Int + n);
      }
    }
    localObject1 = this.jdField_a_of_type_ArrayOfAmdp[2];
    i1 = n;
    if (localObject1 != null)
    {
      i1 = n;
      if (!((amdp)localObject1).jdField_a_of_type_Boolean)
      {
        i1 = ((amdp)localObject1).jdField_b_of_type_Int;
        i1 = n + (((amdp)localObject1).a() + i1);
      }
    }
    localObject1 = this.jdField_a_of_type_ArrayOfAmdp[0];
    n = i1;
    if (localObject1 != null)
    {
      n = i1;
      if (!((amdp)localObject1).jdField_a_of_type_Boolean)
      {
        n = ((amdp)localObject1).jdField_b_of_type_Int;
        n = i1 + (((amdp)localObject1).a() + n);
      }
    }
    localObject1 = this.jdField_a_of_type_ArrayOfAmdq;
    if (localObject1 != null)
    {
      int i4 = localObject1.length;
      i1 = 0;
      int i3 = 0;
      while (i1 < i4)
      {
        Object localObject2 = localObject1[i1];
        int i2 = n;
        if (localObject2.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          i2 = n + (this.m + localObject2.jdField_a_of_type_Int);
          i3 = 1;
        }
        i1 += 1;
        n = i2;
      }
      i1 = n;
      if (i3 != 0) {
        i1 = n + this.l;
      }
      return i1;
    }
    return n;
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
    int i1 = 0;
    super.drawableStateChanged();
    if ((this.jdField_a_of_type_AndroidContentResColorStateList != null) && (this.jdField_a_of_type_AndroidContentResColorStateList.isStateful())) {
      c();
    }
    int[] arrayOfInt = getDrawableState();
    Object localObject1 = this.jdField_a_of_type_Amdo;
    if (localObject1 != null)
    {
      if ((((amdo)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (((amdo)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
        ((amdo)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
      }
      if ((((amdo)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (((amdo)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
        ((amdo)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
      }
    }
    localObject1 = this.jdField_a_of_type_ArrayOfAmdq;
    if (localObject1 != null)
    {
      int i2 = localObject1.length;
      n = 0;
      while (n < i2)
      {
        Object localObject2 = localObject1[n];
        if ((localObject2.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (localObject2.jdField_a_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
          localObject2.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
        }
        n += 1;
      }
    }
    int n = 0;
    if (n < this.jdField_a_of_type_ArrayOfAmdp.length)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfAmdp[n];
      if (localObject1 == null) {}
      for (;;)
      {
        n += 1;
        break;
        if (((amdp)localObject1).a(arrayOfInt)) {
          i1 = 1;
        }
      }
    }
    if (i1 != 0) {
      invalidate();
    }
  }
  
  public int e()
  {
    int n;
    if (this.jdField_a_of_type_AndroidTextLayout.getLineCount() <= 1) {
      n = c();
    }
    int i1;
    int i2;
    int i3;
    int i4;
    do
    {
      do
      {
        return n;
        i1 = c();
        n = d();
        i2 = getHeight() - i1 - n;
        i3 = this.jdField_a_of_type_AndroidTextLayout.getLineTop(1);
        n = i1;
      } while (i3 >= i2);
      i4 = this.f & 0x70;
      n = i1;
    } while (i4 == 48);
    if (i4 == 80) {
      return i1 + i2 - i3;
    }
    return i1 + (i2 - i3) / 2;
  }
  
  public int f()
  {
    int n;
    if (this.jdField_a_of_type_AndroidTextLayout.getLineCount() <= 1) {
      n = d();
    }
    int i1;
    int i2;
    int i3;
    int i4;
    do
    {
      do
      {
        return n;
        n = c();
        i1 = d();
        i2 = getHeight() - n - i1;
        i3 = this.jdField_a_of_type_AndroidTextLayout.getLineTop(1);
        n = i1;
      } while (i3 >= i2);
      i4 = this.f & 0x70;
      if (i4 == 48) {
        return i1 + i2 - i3;
      }
      n = i1;
    } while (i4 == 80);
    return i1 + (i2 - i3) / 2;
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
      int i3 = getScrollX();
      int i1 = getScrollY();
      Object localObject2 = this.jdField_a_of_type_Amdo;
      int i2 = i1;
      int n = i3;
      int i4;
      int i5;
      if (localObject2 != null)
      {
        if (paramDrawable == ((amdo)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable)
        {
          i2 = c();
          i4 = d();
          i5 = getHeight();
          n = i3 + getPaddingLeft();
          i2 = i1 + ((i5 - i4 - i2 - ((amdo)localObject2).jdField_c_of_type_Int) / 2 + i2);
        }
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ArrayOfAmdq;
        i4 = i2;
        i3 = n;
        if (localObject2 != null)
        {
          amdp localamdp = this.jdField_a_of_type_ArrayOfAmdp[0];
          i3 = getWidth() - getPaddingRight() - this.l;
          i1 = i3;
          if (localamdp != null)
          {
            i1 = i3;
            if (!localamdp.jdField_a_of_type_Boolean)
            {
              i1 = localamdp.a();
              i1 = i3 - (localamdp.jdField_b_of_type_Int + i1);
            }
          }
          i5 = 0;
        }
      }
      for (;;)
      {
        i4 = i2;
        i3 = n;
        int i7;
        int i8;
        int i9;
        int i6;
        if (i5 < localObject2.length)
        {
          if (paramDrawable != localObject2[i5].jdField_a_of_type_AndroidGraphicsDrawableDrawable) {
            break label622;
          }
          i7 = c();
          i8 = d();
          i9 = getHeight();
          if (i5 != 1) {
            break label542;
          }
          i3 = i1;
          if (localObject2[2].jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            i3 = i1 - (localObject2[2].jdField_a_of_type_Int - this.m);
          }
          i6 = n + (i3 - localObject2[i5].jdField_a_of_type_Int - this.m);
        }
        for (;;)
        {
          i3 = i6 + (i3 - localObject2[i5].jdField_a_of_type_Int - this.m);
          i4 = i2 + ((i9 - i8 - i7 - localObject2[i5].jdField_b_of_type_Int) / 2 + i7);
          invalidate(((Rect)localObject1).left + i3, ((Rect)localObject1).top + i4, i3 + ((Rect)localObject1).right, i4 + ((Rect)localObject1).bottom);
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
          i1 = localObject1.length;
          n = 0;
          while (n < i1)
          {
            localObject2 = localObject1[n];
            if (((QQText.EmoticonSpan)localObject2).a() == paramDrawable) {
              a(localObject2);
            }
            n += 1;
          }
          i2 = i1;
          n = i3;
          if (paramDrawable != ((amdo)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable) {
            break;
          }
          i2 = c();
          i4 = d();
          i5 = getHeight();
          n = i3 + (getWidth() - getPaddingRight() - ((amdo)localObject2).jdField_b_of_type_Int);
          i2 = i1 + ((i5 - i4 - i2 - ((amdo)localObject2).d) / 2 + i2);
          break;
          label542:
          i6 = n;
          i3 = i1;
          if (i5 == 0)
          {
            i4 = i1;
            if (localObject2[2].jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
              i4 = i1 - (localObject2[2].jdField_a_of_type_Int - this.m);
            }
            i6 = n;
            i3 = i4;
            if (localObject2[1].jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
            {
              i3 = i4 - (localObject2[1].jdField_a_of_type_Int - this.m);
              i6 = n;
            }
          }
        }
        label622:
        i5 += 1;
      }
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i3 = a();
    int i4 = c();
    int i12 = b();
    int i2 = d();
    int i7 = getScrollX();
    int i5 = getScrollY();
    int i8 = getRight();
    int i9 = getLeft();
    int i13 = getBottom();
    int i14 = getTop();
    int n;
    if (this.jdField_a_of_type_AndroidTextLayout == null)
    {
      i1 = i8 - i9 - i3 - i12;
      n = i1;
      if (i1 < 1) {
        n = 0;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label1039;
      }
    }
    label1029:
    label1032:
    label1039:
    for (int i1 = 16384;; i1 = n)
    {
      a(i1, jdField_a_of_type_AndroidTextBoringLayout$Metrics, n);
      int i10 = e();
      int i15 = f();
      int i6 = i13 - i14 - i2 - i4;
      int i11 = this.jdField_a_of_type_AndroidTextLayout.getLineTop(1) - this.jdField_a_of_type_AndroidTextLayout.getLineDescent(0);
      i2 = 0;
      n = 0;
      i1 = 0;
      if ((this.f & 0x70) != 48)
      {
        n = g();
        i1 = g();
      }
      Object localObject1 = getDrawableState();
      Object localObject2 = this.jdField_a_of_type_Amdo;
      if ((localObject2 != null) && (((amdo)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
      {
        paramCanvas.save();
        int i16 = getPaddingLeft();
        int i17 = (i6 - ((amdo)localObject2).jdField_c_of_type_Int) / 2;
        paramCanvas.translate(i16 + i7, i5 + i4 + i17);
        ((amdo)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        paramCanvas.restore();
      }
      Object localObject3 = this.jdField_a_of_type_ArrayOfAmdp[1];
      Paint.FontMetrics localFontMetrics;
      float f2;
      float f1;
      if ((localObject3 != null) && (!((amdp)localObject3).jdField_a_of_type_Boolean))
      {
        paramCanvas.save();
        paramCanvas.translate(i7 + i3 - ((amdp)localObject3).a(), i10 + n);
        localFontMetrics = ((amdp)localObject3).a();
        f2 = i11;
        f1 = f2;
        if (localFontMetrics != null)
        {
          f1 = f2;
          if (f2 > getMeasuredHeight() - localFontMetrics.bottom) {
            f1 = (int)(getMeasuredHeight() - localFontMetrics.bottom);
          }
        }
        ((amdp)localObject3).a(paramCanvas, (int[])localObject1, 0.0F, f1);
        paramCanvas.restore();
      }
      localObject3 = this.jdField_a_of_type_AndroidTextLayout;
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.drawableState = getDrawableState();
      paramCanvas.save();
      paramCanvas.clipRect(i3 + i7, i10 + i5, i8 - i9 - i12 + i7, i13 - i14 - i15 + i5);
      paramCanvas.translate(i3, i10 + n);
      ((Layout)localObject3).draw(paramCanvas, null, null, i1 - n);
      paramCanvas.restore();
      localObject3 = this.jdField_a_of_type_ArrayOfAmdp[2];
      i1 = i2;
      if (localObject3 != null)
      {
        i1 = i2;
        if (!((amdp)localObject3).jdField_a_of_type_Boolean)
        {
          paramCanvas.save();
          i1 = h() + 0 + ((amdp)localObject3).jdField_b_of_type_Int;
          i3 = i7 + i8 - i9 - i12 + 0;
          i2 = 0 + (((amdp)localObject3).a() + ((amdp)localObject3).jdField_b_of_type_Int);
          if (i3 <= i1) {
            break label1032;
          }
        }
      }
      for (;;)
      {
        paramCanvas.translate(i1, i10 + n);
        localFontMetrics = ((amdp)localObject3).a();
        f2 = i11;
        f1 = f2;
        if (localFontMetrics != null)
        {
          f1 = f2;
          if (f2 > getMeasuredHeight() - localFontMetrics.bottom) {
            f1 = (int)(((amdp)localObject3).b() - localFontMetrics.bottom);
          }
        }
        ((amdp)localObject3).a(paramCanvas, (int[])localObject1, 0.0F, f1);
        paramCanvas.restore();
        i1 = i2;
        if ((localObject2 != null) && (((amdo)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null))
        {
          paramCanvas.save();
          i2 = h() + i1 + ((amdo)localObject2).e;
          i1 = i7 + i8 - i9 - i12 + i1 + ((amdo)localObject2).e;
          i3 = ((amdo)localObject2).jdField_b_of_type_Int;
          i3 = ((amdo)localObject2).e;
          if (i1 <= i2) {
            break label1029;
          }
          i1 = i2;
        }
        for (;;)
        {
          i2 = (i6 - ((amdo)localObject2).d) / 2;
          paramCanvas.translate(i1, i5 + i4 + i2);
          ((amdo)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
          paramCanvas.restore();
          localObject2 = this.jdField_a_of_type_ArrayOfAmdp[0];
          i2 = 0;
          i1 = i2;
          if (localObject2 != null)
          {
            i1 = i2;
            if (!((amdp)localObject2).jdField_a_of_type_Boolean)
            {
              paramCanvas.save();
              paramCanvas.translate(i7 + i8 - i9 - ((amdp)localObject2).a() - getPaddingRight(), n + i10);
              ((amdp)localObject2).a(paramCanvas, (int[])localObject1, 0.0F, i11);
              paramCanvas.restore();
              i1 = ((amdp)localObject2).a();
            }
          }
          localObject1 = this.jdField_a_of_type_ArrayOfAmdq;
          if (localObject1 != null)
          {
            i2 = getPaddingRight();
            i3 = this.l;
            n = localObject1.length;
            i1 = i7 + i8 - i9 - i1 - i2 - i3;
            n -= 1;
            while (n >= 0)
            {
              i2 = i1;
              if (localObject1[n].jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
              {
                paramCanvas.save();
                i2 = i1 - this.m - localObject1[n].jdField_a_of_type_Int;
                i1 = (i6 - localObject1[n].jdField_b_of_type_Int) / 2;
                paramCanvas.translate(i2, i5 + i4 + i1);
                localObject1[n].jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
                paramCanvas.restore();
              }
              n -= 1;
              i1 = i2;
            }
          }
          return;
        }
        i1 = i3;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = 0;
    if (Build.VERSION.SDK_INT < 21) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int n = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    Object localObject = jdField_a_of_type_AndroidTextBoringLayout$Metrics;
    if (i1 == 1073741824) {}
    for (;;)
    {
      i1 = n - a() - b();
      if (this.jdField_a_of_type_Boolean) {}
      for (paramInt1 = 16384;; paramInt1 = i1)
      {
        if (this.jdField_a_of_type_AndroidTextLayout == null) {
          a(paramInt1, (BoringLayout.Metrics)localObject, i1);
        }
        for (;;)
        {
          if (i3 != 1073741824) {
            break label244;
          }
          paramInt1 = paramInt2;
          setMeasuredDimension(n, paramInt1);
          return;
          localObject = BoringLayout.isBoring(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_b_of_type_AndroidTextBoringLayout$Metrics);
          if (localObject != null) {
            this.jdField_b_of_type_AndroidTextBoringLayout$Metrics = ((BoringLayout.Metrics)localObject);
          }
          if ((localObject == null) || (localObject == jdField_a_of_type_AndroidTextBoringLayout$Metrics)) {}
          for (paramInt1 = h();; paramInt1 = ((BoringLayout.Metrics)localObject).width)
          {
            paramInt1 = Math.max(Math.min(paramInt1 + (a() + b()), this.e), getSuggestedMinimumWidth());
            if (i1 != -2147483648) {
              break label472;
            }
            n = Math.min(n, paramInt1);
            break;
          }
          if ((this.jdField_a_of_type_AndroidTextLayout.getWidth() != paramInt1) || (this.jdField_a_of_type_AndroidTextLayout.getEllipsizedWidth() != i1)) {
            a(paramInt1, (BoringLayout.Metrics)localObject, i1);
          }
        }
        label244:
        i3 = c() + d();
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
          paramInt1 += i3;
          localObject = this.jdField_a_of_type_Amdo;
          paramInt2 = paramInt1;
          if (localObject != null) {
            paramInt2 = Math.max(Math.max(paramInt1, ((amdo)localObject).jdField_c_of_type_Int), ((amdo)localObject).d);
          }
          localObject = this.jdField_a_of_type_ArrayOfAmdq;
          paramInt1 = paramInt2;
          if (localObject != null)
          {
            int i4 = localObject.length;
            i1 = 0;
            for (;;)
            {
              paramInt1 = paramInt2;
              if (i1 >= i4) {
                break;
              }
              paramInt2 = Math.max(paramInt2, localObject[i1].jdField_b_of_type_Int);
              i1 += 1;
            }
          }
          i1 = paramInt1;
          if (paramInt1 == i3)
          {
            paramInt2 = i2;
            for (;;)
            {
              i1 = paramInt1;
              if (paramInt2 >= this.jdField_a_of_type_ArrayOfAmdp.length) {
                break;
              }
              localObject = this.jdField_a_of_type_ArrayOfAmdp[paramInt2];
              i1 = paramInt1;
              if (localObject != null)
              {
                i1 = paramInt1;
                if (!((amdp)localObject).jdField_a_of_type_Boolean) {
                  i1 = Math.max(paramInt1, ((amdp)localObject).b());
                }
              }
              paramInt2 += 1;
              paramInt1 = i1;
            }
          }
          paramInt1 = Math.max(i1, getSuggestedMinimumHeight());
          break;
        }
      }
      label472:
      n = paramInt1;
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
    amdo localamdo2 = this.jdField_a_of_type_Amdo;
    if (paramInt == 0) {
      if (localamdo2 == null) {}
    }
    amdo localamdo1;
    for (localamdo2.e = paramInt;; localamdo1.e = paramInt)
    {
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
      localamdo1 = localamdo2;
      if (localamdo2 == null)
      {
        localamdo1 = new amdo(null);
        this.jdField_a_of_type_Amdo = localamdo1;
      }
    }
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    Object localObject2 = this.jdField_a_of_type_Amdo;
    int n;
    if ((paramDrawable1 != null) || (paramDrawable2 != null))
    {
      n = 1;
      if (n != 0) {
        break label137;
      }
      if (localObject2 != null)
      {
        if (((amdo)localObject2).e != 0) {
          break label64;
        }
        this.jdField_a_of_type_Amdo = null;
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
      n = 0;
      break;
      label64:
      if (((amdo)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        ((amdo)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((amdo)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      if (((amdo)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
        ((amdo)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((amdo)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
      ((amdo)localObject2).jdField_c_of_type_Int = 0;
      ((amdo)localObject2).jdField_a_of_type_Int = 0;
      ((amdo)localObject2).d = 0;
      ((amdo)localObject2).jdField_b_of_type_Int = 0;
      continue;
      label137:
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new amdo(null);
        this.jdField_a_of_type_Amdo = ((amdo)localObject1);
      }
      if ((((amdo)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != paramDrawable1) && (((amdo)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
        ((amdo)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((amdo)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable1;
      if ((((amdo)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable != paramDrawable1) && (((amdo)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)) {
        ((amdo)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((amdo)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable2;
      localObject2 = ((amdo)localObject1).jdField_a_of_type_AndroidGraphicsRect;
      int[] arrayOfInt = getDrawableState();
      if (paramDrawable1 != null)
      {
        paramDrawable1.setState(arrayOfInt);
        paramDrawable1.copyBounds((Rect)localObject2);
        paramDrawable1.setCallback(this);
        ((amdo)localObject1).jdField_a_of_type_Int = ((Rect)localObject2).width();
        ((amdo)localObject1).jdField_c_of_type_Int = ((Rect)localObject2).height();
      }
      for (;;)
      {
        if (paramDrawable2 == null) {
          break label341;
        }
        paramDrawable2.setState(arrayOfInt);
        paramDrawable2.copyBounds((Rect)localObject2);
        paramDrawable2.setCallback(this);
        ((amdo)localObject1).jdField_b_of_type_Int = ((Rect)localObject2).width();
        ((amdo)localObject1).d = ((Rect)localObject2).height();
        break;
        ((amdo)localObject1).jdField_c_of_type_Int = 0;
        ((amdo)localObject1).jdField_a_of_type_Int = 0;
      }
      label341:
      ((amdo)localObject1).d = 0;
      ((amdo)localObject1).jdField_b_of_type_Int = 0;
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
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfAmdp.length)) {}
    amdp localamdp2;
    boolean bool;
    do
    {
      return;
      localamdp2 = this.jdField_a_of_type_ArrayOfAmdp[paramInt];
      bool = TextUtils.isEmpty(paramString);
    } while ((bool) && ((localamdp2 == null) || (localamdp2.jdField_a_of_type_Boolean)));
    int n;
    if ((bool) && (localamdp2 != null) && (!localamdp2.jdField_a_of_type_Boolean))
    {
      localamdp2.a();
      n = 1;
    }
    for (;;)
    {
      if ((paramInt == 0) && (n != 0)) {
        postInvalidate();
      }
      if ((n == 0) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (!bool)
      {
        amdp localamdp1 = localamdp2;
        if (localamdp2 == null)
        {
          localamdp1 = new amdp(getResources());
          this.jdField_a_of_type_ArrayOfAmdp[paramInt] = localamdp1;
        }
        if (!paramString.equals(localamdp1.jdField_a_of_type_JavaLangString))
        {
          localamdp1.jdField_a_of_type_JavaLangString = paramString;
          localamdp1.jdField_c_of_type_Int = -1;
          localamdp1.jdField_a_of_type_Boolean = false;
          n = 1;
          continue;
        }
      }
      n = 0;
    }
  }
  
  public void setExtendTextColor(ColorStateList paramColorStateList, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfAmdp.length)) {}
    amdp localamdp1;
    do
    {
      return;
      amdp localamdp2 = this.jdField_a_of_type_ArrayOfAmdp[paramInt];
      localamdp1 = localamdp2;
      if (localamdp2 == null)
      {
        localamdp1 = new amdp(getResources());
        this.jdField_a_of_type_ArrayOfAmdp[paramInt] = localamdp1;
      }
    } while (!localamdp1.a(paramColorStateList, getDrawableState()));
    postInvalidate();
  }
  
  public void setExtendTextPadding(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_ArrayOfAmdp.length)) {}
    amdp localamdp2;
    do
    {
      return;
      localamdp2 = this.jdField_a_of_type_ArrayOfAmdp[paramInt2];
    } while ((paramInt1 <= 0) && ((localamdp2 == null) || (localamdp2.jdField_a_of_type_Boolean)));
    amdp localamdp1 = localamdp2;
    if (localamdp2 == null)
    {
      localamdp1 = new amdp(getResources());
      this.jdField_a_of_type_ArrayOfAmdp[paramInt2] = localamdp1;
    }
    localamdp1.jdField_b_of_type_Int = paramInt1;
  }
  
  public void setExtendTextSize(float paramFloat, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfAmdp.length)) {}
    amdp localamdp1;
    do
    {
      return;
      amdp localamdp2 = this.jdField_a_of_type_ArrayOfAmdp[paramInt];
      localamdp1 = localamdp2;
      if (localamdp2 == null)
      {
        localamdp1 = new amdp(getResources());
        this.jdField_a_of_type_ArrayOfAmdp[paramInt] = localamdp1;
      }
    } while ((!localamdp1.a(paramFloat, getContext())) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void setGravity(int paramInt)
  {
    if ((paramInt & 0x7) == 0) {
      paramInt |= 0x3;
    }
    for (;;)
    {
      int n = paramInt;
      if ((paramInt & 0x70) == 0) {
        n = paramInt | 0x30;
      }
      paramInt = 0;
      if ((n & 0x7) != (this.f & 0x7)) {
        paramInt = 1;
      }
      if (n != this.f) {
        invalidate();
      }
      this.f = n;
      if ((this.jdField_a_of_type_AndroidTextLayout != null) && (paramInt != 0))
      {
        paramInt = this.jdField_a_of_type_AndroidTextLayout.getWidth();
        n = getWidth();
        int i1 = a();
        int i2 = b();
        a(paramInt, jdField_a_of_type_AndroidTextBoringLayout$Metrics, n - i1 - i2);
      }
      return;
    }
  }
  
  public void setIconDrawablePadding(int paramInt1, int paramInt2)
  {
    this.m = paramInt1;
    this.l = paramInt2;
    if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    }
  }
  
  public void setIconDrawables(Drawable[] paramArrayOfDrawable, boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_ArrayOfAmdq;
    if (!paramBoolean)
    {
      if (localObject2 != null)
      {
        if (this.l != 0) {
          break label48;
        }
        this.jdField_a_of_type_ArrayOfAmdq = null;
      }
      for (;;)
      {
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        }
        return;
        label48:
        int i1 = localObject2.length;
        n = 0;
        while (n < i1)
        {
          paramArrayOfDrawable = localObject2[n];
          if (paramArrayOfDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            paramArrayOfDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
          }
          paramArrayOfDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
          paramArrayOfDrawable.jdField_a_of_type_Int = 0;
          paramArrayOfDrawable.jdField_b_of_type_Int = 0;
          n += 1;
        }
      }
    }
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new amdq[paramArrayOfDrawable.length];
      this.jdField_a_of_type_ArrayOfAmdq = ((amdq[])localObject1);
      n = 0;
      while (n < localObject1.length)
      {
        localObject1[n] = new amdq(null);
        n += 1;
      }
    }
    localObject2 = getDrawableState();
    int n = 0;
    label161:
    Rect localRect;
    if (n < localObject1.length)
    {
      if ((localObject1[n].jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (localObject1[n].jdField_a_of_type_AndroidGraphicsDrawableDrawable != paramArrayOfDrawable[n])) {
        localObject1[n].jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      localObject1[n].jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramArrayOfDrawable[n];
      localRect = localObject1[n].jdField_a_of_type_AndroidGraphicsRect;
      if (paramArrayOfDrawable[n] == null) {
        break label282;
      }
      paramArrayOfDrawable[n].setState((int[])localObject2);
      paramArrayOfDrawable[n].copyBounds(localRect);
      paramArrayOfDrawable[n].setCallback(this);
      localObject1[n].jdField_a_of_type_Int = localRect.width();
      localObject1[n].jdField_b_of_type_Int = localRect.height();
    }
    for (;;)
    {
      n += 1;
      break label161;
      break;
      label282:
      localRect = localObject1[n];
      localObject1[n].jdField_b_of_type_Int = 0;
      localRect.jdField_a_of_type_Int = 0;
    }
  }
  
  public void setIconDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Drawable localDrawable4 = null;
    if ((this.h == paramInt1) && (this.i == paramInt2) && (this.j == paramInt3) && (this.k == paramInt4)) {
      return;
    }
    this.h = paramInt1;
    this.i = paramInt2;
    this.j = paramInt3;
    this.k = paramInt4;
    Resources localResources = getContext().getResources();
    Drawable localDrawable1;
    Drawable localDrawable2;
    if (paramInt1 != 0)
    {
      localDrawable1 = localResources.getDrawable(paramInt1);
      if (paramInt2 == 0) {
        break label136;
      }
      localDrawable2 = localResources.getDrawable(paramInt2);
      label91:
      if (paramInt3 == 0) {
        break label142;
      }
    }
    label136:
    label142:
    for (Drawable localDrawable3 = localResources.getDrawable(paramInt3);; localDrawable3 = null)
    {
      if (paramInt4 != 0) {
        localDrawable4 = localResources.getDrawable(paramInt4);
      }
      setIconDrawablesWithIntrinsicBounds(localDrawable1, localDrawable2, localDrawable3, localDrawable4);
      return;
      localDrawable1 = null;
      break;
      localDrawable2 = null;
      break label91;
    }
  }
  
  public void setIconDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    Drawable[] arrayOfDrawable = new Drawable[4];
    arrayOfDrawable[0] = paramDrawable1;
    arrayOfDrawable[1] = paramDrawable4;
    arrayOfDrawable[2] = paramDrawable2;
    arrayOfDrawable[3] = paramDrawable3;
    int i1 = arrayOfDrawable.length;
    int n = 0;
    boolean bool = false;
    while (n < i1)
    {
      paramDrawable1 = arrayOfDrawable[n];
      if (paramDrawable1 != null)
      {
        paramDrawable1.setBounds(0, 0, paramDrawable1.getIntrinsicWidth(), paramDrawable1.getIntrinsicHeight());
        bool = true;
      }
      n += 1;
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
    int n = 0;
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
          int i1 = paramCharSequence.length();
          ((Spannable)paramCharSequence).setSpan(this.jdField_a_of_type_AndroidTextMethodTransformationMethod, 0, i1, 18);
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
        if (n >= paramCharSequence.length) {
          break;
        }
        localObject = paramCharSequence[n].a();
        if (localObject != null) {
          ((Drawable)localObject).setCallback(this);
        }
        n += 1;
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