package com.tencent.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import befo;
import bejx;

public class FastScroller
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842919 };
  private static final int[] jdField_b_of_type_ArrayOfInt = new int[0];
  private static final int[] jdField_c_of_type_ArrayOfInt = { 16843609, 16843574, 16843577, 16843575, 16843576, 16843578 };
  private static int jdField_d_of_type_Int = 4;
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  BaseAdapter jdField_a_of_type_AndroidWidgetBaseAdapter;
  private SectionIndexer jdField_a_of_type_AndroidWidgetSectionIndexer;
  AbsListView jdField_a_of_type_ComTencentWidgetAbsListView;
  private FastScroller.ScrollFade jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new FastScroller.1(this);
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  private Object[] jdField_a_of_type_ArrayOfJavaLangObject;
  int jdField_b_of_type_Int;
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_c_of_type_Boolean;
  private Drawable jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int;
  private Drawable jdField_e_of_type_AndroidGraphicsDrawableDrawable;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean;
  private int h = -1;
  private int i;
  private int j;
  private int k;
  private int l;
  
  public FastScroller(Context paramContext, AbsListView paramAbsListView)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView = paramAbsListView;
    a(paramContext);
  }
  
  private int a(int paramInt1, int paramInt2, int paramInt3)
  {
    int m = 0;
    if ((this.jdField_a_of_type_AndroidWidgetSectionIndexer == null) || (this.jdField_a_of_type_AndroidWidgetBaseAdapter == null)) {
      b();
    }
    if ((this.jdField_a_of_type_AndroidWidgetSectionIndexer == null) || (!this.jdField_g_of_type_Boolean)) {
      paramInt1 = (this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - this.jdField_a_of_type_Int) * paramInt1 / (paramInt3 - paramInt2);
    }
    int n;
    do
    {
      return paramInt1;
      n = paramInt1 - this.jdField_g_of_type_Int;
      paramInt1 = m;
    } while (n < 0);
    int i1 = this.jdField_g_of_type_Int;
    int i2 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - this.jdField_a_of_type_Int;
    paramInt1 = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getSectionForPosition(n);
    m = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(paramInt1);
    int i3 = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(paramInt1 + 1);
    int i4 = this.jdField_a_of_type_ArrayOfJavaLangObject.length;
    View localView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(0);
    if (localView == null) {}
    for (float f1 = 0.0F;; f1 = (this.jdField_a_of_type_ComTencentWidgetAbsListView.getPaddingTop() - localView.getTop()) / localView.getHeight() + f1)
    {
      m = (int)(((f1 - m) / (i3 - m) + paramInt1) / i4 * i2);
      paramInt1 = m;
      if (n <= 0) {
        break;
      }
      paramInt1 = m;
      if (n + paramInt2 != paramInt3 - i1) {
        break;
      }
      localView = this.jdField_a_of_type_ComTencentWidgetAbsListView.getChildAt(paramInt2 - 1);
      f1 = (this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - this.jdField_a_of_type_ComTencentWidgetAbsListView.getPaddingBottom() - localView.getTop()) / localView.getHeight();
      float f2 = m;
      return (int)((i2 - m) * f1 + f2);
      f1 = n;
    }
  }
  
  @TargetApi(11)
  private void a(Context paramContext)
  {
    boolean bool = true;
    int m = 0;
    TypedArray localTypedArray = paramContext.getTheme().obtainStyledAttributes(jdField_c_of_type_ArrayOfInt);
    for (;;)
    {
      try
      {
        a(paramContext, localTypedArray.getDrawable(1));
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = localTypedArray.getDrawable(2);
        this.jdField_d_of_type_AndroidGraphicsDrawableDrawable = localTypedArray.getDrawable(3);
        this.jdField_e_of_type_AndroidGraphicsDrawableDrawable = localTypedArray.getDrawable(4);
        this.k = localTypedArray.getInt(5, 0);
        this.jdField_a_of_type_Boolean = true;
        b();
        this.jdField_e_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131165795);
        this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
        this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade = new FastScroller.ScrollFade(this);
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
        this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_e_of_type_Int / 2);
        int n = localTypedArray.getColorStateList(0).getDefaultColor();
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(n);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        if ((this.jdField_a_of_type_ComTencentWidgetAbsListView.getWidth() > 0) && (this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() > 0)) {
          a(this.jdField_a_of_type_ComTencentWidgetAbsListView.getWidth(), this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight(), 0, 0);
        }
        this.i = 0;
        g();
        localTypedArray.recycle();
        this.l = ViewConfiguration.get(paramContext).getScaledTouchSlop();
        if (paramContext.getApplicationInfo().targetSdkVersion >= 11)
        {
          this.jdField_g_of_type_Boolean = bool;
          if (befo.e()) {
            m = this.jdField_a_of_type_ComTencentWidgetAbsListView.getVerticalScrollbarPosition();
          }
          a(m);
          return;
        }
      }
      finally
      {
        localTypedArray.recycle();
      }
      bool = false;
    }
  }
  
  private void a(Context paramContext, Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    if ((paramDrawable instanceof NinePatchDrawable)) {
      this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131165797);
    }
    for (this.jdField_a_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131165796);; this.jdField_a_of_type_Int = paramDrawable.getIntrinsicHeight())
    {
      this.jdField_e_of_type_Boolean = true;
      return;
      this.jdField_b_of_type_Int = paramDrawable.getIntrinsicWidth();
    }
  }
  
  private void g()
  {
    if (this.i == 3) {}
    for (int[] arrayOfInt = jdField_a_of_type_ArrayOfInt;; arrayOfInt = jdField_b_of_type_ArrayOfInt)
    {
      if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
      }
      if ((this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) && (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.isStateful())) {
        this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setState(arrayOfInt);
      }
      return;
    }
  }
  
  private void h()
  {
    int m = this.jdField_a_of_type_ComTencentWidgetAbsListView.getWidth();
    switch (this.j)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(208);
      return;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(m - this.jdField_b_of_type_Int, 0, m, this.jdField_a_of_type_Int);
      continue;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
    }
  }
  
  private void i()
  {
    MotionEvent localMotionEvent = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0);
    this.jdField_a_of_type_ComTencentWidgetAbsListView.onTouchEvent(localMotionEvent);
    localMotionEvent.recycle();
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  void a()
  {
    b(0);
  }
  
  void a(float paramFloat)
  {
    int i6 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getCount();
    this.jdField_a_of_type_Boolean = false;
    float f1 = 1.0F / i6 / 8.0F;
    Object[] arrayOfObject = this.jdField_a_of_type_ArrayOfJavaLangObject;
    int i7;
    int n;
    int m;
    int i1;
    int i4;
    if ((arrayOfObject != null) && (arrayOfObject.length > 1))
    {
      i7 = arrayOfObject.length;
      n = (int)(i7 * paramFloat);
      m = n;
      if (n >= i7) {
        m = i7 - 1;
      }
      i1 = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(m);
      i4 = m + 1;
      if (m >= i7 - 1) {
        break label622;
      }
    }
    label587:
    label590:
    label593:
    label622:
    for (int i3 = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(m + 1);; i3 = i6)
    {
      int i2;
      if (i3 == i1)
      {
        n = i1;
        i2 = m;
        if (i2 > 0)
        {
          i2 -= 1;
          n = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(i2);
          if (n != i1)
          {
            i1 = n;
            n = i2;
          }
        }
      }
      for (;;)
      {
        int i5 = i4 + 1;
        for (;;)
        {
          if ((i5 < i7) && (this.jdField_a_of_type_AndroidWidgetSectionIndexer.getPositionForSection(i5) == i3))
          {
            i5 += 1;
            i4 += 1;
            continue;
            if (i2 != 0) {
              break label593;
            }
            i5 = 0;
            i2 = m;
            i1 = n;
            n = i5;
            break;
          }
        }
        float f2 = i2 / i7;
        float f3 = i4 / i7;
        if ((i2 == m) && (paramFloat - f2 < f1))
        {
          m = i1;
          if (m <= i6 - 1) {
            break label590;
          }
          m = i6 - 1;
        }
        for (;;)
        {
          Object localObject;
          if ((this.jdField_a_of_type_ComTencentWidgetAbsListView instanceof ExpandableListView))
          {
            localObject = (ExpandableListView)this.jdField_a_of_type_ComTencentWidgetAbsListView;
            ((ExpandableListView)localObject).setSelectionFromTop(((ExpandableListView)localObject).a(ExpandableListView.b(m + this.jdField_g_of_type_Int)), 0);
          }
          boolean bool;
          for (;;)
          {
            if (n >= 0)
            {
              localObject = arrayOfObject[n].toString();
              this.jdField_a_of_type_JavaLangString = ((String)localObject);
              if (((((String)localObject).length() != 1) || (((String)localObject).charAt(0) != ' ')) && (n < arrayOfObject.length))
              {
                bool = true;
                label379:
                this.jdField_d_of_type_Boolean = bool;
                return;
                m = (int)((i3 - i1) * (paramFloat - f2) / (f3 - f2)) + i1;
                break;
                if ((this.jdField_a_of_type_ComTencentWidgetAbsListView instanceof ListView))
                {
                  ((ListView)this.jdField_a_of_type_ComTencentWidgetAbsListView).setSelectionFromTop(m + this.jdField_g_of_type_Int, 0);
                  continue;
                }
                this.jdField_a_of_type_ComTencentWidgetAbsListView.setSelection(m + this.jdField_g_of_type_Int);
                continue;
                m = (int)(i6 * paramFloat);
                if (m <= i6 - 1) {
                  break label587;
                }
                m = i6 - 1;
              }
            }
          }
          for (;;)
          {
            if ((this.jdField_a_of_type_ComTencentWidgetAbsListView instanceof ExpandableListView))
            {
              localObject = (ExpandableListView)this.jdField_a_of_type_ComTencentWidgetAbsListView;
              ((ExpandableListView)localObject).setSelectionFromTop(((ExpandableListView)localObject).a(ExpandableListView.b(m + this.jdField_g_of_type_Int)), 0);
            }
            for (;;)
            {
              n = -1;
              break;
              if ((this.jdField_a_of_type_ComTencentWidgetAbsListView instanceof ListView)) {
                ((ListView)this.jdField_a_of_type_ComTencentWidgetAbsListView).setSelectionFromTop(m + this.jdField_g_of_type_Int, 0);
              } else {
                this.jdField_a_of_type_ComTencentWidgetAbsListView.setSelection(m + this.jdField_g_of_type_Int);
              }
            }
            bool = false;
            break label379;
            this.jdField_d_of_type_Boolean = false;
            return;
          }
        }
        break;
        i1 = n;
        n = m;
        i2 = m;
        continue;
        i2 = m;
        n = m;
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.j = paramInt;
    switch (paramInt)
    {
    default: 
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_e_of_type_AndroidGraphicsDrawableDrawable;
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_d_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_f_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      switch (this.j)
      {
      default: 
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(paramInt1 - this.jdField_b_of_type_Int, 0, paramInt1, this.jdField_a_of_type_Int);
      }
    }
    for (;;)
    {
      if (this.k == 0)
      {
        RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
        localRectF.left = ((paramInt1 - this.jdField_e_of_type_Int) / 2);
        localRectF.right = (localRectF.left + this.jdField_e_of_type_Int);
        localRectF.top = (paramInt2 / 10);
        localRectF.bottom = (localRectF.top + this.jdField_e_of_type_Int);
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
        }
      }
      return;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
    }
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.i == 0) {}
    int i1;
    int i2;
    int m;
    do
    {
      return;
      i1 = this.jdField_c_of_type_Int;
      i2 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getWidth();
      Object localObject1 = this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade;
      m = -1;
      int n;
      if (this.i == 4)
      {
        n = ((FastScroller.ScrollFade)localObject1).a();
        if (n < 104) {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(n * 2);
        }
      }
      switch (this.j)
      {
      default: 
        m = 0;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(m, 0, this.jdField_b_of_type_Int + m, this.jdField_a_of_type_Int);
        this.jdField_e_of_type_Boolean = true;
        m = n;
        if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
        {
          localObject1 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds();
          int i4 = ((Rect)localObject1).left;
          n = (((Rect)localObject1).bottom - ((Rect)localObject1).top) / 2;
          int i3 = this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
          i4 = i4 + this.jdField_b_of_type_Int / 2 - i3 / 2;
          this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(i4, n, i3 + i4, this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - n);
          this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        }
        paramCanvas.translate(0.0F, i1);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        paramCanvas.translate(0.0F, -i1);
        if ((this.i != 3) || (!this.jdField_d_of_type_Boolean)) {
          continue;
        }
        if (this.k == 1) {
          switch (this.j)
          {
          }
        }
        break;
      }
      for (m = Math.max(0, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().left - this.jdField_b_of_type_Int - this.jdField_e_of_type_Int);; m = Math.min(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds().right + this.jdField_b_of_type_Int, this.jdField_a_of_type_ComTencentWidgetAbsListView.getWidth() - this.jdField_e_of_type_Int))
      {
        n = Math.max(0, Math.min((this.jdField_a_of_type_Int - this.jdField_e_of_type_Int) / 2 + i1, this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight() - this.jdField_e_of_type_Int));
        localObject1 = this.jdField_a_of_type_AndroidGraphicsRectF;
        ((RectF)localObject1).left = m;
        ((RectF)localObject1).right = (((RectF)localObject1).left + this.jdField_e_of_type_Int);
        ((RectF)localObject1).top = n;
        ((RectF)localObject1).bottom = (((RectF)localObject1).top + this.jdField_e_of_type_Int);
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds((int)((RectF)localObject1).left, (int)((RectF)localObject1).top, (int)((RectF)localObject1).right, (int)((RectF)localObject1).bottom);
        }
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        }
        localObject1 = this.jdField_a_of_type_AndroidGraphicsPaint;
        float f1 = ((Paint)localObject1).descent();
        RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
        Object localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
        if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
          this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getPadding((Rect)localObject2);
        }
        m = (((Rect)localObject2).right - ((Rect)localObject2).left) / 2;
        n = (((Rect)localObject2).bottom - ((Rect)localObject2).top) / 2;
        localObject2 = this.jdField_a_of_type_JavaLangString;
        float f2 = (int)(localRectF.left + localRectF.right) / 2 - m;
        float f3 = localRectF.bottom;
        paramCanvas.drawText((String)localObject2, f2, (int)(localRectF.top + f3) / 2 + this.jdField_e_of_type_Int / 4 - f1 - n, (Paint)localObject1);
        return;
        m = i2 - this.jdField_b_of_type_Int * n / 208;
        break;
        m = -this.jdField_b_of_type_Int + this.jdField_b_of_type_Int * n / 208;
        break;
      }
    } while (this.i != 4);
    if (m == 0)
    {
      b(0);
      return;
    }
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate(i2 - this.jdField_b_of_type_Int, 0, i2, this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight());
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate(i2 - this.jdField_b_of_type_Int, i1, i2, this.jdField_a_of_type_Int + i1);
  }
  
  void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if ((this.h != paramInt3) && (paramInt2 > 0))
    {
      this.h = paramInt3;
      if (this.h / paramInt2 >= jdField_d_of_type_Int)
      {
        bool = true;
        this.jdField_c_of_type_Boolean = bool;
      }
    }
    else
    {
      if (this.jdField_f_of_type_Boolean) {
        this.jdField_c_of_type_Boolean = true;
      }
      if (this.jdField_c_of_type_Boolean) {
        break label78;
      }
      if (this.i != 0) {
        b(0);
      }
    }
    label78:
    do
    {
      do
      {
        do
        {
          return;
          bool = false;
          break;
          if ((paramInt3 - paramInt2 > 0) && (this.i != 3))
          {
            this.jdField_c_of_type_Int = a(paramInt1, paramInt2, paramInt3);
            if (this.jdField_e_of_type_Boolean)
            {
              h();
              this.jdField_e_of_type_Boolean = false;
            }
          }
          this.jdField_a_of_type_Boolean = true;
        } while (paramInt1 == this.jdField_f_of_type_Int);
        this.jdField_f_of_type_Int = paramInt1;
      } while (this.i == 3);
      b(2);
    } while (this.jdField_f_of_type_Boolean);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade, 1500L);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade);
      b(2);
    }
    while (this.i != 2) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade, 1500L);
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  boolean a(float paramFloat1, float paramFloat2)
  {
    int m;
    switch (this.j)
    {
    default: 
      if (paramFloat1 > this.jdField_a_of_type_ComTencentWidgetAbsListView.getWidth() - this.jdField_b_of_type_Int) {
        m = 1;
      }
      break;
    }
    while ((m != 0) && ((this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) || ((paramFloat2 >= this.jdField_c_of_type_Int) && (paramFloat2 <= this.jdField_c_of_type_Int + this.jdField_a_of_type_Int))))
    {
      return true;
      m = 0;
      continue;
      if (paramFloat1 < this.jdField_b_of_type_Int) {
        m = 1;
      } else {
        m = 0;
      }
    }
    return false;
  }
  
  boolean a(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return false;
      if ((this.i > 0) && (a(paramMotionEvent.getX(), paramMotionEvent.getY())))
      {
        if (!this.jdField_a_of_type_ComTencentWidgetAbsListView.isInScrollingContainer())
        {
          f();
          return true;
        }
        this.jdField_a_of_type_Float = paramMotionEvent.getY();
        e();
        continue;
        d();
      }
    }
  }
  
  public int b()
  {
    return this.i;
  }
  
  void b()
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getAdapter();
    this.jdField_a_of_type_AndroidWidgetSectionIndexer = null;
    Object localObject1 = localObject2;
    if ((localObject2 instanceof bejx))
    {
      this.jdField_g_of_type_Int = ((bejx)localObject2).a();
      localObject1 = ((bejx)localObject2).getWrappedAdapter();
    }
    if ((localObject1 instanceof ExpandableListConnector))
    {
      localObject2 = ((ExpandableListConnector)localObject1).a();
      if ((localObject2 instanceof SectionIndexer))
      {
        this.jdField_a_of_type_AndroidWidgetSectionIndexer = ((SectionIndexer)localObject2);
        this.jdField_a_of_type_AndroidWidgetBaseAdapter = ((BaseAdapter)localObject1);
        this.jdField_a_of_type_ArrayOfJavaLangObject = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getSections();
      }
    }
    do
    {
      return;
      if (!(localObject1 instanceof SectionIndexer)) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetBaseAdapter = ((BaseAdapter)localObject1);
      this.jdField_a_of_type_AndroidWidgetSectionIndexer = ((SectionIndexer)localObject1);
      this.jdField_a_of_type_ArrayOfJavaLangObject = this.jdField_a_of_type_AndroidWidgetSectionIndexer.getSections();
    } while (this.jdField_a_of_type_ArrayOfJavaLangObject != null);
    this.jdField_a_of_type_ArrayOfJavaLangObject = new String[] { " " };
    return;
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = ((BaseAdapter)localObject1);
    this.jdField_a_of_type_ArrayOfJavaLangObject = new String[] { " " };
  }
  
  public void b(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.i = paramInt;
      g();
      return;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
      continue;
      if (this.i != 2) {
        h();
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade);
      continue;
      int m = this.jdField_a_of_type_ComTencentWidgetAbsListView.getWidth();
      this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate(m - this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, m, this.jdField_c_of_type_Int + this.jdField_a_of_type_Int);
    }
  }
  
  boolean b()
  {
    return this.i != 0;
  }
  
  boolean b(MotionEvent paramMotionEvent)
  {
    int m = 0;
    if (this.i == 0) {}
    int n;
    int i1;
    label221:
    do
    {
      do
      {
        return false;
        n = paramMotionEvent.getAction();
        if (n != 0) {
          break;
        }
      } while (!a(paramMotionEvent.getX(), paramMotionEvent.getY()));
      if (!this.jdField_a_of_type_ComTencentWidgetAbsListView.isInScrollingContainer())
      {
        f();
        return true;
      }
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      e();
      return false;
      if (n == 1)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          f();
          i1 = this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight();
          n = (int)paramMotionEvent.getY() - this.jdField_a_of_type_Int + 10;
          if (n >= 0) {
            break label221;
          }
          m = 0;
        }
        for (;;)
        {
          this.jdField_c_of_type_Int = m;
          a(this.jdField_c_of_type_Int / (i1 - this.jdField_a_of_type_Int));
          d();
          if (this.i != 3) {
            break;
          }
          if (this.jdField_a_of_type_ComTencentWidgetAbsListView != null)
          {
            this.jdField_a_of_type_ComTencentWidgetAbsListView.requestDisallowInterceptTouchEvent(false);
            this.jdField_a_of_type_ComTencentWidgetAbsListView.reportScrollStateChange(0);
            b(2);
          }
          paramMotionEvent = this.jdField_a_of_type_AndroidOsHandler;
          paramMotionEvent.removeCallbacks(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade);
          if (!this.jdField_f_of_type_Boolean) {
            paramMotionEvent.postDelayed(this.jdField_a_of_type_ComTencentWidgetFastScroller$ScrollFade, 1000L);
          }
          if (this.jdField_a_of_type_ComTencentWidgetAbsListView != null) {
            this.jdField_a_of_type_ComTencentWidgetAbsListView.invalidate();
          }
          return true;
          m = n;
          if (this.jdField_a_of_type_Int + n > i1) {
            m = i1 - this.jdField_a_of_type_Int;
          }
        }
      }
      if (n != 2) {
        break;
      }
      if ((this.jdField_b_of_type_Boolean) && (Math.abs(paramMotionEvent.getY() - this.jdField_a_of_type_Float) > this.l))
      {
        b(3);
        if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter == null) && (this.jdField_a_of_type_ComTencentWidgetAbsListView != null)) {
          b();
        }
        if (this.jdField_a_of_type_ComTencentWidgetAbsListView != null)
        {
          this.jdField_a_of_type_ComTencentWidgetAbsListView.requestDisallowInterceptTouchEvent(true);
          this.jdField_a_of_type_ComTencentWidgetAbsListView.reportScrollStateChange(1);
          i();
          d();
        }
      }
    } while (this.i != 3);
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView != null)
    {
      n = this.jdField_a_of_type_ComTencentWidgetAbsListView.getHeight();
      label355:
      i1 = (int)paramMotionEvent.getY() - this.jdField_a_of_type_Int + 10;
      if (i1 >= 0) {
        break label395;
      }
    }
    for (;;)
    {
      if (Math.abs(this.jdField_c_of_type_Int - m) < 2)
      {
        return true;
        n = 0;
        break label355;
        label395:
        if (this.jdField_a_of_type_Int + i1 <= n) {
          break label458;
        }
        m = n - this.jdField_a_of_type_Int;
        continue;
      }
      this.jdField_c_of_type_Int = m;
      if (this.jdField_a_of_type_Boolean) {
        a(this.jdField_c_of_type_Int / (n - this.jdField_a_of_type_Int));
      }
      return true;
      if (n != 3) {
        break;
      }
      d();
      return false;
      label458:
      m = i1;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetBaseAdapter = null;
  }
  
  void d()
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_b_of_type_Boolean = false;
  }
  
  void e()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentWidgetAbsListView.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 180L);
  }
  
  void f()
  {
    b(3);
    if ((this.jdField_a_of_type_AndroidWidgetBaseAdapter == null) && (this.jdField_a_of_type_ComTencentWidgetAbsListView != null)) {
      b();
    }
    if (this.jdField_a_of_type_ComTencentWidgetAbsListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetAbsListView.requestDisallowInterceptTouchEvent(true);
      this.jdField_a_of_type_ComTencentWidgetAbsListView.reportScrollStateChange(1);
      i();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.widget.FastScroller
 * JD-Core Version:    0.7.0.1
 */