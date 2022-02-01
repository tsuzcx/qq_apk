package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.OrientationEventListener;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ListAdapter;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.view.widget.VideoFeedsAlphaMaskView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class VideoFeedsListView
  extends ListView
  implements AbsListView.OnScrollListener
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private OrientationEventListener jdField_a_of_type_AndroidViewOrientationEventListener;
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private VideoFeedsListView.RotationObserver jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsListView$RotationObserver;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = null;
  private ArrayList<VideoFeedsListView.ListViewEventListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap;
  protected boolean a;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = 0;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean = false;
  private int jdField_j_of_type_Int = -1;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int = -1;
  private boolean jdField_k_of_type_Boolean = false;
  private int jdField_l_of_type_Int;
  private boolean jdField_l_of_type_Boolean = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o = true;
  private boolean p = false;
  private boolean q = false;
  private boolean r = false;
  private boolean s = false;
  private boolean t = false;
  private boolean u = true;
  private boolean v = true;
  private boolean w = true;
  
  public VideoFeedsListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    paramContext = VideoFeedsHelper.b((Activity)this.jdField_a_of_type_AndroidContentContext);
    this.jdField_b_of_type_Int = paramContext[0];
    this.jdField_a_of_type_Int = paramContext[1];
    setOverScrollMode(2);
    c();
    this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsListView$RotationObserver = new VideoFeedsListView.RotationObserver(this, new Handler());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsListView$RotationObserver.a();
    this.w = VideoFeedsHelper.a(this.jdField_a_of_type_AndroidContentContext);
    super.setOnScrollListener(this);
  }
  
  private int a()
  {
    int i2 = getLastVisiblePosition();
    int i3 = getFirstVisiblePosition();
    int i1 = 0;
    while (i1 <= i2 - i3)
    {
      int i4 = getChildAt(i1).getTop();
      int i5 = getChildAt(i1).getBottom();
      int i6 = this.jdField_a_of_type_Int;
      if ((i4 < i6 / 2) && (i5 > i6 / 2)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  private int a(int paramInt)
  {
    return (int)(this.jdField_a_of_type_Int / 2.0F - paramInt / 2.0F - AIOUtils.b(2.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
  }
  
  private void a(float paramFloat)
  {
    if (this.t) {
      return;
    }
    Object localObject = this.jdField_c_of_type_AndroidViewViewGroup;
    if (localObject != null)
    {
      if (((((ViewGroup)localObject).getTag() instanceof BaseItemHolder)) && (((BaseItemHolder)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).jdField_b_of_type_Int == this.jdField_j_of_type_Int))
      {
        localObject = ((BaseItemHolder)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoFeedsAlphaMaskView;
        if (localObject != null) {
          ((VideoFeedsAlphaMaskView)localObject).setAlpha(paramFloat);
        }
      }
      localObject = this.jdField_a_of_type_AndroidViewViewGroup;
      if ((localObject != null) && ((((ViewGroup)localObject).getTag() instanceof BaseItemHolder)) && (this.jdField_c_of_type_AndroidViewViewGroup.getTop() > this.jdField_g_of_type_Int))
      {
        if (((BaseItemHolder)this.jdField_a_of_type_AndroidViewViewGroup.getTag()).jdField_b_of_type_Int == this.jdField_j_of_type_Int - 1)
        {
          localObject = ((BaseItemHolder)this.jdField_a_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoFeedsAlphaMaskView;
          if (localObject != null) {
            ((VideoFeedsAlphaMaskView)localObject).setAlpha(1.0F - paramFloat);
          }
        }
      }
      else
      {
        localObject = this.jdField_b_of_type_AndroidViewViewGroup;
        if ((localObject != null) && ((((ViewGroup)localObject).getTag() instanceof BaseItemHolder)) && (((BaseItemHolder)this.jdField_b_of_type_AndroidViewViewGroup.getTag()).jdField_b_of_type_Int == this.jdField_j_of_type_Int + 1))
        {
          localObject = ((BaseItemHolder)this.jdField_b_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetVideoFeedsAlphaMaskView;
          if (localObject != null) {
            ((VideoFeedsAlphaMaskView)localObject).setAlpha(1.0F - paramFloat);
          }
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    if ((paramInt >= 0) && ((paramInt <= 30) || (paramInt >= 330)))
    {
      paramInt = this.jdField_e_of_type_Int;
      if ((paramInt != -1) && (paramInt != 0)) {
        return;
      }
      this.jdField_e_of_type_Int = -1;
      if (this.jdField_d_of_type_Int != 0) {
        a(true);
      }
    }
    else if ((paramInt >= 70) && (paramInt <= 110))
    {
      paramInt = this.jdField_e_of_type_Int;
      if ((paramInt != -1) && (paramInt != 2)) {
        return;
      }
      this.jdField_e_of_type_Int = -1;
      if (this.jdField_d_of_type_Int != 2) {
        a(2, true);
      }
    }
    else if ((paramInt >= 250) && (paramInt <= 290))
    {
      paramInt = this.jdField_e_of_type_Int;
      if ((paramInt != -1) && (paramInt != 1)) {
        return;
      }
      this.jdField_e_of_type_Int = -1;
      if (this.jdField_d_of_type_Int != 1) {
        a(1, true);
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    b();
    Object localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131368122);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367138);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    this.jdField_g_of_type_Boolean = true;
    this.m = false;
    localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((VideoFeedsListView.ListViewEventListener)((Iterator)localObject1).next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag(), true);
      }
    }
    localObject1 = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131365003);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, "innerEnterFullScreen() ERROR root == null");
      }
      return;
    }
    Object localObject2 = ((ViewGroup)localObject1).getLayoutParams();
    int i1 = this.jdField_a_of_type_Int;
    ((ViewGroup.LayoutParams)localObject2).height = i1;
    ((ViewGroup.LayoutParams)localObject2).width = i1;
    ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    i1 = 0;
    while (i1 < ((ViewGroup)localObject1).getChildCount())
    {
      localObject2 = ((ViewGroup)localObject1).getChildAt(i1);
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject2).getLayoutParams();
      if ((localLayoutParams.height == -1) && (localLayoutParams.width == -1))
      {
        if (paramInt == 1) {
          ((View)localObject2).setRotation(90.0F);
        } else {
          ((View)localObject2).setRotation(-90.0F);
        }
        ((View)localObject2).setTranslationX(-(this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / 2);
        localLayoutParams.height = this.jdField_b_of_type_Int;
        localLayoutParams.width = this.jdField_a_of_type_Int;
        ((View)localObject2).setLayoutParams(localLayoutParams);
        ((View)localObject2).setTranslationY((this.jdField_a_of_type_Int - this.jdField_b_of_type_Int) / 2);
      }
      i1 += 1;
    }
    localObject2 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131365017);
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(8);
    }
    if (this.jdField_d_of_type_Int == 0)
    {
      if (this.jdField_j_of_type_Int != 0) {
        this.jdField_f_of_type_Boolean = true;
      }
      smoothScrollBy(this.jdField_g_of_type_Int, 0);
    }
    if (paramBoolean)
    {
      localObject2 = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject2).setDuration(500L);
      ((AlphaAnimation)localObject2).setFillAfter(true);
      ((ViewGroup)localObject1).startAnimation((Animation)localObject2);
    }
    this.jdField_d_of_type_Int = paramInt;
  }
  
  private void a(View paramView)
  {
    a(paramView, 0);
  }
  
  private void a(View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    Object localObject;
    if (paramView != this.jdField_a_of_type_AndroidViewViewGroup)
    {
      localObject = paramView;
      if (paramView != this.jdField_b_of_type_AndroidViewViewGroup) {}
    }
    else
    {
      this.m = true;
      localObject = paramView;
      if (this.r)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, "smoothScrollItemToCenter: 极端情况，滚动时数据发生变化，不触发滚动");
        }
        this.r = false;
        localObject = this.jdField_c_of_type_AndroidViewViewGroup;
        this.m = false;
      }
    }
    if (localObject == this.jdField_b_of_type_AndroidViewViewGroup) {
      this.p = false;
    }
    int i2 = (((View)localObject).getTop() + ((View)localObject).getBottom()) / 2 - this.jdField_a_of_type_Int / 2;
    int i1 = Math.abs(i2);
    int i3 = Math.abs(paramInt);
    if (i3 == 0) {
      paramInt = 400;
    } else {
      paramInt = i1 / i3;
    }
    if (i1 <= 1) {
      return;
    }
    i1 = 150;
    if (paramInt > 400) {
      paramInt = 400;
    } else if (paramInt < 150) {
      paramInt = i1;
    }
    if (!a(i2, paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, "smoothScrollItemToCenter: dont need scroll just return");
      }
      this.m = false;
      return;
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("scroll distance = ");
      paramView.append(i2);
      paramView.append("speed = ");
      paramView.append(i3);
      paramView.append("duration = ");
      paramView.append(paramInt);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, paramView.toString());
    }
    this.q = true;
    this.jdField_f_of_type_Boolean = true;
    post(new VideoFeedsListView.3(this, i2, paramInt));
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = paramView.findViewById(2131365003);
    if (paramBoolean)
    {
      localLayoutParams = paramView.getLayoutParams();
      this.jdField_l_of_type_Int = localLayoutParams.height;
      localLayoutParams.height = VideoFeedsHelper.b((Activity)this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(localLayoutParams);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = this.jdField_l_of_type_Int;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private boolean a()
  {
    return (this.jdField_c_of_type_AndroidViewViewGroup != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(this.jdField_c_of_type_AndroidViewViewGroup.getTag()));
  }
  
  private boolean a(int paramInt)
  {
    if ((paramInt >= 70) && (paramInt <= 110)) {
      paramInt = 1;
    } else if ((paramInt >= 250) && (paramInt <= 290)) {
      paramInt = 2;
    } else {
      paramInt = 0;
    }
    long l1 = System.currentTimeMillis();
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), Long.valueOf(l1));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((((Integer)localEntry.getKey()).intValue() != paramInt) && (l1 - ((Long)localEntry.getValue()).longValue() < 100L)) {
        return false;
      }
    }
    return true;
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    paramInt2 = this.mFirstPosition;
    int i1 = getChildCount();
    boolean bool2 = true;
    int i2 = getPaddingTop();
    int i3 = getHeight();
    int i4 = getPaddingBottom();
    if ((paramInt1 != 0) && (this.mItemCount != 0) && (getChildCount() != 0) && ((paramInt2 != 0) || (getChildAt(0).getTop() != i2) || (paramInt1 >= 0)))
    {
      bool1 = bool2;
      if (paramInt2 + i1 - 1 != this.mItemCount - 1) {
        break label119;
      }
      bool1 = bool2;
      if (getChildAt(i1 - 1).getBottom() != i3 - i4) {
        break label119;
      }
      if (paramInt1 <= 0) {
        return true;
      }
    }
    boolean bool1 = false;
    label119:
    return bool1;
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      if (((this.jdField_a_of_type_Boolean) && (this.jdField_k_of_type_Boolean)) || ((this.jdField_k_of_type_Boolean) && (paramMotionEvent.getY() + 300.0F < this.jdField_a_of_type_Float)))
      {
        paramMotionEvent = this.jdField_a_of_type_JavaUtilArrayList;
        if (paramMotionEvent != null)
        {
          paramMotionEvent = paramMotionEvent.iterator();
          while (paramMotionEvent.hasNext()) {
            ((VideoFeedsListView.ListViewEventListener)paramMotionEvent.next()).a();
          }
        }
        a(this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
        return true;
      }
      this.jdField_a_of_type_AndroidViewVelocityTracker.clear();
    }
    else if (paramMotionEvent.getAction() == 2)
    {
      this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1);
      this.jdField_i_of_type_Int = ((int)this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity());
      if ((this.jdField_j_of_type_Boolean) && (paramMotionEvent.getY() > this.jdField_a_of_type_Float))
      {
        if ((paramMotionEvent.getY() - this.jdField_a_of_type_Float > 300.0F) && (!this.jdField_c_of_type_Boolean))
        {
          this.jdField_c_of_type_Boolean = true;
          paramMotionEvent = this.jdField_a_of_type_JavaUtilArrayList;
          if (paramMotionEvent != null)
          {
            paramMotionEvent = paramMotionEvent.iterator();
            while (paramMotionEvent.hasNext()) {
              ((VideoFeedsListView.ListViewEventListener)paramMotionEvent.next()).b();
            }
          }
        }
        return true;
      }
      double d1 = this.jdField_f_of_type_Int;
      Double.isNaN(d1);
      int i1 = (int)(d1 * 0.3D);
      float f1 = paramMotionEvent.getY() - this.jdField_a_of_type_Float;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_k_of_type_Boolean) && (f1 < 0.0F) && (Math.abs(f1) >= i1)) {
        return true;
      }
      if (this.jdField_i_of_type_Boolean) {
        return true;
      }
      if ((f1 > 0.0F) && (i1 <= f1))
      {
        this.jdField_i_of_type_Boolean = true;
        a(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
        return true;
      }
      if ((f1 < 0.0F) && (Math.abs(f1) >= i1))
      {
        this.jdField_i_of_type_Boolean = true;
        a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  private void b(int paramInt)
  {
    paramInt = a(paramInt);
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      localView = localView.findViewById(2131363673);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = paramInt;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    try
    {
      this.jdField_a_of_type_AndroidViewOrientationEventListener = new VideoFeedsListView.2(this, this.jdField_a_of_type_AndroidContentContext, 3);
      if (this.jdField_a_of_type_AndroidViewOrientationEventListener.canDetectOrientation())
      {
        this.jdField_a_of_type_AndroidViewOrientationEventListener.enable();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("initOrientationEventListener() Exception error=");
        localStringBuilder.append(localException.getMessage());
        QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, localStringBuilder.toString());
      }
    }
  }
  
  private void c(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null)
    {
      localView = localView.findViewById(2131363673);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = paramInt;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  public void a()
  {
    if (this.q)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, "smoothScrollToNextItem: scrolling item to center ,just return");
      }
      return;
    }
    if (this.jdField_f_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, "smoothScrollToNextItem: scrolling ,do scroll when idle");
      }
      this.p = true;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, "smoothScrollToNextItem: ");
    }
    ViewGroup localViewGroup = this.jdField_b_of_type_AndroidViewViewGroup;
    if (localViewGroup != null) {
      a(localViewGroup);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = false;
    this.jdField_d_of_type_Int = 0;
    Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((VideoFeedsListView.ListViewEventListener)((Iterator)localObject1).next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag(), false);
      }
    }
    localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131368122);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131367138);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = (ViewGroup)this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131365003);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, "innerExitFullScreen() ERROR root == null");
      }
      return;
    }
    Object localObject2 = ((ViewGroup)localObject1).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).height = this.jdField_f_of_type_Int;
    ((ViewGroup.LayoutParams)localObject2).width = this.jdField_b_of_type_Int;
    ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    int i1 = 0;
    while (i1 < ((ViewGroup)localObject1).getChildCount())
    {
      localObject2 = ((ViewGroup)localObject1).getChildAt(i1);
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject2).getLayoutParams();
      if ((localLayoutParams.height == this.jdField_b_of_type_Int) && (localLayoutParams.width == this.jdField_a_of_type_Int))
      {
        ((View)localObject2).setRotation(0.0F);
        ((View)localObject2).setTranslationX(0.0F);
        localLayoutParams.height = -1;
        localLayoutParams.width = -1;
        ((View)localObject2).setLayoutParams(localLayoutParams);
        ((View)localObject2).setTranslationY(0.0F);
      }
      i1 += 1;
    }
    if (this.jdField_j_of_type_Int != 0) {
      this.jdField_f_of_type_Boolean = true;
    }
    smoothScrollBy(-this.jdField_g_of_type_Int, 0);
    localObject1 = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131365017);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    if (paramBoolean)
    {
      localObject1 = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject1).setDuration(500L);
      ((AlphaAnimation)localObject1).setFillAfter(true);
      startAnimation((Animation)localObject1);
    }
  }
  
  public void b()
  {
    if (this.jdField_d_of_type_Int != 0) {
      return;
    }
    if ((this.jdField_g_of_type_Boolean) && (!this.jdField_d_of_type_Boolean)) {
      return;
    }
    if (!this.t)
    {
      if (this.s) {
        return;
      }
      int i1 = a();
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(i1));
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(i1 + 1));
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(i1 - 1));
      Object localObject = this.jdField_c_of_type_AndroidViewViewGroup;
      if ((localObject != null) && (((ViewGroup)localObject).getTag() != null))
      {
        this.jdField_j_of_type_Int = ((BaseItemHolder)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).jdField_b_of_type_Int;
        localObject = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131365003);
        if (localObject == null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("resetVideoInstance: contentView null ！，itemType=");
          ((StringBuilder)localObject).append(((BaseItemHolder)this.jdField_c_of_type_AndroidViewViewGroup.getTag()).jdField_a_of_type_Int);
          QLog.e("Q.pubaccount.video.feedsVideoFeedsListView", 2, ((StringBuilder)localObject).toString());
          return;
        }
        i1 = Math.abs(((View)localObject).getRight() - ((View)localObject).getLeft());
        int i2 = Math.abs(((View)localObject).getBottom() - ((View)localObject).getTop());
        boolean bool;
        if (i1 > i2) {
          bool = true;
        } else {
          bool = false;
        }
        this.jdField_d_of_type_Boolean = bool;
        this.jdField_f_of_type_Int = i2;
        this.jdField_g_of_type_Int = this.jdField_c_of_type_AndroidViewViewGroup.getTop();
      }
      this.jdField_k_of_type_Boolean = false;
      this.jdField_j_of_type_Boolean = false;
      if (this.o) {
        localObject = this.jdField_b_of_type_AndroidViewViewGroup;
      } else {
        localObject = this.jdField_c_of_type_AndroidViewViewGroup;
      }
      if ((localObject != null) && (((View)localObject).getTag() != null) && (((BaseItemHolder)((View)localObject).getTag()).jdField_b_of_type_Int == getAdapter().getCount() - 1 - getHeaderViewsCount() - getFooterViewsCount())) {
        this.jdField_k_of_type_Boolean = true;
      }
      localObject = this.jdField_a_of_type_AndroidViewViewGroup;
      if ((localObject != null) && (((ViewGroup)localObject).getId() == 2131376058)) {
        this.jdField_j_of_type_Boolean = true;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_g_of_type_Boolean) {
      return;
    }
    if (this.jdField_c_of_type_Int == 1) {
      return;
    }
    this.jdField_e_of_type_Int = 1;
    a(1, paramBoolean);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (!this.n)
    {
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)getChildAt(1));
      paramCanvas = this.jdField_c_of_type_AndroidViewViewGroup;
      if (paramCanvas == null) {
        return;
      }
      this.jdField_h_of_type_Int = (paramCanvas.getBottom() - this.jdField_c_of_type_AndroidViewViewGroup.getTop());
      if (this.t)
      {
        paramCanvas = this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131365003);
        int i1 = Math.abs(paramCanvas.getRight() - paramCanvas.getLeft());
        int i2 = Math.abs(paramCanvas.getBottom() - paramCanvas.getTop());
        boolean bool;
        if (i1 > i2) {
          bool = true;
        } else {
          bool = false;
        }
        this.jdField_d_of_type_Boolean = bool;
        this.jdField_f_of_type_Int = i2;
        this.jdField_g_of_type_Int = a(this.jdField_h_of_type_Int);
        this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131368122).setVisibility(8);
        c(0);
        a(this.jdField_c_of_type_AndroidViewViewGroup, true);
        this.u = false;
      }
      else
      {
        b(this.jdField_c_of_type_AndroidViewViewGroup.getHeight());
      }
      this.n = true;
      return;
    }
    if ((!this.o) && (this.jdField_k_of_type_Boolean))
    {
      b();
      if ((!this.jdField_k_of_type_Boolean) && (!this.jdField_f_of_type_Boolean))
      {
        paramCanvas = this.jdField_c_of_type_AndroidViewViewGroup;
        if ((paramCanvas != null) && ((paramCanvas.getTag() instanceof BaseVideoItemHolder)))
        {
          paramCanvas = this.jdField_a_of_type_JavaUtilArrayList;
          if (paramCanvas != null)
          {
            paramCanvas = paramCanvas.iterator();
            while (paramCanvas.hasNext()) {
              ((VideoFeedsListView.ListViewEventListener)paramCanvas.next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag());
            }
          }
        }
      }
    }
    if (!this.jdField_l_of_type_Boolean)
    {
      if (!this.t)
      {
        b();
        this.jdField_g_of_type_Int = a(this.jdField_h_of_type_Int);
      }
      paramCanvas = this.jdField_c_of_type_AndroidViewViewGroup;
      if ((paramCanvas != null) && ((paramCanvas.getTag() instanceof BaseVideoItemHolder)))
      {
        this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131365017).setAlpha(0.0F);
        paramCanvas = this.jdField_a_of_type_JavaUtilArrayList;
        if (paramCanvas != null)
        {
          paramCanvas = paramCanvas.iterator();
          while (paramCanvas.hasNext()) {
            ((VideoFeedsListView.ListViewEventListener)paramCanvas.next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag());
          }
        }
        this.jdField_l_of_type_Boolean = true;
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    if (this.jdField_f_of_type_Boolean) {
      return true;
    }
    if (this.jdField_g_of_type_Boolean) {
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.m = false;
      this.jdField_i_of_type_Boolean = false;
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_h_of_type_Boolean = false;
      b();
    }
    if ((paramMotionEvent.getAction() == 2) && (!this.jdField_h_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewViewGroup != null))
    {
      int i1 = AIOUtils.b(25.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      int i2 = ViewConfiguration.getTouchSlop();
      if (Math.abs(this.jdField_a_of_type_Float - paramMotionEvent.getY()) > i2)
      {
        float f1 = this.jdField_a_of_type_Float;
        float f2 = i1;
        if ((f1 < f2) || (Math.abs(this.jdField_a_of_type_Int - f1) < f2))
        {
          this.jdField_h_of_type_Boolean = true;
          return true;
        }
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.t) {
        return false;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.jdField_c_of_type_AndroidViewViewGroup;
    if (localObject != null)
    {
      float f2 = Math.round(Math.abs(((ViewGroup)localObject).getTop() - this.jdField_g_of_type_Int) / this.jdField_f_of_type_Int * 100.0F) / 100.0F;
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      a(f1);
    }
    localObject = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localObject != null) {
      ((AbsListView.OnScrollListener)localObject).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      DropFrameMonitor.a().a("list_video_feeds", false);
    } else {
      DropFrameMonitor.a().a("list_video_feeds");
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          if (this.jdField_f_of_type_Boolean) {
            return;
          }
          float f1 = this.jdField_b_of_type_Float;
          float f2 = this.jdField_a_of_type_Float;
          if (f1 > f2)
          {
            if (!this.jdField_j_of_type_Boolean) {
              a(this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
            } else {
              a(this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
            }
          }
          else if (f1 < f2) {
            if (!this.jdField_k_of_type_Boolean) {
              a(this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
            } else {
              a(this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
            }
          }
          this.jdField_c_of_type_Int = 2;
        }
      }
      else {
        this.jdField_c_of_type_Int = 1;
      }
    }
    else
    {
      if ((this.jdField_c_of_type_Int == 1) && (!this.jdField_f_of_type_Boolean))
      {
        a(this.jdField_c_of_type_AndroidViewViewGroup, this.jdField_i_of_type_Int);
      }
      else
      {
        this.jdField_f_of_type_Boolean = false;
        this.q = false;
        if (this.m) {
          a(1.0F);
        }
        b();
        if (this.m) {
          a(0.0F);
        }
        if ((this.m) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_g_of_type_Boolean) && (this.jdField_c_of_type_AndroidViewViewGroup != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsPlayManager.preplay", 2, "onScrollStateChanged: onCenterViewChanged ");
          }
          localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((VideoFeedsListView.ListViewEventListener)((Iterator)localObject).next()).a(this.jdField_c_of_type_AndroidViewViewGroup.getTag());
          }
        }
        if (this.p) {
          a();
        }
      }
      this.r = false;
      this.jdField_c_of_type_Int = 0;
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener;
    if (localObject != null) {
      ((AbsListView.OnScrollListener)localObject).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_f_of_type_Boolean) {
      return true;
    }
    if (this.jdField_g_of_type_Boolean) {
      return false;
    }
    if (this.jdField_h_of_type_Boolean) {
      return false;
    }
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
    this.jdField_a_of_type_AndroidViewVelocityTracker.addMovement(paramMotionEvent);
    if (this.jdField_k_of_type_Int == 6)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_k_of_type_Int = paramMotionEvent.getActionMasked();
      return super.onTouchEvent(paramMotionEvent);
    }
    this.jdField_k_of_type_Int = paramMotionEvent.getActionMasked();
    return a(paramMotionEvent);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    getAdapter().registerDataSetObserver(new VideoFeedsListView.1(this));
  }
  
  public void setIsLastItemAsFooter(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setIsOrignalVideoFullScreen(boolean paramBoolean)
  {
    this.v = paramBoolean;
  }
  
  public void setIsScrollItemToTop(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_l_of_type_Boolean)
    {
      if (!paramBoolean1)
      {
        this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131368122).setVisibility(0);
        if (!this.u)
        {
          this.u = true;
          b(this.jdField_h_of_type_Int);
        }
        else
        {
          this.jdField_a_of_type_AndroidViewViewGroup = null;
          this.jdField_b_of_type_AndroidViewViewGroup = null;
          this.jdField_f_of_type_Boolean = true;
          if (this.s) {
            smoothScrollBy(-this.jdField_g_of_type_Int, 0);
          } else {
            smoothScrollBy(-this.jdField_g_of_type_Int, 500);
          }
        }
        a(this.jdField_c_of_type_AndroidViewViewGroup, false);
        this.t = false;
      }
      else
      {
        this.t = true;
        this.jdField_h_of_type_Int = (this.jdField_c_of_type_AndroidViewViewGroup.getBottom() - this.jdField_c_of_type_AndroidViewViewGroup.getTop());
        this.jdField_c_of_type_AndroidViewViewGroup.findViewById(2131368122).setVisibility(8);
        this.jdField_f_of_type_Boolean = true;
        if (paramBoolean2) {
          smoothScrollBy(this.jdField_g_of_type_Int, 500);
        } else {
          smoothScrollBy(this.jdField_g_of_type_Int, 0);
        }
        a(this.jdField_c_of_type_AndroidViewViewGroup, true);
      }
    }
    else {
      this.t = paramBoolean1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setIsScrollItemToTop isScrollItemToTop=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", needDurationWhenScrollToTop=");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(", mFirstDrawCompleted=");
      ((StringBuilder)localObject).append(this.jdField_l_of_type_Boolean);
      ((StringBuilder)localObject).append(", mIsHeaderHeightSetted=");
      ((StringBuilder)localObject).append(this.u);
      ((StringBuilder)localObject).append(", mIsNeedRecoveryScrollItemToTop=");
      ((StringBuilder)localObject).append(this.s);
      ((StringBuilder)localObject).append(", mCenterViewHeight=");
      ((StringBuilder)localObject).append(this.jdField_h_of_type_Int);
      ((StringBuilder)localObject).append(", mContentViewHeightBefore=");
      ((StringBuilder)localObject).append(this.jdField_l_of_type_Int);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((VideoFeedsListView.ListViewEventListener)((Iterator)localObject).next()).a(paramBoolean1);
      }
    }
  }
  
  public void setNeedDetectScreenOrientation(boolean paramBoolean)
  {
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = paramOnScrollListener;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsListView
 * JD-Core Version:    0.7.0.1
 */