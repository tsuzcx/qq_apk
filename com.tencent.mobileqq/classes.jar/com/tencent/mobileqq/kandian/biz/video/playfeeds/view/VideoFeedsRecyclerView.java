package com.tencent.mobileqq.kandian.biz.video.playfeeds.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mobileqq.kandian.api.R.styleable;
import com.tencent.mobileqq.kandian.base.view.widget.ListEventListener;
import com.tencent.mobileqq.kandian.biz.video.OrientationDetector;
import com.tencent.mobileqq.kandian.biz.video.OrientationDetector.OnOrientationChangedListener;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.pull2refresh.PagerSnapHelper;
import com.tencent.widget.pull2refresh.PagerSnapHelper.PagerEventListener;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VideoFeedsRecyclerView
  extends RecyclerViewWithHeaderFooter
  implements OrientationDetector.OnOrientationChangedListener, PagerSnapHelper.PagerEventListener
{
  private static int jdField_a_of_type_Int;
  private static int jdField_b_of_type_Int;
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private RecyclerView.OnScrollListener jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener = new VideoFeedsRecyclerView.1(this);
  private RecyclerView.ViewHolder jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder;
  private View jdField_a_of_type_AndroidViewView;
  private OrientationDetector jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector;
  private PagerSnapHelper jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper;
  private List<ListEventListener> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  private float jdField_b_of_type_Float;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean;
  private int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean = true;
  private boolean h = true;
  private boolean i = true;
  
  public VideoFeedsRecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFeedsRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsRecyclerView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    e();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cg, paramInt, 0);
    this.jdField_e_of_type_Int = paramContext.getInt(R.styleable.s, 0);
    this.jdField_f_of_type_Int = paramContext.getDimensionPixelSize(R.styleable.t, 0);
    this.jdField_b_of_type_Float = paramContext.getFloat(R.styleable.u, 25.0F);
    paramContext.recycle();
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
        return;
      }
      this.jdField_c_of_type_Boolean = false;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector;
      if ((localObject != null) && (this.jdField_e_of_type_Boolean))
      {
        localObject = ((OrientationDetector)localObject).a();
        if ((localObject instanceof Activity)) {
          ((Activity)localObject).setRequestedOrientation(1);
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ListEventListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, false);
        }
      }
      if (paramBoolean)
      {
        localObject = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject).setDuration(500L);
        ((AlphaAnimation)localObject).setFillAfter(true);
        startAnimation((Animation)localObject);
      }
    }
  }
  
  private void b(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      ViewGroup.LayoutParams localLayoutParams = localView.getLayoutParams();
      localLayoutParams.height = paramInt;
      localLayoutParams.width = -1;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
        return;
      }
      this.jdField_c_of_type_Boolean = true;
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector;
      if ((localObject != null) && (this.jdField_e_of_type_Boolean)) {
        if (paramInt == 0)
        {
          localObject = ((OrientationDetector)localObject).a();
          if ((localObject instanceof Activity)) {
            ((Activity)localObject).setRequestedOrientation(0);
          }
        }
        else
        {
          localObject = ((OrientationDetector)localObject).a();
          if ((localObject instanceof Activity)) {
            ((Activity)localObject).setRequestedOrientation(8);
          }
        }
      }
      localObject = this.jdField_a_of_type_JavaUtilList;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((ListEventListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder, true);
        }
      }
      if (paramBoolean)
      {
        localObject = new AlphaAnimation(0.0F, 1.0F);
        ((AlphaAnimation)localObject).setDuration(500L);
        ((AlphaAnimation)localObject).setFillAfter(true);
        startAnimation((Animation)localObject);
      }
    }
  }
  
  private void e()
  {
    addOnScrollListener(this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$OnScrollListener);
    g();
    setOverScrollMode(2);
    setItemAnimator(null);
    setHasFixedSize(true);
    setItemViewCacheSize(0);
    setClipChildren(false);
    setVerticalScrollBarEnabled(false);
    setHorizontalScrollBarEnabled(false);
    jdField_a_of_type_Int = super.getMinFlingVelocity() * 3;
    jdField_b_of_type_Int = super.getMinFlingVelocity() * 3;
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper = new PagerSnapHelper(this.jdField_e_of_type_Int, this.jdField_b_of_type_Float);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.e(this.jdField_f_of_type_Int);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.c(this.jdField_c_of_type_Int + 1);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.d(1);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a(this);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a(this);
    if (Build.VERSION.SDK_INT >= 23) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a(true);
    }
    addOnLayoutChangeListener(new VideoFeedsRecyclerView.2(this));
  }
  
  private void g()
  {
    View localView = new View(getContext());
    localView.setId(2131376058);
    localView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-2, -2));
    this.jdField_a_of_type_AndroidViewView = localView;
    addHeaderView(localView);
    localView = new View(getContext());
    localView.setId(2131376057);
    localView.setLayoutParams(new StaggeredGridLayoutManager.LayoutParams(-2, -2));
    this.jdField_b_of_type_AndroidViewView = localView;
    addFooterView(localView);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.b() - 1;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public View a()
  {
    if ((getLayoutManager() instanceof LinearLayoutManager)) {
      return this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a((LinearLayoutManager)getLayoutManager());
    }
    return null;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ListEventListener)((Iterator)localObject).next()).aC_();
      }
    }
  }
  
  public void a(int paramInt)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_d_of_type_Boolean))
    {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onOrientationChanged: requestOrientation=");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(", userOrientation=");
        localStringBuilder.append(this.jdField_d_of_type_Int);
        QLog.d("VideoFeedsRecyclerView", 2, localStringBuilder.toString());
      }
      int j = this.jdField_d_of_type_Int;
      if ((j != -1) && (j != paramInt)) {
        return;
      }
      this.jdField_d_of_type_Int = -1;
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 8)
          {
            if (paramInt != 9) {
              return;
            }
            a(paramInt, true);
            return;
          }
          b(paramInt, true);
          return;
        }
        a(paramInt, true);
        return;
      }
      b(paramInt, true);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder = paramViewHolder;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPagerChanged: pagerSnapOnCenterViewChanged position=");
        ((StringBuilder)localObject).append(paramViewHolder.getLayoutPosition());
        ((StringBuilder)localObject).append(", this=");
        ((StringBuilder)localObject).append(this);
        QLog.d("VideoFeedsRecyclerView", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ListEventListener)((Iterator)localObject).next()).a(paramViewHolder);
      }
    }
  }
  
  public void a(ListEventListener paramListEventListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.add(paramListEventListener);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecyclerView", 2, "user exitFullScreen: ");
    }
    this.jdField_d_of_type_Int = 1;
    a(1, paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.a();
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.b();
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("changeFullScreenStatus: mIsShowingFull=");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      QLog.d("VideoFeedsRecyclerView", 2, localStringBuilder.toString());
    }
    if (this.jdField_c_of_type_Boolean)
    {
      a(true);
      return;
    }
    b(true);
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onPagerIdle: pagerSnapOnCenterViewChanged position=");
        ((StringBuilder)localObject).append(paramViewHolder.getLayoutPosition());
        ((StringBuilder)localObject).append(", this=");
        ((StringBuilder)localObject).append(this);
        QLog.d("VideoFeedsRecyclerView", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ListEventListener)((Iterator)localObject).next()).b(paramViewHolder);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecyclerView", 2, "user enterFullScreen: ");
    }
    this.jdField_d_of_type_Int = 0;
    b(0, paramBoolean);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.b();
  }
  
  public void c()
  {
    addOnLayoutChangeListener(new VideoFeedsRecyclerView.3(this));
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      ((List)localObject).clear();
      this.jdField_a_of_type_JavaUtilList = null;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector;
    if (localObject != null) {
      ((OrientationDetector)localObject).a();
    }
  }
  
  public int getFooterViewsCount()
  {
    return super.getFooterViewsCount() + this.jdField_c_of_type_Int;
  }
  
  public int getMinFlingVelocity()
  {
    if (getLayoutManager().canScrollVertically()) {
      return jdField_a_of_type_Int;
    }
    return jdField_b_of_type_Int;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.d()) {
      return false;
    }
    if (this.jdField_c_of_type_Boolean) {
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_f_of_type_Boolean = false;
    }
    if ((paramMotionEvent.getAction() == 2) && (!this.jdField_f_of_type_Boolean) && (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView$ViewHolder != null))
    {
      int j = DisplayUtil.a(getContext(), 25.0F);
      int k = ViewConfiguration.get(getContext()).getScaledTouchSlop();
      if (Math.abs(this.jdField_a_of_type_Float - paramMotionEvent.getY()) > k)
      {
        float f1 = this.jdField_a_of_type_Float;
        float f2 = j;
        if ((f1 < f2) || (Math.abs(getHeight() - this.jdField_a_of_type_Float) < f2))
        {
          this.jdField_f_of_type_Boolean = true;
          return false;
        }
      }
    }
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.d()) {
      return true;
    }
    if (this.jdField_c_of_type_Boolean) {
      return false;
    }
    if (this.jdField_f_of_type_Boolean) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void scrollToPosition(int paramInt)
  {
    super.scrollToPosition(getHeaderViewsCount() + paramInt);
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.c();
  }
  
  public void setAdapter(RecyclerView.Adapter paramAdapter)
  {
    RecyclerView.Adapter localAdapter = getAdapter();
    super.setAdapter(paramAdapter);
    if ((localAdapter != getAdapter()) && (getAdapter() != null) && (getLayoutManager() != null)) {
      f();
    }
  }
  
  public void setEnableFooterView(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public void setEnableHeaderView(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
  }
  
  public void setExtraFooterCount(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setHeaderHeight(int paramInt)
  {
    this.jdField_g_of_type_Int = paramInt;
  }
  
  public void setLayoutManager(RecyclerView.LayoutManager paramLayoutManager)
  {
    RecyclerView.LayoutManager localLayoutManager = getLayoutManager();
    super.setLayoutManager(paramLayoutManager);
    if ((localLayoutManager != getLayoutManager()) && (getLayoutManager() != null) && (getAdapter() != null)) {
      f();
    }
  }
  
  public void setNeedDetectOrientation(Activity paramActivity, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if ((this.jdField_d_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector == null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoOrientationDetector = new OrientationDetector(paramActivity, this);
    }
  }
  
  public void setNeedDetectOrientation(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_e_of_type_Boolean = paramBoolean2;
    setNeedDetectOrientation(paramActivity, paramBoolean1);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setSnapOffset(int paramInt)
  {
    this.jdField_f_of_type_Int = paramInt;
    PagerSnapHelper localPagerSnapHelper = this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper;
    if (localPagerSnapHelper != null) {
      localPagerSnapHelper.e(paramInt);
    }
  }
  
  public void setSnapOnFling(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.c(paramBoolean);
  }
  
  public void setSnapOnIdle(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshPagerSnapHelper.b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView
 * JD-Core Version:    0.7.0.1
 */