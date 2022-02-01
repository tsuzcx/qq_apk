package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountArticleObserver;
import com.tencent.biz.pubaccount.util.VideoPlayDianZanHandler;
import com.tencent.biz.pubaccount.util.VideoPlayDianZanObserver;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdExposeFreshService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdSwitchService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.ad.api.entity.IADVideoAppDownloadManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IADVideoFeedsGuideManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdExposureManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdStrategyReportManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdTimeLoadManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdVVAdloadStrategyManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsGameAdComManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsHardAdBarManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsSoftAdBarController;
import com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.view.widget.ListEventListener;
import com.tencent.mobileqq.kandian.base.view.widget.VideoFeedsAlphaMaskView;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.atlas.ReadInJoyAtlasManager.AtlasCallbackImpl;
import com.tencent.mobileqq.kandian.biz.comment.entity.AnchorData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.follow.popup.RIJFollowRecommendPopupCommand;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.dispatcher.ITKDHippyEventDispatcher;
import com.tencent.mobileqq.kandian.biz.hippy.interfaces.receiver.ITKDHippyEventReceiver;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.ShortVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.playfeeds.videofeeds.TiktokVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskConfig;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardTaskVideoTimer;
import com.tencent.mobileqq.kandian.biz.reward.RIJRewardVideoTipsManager;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager;
import com.tencent.mobileqq.kandian.biz.reward.RIJVideoRewardCoinManager.Callback;
import com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsReporter;
import com.tencent.mobileqq.kandian.biz.video.VideoColumnBannerManager;
import com.tencent.mobileqq.kandian.biz.video.VideoColumnBannerManager.IVideoColumnBannerAction;
import com.tencent.mobileqq.kandian.biz.video.column.VideoColumnDataManager;
import com.tencent.mobileqq.kandian.biz.video.column.VideoColumnGuideManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.glue.baseconfig.VideoConfig;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.video.VideoFullPlayController;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeController;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5;
import com.tencent.mobileqq.kandian.glue.video.report.VideoR5.Builder;
import com.tencent.mobileqq.kandian.glue.viola.event.ViolaEvent;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJSocialBottomViewAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJMultiVideoConfigSp;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJVideoSingleModeConfigSp;
import com.tencent.mobileqq.kandian.repo.common.RIJLiveStatusModule;
import com.tencent.mobileqq.kandian.repo.feeds.ActionType;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsInsertAction;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.kandian.repo.follow.IFollowStatusObserver;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.VersionUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class VideoFeedsRecommendFragment
  extends BaseFragment
  implements SimpleEventReceiver<ViolaEvent>, ListEventListener, VideoFeedsAdapter.AdapterEventListener, VideoFeedsRecommendManager.Listener, RIJVideoRewardCoinManager.Callback, VideoColumnBannerManager.IVideoColumnBannerAction
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private View.OnLayoutChangeListener jdField_a_of_type_AndroidViewView$OnLayoutChangeListener;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  private IPublicAccountArticleHandler jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountArticleHandler;
  private IPublicAccountArticleObserver jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountArticleObserver;
  private VideoPlayDianZanHandler jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanHandler;
  private VideoPlayDianZanObserver jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanObserver;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IADVideoAppDownloadManager jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoAppDownloadManager;
  private IADVideoFeedsGuideManager jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager;
  private IVideoAdExposureManager jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager;
  private IVideoAdStrategyReportManager jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdStrategyReportManager;
  private IVideoAdTimeLoadManager jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdTimeLoadManager;
  private IVideoAdVVAdloadStrategyManager jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdVVAdloadStrategyManager;
  private IVideoFeedsGameAdComManager jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsGameAdComManager;
  private IVideoFeedsSoftAdBarController jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsSoftAdBarController;
  private ReadInJoyAtlasManager.AtlasCallbackImpl jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallbackImpl;
  private final ITKDHippyEventReceiver jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesReceiverITKDHippyEventReceiver = new VideoFeedsRecommendFragment.5(this);
  private VideoFeedsAdapter jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
  private VideoFeedsCommentManager.CommentEventListener jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager$CommentEventListener;
  private VideoFeedsCommentManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager;
  private VideoFeedsGuideProxy jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGuideProxy;
  private VideoFeedsInterruptedAdManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsInterruptedAdManager;
  private VideoFeedsLikeAnimateManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager;
  private VideoFeedsPlayManager.VideoStatusListener jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$VideoStatusListener;
  private VideoFeedsPlayManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
  private VideoFeedsRecommendFragment.FriendListObserver jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$FriendListObserver;
  private VideoFeedsRecommendFragment.FullPlayCallbackImpl jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$FullPlayCallbackImpl;
  private VideoFeedsRecommendFragment.LifeCycleCallBack jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$LifeCycleCallBack;
  private VideoFeedsRecommendFragment.LiveStatusCallback jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$LiveStatusCallback;
  private VideoFeedsRecommendFragment.PlayRecommendObserver jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$PlayRecommendObserver;
  private VideoFeedsRecommendFragment.RIJObserver jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$RIJObserver;
  private VideoFeedsRecommendFragment.ScrollEventListenerImpl jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$ScrollEventListenerImpl;
  private VideoFeedsRecommendManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager;
  private VideoFeedsRecommendPresenter jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter;
  private VideoFeedsShareGuideController jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareGuideController;
  private VideoFeedsShuntBarManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShuntBarManager;
  private VideoPlayCountHandler jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayCountHandler;
  private VideoPlayCountObserver jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayCountObserver;
  private VideoPlayRecommendHandler jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler;
  private RIJRewardTaskVideoTimer jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer;
  private RIJRewardVideoTipsManager jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardVideoTipsManager;
  private RIJVideoRewardCoinManager jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager;
  private VideoColumnBannerManager jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoColumnBannerManager;
  private VideoColumnDataManager jdField_a_of_type_ComTencentMobileqqKandianBizVideoColumnVideoColumnDataManager;
  private VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
  private VideoFeedsRecyclerView jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
  private VideoItemHolder jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
  private VideoFullPlayController jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController;
  private RIJLiveStatusModule jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<VideoInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashSet<VideoInfo> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private List<IFollowStatusObserver> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  private String jdField_b_of_type_JavaLangString;
  private HashSet<String> jdField_b_of_type_JavaUtilHashSet;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  private String jdField_c_of_type_JavaLangString;
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int = 0;
  private String jdField_d_of_type_JavaLangString;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int = 5;
  private String jdField_e_of_type_JavaLangString;
  private boolean jdField_e_of_type_Boolean = false;
  private int jdField_f_of_type_Int = 0;
  private String jdField_f_of_type_JavaLangString;
  private boolean jdField_f_of_type_Boolean = false;
  private String jdField_g_of_type_JavaLangString;
  private boolean jdField_g_of_type_Boolean = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private boolean k = true;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private boolean o = false;
  private boolean p;
  private boolean q;
  private boolean r;
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3)
  {
    return a(paramBundle, paramVideoInfo, paramString1, paramString2, paramString3, false);
  }
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return a(paramBundle, paramVideoInfo, paramString1, paramString2, paramString3, paramBoolean, 0);
  }
  
  public static VideoFeedsRecommendFragment a(Bundle paramBundle, VideoInfo paramVideoInfo, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("ARGS_SESSION_ID", paramString1);
    localBundle.putString("ARGS_VIDEO_CHANNEL_SESSION_ID", paramString3);
    localBundle.putParcelable("ARGS_REUQEST_VIDEO_INFO", paramVideoInfo);
    localBundle.putBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", paramBoolean);
    localBundle.putInt("ARGS_FIRST_INFO_POSITION", paramInt);
    localBundle.putString("ARGS_PAGE_SESSION_ID", paramString2);
    localBundle.putAll(paramBundle);
    paramBundle = new VideoFeedsRecommendFragment();
    paramBundle.setArguments(localBundle);
    return paramBundle;
  }
  
  private String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController != null)
    {
      VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (localVideoInfo != null) {
        return VideoFeedsHelper.a(localVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a(), this.jdField_a_of_type_AndroidOsBundle).toString();
      }
    }
    return null;
  }
  
  private List<Long> a(List<VideoInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = ((VideoInfo)paramList.next()).j;
      try
      {
        localArrayList.add(Long.valueOf(Long.parseLong(str)));
      }
      catch (Throwable localThrowable)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("convert2LongList pass uin:");
        localStringBuilder.append(str);
        localStringBuilder.append(" for e:");
        localStringBuilder.append(localThrowable);
        QLog.e("VideoFeedsRecommendFragment", 1, localStringBuilder.toString());
      }
    }
    return localArrayList;
  }
  
  private void a(float paramFloat)
  {
    VideoItemHolder localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if ((localVideoItemHolder instanceof TiktokVideoItemHolder))
    {
      TiktokVideoItemHolder localTiktokVideoItemHolder = (TiktokVideoItemHolder)localVideoItemHolder;
      ((TiktokVideoItemHolder)localVideoItemHolder).a.a(paramFloat, new VideoFeedsRecommendFragment.4(this, localTiktokVideoItemHolder));
    }
  }
  
  private void a(VideoInfo paramVideoInfo)
  {
    if (!TextUtils.isEmpty(paramVideoInfo.j))
    {
      if (paramVideoInfo.jdField_b_of_type_Boolean) {
        return;
      }
      ThreadManager.post(new VideoFeedsRecommendFragment.CheckAccountFollowedRunnable(this, paramVideoInfo), 1, null, true);
    }
  }
  
  private void a(BaseItemHolder paramBaseItemHolder)
  {
    boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager.b();
    boolean bool1 = false;
    if ((!bool2) && (!((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(paramBaseItemHolder)) && ((paramBaseItemHolder instanceof BaseVideoItemHolder))) {
      bool1 = ((BaseVideoItemHolder)paramBaseItemHolder).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.a(getBaseActivity()) ^ true;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.setNeedDetectOrientation(getBaseActivity(), bool1);
  }
  
  private void a(VideoItemHolder paramVideoItemHolder, boolean paramBoolean)
  {
    if ((paramVideoItemHolder != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null))
    {
      if (paramBoolean)
      {
        TimeSliceHelper.b(paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_g_of_type_JavaLangString);
        return;
      }
      TimeSliceHelper.c(paramVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_g_of_type_JavaLangString);
    }
  }
  
  private void a(List<VideoInfo> paramList)
  {
    try
    {
      paramList = a(paramList);
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule.a(paramList);
      return;
    }
    catch (Exception paramList)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fetchLiveStatus error:");
      localStringBuilder.append(paramList);
      QLog.e("VideoFeedsRecommendFragment", 1, localStringBuilder.toString());
    }
  }
  
  private boolean a(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    boolean bool2 = true;
    if (bool1) {
      return true;
    }
    VideoItemHolder localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    bool1 = bool2;
    if (localVideoItemHolder != null)
    {
      bool1 = bool2;
      if (localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null)
        {
          if (!TextUtils.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_g_of_type_JavaLangString)) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  private void b(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo.jdField_a_of_type_Int != 0) && ((!TextUtils.isEmpty(paramVideoInfo.jdField_a_of_type_JavaLangString)) || (!TextUtils.isEmpty(paramVideoInfo.jdField_g_of_type_JavaLangString)))) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayCountHandler.a(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.jdField_g_of_type_JavaLangString);
    }
    if ((RIJRewardTaskConfig.a()) && (!paramVideoInfo.r))
    {
      ReadInJoyLogicEngine.a().j(paramVideoInfo.jdField_g_of_type_JavaLangString);
      ReadInJoyLogicEngine.a().i(paramVideoInfo.jdField_g_of_type_JavaLangString);
    }
  }
  
  private void b(List<VideoInfo> paramList)
  {
    if (this.o)
    {
      QLog.w("VideoFeedsRecommendFragment", 1, "fetchFollowStatus cancel for activity is destroyed.");
      return;
    }
    VideoFeedsRecommendFragment.FollowStatusObserver localFollowStatusObserver = new VideoFeedsRecommendFragment.FollowStatusObserver(paramList);
    this.jdField_a_of_type_JavaUtilList.add(localFollowStatusObserver);
    FollowListInfoModule.a(a(paramList), localFollowStatusObserver);
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.getScrollState() != 0) {
      return;
    }
    Object localObject1 = null;
    Object localObject2 = (LinearLayoutManager)this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.getLayoutManager();
    int i1 = ((LinearLayoutManager)localObject2).findFirstVisibleItemPosition();
    int i2 = ((LinearLayoutManager)localObject2).findLastVisibleItemPosition();
    while (i1 < i2)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.getLayoutManager().findViewByPosition(i1);
      if (localObject2 == null)
      {
        localObject2 = localObject1;
      }
      else
      {
        Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.getChildViewHolder((View)localObject2);
        if (i1 == paramInt) {
          localObject1 = localObject3;
        }
        if (localObject3 == null)
        {
          localObject2 = localObject1;
        }
        else
        {
          localObject2 = localObject1;
          if ((localObject3 instanceof BaseItemHolder))
          {
            localObject3 = ((BaseItemHolder)localObject3).a;
            localObject2 = localObject1;
            if (localObject3 != null)
            {
              ((VideoFeedsAlphaMaskView)localObject3).setAlpha(0.0F);
              localObject2 = localObject1;
            }
          }
        }
      }
      i1 += 1;
      localObject1 = localObject2;
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
    if ((localObject2 != null) && (!((VideoFeedsPlayManager)localObject2).d()) && (localObject1 != null))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.a(localObject1);
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).recordVideoFeeds(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder);
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).recordVideoFeeds1px(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a.c();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.c();
    }
  }
  
  private void d(int paramInt)
  {
    if ((this.m) && (paramInt == 1))
    {
      this.m = false;
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder, false);
    VideoVolumeController.getInstance().requestOrAbandonAudioFocus(false, "videoFeeds doOnPause");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
    if (localObject != null) {
      ((VideoFeedsAdapter)localObject).b(paramInt);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
    if ((localObject != null) && (!this.p)) {
      ((VideoFeedsPlayManager)localObject).e();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsSoftAdBarController;
    if (localObject != null) {
      ((IVideoFeedsSoftAdBarController)localObject).b();
    }
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidOsBundle = getArguments();
    this.jdField_b_of_type_JavaUtilHashSet = new HashSet();
    this.jdField_d_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("ARGS_SESSION_ID");
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("ARGS_VIDEO_CHANNEL_SESSION_ID");
    this.jdField_e_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("ARGS_PAGE_SESSION_ID");
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_CHANNEL_ID");
    Object localObject = this.jdField_a_of_type_AndroidOsBundle;
    boolean bool2 = false;
    this.jdField_e_of_type_Boolean = ((Bundle)localObject).getBoolean("VIDEO_FROM_AIO", false);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_TOPIC_ID", -1L);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_FROM_POLYMERIC_PUIN", 0L);
    this.jdField_f_of_type_Boolean = RIJVideoSingleModeConfigSp.a(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("VIDEO_PLAY_POSITION", 0L);
    this.jdField_g_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("FIRST_VIDEO_TOKEN", "");
    this.h = this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false);
    if ((this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) != 2) && (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) != 3) && (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) != 6) && (this.jdField_a_of_type_AndroidOsBundle.getInt("VIDEO_FROM_TYPE", -1) != 7)) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    this.j = bool1;
    boolean bool1 = this.j;
    this.k = (bool1 ^ true);
    if ((this.jdField_a_of_type_Long > 0L) && (bool1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.l = bool1;
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("KEY_IS_WEISHI_MODE", false);
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("VIDEO_COMMON_DATA");
    this.jdField_a_of_type_ArrayOfByte = this.jdField_a_of_type_AndroidOsBundle.getByteArray("VIDEO_BUSINESS_INFO");
    this.n = RIJMultiVideoConfigSp.a(this.jdField_d_of_type_Int);
    this.jdField_e_of_type_Int = RIJAppSetting.a();
    this.jdField_f_of_type_Int = VideoReporter.a();
    this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule = ReadInJoyLogicEngine.a().a();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$LiveStatusCallback = new VideoFeedsRecommendFragment.LiveStatusCallback(this, null);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule;
    if (localObject != null) {
      ((RIJLiveStatusModule)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$LiveStatusCallback);
    }
    if (CUKingCardUtils.a() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_c_of_type_Boolean = bool1;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAtlasReadInJoyAtlasManager$AtlasCallbackImpl = new VideoFeedsRecommendFragment.FavoriteStatusCallback(this, null);
    if (jdField_a_of_type_Int <= 0) {
      jdField_a_of_type_Int = DisplayUtil.a(getBaseActivity(), 120.0F);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = ((VideoInfo)this.jdField_a_of_type_AndroidOsBundle.getParcelable("ARGS_REUQEST_VIDEO_INFO"));
    localObject = new ArrayList();
    ((List)localObject).add(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
    bool1 = bool2;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
      bool1 = true;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$PlayRecommendObserver = new VideoFeedsRecommendFragment.PlayRecommendObserver(this, bool1);
    VideoFeedsRecommendFragment.PlayRecommendObserver.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$PlayRecommendObserver, (List)localObject);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData() mVideoFromType = ");
      ((StringBuilder)localObject).append(this.jdField_d_of_type_Int);
      QLog.d("VideoFeedsRecommendFragment", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData() mBundle = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidOsBundle.toString());
      QLog.d("VideoFeedsRecommendFragment", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData() mVideoDataList[0] = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.e());
      QLog.d("VideoFeedsRecommendFragment", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initData() needReloadTitle = ");
      ((StringBuilder)localObject).append(this.jdField_e_of_type_Boolean);
      ((StringBuilder)localObject).append(", showSingleVideo = ");
      ((StringBuilder)localObject).append(this.jdField_f_of_type_Boolean);
      ((StringBuilder)localObject).append(", mFirstVideoStartPosition = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(", mFirstVideoToken:");
      ((StringBuilder)localObject).append(this.jdField_g_of_type_JavaLangString);
      QLog.d("VideoFeedsRecommendFragment", 2, ((StringBuilder)localObject).toString());
    }
    VideoConfig.a.b();
  }
  
  private void l()
  {
    try
    {
      if (VersionUtils.d()) {
        getBaseActivity().getWindow().setFlags(16777216, 16777216);
      }
      label22:
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView = ((VideoFeedsRecyclerView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131380736));
      VideoFeedsAccessibilityHelper.a.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.setScrollable(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.setExtraFooterCount(0);
      this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new VideoFeedsLayoutManager(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView, 1, false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$VideoStatusListener = new VideoFeedsRecommendFragment.VideoStatusListenerImpl(this, null);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager = new VideoFeedsPlayManager(getBaseActivity().getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$VideoStatusListener);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.c(false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.f(this.n);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.g(this.h);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter = new VideoFeedsRecommendPresenter(getBaseActivity(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView, this.n, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_d_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createADVideoFeedsGuideManager(getBaseActivity().getApplicationContext());
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager.a(new VideoFeedsRecommendFragment.1(this));
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoAppDownloadManager = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createADVideoAppDownloadManager(getBaseActivity(), false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter = new VideoFeedsAdapter(getBaseActivity().getApplicationContext(), getBaseActivity(), this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_Boolean, this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.f(getUserVisibleHint());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.b(this.jdField_e_of_type_Boolean);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
      int i1;
      if (this.jdField_f_of_type_Boolean) {
        i1 = 3;
      } else {
        i1 = 1;
      }
      ((VideoFeedsAdapter)localObject).e(i1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(this.jdField_a_of_type_JavaUtilArrayList);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoAppDownloadManager);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(this);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.c(this.k);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.d(this.h);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.e(this.jdField_c_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.c((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(this.jdField_g_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$ScrollEventListenerImpl = new VideoFeedsRecommendFragment.ScrollEventListenerImpl(this, null);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$LifeCycleCallBack);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.a(this);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.addOnScrollListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$ScrollEventListenerImpl);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.addOnItemTouchListener(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$ScrollEventListenerImpl);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager$CommentEventListener = new VideoFeedsRecommendFragment.CommentEventListenerImpl(this, null);
      this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131364984));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager = new VideoFeedsCommentManager(getBaseActivity(), getChildFragmentManager(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager, this.jdField_c_of_type_AndroidViewViewGroup);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager$CommentEventListener);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager.getTKDHippyEventDispatcher().register(this.jdField_a_of_type_ComTencentMobileqqKandianBizHippyInterfacesReceiverITKDHippyEventReceiver);
      if (this.h)
      {
        localObject = (AnchorData)this.jdField_a_of_type_AndroidOsBundle.getParcelable("VIDEO_COMMENT_ANCHOR");
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager.a((AnchorData)localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager);
      this.jdField_a_of_type_AndroidOsBundle.getInt("REPORT_VIDEO_FEEDS_JUMP_FROM", 0);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsInterruptedAdManager = new VideoFeedsInterruptedAdManager(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$VideoStatusListener, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter, this.jdField_b_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsGameAdComManager = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createVideoFeedsGameAdComManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView);
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsSoftAdBarController = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createVideoFeedsSoftAdBarController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView);
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsSoftAdBarController.a(this.jdField_a_of_type_JavaUtilArrayList.get(0));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGuideProxy = new VideoFeedsGuideProxy();
      localObject = new VideofeedsUserGuideController(getBaseActivity(), getBaseActivity().getAppRuntime(), this.jdField_b_of_type_AndroidViewViewGroup, true, this.h);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGuideProxy.a((VideofeedsUserGuideController)localObject);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShuntBarManager = new VideoFeedsShuntBarManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter, (VideofeedsUserGuideController)localObject);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGuideProxy.a(new VideoColumnGuideManager());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager = new RIJVideoRewardCoinManager(getBaseActivity(), this);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardVideoTipsManager = new RIJRewardVideoTipsManager(getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager);
      m();
      if ((this.jdField_b_of_type_AndroidViewViewGroup instanceof FrameLayout))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$FullPlayCallbackImpl = new VideoFeedsRecommendFragment.FullPlayCallbackImpl(this, null);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController = new VideoFullPlayController(getBaseActivity(), (FrameLayout)this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$FullPlayCallbackImpl);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a(false);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$FullPlayCallbackImpl);
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$FullPlayCallbackImpl);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager = new VideoFeedsLikeAnimateManager(getBaseActivity(), 1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer = new RIJRewardTaskVideoTimer();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager);
      if (!RIJSocialBottomViewAladdinConfig.b()) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareGuideController = new VideoFeedsShareGuideController(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter, null);
      }
      VideoVolumeController.getInstance().inKandianModule(getBaseActivity());
      VideoBehaviorsReporter.a().a(true);
      VideoBehaviorsReporter.a().a(2);
      return;
    }
    catch (Exception localException)
    {
      break label22;
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131370808));
    this.jdField_a_of_type_AndroidViewViewGroup.bringToFront();
    if (LiuHaiUtils.b())
    {
      int i1 = LiuHaiUtils.b(getBaseActivity());
      ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
      localViewGroup.setPadding(localViewGroup.getPaddingLeft(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingTop() + i1, this.jdField_a_of_type_AndroidViewViewGroup.getPaddingRight(), this.jdField_a_of_type_AndroidViewViewGroup.getPaddingBottom());
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131377376));
    if ((!e()) && (getUserVisibleHint())) {
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131370799));
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("VIDEO_SHOW_COMMENT", false)) {
      a(false);
    }
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler = ((VideoPlayRecommendHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYRECOMMEND_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler.a(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager = new VideoFeedsRecommendManager(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, getBaseActivity(), this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayCountHandler = ((VideoPlayCountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIDEOPLAYCOUNT_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayCountObserver = new VideoFeedsRecommendFragment.PlayCountObserver(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanHandler = ((VideoPlayDianZanHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_DIANZAN));
    this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanObserver = new VideoFeedsRecommendFragment.DianZanObserver(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountArticleHandler = ((IPublicAccountArticleHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PUBLIC_ACCOUNT_VIDEO_HANDLER));
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountArticleObserver = ((IPublicAccountArticleObserver)QRoute.api(IPublicAccountArticleObserver.class));
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountArticleObserver.setOnCallback(new VideoFeedsRecommendFragment.AricleObserver(this, null));
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$FriendListObserver = new VideoFeedsRecommendFragment.FriendListObserver(this, null);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$RIJObserver = new VideoFeedsRecommendFragment.RIJObserver(this, null);
    w();
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdTimeLoadManager = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createVideoAdTimeLoadManager(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter, this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdVVAdloadStrategyManager = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createVideoAdVVAdloadStrategyManager(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdTimeLoadManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdStrategyReportManager = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createVideoAdStrategyReportManager();
    o();
    if (this.jdField_a_of_type_AndroidOsBundle.getBoolean("ARGS_HAS_EXTRA_VIDEO_DATAS", false)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$PlayRecommendObserver.a(true, this.jdField_a_of_type_AndroidOsBundle);
    }
    int i1 = this.jdField_a_of_type_AndroidOsBundle.getInt("ARGS_FIRST_INFO_POSITION", 0);
    if ((i1 > 0) && (i1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(i1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.scrollToPosition(i1);
    }
    VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    b(localVideoInfo);
    if ((localVideoInfo.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(localVideoInfo.k))) {
      localVideoInfo.k = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localVideoInfo.j, true);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localVideoInfo);
    a(localArrayList);
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager = ((IRIJAdService)QRoute.api(IRIJAdService.class)).createVideoAdExposureManager(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView, this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager.a(this.n);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.a(this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoColumnVideoColumnDataManager = new VideoColumnDataManager(this.jdField_d_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoColumnBannerManager = new VideoColumnBannerManager(getBaseActivity(), this.jdField_e_of_type_JavaLangString, this.jdField_d_of_type_Int, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoColumnVideoColumnDataManager, this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoColumnBannerManager);
  }
  
  private void o()
  {
    if (!this.jdField_f_of_type_Boolean)
    {
      s();
      IVideoAdTimeLoadManager localIVideoAdTimeLoadManager = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdTimeLoadManager;
      if (localIVideoAdTimeLoadManager != null)
      {
        ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
        if (localArrayList != null) {
          localIVideoAdTimeLoadManager.a((VideoInfo)localArrayList.get(0));
        }
      }
    }
  }
  
  private void p()
  {
    if (this.n)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
      if ((localObject != null) && (((VideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.g()) && (this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager != null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        if ((((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).isNeedShowAnotherAd(((VideoInfo)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo)) && (!this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_c_of_type_Int)))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_c_of_type_Int);
          if (localObject != null)
          {
            int i1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.getAdapterPosition() - 1;
            int i2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_c_of_type_Int;
            this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager.a(i1, i2, (VideoInfo)localObject);
            ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).reportVideoFeeds(getBaseActivity(), 50, true);
            this.jdField_a_of_type_AndroidOsHandler.postDelayed(new VideoFeedsRecommendFragment.2(this, i1 + 1), 0L);
            return;
          }
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
        if (localObject == null) {
          return;
        }
        ((VideoFeedsPlayManager)localObject).c();
        return;
      }
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$VideoStatusListener;
    if (localObject != null)
    {
      VideoItemHolder localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
      if (localVideoItemHolder != null) {
        ((VideoFeedsPlayManager.VideoStatusListener)localObject).d(localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
      }
    }
  }
  
  private void q()
  {
    if (this.jdField_f_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131715976));
    localStringBuilder.append(this.jdField_g_of_type_Boolean);
    VideoFeedsPlayActivity.a(localStringBuilder.toString());
    if (this.jdField_g_of_type_Boolean) {
      return;
    }
    s();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.e(1);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a();
  }
  
  private void r()
  {
    long l2;
    QQAppInterface localQQAppInterface;
    long l1;
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager != null))
    {
      l2 = this.jdField_c_of_type_Long;
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (localQQAppInterface == null) {}
      }
    }
    try
    {
      l1 = Long.parseLong(localQQAppInterface.getCurrentAccountUin());
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager.a(), l1, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager.a(), this.jdField_d_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager.a());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  private void s()
  {
    long l2;
    Object localObject1;
    long l1;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler != null)
    {
      l2 = this.jdField_c_of_type_Long;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = l2;
      if (l2 == 0L)
      {
        l1 = l2;
        if (localObject1 == null) {}
      }
    }
    try
    {
      l1 = Long.parseLong(((QQAppInterface)localObject1).getCurrentAccountUin());
      localObject1 = a();
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (localObject2 != null)
      {
        if (((VideoInfo)localObject2).jdField_g_of_type_Int > 0) {}
        for (i1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_g_of_type_Int;; i1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo.jdField_a_of_type_Int)
        {
          break label111;
          if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoVideoEntityVideoColumnInfo == null) {
            break;
          }
        }
      }
      int i1 = 0;
      label111:
      this.jdField_g_of_type_Boolean = true;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayRecommendHandler;
      VideoFeedsRecommendFragment.PlayRecommendObserver localPlayRecommendObserver = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$PlayRecommendObserver;
      VideoInfo localVideoInfo = (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
      int i3 = this.jdField_d_of_type_Int;
      ArrayList localArrayList1 = this.jdField_a_of_type_JavaUtilArrayList;
      String str1 = ((VideoInfo)localArrayList1.get(0)).i;
      l2 = this.jdField_b_of_type_Long;
      String str2 = this.jdField_b_of_type_JavaLangString;
      String str3 = this.jdField_c_of_type_JavaLangString;
      int i4 = this.jdField_c_of_type_Int;
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      ArrayList localArrayList2 = new ArrayList(this.jdField_a_of_type_JavaUtilHashSet);
      Bundle localBundle = this.jdField_a_of_type_AndroidOsBundle;
      VideoItemHolder localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
      int i2;
      if (localVideoItemHolder == null) {
        i2 = 0;
      } else {
        i2 = localVideoItemHolder.jdField_c_of_type_Int;
      }
      ((VideoPlayRecommendHandler)localObject2).a(localPlayRecommendObserver, l1, localVideoInfo, i3, localArrayList1, str1, l2, true, i1, str2, str3, null, i4, (String)localObject1, arrayOfByte, 0, localArrayList2, localBundle, i2);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  private void t()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if ((localObject != null) && (((VideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (VideoFeedsShareController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_g_of_type_JavaLangString)))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      ((VideoInfo)localObject).v += 1;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
    }
  }
  
  private void u()
  {
    VideoFeedsGuideProxy localVideoFeedsGuideProxy = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGuideProxy;
    if (localVideoFeedsGuideProxy != null) {
      localVideoFeedsGuideProxy.a();
    }
  }
  
  private void v()
  {
    VideoFeedsGuideProxy localVideoFeedsGuideProxy = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGuideProxy;
    if (localVideoFeedsGuideProxy != null) {
      localVideoFeedsGuideProxy.a((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0));
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$FriendListObserver != null) {
      getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$FriendListObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$PlayRecommendObserver != null) {
      getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$PlayRecommendObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayCountObserver != null) {
      getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayCountObserver);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountArticleObserver != null) {
      getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountArticleObserver.getBusinessObserver());
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanObserver != null) {
      getBaseActivity().addObserver(this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanObserver);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$RIJObserver != null) {
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$RIJObserver);
    }
  }
  
  private void x()
  {
    getBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$FriendListObserver);
    getBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$PlayRecommendObserver);
    getBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoPlayCountObserver);
    getBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountArticleObserver.getBusinessObserver());
    getBaseActivity().removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanObserver);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$RIJObserver);
    Object localObject = ReadInJoyLogicEngine.a().a();
    if (localObject != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        IFollowStatusObserver localIFollowStatusObserver = (IFollowStatusObserver)localIterator.next();
        if (localIFollowStatusObserver != null) {
          ((FollowListInfoModule)localObject).b(localIFollowStatusObserver);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoCommonRIJLiveStatusModule;
    if (localObject != null) {
      ((RIJLiveStatusModule)localObject).b(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$LiveStatusCallback);
    }
  }
  
  private void y()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter;
    if (localObject != null) {
      ((VideoFeedsRecommendPresenter)localObject).h();
    }
    VideoVolumeController.getInstance().requestOrAbandonAudioFocus(true, "videoFeeds doOnResume");
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
    if ((localObject != null) && (!this.p) && (!this.q)) {
      ((VideoFeedsPlayManager)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsInterruptedAdManager;
    if ((localObject != null) && (((VideoFeedsInterruptedAdManager)localObject).a())) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsInterruptedAdManager.a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
    if (localObject != null) {
      ((VideoFeedsAdapter)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager;
    if ((localObject != null) && (((IADVideoFeedsGuideManager)localObject).a()) && (this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager.a() != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
      if (localObject != null) {
        ((VideoFeedsAdapter)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager.a());
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoAppDownloadManager;
    if (localObject != null) {
      ((IADVideoAppDownloadManager)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsGameAdComManager;
    if (localObject != null) {
      ((IVideoFeedsGameAdComManager)localObject).j();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if ((localObject != null) && (((VideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null)) {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController;
    if (localObject != null) {
      ((VideoFullPlayController)localObject).a();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder, true);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdTimeLoadManager;
    if (localObject != null) {
      ((IVideoAdTimeLoadManager)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdVVAdloadStrategyManager;
    if (localObject != null) {
      ((IVideoAdVVAdloadStrategyManager)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsSoftAdBarController;
    if (localObject != null) {
      ((IVideoFeedsSoftAdBarController)localObject).a();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdStrategyReportManager;
    if (localObject != null) {
      ((IVideoAdStrategyReportManager)localObject).c();
    }
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder)) {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doADVideoItemHolderOnResume(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder);
    }
  }
  
  public int a()
  {
    VideoItemHolder localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if (localVideoItemHolder != null) {
      return localVideoItemHolder.jdField_c_of_type_Int;
    }
    return 0;
  }
  
  public long a()
  {
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
    if (localVideoFeedsPlayManager != null) {
      return localVideoFeedsPlayManager.a();
    }
    return 0L;
  }
  
  public VideoFeedsPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
  }
  
  public VideoInfo a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return (VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(0);
    }
    return null;
  }
  
  public void a()
  {
    q();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 9) && (paramInt != 10) && (paramInt != 12)) {
      return;
    }
    t();
  }
  
  public void a(long paramLong)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (VideoPlayerWrapper)((VideoItemHolder)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    long l1;
    if (localObject2 != null) {
      l1 = ((VideoPlayerWrapper)localObject2).b();
    } else {
      l1 = 0L;
    }
    double d1;
    VideoItemHolder localVideoItemHolder;
    if (!this.jdField_d_of_type_Boolean)
    {
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsInterruptedAdManager;
      if (localObject3 != null)
      {
        d1 = paramLong;
        Double.isNaN(d1);
        ((VideoFeedsInterruptedAdManager)localObject3).a((int)(d1 / 1000.0D));
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShuntBarManager;
      if (localObject3 != null)
      {
        localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
        d1 = paramLong;
        Double.isNaN(d1);
        int i1 = (int)(d1 / 1000.0D);
        d1 = l1;
        Double.isNaN(d1);
        ((VideoFeedsShuntBarManager)localObject3).a((VideoInfo)localObject1, localVideoItemHolder, i1, (int)(d1 / 1000.0D));
      }
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGuideProxy;
      if (localObject3 != null) {
        ((VideoFeedsGuideProxy)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam, paramLong, this.jdField_b_of_type_AndroidViewViewGroup, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoColumnBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder, paramLong, l1);
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareGuideController;
      if (localObject3 != null) {
        ((VideoFeedsShareGuideController)localObject3).a(paramLong, l1);
      }
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsGameAdComManager;
    if (localObject3 != null) {
      ((IVideoFeedsGameAdComManager)localObject3).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder, this.jdField_d_of_type_Boolean);
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsSoftAdBarController;
    double d2;
    if (localObject3 != null)
    {
      localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
      boolean bool = this.jdField_d_of_type_Boolean;
      d1 = paramLong;
      Double.isNaN(d1);
      d2 = l1;
      Double.isNaN(d2);
      ((IVideoFeedsSoftAdBarController)localObject3).a(localVideoItemHolder, bool, d1 * 100.0D / d2, l1);
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager;
    if ((localObject3 != null) && (localObject2 != null)) {
      ((VideoFeedsRecommendManager)localObject3).a(((VideoPlayerWrapper)localObject2).a(false));
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardVideoTipsManager;
    if (localObject2 != null) {
      ((RIJRewardVideoTipsManager)localObject2).a(paramLong, l1, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager.b());
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.r) && (this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager != null))
    {
      if ((((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).isNotVVStrategy()) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).isNotMixStrategy())) {
        return;
      }
      localObject1 = ((VideoInfo)localObject1).jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo;
      if ((((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).isNeedShowAnotherAd((VideoAdInfo)localObject1)) && (((IRIJAdSwitchService)QRoute.api(IRIJAdSwitchService.class)).isShowAdGuide((VideoAdInfo)localObject1)))
      {
        d1 = paramLong;
        d2 = l1;
        Double.isNaN(d2);
        if (d1 >= 0.8D * d2)
        {
          ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VIDEO_LINK", "fetchAnotherAd : 同时满足 出结束引导和循环展示  80%");
          this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager.a((VideoAdInfo)localObject1, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_c_of_type_Int);
        }
        else
        {
          Double.isNaN(d2);
          if (d1 >= d2 * 0.5D)
          {
            ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("VIDEO_LINK", "refreshFetchAnotherAdFlag : 同时满足 出结束引导和循环展示  50%");
            this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager.b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_c_of_type_Int);
          }
        }
      }
    }
    a((float)paramLong / (float)l1);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.a(paramLong, l1);
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsRecommendFragment", 2, "onCenterViewChanged: ");
    }
    if ((paramViewHolder instanceof BaseItemHolder)) {
      a((BaseItemHolder)paramViewHolder);
    }
    if ((paramViewHolder instanceof VideoItemHolder))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShuntBarManager;
      if (localObject != null) {
        ((VideoFeedsShuntBarManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsGameAdComManager;
      if (localObject != null) {
        ((IVideoFeedsGameAdComManager)localObject).a((VideoItemHolder)paramViewHolder);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsSoftAdBarController;
      if (localObject != null) {
        ((IVideoFeedsSoftAdBarController)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder, (VideoItemHolder)paramViewHolder);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager;
      VideoItemHolder localVideoItemHolder = (VideoItemHolder)paramViewHolder;
      ((IADVideoFeedsGuideManager)localObject).a(localVideoItemHolder);
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoAppDownloadManager.a(localVideoItemHolder);
      if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(paramViewHolder)) {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doADVideoItemHolderOnResume(localVideoItemHolder);
      }
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder, false);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder = localVideoItemHolder;
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder, true);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsInterruptedAdManager;
      if (localObject != null)
      {
        localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
        if ((localVideoItemHolder instanceof ShortVideoItemHolder)) {
          ((VideoFeedsInterruptedAdManager)localObject).a((ShortVideoItemHolder)localVideoItemHolder, VideoFeedsRecommendFragment.ScrollEventListenerImpl.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$ScrollEventListenerImpl));
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_c_of_type_Int > 0)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGuideProxy;
        if (localObject != null) {
          ((VideoFeedsGuideProxy)localObject).b(false);
        }
        u();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_c_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
        b((VideoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_c_of_type_Int + 1));
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
        VideoFeedsAccessibilityHelper.a.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_AndroidViewViewGroup, ((VideoInfo)localObject).c() * 1000);
        this.jdField_a_of_type_JavaUtilHashSet.add(localObject);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoColumnBannerManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoColumnVideoColumnDataManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder);
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardVideoTipsManager;
      if (localObject != null)
      {
        localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
        if ((localVideoItemHolder instanceof ShortVideoItemHolder)) {
          ((RIJRewardVideoTipsManager)localObject).a((ShortVideoItemHolder)localVideoItemHolder);
        }
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareGuideController;
      if (localObject != null) {
        ((VideoFeedsShareGuideController)localObject).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder);
      }
    }
    SimpleEventBus.getInstance().dispatchEvent(new RIJFollowRecommendPopupCommand(1, null));
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$LifeCycleCallBack != null)
    {
      boolean bool = ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(paramViewHolder);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$LifeCycleCallBack.b(bool);
    }
  }
  
  public void a(RecyclerView.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGuideProxy;
    if (paramViewHolder != null) {
      paramViewHolder.a(paramBoolean);
    }
    paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardVideoTipsManager;
    if (paramViewHolder != null) {
      paramViewHolder.a(this.jdField_d_of_type_Boolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      u();
      paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
      if (paramViewHolder != null) {
        paramViewHolder = paramViewHolder.a();
      } else {
        paramViewHolder = null;
      }
      if (paramViewHolder != null)
      {
        String str1 = new VideoR5.Builder(paramViewHolder.d(), paramViewHolder.j, paramViewHolder.jdField_a_of_type_JavaLangString, paramViewHolder.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.a(), paramViewHolder.c() * 1000L).a(409409).a().a();
        IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        String str2 = paramViewHolder.j;
        if (!TextUtils.isEmpty(paramViewHolder.jdField_g_of_type_JavaLangString)) {
          paramViewHolder = paramViewHolder.jdField_g_of_type_JavaLangString;
        } else {
          paramViewHolder = "0";
        }
        localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str2, "0X8007411", "0X8007411", 0, 0, "0", "", paramViewHolder, str1, false);
      }
      paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
      if (paramViewHolder != null) {
        paramViewHolder.f(false);
      }
      paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
      if ((paramViewHolder instanceof BaseVideoItemHolder)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$FullPlayCallbackImpl.a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo), 0);
      }
    }
    else
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
      if (paramViewHolder != null) {
        paramViewHolder.f(this.n);
      }
      paramViewHolder = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController;
      if (paramViewHolder != null)
      {
        paramBoolean = paramViewHolder.b();
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.b();
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController.c();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$FullPlayCallbackImpl.a(paramBoolean);
      }
    }
    SimpleEventBus.getInstance().dispatchEvent(new RIJFollowRecommendPopupCommand(1, null));
  }
  
  public void a(VideoFeedsRecommendFragment.LifeCycleCallBack paramLifeCycleCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$LifeCycleCallBack = paramLifeCycleCallBack;
  }
  
  public void a(VideoInfo paramVideoInfo, boolean paramBoolean)
  {
    VideoPlayDianZanHandler localVideoPlayDianZanHandler = this.jdField_a_of_type_ComTencentBizPubaccountUtilVideoPlayDianZanHandler;
    if (localVideoPlayDianZanHandler != null) {
      localVideoPlayDianZanHandler.a(paramVideoInfo, paramBoolean);
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.a(new RIJFeedsInsertAction(ActionType.ACTION_LOVE, 0, 0, 0));
  }
  
  public void a(VideoItemHolder paramVideoItemHolder) {}
  
  public void a(RIJFeedsInsertAction paramRIJFeedsInsertAction)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.a(paramRIJFeedsInsertAction);
  }
  
  public void a(@NotNull String paramString, int paramInt)
  {
    if (getBaseActivity() != null) {
      QQToast.a(getBaseActivity(), paramString, 0).a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView;
    if (paramBoolean)
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setVisibility(0);
      }
    }
    else
    {
      localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
      if (localImageView != null) {
        localImageView.setVisibility(8);
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.g(true);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView.setNeedDetectOrientation(getBaseActivity(), false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.g(false);
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder);
  }
  
  public void a(boolean paramBoolean, @NotNull String paramString, int paramInt1, int paramInt2)
  {
    if (paramBoolean)
    {
      paramString = b();
      if (paramString != null)
      {
        paramString.n = true;
        this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(paramString);
        ReadInJoyLogicEngine.a().j(paramString.jdField_g_of_type_JavaLangString);
        if (!this.jdField_d_of_type_Boolean) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardVideoTipsManager.a(paramInt1);
        }
      }
    }
    else if (getBaseActivity() != null)
    {
      QQToast.a(getBaseActivity(), paramString, 0).a();
    }
  }
  
  public boolean a()
  {
    if (!getUserVisibleHint()) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager;
    if ((localObject != null) && (((RIJVideoRewardCoinManager)localObject).b())) {
      return true;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager;
    if ((localObject != null) && (((VideoFeedsCommentManager)localObject).b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager.a(2);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager.h();
      return true;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if ((localObject != null) && (((VideoItemHolder)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      VideoR5.Builder localBuilder = new VideoR5.Builder((VideoInfo)localObject);
      localBuilder.j(((VideoInfo)localObject).jdField_g_of_type_JavaLangString).n(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).m(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_b_of_type_Int).l(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_c_of_type_Int);
      localBuilder.p(1).j(((VideoInfo)localObject).jdField_g_of_type_JavaLangString);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((VideoInfo)localObject).j, "0X8009953", "0X8009953", 0, 0, "", "", "", localBuilder.a().a(), false);
    }
    return false;
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt != 24) && (paramInt != 25)) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder != null) && (!this.jdField_d_of_type_Boolean))
    {
      if (paramInt == 25) {
        paramInt = -1;
      } else {
        paramInt = 1;
      }
      VideoVolumeController.getInstance().adjustMediaVolume(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoFeedsItemUIDelegate.a(VideoVolumeController.getInstance().getMediaVolumeProgress());
      return true;
    }
    return false;
  }
  
  public void aC_()
  {
    if (QLog.isColorLevel()) {
      RIJAppSetting.a("VideoFeedsRecommendFragment", 2, "ListViewEventListener doOnLoadMoreData() 触发拉取推荐视频列表");
    }
    q();
  }
  
  public long b()
  {
    VideoFeedsPlayManager localVideoFeedsPlayManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
    if (localVideoFeedsPlayManager != null) {
      return localVideoFeedsPlayManager.b();
    }
    return 0L;
  }
  
  public VideoInfo b()
  {
    VideoItemHolder localVideoItemHolder = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder;
    if ((localVideoItemHolder != null) && (localVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    }
    return null;
  }
  
  public void b()
  {
    r();
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(RecyclerView.ViewHolder paramViewHolder) {}
  
  public void b(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public boolean b()
  {
    if ((((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder)) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null))
    {
      VideoInfo localVideoInfo = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
      if (localVideoInfo.r)
      {
        VideoFeedsAdapter localVideoFeedsAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
        if ((localVideoFeedsAdapter != null) && (localVideoFeedsAdapter.a != null)) {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a.a(localVideoInfo);
        }
      }
      return true;
    }
    return false;
  }
  
  public long c()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public void c() {}
  
  public boolean c()
  {
    boolean bool = getUserVisibleHint();
    int i1 = 0;
    if (!bool) {
      return false;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager;
    if ((localObject != null) && (((RIJVideoRewardCoinManager)localObject).b())) {
      return true;
    }
    if (this.jdField_d_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
      if (localObject != null)
      {
        ((VideoFeedsRecyclerView)localObject).b();
        VideoFeedsPlayActivity.a("BackPressed, back to list from fullscreen");
        return true;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager;
    if ((localObject != null) && (((VideoFeedsCommentManager)localObject).b()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager;
      if (!this.r) {
        i1 = 5;
      }
      ((VideoFeedsCommentManager)localObject).a(i1);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager.h();
      return true;
    }
    return false;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$LifeCycleCallBack.d();
    VideoFeedsShareGuideController localVideoFeedsShareGuideController = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareGuideController;
    if ((localVideoFeedsShareGuideController != null) && (localVideoFeedsShareGuideController.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.a().a("0X800B944", this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareGuideController.a());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.a().a("0X800B942", 0);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.a();
  }
  
  public void e()
  {
    IADVideoFeedsGuideManager localIADVideoFeedsGuideManager = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager;
    if (localIADVideoFeedsGuideManager != null) {
      localIADVideoFeedsGuideManager.c();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder, false);
  }
  
  public boolean e()
  {
    VideoFeedsCommentManager localVideoFeedsCommentManager = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager;
    return (localVideoFeedsCommentManager != null) && (localVideoFeedsCommentManager.b());
  }
  
  public void f()
  {
    IADVideoFeedsGuideManager localIADVideoFeedsGuideManager = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager;
    if (localIADVideoFeedsGuideManager != null) {
      localIADVideoFeedsGuideManager.d();
    }
    a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder, true);
  }
  
  public void g()
  {
    VideoFeedsRecyclerView localVideoFeedsRecyclerView = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
    if (localVideoFeedsRecyclerView != null) {
      localVideoFeedsRecyclerView.setNeedDetectOrientation(getBaseActivity(), false);
    }
  }
  
  public ArrayList<Class<ViolaEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ViolaEvent.class);
    return localArrayList;
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder);
    }
  }
  
  public void i()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.f();
  }
  
  public void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter.a(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 21)
    {
      Object localObject;
      if (paramInt1 != 117)
      {
        if (paramInt1 != 9999)
        {
          if (paramInt1 != 10001)
          {
            if (paramInt1 != 101)
            {
              if (paramInt1 != 102) {
                return;
              }
              if (paramInt2 != -1) {
                return;
              }
              localObject = paramIntent.getStringExtra("ARG_VIDEO_ARTICLE_ID");
              if ((!paramIntent.getBooleanExtra("KEY_VIDEO_BIU_SUCCESS", false)) || (localObject == null)) {
                return;
              }
              paramIntent = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
              if (paramIntent == null) {
                return;
              }
              paramIntent = paramIntent.a((String)localObject);
              if (paramIntent == null) {
                return;
              }
              paramIntent.jdField_f_of_type_Int += 1;
              this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter.a(paramIntent);
              return;
            }
            ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).dealRedPacketMVResult(getBaseActivity(), paramInt2, paramIntent);
          }
        }
        else
        {
          if (paramInt2 != -1) {
            return;
          }
          QQToast.a(getBaseActivity(), -1, getString(2131699886), 0).b(getBaseActivity().getTitleBarHeight());
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager;
        if (localObject == null) {
          return;
        }
        ((VideoFeedsCommentManager)localObject).a(paramInt1, paramInt2, paramIntent);
        return;
      }
    }
    if (paramInt2 == -1) {
      t();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener == null) && (this.jdField_b_of_type_AndroidViewViewGroup != null))
    {
      this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener = new VideoFeedsRecommendFragment.3(this, paramConfiguration);
      this.jdField_b_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this.jdField_a_of_type_AndroidViewView$OnLayoutChangeListener);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)VideoFeedsResourceLoader.a(2131560373, true, new ViewGroup.LayoutParams(-1, -1)));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
    k();
    l();
    n();
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendFragment$LifeCycleCallBack;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.c();
    }
    SimpleEventBus.getInstance().registerReceiver(this);
    return this.jdField_b_of_type_AndroidViewViewGroup;
  }
  
  public void onDestroyView()
  {
    this.o = true;
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
    if (localObject1 != null) {
      ((VideoFeedsAdapter)localObject1).e();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager;
    if (localObject1 != null)
    {
      ((VideoFeedsPlayManager)localObject1).f();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager;
    if (localObject1 != null)
    {
      ((IADVideoFeedsGuideManager)localObject1).a();
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoAppDownloadManager;
    if (localObject1 != null) {
      ((IADVideoAppDownloadManager)localObject1).c();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager;
    if (localObject1 != null)
    {
      ((IVideoAdExposureManager)localObject1).a();
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdTimeLoadManager;
    if (localObject1 != null)
    {
      ((IVideoAdTimeLoadManager)localObject1).e();
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdExposureManager = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdStrategyReportManager;
    if (localObject1 != null)
    {
      ((IVideoAdStrategyReportManager)localObject1).b();
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdStrategyReportManager = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewVideoFeedsRecyclerView;
    if (localObject1 != null) {
      ((VideoFeedsRecyclerView)localObject1).d();
    }
    localObject1 = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject1 != null)
    {
      ((Handler)localObject1).removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager;
    if (localObject1 != null)
    {
      ((VideoFeedsRecommendManager)localObject1).a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsInterruptedAdManager;
    if (localObject1 != null)
    {
      ((VideoFeedsInterruptedAdManager)localObject1).b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsInterruptedAdManager = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShuntBarManager;
    if (localObject1 != null)
    {
      ((VideoFeedsShuntBarManager)localObject1).a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShuntBarManager = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsGameAdComManager;
    if (localObject1 != null)
    {
      ((IVideoFeedsGameAdComManager)localObject1).a();
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsGameAdComManager = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsSoftAdBarController;
    if (localObject1 != null)
    {
      ((IVideoFeedsSoftAdBarController)localObject1).c();
      this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsSoftAdBarController = null;
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController;
    if (localObject1 != null) {
      ((VideoFullPlayController)localObject1).e();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoColumnBannerManager;
    if (localObject1 != null) {
      ((VideoColumnBannerManager)localObject1).a();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJVideoRewardCoinManager;
    if (localObject1 != null) {
      ((RIJVideoRewardCoinManager)localObject1).j();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardVideoTipsManager;
    if (localObject1 != null) {
      ((RIJRewardVideoTipsManager)localObject1).a();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsCommentManager;
    if (localObject1 != null) {
      ((VideoFeedsCommentManager)localObject1).i();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsShareGuideController;
    if (localObject1 != null) {
      ((VideoFeedsShareGuideController)localObject1).b();
    }
    localObject1 = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (VideoInfo)((Iterator)localObject1).next();
      TimeSliceHelper.a(((VideoInfo)localObject2).jdField_g_of_type_JavaLangString);
      if (((VideoInfo)localObject2).c != null)
      {
        localObject2 = ((VideoInfo)localObject2).c.iterator();
        while (((Iterator)localObject2).hasNext()) {
          TimeSliceHelper.a(((VideoInfo)((Iterator)localObject2).next()).jdField_g_of_type_JavaLangString);
        }
      }
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager;
    if (localObject1 != null)
    {
      ((VideoFeedsLikeAnimateManager)localObject1).a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsLikeAnimateManager = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsGuideProxy;
    if (localObject1 != null) {
      ((VideoFeedsGuideProxy)localObject1).b();
    }
    x();
    VideoBehaviorsReporter.a().a();
    VideoVolumeController.getInstance().outKandianModule(getBaseActivity());
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter;
    if (localObject1 != null) {
      ((VideoFeedsRecommendPresenter)localObject1).c();
    }
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).videoAdStrategyManagerOnDestroy();
    ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).videoAdTimeLoadManagerOnDestroy();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdVVAdloadStrategyManager;
    if (localObject1 != null) {
      ((IVideoAdVVAdloadStrategyManager)localObject1).d();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdStrategyReportManager;
    if (localObject1 != null) {
      ((IVideoAdStrategyReportManager)localObject1).e();
    }
    ((IRIJAdExposeFreshService)QRoute.api(IRIJAdExposeFreshService.class)).exitScene("RIJAdRefreshSceneFloatVideo");
    ((IRIJAdDownloadService)QRoute.api(IRIJAdDownloadService.class)).clearDownloadCache();
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnDestroy()");
    super.onDestroyView();
    SimpleEventBus.getInstance().unRegisterReceiver(this);
  }
  
  public void onPause()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnPause()");
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizRewardRIJRewardTaskVideoTimer;
    if (localObject != null) {
      ((RIJRewardTaskVideoTimer)localObject).b();
    }
    d(1);
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendPresenter;
    if (localObject != null) {
      ((VideoFeedsRecommendPresenter)localObject).g();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoFeedsGuideManager;
    if (localObject != null) {
      ((IADVideoFeedsGuideManager)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoFullPlayController;
    if (localObject != null) {
      ((VideoFullPlayController)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIADVideoAppDownloadManager;
    if (localObject != null) {
      ((IADVideoAppDownloadManager)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdTimeLoadManager;
    if (localObject != null) {
      ((IVideoAdTimeLoadManager)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdVVAdloadStrategyManager;
    if (localObject != null) {
      ((IVideoAdVVAdloadStrategyManager)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoAdStrategyReportManager;
    if (localObject != null) {
      ((IVideoAdStrategyReportManager)localObject).d();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianAdApiEntityIVideoFeedsSoftAdBarController;
    if (localObject != null) {
      ((IVideoFeedsSoftAdBarController)localObject).b();
    }
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).instanceOfADVideoItemHolder(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder)) {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doADVideoItemHolderOnPause(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsViewholderVideoItemHolder);
    }
    super.onPause();
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof ViolaEvent))
    {
      paramSimpleBaseEvent = (ViolaEvent)paramSimpleBaseEvent;
      if (a(paramSimpleBaseEvent.data.optString("rowkey"))) {
        return;
      }
      paramSimpleBaseEvent = paramSimpleBaseEvent.eventName;
      int i1 = -1;
      switch (paramSimpleBaseEvent.hashCode())
      {
      default: 
        break;
      case -355366270: 
        if (paramSimpleBaseEvent.equals("openCommentEditor")) {
          i1 = 0;
        }
        break;
      case -862628966: 
        if (paramSimpleBaseEvent.equals("onCommentEditorResume")) {
          i1 = 4;
        }
        break;
      case -999622423: 
        if (paramSimpleBaseEvent.equals("onCommentEditorPause")) {
          i1 = 2;
        }
        break;
      case -1011306261: 
        if (paramSimpleBaseEvent.equals("onCommentEditorClose")) {
          i1 = 1;
        }
        break;
      case -1774947655: 
        if (paramSimpleBaseEvent.equals("onCommentEditorWillClose")) {
          i1 = 3;
        }
        break;
      }
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3)
            {
              if (i1 != 4) {
                return;
              }
              if (!this.p) {
                this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.d();
              }
            }
            else
            {
              this.q = true;
            }
          }
          else if (!this.q)
          {
            this.p = false;
            this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager.e();
          }
        }
        else
        {
          this.p = false;
          this.q = false;
        }
      }
      else {
        this.p = true;
      }
    }
  }
  
  public void onResume()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnResume()");
    if (getUserVisibleHint()) {
      y();
    }
    super.onResume();
  }
  
  public void onStop()
  {
    VideoFeedsPlayActivity.a("VideoFeedsPlayActivity doOnStop()");
    d(2);
    super.onStop();
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if (paramBoolean) {
      y();
    } else {
      d(2);
    }
    VideoFeedsAdapter localVideoFeedsAdapter = this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsAdapter;
    if (localVideoFeedsAdapter != null) {
      localVideoFeedsAdapter.f(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsRecommendFragment
 * JD-Core Version:    0.7.0.1
 */