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
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IBaseHandler;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IHandlerFactory;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.report.RIJVideoReportManager;
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
  public static float a = 0.0F;
  public static int a = 20;
  public static DynamicItemViewHelper a;
  public static int b = 250;
  public static int e = 1000;
  public long a;
  protected Activity a;
  protected LayoutInflater a;
  public GdtHandler.Params a;
  protected IRecommendADVideoFeedsManager a;
  protected RIJDataManager a;
  private IReadInJoyListItemLifeCycle jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyListItemLifeCycle;
  protected ReadInJoyXListView a;
  public RIJOnScrollListener a;
  private RIJProteusParserObserver jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJProteusParserObserver;
  private RIJShakeManager jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJShakeManager;
  protected ListenerBuilder a;
  protected RIJFrameworkHandleClick a;
  protected RIJInvokeHandler a;
  protected RIJVideoHandleClick a;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyBaseAdapter.2(this);
  private Object jdField_a_of_type_JavaLangObject;
  private ArrayList<IReadInJoyListItemLifeCycle> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<Integer, ClickHandler> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public HashSet<String> a;
  protected Set<Long> a;
  protected boolean a;
  public long b;
  public HashSet<String> b;
  public boolean b;
  protected int c;
  private long jdField_c_of_type_Long = -1L;
  private boolean jdField_c_of_type_Boolean;
  protected int d = 0;
  
  static
  {
    jdField_a_of_type_Float = ViewConfiguration.getScrollFriction();
    if (Build.VERSION.SDK_INT < 21) {
      jdField_a_of_type_Float = 0.025F;
    }
    jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper = new DynamicItemViewHelper();
  }
  
  public ReadInJoyBaseAdapter(Activity paramActivity, LayoutInflater paramLayoutInflater, int paramInt, ListView paramListView, SparseArray<IBaseHandler> paramSparseArray)
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -2147483648L;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramLayoutInflater;
    this.jdField_c_of_type_Int = paramInt;
    paramLayoutInflater = new ReadInjoyContext();
    paramLayoutInflater.setContext(paramActivity);
    paramLayoutInflater.setCurActivity(paramActivity);
    ProteusSupportUtil.a(paramLayoutInflater, "default_feeds");
    jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper.a(paramLayoutInflater);
    paramActivity = (ReadInJoyXListView)paramListView;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView = paramActivity;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler = new RIJInvokeHandler();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(paramSparseArray, this);
    paramListView = new RIJPreloadImage();
    paramListView.a();
    paramSparseArray = new RIJDislikeManager();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager = new RIJDataManager(new RIJDataManager.Builder().a(this.jdField_a_of_type_AndroidAppActivity).a(this.jdField_c_of_type_Int).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a()).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a()).a(this).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a()).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a()).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a()).a(jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper).a(paramListView).a(paramLayoutInflater).a(paramSparseArray).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a()));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJFrameworkHandleClick = new RIJFrameworkHandleClick(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoClickRIJVideoHandleClick = new RIJVideoHandleClick(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJShakeManager = new RIJShakeManager(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJProteusParserObserver = new RIJProteusParserObserver(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJOnScrollListener = new RIJOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager);
    paramActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJOnScrollListener);
    paramActivity.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a);
    paramActivity.setOnDrawCompleteListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a());
    paramActivity.a(new RIJOnScrollChangeListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager));
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  private int a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    int j = ReadInJoyBaseAdapterUtil.a.a(paramAbsBaseArticleInfo, b(), false);
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a(j, paramInt)) {
      i = 119;
    }
    return i;
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
    if ((jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper != null) && (DynamicItemViewHelper.a(paramAbsBaseArticleInfo)))
    {
      paramAbsBaseArticleInfo = jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper.a(paramAbsBaseArticleInfo);
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
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.feedsFirstExposurePos == -1)) {
      paramAbsBaseArticleInfo.feedsFirstExposurePos = paramInt;
    }
    ReadinjoyReportUtils.a(paramAbsBaseArticleInfo, ReadinjoyReportUtils.e, false, "");
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
      int i;
      if (paramAbsBaseArticleInfo.toString() != null) {
        i = paramView.getLayoutParams().height;
      } else {
        i = -1;
      }
      QLog.d("ReadInJoyBaseAdapter", 1, new Object[] { Integer.valueOf(i) });
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
      if (a() != 0) {
        return;
      }
      if ((paramVarArgs != null) && (paramVarArgs.length > 2))
      {
        localObject = paramVarArgs[0];
        if ((localObject instanceof AbsBaseArticleInfo))
        {
          localObject = (AbsBaseArticleInfo)localObject;
          VideoPlayParam localVideoPlayParam = a((AbsBaseArticleInfo)localObject);
          localVideoPlayParam.a.putFloat("currentPlayTime", ((Float)paramVarArgs[1]).floatValue());
          localVideoPlayParam.a.putString("forceViola", "1");
          localVideoPlayParam.a.putFloat("playRate", ((Float)paramVarArgs[2]).floatValue());
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
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public abstract int a(int paramInt);
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a();
  }
  
  public abstract Activity a();
  
  public Bitmap a(long paramLong)
  {
    return null;
  }
  
  public AnimationSet a()
  {
    return new RIJDislikeAnimation(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager).a();
  }
  
  public VafContext a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a();
  }
  
  public IFaceDecoder a()
  {
    return null;
  }
  
  public IRecommendADVideoFeedsManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRecommendADVideoFeedsManager;
  }
  
  public RIJDataManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager;
  }
  
  public IExposureSupplementManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a();
  }
  
  public ReadInJoyFeedbackPopupWindow a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a(a(), this);
  }
  
  public ListenerBuilder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickListenerBuilder;
  }
  
  public DynamicItemViewHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().b();
  }
  
  public VideoPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a();
  }
  
  public AbsBaseArticleInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a(a());
  }
  
  public AbsBaseArticleInfo a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a(paramInt);
  }
  
  public abstract AbsBaseArticleInfo a(int paramInt, long paramLong);
  
  public KandianNegativeWindow a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a(a());
  }
  
  public KandianNegativeWindowForAd a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a(a());
  }
  
  public ListView a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params;
  }
  
  public String a(long paramLong)
  {
    return null;
  }
  
  public ArrayList<BaseReportData> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a();
  }
  
  public List<AbsBaseArticleInfo> a()
  {
    return (List)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilHashSet.clear();
    this.jdField_b_of_type_JavaUtilHashSet.clear();
  }
  
  public void a(int paramInt, Intent paramIntent)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a(paramInt, paramIntent);
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().b(paramInt, paramBoolean);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    h();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a(paramAdvertisementInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView);
  }
  
  public void a(IExposureSupplementManager paramIExposureSupplementManager)
  {
    if ((paramIExposureSupplementManager instanceof IExposureSupplementManager)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(paramIExposureSupplementManager);
    }
  }
  
  public void a(IReadInJoyListItemLifeCycle paramIReadInJoyListItemLifeCycle)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyListItemLifeCycle = paramIReadInJoyListItemLifeCycle;
    ReadInJoyXListView localReadInJoyXListView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView;
    if (localReadInJoyXListView != null) {
      localReadInJoyXListView.setNoteCardLifeCycle(paramIReadInJoyListItemLifeCycle);
    }
  }
  
  public void a(ReadInJoyBaseListView paramReadInJoyBaseListView)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(paramReadInJoyBaseListView);
  }
  
  public void a(PrefetchListener paramPrefetchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(paramPrefetchListener);
  }
  
  public void a(ListenerBuilder paramListenerBuilder)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickListenerBuilder = paramListenerBuilder;
  }
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a(a()) != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a(a()).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a(a()).dismiss();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a(a()) != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a(a()).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a(a()).dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a(paramVideoPlayParam);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a(paramVideoPlayParam, paramInt);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam1, VideoPlayParam paramVideoPlayParam2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a(paramVideoPlayParam1, paramVideoPlayParam2);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    a(paramVideoPlayParam, paramAbsBaseArticleInfo, false, true);
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramAbsBaseArticleInfo instanceof BaseArticleInfo)) {
      RIJFullVideoPlayActivity.a(paramVideoPlayParam, paramAbsBaseArticleInfo, paramBoolean1, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager);
    }
  }
  
  public void a(BigImgVideoColumnItemViewHolder paramBigImgVideoColumnItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    RIJConfigVideoItem.a(paramBigImgVideoColumnItemViewHolder, paramAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager, this, this);
  }
  
  public void a(BigImgVideoItemViewHolder paramBigImgVideoItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    RIJConfigVideoItem.a(paramBigImgVideoItemViewHolder, paramAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager, this, this);
  }
  
  public void a(VideoColumnItemViewHolder paramVideoColumnItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    RIJConfigVideoItem.a(paramVideoColumnItemViewHolder, paramAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager, this, this);
  }
  
  public void a(VideoFeedsTwoItemViewHolder paramVideoFeedsTwoItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    RIJConfigVideoItem.a(paramVideoFeedsTwoItemViewHolder, paramAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager, this);
  }
  
  public void a(VideoFeedsViewHolder paramVideoFeedsViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    RIJConfigVideoItem.a(paramVideoFeedsViewHolder, paramAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager, this, this, this.jdField_a_of_type_JavaUtilSet);
  }
  
  public void a(WeishiGridTwoItemViewHolder paramWeishiGridTwoItemViewHolder, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    RIJConfigVideoItem.a(paramWeishiGridTwoItemViewHolder, paramAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager, this, this);
  }
  
  public void a(VideoPlayManager paramVideoPlayManager, VideoAutoPlayController paramVideoAutoPlayController)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(paramVideoPlayManager).a(paramVideoAutoPlayController).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a(paramVideoPlayManager, paramVideoAutoPlayController);
    paramVideoPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a();
    if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(a())) && (paramVideoPlayManager != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRecommendADVideoFeedsManager = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createRecommendADVideoFeedsManager(this.jdField_a_of_type_AndroidAppActivity, this, paramVideoPlayManager, this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, a());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a().a(this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRecommendADVideoFeedsManager);
    }
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().remove(paramAbsBaseArticleInfo);
    notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().e(true);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a(paramAbsBaseArticleInfo1, paramAbsBaseArticleInfo2, paramBoolean);
  }
  
  public void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, IReadInJoyModel paramIReadInJoyModel, long paramLong, int paramInt)
  {
    RIJReportDataCollectionManager.a(paramAbsBaseArticleInfo, paramIReadInJoyModel, paramLong, paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().b(paramAbsListView, paramInt);
  }
  
  public void a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof GdtHandler.Params)) {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Params = ((GdtHandler.Params)paramObject);
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
  }
  
  public void a(@NotNull HashMap<String, Long> paramHashMap)
  {
    Iterator localIterator = paramHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!this.jdField_a_of_type_JavaUtilHashSet.contains(str)) {
        this.jdField_b_of_type_JavaUtilHashSet.add(str);
      }
    }
    localIterator = this.jdField_b_of_type_JavaUtilHashSet.iterator();
    while (localIterator.hasNext()) {
      paramHashMap.remove((String)localIterator.next());
    }
  }
  
  public void a(List<AbsBaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a(paramList);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(paramList);
  }
  
  public void a(List<AbsBaseArticleInfo> paramList, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a(paramList, paramInt);
  }
  
  public void a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(paramSet, paramMap);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().c(paramBoolean);
  }
  
  public void a(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    RIJVideoReportManager.a(paramBoolean, paramAbsBaseArticleInfo, a(), this.jdField_c_of_type_Int, this.jdField_c_of_type_Long);
  }
  
  public void a(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo1, AbsBaseArticleInfo paramAbsBaseArticleInfo2, String paramString, Map<String, Object> paramMap)
  {
    RIJVideoReportManager.a(paramBoolean, paramAbsBaseArticleInfo1, paramAbsBaseArticleInfo2, paramString, paramMap, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().d();
  }
  
  public boolean a(int paramInt)
  {
    return paramInt == 46;
  }
  
  public abstract boolean a(int paramInt, long paramLong);
  
  public int b()
  {
    return this.d;
  }
  
  public long b()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public List<AbsBaseArticleInfo> b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a();
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.b();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a();
    if (this.jdField_c_of_type_Int == 56) {
      VideoBehaviorsReporter.a().a();
    }
    IRecommendADVideoFeedsManager localIRecommendADVideoFeedsManager = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRecommendADVideoFeedsManager;
    if (localIRecommendADVideoFeedsManager != null) {
      localIRecommendADVideoFeedsManager.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().s();
  }
  
  public void b(int paramInt)
  {
    a(paramInt, true);
  }
  
  public void b(int paramInt, ArrayList<AbsBaseArticleInfo> paramArrayList, ArrayList<DislikeInfo> paramArrayList1, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a(paramInt, paramArrayList, paramArrayList1, paramObject, paramBoolean1, paramBoolean2);
  }
  
  public void b(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void b(IReadInJoyListItemLifeCycle paramIReadInJoyListItemLifeCycle)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramIReadInJoyListItemLifeCycle);
  }
  
  public void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    RIJVideoReportManager.a(paramAbsBaseArticleInfo, a(), this.jdField_c_of_type_Int);
  }
  
  public void b(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().c(paramAbsListView, paramInt);
  }
  
  public void b(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void b(List<AbsBaseArticleInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.b(paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().f(paramBoolean);
  }
  
  public abstract boolean b();
  
  public abstract boolean b(int paramInt, long paramLong);
  
  public Object c()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().o();
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void c(long paramLong)
  {
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(this.jdField_c_of_type_Long);
  }
  
  public void c(IReadInJoyListItemLifeCycle paramIReadInJoyListItemLifeCycle)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramIReadInJoyListItemLifeCycle);
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().g(paramBoolean);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().b();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().l();
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().d(paramBoolean);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a();
  }
  
  public void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRecommendADVideoFeedsManager;
    if (localObject != null) {
      ((IRecommendADVideoFeedsManager)localObject).b();
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Q.readinjoy.video_");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      QLog.d(((StringBuilder)localObject).toString(), 2, "ReadInJoyBaseAdapter doOnResume()");
    }
    if (ReadInJoyHelper.m()) {
      RIJReportDataCollectionManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getFirstVisiblePosition(), this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getHeaderViewsCount(), this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildCount(), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager);
    }
    this.jdField_a_of_type_Boolean = true;
    if (Build.VERSION.SDK_INT < 21) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.setFriction(jdField_a_of_type_Float);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJOnScrollListener.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, 4);
    int k = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().c(false);
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildCount()) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildAt(i);
      if ((localObject instanceof IReadInJoyLifeCycleView))
      {
        localObject = (IReadInJoyLifeCycleView)localObject;
        if (!((IReadInJoyLifeCycleView)localObject).a())
        {
          ((IReadInJoyLifeCycleView)localObject).setIsResume(true);
          ((IReadInJoyLifeCycleView)localObject).a();
        }
      }
      i += 1;
    }
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((IReadInJoyListItemLifeCycle)this.jdField_a_of_type_JavaUtilArrayList.get(j)).a();
      j += 1;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyListItemLifeCycle;
    if (localObject != null) {
      ((IReadInJoyListItemLifeCycle)localObject).a();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJShakeManager.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJProteusParserObserver.a();
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().b(paramBoolean);
  }
  
  public boolean e()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void f()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIRecommendADVideoFeedsManager;
    if (localObject != null) {
      ((IRecommendADVideoFeedsManager)localObject).c();
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Q.readinjoy.video_");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      QLog.d(((StringBuilder)localObject).toString(), 2, "ReadInJoyBaseAdapter doOnPause()");
    }
    int k = 0;
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a(a()) != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a(a()).isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a(a()).dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJOnScrollListener.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView, 5);
    if ((!ReadInJoyHelper.r()) && (ProteusSupportUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), "default_feeds")))
    {
      QLog.d("ReadInJoyBaseAdapter", 2, "hasRefresh notifyDataSetChanged");
      notifyDataSetChanged();
    }
    int i = 0;
    int j;
    for (;;)
    {
      j = k;
      if (i >= this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildCount()) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView.getChildAt(i);
      if ((localObject instanceof IReadInJoyLifeCycleView))
      {
        localObject = (IReadInJoyLifeCycleView)localObject;
        if (((IReadInJoyLifeCycleView)localObject).a())
        {
          ((IReadInJoyLifeCycleView)localObject).setIsResume(false);
          ((IReadInJoyLifeCycleView)localObject).b();
        }
      }
      i += 1;
    }
    while (j < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      ((IReadInJoyListItemLifeCycle)this.jdField_a_of_type_JavaUtilArrayList.get(j)).b();
      j += 1;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonBaseuiIReadInJoyListItemLifeCycle;
    if (localObject != null) {
      ((IReadInJoyListItemLifeCycle)localObject).b();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJShakeManager.b();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJProteusParserObserver.b();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().p();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    int j = a(paramInt);
    int i = j;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a(j, paramInt)) {
      i = 119;
    }
    return i;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TraceUtils.traceBegin("ReadInJoyBaseAdapter.getView");
    System.currentTimeMillis();
    a(a(paramInt), paramInt);
    AbsBaseArticleInfo localAbsBaseArticleInfo = a(paramInt);
    int i = a(paramInt, localAbsBaseArticleInfo);
    ReadInJoyModelImpl localReadInJoyModelImpl = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a(localAbsBaseArticleInfo, i, paramInt);
    RIJFeedsFluencyOptimizeUtil.a.a(localAbsBaseArticleInfo, i);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getView:  pos: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(localAbsBaseArticleInfo);
      localStringBuilder.append(" type= ");
      localStringBuilder.append(i);
      QLog.d("ReadInJoyBaseAdapter", 2, localStringBuilder.toString());
    }
    paramViewGroup = (View)((IHandlerFactory)QRoute.api(IHandlerFactory.class)).invokeHandlerMethodWithReturn(this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(), new ReadInJoyBaseAdapter.1(this, "onAdapterGetView", i, localAbsBaseArticleInfo, paramInt, paramView, paramViewGroup));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a(paramViewGroup, paramView, localAbsBaseArticleInfo, paramInt);
    if (paramViewGroup != null)
    {
      RIJReportDataCollectionManager.a(localAbsBaseArticleInfo, localReadInJoyModelImpl, System.currentTimeMillis(), paramInt, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager);
      paramViewGroup = super.a(paramViewGroup, paramInt);
      RIJReportDataCollectionManager.a(paramViewGroup, i, localAbsBaseArticleInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager);
      TextHook.updateFont(paramView);
      TraceUtils.traceEnd();
      a(localAbsBaseArticleInfo, paramViewGroup);
      return paramViewGroup;
    }
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("get view has error, return then convert view， viewType : ");
    paramViewGroup.append(i);
    QLog.d("ReadInJoyBaseAdapter", 1, paramViewGroup.toString());
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper.a() + 151 + PTSLiteItemViewBuilder.a();
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().a() != null) && (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(this.jdField_c_of_type_Int))) {
      g();
    }
  }
  
  public void i()
  {
    ReadInJoyXListView localReadInJoyXListView = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonWidgetReadInJoyXListView;
    if (localReadInJoyXListView != null) {
      localReadInJoyXListView.c(7);
    }
  }
  
  public boolean isEmpty()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().isEmpty();
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.b();
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().i();
  }
  
  public void l()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.g();
  }
  
  public void onClick(View paramView)
  {
    Object localObject = this.jdField_a_of_type_AndroidAppActivity;
    if ((localObject instanceof ReadInJoyFeedsActivity)) {
      ((ReadInJoyFeedsActivity)localObject).b(16);
    }
    localObject = (ClickHandler)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramView.getId()));
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
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkClickRIJFrameworkHandleClick.a(paramView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoClickRIJVideoHandleClick.a(paramView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkHandlersRIJInvokeHandler.a().onClick(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoClickRIJVideoHandleClick.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter
 * JD-Core Version:    0.7.0.1
 */