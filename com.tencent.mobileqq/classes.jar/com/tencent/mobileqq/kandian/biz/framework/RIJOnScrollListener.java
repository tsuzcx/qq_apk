package com.tencent.mobileqq.kandian.biz.framework;

import android.app.Activity;
import android.os.Build.VERSION;
import android.util.Pair;
import android.view.View;
import com.tencent.biz.pubaccount.util.FeedExposureHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.ad.api.IRIJADExposureService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.ThreadPriorityUtil;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.ad.entity.IExposureSupplementManager;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.gifvideo.utils.VideoPlayControlUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteSwitchManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import mqq.os.MqqHandler;

public class RIJOnScrollListener
  implements AbsListView.OnScrollListener
{
  double jdField_a_of_type_Double = 0.0D;
  int jdField_a_of_type_Int = -1;
  private View jdField_a_of_type_AndroidViewView;
  FeedExposureHelper jdField_a_of_type_ComTencentBizPubaccountUtilFeedExposureHelper;
  ThreadPriorityUtil jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsThreadPriorityUtil = new ThreadPriorityUtil();
  RIJDataManager jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager;
  private Runnable jdField_a_of_type_JavaLangRunnable = new RIJOnScrollListener.1(this);
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqHandler();
  boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  boolean jdField_b_of_type_Boolean = false;
  private int c;
  
  public RIJOnScrollListener(RIJDataManager paramRIJDataManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager = paramRIJDataManager;
    this.jdField_a_of_type_ComTencentBizPubaccountUtilFeedExposureHelper = new RIJOnScrollListener.2(this, paramRIJDataManager);
  }
  
  private String a()
  {
    if (PTSLiteSwitchManager.a().b()) {
      return "list_readinjoy_daily_lite";
    }
    return "list_readinjoy_daily";
  }
  
  private void a()
  {
    if (RIJQQAppInterfaceUtil.a())
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().b();
      if (i != 0)
      {
        if (i != 56)
        {
          if (i != 70)
          {
            if (DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().b()))
            {
              DropFrameMonitor.a().a(a());
              return;
            }
            DropFrameMonitor localDropFrameMonitor = DropFrameMonitor.a();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("list_kandian_channel_");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().b());
            localDropFrameMonitor.a(localStringBuilder.toString());
            return;
          }
          DropFrameMonitor.a().a("list_subscript");
          return;
        }
        DropFrameMonitor.a().a("list_video_kandian");
        return;
      }
      DropFrameMonitor.a().a("list_new_kandian");
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isChannelCanRequstAd(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().b()))
    {
      Pair localPair = ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().b(), paramInt1 + paramInt2 - 1);
      if (localPair != null)
      {
        ReadInJoyLogicEngine.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().b(), ((Integer)localPair.first).intValue(), ((Integer)localPair.second).intValue());
        ThreadManager.executeOnSubThread(new RIJOnScrollListener.3(this, localPair));
      }
    }
  }
  
  private void a(AbsListView paramAbsListView)
  {
    if ((this.jdField_a_of_type_Int == 2) && (Build.VERSION.SDK_INT < 21))
    {
      if (a(paramAbsListView))
      {
        ((IImageManager)QRoute.api(IImageManager.class)).pauseDownload();
        return;
      }
      ((IImageManager)QRoute.api(IImageManager.class)).resume();
    }
  }
  
  private void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.jdField_b_of_type_Int < paramInt1)
    {
      VideoPlayControlUtils.a(this.jdField_a_of_type_AndroidViewView);
      return;
    }
    if (paramInt1 + paramInt2 - 1 < this.c) {
      VideoPlayControlUtils.a(this.jdField_b_of_type_AndroidViewView);
    }
  }
  
  private boolean a(AbsListView paramAbsListView)
  {
    float f1 = paramAbsListView.getFlingVelocity();
    float f2 = (float)DeviceInfoUtil.j();
    return (f1 > 0.0F) && (f1 > f2 * 1.0F);
  }
  
  private void b()
  {
    if (RIJQQAppInterfaceUtil.a())
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().b();
      if (i != 0)
      {
        if (i != 56)
        {
          if (i != 70)
          {
            if (DailyModeConfigHandler.c(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().b()))
            {
              DropFrameMonitor.a().a(a(), false);
              return;
            }
            DropFrameMonitor localDropFrameMonitor = DropFrameMonitor.a();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("list_kandian_channel_");
            localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().b());
            localDropFrameMonitor.a(localStringBuilder.toString(), false);
            return;
          }
          DropFrameMonitor.a().a("list_subscript", false);
          return;
        }
        DropFrameMonitor.a().a("list_video_kandian", false);
        return;
      }
      DropFrameMonitor.a().a("list_new_kandian", false);
    }
  }
  
  public FeedExposureHelper a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountUtilFeedExposureHelper;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    IRIJADExposureService localIRIJADExposureService = (IRIJADExposureService)RIJQQAppInterfaceUtil.a().getRuntimeService(IRIJADExposureService.class);
    if ((localIRIJADExposureService.checkAndReportAdExposure(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), (Activity)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a())) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), (Activity)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a());
    }
    a(paramInt1, paramInt2);
    int i = this.jdField_b_of_type_Int;
    if (paramInt1 > i) {
      this.jdField_a_of_type_Boolean = true;
    } else if (paramInt1 < i) {
      this.jdField_a_of_type_Boolean = false;
    }
    localIRIJADExposureService.checkADScrollAction(this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), (Activity)this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Double);
    a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    this.jdField_b_of_type_Int = paramInt1;
    this.c = (paramInt1 + paramInt2 - 1);
    this.jdField_a_of_type_AndroidViewView = paramAbsListView.getChildAt(0);
    this.jdField_b_of_type_AndroidViewView = paramAbsListView.getChildAt(paramInt2 - 1);
    a(paramAbsListView);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScrollStateChanged ");
      localStringBuilder.append(paramInt);
      QLog.d("RIJOnScrollListener", 2, localStringBuilder.toString());
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScrollStateChanged ");
      localStringBuilder.append(paramInt);
      QLog.d("RIJOnScrollListener", 2, localStringBuilder.toString());
    }
    if (paramInt == 0)
    {
      b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsThreadPriorityUtil.b();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a().a(this.jdField_a_of_type_Boolean, paramAbsListView.getCount(), paramAbsListView.getLastVisiblePosition(), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a(), this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager);
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
    else
    {
      a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBaseUtilsThreadPriorityUtil.a();
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    if ((paramInt == 2) && (this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().a()))
    {
      this.jdField_b_of_type_Boolean = true;
    }
    else if ((paramInt != 2) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizAccesslayerDataRIJDataManager.a().g(false);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountUtilFeedExposureHelper.a(paramAbsListView, paramInt);
    if ((paramInt == 0) && ((paramAbsListView instanceof ReadInJoyXListView)) && (!((ReadInJoyXListView)paramAbsListView).a())) {
      VideoPlayControlUtils.a(paramAbsListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.framework.RIJOnScrollListener
 * JD-Core Version:    0.7.0.1
 */