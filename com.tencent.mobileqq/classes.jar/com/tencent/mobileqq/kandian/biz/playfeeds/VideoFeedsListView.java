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
  private int A = 0;
  private int B = -1;
  private int C;
  private int D;
  private int E;
  private boolean F = false;
  private boolean G = false;
  private boolean H = false;
  private VelocityTracker I;
  private int J = 0;
  private int K = -1;
  private VideoFeedsListView.RotationObserver L;
  private boolean M = true;
  private boolean N = false;
  private boolean O = false;
  private boolean P = false;
  private int Q = -1;
  private boolean R = false;
  private boolean S = false;
  private boolean T = true;
  private boolean U = true;
  private int V;
  private boolean W = true;
  protected boolean a = false;
  private boolean b = true;
  private ArrayList<VideoFeedsListView.ListViewEventListener> c = new ArrayList();
  private Context d;
  private int e;
  private int f;
  private boolean g = false;
  private long h;
  private AbsListView.OnScrollListener i = null;
  private float j;
  private float k;
  private ViewGroup l;
  private ViewGroup m;
  private ViewGroup n;
  private View o;
  private boolean p;
  private int q = 0;
  private boolean r = true;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private HashMap<Integer, Long> y;
  private OrientationEventListener z;
  
  public VideoFeedsListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.d = paramContext;
    paramContext = VideoFeedsHelper.c((Activity)this.d);
    this.f = paramContext[0];
    this.e = paramContext[1];
    setOverScrollMode(2);
    c();
    this.I = VelocityTracker.obtain();
    this.L = new VideoFeedsListView.RotationObserver(this, new Handler());
    this.L.a();
    this.W = VideoFeedsHelper.b(this.d);
    super.setOnScrollListener(this);
  }
  
  private void a(float paramFloat)
  {
    if (this.S) {
      return;
    }
    Object localObject = this.n;
    if (localObject != null)
    {
      if (((((ViewGroup)localObject).getTag() instanceof BaseItemHolder)) && (((BaseItemHolder)this.n.getTag()).Y == this.K))
      {
        localObject = ((BaseItemHolder)this.n.getTag()).W;
        if (localObject != null) {
          ((VideoFeedsAlphaMaskView)localObject).setAlpha(paramFloat);
        }
      }
      localObject = this.l;
      if ((localObject != null) && ((((ViewGroup)localObject).getTag() instanceof BaseItemHolder)) && (this.n.getTop() > this.D))
      {
        if (((BaseItemHolder)this.l.getTag()).Y == this.K - 1)
        {
          localObject = ((BaseItemHolder)this.l.getTag()).W;
          if (localObject != null) {
            ((VideoFeedsAlphaMaskView)localObject).setAlpha(1.0F - paramFloat);
          }
        }
      }
      else
      {
        localObject = this.m;
        if ((localObject != null) && ((((ViewGroup)localObject).getTag() instanceof BaseItemHolder)) && (((BaseItemHolder)this.m.getTag()).Y == this.K + 1))
        {
          localObject = ((BaseItemHolder)this.m.getTag()).W;
          if (localObject != null) {
            ((VideoFeedsAlphaMaskView)localObject).setAlpha(1.0F - paramFloat);
          }
        }
      }
    }
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    b();
    Object localObject1 = this.n.findViewById(2131434977);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    localObject1 = this.n.findViewById(2131433592);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    this.t = true;
    this.G = false;
    localObject1 = this.c;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((VideoFeedsListView.ListViewEventListener)((Iterator)localObject1).next()).a(this.n.getTag(), true);
      }
    }
    localObject1 = (ViewGroup)this.n.findViewById(2131431135);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, "innerEnterFullScreen() ERROR root == null");
      }
      return;
    }
    Object localObject2 = ((ViewGroup)localObject1).getLayoutParams();
    int i1 = this.e;
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
        ((View)localObject2).setTranslationX(-(this.e - this.f) / 2);
        localLayoutParams.height = this.f;
        localLayoutParams.width = this.e;
        ((View)localObject2).setLayoutParams(localLayoutParams);
        ((View)localObject2).setTranslationY((this.e - this.f) / 2);
      }
      i1 += 1;
    }
    localObject2 = this.n.findViewById(2131431149);
    if (localObject2 != null) {
      ((View)localObject2).setVisibility(8);
    }
    if (this.A == 0)
    {
      if (this.K != 0) {
        this.s = true;
      }
      smoothScrollBy(this.D, 0);
    }
    if (paramBoolean)
    {
      localObject2 = new AlphaAnimation(0.0F, 1.0F);
      ((AlphaAnimation)localObject2).setDuration(500L);
      ((AlphaAnimation)localObject2).setFillAfter(true);
      ((ViewGroup)localObject1).startAnimation((Animation)localObject2);
    }
    this.A = paramInt;
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
    if (paramView != this.l)
    {
      localObject = paramView;
      if (paramView != this.m) {}
    }
    else
    {
      this.G = true;
      localObject = paramView;
      if (this.P)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, "smoothScrollItemToCenter: 极端情况，滚动时数据发生变化，不触发滚动");
        }
        this.P = false;
        localObject = this.n;
        this.G = false;
      }
    }
    if (localObject == this.m) {
      this.N = false;
    }
    int i2 = (((View)localObject).getTop() + ((View)localObject).getBottom()) / 2 - this.e / 2;
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
      this.G = false;
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
    this.O = true;
    this.s = true;
    post(new VideoFeedsListView.3(this, i2, paramInt));
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    paramView = paramView.findViewById(2131431135);
    if (paramBoolean)
    {
      localLayoutParams = paramView.getLayoutParams();
      this.V = localLayoutParams.height;
      localLayoutParams.height = VideoFeedsHelper.e((Activity)this.d);
      paramView.setLayoutParams(localLayoutParams);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = this.V;
    paramView.setLayoutParams(localLayoutParams);
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
    this.y.put(Integer.valueOf(paramInt), Long.valueOf(l1));
    Iterator localIterator = this.y.entrySet().iterator();
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
      this.k = paramMotionEvent.getY();
      if (((this.a) && (this.x)) || ((this.x) && (paramMotionEvent.getY() + 300.0F < this.j)))
      {
        paramMotionEvent = this.c;
        if (paramMotionEvent != null)
        {
          paramMotionEvent = paramMotionEvent.iterator();
          while (paramMotionEvent.hasNext()) {
            ((VideoFeedsListView.ListViewEventListener)paramMotionEvent.next()).a();
          }
        }
        a(this.n, this.J);
        return true;
      }
      this.I.clear();
    }
    else if (paramMotionEvent.getAction() == 2)
    {
      this.I.computeCurrentVelocity(1);
      this.J = ((int)this.I.getYVelocity());
      if ((this.w) && (paramMotionEvent.getY() > this.j))
      {
        if ((paramMotionEvent.getY() - this.j > 300.0F) && (!this.g))
        {
          this.g = true;
          paramMotionEvent = this.c;
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
      double d1 = this.C;
      Double.isNaN(d1);
      int i1 = (int)(d1 * 0.3D);
      float f1 = paramMotionEvent.getY() - this.j;
      if ((!this.a) && (this.x) && (f1 < 0.0F) && (Math.abs(f1) >= i1)) {
        return true;
      }
      if (this.v) {
        return true;
      }
      if ((f1 > 0.0F) && (i1 <= f1))
      {
        this.v = true;
        a(this.l, this.J);
        return true;
      }
      if ((f1 < 0.0F) && (Math.abs(f1) >= i1))
      {
        this.v = true;
        a(this.m, this.J);
        return true;
      }
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  private void b(int paramInt)
  {
    if ((paramInt >= 0) && ((paramInt <= 30) || (paramInt >= 330)))
    {
      paramInt = this.B;
      if ((paramInt != -1) && (paramInt != 0)) {
        return;
      }
      this.B = -1;
      if (this.A != 0) {
        a(true);
      }
    }
    else if ((paramInt >= 70) && (paramInt <= 110))
    {
      paramInt = this.B;
      if ((paramInt != -1) && (paramInt != 2)) {
        return;
      }
      this.B = -1;
      if (this.A != 2) {
        a(2, true);
      }
    }
    else if ((paramInt >= 250) && (paramInt <= 290))
    {
      paramInt = this.B;
      if ((paramInt != -1) && (paramInt != 1)) {
        return;
      }
      this.B = -1;
      if (this.A != 1) {
        a(1, true);
      }
    }
  }
  
  private void c()
  {
    this.y = new HashMap();
    try
    {
      this.z = new VideoFeedsListView.2(this, this.d, 3);
      if (this.z.canDetectOrientation())
      {
        this.z.enable();
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
    paramInt = d(paramInt);
    View localView = this.o;
    if (localView != null)
    {
      localView = localView.findViewById(2131429586);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = paramInt;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private int d(int paramInt)
  {
    return (int)(this.e / 2.0F - paramInt / 2.0F - AIOUtils.b(2.0F, this.d.getResources()));
  }
  
  private boolean d()
  {
    return (this.n != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(this.n.getTag()));
  }
  
  private void e(int paramInt)
  {
    View localView = this.o;
    if (localView != null)
    {
      localView = localView.findViewById(2131429586);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      localLayoutParams.height = paramInt;
      localView.setLayoutParams(localLayoutParams);
    }
  }
  
  private int getCenterChildPosition()
  {
    int i2 = getLastVisiblePosition();
    int i3 = getFirstVisiblePosition();
    int i1 = 0;
    while (i1 <= i2 - i3)
    {
      int i4 = getChildAt(i1).getTop();
      int i5 = getChildAt(i1).getBottom();
      int i6 = this.e;
      if ((i4 < i6 / 2) && (i5 > i6 / 2)) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public void a()
  {
    if (this.O)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, "smoothScrollToNextItem: scrolling item to center ,just return");
      }
      return;
    }
    if (this.s)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, "smoothScrollToNextItem: scrolling ,do scroll when idle");
      }
      this.N = true;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, "smoothScrollToNextItem: ");
    }
    ViewGroup localViewGroup = this.m;
    if (localViewGroup != null) {
      a(localViewGroup);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.t = false;
    this.A = 0;
    Object localObject1 = this.c;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((VideoFeedsListView.ListViewEventListener)((Iterator)localObject1).next()).a(this.n.getTag(), false);
      }
    }
    localObject1 = this.n.findViewById(2131434977);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = this.n.findViewById(2131433592);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = (ViewGroup)this.n.findViewById(2131431135);
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, "innerExitFullScreen() ERROR root == null");
      }
      return;
    }
    Object localObject2 = ((ViewGroup)localObject1).getLayoutParams();
    ((ViewGroup.LayoutParams)localObject2).height = this.C;
    ((ViewGroup.LayoutParams)localObject2).width = this.f;
    ((ViewGroup)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    int i1 = 0;
    while (i1 < ((ViewGroup)localObject1).getChildCount())
    {
      localObject2 = ((ViewGroup)localObject1).getChildAt(i1);
      ViewGroup.LayoutParams localLayoutParams = ((View)localObject2).getLayoutParams();
      if ((localLayoutParams.height == this.f) && (localLayoutParams.width == this.e))
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
    if (this.K != 0) {
      this.s = true;
    }
    smoothScrollBy(-this.D, 0);
    localObject1 = this.n.findViewById(2131431149);
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
    if (this.A != 0) {
      return;
    }
    if ((this.t) && (!this.p)) {
      return;
    }
    if (!this.S)
    {
      if (this.R) {
        return;
      }
      int i1 = getCenterChildPosition();
      this.n = ((ViewGroup)getChildAt(i1));
      this.m = ((ViewGroup)getChildAt(i1 + 1));
      this.l = ((ViewGroup)getChildAt(i1 - 1));
      Object localObject = this.n;
      if ((localObject != null) && (((ViewGroup)localObject).getTag() != null))
      {
        this.K = ((BaseItemHolder)this.n.getTag()).Y;
        localObject = this.n.findViewById(2131431135);
        if (localObject == null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("resetVideoInstance: contentView null ！，itemType=");
          ((StringBuilder)localObject).append(((BaseItemHolder)this.n.getTag()).X);
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
        this.p = bool;
        this.C = i2;
        this.D = this.n.getTop();
      }
      this.x = false;
      this.w = false;
      if (this.M) {
        localObject = this.m;
      } else {
        localObject = this.n;
      }
      if ((localObject != null) && (((View)localObject).getTag() != null) && (((BaseItemHolder)((View)localObject).getTag()).Y == getAdapter().getCount() - 1 - getHeaderViewsCount() - getFooterViewsCount())) {
        this.x = true;
      }
      localObject = this.l;
      if ((localObject != null) && (((ViewGroup)localObject).getId() == 2131444258)) {
        this.w = true;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.t) {
      return;
    }
    if (this.q == 1) {
      return;
    }
    this.B = 1;
    a(1, paramBoolean);
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (!this.H)
    {
      this.n = ((ViewGroup)getChildAt(1));
      paramCanvas = this.n;
      if (paramCanvas == null) {
        return;
      }
      this.E = (paramCanvas.getBottom() - this.n.getTop());
      if (this.S)
      {
        paramCanvas = this.n.findViewById(2131431135);
        int i1 = Math.abs(paramCanvas.getRight() - paramCanvas.getLeft());
        int i2 = Math.abs(paramCanvas.getBottom() - paramCanvas.getTop());
        boolean bool;
        if (i1 > i2) {
          bool = true;
        } else {
          bool = false;
        }
        this.p = bool;
        this.C = i2;
        this.D = d(this.E);
        this.n.findViewById(2131434977).setVisibility(8);
        e(0);
        a(this.n, true);
        this.T = false;
      }
      else
      {
        c(this.n.getHeight());
      }
      this.H = true;
      return;
    }
    if ((!this.M) && (this.x))
    {
      b();
      if ((!this.x) && (!this.s))
      {
        paramCanvas = this.n;
        if ((paramCanvas != null) && ((paramCanvas.getTag() instanceof BaseVideoItemHolder)))
        {
          paramCanvas = this.c;
          if (paramCanvas != null)
          {
            paramCanvas = paramCanvas.iterator();
            while (paramCanvas.hasNext()) {
              ((VideoFeedsListView.ListViewEventListener)paramCanvas.next()).a(this.n.getTag());
            }
          }
        }
      }
    }
    if (!this.F)
    {
      if (!this.S)
      {
        b();
        this.D = d(this.E);
      }
      paramCanvas = this.n;
      if ((paramCanvas != null) && ((paramCanvas.getTag() instanceof BaseVideoItemHolder)))
      {
        this.n.findViewById(2131431149).setAlpha(0.0F);
        paramCanvas = this.c;
        if (paramCanvas != null)
        {
          paramCanvas = paramCanvas.iterator();
          while (paramCanvas.hasNext()) {
            ((VideoFeedsListView.ListViewEventListener)paramCanvas.next()).a(this.n.getTag());
          }
        }
        this.F = true;
      }
    }
  }
  
  public boolean getIsScrollItemToTop()
  {
    return this.S;
  }
  
  public long getLastActionDownTimeStamp()
  {
    return this.h;
  }
  
  public int getLastScrollStatus()
  {
    return this.q;
  }
  
  public View getNextView()
  {
    return this.m;
  }
  
  public View getPreView()
  {
    return this.l;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    this.h = System.currentTimeMillis();
    if (this.s) {
      return true;
    }
    if (this.t) {
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.G = false;
      this.v = false;
      this.j = paramMotionEvent.getY();
      this.u = false;
      b();
    }
    if ((paramMotionEvent.getAction() == 2) && (!this.u) && (this.n != null))
    {
      int i1 = AIOUtils.b(25.0F, this.d.getResources());
      int i2 = ViewConfiguration.getTouchSlop();
      if (Math.abs(this.j - paramMotionEvent.getY()) > i2)
      {
        float f1 = this.j;
        float f2 = i1;
        if ((f1 < f2) || (Math.abs(this.e - f1) < f2))
        {
          this.u = true;
          return true;
        }
      }
    }
    if (this.b)
    {
      if (this.S) {
        return false;
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = this.n;
    if (localObject != null)
    {
      float f2 = Math.round(Math.abs(((ViewGroup)localObject).getTop() - this.D) / this.C * 100.0F) / 100.0F;
      float f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      a(f1);
    }
    localObject = this.i;
    if (localObject != null) {
      ((AbsListView.OnScrollListener)localObject).onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 0) {
      DropFrameMonitor.b().a("list_video_feeds", false);
    } else {
      DropFrameMonitor.b().a("list_video_feeds");
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          if (this.s) {
            return;
          }
          float f1 = this.k;
          float f2 = this.j;
          if (f1 > f2)
          {
            if (!this.w) {
              a(this.l, this.J);
            } else {
              a(this.n, this.J);
            }
          }
          else if (f1 < f2) {
            if (!this.x) {
              a(this.m, this.J);
            } else {
              a(this.n, this.J);
            }
          }
          this.q = 2;
        }
      }
      else {
        this.q = 1;
      }
    }
    else
    {
      if ((this.q == 1) && (!this.s))
      {
        a(this.n, this.J);
      }
      else
      {
        this.s = false;
        this.O = false;
        if (this.G) {
          a(1.0F);
        }
        b();
        if (this.G) {
          a(0.0F);
        }
        if ((this.G) && (this.c != null) && (!this.t) && (this.n != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsPlayManager.preplay", 2, "onScrollStateChanged: onCenterViewChanged ");
          }
          localObject = this.c.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((VideoFeedsListView.ListViewEventListener)((Iterator)localObject).next()).a(this.n.getTag());
          }
        }
        if (this.N) {
          a();
        }
      }
      this.P = false;
      this.q = 0;
    }
    Object localObject = this.i;
    if (localObject != null) {
      ((AbsListView.OnScrollListener)localObject).onScrollStateChanged(paramAbsListView, paramInt);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.s) {
      return true;
    }
    if (this.t) {
      return false;
    }
    if (this.u) {
      return false;
    }
    if (this.I == null) {
      this.I = VelocityTracker.obtain();
    }
    this.I.addMovement(paramMotionEvent);
    if (this.Q == 6)
    {
      this.j = paramMotionEvent.getY();
      this.Q = paramMotionEvent.getActionMasked();
      return super.onTouchEvent(paramMotionEvent);
    }
    this.Q = paramMotionEvent.getActionMasked();
    return a(paramMotionEvent);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    getAdapter().registerDataSetObserver(new VideoFeedsListView.1(this));
  }
  
  public void setIsLastItemAsFooter(boolean paramBoolean)
  {
    this.M = paramBoolean;
  }
  
  public void setIsOrignalVideoFullScreen(boolean paramBoolean)
  {
    this.U = paramBoolean;
  }
  
  public void setIsScrollItemToTop(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.F)
    {
      if (!paramBoolean1)
      {
        this.n.findViewById(2131434977).setVisibility(0);
        if (!this.T)
        {
          this.T = true;
          c(this.E);
        }
        else
        {
          this.l = null;
          this.m = null;
          this.s = true;
          if (this.R) {
            smoothScrollBy(-this.D, 0);
          } else {
            smoothScrollBy(-this.D, 500);
          }
        }
        a(this.n, false);
        this.S = false;
      }
      else
      {
        this.S = true;
        this.E = (this.n.getBottom() - this.n.getTop());
        this.n.findViewById(2131434977).setVisibility(8);
        this.s = true;
        if (paramBoolean2) {
          smoothScrollBy(this.D, 500);
        } else {
          smoothScrollBy(this.D, 0);
        }
        a(this.n, true);
      }
    }
    else {
      this.S = paramBoolean1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setIsScrollItemToTop isScrollItemToTop=");
      ((StringBuilder)localObject).append(paramBoolean1);
      ((StringBuilder)localObject).append(", needDurationWhenScrollToTop=");
      ((StringBuilder)localObject).append(paramBoolean2);
      ((StringBuilder)localObject).append(", mFirstDrawCompleted=");
      ((StringBuilder)localObject).append(this.F);
      ((StringBuilder)localObject).append(", mIsHeaderHeightSetted=");
      ((StringBuilder)localObject).append(this.T);
      ((StringBuilder)localObject).append(", mIsNeedRecoveryScrollItemToTop=");
      ((StringBuilder)localObject).append(this.R);
      ((StringBuilder)localObject).append(", mCenterViewHeight=");
      ((StringBuilder)localObject).append(this.E);
      ((StringBuilder)localObject).append(", mContentViewHeightBefore=");
      ((StringBuilder)localObject).append(this.V);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsListView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.c;
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
    this.r = paramBoolean;
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.i = paramOnScrollListener;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsListView
 * JD-Core Version:    0.7.0.1
 */