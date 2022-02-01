package com.tencent.mobileqq.kandian.biz.accesslayer.data;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.kandian.biz.ad.entity.IExposureSupplementManager;
import com.tencent.mobileqq.kandian.biz.dislike.RIJDislikeManager;
import com.tencent.mobileqq.kandian.biz.framework.PrefetchListener;
import com.tencent.mobileqq.kandian.biz.framework.RIJPreloadImage;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.util.DynamicItemViewHelper;
import com.tencent.mobileqq.kandian.biz.share.VideoShareHelper;
import com.tencent.mobileqq.kandian.biz.video.PlayableItem;
import com.tencent.mobileqq.kandian.biz.video.VideoAutoPlayController;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.mobileqq.kandian.glue.video.VideoRecommendManager;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public final class RIJDataManager$Builder
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  Context jdField_a_of_type_AndroidContentContext;
  VafContext jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  IExposureSupplementManager jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityIExposureSupplementManager;
  RIJDislikeManager jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager;
  PrefetchListener jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkPrefetchListener;
  RIJPreloadImage jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJPreloadImage;
  ReadInJoyBaseAdapter jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  DynamicItemViewHelper jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper;
  VideoShareHelper jdField_a_of_type_ComTencentMobileqqKandianBizShareVideoShareHelper;
  PlayableItem jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem;
  VideoAutoPlayController jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController;
  VideoPlayManager jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
  VideoPreDownloadMgr jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
  VideoRecommendManager jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager;
  ArrayList<BaseReportData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  Map<Long, BaseReportData> jdField_a_of_type_JavaUtilMap = null;
  Set<Long> jdField_a_of_type_JavaUtilSet = null;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  boolean c = false;
  boolean d = false;
  boolean e = false;
  boolean f = false;
  boolean g = false;
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public VafContext a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext;
  }
  
  public Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public Builder a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public Builder a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    return this;
  }
  
  public Builder a(VafContext paramVafContext)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusVirtualviewCoreVafContext = paramVafContext;
    return this;
  }
  
  public Builder a(IExposureSupplementManager paramIExposureSupplementManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityIExposureSupplementManager = paramIExposureSupplementManager;
    return this;
  }
  
  public Builder a(RIJDislikeManager paramRIJDislikeManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager = paramRIJDislikeManager;
    return this;
  }
  
  public Builder a(PrefetchListener paramPrefetchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkPrefetchListener = paramPrefetchListener;
    return this;
  }
  
  public Builder a(RIJPreloadImage paramRIJPreloadImage)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJPreloadImage = paramRIJPreloadImage;
    return this;
  }
  
  public Builder a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter = paramReadInJoyBaseAdapter;
    return this;
  }
  
  public Builder a(DynamicItemViewHelper paramDynamicItemViewHelper)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper = paramDynamicItemViewHelper;
    return this;
  }
  
  public Builder a(VideoShareHelper paramVideoShareHelper)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizShareVideoShareHelper = paramVideoShareHelper;
    return this;
  }
  
  public Builder a(PlayableItem paramPlayableItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem = paramPlayableItem;
    return this;
  }
  
  public Builder a(VideoAutoPlayController paramVideoAutoPlayController)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController = paramVideoAutoPlayController;
    return this;
  }
  
  public Builder a(VideoPlayManager paramVideoPlayManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager = paramVideoPlayManager;
    return this;
  }
  
  public Builder a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr = paramVideoPreDownloadMgr;
    return this;
  }
  
  public Builder a(VideoRecommendManager paramVideoRecommendManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager = paramVideoRecommendManager;
    return this;
  }
  
  public Builder a(Set<Long> paramSet, Map<Long, BaseReportData> paramMap)
  {
    this.jdField_a_of_type_JavaUtilSet = paramSet;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    return this;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public IExposureSupplementManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizAdEntityIExposureSupplementManager;
  }
  
  public RIJDislikeManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizDislikeRIJDislikeManager;
  }
  
  public PrefetchListener a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkPrefetchListener;
  }
  
  public RIJPreloadImage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkRIJPreloadImage;
  }
  
  public ReadInJoyBaseAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkReadInJoyBaseAdapter;
  }
  
  public DynamicItemViewHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper;
  }
  
  public VideoShareHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizShareVideoShareHelper;
  }
  
  public PlayableItem a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayableItem;
  }
  
  public VideoAutoPlayController a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoAutoPlayController;
  }
  
  public VideoPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPlayManager;
  }
  
  public VideoPreDownloadMgr a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr;
  }
  
  public VideoRecommendManager a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoRecommendManager;
  }
  
  public ArrayList<BaseReportData> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public Map<Long, BaseReportData> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public Set<Long> a()
  {
    return this.jdField_a_of_type_JavaUtilSet;
  }
  
  public boolean a()
  {
    return this.g;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Builder b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public DynamicItemViewHelper b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizPtsUtilDynamicItemViewHelper;
  }
  
  public boolean b()
  {
    return this.f;
  }
  
  public Builder c(boolean paramBoolean)
  {
    this.c = paramBoolean;
    return this;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public Builder d(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public boolean d()
  {
    return this.d;
  }
  
  public Builder e(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public boolean e()
  {
    return this.c;
  }
  
  public Builder f(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public boolean f()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public Builder g(boolean paramBoolean)
  {
    this.g = paramBoolean;
    return this;
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder
 * JD-Core Version:    0.7.0.1
 */