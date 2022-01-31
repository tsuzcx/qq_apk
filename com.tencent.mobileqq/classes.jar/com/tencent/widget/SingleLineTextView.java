package com.tencent.widget;

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
import asbd;
import axkk;
import bacc;
import benf;
import beng;
import benh;
import beni;
import benj;
import benk;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class SingleLineTextView
  extends View
  implements Handler.Callback
{
  private static final BoringLayout.Metrics jdField_a_of_type_AndroidTextBoringLayout$Metrics = new BoringLayout.Metrics();
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private BoringLayout jdField_a_of_type_AndroidTextBoringLayout;
  protected Layout a;
  private final TextPaint jdField_a_of_type_AndroidTextTextPaint;
  private TextUtils.TruncateAt jdField_a_of_type_AndroidTextTextUtils$TruncateAt;
  private TransformationMethod jdField_a_of_type_AndroidTextMethodTransformationMethod;
  private benf jdField_a_of_type_Benf;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  ArrayList<benk> jdField_a_of_type_JavaUtilArrayList;
  private boolean jdField_a_of_type_Boolean;
  private final beng[] jdField_a_of_type_ArrayOfBeng;
  private benj[] jdField_a_of_type_ArrayOfBenj;
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = -16777216;
  private BoringLayout.Metrics jdField_b_of_type_AndroidTextBoringLayout$Metrics;
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e = 2147483647;
  private int f = 16;
  private int g;
  private int h;
  private int i;
  
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
    this.jdField_a_of_type_ArrayOfBeng = new beng[3];
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-16777216);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentResColorStateList.getDefaultColor();
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SingleLineTextView);
      paramInt = paramAttributeSet.getDimensionPixelSize(0, (int)bacc.a(paramContext, 12.0F));
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
  
  public static Drawable a(Context paramContext, benk parambenk)
  {
    Object localObject2 = null;
    asbd localasbd = null;
    Object localObject1 = localObject2;
    if (paramContext != null)
    {
      localObject1 = localObject2;
      if (parambenk != null)
      {
        if (TextUtils.isEmpty(parambenk.jdField_a_of_type_JavaLangString)) {
          break label81;
        }
        localasbd = new asbd(paramContext, parambenk.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      localObject1 = localasbd;
      if (localasbd != null)
      {
        localObject1 = localasbd.mutate();
        ((Drawable)localObject1).setAlpha((int)(parambenk.jdField_a_of_type_Float * 255.0F));
        ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
      }
      return localObject1;
      label81:
      if (parambenk.jdField_a_of_type_Int != 0) {
        localasbd = new asbd(paramContext, parambenk.jdField_a_of_type_Int);
      }
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams.width != -2)
    {
      int j = getWidth() - a() - b();
      if (j > 0)
      {
        int k = this.jdField_a_of_type_AndroidTextLayout.getHeight();
        a(this.jdField_a_of_type_AndroidTextLayout.getWidth(), jdField_a_of_type_AndroidTextBoringLayout$Metrics, j);
        if ((localLayoutParams.height != -2) && (localLayoutParams.height != -1))
        {
          invalidate();
          return;
        }
        if (this.jdField_a_of_type_AndroidTextLayout.getHeight() == k)
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
      int k = ((Spannable)localObject).getSpanStart(paramObject);
      int m = ((Spannable)localObject).getSpanEnd(paramObject);
      SpanWatcher[] arrayOfSpanWatcher = (SpanWatcher[])((Spannable)localObject).getSpans(k, m, SpanWatcher.class);
      if ((arrayOfSpanWatcher != null) && (arrayOfSpanWatcher.length > 0))
      {
        int n = arrayOfSpanWatcher.length;
        int j = 0;
        for (;;)
        {
          if (j < n)
          {
            SpanWatcher localSpanWatcher = arrayOfSpanWatcher[j];
            try
            {
              localSpanWatcher.onSpanChanged((Spannable)localObject, paramObject, k, m, k, m);
              j += 1;
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
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    int j = g();
    boolean bool1 = bool2;
    int m;
    benj[] arrayOfbenj;
    if (j > 0)
    {
      bool1 = bool2;
      if (j > (int)bacc.a(getContext(), 105.0F))
      {
        m = Math.min(i(), getResources().getDimensionPixelSize(2131165604));
        bool1 = bool2;
        if (paramInt < m)
        {
          arrayOfbenj = this.jdField_a_of_type_ArrayOfBenj;
          bool1 = bool2;
          if (arrayOfbenj != null) {
            j = 0;
          }
        }
      }
    }
    for (int k = paramInt;; k = paramInt)
    {
      bool1 = bool2;
      if (j < arrayOfbenj.length)
      {
        benj localbenj = arrayOfbenj[j];
        paramInt = k;
        if (localbenj != null)
        {
          paramInt = k;
          if (localbenj.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
          {
            paramInt = k;
            if (!localbenj.jdField_a_of_type_Boolean)
            {
              paramInt = k;
              if (localbenj.jdField_a_of_type_Int > 0)
              {
                k += localbenj.jdField_a_of_type_Int;
                localbenj.jdField_a_of_type_Int = 0;
                paramInt = k;
                if (k >= m) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
      else
      {
        return bool1;
      }
      j += 1;
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
    int j = this.jdField_a_of_type_AndroidContentResColorStateList.getColorForState(arrayOfInt, this.jdField_b_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.i("SingleLineTextView", 2, "updateTextColors, color=" + j + ", cur=" + this.jdField_a_of_type_Int);
    }
    if (j != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = j;
      invalidate();
    }
  }
  
  private int g()
  {
    int k = 0;
    int j = 0;
    benj[] arrayOfbenj = this.jdField_a_of_type_ArrayOfBenj;
    if (arrayOfbenj != null)
    {
      int i2 = arrayOfbenj.length;
      k = 0;
      int m = 0;
      while (k < i2)
      {
        benj localbenj = arrayOfbenj[k];
        int i1 = m;
        int n = j;
        if (localbenj.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          i1 = m;
          n = j;
          if (localbenj.jdField_a_of_type_Int > 0)
          {
            n = j + (this.i + localbenj.jdField_a_of_type_Int);
            i1 = 1;
          }
        }
        k += 1;
        m = i1;
        j = n;
      }
      k = j;
      if (m != 0) {
        k = j + this.h;
      }
    }
    return k;
  }
  
  private int h()
  {
    int k = 0;
    int m = this.f & 0x70;
    Layout localLayout = this.jdField_a_of_type_AndroidTextLayout;
    int j = k;
    int n;
    int i1;
    if (m != 48)
    {
      n = getMeasuredHeight() - e() - f();
      i1 = localLayout.getHeight();
      j = k;
      if (i1 < n)
      {
        if (m != 80) {
          break label70;
        }
        j = n - i1;
      }
    }
    return j;
    label70:
    return n - i1 >> 1;
  }
  
  private int i()
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
    int k = getPaddingLeft();
    Object localObject = this.jdField_a_of_type_Benf;
    int j = k;
    if (localObject != null)
    {
      j = k;
      if (((benf)localObject).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        j = ((benf)localObject).g;
        j = k + (((benf)localObject).jdField_a_of_type_Int + j);
      }
    }
    localObject = this.jdField_a_of_type_ArrayOfBeng[1];
    k = j;
    if (localObject != null)
    {
      k = j;
      if (!((beng)localObject).jdField_a_of_type_Boolean)
      {
        k = ((beng)localObject).jdField_b_of_type_Int;
        k = j + (((beng)localObject).a() + k);
      }
    }
    return k;
  }
  
  public Drawable a()
  {
    if (this.jdField_a_of_type_Benf != null) {
      return this.jdField_a_of_type_Benf.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    }
    return null;
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
        this.jdField_a_of_type_AndroidTextLayout = new benh(this.jdField_a_of_type_JavaLangCharSequence, this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramInt2);
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
          this.jdField_a_of_type_AndroidTextLayout = new beni(this.jdField_b_of_type_JavaLangCharSequence, 0, this.jdField_b_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramInt2);
          return;
        }
        this.jdField_a_of_type_AndroidTextLayout = new beni(this.jdField_b_of_type_JavaLangCharSequence, 0, this.jdField_b_of_type_JavaLangCharSequence.length(), this.jdField_a_of_type_AndroidTextTextPaint, paramInt1, localAlignment, this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_AndroidTextTextUtils$TruncateAt, paramInt2);
        return;
      }
    }
  }
  
  public int b()
  {
    int j = getPaddingRight();
    Object localObject = this.jdField_a_of_type_Benf;
    int k = j;
    if (localObject != null)
    {
      k = j;
      if (((benf)localObject).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
        k = j + (((benf)localObject).g + ((benf)localObject).jdField_b_of_type_Int + ((benf)localObject).g);
      }
    }
    j = k;
    if (localObject != null)
    {
      j = k;
      if (((benf)localObject).jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        if (((benf)localObject).jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
          break label178;
        }
        j = ((benf)localObject).jdField_c_of_type_Int;
      }
    }
    label178:
    int m;
    for (j = k + (((benf)localObject).g + j);; j = k + (((benf)localObject).g + (j + m)))
    {
      localObject = this.jdField_a_of_type_ArrayOfBeng[2];
      k = j;
      if (localObject != null)
      {
        k = j;
        if (!((beng)localObject).jdField_a_of_type_Boolean)
        {
          k = ((beng)localObject).jdField_b_of_type_Int;
          k = j + (((beng)localObject).a() + k);
        }
      }
      localObject = this.jdField_a_of_type_ArrayOfBeng[0];
      j = k;
      if (localObject != null)
      {
        j = k;
        if (!((beng)localObject).jdField_a_of_type_Boolean)
        {
          j = ((beng)localObject).jdField_b_of_type_Int;
          j = k + (((beng)localObject).a() + j);
        }
      }
      return j + g();
      j = ((benf)localObject).g;
      m = ((benf)localObject).jdField_c_of_type_Int;
    }
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
    int k = 0;
    super.drawableStateChanged();
    if ((this.jdField_a_of_type_AndroidContentResColorStateList != null) && (this.jdField_a_of_type_AndroidContentResColorStateList.isStateful())) {
      c();
    }
    int[] arrayOfInt = getDrawableState();
    Object localObject1 = this.jdField_a_of_type_Benf;
    if (localObject1 != null)
    {
      if ((((benf)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (((benf)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
        ((benf)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
      }
      if ((((benf)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) && (((benf)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
        ((benf)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
      }
      if ((((benf)localObject1).jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) && (((benf)localObject1).jdField_c_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
        ((benf)localObject1).jdField_c_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
      }
    }
    localObject1 = this.jdField_a_of_type_ArrayOfBenj;
    if (localObject1 != null)
    {
      int m = localObject1.length;
      j = 0;
      while (j < m)
      {
        Object localObject2 = localObject1[j];
        if ((localObject2.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (localObject2.jdField_a_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
          localObject2.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
        }
        j += 1;
      }
    }
    int j = 0;
    if (j < this.jdField_a_of_type_ArrayOfBeng.length)
    {
      localObject1 = this.jdField_a_of_type_ArrayOfBeng[j];
      if (localObject1 == null) {}
      for (;;)
      {
        j += 1;
        break;
        if (((beng)localObject1).a(arrayOfInt)) {
          k = 1;
        }
      }
    }
    if (k != 0) {
      invalidate();
    }
  }
  
  public int e()
  {
    int j;
    if (this.jdField_a_of_type_AndroidTextLayout.getLineCount() <= 1) {
      j = c();
    }
    int k;
    int m;
    int n;
    int i1;
    do
    {
      do
      {
        return j;
        k = c();
        j = d();
        m = getHeight() - k - j;
        n = this.jdField_a_of_type_AndroidTextLayout.getLineTop(1);
        j = k;
      } while (n >= m);
      i1 = this.f & 0x70;
      j = k;
    } while (i1 == 48);
    if (i1 == 80) {
      return k + m - n;
    }
    return k + (m - n) / 2;
  }
  
  public int f()
  {
    int j;
    if (this.jdField_a_of_type_AndroidTextLayout.getLineCount() <= 1) {
      j = d();
    }
    int k;
    int m;
    int n;
    int i1;
    do
    {
      do
      {
        return j;
        j = c();
        k = d();
        m = getHeight() - j - k;
        n = this.jdField_a_of_type_AndroidTextLayout.getLineTop(1);
        j = k;
      } while (n >= m);
      i1 = this.f & 0x70;
      if (i1 == 48) {
        return k + m - n;
      }
      j = k;
    } while (i1 == 80);
    return k + (m - n) / 2;
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
    Object localObject1;
    int j;
    int k;
    Object localObject2;
    int n;
    int i1;
    int i2;
    int m;
    if (verifyDrawable(paramDrawable))
    {
      localObject1 = paramDrawable.getBounds();
      j = getScrollX();
      k = getScrollY();
      localObject2 = this.jdField_a_of_type_Benf;
      if (localObject2 == null) {
        break label721;
      }
      if (paramDrawable == ((benf)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable)
      {
        n = c();
        i1 = d();
        i2 = getHeight();
        m = getPaddingLeft();
        k = (i2 - i1 - n - ((benf)localObject2).jdField_d_of_type_Int) / 2 + n + k;
        j = m + j;
      }
    }
    label720:
    label721:
    for (;;)
    {
      localObject2 = this.jdField_a_of_type_ArrayOfBenj;
      i2 = k;
      i1 = j;
      Object localObject3;
      if (localObject2 != null)
      {
        localObject3 = this.jdField_a_of_type_ArrayOfBeng[0];
        n = getWidth() - getPaddingRight() - this.h;
        m = n;
        if (localObject3 != null)
        {
          m = n;
          if (!((beng)localObject3).jdField_a_of_type_Boolean)
          {
            m = ((beng)localObject3).a();
            m = n - (((beng)localObject3).jdField_b_of_type_Int + m);
          }
        }
        n = 0;
      }
      for (;;)
      {
        i2 = k;
        i1 = j;
        if (n < localObject2.length)
        {
          if (paramDrawable == localObject2[n].jdField_a_of_type_AndroidGraphicsDrawableDrawable)
          {
            localObject3 = localObject2[n].jdField_a_of_type_AndroidGraphicsRect;
            paramDrawable.copyBounds((Rect)localObject3);
            localObject2[n].jdField_a_of_type_Int = ((Rect)localObject3).width();
            localObject2[n].jdField_b_of_type_Int = ((Rect)localObject3).height();
            int i3 = c();
            int i4 = d();
            int i5 = getHeight();
            i2 = n + 1;
            i1 = m;
            m = i2;
            for (;;)
            {
              if (m < localObject2.length)
              {
                i2 = i1;
                if (localObject2[m].jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
                  i2 = i1 - (localObject2[m].jdField_a_of_type_Int - this.i);
                }
                j += i2 - localObject2[n].jdField_a_of_type_Int - this.i;
                m += 1;
                i1 = i2;
                continue;
                if (paramDrawable == ((benf)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable)
                {
                  i2 = c();
                  i3 = d();
                  i4 = getHeight();
                  m = getWidth();
                  n = getPaddingRight();
                  i1 = ((benf)localObject2).jdField_b_of_type_Int;
                  k = (i4 - i3 - i2 - ((benf)localObject2).e) / 2 + i2 + k;
                  j = m - n - i1 + j;
                  break;
                }
                if (paramDrawable != ((benf)localObject2).jdField_c_of_type_AndroidGraphicsDrawableDrawable) {
                  break label721;
                }
                n = c();
                i1 = d();
                i2 = getHeight();
                m = j + i();
                j = m;
                if (((benf)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
                  j = m + (((benf)localObject2).jdField_b_of_type_Int + ((benf)localObject2).g);
                }
                m = (i2 - i1 - n - ((benf)localObject2).f) / 2;
                k += n + m;
                break;
              }
            }
            i1 = i1 - localObject2[n].jdField_a_of_type_Int - this.i + j;
            i2 = k + ((i5 - i4 - i3 - localObject2[n].jdField_b_of_type_Int) / 2 + i3);
          }
        }
        else
        {
          invalidate(((Rect)localObject1).left + i1, ((Rect)localObject1).top + i2, i1 + ((Rect)localObject1).right, i2 + ((Rect)localObject1).bottom);
          localObject1 = a();
          if (!(localObject1 instanceof Spannable)) {
            break label720;
          }
          localObject1 = (Spannable)localObject1;
          localObject1 = (axkk[])((Spannable)localObject1).getSpans(0, ((Spannable)localObject1).length(), axkk.class);
          if ((localObject1 == null) || (localObject1.length <= 0)) {
            break label720;
          }
          this.jdField_d_of_type_Boolean = true;
          k = localObject1.length;
          j = 0;
          while (j < k)
          {
            localObject2 = localObject1[j];
            if (((axkk)localObject2).a() == paramDrawable) {
              a(localObject2);
            }
            j += 1;
          }
        }
        n += 1;
      }
      this.jdField_d_of_type_Boolean = false;
      return;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int n = a();
    int i2 = c();
    int i10 = b();
    int m = d();
    int i5 = getScrollX();
    int i3 = getScrollY();
    int i6 = getRight();
    int i7 = getLeft();
    int i1 = getBottom();
    int i11 = getTop();
    int j;
    if (this.jdField_a_of_type_AndroidTextLayout == null)
    {
      k = i6 - i7 - n - i10;
      j = k;
      if (k < 1) {
        j = 0;
      }
      if (!this.jdField_a_of_type_Boolean) {
        break label1192;
      }
    }
    label1171:
    label1178:
    label1185:
    label1192:
    for (int k = 16384;; k = j)
    {
      a(k, jdField_a_of_type_AndroidTextBoringLayout$Metrics, j);
      int i8 = e();
      int i12 = f();
      int i4 = i1 - i11 - m - i2;
      int i9 = this.jdField_a_of_type_AndroidTextLayout.getLineTop(1) - this.jdField_a_of_type_AndroidTextLayout.getLineDescent(0);
      m = 0;
      k = 0;
      j = 0;
      if ((this.f & 0x70) != 48)
      {
        k = h();
        j = h();
      }
      Object localObject1 = getDrawableState();
      Object localObject2 = this.jdField_a_of_type_Benf;
      if ((localObject2 != null) && (((benf)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
      {
        paramCanvas.save();
        int i13 = getPaddingLeft();
        int i14 = (i4 - ((benf)localObject2).jdField_d_of_type_Int) / 2;
        paramCanvas.translate(i13 + i5, i3 + i2 + i14);
        ((benf)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        paramCanvas.restore();
      }
      Object localObject3 = this.jdField_a_of_type_ArrayOfBeng[1];
      Paint.FontMetrics localFontMetrics;
      float f2;
      float f1;
      if ((localObject3 != null) && (!((beng)localObject3).jdField_a_of_type_Boolean))
      {
        paramCanvas.save();
        paramCanvas.translate(i5 + n - ((beng)localObject3).a(), i8 + k);
        localFontMetrics = ((beng)localObject3).a();
        f2 = i9;
        f1 = f2;
        if (localFontMetrics != null)
        {
          f1 = f2;
          if (f2 > getMeasuredHeight() - localFontMetrics.bottom) {
            f1 = (int)(getMeasuredHeight() - localFontMetrics.bottom);
          }
        }
        ((beng)localObject3).a(paramCanvas, (int[])localObject1, 0.0F, f1);
        paramCanvas.restore();
      }
      localObject3 = this.jdField_a_of_type_AndroidTextLayout;
      this.jdField_a_of_type_AndroidTextTextPaint.setColor(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_AndroidTextTextPaint.drawableState = getDrawableState();
      paramCanvas.save();
      paramCanvas.clipRect(n + i5, i8 + i3, i6 - i7 - i10 + i5, i1 - i11 - i12 + i3);
      paramCanvas.translate(n, i8 + k);
      ((Layout)localObject3).draw(paramCanvas, null, null, j - k);
      paramCanvas.restore();
      localObject3 = this.jdField_a_of_type_ArrayOfBeng[2];
      j = m;
      if (localObject3 != null)
      {
        j = m;
        if (!((beng)localObject3).jdField_a_of_type_Boolean)
        {
          paramCanvas.save();
          j = i() + 0 + ((beng)localObject3).jdField_b_of_type_Int;
          n = i5 + i6 - i7 - i10 + 0;
          m = 0 + (((beng)localObject3).a() + ((beng)localObject3).jdField_b_of_type_Int);
          if (n <= j) {
            break label1185;
          }
        }
      }
      for (;;)
      {
        paramCanvas.translate(j, i8 + k);
        localFontMetrics = ((beng)localObject3).a();
        f2 = i9;
        f1 = f2;
        if (localFontMetrics != null)
        {
          f1 = f2;
          if (f2 > getMeasuredHeight() - localFontMetrics.bottom) {
            f1 = (int)(((beng)localObject3).b() - localFontMetrics.bottom);
          }
        }
        ((beng)localObject3).a(paramCanvas, (int[])localObject1, 0.0F, f1);
        paramCanvas.restore();
        j = m;
        m = j;
        if (localObject2 != null)
        {
          m = j;
          if (((benf)localObject2).jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
          {
            paramCanvas.save();
            n = i() + j + ((benf)localObject2).g;
            i1 = i5 + i6 - i7 - i10 + j + ((benf)localObject2).g;
            m = j + (((benf)localObject2).jdField_c_of_type_Int + ((benf)localObject2).g);
            if (i1 <= n) {
              break label1178;
            }
          }
        }
        for (j = n;; j = i1)
        {
          n = (i4 - ((benf)localObject2).f) / 2;
          paramCanvas.translate(j, i3 + i2 + n);
          ((benf)localObject2).jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
          paramCanvas.restore();
          if ((localObject2 != null) && (((benf)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null))
          {
            paramCanvas.save();
            j = i() + m + ((benf)localObject2).g;
            m = i5 + i6 - i7 - i10 + m + ((benf)localObject2).g;
            n = ((benf)localObject2).jdField_b_of_type_Int;
            n = ((benf)localObject2).g;
            if (m <= j) {
              break label1171;
            }
          }
          for (;;)
          {
            m = (i4 - ((benf)localObject2).e) / 2;
            paramCanvas.translate(j, i3 + i2 + m);
            ((benf)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
            paramCanvas.restore();
            localObject2 = this.jdField_a_of_type_ArrayOfBeng[0];
            m = 0;
            j = m;
            if (localObject2 != null)
            {
              j = m;
              if (!((beng)localObject2).jdField_a_of_type_Boolean)
              {
                paramCanvas.save();
                paramCanvas.translate(i5 + i6 - i7 - ((beng)localObject2).a() - getPaddingRight(), k + i8);
                ((beng)localObject2).a(paramCanvas, (int[])localObject1, 0.0F, i9);
                paramCanvas.restore();
                j = ((beng)localObject2).a();
              }
            }
            localObject1 = this.jdField_a_of_type_ArrayOfBenj;
            if (localObject1 != null)
            {
              k = getPaddingRight();
              n = this.h;
              m = localObject1.length;
              k = i5 + i6 - i7 - j - k - n;
              j = m - 1;
              while (j >= 0)
              {
                m = k;
                if (localObject1[j].jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
                {
                  m = k;
                  if (localObject1[j].jdField_a_of_type_Int != 0)
                  {
                    paramCanvas.save();
                    m = k - this.i - localObject1[j].jdField_a_of_type_Int;
                    k = (i4 - localObject1[j].jdField_b_of_type_Int) / 2;
                    paramCanvas.translate(m, i3 + i2 + k);
                    localObject1[j].jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
                    paramCanvas.restore();
                  }
                }
                j -= 1;
                k = m;
              }
            }
            return;
            j = m;
          }
        }
        j = n;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = 0;
    if (Build.VERSION.SDK_INT < 21) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    }
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    Object localObject = jdField_a_of_type_AndroidTextBoringLayout$Metrics;
    if (i1 == 1073741824) {}
    for (;;)
    {
      paramInt2 = j - a() - b();
      if ((this.jdField_c_of_type_Boolean) && (a(paramInt2))) {
        paramInt2 = j - a() - b();
      }
      for (paramInt1 = paramInt2;; paramInt1 = paramInt2)
      {
        if (this.jdField_a_of_type_Boolean) {
          paramInt1 = 16384;
        }
        if (this.jdField_a_of_type_AndroidTextLayout == null) {
          a(paramInt1, (BoringLayout.Metrics)localObject, paramInt2);
        }
        for (;;)
        {
          if (n != 1073741824) {
            break label271;
          }
          paramInt1 = k;
          setMeasuredDimension(j, paramInt1);
          return;
          localObject = BoringLayout.isBoring(this.jdField_b_of_type_JavaLangCharSequence, this.jdField_a_of_type_AndroidTextTextPaint, this.jdField_b_of_type_AndroidTextBoringLayout$Metrics);
          if (localObject != null) {
            this.jdField_b_of_type_AndroidTextBoringLayout$Metrics = ((BoringLayout.Metrics)localObject);
          }
          if ((localObject == null) || (localObject == jdField_a_of_type_AndroidTextBoringLayout$Metrics)) {}
          for (paramInt1 = i();; paramInt1 = ((BoringLayout.Metrics)localObject).width)
          {
            paramInt1 = Math.max(Math.min(paramInt1 + (a() + b()), this.e), getSuggestedMinimumWidth());
            if (i1 != -2147483648) {
              break label498;
            }
            j = Math.min(j, paramInt1);
            break;
          }
          if ((this.jdField_a_of_type_AndroidTextLayout.getWidth() != paramInt1) || (this.jdField_a_of_type_AndroidTextLayout.getEllipsizedWidth() != paramInt2)) {
            a(paramInt1, (BoringLayout.Metrics)localObject, paramInt2);
          }
        }
        label271:
        n = c() + d();
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
          paramInt1 += n;
          localObject = this.jdField_a_of_type_Benf;
          paramInt2 = paramInt1;
          if (localObject != null) {
            paramInt2 = Math.max(Math.max(paramInt1, ((benf)localObject).jdField_d_of_type_Int), ((benf)localObject).e);
          }
          localObject = this.jdField_a_of_type_ArrayOfBenj;
          paramInt1 = paramInt2;
          if (localObject != null)
          {
            i1 = localObject.length;
            k = 0;
            for (;;)
            {
              paramInt1 = paramInt2;
              if (k >= i1) {
                break;
              }
              paramInt2 = Math.max(paramInt2, localObject[k].jdField_b_of_type_Int);
              k += 1;
            }
          }
          k = paramInt1;
          if (paramInt1 == n)
          {
            paramInt2 = m;
            for (;;)
            {
              k = paramInt1;
              if (paramInt2 >= this.jdField_a_of_type_ArrayOfBeng.length) {
                break;
              }
              localObject = this.jdField_a_of_type_ArrayOfBeng[paramInt2];
              k = paramInt1;
              if (localObject != null)
              {
                k = paramInt1;
                if (!((beng)localObject).jdField_a_of_type_Boolean) {
                  k = Math.max(paramInt1, ((beng)localObject).b());
                }
              }
              paramInt2 += 1;
              paramInt1 = k;
            }
          }
          paramInt1 = Math.max(k, getSuggestedMinimumHeight());
          break;
        }
      }
      label498:
      j = paramInt1;
    }
  }
  
  public void requestLayout()
  {
    if (!this.jdField_d_of_type_Boolean) {
      super.requestLayout();
    }
  }
  
  public void setCompoundDrawablePadding(int paramInt)
  {
    benf localbenf2 = this.jdField_a_of_type_Benf;
    if (paramInt == 0) {
      if (localbenf2 == null) {}
    }
    benf localbenf1;
    for (localbenf2.g = paramInt;; localbenf1.g = paramInt)
    {
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
      localbenf1 = localbenf2;
      if (localbenf2 == null)
      {
        localbenf1 = new benf(null);
        this.jdField_a_of_type_Benf = localbenf1;
      }
    }
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    Object localObject2 = this.jdField_a_of_type_Benf;
    int j;
    if ((paramDrawable1 != null) || (paramDrawable2 != null))
    {
      j = 1;
      if (j != 0) {
        break label137;
      }
      if (localObject2 != null)
      {
        if (((benf)localObject2).g != 0) {
          break label64;
        }
        this.jdField_a_of_type_Benf = null;
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
      j = 0;
      break;
      label64:
      if (((benf)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        ((benf)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((benf)localObject2).jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      if (((benf)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
        ((benf)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((benf)localObject2).jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
      ((benf)localObject2).jdField_d_of_type_Int = 0;
      ((benf)localObject2).jdField_a_of_type_Int = 0;
      ((benf)localObject2).e = 0;
      ((benf)localObject2).jdField_b_of_type_Int = 0;
      continue;
      label137:
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new benf(null);
        this.jdField_a_of_type_Benf = ((benf)localObject1);
      }
      if ((((benf)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != paramDrawable1) && (((benf)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)) {
        ((benf)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((benf)localObject1).jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable1;
      if ((((benf)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable != paramDrawable1) && (((benf)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)) {
        ((benf)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((benf)localObject1).jdField_b_of_type_AndroidGraphicsDrawableDrawable = paramDrawable2;
      localObject2 = ((benf)localObject1).jdField_a_of_type_AndroidGraphicsRect;
      int[] arrayOfInt = getDrawableState();
      if (paramDrawable1 != null)
      {
        paramDrawable1.setState(arrayOfInt);
        paramDrawable1.copyBounds((Rect)localObject2);
        paramDrawable1.setCallback(this);
        ((benf)localObject1).jdField_a_of_type_Int = ((Rect)localObject2).width();
        ((benf)localObject1).jdField_d_of_type_Int = ((Rect)localObject2).height();
      }
      for (;;)
      {
        if (paramDrawable2 == null) {
          break label341;
        }
        paramDrawable2.setState(arrayOfInt);
        paramDrawable2.copyBounds((Rect)localObject2);
        paramDrawable2.setCallback(this);
        ((benf)localObject1).jdField_b_of_type_Int = ((Rect)localObject2).width();
        ((benf)localObject1).e = ((Rect)localObject2).height();
        break;
        ((benf)localObject1).jdField_d_of_type_Int = 0;
        ((benf)localObject1).jdField_a_of_type_Int = 0;
      }
      label341:
      ((benf)localObject1).e = 0;
      ((benf)localObject1).jdField_b_of_type_Int = 0;
    }
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2)
  {
    Drawable localDrawable2 = null;
    if ((paramInt1 == 0) && (paramInt2 == 0) && (this.jdField_a_of_type_Benf != null) && ((this.jdField_a_of_type_Benf.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_Benf.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)))
    {
      this.jdField_c_of_type_Int = 0;
      this.jdField_d_of_type_Int = 0;
      setCompoundDrawablesWithIntrinsicBounds(null, null);
    }
    while ((this.jdField_c_of_type_Int == paramInt1) && (this.jdField_d_of_type_Int == paramInt2)) {
      return;
    }
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
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
  
  public void setDrawableRight2(Drawable paramDrawable)
  {
    Object localObject2 = this.jdField_a_of_type_Benf;
    if (paramDrawable == null) {
      if (localObject2 != null)
      {
        if (((benf)localObject2).jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) {
          ((benf)localObject2).jdField_c_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
        }
        ((benf)localObject2).jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
        ((benf)localObject2).f = 0;
        ((benf)localObject2).jdField_c_of_type_Int = 0;
      }
    }
    for (;;)
    {
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new benf(null);
        this.jdField_a_of_type_Benf = ((benf)localObject1);
      }
      if ((((benf)localObject1).jdField_c_of_type_AndroidGraphicsDrawableDrawable != paramDrawable) && (((benf)localObject1).jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)) {
        ((benf)localObject1).jdField_c_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
      }
      ((benf)localObject1).jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
      localObject2 = ((benf)localObject1).jdField_a_of_type_AndroidGraphicsRect;
      paramDrawable.setState(getDrawableState());
      paramDrawable.copyBounds((Rect)localObject2);
      paramDrawable.setCallback(this);
      ((benf)localObject1).jdField_c_of_type_Int = ((Rect)localObject2).width();
      ((benf)localObject1).f = ((Rect)localObject2).height();
    }
  }
  
  public void setDrawableRight2WithIntrinsicBounds(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      paramDrawable.setBounds(0, 0, paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight());
    }
    setDrawableRight2(paramDrawable);
  }
  
  public void setExtendText(String paramString, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfBeng.length)) {}
    beng localbeng2;
    boolean bool;
    do
    {
      return;
      localbeng2 = this.jdField_a_of_type_ArrayOfBeng[paramInt];
      bool = TextUtils.isEmpty(paramString);
    } while ((bool) && ((localbeng2 == null) || (localbeng2.jdField_a_of_type_Boolean)));
    int j;
    if ((bool) && (localbeng2 != null) && (!localbeng2.jdField_a_of_type_Boolean))
    {
      localbeng2.a();
      j = 1;
    }
    for (;;)
    {
      if ((paramInt == 0) && (j != 0)) {
        postInvalidate();
      }
      if ((j == 0) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1))) {
        break;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (!bool)
      {
        beng localbeng1 = localbeng2;
        if (localbeng2 == null)
        {
          localbeng1 = new beng(getResources());
          this.jdField_a_of_type_ArrayOfBeng[paramInt] = localbeng1;
        }
        if (!paramString.equals(localbeng1.jdField_a_of_type_JavaLangString))
        {
          localbeng1.jdField_a_of_type_JavaLangString = paramString;
          localbeng1.jdField_c_of_type_Int = -1;
          localbeng1.jdField_a_of_type_Boolean = false;
          j = 1;
          continue;
        }
      }
      j = 0;
    }
  }
  
  public void setExtendTextColor(ColorStateList paramColorStateList, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfBeng.length)) {}
    beng localbeng1;
    do
    {
      return;
      beng localbeng2 = this.jdField_a_of_type_ArrayOfBeng[paramInt];
      localbeng1 = localbeng2;
      if (localbeng2 == null)
      {
        localbeng1 = new beng(getResources());
        this.jdField_a_of_type_ArrayOfBeng[paramInt] = localbeng1;
      }
    } while (!localbeng1.a(paramColorStateList, getDrawableState()));
    postInvalidate();
  }
  
  public void setExtendTextPadding(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 >= this.jdField_a_of_type_ArrayOfBeng.length)) {}
    beng localbeng2;
    do
    {
      return;
      localbeng2 = this.jdField_a_of_type_ArrayOfBeng[paramInt2];
    } while ((paramInt1 <= 0) && ((localbeng2 == null) || (localbeng2.jdField_a_of_type_Boolean)));
    beng localbeng1 = localbeng2;
    if (localbeng2 == null)
    {
      localbeng1 = new beng(getResources());
      this.jdField_a_of_type_ArrayOfBeng[paramInt2] = localbeng1;
    }
    localbeng1.jdField_b_of_type_Int = paramInt1;
  }
  
  public void setExtendTextSize(float paramFloat, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfBeng.length)) {}
    beng localbeng1;
    do
    {
      return;
      beng localbeng2 = this.jdField_a_of_type_ArrayOfBeng[paramInt];
      localbeng1 = localbeng2;
      if (localbeng2 == null)
      {
        localbeng1 = new beng(getResources());
        this.jdField_a_of_type_ArrayOfBeng[paramInt] = localbeng1;
      }
    } while ((!localbeng1.a(paramFloat, getContext())) || (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void setGravity(int paramInt)
  {
    if ((paramInt & 0x7) == 0) {
      paramInt |= 0x3;
    }
    for (;;)
    {
      int j = paramInt;
      if ((paramInt & 0x70) == 0) {
        j = paramInt | 0x30;
      }
      paramInt = 0;
      if ((j & 0x7) != (this.f & 0x7)) {
        paramInt = 1;
      }
      if (j != this.f) {
        invalidate();
      }
      this.f = j;
      if ((this.jdField_a_of_type_AndroidTextLayout != null) && (paramInt != 0))
      {
        paramInt = this.jdField_a_of_type_AndroidTextLayout.getWidth();
        j = getWidth();
        int k = a();
        int m = b();
        a(paramInt, jdField_a_of_type_AndroidTextBoringLayout$Metrics, j - k - m);
      }
      return;
    }
  }
  
  public void setIconDrawablePadding(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.i) && (paramInt2 == this.h)) {}
    do
    {
      return;
      this.i = paramInt1;
      this.h = paramInt2;
    } while (this.jdField_a_of_type_AndroidOsHandler.hasMessages(1));
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
  
  public void setIconDrawables(Drawable[] paramArrayOfDrawable, boolean paramBoolean)
  {
    Object localObject2 = this.jdField_a_of_type_ArrayOfBenj;
    int j;
    if ((!paramBoolean) || (paramArrayOfDrawable == null) || (paramArrayOfDrawable.length == 0)) {
      if (localObject2 != null)
      {
        int k = localObject2.length;
        j = 0;
        while (j < k)
        {
          paramArrayOfDrawable = localObject2[j];
          if (paramArrayOfDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
            paramArrayOfDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
          }
          paramArrayOfDrawable.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
          paramArrayOfDrawable.jdField_a_of_type_Int = 0;
          paramArrayOfDrawable.jdField_b_of_type_Int = 0;
          paramArrayOfDrawable.jdField_a_of_type_Boolean = false;
          j += 1;
        }
      }
    }
    Object localObject1;
    for (this.jdField_a_of_type_ArrayOfBenj = null;; this.jdField_a_of_type_ArrayOfBenj = ((benj[])localObject1))
    {
      if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(1)) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
      return;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (localObject2.length == paramArrayOfDrawable.length) {}
      }
      else
      {
        localObject1 = new benj[paramArrayOfDrawable.length];
        j = 0;
        while (j < localObject1.length)
        {
          localObject1[j] = new benj(null);
          j += 1;
        }
      }
      localObject2 = getDrawableState();
      j = 0;
      if (j < localObject1.length)
      {
        if ((localObject1[j].jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (localObject1[j].jdField_a_of_type_AndroidGraphicsDrawableDrawable != paramArrayOfDrawable[j])) {
          localObject1[j].jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(null);
        }
        localObject1[j].jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramArrayOfDrawable[j];
        localObject1[j].jdField_a_of_type_Boolean = false;
        Rect localRect = localObject1[j].jdField_a_of_type_AndroidGraphicsRect;
        if (paramArrayOfDrawable[j] != null)
        {
          paramArrayOfDrawable[j].setState((int[])localObject2);
          paramArrayOfDrawable[j].copyBounds(localRect);
          paramArrayOfDrawable[j].setCallback(this);
          localObject1[j].jdField_a_of_type_Int = localRect.width();
          localObject1[j].jdField_b_of_type_Int = localRect.height();
        }
        for (;;)
        {
          j += 1;
          break;
          localRect = localObject1[j];
          localObject1[j].jdField_b_of_type_Int = 0;
          localRect.jdField_a_of_type_Int = 0;
        }
      }
    }
  }
  
  public void setIconDrawablesWithIntrinsicBounds(ArrayList<benk> paramArrayList)
  {
    int m = 0;
    if (paramArrayList != null) {}
    for (int k = paramArrayList.size();; k = 0)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {}
      for (int j = this.jdField_a_of_type_JavaUtilArrayList.size();; j = 0)
      {
        if (k == j)
        {
          if ((k <= 0) || (paramArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList == null)) {
            break label261;
          }
          j = 0;
          if (j >= k) {
            break label261;
          }
          if (!((benk)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a((benk)paramArrayList.get(j))) {
            j = 1;
          }
        }
        for (;;)
        {
          label81:
          Object localObject;
          boolean bool;
          if (j != 0)
          {
            localObject = null;
            if (k <= 0) {
              break label255;
            }
            localObject = new Drawable[k];
            j = 0;
            bool = false;
            for (;;)
            {
              if (j < k)
              {
                benk localbenk = (benk)paramArrayList.get(j);
                localObject[j] = a(getContext(), localbenk);
                if (localObject[j] == null) {
                  break label252;
                }
                bool = true;
                j += 1;
                continue;
                j += 1;
                break;
                j = 1;
                break label81;
              }
            }
          }
          for (;;)
          {
            this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
            setIconDrawables((Drawable[])localObject, bool);
            localObject = this.jdField_a_of_type_ArrayOfBenj;
            if ((localObject != null) && (paramArrayList != null))
            {
              j = m;
              while ((j < localObject.length) && (j < paramArrayList.size()))
              {
                if ((localObject[j] != null) && (paramArrayList.get(j) != null)) {
                  localObject[j].jdField_a_of_type_Boolean = ((benk)paramArrayList.get(j)).jdField_a_of_type_Boolean;
                }
                j += 1;
              }
            }
            this.jdField_c_of_type_Boolean = true;
            return;
            label252:
            break;
            label255:
            bool = false;
          }
          label261:
          j = 0;
        }
      }
    }
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
    int j = 0;
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
          int k = paramCharSequence.length();
          ((Spannable)paramCharSequence).setSpan(this.jdField_a_of_type_AndroidTextMethodTransformationMethod, 0, k, 18);
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
        paramCharSequence = (axkk[])paramCharSequence.getSpans(0, paramCharSequence.length(), axkk.class);
        if (j >= paramCharSequence.length) {
          break;
        }
        localObject = paramCharSequence[j].a();
        if (localObject != null) {
          ((Drawable)localObject).setCallback(this);
        }
        j += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.SingleLineTextView
 * JD-Core Version:    0.7.0.1
 */