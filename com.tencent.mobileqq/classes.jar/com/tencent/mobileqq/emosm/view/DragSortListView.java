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
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.mobileqq.widget.ProgressCircle;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.util.VersionUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;

public class DragSortListView
  extends XListView
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver;
  Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private Rect jdField_a_of_type_AndroidGraphicsRect = null;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  private View jdField_a_of_type_AndroidViewView;
  private DragSortListView.AdapterWrapper jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$AdapterWrapper;
  private DragSortListView.DragListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragListener;
  DragSortListView.DragScrollProfile jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScrollProfile = new DragSortListView.1(this);
  private DragSortListView.DragScroller jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller;
  private DragSortListView.DragSortTracker jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragSortTracker;
  private DragSortListView.DropAnimator jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropAnimator;
  private DragSortListView.DropListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener;
  private DragSortListView.FloatViewManager jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager = null;
  private DragSortListView.HeightCache jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$HeightCache = new DragSortListView.HeightCache(this, 3);
  private DragSortListView.LeftEventListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LeftEventListener;
  private DragSortListView.LiftAnimator jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LiftAnimator;
  private DragSortListView.RemoveAnimator jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveAnimator;
  private DragSortListView.RemoveListener jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener;
  boolean jdField_a_of_type_Boolean;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView = new View[1];
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  private Point jdField_b_of_type_AndroidGraphicsPoint = new Point();
  private boolean jdField_b_of_type_Boolean = false;
  float jdField_c_of_type_Float;
  int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  float jdField_d_of_type_Float;
  int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = true;
  float jdField_e_of_type_Float = 0.5F;
  int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = false;
  float jdField_f_of_type_Float = 0.0F;
  int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = false;
  private float jdField_g_of_type_Float = 1.0F;
  int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean = false;
  private float jdField_h_of_type_Float = 1.0F;
  int jdField_h_of_type_Int = 1;
  private boolean jdField_h_of_type_Boolean = false;
  private float jdField_i_of_type_Float = 0.3333333F;
  int jdField_i_of_type_Int;
  private boolean jdField_i_of_type_Boolean = false;
  private float jdField_j_of_type_Float = 0.3333333F;
  int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean = false;
  private float jdField_k_of_type_Float = 0.25F;
  int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private float jdField_l_of_type_Float = 0.0F;
  int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean = false;
  int jdField_m_of_type_Int = -1;
  private boolean jdField_m_of_type_Boolean;
  int jdField_n_of_type_Int;
  private boolean jdField_n_of_type_Boolean;
  private int jdField_o_of_type_Int;
  private boolean jdField_o_of_type_Boolean = true;
  private int jdField_p_of_type_Int;
  private boolean jdField_p_of_type_Boolean;
  private int jdField_q_of_type_Int;
  private boolean jdField_q_of_type_Boolean = false;
  private int jdField_r_of_type_Int = 0;
  private boolean jdField_r_of_type_Boolean;
  private int s;
  private int t;
  private int u;
  private int v;
  private int w;
  private int x = 0;
  private int y = 0;
  
  public DragSortListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i1 = 150;
    int i2;
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.G, 0, 0);
      this.jdField_h_of_type_Int = Math.max(1, paramContext.getDimensionPixelSize(R.styleable.jdField_i_of_type_Int, 1));
      this.jdField_h_of_type_Boolean = paramContext.getBoolean(R.styleable.y, false);
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragSortTracker = new DragSortListView.DragSortTracker(this);
      }
      this.jdField_g_of_type_Float = paramContext.getFloat(R.styleable.jdField_p_of_type_Int, this.jdField_g_of_type_Float);
      this.jdField_h_of_type_Float = this.jdField_g_of_type_Float;
      this.jdField_d_of_type_Boolean = paramContext.getBoolean(R.styleable.jdField_j_of_type_Int, this.jdField_d_of_type_Boolean);
      this.jdField_e_of_type_Boolean = paramContext.getBoolean(R.styleable.jdField_r_of_type_Int, this.jdField_e_of_type_Boolean);
      this.jdField_k_of_type_Float = Math.max(0.0F, Math.min(1.0F, 1.0F - paramContext.getFloat(R.styleable.w, 0.75F)));
      boolean bool1;
      if (this.jdField_k_of_type_Float > 0.0F) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.jdField_c_of_type_Boolean = bool1;
      setDragScrollStart(paramContext.getFloat(R.styleable.jdField_l_of_type_Int, this.jdField_i_of_type_Float));
      this.jdField_e_of_type_Float = paramContext.getFloat(R.styleable.s, this.jdField_e_of_type_Float);
      i1 = paramContext.getInt(R.styleable.t, 150);
      i2 = paramContext.getInt(R.styleable.jdField_n_of_type_Int, 150);
      if (paramContext.getBoolean(R.styleable.z, true))
      {
        bool1 = paramContext.getBoolean(R.styleable.u, false);
        int i3 = paramContext.getInt(R.styleable.v, 1);
        boolean bool2 = paramContext.getBoolean(R.styleable.x, true);
        int i4 = paramContext.getInt(R.styleable.jdField_m_of_type_Int, 0);
        int i5 = paramContext.getResourceId(R.styleable.jdField_k_of_type_Int, 0);
        int i6 = paramContext.getResourceId(R.styleable.jdField_o_of_type_Int, 0);
        int i7 = paramContext.getResourceId(R.styleable.jdField_h_of_type_Int, 0);
        int i8 = paramContext.getColor(R.styleable.jdField_q_of_type_Int, -16777216);
        paramAttributeSet = new DragSortController(this, i5, i4, i3, i7, i6);
        paramAttributeSet.b(bool1);
        paramAttributeSet.a(bool2);
        paramAttributeSet.f(i8);
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager = paramAttributeSet;
        super.setOnTouchListener(paramAttributeSet);
      }
      paramContext.recycle();
    }
    else
    {
      i2 = 150;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller = new DragSortListView.DragScroller(this);
    this.jdField_k_of_type_Boolean = true;
    if (i1 > 0) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveAnimator = new DragSortListView.RemoveAnimator(this, 0.5F, i1);
    }
    if (i2 > 0) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropAnimator = new DragSortListView.DropAnimator(this, 0.5F, i2);
    }
    this.jdField_a_of_type_AndroidViewMotionEvent = MotionEvent.obtain(0L, 0L, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
    this.jdField_a_of_type_AndroidDatabaseDataSetObserver = new DragSortListView.2(this);
  }
  
  private int a(int paramInt1, View paramView, int paramInt2, int paramInt3)
  {
    int i2 = b(paramInt1);
    int i4 = paramView.getHeight();
    int i5 = b(paramInt1, i2);
    int i1;
    if (paramInt1 != this.jdField_e_of_type_Int)
    {
      i1 = i4 - i2;
      i2 = i5 - i2;
    }
    else
    {
      i1 = i4;
      i2 = i5;
    }
    int i6 = this.jdField_i_of_type_Int;
    int i7 = this.jdField_e_of_type_Int;
    int i3 = i6;
    if (i7 != this.jdField_c_of_type_Int)
    {
      i3 = i6;
      if (i7 != this.jdField_d_of_type_Int) {
        i3 = i6 - this.jdField_h_of_type_Int;
      }
    }
    i6 = 0;
    if (paramInt1 <= paramInt2)
    {
      paramInt2 = i6;
      if (paramInt1 > this.jdField_c_of_type_Int) {
        return 0 + (i3 - i2);
      }
    }
    else
    {
      if (paramInt1 == paramInt3)
      {
        if (paramInt1 <= this.jdField_c_of_type_Int) {
          i1 -= i3;
        }
        while (paramInt1 != this.jdField_d_of_type_Int) {
          return 0 + i1;
        }
        return 0 + (i4 - i5);
      }
      if (paramInt1 <= this.jdField_c_of_type_Int) {
        return 0 - i3;
      }
      paramInt2 = i6;
      if (paramInt1 == this.jdField_d_of_type_Int) {
        paramInt2 = 0 - i2;
      }
    }
    return paramInt2;
  }
  
  private int a(int paramInt, View paramView, boolean paramBoolean)
  {
    if (paramInt == this.jdField_e_of_type_Int) {
      return 0;
    }
    View localView = paramView;
    if (paramInt >= getHeaderViewsCount()) {
      if (paramInt >= getCount() - getFooterViewsCount()) {
        localView = paramView;
      } else {
        localView = ((ViewGroup)paramView).getChildAt(0);
      }
    }
    paramView = localView.getLayoutParams();
    if ((paramView != null) && (paramView.height > 0)) {
      return paramView.height;
    }
    paramInt = localView.getHeight();
    if ((paramInt == 0) || (paramBoolean))
    {
      a(localView);
      paramInt = localView.getMeasuredHeight();
    }
    return paramInt;
  }
  
  private ImageView a(int paramInt)
  {
    paramInt -= getFirstVisiblePosition();
    if ((paramInt >= 0) && (paramInt <= getChildCount()))
    {
      View localView = super.getChildAt(paramInt);
      if (localView != null) {
        return (ImageView)localView.findViewById(2131366168);
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    Point localPoint = this.jdField_a_of_type_AndroidGraphicsPoint;
    localPoint.x = (paramInt1 - this.jdField_o_of_type_Int);
    localPoint.y = (paramInt2 - this.jdField_f_of_type_Int);
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
      return;
    }
    if ((paramInt2 < this.jdField_l_of_type_Int) && (paramInt2 < this.s) && (i1 != 0))
    {
      if (i1 != -1) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.a(true);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.a(0);
      return;
    }
    if ((paramInt2 >= this.s) && (paramInt1 <= this.t) && (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.a())) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScroller.a(true);
    }
  }
  
  private void a(int paramInt, Canvas paramCanvas)
  {
    Drawable localDrawable = super.getDivider();
    int i4 = super.getDividerHeight();
    if ((localDrawable != null) && (i4 != 0))
    {
      ViewGroup localViewGroup = (ViewGroup)super.getChildAt(paramInt - getFirstVisiblePosition());
      if (localViewGroup != null)
      {
        int i2 = super.getPaddingLeft();
        int i3 = super.getWidth() - super.getPaddingRight();
        int i1 = localViewGroup.getChildAt(0).getHeight();
        if (paramInt > this.jdField_e_of_type_Int)
        {
          i1 = localViewGroup.getTop() + i1;
          paramInt = i4 + i1;
        }
        else
        {
          i1 = localViewGroup.getBottom() - i1;
          paramInt = i1;
          i1 -= i4;
        }
        paramCanvas.save();
        paramCanvas.clipRect(i2, i1, i3, paramInt);
        localDrawable.setBounds(i2, i1, i3, paramInt);
        localDrawable.draw(paramCanvas);
        paramCanvas.restore();
      }
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
    int i2 = ViewGroup.getChildMeasureSpec(this.jdField_r_of_type_Int, getListPaddingLeft() + getListPaddingRight(), ((ViewGroup.LayoutParams)localObject).width);
    int i1;
    if (((ViewGroup.LayoutParams)localObject).height > 0) {
      i1 = View.MeasureSpec.makeMeasureSpec(((ViewGroup.LayoutParams)localObject).height, 1073741824);
    } else {
      i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    }
    paramView.measure(i2, i1);
  }
  
  private boolean a(View paramView, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    }
    paramView.getDrawingRect(this.jdField_a_of_type_AndroidGraphicsRect);
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    paramView.left = arrayOfInt[0];
    paramView.top = arrayOfInt[1];
    paramView.right += arrayOfInt[0];
    paramView = this.jdField_a_of_type_AndroidGraphicsRect;
    paramView.bottom += arrayOfInt[1];
    return this.jdField_a_of_type_AndroidGraphicsRect.contains(paramInt1, paramInt2);
  }
  
  private int b(int paramInt1, int paramInt2)
  {
    getDividerHeight();
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_c_of_type_Int != this.jdField_d_of_type_Int)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i4 = this.jdField_i_of_type_Int;
    int i5 = this.jdField_h_of_type_Int;
    int i2 = i4 - i5;
    int i3 = (int)(this.jdField_l_of_type_Float * i2);
    int i6 = this.jdField_e_of_type_Int;
    if (paramInt1 == i6)
    {
      if (i6 == this.jdField_c_of_type_Int)
      {
        if (i1 != 0) {
          return i3 + i5;
        }
        return i4;
      }
      if (i6 == this.jdField_d_of_type_Int) {
        return i4 - i3;
      }
      if (this.jdField_g_of_type_Int == 0) {
        return paramInt2;
      }
      return i5;
    }
    if (paramInt1 == this.jdField_c_of_type_Int)
    {
      if (i1 != 0) {
        return paramInt2 + i3;
      }
      return paramInt2 + i2;
    }
    int i1 = paramInt2;
    if (paramInt1 == this.jdField_d_of_type_Int) {
      i1 = paramInt2 + i2 - i3;
    }
    return i1;
  }
  
  private int b(int paramInt, View paramView, boolean paramBoolean)
  {
    return b(paramInt, a(paramInt, paramView, paramBoolean));
  }
  
  private void b(int paramInt)
  {
    this.jdField_g_of_type_Int = 1;
    DragSortListView.RemoveListener localRemoveListener = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener;
    if (localRemoveListener != null) {
      localRemoveListener.a(paramInt);
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
    if ((paramInt != this.jdField_e_of_type_Int) && (paramInt != this.jdField_c_of_type_Int) && (paramInt != this.jdField_d_of_type_Int)) {
      i1 = -2;
    } else {
      i1 = b(paramInt, paramView, paramBoolean);
    }
    if (i1 != localLayoutParams.height)
    {
      localLayoutParams.height = i1;
      paramView.setLayoutParams(localLayoutParams);
    }
    if ((paramInt == this.jdField_c_of_type_Int) || (paramInt == this.jdField_d_of_type_Int))
    {
      i1 = this.jdField_e_of_type_Int;
      if (paramInt < i1) {
        ((DragSortItemView)paramView).setGravity(80);
      } else if (paramInt > i1) {
        ((DragSortItemView)paramView).setGravity(48);
      }
    }
    int i3 = paramView.getVisibility();
    int i2 = 0;
    int i1 = i2;
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
  }
  
  private boolean b(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (this.jdField_r_of_type_Boolean)
      {
        if (this.jdField_m_of_type_Boolean)
        {
          if (this.jdField_k_of_type_Boolean)
          {
            e();
            a(this.jdField_e_of_type_Int);
            this.jdField_m_of_type_Boolean = false;
          }
          else
          {
            paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener;
            if (paramMotionEvent != null) {
              paramMotionEvent.a(this.jdField_e_of_type_Int);
            }
            this.jdField_m_of_type_Boolean = false;
            return false;
          }
        }
        else {
          d();
        }
        this.jdField_r_of_type_Boolean = false;
        return false;
      }
      Button localButton = (Button)a(this.jdField_n_of_type_Int, 2131380216);
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
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent)
    {
      paramMotionEvent.printStackTrace();
    }
    return false;
  }
  
  private boolean c(MotionEvent paramMotionEvent)
  {
    boolean bool1 = this.jdField_f_of_type_Boolean;
    boolean bool2 = false;
    this.jdField_f_of_type_Boolean = false;
    if (!bool1) {
      a(paramMotionEvent);
    }
    int i1 = this.jdField_g_of_type_Int;
    if (i1 == 4)
    {
      a(paramMotionEvent);
      return true;
    }
    bool1 = bool2;
    if (i1 == 0)
    {
      bool1 = bool2;
      if (super.onTouchEvent(paramMotionEvent)) {
        bool1 = true;
      }
    }
    i1 = paramMotionEvent.getAction() & 0xFF;
    if ((i1 != 1) && (i1 != 3))
    {
      if (bool1)
      {
        this.y = 1;
        return bool1;
      }
    }
    else {
      k();
    }
    return bool1;
  }
  
  private boolean d()
  {
    int i1 = super.getFirstVisiblePosition();
    int i3 = this.jdField_c_of_type_Int;
    View localView = super.getChildAt(i3 - i1);
    Object localObject = localView;
    if (localView == null)
    {
      i3 = getChildCount() / 2 + i1;
      localObject = super.getChildAt(i3 - i1);
    }
    i1 = ((View)localObject).getTop();
    int i6 = ((View)localObject).getHeight();
    int i2 = a(i3, i1);
    int i7 = super.getDividerHeight();
    int i5;
    int i4;
    if (this.jdField_a_of_type_Int < i2)
    {
      for (;;)
      {
        i5 = i3;
        i4 = i2;
        if (i3 < 0) {
          break;
        }
        i3 -= 1;
        i4 = a(i3);
        if (i3 == 0)
        {
          i1 = i1 - i7 - i4;
          break label279;
        }
        i4 = i1 - (i4 + i7);
        i1 = a(i3, i4);
        if (this.jdField_a_of_type_Int >= i1) {
          break label279;
        }
        i2 = i1;
        i1 = i4;
      }
      i1 = i4;
      i3 = i5;
      i2 = i4;
    }
    else
    {
      i8 = getCount();
      for (;;)
      {
        i5 = i3;
        i4 = i2;
        if (i3 >= i8) {
          break;
        }
        if (i3 == i8 - 1)
        {
          i1 = i1 + i7 + i6;
          break label279;
        }
        i4 = i1 + (i6 + i7);
        i5 = i3 + 1;
        i6 = a(i5);
        i1 = a(i5, i4);
        if (this.jdField_a_of_type_Int < i1) {
          break label279;
        }
        i3 = i5;
        i2 = i1;
        i1 = i4;
      }
    }
    label279:
    i6 = super.getHeaderViewsCount();
    int i9 = super.getFooterViewsCount();
    boolean bool = false;
    i7 = this.jdField_c_of_type_Int;
    int i8 = this.jdField_d_of_type_Int;
    float f1 = this.jdField_l_of_type_Float;
    if (this.jdField_c_of_type_Boolean)
    {
      int i10 = Math.abs(i1 - i2);
      i5 = i1;
      i4 = i2;
      if (this.jdField_a_of_type_Int < i1)
      {
        i4 = i1;
        i5 = i2;
      }
      i1 = (int)(this.jdField_k_of_type_Float * 0.5F * i10);
      float f2 = i1;
      i2 = i5 + i1;
      i5 = this.jdField_a_of_type_Int;
      if (i5 < i2)
      {
        this.jdField_c_of_type_Int = (i3 - 1);
        this.jdField_d_of_type_Int = i3;
        this.jdField_l_of_type_Float = ((i2 - i5) * 0.5F / f2);
      }
      else if (i5 < i4 - i1)
      {
        this.jdField_c_of_type_Int = i3;
        this.jdField_d_of_type_Int = i3;
      }
      else
      {
        this.jdField_c_of_type_Int = i3;
        this.jdField_d_of_type_Int = (i3 + 1);
        this.jdField_l_of_type_Float = (((i4 - i5) / f2 + 1.0F) * 0.5F);
      }
    }
    else
    {
      this.jdField_c_of_type_Int = i3;
      this.jdField_d_of_type_Int = i3;
    }
    if (this.jdField_c_of_type_Int < i6)
    {
      this.jdField_c_of_type_Int = i6;
      this.jdField_d_of_type_Int = i6;
      i3 = i6;
    }
    else if (this.jdField_d_of_type_Int >= getCount() - i9)
    {
      i3 = super.getCount() - i9 - 1;
      this.jdField_c_of_type_Int = i3;
      this.jdField_d_of_type_Int = i3;
    }
    if ((this.jdField_c_of_type_Int != i7) || (this.jdField_d_of_type_Int != i8) || (this.jdField_l_of_type_Float != f1)) {
      bool = true;
    }
    i1 = this.jdField_b_of_type_Int;
    if (i3 != i1)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragListener;
      if (localObject != null) {
        ((DragSortListView.DragListener)localObject).a(i1 - i6, i3 - i6);
      }
      this.jdField_b_of_type_Int = i3;
      return true;
    }
    return bool;
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
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener != null)
    {
      int i1 = this.jdField_b_of_type_Int;
      if ((i1 >= 0) && (i1 < getCount()))
      {
        i1 = getHeaderViewsCount();
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener.a_(this.jdField_e_of_type_Int - i1, this.jdField_b_of_type_Int - i1);
      }
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
    int i2 = super.getFirstVisiblePosition();
    if (this.jdField_e_of_type_Int < i2)
    {
      int i1 = 0;
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
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$HeightCache.a();
  }
  
  private void l()
  {
    int i1 = getPaddingTop();
    int i2 = getHeight() - i1 - getPaddingBottom();
    float f2 = i2;
    float f1 = i1;
    this.jdField_b_of_type_Float = (this.jdField_i_of_type_Float * f2 + f1);
    this.jdField_a_of_type_Float = ((1.0F - this.jdField_j_of_type_Float) * f2 + f1);
    f2 = this.jdField_b_of_type_Float;
    this.s = ((int)f2);
    float f3 = this.jdField_a_of_type_Float;
    this.t = ((int)f3);
    this.jdField_c_of_type_Float = (f2 - f1);
    this.jdField_d_of_type_Float = (i1 + i2 - f3);
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
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      a(localView);
      this.jdField_i_of_type_Int = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
      this.jdField_j_of_type_Int = (this.jdField_i_of_type_Int / 2);
    }
  }
  
  private void o()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager != null)
    {
      this.jdField_b_of_type_AndroidGraphicsPoint.set(this.u, this.jdField_k_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_AndroidGraphicsPoint, this.jdField_b_of_type_AndroidGraphicsPoint);
    }
    int i1 = this.jdField_a_of_type_AndroidGraphicsPoint.x;
    int i4 = this.jdField_a_of_type_AndroidGraphicsPoint.y;
    int i2 = getPaddingLeft();
    if (((this.x & 0x1) == 0) && (i1 > i2)) {
      this.jdField_a_of_type_AndroidGraphicsPoint.x = i2;
    } else if (((this.x & 0x2) == 0) && (i1 < i2)) {
      this.jdField_a_of_type_AndroidGraphicsPoint.x = i2;
    }
    i2 = getHeaderViewsCount();
    int i3 = getFooterViewsCount();
    int i5 = getFirstVisiblePosition();
    int i6 = getLastVisiblePosition();
    i1 = getPaddingTop();
    if (i5 < i2) {
      i1 = getChildAt(i2 - i5 - 1).getBottom();
    }
    i2 = i1;
    int i7;
    if ((this.x & 0x8) == 0)
    {
      i7 = this.jdField_e_of_type_Int;
      i2 = i1;
      if (i5 <= i7) {
        i2 = Math.max(getChildAt(i7 - i5).getTop(), i1);
      }
    }
    i1 = getHeight() - getPaddingBottom();
    if (i6 >= getCount() - i3 - 1) {
      i1 = getChildAt(getCount() - i3 - 1 - i5).getBottom();
    }
    i3 = i1;
    if ((this.x & 0x4) == 0)
    {
      i7 = this.jdField_e_of_type_Int;
      i3 = i1;
      if (i6 >= i7) {
        i3 = Math.min(getChildAt(i7 - i5).getBottom(), i1);
      }
    }
    if (i4 < i2)
    {
      this.jdField_a_of_type_AndroidGraphicsPoint.y = i2;
    }
    else
    {
      i1 = this.jdField_i_of_type_Int;
      if (i4 + i1 > i3) {
        this.jdField_a_of_type_AndroidGraphicsPoint.y = (i3 - i1);
      }
    }
    this.jdField_a_of_type_Int = (this.jdField_a_of_type_AndroidGraphicsPoint.y + this.jdField_j_of_type_Int);
  }
  
  int a(int paramInt)
  {
    View localView = super.getChildAt(paramInt - getFirstVisiblePosition());
    if (localView != null) {
      return localView.getHeight();
    }
    return b(paramInt, b(paramInt));
  }
  
  int a(int paramInt1, int paramInt2)
  {
    int i2 = super.getHeaderViewsCount();
    int i3 = super.getFooterViewsCount();
    int i1 = paramInt2;
    if (paramInt1 > i2)
    {
      if (paramInt1 >= getCount() - i3) {
        return paramInt2;
      }
      i3 = super.getDividerHeight();
      i2 = this.jdField_i_of_type_Int - this.jdField_h_of_type_Int;
      int i4 = b(paramInt1);
      int i5 = a(paramInt1);
      i1 = this.jdField_d_of_type_Int;
      int i6 = this.jdField_e_of_type_Int;
      if (i1 <= i6)
      {
        if ((paramInt1 == i1) && (this.jdField_c_of_type_Int != i1))
        {
          if (paramInt1 == i6)
          {
            paramInt2 += i5;
            i1 = this.jdField_i_of_type_Int;
          }
          else
          {
            paramInt2 += i5 - i4;
            i1 = i2;
          }
        }
        else
        {
          i1 = paramInt2;
          if (paramInt1 <= this.jdField_d_of_type_Int) {
            break label212;
          }
          i1 = paramInt2;
          if (paramInt1 > this.jdField_e_of_type_Int) {
            break label212;
          }
          i1 = i2;
        }
        i1 = paramInt2 - i1;
      }
      else if ((paramInt1 > i6) && (paramInt1 <= this.jdField_c_of_type_Int))
      {
        i1 = paramInt2 + i2;
      }
      else
      {
        i2 = this.jdField_d_of_type_Int;
        i1 = paramInt2;
        if (paramInt1 == i2)
        {
          i1 = paramInt2;
          if (this.jdField_c_of_type_Int != i2) {
            i1 = paramInt2 + (i5 - i4);
          }
        }
      }
      label212:
      if (paramInt1 <= this.jdField_e_of_type_Int) {
        return i1 + (this.jdField_i_of_type_Int - i3 - b(paramInt1 - 1)) / 2;
      }
      i1 += (i4 - i3 - this.jdField_i_of_type_Int) / 2;
    }
    return i1;
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
        return (ShaderAnimLayout)localView.findViewById(2131377351);
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
      if (this.jdField_g_of_type_Boolean)
      {
        this.jdField_g_of_type_Int = 3;
        return;
      }
      this.jdField_g_of_type_Int = 0;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Boolean = false;
    a(paramInt, 0.0F);
  }
  
  public void a(int paramInt, float paramFloat)
  {
    int i1 = this.jdField_g_of_type_Int;
    if ((i1 == 0) || (i1 == 4))
    {
      if (this.jdField_g_of_type_Int == 0)
      {
        this.jdField_e_of_type_Int = (getHeaderViewsCount() + paramInt);
        i1 = this.jdField_e_of_type_Int;
        this.jdField_c_of_type_Int = i1;
        this.jdField_d_of_type_Int = i1;
        this.jdField_b_of_type_Int = i1;
        localObject = super.getChildAt(i1 - getFirstVisiblePosition());
        if (localObject != null) {
          ((View)localObject).setVisibility(4);
        }
      }
      this.jdField_g_of_type_Int = 1;
      this.jdField_f_of_type_Float = paramFloat;
      if (this.jdField_g_of_type_Boolean)
      {
        i1 = this.y;
        if (i1 != 1)
        {
          if (i1 == 2) {
            super.onInterceptTouchEvent(this.jdField_a_of_type_AndroidViewMotionEvent);
          }
        }
        else {
          super.onTouchEvent(this.jdField_a_of_type_AndroidViewMotionEvent);
        }
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveAnimator;
      if (localObject != null)
      {
        ((DragSortListView.RemoveAnimator)localObject).c();
        return;
      }
      b(paramInt);
    }
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
      i1 = a(paramInt, paramView, i1, i2);
      setSelectionFromTop(paramInt, paramView.getTop() + i1 - getPaddingTop());
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
    if (this.jdField_g_of_type_Boolean)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager;
      if (localObject == null) {
        return false;
      }
      localObject = ((DragSortListView.FloatViewManager)localObject).a(paramInt1);
      if (localObject == null) {
        return false;
      }
      return a(paramInt1, (View)localObject, paramInt2, paramInt3, paramInt4);
    }
    return false;
  }
  
  public boolean a(int paramInt1, View paramView, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_g_of_type_Int == 0) && (this.jdField_g_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView == null) && (paramView != null))
    {
      if (!this.jdField_d_of_type_Boolean) {
        return false;
      }
      if (getParent() != null) {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      paramInt1 += getHeaderViewsCount();
      this.jdField_c_of_type_Int = paramInt1;
      this.jdField_d_of_type_Int = paramInt1;
      this.jdField_e_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_g_of_type_Int = 4;
      this.x = 0;
      this.x = (paramInt2 | this.x);
      this.jdField_a_of_type_AndroidViewView = paramView;
      n();
      this.jdField_o_of_type_Int = paramInt3;
      this.jdField_f_of_type_Int = paramInt4;
      paramInt1 = this.jdField_k_of_type_Int;
      this.w = paramInt1;
      paramView = this.jdField_a_of_type_AndroidGraphicsPoint;
      paramView.x = (this.u - this.jdField_o_of_type_Int);
      paramView.y = (paramInt1 - this.jdField_f_of_type_Int);
      paramView = getChildAt(this.jdField_e_of_type_Int - getFirstVisiblePosition());
      if (paramView != null) {
        paramView.setVisibility(4);
      }
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragSortTracker.a();
      }
      paramInt1 = this.y;
      if (paramInt1 != 1)
      {
        if (paramInt1 == 2) {
          super.onInterceptTouchEvent(this.jdField_a_of_type_AndroidViewMotionEvent);
        }
      }
      else {
        super.onTouchEvent(this.jdField_a_of_type_AndroidViewMotionEvent);
      }
      requestLayout();
      paramView = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LiftAnimator;
      if (paramView != null) {
        paramView.c();
      }
      return true;
    }
    return false;
  }
  
  protected boolean a(MotionEvent paramMotionEvent)
  {
    paramMotionEvent.getAction();
    int i1 = paramMotionEvent.getAction() & 0xFF;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3) {
          return true;
        }
        if (this.jdField_g_of_type_Int == 4) {
          a();
        }
        k();
        return true;
      }
      a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      return true;
    }
    if (this.jdField_g_of_type_Int == 4) {
      a(false);
    }
    k();
    return true;
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
  
  int b(int paramInt)
  {
    if (paramInt == this.jdField_e_of_type_Int) {
      return 0;
    }
    Object localObject = getChildAt(paramInt - getFirstVisiblePosition());
    if (localObject != null) {
      return a(paramInt, (View)localObject, false);
    }
    int i1 = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$HeightCache.a(paramInt);
    if (i1 != -1) {
      return i1;
    }
    localObject = getAdapter();
    i1 = ((ListAdapter)localObject).getItemViewType(paramInt);
    int i2 = ((ListAdapter)localObject).getViewTypeCount();
    if (i2 != this.jdField_a_of_type_ArrayOfAndroidViewView.length) {
      this.jdField_a_of_type_ArrayOfAndroidViewView = new View[i2];
    }
    if (i1 >= 0)
    {
      View[] arrayOfView = this.jdField_a_of_type_ArrayOfAndroidViewView;
      if (arrayOfView[i1] == null)
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
        this.jdField_a_of_type_ArrayOfAndroidViewView[i1] = localObject;
      }
      else
      {
        localObject = ((ListAdapter)localObject).getView(paramInt, arrayOfView[i1], this);
      }
    }
    else
    {
      localObject = ((ListAdapter)localObject).getView(paramInt, null, this);
    }
    i1 = a(paramInt, (View)localObject, true);
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$HeightCache.a(paramInt, i1);
    return i1;
  }
  
  void b()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      ((View)localObject).setVisibility(8);
      localObject = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager;
      if (localObject != null) {
        ((DragSortListView.FloatViewManager)localObject).a(this.jdField_a_of_type_AndroidViewView);
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
      if (paramBoolean)
      {
        a(this.jdField_e_of_type_Int - getHeaderViewsCount(), paramFloat);
      }
      else
      {
        DragSortListView.DropAnimator localDropAnimator = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropAnimator;
        if (localDropAnimator != null) {
          localDropAnimator.c();
        } else {
          h();
        }
      }
      if (this.jdField_h_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragSortTracker.d();
      }
      return true;
    }
    return false;
  }
  
  public void c()
  {
    if (this.jdField_r_of_type_Boolean) {
      return;
    }
    Object localObject = a(this.jdField_e_of_type_Int);
    if (localObject != null)
    {
      ((ShaderAnimLayout)localObject).a();
      this.jdField_r_of_type_Boolean = true;
      localObject = (RelativeLayout)a(this.jdField_e_of_type_Int, 2131380217);
      if (localObject == null) {
        return;
      }
      ProgressCircle localProgressCircle = (ProgressCircle)((RelativeLayout)localObject).findViewById(2131380218);
      if ((((RelativeLayout)localObject).getVisibility() == 0) && (localProgressCircle.getVisibility() == 0))
      {
        ((RelativeLayout)localObject).setVisibility(8);
        this.jdField_m_of_type_Int = this.jdField_e_of_type_Int;
      }
    }
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
      this.jdField_r_of_type_Boolean = false;
      int i1 = this.jdField_m_of_type_Int;
      if (i1 >= 0)
      {
        localObject = (RelativeLayout)a(i1, 2131380217);
        if ((localObject != null) && (((ProgressCircle)((RelativeLayout)localObject).findViewById(2131380218)).getVisibility() == 0)) {
          ((RelativeLayout)localObject).setVisibility(0);
        }
      }
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    super.dispatchDraw(paramCanvas);
    int i1;
    if (this.jdField_g_of_type_Int != 0)
    {
      i1 = this.jdField_c_of_type_Int;
      if (i1 != this.jdField_e_of_type_Int) {
        a(i1, paramCanvas);
      }
      i1 = this.jdField_d_of_type_Int;
      if ((i1 != this.jdField_c_of_type_Int) && (i1 != this.jdField_e_of_type_Int)) {
        a(i1, paramCanvas);
      }
    }
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      int i3 = localView.getWidth();
      int i4 = this.jdField_a_of_type_AndroidViewView.getHeight();
      int i2 = this.jdField_a_of_type_AndroidGraphicsPoint.x;
      int i5 = getWidth();
      i1 = i2;
      if (i2 < 0) {
        i1 = -i2;
      }
      float f1;
      if (i1 < i5)
      {
        f1 = (i5 - i1) / i5;
        f1 *= f1;
      }
      else
      {
        f1 = 0.0F;
      }
      i1 = (int)(this.jdField_h_of_type_Float * 255.0F * f1);
      paramCanvas.save();
      paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y);
      paramCanvas.clipRect(0, 0, i3, i4);
      paramCanvas.saveLayerAlpha(0.0F, 0.0F, i3, i4, i1, 31);
      this.jdField_a_of_type_AndroidViewView.draw(paramCanvas);
      paramCanvas.restore();
      paramCanvas.restore();
    }
  }
  
  public void e()
  {
    Object localObject = a(this.jdField_e_of_type_Int);
    if (localObject != null)
    {
      ((ShaderAnimLayout)localObject).g();
      this.jdField_r_of_type_Boolean = false;
      int i1 = this.jdField_m_of_type_Int;
      if (i1 >= 0)
      {
        localObject = (RelativeLayout)a(i1, 2131380217);
        if (localObject == null) {
          return;
        }
        if (((ProgressCircle)((RelativeLayout)localObject).findViewById(2131380218)).getVisibility() == 0) {
          ((RelativeLayout)localObject).setVisibility(0);
        }
      }
    }
  }
  
  public void f()
  {
    if ((this.jdField_r_of_type_Boolean) && (VersionUtils.m()) && (AppSetting.jdField_d_of_type_Boolean))
    {
      if (this.jdField_k_of_type_Boolean)
      {
        e();
        a(this.jdField_e_of_type_Int);
        this.jdField_m_of_type_Boolean = false;
      }
      else
      {
        DragSortListView.RemoveListener localRemoveListener = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener;
        if (localRemoveListener != null) {
          localRemoveListener.a(this.jdField_e_of_type_Int);
        }
        this.jdField_m_of_type_Boolean = false;
      }
      this.jdField_r_of_type_Boolean = false;
    }
  }
  
  protected void layoutChildren()
  {
    super.layoutChildren();
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      if ((localView.isLayoutRequested()) && (!this.jdField_b_of_type_Boolean)) {
        n();
      }
      localView = this.jdField_a_of_type_AndroidViewView;
      localView.layout(0, 0, localView.getMeasuredWidth(), this.jdField_a_of_type_AndroidViewView.getMeasuredHeight());
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_h_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragSortTracker.b();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i2;
    if (!this.jdField_d_of_type_Boolean)
    {
      i1 = (int)paramMotionEvent.getRawX();
      i2 = (int)paramMotionEvent.getRawY();
      if (this.jdField_r_of_type_Boolean)
      {
        paramMotionEvent = a(this.jdField_e_of_type_Int);
        if (paramMotionEvent == null) {
          return false;
        }
        if (a(paramMotionEvent, i1, i2))
        {
          this.jdField_m_of_type_Boolean = true;
          return true;
        }
        d();
        this.jdField_o_of_type_Boolean = false;
        return true;
      }
      paramMotionEvent = (Button)a(this.jdField_n_of_type_Int, 2131380216);
      if (paramMotionEvent == null) {
        return false;
      }
      if (a(paramMotionEvent, i1, i2))
      {
        this.jdField_n_of_type_Boolean = true;
        return false;
      }
      return true;
    }
    int i1 = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
    ImageView localImageView = a(i1);
    if ((localImageView != null) && (a(localImageView, (int)paramMotionEvent.getRawX(), (int)paramMotionEvent.getRawY())))
    {
      if ((this.jdField_r_of_type_Boolean) && (this.jdField_e_of_type_Int != i1))
      {
        this.jdField_p_of_type_Boolean = false;
        return true;
      }
      this.jdField_e_of_type_Int = i1;
      this.jdField_p_of_type_Boolean = true;
      return true;
    }
    if (this.jdField_r_of_type_Boolean)
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
    boolean bool;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      bool = true;
    }
    else
    {
      if (super.onInterceptTouchEvent(paramMotionEvent))
      {
        this.jdField_l_of_type_Boolean = true;
        bool = true;
      }
      else
      {
        bool = false;
      }
      if ((i1 != 1) && (i1 != 3))
      {
        if (bool) {
          this.y = 1;
        } else {
          this.y = 2;
        }
      }
      else {
        k();
      }
    }
    if ((i1 == 1) || (i1 == 3)) {
      this.jdField_g_of_type_Boolean = false;
    }
    return bool;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      if (localView.isLayoutRequested()) {
        n();
      }
      this.jdField_b_of_type_Boolean = true;
    }
    this.jdField_r_of_type_Int = paramInt1;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    l();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
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
        boolean bool = this.jdField_r_of_type_Boolean;
        int i2 = 1;
        if (bool)
        {
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LeftEventListener;
          if (paramMotionEvent != null) {
            paramMotionEvent.a(this.jdField_e_of_type_Int);
          }
          int i1 = i2;
          if (AppSetting.jdField_d_of_type_Boolean)
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
              this.jdField_r_of_type_Boolean = false;
              paramMotionEvent.e();
            }
          }
        }
        else
        {
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LeftEventListener;
          if (paramMotionEvent != null) {
            paramMotionEvent.b(this.jdField_e_of_type_Int);
          }
          paramMotionEvent = a(this.jdField_e_of_type_Int);
          if (paramMotionEvent != null)
          {
            this.jdField_r_of_type_Boolean = true;
            paramMotionEvent.a();
            this.jdField_a_of_type_Long = System.currentTimeMillis();
          }
        }
        this.jdField_p_of_type_Boolean = false;
        return false;
      }
      if (this.jdField_r_of_type_Boolean)
      {
        if (this.jdField_m_of_type_Boolean)
        {
          if (!this.jdField_e_of_type_Boolean)
          {
            e();
            a(this.jdField_e_of_type_Int);
            this.jdField_m_of_type_Boolean = false;
          }
          else
          {
            paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener;
            if (paramMotionEvent != null) {
              paramMotionEvent.a(this.jdField_e_of_type_Int);
            }
            this.jdField_m_of_type_Boolean = false;
            return false;
          }
        }
        else {
          d();
        }
        this.jdField_r_of_type_Boolean = false;
        return false;
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
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$AdapterWrapper = new DragSortListView.AdapterWrapper(this, paramListAdapter);
      paramListAdapter.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
      if ((paramListAdapter instanceof DragSortListView.DropListener)) {
        setDropListener((DragSortListView.DropListener)paramListAdapter);
      }
      if ((paramListAdapter instanceof DragSortListView.DragListener)) {
        setDragListener((DragSortListView.DragListener)paramListAdapter);
      }
      if ((paramListAdapter instanceof DragSortListView.RemoveListener)) {
        setRemoveListener((DragSortListView.RemoveListener)paramListAdapter);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$AdapterWrapper = null;
    }
    super.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$AdapterWrapper);
  }
  
  public void setDelImmediately(boolean paramBoolean)
  {
    this.jdField_k_of_type_Boolean = paramBoolean;
  }
  
  public void setDragEnabled(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    this.jdField_r_of_type_Boolean = false;
    this.jdField_m_of_type_Boolean = false;
    this.jdField_p_of_type_Boolean = false;
  }
  
  public void setDragListener(DragSortListView.DragListener paramDragListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragListener = paramDragListener;
  }
  
  public void setDragScrollProfile(DragSortListView.DragScrollProfile paramDragScrollProfile)
  {
    if (paramDragScrollProfile != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DragScrollProfile = paramDragScrollProfile;
    }
  }
  
  public void setDragScrollStart(float paramFloat)
  {
    setDragScrollStarts(paramFloat, paramFloat);
  }
  
  public void setDragScrollStarts(float paramFloat1, float paramFloat2)
  {
    if (paramFloat2 > 0.5F) {
      this.jdField_j_of_type_Float = 0.5F;
    } else {
      this.jdField_j_of_type_Float = paramFloat2;
    }
    if (paramFloat1 > 0.5F) {
      this.jdField_i_of_type_Float = 0.5F;
    } else {
      this.jdField_i_of_type_Float = paramFloat1;
    }
    if (getHeight() != 0) {
      l();
    }
  }
  
  public void setDragSortListener(DragSortListView.DragSortListener paramDragSortListener)
  {
    setDropListener(paramDragSortListener);
    setDragListener(paramDragSortListener);
    setRemoveListener(paramDragSortListener);
  }
  
  public void setDropListener(DragSortListView.DropListener paramDropListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$DropListener = paramDropListener;
  }
  
  public void setFloatAlpha(float paramFloat)
  {
    this.jdField_h_of_type_Float = paramFloat;
  }
  
  public void setFloatViewManager(DragSortListView.FloatViewManager paramFloatViewManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$FloatViewManager = paramFloatViewManager;
  }
  
  public void setLeftEventListener(DragSortListView.LeftEventListener paramLeftEventListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$LeftEventListener = paramLeftEventListener;
  }
  
  public void setMaxScrollSpeed(float paramFloat)
  {
    this.jdField_e_of_type_Float = paramFloat;
  }
  
  public void setRemoveListener(DragSortListView.RemoveListener paramRemoveListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView$RemoveListener = paramRemoveListener;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortListView
 * JD-Core Version:    0.7.0.1
 */