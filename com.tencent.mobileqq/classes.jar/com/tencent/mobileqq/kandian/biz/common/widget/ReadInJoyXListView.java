package com.tencent.mobileqq.kandian.biz.common.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.api.R.styleable;
import com.tencent.mobileqq.kandian.base.tab.IRIJTabFrame;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.base.view.api.IReadInJoyLifeCycleView;
import com.tencent.mobileqq.kandian.biz.common.FluencyOptUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyListItemLifeCycle;
import com.tencent.mobileqq.kandian.biz.pts.IProteusItemView;
import com.tencent.mobileqq.kandian.biz.skin.api.IFrameHelperActivity;
import com.tencent.mobileqq.kandian.biz.skin.api.IPublicTracker;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoyRefreshAnimFactory;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoyRefreshManagerService;
import com.tencent.mobileqq.kandian.biz.skin.api.IReadInJoySkinAnimManager;
import com.tencent.mobileqq.kandian.biz.skin.api.IRefreshRes;
import com.tencent.mobileqq.kandian.glue.report.api.IReportR5Builder;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.HeaderViewListAdapter;
import com.tencent.widget.ListView;
import com.tencent.widget.ReadInJoyOverScrollViewListener;
import com.tencent.widget.pull2refresh.anim.IAnimManager;
import com.tencent.widget.pull2refresh.anim.IAnimManager.OnRefreshPullDistanceListener;
import com.tencent.widget.pull2refresh.anim.IAnimManager.PullRefreshComplete;

public class ReadInJoyXListView
  extends ReadInJoyBaseListView
  implements ReadInJoyOverScrollViewListener
{
  private View A;
  private boolean B = false;
  private IAnimManager.OnRefreshPullDistanceListener C;
  private ThreadLocal<Integer> D = new ReadInJoyXListView.1(this);
  private int E = 0;
  private IReadInJoyListItemLifeCycle F;
  private int G = -1;
  private boolean H = true;
  protected boolean m;
  protected int n = 0;
  protected int o = 0;
  public int p = -1;
  public int q = -1;
  public float[] r = new float[2];
  public float[] s = new float[2];
  public long t = 0L;
  public long u = 0L;
  protected boolean v = false;
  private Handler w;
  private boolean x;
  private boolean y;
  private IAnimManager z;
  
  public ReadInJoyXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(long paramLong)
  {
    if (this.x)
    {
      this.w.removeMessages(1);
      this.w.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  private void e(int paramInt)
  {
    if (!this.x)
    {
      if (this.B) {
        return;
      }
      this.D.set(Integer.valueOf(paramInt));
      Object localObject = ((IReadInJoyRefreshManagerService)QRoute.api(IReadInJoyRefreshManagerService.class)).getRefreshData(getContext(), 0);
      int j = 1;
      int i;
      if (localObject != null) {
        i = 1;
      } else {
        i = 0;
      }
      if (((this.z instanceof IReadInJoySkinAnimManager)) && ((paramInt == 2) || (paramInt == 3)) && (this.i == 0) && (i != 0)) {
        i = j;
      } else {
        i = 0;
      }
      int k = i;
      if (i != 0)
      {
        this.z.getPullRefreshAreaHeight();
        j = i;
        if (((IRefreshRes)QRoute.api(IRefreshRes.class)).getRefreshLengthType())
        {
          j = Aladdin.getConfig(189).getIntegerFromString("banner_refresh_length", 0);
          if (j > 0)
          {
            setOverScrollHeight((int)(DeviceInfoUtil.J() / 160.0F * j));
            j = i;
          }
          else
          {
            j = 0;
          }
        }
        k = j;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("changeRefreshAreaHeight with refreshType：");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("ReadInJoyXListView", 2, ((StringBuilder)localObject).toString());
          k = j;
        }
      }
      showOverScrollHeader();
      if (!this.v)
      {
        localObject = this.z;
        if (localObject != null) {
          ((IAnimManager)localObject).showPullRefresh();
        }
      }
      localObject = this.z;
      if ((localObject != null) && (k != 0)) {
        setOverScrollHeight(((IAnimManager)localObject).getPullRefreshAreaHeight());
      }
    }
  }
  
  private void f(int paramInt)
  {
    if (this.y)
    {
      if (this.mFirstPosition == 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("scroll2Top : stop on top,refresh ! from : ");
        localStringBuilder.append(paramInt);
        QLog.d("ReadInJoyXListView", 2, localStringBuilder.toString());
        e(1);
        this.y = false;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scroll2Top : not on top, jump to top and refresh. from : ");
      localStringBuilder.append(paramInt);
      QLog.d("ReadInJoyXListView", 2, localStringBuilder.toString());
      if (paramInt != 3)
      {
        this.y = false;
        if ((getAdapter() instanceof HeaderViewListAdapter)) {
          setAdapter(((HeaderViewListAdapter)getAdapter()).getWrappedAdapter());
        } else {
          setAdapter(getAdapter());
        }
        e(1);
        return;
      }
      g();
    }
  }
  
  private void k()
  {
    IAnimManager localIAnimManager = this.z;
    if ((localIAnimManager != null) && (!this.B))
    {
      this.A = localIAnimManager.getRefreshView(this);
      setOverScrollHeader(this.z.getRefreshView(this));
      setOverScrollListener(this);
      setOverScrollHeight(this.z.getPullRefreshAreaHeight());
      if ((this.z instanceof IReadInJoySkinAnimManager))
      {
        setOverscrollHeader(new ColorDrawable(Color.parseColor("#F7F7F7")));
        return;
      }
      setOverscrollHeader(new ColorDrawable(-1));
    }
  }
  
  private void setIsTopRefreshIng(boolean paramBoolean)
  {
    this.x = paramBoolean;
    Object localObject = Aladdin.getConfig(214);
    if (localObject != null)
    {
      int i = ((AladdinConfig)localObject).getIntegerFromString("feeds_loading", 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setIsTopRefreshIng], isOpen = ");
      ((StringBuilder)localObject).append(i);
      QLog.i("ReadInJoyXListView", 1, ((StringBuilder)localObject).toString());
      if (i == 0)
      {
        QLog.i("ReadInJoyXListView", 1, "[setIsTopRefreshIng], do not switch layer type.");
        return;
      }
    }
    RIJThreadHandler.b().post(new ReadInJoyXListView.3(this, paramBoolean));
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.bk);
    this.m = paramContext.getBoolean(R.styleable.bm, false);
    paramContext.recycle();
    this.o = ((int)DeviceInfoUtil.E());
    this.E = getLayerType();
  }
  
  public void a(IAnimManager.PullRefreshComplete paramPullRefreshComplete)
  {
    IAnimManager localIAnimManager = this.z;
    if (localIAnimManager != null) {
      localIAnimManager.registerRefreshCompleteListener(paramPullRefreshComplete);
    }
  }
  
  public void a(String paramString)
  {
    this.l = true;
    if (!TextUtils.isEmpty(paramString))
    {
      if ((this.c != null) && (this.a != null) && (this.b != null))
      {
        this.c.setVisibility(0);
        this.b.setVisibility(4);
        setFooterView(true);
        this.a.setText(paramString);
      }
    }
    else if (this.c != null) {
      removeFooterView(this.c);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((this.z != null) && (this.x))
    {
      a(Aladdin.getConfig(222).getIntegerFromString("refresh_bar_animation_total_time", 1000));
      this.z.showRefreshResult(paramBoolean, paramString);
    }
  }
  
  public IAnimManager b(int paramInt)
  {
    if (this.G == paramInt) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAnimType animType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ReadInJoyXListView", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.z;
    if ((localObject != null) && ((localObject instanceof IReadInJoySkinAnimManager))) {
      ((IAnimManager)localObject).onDestroy();
    }
    this.z = ((IReadInJoyRefreshAnimFactory)QRoute.api(IReadInJoyRefreshAnimFactory.class)).getAnimManger(getContext(), paramInt);
    localObject = this.C;
    if (localObject != null) {
      this.z.setRefreshPullDistanceListener((IAnimManager.OnRefreshPullDistanceListener)localObject);
    }
    if (this.m) {
      k();
    }
    return this.z;
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      f(2);
    }
  }
  
  public void c(int paramInt)
  {
    QLog.d("ReadInJoyXListView", 1, new Object[] { "beginRefresh, refreshType = ", Integer.valueOf(paramInt), ", mIsTopRefreshing = ", Boolean.valueOf(this.x) });
    if (this.x) {
      return;
    }
    post(new ReadInJoyXListView.2(this, paramInt));
  }
  
  public boolean c()
  {
    return this.x;
  }
  
  public void d()
  {
    IAnimManager localIAnimManager = this.z;
    if (localIAnimManager != null)
    {
      localIAnimManager.onDestroy();
      this.z = null;
    }
    this.A = null;
  }
  
  public void d(int paramInt)
  {
    if (this.x) {
      return;
    }
    smoothScrollBy(0, 0);
    setSelection(0);
    e(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scroll2TopAndRefresh needScroll : ");
    localStringBuilder.append(true);
    QLog.d("ReadInJoyXListView", 2, localStringBuilder.toString());
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) || (i == 3))
      {
        this.q = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() + getScrollY());
        this.s[0] = paramMotionEvent.getX();
        this.s[1] = paramMotionEvent.getY();
        this.u = System.currentTimeMillis();
        if (FluencyOptUtils.a.c())
        {
          i = (int)Math.abs(this.s[0] - this.r[0]);
          int j = (int)Math.abs(this.s[1] - this.r[1]);
          IReportR5Builder localIReportR5Builder = ((IReportR5Builder)QRoute.api(IReportR5Builder.class)).create();
          localIReportR5Builder.addStringNotThrow("downX", String.valueOf(this.r[0])).addStringNotThrow("downY", String.valueOf(this.r[1])).addStringNotThrow("upX", String.valueOf(this.s[0])).addStringNotThrow("upY", String.valueOf(this.s[1])).addStringNotThrow("xOffsetRate", String.valueOf(i * 100 / ViewUtils.getScreenWidth())).addStringNotThrow("yOffsetRate", String.valueOf(j * 100 / ViewUtils.getScreenHeight())).addStringNotThrow("duration", String.valueOf(this.u - this.t));
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AFD1", localIReportR5Builder.build());
        }
      }
    }
    else
    {
      this.p = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() + getScrollY());
      this.r[0] = paramMotionEvent.getX();
      this.r[1] = paramMotionEvent.getY();
      this.t = System.currentTimeMillis();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    IAnimManager localIAnimManager = this.z;
    if ((localIAnimManager != null) && ((localIAnimManager instanceof IReadInJoySkinAnimManager))) {
      ((IReadInJoySkinAnimManager)localIAnimManager).a();
    }
  }
  
  public void f()
  {
    IAnimManager localIAnimManager = this.z;
    if ((localIAnimManager != null) && ((localIAnimManager instanceof IReadInJoySkinAnimManager))) {
      ((IReadInJoySkinAnimManager)localIAnimManager).b();
    }
  }
  
  public void g()
  {
    d(1);
  }
  
  public int getTouchMode()
  {
    return this.mTouchMode;
  }
  
  public void h()
  {
    if ((this.z != null) && (this.x)) {
      a(0L);
    }
  }
  
  public void i()
  {
    setIsTopRefreshIng(false);
    springBackOverScrollHeaderView();
    if (this.g != null) {
      this.g.a();
    }
    if (!this.x)
    {
      IAnimManager localIAnimManager = this.z;
      if ((localIAnimManager != null) && (!this.v)) {
        localIAnimManager.endOfRefresh();
      }
    }
  }
  
  public void initPaddingManual()
  {
    super.initPaddingManual();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initPaddingManual  mPaddingTop=");
      localStringBuilder.append(getPaddingTop());
      localStringBuilder.append(",mListPadding.top=");
      localStringBuilder.append(this.mListPadding.top);
      QLog.d("ReadInJoyXListView", 2, localStringBuilder.toString());
    }
    if ((this.mListPadding.top == 0) && (getPaddingTop() > 0)) {
      this.mListPadding.top = getPaddingTop();
    }
    if ((this.mListPadding.bottom == 0) && (getPaddingBottom() > 0)) {
      this.mListPadding.bottom = getPaddingBottom();
    }
    if ((this.mListPadding.left == 0) && (getPaddingLeft() > 0)) {
      this.mListPadding.left = getPaddingLeft();
    }
    if ((this.mListPadding.right == 0) && (getPaddingRight() > 0)) {
      this.mListPadding.right = getPaddingRight();
    }
  }
  
  public void j()
  {
    View localView = this.A;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.B = true;
    setOverScrollHeight(0);
  }
  
  protected void onAttachChildView(View paramView)
  {
    if ((paramView instanceof IReadInJoyLifeCycleView))
    {
      IReadInJoyLifeCycleView localIReadInJoyLifeCycleView = (IReadInJoyLifeCycleView)paramView;
      if (!localIReadInJoyLifeCycleView.c())
      {
        localIReadInJoyLifeCycleView.setIsResume(true);
        localIReadInJoyLifeCycleView.a();
      }
    }
    if ((paramView instanceof IProteusItemView))
    {
      paramView = (IProteusItemView)paramView;
      if ((paramView.getModel() != null) && (paramView.getModel().k() != null) && (paramView.getModel().k().mResolvedFeedType == 123))
      {
        paramView = this.F;
        if (paramView != null) {
          paramView.a();
        }
      }
    }
  }
  
  protected void onDetachChildView(View paramView)
  {
    if ((paramView instanceof IReadInJoyLifeCycleView))
    {
      IReadInJoyLifeCycleView localIReadInJoyLifeCycleView = (IReadInJoyLifeCycleView)paramView;
      if (localIReadInJoyLifeCycleView.c())
      {
        localIReadInJoyLifeCycleView.setIsResume(false);
        localIReadInJoyLifeCycleView.b();
      }
    }
    if ((paramView instanceof IProteusItemView))
    {
      paramView = (IProteusItemView)paramView;
      if ((paramView.getModel() != null) && (paramView.getModel().k() != null) && (paramView.getModel().k().mResolvedFeedType == 123))
      {
        paramView = this.F;
        if (paramView != null) {
          paramView.b();
        }
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.w = new Handler(new ReadInJoyXListView.UICallBack(this));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.H)
    {
      ((IPublicTracker)QRoute.api(IPublicTracker.class)).trackAIO("KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE", null);
      ((IPublicTracker)QRoute.api(IPublicTracker.class)).trackAIO(null, "KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW");
      this.H = false;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onNotCompleteVisable(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    if (paramListView != this) {
      return;
    }
    paramListView = this.z;
    if ((paramListView != null) && (paramView == paramListView.getRefreshView(this)) && (!this.v)) {
      this.z.onPullRefreshing(paramInt2, this.x);
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if (paramInt1 == 0)
    {
      paramAbsListView = getChildAt(0);
      if (paramAbsListView != null) {
        paramAbsListView.getTop();
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    if (paramInt == 0)
    {
      f(3);
      if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInReadInJoyNewFeedsActivity((Activity)getContext()))
      {
        ((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).setOperationFlag(getContext(), 8);
        return;
      }
      if (((IReadInJoyHelper)QRoute.api(IReadInJoyHelper.class)).isInSplashActivity((Activity)getContext()))
      {
        paramAbsListView = ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).getReadinjoyTabFrame(getContext());
        if (paramAbsListView != null) {
          paramAbsListView.b(8);
        }
      }
    }
  }
  
  public void onScrollView(View paramView, ListView paramListView, int paramInt)
  {
    if (paramListView != this) {
      return;
    }
    paramListView = this.z;
    if ((paramListView != null) && (paramView == paramListView.getRefreshView(this)) && (!this.v)) {
      this.z.onTouchPullDistance(paramInt, this.mTouchMode);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.y)
    {
      QLog.d("ReadInJoyXListView", 2, "scroll2Top catch user touch event!");
      return true;
    }
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2) {
          this.e = ((int)paramMotionEvent.getRawY() - this.n);
        }
      }
      else
      {
        ((IFrameHelperActivity)QRoute.api(IFrameHelperActivity.class)).setDrawerFrameEnable(true);
        localIAnimManager = this.z;
        if ((localIAnimManager != null) && ((localIAnimManager instanceof IReadInJoySkinAnimManager)) && (((IReadInJoySkinAnimManager)localIAnimManager).c())) {
          return true;
        }
      }
    }
    else {
      this.n = ((int)paramMotionEvent.getRawY());
    }
    IAnimManager localIAnimManager = this.z;
    if ((localIAnimManager != null) && (localIAnimManager.onTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this) {
      return;
    }
    paramListView = this.z;
    if ((paramListView != null) && (paramView == paramListView.getRefreshView(this)) && (!this.x) && (!this.v)) {
      this.z.onPullRefreshing(100, false);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this) {
      return true;
    }
    paramInt = ((Integer)this.D.get()).intValue();
    paramListView = this.D;
    boolean bool = false;
    paramListView.set(Integer.valueOf(0));
    if (!this.x)
    {
      paramListView = this.z;
      if ((paramListView != null) && (paramView == paramListView.getRefreshView(this)))
      {
        if (!this.v)
        {
          paramView = this.z;
          if (paramInt != 0) {
            bool = true;
          }
          paramView.onPullRefreshComplete(bool);
        }
        if (this.g != null)
        {
          setIsTopRefreshIng(true);
          this.g.a(this, paramInt);
        }
      }
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (!this.x)
    {
      paramListView = this.z;
      if ((paramListView != null) && (paramView == paramListView.getRefreshView(this)) && (!this.v)) {
        this.z.onPullRefreshCancel();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      f(1);
    }
  }
  
  public void setNeedShowHeaderView(boolean paramBoolean)
  {
    this.m = paramBoolean;
    k();
  }
  
  public void setNoteCardLifeCycle(IReadInJoyListItemLifeCycle paramIReadInJoyListItemLifeCycle)
  {
    this.F = paramIReadInJoyListItemLifeCycle;
  }
  
  public void setRefreshPullDistanceListener(IAnimManager.OnRefreshPullDistanceListener paramOnRefreshPullDistanceListener)
  {
    this.C = paramOnRefreshPullDistanceListener;
    IAnimManager localIAnimManager = this.z;
    if (localIAnimManager != null) {
      localIAnimManager.setRefreshPullDistanceListener(paramOnRefreshPullDistanceListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView
 * JD-Core Version:    0.7.0.1
 */