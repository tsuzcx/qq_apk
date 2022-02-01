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
  public long a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private IReadInJoyListItemLifeCycle jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyListItemLifeCycle;
  private IAnimManager.OnRefreshPullDistanceListener jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager$OnRefreshPullDistanceListener;
  private IAnimManager jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
  private ThreadLocal<Integer> jdField_a_of_type_JavaLangThreadLocal = new ReadInJoyXListView.1(this);
  public float[] a;
  public long b;
  public float[] b;
  protected boolean d;
  protected int e;
  protected boolean e;
  protected int f;
  private boolean f;
  public int g;
  private boolean g;
  public int h;
  private boolean h;
  private int jdField_i_of_type_Int = 0;
  private boolean jdField_i_of_type_Boolean = true;
  private int j = -1;
  
  public ReadInJoyXListView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyXListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfFloat = new float[2];
    this.jdField_b_of_type_ArrayOfFloat = new float[2];
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
  }
  
  public ReadInJoyXListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_g_of_type_Int = -1;
    this.jdField_h_of_type_Int = -1;
    this.jdField_a_of_type_ArrayOfFloat = new float[2];
    this.jdField_b_of_type_ArrayOfFloat = new float[2];
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_h_of_type_Boolean = false;
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_f_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1, paramLong);
    }
  }
  
  private void c(boolean paramBoolean)
  {
    this.jdField_f_of_type_Boolean = paramBoolean;
    Object localObject = Aladdin.getConfig(214);
    if (localObject != null)
    {
      int k = ((AladdinConfig)localObject).getIntegerFromString("feeds_loading", 0);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setIsTopRefreshIng], isOpen = ");
      ((StringBuilder)localObject).append(k);
      QLog.i("ReadInJoyXListView", 1, ((StringBuilder)localObject).toString());
      if (k == 0)
      {
        QLog.i("ReadInJoyXListView", 1, "[setIsTopRefreshIng], do not switch layer type.");
        return;
      }
    }
    RIJThreadHandler.b().post(new ReadInJoyXListView.3(this, paramBoolean));
  }
  
  private void d(int paramInt)
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      if (this.jdField_h_of_type_Boolean) {
        return;
      }
      this.jdField_a_of_type_JavaLangThreadLocal.set(Integer.valueOf(paramInt));
      Object localObject = ((IReadInJoyRefreshManagerService)QRoute.api(IReadInJoyRefreshManagerService.class)).getRefreshData(getContext(), 0);
      int m = 1;
      int k;
      if (localObject != null) {
        k = 1;
      } else {
        k = 0;
      }
      if (((this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager instanceof IReadInJoySkinAnimManager)) && ((paramInt == 2) || (paramInt == 3)) && (this.jdField_d_of_type_Int == 0) && (k != 0)) {
        k = m;
      } else {
        k = 0;
      }
      int n = k;
      if (k != 0)
      {
        this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager.getPullRefreshAreaHeight();
        m = k;
        if (((IRefreshRes)QRoute.api(IRefreshRes.class)).getRefreshLengthType())
        {
          m = Aladdin.getConfig(189).getIntegerFromString("banner_refresh_length", 0);
          if (m > 0)
          {
            setOverScrollHeight((int)(DeviceInfoUtil.e() / 160.0F * m));
            m = k;
          }
          else
          {
            m = 0;
          }
        }
        n = m;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("changeRefreshAreaHeight with refreshType：");
          ((StringBuilder)localObject).append(paramInt);
          QLog.d("ReadInJoyXListView", 2, ((StringBuilder)localObject).toString());
          n = m;
        }
      }
      showOverScrollHeader();
      if (!this.jdField_e_of_type_Boolean)
      {
        localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
        if (localObject != null) {
          ((IAnimManager)localObject).showPullRefresh();
        }
      }
      localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
      if ((localObject != null) && (n != 0)) {
        setOverScrollHeight(((IAnimManager)localObject).getPullRefreshAreaHeight());
      }
    }
  }
  
  private void e(int paramInt)
  {
    if (this.jdField_g_of_type_Boolean)
    {
      if (this.mFirstPosition == 0)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("scroll2Top : stop on top,refresh ! from : ");
        localStringBuilder.append(paramInt);
        QLog.d("ReadInJoyXListView", 2, localStringBuilder.toString());
        d(1);
        this.jdField_g_of_type_Boolean = false;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("scroll2Top : not on top, jump to top and refresh. from : ");
      localStringBuilder.append(paramInt);
      QLog.d("ReadInJoyXListView", 2, localStringBuilder.toString());
      if (paramInt != 3)
      {
        this.jdField_g_of_type_Boolean = false;
        if ((getAdapter() instanceof HeaderViewListAdapter)) {
          setAdapter(((HeaderViewListAdapter)getAdapter()).getWrappedAdapter());
        } else {
          setAdapter(getAdapter());
        }
        d(1);
        return;
      }
      f();
    }
  }
  
  private void j()
  {
    IAnimManager localIAnimManager = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
    if ((localIAnimManager != null) && (!this.jdField_h_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewView = localIAnimManager.getRefreshView(this);
      setOverScrollHeader(this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager.getRefreshView(this));
      setOverScrollListener(this);
      setOverScrollHeight(this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager.getPullRefreshAreaHeight());
      if ((this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager instanceof IReadInJoySkinAnimManager))
      {
        setOverscrollHeader(new ColorDrawable(Color.parseColor("#F7F7F7")));
        return;
      }
      setOverscrollHeader(new ColorDrawable(-1));
    }
  }
  
  public int a()
  {
    return this.mTouchMode;
  }
  
  public IAnimManager a(int paramInt)
  {
    if (this.j == paramInt) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setAnimType animType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ReadInJoyXListView", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
    if ((localObject != null) && ((localObject instanceof IReadInJoySkinAnimManager))) {
      ((IAnimManager)localObject).onDestroy();
    }
    this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager = ((IReadInJoyRefreshAnimFactory)QRoute.api(IReadInJoyRefreshAnimFactory.class)).getAnimManger(getContext(), paramInt);
    localObject = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager$OnRefreshPullDistanceListener;
    if (localObject != null) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager.setRefreshPullDistanceListener((IAnimManager.OnRefreshPullDistanceListener)localObject);
    }
    if (this.jdField_d_of_type_Boolean) {
      j();
    }
    return this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
  }
  
  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    super.a(paramContext, paramAttributeSet);
    paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.bc);
    this.jdField_d_of_type_Boolean = paramContext.getBoolean(R.styleable.jdField_b_of_type_Int, false);
    paramContext.recycle();
    this.jdField_f_of_type_Int = ((int)DeviceInfoUtil.j());
    this.jdField_i_of_type_Int = getLayerType();
  }
  
  public void a(IAnimManager.PullRefreshComplete paramPullRefreshComplete)
  {
    IAnimManager localIAnimManager = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
    if (localIAnimManager != null) {
      localIAnimManager.registerRefreshCompleteListener(paramPullRefreshComplete);
    }
  }
  
  public void a(String paramString)
  {
    this.c = true;
    if (!TextUtils.isEmpty(paramString))
    {
      if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidWidgetProgressBar != null))
      {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        setFooterView(true);
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
      }
    }
    else if (this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      removeFooterView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager != null) && (this.jdField_f_of_type_Boolean))
    {
      a(Aladdin.getConfig(222).getIntegerFromString("refresh_bar_animation_total_time", 1000));
      this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager.showRefreshResult(paramBoolean, paramString);
    }
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void b(int paramInt)
  {
    QLog.d("ReadInJoyXListView", 1, new Object[] { "beginRefresh, refreshType = ", Integer.valueOf(paramInt), ", mIsTopRefreshing = ", Boolean.valueOf(this.jdField_f_of_type_Boolean) });
    if (this.jdField_f_of_type_Boolean) {
      return;
    }
    post(new ReadInJoyXListView.2(this, paramInt));
  }
  
  public void b(boolean paramBoolean)
  {
    if (!paramBoolean) {
      e(2);
    }
  }
  
  public void c()
  {
    IAnimManager localIAnimManager = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
    if (localIAnimManager != null)
    {
      localIAnimManager.onDestroy();
      this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager = null;
    }
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void c(int paramInt)
  {
    if (this.jdField_f_of_type_Boolean) {
      return;
    }
    smoothScrollBy(0, 0);
    setSelection(0);
    d(paramInt);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scroll2TopAndRefresh needScroll : ");
    localStringBuilder.append(true);
    QLog.d("ReadInJoyXListView", 2, localStringBuilder.toString());
  }
  
  public void d()
  {
    IAnimManager localIAnimManager = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
    if ((localIAnimManager != null) && ((localIAnimManager instanceof IReadInJoySkinAnimManager))) {
      ((IReadInJoySkinAnimManager)localIAnimManager).a();
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int k = paramMotionEvent.getAction();
    if (k != 0)
    {
      if ((k == 1) || (k == 3))
      {
        this.jdField_h_of_type_Int = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() + getScrollY());
        this.jdField_b_of_type_ArrayOfFloat[0] = paramMotionEvent.getX();
        this.jdField_b_of_type_ArrayOfFloat[1] = paramMotionEvent.getY();
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        if (FluencyOptUtils.a.c())
        {
          k = (int)Math.abs(this.jdField_b_of_type_ArrayOfFloat[0] - this.jdField_a_of_type_ArrayOfFloat[0]);
          int m = (int)Math.abs(this.jdField_b_of_type_ArrayOfFloat[1] - this.jdField_a_of_type_ArrayOfFloat[1]);
          IReportR5Builder localIReportR5Builder = ((IReportR5Builder)QRoute.api(IReportR5Builder.class)).create();
          localIReportR5Builder.addStringNotThrow("downX", String.valueOf(this.jdField_a_of_type_ArrayOfFloat[0])).addStringNotThrow("downY", String.valueOf(this.jdField_a_of_type_ArrayOfFloat[1])).addStringNotThrow("upX", String.valueOf(this.jdField_b_of_type_ArrayOfFloat[0])).addStringNotThrow("upY", String.valueOf(this.jdField_b_of_type_ArrayOfFloat[1])).addStringNotThrow("xOffsetRate", String.valueOf(k * 100 / ViewUtils.a())).addStringNotThrow("yOffsetRate", String.valueOf(m * 100 / ViewUtils.b())).addStringNotThrow("duration", String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AFD1", localIReportR5Builder.build());
        }
      }
    }
    else
    {
      this.jdField_g_of_type_Int = pointToPosition((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY() + getScrollY());
      this.jdField_a_of_type_ArrayOfFloat[0] = paramMotionEvent.getX();
      this.jdField_a_of_type_ArrayOfFloat[1] = paramMotionEvent.getY();
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    IAnimManager localIAnimManager = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
    if ((localIAnimManager != null) && ((localIAnimManager instanceof IReadInJoySkinAnimManager))) {
      ((IReadInJoySkinAnimManager)localIAnimManager).b();
    }
  }
  
  public void f()
  {
    c(1);
  }
  
  public void g()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager != null) && (this.jdField_f_of_type_Boolean)) {
      a(0L);
    }
  }
  
  public void h()
  {
    c(false);
    springBackOverScrollHeaderView();
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$RefreshCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$RefreshCallback.a();
    }
    if (!this.jdField_f_of_type_Boolean)
    {
      IAnimManager localIAnimManager = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
      if ((localIAnimManager != null) && (!this.jdField_e_of_type_Boolean)) {
        localIAnimManager.endOfRefresh();
      }
    }
  }
  
  public void i()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.jdField_h_of_type_Boolean = true;
    setOverScrollHeight(0);
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
  
  protected void onAttachChildView(View paramView)
  {
    if ((paramView instanceof IReadInJoyLifeCycleView))
    {
      IReadInJoyLifeCycleView localIReadInJoyLifeCycleView = (IReadInJoyLifeCycleView)paramView;
      if (!localIReadInJoyLifeCycleView.a())
      {
        localIReadInJoyLifeCycleView.setIsResume(true);
        localIReadInJoyLifeCycleView.a();
      }
    }
    if ((paramView instanceof IProteusItemView))
    {
      paramView = (IProteusItemView)paramView;
      if ((paramView.a() != null) && (paramView.a().a() != null) && (paramView.a().a().mResolvedFeedType == 123))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyListItemLifeCycle;
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
      if (localIReadInJoyLifeCycleView.a())
      {
        localIReadInJoyLifeCycleView.setIsResume(false);
        localIReadInJoyLifeCycleView.b();
      }
    }
    if ((paramView instanceof IProteusItemView))
    {
      paramView = (IProteusItemView)paramView;
      if ((paramView.a() != null) && (paramView.a().a() != null) && (paramView.a().a().mResolvedFeedType == 123))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyListItemLifeCycle;
        if (paramView != null) {
          paramView.b();
        }
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(new ReadInJoyXListView.UICallBack(this));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.jdField_i_of_type_Boolean)
    {
      ((IPublicTracker)QRoute.api(IPublicTracker.class)).trackAIO("KANDIAN_NEW_FEEDS_LOAD_ARTICLE_FINISH_TO_MEASURE", null);
      ((IPublicTracker)QRoute.api(IPublicTracker.class)).trackAIO(null, "KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW");
      this.jdField_i_of_type_Boolean = false;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView) {}
  
  public void onNotCompleteVisable(int paramInt1, View paramView, ListView paramListView, int paramInt2)
  {
    if (paramListView != this) {
      return;
    }
    paramListView = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
    if ((paramListView != null) && (paramView == paramListView.getRefreshView(this)) && (!this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager.onPullRefreshing(paramInt2, this.jdField_f_of_type_Boolean);
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
      e(3);
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
    paramListView = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
    if ((paramListView != null) && (paramView == paramListView.getRefreshView(this)) && (!this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager.onTouchPullDistance(paramInt, this.mTouchMode);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_g_of_type_Boolean)
    {
      QLog.d("ReadInJoyXListView", 2, "scroll2Top catch user touch event!");
      return true;
    }
    int k = paramMotionEvent.getAction();
    if (k != 0)
    {
      if (k != 1)
      {
        if (k == 2) {
          this.jdField_b_of_type_Int = ((int)paramMotionEvent.getRawY() - this.jdField_e_of_type_Int);
        }
      }
      else
      {
        ((IFrameHelperActivity)QRoute.api(IFrameHelperActivity.class)).setDrawerFrameEnable(true);
        localIAnimManager = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
        if ((localIAnimManager != null) && ((localIAnimManager instanceof IReadInJoySkinAnimManager)) && (((IReadInJoySkinAnimManager)localIAnimManager).a())) {
          return true;
        }
      }
    }
    else {
      this.jdField_e_of_type_Int = ((int)paramMotionEvent.getRawY());
    }
    IAnimManager localIAnimManager = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
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
    paramListView = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
    if ((paramListView != null) && (paramView == paramListView.getRefreshView(this)) && (!this.jdField_f_of_type_Boolean) && (!this.jdField_e_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager.onPullRefreshing(100, false);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (paramListView != this) {
      return true;
    }
    paramInt = ((Integer)this.jdField_a_of_type_JavaLangThreadLocal.get()).intValue();
    paramListView = this.jdField_a_of_type_JavaLangThreadLocal;
    boolean bool = false;
    paramListView.set(Integer.valueOf(0));
    if (!this.jdField_f_of_type_Boolean)
    {
      paramListView = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
      if ((paramListView != null) && (paramView == paramListView.getRefreshView(this)))
      {
        if (!this.jdField_e_of_type_Boolean)
        {
          paramView = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
          if (paramInt != 0) {
            bool = true;
          }
          paramView.onPullRefreshComplete(bool);
        }
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$RefreshCallback != null)
        {
          c(true);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyBaseListView$RefreshCallback.a(this, paramInt);
        }
      }
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      paramListView = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
      if ((paramListView != null) && (paramView == paramListView.getRefreshView(this)) && (!this.jdField_e_of_type_Boolean)) {
        this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager.onPullRefreshCancel();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {
      e(1);
    }
  }
  
  public void setNeedShowHeaderView(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    j();
  }
  
  public void setNoteCardLifeCycle(IReadInJoyListItemLifeCycle paramIReadInJoyListItemLifeCycle)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyListItemLifeCycle = paramIReadInJoyListItemLifeCycle;
  }
  
  public void setRefreshPullDistanceListener(IAnimManager.OnRefreshPullDistanceListener paramOnRefreshPullDistanceListener)
  {
    this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager$OnRefreshPullDistanceListener = paramOnRefreshPullDistanceListener;
    IAnimManager localIAnimManager = this.jdField_a_of_type_ComTencentWidgetPull2refreshAnimIAnimManager;
    if (localIAnimManager != null) {
      localIAnimManager.setRefreshPullDistanceListener(paramOnRefreshPullDistanceListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView
 * JD-Core Version:    0.7.0.1
 */