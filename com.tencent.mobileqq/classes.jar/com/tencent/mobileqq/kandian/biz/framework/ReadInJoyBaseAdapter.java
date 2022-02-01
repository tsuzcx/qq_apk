package com.tencent.mobileqq.kandian.biz.framework;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationSet;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.biz.pubaccount.util.FeedExposureHelper;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdShakeManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.entity.IRecommendADVideoFeedsManager;
import com.tencent.mobileqq.kandian.base.annotation.IgnoreDenyDependencyToSelf;
import com.tencent.mobileqq.kandian.base.view.api.IReadInJoyLifeCycleView;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJReportDataCollectionManager;
import com.tencent.mobileqq.kandian.biz.ad.entity.IExposureSupplementManager;
import com.tencent.mobileqq.kandian.biz.common.CustomAnimationAdapter;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyListItemLifeCycle;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyBaseListView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeAnimation;
import com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyFeedbackPopupWindow;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyFeedsActivity;
import com.tencent.mobileqq.kandian.biz.framework.click.ClickHandler;
import com.tencent.mobileqq.kandian.biz.framework.click.ListenerBuilder;
import com.tencent.mobileqq.kandian.biz.framework.click.RIJFrameworkHandleClick;
import com.tencent.mobileqq.kandian.biz.framework.handlers.RIJInvokeHandler;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.biz.pts.lite.PTSLiteItemViewBuilder;
import com.tencent.mobileqq.kandian.biz.pts.util.DynamicItemViewHelper;
import com.tencent.mobileqq.kandian.biz.video.RIJConfigVideoItem;
import com.tencent.mobileqq.kandian.biz.video.RIJFullVideoPlayActivity;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsReporter;
import com.tencent.mobileqq.kandian.biz.video.click.RIJVideoHandleClick;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.viewholder.BigImgVideoColumnItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.BigImgVideoItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoColumnItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsTwoItemViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.VideoFeedsViewHolder;
import com.tencent.mobileqq.kandian.biz.video.viewholder.WeishiGridTwoItemViewHolder;
import com.tencent.mobileqq.kandian.glue.businesshandler.HandlerFactory;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.utils.ReadInJoyBaseAdapterUtil;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJFeedsFluencyOptimizeUtil;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJBaseItemViewType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.KandianNegativeWindow;
import com.tencent.widget.KandianNegativeWindowForAd;
import com.tencent.widget.ListView;
import com.tencent.widget.TraceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@IgnoreDenyDependencyToSelf
public abstract class ReadInJoyBaseAdapter
  extends CustomAnimationAdapter
  implements View.OnClickListener, View.OnLongClickListener, IReadInJoyBaseAdapter
{
  public static int a = 20;
  public static int b = 250;
  public static int k = 1000;
  public static float s = ;
  public static DynamicItemViewHelper t = new DynamicItemViewHelper();
  private Object A;
  private IReadInJoyListItemLifeCycle B;
  private ArrayList<IReadInJoyListItemLifeCycle> C = new ArrayList();
  private HashMap<Integer, ClickHandler> D = new HashMap();
  private RIJShakeManager E;
  private RIJProteusParserObserver F;
  private boolean G;
  private ReadInJoyObserver H = new ReadInJoyBaseAdapter.2(this);
  protected int c = -1;
  protected int d = 0;
  protected Activity e;
  protected LayoutInflater f;
  protected boolean g = false;
  protected Set<Long> h;
  protected ReadInJoyXListView i;
  protected IRecommendADVideoFeedsManager j;
  public GdtHandler.Params l;
  public long m = -2147483648L;
  protected RIJDataManager n;
  protected RIJFrameworkHandleClick o;
  protected RIJVideoHandleClick p;
  protected ListenerBuilder q;
  public RIJOnScrollListener r;
  protected RIJInvokeHandler u;
  public boolean v = false;
  public HashSet<String> w = new HashSet();
  public HashSet<String> x = new HashSet();
  public long y = 0L;
  private long z = -1L;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {
      s = 0.025F;
    }
  }
  
  public ReadInJoyBaseAdapter(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<IBaseHandler> paramSparseArray)
  {
    this.e = paramActivity;
    this.f = paramLayoutInflater;
    this.c = paramInt;
    paramLayoutInflater = new ReadInjoyContext();
    paramLayoutInflater.setContext(paramActivity);
    paramLayoutInflater.setCurActivity(paramActivity);
    ProteusSupportUtil.a(paramLayoutInflater, "default_feeds");
    t.a(paramLayoutInflater);
    paramActivity = (ReadInJoyXListView)paramListView;
    this.i = paramActivity;
    this.h = new HashSet();
    this.u = new RIJInvokeHandler();
    this.u.a(paramSparseArray, this);
    paramListView = new RIJPreloadImage();
    paramListView.b();
    paramSparseArray = new RIJDislikeManager();
    this.n = new RIJDataManager(new RIJDataManager.Builder().a(this.e).a(this.c).a(this.u.c().E()).a(this.u.c().A()).a(this).a(this.u.c().C()).a(this.u.c().D()).a(this.u.c().B()).a(t).a(paramListView).a(paramLayoutInflater).a(paramSparseArray).a(this.u.c().F()));
    this.o = new RIJFrameworkHandleClick(this.n);
    this.p = new RIJVideoHandleClick(this.n);
    this.E = new RIJShakeManager(this.n);
    this.F = new RIJProteusParserObserver(this);
    this.r = new RIJOnScrollListener(this.n);
    paramActivity.a(this.r);
    paramActivity.a(this.n.c);
    paramActivity.setOnDrawCompleteListener(this.n.c());
    paramActivity.a(new RIJOnScrollChangeListener(this.n));
    ReadInJoyLogicEngineEventDispatcher.a().a(this.H);
  }
  
  private int a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int i2 = ReadInJoyBaseAdapterUtil.a.a(paramAbsBaseArticleInfo, i(), false);
    int i1 = i2;
    if (this.u.c().a(i2, paramInt)) {
      i1 = 119;
    }
    return i1;
  }
  
  public static VideoPlayParam a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return RIJConfigVideoItem.a(paramAbsBaseArticleInfo);
  }
  
  public static VideoPlayParam a(AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    return RIJConfigVideoItem.a(paramAbsBaseArticleInfo, paramBoolean);
  }
  
  public static String a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if ((t != null) && (DynamicItemViewHelper.a(paramAbsBaseArticleInfo)))
    {
      paramAbsBaseArticleInfo = t.d(paramAbsBaseArticleInfo);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("getProteusFamilyCardViewType | dynamic viewType : ");
      localStringBuilder.append(paramAbsBaseArticleInfo);
      QLog.d("ReadInJoyBaseAdapter", 2, localStringBuilder.toString());
      return paramAbsBaseArticleInfo;
    }
    paramAbsBaseArticleInfo = String.valueOf(RIJBaseItemViewType.a(paramAbsBaseArticleInfo, paramInt));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getProteusFamilyCardViewType | normal viewType : ");
    localStringBuilder.append(paramAbsBaseArticleInfo);
    QLog.d("ReadInJoyBaseAdapter", 2, localStringBuilder.toString());
    return paramAbsBaseArticleInfo;
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.insertAction != null))
    {
      if (!paramAbsBaseArticleInfo.hasInsertAnimated)
      {
        QLog.d("ReadInJoyBaseAdapter", 1, "insert animation");
        a(paramAbsBaseArticleInfo, paramView, paramView.getMeasuredHeight());
        paramAbsBaseArticleInfo.curHeight = 1;
        paramView.setMinimumHeight(1);
        paramAbsBaseArticleInfo.hasInsertAnimated = true;
      }
      ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
      if (localLayoutParams != null)
      {
        localLayoutParams.height = paramAbsBaseArticleInfo.curHeight;
        paramView.setLayoutParams(localLayoutParams);
      }
      else
      {
        paramView.setLayoutParams(new AbsListView.LayoutParams(-2, paramAbsBaseArticleInfo.curHeight));
      }
      paramAbsBaseArticleInfo = new StringBuilder();
      paramAbsBaseArticleInfo.append("insert curHeight: ");
      paramAbsBaseArticleInfo.append(paramView.getLayoutParams());
      int i1;
      if (paramAbsBaseArticleInfo.toString() != null) {
        i1 = paramView.getLayoutParams().height;
      } else {
        i1 = -1;
      }
      QLog.d("ReadInJoyBaseAdapter", 1, new Object[] { Integer.valueOf(i1) });
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, View paramView, int paramInt)
  {
    if (paramView != null)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "translationX", new float[] { paramView.getMeasuredWidth(), 0.0F });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 0.0F, 1.0F });
      paramAbsBaseArticleInfo = ObjectAnimator.ofInt(paramView, new ReadInJoyBaseAdapter.HeightProperty(paramAbsBaseArticleInfo), new int[] { 1, paramInt });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, paramAbsBaseArticleInfo });
      localAnimatorSet.setTarget(paramView);
      localAnimatorSet.setDuration(360L);
      localAnimatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
      localAnimatorSet.start();
    }
  }
  
  private void a(boolean paramBoolean, Object... paramVarArgs)
  {
    try
    {
      if (c() != 0) {
        return;
      }
      if ((paramVarArgs != null) && (paramVarArgs.length > 2))
      {
        localObject = paramVarArgs[0];
        if ((localObject instanceof AbsBaseArticleInfo))
        {
          localObject = (AbsBaseArticleInfo)localObject;
          VideoPlayParam localVideoPlayParam = a((AbsBaseArticleInfo)localObject);
          localVideoPlayParam.W.putFloat("currentPlayTime", ((Float)paramVarArgs[1]).floatValue());
          localVideoPlayParam.W.putString("forceViola", "1");
          localVideoPlayParam.W.putFloat("playRate", ((Float)paramVarArgs[2]).floatValue());
          a(localVideoPlayParam, (AbsBaseArticleInfo)localObject, false, paramBoolean);
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("jump3Video,params error!  params=");
        ((StringBuilder)localObject).append(paramVarArgs);
        QLog.d("ReadInJoyBaseAdapter", 1, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception paramVarArgs)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jump3Video,error=");
      ((StringBuilder)localObject).append(paramVarArgs);
      QLog.d("ReadInJoyBaseAdapter", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void b(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.feedsFirstExposurePos == -1)) {
      paramAbsBaseArticleInfo.feedsFirstExposurePos = paramInt;
    }
    ReadinjoyReportUtils.a(paramAbsBaseArticleInfo, ReadinjoyReportUtils.e, false, "");
  }
  
  public boolean A()
  {
    return this.n.a().f();
  }
  
  public KandianNegativeWindow B()
  {
    return this.n.a().e().a(a());
  }
  
  public KandianNegativeWindowForAd C()
  {
    return this.n.a().e().b(a());
  }
  
  public ReadInJoyFeedbackPopupWindow D()
  {
    return this.n.a().e().a(a(), this);
  }
  
  public RIJDataManager E()
  {
    return this.n;
  }
  
  public VafContext F()
  {
    return this.n.a().g();
  }
  
  public DynamicItemViewHelper G()
  {
    return this.n.a().o();
  }
  
  public boolean H()
  {
    return this.n.a().a();
  }
  
  public void I()
  {
    this.u.c().K();
  }
  
  public boolean J()
  {
    return this.G;
  }
  
  public void K()
  {
    this.u.c().H();
  }
  
  public AbsBaseArticleInfo L()
  {
    return this.n.a(a());
  }
  
  public void M()
  {
    Object localObject = this.j;
    if (localObject != null) {
      ((IRecommendADVideoFeedsManager)localObject).b();
    }
    if (this.g) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Q.readinjoy.video_");
      ((StringBuilder)localObject).append(this.c);
      QLog.d(((StringBuilder)localObject).toString(), 2, "ReadInJoyBaseAdapter doOnResume()");
    }
    if (ReadInJoyHelper.w()) {
      RIJReportDataCollectionManager.a(this.i.getFirstVisiblePosition(), this.i.getHeaderViewsCount(), this.i.getChildCount(), this.n);
    }
    this.g = true;
    if (Build.VERSION.SDK_INT < 21) {
      this.i.setFriction(s);
    }
    this.r.a().a(this.i, 4);
    int i3 = 0;
    this.v = false;
    this.n.a().c(false);
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= this.i.getChildCount()) {
        break;
      }
      localObject = this.i.getChildAt(i1);
      if ((localObject instanceof IReadInJoyLifeCycleView))
      {
        localObject = (IReadInJoyLifeCycleView)localObject;
        if (!((IReadInJoyLifeCycleView)localObject).c())
        {
          ((IReadInJoyLifeCycleView)localObject).setIsResume(true);
          ((IReadInJoyLifeCycleView)localObject).a();
        }
      }
      i1 += 1;
    }
    while (i2 < this.C.size())
    {
      ((IReadInJoyListItemLifeCycle)this.C.get(i2)).a();
      i2 += 1;
    }
    localObject = this.B;
    if (localObject != null) {
      ((IReadInJoyListItemLifeCycle)localObject).a();
    }
    this.E.a();
    this.F.a();
  }
  
  public void N()
  {
    Object localObject = this.j;
    if (localObject != null) {
      ((IRecommendADVideoFeedsManager)localObject).c();
    }
    if (!this.g) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Q.readinjoy.video_");
      ((StringBuilder)localObject).append(this.c);
      QLog.d(((StringBuilder)localObject).toString(), 2, "ReadInJoyBaseAdapter doOnPause()");
    }
    int i3 = 0;
    this.g = false;
    if ((this.n.a().e().a(a()) != null) && (this.n.a().e().a(a()).isShowing())) {
      this.n.a().e().a(a()).dismiss();
    }
    this.r.a().a(this.i, 5);
    if ((!ReadInJoyHelper.E()) && (ProteusSupportUtil.b(this.n.a().g(), "default_feeds")))
    {
      QLog.d("ReadInJoyBaseAdapter", 2, "hasRefresh notifyDataSetChanged");
      notifyDataSetChanged();
    }
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= this.i.getChildCount()) {
        break;
      }
      localObject = this.i.getChildAt(i1);
      if ((localObject instanceof IReadInJoyLifeCycleView))
      {
        localObject = (IReadInJoyLifeCycleView)localObject;
        if (((IReadInJoyLifeCycleView)localObject).c())
        {
          ((IReadInJoyLifeCycleView)localObject).setIsResume(false);
          ((IReadInJoyLifeCycleView)localObject).b();
        }
      }
      i1 += 1;
    }
    while (i2 < this.C.size())
    {
      ((IReadInJoyListItemLifeCycle)this.C.get(i2)).b();
      i2 += 1;
    }
    localObject = this.B;
    if (localObject != null) {
      ((IReadInJoyListItemLifeCycle)localObject).b();
    }
    this.E.b();
    this.F.b();
  }
  
  public boolean O()
  {
    return this.g;
  }
  
  public void P()
  {
    this.u.c().L();
  }
  
  public void Q()
  {
    if ((this.u.c().A() != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(this.c)))
    {
      ((IRIJAdShakeManager)QRoute.api(IRIJAdShakeManager.class)).reportNegative();
      P();
    }
  }
  
  public VideoPlayManager R()
  {
    return this.u.c().A();
  }
  
  public IRecommendADVideoFeedsManager S()
  {
    return this.j;
  }
  
  public void T()
  {
    ReadInJoyXListView localReadInJoyXListView = this.i;
    if (localReadInJoyXListView != null) {
      localReadInJoyXListView.d(7);
    }
  }
  
  public void U()
  {
    this.n.f();
  }
  
  public void V()
  {
    this.u.c().y();
  }
  
  public void W()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.H);
  }
  
  public abstract Activity a();
  
  public AbsBaseArticleInfo a(int paramInt)
  {
    return this.n.c(paramInt);
  }
  
  public abstract AbsBaseArticleInfo a(int paramInt, long paramLong);
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.u.c().a(paramInt, paramIntent);
  }
  
  public abstract void a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo, ArrayList<DislikeInfo> paramArrayList);
  
  public abstract void a(int paramInt, ArrayList<AbsBaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1);
  
  public void a(int paramInt, ArrayList<AbsBaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject)
  {
    b(paramInt, paramArrayList, paramArrayList1, paramObject, false, true);
  }
  
  public void a(int paramInt, ArrayList<AbsBaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean)
  {
    b(paramInt, paramArrayList, paramArrayList1, paramObject, paramBoolean, true);
  }
  
  public void a(int paramInt, @Nullable ArrayList<AbsBaseArticleInfo> paramArrayList, @Nullable ArrayList<DislikeInfo> paramArrayList1, @Nullable Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    b(paramInt, paramArrayList, paramArrayList1, paramObject, paramBoolean1, paramBoolean2);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.u.c().b(paramInt, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    this.m = paramLong;
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    Q();
    this.n.a(paramAdvertisementInfo, this.i);
  }
  
  public void a(IExposureSupplementManager paramIExposureSupplementManager)
  {
    if ((paramIExposureSupplementManager instanceof IExposureSupplementManager)) {
      this.n.a().a(paramIExposureSupplementManager);
    }
  }
  
  public void a(IReadInJoyListItemLifeCycle paramIReadInJoyListItemLifeCycle)
  {
    this.B = paramIReadInJoyListItemLifeCycle;
    ReadInJoyXListView localReadInJoyXListView = this.i;
    if (localReadInJoyXListView != null) {
      localReadInJoyXListView.setNoteCardLifeCycle(paramIReadInJoyListItemLifeCycle);
    }
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    this.u.a(paramReadInJoyBaseListView);
  }
  
  public void a(PrefetchListener paramPrefetchListener)
  {
    this.n.a().a(paramPrefetchListener);
  }
  
  public void a(ListenerBuilder paramListenerBuilder)
  {
    this.q = paramListenerBuilder;
  }
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    if ((this.n.a().e().a(a()) != null) && (this.n.a().e().a(a()).isShowing())) {
      this.n.a().e().a(a()).dismiss();
    }
    if ((this.n.a().e().b(a()) != null) && (this.n.a().e().b(a()).isShowing())) {
      this.n.a().e().b(a()).dismiss();
    }
    this.u.c().a(paramVideoPlayParam);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    this.u.c().a(paramVideoPlayParam, paramInt);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2)
  {
    this.u.c().a(paramVideoPlayParam1, paramVideoPlayParam2);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    a(paramVideoPlayParam, paramAbsBaseArticleInfo, false, true);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramAbsBaseArticleInfo instanceof BaseArticleInfo)) {
      RIJFullVideoPlayActivity.a(paramVideoPlayParam, paramAbsBaseArticleInfo, paramBoolean1, this.n);
    }
  }
  
  public void a(BigImgVideoColumnItemViewHolder paramBigImgVideoColumnItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    RIJConfigVideoItem.a(paramBigImgVideoColumnItemViewHolder, paramAbsBaseArticleInfo, this.n, this, this);
  }
  
  public void a(BigImgVideoItemViewHolder paramBigImgVideoItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    RIJConfigVideoItem.a(paramBigImgVideoItemViewHolder, paramAbsBaseArticleInfo, this.n, this, this);
  }
  
  public void a(VideoColumnItemViewHolder paramVideoColumnItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    RIJConfigVideoItem.a(paramVideoColumnItemViewHolder, paramAbsBaseArticleInfo, this.n, this, this);
  }
  
  public void a(VideoFeedsTwoItemViewHolder paramVideoFeedsTwoItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    RIJConfigVideoItem.a(paramVideoFeedsTwoItemViewHolder, paramAbsBaseArticleInfo, this.n, this);
  }
  
  public void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    RIJConfigVideoItem.a(paramVideoFeedsViewHolder, paramAbsBaseArticleInfo, this.n, this, this, this.h);
  }
  
  public void a(WeishiGridTwoItemViewHolder paramWeishiGridTwoItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    RIJConfigVideoItem.a(paramWeishiGridTwoItemViewHolder, paramAbsBaseArticleInfo, this.n, this, this);
  }
  
  public void a(VideoPlayManager paramVideoPlayManager, VideoAutoPlayController paramVideoAutoPlayController)
  {
    this.n.a().a(paramVideoPlayManager).a(paramVideoAutoPlayController).a(this.u.c().F());
    this.u.c().a(paramVideoPlayManager, paramVideoAutoPlayController);
    paramVideoPlayManager = this.u.c().A();
    if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(c())) && (paramVideoPlayManager != null))
    {
      this.j = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createRecommendADVideoFeedsManager(this.e, this, paramVideoPlayManager, this.i, c());
      this.u.c().A().a(this.j);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, boolean paramBoolean)
  {
    this.n.a(paramAbsBaseArticleInfo1, paramAbsBaseArticleInfo2, paramBoolean);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel, long paramLong, int paramInt)
  {
    RIJReportDataCollectionManager.a(paramAbsBaseArticleInfo, paramIReadInJoyModel, paramLong, paramInt, this.n);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.u.c().b(paramAbsListView, paramInt);
  }
  
  public void a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof GdtHandler.Params)) {
      this.l = ((GdtHandler.Params)paramObject);
    }
  }
  
  public void a(String paramString)
  {
    this.w.add(paramString);
  }
  
  public void a(@NotNull HashMap<String, Long> paramHashMap)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!this.w.contains(str)) {
        this.x.add(str);
      }
    }
    localIterator = this.x.iterator();
    while (localIterator.hasNext()) {
      paramHashMap.remove((String)localIterator.next());
    }
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    this.n.a(paramList);
    this.u.a(paramList);
  }
  
  public void a(List<AbsBaseArticleInfo> paramList, int paramInt)
  {
    this.n.a(paramList, paramInt);
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    this.n.a().a(paramSet, paramMap);
  }
  
  public void a(boolean paramBoolean)
  {
    this.n.a().c(paramBoolean);
  }
  
  public void a(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    RIJVideoReportManager.a(paramBoolean, paramAbsBaseArticleInfo, a(), this.c, this.z);
  }
  
  public void a(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, String paramString, Map<String, Object> paramMap)
  {
    RIJVideoReportManager.a(paramBoolean, paramAbsBaseArticleInfo1, paramAbsBaseArticleInfo2, paramString, paramMap, this.n);
  }
  
  public List<AbsBaseArticleInfo> b()
  {
    return (List)this.n.b();
  }
  
  public void b(int paramInt, ArrayList<AbsBaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.n.b(paramInt, paramArrayList, paramArrayList1, paramObject, paramBoolean1, paramBoolean2);
  }
  
  public void b(long paramLong)
  {
    this.y = paramLong;
  }
  
  public void b(IReadInJoyListItemLifeCycle paramIReadInJoyListItemLifeCycle)
  {
    this.C.add(paramIReadInJoyListItemLifeCycle);
  }
  
  public void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.n.b().remove(paramAbsBaseArticleInfo);
    notifyDataSetChanged();
    this.n.a().e(true);
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    this.u.c().c(paramAbsListView, paramInt);
  }
  
  public void b(Object paramObject)
  {
    this.A = paramObject;
  }
  
  public void b(List<AbsBaseArticleInfo> paramList)
  {
    this.n.b(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    this.n.a().f(paramBoolean);
  }
  
  public abstract boolean b(int paramInt, long paramLong);
  
  public int c()
  {
    return this.c;
  }
  
  public abstract int c(int paramInt);
  
  public void c(int paramInt, ArrayList<AbsBaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.n.a(paramInt, paramArrayList, paramArrayList1, paramObject, paramBoolean1, paramBoolean2);
  }
  
  public void c(long paramLong)
  {
    this.z = paramLong;
    this.n.a().a(this.z);
  }
  
  public void c(IReadInJoyListItemLifeCycle paramIReadInJoyListItemLifeCycle)
  {
    this.C.remove(paramIReadInJoyListItemLifeCycle);
  }
  
  public void c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    RIJVideoReportManager.a(paramAbsBaseArticleInfo, a(), this.c);
  }
  
  public void c(boolean paramBoolean)
  {
    this.n.a().g(paramBoolean);
  }
  
  public abstract boolean c(int paramInt, long paramLong);
  
  public Bitmap d(long paramLong)
  {
    return null;
  }
  
  public ListView d()
  {
    return this.i;
  }
  
  public void d(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void d(boolean paramBoolean)
  {
    this.n.a().d(paramBoolean);
  }
  
  public String e(long paramLong)
  {
    return null;
  }
  
  public void e(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void e(boolean paramBoolean)
  {
    this.u.c().b(paramBoolean);
  }
  
  public long f()
  {
    return this.u.c().Q();
  }
  
  public boolean f(int paramInt)
  {
    return paramInt == 46;
  }
  
  public Object g()
  {
    return this.l;
  }
  
  public int getCount()
  {
    return this.n.e();
  }
  
  public Object getItem(int paramInt)
  {
    return this.n.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.n.b(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    int i2 = c(paramInt);
    int i1 = i2;
    if (this.u.c().a(i2, paramInt)) {
      i1 = 119;
    }
    return i1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TraceUtils.traceBegin("ReadInJoyBaseAdapter.getView");
    System.currentTimeMillis();
    b(a(paramInt), paramInt);
    AbsBaseArticleInfo localAbsBaseArticleInfo = a(paramInt);
    int i1 = a(paramInt, localAbsBaseArticleInfo);
    ReadInJoyModelImpl localReadInJoyModelImpl = this.n.a(localAbsBaseArticleInfo, i1, paramInt);
    RIJFeedsFluencyOptimizeUtil.a.a(localAbsBaseArticleInfo, i1);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getView:  pos: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(localAbsBaseArticleInfo);
      localStringBuilder.append(" type= ");
      localStringBuilder.append(i1);
      QLog.d("ReadInJoyBaseAdapter", 2, localStringBuilder.toString());
    }
    paramViewGroup = (View)HandlerFactory.a(this.u.a(), new ReadInJoyBaseAdapter.1(this, "onAdapterGetView", i1, localAbsBaseArticleInfo, paramInt, paramView, paramViewGroup));
    this.u.a(paramViewGroup, paramView, localAbsBaseArticleInfo, paramInt);
    if (paramViewGroup != null)
    {
      RIJReportDataCollectionManager.a(localAbsBaseArticleInfo, localReadInJoyModelImpl, System.currentTimeMillis(), paramInt, this.n);
      paramViewGroup = super.a(paramViewGroup, paramInt);
      RIJReportDataCollectionManager.a(paramViewGroup, i1, localAbsBaseArticleInfo, this.n);
      TextHook.updateFont(paramView);
      TraceUtils.traceEnd();
      a(localAbsBaseArticleInfo, paramViewGroup);
      return paramViewGroup;
    }
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("get view has error, return then convert view， viewType : ");
    paramViewGroup.append(i1);
    QLog.d("ReadInJoyBaseAdapter", 1, paramViewGroup.toString());
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return t.a() + 154 + PTSLiteItemViewBuilder.a();
  }
  
  public List<AbsBaseArticleInfo> h()
  {
    return this.n.b();
  }
  
  public int i()
  {
    return this.d;
  }
  
  public boolean isEmpty()
  {
    return this.n.b().isEmpty();
  }
  
  public boolean j()
  {
    return this.n.a().n();
  }
  
  public AnimationSet k()
  {
    return new RIJDislikeAnimation(this.n).a();
  }
  
  public IFaceDecoder l()
  {
    return null;
  }
  
  public long m()
  {
    return this.y;
  }
  
  public void n()
  {
    this.w.clear();
    this.x.clear();
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.u.k();
  }
  
  public IExposureSupplementManager o()
  {
    return this.n.a().b();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.e;
    if ((localObject instanceof ReadInJoyFeedsActivity)) {
      ((ReadInJoyFeedsActivity)localObject).b(16);
    }
    localObject = (ClickHandler)this.D.get(Integer.valueOf(paramView.getId()));
    if (localObject != null)
    {
      ((ClickHandler)localObject).onClick(paramView);
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onClick, has no click handler for id(");
      ((StringBuilder)localObject).append(paramView.getId());
      ((StringBuilder)localObject).append("}");
      QLog.e("ReadInJoyBaseAdapter", 1, ((StringBuilder)localObject).toString());
    }
    this.o.a(paramView);
    this.p.a(paramView);
    this.u.c().onClick(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    return this.p.b(paramView);
  }
  
  public Object q()
  {
    return this.A;
  }
  
  public abstract boolean r();
  
  public void s()
  {
    this.G = true;
    this.n.d();
    this.i.b();
    this.n.a().e().a();
    if (this.c == 56) {
      VideoBehaviorsReporter.a().b();
    }
    IRecommendADVideoFeedsManager localIRecommendADVideoFeedsManager = this.j;
    if (localIRecommendADVideoFeedsManager != null) {
      localIRecommendADVideoFeedsManager.d();
    }
    this.u.c().P();
  }
  
  public ListenerBuilder y()
  {
    return this.q;
  }
  
  public ArrayList<BaseReportData> z()
  {
    return this.n.a().m();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter
 * JD-Core Version:    0.7.0.1
 */