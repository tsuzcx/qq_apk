package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.bandwidth.BandwidthPredictor;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.base.video.player.data.AbsReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.data.ReadInJoyVideoReportData;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper;
import com.tencent.mobileqq.kandian.base.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.mobileqq.kandian.base.video.plugin.OnVideoPluginInstallListener;
import com.tencent.mobileqq.kandian.base.video.plugin.VideoPluginInstall;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.ad.report.ReadinjoyAdVideoReportData;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.biz.video.VideoBehaviorsReporter;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoVolumeController.EventListener;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsPlayManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.glue.video.VideoResumeManager;
import com.tencent.mobileqq.kandian.glue.video.VideoVolumeController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class VideoFeedsPlayManager
  implements OnVideoPluginInstallListener, IVideoVolumeController.EventListener, IVideoFeedsPlayManager
{
  private static List<VideoFeedsPlayManager> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private ReportConstants.VideoEndType jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private VideoPluginInstall jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
  private VideoFeedsPlayManager.MediaPlayListenerAdapterImpl jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$MediaPlayListenerAdapterImpl;
  private VideoFeedsPlayManager.VideoPlayProgressListener jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$VideoPlayProgressListener;
  private VideoFeedsRecommendManager jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager;
  private VideoAutoPlayController jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController;
  private VideoPlayParam jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
  private VideoPreDownloadMgr jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<VideoFeedsPlayManager.VideoStatusListener> jdField_a_of_type_JavaUtilArrayList;
  private Set<String> jdField_a_of_type_JavaUtilSet;
  private ConcurrentHashMap<VideoPlayerWrapper, Object> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private VideoPlayParam jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  private boolean g;
  private boolean h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  private boolean n;
  private boolean o;
  
  public VideoFeedsPlayManager(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this(paramContext, paramQQAppInterface, 0);
  }
  
  public VideoFeedsPlayManager(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    boolean bool = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilSet = new HashSet();
    this.d = false;
    this.e = false;
    this.f = true;
    this.jdField_g_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaLangObject = new Object();
    this.jdField_c_of_type_Int = -1;
    this.j = false;
    this.k = false;
    this.l = false;
    this.m = false;
    this.n = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$MediaPlayListenerAdapterImpl = new VideoFeedsPlayManager.MediaPlayListenerAdapterImpl(this, null);
    this.jdField_a_of_type_AndroidOsHandler = new VideoFeedsPlayManager.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_JavaUtilArrayList = null;
    this.o = false;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall = new VideoPluginInstall();
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a(this);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    VideoVolumeController.getInstance().addEventListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController = VideoAutoPlayController.getInstance();
    if (NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext)) {
      e(true);
    } else {
      e(false);
    }
    if ((ReadInJoyHelper.h(paramQQAppInterface)) || (PlayerHelper.a.a())) {
      bool = true;
    }
    this.jdField_h_of_type_Boolean = bool;
    jdField_a_of_type_JavaUtilList.add(this);
    j();
  }
  
  private VideoPlayerWrapper a()
  {
    return b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
  }
  
  private VideoPlayerWrapper a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper == a()) {
      return paramVideoPlayerWrapper;
    }
    return null;
  }
  
  private VideoPlayerWrapper a(VideoPlayParam paramVideoPlayParam)
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && (!this.jdField_b_of_type_Boolean))
    {
      paramVideoPlayParam = new VideoPlayerWrapper(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), paramVideoPlayParam.jdField_a_of_type_JavaLangString);
      paramVideoPlayParam.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$MediaPlayListenerAdapterImpl);
      return paramVideoPlayParam;
    }
    return null;
  }
  
  private VideoPlayParam a(VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam == this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam) {
      return paramVideoPlayParam;
    }
    return null;
  }
  
  private void a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    if (paramVideoPlayerWrapper == null) {
      return;
    }
    paramVideoPlayerWrapper.n();
    if (paramVideoPlayerWrapper.j()) {
      return;
    }
    paramVideoPlayerWrapper.j();
    ThreadManager.excute(new VideoFeedsPlayManager.7(this, paramVideoPlayerWrapper), 16, null, true);
  }
  
  private void a(ReadInJoyVideoReportData paramReadInJoyVideoReportData)
  {
    ThreadManager.excute(new VideoFeedsPlayManager.8(this, paramReadInJoyVideoReportData), 16, null, true);
  }
  
  private void a(boolean paramBoolean, VideoPlayParam paramVideoPlayParam, ReportConstants.VideoEndType paramVideoEndType)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 105) || (paramInt == 208);
  }
  
  private boolean a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    return a(paramVideoPlayerWrapper) != null;
  }
  
  private boolean a(VideoPlayParam paramVideoPlayParam)
  {
    VideoPlayerWrapper localVideoPlayerWrapper = b(paramVideoPlayParam);
    int i1;
    if ((localVideoPlayerWrapper != null) && ((localVideoPlayerWrapper.d()) || (localVideoPlayerWrapper.e()) || (localVideoPlayerWrapper.g()))) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if ((localVideoPlayerWrapper != null) && (localVideoPlayerWrapper.a() != paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo)) {
      i2 = 0;
    } else {
      i2 = 1;
    }
    if ((i1 != 0) && (i2 != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo hasPrePlay, just go onVideoPrepared");
      }
      paramVideoPlayParam.jdField_a_of_type_Boolean = false;
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.p = 2;
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.k();
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.p();
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_h_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$MediaPlayListenerAdapterImpl.a(paramVideoPlayParam);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$MediaPlayListenerAdapterImpl.a((VideoPlayerWrapper)paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper);
      return true;
    }
    if ((paramVideoPlayParam.jdField_a_of_type_Boolean) && (i2 != 0))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("VideoFeedsPlayManager playVideo prePlaying, just do nothing ");
        Integer localInteger;
        if (localVideoPlayerWrapper != null) {
          localInteger = Integer.valueOf(localVideoPlayerWrapper.b());
        } else {
          localInteger = null;
        }
        localStringBuilder.append(localInteger);
        QLog.d("VideoFeedsPlayManager.preplay", 2, localStringBuilder.toString());
      }
      if (localVideoPlayerWrapper != null)
      {
        localVideoPlayerWrapper.k();
        localVideoPlayerWrapper.p();
      }
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.p = 1;
      this.m = true;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(-3, 10000L);
      return true;
    }
    return false;
  }
  
  private VideoPlayerWrapper b(VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null) {
      return (VideoPlayerWrapper)paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper;
    }
    return null;
  }
  
  private void b(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    VideoPlayerWrapper localVideoPlayerWrapper = b(paramVideoPlayParam);
    Object localObject;
    if (localVideoPlayerWrapper != null) {
      localObject = localVideoPlayerWrapper.a();
    } else {
      localObject = null;
    }
    if ((localVideoPlayerWrapper != null) && (localObject == null) && (localVideoPlayerWrapper.j()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsPlayManager.preplay", 2, "createVideoPlayerAndPlay VideoFeedsPlayManager innerPlayVideo hit cache");
      }
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
      d(paramVideoPlayParam, paramBoolean);
      return;
    }
    boolean bool = paramVideoPlayParam.jdField_c_of_type_Boolean;
    String str = "not null";
    StringBuilder localStringBuilder;
    if (bool)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("createVideoPlayerAndPlay: isSeamlessPlay， tag ");
        if (localObject == null) {
          str = "null";
        }
        localStringBuilder.append(str);
        QLog.d("VideoFeedsPlayManager.preplay", 2, localStringBuilder.toString());
      }
      if (localVideoPlayerWrapper != null) {
        localVideoPlayerWrapper.b(true);
      }
      paramVideoPlayParam.jdField_a_of_type_AndroidViewView = null;
      c(paramVideoPlayParam, paramBoolean);
      return;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("createVideoPlayerAndPlay: tag ");
      if (localObject == null) {
        str = "null";
      }
      localStringBuilder.append(str);
      localStringBuilder.append(", oldPlayer=");
      localStringBuilder.append(localVideoPlayerWrapper);
      QLog.d("VideoFeedsPlayManager.preplay", 2, localStringBuilder.toString());
    }
    if (localVideoPlayerWrapper != null) {
      localVideoPlayerWrapper.b(true);
    }
    paramVideoPlayParam.jdField_a_of_type_AndroidViewView = null;
    ThreadManager.post(new VideoFeedsPlayManager.2(this, paramVideoPlayParam, paramBoolean), 5, null, true);
  }
  
  private boolean b(VideoPlayParam paramVideoPlayParam)
  {
    return a(paramVideoPlayParam) != null;
  }
  
  private void c(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper = a(paramVideoPlayParam);
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo miss cache");
    }
    if ((paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper != null) && (this.jdField_a_of_type_AndroidOsHandler != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null))
    {
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put((VideoPlayerWrapper)paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper, this.jdField_a_of_type_JavaLangObject);
      this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayManager.3(this, paramVideoPlayParam, paramBoolean));
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("createVideoPlayerAndPlay aysnc run error : playerParam.videoPlayer = ");
      localStringBuilder.append(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper);
      localStringBuilder.append(", mUIHandler = ");
      localStringBuilder.append(this.jdField_a_of_type_AndroidOsHandler);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, localStringBuilder.toString());
    }
  }
  
  private void d(VideoPlayParam paramVideoPlayParam)
  {
    int i1;
    if (paramVideoPlayParam != null)
    {
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData = new ReadInJoyVideoReportData();
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Int = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_Int;
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_c_of_type_JavaLangString = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString;
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_JavaLangString = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_g_of_type_JavaLangString;
      AbsReadInJoyVideoReportData localAbsReadInJoyVideoReportData = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData;
      if (this.jdField_a_of_type_Int == 1) {
        i1 = 5;
      } else {
        i1 = 2;
      }
      localAbsReadInJoyVideoReportData.e = i1;
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.l = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_b_of_type_Int;
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.m = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_c_of_type_Int;
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_s_of_type_Long = paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.d;
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_a_of_type_Boolean = true;
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.q = 0;
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.r = 0;
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_s_of_type_Int = 0;
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.f = false;
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_g_of_type_JavaLangString = "";
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_g_of_type_Boolean = false;
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_h_of_type_Boolean = false;
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.j = paramVideoPlayParam.jdField_a_of_type_AndroidOsBundle.getInt("jump_from_scene");
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.k = paramVideoPlayParam.jdField_a_of_type_AndroidOsBundle.getInt("video_feeds_index");
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.r))
    {
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData = new ReadinjoyAdVideoReportData();
      i1 = paramVideoPlayParam.jdField_a_of_type_AndroidOsBundle.getInt("ad_origin", 10);
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData.g = i1;
    }
  }
  
  private void d(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    VideoPlayerWrapper localVideoPlayerWrapper = b(paramVideoPlayParam);
    if (paramVideoPlayParam != null)
    {
      if (localVideoPlayerWrapper == null) {
        return;
      }
      paramVideoPlayParam.jdField_a_of_type_AndroidViewViewGroup.setKeepScreenOn(true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "innerPlayVideo: ");
      }
      Object localObject;
      if (paramVideoPlayParam.jdField_a_of_type_AndroidViewView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager innerPlayVideo videoView null");
        }
        paramVideoPlayParam.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        localVideoPlayerWrapper.a(paramVideoPlayParam.jdField_a_of_type_AndroidViewViewGroup, paramVideoPlayParam.jdField_c_of_type_Boolean, false);
        if ((paramVideoPlayParam.jdField_c_of_type_Boolean) && (localVideoPlayerWrapper.a() != 0))
        {
          localVideoPlayerWrapper.g();
          paramVideoPlayParam.jdField_c_of_type_Boolean = false;
          paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.b(paramVideoPlayParam, false);
        }
        localObject = localVideoPlayerWrapper.a();
        if (localObject == null)
        {
          if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate != null) {
            paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.a(paramVideoPlayParam, 999, 999, null);
          }
          paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper = null;
          return;
        }
        paramVideoPlayParam.jdField_a_of_type_AndroidViewView = ((View)localObject);
        ((View)localObject).setId(2131376064);
        if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate != null) {
          paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.b(paramVideoPlayParam);
        }
        if ((paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_b_of_type_Int > 0) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_c_of_type_Int > 0) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_c_of_type_Int < 10000) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_b_of_type_Int < 10000)) {
          localVideoPlayerWrapper.a().a(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_b_of_type_Int, paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_c_of_type_Int);
        }
      }
      int i1;
      if (this.jdField_a_of_type_Boolean) {
        i1 = 2;
      } else {
        i1 = paramVideoPlayParam.jdField_a_of_type_Int;
      }
      localVideoPlayerWrapper.b(i1);
      boolean bool;
      if ((!this.o) && (!this.jdField_g_of_type_Boolean)) {
        bool = false;
      } else {
        bool = true;
      }
      localVideoPlayerWrapper.d(bool);
      localVideoPlayerWrapper.a(this.jdField_h_of_type_Boolean);
      localVideoPlayerWrapper.e(paramVideoPlayParam.jdField_b_of_type_Boolean);
      localVideoPlayerWrapper.c(this.i);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("innerPlayVideo: isMuted=");
        ((StringBuilder)localObject).append(b(paramVideoPlayParam).l());
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
      }
      paramVideoPlayParam.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (!paramBoolean) {
        paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_b_of_type_Long = SystemClock.uptimeMillis();
      }
      if (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData != null)
      {
        paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.q = 0;
        paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.r = 0;
        paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_s_of_type_Int = 0;
        paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_g_of_type_Boolean = false;
        paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_h_of_type_Boolean = false;
        paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.i = this.jdField_h_of_type_Boolean;
      }
      if (!paramVideoPlayParam.jdField_c_of_type_Boolean) {
        ThreadManager.excute(new VideoFeedsPlayManager.PlayStartVideoRunnable(this, paramVideoPlayParam, localVideoPlayerWrapper, paramBoolean), 16, null, true);
      }
      paramVideoPlayParam.jdField_c_of_type_Boolean = false;
      paramVideoPlayParam.jdField_a_of_type_JavaLangString = null;
    }
  }
  
  private void e(VideoPlayParam paramVideoPlayParam)
  {
    ThreadManager.excute(new VideoFeedsPlayManager.9(this, paramVideoPlayParam), 16, null, true);
  }
  
  private void h()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.getSubThreadHandler().postAtFrontOfQueue(new VideoFeedsPlayManager.4(this));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "innerChangeCoverImageView: getCurVideoPlayer().start() ");
    }
    VideoPlayerWrapper localVideoPlayerWrapper = a();
    if (localVideoPlayerWrapper != null) {
      localVideoPlayerWrapper.d();
    }
  }
  
  private boolean h()
  {
    VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    return (localVideoPlayParam != null) && (localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.r) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo != null);
  }
  
  private void i()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if (localObject != null)
    {
      if ((d()) || (b())) {
        this.k = true;
      }
      a(ReportConstants.VideoEndType.EXIT_SCENE);
      ((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper = null;
      ((VideoPlayParam)localObject).jdField_a_of_type_AndroidViewView = null;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam = ((VideoPlayParam)localObject);
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if (localObject != null)
    {
      if (b((VideoPlayParam)localObject) != null) {
        b(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam).l();
      }
      localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      ((VideoPlayParam)localObject).jdField_a_of_type_AndroidViewView = null;
      ((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper = null;
      this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)((Iterator)localObject).next();
        if ((localVideoPlayerWrapper != null) && (!localVideoPlayerWrapper.i())) {
          localVideoPlayerWrapper.l();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  private void j()
  {
    int i1 = Aladdin.getConfig(352).getIntegerFromString("play_manager_max_count", 3);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("inspectPlayerMemory: size=");
      localStringBuilder.append(jdField_a_of_type_JavaUtilList.size());
      localStringBuilder.append(", maxCount=");
      localStringBuilder.append(i1);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, localStringBuilder.toString());
    }
    if (jdField_a_of_type_JavaUtilList.size() > i1)
    {
      int i2 = jdField_a_of_type_JavaUtilList.size();
      ((VideoFeedsPlayManager)jdField_a_of_type_JavaUtilList.get(i2 - i1 - 1)).i();
    }
  }
  
  public int a()
  {
    if (a() != null) {
      return a().b();
    }
    return 0;
  }
  
  public long a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (a() != null)) {
      return a().a();
    }
    return 0L;
  }
  
  public VideoInfo a()
  {
    VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if ((localVideoPlayParam != null) && (localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null)) {
      return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
    }
    return null;
  }
  
  public VideoPlayParam a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
  }
  
  public void a()
  {
    Object localObject;
    if (a() != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)((Iterator)localObject).next()).b(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
        }
      }
      h();
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(-2);
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayManager.5(this));
    if (h()) {
      try
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityVideoAdInfo.jdField_h_of_type_JavaLangString;
        if (!this.jdField_a_of_type_JavaUtilSet.contains(localObject))
        {
          this.jdField_a_of_type_JavaUtilSet.add(localObject);
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData.f = ReadinjoyAdVideoReportData.jdField_a_of_type_Int;
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData.i = 0;
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData.f = ReadinjoyAdVideoReportData.jdField_c_of_type_Int;
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizAdReportReadinjoyAdVideoReportData;
          ((ReadinjoyAdVideoReportData)localObject).i += 1;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("Q.pubaccount.video.feedsVideoFeedsPlayManager", 1, localThrowable, new Object[0]);
      }
    }
    VideoPlayerWrapper localVideoPlayerWrapper = a();
    VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if ((localVideoPlayParam != null) && (localVideoPlayerWrapper != null))
    {
      localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.o = localVideoPlayerWrapper.d();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.n = localVideoPlayerWrapper.c();
    }
  }
  
  public void a(float paramFloat)
  {
    if (a() != null) {
      a().a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    a(paramInt, false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (a() != null))
    {
      this.j = true;
      a().a(paramInt);
      if (paramBoolean)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
        if ((localObject != null) && (((VideoPlayParam)localObject).jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate != null))
        {
          long l1 = a().b();
          localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate;
          VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
          double d1 = paramInt * 100.0F / (float)l1;
          Double.isNaN(d1);
          ((IVideoUIDelegate)localObject).a(localVideoPlayParam, (int)(d1 + 0.5D), l1);
        }
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
    }
  }
  
  public void a(ReportConstants.VideoEndType paramVideoEndType)
  {
    a(true, paramVideoEndType);
  }
  
  public void a(VideoFeedsPlayManager.VideoPlayProgressListener paramVideoPlayProgressListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$VideoPlayProgressListener = paramVideoPlayProgressListener;
  }
  
  public void a(VideoFeedsPlayManager.VideoStatusListener paramVideoStatusListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramVideoStatusListener);
  }
  
  public void a(VideoFeedsRecommendManager paramVideoFeedsRecommendManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager = paramVideoFeedsRecommendManager;
  }
  
  public void a(VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam = paramVideoPlayParam;
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "VideoFeedsPlayManager playVideo");
    }
    if (this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel())
      {
        paramVideoPlayParam = new StringBuilder();
        paramVideoPlayParam.append("playVideo: mHasDestory=");
        paramVideoPlayParam.append(this.jdField_b_of_type_Boolean);
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, paramVideoPlayParam.toString());
      }
      return;
    }
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("playVideo() vid=");
        ((StringBuilder)localObject).append(paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString);
        QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_c_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 0;
      this.d = false;
      this.e = false;
      this.j = false;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam = paramVideoPlayParam;
      this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam = null;
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if (localObject != null)
      {
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)((Iterator)localObject).next()).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate != null) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam, paramBoolean);
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(-3);
      if (a(paramVideoPlayParam)) {
        return;
      }
      d(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_c_of_type_Long = SystemClock.uptimeMillis();
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
      if ((localObject != null) && (!((VideoPluginInstall)localObject).a()))
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall.a();
        return;
      }
      paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.p = 0;
      b(paramVideoPlayParam, false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "playVideo() error, playerParam or videoInfo is null");
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(@Nullable Object paramObject)
  {
    if ((paramObject instanceof ReportConstants.VideoEndType)) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = ((ReportConstants.VideoEndType)paramObject);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    VideoPlayParam localVideoPlayParam;
    if (paramBoolean)
    {
      localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      if (localVideoPlayParam != null) {
        a(localVideoPlayParam, true);
      }
    }
    else
    {
      localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      if ((localVideoPlayParam != null) && (localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate != null)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam, 999, 998, null);
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam = null;
    }
  }
  
  public void a(boolean paramBoolean, ReportConstants.VideoEndType paramVideoEndType)
  {
    VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if ((localVideoPlayParam != null) && (localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate != null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsApiIVideoUIDelegate.f(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
    }
    localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if ((localVideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager != null) && (localVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper != null) && ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo instanceof VideoInfo))) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager.a(1, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper.a(this.jdField_c_of_type_Boolean));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (a() != null))
    {
      a(paramBoolean, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam, paramVideoEndType);
      paramVideoEndType = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      paramVideoEndType.jdField_a_of_type_Boolean = false;
      paramVideoEndType.jdField_a_of_type_JavaLangString = null;
      paramVideoEndType.jdField_c_of_type_Boolean = false;
      paramVideoEndType = this.jdField_a_of_type_JavaUtilArrayList;
      if (paramVideoEndType != null)
      {
        paramVideoEndType = paramVideoEndType.iterator();
        while (paramVideoEndType.hasNext()) {
          ((VideoFeedsPlayManager.VideoStatusListener)paramVideoEndType.next()).a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam, this.jdField_c_of_type_Boolean);
        }
      }
      VideoResumeManager.a.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo.jdField_a_of_type_JavaLangString, a(), d());
      c(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam = null;
    }
    this.jdField_b_of_type_Int = 0;
    this.d = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(-2);
  }
  
  public boolean a()
  {
    return this.l;
  }
  
  public long b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (a() != null)) {
      return a().a(g());
    }
    return 0L;
  }
  
  public void b()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void b(VideoPlayParam paramVideoPlayParam)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("VideoFeedsPlayManager prePlayVideo mPreplaying=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
      ((StringBuilder)localObject).append(", player=");
      ((StringBuilder)localObject).append(b(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam));
      QLog.d("VideoFeedsPlayManager.preplay", 2, ((StringBuilder)localObject).toString());
    }
    if (paramVideoPlayParam != null)
    {
      if (paramVideoPlayParam == this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam) {
        return;
      }
      localObject = b(paramVideoPlayParam);
      if ((localObject != null) && (paramVideoPlayParam.jdField_a_of_type_Boolean) && (((VideoPlayerWrapper)localObject).a() == paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo)) {
        return;
      }
      if (b(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, "prePlayVideo: last preplay video not stop");
        }
        b(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam).b(true);
      }
      this.jdField_a_of_type_JavaLangString = null;
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
      if ((localObject != null) && (((VideoPluginInstall)localObject).a()))
      {
        paramVideoPlayParam.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam = paramVideoPlayParam;
        d(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
        paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerDataAbsReadInJoyVideoReportData.jdField_c_of_type_Long = SystemClock.uptimeMillis();
        b(paramVideoPlayParam, true);
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public boolean b()
  {
    return (a() != null) && (a().e());
  }
  
  public long c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null) && (a() != null)) {
      return a().b(g());
    }
    return 0L;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VideoFeedsPlayManager.6(this));
  }
  
  @Deprecated
  public void c(VideoPlayParam paramVideoPlayParam)
  {
    if (paramVideoPlayParam != null) {
      a((VideoPlayerWrapper)paramVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (a() != null)
      {
        VideoPlayParam localVideoPlayParam = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
        if (localVideoPlayParam != null)
        {
          int i1;
          if (this.jdField_a_of_type_Boolean) {
            i1 = 2;
          } else {
            i1 = localVideoPlayParam.jdField_a_of_type_Int;
          }
          a().b(i1);
        }
      }
    }
  }
  
  public boolean c()
  {
    return (a() != null) && (a().l());
  }
  
  public long d()
  {
    if (a() != null) {
      return a().b();
    }
    return 0L;
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdReportConstantReportConstants$VideoEndType = null;
    this.f = true;
    Object localObject;
    if (this.k)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
      if (localObject != null)
      {
        a((VideoPlayParam)localObject, false);
        break label105;
      }
    }
    if ((this.n) && (a() != null) && (a().d()))
    {
      a();
    }
    else if (this.l)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      boolean bool;
      if (localObject != null) {
        bool = ((QQAppInterface)localObject).isVideoChatting();
      } else {
        bool = false;
      }
      if (!bool)
      {
        this.m = true;
        c();
      }
    }
    label105:
    this.k = false;
    this.l = false;
    this.n = false;
    VideoBehaviorsReporter.a().b(true ^ VideoAutoPlayController.getInstance().isNeedNetWorkAlert());
    BandwidthPredictor.from().start(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void d(boolean paramBoolean)
  {
    this.i = paramBoolean;
    if (a() != null) {
      a().c(paramBoolean);
    }
    if (b(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam) != null) {
      b(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam).c(paramBoolean);
    }
  }
  
  public boolean d()
  {
    return (a() != null) && (a().f());
  }
  
  public void e()
  {
    this.f = false;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnPause() isPlaying()=");
      localStringBuilder.append(d());
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, localStringBuilder.toString());
    }
    if (d())
    {
      this.l = true;
      this.m = false;
      b();
    }
    BandwidthPredictor.from().stop(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void e(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController.updateNetworkChange(paramBoolean);
  }
  
  public boolean e()
  {
    return a() == 5;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFeedsPlayManager.preplay", 2, "doOnDestory: ");
    }
    jdField_a_of_type_JavaUtilList.remove(this);
    this.jdField_b_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
    if (localObject != null)
    {
      ((VideoPreDownloadMgr)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr = null;
    }
    a(ReportConstants.VideoEndType.EXIT_SCENE);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam != null)
    {
      if (a() != null)
      {
        a().l();
        this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper = null;
      }
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam = null;
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam;
    if (localObject != null)
    {
      if (b((VideoPlayParam)localObject) != null)
      {
        b(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam).l();
        this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerApiIVideoPlayerWrapper = null;
      }
      this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam = null;
    }
    localObject = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localObject != null)
    {
      localObject = ((ConcurrentHashMap)localObject).keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        VideoPlayerWrapper localVideoPlayerWrapper = (VideoPlayerWrapper)((Iterator)localObject).next();
        if ((localVideoPlayerWrapper != null) && (!localVideoPlayerWrapper.i())) {
          localVideoPlayerWrapper.l();
        }
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall;
    if (localObject != null)
    {
      ((VideoPluginInstall)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPluginVideoPluginInstall = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    localObject = this.jdField_a_of_type_JavaUtilArrayList;
    if (localObject != null)
    {
      ((ArrayList)localObject).clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    VideoVolumeController.getInstance().removeEventListener(this);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsPlayManager$VideoPlayProgressListener = null;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsRecommendManager = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void f(boolean paramBoolean)
  {
    this.jdField_g_of_type_Boolean = paramBoolean;
    if (a() != null) {
      a().d(paramBoolean);
    }
    if (b(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam) != null) {
      b(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam).d(paramBoolean);
    }
  }
  
  public boolean f()
  {
    return a() == 3;
  }
  
  public void g()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkPlayStateAfterPhoneCall mIsActivityOnResume = ");
      localStringBuilder.append(this.f);
      QLog.d("Q.pubaccount.video.feedsVideoFeedsPlayManager", 2, localStringBuilder.toString());
    }
    if (!this.f) {
      return;
    }
    if (b())
    {
      if (!a()) {
        return;
      }
      b(false);
      c();
    }
  }
  
  public void g(boolean paramBoolean)
  {
    this.o = paramBoolean;
    VideoPlayerWrapper localVideoPlayerWrapper = a();
    boolean bool2 = false;
    if (localVideoPlayerWrapper != null)
    {
      localVideoPlayerWrapper = a();
      boolean bool1;
      if ((!paramBoolean) && (!this.jdField_g_of_type_Boolean)) {
        bool1 = false;
      } else {
        bool1 = true;
      }
      localVideoPlayerWrapper.d(bool1);
    }
    if (b(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam) != null)
    {
      localVideoPlayerWrapper = b(this.jdField_b_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoPlayParam);
      if (!paramBoolean)
      {
        paramBoolean = bool2;
        if (!this.jdField_g_of_type_Boolean) {}
      }
      else
      {
        paramBoolean = true;
      }
      localVideoPlayerWrapper.d(paramBoolean);
    }
  }
  
  public boolean g()
  {
    return a() == 7;
  }
  
  public void onHeadsetStateChanged(boolean paramBoolean)
  {
    if (a() != null) {
      a().c(paramBoolean ^ true);
    }
  }
  
  public void onPhoneCome()
  {
    if (a() != null) {
      a().f();
    }
  }
  
  public void onSystemVolumeChanged(int paramInt)
  {
    if (a() != null)
    {
      VideoPlayerWrapper localVideoPlayerWrapper = a();
      boolean bool;
      if (paramInt <= 0) {
        bool = true;
      } else {
        bool = false;
      }
      localVideoPlayerWrapper.c(bool);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsPlayManager
 * JD-Core Version:    0.7.0.1
 */