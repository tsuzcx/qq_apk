package com.tencent.widget;

import ahui;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.OnScaleGestureListener;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import baro;
import bdzx;
import bkhl;
import bkih;
import bkik;
import bkks;
import bkkt;
import bkku;
import bkkv;
import bkmr;
import com.tencent.image.GifDrawable;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter.GalleryImageStruct;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;

public class Gallery
  extends AbsSpinner
  implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener, ScaleGestureDetector.OnScaleGestureListener
{
  private static RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  protected static Rect b;
  public static float c = 2.0F;
  private static int jdField_w_of_type_Int = 20;
  double jdField_a_of_type_Double = 0.0D;
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = -1L;
  private Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(paramContext, this);
  private ScaleGestureDetector jdField_a_of_type_AndroidViewScaleGestureDetector;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  protected View a;
  private bkih jdField_a_of_type_Bkih;
  bkks jdField_a_of_type_Bkks;
  protected bkkt a;
  private Gallery.FlingRunnable jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable = new Gallery.FlingRunnable(this);
  private Runnable jdField_a_of_type_JavaLangRunnable = new Gallery.1(this);
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float = 1.0F;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  float d;
  protected boolean d;
  float e;
  public boolean e;
  float f;
  public boolean f;
  float g;
  public boolean g;
  float jdField_h_of_type_Float;
  protected int h;
  boolean jdField_h_of_type_Boolean = false;
  private float jdField_i_of_type_Float = c;
  protected int i;
  boolean jdField_i_of_type_Boolean = true;
  protected int j;
  private boolean j;
  protected int k;
  private boolean k;
  private int jdField_l_of_type_Int = 400;
  private boolean jdField_l_of_type_Boolean;
  private int jdField_m_of_type_Int;
  private boolean jdField_m_of_type_Boolean;
  private int jdField_n_of_type_Int;
  private boolean jdField_n_of_type_Boolean;
  private int jdField_o_of_type_Int;
  private boolean jdField_o_of_type_Boolean;
  private int jdField_p_of_type_Int;
  private boolean jdField_p_of_type_Boolean;
  private int jdField_q_of_type_Int;
  private boolean jdField_q_of_type_Boolean;
  private int jdField_r_of_type_Int;
  private boolean jdField_r_of_type_Boolean;
  private int jdField_s_of_type_Int;
  private boolean jdField_s_of_type_Boolean;
  private int jdField_t_of_type_Int;
  private boolean jdField_t_of_type_Boolean = true;
  private int jdField_u_of_type_Int;
  private boolean jdField_u_of_type_Boolean = true;
  private int jdField_v_of_type_Int;
  private boolean jdField_v_of_type_Boolean;
  private boolean jdField_w_of_type_Boolean = true;
  private boolean x;
  
  static
  {
    jdField_b_of_type_AndroidGraphicsRect = new Rect();
  }
  
  public Gallery(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public Gallery(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842864);
  }
  
  public Gallery(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, false);
    this.jdField_j_of_type_Boolean = true;
    this.jdField_j_of_type_Int = -1;
    this.jdField_d_of_type_Float = 0.0F;
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(true);
    this.jdField_a_of_type_AndroidViewGestureDetector.setOnDoubleTapListener(this);
    this.jdField_a_of_type_AndroidViewScaleGestureDetector = new ScaleGestureDetector(paramContext, this);
    if (!VersionUtils.isHoneycomb()) {
      setStaticTransformationsEnabled(true);
    }
    this.jdField_p_of_type_Int = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
    this.jdField_a_of_type_Float = TypedValue.applyDimension(1, 2400.0F, paramContext.getResources().getDisplayMetrics());
    setFadingEdgeLength(0);
  }
  
  private double a(float paramFloat1, float paramFloat2)
  {
    double d2 = Math.atan(paramFloat2 / paramFloat1);
    double d1;
    if (paramFloat1 < 0.0F) {
      d1 = d2 + 3.141592653589793D;
    }
    do
    {
      return d1;
      d1 = d2;
    } while (d2 >= 0.0D);
    return d2 + 6.283185307179586D;
  }
  
  public static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    int i2 = 1;
    int i3 = 0;
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 1.0F;
    }
    int i4 = paramInt2 * paramInt3 / paramInt1;
    int i5 = bdzx.c;
    boolean bool = baro.a(paramInt1, paramInt2);
    int i1 = i3;
    if (paramObject != null)
    {
      i1 = i3;
      if ((paramObject instanceof AIOImageData))
      {
        if ((((AIOImageData)paramObject).d & 0x1) != 1) {
          break label128;
        }
        i1 = i2;
      }
    }
    float f1;
    if (((bool) && (paramInt1 <= paramInt3) && (paramInt2 <= paramInt4)) || ((paramInt1 < i5) && (paramInt2 < i5)) || ((i1 != 0) && (paramInt1 <= paramInt3) && (paramInt2 <= paramInt4))) {
      f1 = 1.0F;
    }
    for (;;)
    {
      return Math.min(f1, 2.0F);
      label128:
      i1 = 0;
      break;
      if (paramInt4 >= i4) {
        f1 = paramInt3 / paramInt1;
      } else {
        f1 = paramInt4 / paramInt2;
      }
    }
  }
  
  private Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    int i2 = getMeasuredWidth();
    int i1 = getMeasuredHeight();
    switch (paramInt3 & 0x70)
    {
    default: 
      i1 = 0;
      switch (paramInt3 & 0x7)
      {
      case 4: 
      default: 
        paramInt3 = (i2 - this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_AndroidGraphicsRect.right - paramInt1) / 2;
        if (paramBoolean)
        {
          paramInt3 = paramInt4 + paramInt3;
          paramInt4 = paramInt3 + paramInt1;
          paramInt1 = paramInt3;
        }
        break;
      }
      break;
    }
    for (;;)
    {
      localRect.left = paramInt1;
      localRect.top = i1;
      localRect.right = paramInt4;
      localRect.bottom = (i1 + paramInt2);
      return localRect;
      i1 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      break;
      int i3 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      int i4 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      int i5 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      i1 = (i1 - i3 - i4 - paramInt2) / 2 + i5;
      break;
      i1 = i1 - this.jdField_a_of_type_AndroidGraphicsRect.bottom - paramInt2;
      break;
      if (paramBoolean)
      {
        paramInt3 = paramInt4;
        paramInt4 += paramInt1;
        paramInt1 = paramInt3;
      }
      else
      {
        paramInt1 = paramInt4 - paramInt1;
        continue;
        paramInt1 = paramInt4 - paramInt1 - paramInt3;
        paramInt4 -= paramInt3;
      }
    }
  }
  
  @TargetApi(11)
  private Rect a(View paramView)
  {
    if (paramView == null) {
      return new Rect();
    }
    Rect localRect = new Rect();
    jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
    if (VersionUtils.isHoneycomb()) {}
    for (Matrix localMatrix = paramView.getMatrix();; localMatrix = bkkv.a(a(paramView)))
    {
      localMatrix.mapRect(jdField_a_of_type_AndroidGraphicsRectF);
      jdField_a_of_type_AndroidGraphicsRectF.offset(paramView.getLeft(), paramView.getTop());
      jdField_a_of_type_AndroidGraphicsRectF.round(localRect);
      return localRect;
    }
  }
  
  private View a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, View paramView)
  {
    Object localObject2;
    if (!this.mDataChanged)
    {
      localObject2 = this.jdField_a_of_type_Bkhl.a(paramInt1);
      if (localObject2 != null)
      {
        paramInt1 = ((View)localObject2).getLeft();
        this.jdField_n_of_type_Int = Math.max(this.jdField_n_of_type_Int, ((View)localObject2).getMeasuredWidth() + paramInt1);
        this.jdField_m_of_type_Int = Math.min(this.jdField_m_of_type_Int, paramInt1);
        a((View)localObject2, paramInt2, paramInt3, paramBoolean, true);
      }
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject2 = this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getView(paramInt1, null, this);
      a(paramInt1, this, paramBoolean, false);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = getContext();
        localObject1 = new ImageView((Context)localObject2);
        ((ImageView)localObject1).setImageDrawable(((Context)localObject2).getResources().getDrawable(2130850730));
      }
      a((View)localObject1, paramInt2, paramInt3, paramBoolean, false);
      localObject2 = localObject1;
    } while (paramView == null);
    a(paramView, (View)localObject1);
    return localObject1;
  }
  
  private bkku a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    boolean bool2 = false;
    bkku localbkku = new bkku(null);
    if (paramView.getTag(2131296389) != null) {}
    for (int i3 = ((Integer)paramView.getTag(2131296389)).intValue();; i3 = 0)
    {
      localbkku.jdField_a_of_type_Int = i3;
      if ((paramView.getTag(2131296415) instanceof Integer)) {}
      for (localbkku.jdField_b_of_type_Int = ((Integer)paramView.getTag(2131296415)).intValue(); paramView.getTag(2131296386) != null; localbkku.jdField_b_of_type_Int = 17)
      {
        localbkku.jdField_a_of_type_Float = ((Float)paramView.getTag(2131296386)).floatValue();
        return localbkku;
      }
      int i2;
      int i1;
      if (i3 != 1)
      {
        i2 = paramInt1;
        i1 = paramInt2;
        if (i3 != 3) {}
      }
      else
      {
        i1 = paramInt1;
        i2 = paramInt2;
      }
      if ((paramView instanceof AIOGalleryAdapter.GalleryImageStruct))
      {
        localObject = ((AIOGalleryAdapter.GalleryImageStruct)paramView).a();
        if (localObject == null) {}
      }
      for (Object localObject = ((ahui)localObject).a;; localObject = null)
      {
        float f1 = a(i2, i1, paramInt3, paramInt4, localObject);
        if (i1 >= i2 * 3)
        {
          paramInt1 = 1;
          if ((paramInt1 == 0) || ((i2 <= paramInt3) && (i1 <= paramInt4)) || ((i2 < bdzx.c) && (i1 < bdzx.c))) {
            break label356;
          }
          localbkku.jdField_b_of_type_Int = 49;
          localbkku.jdField_a_of_type_Float = Math.min(paramInt3 / i2, this.jdField_i_of_type_Float);
          localbkku.jdField_b_of_type_Boolean = true;
          paramView.setTag(2131296392, Float.valueOf(f1));
          if (b()) {
            paramView.setTag(2131296414, Float.valueOf(localbkku.jdField_a_of_type_Float));
          }
        }
        for (;;)
        {
          boolean bool1 = bool2;
          if (paramView.getTag(2131296412) != null)
          {
            bool1 = bool2;
            if (((Boolean)paramView.getTag(2131296412)).booleanValue()) {
              bool1 = true;
            }
          }
          localbkku.jdField_a_of_type_Boolean = bool1;
          return localbkku;
          paramInt1 = 0;
          break;
          label356:
          localbkku.jdField_b_of_type_Int = 17;
          localbkku.jdField_b_of_type_Boolean = false;
          localbkku.jdField_a_of_type_Float = a(paramView, f1, i2);
        }
      }
    }
  }
  
  private bkkv a(View paramView)
  {
    bkkv localbkkv2 = (bkkv)paramView.getTag(2131296388);
    bkkv localbkkv1 = localbkkv2;
    if (localbkkv2 == null)
    {
      localbkkv1 = new bkkv();
      paramView.setTag(2131296388, localbkkv1);
    }
    if (localbkkv1.jdField_a_of_type_Boolean) {
      a(localbkkv1);
    }
    return localbkkv1;
  }
  
  @TargetApi(11)
  private void a(float paramFloat1, float paramFloat2)
  {
    a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
    float f1 = this.jdField_a_of_type_AndroidViewView.getLeft();
    float f2 = this.jdField_a_of_type_AndroidViewView.getTop();
    a(this.jdField_a_of_type_AndroidViewView).invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = (paramFloat1 - f1);
    arrayOfFloat[1] = (paramFloat2 - f2);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapPoints(arrayOfFloat);
    int i3 = jdField_b_of_type_AndroidGraphicsRect.width() / 2;
    int i4 = jdField_b_of_type_AndroidGraphicsRect.left;
    int i1 = jdField_b_of_type_AndroidGraphicsRect.height() / 2;
    int i2 = jdField_b_of_type_AndroidGraphicsRect.top;
    a(this.jdField_a_of_type_AndroidViewView, arrayOfFloat[0], arrayOfFloat[1]);
    a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
    i3 = i3 + i4 - (jdField_b_of_type_AndroidGraphicsRect.width() / 2 + jdField_b_of_type_AndroidGraphicsRect.left);
    i1 = i1 + i2 - (jdField_b_of_type_AndroidGraphicsRect.height() / 2 + jdField_b_of_type_AndroidGraphicsRect.top);
    if (VersionUtils.isHoneycomb())
    {
      a(this.jdField_a_of_type_AndroidViewView, i3, i1);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(i3);
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(i1);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, View paramView)
  {
    this.jdField_e_of_type_Boolean = true;
    int i1 = paramView.getMeasuredWidth();
    int i2 = paramView.getMeasuredHeight();
    if ((i2 == 0) || (i1 == 0)) {
      return;
    }
    bkku localbkku = a(i1, i2, paramInt1, paramInt2, paramView);
    boolean bool1;
    boolean bool2;
    if ((paramView.getWidth() != i1) || (paramView.getHeight() != i2))
    {
      bool1 = true;
      if (localbkku.jdField_a_of_type_Int * 90 == paramView.getRotation()) {
        break label354;
      }
      bool2 = true;
      label88:
      if (QLog.isColorLevel()) {
        QLog.d("Gallery", 2, "imgSizeChanged in layoutAndScaleChild is " + Boolean.toString(bool1) + " rotateChanged:" + bool2);
      }
      if (localbkku != null)
      {
        paramInt1 = paramView.getLeft();
        a(paramView, localbkku.jdField_b_of_type_Int, paramInt3, paramBoolean);
        if ((localbkku.jdField_b_of_type_Boolean) && (a())) {
          e(true);
        }
        if ((localbkku.jdField_a_of_type_Boolean) && (!bool1) && (!bool2)) {
          break label360;
        }
        float f1 = localbkku.jdField_a_of_type_Float;
        if (f1 != 0.0F)
        {
          a(paramView, 0.0F, 0.0F);
          a(paramView, f1);
          b(paramView, localbkku.jdField_a_of_type_Int * 90);
          a(paramView, jdField_b_of_type_AndroidGraphicsRect);
          Rect localRect = a(jdField_b_of_type_AndroidGraphicsRect.width(), jdField_b_of_type_AndroidGraphicsRect.height(), localbkku.jdField_b_of_type_Int, paramInt3, paramBoolean);
          a(paramView, localRect.left - jdField_b_of_type_AndroidGraphicsRect.left, localRect.top - jdField_b_of_type_AndroidGraphicsRect.top);
        }
        paramView.setTag(2131296385, Float.valueOf(localbkku.jdField_a_of_type_Float));
        paramView.setTag(2131296389, Integer.valueOf(localbkku.jdField_a_of_type_Int));
      }
    }
    for (;;)
    {
      this.jdField_e_of_type_Boolean = false;
      return;
      bool1 = false;
      break;
      label354:
      bool2 = false;
      break label88;
      label360:
      paramInt1 -= paramView.getLeft();
      if (QLog.isColorLevel()) {
        QLog.d("Gallery", 2, "left diff is: " + Integer.toString(paramInt1));
      }
      if (paramInt1 != 0) {
        a(paramView, paramInt1, 0);
      }
    }
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    paramView.setTag(2131296412, Boolean.valueOf(true));
  }
  
  private void a(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    do
    {
      return;
      a(paramView);
      paramView.setScaleX(paramFloat);
      paramView.setScaleY(paramFloat);
    } while (isHardwareAccelerated());
    invalidate();
  }
  
  @TargetApi(11)
  private void a(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {}
    bkkv localbkkv;
    do
    {
      return;
      if (VersionUtils.isHoneycomb())
      {
        paramView.setPivotX(paramFloat1);
        paramView.setPivotY(paramFloat2);
        return;
      }
      localbkkv = a(paramView);
    } while ((localbkkv.jdField_f_of_type_Float == paramFloat1) && (localbkkv.jdField_g_of_type_Float == paramFloat2));
    localbkkv.jdField_f_of_type_Float = paramFloat1;
    localbkkv.jdField_g_of_type_Float = paramFloat2;
    localbkkv.jdField_a_of_type_Boolean = true;
    paramView.invalidate();
  }
  
  private void a(View paramView, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    a(paramView);
    paramView.setPivotX(paramFloat1);
    paramView.setPivotY(paramFloat2);
    paramView.setScaleX(paramFloat3);
    paramView.setScaleY(paramFloat3);
    paramView.getMatrix();
    if (!isHardwareAccelerated()) {
      invalidate();
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null) {
      return;
    }
    paramView.setTranslationX(paramView.getTranslationX() + paramInt1);
    paramView.setTranslationY(paramView.getTranslationY() + paramInt2);
    a(paramView);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Rect localRect = a(paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), paramInt1, paramInt2, paramBoolean);
    paramView.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i3 = 0;
    if (paramView == null) {
      return;
    }
    boolean bool;
    label26:
    int i1;
    label45:
    Gallery.LayoutParams localLayoutParams;
    if (paramInt1 == 0)
    {
      bool = true;
      if (bool == paramView.isSelected()) {
        break label264;
      }
      paramInt1 = 1;
      if ((paramBoolean2) && (paramInt1 == 0) && (!paramView.isLayoutRequested())) {
        break label269;
      }
      i1 = 1;
      localLayoutParams = (Gallery.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams != null) {
        break label287;
      }
      localLayoutParams = (Gallery.LayoutParams)generateDefaultLayoutParams();
    }
    label264:
    label269:
    label281:
    label287:
    for (;;)
    {
      int i2;
      if (paramBoolean1)
      {
        i2 = -1;
        label76:
        addViewInLayout(paramView, i2, localLayoutParams, true);
        if (paramInt1 != 0) {
          paramView.setSelected(bool);
        }
        if (i1 == 0) {
          break;
        }
        i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        i2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        if (!this.jdField_v_of_type_Boolean)
        {
          paramInt1 = i3;
          if (paramView.getTag(2131296433) != null)
          {
            paramInt1 = i3;
            if (!((Boolean)paramView.getTag(2131296433)).booleanValue()) {}
          }
        }
        else
        {
          paramInt1 = 1;
        }
        if ((paramInt1 == 0) || (localLayoutParams.height != -1) || (localLayoutParams.width != -1)) {
          break label281;
        }
        i1 = View.MeasureSpec.makeMeasureSpec(getWidth() - this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_AndroidGraphicsRect.right, 1073741824);
      }
      for (paramInt1 = View.MeasureSpec.makeMeasureSpec(getHeight() - this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_AndroidGraphicsRect.bottom, 1073741824);; paramInt1 = i2)
      {
        paramView.measure(i1, paramInt1);
        a(this.jdField_q_of_type_Int, this.jdField_r_of_type_Int, paramInt2, paramBoolean1, paramView);
        return;
        bool = false;
        break;
        paramInt1 = 0;
        break label26;
        i1 = 0;
        break label45;
        i2 = 0;
        break label76;
      }
    }
  }
  
  @TargetApi(11)
  private void a(View paramView1, View paramView2)
  {
    if (paramView1 != paramView2)
    {
      if (VersionUtils.isHoneycomb()) {
        a(paramView2, paramView1.getPivotX(), paramView1.getPivotY(), paramView1.getScaleX());
      }
    }
    else {
      return;
    }
    paramView2.setTag(2131296388, (bkkv)paramView1.getTag(2131296388));
  }
  
  private void a(bkkv parambkkv)
  {
    if (parambkkv == null) {}
    while (!parambkkv.jdField_a_of_type_Boolean) {
      return;
    }
    bkkv.a(parambkkv).reset();
    bkkv.a(parambkkv).setTranslate(parambkkv.jdField_b_of_type_Float, parambkkv.c);
    bkkv.a(parambkkv).preRotate(parambkkv.jdField_a_of_type_Float, parambkkv.jdField_f_of_type_Float, parambkkv.jdField_g_of_type_Float);
    bkkv.a(parambkkv).preScale(parambkkv.jdField_d_of_type_Float, parambkkv.jdField_e_of_type_Float, parambkkv.jdField_f_of_type_Float, parambkkv.jdField_g_of_type_Float);
    parambkkv.jdField_a_of_type_Boolean = false;
    bkkv.a(parambkkv, bkkv.a(parambkkv).isIdentity());
  }
  
  private boolean a(View paramView, int paramInt, long paramLong)
  {
    if (this.mOnItemLongClickListener != null) {}
    for (boolean bool1 = this.mOnItemLongClickListener.a(this, this.jdField_b_of_type_AndroidViewView, paramInt, paramLong);; bool1 = false)
    {
      boolean bool2 = bool1;
      if (!bool1)
      {
        this.jdField_a_of_type_Bkih = new bkih(paramView, paramInt, paramLong);
        bool2 = super.showContextMenuForChild(this);
      }
      if (bool2) {
        performHapticFeedback(0);
      }
      return bool2;
    }
  }
  
  @TargetApi(11)
  private float b(View paramView)
  {
    if (VersionUtils.isHoneycomb()) {
      return paramView.getRotation();
    }
    return a(paramView).jdField_a_of_type_Float;
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      paramInt1 = (-paramInt1 + 360) / 360 * 360 + paramInt1;
    }
    for (;;)
    {
      int i1 = paramInt1;
      if (paramInt1 > 360) {
        i1 = paramInt1 % 360;
      }
      paramInt1 = jdField_w_of_type_Int;
      if ((paramInt2 == 1) || (paramInt2 == 3)) {
        paramInt1 = 90 - jdField_w_of_type_Int;
      }
      paramInt2 = 180 - paramInt1;
      int i2 = paramInt1 + 180;
      int i3 = 360 - paramInt1;
      if (((i1 >= 0) && (i1 < paramInt1)) || (i1 >= i3)) {
        return 0;
      }
      if ((i1 >= paramInt1) && (i1 < paramInt2)) {
        return 1;
      }
      if ((i1 >= paramInt2) && (i1 < i2)) {
        return 2;
      }
      if ((i1 >= i2) && (i1 < i3)) {
        return 3;
      }
      return 0;
    }
  }
  
  private void b(View paramView)
  {
    if (paramView != null) {
      paramView.setPressed(true);
    }
    setPressed(true);
  }
  
  @TargetApi(11)
  private void b(View paramView, float paramFloat)
  {
    if (paramView == null) {
      return;
    }
    paramView.setRotation(paramFloat);
    a(paramView);
  }
  
  private static int c(int paramInt1, int paramInt2)
  {
    if (paramInt1 < -45) {
      paramInt1 = (-paramInt1 + 360) / 360 * 360 + paramInt1;
    }
    label86:
    for (;;)
    {
      int i1 = paramInt1 - paramInt2 * 90;
      if (i1 > 180) {
        paramInt2 = paramInt1 - 360;
      }
      do
      {
        return paramInt2;
        if (paramInt1 < 275) {
          break label86;
        }
        paramInt1 -= (paramInt1 + 360) / 360 * 360;
        break;
        paramInt2 = paramInt1;
      } while (i1 >= -180);
      return paramInt1 + 360;
    }
  }
  
  private void d(boolean paramBoolean)
  {
    int i3 = 0;
    int i2 = 0;
    int i7 = getChildCount();
    int i6 = this.mFirstPosition;
    int i4;
    int i5;
    View localView;
    if (paramBoolean)
    {
      i8 = getPaddingLeft();
      i1 = 0;
      i4 = 0;
      i3 = i2;
      i2 = i4;
      for (;;)
      {
        i4 = i2;
        i5 = i3;
        if (i1 < i7)
        {
          localView = getChildAt(i1);
          if (a(localView, jdField_b_of_type_AndroidGraphicsRect).right > i8)
          {
            i5 = i3;
            i4 = i2;
          }
        }
        else
        {
          detachViewsFromParent(i5, i4);
          if (paramBoolean) {
            this.mFirstPosition = (i4 + this.mFirstPosition);
          }
          return;
        }
        i2 += 1;
        this.jdField_a_of_type_Bkhl.a(i6 + i1, localView);
        a(i6 + i1, localView, this, paramBoolean);
        a(i6 + i1 + 1, this, paramBoolean, true);
        i3 = i1;
        i1 += 1;
      }
    }
    int i8 = getWidth();
    int i9 = getPaddingRight();
    int i1 = i7 - 1;
    i2 = 0;
    for (;;)
    {
      i4 = i2;
      i5 = i3;
      if (i1 < 0) {
        break;
      }
      localView = getChildAt(i1);
      i4 = i2;
      i5 = i3;
      if (a(localView, jdField_b_of_type_AndroidGraphicsRect).left < i8 - i9) {
        break;
      }
      this.jdField_a_of_type_Bkhl.a(i6 + i1, localView);
      a(i6 + i1, localView, this, paramBoolean);
      a(i6 + i1 - 1, this, paramBoolean, true);
      i2 += 1;
      i3 = i1;
      i1 -= 1;
    }
  }
  
  private void e(boolean paramBoolean)
  {
    a(paramBoolean, 0);
  }
  
  private void g()
  {
    a(0.0F);
  }
  
  private void h()
  {
    int i1;
    if (this.jdField_u_of_type_Int > 0)
    {
      i1 = getChildCount() - 1;
      this.jdField_u_of_type_Int = a(getChildAt(i1), jdField_b_of_type_AndroidGraphicsRect).left;
      i1 += this.mFirstPosition;
      this.jdField_v_of_type_Int = 0;
    }
    for (;;)
    {
      if (i1 != this.mSelectedPosition)
      {
        setSelectedPositionInt(i1);
        setNextSelectedPositionInt(i1);
        checkSelectionChanged();
      }
      return;
      if (this.jdField_u_of_type_Int < 0)
      {
        i1 = this.mFirstPosition;
        this.jdField_u_of_type_Int = a(getChildAt(0), jdField_b_of_type_AndroidGraphicsRect).left;
        this.jdField_v_of_type_Int = 0;
      }
      else
      {
        i1 = 0;
      }
    }
  }
  
  private void i()
  {
    if (getChildCount() >= 2) {}
    for (;;)
    {
      return;
      int i3 = this.jdField_a_of_type_Int;
      int i4 = getPaddingLeft();
      int i5 = this.jdField_q_of_type_Int;
      View localView = getChildAt(0);
      int i1;
      int i2;
      if (localView != null)
      {
        i1 = this.mFirstPosition - 1;
        i2 = a(localView, jdField_b_of_type_AndroidGraphicsRect).left - i3;
      }
      while ((i2 > i4) && (i1 >= 0))
      {
        a(i1, i1 - this.mSelectedPosition, i2, false, null);
        if (this.jdField_a_of_type_Bkkt != null) {
          this.jdField_a_of_type_Bkkt.a(i1);
        }
        this.mFirstPosition = i1;
        i2 -= i5 + i3;
        i1 -= 1;
        continue;
        i2 = getRight() - getLeft() - getPaddingRight();
        this.jdField_a_of_type_Boolean = true;
        i1 = 0;
      }
    }
  }
  
  private void j()
  {
    int i1 = getChildCount();
    if (i1 >= 2) {}
    for (;;)
    {
      return;
      int i3 = this.jdField_a_of_type_Int;
      int i4 = getRight();
      int i5 = getLeft();
      int i6 = getPaddingRight();
      int i7 = this.jdField_q_of_type_Int;
      int i8 = this.mItemCount;
      View localView = getChildAt(i1 - 1);
      int i2;
      if (localView != null)
      {
        i1 = this.mFirstPosition + i1;
        i2 = a(localView, jdField_b_of_type_AndroidGraphicsRect).right + i3;
      }
      while ((i2 < i4 - i5 - i6) && (i1 < i8))
      {
        a(i1, i1 - this.mSelectedPosition, i2, true, null);
        if (this.jdField_a_of_type_Bkkt != null) {
          this.jdField_a_of_type_Bkkt.a(i1);
        }
        i2 += i7 + i3;
        i1 += 1;
        continue;
        i1 = this.mItemCount - 1;
        this.mFirstPosition = i1;
        i2 = getPaddingLeft();
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker != null)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
    }
  }
  
  private void m()
  {
    this.jdField_j_of_type_Int = -1;
    this.jdField_a_of_type_AndroidViewGestureDetector.setIsLongpressEnabled(true);
  }
  
  private void n()
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      getChildAt(i1).setPressed(false);
      i1 -= 1;
    }
    setPressed(false);
  }
  
  private void o()
  {
    View localView1 = this.jdField_a_of_type_AndroidViewView;
    View localView2 = getChildAt(this.mSelectedPosition - this.mFirstPosition);
    this.jdField_a_of_type_AndroidViewView = localView2;
    if (localView2 == null) {}
    do
    {
      return;
      localView2.setSelected(true);
      localView2.setFocusable(true);
      if (hasFocus()) {
        localView2.requestFocus();
      }
    } while ((localView1 == null) || (localView1 == localView2));
    localView1.setSelected(false);
    localView1.setFocusable(false);
  }
  
  @TargetApi(11)
  protected float a(View paramView)
  {
    if (VersionUtils.isHoneycomb()) {
      return paramView.getScaleX();
    }
    return a(paramView).jdField_d_of_type_Float;
  }
  
  protected float a(View paramView, float paramFloat, int paramInt)
  {
    boolean bool = false;
    if (paramView.getTag(2131296418) != null) {
      bool = ((Boolean)paramView.getTag(2131296418)).booleanValue();
    }
    float f1 = paramFloat;
    if (this.jdField_g_of_type_Boolean)
    {
      f1 = paramFloat;
      if (!bool) {
        f1 = Math.min(1.0F, paramFloat);
      }
    }
    return f1;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i1 = getChildCount() - 1;
    while (i1 >= 0)
    {
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 0)
      {
        a(localView, jdField_b_of_type_AndroidGraphicsRect);
        if (jdField_b_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2)) {
          return i1 + this.mFirstPosition;
        }
      }
      i1 -= 1;
    }
    return -1;
  }
  
  int a(View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  protected int a(boolean paramBoolean, int paramInt)
  {
    int i2;
    int i1;
    if (paramBoolean)
    {
      i2 = this.jdField_q_of_type_Int - this.jdField_a_of_type_AndroidGraphicsRect.right - jdField_b_of_type_AndroidGraphicsRect.right;
      if (i2 > 0) {
        i1 = paramInt / 4;
      }
    }
    do
    {
      do
      {
        return i1;
        i1 = paramInt;
      } while (paramInt >= i2);
      return (paramInt - i2) / 4 + i2;
      i2 = this.jdField_a_of_type_AndroidGraphicsRect.left - jdField_b_of_type_AndroidGraphicsRect.left;
      if (i2 < 0) {
        return paramInt / 4;
      }
      i1 = paramInt;
    } while (paramInt <= i2);
    return (paramInt - i2) / 4 + i2;
  }
  
  protected int a(boolean paramBoolean, int paramInt1, int paramInt2, Point paramPoint)
  {
    int i1;
    if (paramBoolean)
    {
      i1 = this.mItemCount - 1;
      if (paramInt2 >= 0) {
        break label113;
      }
    }
    View localView;
    label113:
    for (int i2 = 1;; i2 = 0)
    {
      localView = getChildAt(i1 - this.mFirstPosition);
      if ((localView != null) || (this.jdField_j_of_type_Int == 1) || (((!paramBoolean) || (!this.jdField_o_of_type_Boolean)) && ((paramBoolean) || (!this.jdField_n_of_type_Boolean)))) {
        break label180;
      }
      if ((this.jdField_j_of_type_Int != 0) && (Math.abs(paramInt1) <= Math.abs(paramInt2))) {
        break label119;
      }
      paramPoint.x = paramInt1;
      paramPoint.y = 0;
      this.jdField_j_of_type_Int = 0;
      return this.jdField_j_of_type_Int;
      i1 = 0;
      break;
    }
    label119:
    a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
    if (jdField_b_of_type_AndroidGraphicsRect.height() <= this.jdField_r_of_type_Int)
    {
      paramPoint.x = 0;
      paramPoint.y = 0;
      if (i2 == 0) {
        a();
      }
      return this.jdField_j_of_type_Int;
    }
    this.jdField_o_of_type_Boolean = false;
    this.jdField_n_of_type_Boolean = false;
    label180:
    if (this.jdField_j_of_type_Int != 0) {
      this.jdField_j_of_type_Int = 1;
    }
    if (((paramBoolean) && (!this.jdField_o_of_type_Boolean)) || ((!paramBoolean) && (!this.jdField_n_of_type_Boolean))) {
      localView = this.jdField_a_of_type_AndroidViewView;
    }
    for (;;)
    {
      a(localView, jdField_b_of_type_AndroidGraphicsRect);
      i1 = a(paramBoolean, paramInt1);
      this.jdField_h_of_type_Int += i1;
      this.jdField_i_of_type_Int += paramInt2;
      if (jdField_b_of_type_AndroidGraphicsRect.height() < this.jdField_r_of_type_Int)
      {
        a();
        paramInt1 = 0;
        if (i1 <= this.jdField_q_of_type_Int) {
          break label425;
        }
        paramInt2 = this.jdField_q_of_type_Int;
      }
      for (;;)
      {
        paramPoint.x = paramInt2;
        paramPoint.y = paramInt1;
        return this.jdField_j_of_type_Int;
        if (i2 != 0)
        {
          i2 = this.jdField_r_of_type_Int - this.jdField_a_of_type_AndroidGraphicsRect.bottom - jdField_b_of_type_AndroidGraphicsRect.bottom;
          if (i2 > 0)
          {
            paramInt1 = paramInt2 / 4;
            break;
          }
          paramInt1 = paramInt2;
          if (i1 >= i2) {
            break;
          }
          paramInt1 = (paramInt2 - i2) / 6 + i2;
          break;
        }
        i2 = this.jdField_a_of_type_AndroidGraphicsRect.top - jdField_b_of_type_AndroidGraphicsRect.top;
        if (i2 < 0)
        {
          paramInt1 = paramInt2 / 4;
          a();
          break;
        }
        paramInt1 = paramInt2;
        if (i1 <= i2) {
          break;
        }
        paramInt1 = (paramInt2 - i2) / 6 + i2;
        break;
        label425:
        if (i1 < -this.jdField_q_of_type_Int) {
          paramInt2 = -this.jdField_q_of_type_Int;
        } else {
          paramInt2 = i1;
        }
      }
    }
  }
  
  public Matrix a(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    if (VersionUtils.isHoneycomb()) {
      return paramView.getMatrix();
    }
    return bkkv.a(a(paramView));
  }
  
  @TargetApi(11)
  protected Rect a(View paramView, Rect paramRect)
  {
    if (paramView == null) {
      paramView = new Rect();
    }
    do
    {
      return paramView;
      jdField_a_of_type_AndroidGraphicsRectF.set(0.0F, 0.0F, paramView.getWidth(), paramView.getHeight());
      a(paramView).mapRect(jdField_a_of_type_AndroidGraphicsRectF);
      jdField_a_of_type_AndroidGraphicsRectF.offset(paramView.getLeft(), paramView.getTop());
      jdField_a_of_type_AndroidGraphicsRectF.round(paramRect);
      paramView = paramRect;
    } while (paramRect.width() >= this.jdField_q_of_type_Int);
    int i1 = (this.jdField_q_of_type_Int - paramRect.width()) / 2;
    int i2 = this.jdField_q_of_type_Int;
    int i3 = paramRect.width();
    paramRect.set(paramRect.left - i1, paramRect.top, i2 - i3 - i1 + paramRect.right, paramRect.bottom);
    return paramRect;
  }
  
  protected void a() {}
  
  public void a(float paramFloat)
  {
    int i1 = getChildCount();
    if ((i1 == 0) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    View localView = getChildAt(0);
    float f2;
    if (i1 == 1)
    {
      f2 = a(this.jdField_a_of_type_AndroidViewView);
      if (this.jdField_a_of_type_AndroidViewView.getTag(2131296389) == null) {
        break label837;
      }
    }
    label274:
    label577:
    label834:
    label837:
    for (i1 = ((Integer)this.jdField_a_of_type_AndroidViewView.getTag(2131296389)).intValue();; i1 = 0)
    {
      float f1;
      label105:
      float f3;
      int i2;
      float f5;
      float f6;
      int i3;
      if ((this.jdField_a_of_type_AndroidViewView.getTag(2131296392) instanceof Float))
      {
        f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296392)).floatValue();
        f3 = b(this.jdField_a_of_type_AndroidViewView);
        i2 = b((int)f3, i1);
        f5 = c((int)f3, i2);
        f6 = i2 * 90;
        i3 = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
        int i4 = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
        int i5 = getMeasuredWidth();
        int i6 = getMeasuredHeight();
        if (paramFloat != 0.0F) {
          break label834;
        }
        if (i2 == i1) {
          break label497;
        }
        this.jdField_a_of_type_AndroidViewView.setTag(2131296389, Integer.valueOf(i2));
        bkku localbkku = a(i3, i4, i5, i6, this.jdField_a_of_type_AndroidViewView);
        f1 = localbkku.jdField_a_of_type_Float;
        this.jdField_a_of_type_AndroidViewView.setTag(2131296385, Float.valueOf(localbkku.jdField_a_of_type_Float));
        paramFloat = f1;
        if (this.jdField_a_of_type_Bkks != null)
        {
          this.jdField_a_of_type_Bkks.a(this.jdField_a_of_type_AndroidViewView, getSelectedItemPosition(), i2);
          paramFloat = f1;
        }
      }
      for (;;)
      {
        i2 = 0;
        i1 = 0;
        if ((f2 != paramFloat) || (f6 != f5))
        {
          a(this.jdField_a_of_type_AndroidViewView, paramFloat);
          b(this.jdField_a_of_type_AndroidViewView, f6);
          a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
          a(this.jdField_a_of_type_AndroidViewView, f2);
          b(this.jdField_a_of_type_AndroidViewView, f5);
          label344:
          if (jdField_b_of_type_AndroidGraphicsRect.right >= this.jdField_q_of_type_Int + this.jdField_a_of_type_AndroidGraphicsRect.left) {
            break label577;
          }
          i2 = this.jdField_q_of_type_Int + this.jdField_a_of_type_AndroidGraphicsRect.left - jdField_b_of_type_AndroidGraphicsRect.right;
          if (jdField_b_of_type_AndroidGraphicsRect.height() >= this.jdField_r_of_type_Int) {
            break label612;
          }
          i1 = this.jdField_a_of_type_AndroidGraphicsRect.top + (this.jdField_r_of_type_Int - jdField_b_of_type_AndroidGraphicsRect.height()) / 2 - jdField_b_of_type_AndroidGraphicsRect.top;
        }
        for (;;)
        {
          if ((f2 == paramFloat) && (f6 == f5)) {
            break label692;
          }
          this.jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable.a(i2, i1, f2, paramFloat, f5, f6);
          return;
          if (!(this.jdField_a_of_type_AndroidViewView.getTag(2131296385) instanceof Float)) {
            break;
          }
          f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
          break label105;
          label497:
          f3 = Math.min(f1, this.jdField_b_of_type_Float);
          float f4 = Math.max(f1, this.jdField_i_of_type_Float);
          if (Math.abs(f2 - f1) < 1.E-005D)
          {
            paramFloat = f1;
            break label274;
          }
          paramFloat = f3;
          if (f2 < f3) {
            break label274;
          }
          if (f2 > f4)
          {
            paramFloat = f4;
            break label274;
          }
          paramFloat = f2;
          break label274;
          a(localView, jdField_b_of_type_AndroidGraphicsRect);
          break label344;
          if (jdField_b_of_type_AndroidGraphicsRect.left <= this.jdField_a_of_type_AndroidGraphicsRect.left) {
            break label386;
          }
          i2 = this.jdField_a_of_type_AndroidGraphicsRect.left - jdField_b_of_type_AndroidGraphicsRect.left;
          break label386;
          label612:
          if (jdField_b_of_type_AndroidGraphicsRect.top > this.jdField_a_of_type_AndroidGraphicsRect.top) {
            i1 = this.jdField_a_of_type_AndroidGraphicsRect.top - jdField_b_of_type_AndroidGraphicsRect.top;
          } else if (jdField_b_of_type_AndroidGraphicsRect.bottom < this.jdField_r_of_type_Int + this.jdField_a_of_type_AndroidGraphicsRect.top) {
            i1 = this.jdField_r_of_type_Int + this.jdField_a_of_type_AndroidGraphicsRect.top - jdField_b_of_type_AndroidGraphicsRect.bottom;
          }
        }
        this.jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable.a(i2, i1);
        return;
        if (jdField_b_of_type_AndroidGraphicsRect.right + this.jdField_a_of_type_Int / 2 > this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_q_of_type_Int / 2)
        {
          a(localView, jdField_b_of_type_AndroidGraphicsRect);
          i1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
          i2 = this.jdField_q_of_type_Int;
          i3 = jdField_b_of_type_AndroidGraphicsRect.right;
          this.jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable.a(i1 + i2 - i3, 0);
          return;
        }
        a(localView, jdField_b_of_type_AndroidGraphicsRect);
        i1 = this.jdField_a_of_type_AndroidGraphicsRect.left;
        i2 = jdField_b_of_type_AndroidGraphicsRect.right;
        i3 = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable.a(i1 - i2 - i3, 0);
        return;
      }
    }
  }
  
  public void a(float paramFloat, boolean paramBoolean)
  {
    Object localObject;
    if ((!VersionUtils.isHoneycomb()) && ((this.jdField_a_of_type_AndroidViewView instanceof ImageView)))
    {
      localObject = ((ImageView)this.jdField_a_of_type_AndroidViewView).getDrawable();
      if ((!(localObject instanceof URLDrawable)) || (!(((URLDrawable)localObject).getCurrDrawable() instanceof GifDrawable))) {}
    }
    label150:
    label409:
    label415:
    label549:
    for (int i1 = 1;; i1 = 0)
    {
      float f1;
      float f2;
      int i5;
      int i6;
      if ((this.jdField_q_of_type_Boolean) && (i1 == 0))
      {
        this.jdField_n_of_type_Boolean = false;
        this.jdField_o_of_type_Boolean = false;
        f1 = 1.0F;
        if ((this.jdField_a_of_type_AndroidViewView == null) || (((this.jdField_a_of_type_AndroidViewView.getTag(2131296400) instanceof Boolean)) && (((Boolean)this.jdField_a_of_type_AndroidViewView.getTag(2131296400)).booleanValue()))) {
          return;
        }
        if (this.jdField_a_of_type_AndroidViewView.getTag(2131296392) != null)
        {
          f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296392)).floatValue();
          f2 = a(this.jdField_a_of_type_AndroidViewView);
          i5 = getMeasuredWidth();
          i6 = getMeasuredHeight();
          if (this.jdField_a_of_type_AndroidViewView.getTag(2131296389) == null) {
            break label596;
          }
        }
      }
      label305:
      label596:
      for (i1 = ((Integer)this.jdField_a_of_type_AndroidViewView.getTag(2131296389)).intValue();; i1 = 0)
      {
        int i2;
        label233:
        int i3;
        label250:
        int i4;
        if ((i1 == 1) || (i1 == 3))
        {
          i2 = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
          i1 = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
          if ((i2 > i5) || (i1 > i6)) {
            break label403;
          }
          i3 = 1;
          if (i1 < i2 * 3) {
            break label409;
          }
          i4 = 1;
          if (i3 == 0) {
            break label415;
          }
          f1 = this.jdField_i_of_type_Float;
          paramFloat = Math.min(paramFloat, f1);
          if (f2 >= paramFloat) {
            break label549;
          }
          if (!a()) {
            a(this.mSelectedPosition, this.jdField_a_of_type_AndroidViewView, this);
          }
          a(paramFloat);
        }
        for (;;)
        {
          this.jdField_q_of_type_Boolean = false;
          n();
          if (!this.jdField_p_of_type_Boolean) {
            break;
          }
          this.jdField_p_of_type_Boolean = false;
          this.jdField_k_of_type_Int = 0;
          if (!a()) {
            break;
          }
          e(true);
          return;
          if (this.jdField_a_of_type_AndroidViewView.getTag(2131296385) == null) {
            break label150;
          }
          f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
          break label150;
          i2 = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
          i1 = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
          break label233;
          i3 = 0;
          break label250;
          i4 = 0;
          break label262;
          if (i4 != 0)
          {
            f1 = Math.min(i5 / i2, this.jdField_i_of_type_Float);
            break label272;
          }
          localObject = a(this.jdField_a_of_type_AndroidViewView);
          i3 = ((Rect)localObject).right - ((Rect)localObject).left;
          i4 = ((Rect)localObject).bottom;
          int i7 = ((Rect)localObject).top;
          if (i3 < i5)
          {
            if (i3 * 1.5F >= i5)
            {
              f1 *= 2.0F;
              break label272;
            }
            f1 = i5 / i2;
            break label272;
          }
          if ((i4 - i7) * 1.5F >= i6)
          {
            f1 *= 2.0F;
            break label272;
          }
          f1 = i6 / i1;
          break label272;
          if (!a()) {
            break label305;
          }
          e(false);
          break label305;
          if (Gallery.FlingRunnable.a(this.jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable).a())
          {
            g();
            if (this.jdField_j_of_type_Int == 0) {
              this.jdField_j_of_type_Int = 2;
            }
          }
        }
      }
    }
  }
  
  protected void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((getChildCount() == 0) || ((paramInt1 == 0) && (paramInt2 == 0))) {
      return;
    }
    boolean bool;
    if (paramInt1 < 0)
    {
      bool = true;
      if (paramInt1 != 0) {
        break label109;
      }
      this.jdField_k_of_type_Int = 0;
      label32:
      if (!paramBoolean) {
        break label129;
      }
      a(bool, paramInt1, paramInt2, this.jdField_a_of_type_AndroidGraphicsPoint);
    }
    for (;;)
    {
      a(bool, paramInt1, this.jdField_a_of_type_AndroidGraphicsPoint, this.jdField_q_of_type_Int, this.jdField_a_of_type_AndroidGraphicsRect);
      paramInt1 = getChildCount() - 1;
      while (paramInt1 >= 0)
      {
        a(getChildAt(paramInt1), this.jdField_a_of_type_AndroidGraphicsPoint.x, 0);
        paramInt1 -= 1;
      }
      bool = false;
      break;
      label109:
      if (paramInt1 < 0)
      {
        this.jdField_k_of_type_Int = 1;
        break label32;
      }
      this.jdField_k_of_type_Int = 2;
      break label32;
      label129:
      this.jdField_a_of_type_AndroidGraphicsPoint.x = paramInt1;
      this.jdField_a_of_type_AndroidGraphicsPoint.y = paramInt2;
    }
    this.jdField_u_of_type_Int += this.jdField_a_of_type_AndroidGraphicsPoint.x;
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_j_of_type_Int != 0))
    {
      a(this.jdField_a_of_type_AndroidViewView, 0, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      this.jdField_v_of_type_Int += this.jdField_a_of_type_AndroidGraphicsPoint.y;
    }
    d(bool);
    if (this.jdField_a_of_type_AndroidViewView != null) {
      if (this.jdField_a_of_type_AndroidViewView.getParent() == null) {
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      if ((bool) && (this.jdField_o_of_type_Boolean)) {
        j();
      }
      for (;;)
      {
        this.jdField_a_of_type_Bkhl.a();
        if (paramInt1 != 0) {
          h();
        }
        onScrollChanged(0, 0, 0, 0);
        invalidate();
        return;
        paramInt1 = 0;
        break;
        if ((!bool) && (this.jdField_n_of_type_Boolean)) {
          i();
        }
      }
      paramInt1 = 0;
    }
  }
  
  protected void a(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  protected void a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean) {}
  
  protected void a(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData) {}
  
  protected void a(int paramInt, ViewGroup paramViewGroup, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_t_of_type_Boolean = paramBoolean;
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    View localView;
    int i1;
    int i2;
    Rect localRect;
    do
    {
      do
      {
        return;
        localView = this.jdField_a_of_type_AndroidViewView;
        i1 = getMeasuredWidth();
        i2 = getMeasuredHeight();
      } while ((i1 == 0) || (i2 == 0));
      localRect = new Rect();
      a(localView, localRect);
    } while (!localRect.intersect(0, 0, i1, i2));
    localRect.offset(-localView.getLeft(), -localView.getTop());
    a(localView).invert(this.jdField_a_of_type_AndroidGraphicsMatrix);
    Object localObject = new RectF(localRect);
    this.jdField_a_of_type_AndroidGraphicsMatrix.mapRect((RectF)localObject);
    ((RectF)localObject).round(localRect);
    jdField_b_of_type_AndroidGraphicsRect.set(0, 0, localView.getWidth(), localView.getHeight());
    localRect.intersect(jdField_b_of_type_AndroidGraphicsRect);
    float f1 = a(localView);
    localObject = new RegionDrawableData();
    ((RegionDrawableData)localObject).mImageArea = jdField_b_of_type_AndroidGraphicsRect;
    ((RegionDrawableData)localObject).mShowArea = localRect;
    ((RegionDrawableData)localObject).mScale = f1;
    ((RegionDrawableData)localObject).mState = paramInt;
    ((RegionDrawableData)localObject).mShowRegion = paramBoolean;
    ((RegionDrawableData)localObject).mScrollDirection = this.jdField_k_of_type_Int;
    if (this.jdField_a_of_type_AndroidViewView.getTag(2131296392) != null) {
      ((RegionDrawableData)localObject).mDefaultScale = ((Float)localView.getTag(2131296392)).floatValue();
    }
    for (;;)
    {
      a(this.mSelectedPosition, localView, (RegionDrawableData)localObject);
      return;
      if (localView.getTag(2131296385) != null) {
        ((RegionDrawableData)localObject).mDefaultScale = ((Float)localView.getTag(2131296385)).floatValue();
      }
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, Point paramPoint, int paramInt2, Rect paramRect) {}
  
  protected boolean a()
  {
    if (!VersionUtils.isHoneycomb()) {}
    while ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_a_of_type_AndroidViewView.getWidth() * this.jdField_a_of_type_AndroidViewView.getHeight() < this.jdField_s_of_type_Int * this.jdField_t_of_type_Int << 2)) {
      return false;
    }
    return true;
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_n_of_type_Boolean = false;
    this.jdField_o_of_type_Boolean = false;
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag(2131296385);
    if ((localObject == null) || (!(localObject instanceof Float))) {
      return false;
    }
    float f1 = ((Float)localObject).floatValue();
    float f2 = a(this.jdField_a_of_type_AndroidViewView);
    if ((f2 < f1) || ((Math.abs(f2 - f1) < 1.E-005D) && (!paramBoolean))) {
      return false;
    }
    a(f1 * this.jdField_b_of_type_Float);
    return true;
  }
  
  protected void b(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  void b(int paramInt, boolean paramBoolean)
  {
    Object localObject = null;
    if (this.mDataChanged) {
      handleDataChanged();
    }
    if (this.mItemCount == 0)
    {
      b();
      return;
    }
    paramInt = getChildCount();
    int i1 = this.mSelectedPosition - this.mFirstPosition;
    if ((i1 >= 0) && (i1 < paramInt)) {}
    for (View localView = getChildAt(i1);; localView = null)
    {
      if (this.mNextSelectedPosition >= 0)
      {
        paramInt = this.mNextSelectedPosition;
        paramInt = this.mSelectedPosition;
      }
      if (this.mNextSelectedPosition >= 0) {
        setSelectedPositionInt(this.mNextSelectedPosition);
      }
      c();
      detachAllViewsFromParent();
      if (this.jdField_s_of_type_Boolean)
      {
        this.jdField_a_of_type_Bkhl.a();
        this.jdField_v_of_type_Int = 0;
        this.jdField_u_of_type_Int = 0;
        localView = null;
      }
      this.jdField_n_of_type_Int = 0;
      this.jdField_m_of_type_Int = 0;
      this.mFirstPosition = this.mSelectedPosition;
      if ((a().hasStableIds()) && (localView != null) && (this.mSelectedRowId == this.mOldSelectedRowId))
      {
        paramInt = 1;
        i1 = this.mSelectedPosition;
        int i2 = this.jdField_u_of_type_Int;
        if (paramInt != 0) {
          localObject = localView;
        }
        a(i1, 0, i2, true, localObject);
        if (this.jdField_u_of_type_Int >= 0) {
          break label282;
        }
        j();
        label215:
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_u_of_type_Int = 0;
          this.jdField_v_of_type_Int = 0;
        }
        if (!this.jdField_f_of_type_Boolean) {
          break label289;
        }
        this.jdField_a_of_type_Bkhl.b();
      }
      for (;;)
      {
        invalidate();
        checkSelectionChanged();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        o();
        return;
        paramInt = 0;
        break;
        label282:
        i();
        break label215;
        label289:
        this.jdField_a_of_type_Bkhl.a();
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_u_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  boolean c()
  {
    return false;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof Gallery.LayoutParams;
  }
  
  protected int computeHorizontalScrollExtent()
  {
    return 1;
  }
  
  protected int computeHorizontalScrollOffset()
  {
    return this.mSelectedPosition;
  }
  
  protected int computeHorizontalScrollRange()
  {
    return this.mItemCount;
  }
  
  public void d()
  {
    Object localObject;
    if ((!VersionUtils.isHoneycomb()) && ((this.jdField_a_of_type_AndroidViewView instanceof ImageView)))
    {
      localObject = ((ImageView)this.jdField_a_of_type_AndroidViewView).getDrawable();
      if ((!(localObject instanceof URLDrawable)) || (!(((URLDrawable)localObject).getCurrDrawable() instanceof GifDrawable))) {}
    }
    for (int i1 = 1;; i1 = 0)
    {
      float f1;
      float f2;
      if ((this.jdField_q_of_type_Boolean) && (i1 == 0))
      {
        this.jdField_n_of_type_Boolean = false;
        this.jdField_o_of_type_Boolean = false;
        f1 = 1.0F;
        if ((this.jdField_a_of_type_AndroidViewView == null) || (((this.jdField_a_of_type_AndroidViewView.getTag(2131296400) instanceof Boolean)) && (((Boolean)this.jdField_a_of_type_AndroidViewView.getTag(2131296400)).booleanValue()))) {
          return;
        }
        f2 = a(this.jdField_a_of_type_AndroidViewView);
        if (this.jdField_a_of_type_AndroidViewView.getTag(2131296392) != null) {
          if (b())
          {
            f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296414)).floatValue();
            if (Math.abs(f2 - f1) >= 1.E-005D) {
              break label768;
            }
            f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296392)).floatValue();
          }
        }
      }
      label768:
      for (;;)
      {
        if (Math.abs(f2 - f1) >= 1.E-005D)
        {
          if (f2 >= f1) {
            break label716;
          }
          if (!a()) {
            a(this.mSelectedPosition, this.jdField_a_of_type_AndroidViewView, this);
          }
          label235:
          a(f1);
          label240:
          this.jdField_q_of_type_Boolean = false;
          n();
          if (!this.jdField_p_of_type_Boolean) {
            break;
          }
          this.jdField_p_of_type_Boolean = false;
          this.jdField_k_of_type_Int = 0;
          if (!a()) {
            break;
          }
          e(true);
          return;
          f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296392)).floatValue();
          continue;
          if (this.jdField_a_of_type_AndroidViewView.getTag(2131296385) == null) {
            continue;
          }
          f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
          continue;
        }
        int i5 = getMeasuredWidth();
        int i6 = getMeasuredHeight();
        if (this.jdField_a_of_type_AndroidViewView.getTag(2131296389) != null) {}
        for (i1 = ((Integer)this.jdField_a_of_type_AndroidViewView.getTag(2131296389)).intValue();; i1 = 0)
        {
          int i2;
          label401:
          int i3;
          label417:
          int i4;
          if ((i1 == 1) || (i1 == 3))
          {
            i2 = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
            i1 = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
            if ((i2 > i5) || (i1 > i6)) {
              break label530;
            }
            i3 = 1;
            if (i1 < i2 * 3) {
              break label536;
            }
            i4 = 1;
            label428:
            if ((i3 == 0) || (((this.jdField_a_of_type_AndroidViewView.getTag(2131296417) instanceof Boolean)) && (((Boolean)this.jdField_a_of_type_AndroidViewView.getTag(2131296417)).booleanValue()))) {
              break label550;
            }
            if (this.jdField_a_of_type_AndroidViewView.getTag(2131296413) == null) {
              break label542;
            }
            f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296413)).floatValue();
          }
          for (;;)
          {
            f1 = Math.min(f1, this.jdField_i_of_type_Float);
            break;
            i2 = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
            i1 = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
            break label401;
            label530:
            i3 = 0;
            break label417;
            label536:
            i4 = 0;
            break label428;
            label542:
            f1 = this.jdField_i_of_type_Float;
            continue;
            label550:
            if (i4 != 0)
            {
              f1 = Math.min(i5 / i2, this.jdField_i_of_type_Float);
              if ((this.jdField_a_of_type_AndroidViewView.getTag(2131296416) instanceof Float)) {
                f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296416)).floatValue();
              }
            }
            else
            {
              localObject = a(this.jdField_a_of_type_AndroidViewView);
              i3 = ((Rect)localObject).right - ((Rect)localObject).left;
              i4 = ((Rect)localObject).bottom;
              int i7 = ((Rect)localObject).top;
              if (i3 < i5)
              {
                if (i3 * 1.5F >= i5) {
                  f1 = 2.0F * f1;
                } else {
                  f1 = i5 / i2;
                }
              }
              else if ((i4 - i7) * 1.5F >= i6) {
                f1 = 2.0F * f1;
              } else {
                f1 = i6 / i1;
              }
            }
          }
          label716:
          if (!a()) {
            break label235;
          }
          e(false);
          break label235;
          if (!Gallery.FlingRunnable.a(this.jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable).a()) {
            break label240;
          }
          g();
          if (this.jdField_j_of_type_Int != 0) {
            break label240;
          }
          this.jdField_j_of_type_Int = 2;
          break label240;
        }
      }
    }
  }
  
  boolean d()
  {
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return paramKeyEvent.dispatch(this, null, null);
  }
  
  protected void dispatchSetPressed(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setPressed(paramBoolean);
    }
  }
  
  public void dispatchSetSelected(boolean paramBoolean) {}
  
  public void e()
  {
    this.jdField_u_of_type_Int = 0;
  }
  
  public boolean e()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      return false;
    }
    float f1 = 1.0F;
    if (this.jdField_a_of_type_AndroidViewView.getTag(2131296392) != null)
    {
      f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296392)).floatValue();
      if (Math.abs(a(this.jdField_a_of_type_AndroidViewView) - f1) < 1.E-005D) {
        break label135;
      }
    }
    label135:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      if (this.jdField_a_of_type_AndroidViewView.getTag(2131296385) != null)
      {
        f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
        break;
      }
      if (!(this.jdField_a_of_type_AndroidViewView.getTag(2131296386) instanceof Float)) {
        break;
      }
      f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296386)).floatValue();
      break;
    }
  }
  
  void f()
  {
    d();
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new Gallery.LayoutParams(-2, -2);
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new Gallery.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new Gallery.LayoutParams(paramLayoutParams);
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    int i1 = this.mSelectedPosition - this.mFirstPosition;
    if (i1 < 0) {}
    do
    {
      return paramInt2;
      if (paramInt2 == paramInt1 - 1) {
        return i1;
      }
    } while (paramInt2 < i1);
    return paramInt2 + 1;
  }
  
  protected boolean getChildStaticTransformation(View paramView, Transformation paramTransformation)
  {
    paramView = (bkkv)paramView.getTag(2131296388);
    if (paramView != null)
    {
      a(paramView);
      paramTransformation.getMatrix().set(bkkv.a(paramView));
      return true;
    }
    return false;
  }
  
  protected ContextMenu.ContextMenuInfo getContextMenuInfo()
  {
    return this.jdField_a_of_type_Bkih;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (!this.jdField_u_of_type_Boolean) {}
    float f1;
    float f2;
    do
    {
      return true;
      this.jdField_q_of_type_Boolean = true;
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
    } while (this.jdField_a_of_type_AndroidViewView == null);
    a(f1, f2);
    return true;
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    if (this.jdField_j_of_type_Int == 2) {
      this.jdField_j_of_type_Int = 0;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable.a(false);
      this.jdField_o_of_type_Int = a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      if (this.jdField_o_of_type_Int >= 0)
      {
        this.jdField_b_of_type_AndroidViewView = getChildAt(this.jdField_o_of_type_Int - this.mFirstPosition);
        this.jdField_b_of_type_AndroidViewView.setPressed(true);
      }
      this.jdField_m_of_type_Boolean = true;
      this.jdField_h_of_type_Int = 0;
      this.jdField_i_of_type_Int = 0;
      a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
      if (jdField_b_of_type_AndroidGraphicsRect.width() != this.jdField_q_of_type_Int) {
        break;
      }
      this.jdField_o_of_type_Boolean = true;
      this.jdField_n_of_type_Boolean = true;
      return true;
      m();
    }
    if (jdField_b_of_type_AndroidGraphicsRect.left == 0) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_n_of_type_Boolean = bool1;
      bool1 = bool2;
      if (jdField_b_of_type_AndroidGraphicsRect.right == this.jdField_q_of_type_Int) {
        bool1 = true;
      }
      this.jdField_o_of_type_Boolean = bool1;
      return true;
    }
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      if (!this.jdField_k_of_type_Boolean) {
        this.jdField_k_of_type_Boolean = true;
      }
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
    paramFloat1 = this.jdField_a_of_type_AndroidViewVelocityTracker.getXVelocity();
    paramFloat2 = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity();
    int i1;
    int i2;
    label154:
    int i3;
    int i4;
    int i5;
    int i6;
    int i7;
    int i8;
    float f1;
    if (getChildCount() <= 1)
    {
      a(this.jdField_a_of_type_AndroidViewView, jdField_b_of_type_AndroidGraphicsRect);
      i1 = this.jdField_q_of_type_Int + this.jdField_a_of_type_AndroidGraphicsRect.left - jdField_b_of_type_AndroidGraphicsRect.right;
      i2 = this.jdField_a_of_type_AndroidGraphicsRect.left - jdField_b_of_type_AndroidGraphicsRect.left;
      if ((jdField_b_of_type_AndroidGraphicsRect.height() < this.jdField_r_of_type_Int) && (jdField_b_of_type_AndroidGraphicsRect.width() <= this.jdField_q_of_type_Int))
      {
        g();
        if (this.jdField_j_of_type_Int != 0) {
          break label693;
        }
        this.jdField_j_of_type_Int = 2;
        if (this.jdField_p_of_type_Boolean) {
          this.jdField_p_of_type_Boolean = false;
        }
        return true;
      }
      if (jdField_b_of_type_AndroidGraphicsRect.height() < this.jdField_r_of_type_Int)
      {
        i3 = this.jdField_a_of_type_AndroidGraphicsRect.top;
        i4 = (this.jdField_r_of_type_Int - jdField_b_of_type_AndroidGraphicsRect.bottom + jdField_b_of_type_AndroidGraphicsRect.top) / 2;
        i5 = jdField_b_of_type_AndroidGraphicsRect.top;
        i6 = this.jdField_r_of_type_Int;
        i7 = (this.jdField_r_of_type_Int - jdField_b_of_type_AndroidGraphicsRect.bottom + jdField_b_of_type_AndroidGraphicsRect.top) / 2;
        i8 = jdField_b_of_type_AndroidGraphicsRect.bottom;
        f1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
        if (f1 <= this.jdField_a_of_type_Float) {
          break label707;
        }
        paramFloat1 = this.jdField_a_of_type_Float * paramFloat1 / f1;
        paramFloat2 = 0.0F;
      }
    }
    label693:
    label707:
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable.a((int)paramFloat1, (int)paramFloat2, i1, i2, i3 + i4 - i5, i6 - i7 - i8);
      break;
      i3 = this.jdField_r_of_type_Int;
      i4 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      i5 = jdField_b_of_type_AndroidGraphicsRect.bottom;
      i6 = this.jdField_a_of_type_AndroidGraphicsRect.top;
      i7 = jdField_b_of_type_AndroidGraphicsRect.top;
      f1 = (float)Math.sqrt(paramFloat1 * paramFloat1 + paramFloat2 * paramFloat2);
      if (f1 > this.jdField_a_of_type_Float)
      {
        paramFloat1 = paramFloat1 * this.jdField_a_of_type_Float / f1;
        paramFloat2 = paramFloat2 * this.jdField_a_of_type_Float / f1;
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable.a((int)paramFloat1, (int)paramFloat2, i1, i2, i3 + i4 - i5, i6 - i7);
        break;
        if (paramFloat1 < 0.0F)
        {
          i1 = a(getChildAt(1), jdField_b_of_type_AndroidGraphicsRect).left;
          a(getChildAt(0), jdField_b_of_type_AndroidGraphicsRect);
          if (i1 == 0) {
            return true;
          }
          if (this.jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable.a(i1, (int)paramFloat1) <= this.jdField_a_of_type_AndroidGraphicsRect.left)
          {
            this.jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable.a((int)paramFloat1, 0, this.jdField_a_of_type_AndroidGraphicsRect.left - i1, 2147483647, 0, 0);
            break;
          }
          if (paramFloat1 < -this.jdField_p_of_type_Int)
          {
            this.jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable.a(this.jdField_a_of_type_AndroidGraphicsRect.left - i1, 0);
            break;
          }
          g();
          break;
        }
        i1 = this.jdField_q_of_type_Int + this.jdField_a_of_type_AndroidGraphicsRect.left;
        i2 = a(getChildAt(0), jdField_b_of_type_AndroidGraphicsRect).right;
        if (i2 == i1) {
          return true;
        }
        if (this.jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable.a(i2, (int)paramFloat1) >= i1)
        {
          this.jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable.a((int)paramFloat1, 0, -2147483648, i1 - i2, 0, 0);
          break;
        }
        if (paramFloat1 > this.jdField_p_of_type_Int)
        {
          this.jdField_a_of_type_ComTencentWidgetGallery$FlingRunnable.a(i1 - i2, 0);
          break;
        }
        g();
        break;
        if (this.jdField_j_of_type_Int != 1) {
          break label154;
        }
        break label154;
      }
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_AndroidViewView.requestFocus(paramInt);
      this.jdField_a_of_type_AndroidViewView.setSelected(true);
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_w_of_type_Boolean;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
      do
      {
        do
        {
          return bool;
        } while (!c());
        playSoundEffect(1);
        return true;
      } while (!d());
      playSoundEffect(3);
      return true;
      this.jdField_l_of_type_Boolean = true;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    switch (paramInt)
    {
    default: 
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    if ((this.jdField_l_of_type_Boolean) && (this.mItemCount > 0))
    {
      b(this.jdField_a_of_type_AndroidViewView);
      postDelayed(new Gallery.2(this), ViewConfiguration.getPressedStateDuration());
      performItemClick(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getItemId(this.mSelectedPosition));
    }
    this.jdField_l_of_type_Boolean = false;
    return true;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    float f1 = getResources().getDisplayMetrics().density;
    this.jdField_q_of_type_Int = (getRight() - getLeft() - this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_AndroidGraphicsRect.right);
    this.jdField_r_of_type_Int = (getBottom() - getTop() - this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_AndroidGraphicsRect.bottom);
    this.jdField_s_of_type_Int = ((int)Math.ceil(this.jdField_q_of_type_Int * f1));
    this.jdField_t_of_type_Int = ((int)Math.ceil(f1 * this.jdField_r_of_type_Int));
    this.mInLayout = true;
    b(0, false);
    this.mInLayout = false;
    this.jdField_s_of_type_Boolean = false;
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (this.jdField_r_of_type_Boolean) {
      return;
    }
    long l1 = getItemIdAtPosition(this.mSelectedPosition);
    a(this.jdField_b_of_type_AndroidViewView, this.mSelectedPosition, l1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getMode(paramInt2);
    if ((i1 == 1073741824) && (i2 == 1073741824))
    {
      setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  @TargetApi(11)
  public boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_j_of_type_Int == 0)) {
      return false;
    }
    float f1 = paramScaleGestureDetector.getFocusX();
    float f2 = paramScaleGestureDetector.getFocusY();
    float f3 = f1 - this.jdField_e_of_type_Float;
    float f4 = f2 - this.jdField_f_of_type_Float;
    this.jdField_e_of_type_Float = f1;
    this.jdField_f_of_type_Float = f2;
    if (VersionUtils.isHoneycomb())
    {
      a(this.jdField_a_of_type_AndroidViewView, (int)f3, (int)f4);
      a(f1, f2);
      f3 = paramScaleGestureDetector.getCurrentSpan() / this.jdField_g_of_type_Float;
      f2 = f3 * this.jdField_h_of_type_Float;
      if (this.jdField_a_of_type_AndroidViewView.getTag(2131296392) == null) {
        break label291;
      }
      f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296392)).floatValue();
      label127:
      if (f1 > 1.0F) {
        break label450;
      }
    }
    label151:
    label291:
    label445:
    label450:
    for (f1 = f1 * f1 * 0.6F * 0.6F;; f1 = 0.6F)
    {
      if (f2 < f1) {}
      for (;;)
      {
        a(this.jdField_a_of_type_AndroidViewView, f1);
        Boolean localBoolean = (Boolean)this.jdField_a_of_type_AndroidViewView.getTag(2131296390);
        if ((this.x) && (this.jdField_i_of_type_Boolean) && (localBoolean != null) && (localBoolean.booleanValue()))
        {
          if (!this.jdField_h_of_type_Boolean) {
            break label354;
          }
          f2 = (float)((a(paramScaleGestureDetector.getCurrentSpanX(), paramScaleGestureDetector.getCurrentSpanY()) - this.jdField_a_of_type_Double) / 3.141592653589793D * 180.0D);
          f1 = f2;
          if (f2 > 180.0F) {
            f1 = f2 - 360.0F;
          }
          b(this.jdField_a_of_type_AndroidViewView, f1 + this.jdField_d_of_type_Float);
        }
        for (;;)
        {
          return true;
          this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight((int)f3);
          this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom((int)f4);
          break;
          if (this.jdField_a_of_type_AndroidViewView.getTag(2131296385) != null)
          {
            f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
            break label127;
          }
          f1 = 1.0F;
          break label127;
          if (f2 <= this.jdField_i_of_type_Float * 1.5F) {
            break label445;
          }
          f1 = this.jdField_i_of_type_Float * 1.5F;
          break label151;
          label354:
          if (f3 <= 0.95F)
          {
            this.jdField_h_of_type_Boolean = true;
            f2 = (float)((a(paramScaleGestureDetector.getCurrentSpanX(), paramScaleGestureDetector.getCurrentSpanY()) - this.jdField_a_of_type_Double) / 3.141592653589793D * 180.0D);
            f1 = f2;
            if (f2 > 180.0F) {
              f1 = f2 - 360.0F;
            }
            b(this.jdField_a_of_type_AndroidViewView, f1 + this.jdField_d_of_type_Float);
          }
          else if (f3 >= 1.05F)
          {
            this.jdField_i_of_type_Boolean = false;
          }
        }
        f1 = f2;
      }
    }
  }
  
  @TargetApi(11)
  public boolean onScaleBegin(ScaleGestureDetector paramScaleGestureDetector)
  {
    this.jdField_h_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidViewView == null) || (this.jdField_j_of_type_Int == 0)) {}
    Drawable localDrawable;
    do
    {
      return false;
      if ((VersionUtils.isHoneycomb()) || (!(this.jdField_a_of_type_AndroidViewView instanceof ImageView))) {
        break;
      }
      localDrawable = ((ImageView)this.jdField_a_of_type_AndroidViewView).getDrawable();
    } while (((localDrawable instanceof URLDrawable)) && ((((URLDrawable)localDrawable).getCurrDrawable() instanceof GifDrawable)));
    this.jdField_a_of_type_Double = a(paramScaleGestureDetector.getCurrentSpanX(), paramScaleGestureDetector.getCurrentSpanY());
    this.jdField_d_of_type_Float = b(this.jdField_a_of_type_AndroidViewView);
    float f1 = 1.0F;
    if (this.jdField_a_of_type_AndroidViewView.getTag(2131296392) != null)
    {
      f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296392)).floatValue();
      label131:
      if (a(this.jdField_a_of_type_AndroidViewView) > f1 + 1.0E-005F) {
        break label315;
      }
    }
    label315:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_i_of_type_Boolean = bool;
      f1 = paramScaleGestureDetector.getFocusX();
      float f2 = paramScaleGestureDetector.getFocusY();
      this.jdField_n_of_type_Boolean = false;
      this.jdField_o_of_type_Boolean = false;
      a(f1, f2);
      this.jdField_e_of_type_Float = f1;
      this.jdField_f_of_type_Float = f2;
      this.jdField_g_of_type_Float = paramScaleGestureDetector.getCurrentSpan();
      this.jdField_h_of_type_Float = a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_d_of_type_Boolean = true;
      if (a()) {
        e(false);
      }
      return true;
      if ((this.jdField_a_of_type_AndroidViewView.getTag(2131296400) == null) || (!(this.jdField_a_of_type_AndroidViewView.getTag(2131296400) instanceof Boolean)) || (!((Boolean)this.jdField_a_of_type_AndroidViewView.getTag(2131296400)).booleanValue())) {
        break;
      }
      return false;
      if (this.jdField_a_of_type_AndroidViewView.getTag(2131296385) == null) {
        break label131;
      }
      f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
      break label131;
    }
  }
  
  public void onScaleEnd(ScaleGestureDetector paramScaleGestureDetector)
  {
    float f1;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      f1 = 1.0F;
      if (this.jdField_a_of_type_AndroidViewView.getTag(2131296392) == null) {
        break label85;
      }
      f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296392)).floatValue();
      float f2 = a(this.jdField_a_of_type_AndroidViewView);
      if ((f2 <= f1) || (f2 > this.jdField_i_of_type_Float)) {
        break label134;
      }
      if (!a()) {
        break label118;
      }
      e(true);
    }
    for (;;)
    {
      m();
      this.jdField_i_of_type_Boolean = true;
      return;
      label85:
      if (this.jdField_a_of_type_AndroidViewView.getTag(2131296385) == null) {
        break;
      }
      f1 = ((Float)this.jdField_a_of_type_AndroidViewView.getTag(2131296385)).floatValue();
      break;
      label118:
      a(this.mSelectedPosition, this.jdField_a_of_type_AndroidViewView, this);
      continue;
      label134:
      e(false);
    }
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    if (!this.jdField_b_of_type_Boolean) {
      if (this.jdField_m_of_type_Boolean)
      {
        if (!this.jdField_k_of_type_Boolean) {
          this.jdField_k_of_type_Boolean = true;
        }
        postDelayed(this.jdField_a_of_type_JavaLangRunnable, 250L);
      }
    }
    for (;;)
    {
      a((int)paramFloat1 * -1, (int)paramFloat2 * -1, true);
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_j_of_type_Int == 1) && (a()))
      {
        if (!this.jdField_p_of_type_Boolean) {
          this.jdField_p_of_type_Boolean = true;
        }
        a(true, 1);
      }
      this.jdField_m_of_type_Boolean = false;
      return true;
      if (this.jdField_k_of_type_Boolean) {
        this.jdField_k_of_type_Boolean = false;
      }
    }
  }
  
  public void onShowPress(MotionEvent paramMotionEvent) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidWidgetSpinnerAdapter != null)
    {
      performItemClick(this.jdField_b_of_type_AndroidViewView, this.mSelectedPosition, this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getItemId(this.mSelectedPosition));
      return true;
    }
    return false;
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_s_of_type_Boolean = true;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.mItemCount == 0) {
      return false;
    }
    k();
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    boolean bool;
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.jdField_r_of_type_Boolean = true;
      if (!this.jdField_t_of_type_Boolean) {
        break label136;
      }
      bool = this.jdField_a_of_type_AndroidViewScaleGestureDetector.onTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      int i1 = paramMotionEvent.getAction();
      if (i1 == 1)
      {
        d();
        l();
        this.jdField_d_of_type_Boolean = false;
      }
      for (;;)
      {
        if ((i1 & 0xFF) == 2) {
          this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
        }
        return bool;
        if (this.jdField_d_of_type_Boolean) {
          break label136;
        }
        this.jdField_r_of_type_Boolean = false;
        bool = this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
        break;
        if (i1 == 3)
        {
          f();
          l();
          this.jdField_d_of_type_Boolean = false;
        }
      }
      label136:
      bool = false;
    }
  }
  
  void selectionChanged()
  {
    if (!this.jdField_k_of_type_Boolean) {
      super.selectionChanged();
    }
  }
  
  public void setAdapter(SpinnerAdapter paramSpinnerAdapter)
  {
    super.setAdapter(paramSpinnerAdapter);
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void setAnimationDuration(int paramInt)
  {
    this.jdField_l_of_type_Int = paramInt;
  }
  
  public void setCallbackDuringFling(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setCallbackOnUnselectedItemClick(boolean paramBoolean)
  {
    this.jdField_j_of_type_Boolean = paramBoolean;
  }
  
  public void setClearByTag(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
  }
  
  public void setInterceptTouchEventReturn(boolean paramBoolean)
  {
    this.jdField_w_of_type_Boolean = paramBoolean;
  }
  
  public void setMaxScale(float paramFloat)
  {
    this.jdField_i_of_type_Float = paramFloat;
  }
  
  public void setOnItemRotateListener(bkks parambkks)
  {
    this.jdField_a_of_type_Bkks = parambkks;
  }
  
  public void setOnScollListener(bkkt parambkkt)
  {
    this.jdField_a_of_type_Bkkt = parambkkt;
  }
  
  public void setRotateEnable(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  void setSelectedPositionInt(int paramInt)
  {
    super.setSelectedPositionInt(paramInt);
    o();
  }
  
  public void setSelectionToNothing()
  {
    setSelectedPositionInt(-1);
    setNextSelectedPositionInt(-1);
    checkSelectionChanged();
  }
  
  public void setSpacing(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setSupportMatchParent(boolean paramBoolean)
  {
    this.jdField_v_of_type_Boolean = paramBoolean;
  }
  
  public boolean showContextMenu()
  {
    if ((isPressed()) && (this.mSelectedPosition >= 0)) {
      return a(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mSelectedRowId);
    }
    return false;
  }
  
  public boolean showContextMenuForChild(View paramView)
  {
    int i1 = getPositionForView(paramView);
    if (i1 < 0) {
      return false;
    }
    return a(paramView, i1, this.jdField_a_of_type_AndroidWidgetSpinnerAdapter.getItemId(i1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.Gallery
 * JD-Core Version:    0.7.0.1
 */