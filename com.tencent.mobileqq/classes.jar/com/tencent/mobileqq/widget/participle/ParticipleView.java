package com.tencent.mobileqq.widget.participle;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParticipleView
  extends View
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#00CAFC");
  private static final int jdField_b_of_type_Int = Color.parseColor("#FFFFFF");
  private static final int jdField_c_of_type_Int = Color.parseColor("#FFFFFF");
  private static final int jdField_d_of_type_Int = Color.parseColor("#03081A");
  private byte jdField_a_of_type_Byte = 0;
  private float jdField_a_of_type_Float = 0.0F;
  private long jdField_a_of_type_Long;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point(0, 0);
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private ParticipleView.OnParticipleSelectChangeListener jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$OnParticipleSelectChangeListener;
  private ParticipleView.ParticipleEntity jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleEntity;
  private ParticipleView.ParticipleExploreByTouchHelper jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleExploreByTouchHelper;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private List<ParticipleView.ParticipleEntity> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private RectF jdField_b_of_type_AndroidGraphicsRectF;
  private final List<ParticipleView.ParticipleEntity> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  private float jdField_c_of_type_Float;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q = 0;
  private int r;
  private int s = 0;
  private int t = 0;
  private int u;
  
  public ParticipleView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public ParticipleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public ParticipleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private int a()
  {
    a(null);
    return this.q;
  }
  
  private int a(float paramFloat1, float paramFloat2)
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i1 = 0;
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      while (i1 < i2)
      {
        localObject = ParticipleView.ParticipleEntity.a((ParticipleView.ParticipleEntity)this.jdField_a_of_type_JavaUtilList.get(i1)).iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((RectF)((Iterator)localObject).next()).contains(paramFloat1, paramFloat2)) {
            return i1;
          }
        }
        i1 += 1;
      }
    }
    return -1;
  }
  
  private int a(QQText paramQQText)
  {
    int i6 = paramQQText.mSpanCount;
    String str = paramQQText.toString();
    if (i6 > 0)
    {
      paramQQText = paramQQText.getSpanData();
      int i3 = 0;
      int i2 = 0;
      int i1 = 0;
      int i4 = 0;
      while (i3 < i6)
      {
        if (i2 > 0) {
          i4 = i2;
        }
        i2 = i3 * 3;
        int i7 = paramQQText[i2];
        int i5 = paramQQText[(i2 + 1)];
        i2 = i1;
        if (i7 > i4) {
          i2 = (int)(i1 + this.jdField_a_of_type_AndroidGraphicsPaint.measureText(str.substring(i4, i7)));
        }
        i1 = i2 + this.e;
        i3 += 1;
        i2 = i5;
      }
      i3 = i1;
      if (i2 < str.length()) {
        i3 = (int)(i1 + this.jdField_a_of_type_AndroidGraphicsPaint.measureText(str.substring(i2)));
      }
      return i3;
    }
    return (int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(str);
  }
  
  private void a(int paramInt1, int paramInt2, QQText paramQQText, ParticipleView.ParticipleEntity paramParticipleEntity, Canvas paramCanvas)
  {
    int i2 = a(paramQQText);
    int i1;
    if (getWidth() <= 0) {
      i1 = this.r;
    } else {
      i1 = getWidth();
    }
    int i3 = i2 + paramInt1;
    if (this.g * 2 + i3 + getPaddingRight() > i1)
    {
      if (getPaddingLeft() + getPaddingRight() + i2 + this.g * 2 <= i1) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if (i1 != 0)
      {
        c(getPaddingLeft(), this.e + paramInt2 + this.h + this.f * 2, paramQQText, paramParticipleEntity, paramCanvas);
        this.jdField_a_of_type_AndroidGraphicsPoint.x = (getPaddingLeft() + i2 + this.g * 2 + this.i);
        this.jdField_a_of_type_AndroidGraphicsPoint.y = (paramInt2 + this.e + this.h + this.f * 2);
        return;
      }
      b(paramInt1, paramInt2, paramQQText, paramParticipleEntity, paramCanvas);
      return;
    }
    c(paramInt1, paramInt2, paramQQText, paramParticipleEntity, paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPoint.x = (i3 + this.i + this.g * 2);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.jdField_aA_of_type_ArrayOfInt);
      this.k = paramAttributeSet.getColor(R.styleable.aC, jdField_a_of_type_Int);
      this.l = paramAttributeSet.getColor(R.styleable.aD, jdField_b_of_type_Int);
      this.j = paramAttributeSet.getDimensionPixelSize(R.styleable.aw, DisplayUtil.a(getContext(), 3.0F));
      this.m = paramAttributeSet.getColor(R.styleable.ax, jdField_c_of_type_Int);
      this.n = paramAttributeSet.getColor(R.styleable.aB, jdField_d_of_type_Int);
      this.e = paramAttributeSet.getDimensionPixelSize(R.styleable.az, DisplayUtil.a(getContext(), 27.0F));
      this.f = paramAttributeSet.getDimensionPixelSize(R.styleable.jdField_aA_of_type_Int, DisplayUtil.a(getContext(), 4.0F));
      this.g = paramAttributeSet.getDimensionPixelSize(R.styleable.ay, DisplayUtil.a(getContext(), 6.0F));
      this.h = paramAttributeSet.getDimensionPixelSize(R.styleable.aE, DisplayUtil.a(getContext(), 12.0F));
      this.i = paramAttributeSet.getDimensionPixelSize(R.styleable.av, DisplayUtil.a(getContext(), 8.0F));
      this.o = paramAttributeSet.getInteger(R.styleable.at, 200);
      this.p = paramAttributeSet.getInteger(R.styleable.au, 200);
      paramAttributeSet.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.e);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.l);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.k);
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleExploreByTouchHelper = new ParticipleView.ParticipleExploreByTouchHelper(this, null);
    ViewCompat.setAccessibilityDelegate(this, this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleExploreByTouchHelper);
    this.u = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint.x = getPaddingLeft();
    this.jdField_a_of_type_AndroidGraphicsPoint.y = getPaddingTop();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i1 = 0;
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      while (i1 < i2)
      {
        localObject = (ParticipleView.ParticipleEntity)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((paramCanvas == null) || (a((ParticipleView.ParticipleEntity)localObject))) {
          a(paramCanvas, (ParticipleView.ParticipleEntity)localObject);
        }
        i1 += 1;
      }
    }
  }
  
  private void a(Canvas paramCanvas, ParticipleView.ParticipleEntity paramParticipleEntity)
  {
    if (ParticipleView.ParticipleEntity.a(paramParticipleEntity).isEmpty())
    {
      a(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y, paramParticipleEntity.a, paramParticipleEntity, paramCanvas);
      return;
    }
    int i1 = 0;
    int i2 = ParticipleView.ParticipleEntity.a(paramParticipleEntity).size();
    while (i1 < i2)
    {
      RectF localRectF = (RectF)ParticipleView.ParticipleEntity.a(paramParticipleEntity).get(i1);
      a(localRectF, (QQText)ParticipleView.ParticipleEntity.b(paramParticipleEntity).get(i1), paramParticipleEntity, paramCanvas);
      this.jdField_a_of_type_AndroidGraphicsPoint.x = ((int)localRectF.right + this.i);
      this.jdField_a_of_type_AndroidGraphicsPoint.y = ((int)localRectF.top);
      i1 += 1;
    }
  }
  
  private void a(RectF paramRectF1, RectF paramRectF2)
  {
    if ((paramRectF1 != null) && (paramRectF2 != null))
    {
      if (paramRectF1 == paramRectF2) {
        return;
      }
      Object localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        boolean bool2 = a(paramRectF1, paramRectF2);
        boolean bool1 = true;
        RectF localRectF1;
        int i1;
        if (bool2)
        {
          localObject = paramRectF1;
          localRectF1 = paramRectF2;
          i1 = 2;
        }
        else
        {
          localRectF1 = paramRectF1;
          localObject = paramRectF2;
          i1 = 1;
        }
        RectF localRectF2;
        if ((a((RectF)localObject, this.jdField_b_of_type_AndroidGraphicsRectF)) && (a(this.jdField_b_of_type_AndroidGraphicsRectF, localRectF1)))
        {
          if (i1 == 2)
          {
            localRectF2 = this.jdField_b_of_type_AndroidGraphicsRectF;
            paramRectF1 = (RectF)localObject;
            localObject = localRectF2;
          }
          else
          {
            paramRectF1 = this.jdField_b_of_type_AndroidGraphicsRectF;
            localRectF2 = localRectF1;
            localRectF1 = paramRectF1;
          }
          this.jdField_a_of_type_Boolean = ParticipleView.ParticipleEntity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleEntity);
        }
        else
        {
          if (paramRectF1.equals(this.jdField_b_of_type_AndroidGraphicsRectF))
          {
            this.jdField_a_of_type_Boolean = ParticipleView.ParticipleEntity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleEntity);
          }
          else
          {
            int i2 = this.t;
            if ((i2 != 0) && (i2 != i1)) {
              this.jdField_a_of_type_Boolean ^= true;
            }
          }
          paramRectF1 = null;
          localRectF2 = paramRectF1;
        }
        this.t = i1;
        if (paramRectF2.equals(this.jdField_b_of_type_AndroidGraphicsRectF))
        {
          if (i1 == 1) {
            bool1 = false;
          }
        }
        else {
          bool1 = a(this.jdField_b_of_type_AndroidGraphicsRectF, paramRectF2) ^ true;
        }
        a(paramRectF1, localRectF2, (RectF)localObject, localRectF1, bool1);
      }
    }
  }
  
  private void a(RectF paramRectF1, RectF paramRectF2, RectF paramRectF3, RectF paramRectF4, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    int i2 = this.jdField_a_of_type_JavaUtilList.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ParticipleView.ParticipleEntity localParticipleEntity = (ParticipleView.ParticipleEntity)this.jdField_a_of_type_JavaUtilList.get(i1);
      Iterator localIterator = ParticipleView.ParticipleEntity.a(localParticipleEntity).iterator();
      while (localIterator.hasNext())
      {
        RectF localRectF = (RectF)localIterator.next();
        if ((paramRectF1 != null) && (paramRectF2 != null) && (!localRectF.equals(paramRectF3)) && (!localRectF.equals(paramRectF4)) && (((a(paramRectF1, localRectF)) && (a(localRectF, paramRectF2))) || (localRectF.equals(paramRectF2)) || (localRectF.equals(paramRectF1))))
        {
          if (this.jdField_c_of_type_Boolean)
          {
            if (ParticipleView.ParticipleEntity.a(localParticipleEntity)) {
              ParticipleView.ParticipleEntity.a(localParticipleEntity, false);
            }
          }
          else {
            ParticipleView.ParticipleEntity.a(localParticipleEntity, this.jdField_a_of_type_Boolean ^ true);
          }
        }
        else if (((paramRectF3.top < localRectF.top) || ((paramRectF3.top == localRectF.top) && (paramBoolean ? paramRectF3.left <= localRectF.left : paramRectF3.left < localRectF.left))) && ((localRectF.top < paramRectF4.top) || ((localRectF.top == paramRectF4.top) && (paramBoolean ? localRectF.left < paramRectF4.left : localRectF.left <= paramRectF4.left)))) {
          if (this.jdField_c_of_type_Boolean)
          {
            if (ParticipleView.ParticipleEntity.a(localParticipleEntity)) {
              ParticipleView.ParticipleEntity.a(localParticipleEntity, false);
            }
          }
          else if (this.jdField_a_of_type_Boolean)
          {
            if (!ParticipleView.ParticipleEntity.a(localParticipleEntity))
            {
              ParticipleView.ParticipleEntity.a(localParticipleEntity, true);
              ParticipleView.ParticipleEntity.a(localParticipleEntity, System.currentTimeMillis());
              localArrayList.add(localParticipleEntity);
            }
          }
          else if (ParticipleView.ParticipleEntity.a(localParticipleEntity)) {
            ParticipleView.ParticipleEntity.a(localParticipleEntity, false);
          }
        }
      }
      i1 += 1;
    }
    a(localArrayList);
    paramRectF1 = this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$OnParticipleSelectChangeListener;
    if (paramRectF1 != null) {
      paramRectF1.a();
    }
  }
  
  private void a(RectF paramRectF, QQText paramQQText, ParticipleView.ParticipleEntity paramParticipleEntity, Canvas paramCanvas)
  {
    int i2 = (int)paramRectF.bottom;
    int i3 = (int)paramRectF.left;
    int i4 = (int)paramRectF.top;
    int i1 = (int)paramRectF.right;
    if (paramCanvas != null)
    {
      i1 = i1 - i3 - this.g * 2;
      float f1;
      float f2;
      if (ParticipleView.ParticipleEntity.a(paramParticipleEntity))
      {
        if (ParticipleView.ParticipleEntity.a(paramParticipleEntity) >= 0.0F) {
          f1 = ParticipleView.ParticipleEntity.a(paramParticipleEntity);
        } else {
          f1 = 0.0F;
        }
        f2 = 1.0F;
      }
      else
      {
        f2 = this.jdField_a_of_type_Float;
        if (f2 >= 0.0F)
        {
          f1 = 0.0F;
        }
        else
        {
          f1 = 0.0F;
          f2 = 0.0F;
        }
      }
      int i5;
      if (f1 < 1.0F)
      {
        float f3 = i3;
        i5 = (int)((this.g * 2 + i1) * f2 + f3);
        paramRectF = new RectF(f3, i4, i5, i2);
        i5 = this.j;
        paramCanvas.drawRoundRect(paramRectF, i5, i5, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      if (f1 > 0.0F) {
        if (this.s == 4)
        {
          f2 = i3;
          i1 = (int)((i1 + this.g * 2) * f1 + f2);
          paramRectF = new RectF(f2, i4, i1, i2);
          i1 = this.j;
          paramCanvas.drawRoundRect(paramRectF, i1, i1, this.jdField_c_of_type_AndroidGraphicsPaint);
        }
        else
        {
          f2 = i3;
          i5 = this.g;
          paramRectF = new RectF((int)(f2 + (i5 * 2 + i1) * (1.0F - f1)), i4, i1 + i3 + i5 * 2, i2);
          i1 = this.j;
          paramCanvas.drawRoundRect(paramRectF, i1, i1, this.jdField_c_of_type_AndroidGraphicsPaint);
        }
      }
      paramRectF = this.jdField_a_of_type_AndroidGraphicsPaint;
      if (ParticipleView.ParticipleEntity.a(paramParticipleEntity)) {
        i1 = this.m;
      } else {
        i1 = this.n;
      }
      paramRectF.setColor(i1);
      a(paramQQText, paramCanvas, i3 + this.g, i4);
    }
    this.q = i2;
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i2 = (int)paramMotionEvent.getX();
    int i3 = (int)paramMotionEvent.getY();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i1 = 0;
      int i4 = this.jdField_a_of_type_JavaUtilList.size();
      while (i1 < i4)
      {
        ParticipleView.ParticipleEntity localParticipleEntity = (ParticipleView.ParticipleEntity)this.jdField_a_of_type_JavaUtilList.get(i1);
        Iterator localIterator = ParticipleView.ParticipleEntity.a(localParticipleEntity).iterator();
        while (localIterator.hasNext())
        {
          RectF localRectF = (RectF)localIterator.next();
          localObject = null;
          if (localRectF.contains(i2, i3)) {
            localObject = localRectF;
          }
          if (localObject != null) {
            if (paramMotionEvent.getAction() == 0)
            {
              this.jdField_a_of_type_AndroidGraphicsRectF = localRectF;
              this.jdField_b_of_type_AndroidGraphicsRectF = localRectF;
              this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleEntity = localParticipleEntity;
            }
            else if (paramMotionEvent.getAction() == 2)
            {
              if (this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleEntity == null)
              {
                this.jdField_a_of_type_AndroidGraphicsRectF = localRectF;
                this.jdField_b_of_type_AndroidGraphicsRectF = localRectF;
                this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleEntity = localParticipleEntity;
                f();
              }
              else if (!((RectF)localObject).equals(this.jdField_a_of_type_AndroidGraphicsRectF))
              {
                a(this.jdField_a_of_type_AndroidGraphicsRectF, (RectF)localObject);
                this.jdField_a_of_type_AndroidGraphicsRectF = ((RectF)localObject);
              }
            }
          }
        }
        i1 += 1;
      }
    }
  }
  
  private void a(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentWidgetScrollView != null) {
      return;
    }
    if (paramView != null)
    {
      paramView = (View)paramView.getParent();
      if ((paramView instanceof ScrollView))
      {
        this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)paramView);
        return;
      }
      a(paramView);
    }
  }
  
  private void a(QQText paramQQText, Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    String str = paramQQText.toString();
    if (paramQQText.mSpanCount > 0)
    {
      int[] arrayOfInt = paramQQText.getSpanData();
      Object[] arrayOfObject = paramQQText.mSpans;
      int i2 = 0;
      int i1 = 0;
      int i3 = 0;
      while (i2 < paramQQText.mSpanCount)
      {
        if (i1 > 0) {
          i3 = i1;
        }
        i1 = i2 * 3;
        int i5 = arrayOfInt[i1];
        int i4 = arrayOfInt[(i1 + 1)];
        i1 = paramInt1;
        if (i5 > i3)
        {
          localObject = str.substring(i3, i5);
          float f1 = paramInt1;
          paramCanvas.drawText((String)localObject, f1, this.e + paramInt2, this.jdField_a_of_type_AndroidGraphicsPaint);
          i1 = (int)(f1 + this.jdField_a_of_type_AndroidGraphicsPaint.measureText((String)localObject));
        }
        Object localObject = arrayOfObject[i2];
        paramInt1 = i1;
        if ((localObject instanceof EmoticonSpan))
        {
          localObject = ((EmoticonSpan)localObject).getDrawable();
          paramInt1 = i1;
          if (localObject != null)
          {
            paramInt1 = this.f;
            i5 = this.e;
            ((Drawable)localObject).setBounds(i1, paramInt2 + paramInt1, i1 + i5, paramInt1 + paramInt2 + i5);
            ((Drawable)localObject).draw(paramCanvas);
            paramInt1 = i1 + this.e;
          }
        }
        i2 += 1;
        i1 = i4;
      }
      if (i1 < str.length()) {
        paramCanvas.drawText(str.substring(i1), paramInt1, paramInt2 + this.e, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    else
    {
      paramCanvas.drawText(str, paramInt1, paramInt2 + this.e, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void a(ParticipleView.ParticipleEntity paramParticipleEntity)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramParticipleEntity);
    b(localArrayList);
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new QQText(paramString, 3);
      this.jdField_a_of_type_JavaUtilList.add(new ParticipleView.ParticipleEntity(paramString, null));
    }
  }
  
  private void a(List<ParticipleView.ParticipleEntity> paramList)
  {
    if (paramList.size() > 0)
    {
      b(paramList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleView", 2, "doAnimationAfterSelectAmong invalidate()");
    }
    invalidate();
  }
  
  private boolean a(RectF paramRectF1, RectF paramRectF2)
  {
    return (paramRectF1.top < paramRectF2.top) || ((paramRectF1.top == paramRectF2.top) && (paramRectF1.left < paramRectF2.left));
  }
  
  private boolean a(ParticipleView.ParticipleEntity paramParticipleEntity)
  {
    if ((this.jdField_b_of_type_Boolean) && (!ParticipleView.ParticipleEntity.a(paramParticipleEntity).isEmpty()))
    {
      a(this);
      if (this.jdField_a_of_type_ComTencentWidgetScrollView != null)
      {
        paramParticipleEntity = ParticipleView.ParticipleEntity.a(paramParticipleEntity).iterator();
        int i1;
        do
        {
          boolean bool = paramParticipleEntity.hasNext();
          int i2 = 0;
          if (!bool) {
            break;
          }
          int i3 = (int)((RectF)paramParticipleEntity.next()).top;
          i1 = i2;
          if (this.e + i3 + this.f * 2 - this.jdField_a_of_type_ComTencentWidgetScrollView.getScrollY() > 0)
          {
            i1 = i2;
            if (i3 - this.jdField_a_of_type_ComTencentWidgetScrollView.getScrollY() < this.jdField_a_of_type_ComTencentWidgetScrollView.getHeight()) {
              i1 = 1;
            }
          }
        } while (i1 == 0);
        return true;
        return false;
      }
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    int i1 = 0;
    while (i1 < paramString.length())
    {
      int i2 = paramString.charAt(i1);
      if ((19968 <= i2) && (i2 < 40869)) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private void b(int paramInt1, int paramInt2, QQText paramQQText, ParticipleView.ParticipleEntity paramParticipleEntity, Canvas paramCanvas)
  {
    int i3;
    if (getWidth() <= 0) {
      i3 = this.r;
    } else {
      i3 = getWidth();
    }
    int i9 = paramQQText.mSpanCount;
    int[] arrayOfInt = paramQQText.getSpanData();
    int i2;
    if (i9 > 0)
    {
      i1 = arrayOfInt[0];
      i2 = arrayOfInt[1];
    }
    else
    {
      i1 = 0;
      i2 = 0;
    }
    String str2 = paramQQText.toString();
    int i10 = str2.length();
    int i6 = 0;
    int i4 = i1;
    int i5 = 0;
    for (int i1 = i6; i1 < i10; i1 = i6 + 1)
    {
      Object localObject;
      if ((i9 > 0) && (i5 < i9) && (i4 == i1))
      {
        String str1 = str2.substring(0, i2);
        int i7 = i2 - 1;
        int i8 = i5 + 1;
        i5 = i8;
        localObject = str1;
        i6 = i7;
        if (i8 < i9)
        {
          i2 = i8 * 3;
          i4 = arrayOfInt[i2];
          i2 = arrayOfInt[(i2 + 1)];
          i5 = i8;
          localObject = str1;
          i6 = i7;
        }
      }
      else
      {
        localObject = str2.substring(0, i1 + 1);
        i6 = i1;
      }
      if (a(new QQText((CharSequence)localObject, 3)) + paramInt1 + this.g * 2 + getPaddingRight() > i3)
      {
        this.jdField_a_of_type_AndroidGraphicsPoint.x = getPaddingLeft();
        localObject = this.jdField_a_of_type_AndroidGraphicsPoint;
        ((Point)localObject).y = (paramInt2 + this.e + this.h + this.f * 2);
        if (i1 <= 0)
        {
          a(((Point)localObject).x, this.jdField_a_of_type_AndroidGraphicsPoint.y, paramQQText, paramParticipleEntity, paramCanvas);
        }
        else
        {
          c(paramInt1, paramInt2, new QQText(str2.substring(0, i1), 3), paramParticipleEntity, paramCanvas);
          localObject = str2.substring(i1, i10);
          a(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y, new QQText((CharSequence)localObject, 3), paramParticipleEntity, paramCanvas);
        }
        i1 = 1;
        break label396;
      }
    }
    i1 = 0;
    label396:
    if (i1 == 0) {
      a(paramInt1, paramInt2, paramQQText, paramParticipleEntity, paramCanvas);
    }
  }
  
  private void b(List<ParticipleView.ParticipleEntity> paramList)
  {
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleView", 2, "selectedAnimation create");
      }
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.p);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new ParticipleView.1(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  private void c()
  {
    ReportController.b(null, "dc00898", "", "", "0X800A359", "0X800A359", 0, 0, "", "", "", "");
  }
  
  private void c(int paramInt1, int paramInt2, QQText paramQQText, ParticipleView.ParticipleEntity paramParticipleEntity, Canvas paramCanvas)
  {
    int i1 = this.e;
    int i2 = this.f;
    int i3 = a(paramQQText);
    int i4 = this.g;
    RectF localRectF = new RectF(paramInt1, paramInt2, i3 + i4 * 2 + paramInt1, i1 + paramInt2 + i2 * 2);
    ParticipleView.ParticipleEntity.a(paramParticipleEntity, localRectF, paramQQText);
    a(localRectF, paramQQText, paramParticipleEntity, paramCanvas);
  }
  
  private void d()
  {
    f();
    ParticipleView.ParticipleEntity localParticipleEntity = this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleEntity;
    if ((localParticipleEntity != null) && (ParticipleView.ParticipleEntity.a(localParticipleEntity))) {
      ReportController.b(null, "dc00898", "", "", "0X800A358", "0X800A358", 0, 0, "", "", "", "");
    }
  }
  
  private void e()
  {
    f();
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleEntity;
    if (localObject != null)
    {
      this.jdField_c_of_type_Boolean = ParticipleView.ParticipleEntity.a((ParticipleView.ParticipleEntity)localObject);
      if (ParticipleView.ParticipleEntity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleEntity))
      {
        ParticipleView.ParticipleEntity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleEntity, false);
        this.jdField_a_of_type_Boolean = false;
        invalidate();
      }
      else
      {
        ParticipleView.ParticipleEntity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleEntity, true);
        this.jdField_a_of_type_Boolean = true;
        ParticipleView.ParticipleEntity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleEntity, System.currentTimeMillis());
        a(this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleEntity);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$OnParticipleSelectChangeListener;
      if (localObject != null) {
        ((ParticipleView.OnParticipleSelectChangeListener)localObject).a();
      }
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i1 = 0;
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      while (i1 < i2)
      {
        localObject = (ParticipleView.ParticipleEntity)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (ParticipleView.ParticipleEntity.a((ParticipleView.ParticipleEntity)localObject))
        {
          localObject = ((ParticipleView.ParticipleEntity)localObject).a.toString();
          boolean bool1 = a((String)localObject);
          if (localStringBuilder.length() > 0)
          {
            boolean bool2 = this.jdField_d_of_type_Boolean;
            if ((bool2 != bool1) || (!bool2)) {
              localStringBuilder.append(" ");
            }
          }
          this.jdField_d_of_type_Boolean = a((String)localObject);
          localStringBuilder.append((String)localObject);
        }
        i1 += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleView", 2, "translateAppearAnimation invalidate()");
    }
    setAlpha(0.0F);
    setVisibility(0);
    this.jdField_a_of_type_Float = 0.0F;
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(this.o);
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new ParticipleView.2(this));
    localValueAnimator.setDuration(this.p);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.addListener(new ParticipleView.3(this));
    localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator, localValueAnimator });
    localAnimatorSet.start();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleView", 2, "resetState invalidate()");
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        ParticipleView.ParticipleEntity.a((ParticipleView.ParticipleEntity)this.jdField_a_of_type_JavaUtilList.get(i1), false);
        a(this);
        localObject = this.jdField_a_of_type_ComTencentWidgetScrollView;
        if (localObject != null) {
          ((ScrollView)localObject).scrollTo(0, 0);
        }
        i1 += 1;
      }
    }
    invalidate();
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if (AppSetting.jdField_d_of_type_Boolean)
    {
      ParticipleView.ParticipleExploreByTouchHelper localParticipleExploreByTouchHelper = this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleExploreByTouchHelper;
      if ((localParticipleExploreByTouchHelper != null) && (localParticipleExploreByTouchHelper.dispatchHoverEvent(paramMotionEvent))) {
        return true;
      }
    }
    return super.dispatchHoverEvent(paramMotionEvent);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = getDefaultSize(getSuggestedMinimumWidth(), paramInt1);
    this.r = i2;
    int i1 = getDefaultSize(getSuggestedMinimumHeight(), paramInt2);
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824) {
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
    } else {
      paramInt1 = a();
    }
    if (paramInt1 <= 0) {
      paramInt1 = i1;
    }
    setMeasuredDimension(i2, paramInt1);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = paramMotionEvent.getAction();
    boolean bool = false;
    Object localObject;
    if (i2 != 0)
    {
      if (i2 != 1)
      {
        int i1 = 3;
        if (i2 != 2)
        {
          if (i2 != 3) {
            break label301;
          }
        }
        else
        {
          float f1 = (int)paramMotionEvent.getX();
          float f3 = (int)paramMotionEvent.getY();
          if (this.jdField_a_of_type_Byte == 0)
          {
            float f2 = Math.abs(f1 - this.jdField_b_of_type_Float);
            f3 = Math.abs(f3 - this.jdField_c_of_type_Float);
            i2 = this.u;
            if ((f2 > i2) || (f3 > i2)) {
              if (f3 > f2)
              {
                this.jdField_a_of_type_Byte = 2;
              }
              else
              {
                this.jdField_a_of_type_Byte = 1;
                c();
                f();
                if (f1 - this.jdField_b_of_type_Float > 0.0F) {
                  i1 = 4;
                }
                this.s = i1;
              }
            }
          }
          if (this.jdField_a_of_type_Byte == 0) {
            return true;
          }
          this.jdField_b_of_type_Boolean = true;
          localObject = getParent();
          if (this.jdField_a_of_type_Byte == 1) {
            bool = true;
          }
          ((ViewParent)localObject).requestDisallowInterceptTouchEvent(bool);
          if (this.jdField_a_of_type_Byte != 1) {
            break label301;
          }
          a(paramMotionEvent);
          return true;
        }
      }
      else if (!this.jdField_b_of_type_Boolean)
      {
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 500L) {
          e();
        } else {
          d();
        }
      }
      getParent().requestDisallowInterceptTouchEvent(false);
      this.jdField_a_of_type_Byte = 0;
      this.jdField_a_of_type_AndroidGraphicsRectF = null;
      this.jdField_b_of_type_AndroidGraphicsRectF = null;
      this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$ParticipleEntity = null;
      this.t = 0;
      this.jdField_b_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleView", 2, "ACTION_UP invalidate()");
      }
      invalidate();
      label301:
      return super.onTouchEvent(paramMotionEvent);
    }
    getParent().requestDisallowInterceptTouchEvent(true);
    this.jdField_a_of_type_Byte = 0;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Boolean = false;
    this.jdField_b_of_type_Float = paramMotionEvent.getX();
    this.jdField_c_of_type_Float = paramMotionEvent.getY();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onTouchEvent ACTION_DOWN  downX -> ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Float);
      ((StringBuilder)localObject).append(", downY -> ");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Float);
      QLog.d("ParticipleView", 2, ((StringBuilder)localObject).toString());
    }
    a(paramMotionEvent);
    return true;
  }
  
  public void setOnParticipleSelectChangeListener(ParticipleView.OnParticipleSelectChangeListener paramOnParticipleSelectChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetParticipleParticipleView$OnParticipleSelectChangeListener = paramOnParticipleSelectChangeListener;
  }
  
  public void setParticipleItems(List<String> paramList)
  {
    int i2 = 0;
    int i1 = i2;
    if (paramList != null) {
      if (paramList.size() != this.jdField_a_of_type_JavaUtilList.size())
      {
        i1 = i2;
      }
      else
      {
        int i3 = paramList.size();
        i1 = 0;
        while (i1 < i3)
        {
          if (!TextUtils.equals((CharSequence)paramList.get(i1), ((ParticipleView.ParticipleEntity)this.jdField_a_of_type_JavaUtilList.get(i1)).a.toString()))
          {
            i1 = i2;
            break label96;
          }
          i1 += 1;
        }
        i1 = 1;
      }
    }
    label96:
    if (i1 == 0)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          a((String)paramList.next());
        }
      }
    }
    else {
      b();
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.participle.ParticipleView
 * JD-Core Version:    0.7.0.1
 */