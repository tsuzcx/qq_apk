package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import arsb;
import arsd;
import arse;
import arsf;
import arsh;
import arsi;
import arsj;
import arsk;
import arsl;
import arsm;
import arsn;
import arso;
import arsp;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.widget.ProgressCircle;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;

public class DragSortListView
  extends XListView
{
  float jdField_a_of_type_Float;
  public int a;
  private long jdField_a_of_type_Long;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private View jdField_a_of_type_AndroidViewView;
  private arsf jdField_a_of_type_Arsf;
  private arsh jdField_a_of_type_Arsh;
  arsi jdField_a_of_type_Arsi = new arsd(this);
  private arsk jdField_a_of_type_Arsk;
  private arsl jdField_a_of_type_Arsl;
  private arsm jdField_a_of_type_Arsm;
  private arsn jdField_a_of_type_Arsn = new arsn(this, 3);
  private arso jdField_a_of_type_Arso;
  private arsp jdField_a_of_type_Arsp;
  private DragSortListView.DragScroller jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller;
  private DragSortListView.DropAnimator jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropAnimator;
  private DragSortListView.LiftAnimator jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LiftAnimator;
  private DragSortListView.RemoveAnimator jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveAnimator;
  boolean jdField_a_of_type_Boolean;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[1];
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  private Point jdField_b_of_type_AndroidGraphicsPoint = new Point();
  private boolean jdField_b_of_type_Boolean;
  float jdField_c_of_type_Float;
  public int c;
  private boolean jdField_c_of_type_Boolean;
  float jdField_d_of_type_Float;
  public int d;
  private boolean jdField_d_of_type_Boolean = true;
  public float e;
  public int e;
  private boolean e;
  float jdField_f_of_type_Float = 0.0F;
  int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private float jdField_g_of_type_Float = 1.0F;
  public int g;
  private boolean jdField_g_of_type_Boolean;
  private float jdField_h_of_type_Float = 1.0F;
  int jdField_h_of_type_Int = 1;
  private boolean jdField_h_of_type_Boolean;
  private float jdField_i_of_type_Float = 0.3333333F;
  public int i;
  private boolean jdField_i_of_type_Boolean;
  private float jdField_j_of_type_Float = 0.3333333F;
  int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean;
  private float jdField_k_of_type_Float = 0.25F;
  int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private float jdField_l_of_type_Float = 0.0F;
  public int l;
  private boolean jdField_l_of_type_Boolean;
  int jdField_m_of_type_Int = -1;
  private boolean jdField_m_of_type_Boolean;
  int jdField_n_of_type_Int;
  private boolean jdField_n_of_type_Boolean;
  private int jdField_o_of_type_Int;
  private boolean jdField_o_of_type_Boolean = true;
  private int jdField_p_of_type_Int;
  private boolean jdField_p_of_type_Boolean;
  private int jdField_q_of_type_Int;
  private boolean jdField_q_of_type_Boolean;
  private int r;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x;
  private int y = 0;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_g_of_type_Int = 0;
    this.jdField_e_of_type_Float = 0.5F;
    int i2 = 150;
    boolean bool1;
    int i1;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.DragSortListView, 0, 0);
      this.jdField_h_of_type_Int = Math.max(1, paramContext.getDimensionPixelSize(1, 1));
      this.jdField_h_of_type_Boolean = paramContext.getBoolean(17, false);
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_Arsk = new arsk(this);
      }
      this.jdField_g_of_type_Float = paramContext.getFloat(8, this.jdField_g_of_type_Float);
      this.jdField_h_of_type_Float = this.jdField_g_of_type_Float;
      this.jdField_d_of_type_Boolean = paramContext.getBoolean(2, this.jdField_d_of_type_Boolean);
      this.jdField_e_of_type_Boolean = paramContext.getBoolean(10, this.jdField_e_of_type_Boolean);
      this.jdField_k_of_type_Float = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(15, 0.75F)));
      if (this.jdField_k_of_type_Float > 0.0F)
      {
        bool1 = true;
        this.jdField_c_of_type_Boolean = bool1;
        setDragScrollStart(paramContext.getFloat(4, this.jdField_i_of_type_Float));
        this.jdField_e_of_type_Float = paramContext.getFloat(11, this.jdField_e_of_type_Float);
        i2 = paramContext.getInt(12, 150);
        i1 = paramContext.getInt(6, 150);
        if (paramContext.getBoolean(18, true))
        {
          bool1 = paramContext.getBoolean(13, false);
          int i3 = paramContext.getInt(14, 1);
          boolean bool2 = paramContext.getBoolean(16, true);
          int i4 = paramContext.getInt(5, 0);
          int i5 = paramContext.getResourceId(3, 0);
          int i6 = paramContext.getResourceId(7, 0);
          int i7 = paramContext.getResourceId(0, 0);
          int i8 = paramContext.getColor(9, -16777216);
          paramAttributeSet = new arsb(this, i5, i4, i3, i7, i6);
          paramAttributeSet.b(bool1);
          paramAttributeSet.a(bool2);
          paramAttributeSet.f(i8);
          this.jdField_a_of_type_Arsm = paramAttributeSet;
          super.setOnTouchListener(paramAttributeSet);
        }
        paramContext.recycle();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller = new DragSortListView.DragScroller(this);
      this.jdField_k_of_type_Boolean = true;
      if (i2 > 0) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveAnimator = new DragSortListView.RemoveAnimator(this, 0.5F, i2);
      }
      if (i1 > 0) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropAnimator = new DragSortListView.DropAnimator(this, 0.5F, i1);
      }
      this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
      this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new arse(this);
      return;
      bool1 = false;
      break;
      i1 = 150;
    }
  }
  
  private int a(int paramInt1, View paramView, int paramInt2, int paramInt3)
  {
    int i1 = b(paramInt1);
    int i4 = paramView.getHeight();
    int i5 = b(paramInt1, i1);
    int i2;
    if (paramInt1 != this.jdField_e_of_type_Int)
    {
      i2 = i4 - i1;
      i1 = i5 - i1;
    }
    for (;;)
    {
      int i6 = this.jdField_i_of_type_Int;
      int i3 = i6;
      if (this.jdField_e_of_type_Int != this.jdField_c_of_type_Int)
      {
        i3 = i6;
        if (this.jdField_e_of_type_Int != this.jdField_d_of_type_Int) {
          i3 = i6 - this.jdField_h_of_type_Int;
        }
      }
      if (paramInt1 <= paramInt2)
      {
        if (paramInt1 > this.jdField_c_of_type_Int) {
          return i3 - i1 + 0;
        }
      }
      else
      {
        if (paramInt1 == paramInt3)
        {
          if (paramInt1 <= this.jdField_c_of_type_Int) {
            return i2 - i3 + 0;
          }
          if (paramInt1 == this.jdField_d_of_type_Int) {
            return i4 - i5 + 0;
          }
          return 0 + i2;
        }
        if (paramInt1 <= this.jdField_c_of_type_Int) {
          return 0 - i3;
        }
        if (paramInt1 == this.jdField_d_of_type_Int) {
          return 0 - i1;
        }
      }
      return 0;
      i1 = i5;
      i2 = i4;
    }
  }
  
  private int a(int paramInt, View paramView, boolean paramBoolean)
  {
    int i1 = 0;
    if (paramInt == this.jdField_e_of_type_Int) {
      paramInt = i1;
    }
    View localView;
    label65:
    do
    {
      return paramInt;
      localView = paramView;
      if (paramInt >= getHeaderViewsCount()) {
        if (paramInt < getCount() - getFooterViewsCount()) {
          break label65;
        }
      }
      for (localView = paramView;; localView = ((ViewGroup)paramView).getChildAt(0))
      {
        paramView = localView.getLayoutParams();
        if ((paramView == null) || (paramView.height <= 0)) {
          break;
        }
        return paramView.height;
      }
      paramInt = localView.getHeight();
    } while ((paramInt != 0) && (!paramBoolean));
    a(localView);
    return localView.getMeasuredHeight();
  }
  
  private ImageView a(int paramInt)
  {
    paramInt -= getFirstVisiblePosition();
    if ((paramInt >= 0) && (paramInt <= getChildCount()))
    {
      View localView = super.getChildAt(paramInt);
      if (localView != null) {
        return (ImageView)localView.findViewById(2131365932);
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPoint.x = (paramInt1 - this.jdField_o_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPoint.y = (paramInt2 - this.jdField_f_of_type_Int);
    a(true);
    paramInt1 = Math.min(paramInt2, this.jdField_a_of_type_Int + this.jdField_j_of_type_Int);
    paramInt2 = Math.max(paramInt2, this.jdField_a_of_type_Int - this.jdField_j_of_type_Int);
    int i1 = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.a();
    if ((paramInt1 > this.jdField_l_of_type_Int) && (paramInt1 > this.t) && (i1 != 1))
    {
      if (i1 != -1) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.a(1);
    }
    do
    {
      return;
      if ((paramInt2 < this.jdField_l_of_type_Int) && (paramInt2 < this.s) && (i1 != 0))
      {
        if (i1 != -1) {
          this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.a(true);
        }
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.a(0);
        return;
      }
    } while ((paramInt2 < this.s) || (paramInt1 > this.t) || (!this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.a()));
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.a(true);
  }
  
  private void a(int paramInt, Canvas paramCanvas)
  {
    Drawable localDrawable = super.getDivider();
    int i4 = super.getDividerHeight();
    ViewGroup localViewGroup;
    int i2;
    int i3;
    int i1;
    if ((localDrawable != null) && (i4 != 0))
    {
      localViewGroup = (ViewGroup)super.getChildAt(paramInt - getFirstVisiblePosition());
      if (localViewGroup != null)
      {
        i2 = super.getPaddingLeft();
        i3 = super.getWidth() - super.getPaddingRight();
        i1 = localViewGroup.getChildAt(0).getHeight();
        if (paramInt <= this.jdField_e_of_type_Int) {
          break label128;
        }
        i1 += localViewGroup.getTop();
        paramInt = i1 + i4;
      }
    }
    for (;;)
    {
      paramCanvas.save();
      paramCanvas.clipRect(i2, i1, i3, paramInt);
      localDrawable.setBounds(i2, i1, i3, paramInt);
      localDrawable.draw(paramCanvas);
      paramCanvas.restore();
      return;
      label128:
      paramInt = localViewGroup.getBottom() - i1;
      i1 = paramInt - i4;
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 0)
    {
      this.v = this.u;
      this.jdField_l_of_type_Int = this.jdField_k_of_type_Int;
    }
    this.u = ((int)paramMotionEvent.getX());
    this.jdField_k_of_type_Int = ((int)paramMotionEvent.getY());
    if (i1 == 0)
    {
      this.v = this.u;
      this.jdField_l_of_type_Int = this.jdField_k_of_type_Int;
    }
    this.jdField_p_of_type_Int = ((int)paramMotionEvent.getRawX() - this.u);
    this.jdField_q_of_type_Int = ((int)paramMotionEvent.getRawY() - this.jdField_k_of_type_Int);
  }
  
  private void a(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null)
    {
      localObject = new AbsListView.LayoutParams(-1, -2);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int i2 = ViewGroup.getChildMeasureSpec(this.r, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    if (((ViewGroup.LayoutParams)localObject).height > 0) {}
    for (int i1 = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);; i1 = View.MeasureSpec.makeMeasureSpec(0, 0))
    {
      paramView.measure(i2, i1);
      return;
    }
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    paramView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    this.jdField_a_of_type_AndroidGraphicsRect.left = arrayOfInt[0];
    this.jdField_a_of_type_AndroidGraphicsRect.top = arrayOfInt[1];
    this.jdField_a_of_type_AndroidGraphicsRect.right += arrayOfInt[0];
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    int i1 = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
    paramView.bottom = (arrayOfInt[1] + i1);
    return this.jdField_a_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2);
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    getDividerHeight();
    int i1;
    int i2;
    int i3;
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_c_of_type_Int != this.jdField_d_of_type_Int))
    {
      i1 = 1;
      i2 = this.jdField_i_of_type_Int - this.jdField_h_of_type_Int;
      i3 = (int)(this.jdField_l_of_type_Float * i2);
      if (paramInt1 != this.jdField_e_of_type_Int) {
        break label123;
      }
      if (this.jdField_e_of_type_Int != this.jdField_c_of_type_Int) {
        break label90;
      }
      if (i1 == 0) {
        break label85;
      }
      i1 = i3 + this.jdField_h_of_type_Int;
    }
    label85:
    label90:
    label123:
    do
    {
      do
      {
        return i1;
        i1 = 0;
        break;
        return this.jdField_i_of_type_Int;
        if (this.jdField_e_of_type_Int == this.jdField_d_of_type_Int) {
          return this.jdField_i_of_type_Int - i3;
        }
        i1 = paramInt2;
      } while (this.jdField_g_of_type_Int == 0);
      return this.jdField_h_of_type_Int;
      if (paramInt1 == this.jdField_c_of_type_Int)
      {
        if (i1 != 0) {
          return paramInt2 + i3;
        }
        return paramInt2 + i2;
      }
      i1 = paramInt2;
    } while (paramInt1 != this.jdField_d_of_type_Int);
    return paramInt2 + i2 - i3;
  }
  
  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    return b(paramInt, a(paramInt, paramView, paramBoolean));
  }
  
  private void b(int paramInt)
  {
    this.jdField_g_of_type_Int = 1;
    if (this.jdField_a_of_type_Arsp != null) {
      this.jdField_a_of_type_Arsp.a(paramInt);
    }
    b();
    j();
    g();
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_g_of_type_Int = 3;
      return;
    }
    this.jdField_g_of_type_Int = 0;
  }
  
  private void b(int paramInt, View paramView, boolean paramBoolean)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    int i1;
    if ((paramInt != this.jdField_e_of_type_Int) && (paramInt != this.jdField_c_of_type_Int) && (paramInt != this.jdField_d_of_type_Int))
    {
      i1 = -2;
      if (i1 != localLayoutParams.height)
      {
        localLayoutParams.height = i1;
        paramView.setLayoutParams(localLayoutParams);
      }
      if ((paramInt == this.jdField_c_of_type_Int) || (paramInt == this.jdField_d_of_type_Int))
      {
        if (paramInt >= this.jdField_e_of_type_Int) {
          break label151;
        }
        ((DragSortItemView)paramView).setGravity(80);
      }
    }
    for (;;)
    {
      int i3 = paramView.getVisibility();
      int i2 = 0;
      i1 = i2;
      if (paramInt == this.jdField_e_of_type_Int)
      {
        i1 = i2;
        if (this.jdField_a_of_type_AndroidViewView != null) {
          i1 = 4;
        }
      }
      if (i1 != i3) {
        paramView.setVisibility(i1);
      }
      return;
      i1 = b(paramInt, paramView, paramBoolean);
      break;
      label151:
      if (paramInt > this.jdField_e_of_type_Int) {
        ((DragSortItemView)paramView).setGravity(48);
      }
    }
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (this.jdField_q_of_type_Boolean)
      {
        if (this.jdField_m_of_type_Boolean) {
          if (this.jdField_k_of_type_Boolean)
          {
            e();
            a(this.jdField_e_of_type_Int);
            this.jdField_m_of_type_Boolean = false;
          }
        }
        for (;;)
        {
          this.jdField_q_of_type_Boolean = false;
          return false;
          if (this.jdField_a_of_type_Arsp != null) {
            this.jdField_a_of_type_Arsp.a(this.jdField_e_of_type_Int);
          }
          this.jdField_m_of_type_Boolean = false;
          return false;
          d();
        }
      }
      Button localButton = (Button)a(this.jdField_n_of_type_Int, 2131380262);
      if ((this.jdField_n_of_type_Boolean) && (localButton != null))
      {
        this.jdField_n_of_type_Boolean = false;
        this.jdField_o_of_type_Boolean = true;
        return false;
      }
      if (!this.jdField_o_of_type_Boolean)
      {
        this.jdField_o_of_type_Boolean = true;
        return true;
      }
    }
    try
    {
      bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent)
    {
      for (;;)
      {
        paramMotionEvent.printStackTrace();
        boolean bool = false;
      }
    }
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = this.jdField_f_of_type_Boolean;
    this.jdField_f_of_type_Boolean = false;
    if (!bool1) {
      a(paramMotionEvent);
    }
    if (this.jdField_g_of_type_Int == 4)
    {
      a(paramMotionEvent);
      bool2 = true;
    }
    do
    {
      return bool2;
      bool1 = bool2;
      if (this.jdField_g_of_type_Int == 0)
      {
        bool1 = bool2;
        if (super.onTouchEvent(paramMotionEvent)) {
          bool1 = true;
        }
      }
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 2: 
      default: 
        bool2 = bool1;
      }
    } while (!bool1);
    this.y = 1;
    return bool1;
    k();
    return bool1;
  }
  
  private boolean d()
  {
    int i1 = super.getFirstVisiblePosition();
    int i2 = this.jdField_c_of_type_Int;
    View localView2 = super.getChildAt(i2 - i1);
    View localView1 = localView2;
    if (localView2 == null)
    {
      i2 = i1 + getChildCount() / 2;
      localView1 = super.getChildAt(i2 - i1);
    }
    int i6 = localView1.getTop();
    int i7 = localView1.getHeight();
    i1 = a(i2, i6);
    int i9 = super.getDividerHeight();
    int i3;
    int i4;
    int i5;
    label147:
    int i8;
    label200:
    float f2;
    if (this.jdField_a_of_type_Int < i1)
    {
      i3 = i1;
      i4 = i1;
      i1 = i3;
      i5 = i2;
      i2 = i5;
      i3 = i4;
      if (i5 >= 0)
      {
        i5 -= 1;
        i1 = a(i5);
        if (i5 == 0)
        {
          i1 = i6 - i9 - i1;
          i3 = i4;
          i2 = i5;
        }
      }
      else
      {
        i5 = super.getHeaderViewsCount();
        i8 = super.getFooterViewsCount();
        i6 = this.jdField_c_of_type_Int;
        i7 = this.jdField_d_of_type_Int;
        float f1 = this.jdField_l_of_type_Float;
        if (!this.jdField_c_of_type_Boolean) {
          break label629;
        }
        i9 = Math.abs(i1 - i3);
        if (this.jdField_a_of_type_Int >= i1) {
          break label555;
        }
        f2 = this.jdField_k_of_type_Float;
        i4 = (int)(i9 * (f2 * 0.5F));
        f2 = i4;
        i3 += i4;
        if (this.jdField_a_of_type_Int >= i3) {
          break label568;
        }
        this.jdField_c_of_type_Int = (i2 - 1);
        this.jdField_d_of_type_Int = i2;
        this.jdField_l_of_type_Float = ((i3 - this.jdField_a_of_type_Int) * 0.5F / f2);
        label267:
        if (this.jdField_c_of_type_Int >= i5) {
          break label644;
        }
        this.jdField_c_of_type_Int = i5;
        this.jdField_d_of_type_Int = i5;
        i2 = i5;
        label292:
        if ((this.jdField_c_of_type_Int == i6) && (this.jdField_d_of_type_Int == i7) && (this.jdField_l_of_type_Float == f1)) {
          break label687;
        }
      }
    }
    label555:
    label687:
    for (boolean bool = true;; bool = false)
    {
      if (i2 != this.jdField_b_of_type_Int)
      {
        if (this.jdField_a_of_type_Arsh != null) {
          this.jdField_a_of_type_Arsh.a(this.jdField_b_of_type_Int - i5, i2 - i5);
        }
        this.jdField_b_of_type_Int = i2;
        return true;
        i7 = i6 - (i1 + i9);
        i6 = a(i5, i7);
        i2 = i5;
        i3 = i4;
        i1 = i6;
        if (this.jdField_a_of_type_Int >= i6) {
          break label147;
        }
        i4 = i6;
        i1 = i6;
        i6 = i7;
        break;
        int i10 = getCount();
        i3 = i1;
        i5 = i1;
        i1 = i3;
        i4 = i2;
        for (;;)
        {
          i2 = i4;
          i3 = i5;
          if (i4 >= i10) {
            break;
          }
          if (i4 == i10 - 1)
          {
            i1 = i6 + i9 + i7;
            i2 = i4;
            i3 = i5;
            break;
          }
          i8 = i6 + (i9 + i7);
          i7 = a(i4 + 1);
          i6 = a(i4 + 1, i8);
          i2 = i4;
          i3 = i5;
          i1 = i6;
          if (this.jdField_a_of_type_Int < i6) {
            break;
          }
          i4 += 1;
          i5 = i6;
          i1 = i6;
          i6 = i8;
        }
        i4 = i3;
        i3 = i1;
        i1 = i4;
        break label200;
        label568:
        if (this.jdField_a_of_type_Int < i1 - i4)
        {
          this.jdField_c_of_type_Int = i2;
          this.jdField_d_of_type_Int = i2;
          break label267;
        }
        this.jdField_c_of_type_Int = i2;
        this.jdField_d_of_type_Int = (i2 + 1);
        this.jdField_l_of_type_Float = ((1.0F + (i1 - this.jdField_a_of_type_Int) / f2) * 0.5F);
        break label267;
        label629:
        this.jdField_c_of_type_Int = i2;
        this.jdField_d_of_type_Int = i2;
        break label267;
        if (this.jdField_d_of_type_Int < getCount() - i8) {
          break label292;
        }
        i2 = super.getCount() - i8 - 1;
        this.jdField_c_of_type_Int = i2;
        this.jdField_d_of_type_Int = i2;
        break label292;
      }
      return bool;
    }
  }
  
  private void g()
  {
    this.jdField_e_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_b_of_type_Int = -1;
  }
  
  private void h()
  {
    this.jdField_g_of_type_Int = 2;
    if ((this.jdField_a_of_type_Arsl != null) && (this.jdField_b_of_type_Int >= 0) && (this.jdField_b_of_type_Int < getCount()))
    {
      int i1 = getHeaderViewsCount();
      this.jdField_a_of_type_Arsl.a_(this.jdField_e_of_type_Int - i1, this.jdField_b_of_type_Int - i1);
    }
    b();
    j();
    g();
    m();
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_g_of_type_Int = 3;
      return;
    }
    this.jdField_g_of_type_Int = 0;
  }
  
  private void i()
  {
    b(this.jdField_e_of_type_Int - getHeaderViewsCount());
  }
  
  private void j()
  {
    int i1 = 0;
    int i2 = super.getFirstVisiblePosition();
    if (this.jdField_e_of_type_Int < i2)
    {
      View localView = super.getChildAt(0);
      if (localView != null) {
        i1 = localView.getTop();
      }
      super.setSelectionFromTop(i2 - 1, i1 - getPaddingTop());
    }
  }
  
  private void k()
  {
    this.y = 0;
    this.jdField_g_of_type_Boolean = false;
    if (this.jdField_g_of_type_Int == 3) {
      this.jdField_g_of_type_Int = 0;
    }
    this.jdField_h_of_type_Float = this.jdField_g_of_type_Float;
    this.jdField_l_of_type_Boolean = false;
    this.jdField_a_of_type_Arsn.a();
  }
  
  private void l()
  {
    int i1 = getPaddingTop();
    int i2 = getHeight() - i1 - getPaddingBottom();
    float f1 = i2;
    this.jdField_b_of_type_Float = (i1 + this.jdField_i_of_type_Float * f1);
    float f2 = i1;
    this.jdField_a_of_type_Float = (f1 * (1.0F - this.jdField_j_of_type_Float) + f2);
    this.s = ((int)this.jdField_b_of_type_Float);
    this.t = ((int)this.jdField_a_of_type_Float);
    this.jdField_c_of_type_Float = (this.jdField_b_of_type_Float - i1);
    this.jdField_d_of_type_Float = (i1 + i2 - this.jdField_a_of_type_Float);
  }
  
  private void m()
  {
    int i2 = getFirstVisiblePosition();
    int i3 = getLastVisiblePosition();
    int i1 = Math.max(0, getHeaderViewsCount() - i2);
    i3 = Math.min(i3 - i2, getCount() - 1 - getFooterViewsCount() - i2);
    while (i1 <= i3)
    {
      View localView = getChildAt(i1);
      if (localView != null) {
        b(i2 + i1, localView, false);
      }
      i1 += 1;
    }
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      a(this.jdField_a_of_type_AndroidViewView);
      this.jdField_i_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
      this.jdField_j_of_type_Int = (this.jdField_i_of_type_Int / 2);
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_Arsm != null)
    {
      this.jdField_b_of_type_AndroidGraphicsPoint.set(this.u, this.jdField_k_of_type_Int);
      this.jdField_a_of_type_Arsm.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidGraphicsPoint, this.jdField_b_of_type_AndroidGraphicsPoint);
    }
    int i1 = this.jdField_a_of_type_AndroidGraphicsPoint.x;
    int i4 = this.jdField_a_of_type_AndroidGraphicsPoint.y;
    int i2 = getPaddingLeft();
    int i3;
    if (((this.x & 0x1) == 0) && (i1 > i2))
    {
      this.jdField_a_of_type_AndroidGraphicsPoint.x = i2;
      i2 = getHeaderViewsCount();
      i3 = getFooterViewsCount();
      int i5 = getFirstVisiblePosition();
      int i6 = getLastVisiblePosition();
      i1 = getPaddingTop();
      if (i5 < i2) {
        i1 = getChildAt(i2 - i5 - 1).getBottom();
      }
      i2 = i1;
      if ((this.x & 0x8) == 0)
      {
        i2 = i1;
        if (i5 <= this.jdField_e_of_type_Int) {
          i2 = Math.max(getChildAt(this.jdField_e_of_type_Int - i5).getTop(), i1);
        }
      }
      i1 = getHeight() - getPaddingBottom();
      if (i6 >= getCount() - i3 - 1) {
        i1 = getChildAt(getCount() - i3 - 1 - i5).getBottom();
      }
      i3 = i1;
      if ((this.x & 0x4) == 0)
      {
        i3 = i1;
        if (i6 >= this.jdField_e_of_type_Int) {
          i3 = Math.min(getChildAt(this.jdField_e_of_type_Int - i5).getBottom(), i1);
        }
      }
      if (i4 >= i2) {
        break label315;
      }
      this.jdField_a_of_type_AndroidGraphicsPoint.y = i2;
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = (this.jdField_a_of_type_AndroidGraphicsPoint.y + this.jdField_j_of_type_Int);
      return;
      if (((this.x & 0x2) != 0) || (i1 >= i2)) {
        break;
      }
      this.jdField_a_of_type_AndroidGraphicsPoint.x = i2;
      break;
      label315:
      if (this.jdField_i_of_type_Int + i4 > i3) {
        this.jdField_a_of_type_AndroidGraphicsPoint.y = (i3 - this.jdField_i_of_type_Int);
      }
    }
  }
  
  public int a(int paramInt)
  {
    View localView = super.getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null) {
      return localView.getHeight();
    }
    return b(paramInt, b(paramInt));
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    int i1 = super.getHeaderViewsCount();
    int i2 = super.getFooterViewsCount();
    if ((paramInt1 <= i1) || (paramInt1 >= getCount() - i2)) {
      return paramInt2;
    }
    i2 = super.getDividerHeight();
    int i4 = this.jdField_i_of_type_Int - this.jdField_h_of_type_Int;
    int i3 = b(paramInt1);
    int i5 = a(paramInt1);
    if (this.jdField_d_of_type_Int <= this.jdField_e_of_type_Int) {
      if ((paramInt1 == this.jdField_d_of_type_Int) && (this.jdField_c_of_type_Int != this.jdField_d_of_type_Int)) {
        if (paramInt1 == this.jdField_e_of_type_Int) {
          i1 = paramInt2 + i5 - this.jdField_i_of_type_Int;
        }
      }
    }
    while (paramInt1 <= this.jdField_e_of_type_Int)
    {
      return (this.jdField_i_of_type_Int - i2 - b(paramInt1 - 1)) / 2 + i1;
      i1 = i5 - i3 + paramInt2 - i4;
      continue;
      i1 = paramInt2;
      if (paramInt1 > this.jdField_d_of_type_Int)
      {
        i1 = paramInt2;
        if (paramInt1 <= this.jdField_e_of_type_Int)
        {
          i1 = paramInt2 - i4;
          continue;
          if ((paramInt1 > this.jdField_e_of_type_Int) && (paramInt1 <= this.jdField_c_of_type_Int))
          {
            i1 = paramInt2 + i4;
          }
          else
          {
            i1 = paramInt2;
            if (paramInt1 == this.jdField_d_of_type_Int)
            {
              i1 = paramInt2;
              if (this.jdField_c_of_type_Int != this.jdField_d_of_type_Int) {
                i1 = paramInt2 + (i5 - i3);
              }
            }
          }
        }
      }
    }
    return (i3 - i2 - this.jdField_i_of_type_Int) / 2 + i1;
  }
  
  public View a(int paramInt1, int paramInt2)
  {
    paramInt1 -= super.getFirstVisiblePosition();
    if ((paramInt1 >= 0) && (paramInt1 <= getChildCount()))
    {
      View localView = super.getChildAt(paramInt1);
      if (localView != null) {
        return localView.findViewById(paramInt2);
      }
    }
    return null;
  }
  
  public ShaderAnimLayout a(int paramInt)
  {
    paramInt -= super.getFirstVisiblePosition();
    if ((paramInt >= 0) && (paramInt <= super.getChildCount()))
    {
      View localView = super.getChildAt(paramInt);
      if (localView != null) {
        return (ShaderAnimLayout)localView.findViewById(2131377341);
      }
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_g_of_type_Int == 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.a(true);
      b();
      g();
      m();
      if (this.jdField_g_of_type_Boolean) {
        this.jdField_g_of_type_Int = 3;
      }
    }
    else
    {
      return;
    }
    this.jdField_g_of_type_Int = 0;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    a(paramInt, 0.0F);
  }
  
  public void a(int paramInt, float paramFloat)
  {
    if ((this.jdField_g_of_type_Int == 0) || (this.jdField_g_of_type_Int == 4))
    {
      if (this.jdField_g_of_type_Int == 0)
      {
        this.jdField_e_of_type_Int = (getHeaderViewsCount() + paramInt);
        this.jdField_c_of_type_Int = this.jdField_e_of_type_Int;
        this.jdField_d_of_type_Int = this.jdField_e_of_type_Int;
        this.jdField_b_of_type_Int = this.jdField_e_of_type_Int;
        View localView = super.getChildAt(this.jdField_e_of_type_Int - getFirstVisiblePosition());
        if (localView != null) {
          localView.setVisibility(4);
        }
      }
      this.jdField_g_of_type_Int = 1;
      this.jdField_f_of_type_Float = paramFloat;
      if (this.jdField_g_of_type_Boolean) {
        switch (this.y)
        {
        }
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveAnimator != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveAnimator.c();
      return;
      super.onTouchEvent(this.jdField_a_of_type_AndroidViewMotionEvent);
      continue;
      super.onInterceptTouchEvent(this.jdField_a_of_type_AndroidViewMotionEvent);
    }
    b(paramInt);
  }
  
  void a(int paramInt, View paramView, boolean paramBoolean)
  {
    this.jdField_i_of_type_Boolean = true;
    o();
    int i1 = this.jdField_c_of_type_Int;
    int i2 = this.jdField_d_of_type_Int;
    boolean bool = d();
    if (bool)
    {
      m();
      setSelectionFromTop(paramInt, a(paramInt, paramView, i1, i2) + paramView.getTop() - getPaddingTop());
      layoutChildren();
    }
    if ((bool) || (paramBoolean)) {
      invalidate();
    }
    this.jdField_i_of_type_Boolean = false;
  }
  
  void a(boolean paramBoolean)
  {
    int i1 = getFirstVisiblePosition();
    int i2 = getChildCount() / 2;
    View localView = getChildAt(getChildCount() / 2);
    if (localView == null) {
      return;
    }
    a(i1 + i2, localView, paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_l_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((!this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_Arsm == null)) {}
    View localView;
    do
    {
      return false;
      localView = this.jdField_a_of_type_Arsm.a(paramInt1);
    } while (localView == null);
    return a(paramInt1, localView, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = true;
    if ((this.jdField_g_of_type_Int != 0) || (!this.jdField_g_of_type_Boolean) || (this.jdField_a_of_type_AndroidViewView != null) || (paramView == null) || (!this.jdField_d_of_type_Boolean))
    {
      bool = false;
      return bool;
    }
    if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    paramInt1 = getHeaderViewsCount() + paramInt1;
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_g_of_type_Int = 4;
    this.x = 0;
    this.x |= paramInt2;
    this.jdField_a_of_type_AndroidViewView = paramView;
    n();
    this.jdField_o_of_type_Int = paramInt3;
    this.jdField_f_of_type_Int = paramInt4;
    this.w = this.jdField_k_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsPoint.x = (this.u - this.jdField_o_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPoint.y = (this.jdField_k_of_type_Int - this.jdField_f_of_type_Int);
    paramView = getChildAt(this.jdField_e_of_type_Int - getFirstVisiblePosition());
    if (paramView != null) {
      paramView.setVisibility(4);
    }
    if (this.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_Arsk.a();
    }
    switch (this.y)
    {
    }
    for (;;)
    {
      requestLayout();
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LiftAnimator == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LiftAnimator.c();
      return true;
      super.onTouchEvent(this.jdField_a_of_type_AndroidViewMotionEvent);
      continue;
      super.onInterceptTouchEvent(this.jdField_a_of_type_AndroidViewMotionEvent);
    }
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getAction();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      return true;
      if (this.jdField_g_of_type_Int == 4) {
        a();
      }
      k();
      continue;
      if (this.jdField_g_of_type_Int == 4) {
        a(false);
      }
      k();
      continue;
      a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    return b(paramBoolean, 0.0F);
  }
  
  public boolean a(boolean paramBoolean, float paramFloat)
  {
    this.jdField_a_of_type_Boolean = true;
    return b(paramBoolean, paramFloat);
  }
  
  public int b(int paramInt)
  {
    int i1 = 0;
    if (paramInt == this.jdField_e_of_type_Int) {}
    do
    {
      return i1;
      localObject = getChildAt(paramInt - getFirstVisiblePosition());
      if (localObject != null) {
        return a(paramInt, (View)localObject, false);
      }
      i2 = this.jdField_a_of_type_Arsn.a(paramInt);
      i1 = i2;
    } while (i2 != -1);
    Object localObject = getAdapter();
    i1 = ((ListAdapter)localObject).getItemViewType(paramInt);
    int i2 = ((ListAdapter)localObject).getViewTypeCount();
    if (i2 != this.jdField_a_of_type_ArrayOfAndroidViewView.length) {
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[i2];
    }
    if (i1 >= 0) {
      if (this.jdField_a_of_type_ArrayOfAndroidViewView[i1] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i1] = localObject;
      }
    }
    for (;;)
    {
      i1 = a(paramInt, (View)localObject, true);
      this.jdField_a_of_type_Arsn.a(paramInt, i1);
      return i1;
      localObject = ((ListAdapter)localObject).getView(paramInt, this.jdField_a_of_type_ArrayOfAndroidViewView[i1], this);
      continue;
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
    }
  }
  
  void b()
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_Arsm != null) {
        this.jdField_a_of_type_Arsm.a(this.jdField_a_of_type_AndroidViewView);
      }
      this.jdField_a_of_type_AndroidViewView = null;
      invalidate();
    }
  }
  
  public boolean b()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public boolean b(boolean paramBoolean, float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.a(true);
      if (paramBoolean) {
        a(this.jdField_e_of_type_Int - getHeaderViewsCount(), paramFloat);
      }
      for (;;)
      {
        if (this.jdField_h_of_type_Boolean) {
          this.jdField_a_of_type_Arsk.d();
        }
        return true;
        if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropAnimator != null) {
          this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropAnimator.c();
        } else {
          h();
        }
      }
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_q_of_type_Boolean) {}
    Object localObject;
    ProgressCircle localProgressCircle;
    do
    {
      do
      {
        return;
        localObject = a(this.jdField_e_of_type_Int);
      } while (localObject == null);
      ((ShaderAnimLayout)localObject).a();
      this.jdField_q_of_type_Boolean = true;
      localObject = (RelativeLayout)a(this.jdField_e_of_type_Int, 2131380263);
      localProgressCircle = (ProgressCircle)((RelativeLayout)localObject).findViewById(2131380264);
    } while ((((RelativeLayout)localObject).getVisibility() != 0) || (localProgressCircle.getVisibility() != 0));
    ((RelativeLayout)localObject).setVisibility(8);
    this.jdField_m_of_type_Int = this.jdField_e_of_type_Int;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.a();
  }
  
  public void d()
  {
    Object localObject = a(this.jdField_e_of_type_Int);
    if (localObject != null)
    {
      ((ShaderAnimLayout)localObject).e();
      this.jdField_q_of_type_Boolean = false;
      if (this.jdField_m_of_type_Int >= 0)
      {
        localObject = (RelativeLayout)a(this.jdField_m_of_type_Int, 2131380263);
        if ((localObject != null) && (((ProgressCircle)((RelativeLayout)localObject).findViewById(2131380264)).getVisibility() == 0)) {
          ((RelativeLayout)localObject).setVisibility(0);
        }
      }
    }
  }
  
  public void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    if (this.jdField_g_of_type_Int != 0)
    {
      if (this.jdField_c_of_type_Int != this.jdField_e_of_type_Int) {
        a(this.jdField_c_of_type_Int, paramCanvas);
      }
      if ((this.jdField_d_of_type_Int != this.jdField_c_of_type_Int) && (this.jdField_d_of_type_Int != this.jdField_e_of_type_Int)) {
        a(this.jdField_d_of_type_Int, paramCanvas);
      }
    }
    int i3;
    int i4;
    int i1;
    float f1;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      i3 = this.jdField_a_of_type_AndroidViewView.getWidth();
      i4 = this.jdField_a_of_type_AndroidViewView.getHeight();
      int i2 = this.jdField_a_of_type_AndroidGraphicsPoint.x;
      int i5 = getWidth();
      i1 = i2;
      if (i2 < 0) {
        i1 = -i2;
      }
      if (i1 >= i5) {
        break label216;
      }
      f1 = (i5 - i1) / i5;
    }
    label216:
    for (f1 *= f1;; f1 = 0.0F)
    {
      i1 = (int)(f1 * (255.0F * this.jdField_h_of_type_Float));
      paramCanvas.save();
      paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      paramCanvas.clipRect(0, 0, i3, i4);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, i3, i4, i1, 31);
      this.jdField_a_of_type_AndroidViewView.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
      return;
    }
  }
  
  public void e()
  {
    Object localObject = a(this.jdField_e_of_type_Int);
    if (localObject != null)
    {
      ((ShaderAnimLayout)localObject).g();
      this.jdField_q_of_type_Boolean = false;
      if (this.jdField_m_of_type_Int >= 0)
      {
        localObject = (RelativeLayout)a(this.jdField_m_of_type_Int, 2131380263);
        if (((ProgressCircle)((RelativeLayout)localObject).findViewById(2131380264)).getVisibility() == 0) {
          ((RelativeLayout)localObject).setVisibility(0);
        }
      }
    }
  }
  
  public void f()
  {
    if ((this.jdField_q_of_type_Boolean) && (VersionUtils.isOreo()) && (AppSetting.jdField_c_of_type_Boolean))
    {
      if (!this.jdField_k_of_type_Boolean) {
        break label49;
      }
      e();
      a(this.jdField_e_of_type_Int);
    }
    for (this.jdField_m_of_type_Boolean = false;; this.jdField_m_of_type_Boolean = false)
    {
      this.jdField_q_of_type_Boolean = false;
      return;
      label49:
      if (this.jdField_a_of_type_Arsp != null) {
        this.jdField_a_of_type_Arsp.a(this.jdField_e_of_type_Int);
      }
    }
  }
  
  public void layoutChildren()
  {
    super.layoutChildren();
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if ((this.jdField_a_of_type_AndroidViewView.isLayoutRequested()) && (!this.jdField_b_of_type_Boolean)) {
        n();
      }
      this.jdField_a_of_type_AndroidViewView.layout(0, 0, this.jdField_a_of_type_AndroidViewView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_Arsk.b();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1;
    int i2;
    boolean bool2;
    if (!this.jdField_d_of_type_Boolean)
    {
      i1 = (int)paramMotionEvent.getRawX();
      i2 = (int)paramMotionEvent.getRawY();
      if (this.jdField_q_of_type_Boolean)
      {
        paramMotionEvent = a(this.jdField_e_of_type_Int);
        if (paramMotionEvent == null) {
          bool2 = false;
        }
      }
    }
    do
    {
      return bool2;
      if (a(paramMotionEvent, i1, i2)) {
        this.jdField_m_of_type_Boolean = true;
      }
      do
      {
        for (;;)
        {
          return true;
          d();
          this.jdField_o_of_type_Boolean = false;
        }
        paramMotionEvent = (Button)a(this.jdField_n_of_type_Int, 2131380262);
        if (paramMotionEvent == null) {
          return false;
        }
      } while (!a(paramMotionEvent, i1, i2));
      this.jdField_n_of_type_Boolean = true;
      return false;
      i1 = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      ImageView localImageView = a(i1);
      if ((localImageView != null) && (a(localImageView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())))
      {
        if ((this.jdField_q_of_type_Boolean) && (this.jdField_e_of_type_Int != i1))
        {
          this.jdField_p_of_type_Boolean = false;
          return true;
        }
        this.jdField_e_of_type_Int = i1;
        this.jdField_p_of_type_Boolean = true;
        return true;
      }
      if (this.jdField_q_of_type_Boolean)
      {
        i1 = (int)paramMotionEvent.getRawX();
        i2 = (int)paramMotionEvent.getRawY();
        paramMotionEvent = a(this.jdField_e_of_type_Int);
        if (paramMotionEvent == null) {
          return false;
        }
        if (a(paramMotionEvent, i1, i2)) {
          this.jdField_m_of_type_Boolean = true;
        }
        return true;
      }
      a(paramMotionEvent);
      this.jdField_f_of_type_Boolean = true;
      i1 = paramMotionEvent.getAction() & 0xFF;
      if (i1 == 0)
      {
        if (this.jdField_g_of_type_Int != 0)
        {
          this.jdField_j_of_type_Boolean = true;
          return true;
        }
        this.jdField_g_of_type_Boolean = true;
      }
      if (this.jdField_a_of_type_AndroidViewView == null) {
        break label317;
      }
      bool1 = true;
      if (i1 == 1) {
        break;
      }
      bool2 = bool1;
    } while (i1 != 3);
    this.jdField_g_of_type_Boolean = false;
    return bool1;
    label317:
    if (super.onInterceptTouchEvent(paramMotionEvent)) {
      this.jdField_l_of_type_Boolean = true;
    }
    for (boolean bool1 = true;; bool1 = false) {
      switch (i1)
      {
      case 2: 
      default: 
        if (bool1) {
          this.y = 1;
        }
        break;
      case 1: 
      case 3: 
        k();
        break;
        this.y = 2;
        break;
      }
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (this.jdField_a_of_type_AndroidViewView.isLayoutRequested()) {
        n();
      }
      this.jdField_b_of_type_Boolean = true;
    }
    this.r = paramInt1;
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    l();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2 = 1;
    if (this.jdField_j_of_type_Boolean)
    {
      this.jdField_j_of_type_Boolean = false;
      return false;
    }
    if (!this.jdField_d_of_type_Boolean) {
      return b(paramMotionEvent);
    }
    if (paramMotionEvent.getAction() == 0)
    {
      if (this.jdField_p_of_type_Boolean)
      {
        if (this.jdField_q_of_type_Boolean)
        {
          if (this.jdField_a_of_type_Arso != null) {
            this.jdField_a_of_type_Arso.a(this.jdField_e_of_type_Int);
          }
          int i1 = i2;
          if (AppSetting.jdField_c_of_type_Boolean)
          {
            i1 = i2;
            if (System.currentTimeMillis() - this.jdField_a_of_type_Long < 300L) {
              i1 = 0;
            }
          }
          if (i1 != 0)
          {
            paramMotionEvent = a(this.jdField_e_of_type_Int);
            if (paramMotionEvent != null)
            {
              this.jdField_q_of_type_Boolean = false;
              paramMotionEvent.e();
            }
          }
        }
        for (;;)
        {
          this.jdField_p_of_type_Boolean = false;
          return false;
          if (this.jdField_a_of_type_Arso != null) {
            this.jdField_a_of_type_Arso.b(this.jdField_e_of_type_Int);
          }
          paramMotionEvent = a(this.jdField_e_of_type_Int);
          if (paramMotionEvent != null)
          {
            this.jdField_q_of_type_Boolean = true;
            paramMotionEvent.a();
            this.jdField_a_of_type_Long = System.currentTimeMillis();
          }
        }
      }
      if (this.jdField_q_of_type_Boolean)
      {
        if (this.jdField_m_of_type_Boolean) {
          if (!this.jdField_e_of_type_Boolean)
          {
            e();
            a(this.jdField_e_of_type_Int);
            this.jdField_m_of_type_Boolean = false;
          }
        }
        for (;;)
        {
          this.jdField_q_of_type_Boolean = false;
          return false;
          if (this.jdField_a_of_type_Arsp != null) {
            this.jdField_a_of_type_Arsp.a(this.jdField_e_of_type_Int);
          }
          this.jdField_m_of_type_Boolean = false;
          return false;
          d();
        }
      }
    }
    return c(paramMotionEvent);
  }
  
  public void requestLayout()
  {
    if (!this.jdField_i_of_type_Boolean) {
      super.requestLayout();
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (paramListAdapter != null)
    {
      this.jdField_a_of_type_Arsf = new arsf(this, paramListAdapter);
      paramListAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      if ((paramListAdapter instanceof arsl)) {
        setDropListener((arsl)paramListAdapter);
      }
      if ((paramListAdapter instanceof arsh)) {
        setDragListener((arsh)paramListAdapter);
      }
      if ((paramListAdapter instanceof arsp)) {
        setRemoveListener((arsp)paramListAdapter);
      }
    }
    for (;;)
    {
      super.setAdapter(this.jdField_a_of_type_Arsf);
      return;
      this.jdField_a_of_type_Arsf = null;
    }
  }
  
  public void setDelImmediately(boolean paramBoolean)
  {
    this.jdField_k_of_type_Boolean = paramBoolean;
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_q_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
  }
  
  public void setDragListener(arsh paramarsh)
  {
    this.jdField_a_of_type_Arsh = paramarsh;
  }
  
  public void setDragScrollProfile(arsi paramarsi)
  {
    if (paramarsi != null) {
      this.jdField_a_of_type_Arsi = paramarsi;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    setDragScrollStarts(paramFloat, paramFloat);
  }
  
  public void setDragScrollStarts(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 > 0.5F)
    {
      this.jdField_j_of_type_Float = 0.5F;
      if (paramFloat1 <= 0.5F) {
        break label46;
      }
    }
    label46:
    for (this.jdField_i_of_type_Float = 0.5F;; this.jdField_i_of_type_Float = paramFloat1)
    {
      if (getHeight() != 0) {
        l();
      }
      return;
      this.jdField_j_of_type_Float = paramFloat2;
      break;
    }
  }
  
  public void setDragSortListener(arsj paramarsj)
  {
    setDropListener(paramarsj);
    setDragListener(paramarsj);
    setRemoveListener(paramarsj);
  }
  
  public void setDropListener(arsl paramarsl)
  {
    this.jdField_a_of_type_Arsl = paramarsl;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.jdField_h_of_type_Float = paramFloat;
  }
  
  public void setFloatViewManager(arsm paramarsm)
  {
    this.jdField_a_of_type_Arsm = paramarsm;
  }
  
  public void setLeftEventListener(arso paramarso)
  {
    this.jdField_a_of_type_Arso = paramarso;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.jdField_e_of_type_Float = paramFloat;
  }
  
  public void setRemoveListener(arsp paramarsp)
  {
    this.jdField_a_of_type_Arsp = paramarsp;
  }
  
  public void setSrcPos(int paramInt)
  {
    this.jdField_e_of_type_Int = paramInt;
  }
  
  public void setTapPos(int paramInt)
  {
    this.jdField_n_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView
 * JD-Core Version:    0.7.0.1
 */