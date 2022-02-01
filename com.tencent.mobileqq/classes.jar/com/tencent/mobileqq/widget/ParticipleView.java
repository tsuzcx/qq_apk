package com.tencent.mobileqq.widget;

import agej;
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
import bdll;
import begp;
import begw;
import bizy;
import bizz;
import bjaa;
import bjab;
import bjac;
import bjad;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.BaseActivity;
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
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Point jdField_a_of_type_AndroidGraphicsPoint = new Point(0, 0);
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private bjab jdField_a_of_type_Bjab;
  private bjac jdField_a_of_type_Bjac;
  private bjad jdField_a_of_type_Bjad;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private List<bjac> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private RectF jdField_b_of_type_AndroidGraphicsRectF;
  private final List<bjac> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private float jdField_c_of_type_Float;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private boolean jdField_c_of_type_Boolean;
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
  private int q;
  private int r;
  private int s = 0;
  private int t = 0;
  private int u;
  
  public ParticipleView(Context paramContext)
  {
    super(paramContext);
    c();
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
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int i1 = 0;
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      while (i1 < i2)
      {
        Iterator localIterator = bjac.a((bjac)this.jdField_a_of_type_JavaUtilList.get(i1)).iterator();
        while (localIterator.hasNext()) {
          if (((RectF)localIterator.next()).contains(paramFloat1, paramFloat2)) {
            return i1;
          }
        }
        i1 += 1;
      }
    }
    return -1;
  }
  
  private int a(begp parambegp)
  {
    int i2 = 0;
    int i6 = parambegp.jdField_b_of_type_Int;
    String str = parambegp.toString();
    int i4;
    int i1;
    int i3;
    if (i6 > 0)
    {
      parambegp = parambegp.a();
      i4 = 0;
      i1 = 0;
      i3 = 0;
      if (i4 < i6) {
        if (i2 <= 0) {
          break label169;
        }
      }
    }
    for (;;)
    {
      i3 = parambegp[(i4 * 3)];
      int i5 = parambegp[(i4 * 3 + 1)];
      float f1;
      if (i3 > i2)
      {
        f1 = i1;
        i1 = (int)(this.jdField_a_of_type_AndroidGraphicsPaint.measureText(str.substring(i2, i3)) + f1);
      }
      for (;;)
      {
        i1 = this.e + i1;
        i4 += 1;
        i3 = i2;
        i2 = i5;
        break;
        i3 = i1;
        if (i2 < str.length())
        {
          f1 = i1;
          i3 = (int)(this.jdField_a_of_type_AndroidGraphicsPaint.measureText(str.substring(i2)) + f1);
        }
        return i3;
        return (int)this.jdField_a_of_type_AndroidGraphicsPaint.measureText(str);
      }
      label169:
      i2 = i3;
    }
  }
  
  private void a(int paramInt1, int paramInt2, begp parambegp, bjac parambjac, Canvas paramCanvas)
  {
    int i2 = a(parambegp);
    if (getWidth() <= 0)
    {
      i1 = this.r;
      if (i2 + paramInt1 + this.g * 2 + getPaddingRight() <= i1) {
        break label193;
      }
      if (getPaddingLeft() + getPaddingRight() + i2 + this.g * 2 > i1) {
        break label175;
      }
    }
    label175:
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 == 0) {
        break label181;
      }
      paramInt1 = getPaddingLeft();
      i1 = this.e;
      int i3 = this.h;
      c(paramInt1, this.f * 2 + (i1 + paramInt2 + i3), parambegp, parambjac, paramCanvas);
      this.jdField_a_of_type_AndroidGraphicsPoint.x = (getPaddingLeft() + i2 + this.g * 2 + this.i);
      this.jdField_a_of_type_AndroidGraphicsPoint.y = (this.e + paramInt2 + this.h + this.f * 2);
      return;
      i1 = getWidth();
      break;
    }
    label181:
    b(paramInt1, paramInt2, parambegp, parambjac, paramCanvas);
    return;
    label193:
    c(paramInt1, paramInt2, parambegp, parambjac, paramCanvas);
    this.jdField_a_of_type_AndroidGraphicsPoint.x = (paramInt1 + i2 + this.i + this.g * 2);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if ((paramAttributeSet != null) && (paramContext != null))
    {
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ParticipleView);
      this.k = paramAttributeSet.getColor(9, jdField_a_of_type_Int);
      this.l = paramAttributeSet.getColor(10, jdField_b_of_type_Int);
      this.j = paramAttributeSet.getDimensionPixelSize(3, agej.a(3.0F, getResources()));
      this.m = paramAttributeSet.getColor(4, jdField_c_of_type_Int);
      this.n = paramAttributeSet.getColor(8, jdField_d_of_type_Int);
      this.e = paramAttributeSet.getDimensionPixelSize(6, agej.a(27.0F, getResources()));
      this.f = paramAttributeSet.getDimensionPixelSize(7, agej.a(4.0F, getResources()));
      this.g = paramAttributeSet.getDimensionPixelSize(5, agej.a(6.0F, getResources()));
      this.h = paramAttributeSet.getDimensionPixelSize(11, agej.a(12.0F, getResources()));
      this.i = paramAttributeSet.getDimensionPixelSize(2, agej.a(8.0F, getResources()));
      this.o = paramAttributeSet.getInteger(0, 200);
      this.p = paramAttributeSet.getInteger(1, 200);
      paramAttributeSet.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.e);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.l);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.k);
    this.jdField_a_of_type_Bjad = new bjad(this, null);
    ViewCompat.setAccessibilityDelegate(this, this.jdField_a_of_type_Bjad);
    this.u = ViewConfiguration.get(paramContext).getScaledTouchSlop();
  }
  
  private void a(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint.x = getPaddingLeft();
    this.jdField_a_of_type_AndroidGraphicsPoint.y = getPaddingTop();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        bjac localbjac = (bjac)this.jdField_a_of_type_JavaUtilList.get(i1);
        if ((paramCanvas == null) || (a(localbjac))) {
          a(paramCanvas, localbjac);
        }
        i1 += 1;
      }
    }
  }
  
  private void a(Canvas paramCanvas, bjac parambjac)
  {
    if (bjac.a(parambjac).isEmpty()) {
      a(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y, parambjac.a, parambjac, paramCanvas);
    }
    for (;;)
    {
      return;
      int i2 = bjac.a(parambjac).size();
      int i1 = 0;
      while (i1 < i2)
      {
        RectF localRectF = (RectF)bjac.a(parambjac).get(i1);
        a(localRectF, (begp)bjac.b(parambjac).get(i1), parambjac, paramCanvas);
        this.jdField_a_of_type_AndroidGraphicsPoint.x = ((int)localRectF.right + this.i);
        this.jdField_a_of_type_AndroidGraphicsPoint.y = ((int)localRectF.top);
        i1 += 1;
      }
    }
  }
  
  private void a(RectF paramRectF1, RectF paramRectF2)
  {
    boolean bool2 = true;
    if ((paramRectF1 == null) || (paramRectF2 == null) || (paramRectF1 == paramRectF2)) {}
    while ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
      return;
    }
    int i1;
    Object localObject1;
    Object localObject2;
    Object localObject4;
    Object localObject3;
    label103:
    label124:
    boolean bool1;
    if (a(paramRectF1, paramRectF2))
    {
      i1 = 2;
      localObject1 = paramRectF2;
      localObject2 = paramRectF1;
      if ((!a((RectF)localObject2, this.jdField_b_of_type_AndroidGraphicsRectF)) || (!a(this.jdField_b_of_type_AndroidGraphicsRectF, (RectF)localObject1))) {
        break label196;
      }
      if (i1 != 2) {
        break label174;
      }
      localObject4 = this.jdField_b_of_type_AndroidGraphicsRectF;
      localObject3 = this.jdField_b_of_type_AndroidGraphicsRectF;
      paramRectF1 = (RectF)localObject1;
      localObject1 = localObject4;
      this.jdField_a_of_type_Boolean = bjac.a(this.jdField_a_of_type_Bjac);
      localObject4 = paramRectF1;
      paramRectF1 = (RectF)localObject2;
      localObject2 = localObject4;
      this.t = i1;
      if (!paramRectF2.equals(this.jdField_b_of_type_AndroidGraphicsRectF)) {
        break label301;
      }
      if (i1 == 1) {
        break label295;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      a(paramRectF1, (RectF)localObject1, (RectF)localObject3, (RectF)localObject2, bool1);
      return;
      i1 = 1;
      localObject1 = paramRectF1;
      localObject2 = paramRectF2;
      break;
      label174:
      localObject4 = this.jdField_b_of_type_AndroidGraphicsRectF;
      paramRectF1 = this.jdField_b_of_type_AndroidGraphicsRectF;
      localObject3 = localObject2;
      localObject2 = localObject4;
      break label103;
      label196:
      if (paramRectF1.equals(this.jdField_b_of_type_AndroidGraphicsRectF))
      {
        this.jdField_a_of_type_Boolean = bjac.a(this.jdField_a_of_type_Bjac);
        paramRectF1 = null;
        localObject4 = localObject1;
        localObject1 = null;
        localObject3 = localObject2;
        localObject2 = localObject4;
        break label124;
      }
      if ((this.t != 0) && (this.t != i1)) {
        if (this.jdField_a_of_type_Boolean) {
          break label289;
        }
      }
      label289:
      for (bool1 = true;; bool1 = false)
      {
        this.jdField_a_of_type_Boolean = bool1;
        paramRectF1 = null;
        localObject4 = localObject1;
        localObject1 = null;
        localObject3 = localObject2;
        localObject2 = localObject4;
        break;
      }
      label295:
      bool1 = false;
      continue;
      label301:
      bool1 = bool2;
      if (a(this.jdField_b_of_type_AndroidGraphicsRectF, paramRectF2)) {
        bool1 = false;
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
      bjac localbjac = (bjac)this.jdField_a_of_type_JavaUtilList.get(i1);
      Iterator localIterator = bjac.a(localbjac).iterator();
      while (localIterator.hasNext())
      {
        RectF localRectF = (RectF)localIterator.next();
        if ((paramRectF1 != null) && (paramRectF2 != null) && (!localRectF.equals(paramRectF3)) && (!localRectF.equals(paramRectF4)) && (((a(paramRectF1, localRectF)) && (a(localRectF, paramRectF2))) || (localRectF.equals(paramRectF2)) || (localRectF.equals(paramRectF1))))
        {
          if (this.jdField_c_of_type_Boolean)
          {
            if (bjac.a(localbjac)) {
              bjac.a(localbjac, false);
            }
          }
          else
          {
            if (!this.jdField_a_of_type_Boolean) {}
            for (boolean bool = true;; bool = false)
            {
              bjac.a(localbjac, bool);
              break;
            }
          }
        }
        else
        {
          if (paramRectF3.top >= localRectF.top)
          {
            if (paramRectF3.top != localRectF.top) {
              continue;
            }
            if (paramBoolean) {
              if (paramRectF3.left > localRectF.left) {
                continue;
              }
            }
          }
          else
          {
            label241:
            if (localRectF.top >= paramRectF4.top)
            {
              if (localRectF.top != paramRectF4.top) {
                continue;
              }
              if (!paramBoolean) {
                break label329;
              }
              if (localRectF.left >= paramRectF4.left) {
                continue;
              }
            }
          }
          for (;;)
          {
            if (!this.jdField_c_of_type_Boolean) {
              break label346;
            }
            if (!bjac.a(localbjac)) {
              break;
            }
            bjac.a(localbjac, false);
            break;
            if (paramRectF3.left >= localRectF.left) {
              break;
            }
            break label241;
            label329:
            if (localRectF.left > paramRectF4.left) {
              break;
            }
          }
          label346:
          if (this.jdField_a_of_type_Boolean)
          {
            if (!bjac.a(localbjac))
            {
              bjac.a(localbjac, true);
              bjac.a(localbjac, System.currentTimeMillis());
              localArrayList.add(localbjac);
            }
          }
          else if (bjac.a(localbjac)) {
            bjac.a(localbjac, false);
          }
        }
      }
      i1 += 1;
    }
    a(localArrayList);
    if (this.jdField_a_of_type_Bjab != null) {
      this.jdField_a_of_type_Bjab.a();
    }
  }
  
  private void a(RectF paramRectF, begp parambegp, bjac parambjac, Canvas paramCanvas)
  {
    int i2 = (int)paramRectF.bottom;
    int i3 = (int)paramRectF.left;
    int i4 = (int)paramRectF.top;
    int i1 = (int)paramRectF.right;
    float f1;
    float f2;
    float f3;
    if (paramCanvas != null)
    {
      i1 = i1 - i3 - this.g * 2;
      f1 = 0.0F;
      f2 = 0.0F;
      if (!bjac.a(parambjac)) {
        break label271;
      }
      if (bjac.a(parambjac) >= 0.0F) {
        f2 = bjac.a(parambjac);
      }
      f1 = 1.0F;
      if (f2 < 1.0F)
      {
        f3 = i3;
        int i5 = (int)(f1 * (this.g * 2 + i1) + f3);
        paramCanvas.drawRoundRect(new RectF(i3, i4, i5, i2), this.j, this.j, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      if (f2 > 0.0F)
      {
        if (this.s != 4) {
          break label300;
        }
        f1 = i3;
        i1 = (int)(f2 * (i1 + this.g * 2) + f1);
        paramCanvas.drawRoundRect(new RectF(i3, i4, i1, i2), this.j, this.j, this.jdField_c_of_type_AndroidGraphicsPaint);
      }
      label224:
      paramRectF = this.jdField_a_of_type_AndroidGraphicsPaint;
      if (!bjac.a(parambjac)) {
        break label373;
      }
    }
    label271:
    label300:
    label373:
    for (i1 = this.m;; i1 = this.n)
    {
      paramRectF.setColor(i1);
      a(parambegp, paramCanvas, this.g + i3, i4);
      this.q = i2;
      return;
      f3 = 0.0F;
      f2 = f3;
      if (this.jdField_a_of_type_Float < 0.0F) {
        break;
      }
      f1 = this.jdField_a_of_type_Float;
      f2 = f3;
      break;
      f1 = i3;
      paramCanvas.drawRoundRect(new RectF((int)((1.0F - f2) * (this.g * 2 + i1) + f1), i4, i1 + i3 + this.g * 2, i2), this.j, this.j, this.jdField_c_of_type_AndroidGraphicsPaint);
      break label224;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i2 = (int)paramMotionEvent.getX();
    int i3 = (int)paramMotionEvent.getY();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int i4 = this.jdField_a_of_type_JavaUtilList.size();
      int i1 = 0;
      while (i1 < i4)
      {
        bjac localbjac = (bjac)this.jdField_a_of_type_JavaUtilList.get(i1);
        Iterator localIterator = bjac.a(localbjac).iterator();
        while (localIterator.hasNext())
        {
          RectF localRectF2 = (RectF)localIterator.next();
          RectF localRectF1 = null;
          if (localRectF2.contains(i2, i3)) {
            localRectF1 = localRectF2;
          }
          if (localRectF1 != null) {
            if (paramMotionEvent.getAction() == 0)
            {
              this.jdField_a_of_type_AndroidGraphicsRectF = localRectF2;
              this.jdField_b_of_type_AndroidGraphicsRectF = localRectF2;
              this.jdField_a_of_type_Bjac = localbjac;
            }
            else if (paramMotionEvent.getAction() == 2)
            {
              if (this.jdField_a_of_type_Bjac == null)
              {
                this.jdField_a_of_type_AndroidGraphicsRectF = localRectF2;
                this.jdField_b_of_type_AndroidGraphicsRectF = localRectF2;
                this.jdField_a_of_type_Bjac = localbjac;
                g();
              }
              else if (!localRectF1.equals(this.jdField_a_of_type_AndroidGraphicsRectF))
              {
                a(this.jdField_a_of_type_AndroidGraphicsRectF, localRectF1);
                this.jdField_a_of_type_AndroidGraphicsRectF = localRectF1;
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
    if (this.jdField_a_of_type_ComTencentWidgetScrollView != null) {}
    while (paramView == null) {
      return;
    }
    paramView = (View)paramView.getParent();
    if ((paramView instanceof ScrollView))
    {
      this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)paramView);
      return;
    }
    a(paramView);
  }
  
  private void a(begp parambegp, Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    int i1 = 0;
    String str = parambegp.toString();
    int[] arrayOfInt;
    Object[] arrayOfObject;
    int i3;
    int i2;
    if (parambegp.jdField_b_of_type_Int > 0)
    {
      arrayOfInt = parambegp.a();
      arrayOfObject = parambegp.a;
      i3 = 0;
      i2 = 0;
      if (i3 < parambegp.jdField_b_of_type_Int)
      {
        if (i2 <= 0) {
          break label285;
        }
        i1 = i2;
      }
    }
    label285:
    for (;;)
    {
      int i5 = arrayOfInt[(i3 * 3)];
      int i4 = arrayOfInt[(i3 * 3 + 1)];
      i2 = paramInt1;
      if (i5 > i1)
      {
        localObject = str.substring(i1, i5);
        paramCanvas.drawText((String)localObject, paramInt1, this.e + paramInt2, this.jdField_a_of_type_AndroidGraphicsPaint);
        float f1 = paramInt1;
        i2 = (int)(this.jdField_a_of_type_AndroidGraphicsPaint.measureText((String)localObject) + f1);
      }
      Object localObject = arrayOfObject[i3];
      paramInt1 = i2;
      if ((localObject instanceof begw))
      {
        localObject = ((begw)localObject).a();
        paramInt1 = i2;
        if (localObject != null)
        {
          ((Drawable)localObject).setBounds(i2, this.f + paramInt2, this.e + i2, this.f + paramInt2 + this.e);
          ((Drawable)localObject).draw(paramCanvas);
          paramInt1 = i2 + this.e;
        }
      }
      i3 += 1;
      i2 = i4;
      break;
      if (i2 < str.length()) {
        paramCanvas.drawText(str.substring(i2), paramInt1, this.e + paramInt2, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      return;
      paramCanvas.drawText(str, paramInt1, this.e + paramInt2, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  private void a(bjac parambjac)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(parambjac);
    b(localArrayList);
  }
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new begp(paramString, 3);
      this.jdField_a_of_type_JavaUtilList.add(new bjac(paramString, null));
    }
  }
  
  private void a(List<bjac> paramList)
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
  
  private boolean a(bjac parambjac)
  {
    if ((this.jdField_b_of_type_Boolean) && (!bjac.a(parambjac).isEmpty()))
    {
      a(this);
      if (this.jdField_a_of_type_ComTencentWidgetScrollView != null)
      {
        parambjac = bjac.a(parambjac).iterator();
        while (parambjac.hasNext())
        {
          int i1 = (int)((RectF)parambjac.next()).top;
          if ((this.e + i1 + this.f * 2 - this.jdField_a_of_type_ComTencentWidgetScrollView.getScrollY() > 0) && (i1 - this.jdField_a_of_type_ComTencentWidgetScrollView.getScrollY() < this.jdField_a_of_type_ComTencentWidgetScrollView.getHeight())) {}
          for (i1 = 1; i1 != 0; i1 = 0) {
            return true;
          }
        }
        return false;
      }
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < paramString.length())
      {
        int i2 = paramString.charAt(i1);
        if ((19968 <= i2) && (i2 < 40869)) {
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  private void b(int paramInt1, int paramInt2, begp parambegp, bjac parambjac, Canvas paramCanvas)
  {
    int i3;
    int i1;
    String str3;
    int i10;
    int i6;
    label79:
    String str1;
    if (getWidth() <= 0)
    {
      i3 = this.r;
      int i9 = parambegp.jdField_b_of_type_Int;
      int[] arrayOfInt = parambegp.a();
      int i4 = 0;
      i1 = 0;
      int i2 = 0;
      if (i9 > 0)
      {
        i1 = arrayOfInt[0];
        i2 = arrayOfInt[1];
      }
      str3 = parambegp.toString();
      i10 = str3.length();
      i6 = 0;
      int i5 = i2;
      i2 = i1;
      i1 = i6;
      if (i1 >= i10) {
        break label407;
      }
      if ((i9 <= 0) || (i4 >= i9) || (i2 != i1)) {
        break label304;
      }
      String str2 = str3.substring(0, i5);
      int i7 = i5 - 1;
      int i8 = i4 + 1;
      str1 = str2;
      i6 = i7;
      i4 = i8;
      if (i8 < i9)
      {
        i2 = arrayOfInt[(i8 * 3)];
        i5 = arrayOfInt[(i8 * 3 + 1)];
        i4 = i8;
        i6 = i7;
        str1 = str2;
      }
      label178:
      if (a(new begp(str1, 3)) + paramInt1 + this.g * 2 + getPaddingRight() <= i3) {
        break label398;
      }
      this.jdField_a_of_type_AndroidGraphicsPoint.x = getPaddingLeft();
      this.jdField_a_of_type_AndroidGraphicsPoint.y = (this.e + paramInt2 + this.h + this.f * 2);
      if (i1 > 0) {
        break label323;
      }
      a(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y, parambegp, parambjac, paramCanvas);
      i1 = 1;
    }
    for (;;)
    {
      if (i1 == 0) {
        a(paramInt1, paramInt2, parambegp, parambjac, paramCanvas);
      }
      return;
      i3 = getWidth();
      break;
      label304:
      str1 = str3.substring(0, i1 + 1);
      i6 = i1;
      break label178;
      label323:
      c(paramInt1, paramInt2, new begp(str3.substring(0, i1), 3), parambjac, paramCanvas);
      str1 = str3.substring(i1, i10);
      a(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y, new begp(str1, 3), parambjac, paramCanvas);
      i1 = 1;
      continue;
      label398:
      i1 = i6 + 1;
      break label79;
      label407:
      i1 = 0;
    }
  }
  
  private void b(List<bjac> paramList)
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
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new bizy(this));
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  private void c()
  {
    a(null, null);
  }
  
  private void c(int paramInt1, int paramInt2, begp parambegp, bjac parambjac, Canvas paramCanvas)
  {
    int i1 = this.e;
    int i2 = this.f;
    int i3 = a(parambegp);
    int i4 = this.g;
    RectF localRectF = new RectF(paramInt1, paramInt2, i3 + i4 * 2 + paramInt1, i1 + paramInt2 + i2 * 2);
    bjac.a(parambjac, localRectF, parambegp);
    a(localRectF, parambegp, parambjac, paramCanvas);
  }
  
  private void d()
  {
    bdll.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A359", "0X800A359", 0, 0, "", "", "", "");
  }
  
  private void e()
  {
    g();
    if ((this.jdField_a_of_type_Bjac != null) && (bjac.a(this.jdField_a_of_type_Bjac))) {
      bdll.b(((BaseActivity)getContext()).app, "dc00898", "", "", "0X800A358", "0X800A358", 0, 0, "", "", "", "");
    }
  }
  
  private void f()
  {
    g();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_Bjac != null)
    {
      this.jdField_c_of_type_Boolean = bjac.a(this.jdField_a_of_type_Bjac);
      if (!bjac.a(this.jdField_a_of_type_Bjac)) {
        break label63;
      }
      bjac.a(this.jdField_a_of_type_Bjac, false);
      this.jdField_a_of_type_Boolean = false;
      invalidate();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bjab != null) {
        this.jdField_a_of_type_Bjab.a();
      }
      return;
      label63:
      bjac.a(this.jdField_a_of_type_Bjac, true);
      this.jdField_a_of_type_Boolean = true;
      bjac.a(this.jdField_a_of_type_Bjac, System.currentTimeMillis());
      a(this.jdField_a_of_type_Bjac);
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = (bjac)this.jdField_a_of_type_JavaUtilList.get(i1);
        if (bjac.a((bjac)localObject))
        {
          localObject = ((bjac)localObject).a.toString();
          boolean bool = a((String)localObject);
          if ((localStringBuilder.length() > 0) && ((this.jdField_d_of_type_Boolean != bool) || (!this.jdField_d_of_type_Boolean))) {
            localStringBuilder.append(" ");
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
    localValueAnimator.addUpdateListener(new bizz(this));
    localValueAnimator.setDuration(this.p);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.addListener(new bjaa(this));
    localAnimatorSet.playSequentially(new Animator[] { localObjectAnimator, localValueAnimator });
    localAnimatorSet.start();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ParticipleView", 2, "resetState invalidate()");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      int i2 = this.jdField_a_of_type_JavaUtilList.size();
      int i1 = 0;
      while (i1 < i2)
      {
        bjac.a((bjac)this.jdField_a_of_type_JavaUtilList.get(i1), false);
        a(this);
        if (this.jdField_a_of_type_ComTencentWidgetScrollView != null) {
          this.jdField_a_of_type_ComTencentWidgetScrollView.scrollTo(0, 0);
        }
        i1 += 1;
      }
    }
    invalidate();
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    if ((AppSetting.jdField_c_of_type_Boolean) && (this.jdField_a_of_type_Bjad != null) && (this.jdField_a_of_type_Bjad.dispatchHoverEvent(paramMotionEvent))) {
      return true;
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
    if (View.MeasureSpec.getMode(paramInt2) == 1073741824)
    {
      paramInt1 = View.MeasureSpec.getSize(paramInt2);
      if (paramInt1 <= 0) {
        break label60;
      }
    }
    for (;;)
    {
      setMeasuredDimension(i2, paramInt1);
      return;
      paramInt1 = a();
      break;
      label60:
      paramInt1 = i1;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    default: 
    case 0: 
    case 2: 
      do
      {
        return super.onTouchEvent(paramMotionEvent);
        this.jdField_a_of_type_Byte = 0;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_b_of_type_Boolean = false;
        this.jdField_b_of_type_Float = paramMotionEvent.getX();
        this.jdField_c_of_type_Float = paramMotionEvent.getY();
        if (QLog.isColorLevel()) {
          QLog.d("ParticipleView", 2, "onTouchEvent ACTION_DOWN  downX -> " + this.jdField_b_of_type_Float + ", downY -> " + this.jdField_c_of_type_Float);
        }
        a(paramMotionEvent);
        return true;
        float f1 = (int)paramMotionEvent.getX();
        float f3 = (int)paramMotionEvent.getY();
        if (this.jdField_a_of_type_Byte == 0)
        {
          float f2 = Math.abs(f1 - this.jdField_b_of_type_Float);
          f3 = Math.abs(f3 - this.jdField_c_of_type_Float);
          if ((f2 > this.u) || (f3 > this.u))
          {
            if (f3 <= f2) {
              break label217;
            }
            this.jdField_a_of_type_Byte = 2;
          }
        }
        if (this.jdField_a_of_type_Byte == 0)
        {
          return true;
          this.jdField_a_of_type_Byte = 1;
          d();
          g();
          if (f1 - this.jdField_b_of_type_Float > 0.0F) {}
          for (int i1 = 4;; i1 = 3)
          {
            this.s = i1;
            break;
          }
        }
        this.jdField_b_of_type_Boolean = true;
      } while (this.jdField_a_of_type_Byte != 1);
      getParent().requestDisallowInterceptTouchEvent(true);
      a(paramMotionEvent);
      return true;
    case 1: 
      label217:
      if (!this.jdField_b_of_type_Boolean)
      {
        if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 500L) {
          break label368;
        }
        f();
      }
      break;
    }
    for (;;)
    {
      this.jdField_a_of_type_Byte = 0;
      this.jdField_a_of_type_AndroidGraphicsRectF = null;
      this.jdField_b_of_type_AndroidGraphicsRectF = null;
      this.jdField_a_of_type_Bjac = null;
      this.t = 0;
      this.jdField_b_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("ParticipleView", 2, "ACTION_UP invalidate()");
      }
      invalidate();
      break;
      label368:
      e();
    }
  }
  
  public void setOnParticipleSelectChangeListener(bjab parambjab)
  {
    this.jdField_a_of_type_Bjab = parambjab;
  }
  
  public void setParticipleItems(List<String> paramList)
  {
    int i1;
    if ((paramList == null) || (paramList.size() != this.jdField_a_of_type_JavaUtilList.size())) {
      i1 = 0;
    }
    for (;;)
    {
      if (i1 == 0)
      {
        if ((paramList != null) && (paramList.size() > 0))
        {
          this.jdField_a_of_type_JavaUtilList.clear();
          paramList = paramList.iterator();
          while (paramList.hasNext()) {
            a((String)paramList.next());
          }
          int i2 = paramList.size();
          i1 = 0;
          for (;;)
          {
            if (i1 >= i2) {
              break label148;
            }
            if (!TextUtils.equals((CharSequence)paramList.get(i1), ((bjac)this.jdField_a_of_type_JavaUtilList.get(i1)).a.toString()))
            {
              i1 = 0;
              break;
            }
            i1 += 1;
          }
        }
      }
      else {
        b();
      }
      return;
      label148:
      i1 = 1;
    }
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ParticipleView
 * JD-Core Version:    0.7.0.1
 */